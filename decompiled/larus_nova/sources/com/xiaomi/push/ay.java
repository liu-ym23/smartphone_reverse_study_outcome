package com.xiaomi.push;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import java.security.InvalidParameterException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes41.dex */
public class ay {
    public static String a(String r100) {
        return String.valueOf(ax.a(MessageDigest.getInstance("SHA1").digest(r100.getBytes("UTF-8"))));
    L7:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.a("CloudCoder.hash4SHA1 ", e);
    L12:
        throw new IllegalStateException("failed to SHA1");
    L9:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.a("CloudCoder.hash4SHA1 ", e);
    L5:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.a("CloudCoder.hash4SHA1 ", e);
        goto L12
    }

    public static String a(String r100, String r101, Map<String, String> r102, String r103) {
        if (TextUtils.isEmpty(r103) == true) goto L27;
        ArrayList r104 = new ArrayList();
        if (r100 == null) goto L7;
        r104.add(r100.toUpperCase());
    L7:
        if (r101 == null) goto L9;
        r104.add(UriProtector.parse(r101).getEncodedPath());
    L9:
        boolean r105 = true;
        if (r102 != null) goto L12;
    L17:
        r104.add(r103);
        StringBuilder r106 = new StringBuilder();
        Iterator r107 = r104.iterator();
    L19:
        if (r107.hasNext() == false) goto L25;
        String r108 = (String) r107.next();
        if (r105 == true) goto L23;
        r106.append(Typography.amp);
    L23:
        r106.append(r108);
        r105 = false;
        goto L19
    L25:
        return a(r106.toString());
    L12:
        if (r102.isEmpty() == true) goto L17;
        Iterator r109 = new TreeMap(r102).entrySet().iterator();
    L15:
        if (r109.hasNext() == false) goto L17;
        Map.Entry r110 = (Map.Entry) r109.next();
        r104.add(String.format("%s=%s", new Object[]{r110.getKey(), r110.getValue()}));
        goto L15
    L27:
        throw new InvalidParameterException("security is not nullable");
    }
}
