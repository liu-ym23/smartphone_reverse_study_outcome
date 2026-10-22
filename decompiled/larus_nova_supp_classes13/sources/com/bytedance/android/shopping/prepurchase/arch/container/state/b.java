package com.bytedance.android.shopping.prepurchase.arch.container.state;

import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b<T> implements Observer<T> {
    public static final Object e = null;
    public boolean a;
    public Object b;
    public final i<T> c;
    public final g<? super T> d;

    public static final class a {
    }

    static {
        e = new Object();
    }

    public final void onChanged(T r4) {
        boolean r1 = true;
        if (this.c.a == true) goto L5;
    L8:
        Object r0 = this.b;
        if (Intrinsics.areEqual(r0, e) == true) goto L14;
        this.c.b.getClass();
        if (Intrinsics.areEqual(r0, r4) == false) goto L14;
        r1 = false;
    L14:
        if (r1 == false) goto L17;
        this.b = r4;
        this.d.onChanged(r4);
        return;
    L17:
        return;
    L5:
        if (this.a == true) goto L8;
        this.a = true;
    }

    public b(i<T> r2, g<? super T> r3) {
        Intrinsics.checkNotNullParameter(r2, "config");
        Intrinsics.checkNotNullParameter(r3, "block");
        this.c = r2;
        this.d = r3;
        this.b = e;
    }
}
