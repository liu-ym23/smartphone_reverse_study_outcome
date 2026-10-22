package com.ss.android.lark.widget.photopickerimpl.model;

import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class j<T> implements RxScheduledExecutor.Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c<T> f447816a;

    public j(c<T> r100) {
        this.f447816a = r100;
    }

    @Override // com.ss.android.lark.utils.rxjava.RxScheduledExecutor.Consumer
    public final void consume(Object r100) {
        List r101 = (List) r100;
        ldc.d<T> r102 = this.f447816a.f447785d;
        if (r102 == 0) goto L6;
        Intrinsics.checkNotNull(r101);
        r102.a(r101, 0);
        return;
    }
}
