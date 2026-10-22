package com.bytedance.frameworks.baselib.network.http.util;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.UriProtector;
import java.io.IOException;
import java.net.URI;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public class UrlUtils {
    public static final String CONTENT_TYPE = "Content-Type";
    public static final int CR = 13;
    public static final String DEFAULT_CONTENT_CHARSET = "ISO-8859-1";
    private static final String DOMAIN_NAME_STR = "(([a-zA-Z0-9[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]]](?:[a-zA-Z0-9[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]]_\\-]{0,61}[a-zA-Z0-9[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]]]){0,1}\\.)+(xn\\-\\-[\\w\\-]{0,58}\\w|[a-zA-Z[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]]]{2,63})|((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9])))";
    private static final String HOST_NAME = "([a-zA-Z0-9[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]]](?:[a-zA-Z0-9[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]]_\\-]{0,61}[a-zA-Z0-9[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]]]){0,1}\\.)+(xn\\-\\-[\\w\\-]{0,58}\\w|[a-zA-Z[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]]]{2,63})";
    public static final int HT = 9;
    private static final String IP_ADDRESS_STRING = "((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9]))";
    private static final String IRI_LABEL = "[a-zA-Z0-9[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]]](?:[a-zA-Z0-9[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]]_\\-]{0,61}[a-zA-Z0-9[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]]]){0,1}";
    private static final String LABEL_CHAR = "a-zA-Z0-9[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]]";
    public static final int LF = 10;
    private static final String NAME_VALUE_SEPARATOR = "=";
    private static final String PARAMETER_SEPARATOR = "&";
    private static final String PATH_AND_QUERY = "[/\\?](?:(?:[a-zA-Z0-9[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]];/\\?:@&=#~\\-\\.\\+!\\*'\\(\\),_\\$])|(?:%[a-fA-F0-9]{2}))*";
    private static final String PORT_NUMBER = "\\:\\d{1,5}";
    private static final String PROTOCOL = "(?i:http|https|rtsp|ws|wss)://";
    private static final String PUNYCODE_TLD = "xn\\-\\-[\\w\\-]{0,58}\\w";
    public static final int SP = 32;
    private static final String TLD = "(xn\\-\\-[\\w\\-]{0,58}\\w|[a-zA-Z[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]]]{2,63})";
    private static final String TLD_CHAR = "a-zA-Z[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]]";
    private static final String UCS_CHAR = "[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]]";
    public static final String USER_AGENT = "User-Agent";
    private static final String USER_INFO = "(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,64}(?:\\:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,25})?\\@";
    public static final String UTF_8 = "UTF-8";
    public static final Pattern WEB_URL = null;
    private static final String WORD_BOUNDARY = "(?:\\b|$|^)";

    public UrlUtils() {
    }

    public static boolean isWhitespace(char r100) {
        if (r100 != ' ') goto L5;
    L12:
        return true;
    L5:
        if (r100 == '\t') goto L12;
        if (r100 == '\r') goto L12;
        if (r100 == '\n') goto L12;
        return false;
    }

    static {
        WEB_URL = PatternProtector.compile("(((?:(?i:http|https|rtsp|ws|wss)://(?:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,64}(?:\\:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,25})?\\@)?)?(?:(([a-zA-Z0-9[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]]](?:[a-zA-Z0-9[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]]_\\-]{0,61}[a-zA-Z0-9[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]]]){0,1}\\.)+(xn\\-\\-[\\w\\-]{0,58}\\w|[a-zA-Z[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]]]{2,63})|((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9]))))(?:\\:\\d{1,5})?)([/\\?](?:(?:[a-zA-Z0-9[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]];/\\?:@&=#~\\-\\.\\+!\\*'\\(\\),_\\$])|(?:%[a-fA-F0-9]{2}))*)?(?:\\b|$|^))");
    }

    private static URI createUriWithOutQuery(String r100) throws RuntimeException {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.isEmpty() == true) goto L18;
        int r101 = r100.indexOf("?");     // Catch: Exception -> L11
        if (r101 <= 0) goto L9;
        r100 = r100.substring(0, r101);     // Catch: Exception -> L11
    L9:
        return URI.create(r100);
    L11:
        e = move-exception;
        throw new RuntimeException(e);
    L18:
        return null;
    }

    private static boolean isHttpUrl(String r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.length() > 6) goto L7;
        return false;
    L7:
        if (r100.substring(0, 7).equalsIgnoreCase("http://") == false) goto L12;
        return true;
    L12:
        return false;
    }

    private static boolean isHttpsUrl(String r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.length() > 7) goto L7;
        return false;
    L7:
        if (r100.substring(0, 8).equalsIgnoreCase("https://") == false) goto L12;
        return true;
    L12:
        return false;
    }

    public static boolean isValidUrl(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return false;
    L6:
        if (isHttpsUrl(r100) == true) goto L18;
        if (isHttpUrl(r100) == true) goto L18;
        if (isWssUrl(r100) == true) goto L18;
        if (isWsUrl(r100) == true) goto L18;
        return false;
    L18:
        return WEB_URL.matcher(r100).matches();
    L20:
        return false;
    }

    private static boolean isWsUrl(String r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.length() > 4) goto L7;
        return false;
    L7:
        if (r100.substring(0, 5).equalsIgnoreCase("ws://") == false) goto L12;
        return true;
    L12:
        return false;
    }

    private static boolean isWssUrl(String r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.length() > 5) goto L7;
        return false;
    L7:
        if (r100.substring(0, 6).equalsIgnoreCase("wss://") == false) goto L12;
        return true;
    L12:
        return false;
    }

    public static String replacePlusInEncodeUrl(String r100) {
        int r101 = r100.indexOf("?");
        if (r101 > 0) goto L5;
        return r100;
    L5:
        return r100.substring(0, r101) + r100.substring(r101).replaceAll("\\+", "%20");
    }

    public static URI safeCreateUri(String r100) throws RuntimeException {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.isEmpty() == true) goto L17;
        return new URI(r100);
    L8:
        return URI.create(r100.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
    L11:
        return createUriWithOutQuery(r100);
    L17:
        return null;
    }

    private static String encode(String r100, String r101) {
        if (r101 != null) goto L10;
        r101 = "ISO-8859-1";
    L10:
        return URLEncoder.encode(r100, r101);
    L7:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    public static String format(Map<String, List<String>> r100, String r101) {
        StringBuilder r102 = new StringBuilder();
        Iterator<Map.Entry<String, List<String>>> r103 = r100.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L23;
        Map.Entry<String, List<String>> r104 = r103.next();
        String r105 = encode(r104.getKey(), r101);
        List<String> r106 = r104.getValue();
        if (r106 == null) goto L4;
        if (r106.size() <= 0) goto L4;
        Iterator<String> r107 = r106.iterator();
    L11:
        if (r107.hasNext() == false) goto L4;
        String r108 = r107.next();
        if (r108 == null) goto L15;
        String r109 = encode(r108, r101);
    L17:
        if (r102.length() <= 0) goto L19;
        r102.append("&");
    L19:
        r102.append(r105);
        if (r109.isEmpty() == true) goto L11;
        r102.append("=");
        r102.append(r109);
        goto L11
    L15:
        r109 = "";
        goto L17
    L23:
        return r102.toString();
    }

    public static boolean matchPattern(String r110, String r111) {
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

    public static Pair<String, String> parseUrl(String r100, Map<String, String> r110) throws IOException {
        if (StringUtils.isEmpty(r100) == true) goto L29;
        Uri r101 = UriProtector.parse(r100);     // Catch: Throwable -> L25
        StringBuilder r102 = new StringBuilder();     // Catch: Throwable -> L25
        String r103 = r101.getScheme();     // Catch: Throwable -> L25
        String r104 = r101.getHost();     // Catch: Throwable -> L25
        int r105 = r101.getPort();     // Catch: Throwable -> L25
        if (r104 == null) goto L11;
        if (r103 == null) goto L8;
        r102.append(r103);     // Catch: Throwable -> L25
        r102.append("://");     // Catch: Throwable -> L25
    L8:
        r102.append(r104);     // Catch: Throwable -> L25
        if (r105 <= 0) goto L11;
        r102.append(':');     // Catch: Throwable -> L25
        r102.append(r105);     // Catch: Throwable -> L25
    L11:
        String r106 = r102.toString();     // Catch: Throwable -> L25
        String r107 = r101.getEncodedPath();     // Catch: Throwable -> L25
        if (r110 == null) goto L23;
        String r108 = r101.getEncodedQuery();     // Catch: Throwable -> L25
        if (r108 == null) goto L23;
        String[] r109 = r108.split("&");     // Catch: Throwable -> L25
        int r111 = r109.length;     // Catch: Throwable -> L25
        int r112 = 0;
    L16:
        if (r112 >= r111) goto L23;
        String r113 = r109[r112];     // Catch: Throwable -> L25
        int r114 = r113.indexOf("=");     // Catch: Throwable -> L25
        if (r114 < 0) goto L21;
        r110.put(URLDecoder.decode(r113.substring(0, r114), "UTF-8"), URLDecoder.decode(r113.substring(r114 + 1), "UTF-8"));     // Catch: Throwable -> L25
    L22:
        r112 = r112 + 1;     // Catch: Throwable -> L25
        goto L16
    L21:
        r110.put(URLDecoder.decode(r113, "UTF-8"), "");     // Catch: Throwable -> L25
    L23:
        return new Pair(r106, r107);
    L25:
        th = move-exception;
        th.printStackTrace();
        throw new IOException("parseUrl url is fail !!!");
    L29:
        throw new IOException("parseUrl url is null !!!");
    }

    public static Pair<String, String> parseUrlWithValueList(String r110, Map<String, List<String>> r111) throws IOException {
        if (StringUtils.isEmpty(r110) == true) goto L35;
        Uri r112 = UriProtector.parse(r110);     // Catch: Throwable -> L31
        StringBuilder r100 = new StringBuilder();     // Catch: Throwable -> L31
        String r101 = r112.getScheme();     // Catch: Throwable -> L31
        String r102 = r112.getHost();     // Catch: Throwable -> L31
        int r103 = r112.getPort();     // Catch: Throwable -> L31
        if (r102 == null) goto L11;
        if (r101 == null) goto L8;
        r100.append(r101);     // Catch: Throwable -> L31
        r100.append("://");     // Catch: Throwable -> L31
    L8:
        r100.append(r102);     // Catch: Throwable -> L31
        if (r103 <= 0) goto L11;
        r100.append(':');     // Catch: Throwable -> L31
        r100.append(r103);     // Catch: Throwable -> L31
    L11:
        String r104 = r100.toString();     // Catch: Throwable -> L31
        String r105 = r112.getEncodedPath();     // Catch: Throwable -> L31
        if (r111 == null) goto L29;
        String r113 = r112.getEncodedQuery();     // Catch: Throwable -> L31
        if (r113 == null) goto L29;
        String[] r114 = r113.split("&");     // Catch: Throwable -> L31
        int r106 = r114.length;     // Catch: Throwable -> L31
        int r107 = 0;
    L16:
        if (r107 >= r106) goto L29;
        String r108 = r114[r107];     // Catch: Throwable -> L31
        int r109 = r108.indexOf("=");     // Catch: Throwable -> L31
        if (r109 < 0) goto L24;
        String r115 = URLDecoder.decode(r108.substring(0, r109), "UTF-8");     // Catch: Throwable -> L31
        List<String> r116 = r111.get(r115);     // Catch: Throwable -> L31
        if (r116 != null) goto L23;
        r116 = new LinkedList();     // Catch: Throwable -> L31
    L23:
        r116.add(URLDecoder.decode(r108.substring(r109 + 1), "UTF-8"));     // Catch: Throwable -> L31
        r111.put(r115, r116);     // Catch: Throwable -> L31
    L28:
        r107 = r107 + 1;     // Catch: Throwable -> L31
        goto L16
    L24:
        String r117 = URLDecoder.decode(r108, "UTF-8");     // Catch: Throwable -> L31
        List<String> r118 = r111.get(r117);     // Catch: Throwable -> L31
        if (r118 != null) goto L27;
        r118 = new LinkedList();     // Catch: Throwable -> L31
    L27:
        r118.add("");     // Catch: Throwable -> L31
        r111.put(r117, r118);     // Catch: Throwable -> L31
    L29:
        return new Pair(r104, r105);
    L31:
        th = move-exception;
        th.printStackTrace();
        throw new IOException("parseUrl url is fail !!!");
    L35:
        throw new IOException("parseUrl url is null !!!");
    }
}
