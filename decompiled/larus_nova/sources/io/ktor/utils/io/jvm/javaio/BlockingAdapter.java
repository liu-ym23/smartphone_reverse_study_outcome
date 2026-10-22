package io.ktor.utils.io.jvm.javaio;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.q0;
import kotlinx.coroutines.v1;

/* JADX INFO: loaded from: classes41.dex */
public abstract class BlockingAdapter {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f492104f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Job f492105a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f492106b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m0 f492107c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f492108d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f492109e;
    volatile /* synthetic */ int result;
    volatile /* synthetic */ Object state;

    public static final class a implements Continuation<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CoroutineContext f492110a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BlockingAdapter f492111b;

        @Override // kotlin.coroutines.Continuation
        public CoroutineContext getContext() {
            return this.f492110a;
        }

        public a(BlockingAdapter r100) {
            this.f492111b = r100;
            Job r101 = r100.f492105a;
            if (r101 == null) goto L5;
            CoroutineContext r102 = f.f492127a.plus(r101);
        L6:
            this.f492110a = r102;
            return;
        L5:
            r102 = f.f492127a;
            goto L6
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.Continuation
        public final void resumeWith(Object r100) {
            Object r101 = Result.m9452exceptionOrNullimpl(r100);
            if (r101 != null) goto L5;
            r101 = Unit.INSTANCE;
        L5:
            BlockingAdapter r102 = this.f492111b;
        L6:
            Object r103 = r102.state;
            boolean r104 = r103 instanceof Thread;
            if (r104 == false) goto L9;
            boolean r105 = true;
        L10:
            if (r105 == false) goto L12;
            boolean r106 = true;
        L13:
            if (r106 == false) goto L49;
            AtomicReferenceFieldUpdater r107 = BlockingAdapter.f492104f;
        L16:
            if (r107.compareAndSet(r102, r103, r101) == true) goto L17;
            if (r107.get(r102) == r103) goto L16;
            boolean r108 = false;
        L21:
            if (r108 == false) goto L6;
            if (r104 == false) goto L25;
            c.a().a(r103);
        L30:
            if (Result.m9455isFailureimpl(r100) == true) goto L32;
        L36:
            m0 r109 = this.f492111b.f492107c;
            if (r109 == null) goto L48;
            r109.dispose();
            return;
        L48:
            return;
        L32:
            if ((Result.m9452exceptionOrNullimpl(r100) instanceof CancellationException) == true) goto L36;
            Job r110 = this.f492111b.f492105a;
            if (r110 == null) goto L36;
            Job.DefaultImpls.cancel$default(r110, null, 1, null);
            goto L36
        L25:
            if ((r103 instanceof Continuation) == false) goto L30;
            Throwable r111 = Result.m9452exceptionOrNullimpl(r100);
            if (r111 == null) goto L30;
            ((Continuation) r103).resumeWith(Result.m9449constructorimpl(ResultKt.createFailure(r111)));
            goto L30
        L17:
            r108 = true;
            goto L21
        L49:
            return;
        L12:
            r106 = Intrinsics.areEqual(r103, this);
            goto L13
        L9:
            r105 = r103 instanceof Continuation;
            goto L10
        }
    }

    static {
        f492104f = AtomicReferenceFieldUpdater.newUpdater(BlockingAdapter.class, Object.class, "state");
    }

    public BlockingAdapter() {
        this(null);
    }

    public abstract Object b(Continuation<? super Unit> r100);

    public final void c() {
        m0 r100 = this.f492107c;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        a r101 = this.f492106b;
        Result.Companion r102 = Result.Companion;
        r101.resumeWith(Result.m9449constructorimpl(ResultKt.createFailure(new CancellationException("Stream closed"))));
    }

