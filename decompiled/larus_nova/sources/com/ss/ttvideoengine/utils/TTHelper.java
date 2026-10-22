package com.ss.ttvideoengine.utils;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.os.Looper;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Base64;
import androidx.exifinterface.media.ExifInterface;
import com.alibaba.gaiax.render.view.basic.GXImageView;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.huawei.hms.framework.common.ContainerUtils;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.miui.easygo.constant.EasyGoConstant;
import com.ss.ttvideoengine.JniUtils;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.TTVideoEngineConfig;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import kotlin.UByte;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes35.dex */
public class TTHelper {
    private static final String TAG = "TTHelper";
    private static String mAppPath = null;
    private static final String queryStrAllowCharset = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_.~#[]!\\()*%";
    private static String sBoeSuffix = "";
    private static volatile String sLastExternalStorageState = null;
    private static volatile long sLastGetExternalStorageStateTime = -1;

    public TTHelper() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static /* synthetic */ Class access$001(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
        return Class.forName(r100, r101, r102);
    }

    public static boolean isAndroidJB2() {
        return true;
    }

    public static <T> T nonNullElse(T r100, T r101) {
        if (r100 != null) goto L4;
        return r101;
    L4:
        return r100;
    }

    public static HashMap<String, Resolution> defaultAudioResolutionMap() {
        return new AnonymousClass2();
    }

    public static HashMap<String, Resolution> defaultVideoResolutionMap() {
        return new AnonymousClass1();
    }

    public static boolean isExternalStorageWritable() {
        return "mounted".equals(safeGetExternalStorageState());
    }

    public static String safeGetExternalStorageState() {
        if (TextUtils.isEmpty(sLastExternalStorageState) == false) goto L5;
    L12:
        sLastGetExternalStorageStateTime = System.currentTimeMillis();     // Catch: Throwable -> L10
        sLastExternalStorageState = Environment.getExternalStorageState();     // Catch: Throwable -> L10
        return sLastExternalStorageState;
    L10:
        return "";
    L5:
        if ((System.currentTimeMillis() - sLastGetExternalStorageStateTime) >= 5000) goto L12;
        return sLastExternalStorageState;
    }

