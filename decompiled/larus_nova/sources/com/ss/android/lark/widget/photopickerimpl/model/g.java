package com.ss.android.lark.widget.photopickerimpl.model;

import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class g<T> implements RxScheduledExecutor.Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ldc.g<c.b<T>> f447813a;

    public g(c.d r100) {
        this.f447813a = r100;
    }

    @Override // com.ss.android.lark.utils.rxjava.RxScheduledExecutor.Consumer
    public final void consume(Object r100) {
        c.b<T> r101 = (c.b) r100;
        ldc.g<c.b<T>> r102 = this.f447813a;
        Intrinsics.checkNotNull(r101);
        if (r102.f508885a == true) goto L6;
        r102.b(r101);
        return;
    }
}
