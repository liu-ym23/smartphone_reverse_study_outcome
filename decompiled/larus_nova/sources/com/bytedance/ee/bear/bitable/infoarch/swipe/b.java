package com.bytedance.ee.bear.bitable.infoarch.swipe;

import android.app.Activity;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function2<Activity, Boolean, Unit> f213686a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference<c> f213687b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReference<Boolean> f213688c;

    public b() {
        this(null);
    }

    public final c c() {
        if (this.f213688c.get().booleanValue() == true) goto L7;
        return null;
    L7:
        return this.f213687b.get();
    }

    @Override // com.bytedance.ee.bear.bitable.infoarch.swipe.a
    public final void w0() {
        c r100 = this.f213687b.getAndSet(null);
        if (r100 == null) goto L8;
        Activity r101 = r100.getActivity();
        if (r101 == null) goto L9;
        this.f213686a.invoke(r101, Boolean.TRUE);
        return;
    L9:
        return;
    }

    public b(Object r100) {
        PageBackControllerImpl$1 r101 = PageBackControllerImpl$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r101, "swipeBackSetter");
        this.f213686a = r101;
        this.f213687b = new AtomicReference(null);
        this.f213688c = new AtomicReference(Boolean.TRUE);
    }

    @Override // com.bytedance.ee.bear.bitable.infoarch.swipe.a
    public final void a(boolean r100) {
        this.f213688c.set(Boolean.valueOf(r100));
    }

    @Override // com.bytedance.ee.bear.bitable.infoarch.swipe.a
    public final boolean b(c r100) {
        Intrinsics.checkNotNullParameter(r100, "interceptor");
        Activity r101 = r100.getActivity();
        if (r101 == null) goto L5;
        this.f213686a.invoke(r101, Boolean.FALSE);
    L5:
        AtomicReference<c> r102 = this.f213687b;
    L7:
        if (r102.compareAndSet(null, r100) == true) goto L8;
        if (r102.get() == null) goto L7;
        return false;
    L8:
        return true;
    }
}
