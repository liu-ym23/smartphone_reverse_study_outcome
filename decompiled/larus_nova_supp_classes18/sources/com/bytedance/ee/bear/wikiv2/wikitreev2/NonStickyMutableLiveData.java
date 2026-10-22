package com.bytedance.ee.bear.wikiv2.wikitreev2;

import androidx.lifecycle.Observer;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class NonStickyMutableLiveData<T> {
    public final Lazy a;

    public void b() {
    }

    public void c() {
    }

    public NonStickyMutableLiveData() {
        this.a = LazyKt.lazy(NonStickyMutableLiveData$observers$2.INSTANCE);
    }

    public final void a(Observer<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        ((List) this.a.getValue()).add(r2);
        if (((List) this.a.getValue()).size() != 1) goto L6;
        b();
        return;
    }

    public final void d(Observer<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        ((List) this.a.getValue()).remove(r2);
        if (((List) this.a.getValue()).size() != 0) goto L6;
        c();
        return;
    }

    public final void e(T r3) {
        Iterator r0 = ((List) this.a.getValue()).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((Observer) r0.next()).onChanged(r3);
        goto L4
    }
}
