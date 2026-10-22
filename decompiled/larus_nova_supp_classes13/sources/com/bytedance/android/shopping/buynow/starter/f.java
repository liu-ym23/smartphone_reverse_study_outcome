package com.bytedance.android.shopping.buynow.starter;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f implements nl.c {
    public com.bytedance.android.shopping.buynow.cache.a a;
    public final Map<String, String> b;
    public final JSONObject c;
    public String d;

    public static final class a {
    }

    static {
    }

    public final String a() {
        JSONObject r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.toString();
    }

    public final Map<String, String> b() {
        return this.b;
    }

    public final nl.b getCacheKey() {
        return this.a;
    }

    public final void c(String r2) {
        Intrinsics.checkNotNullParameter("pass_through", "key");
        Map<String, String> r3 = this.b;
        if (r3 == null) goto L6;
        String r4 = r3.remove("pass_through");
        return;
    }

    public final String getQueryParam(String r2) {
        Intrinsics.checkNotNullParameter(r2, "queryName");
        Map<String, String> r0 = this.b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get(r2);
    }

    public f(Map r1, JSONObject r2) {
        this.b = r1;
        this.c = r2;
        this.d = null;
    }

    public final void replaceOrAppendParam(String r2, String r3) {
        Intrinsics.checkNotNullParameter("pass_through", "queryName");
        Intrinsics.checkNotNullParameter(r3, "value");
        Map<String, String> r4 = this.b;
        if (r4 == null) goto L6;
        String r5 = r4.put("pass_through", r3);
        return;
    }
}
