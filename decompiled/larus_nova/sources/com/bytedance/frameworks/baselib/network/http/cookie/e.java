package com.bytedance.frameworks.baselib.network.http.cookie;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URI;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class e {
    public static String c(URI r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        String r101 = r100.getHost();
        if (TextUtils.isEmpty(r101) == false) goto L13;
        return r100.toURL().getHost();
    L10:
        return r100.getAuthority();
    L13:
        return r101;
    }

    public static Pair<Boolean, Double> a(Set<String> r210, Map<String, Set<f>> r211, JSONObject r212) {
        boolean r100 = false;
        HashSet r101 = new HashSet();     // Catch: Throwable -> L76
        HashSet r102 = new HashSet();     // Catch: Throwable -> L76
        JSONArray r103 = new JSONArray();     // Catch: Throwable -> L76
        JSONArray r104 = new JSONArray();     // Catch: Throwable -> L76
        HashSet r105 = (HashSet) r210;     // Catch: Throwable -> L76
        Iterator r106 = r105.iterator();     // Catch: Throwable -> L76
        long r110 = 0;
        boolean r111 = false;
    L90:
    L73:
        th = th;
        double r107 = 100.0d;
    L75:
        r100 = r111;
    L78:
        th.printStackTrace();
        r111 = r100;
        double r108 = r107;
    L80:
        return new Pair(Boolean.valueOf(r111), Double.valueOf(r108));
    L7:
        if (r106.hasNext() == false) goto L32;
        String r112 = (String) r106.next();     // Catch: Throwable -> L28
        if (TextUtils.isEmpty(r112) == true) goto L90;
        Set<f> r113 = r211.remove(r112);     // Catch: Throwable -> L28
        if (CollectionUtils.isEmpty(r113) == false) goto L13;
        r103.put(r112);     // Catch: Throwable -> L28
        String r109 = r112.split(ContainerUtils.KEY_VALUE_DELIMITER)[0];     // Catch: Throwable -> L81
        if (TextUtils.isEmpty(r109) == true) goto L90;
        r101.add(r109);     // Catch: Throwable -> L81
        goto L90
    L13:
        r110 = r110 + 1;     // Catch: Throwable -> L28
        Iterator<f> r114 = r113.iterator();     // Catch: Throwable -> L28
    L15:
        if (r114.hasNext() == false) goto L90;
        f r115 = r114.next();     // Catch: Throwable -> L28
        if (r115 == null) goto L15;
        if (r115.b() <= 0) goto L15;
        if ((System.currentTimeMillis() - r115.b()) > 3000) goto L15;
        r111 = true;
    L28:
        th = th;
        r100 = r111;
    L30:
        r107 = 100.0d;
        goto L78
    L32:
        Iterator<Map.Entry<String, Set<f>>> r116 = r211.entrySet().iterator();     // Catch: Throwable -> L73
    L34:
        if (r116.hasNext() == false) goto L49;
        Set<f> r117 = r116.next().getValue();     // Catch: Throwable -> L28
        if (CollectionUtils.isEmpty(r117) == true) goto L34;
        Iterator<f> r118 = r117.iterator();     // Catch: Throwable -> L28
    L39:
        if (r118.hasNext() == false) goto L34;
        f r119 = r118.next();     // Catch: Throwable -> L28
        if (r119 == null) goto L39;
        r102.add(r119.f244706e);     // Catch: Throwable -> L28
        r104.put(r119.a());     // Catch: Throwable -> L28
        if (r119.b() <= 0) goto L39;
        if ((System.currentTimeMillis() - r119.b()) > 3000) goto L39;
        r111 = true;
        goto L39
    L49:
        JSONObject r120 = new JSONObject();     // Catch: Throwable -> L73
        if (r101.isEmpty() == true) goto L53;
        r120.put("only_sys", new JSONArray(r101));     // Catch: Throwable -> L28
    L53:
        if (r102.isEmpty() == true) goto L56;
        r120.put("only_tt", new JSONArray(r102));     // Catch: Throwable -> L28
    L56:
        if (r103.length() <= 0) goto L59;
        r120.put("o_sys_dtl", r103);     // Catch: Throwable -> L28
    L59:
        if (r104.length() <= 0) goto L62;
        r120.put("o_tt_dtl", r104);     // Catch: Throwable -> L28
    L62:
        if (r120.length() <= 0) goto L64;
        r212.put("diff", r120);     // Catch: Throwable -> L28
    L64:
        long r121 = r105.size();     // Catch: Throwable -> L73
        if (r121 <= 0) goto L68;
        r107 = 100.0d;
        double r122 = (r110 / r121) * 100.0d;
    L86:
        r108 = new BigDecimal(r122).setScale(3, RoundingMode.HALF_UP).doubleValue();     // Catch: Throwable -> L71
    L71:
        th = th;
        goto L75
    L68:
        r107 = 100.0d;
        r122 = 100.0d;
    L76:
        th = th;
        goto L30
    }

    public static boolean b(String r100, String r101, boolean r102) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
    L22:
        return false;
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L22;
        Locale r103 = Locale.US;
        String r104 = r100.toLowerCase(r103);
        String r105 = r101.toLowerCase(r103);
        if (r102 == true) goto L13;
        if (r105.startsWith(".") == true) goto L13;
        r105 = ".".concat(r105);
    L13:
        if (r105.startsWith(".") == false) goto L21;
        if (r104.endsWith(r105) == false) goto L17;
    L18:
        return true;
    L17:
        if (r105.equals(".".concat(r104)) == true) goto L18;
        return false;
    L21:
        return r104.equals(r105);
    }
}
