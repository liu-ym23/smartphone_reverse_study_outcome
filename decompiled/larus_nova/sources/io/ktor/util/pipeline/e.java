package io.ktor.util.pipeline;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes41.dex */
public final class e implements CoroutineStackFrame, Continuation<?> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f491978a = null;

    static {
        f491978a = new e();
    }

    public e() {
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final CoroutineStackFrame getCallerFrame() {
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final StackTraceElement getStackTraceElement() {
        KClass r100 = Reflection.getOrCreateKotlinClass(d.class);
        Intrinsics.checkNotNullParameter(r100, "kClass");
        Intrinsics.checkNotNullParameter("failedToCaptureStackFrame", "methodName");
        Intrinsics.checkNotNullParameter("StackWalkingFailed.kt", "fileName");
        return new StackTraceElement(JvmClassMappingKt.getJavaClass(r100).getName(), "failedToCaptureStackFrame", "StackWalkingFailed.kt", 8);
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object r100) {
        d.f491977a.getClass();
        throw new IllegalStateException("Failed to capture stack frame. This is usually happens when a coroutine is running so the frame stack is changing quickly and the coroutine debug agent is unable to capture it concurrently. You may retry running your test to see this particular trace.".toString());
    }
}
