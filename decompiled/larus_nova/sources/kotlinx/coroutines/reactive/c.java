package kotlinx.coroutines.reactive;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.ExceptionsKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.y;

/* JADX INFO: loaded from: classes42.dex */
public final class c<T> extends kotlinx.coroutines.a<Unit> implements wwc.c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f505030d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f505031e = null;
    private volatile boolean cancellationRequested;
    private volatile /* synthetic */ Object producer$volatile;
    private volatile /* synthetic */ long requested$volatile;

    static {
        f505030d = AtomicLongFieldUpdater.newUpdater(c.class, "requested$volatile");
        f505031e = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "producer$volatile");
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    public final void cancel() {
        this.cancellationRequested = true;
        cancel(null);
    }

    @Override // wwc.c
    public final void request(long r110) {
        if (r110 > 0) goto L5;
        return;
    L5:
        AtomicLongFieldUpdater r100 = f505030d;
    L6:
        long r101 = r100.get(this);
        long r102 = r101 + r110;
        if (r102 > 0) goto L10;
        r102 = Long.MAX_VALUE;
    L10:
        if (r100.compareAndSet(this, r101, r102) == false) goto L6;
        if (r101 > 0) goto L22;
    L13:
        Continuation r111 = (Continuation) f505031e.getAndSet(this, null);
        if (r111 == null) goto L13;
        Result.Companion r112 = Result.Companion;
        r111.resumeWith(Result.m9449constructorimpl(Unit.INSTANCE));
        return;
    }

    public static final Unit n0(c r100, Continuation r101) {
        r100.getClass();
        if ((r101 instanceof FlowSubscription$flowProcessing$1) == false) goto L7;
        FlowSubscription$flowProcessing$1 r102 = (FlowSubscription$flowProcessing$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L19;
        if (r105 != 1) goto L12;
        c r106 = (c) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L22
        r106.getClass();     // Catch: Throwable -> L17
        throw null;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        y.a(r106.f504616c, th);
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        ResultKt.throwOnFailure(r104);
        r102.L$0 = r100;     // Catch: Throwable -> L22
        r102.label = 1;     // Catch: Throwable -> L22
        throw null;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        if (r100.cancellationRequested == true) goto L26;
    L38:
        throw null;     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        ExceptionsKt.addSuppressed(th, th);
        y.a(r100.f504616c, th);
    L34:
        return Unit.INSTANCE;
    L26:
        if (r100.isActive() == true) goto L38;
        if (th != r100.getCancellationException()) goto L38;
    L7:
        r102 = new FlowSubscription$flowProcessing$1(r100, r101);
        goto L8
    }
}
