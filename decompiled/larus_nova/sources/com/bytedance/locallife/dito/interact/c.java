package com.bytedance.locallife.dito.interact;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public abstract class c {
    public c() {
    }

    public abstract void a(Function0<Unit> r100);

    public void b(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "showFunc");
        r100.invoke();
    }
}
