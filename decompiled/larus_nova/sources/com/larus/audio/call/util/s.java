package com.larus.audio.call.util;

import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.random.Random;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.w1;

/* JADX INFO: loaded from: classes24.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CoroutineScope f289653a = null;

    public static final class a extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public a(CoroutineExceptionHandler.Key r100) {
            super(r100);
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public final void handleException(CoroutineContext r100, Throwable r101) {
            e.f289645a.w("TimeUtils", "[timerScope] exception: " + r101.getMessage());
        }
    }

    static {
        f289653a = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(w1.a(1, "flow-av-kit-timer")).plus(new a(CoroutineExceptionHandler.Key)));
    }

    public static boolean a(float r100) {
        double r101 = 2;
        float r102 = (float) Math.pow(10.0d, r101);
        int r103 = (int) Math.pow(10.0d, r101);
        if (Random.Default.nextInt(0, r103) >= ((int) ((((int) (r100 * r102)) / r102) * r103))) goto L6;
        return true;
    L6:
        return false;
    }
}
