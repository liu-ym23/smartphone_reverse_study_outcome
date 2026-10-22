package com.bytedance.revenue.platform.api.core.rx;

import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f267513a = 0;

    static {
    }

    public static Disposable a(final Function0 r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        return Disposables.fromAction(new g(r100));
    }
}
