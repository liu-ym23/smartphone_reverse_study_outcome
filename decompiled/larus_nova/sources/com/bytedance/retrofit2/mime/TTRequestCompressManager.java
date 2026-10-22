package com.bytedance.retrofit2.mime;

import android.text.TextUtils;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.common.utility.Logger;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import kotlin.UByte;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: classes3.dex */
public class TTRequestCompressManager {
    private static final String BLOCK_PATH_EQUAL_KEY = "block_path_equal_list";
    private static final String BLOCK_PATH_REGEX_KEY = "block_path_regex_list";
    private static final String BROTLI_COMPRESS_HEADER = "br";
    private static final String COMPRESS_BROTLI_QUALITY_KEY = "br_level";
    private static final String COMPRESS_ENABLED_KEY = "enabled";
    private static final int COMPRESS_MAX_BODY_SIZE = 1048576;
    private static final String COMPRESS_MAX_BODY_SIZE_KEY = "max_body_size";
    private static final String COMPRESS_MAX_BODY_SIZE_MAP_KEY = "max_body_size_map";
    private static final String COMPRESS_MAX_BODY_SIZE_MAP_PATH_EQUAL_KEY = "path_eq";
    private static final String COMPRESS_MAX_BODY_SIZE_MAP_PATH_WILDCHAR_KEY = "path_wc";
    private static final int COMPRESS_MIN_BODY_SIZE = 100;
    private static final String COMPRESS_MIN_BODY_SIZE_KEY = "min_body_size";
    private static final String COMPRESS_REQUEST_KEY = "tt_compress";
    private static final String COMPRESS_REQUEST_TYPE_KEY = "type";
    private static final String COMPRESS_ZSTD_LEVEL_KEY = "zstd_level";
    private static final int DEFAULT_BROTLI_QUALITY = 4;
    private static final int DEFAULT_ZSTD_LEVEL = 6;
    private static final String EQUAL_PATH_KEY = "equal_path";
    private static final String GZIP_COMPRESS_HEADER = "gzip";
    private static final char[] HEX_ARRAY = null;
    private static final String HOST_GROUP_KEY = "host_group";
    private static final int MAX_BROTLI_QUALITY = 11;
    private static final int MAX_ZSTD_LEVEL = 22;
    private static final int MIN_BROTLI_QUALITY = 0;
    private static final int MIN_ZSTD_LEVEL = 1;
    private static final String OPT_ENABLED_KEY = "opt_enabled";
    private static final String PREFIX_PATH_KEY = "prefix_path";
    private static final String REGEX_PATH_KEY = "regex_path";
    private static final String TAG = "TTRequestCompress";
    private static final String ZSTD_COMPRESS_HEADER = "zstd";
    private static final String ZSTD_EQUAL_PATH_KEY = "zstd_equal_path";
    private static final String ZSTD_PREFIX_PATH_KEY = "zstd_prefix_path";
    private static final String ZSTD_REGEX_PATH_KEY = "zstd_regex_path";
    private static AddZstdCompressCallback sAddZstdCompressCallback = null;
    private static CopyOnWriteArraySet<String> sBlockEqualPathArraySet = null;
    private static CopyOnWriteArraySet<Pattern> sBlockPatternPathArraySet = null;
    private static int sBrotliCompressQuality = 0;
    public static volatile CompressDataCallback sCallback = null;
    private static volatile boolean sCompressOptEnabled = false;
    private static CompressType sCompressType = null;
    private static CopyOnWriteArraySet<String> sEqualPathArraySet = null;
    public static volatile Boolean sGlobalCompressDisabled = null;
    private static CopyOnWriteArraySet<String> sHostGroupArraySet = null;
    private static final ConcurrentMap<String, Integer> sMaxBodyCompressEqualPathSize = null;
    private static int sMaxBodyCompressSize = 1048576;
    private static final ConcurrentMap<String, Integer> sMaxBodyCompressWildcardPathSize = null;
    private static int sMinBodyCompressSize;
    private static CopyOnWriteArraySet<String> sPrefixPathArraySet;
    private static CopyOnWriteArraySet<Pattern> sRegexPathArraySet;
    private static volatile boolean sRequestCompressEnabled;
    private static int sZstdCompressLevel;
    private static CopyOnWriteArraySet<String> sZstdEqualPathArraySet;
    private static CopyOnWriteArraySet<String> sZstdPrefixPathArraySet;
    private static CopyOnWriteArraySet<Pattern> sZstdRegexPathArraySet;

