package com.bytedance.assem.arch.viewModel;

import android.os.Looper;
import io.reactivex.functions.BiPredicate;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.android.HandlerDispatcherKt;

/* JADX INFO: loaded from: classes14.dex */
public final class i<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f193087a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f193088b;

    public static final class a<T1, T2> implements BiPredicate<R, R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f193089a = null;

        static {
            f193089a = new a();
        }

        public a() {
        }

        @Override // io.reactivex.functions.BiPredicate
        public final boolean test(R r100, R r101) {
            return Intrinsics.areEqual(r100, r101);
        }
    }

    public i() {
        this.f193087a = true;
        HandlerDispatcherKt.from(com.bytedance.assem.arch.viewModel.a.a(Looper.getMainLooper()), "fast-main");
    }
}
