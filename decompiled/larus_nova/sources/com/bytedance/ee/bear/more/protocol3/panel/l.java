package com.bytedance.ee.bear.more.protocol3.panel;

import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@MoreDslMarker
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ItemUIStyle f234990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<m> f234991b;

    public l() {
        this.f234990a = ItemUIStyle.FEISHU;
        this.f234991b = new ArrayList();
    }

    public final void a(MoreGroup r100, Function1<? super n, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "group");
        Intrinsics.checkNotNullParameter(r101, "init");
        n r102 = new n(r100);
        r101.invoke(r102);
        List<m> r103 = this.f234991b;
        ArrayList r104 = (ArrayList) r103;
        r104.add(new m(r102.f234994a, CollectionsKt.toList(r102.f234995b)));
    }
}