    public static Looper getLooper() {
        if (Looper.myLooper() == null) goto L7;
        return Looper.myLooper();
    L7:
        return Looper.getMainLooper();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ss_ttvideoengine_utils_TTHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static String base64Decode(String r100) {
        return base64Decode(r100, null);
    }

    public static byte[] base64DecodeToBytes(String r100) {
        TTVideoEngineLog.d(TAG, "base64DecodeToBytes " + r100);
        if (TextUtils.isEmpty(r100) == false) goto L11;
    L9:
        return null;
    L11:
        return Base64.decode(r100, 0);
    L7:
        th = move-exception;
        TTVideoEngineLog.e(TAG, "base64DecodeToBytes " + th);
        goto L9
    }

    public static String buildBoeUrl(String r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (TextUtils.isEmpty(sBoeSuffix) == false) goto L8;
        return r100;
    L8:
        boolean r101 = r100.contains(sBoeSuffix);
        boolean r102 = isIP(r100);
        if (r100.startsWith("https") == false) goto L11;
        r100 = r100.replace("https", "http");
    L11:
        if (r102 == false) goto L13;
        return r100;
    L13:
        if (r100.indexOf("http") != 0) goto L23;
        if (r101 == true) goto L24;
        String r103 = new URL(r100).getHost();     // Catch: Exception -> L17
        StringBuilder r104 = new StringBuilder();     // Catch: Exception -> L17
        r104.append(r103);     // Catch: Exception -> L17
        r104.append(String.format(".%s", new Object[]{sBoeSuffix}));     // Catch: Exception -> L17
        return r100.replace(r103, r104);
    L17:
        e = move-exception;
        TTVideoEngineLog.d(e);
        return r100;
    L24:
        return r100;
    L23:
        return r100;
    }

    public static String buildHttpUrl(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return r100;
    L5:
        if (r100.startsWith("https") == true) goto L7;
        return r100;
    L7:
        return r100.replace("https", "http");
    }

    public static String buildHttpsUrl(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return r100;
    L5:
        if (r100.contains("http://127.0.0.1") == false) goto L7;
        return r100;
    L7:
        return r100.replaceAll(GXImageView.NET_HTTP_PREFIX, GXImageView.NET_HTTPS_PREFIX);
    }

    public static StringBuilder buildUrlEncodedQuery(Map<String, Object> r100) {
        StringBuilder r101 = new StringBuilder();
        Iterator<Map.Entry<String, Object>> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L13;
        Map.Entry<String, Object> r103 = r102.next();
        if (TextUtils.isEmpty(r103.getKey()) == true) goto L4;
        if (r103.getValue() == null) goto L4;
        r101.append(URLEncoder.encode(r103.getKey(), "UTF-8"));     // Catch: UnsupportedEncodingException -> L11
        r101.append(ContainerUtils.KEY_VALUE_DELIMITER);     // Catch: UnsupportedEncodingException -> L11
        r101.append(URLEncoder.encode(String.valueOf(r103.getValue()), "UTF-8"));     // Catch: UnsupportedEncodingException -> L11
        r101.append("&");     // Catch: UnsupportedEncodingException -> L11
        goto L4
    L13:
        if (r101.length() <= 0) goto L15;
        r101.deleteCharAt(r101.length() - 1);
    L15:
        return r101;
    }

    private static String bytesToHexString(byte[] r100) {
        StringBuilder r101 = new StringBuilder();
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.length <= 0) goto L20;
        int r102 = r100.length;
        int r103 = 0;
    L8:
        if (r103 >= r102) goto L14;
        String r104 = Integer.toHexString(r100[r103] & UByte.MAX_VALUE);
        if (r104.length() >= 2) goto L12;
        r101.append(0);
    L12:
        r101.append(r104);
        r103 = r103 + 1;
        goto L8
    L14:
        return r101.toString();
    L20:
        return null;
    }

    public static String computeMD5(String r100) {
        MessageDigest r101 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L4
        r101.update(r100.getBytes());     // Catch: Exception -> L4
        return new BigInteger(1, r101.digest()).toString(16);
    L7:
        return r100;
    }

    public static void configBoeSuffix(String r100) {
        sBoeSuffix = r100;
    }

    public static String customBase64Decode(String r100) {
        if (r100 != null) goto L4;
        return r100;
    L4:
        if (r100.length() != 0) goto L7;
        return r100;
    L7:
        return r100.replace("$", "_").replace("@", HTTP.URL_DEFAULT).replace("#", ".");
    }

    public static String customBase64Encode(String r100) {
        if (r100 != null) goto L4;
        return r100;
    L4:
        if (r100.length() != 0) goto L7;
        return r100;
    L7:
        return r100.replace("_", "$").replace(HTTP.URL_DEFAULT, "@").replace(".", "#");
    }

    public static String decodeUrl(String r100) {
        String r101 = "";
    L10:
    L8:
        return null;
    L4:
        if (r101.equals(r100) == true) goto L7;
        r101 = r100;
        r100 = URLDecoder.decode(r100, "UTF-8");     // Catch: UnsupportedEncodingException -> L8
        goto L10
    L7:
        return r100;
    }

    public static void deleteBeforeDirFiles(Context r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        String r101 = getAppFilesPath(r100);
        if (r101 != null) goto L7;
        return;
    L7:
        PolarisFileWrapper r102 = new PolarisFileWrapper(r101);
        if (r102.exists() == true) goto L10;
        return;
    L10:
        if (r102.isDirectory() == false) goto L31;
        File[] r103 = r102.listFiles();
        if (r103 != null) goto L15;
        return;
    L15:
        if (r103.length == 0) goto L32;
        int r104 = r103.length;
        int r105 = 0;
    L18:
        if (r105 >= r104) goto L33;
        File r106 = r103[r105];
        if (r106.isFile() == false) goto L24;
        if (r106.getName().matches("^[0-9]{1,15}\\.cach$") == false) goto L24;
        r106.delete();
    L24:
        r105 = r105 + 1;
        goto L18
    L33:
        return;
    L32:
        return;
    }

