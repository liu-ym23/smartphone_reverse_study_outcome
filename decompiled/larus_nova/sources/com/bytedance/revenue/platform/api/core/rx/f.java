package com.bytedance.revenue.platform.api.core.rx;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class f {
    public static final void a(Disposable r100, CompositeDisposable r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 == null) goto L6;
        r101.add(r100);
        return;
    }
}