    public interface AddZstdCompressCallback {
        byte[] compress(byte[] r100, int r101);

        byte[] decompress(byte[] r100, int r101);
    }

    public static class CompressData {
        public String contentEncoding;
        public byte[] data;
        public int failedCode;
        public String failedPrefixData;
        public CompressType type;

        public CompressData(int r100) {
            this.failedCode = r100;
        }
    }

    public interface CompressDataCallback {
        byte[] compressData(byte[] r100, int r101, int r102, int r103);

        byte[] decompressData(byte[] r100, int r101, int r102);
    }

    public static final enum CompressType extends Enum<CompressType> {
        private static final /* synthetic */ CompressType[] $VALUES = null;
        public static final CompressType BROTLI = null;
        public static final CompressType GZIP = null;
        public static final CompressType NONE = null;
        public static final CompressType ZSTD = null;
        private final int mType;

        static {
            CompressType r100 = new CompressType(UserProfileEvent.POSITION_NONE, 0, 0);
            NONE = r100;
            CompressType r101 = new CompressType("GZIP", 1, 1);
            GZIP = r101;
            CompressType r102 = new CompressType("BROTLI", 2, 2);
            BROTLI = r102;
            CompressType r103 = new CompressType("ZSTD", 3, 3);
            ZSTD = r103;
            $VALUES = new CompressType[]{r100, r101, r102, r103};
        }

        public static CompressType[] values() {
            return (CompressType[]) $VALUES.clone();
        }

        public int getType() {
            return this.mType;
        }

        public static CompressType valueOf(String r100) {
            return (CompressType) a.a(CompressType.class, r100);
        }

        private CompressType(String r100, int r101, int r102) {
            super(r100, r101);
            this.mType = r102;
        }
    }

    public static final enum DisableCompress extends Enum<DisableCompress> {
        private static final /* synthetic */ DisableCompress[] $VALUES = null;
        public static final DisableCompress BODY_ENCODED = null;
        public static final DisableCompress BODY_ENCRYPTED = null;
        public static final DisableCompress BODY_SIZE_MISMATCH = null;
        public static final DisableCompress BODY_SIZE_OVERFLOW = null;
        public static final DisableCompress DATA_NULL = null;
        public static final DisableCompress GLOBAL_DISABLE = null;
        public static final DisableCompress GZIP_PREFIX_MISMATCH = null;
        public static final DisableCompress NONE = null;
        public static final DisableCompress NON_POST_METHOD = null;
        public static final DisableCompress REMOVE_ENCODING = null;
        public static final DisableCompress TNC_DISABLE = null;
        public static final DisableCompress URL_MISMATCH = null;
        public static final DisableCompress USER_DISABLE = null;
        public static final DisableCompress ZSTD_PREFIX_MISMATCH = null;
        private final int reason;

        static {
            DisableCompress r100 = new DisableCompress(UserProfileEvent.POSITION_NONE, 0, 0);
            NONE = r100;
            DisableCompress r101 = new DisableCompress("GLOBAL_DISABLE", 1, 1);
            GLOBAL_DISABLE = r101;
            DisableCompress r102 = new DisableCompress("TNC_DISABLE", 2, 2);
            TNC_DISABLE = r102;
            DisableCompress r103 = new DisableCompress("URL_MISMATCH", 3, 3);
            URL_MISMATCH = r103;
            DisableCompress r104 = new DisableCompress("BODY_SIZE_MISMATCH", 4, 4);
            BODY_SIZE_MISMATCH = r104;
            DisableCompress r105 = new DisableCompress("BODY_SIZE_OVERFLOW", 5, 5);
            BODY_SIZE_OVERFLOW = r105;
            DisableCompress r110 = new DisableCompress("ZSTD_PREFIX_MISMATCH", 6, 6);
            ZSTD_PREFIX_MISMATCH = r110;
            DisableCompress r111 = new DisableCompress("GZIP_PREFIX_MISMATCH", 7, 7);
            GZIP_PREFIX_MISMATCH = r111;
            DisableCompress r112 = new DisableCompress("BODY_ENCRYPTED", 8, 8);
            BODY_ENCRYPTED = r112;
            DisableCompress r113 = new DisableCompress("REMOVE_ENCODING", 9, 9);
            REMOVE_ENCODING = r113;
            DisableCompress r114 = new DisableCompress("DATA_NULL", 10, 10);
            DATA_NULL = r114;
            DisableCompress r115 = new DisableCompress("NON_POST_METHOD", 11, 11);
            NON_POST_METHOD = r115;
            DisableCompress r106 = new DisableCompress("BODY_ENCODED", 12, 12);
            BODY_ENCODED = r106;
            DisableCompress r107 = new DisableCompress("USER_DISABLE", 13, 13);
            USER_DISABLE = r107;
            $VALUES = new DisableCompress[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107};
        }

