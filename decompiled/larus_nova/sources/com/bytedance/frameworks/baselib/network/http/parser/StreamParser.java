package com.bytedance.frameworks.baselib.network.http.parser;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.collection.SieveCacheKt;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.util.DownloadFileTooLargeException;
import com.bytedance.frameworks.baselib.network.http.util.e;
import com.bytedance.frameworks.baselib.network.http.util.j;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.mime.MimeUtil;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.cache.disk.DefaultDiskStorage;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.GZIPInputStream;
import kotlin.jvm.internal.ByteCompanionObject;
import lx5.d;
import okio.Buffer;
import okio.BufferedSource;
import okio.Okio;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class StreamParser {
    private static final String CONTENT_ENCODING = "Content-Encoding";
    public static final String CONTENT_TYPE_OCTET = "application/octet-stream";
    private static final int DEFAULT_MAX_API_RESPONSE_LENGTH = 5242880;
    private static final String KEY_READ_RESPONSE_BUFF_INCREASE_SIZE = "read_response_buff_increase_size";
    private static final String KEY_READ_RESPONSE_BUFF_INIT_SIZE = "read_response_buff_init_size";
    private static final String KEY_RETROFIT_READ_MAX_LENGTH = "retrofit_response_max_length";
    private static final String KEY_RETROFIT_RESPONSE_MAX_LENGTH_PATH_LIST = "retrofit_response_max_length_path_prefix_list";
    private static final String KEY_SPECIFIC_READ_RESPONSE_BUFF_INIT_SIZE = "specific_init_size";
    private static final int READ_RESPONSE_FIRST_INCREASE_SIZE = 102400;
    private static final int READ_RESPONSE_FREE_MIN_BUFF_SIZE = 4096;
    private static final int READ_RESPONSE_INIT_BUFF_SIZE = 32768;
    private static final String TAG = null;
    private static volatile int sReadBodyBuffFirstIncreaseSize;
    private static volatile int sReadBodyBuffInitSize;
    private static volatile int sReadMaxLength;
    private static final Map<String, Integer> sReadMaxLengthMap = null;
    private static final Map<String, Integer> sSpecificReadBodyBuffInitSize = null;

    public StreamParser() {
    }

    private static boolean isBuffSizeValid(int r100) {
        if (r100 >= 4096) goto L5;
    L7:
        return false;
    L5:
        if (r100 > 5242880) goto L7;
        return true;
    }

    static {
        TAG = "StreamParser";
        sReadBodyBuffInitSize = 0;
        sReadBodyBuffFirstIncreaseSize = 0;
        sSpecificReadBodyBuffInitSize = new ConcurrentHashMap();
        sReadMaxLength = 5242880;
        sReadMaxLengthMap = new ConcurrentHashMap();
    }

    public static void onConfigUpdate(SharedPreferences r100) {
        sReadBodyBuffInitSize = r100.getInt(KEY_READ_RESPONSE_BUFF_INIT_SIZE, 0);
        sReadBodyBuffFirstIncreaseSize = r100.getInt(KEY_READ_RESPONSE_BUFF_INCREASE_SIZE, 0);
    }

    public static void onSaveConfigToSP(SharedPreferences.Editor r100) {
        r100.putInt(KEY_READ_RESPONSE_BUFF_INIT_SIZE, sReadBodyBuffInitSize);
        r100.putInt(KEY_READ_RESPONSE_BUFF_INCREASE_SIZE, sReadBodyBuffFirstIncreaseSize);
    }

    public static void onServerConfigUpdate(JSONObject r100) {
        sReadBodyBuffInitSize = r100.optInt(KEY_READ_RESPONSE_BUFF_INIT_SIZE, 0);
        sReadBodyBuffFirstIncreaseSize = r100.optInt(KEY_READ_RESPONSE_BUFF_INCREASE_SIZE, 0);
        JSONObject r101 = r100.optJSONObject(KEY_SPECIFIC_READ_RESPONSE_BUFF_INIT_SIZE);
        if (r101 == null) goto L13;
        sSpecificReadBodyBuffInitSize.clear();
        Iterator<String> r102 = r101.keys();
    L6:
        if (r102.hasNext() == false) goto L11;
        String r103 = r102.next();
        int r104 = r101.optInt(r103);
        if (r104 < 4096) goto L6;
        sSpecificReadBodyBuffInitSize.put(r103, Integer.valueOf(r104));
        goto L6
    L11:
        if (Logger.debug() == false) goto L13;
        Logger.d(TAG, "bufrefine, get specific init size " + sSpecificReadBodyBuffInitSize);
    L13:
        sReadMaxLength = r100.optInt(KEY_RETROFIT_READ_MAX_LENGTH, 5242880);
        JSONObject r105 = r100.optJSONObject(KEY_RETROFIT_RESPONSE_MAX_LENGTH_PATH_LIST);
        sReadMaxLengthMap.clear();
        if (r105 == null) goto L23;
        Iterator<String> r106 = r105.keys();
    L17:
        if (r106.hasNext() == false) goto L36;
        String r107 = r106.next();
        int r108 = r105.optInt(r107);
        if (r108 < 5242880) goto L17;
        Map<String, Integer> r109 = sReadMaxLengthMap;
        r109.put(r107, Integer.valueOf(r108));
        if (Logger.debug() == false) goto L17;
        Logger.d(TAG, "max length refine, " + r109.size() + " key " + r107 + " value " + r108);
        goto L17
    L36:
        return;
    }

    public static void safeClose(Closeable r100) {
        safeClose(r100, null);
    }

    public static boolean testIsSSBinary(String r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        int r101 = r100.indexOf("application/octet-stream");
        if (r101 < 0) goto L8;
        r101 = r100.indexOf("ssmix=", r101 + 24);
    L8:
        if (r101 <= 0) goto L11;
        return true;
    L11:
        return false;
    }

    public static String bytesToString(byte[] r100, Map<String, String> r101) throws Exception {
        if (r100 != null) goto L5;
        return null;
    L5:
        String r102 = r101.get("Content-Type");
        if (TextUtils.isEmpty(r102) == false) goto L9;
        r102 = r101.get("Content-Type".toLowerCase());
    L9:
        return bytesToString(r100, r102);
    }

    public static void decodeSSBinary(byte[] r100, int r101) throws IOException {
        if (r100 == null) goto L8;
        if (r101 <= 0) goto L10;
        byte[] r102 = {-99, -114, ByteCompanionObject.MAX_VALUE, 90};
        int r103 = 0;
    L6:
        if (r103 >= r101) goto L11;
        r100[r103] = (byte) (r100[r103] ^ r102[r103 % 4]);
        r103 = r103 + 1;
        goto L6
    L11:
        return;
    L10:
        return;
    }

    private static int getMaxLength(int r100, RetrofitMetrics r101) {
        Map<String, Integer> r102 = sReadMaxLengthMap;
        if (r102.isEmpty() == true) goto L17;
        if (r101 == null) goto L17;
        URL r103 = r101.url;
        if (r103 == null) goto L17;
        String r104 = r103.getPath();
        Iterator<String> r105 = r102.keySet().iterator();
    L9:
        if (r105.hasNext() == false) goto L17;
        String r106 = r105.next();
        if (r104.startsWith(r106) == false) goto L9;
        Integer r107 = sReadMaxLengthMap.get(r106);
        if (r107 == null) goto L9;
        return r107.intValue();
    L17:
        if (r100 < 5242880) goto L20;
        return r100;
    L20:
        return Math.max(sReadMaxLength, 5242880);
    }

    public static byte[] readResponseWithZeroCopy(InputStream r100, RetrofitMetrics r101) throws IOException {
        if (r100 != null) goto L17;
        return null;
    L17:
        r100.read(new byte[0]);     // Catch: IOException -> L14
        int r102 = r100.available();     // Catch: IOException -> L14
        if (Logger.debug() == false) goto L10;
        Logger.d("ttnet_0cp", "available size is " + r102);     // Catch: IOException -> L14
    L10:
        byte[] r103 = new byte[r102];     // Catch: IOException -> L14
        r100.read(r103);     // Catch: IOException -> L14
        if (r101 == null) goto L13;
        r101.responseReadType = 2;     // Catch: IOException -> L14
        r101.extra.put(RetrofitMetrics.ExtraKeys.STREAM_READ_BYTE_COUNT, Long.valueOf(r102));     // Catch: IOException -> L14
    L13:
        return r103;
    L14:
        e = move-exception;
        Logger.e("ttnet_0cp", e.getMessage());
        throw e;
    }

    private static void safeClose(Closeable r100, String r101) {
        if (r100 == null) goto L13;
        r100.close();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        if (Logger.debug() == false) goto L14;
        if (r101 == null) goto L15;
        Logger.d(TAG, r101 + " " + e);
        return;
    L15:
        return;
    L14:
        return;
    }

    public static String bytesToString(byte[] r100, String r101) throws Exception {
        if (r100 != null) goto L5;
        return null;
    L5:
        String r102 = "UTF-8";
        String r103 = MimeUtil.parseCharset(r101, "UTF-8");
        if (r103 == null) goto L10;
        r102 = r103;
    L10:
        return new String(r100, r102);
    }

    private static byte[] readResponseWithOkio(int r100, InputStream r101, RetrofitMetrics r110) throws IOException {
        Buffer r102 = new Buffer();
        BufferedSource r103 = Okio.buffer(Okio.source(r101));     // Catch: Exception -> L25
    L29:
    L18:
        th = move-exception;
        if (r103 != null) goto L30;
    L24:
        throw th;     // Catch: Exception -> L25
    L30:
        r103.close();     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L25
        goto L24
    L5:
        if (r103.exhausted() == true) goto L13;
        long r104 = r100;
        if (r103.read(r102, r104 - r102.size()) == (-1)) goto L12;
        if (r102.size() <= r104) goto L29;
    L12:
        throw new DownloadFileTooLargeException(r100, r102.size());     // Catch: Throwable -> L18
    L13:
        if (r110 == null) goto L15;
        r110.responseReadType = 1;     // Catch: Throwable -> L18
        r110.extra.put(RetrofitMetrics.ExtraKeys.STREAM_READ_BYTE_COUNT, Long.valueOf(r102.size()));     // Catch: Throwable -> L18
    L15:
        byte[] r105 = r102.readByteArray();     // Catch: Throwable -> L18
        r103.close();     // Catch: Exception -> L25
        return r105;
    L25:
        e = move-exception;
        Logger.e("ttnet_okio", e.getMessage());
        throw e;
    }

    public static InputStream processInputStream(InputStream r100, Map<String, List<String>> r101, boolean r102, RetrofitMetrics r103) throws IOException {
        if (r102 == true) goto L4;
        NetworkParams.getStreamProcessor();
        return r100;
    L4:
        return new GZIPInputStream(r100);
    }

    public static byte[] stream2ByteArray(int r100, InputStream r101, long r102, d r110) throws IOException {
        if (r101 != null) goto L64;
        return null;
    L64:
        if (r102 <= SieveCacheKt.NodeLinkMask) goto L13;
        Logger.w(TAG, "HTTP entity too large to be buffered in memory");     // Catch: Throwable -> L10 Exception -> L38
        safeClose(r101);
        return null;
    L13:
        if (r102 >= 0) goto L15;
        r102 = 4096;
    L21:
        int r111 = (int) r102;
        if (r111 < 0) goto L55;
        byte[] r103 = new byte[r111];     // Catch: Throwable -> L10 Exception -> L38
        byte[] r112 = new byte[4096];     // Catch: Throwable -> L10 Exception -> L38
        int r104 = 0;
        int r105 = 0;
    L24:
        int r106 = r101.read(r112);     // Catch: Throwable -> L10 Exception -> L38
        if (r106 == (-1)) goto L49;
        if (r112.length < 0) goto L48;
        if (r106 < 0) goto L48;
        int r107 = 0 + r106;     // Catch: Throwable -> L10 Exception -> L38
        if (r107 < 0) goto L48;
        if (r107 > r112.length) goto L48;
        if (r106 == 0) goto L41;
        int r108 = r105 + r106;     // Catch: Throwable -> L10 Exception -> L38
        if (r108 <= r103.length) goto L40;
        byte[] r109 = new byte[Math.max(r103.length << 1, r108)];     // Catch: Throwable -> L10 Exception -> L38
        System.arraycopy(r103, 0, r109, 0, r105);     // Catch: Throwable -> L10 Exception -> L38
        r103 = r109;
    L40:
        System.arraycopy(r112, 0, r103, r105, r106);     // Catch: Throwable -> L10 Exception -> L38
        r105 = r108;
    L41:
        r104 = r104 + r106;     // Catch: Throwable -> L10 Exception -> L38
        if (r100 <= 0) goto L24;
        if (r104 <= r100) goto L24;
        Logger.w(TAG, "entity length did exceed given maxLength");     // Catch: Throwable -> L10 Exception -> L38
        safeClose(r101);
        return null;
    L48:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10 Exception -> L38
    L49:
        byte[] r113 = new byte[r105];     // Catch: Throwable -> L10 Exception -> L38
        if (r105 <= 0) goto L52;
        System.arraycopy(r103, 0, r113, 0, r105);     // Catch: Throwable -> L10 Exception -> L38
    L52:
        safeClose(r101);
        return r113;
    L55:
        throw new IllegalArgumentException("Buffer capacity may not be negative");     // Catch: Throwable -> L10 Exception -> L38
    L15:
        if (r100 <= 0) goto L21;
        if (r102 <= r100) goto L21;
        Logger.w(TAG, "entity length exceed given maxLength: " + r100 + " " + r102);     // Catch: Throwable -> L10 Exception -> L38
        safeClose(r101);
        return null;
    L38:
        e = move-exception;
        if (r110 != null) goto L62;
    L58:
        throw e;     // Catch: Throwable -> L10
    L62:
        r110.abort();     // Catch: Throwable -> L61
    L10:
        th = move-exception;
        safeClose(r101);
        throw th;
    }

    private static byte[] readResponseLegacy(boolean r110, int r111, InputStream r112, int[] r113, RetrofitMetrics r114) throws IOException {
        if (isBuffSizeValid(sReadBodyBuffInitSize) == false) goto L5;
        int r100 = sReadBodyBuffInitSize;
    L7:
        if (isBuffSizeValid(sReadBodyBuffFirstIncreaseSize) == false) goto L9;
        int r101 = sReadBodyBuffFirstIncreaseSize;
    L10:
        if (r114 == null) goto L19;
        URL r102 = r114.url;
        if (r102 == null) goto L19;
        if (TextUtils.isEmpty(r102.getPath()) == true) goto L19;
        Integer r103 = sSpecificReadBodyBuffInitSize.get(r114.url.getPath());
        if (r103 == null) goto L19;
        r100 = r103.intValue();
    L19:
        if (Logger.debug() == false) goto L24;
        if (r114 == null) goto L24;
        if (r114.url == null) goto L24;
        Logger.d(TAG, "bufrefine " + r114.url.getPath() + " read init buf size is " + r100);
    L24:
        byte[] r104 = new byte[r100];
        int r105 = 0;
        int r106 = 0;
    L70:
    L53:
        e = move-exception;
        if (r110 == false) goto L69;
        if (r105 <= 0) goto L69;
        Logger.w(TAG, "ungzip got exception " + e);
    L57:
        if (r105 <= 0) goto L68;
        if (r114 == null) goto L61;
        r114.responseReadType = 0;
        r114.extra.put(RetrofitMetrics.ExtraKeys.STREAM_READ_BYTE_COUNT, Long.valueOf(r105));
        r114.streamParserCopyCount = r106;
    L61:
        if (Logger.debug() == false) goto L66;
        if (r114 == null) goto L66;
        if (r114.url == null) goto L66;
        Logger.d(TAG, "bufrefine " + r114.url.getPath() + " copyTimes is " + r106 + " final length is " + r105);
    L66:
        byte[] r115 = new byte[r105];
        System.arraycopy(r104, 0, r115, 0, r105);
        r113[0] = r105;
        return r115;
    L68:
        return null;
    L69:
        throw e;
    L43:
        e = move-exception;
        String r116 = e.getMessage();
        if (r110 == false) goto L52;
        if (r105 <= 0) goto L52;
        if ("CRC mismatch".equals(r116) == false) goto L50;
    L51:
        Logger.w(TAG, "ungzip got exception " + e);
        goto L57
    L50:
        if ("Size mismatch".equals(r116) == true) goto L51;
    L52:
        throw e;
    L40:
        e = move-exception;
        Logger.e(TAG, "new buff error" + e);
        return null;
    L27:
        if ((r105 + 4096) > r104.length) goto L29;
    L33:
        int r107 = r112.read(r104, r105, r104.length - r105);     // Catch: OutOfMemoryError -> L40 IOException -> L43 EOFException -> L53
        if (r107 <= 0) goto L57;
        r105 = r105 + r107;     // Catch: OutOfMemoryError -> L40 IOException -> L43 EOFException -> L53
        if (r105 <= r111) goto L70;
        Logger.w(TAG, "entity length did exceed given maxLength");     // Catch: OutOfMemoryError -> L40 IOException -> L43 EOFException -> L53
        throw new DownloadFileTooLargeException(r111, r105);     // Catch: OutOfMemoryError -> L40 IOException -> L43 EOFException -> L53
    L29:
        if (r104.length >= r101) goto L31;
        int r108 = r104.length + r101;     // Catch: OutOfMemoryError -> L40 IOException -> L43 EOFException -> L53
    L32:
        byte[] r109 = new byte[r108];     // Catch: OutOfMemoryError -> L40 IOException -> L43 EOFException -> L53
        System.arraycopy(r104, 0, r109, 0, r105);     // Catch: OutOfMemoryError -> L40 IOException -> L43 EOFException -> L53
        r106 = r106 + 1;     // Catch: OutOfMemoryError -> L40 IOException -> L43 EOFException -> L53
        r104 = r109;
        goto L33
    L31:
        r108 = r104.length * 2;     // Catch: OutOfMemoryError -> L40 IOException -> L43 EOFException -> L53
        goto L32
    L9:
        r101 = READ_RESPONSE_FIRST_INCREASE_SIZE;
        goto L10
    L5:
        r100 = 32768;
        goto L7
    }

    public static byte[] readResponse(boolean r100, Map<String, List<String>> r101, int r102, InputStream r110, int[] r111, RetrofitMetrics r112) throws IOException {
        if (r110 != null) goto L11;
        return null;
    L11:
        r110 = processInputStream(r110, r101, r100, r112);     // Catch: Throwable -> L8
        byte[] r103 = readResponseInternal(r100, r102, r110, r111, r112, false, false);     // Catch: Throwable -> L8
        safeClose(r110);
        return r103;
    L8:
        th = move-exception;
        safeClose(r110);
        throw th;
    }

    public static byte[] response2buf(boolean r100, Map<String, List<String>> r101, int r102, InputStream r110, int[] r111, d r112) throws IOException {
        if (r110 != null) goto L18;
        return null;
    L18:
        byte[] r103 = readResponse(r100, r101, r102, r110, r111, null);     // Catch: Exception -> L13
        if (r103 != null) goto L9;
    L12:
        return null;
    L9:
        if (r111[0] <= 0) goto L12;
        return r103;
    L13:
        e = move-exception;
        if (r112 != null) goto L20;
    L16:
        throw e;
    L20:
        r112.abort();     // Catch: Throwable -> L17
        goto L16
    }

    public static byte[] readResponseInternal(boolean r100, int r101, InputStream r102, int[] r103, RetrofitMetrics r104, boolean r105, boolean r106) throws IOException {
        if (r102 != null) goto L5;
        return null;
    L5:
        int r107 = getMaxLength(r101, r104);
        if (Logger.debug() == false) goto L8;
        Logger.d(TAG, "readResponseInternal maxLength is " + r107);
    L8:
        long r108 = System.currentTimeMillis();
        if (r106 == false) goto L16;
        byte[] r109 = readResponseWithZeroCopy(r102, r104);     // Catch: Throwable -> L14
        if (r104 == null) goto L13;
        r104.extra.put(RetrofitMetrics.ExtraKeys.STREAM_READ_TIME, Long.valueOf(System.currentTimeMillis() - r108));
    L13:
        return r109;
    L16:
        if (r105 == false) goto L21;
        byte[] r110 = readResponseWithOkio(r107, r102, r104);     // Catch: Throwable -> L14
        if (r104 == null) goto L20;
        r104.extra.put(RetrofitMetrics.ExtraKeys.STREAM_READ_TIME, Long.valueOf(System.currentTimeMillis() - r108));
    L20:
        return r110;
    L21:
        byte[] r111 = readResponseLegacy(r100, r107, r102, r103, r104);     // Catch: Throwable -> L14
        if (r104 == null) goto L24;
        r104.extra.put(RetrofitMetrics.ExtraKeys.STREAM_READ_TIME, Long.valueOf(System.currentTimeMillis() - r108));
    L24:
        return r111;
    L14:
        th = move-exception;
        if (r104 == null) goto L27;
        r104.extra.put(RetrofitMetrics.ExtraKeys.STREAM_READ_TIME, Long.valueOf(System.currentTimeMillis() - r108));
    L27:
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r10v22 */
    /* JADX WARN: Type inference failed for: r10v24 */
    /* JADX WARN: Type inference failed for: r10v28 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r16v6, types: [long] */
    /* JADX WARN: Type inference failed for: r2v0, types: [long] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10, types: [long] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v36 */
    /* JADX WARN: Type inference failed for: r2v37 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v24 */
    /* JADX WARN: Type inference failed for: r6v25 */
    /* JADX WARN: Type inference failed for: r6v26 */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v19 */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r7v20 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v9 */
    public static boolean stream2File(InputStream r210, long r211, d r212, int r213, String r214, String r215, String r310, e<String> r311, String r312, j r313) throws Exception {
        InputStream r100 = r210;
        ?? r101 = r211;
        String r102 = r214;
        if (r100 != null) goto L5;
        return false;
    L5:
        ?? r110 = 0;
        Object r111 = null;
        r111 = null;
        r111 = null;
        ?? r112 = 0;
        String r113 = "delete temp file exception ";
        if (r101 <= SieveCacheKt.NodeLinkMask) goto L184;
        Logger.w(TAG, "HTTP entity too large");     // Catch: Throwable -> L137 Exception -> L141
        throw new DownloadFileTooLargeException(r213, SieveCacheKt.NodeLinkMask);     // Catch: Throwable -> L137 Exception -> L141
    L184:
        if (r101 >= 0) goto L10;
        r101 = 4096(0x1000, double:2.0237E-320);
    L170:
        PolarisFileWrapper r103 = new PolarisFileWrapper(r102);     // Catch: Throwable -> L131 Exception -> L133
        if (r103.exists() == true) goto L166;
        r103.mkdirs();     // Catch: Throwable -> L16 Exception -> L18
    L166:
        File r104 = File.createTempFile("tempimage", DefaultDiskStorage.FileType.TEMP, new PolarisFileWrapper(r102));     // Catch: Throwable -> L16 Exception -> L18 IOException -> L25
    L24:
        File r105 = r104;
        if (r105 != null) goto L168;
        safeClose(r100, "close instream exception ");
        safeClose(null, "close outstream exception ");
        safeClose(null, "close random file exception ");
        if (r105 == null) goto L200;
        r105.delete();     // Catch: Exception -> L43
        return false;
    L43:
        e = move-exception;
        if (Logger.debug() == false) goto L201;
        Logger.d(TAG, "delete temp file exception " + e);
        return false;
    L201:
        return false;
    L200:
        return false;
    L168:
        RandomAccessFile r106 = new RandomAccessFile(r105, "rw");     // Catch: Throwable -> L125 Exception -> L127
    L172:
        r106.setLength(0);     // Catch: Throwable -> L120 Exception -> L122
        byte[] r107 = new byte[4096];     // Catch: Throwable -> L120 Exception -> L122
        long r114 = 0;
        long r115 = 0;
    L52:
        int r108 = r100.read(r107);     // Catch: Throwable -> L120 Exception -> L122
    L54:
        if (r108 == (-1)) goto L84;
        String r116 = r113;
        r114 = r114 + ((long) r108);
        if (r213 <= 0) goto L182;
        if (r114 <= r213) goto L182;
        Logger.w(TAG, "entity length did exceed given maxLength");     // Catch: Throwable -> L67 Exception -> L69
        r106.close();     // Catch: Throwable -> L67 Exception -> L69
    L65:
        e = e;
        r106 = null;
    L83:
        r112 = r106;
        ?? r109 = 0;
        ?? r117 = r105;
    L143:
        if (r212 == null) goto L164;
        r212.abort();     // Catch: Throwable -> L157
    L164:
        throw e;     // Catch: Throwable -> L146
    L146:
        th = th;
        ?? r118 = r112;
        ?? r119 = r109;
        ?? r120 = r117;
    L139:
        ?? r121 = r119;
        ?? r122 = r120;
        ?? r123 = r118;
    L140:
        Throwable r124 = th;
        ?? r125 = r122;
        ?? r126 = r123;
        r110 = r121;
    L148:
        safeClose(r100, "close instream exception ");
        safeClose(r110, "close outstream exception ");
        safeClose(r126, "close random file exception ");
        if (r125 == 0) goto L197;
        r125.delete();     // Catch: Exception -> L152
        throw r124;
    L152:
        e = move-exception;
        if (Logger.debug() == false) goto L198;
        Logger.d(TAG, r116 + e);
        throw r124;
    L198:
        throw r124;
    L197:
        throw r124;
    L63:
        th = th;
        r106 = null;
    L100:
        r124 = th;
        r110 = 0;
        r125 = r105;
        r126 = r106;
        goto L148
    L62:
        throw new DownloadFileTooLargeException(r213, r101);     // Catch: Throwable -> L63 Exception -> L65
    L69:
        e = e;
    L67:
        th = th;
    L182:
        r106.write(r107, 0, r108);     // Catch: Throwable -> L67 Exception -> L69
        if (r311 == null) goto L82;
        if (r312 == null) goto L82;
        long r127 = System.currentTimeMillis();     // Catch: Throwable -> L67 Exception -> L69
        if ((r127 - r115) < 500) goto L82;
        if (r101 < r114) goto L80;
        ?? r128 = (100 * r114) / r101;     // Catch: Throwable -> L67 Exception -> L69
    L80:
        r311.a();     // Catch: Throwable -> L67 Exception -> L69
        r115 = r127;
    L82:
        r113 = r116;
        r111 = null;
        goto L52
    L84:
        r116 = r113;
        r210.close();     // Catch: Throwable -> L116 Exception -> L118
    L87:
        if (r114 <= 0) goto L185;
        r106.seek(0);     // Catch: Throwable -> L98 Exception -> L101
        PolarisFileOutputStreamWrapper r129 = new PolarisFileOutputStreamWrapper(new PolarisFileWrapper(r102, r310));     // Catch: Throwable -> L98 Exception -> L101
    L174:
        int r130 = r106.read(r107);     // Catch: Throwable -> L94 Exception -> L96
        if (r130 == (-1)) goto L92;
        r129.write(r107, 0, r130);     // Catch: Throwable -> L94 Exception -> L96
        goto L174
    L92:
        r129.close();     // Catch: Throwable -> L94 Exception -> L96
    L96:
        e = e;
    L103:
        r109 = r129;
        r112 = r106;
        r100 = null;
        r117 = r105;
    L94:
        th = move-exception;
        r124 = th;
        r110 = r129;
        r100 = null;
        r125 = r105;
        r126 = r106;
        goto L148
    L101:
        e = e;
        r129 = null;
    L98:
        th = th;
        r100 = null;
    L185:
        r106.close();     // Catch: Throwable -> L112 Exception -> L114
        r105.delete();     // Catch: Throwable -> L108 Exception -> L110
        safeClose(null, "close instream exception ");
        safeClose(null, "close outstream exception ");
        safeClose(null, "close random file exception ");
        return true;
    L110:
        e = e;
        r109 = 0;
        r100 = null;
        r112 = 0;
        r117 = r105;
    L108:
        th = th;
        r100 = null;
        r123 = 0;
        r121 = 0;
        r122 = r105;
        goto L140
    L114:
        e = e;
        Object r131 = null;
        r100 = null;
    L124:
        r112 = r106;
        r109 = r131;
        r117 = r105;
    L112:
        th = th;
        r100 = null;
        r121 = 0;
        r122 = r105;
        r123 = r106;
    L118:
        e = e;
        r131 = null;
    L116:
        th = th;
        r119 = 0;
        r120 = r105;
        r118 = r106;
    L122:
        e = e;
        r131 = r111;
        r116 = r113;
    L120:
        th = th;
        r119 = r111;
        r116 = r113;
        r120 = r105;
        r118 = r106;
    L127:
        e = e;
        r109 = 0;
        r116 = "delete temp file exception ";
        r112 = 0;
        r117 = r105;
    L125:
        th = th;
        r119 = 0;
        r116 = "delete temp file exception ";
        r118 = 0;
        r120 = r105;
        goto L139
    L25:
        e = move-exception;
        if (StringUtils.isEmpty(r215) == true) goto L130;
        if (r215.equals(r102) == true) goto L130;
        PolarisFileWrapper r132 = new PolarisFileWrapper(r215);     // Catch: Throwable -> L131 Exception -> L133
        if (r132.exists() == true) goto L36;
        r132.mkdirs();     // Catch: Throwable -> L16 Exception -> L18
    L36:
        r104 = File.createTempFile("tempimage", DefaultDiskStorage.FileType.TEMP, new PolarisFileWrapper(r215));     // Catch: Throwable -> L131 Exception -> L133
        r102 = r215;
        goto L24
    L130:
        throw e;     // Catch: Throwable -> L137 Exception -> L141
    L133:
        e = e;
        r101 = 0;
        r116 = "delete temp file exception ";
    L142:
        ?? r133 = r101;
        r112 = r133;
        r109 = r101;
        r117 = r133;
    L131:
        th = th;
        r101 = 0;
        r116 = "delete temp file exception ";
    L138:
        ?? r134 = r101;
        r118 = r134;
        r119 = r101;
        r120 = r134;
        goto L139
    L10:
        if (r213 <= 0) goto L170;
        if (r101 <= r213) goto L170;
        Logger.w(TAG, "entity length exceed given maxLength");     // Catch: Throwable -> L16 Exception -> L18
        throw new DownloadFileTooLargeException(r213, r101);     // Catch: Throwable -> L16 Exception -> L18
    L18:
        e = e;
        r109 = 0;
        r117 = 0;
        r116 = "delete temp file exception ";
    L16:
        th = move-exception;
        r124 = th;
        r125 = 0;
        r126 = 0;
        r116 = "delete temp file exception ";
    L141:
        e = e;
    L137:
        th = th;
        goto L138
    }
}
