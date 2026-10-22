package com.ss.android.lark.widget.photopickerimpl.model;

import com.lynx.tasm.LynxError;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class h<T> implements RxScheduledExecutor.Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ldc.g<c.b<T>> f447814a;

    public h(c.d r100) {
        this.f447814a = r100;
    }

    @Override // com.ss.android.lark.utils.rxjava.RxScheduledExecutor.Consumer
    public final void consume(Object r100) {
        Throwable r101 = (Throwable) r100;
        ldc.g<c.b<T>> r102 = this.f447814a;
        Intrinsics.checkNotNull(r101);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
        if (r102.f508885a == true) goto L6;
        r102.a(r101);
        return;
    }
}
