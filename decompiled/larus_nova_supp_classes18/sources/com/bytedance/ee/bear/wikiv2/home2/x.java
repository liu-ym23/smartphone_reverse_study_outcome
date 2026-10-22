package com.bytedance.ee.bear.wikiv2.home2;

import androidx.lifecycle.Observer;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class x<T> implements Observer {
    public final /* synthetic */ y a;

    public x(y r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        List r3 = (List) r2;
        this.a.b.clear();
        Set<String> r0 = this.a.b;
        Intrinsics.checkNotNull(r3);
        r0.addAll(r3);
    }
}
