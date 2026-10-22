package com.bytedance.ee.bear.more.protocol3.panel;

import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@MoreDslMarker
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MoreGroup f234994a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<o> f234995b;

    public n(MoreGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "group");
        this.f234994a = r100;
        this.f234995b = new ArrayList();
    }

    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "itemId");
        List<o> r101 = this.f234995b;
        ArrayList r102 = (ArrayList) r101;
        r102.add(new o(r100, null, null));
    }

    public final void b(String r100, Function1<? super p, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "itemId");
        Intrinsics.checkNotNullParameter(r101, "init");
        p r102 = new p(r100);
        r101.invoke(r102);
        List<o> r103 = this.f234995b;
        ArrayList r104 = (ArrayList) r103;
        r104.add(new o(r102.f234999a, r102.f235000b, r102.f235001c));
    }
}
