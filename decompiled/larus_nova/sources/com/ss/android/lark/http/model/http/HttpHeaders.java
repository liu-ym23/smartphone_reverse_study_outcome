package com.ss.android.lark.http.model.http;

import android.text.TextUtils;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes36.dex */
public class HttpHeaders implements Serializable {
    public static final String FORMAT_HTTP_DATA = "EEE, dd MMM y HH:mm:ss 'GMT'";
    public static final TimeZone GMT_TIME_ZONE = null;
    public static final String HEAD_KEY_ACCEPT = "Accept";
    public static final String HEAD_KEY_ACCEPT_ENCODING = "Accept-Encoding";
    public static final String HEAD_KEY_ACCEPT_LANGUAGE = "Accept-Language";
    public static final String HEAD_KEY_CACHE_CONTROL = "Cache-Control";
    public static final String HEAD_KEY_CONNECTION = "Connection";
    public static final String HEAD_KEY_CONTENT_DISPOSITION = "Content-Disposition";
    public static final String HEAD_KEY_CONTENT_ENCODING = "Content-Encoding";
    public static final String HEAD_KEY_CONTENT_LENGTH = "Content-Length";
    public static final String HEAD_KEY_CONTENT_RANGE = "Content-Range";
    public static final String HEAD_KEY_CONTENT_TYPE = "Content-Type";
    public static final String HEAD_KEY_COOKIE = "Cookie";
    public static final String HEAD_KEY_COOKIE2 = "Cookie2";
    public static final String HEAD_KEY_DATE = "Date";
    public static final String HEAD_KEY_EXPIRES = "Expires";
    public static final String HEAD_KEY_E_TAG = "ETag";
    public static final String HEAD_KEY_IF_MODIFIED_SINCE = "If-Modified-Since";
    public static final String HEAD_KEY_IF_NONE_MATCH = "If-None-Match";
    public static final String HEAD_KEY_LAST_MODIFIED = "Last-Modified";
    public static final String HEAD_KEY_LOCATION = "Location";
    public static final String HEAD_KEY_PRAGMA = "Pragma";
    public static final String HEAD_KEY_RANGE = "Range";
    public static final String HEAD_KEY_RESPONSE_CODE = "ResponseCode";
    public static final String HEAD_KEY_RESPONSE_MESSAGE = "ResponseMessage";
    public static final String HEAD_KEY_SET_COOKIE = "Set-Cookie";
    public static final String HEAD_KEY_SET_COOKIE2 = "Set-Cookie2";
    public static final String HEAD_KEY_USER_AGENT = "User-Agent";
    public static final String HEAD_VALUE_ACCEPT_ENCODING = "gzip, deflate";
    public static final String HEAD_VALUE_CONNECTION_CLOSE = "close";
    public static final String HEAD_VALUE_CONNECTION_KEEP_ALIVE = "keep-alive";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f425861a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f425862b = null;
    private static final long serialVersionUID = 8458647755751403873L;
    public LinkedHashMap<String, String> headersMap;

    public static String getCacheControl(String r100, String r101) {
        if (r100 == null) goto L4;
        return r100;
    L4:
        if (r101 == null) goto L6;
        return r101;
    L6:
        return null;
    }

    static {
        GMT_TIME_ZONE = TimeZone.getTimeZone("GMT");
    }

    public static String getAcceptLanguage() {
        if (TextUtils.isEmpty(f425861a) == false) goto L10;
        Locale r100 = Locale.getDefault();
        String r101 = r100.getLanguage();
        String r102 = r100.getCountry();
        StringBuilder r103 = new StringBuilder(r101);
        if (TextUtils.isEmpty(r102) == true) goto L7;
        r103.append('-');
        r103.append(r102);
        r103.append(',');
        r103.append(r101);
        r103.append(";q=0.8");
    L7:
        String r104 = r103.toString();
        f425861a = r104;
        return r104;
    L10:
        return f425861a;
    }

    public static String getUserAgent() {
        if (TextUtils.isEmpty(f425862b) == false) goto L6;
        f425862b = "Mozilla/5.0 (Linux; U; Android 5.0.2; zh-cn; Redmi Note 3 Build/LRX22G) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Mobile Safari/537.36";
    L6:
        return f425862b;
    }

    public void clear() {
        this.headersMap.clear();
    }

    public Set<String> getNames() {
        return this.headersMap.keySet();
    }

    public boolean isEmpty() {
        LinkedHashMap<String, String> r100 = this.headersMap;
        if (r100 != null) goto L5;
    L8:
        return true;
    L5:
        if (r100.isEmpty() == true) goto L8;
        return false;
    }

    public final String toJSONString() {
        JSONObject r100 = new JSONObject();
        Iterator<Map.Entry<String, String>> r101 = this.headersMap.entrySet().iterator();     // Catch: JSONException -> L8
    L5:
        if (r101.hasNext() == false) goto L11;
        Map.Entry<String, String> r102 = r101.next();     // Catch: JSONException -> L8
        r100.put(r102.getKey(), r102.getValue());     // Catch: JSONException -> L8
    L11:
        return r100.toString();
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    public String toString() {
        return "HttpHeaders{headersMap=" + this.headersMap + '}';
    }

    public HttpHeaders() {
        this.headersMap = new LinkedHashMap();
    }

    public static String formatMillisToGMT(long r100) {
        Date r101 = new Date(r100);
        SimpleDateFormat r102 = new SimpleDateFormat("EEE, dd MMM y HH:mm:ss 'GMT'", Locale.US);
        r102.setTimeZone(GMT_TIME_ZONE);
        return r102.format(r101);
    }

    public static long getDate(String r100) {
        return parseGMTToMillis(r100);
    L4:
        return 0;
    }

    public static long getExpiration(String r100) {
        return parseGMTToMillis(r100);
    L4:
        return -1;
    }

    public static long getLastModified(String r100) {
        return parseGMTToMillis(r100);
    L4:
        return 0;
    }

    public static long parseGMTToMillis(String r100) throws ParseException {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return 0;
    L6:
        SimpleDateFormat r101 = new SimpleDateFormat("EEE, dd MMM y HH:mm:ss 'GMT'", Locale.US);
        r101.setTimeZone(GMT_TIME_ZONE);
        return r101.parse(r100).getTime();
    }

    public static void setAcceptLanguage(String r100) {
        f425861a = r100;
    }

    public static void setUserAgent(String r100) {
        f425862b = r100;
    }

    public String get(String r100) {
        return this.headersMap.get(r100);
    }

    public void put(HttpHeaders r100) {
        if (r100 == null) goto L9;
        LinkedHashMap<String, String> r101 = r100.headersMap;
        if (r101 != null) goto L6;
        return;
    L6:
        if (r101.isEmpty() == true) goto L11;
        this.headersMap.putAll(r100.headersMap);
        return;
    L11:
        return;
    }

    public String remove(String r100) {
        return this.headersMap.remove(r100);
    }

    public static String getDate(long r100) {
        return formatMillisToGMT(r100);
    }

    public HttpHeaders(String r100, String r101) {
        this.headersMap = new LinkedHashMap();
        put(r100, r101);
    }

    public void put(String r100, String r101) {
        if (r100 == null) goto L6;
        if (r101 == null) goto L7;
        this.headersMap.put(r100, r101);
        return;
    L7:
        return;
    }
}
