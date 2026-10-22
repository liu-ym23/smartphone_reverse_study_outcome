package com.bytedance.ee.bear.more.protocol3.panel;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class e implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, e0> f234957a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, q> f234958b;

    public e() {
        this.f234957a = new LinkedHashMap();
        this.f234958b = new LinkedHashMap();
    }

    @Override // com.bytedance.ee.bear.more.protocol3.panel.t
    public final q a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "itemId");
        Map<String, q> r101 = this.f234958b;
        LinkedHashMap r102 = (LinkedHashMap) r101;
        return (q) r102.get(s.a(r100));
    }

    public final e0 c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "itemId");
        Map<String, e0> r101 = this.f234957a;
        LinkedHashMap r102 = (LinkedHashMap) r101;
        return (e0) r102.get(s.a(r100));
    }

    @Override // com.bytedance.ee.bear.more.protocol3.panel.t
    public final void b(String r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, "itemId");
        Intrinsics.checkNotNullParameter(r101, "delegate");
        this.f234958b.put(s.a(r100), r101);
    }

    public final void d(String r100, e0 r101) {
        Intrinsics.checkNotNullParameter(r100, "itemId");
        Intrinsics.checkNotNullParameter(r101, "factory");
        this.f234957a.put(s.a(r100), r101);
    }
}
