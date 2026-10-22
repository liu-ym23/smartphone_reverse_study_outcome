package com.bytedance.applog.params;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final /* synthetic */ class f implements Runnable {
    public final /* synthetic */ Function0 a;

    public /* synthetic */ f(Function0 r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Function0 r0 = this.a;
        Intrinsics.checkNotNullParameter(r0, "$f");
        r0.invoke();
    }
}
