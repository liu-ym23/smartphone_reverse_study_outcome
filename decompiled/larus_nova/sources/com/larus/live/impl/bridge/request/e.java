package com.larus.live.impl.bridge.request;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class e extends i66.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f355798g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f355799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f355800b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, ? extends Object> f355801c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f355802d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f355803e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f355804f;

    public static final class a {
        @JvmStatic
        public static Map a(e r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            Integer r101 = r100.f355799a;
            if (r101 == null) goto L20;
            r101.intValue();
            if (r100.f355802d != null) goto L7;
            return null;
        L7:
            LinkedHashMap r102 = new LinkedHashMap();
            Integer r103 = r100.f355799a;
            Intrinsics.checkNotNull(r103);
            r102.put("httpCode", r103);
            Object r104 = r100.f355802d;
            Intrinsics.checkNotNull(r104);
            r102.put("response", r104);
            Map<String, ? extends Object> r105 = r100.f355801c;
            if (r105 == null) goto L10;
            r102.put("header", r105);
        L10:
            String r106 = r100.f355803e;
            if (r106 == null) goto L13;
            r102.put("rawResponse", r106);
        L13:
            String r107 = r100.f355804f;
            if (r107 == null) goto L16;
            r102.put("responseType", r107);
        L16:
            Integer r108 = r100.f355800b;
            if (r108 == null) goto L19;
            r102.put("clientCode", Integer.valueOf(r108.intValue()));
        L19:
            return r102;
        L20:
            return null;
        }
    }

    static {
    }

    public e() {
    }
}