    public static String encodeQuery(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L9;
        return r100;
    L9:
        return Uri.encode(r100, queryStrAllowCharset);
    L7:
        return null;
    }

    public static String encodeUrl(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L9;
        return r100;
    L9:
        return URLEncoder.encode(r100, "UTF-8");
    L7:
        return null;
    }

    public static Error errorWithJson(JSONObject r100) {
        if (r100 != null) goto L10;
        return null;
    L10:
        return new Error(r100.optString("domain"), r100.optInt("code"), r100.optInt(LKBaseResponseModel.INNER_CODE_KEY), r100.optString("des"));
    L7:
        th = move-exception;
        TTVideoEngineLog.e("TTVideoEngineTTHelper", "generate error fail. " + th + " " + r100);
        return null;
    }

    public static String getAppFilesPath(Context r100) {
        String r101 = mAppPath;
        if (r101 == null) goto L6;
        return r101;
    L6:
        if (r100 != null) goto L11;
        return null;
    L11:
        String r102 = r100.getApplicationContext().getFilesDir().getAbsolutePath();     // Catch: Exception -> L10
        mAppPath = r102;     // Catch: Exception -> L10
        return r102;
    L10:
        return null;
    }

    public static long getAvailableStorageSize(Context r100) {
        if (r100 != null) goto L6;
        return -1;
    L6:
        if (Environment.getDataDirectory() != null) goto L8;
        return -1;
    L8:
        return getDirectoryAvailableSize(r100.getFilesDir().getParent());
    }

    public static long getDirectoryAvailableSize(String r100) {
        StatFs r101 = new StatFs(r100);     // Catch: IllegalArgumentException -> L9
        if (isAndroidJB2() == false) goto L5;
        long r102 = r101.getBlockSizeLong();     // Catch: IllegalArgumentException -> L9
        long r103 = r101.getAvailableBlocksLong();     // Catch: IllegalArgumentException -> L9
    L8:
        return r102 * r103;
    L5:
        r102 = r101.getBlockSize();     // Catch: IllegalArgumentException -> L9
        r103 = r101.getAvailableBlocks();     // Catch: IllegalArgumentException -> L9
    L9:
        return -1;
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0049: MOVE (r1 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]) (LINE:16777289), block:B:32:0x0049 */
    public static String getFileMd5(File r100) {
        FileInputStream r101 = null;
        if (r100.isFile() == true) goto L5;
        return null;
    L5:
        byte[] r102 = new byte[1024];
        MessageDigest r103 = MessageDigest.getInstance("MD5");     // Catch: Throwable -> L20 Exception -> L22
        PolarisFileInputStreamWrapper r104 = new PolarisFileInputStreamWrapper(r100);     // Catch: Throwable -> L20 Exception -> L22
    L46:
        int r105 = r104.read(r102, 0, 1024);     // Catch: Exception -> L18 Throwable -> L31
        if (r105 == (-1)) goto L39;
        r103.update(r102, 0, r105);     // Catch: Exception -> L18 Throwable -> L31
        goto L46
    L39:
        r104.close();     // Catch: IOException -> L14
    L17:
        return bytesToHexString(r103.digest());
    L14:
        e = move-exception;
        e.printStackTrace();
    L18:
        e = e;
    L24:
        e.printStackTrace();     // Catch: Throwable -> L31
        if (r104 != null) goto L41;
    L30:
        return null;
    L41:
        r104.close();     // Catch: IOException -> L28
    L28:
        e = move-exception;
        e.printStackTrace();
    L31:
        th = th;
        r101 = r4;
    L33:
        if (r101 != null) goto L44;
    L38:
        throw th;
    L44:
        r101.close();     // Catch: IOException -> L36
    L36:
        e = move-exception;
        e.printStackTrace();
    L22:
        e = e;
        r104 = null;
    L20:
        th = th;
        goto L33
    }