    public BlockingAdapter(Job r100) {
        this.f492105a = r100;
        a r101 = new a(this);
        this.f492106b = r101;
        this.state = this;
        boolean r102 = false;
        this.result = 0;
        if (r100 == null) goto L5;
        m0 r103 = r100.invokeOnCompletion(new BlockingAdapter$disposable$1(this));
    L6:
        this.f492107c = r103;
        ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(new BlockingAdapter$block$1(this, null), 1)).invoke(r101);
        if (this.state == this) goto L9;
        r102 = true;
    L9:
        if (r102 == false) goto L12;
        return;
    L12:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        r103 = null;
        goto L6
    }

    public final int d(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "jobToken");
        Object r101 = ThreadMethodProxy.currentThread();
        Continuation r102 = null;
    L3:
        Object r103 = this.state;
        if ((r103 instanceof Continuation) == false) goto L7;
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any>");
        r102 = (Continuation) r103;
        Object r104 = r101;
    L17:
        AtomicReferenceFieldUpdater r105 = f492104f;
    L18:
        boolean r106 = true;
        if (r105.compareAndSet(this, r103, r104) == true) goto L20;
        if (r105.get(this) == r103) goto L18;
        boolean r107 = false;
    L24:
        if (r107 == false) goto L3;
        Intrinsics.checkNotNull(r102);
        r102.resumeWith(Result.m9449constructorimpl(r100));
        if (this.state == r101) goto L29;
    L43:
        Object r108 = this.state;
        if ((r108 instanceof Throwable) == true) goto L48;
        return this.result;
    L48:
        throw ((Throwable) r108);
    L29:
        if (c.a() != d.f492126a) goto L32;
        r106 = false;
    L32:
        if (r106 == true) goto L34;
        ((xwc.c) BlockingKt.f492112a.getValue()).warn("Blocking network thread detected. \nIt can possible lead to a performance decline or even a deadlock.\nPlease make sure you're using blocking IO primitives like InputStream and OutputStream only in \nthe context of Dispatchers.IO:\n```\nwithContext(Dispatchers.IO) {\n    myInputStream.read()\n}\n```");
    L34:
        q0 r109 = v1.f505154a.get();
        if (r109 == null) goto L37;
        long r110 = r109.m();
    L39:
        if (this.state != r101) goto L43;
        if (r110 <= 0) goto L34;
        c.a().b(r110);
        goto L34
    L37:
        r110 = Long.MAX_VALUE;
        goto L39
    L20:
        r107 = true;
        goto L24
    L7:
        if ((r103 instanceof Unit) == true) goto L9;
        if ((r103 instanceof Throwable) == true) goto L54;
        if ((r103 instanceof Thread) == true) goto L52;
        if (Intrinsics.areEqual(r103, this) == true) goto L50;
        r104 = new NoWhenBranchMatchedException();
        goto L17
    L50:
        throw new IllegalStateException("Not yet started");
    L52:
        throw new IllegalStateException("There is already thread owning adapter");
    L54:
        throw ((Throwable) r103);
    L9:
        return this.result;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object a(BlockingAdapter r100, ContinuationImpl r101) {
        Object r102 = null;
    L3:
        Object r103 = r100.state;
        if ((r103 instanceof Thread) == false) goto L7;
        Continuation r104 = IntrinsicsKt.intercepted(r101);
        Object r105 = r103;
    L9:
        AtomicReferenceFieldUpdater r106 = f492104f;
    L11:
        if (r106.compareAndSet(r100, r103, r104) == true) goto L12;
        if (r106.get(r100) == r103) goto L11;
        boolean r107 = false;
    L16:
        if (r107 == true) goto L17;
        r102 = r105;
        goto L3
    L17:
        if (r105 == null) goto L20;
        c.a().a(r105);
    L20:
        return IntrinsicsKt.getCOROUTINE_SUSPENDED();
    L12:
        r107 = true;
        goto L16
    L7:
        if (Intrinsics.areEqual(r103, r100) == false) goto L23;
        r105 = r102;
        r104 = IntrinsicsKt.intercepted(r101);
        goto L9
    L23:
        throw new IllegalStateException("Already suspended or in finished state");
    }

    public final int e(byte[] r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "buffer");
        this.f492108d = r101;
        this.f492109e = r102;
        return d(r100);
    }
}