        public static DisableCompress[] values() {
            return (DisableCompress[]) $VALUES.clone();
        }

        public int getReason() {
            return this.reason;
        }

        public static DisableCompress valueOf(String r100) {
            return (DisableCompress) a.a(DisableCompress.class, r100);
        }

        private DisableCompress(String r100, int r101, int r102) {
            super(r100, r101);
            this.reason = r102;
        }
    }

    public TTRequestCompressManager() {
    }

    private static void resetCompressConfig() {
        sRequestCompressEnabled = false;
        sMaxBodyCompressSize = 1048576;
        sMaxBodyCompressEqualPathSize.clear();
        sMaxBodyCompressWildcardPathSize.clear();
        sMinBodyCompressSize = 100;
        sCompressType = CompressType.NONE;
        sEqualPathArraySet.clear();
        sPrefixPathArraySet.clear();
        sRegexPathArraySet.clear();
        sZstdEqualPathArraySet.clear();
        sZstdPrefixPathArraySet.clear();
        sZstdRegexPathArraySet.clear();
        sHostGroupArraySet.clear();
        sBlockEqualPathArraySet.clear();
        sBlockPatternPathArraySet.clear();
    }

    static {
        sMaxBodyCompressEqualPathSize = new ConcurrentHashMap();
        sMaxBodyCompressWildcardPathSize = new ConcurrentHashMap();
        sMinBodyCompressSize = 100;
        sBrotliCompressQuality = 4;
        sZstdCompressLevel = 6;
        sCompressType = CompressType.NONE;
        sEqualPathArraySet = new CopyOnWriteArraySet();
        sPrefixPathArraySet = new CopyOnWriteArraySet();
        sRegexPathArraySet = new CopyOnWriteArraySet();
        sZstdEqualPathArraySet = new CopyOnWriteArraySet();
        sZstdPrefixPathArraySet = new CopyOnWriteArraySet();
        sZstdRegexPathArraySet = new CopyOnWriteArraySet();
        sHostGroupArraySet = new CopyOnWriteArraySet();
        sBlockEqualPathArraySet = new CopyOnWriteArraySet();
        sBlockPatternPathArraySet = new CopyOnWriteArraySet();
        sGlobalCompressDisabled = Boolean.FALSE;
        HEX_ARRAY = "0123456789ABCDEF".toCharArray();
    }

    public static void setGlobalForbidenCompress() {
        sGlobalCompressDisabled = Boolean.TRUE;
    }

    public static boolean isBodyOptEnabled() {
        return sCompressOptEnabled;
    }

    private static String byteArrayToHexString(byte[] r100) {
        char[] r101 = new char[r100.length * 2];
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L7;
        int r103 = r100[r102] & UByte.MAX_VALUE;
        int r104 = r102 * 2;
        char[] r105 = HEX_ARRAY;
        r101[r104] = r105[r103 >>> 4];
        r101[r104 + 1] = r105[r103 & 15];
        r102 = r102 + 1;
        goto L4
    L7:
        return new String(r101);
    }