    public static long getFreeSize(Context r100) {
        if (r100 != null) goto L6;
        return -1;
    L6:
        if (isExternalStorageWritable() == true) goto L8;
        return -1;
    L8:
        return getAvailableStorageSize(r100);
    }

    public static String getHexString(byte[] r100) {
        StringBuilder r101 = new StringBuilder();
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        String r104 = Integer.toHexString(r100[r103] & UByte.MAX_VALUE);
        if (r104.length() >= 2) goto L7;
        r101.append(0);
    L7:
        r101.append(r104);
        r103 = r103 + 1;
        goto L3
    L9:
        return r101.toString();
    }

    public static float getVolume(Context r100) {
        return TTVideoEngineInternalHelper.getVolume(r100);
    }

    public static String hmacSha1(String r100) {
        byte[] r101 = JniUtils.getSettingSignature(r100);
        if (r101 != null) goto L7;
        TTVideoEngineLog.d(TAG, "hmacSha1 signature is null");
        return null;
    L7:
        return getHexString(r101);
    }

    public static boolean isBase64(String r100) {
        return Pattern.matches("^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{4}|[A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)$", r100);
    }

    public static boolean isEmpty(List r100) {
        if (r100 != null) goto L4;
    L7:
        return true;
    L4:
        if (r100.isEmpty() == true) goto L7;
        return false;
    }

    public static boolean isIP(String r100) {
        if (r100 == null) goto L20;
        String r101 = "";
        if (r100.equals("") == true) goto L20;
        r101 = new URL(r100).getHost();     // Catch: Exception -> L9
    L12:
        if (PatternProtector.compile("([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}").matcher(r101).find() == false) goto L14;
        return true;
    L14:
        int r102 = r100.indexOf("[");
        int r103 = r100.indexOf("]");
        if (r102 <= 0) goto L20;
        if (r103 <= r102) goto L20;
        if (r100.substring(r102, r103).indexOf(":") <= 0) goto L20;
        return true;
    L9:
        e = move-exception;
        TTVideoEngineLog.d(e);
    L20:
        return false;
    }

    public static boolean isStringHex(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return false;
    L7:
        return r100.matches("^[A-Fa-f0-9]+$");
    }

    public static boolean isTranscodeUrl(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        TTVideoEngineLog.d("isTranscodeUrl", "----start check url:" + r100);
        String r101 = UriProtector.getQueryParameter(UriProtector.parse(r100), "btag");
        if (TextUtils.isEmpty(r101) == false) goto L9;
        TTVideoEngineLog.d("isTranscodeUrl", "get query value is null");
        return false;
    L9:
        TTVideoEngineLog.d("isTranscodeUrl", "get query value is:" + r101);
        if (isStringHex(r101) == true) goto L13;
        TTVideoEngineLog.d("isTranscodeUrl", "not hex string");
        return false;
    L13:
        BigInteger r102 = new BigInteger(r101, 16);
        BigInteger r103 = new BigInteger("80000", 16);
        if (r102.and(r103).compareTo(r103) != 0) goto L17;
        TTVideoEngineLog.d("isTranscodeUrl", "end url is transcoded");
        return true;
    L17:
        TTVideoEngineLog.d("isTranscodeUrl", "****end url is not transcoded");
        return false;
    }

    public static boolean isTranscodeUrlList(String[] r100) {
        if (r100 != null) goto L5;
    L14:
        return false;
    L5:
        if (r100.length <= 0) goto L14;
        int r101 = r100.length;
        int r102 = 0;
    L8:
        if (r102 >= r101) goto L14;
        if (isTranscodeUrl(r100[r102]) == true) goto L11;
        r102 = r102 + 1;
        goto L8
    L11:
        return true;
    }

