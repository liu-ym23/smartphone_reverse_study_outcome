package com.larus.im.internal.utils;

import java.util.concurrent.ScheduledExecutorService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes30.dex */
public final class TimerUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f350521a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CoroutineScope f350522b = null;

    public static final class a extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public a(CoroutineExceptionHandler.Key r100) {
            super(r100);
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public final void handleException(CoroutineContext r100, Throwable r101) {
            fe9.a.f476620a.f("TimerUtils", "[timerScope] exception: " + r101.getMessage());
        }
    }

    static {
        Lazy r100 = LazyKt.lazy(new h0());
        f350521a = r100;
        f350522b = CoroutineScopeKt.CoroutineScope(ExecutorsKt.from((ScheduledExecutorService) r100.getValue()).plus(new a(CoroutineExceptionHandler.Key)));
    }

    public static Job a(Function2 r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        return BuildersKt.launch$default(f350522b, null, null, new TimerUtils$launch$1(r100, null), 3, null);
    }
}
