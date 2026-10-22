package com.bytedance.ee.bear.more.protocol3.panel;

import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f implements u {
    public w a;

    public f() {
    }

    @Override // com.bytedance.ee.bear.more.protocol3.panel.u
    public final void unregisterMoreConfig() {
        this.a = null;
    }

    @Override // com.bytedance.ee.bear.more.protocol3.panel.u
    public final w a() {
        return this.a;
    }

    @Override // com.bytedance.ee.bear.more.protocol3.panel.u
    public final void registerMoreConfig(Function1<? super l, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "block");
        l r0 = new l();
        r3.invoke(r0);
        this.a = new w(r0.a, CollectionsKt.toList(r0.b));
    }
}
