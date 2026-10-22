package com.larus.basic.experience.downgrade.impl.strategy;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public interface c<T> {

    public static final class a {
        public static <T> Pair<Boolean, String> a(c<T> r110, b<T> r111, boolean r112) {
            Intrinsics.checkNotNullParameter(r111, "downgradeContext");
            Map<String, List<String>> r100 = r110.f();
            if (r100 != null) goto L5;
        L8:
            boolean r101 = true;
        L9:
            if (r101 == false) goto L28;
            Map<String, List<String>> r102 = r110.a();
            if (r102 != null) goto L13;
        L16:
            boolean r103 = true;
        L17:
            if (r103 == false) goto L28;
            Map<String, List<String>> r104 = r110.b();
            if (r104 != null) goto L21;
        L24:
            boolean r105 = true;
        L25:
            if (r105 == false) goto L28;
            return TuplesKt.to(Boolean.valueOf(r112), "default");
        L21:
            if (r104.isEmpty() == true) goto L24;
            r105 = false;
            goto L25
        L13:
            if (r102.isEmpty() == true) goto L16;
            r103 = false;
        L28:
            String r113 = "not match extra " + r111.f294856d;
            Map<String, String> r106 = r111.f294856d;
            if (r106 == null) goto L43;
            Map<String, List<String>> r107 = r110.f();
            if (r107 == null) goto L43;
            Iterator<Map.Entry<String, List<String>>> r108 = r107.entrySet().iterator();
            boolean r109 = false;
        L34:
            if (r108.hasNext() == false) goto L44;
            Map.Entry<String, List<String>> r114 = r108.next();
            String r115 = r114.getKey();
            List<String> r116 = r114.getValue();
            if (r116 != null) goto L38;
        L40:
            boolean r117 = false;
        L41:
            if (r117 == false) goto L34;
            r113 = "match extra [" + r115 + com.alipay.sdk.m.n.a.f25612h + r106.get(r115) + ']';
            r109 = true;
            goto L34
        L38:
            if (r116.contains(r106.get(r115)) != true) goto L40;
            r117 = true;
        L44:
            if (r109 == true) goto L64;
            JSONObject r118 = r111.f294857e;
            if (r118 == null) goto L64;
            Map<String, List<String>> r119 = r110.a();
            if (r119 == null) goto L64;
            Iterator<Map.Entry<String, List<String>>> r120 = r119.entrySet().iterator();
        L51:
            if (r120.hasNext() == false) goto L64;
            Map.Entry<String, List<String>> r121 = r120.next();
            String r122 = r121.getKey();
            List<String> r123 = r121.getValue();
            Object r124 = r118.opt(r122);
            if (r124 == null) goto L55;
            String r125 = r124.toString();
        L56:
            if (r125 == null) goto L51;
            if (r123 != null) goto L59;
        L61:
            boolean r126 = false;
        L62:
            if (r126 == false) goto L51;
            r113 = "match body [" + r122 + com.alipay.sdk.m.n.a.f25612h + r125 + ']';
            r109 = true;
            goto L51
        L59:
            if (r123.contains(r125) != true) goto L61;
            r126 = true;
            goto L62
        L55:
            r125 = null;
        L64:
            if (r109 == true) goto L81;
            Map<String, String> r127 = r111.f294858f;
            if (r127 == null) goto L81;
            Map<String, List<String>> r128 = r110.b();
            if (r128 == null) goto L81;
            Iterator<Map.Entry<String, List<String>>> r129 = r128.entrySet().iterator();
        L71:
            if (r129.hasNext() == false) goto L81;
            Map.Entry<String, List<String>> r130 = r129.next();
            String r131 = r130.getKey();
            List<String> r132 = r130.getValue();
            if (r132 != null) goto L75;
        L77:
            boolean r133 = false;
        L78:
            if (r133 == false) goto L71;
            r113 = "match query [" + r131 + com.alipay.sdk.m.n.a.f25612h + r127.get(r131) + ']';
            r109 = true;
            goto L71
        L75:
            if (r132.contains(r127.get(r131)) != true) goto L77;
            r133 = true;
        L81:
            return TuplesKt.to(Boolean.valueOf(r109), r113);
        L43:
            r109 = false;
            goto L44
        L5:
            if (r100.isEmpty() == true) goto L8;
            r101 = false;
            goto L9
        }
    }

    Map<String, List<String>> a();

    Map<String, List<String>> b();

    Pair c(b r100, com.larus.network.http.a r101);

    int d();

    Object e(b<T> r100, Continuation<? super b<T>> r101);

    Map<String, List<String>> f();

    int g();
}
