package io.ktor.utils.io.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.m0;

/* JADX INFO: loaded from: classes41.dex */
public final class b<T> implements Continuation<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f492066a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f492067b = null;
    private volatile /* synthetic */ Object jobCancellationHandler;
    private volatile /* synthetic */ Object state;

    public final class a implements Function1<Throwable, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Job f492068a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public m0 f492069b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b<T> f492070c;

        public final void a() {
            m0 r100 = this.f492069b;
            if (r100 == null) goto L6;
            this.f492069b = null;
            r100.dispose();
            return;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Throwable r100) {
            Throwable r101 = r100;
            b<T> r102 = this.f492070c;
            AtomicReferenceFieldUpdater r103 = b.f492066a;
            r102.getClass();
            AtomicReferenceFieldUpdater r104 = b.f492067b;
        L4:
            if (r104.compareAndSet(r102, this, null) == true) goto L8;
            if (r104.get(r102) == this) goto L4;
        L8:
            a();
            if (r101 == null) goto L12;
            b.a(this.f492070c, this.f492068a, r101);
        L12:
            return Unit.INSTANCE;
        }

        public a(b r100, Job r101) {
            Intrinsics.checkNotNullParameter(r101, "job");
            this.f492070c = r100;
            this.f492068a = r101;
            m0 r102 = Job.DefaultImpls.invokeOnCompletion$default(r101, true, false, this, 2, null);
            if (r101.isActive() == false) goto L6;
            this.f492069b = r102;
            return;
        }
    }

    static {
        f492066a = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "state");
        f492067b = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "jobCancellationHandler");
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        Object r100 = this.state;
        if ((r100 instanceof Continuation) == false) goto L5;
        Continuation r101 = (Continuation) r100;
    L6:
        if (r101 == null) goto L10;
        CoroutineContext r102 = r101.getContext();
        if (r102 == null) goto L10;
        return r102;
    L10:
        return EmptyCoroutineContext.INSTANCE;
    L5:
        r101 = null;
        goto L6
    }

    public b() {
        this.state = null;
        this.jobCancellationHandler = null;
    }

    public final void c(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "cause");
        Result.Companion r101 = Result.Companion;
        resumeWith(Result.m9449constructorimpl(ResultKt.createFailure(r100)));
        a r102 = (a) f492067b.getAndSet(this, null);
        if (r102 == null) goto L6;
        r102.a();
        return;
    }

    public final Object e(Continuation<? super T> r100) {
        Intrinsics.checkNotNullParameter(r100, "actual");
    L3:
        Object r101 = this.state;
        boolean r102 = false;
        if (r101 == null) goto L5;
        AtomicReferenceFieldUpdater r103 = f492066a;
    L44:
        if (r103.compareAndSet(this, r101, null) == true) goto L45;
        if (r103.get(this) == r101) goto L44;
    L48:
        if (r102 == false) goto L3;
        if ((r101 instanceof Throwable) == true) goto L54;
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type T of io.ktor.utils.io.internal.CancellableReusableContinuation");
        return r101;
    L54:
        throw ((Throwable) r101);
    L45:
        r102 = true;
        goto L48
    L5:
        AtomicReferenceFieldUpdater r104 = f492066a;
    L7:
        if (r104.compareAndSet(this, null, r100) == true) goto L8;
        if (r104.get(this) == null) goto L7;
        boolean r105 = false;
    L12:
        if (r105 == false) goto L3;
        Job r106 = (Job) r100.getContext().get(Job.Key);
        a r107 = (a) this.jobCancellationHandler;
        if (r107 == null) goto L16;
        Job r108 = r107.f492068a;
    L17:
        if (r108 == r106) goto L41;
        if (r106 != null) goto L23;
        a r109 = (a) f492067b.getAndSet(this, null);
        if (r109 == null) goto L41;
        r109.a();
        goto L41
    L23:
        a r110 = new a(this, r106);
    L24:
        Object r111 = this.jobCancellationHandler;
        a r112 = (a) r111;
        if (r112 != null) goto L28;
    L30:
        AtomicReferenceFieldUpdater r113 = f492067b;
    L32:
        if (r113.compareAndSet(this, r111, r110) == true) goto L33;
        if (r113.get(this) == r111) goto L32;
        boolean r114 = false;
    L37:
        if (r114 == false) goto L24;
        if (r112 == null) goto L41;
        r112.a();
        goto L41
    L33:
        r114 = true;
        goto L37
    L28:
        if (r112.f492068a != r106) goto L30;
        r110.a();
    L41:
        return IntrinsicsKt.getCOROUTINE_SUSPENDED();
    L16:
        r108 = null;
        goto L17
    L8:
        r105 = true;
        goto L12
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object r100) {
    L2:
        Object r101 = this.state;
        if (r101 != null) goto L8;
        Object r102 = Result.m9452exceptionOrNullimpl(r100);
        if (r102 != null) goto L10;
        ResultKt.throwOnFailure(r100);
        r102 = r100;
    L10:
        AtomicReferenceFieldUpdater r103 = f492066a;
    L12:
        if (r103.compareAndSet(this, r101, r102) == true) goto L13;
        if (r103.get(this) == r101) goto L12;
        boolean r104 = false;
    L17:
        if (r104 == false) goto L2;
        if ((r101 instanceof Continuation) == false) goto L30;
        ((Continuation) r101).resumeWith(r100);
        return;
    L30:
        return;
    L13:
        r104 = true;
        goto L17
    L8:
        if ((r101 instanceof Continuation) == false) goto L31;
        r102 = null;
        goto L10
    }

    public static final void a(b r100, Job r101, Throwable r102) {
    L2:
        Object r103 = r100.state;
        if ((r103 instanceof Continuation) == false) goto L27;
        Continuation r104 = (Continuation) r103;
        if (r104.getContext().get(Job.Key) != r101) goto L28;
        AtomicReferenceFieldUpdater r105 = f492066a;
    L10:
        if (r105.compareAndSet(r100, r103, null) == true) goto L11;
        if (r105.get(r100) == r103) goto L10;
        boolean r106 = false;
    L15:
        if (r106 == false) goto L2;
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.coroutines.Continuation<T of io.ktor.utils.io.internal.CancellableReusableContinuation>");
        Result.Companion r107 = Result.Companion;
        r104.resumeWith(Result.m9449constructorimpl(ResultKt.createFailure(r102)));
        return;
    L11:
        r106 = true;
        goto L15
    L28:
        return;
    }
}
