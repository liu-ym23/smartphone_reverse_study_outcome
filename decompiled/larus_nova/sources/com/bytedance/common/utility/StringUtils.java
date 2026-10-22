package com.bytedance.common.utility;

import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class StringUtils {
    private static final int CHAR_12288 = 12288;
    private static final int CHAR_127 = 127;
    private static final int CHAR_32 = 32;
    private static final int CHAR_65248 = 65248;
    private static final int CHAR_65280 = 65280;
    private static final int CHAR_65375 = 65375;
    private static final int CHAR_MAX = 31;
    public static final String EMPTY = "";
    private static final long G = 1073741824;
    private static final long K = 1024;
    private static final long M = 1048576;
    private static final int STRING_MAX_NUM = 255;
    private static final long T = 1099511627776L;
    private static final int XOR_MASK = 5;

    private StringUtils() {
    }

    public static String bytesToHuman(long r100) {
        long[] r101 = {1099511627776L, 1073741824, 1048576, 1024, 1};
        String[] r102 = {"TB", "GB", "MB", "KB", "B"};
        if (r100 < 1) goto L5;
        int r103 = 0;
    L7:
        if (r103 >= 5) goto L12;
        long r104 = r101[r103];
        if (r100 >= r104) goto L16;
        r103 = r103 + 1;
        goto L7
    L16:
        return format(r100, r104, r102[r103]);
    L12:
        return null;
    L5:
        return "0 " + r102[4];
    }

    public static String clean(String r100) {
        int r101 = r100.indexOf(34);
        int r102 = r100.lastIndexOf(34);
        if (r101 < 0) goto L7;
        if (r102 > r101) goto L6;
        return r100;
    L6:
        return r100.substring(r101 + 1, r102).trim();
    L7:
        return r100;
    }

    public static String compressWithGzip(String r100) throws IOException {
        if (isEmpty(r100) == false) goto L37;
        return null;
    L37:
        ByteArrayOutputStream r101 = new ByteArrayOutputStream(r100.length());     // Catch: Throwable -> L14
        GZIPOutputStream r102 = new GZIPOutputStream(r101);     // Catch: Throwable -> L12
        r102.write(r100.getBytes());     // Catch: Throwable -> L10
        r102.close();     // Catch: Throwable -> L10
        byte[] r103 = r101.toByteArray();     // Catch: Throwable -> L10
        String r104 = DigestUtils.toHexString(r103, 0, r103.length);     // Catch: Throwable -> L10
        r102.close();     // Catch: Throwable -> L28
        r101.close();     // Catch: Throwable -> L28
    L9:
        return r104;
    L10:
        th = th;
    L43:
        Logger.d("Thread", th.getMessage());     // Catch: Throwable -> L22
        if (r102 != null) goto L41;
    L19:
        if (r101 == null) goto L21;
        r101.close();     // Catch: Throwable -> L29
    L21:
        return null;
    L41:
        r102.close();     // Catch: Throwable -> L29
    L22:
        th = move-exception;
        if (r102 != null) goto L39;
    L25:
        if (r101 == null) goto L27;
        r101.close();     // Catch: Throwable -> L30
    L27:
        throw th;
    L39:
        r102.close();     // Catch: Throwable -> L30
    L12:
        th = th;
        r102 = null;
    L14:
        th = th;
        r101 = null;
        r102 = null;
        goto L43
    }

    public static String decompressWithGzip(String r100) throws IOException {
        if (isEmpty(r100) == false) goto L52;
        return null;
    L52:
        ByteArrayInputStream r101 = new ByteArrayInputStream(DigestUtils.hexStringToBytes(r100));     // Catch: Throwable -> L21
        GZIPInputStream r102 = new GZIPInputStream(r101);     // Catch: Throwable -> L19
        BufferedReader r103 = new BufferedReader(new InputStreamReader(r102, "UTF-8"));     // Catch: Throwable -> L17
        StringBuilder r104 = new StringBuilder();     // Catch: Throwable -> L15
    L9:
        String r105 = r103.readLine();     // Catch: Throwable -> L15
        if (r105 == null) goto L12;
        r104.append(r105);     // Catch: Throwable -> L15
        goto L9
    L12:
        String r106 = r104.toString();     // Catch: Throwable -> L15
        r103.close();     // Catch: Throwable -> L39
        r102.close();     // Catch: Throwable -> L39
        r101.close();     // Catch: Throwable -> L39
    L14:
        return r106;
    L15:
        th = th;
    L50:
        Logger.d("Thread", th.getMessage());     // Catch: Throwable -> L31
        if (r103 != null) goto L44;
    L26:
        if (r102 == null) goto L28;
        r102.close();     // Catch: Throwable -> L40
    L28:
        if (r101 == null) goto L30;
        r101.close();     // Catch: Throwable -> L40
    L30:
        return null;
    L44:
        r103.close();     // Catch: Throwable -> L40
    L31:
        th = move-exception;
        if (r103 != null) goto L48;
    L34:
        if (r102 == null) goto L36;
        r102.close();     // Catch: Throwable -> L41
    L36:
        if (r101 == null) goto L38;
        r101.close();     // Catch: Throwable -> L41
    L38:
        throw th;
    L48:
        r103.close();     // Catch: Throwable -> L41
    L17:
        th = th;
        r103 = null;
    L19:
        th = th;
        r102 = null;
        r103 = null;
    L21:
        th = th;
        r102 = null;
        r101 = null;
        r103 = null;
        goto L50
    }

    public static String encryptWithXor(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return null;
    L6:
        byte[] r101 = r100.getBytes("UTF-8");     // Catch: Exception -> L12
        int r102 = 0;
    L8:
        if (r102 >= r101.length) goto L10;
        r101[r102] = (byte) (r101[r102] ^ 5);     // Catch: Exception -> L12
        r102 = r102 + 1;     // Catch: Exception -> L12
        goto L8
    L10:
        return DigestUtils.toHexString(r101, 0, r101.length);
    L16:
        return r100;
    }

    public static String getShortDateTime(String r100) {
        int r101 = r100.indexOf(45) + 1;
        int r102 = r100.lastIndexOf(58);
        if (r101 <= 0) goto L7;
        if (r102 > 0) goto L6;
        return r100;
    L6:
        return r100.substring(r101, r102);
    L7:
        return r100;
    }

    public static String handleAdClickTrackUrl(String r100) {
        if (isEmpty(r100) == true) goto L11;
        return r100.replace("[ss_random]", String.valueOf(new Random().nextLong())).replace("[ss_timestamp]", String.valueOf(System.currentTimeMillis()));
    L6:
        e = move-exception;
        e.printStackTrace();
        return r100;
    L11:
        return r100;
    }

    public static boolean isChinese(char r100) {
        Character.UnicodeBlock r101 = Character.UnicodeBlock.of(r100);
        if (r101 != Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS) goto L5;
        return true;
    L5:
        if (r101 != Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS) goto L7;
        return true;
    L7:
        if (r101 != Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A) goto L9;
        return true;
    L9:
        if (r101 != Character.UnicodeBlock.GENERAL_PUNCTUATION) goto L11;
        return true;
    L11:
        if (r101 != Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION) goto L13;
        return true;
    L13:
        if (r101 == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) goto L23;
        return false;
    L23:
        return true;
    }

    public static boolean isEmpty(String r100) {
        if (r100 != null) goto L4;
        return true;
    L4:
        if (r100.length() == 0) goto L10;
        return false;
    L10:
        return true;
    }

    public static String mapToString(Map<String, String> r100) {
        if (r100 != null) goto L17;
        return null;
    L17:
        JSONObject r101 = new JSONObject();     // Catch: Exception -> L16
        Iterator<String> r102 = r100.keySet().iterator();     // Catch: Exception -> L16
    L7:
        if (r102.hasNext() == false) goto L14;
        String r103 = r102.next();     // Catch: Exception -> L16
        String r104 = r100.get(r103);     // Catch: Exception -> L16
        if (isEmpty(r103) == true) goto L7;
        if (isEmpty(r104) == true) goto L7;
        r101.put(r103, r104);     // Catch: Exception -> L16
        goto L7
    L14:
        return r101.toString();
    L16:
        return null;
    }

    public static HashMap<String, String> parseResponse(String r100) {
        int r101 = r100.indexOf(123);
        int r102 = r101 + 1;
        String[] r103 = r100.substring(r102, r100.lastIndexOf(125)).split(",");
        int r104 = 0;
    L4:
        if (r104 >= r103.length) goto L6;
        r103[r104] = r103[r104].trim();
        r104 = r104 + 1;
        goto L4
    L6:
        HashMap<String, String> r105 = new HashMap();
        int r106 = 0;
    L8:
        if (r106 >= r103.length) goto L10;
        String[] r107 = r103[r106].split(":", 2);
        r105.put(clean(r107[0]), clean(r107[1]));
        r106 = r106 + 1;
        goto L8
    L10:
        return r105;
    }

    public static String removeBlank(String r100) {
        if (isEmpty(r100) == false) goto L6;
        return "";
    L6:
        StringBuffer r101 = new StringBuffer();
        int r102 = 0;
    L8:
        if (r102 >= r100.length()) goto L16;
        if (r100.charAt(r102) < '0') goto L14;
        if (r100.charAt(r102) > '9') goto L14;
        r101.append(r100.charAt(r102));
    L14:
        r102 = r102 + 1;
        goto L8
    L16:
        return r101.toString();
    }

    public static String strEncode(String r100) {
        if (isEmpty(r100) == true) goto L9;
        return URLEncoder.encode(r100, "UTF-8");
    L10:
        return r100;
    L9:
        return r100;
    }

    public static String toDBC(String r100) {
        char[] r101 = r100.toCharArray();
        int r102 = 0;
    L4:
        if (r102 >= r101.length) goto L18;
        if (isChinese(r101[r102]) == false) goto L16;
        char r103 = r101[r102];
        if (r103 != 12288) goto L12;
        r101[r102] = ' ';
        goto L16
    L12:
        if (r103 <= 65280) goto L16;
        if (r103 >= CHAR_65375) goto L16;
        r101[r102] = (char) (r103 - CHAR_65248);
    L16:
        r102 = r102 + 1;
        goto L4
    L18:
        return new String(r101);
    }

    public static String toSBC(String r100) {
        char[] r101 = r100.toCharArray();
        int r102 = 0;
    L4:
        if (r102 >= r101.length) goto L14;
        char r103 = r101[r102];
        if (r103 != ' ') goto L9;
        r101[r102] = 12288;
    L12:
        r102 = r102 + 1;
        goto L4
    L9:
        if (r103 >= 127) goto L12;
        if (r103 <= ' ') goto L12;
        r101[r102] = (char) (r103 + CHAR_65248);
        goto L12
    L14:
        return new String(r101);
    }

    public static String trimString(String r100) {
        if (r100 != null) goto L4;
        return r100;
    L4:
        if (r100.length() != 0) goto L7;
        return r100;
    L7:
        return r100.trim();
    }

    public static String decryptWithXor(String r100, Boolean... r101) {
    L20:
        return r100;
    L3:
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return null;
    L7:
        if (r101 != null) goto L9;
    L13:
        byte[] r102 = DigestUtils.hexStringToBytes(r100);     // Catch: Exception -> L20
    L14:
        int r103 = 0;
    L16:
        if (r103 >= r102.length) goto L18;
        r102[r103] = (byte) (r102[r103] ^ 5);     // Catch: Exception -> L20
        r103 = r103 + 1;     // Catch: Exception -> L20
        goto L16
    L18:
        return new String(r102, 0, r102.length, "UTF-8");
    L9:
        if (r101.length <= 0) goto L13;
        if (r101[0].booleanValue() == false) goto L13;
        r102 = Base64.decode(r100, 0);     // Catch: Exception -> L20
        goto L14
    }

    public static String ellipsize(String r100, int r101) {
        if (r100 != null) goto L5;
        return "";
    L5:
        StringBuilder r102 = new StringBuilder();
        int r103 = 0;
        int r104 = 0;
    L7:
        if (r103 >= r100.length()) goto L18;
        char r105 = r100.charAt(r103);
        if (r105 > 0) goto L11;
    L13:
        r104 = r104 + 2;
    L14:
        if (r104 > r101) goto L15;
        r102.append(r105);
        r103 = r103 + 1;
        goto L7
    L15:
        r102.append("...");
        goto L18
    L11:
        if (r105 > 255) goto L13;
        r104 = r104 + 1;
    L18:
        return r102.toString();
    }

    public static boolean equal(String r100, String r101) {
        if (isEmpty(r100) == true) goto L5;
    L6:
        if (r100 != null) goto L8;
    L10:
        return false;
    L8:
        if (r100.equals(r101) == false) goto L10;
    L9:
        return true;
    L5:
        if (isEmpty(r101) == true) goto L9;
        goto L6
    }

    public static Map<String, String> stringToMap(String r100, Map<String, String> r101) {
        if (isEmpty(r100) == true) goto L18;
        if (r101 == null) goto L32;
        JSONObject r102 = new JSONObject(r100);     // Catch: Exception -> L20
        Iterator<String> r103 = r102.keys();     // Catch: Exception -> L20
    L8:
        if (r103.hasNext() == false) goto L17;
        String r104 = r103.next();     // Catch: Exception -> L20
        String r105 = JSONObjectProtectorUtils.getString(r102, r104);     // Catch: Exception -> L20
        if (isEmpty(r104) == true) goto L8;
        if (isEmpty(r105) == true) goto L8;
        r101.put(r104, r105);     // Catch: Exception -> L20
    L17:
        return r101;
    L32:
        return null;
    L18:
        return null;
    }

    public static void escapeEcmaScript(StringBuilder r100, String r101, boolean r110) {
        if (r110 == false) goto L5;
        r100.append("\"");
    L5:
        int r102 = r101.length();
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L31;
        char r104 = r101.charAt(r103);
        if (r104 != '\f') goto L10;
        r100.append("\\f");
    L30:
        r103 = r103 + 1;
        goto L6
    L10:
        if (r104 != '\r') goto L12;
        r100.append("\\r");
        goto L30
    L12:
        if (r104 == '\"') goto L27;
        if (r104 == '\\') goto L27;
        if (r104 != 8232) goto L17;
    L26:
        r100.append(String.format("\\u%04x", new Object[]{Integer.valueOf(r104)}));
        goto L30
    L17:
        if (r104 == 8233) goto L26;
        switch(r104) {
            case 8: goto L25;
            case 9: goto L24;
            case 10: goto L23;
            default: goto L20;
        };
    L23:
        r100.append("\\n");
        goto L30
    L24:
        r100.append("\\t");
        goto L30
    L25:
        r100.append("\\b");
        goto L30
    L20:
        if (r104 > 31) goto L22;
        r100.append(String.format("\\u%04x", new Object[]{Integer.valueOf(r104)}));
        goto L30
    L22:
        r100.append(r104);
    L27:
        r100.append('\\');
        r100.append(r104);
        goto L30
    L31:
        if (r110 == false) goto L44;
        r100.append("\"");
        return;
    }

    private static String format(long r100, long r101, String r102) {
        double r103 = r100;
        if (r101 <= 1) goto L6;
        r103 = r103 / r101;
    L6:
        return new DecimalFormat("#.##").format(r103) + " " + r102;
    }
}