    public static JSONObject jsonWithError(Error r100) {
        JSONObject r101 = null;
        if (r100 != null) goto L15;
        return null;
    L15:
        JSONObject r102 = new JSONObject();     // Catch: Throwable -> L10
        r102.put("domain", r100.domain);     // Catch: Throwable -> L8
        r102.put("code", r100.code);     // Catch: Throwable -> L8
        r102.put(LKBaseResponseModel.INNER_CODE_KEY, r100.internalCode);     // Catch: Throwable -> L8
        r102.put("des", r100.description);     // Catch: Throwable -> L8
        return r102;
    L8:
        th = th;
        r101 = r102;
    L11:
        TTVideoEngineLog.e("TTVideoEngineTTHelper", "error to json fail. " + th + " " + r101.toString());
        return r101;
    L10:
        th = th;
        goto L11
    }

    public static String md5(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L16;
        return "";
    L16:
        byte[] r101 = MessageDigest.getInstance("MD5").digest(r100.getBytes());     // Catch: NoSuchAlgorithmException -> L13
        StringBuilder r102 = new StringBuilder();     // Catch: NoSuchAlgorithmException -> L13
        int r103 = r101.length;     // Catch: NoSuchAlgorithmException -> L13
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L11;
        String r105 = Integer.toHexString(r101[r104] & UByte.MAX_VALUE);     // Catch: NoSuchAlgorithmException -> L13
        if (r105.length() != 1) goto L10;
        r105 = "0" + r105;     // Catch: NoSuchAlgorithmException -> L13
    L10:
        r102.append(r105);     // Catch: NoSuchAlgorithmException -> L13
        r104 = r104 + 1;     // Catch: NoSuchAlgorithmException -> L13
        goto L6
    L11:
        return r102.toString();
    L13:
        e = move-exception;
        TTVideoEngineLog.d(e);
        return "";
    }

    public static int parseInt(Object r100) {
        if (r100 == null) goto L14;
        if ((r100 instanceof Integer) == false) goto L8;
        return ((Integer) r100).intValue();
    L8:
        if ((r100 instanceof String) == false) goto L12;
        return CastIntegerProtector.parseInt((String) r100);
    L12:
        throw new NumberFormatException("Can't format " + r100.getClass() + " to int");
    L14:
        throw null;
    }

