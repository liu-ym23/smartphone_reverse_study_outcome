package com.bytedance.android.shopping.prepurchase.arch.exposure;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public final LifecycleOwner a;
    public final Function1<View, c> b;
    public final f c;
    public final long d;

    public a(ConfigurationBuilder r3) {
        Intrinsics.checkNotNullParameter(r3, "builder");
        LifecycleOwner r0 = r3.a;
        Intrinsics.checkNotNull(r0);
        this.a = r0;
        this.b = r3.d;
        this.c = r3.b;
        this.d = r3.c;
    }
}
