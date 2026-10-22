package com.bytedance.ee.bear.wikiv2.wikitreev2;

import androidx.lifecycle.Observer;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public class NonStickyMutableLiveData<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f241333a;

    public void b() {
    }

    public void c() {
    }

    public NonStickyMutableLiveData() {
        this.f241333a = LazyKt.lazy(NonStickyMutableLiveData$observers$2.INSTANCE);
    }

    public final void a(Observer<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        ((List) this.f241333a.getValue()).add(r100);
        if (((List) this.f241333a.getValue()).size() != 1) goto L6;
        b();
        return;
    }

    public final void d(Observer<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        ((List) this.f241333a.getValue()).remove(r100);
        if (((List) this.f241333a.getValue()).size() != 0) goto L6;
        c();
        return;
    }

    public final void e(T r100) {
        Iterator r101 = ((List) this.f241333a.getValue()).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((Observer) r101.next()).onChanged(r100);
        goto L4
    }
}