    public static void recursionDeleteFile(File r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isFile() == false) goto L9;
        r100.delete();
        return;
    L9:
        if (r100.isDirectory() == false) goto L22;
        File[] r101 = r100.listFiles();
        if (r101 != null) goto L13;
    L19:
        r100.delete();
        return;
    L13:
        if (r101.length == 0) goto L19;
        int r102 = r101.length;
        int r103 = 0;
    L16:
        if (r103 >= r102) goto L18;
        recursionDeleteFile(r101[r103]);
        r103 = r103 + 1;
        goto L16
    L18:
        r100.delete();
        return;
    }

    public static long safelyUnbox(Long r100) {
        return ((Long) nonNullElse(r100, 0L)).longValue();
    }

    public static int versionStringToInt(String r100) {
        int r101 = 0;
        if (r100 != null) goto L5;
    L19:
        return 0;
    L5:
        if (r100.isEmpty() == true) goto L19;
        String[] r102 = r100.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);
        if (r102.length > 0) goto L10;
        return 0;
    L10:
        int r103 = 0;
    L12:
        if (r101 >= r102.length) goto L18;
        if (r101 != 0) goto L16;
        r103 = CastIntegerProtector.parseInt(r102[r101]);     // Catch: Exception -> L20
    L17:
        r101 = r101 + 1;
        goto L12
    L16:
        r103 = (r103 * 100) + CastIntegerProtector.parseInt(r102[r101]);
        goto L17
    L18:
        return r103;
    }

    public static boolean isEmpty(Map r100) {
        if (r100 != null) goto L4;
    L7:
        return true;
    L4:
        if (r100.size() == 0) goto L7;
        return false;
    }

    public static boolean isEmpty(JSONArray r100) {
        if (r100 != null) goto L4;
    L7:
        return true;
    L4:
        if (r100.length() == 0) goto L7;
        return false;
    }

    public static boolean isEmpty(String[] r100) {
        if (r100 != null) goto L4;
    L7:
        return true;
    L4:
        if (r100.length == 0) goto L7;
        return false;
    }

    public static String appendQueryString(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return r100;
    L5:
        if (TextUtils.isEmpty(r101) == false) goto L8;
        return r100;
    L8:
        if (r100.contains(r101) == false) goto L11;
        return r100;
    L11:
        if (r100.contains("?") == true) goto L14;
        return r100 + "?" + r101;
    L14:
        return r100 + "&" + r101;
    }

    public static String base64Decode(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return r100;
    L5:
        if (isBase64(r100) == true) goto L16;
        return r100;
    L16:
        byte[] r102 = Base64.decode(r100, 0);     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(r101) == false) goto L12;
        return new String(r102, XML.CHARSET_UTF8);
    L12:
        return JniUtils.getDecodedStrWithKey(r102, Base64.decode(r101, 0));
    L13:
        th = move-exception;
        TTVideoEngineLog.d(TAG, th.toString());
        return "";
    }

    public static String genTrackID(String r100, long r101) {
        StringBuilder r102 = new StringBuilder();
        if (TextUtils.isEmpty(r100) == true) goto L5;
        r102.append(r100);
        r102.append(ExifInterface.GPS_DIRECTION_TRUE);
    L5:
        r102.append(r101);
        r102.append(ExifInterface.GPS_DIRECTION_TRUE);
        r102.append(Integer.toString((int) (Math.random() * 65535.0d)));
        return r102.toString();
    }

    public static Class<?> getClzUsingPluginLoader(int r100, String r101) throws Exception {
        if (r100 < 0) goto L12;
        if (TextUtils.isEmpty(r101) == true) goto L12;
        ClassLoader r102 = TTVideoEngineConfig.getClassLoader(r100);
        if (r102 != null) goto L10;
        return INVOKESTATIC_com_ss_ttvideoengine_utils_TTHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r101);
    L10:
        return INVOKESTATIC_com_ss_ttvideoengine_utils_TTHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r101, true, r102);
    L12:
        throw new Exception("pluginName or/and className is empty");
    }

    public static String getParam(String r100, String r101) {
        List<String> r102 = getUrlSlices(r100, r101);
        if (r102 != null) goto L5;
    L14:
        return null;
    L5:
        if (r102.size() == 0) goto L14;
        Iterator<String> r103 = r102.iterator();
    L9:
        if (r103.hasNext() == false) goto L14;
        String r104 = r103.next();
        if (r104.startsWith(r101 + ContainerUtils.KEY_VALUE_DELIMITER) == false) goto L9;
        return r104.substring(r101.length() + 1);
    }

    private static List<String> getUrlSlices(String r100, String r101) {
        ArrayList r102 = new ArrayList();
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return null;
    L5:
        String[] r103 = r100.split("[?]");
        if (r103.length >= 2) goto L8;
        return null;
    L8:
        String r104 = r103[0];
        String r105 = r103[1];
        int r106 = r105.indexOf(r101 + ContainerUtils.KEY_VALUE_DELIMITER);
        if (r106 != (-1)) goto L11;
        return null;
    L11:
        r102.add(r104);
        r102.add("?");
        r102.add(r105.substring(0, r106));
        int r107 = r105.indexOf("&", r106);
        if (r107 != (-1)) goto L15;
        r102.add(r105.substring(r106));
        return r102;
    L15:
        r102.add(r105.substring(r106, r107));
        r102.add(r105.substring(r107));
        return r102;
    }

    public static String keyFromFilePath(Context r100, String r101) {
        if (TextUtils.isEmpty(r101) == false) goto L6;
        return null;
    L6:
        if (r100 == null) goto L11;
        String r102 = getAppFilesPath(r100);
        if (TextUtils.isEmpty(r102) == true) goto L11;
        r101.replace(r102, "");
    L11:
        return md5(r101);
    }

    public static String replaceHostInURL(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return "";
    L7:
        if (TextUtils.isEmpty(r101) == false) goto L17;
        return r100;
    L17:
        String r102 = new URI(r100).getHost();     // Catch: URISyntaxException -> L14
        if (TextUtils.isEmpty(r102) == false) goto L12;
        return r100;
    L12:
        return r100.replaceFirst(r102, r101);
    L14:
        e = move-exception;
        e.printStackTrace();
        return r100;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ss_ttvideoengine_utils_TTHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r103 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r104 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r105 = access$001(r100, r101, r102);     // Catch: Throwable -> L8
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r105;
    L8:
        th = move-exception;
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r106 = access$001(r100, r101, r102);     // Catch: Throwable -> L17
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r106;
    L17:
        th = move-exception;
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static String overrideUrlParam(String r100, String r101, String r102) {
        List<String> r103 = getUrlSlices(r100, r101);
        if (r103 != null) goto L5;
        return r100;
    L5:
        if (r103.size() == 0) goto L23;
        StringBuilder r104 = new StringBuilder();
        Iterator<String> r105 = r103.iterator();
    L9:
        if (r105.hasNext() == false) goto L15;
        String r106 = r105.next();
        if (r106.startsWith(r101 + ContainerUtils.KEY_VALUE_DELIMITER) == true) goto L12;
        r104.append(r106);
        goto L9
    L12:
        r104.append(r101);
        r104.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r104.append(r102);
        goto L9
    L15:
        return r104.toString();
    L23:
        return r100;
    }

    public static float safeGetFloat(Map<String, Object> r100, String r101, float r102) {
        if (r100 != null) goto L4;
        Object r103 = null;
    L6:
        if ((r103 instanceof Float) == true) goto L8;
        return r102;
    L8:
        return ((Float) r103).floatValue();
    L4:
        r103 = r100.get(r101);
        goto L6
    }

    public static int safeGetInt(Map<String, Object> r100, String r101, int r102) {
        if (r100 != null) goto L4;
        Object r103 = null;
    L6:
        if ((r103 instanceof Integer) == true) goto L8;
        return r102;
    L8:
        return ((Integer) r103).intValue();
    L4:
        r103 = r100.get(r101);
        goto L6
    }

    public static long safeGetLong(Map<String, Object> r100, String r101, long r102) {
        if (r100 != null) goto L4;
        Object r103 = null;
    L6:
        if ((r103 instanceof Long) == true) goto L8;
        return r102;
    L8:
        return ((Long) r103).longValue();
    L4:
        r103 = r100.get(r101);
        goto L6
    }

    public static String safeGetString(Map<String, Object> r100, String r101, String r102) {
        if (r100 != null) goto L4;
        Object r103 = null;
    L6:
        if ((r103 instanceof String) == true) goto L8;
        return r102;
    L8:
        return (String) r103;
    L4:
        r103 = r100.get(r101);
        goto L6
    }

    public static double safeParseDouble(JSONObject r100, String r101, double r102) {
        String r103 = r100.optString(r101);
        if (TextUtils.isEmpty(r103) == false) goto L10;
        return r102;
    L10:
        return CastDoubleProtector.parseDouble(r103);
    L7:
        e = move-exception;
        e.printStackTrace();
        return r102;
    }

    public static float safeParseFloat(JSONObject r100, String r101, float r102) {
        String r103 = r100.optString(r101);
        if (TextUtils.isEmpty(r103) == false) goto L10;
        return r102;
    L10:
        return CastFloatProtector.parseFloat(r103);
    L7:
        e = move-exception;
        e.printStackTrace();
        return r102;
    }
}
