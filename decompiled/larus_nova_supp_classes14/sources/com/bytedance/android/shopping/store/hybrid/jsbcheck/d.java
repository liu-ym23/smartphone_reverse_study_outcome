package com.bytedance.android.shopping.store.hybrid.jsbcheck;

import et3.c$d;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d implements c$d {
    public final /* synthetic */ Function1 a;

    public d(Function1 r1) {
        this.a = r1;
    }

    @Override // et3.c$d
    public final void fpsCallBack(double r2) {
        this.a.invoke(Double.valueOf(r2));
    }
}
