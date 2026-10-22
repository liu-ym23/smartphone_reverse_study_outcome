package com.bytedance.assem.arch.viewModel;

import android.os.Looper;
import io.reactivex.functions.BiPredicate;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.android.HandlerDispatcherKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i<R> {
    public boolean a;
    public boolean b;

    public static final class a<T1, T2> implements BiPredicate<R, R> {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final boolean test(R r1, R r2) {
            return Intrinsics.areEqual(r1, r2);
        }
    }

    public i() {
        this.a = true;
        HandlerDispatcherKt.from(com.bytedance.assem.arch.viewModel.a.a(Looper.getMainLooper()), "fast-main");
    }
}
