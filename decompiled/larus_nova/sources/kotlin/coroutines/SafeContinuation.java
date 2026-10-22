package kotlin.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0001\u0018\u0000 \u001a*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003:\u0001\u001aB\u0015\b\u0011\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0002\u0010\u0005B\u001f\b\u0000\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\n\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u0001J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001b\u0010\u0014\u001a\u00020\u00152\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0016¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lkotlin/coroutines/SafeContinuation;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/coroutines/Continuation;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "delegate", "(Lkotlin/coroutines/Continuation;)V", "initialResult", "", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "result", "getOrThrow", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "resumeWith", "", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "toString", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SafeContinuation<T> implements Continuation<T>, CoroutineStackFrame {
    private static final Companion Companion = null;
    private static final AtomicReferenceFieldUpdater<SafeContinuation<?>, Object> RESULT = null;
    private final Continuation<T> delegate;
    private volatile Object result;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Rd\u0010\u0003\u001aR\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0006*\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00010\u0001 \u0006*(\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0006*\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0002¨\u0006\b"}, d2 = {"Lkotlin/coroutines/SafeContinuation$Companion;", "", "()V", "RESULT", "Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;", "Lkotlin/coroutines/SafeContinuation;", "kotlin.jvm.PlatformType", "getRESULT$annotations", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        private static /* synthetic */ void getRESULT$annotations() {
        }
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    static {
        Companion = new Companion(null);
        RESULT = AtomicReferenceFieldUpdater.newUpdater(SafeContinuation.class, Object.class, "result");
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        Continuation<T> r100 = this.delegate;
        if ((r100 instanceof CoroutineStackFrame) == true) goto L7;
        return null;
    L7:
        return (CoroutineStackFrame) r100;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.delegate.getContext();
    }

    public final Object getOrThrow() {
        Object r100 = this.result;
        CoroutineSingletons r101 = CoroutineSingletons.UNDECIDED;
        if (r100 != r101) goto L16;
        AtomicReferenceFieldUpdater<SafeContinuation<?>, Object> r102 = RESULT;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    L6:
        if (r102.compareAndSet(this, r101, r103) == true) goto L7;
        if (r102.get(this) == r101) goto L6;
        boolean r104 = false;
    L11:
        if (r104 == true) goto L13;
        r100 = this.result;
        goto L16
    L13:
        return IntrinsicsKt.getCOROUTINE_SUSPENDED();
    L7:
        r104 = true;
    L16:
        if (r100 != CoroutineSingletons.RESUMED) goto L19;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED();
    L19:
        if ((r100 instanceof Result.Failure) == true) goto L22;
        return r100;
    L22:
        throw ((Result.Failure) r100).exception;
    }

    public String toString() {
        return "SafeContinuation for " + this.delegate;
    }

    public SafeContinuation(Continuation<? super T> r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        this(r100, CoroutineSingletons.UNDECIDED);
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object r100) {
    L2:
        Object r101 = this.result;
        CoroutineSingletons r102 = CoroutineSingletons.UNDECIDED;
        boolean r103 = false;
        if (r101 == r102) goto L4;
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L24;
        AtomicReferenceFieldUpdater<SafeContinuation<?>, Object> r104 = RESULT;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        CoroutineSingletons r106 = CoroutineSingletons.RESUMED;
    L16:
        if (r104.compareAndSet(this, r105, r106) == true) goto L17;
        if (r104.get(this) == r105) goto L16;
    L20:
        if (r103 == false) goto L2;
        this.delegate.resumeWith(r100);
        return;
    L17:
        r103 = true;
        goto L20
    L24:
        throw new IllegalStateException("Already resumed");
    L4:
        AtomicReferenceFieldUpdater<SafeContinuation<?>, Object> r107 = RESULT;
    L6:
        if (r107.compareAndSet(this, r102, r100) == true) goto L7;
        if (r107.get(this) == r102) goto L6;
    L10:
        if (r103 == false) goto L2;
        return;
    L7:
        r103 = true;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SafeContinuation(Continuation<? super T> r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        this.delegate = r100;
        this.result = r101;
    }
}
