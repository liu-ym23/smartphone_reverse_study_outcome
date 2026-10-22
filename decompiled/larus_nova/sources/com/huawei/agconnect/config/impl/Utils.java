package com.huawei.agconnect.config.impl;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.huawei.agconnect.AGCRoutePolicy;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
public final class Utils {
    private static final int BUFF_SIZE = 4096;
    public static final String DEFAULT_NAME = "DEFAULT_INSTANCE";
    private static final String TAG = "Utils";

    public Utils() {
    }

    public static void closeQuietly(Closeable r100) {
        if (r100 == null) goto L8;
        r100.close();     // Catch: IOException -> L5
        return;
    L9:
        return;
    }

    public static void copy(Reader r100, Writer r101) throws IOException {
        copy(r100, r101, new char[4096]);
    }

    public static void copy(Reader r100, Writer r101, char[] r102) throws IOException {
    L2:
        int r103 = r100.read(r102);
        if ((-1) == r103) goto L5;
        r101.write(r102, 0, r103);
        goto L2
    }

    public static Map<String, String> fixKeyPathMap(Map<String, String> r100) {
        HashMap r101 = new HashMap();
        Iterator<Map.Entry<String, String>> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Map.Entry<String, String> r103 = r102.next();
        r101.put(fixPath(r103.getKey()), r103.getValue());
        goto L4
    L6:
        return r101;
    }

    public static String fixPath(String r100) {
        int r101 = 0;
        if (r100.length() <= 0) goto L8;
    L5:
        if (r100.charAt(r101) != '/') goto L8;
        r101 = r101 + 1;
    L8:
        return HTTP.URL_DEFAULT + r100.substring(r101);
    }

    public static AGCRoutePolicy getRoutePolicyFromJson(String r100, String r101) {
        if (r100 == null) goto L33;
        byte r102 = -1;
        switch(r100.hashCode()) {
            case 2155: goto L19;
            case 2177: goto L15;
            case 2627: goto L11;
            case 2644: goto L7;
            default: goto L22;
        };
    L22:
        switch(r102) {
            case 0: goto L32;
            case 1: goto L30;
            case 2: goto L28;
            case 3: goto L26;
            default: goto L24;
        };
    L24:
        return AGCRoutePolicy.UNKNOWN;
    L26:
        return AGCRoutePolicy.SINGAPORE;
    L28:
        return AGCRoutePolicy.RUSSIA;
    L30:
        return AGCRoutePolicy.GERMANY;
    L32:
        return AGCRoutePolicy.CHINA;
    L7:
        if (r100.equals("SG") == false) goto L22;
        r102 = 3;
        goto L22
    L11:
        if (r100.equals("RU") == false) goto L22;
        r102 = 2;
        goto L22
    L15:
        if (r100.equals("DE") == false) goto L22;
        r102 = 1;
        goto L22
    L19:
        if (r100.equals("CN") == false) goto L22;
        r102 = 0;
        goto L22
    L33:
        if (r101 == null) goto L51;
        if (r101.contains("connect-drcn") == false) goto L39;
        return AGCRoutePolicy.CHINA;
    L39:
        if (r101.contains("connect-dre") == false) goto L43;
        return AGCRoutePolicy.GERMANY;
    L43:
        if (r101.contains("connect-drru") == false) goto L47;
        return AGCRoutePolicy.RUSSIA;
    L47:
        if (r101.contains("connect-dra") == false) goto L51;
        return AGCRoutePolicy.SINGAPORE;
    L51:
        return AGCRoutePolicy.UNKNOWN;
    }

    public static String toString(InputStream r100, String r101) throws UnsupportedEncodingException, IOException {
        StringWriter r102 = new StringWriter();
        copy(new InputStreamReader(r100, r101), r102);
        return r102.toString();
    }
}
