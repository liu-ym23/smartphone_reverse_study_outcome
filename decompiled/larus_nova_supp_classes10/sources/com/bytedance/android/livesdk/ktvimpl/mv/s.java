package com.bytedance.android.livesdk.ktvimpl.mv;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class s {
    public final y a;
    public final Function1<l, Boolean> b;

    /* JADX WARN: Multi-variable type inference failed */
    public s(y r2, Function1<? super l, Boolean> r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        this.a = r2;
        this.b = r3;
    }
}