    private static void covertIntToCompressType(int r100) {
        if (r100 != 1) goto L5;
        sCompressType = CompressType.GZIP;
        return;
    L5:
        if (r100 != 2) goto L7;
        sCompressType = CompressType.BROTLI;
        return;
    L7:
        if (r100 == 3) goto L9;
        sCompressType = CompressType.NONE;
        return;
    L9:
        sCompressType = CompressType.ZSTD;
    }

    private static int getCompressMaxBodySize(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L5;
        Integer r101 = sMaxBodyCompressEqualPathSize.get(r100);
        if (r101 != null) goto L9;
        Iterator<Map.Entry<String, Integer>> r102 = sMaxBodyCompressWildcardPathSize.entrySet().iterator();
    L12:
        if (r102.hasNext() == false) goto L21;
        Map.Entry<String, Integer> r103 = r102.next();
        if (matchPattern(r100, r103.getKey()) == false) goto L12;
        Integer r104 = r103.getValue();
        if (r104 == null) goto L19;
        return r104.intValue();
    L19:
        return sMaxBodyCompressSize;
    L21:
        return sMaxBodyCompressSize;
    L9:
        return r101.intValue();
    L5:
        return sMaxBodyCompressSize;
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x004b: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]) (LINE:16777291), block:B:32:0x004b */
    public static byte[] gzipDecompress(byte[] r100) {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        GZIPInputStream r102 = null;
        GZIPInputStream r103 = new GZIPInputStream(new ByteArrayInputStream(r100));     // Catch: Throwable -> L18 IOException -> L20
    L46:
        byte[] r104 = new byte[4096];     // Catch: IOException -> L16 Throwable -> L31
    L6:
        int r105 = r103.read(r104);     // Catch: IOException -> L16 Throwable -> L31
        if (r105 < 0) goto L41;
        r101.write(r104, 0, r105);     // Catch: IOException -> L16 Throwable -> L31
        goto L6
    L41:
        r103.close();     // Catch: IOException -> L12
        r101.close();     // Catch: IOException -> L12
    L15:
        return r101.toByteArray();
    L12:
        e = move-exception;
        e.printStackTrace();
    L16:
        e = e;
    L22:
        e.toString();     // Catch: Throwable -> L31
        if (r103 != null) goto L48;
    L27:
        r101.close();     // Catch: IOException -> L25
    L30:
        return null;
    L25:
        e = move-exception;
        e.printStackTrace();
        goto L30
    L48:
        r103.close();     // Catch: IOException -> L25
    L31:
        th = th;
        r102 = r2;
    L33:
        if (r102 != null) goto L43;
    L37:
        r101.close();     // Catch: IOException -> L35
    L40:
        throw th;
    L35:
        e = move-exception;
        e.printStackTrace();
        goto L40
    L43:
        r102.close();     // Catch: IOException -> L35
    L20:
        e = e;
        r103 = null;
    L18:
        th = th;
        goto L33
    }

    private static boolean isEmptySet(Set<?> r100) {
        if (r100 != null) goto L4;
        return true;
    L4:
        if (r100.isEmpty() == true) goto L10;
        return false;
    L10:
        return true;
    }

    private static boolean isHostMatch(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        Iterator<String> r101 = sHostGroupArraySet.iterator();
    L7:
        if (r101.hasNext() == false) goto L15;
        if (matchPattern(r100, r101.next()) == false) goto L7;
        return true;
    L15:
        return false;
    }

    public static void onServerConfigChanged(JSONObject r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        resetCompressConfig();
        JSONObject r101 = r100.optJSONObject(COMPRESS_REQUEST_KEY);
        if (r101 != null) goto L7;
        return;
    L7:
        boolean r102 = false;
        if (r101.optInt(COMPRESS_ENABLED_KEY, 0) <= 0) goto L10;
        boolean r103 = true;
    L11:
        sRequestCompressEnabled = r103;
        if (r101.optInt(OPT_ENABLED_KEY, 0) <= 0) goto L14;
        r102 = true;
    L14:
        sCompressOptEnabled = r102;
        sMaxBodyCompressSize = r101.optInt(COMPRESS_MAX_BODY_SIZE_KEY, 1048576);
        JSONObject r104 = r101.optJSONObject(COMPRESS_MAX_BODY_SIZE_MAP_KEY);
        if (r104 == null) goto L17;
        parseObjectMapStringConfig(r104, COMPRESS_MAX_BODY_SIZE_MAP_PATH_EQUAL_KEY, sMaxBodyCompressEqualPathSize);
        parseObjectMapStringConfig(r104, COMPRESS_MAX_BODY_SIZE_MAP_PATH_WILDCHAR_KEY, sMaxBodyCompressWildcardPathSize);
    L17:
        sMinBodyCompressSize = r101.optInt(COMPRESS_MIN_BODY_SIZE_KEY, 100);
        int r105 = r101.optInt(COMPRESS_BROTLI_QUALITY_KEY, 4);
        if (r105 >= 0) goto L20;
    L22:
        int r106 = r101.optInt(COMPRESS_ZSTD_LEVEL_KEY, 6);
        if (r106 >= 1) goto L25;
    L27:
        covertIntToCompressType(r101.optInt("type", CompressType.GZIP.getType()));
        parseArraySetStringConfig(r101.optJSONArray(EQUAL_PATH_KEY), sEqualPathArraySet);
        parseArraySetStringConfig(r101.optJSONArray(PREFIX_PATH_KEY), sPrefixPathArraySet);
        parseArraySetPatternConfig(r101.optJSONArray(REGEX_PATH_KEY), sRegexPathArraySet);
        parseArraySetStringConfig(r101.optJSONArray(ZSTD_EQUAL_PATH_KEY), sZstdEqualPathArraySet);
        parseArraySetStringConfig(r101.optJSONArray(ZSTD_PREFIX_PATH_KEY), sZstdPrefixPathArraySet);
        parseArraySetPatternConfig(r101.optJSONArray(ZSTD_REGEX_PATH_KEY), sZstdRegexPathArraySet);
        parseArraySetStringConfig(r101.optJSONArray(HOST_GROUP_KEY), sHostGroupArraySet);
        parseArraySetStringConfig(r101.optJSONArray(BLOCK_PATH_EQUAL_KEY), sBlockEqualPathArraySet);
        parseArraySetPatternConfig(r101.optJSONArray(BLOCK_PATH_REGEX_KEY), sBlockPatternPathArraySet);
        if (Logger.debug() == true) goto L30;
        return;
    L30:
        return;
    L25:
        if (r106 > 22) goto L27;
        sZstdCompressLevel = r106;
        goto L27
    L20:
        if (r105 > 11) goto L22;
        sBrotliCompressQuality = r105;
        goto L22
    L10:
        r103 = false;
        goto L11
    }

    public static void setAddZstdCompressCallback(AddZstdCompressCallback r100) {
        sAddZstdCompressCallback = r100;
    }

    public static void setCompressDataCallback(CompressDataCallback r100) {
        sCallback = r100;
    }

    public static byte[] brotliDecompress(byte[] r100, int r101) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (sCallback != null) goto L8;
        return null;
    L8:
        return sCallback.decompressData(r100, r101, CompressType.BROTLI.getType());
    }

    private static CompressType getCompressType(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == true) goto L89;
        if (TextUtils.isEmpty(r101) == true) goto L89;
        if (isEmptySet(sZstdEqualPathArraySet) == true) goto L14;
        if (sZstdEqualPathArraySet.contains(r101) == false) goto L14;
        return CompressType.ZSTD;
    L14:
        if (isEmptySet(sZstdPrefixPathArraySet) == true) goto L23;
        Iterator<String> r102 = sZstdPrefixPathArraySet.iterator();
    L17:
        if (r102.hasNext() == false) goto L23;
        if (r101.startsWith(r102.next()) == false) goto L17;
        return CompressType.ZSTD;
    L23:
        if (isEmptySet(sZstdRegexPathArraySet) == true) goto L35;
        Iterator<Pattern> r103 = sZstdRegexPathArraySet.iterator();
    L26:
        if (r103.hasNext() == false) goto L35;
        Pattern r104 = r103.next();
        if (r104 == null) goto L26;
        if (r104.matcher(r101).matches() == false) goto L26;
        return CompressType.ZSTD;
    L35:
        if (isEmptySet(sEqualPathArraySet) == true) goto L41;
        if (sEqualPathArraySet.contains(r101) == false) goto L41;
        return sCompressType;
    L41:
        if (isEmptySet(sPrefixPathArraySet) == true) goto L50;
        Iterator<String> r105 = sPrefixPathArraySet.iterator();
    L44:
        if (r105.hasNext() == false) goto L50;
        if (r101.startsWith(r105.next()) == false) goto L44;
        return sCompressType;
    L50:
        if (isEmptySet(sRegexPathArraySet) == true) goto L62;
        Iterator<Pattern> r106 = sRegexPathArraySet.iterator();
    L53:
        if (r106.hasNext() == false) goto L62;
        Pattern r107 = r106.next();
        if (r107 == null) goto L53;
        if (r107.matcher(r101).matches() == false) goto L53;
        return sCompressType;
    L62:
        if (isEmptySet(sHostGroupArraySet) == true) goto L87;
        if (isHostMatch(r100) == false) goto L87;
        if (isEmptySet(sBlockEqualPathArraySet) == true) goto L73;
        if (sBlockEqualPathArraySet.contains(r101) == false) goto L73;
        return CompressType.NONE;
    L73:
        if (isEmptySet(sBlockPatternPathArraySet) == true) goto L85;
        Iterator<Pattern> r108 = sBlockPatternPathArraySet.iterator();
    L76:
        if (r108.hasNext() == false) goto L85;
        Pattern r109 = r108.next();
        if (r109 == null) goto L76;
        if (r109.matcher(r101).matches() == false) goto L76;
        return CompressType.NONE;
    L85:
        return sCompressType;
    L87:
        return CompressType.NONE;
    L89:
        return CompressType.NONE;
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0022: MOVE (r4 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]) (LINE:33554466), block:B:15:0x0022 */
    public static byte[] gzipCompress(byte[] r100, int r101) {
        GZIPOutputStream r102 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        ByteArrayOutputStream r103 = new ByteArrayOutputStream();
        GZIPOutputStream r104 = new GZIPOutputStream(r103);     // Catch: Throwable -> L18 IOException -> L20
        r104.write(r100);     // Catch: Throwable -> L14 IOException -> L16
        r104.close();     // Catch: IOException -> L10
        r103.close();     // Catch: IOException -> L10
    L13:
        return r103.toByteArray();
    L10:
        e = move-exception;
        e.printStackTrace();
    L16:
        e = e;
    L22:
        e.toString();     // Catch: Throwable -> L14
        if (r104 != null) goto L42;
    L27:
        r103.close();     // Catch: IOException -> L25
    L30:
        return null;
    L25:
        e = move-exception;
        e.printStackTrace();
        goto L30
    L42:
        r104.close();     // Catch: IOException -> L25
        goto L27
    L14:
        th = th;
        r102 = r1;
    L31:
        if (r102 != null) goto L44;
    L35:
        r103.close();     // Catch: IOException -> L33
    L38:
        throw th;
    L33:
        e = move-exception;
        e.printStackTrace();
        goto L38
    L44:
        r102.close();     // Catch: IOException -> L33
    L20:
        e = e;
        r104 = null;
    L18:
        th = th;
        goto L31
    }

    private static boolean matchPattern(String r110, String r111) {
        if (r110 == null) goto L29;
        if (r111 == null) goto L29;
        int r100 = r110.length();
        int r101 = r111.length();
        int r102 = 0;
        int r103 = 0;
        int r104 = -1;
        int r105 = -1;
    L8:
        if (r102 >= r100) goto L22;
        if (r103 >= r101) goto L15;
        if (r111.charAt(r103) == '?') goto L14;
        if (r111.charAt(r103) != r110.charAt(r102)) goto L15;
    L14:
        r102 = r102 + 1;
        r103 = r103 + 1;
    L15:
        if (r103 >= r101) goto L19;
        if (r111.charAt(r103) != '*') goto L19;
        r105 = r102;
        r104 = r103;
        r103 = r103 + 1;
    L19:
        if (r104 == (-1)) goto L20;
        r103 = r104 + 1;
        r105 = r105 + 1;
        r102 = r105;
        goto L8
    L20:
        return false;
    L22:
        if (r103 >= r101) goto L27;
        if (r111.charAt(r103) != '*') goto L25;
        r103 = r103 + 1;
        goto L22
    L25:
        return false;
    L27:
        return true;
    L29:
        return false;
    }

    private static void parseArraySetPatternConfig(JSONArray r100, CopyOnWriteArraySet<Pattern> r101) {
        if (r100 == null) goto L13;
        if (r101 == null) goto L23;
        int r102 = 0;
    L16:
        if (r102 >= r100.length()) goto L25;
        String r103 = JSONArrayProtectorUtils.getString(r100, r102);     // Catch: JSONException -> L15
        if (TextUtils.isEmpty(r103) == true) goto L12;
        r101.add(PatternProtector.compile(r103, 2));     // Catch: Throwable -> L14
    L12:
        r102 = r102 + 1;
        goto L16
    L25:
        return;
    L24:
        return;
    L23:
        return;
    }

    private static void parseArraySetStringConfig(JSONArray r100, CopyOnWriteArraySet<String> r101) {
        if (r100 == null) goto L12;
        if (r101 == null) goto L19;
        int r102 = 0;
    L14:
        if (r102 >= r100.length()) goto L21;
        String r103 = JSONArrayProtectorUtils.getString(r100, r102);     // Catch: JSONException -> L13
        if (TextUtils.isEmpty(r103) == true) goto L11;
        r101.add(r103);     // Catch: JSONException -> L13
    L11:
        r102 = r102 + 1;
        goto L14
    L21:
        return;
    L20:
        return;
    L19:
        return;
    }

    public static byte[] zstdCompress(byte[] r100, int r101) {
        AddZstdCompressCallback r102 = sAddZstdCompressCallback;
        if (r102 != null) goto L5;
        return null;
    L5:
        return r102.compress(r100, r101);
    }

    public static byte[] zstdDecompress(byte[] r100, int r101) {
        AddZstdCompressCallback r102 = sAddZstdCompressCallback;
        if (r102 != null) goto L5;
        return null;
    L5:
        return r102.decompress(r100, r101);
    }

    public static byte[] brotliCompress(byte[] r100, int r101, int r102) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (sCallback != null) goto L8;
        return null;
    L8:
        return sCallback.compressData(r100, r101, r102, CompressType.BROTLI.getType());
    }

    public static byte[] decompressDataByType(byte[] r100, String r101, int r102) {
        if (r100 != null) goto L4;
        return r100;
    L4:
        if (TextUtils.isEmpty(r101) == true) goto L30;
        r101.getClass();
        byte r103 = -1;
        switch(r101.hashCode()) {
            case 3152: goto L18;
            case 3189082: goto L14;
            case 3748713: goto L10;
            default: goto L21;
        };
    L21:
        switch(r103) {
            case 0: goto L28;
            case 1: goto L26;
            case 2: goto L24;
            default: goto L22;
        };
    L22:
        return r100;
    L24:
        return zstdDecompress(r100, r102);
    L26:
        return gzipDecompress(r100);
    L28:
        return brotliDecompress(r100, r100.length);
    L10:
        if (r101.equals(ZSTD_COMPRESS_HEADER) == false) goto L21;
        r103 = 2;
        goto L21
    L14:
        if (r101.equals("gzip") == false) goto L21;
        r103 = 1;
        goto L21
    L18:
        if (r101.equals("br") == false) goto L21;
        r103 = 0;
        goto L21
    L30:
        return r100;
    }

    private static void parseObjectMapStringConfig(JSONObject r100, String r101, ConcurrentMap<String, Integer> r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r101) == true) goto L29;
        if (r102 == null) goto L30;
        JSONObject r103 = r100.optJSONObject(r101);
        if (r103 != null) goto L10;
        return;
    L10:
        HashMap r104 = new HashMap();
        Iterator<String> r105 = r103.keys();
    L12:
        if (r105.hasNext() == false) goto L19;
        String r106 = r105.next();
        if (TextUtils.isEmpty(r106) == true) goto L12;
        int r107 = r103.optInt(r106);
        if (r107 <= 0) goto L12;
        r104.put(r106, Integer.valueOf(r107));
        goto L12
    L19:
        r102.clear();
        r102.putAll(r104);
        return;
    L30:
        return;
    }

    public static boolean canUseCompressedBody(int r100, byte[] r101, CompressType r102, CompressData r103) {
        if (r101 != null) goto L5;
    L37:
        return false;
    L5:
        if (r101.length <= 3) goto L37;
        if (sCompressOptEnabled == true) goto L11;
        return true;
    L11:
        if (r101.length < r100) goto L15;
        r103.failedCode = DisableCompress.BODY_SIZE_OVERFLOW.getReason();
        return false;
    L15:
        if (r102 != CompressType.GZIP) goto L26;
        byte r104 = r101[0];
        byte r105 = r101[1];
        byte r106 = r101[2];
        if (r104 == 31) goto L19;
    L23:
        r103.failedCode = DisableCompress.GZIP_PREFIX_MISMATCH.getReason();
        r103.failedPrefixData = byteArrayToHexString(new byte[]{r104, r105, r106});
        return false;
    L19:
        if (r105 != (-117)) goto L23;
        if (r106 != 8) goto L23;
        return true;
    L26:
        if (r102 != CompressType.ZSTD) goto L36;
        byte r107 = r101[0];
        byte r108 = r101[1];
        byte r109 = r101[2];
        if (r107 == 40) goto L30;
    L34:
        r103.failedCode = DisableCompress.ZSTD_PREFIX_MISMATCH.getReason();
        r103.failedPrefixData = byteArrayToHexString(new byte[]{r107, r108, r109});
        return false;
    L30:
        if (r108 != (-75)) goto L34;
        if (r109 != 47) goto L34;
        return true;
    L36:
        return true;
    }

    public static CompressData compressBody(byte[] r100, int r101, String r102, String r103, boolean r104) {
        CompressData r105 = new CompressData(0);
        if (sGlobalCompressDisabled.booleanValue() == false) goto L7;
        Logger.debug();
        r105.failedCode = DisableCompress.GLOBAL_DISABLE.getReason();
        return r105;
    L7:
        if (sRequestCompressEnabled == false) goto L52;
        CompressType r106 = sCompressType;
        CompressType r107 = CompressType.NONE;
        if (r106 == r107) goto L52;
        CompressType r108 = getCompressType(r102, r103);
        if (r104 == true) goto L20;
        if (r108 != r107) goto L20;
        if (Logger.debug() == true) goto L17;
    L17:
        r105.failedCode = DisableCompress.URL_MISMATCH.getReason();
        return r105;
    L20:
        if (r101 > getCompressMaxBodySize(r103)) goto L48;
        if (r101 < sMinBodyCompressSize) goto L48;
        if (r108 != CompressType.GZIP) goto L32;
        byte[] r109 = gzipCompress(r100, r101);
        if (canUseCompressedBody(r101, r109, r108, r105) == true) goto L29;
        return r105;
    L29:
        r105.data = r109;
        r105.type = r108;
        r105.contentEncoding = "gzip";
        return r105;
    L32:
        if (r108 != CompressType.BROTLI) goto L39;
        byte[] r110 = brotliCompress(r100, r101, sBrotliCompressQuality);
        if (canUseCompressedBody(r101, r110, r108, r105) == true) goto L36;
        return r105;
    L36:
        r105.data = r110;
        r105.type = r108;
        r105.contentEncoding = "br";
        return r105;
    L39:
        if (r108 != CompressType.ZSTD) goto L45;
        byte[] r111 = zstdCompress(r100, sZstdCompressLevel);
        if (canUseCompressedBody(r101, r111, r108, r105) == true) goto L43;
        return r105;
    L43:
        r105.data = r111;
        r105.type = r108;
        r105.contentEncoding = ZSTD_COMPRESS_HEADER;
        return r105;
    L45:
        return null;
    L48:
        if (Logger.debug() == true) goto L50;
    L50:
        r105.failedCode = DisableCompress.BODY_SIZE_MISMATCH.getReason();
        return r105;
    L52:
        Logger.debug();
        r105.failedCode = DisableCompress.TNC_DISABLE.getReason();
        return r105;
    }
}
