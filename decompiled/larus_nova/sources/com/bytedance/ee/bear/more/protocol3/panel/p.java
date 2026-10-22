package com.bytedance.ee.bear.more.protocol3.panel;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@MoreDslMarker
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f234999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f235000b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public j f235001c;

    public p(String r100) {
        Intrinsics.checkNotNullParameter(r100, "itemId");
        this.f234999a = r100;
    }

    public final void a(Function1<? super b, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "init");
        b r101 = new b();
        r100.invoke(r101);
        d r102 = r101.f234934a;
        if (r102 == null) goto L7;
        this.f235000b = new c(r102, null, null);
        return;
    L7:
        throw new IllegalArgumentException("CustomFactoryBuilder requires template".toString());
    }

    public final void b(Function1<? super h, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "init");
        h r101 = new h();
        r100.invoke(r101);
        this.f235001c = new j(r101.f234972a, r101.f234973b, r101.f234974c);
    }
}
