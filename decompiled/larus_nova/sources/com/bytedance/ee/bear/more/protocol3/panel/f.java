package com.bytedance.ee.bear.more.protocol3.panel;

import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class f implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public w f234959a;

    public f() {
    }

    @Override // com.bytedance.ee.bear.more.protocol3.panel.u
    public final void unregisterMoreConfig() {
        this.f234959a = null;
    }

    @Override // com.bytedance.ee.bear.more.protocol3.panel.u
    public final w a() {
        return this.f234959a;
    }

    @Override // com.bytedance.ee.bear.more.protocol3.panel.u
    public final void registerMoreConfig(Function1<? super l, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        l r101 = new l();
        r100.invoke(r101);
        this.f234959a = new w(r101.f234990a, CollectionsKt.toList(r101.f234991b));
    }
}
