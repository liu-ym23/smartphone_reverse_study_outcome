package com.bytedance.navigation.kmp.handler.tracker;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Long> f265892a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Object> f265893b;

    public final void a() {
        if (this.f265892a.containsKey("duration") == false) goto L6;
        this.f265892a.remove("duration");
        return;
    L6:
        Map<String, Long> r100 = this.f265892a;
        int r101 = w27.g.f558041a;
        r100.put("duration", Long.valueOf(System.currentTimeMillis()));
    }

    public final void b() {
        Long r100 = (Long) ((LinkedHashMap) this.f265892a).get("duration");
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f265893b.containsKey("duration") == true) goto L10;
        Map<String, Object> r101 = this.f265893b;
        int r102 = w27.g.f558041a;
        r101.put("duration", Long.valueOf(Math.abs(System.currentTimeMillis() - r100.longValue())));
        this.f265892a.remove("duration");
        return;
    }

    public final Map<String, Object> c() {
        if (this.f265893b.isEmpty() == false) goto L7;
        return MapsKt.emptyMap();
    L7:
        return MapsKt.toMap(this.f265893b);
    }

    public a() {
        this.f265892a = new LinkedHashMap();
        this.f265893b = new LinkedHashMap();
    }

    public final void d(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r101, "value");
        this.f265893b.put(r100, r101);
    }
}
