package kotlinx.coroutines.channels;

import androidx.collection.SieveCacheKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExceptionsKt;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.d2;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.internal.a0;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.internal.y;
import kotlinx.coroutines.internal.z;
import kotlinx.coroutines.selects.SelectImplementation;
import kotlinx.coroutines.selects.TrySelectDetailedResult;

/* JADX INFO: loaded from: classes5.dex */
public class BufferedChannel<E> implements Channel<E> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f504652d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f504653e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f504654f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f504655g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f504656h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f504657i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f504658j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f504659k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f504660l = null;
    private volatile /* synthetic */ Object _closeCause$volatile;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f504661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<E, Unit> f504662b;
    private volatile /* synthetic */ long bufferEnd$volatile;
    private volatile /* synthetic */ Object bufferEndSegment$volatile;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function3<kotlinx.coroutines.selects.l<?>, Object, Object, Function1<Throwable, Unit>> f504663c;
    private volatile /* synthetic */ Object closeHandler$volatile;
    private volatile /* synthetic */ long completedExpandBuffersAndPauseFlag$volatile;
    private volatile /* synthetic */ Object receiveSegment$volatile;
    private volatile /* synthetic */ long receivers$volatile;
    private volatile /* synthetic */ Object sendSegment$volatile;
    private volatile /* synthetic */ long sendersAndCloseStatus$volatile;

    public final class a implements ChannelIterator<E>, d2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f504664a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public kotlinx.coroutines.j<? super Boolean> f504665b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BufferedChannel<E> f504666c;

        @Override // kotlinx.coroutines.channels.ChannelIterator
        public final E next() {
            E r100 = (E) this.f504664a;
            b0 r101 = e.f504691p;
            if (r100 == r101) goto L5;
            boolean r102 = true;
        L6:
            if (r102 == false) goto L13;
            this.f504664a = r101;
            if (r100 == e.f504687l) goto L10;
            return r100;
        L10:
            BufferedChannel<E> r103 = this.f504666c;
            AtomicLongFieldUpdater r104 = BufferedChannel.f504652d;
            Throwable r105 = r103.n();
            int r106 = a0.f504935a;
            throw r105;
        L13:
            throw new IllegalStateException("`hasNext()` has not been invoked".toString());
        L5:
            r102 = false;
            goto L6
        }

        public a(BufferedChannel r100) {
            this.f504666c = r100;
            this.f504664a = e.f504691p;
        }

        public static final void a(a r100) {
            kotlinx.coroutines.j<? super Boolean> r101 = r100.f504665b;
            Intrinsics.checkNotNull(r101);
            r100.f504665b = null;
            r100.f504664a = e.f504687l;
            Throwable r102 = r100.f504666c.m();
            if (r102 != null) goto L5;
            Result.Companion r103 = Result.Companion;
            r101.resumeWith(Result.m9449constructorimpl(Boolean.FALSE));
            return;
        L5:
            Result.Companion r104 = Result.Companion;
            r101.resumeWith(Result.m9449constructorimpl(ResultKt.createFailure(r102)));
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        public final Object hasNext(Continuation<? super Boolean> r110) {
            BufferedChannel<E> r100 = this.f504666c;
            h<E> r101 = (h) BufferedChannel.f504657i.get(r100);
        L4:
            if (r100.isClosedForReceive() == true) goto L5;
            long r102 = BufferedChannel.f504653e.getAndIncrement(r100);
            int r103 = e.f504677b;
            long r104 = r102 / ((long) r103);
            int r111 = (int) (r102 % ((long) r103));
            if (r101.f504984c == r104) goto L16;
            h<E> r105 = r100.k(r104, r101);
            if (r105 == null) goto L4;
            h<E> r112 = r105;
        L17:
            Object r106 = r100.K(r112, r111, r102, null);
            b0 r113 = e.f504688m;
            if (r106 == r113) goto L78;
            b0 r114 = e.f504690o;
            if (r106 != r114) goto L26;
            if (r102 >= r100.q()) goto L24;
            r112.b();
        L24:
            r101 = r112;
            goto L4
        L26:
            if (r106 != e.f504689n) goto L75;
            BufferedChannel<E> r107 = this.f504666c;
            kotlinx.coroutines.j<? super Boolean> r115 = kotlinx.coroutines.l.a(IntrinsicsKt.intercepted(r110));
            this.f504665b = r115;     // Catch: Throwable -> L72
            Object r108 = r107.K(r112, r111, r102, this);     // Catch: Throwable -> L72
            if (r108 != r113) goto L31;
            r107.B();     // Catch: Throwable -> L72
            e(r112, r111);     // Catch: Throwable -> L72
        L68:
            Object r109 = r115.B();
            if (r109 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L71;
            DebugProbesKt.probeCoroutineSuspended(r110);
        L71:
            return r109;
        L31:
            Function1<Throwable, Unit> r116 = null;
            if (r108 == r114) goto L34;
            r112.b();     // Catch: Throwable -> L72
            this.f504664a = r108;     // Catch: Throwable -> L72
            this.f504665b = null;     // Catch: Throwable -> L72
            Boolean r117 = Boxing.boxBoolean(true);     // Catch: Throwable -> L72
            Function1<E, Unit> r118 = r107.f504662b;     // Catch: Throwable -> L72
            if (r118 == null) goto L67;
            CoroutineContext r119 = r115.getContext();     // Catch: Throwable -> L72
        L61:
            r116 = OnUndeliveredElementKt.a(r118, r108, r119);     // Catch: Throwable -> L72
        L67:
            r115.h(r117, r116);     // Catch: Throwable -> L72
            goto L68
        L34:
            if (r102 >= r107.q()) goto L36;
            r112.b();     // Catch: Throwable -> L72
        L36:
            h<E> r120 = (h) BufferedChannel.f504657i.get(r107);     // Catch: Throwable -> L72
        L38:
            if (r107.isClosedForReceive() == true) goto L39;
            long r121 = BufferedChannel.f504653e.getAndIncrement(r107);     // Catch: Throwable -> L72
            long r122 = e.f504677b;     // Catch: Throwable -> L72
            long r123 = r121 / r122;     // Catch: Throwable -> L72
            int r124 = (int) (r121 % r122);     // Catch: Throwable -> L72
            if (r120.f504984c == r123) goto L46;
            h<E> r125 = r107.k(r123, r120);     // Catch: Throwable -> L72
            if (r125 == null) goto L38;
            h<E> r126 = r125;
        L47:
            r108 = r107.K(r126, r124, r121, this);     // Catch: Throwable -> L72
            if (r108 == e.f504688m) goto L49;
            if (r108 != e.f504690o) goto L57;
            if (r121 >= r107.q()) goto L55;
            r126.b();     // Catch: Throwable -> L72
        L55:
            r120 = r126;
            goto L38
        L57:
            if (r108 == e.f504689n) goto L63;
            r126.b();     // Catch: Throwable -> L72
            this.f504664a = r108;     // Catch: Throwable -> L72
            this.f504665b = null;     // Catch: Throwable -> L72
            r117 = Boxing.boxBoolean(true);     // Catch: Throwable -> L72
            r118 = r107.f504662b;     // Catch: Throwable -> L72
            if (r118 == null) goto L67;
            r119 = r115.getContext();     // Catch: Throwable -> L72
            goto L61
        L63:
            throw new IllegalStateException("unexpected".toString());     // Catch: Throwable -> L72
        L49:
            r107.B();     // Catch: Throwable -> L72
            e(r126, r124);     // Catch: Throwable -> L72
            goto L68
        L46:
            r126 = r120;
            goto L47
        L39:
            a(this);     // Catch: Throwable -> L72
        L72:
            th = move-exception;
            r115.H();
            throw th;
        L75:
            r112.b();
            this.f504664a = r106;
            return Boxing.boxBoolean(true);
        L78:
            throw new IllegalStateException("unreachable".toString());
        L16:
            r112 = r101;
            goto L17
        L5:
            this.f504664a = e.f504687l;
            Throwable r127 = this.f504666c.m();
            if (r127 == null) goto L97;
            int r128 = a0.f504935a;
            throw r127;
        L97:
            return Boxing.boxBoolean(false);
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.3.0, binary compatibility with versions <= 1.2.x")
        public final /* synthetic */ Object next(Continuation r100) {
            return ChannelIterator.DefaultImpls.a(this, r100);
        }

        @Override // kotlinx.coroutines.d2
        public final void e(y<?> r100, int r101) {
            kotlinx.coroutines.j<? super Boolean> r102 = this.f504665b;
            if (r102 == null) goto L6;
            r102.e(r100, r101);
            return;
        }
    }

    /* JADX INFO: loaded from: classes42.dex */
    public static final class b implements d2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final kotlinx.coroutines.i<Boolean> f504667a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.j<Boolean> f504668b;

        @Override // kotlinx.coroutines.d2
        public final void e(y<?> r100, int r101) {
            this.f504668b.e(r100, r101);
        }

        public b(kotlinx.coroutines.j r100) {
            this.f504667a = r100;
            Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuationImpl<kotlin.Boolean>");
            this.f504668b = r100;
        }
    }

    static {
        f504652d = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "sendersAndCloseStatus$volatile");
        f504653e = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "receivers$volatile");
        f504654f = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "bufferEnd$volatile");
        f504655g = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "completedExpandBuffersAndPauseFlag$volatile");
        f504656h = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "sendSegment$volatile");
        f504657i = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "receiveSegment$volatile");
        f504658j = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "bufferEndSegment$volatile");
        f504659k = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "_closeCause$volatile");
        f504660l = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "closeHandler$volatile");
    }

    public void A() {
    }

    public void B() {
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final void cancel() {
        f(null);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /* JADX INFO: renamed from: receiveCatching-JP2dKIU, reason: not valid java name */
    public final Object mo10963receiveCatchingJP2dKIU(Continuation<? super g<? extends E>> r100) {
        return C(this, r100);
    }

    public boolean u() {
        return false;
    }

    public void x() {
    }

    public boolean H() {
        long r100 = f504652d.get(this);
        if (t(r100, false) == false) goto L6;
        return false;
    L6:
        return !e(r100 & 1152921504606846975L);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final kotlinx.coroutines.selects.g<E> getOnReceive() {
        BufferedChannel$onReceive$1 r100 = BufferedChannel$onReceive$1.INSTANCE;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Function3 r101 = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r100, 3);
        BufferedChannel$onReceive$2 r102 = BufferedChannel$onReceive$2.INSTANCE;
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new kotlinx.coroutines.selects.h(this, r101, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r102, 3), this.f504663c);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final kotlinx.coroutines.selects.g<g<E>> getOnReceiveCatching() {
        BufferedChannel$onReceiveCatching$1 r100 = BufferedChannel$onReceiveCatching$1.INSTANCE;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Function3 r101 = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r100, 3);
        BufferedChannel$onReceiveCatching$2 r102 = BufferedChannel$onReceiveCatching$2.INSTANCE;
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new kotlinx.coroutines.selects.h(this, r101, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r102, 3), this.f504663c);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final kotlinx.coroutines.selects.g<E> getOnReceiveOrNull() {
        BufferedChannel$onReceiveOrNull$1 r100 = BufferedChannel$onReceiveOrNull$1.INSTANCE;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Function3 r101 = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r100, 3);
        BufferedChannel$onReceiveOrNull$2 r102 = BufferedChannel$onReceiveOrNull$2.INSTANCE;
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new kotlinx.coroutines.selects.h(this, r101, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r102, 3), this.f504663c);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final kotlinx.coroutines.selects.i<E, BufferedChannel<E>> getOnSend() {
        BufferedChannel$onSend$1 r100 = BufferedChannel$onSend$1.INSTANCE;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Function3 r101 = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r100, 3);
        BufferedChannel$onSend$2 r102 = BufferedChannel$onSend$2.INSTANCE;
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new kotlinx.coroutines.selects.j(this, r101, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r102, 3));
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final boolean isClosedForReceive() {
        return t(f504652d.get(this), true);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean isClosedForSend() {
        return t(f504652d.get(this), false);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final ChannelIterator<E> iterator() {
        return new a(this);
    }

    public final void j() {
        if (v() == false) goto L5;
        return;
    L5:
        h<E> r100 = (h) f504658j.get(this);
    L6:
        long r101 = f504654f.getAndIncrement(this);
        long r102 = r101 / ((long) e.f504677b);
        if (q() <= r101) goto L9;
        if (r100.f504984c == r102) goto L58;
        AtomicReferenceFieldUpdater r103 = f504658j;
        BufferedChannelKt$createSegmentFunction$1 r104 = BufferedChannelKt$createSegmentFunction$1.INSTANCE;
    L18:
        Object r105 = kotlinx.coroutines.internal.d.a(r100, r102, r104);
        if (z.b(r105) == true) goto L46;
        y r106 = z.a(r105);
    L21:
        y r110 = (y) r103.get(this);
        if (r110.f504984c >= r106.f504984c) goto L37;
        if (r106.j() == false) goto L26;
    L28:
        if (r103.compareAndSet(this, r110, r106) == true) goto L29;
        if (r103.get(this) == r110) goto L28;
        boolean r111 = false;
    L33:
        if (r111 == true) goto L35;
        if (r106.f() == false) goto L21;
        r106.e();
        goto L21
    L35:
        if (r110.f() == false) goto L37;
        r110.e();
        goto L37
    L29:
        r111 = true;
        goto L33
    L26:
        boolean r107 = false;
    L38:
        if (r107 == false) goto L18;
    L37:
        r107 = true;
    L46:
        if (z.b(r105) == false) goto L48;
        isClosedForSend();
        w(r102, r100);
        s(1);
    L54:
        h<E> r112 = null;
    L55:
        if (r112 == null) goto L6;
        r100 = r112;
        goto L58
    L48:
        r112 = (h) z.a(r105);
        long r108 = r112.f504984c;
        if (r108 <= r102) goto L55;
        long r113 = e.f504677b;
        if (f504654f.compareAndSet(this, r101 + 1, r108 * r113) == false) goto L53;
        s((r112.f504984c * r113) - r101);
        goto L54
    L53:
        s(1);
    L58:
        int r109 = (int) (r101 % ((long) e.f504677b));
        Object r114 = r100.l(r109);
        if ((r114 instanceof d2) == false) goto L68;
        if (r101 < f504653e.get(this)) goto L68;
        if (r100.k(r109, r114, e.f504682g) == false) goto L68;
        if (J(r114, r100, r109) == false) goto L67;
        r100.o(r109, e.f504679d);
    L106:
        boolean r115 = true;
    L107:
        if (r115 == true) goto L108;
        s(1);
        goto L6
    L108:
        s(1);
        return;
    L67:
        r100.o(r109, e.f504685j);
        r100.m(r109, false);
    L83:
        r115 = false;
    L68:
        Object r116 = r100.l(r109);
        if ((r116 instanceof d2) == true) goto L71;
        if (r116 == e.f504685j) goto L83;
        if (r116 == null) goto L86;
        if (r116 == e.f504679d) goto L106;
        if (r116 == e.f504683h) goto L106;
        if (r116 == e.f504684i) goto L106;
        if (r116 == e.f504686k) goto L106;
        if (r116 == e.f504687l) goto L106;
        if (r116 == e.f504681f) goto L68;
        throw new IllegalStateException(("Unexpected cell state: " + r116).toString());
    L86:
        if (r100.k(r109, r116, e.f504680e) == false) goto L68;
    L71:
        if (r101 < f504653e.get(this)) goto L73;
        if (r100.k(r109, r116, e.f504682g) == false) goto L68;
        if (J(r116, r100, r109) == false) goto L80;
        r100.o(r109, e.f504679d);
        goto L106
    L80:
        r100.o(r109, e.f504685j);
        r100.m(r109, false);
        goto L83
    L73:
        if (r100.k(r109, r116, new n((d2) r116)) == false) goto L68;
    L9:
        if (r100.f504984c < r102) goto L11;
    L13:
        s(1);
        return;
    L11:
        if (r100.c() == 0) goto L13;
        w(r102, r100);
        goto L13
    }

    public final long l() {
        return f504654f.get(this);
    }

    public final Throwable m() {
        return (Throwable) f504659k.get(this);
    }

    public final long o() {
        return f504653e.get(this);
    }

    public final long q() {
        return f504652d.get(this) & 1152921504606846975L;
    }

    public final boolean r() {
    L2:
        AtomicReferenceFieldUpdater r100 = f504657i;
        h<E> r101 = (h) r100.get(this);
        long r102 = o();
        boolean r103 = false;
        if (q() <= r102) goto L4;
        int r104 = e.f504677b;
        long r105 = r102 / ((long) r104);
        if (r101.f504984c == r105) goto L12;
        r101 = k(r105, r101);
        if (r101 != null) goto L12;
        if (((h) r100.get(this)).f504984c >= r105) goto L2;
        return false;
    L12:
        r101.b();
        int r106 = (int) (r102 % ((long) r104));
    L13:
        Object r107 = r101.l(r106);
        if (r107 == null) goto L43;
        if (r107 == e.f504680e) goto L43;
        if (r107 != e.f504679d) goto L22;
    L41:
        r103 = true;
    L45:
        if (r103 == true) goto L46;
        f504653e.compareAndSet(this, r102, r102 + 1);
        goto L2
    L46:
        return true;
    L22:
        if (r107 == e.f504685j) goto L45;
        if (r107 == e.f504687l) goto L45;
        if (r107 == e.f504684i) goto L45;
        if (r107 == e.f504683h) goto L45;
        if (r107 == e.f504682g) goto L41;
        if (r107 == e.f504681f) goto L45;
        if (r102 != o()) goto L45;
    L43:
        if (r101.k(r106, r107, e.f504683h) == false) goto L13;
        j();
        goto L45
    L4:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        int r101 = (int) (f504652d.get(this) >> 60);
        if (r101 == 2) goto L7;
        if (r101 != 3) goto L8;
        r100.append("cancelled,");
    L8:
        r100.append("capacity=" + this.f504661a + ',');
        r100.append("data=[");
        List r102 = CollectionsKt.listOf(new h[]{f504657i.get(this), f504656h.get(this), f504658j.get(this)});
        ArrayList r103 = new ArrayList();
        Iterator r104 = r102.iterator();
    L10:
        if (r104.hasNext() == false) goto L17;
        Object r105 = r104.next();
        if (((h) r105) == e.f504676a) goto L14;
        boolean r106 = true;
    L15:
        if (r106 == false) goto L10;
        r103.add(r105);
        goto L10
    L14:
        r106 = false;
        goto L15
    L17:
        Iterator r107 = r103.iterator();
        if (r107.hasNext() == false) goto L103;
        Object r108 = r107.next();
        if (r107.hasNext() == false) goto L28;
        long r109 = ((h) r108).f504984c;
    L23:
        Object r110 = r107.next();
        long r111 = ((h) r110).f504984c;
        if (r109 <= r111) goto L27;
        r108 = r110;
        r109 = r111;
    L27:
        if (r107.hasNext() == true) goto L23;
    L28:
        h r112 = (h) r108;
        long r113 = o();
        long r114 = q();
    L29:
        int r115 = e.f504677b;
        int r116 = 0;
    L30:
        if (r116 >= r115) goto L94;
        long r117 = (r112.f504984c * ((long) e.f504677b)) + ((long) r116);
        if (r117 >= r114) goto L34;
    L35:
        Object r118 = r112.l(r116);
        Object r119 = r112.f504700f.get(r116 * 2);
        if ((r118 instanceof kotlinx.coroutines.i) == false) goto L46;
        if (r117 >= r113) goto L41;
        if (r117 < r114) goto L41;
        String r120 = "receive";
    L90:
        if (r119 == null) goto L92;
        r100.append("(" + r120 + ',' + r119 + "),");
    L93:
        r116 = r116 + 1;
        goto L30
    L92:
        r100.append(r120 + ',');
    L41:
        if (r117 >= r114) goto L44;
        if (r117 < r113) goto L44;
        r120 = "send";
    L44:
        r120 = "cont";
        goto L90
    L46:
        if ((r118 instanceof kotlinx.coroutines.selects.l) == false) goto L56;
        if (r117 >= r113) goto L51;
        if (r117 < r114) goto L51;
        r120 = "onReceive";
    L51:
        if (r117 >= r114) goto L54;
        if (r117 < r113) goto L54;
        r120 = "onSend";
    L54:
        r120 = "select";
        goto L90
    L56:
        if ((r118 instanceof l) == false) goto L59;
        r120 = "receiveCatching";
        goto L90
    L59:
        if ((r118 instanceof b) == false) goto L62;
        r120 = "sendBroadcast";
        goto L90
    L62:
        if ((r118 instanceof n) == false) goto L65;
        r120 = "EB(" + r118 + ')';
        goto L90
    L65:
        if (Intrinsics.areEqual(r118, e.f504681f) == false) goto L67;
        boolean r121 = true;
    L68:
        if (r121 == false) goto L70;
        r120 = "resuming_sender";
        goto L90
    L70:
        if (r118 != null) goto L72;
        boolean r122 = true;
    L73:
        if (r122 == false) goto L75;
        boolean r123 = true;
    L76:
        if (r123 == false) goto L78;
        boolean r124 = true;
    L79:
        if (r124 == false) goto L81;
        boolean r125 = true;
    L82:
        if (r125 == false) goto L84;
        boolean r126 = true;
    L85:
        if (r126 == false) goto L87;
        boolean r127 = true;
    L88:
        if (r127 == true) goto L93;
        r120 = r118.toString();
        goto L90
    L87:
        r127 = Intrinsics.areEqual(r118, e.f504687l);
        goto L88
    L84:
        r126 = Intrinsics.areEqual(r118, e.f504685j);
        goto L85
    L81:
        r125 = Intrinsics.areEqual(r118, e.f504686k);
        goto L82
    L78:
        r124 = Intrinsics.areEqual(r118, e.f504683h);
        goto L79
    L75:
        r123 = Intrinsics.areEqual(r118, e.f504684i);
        goto L76
    L72:
        r122 = Intrinsics.areEqual(r118, e.f504680e);
        goto L73
    L67:
        r121 = Intrinsics.areEqual(r118, e.f504682g);
        goto L68
    L34:
        if (r117 < r113) goto L35;
    L97:
        if (StringsKt.last(r100) != ',') goto L99;
        r100.deleteCharAt(r100.length() - 1);
    L99:
        r100.append("]");
        return r100.toString();
    L94:
        r112 = (h) r112.c();
        if (r112 != null) goto L29;
    L103:
        throw new NoSuchElementException();
    L7:
        r100.append("closed,");
        goto L8
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /* JADX INFO: renamed from: tryReceive-PtdJZtk, reason: not valid java name */
    public final Object mo10964tryReceivePtdJZtk() {
        long r100 = f504653e.get(this);
        long r101 = f504652d.get(this);
        if (t(r101, true) == false) goto L7;
        g.c r102 = g.f504696b;
        return new g.a(m());
    L7:
        if (r100 < (r101 & 1152921504606846975L)) goto L10;
        g.c r103 = g.f504696b;
        return g.f504696b;
    L10:
        Object r104 = e.f504686k;
        h<E> r105 = (h) f504657i.get(this);
    L12:
        if (isClosedForReceive() == true) goto L13;
        long r106 = f504653e.getAndIncrement(this);
        int r107 = e.f504677b;
        long r108 = r106 / ((long) r107);
        int r109 = (int) (r106 % ((long) r107));
        if (r105.f504984c == r108) goto L20;
        h<E> r110 = k(r108, r105);
        if (r110 == null) goto L12;
        h<E> r111 = r110;
    L21:
        Object r112 = K(r111, r109, r106, r104);
        if (r112 == e.f504688m) goto L24;
        if (r112 != e.f504690o) goto L37;
        if (r106 >= q()) goto L35;
        r111.b();
    L35:
        r105 = r111;
        goto L12
    L37:
        if (r112 == e.f504689n) goto L41;
        r111.b();
        g.c r113 = g.f504696b;
        return r112;
    L41:
        throw new IllegalStateException("unexpected".toString());
    L24:
        if ((r104 instanceof d2) == false) goto L26;
        d2 r114 = (d2) r104;
    L27:
        if (r114 == null) goto L29;
        B();
        r114.e(r111, r109);
    L29:
        M(r106);
        r111.i();
        g.c r115 = g.f504696b;
        return g.f504696b;
    L26:
        r114 = null;
        goto L27
    L20:
        r111 = r105;
        goto L21
    L13:
        g.c r116 = g.f504696b;
        return new g.a(m());
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final boolean isEmpty() {
        if (isClosedForReceive() == false) goto L6;
        return false;
    L6:
        if (r() == false) goto L9;
        return false;
    L9:
        return !isClosedForReceive();
    }

    public final Throwable n() {
        Throwable r100 = m();
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new ClosedReceiveChannelException(ChannelsKt.DEFAULT_CLOSE_MESSAGE);
    }

    public final Throwable p() {
        Throwable r100 = m();
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new ClosedSendChannelException(ChannelsKt.DEFAULT_CLOSE_MESSAGE);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith = @ReplaceWith(expression = "tryReceive().getOrNull()", imports = {}))
    public final E poll() {
        E r100 = (E) mo10964tryReceivePtdJZtk();
        g.c r101 = g.f504696b;
        if ((!(r100 instanceof g.c)) == false) goto L5;
        g.c(r100);
        return r100;
    L5:
        Throwable r102 = g.a(r100);
        if (r102 != null) goto L9;
        return null;
    L9:
        int r103 = a0.f504935a;
        throw r102;
    }

    public final boolean v() {
        long r100 = l();
        if (r100 != 0) goto L5;
    L8:
        return true;
    L5:
        if (r100 == Long.MAX_VALUE) goto L8;
        return false;
    }

    public final void M(long r210) {
        if (v() == false) goto L6;
        return;
    L6:
        if (l() <= r210) goto L6;
        int r100 = e.f504678c;
        int r101 = 0;
    L9:
        if (r101 >= r100) goto L16;
        long r102 = l();
        if (r102 != (f504655g.get(this) & 4611686018427387903L)) goto L15;
        if (r102 != l()) goto L15;
        return;
    L15:
        r101 = r101 + 1;
        goto L9
    L16:
        AtomicLongFieldUpdater r110 = f504655g;
    L17:
        long r103 = r110.get(this);
        if (r110.compareAndSet(this, r103, SieveCacheKt.NodeVisitedBit + (r103 & 4611686018427387903L)) == false) goto L17;
    L19:
        long r104 = l();
        AtomicLongFieldUpdater r111 = f504655g;
        long r105 = r111.get(this);
        long r106 = r105 & 4611686018427387903L;
        if ((r105 & SieveCacheKt.NodeVisitedBit) == 0) goto L22;
        boolean r112 = true;
    L24:
        if (r104 == r106) goto L26;
    L30:
        if (r112 == true) goto L19;
        r111.compareAndSet(this, r105, r106 + SieveCacheKt.NodeVisitedBit);
        goto L19
    L26:
        if (r104 != l()) goto L30;
    L27:
        long r107 = r111.get(this);
        if (r111.compareAndSet(this, r107, 0 + (r107 & 4611686018427387903L)) == false) goto L27;
        return;
    L22:
        r112 = false;
        goto L24
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final boolean cancel(Throwable r100) {
        return f(r100);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean close(Throwable r100) {
        return g(r100, false);
    }

    public final boolean e(long r100) {
        if (r100 >= l()) goto L5;
    L8:
        return true;
    L5:
        if (r100 < (o() + ((long) this.f504661a))) goto L8;
        return false;
    }

    public boolean f(Throwable r100) {
        if (r100 != null) goto L5;
        r100 = new CancellationException("Channel was cancelled");
    L5:
        return g(r100, true);
    }

    public final h<E> h(long r110) {
        Object r100 = f504658j.get(this);
        h r101 = (h) f504656h.get(this);
        if (r101.f504984c <= ((h) r100).f504984c) goto L5;
        r100 = r101;
    L5:
        h r102 = (h) f504657i.get(this);
        if (r102.f504984c <= ((h) r100).f504984c) goto L8;
        r100 = r102;
    L8:
        kotlinx.coroutines.internal.e r103 = (kotlinx.coroutines.internal.e) r100;
        b0 r104 = kotlinx.coroutines.internal.d.f504939a;
    L9:
        r103.getClass();
        AtomicReferenceFieldUpdater r105 = kotlinx.coroutines.internal.e.f504941a;
        Object r106 = r105.get(r103);
        b0 r107 = kotlinx.coroutines.internal.d.f504939a;
        Object r108 = null;
        if (r106 == r107) goto L21;
        kotlinx.coroutines.internal.e r109 = (kotlinx.coroutines.internal.e) r106;
        if (r109 == null) goto L15;
        r103 = r109;
    L15:
        if (r105.compareAndSet(r103, null, r107) == true) goto L16;
        if (r105.get(r103) == null) goto L15;
        boolean r111 = false;
    L20:
        if (r111 == false) goto L9;
    L16:
        r111 = true;
    L21:
        h<E> r112 = (h) r103;
        if (u() == false) goto L48;
        h<E> r113 = r112;
    L24:
        int r114 = e.f504677b - 1;
    L26:
        if ((-1) >= r114) goto L42;
        long r115 = (r113.f504984c * ((long) e.f504677b)) + ((long) r114);
        if (r115 < o()) goto L44;
    L30:
        Object r116 = r113.l(r114);
        if (r116 == null) goto L39;
        if (r116 == e.f504680e) goto L39;
        if (r116 != e.f504679d) goto L41;
    L46:
        if (r115 == (-1)) goto L48;
        i(r115);
    L41:
        r114 = r114 - 1;
    L39:
        if (r113.k(r114, r116, e.f504687l) == false) goto L30;
        r113.i();
    L44:
        r115 = -1;
        goto L46
    L42:
        r113 = (h) ((kotlinx.coroutines.internal.e) kotlinx.coroutines.internal.e.f504942b.get(r113));
        if (r113 != null) goto L24;
    L48:
        h<E> r117 = r112;
    L49:
        if (r117 == null) goto L74;
        int r118 = e.f504677b - 1;
    L51:
        if ((-1) >= r118) goto L73;
        if (((r117.f504984c * ((long) e.f504677b)) + ((long) r118)) < r110) goto L74;
    L54:
        Object r119 = r117.l(r118);
        if (r119 == null) goto L70;
        if (r119 == e.f504680e) goto L70;
        if ((r119 instanceof n) == true) goto L62;
        if ((r119 instanceof d2) == false) goto L72;
        if (r117.k(r118, r119, e.f504687l) == false) goto L54;
        r108 = kotlinx.coroutines.internal.k.a(r108, r119);
        r117.m(r118, true);
    L72:
        r118 = r118 - 1;
        goto L51
    L62:
        if (r117.k(r118, r119, e.f504687l) == false) goto L54;
        r108 = kotlinx.coroutines.internal.k.a(r108, ((n) r119).f504703a);
        r117.m(r118, true);
    L70:
        if (r117.k(r118, r119, e.f504687l) == false) goto L54;
        r117.i();
        goto L72
    L73:
        r117 = (h) ((kotlinx.coroutines.internal.e) kotlinx.coroutines.internal.e.f504942b.get(r117));
    L74:
        if (r108 != null) goto L76;
    L81:
        return r112;
    L76:
        if ((r108 instanceof ArrayList) == true) goto L78;
        F((d2) r108, true);
        goto L81
    L78:
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
        ArrayList r120 = (ArrayList) r108;
        int r121 = r120.size() - 1;
    L79:
        if ((-1) >= r121) goto L81;
        F((d2) ListProtector.get(r120, r121), true);
        r121 = r121 - 1;
        goto L79
    }

    public final void i(long r110) {
        h<E> r100 = (h) f504657i.get(this);
    L3:
        AtomicLongFieldUpdater r101 = f504653e;
        long r102 = r101.get(this);
        if (r110 < Math.max(((long) this.f504661a) + r102, l())) goto L5;
        if (r101.compareAndSet(this, r102, r102 + 1) == false) goto L3;
        long r103 = e.f504677b;
        long r104 = r102 / r103;
        int r105 = (int) (r102 % r103);
        if (r100.f504984c == r104) goto L14;
        h<E> r106 = k(r104, r100);
        if (r106 == null) goto L3;
        r100 = r106;
    L14:
        Object r107 = K(r100, r105, r102, null);
        if (r107 == e.f504690o) goto L17;
        r100.b();
        Function1<E, Unit> r108 = this.f504662b;
        if (r108 == null) goto L3;
        UndeliveredElementException r109 = OnUndeliveredElementKt.c(r108, r107, null);
        if (r109 == null) goto L3;
        throw r109;
    L17:
        if (r102 >= q()) goto L3;
        r100.b();
        goto L3
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final void invokeOnClose(Function1<? super Throwable, Unit> r100) {
        AtomicReferenceFieldUpdater r101 = f504660l;
    L4:
        if (r101.compareAndSet(this, null, r100) == true) goto L5;
        if (r101.get(this) == null) goto L4;
        boolean r102 = false;
    L9:
        if (r102 == false) goto L11;
        return;
    L11:
        AtomicReferenceFieldUpdater r103 = f504660l;
    L12:
        Object r104 = r103.get(this);
        b0 r105 = e.f504692q;
        if (r104 != r105) goto L25;
        AtomicReferenceFieldUpdater r106 = f504660l;
        b0 r107 = e.f504693r;
    L16:
        if (r106.compareAndSet(this, r105, r107) == true) goto L17;
        if (r106.get(this) == r105) goto L16;
        boolean r108 = false;
    L21:
        if (r108 == false) goto L12;
        r100.invoke(m());
        return;
    L17:
        r108 = true;
        goto L21
    L25:
        if (r104 != e.f504693r) goto L29;
        throw new IllegalStateException("Another handler was already registered and successfully invoked".toString());
    L29:
        throw new IllegalStateException(("Another handler is already registered: " + r104).toString());
    L5:
        r102 = true;
        goto L9
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(expression = "trySend(element).isSuccess", imports = {}))
    public final boolean offer(E r100) {
        return SendChannel.a.b(this, r100);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final Object receive(Continuation<? super E> r110) {
        h<E> r100 = (h) f504657i.get(this);
    L4:
        if (isClosedForReceive() == true) goto L72;
        long r101 = f504653e.getAndIncrement(this);
        long r102 = e.f504677b;
        long r103 = r101 / r102;
        int r111 = (int) (r101 % r102);
        if (r100.f504984c == r103) goto L11;
        h<E> r104 = k(r103, r100);
        if (r104 == null) goto L4;
        h<E> r112 = r104;
    L12:
        Object r105 = K(r112, r111, r101, null);
        b0 r113 = e.f504688m;
        if (r105 == r113) goto L71;
        b0 r114 = e.f504690o;
        if (r105 != r114) goto L21;
        if (r101 >= q()) goto L19;
        r112.b();
    L19:
        r100 = r112;
        goto L4
    L21:
        if (r105 != e.f504689n) goto L68;
        kotlinx.coroutines.j r115 = kotlinx.coroutines.l.a(IntrinsicsKt.intercepted(r110));
        Object r106 = K(r112, r111, r101, r115);     // Catch: Throwable -> L65
        if (r106 != r113) goto L26;
        B();     // Catch: Throwable -> L65
        r115.e(r112, r111);     // Catch: Throwable -> L65
    L62:
        r105 = r115.B();
        if (r105 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L69;
        DebugProbesKt.probeCoroutineSuspended(r110);
    L69:
        return r105;
    L26:
        Function1<Throwable, Unit> r116 = null;
        if (r106 == r114) goto L29;
        r112.b();     // Catch: Throwable -> L65
        Function1<E, Unit> r107 = this.f504662b;     // Catch: Throwable -> L65
        if (r107 == null) goto L61;
        CoroutineContext r108 = r115.getContext();     // Catch: Throwable -> L65
        Object r109 = r106;
        Function1<E, Unit> r117 = r107;
    L59:
        r116 = OnUndeliveredElementKt.a(r117, r109, r108);     // Catch: Throwable -> L65
    L60:
        r106 = r109;
    L61:
        r115.h(r106, r116);     // Catch: Throwable -> L65
        goto L62
    L29:
        if (r101 >= q()) goto L31;
        r112.b();     // Catch: Throwable -> L65
    L31:
        h<E> r118 = (h) f504657i.get(this);     // Catch: Throwable -> L65
    L33:
        if (isClosedForReceive() == true) goto L34;
        long r119 = f504653e.getAndIncrement(this);     // Catch: Throwable -> L65
        long r120 = e.f504677b;     // Catch: Throwable -> L65
        long r121 = r119 / r120;     // Catch: Throwable -> L65
        int r122 = (int) (r119 % r120);     // Catch: Throwable -> L65
        if (r118.f504984c == r121) goto L41;
        h<E> r123 = k(r121, r118);     // Catch: Throwable -> L65
        if (r123 == null) goto L33;
        r118 = r123;
    L41:
        r109 = K(r118, r122, r119, r115);     // Catch: Throwable -> L65
        if (r109 == e.f504688m) goto L43;
        if (r109 != e.f504690o) goto L50;
        if (r119 >= q()) goto L33;
        r118.b();     // Catch: Throwable -> L65
        goto L33
    L50:
        if (r109 == e.f504689n) goto L55;
        r118.b();     // Catch: Throwable -> L65
        r117 = this.f504662b;     // Catch: Throwable -> L65
        if (r117 == null) goto L60;
        r108 = r115.getContext();     // Catch: Throwable -> L65
        goto L59
    L55:
        throw new IllegalStateException("unexpected".toString());     // Catch: Throwable -> L65
    L43:
        B();     // Catch: Throwable -> L65
        r115.e(r118, r122);     // Catch: Throwable -> L65
        goto L62
    L34:
        Result.Companion r124 = Result.Companion;     // Catch: Throwable -> L65
        r115.resumeWith(Result.m9449constructorimpl(ResultKt.createFailure(n())));     // Catch: Throwable -> L65
    L65:
        th = move-exception;
        r115.H();
        throw th;
    L68:
        r112.b();
        goto L69
    L71:
        throw new IllegalStateException("unexpected".toString());
    L11:
        r112 = r100;
        goto L12
    L72:
        Throwable r125 = n();
        int r126 = a0.f504935a;
        throw r125;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @ReplaceWith(expression = "receiveCatching().getOrNull()", imports = {}))
    public final Object receiveOrNull(Continuation<? super E> r100) {
        return ReceiveChannel.DefaultImpls.a(this, r100);
    }

    public final void s(long r100) {
        if ((f504655g.addAndGet(this, r100) & SieveCacheKt.NodeVisitedBit) == 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L8;
        return;
    L8:
        if ((f504655g.get(this) & SieveCacheKt.NodeVisitedBit) == 0) goto L10;
        boolean r102 = true;
    L11:
        if (r102 == true) goto L8;
        return;
    L10:
        r102 = false;
        goto L11
    L5:
        r101 = false;
        goto L6
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    /* JADX INFO: renamed from: trySend-JP2dKIU */
    public Object mo10962trySendJP2dKIU(E r110) {
        long r100 = f504652d.get(this);
        boolean r101 = false;
        if (t(r100, false) == false) goto L5;
        boolean r102 = false;
    L6:
        if (r102 == true) goto L8;
        Object r111 = e.f504685j;
        h r103 = (h) f504656h.get(this);
    L10:
        long r104 = f504652d.getAndIncrement(this);
        long r112 = r104 & 1152921504606846975L;
        boolean r113 = t(r104, r101);
        long r105 = e.f504677b;
        long r106 = r112 / r105;
        int r107 = (int) (r112 % r105);
        if (r103.f504984c == r106) goto L17;
        h r108 = a(this, r106, r103);
        if (r108 == null) goto L14;
        h r109 = r108;
    L18:
        h r114 = r109;
        int r115 = d(this, r109, r107, r110, r112, r111, r113);
        if (r115 == 0) goto L48;
        if (r115 == 1) goto L49;
        if (r115 == 2) goto L38;
        if (r115 == 3) goto L37;
        if (r115 == 4) goto L33;
        if (r115 != 5) goto L31;
        r114.b();
    L31:
        r103 = r114;
        r101 = false;
        goto L10
    L33:
        if (r112 >= o()) goto L35;
        r114.b();
    L35:
        g.c r116 = g.f504696b;
        return new g.a(p());
    L37:
        throw new IllegalStateException("unexpected".toString());
    L38:
        if (r113 == false) goto L41;
        r114.i();
        g.c r117 = g.f504696b;
        return new g.a(p());
    L41:
        if ((r111 instanceof d2) == false) goto L43;
        d2 r118 = (d2) r111;
    L45:
        if (r118 == null) goto L47;
        b(this, r118, r114, r107);
    L47:
        r114.i();
        return g.f504696b;
    L43:
        r118 = null;
    L49:
        g.c r119 = g.f504696b;
        return Unit.INSTANCE;
    L48:
        r114.b();
        goto L49
    L14:
        if (r113 == false) goto L10;
        g.c r120 = g.f504696b;
        return new g.a(p());
    L17:
        r109 = r103;
        goto L18
    L8:
        return g.f504696b;
    L5:
        r102 = !e(r100 & 1152921504606846975L);
        goto L6
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final void cancel(CancellationException r100) {
        f(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [kotlin.jvm.functions.Function1<? super E, kotlin.Unit>, kotlin.jvm.functions.Function1<E, kotlin.Unit>] */
    public BufferedChannel(int r100, Function1<? super E, Unit> r110) {
        this.f504661a = r100;
        this.f504662b = r110;
        if (r100 < 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L24;
        h<Object> r102 = e.f504676a;
        if (r100 != 0) goto L10;
        long r103 = 0;
    L14:
        this.bufferEnd$volatile = r103;
        this.completedExpandBuffersAndPauseFlag$volatile = l();
        h<Object> r104 = new h(0, null, this, 3);
        this.sendSegment$volatile = r104;
        this.receiveSegment$volatile = r104;
        if (v() == false) goto L17;
        r104 = e.f504676a;
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
    L17:
        this.bufferEndSegment$volatile = r104;
        if (r110 == 0) goto L20;
        Function3 r105 = new BufferedChannel$onUndeliveredElementReceiveCancellationConstructor$1$1(this);
    L21:
        this.f504663c = r105;
        this._closeCause$volatile = e.f504694s;
        return;
    L20:
        r105 = null;
        goto L21
    L10:
        if (r100 == Integer.MAX_VALUE) goto L12;
        r103 = r100;
        goto L14
    L12:
        r103 = Long.MAX_VALUE;
        goto L14
    L24:
        throw new IllegalArgumentException(("Invalid channel capacity: " + r100 + ", should be >=0").toString());
    L5:
        r101 = false;
        goto L6
    }

    public static <E> Object C(BufferedChannel<E> r110, Continuation<? super g<? extends E>> r111) {
        if ((r111 instanceof BufferedChannel$receiveCatching$1) == false) goto L7;
        BufferedChannel$receiveCatching$1 r100 = (BufferedChannel$receiveCatching$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        BufferedChannel$receiveCatching$1 r102 = r100;
        Object r112 = r102.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r112);
        Object r113 = ((g) r112).f504697a;
    L52:
        return r113;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        h<E> r105 = (h) f504657i.get(r110);
    L16:
        if (r110.isClosedForReceive() == true) goto L17;
        long r106 = f504653e.getAndIncrement(r110);
        int r107 = e.f504677b;
        long r108 = r106 / ((long) r107);
        int r109 = (int) (r106 % ((long) r107));
        if (r105.f504984c == r108) goto L24;
        h<E> r114 = r110.k(r108, r105);
        if (r114 == null) goto L16;
        h<E> r115 = r114;
    L25:
        Object r116 = r110.K(r115, r109, r106, null);
        if (r116 == e.f504688m) goto L42;
        if (r116 != e.f504690o) goto L34;
        if (r106 >= r110.q()) goto L32;
        r115.b();
    L32:
        r105 = r115;
        goto L16
    L34:
        if (r116 != e.f504689n) goto L39;
        r102.label = 1;
        r113 = r110.D(r115, r109, r106, r102);
        if (r113 != r103) goto L52;
        return r103;
    L39:
        r115.b();
        g.c r117 = g.f504696b;
        return r116;
    L42:
        throw new IllegalStateException("unexpected".toString());
    L24:
        r115 = r105;
        goto L25
    L17:
        g.c r118 = g.f504696b;
        return new g.a(r110.m());
    L7:
        r100 = new BufferedChannel$receiveCatching$1(r110, r111);
        goto L8
    }

    public static final void c(BufferedChannel r110, kotlinx.coroutines.selects.l r111) {
        r110.getClass();
        h<E> r100 = (h) f504657i.get(r110);
    L4:
        if (r110.isClosedForReceive() == true) goto L5;
        long r101 = f504653e.getAndIncrement(r110);
        long r102 = e.f504677b;
        long r103 = r101 / r102;
        int r112 = (int) (r101 % r102);
        if (r100.f504984c == r103) goto L12;
        h<E> r104 = r110.k(r103, r100);
        if (r104 == null) goto L4;
        r100 = r104;
    L12:
        Object r105 = r110.K(r100, r112, r101, r111);
        if (r105 == e.f504688m) goto L15;
        if (r105 != e.f504690o) goto L26;
        if (r101 >= r110.q()) goto L4;
        r100.b();
        goto L4
    L26:
        if (r105 == e.f504689n) goto L30;
        r100.b();
        r111.c(r105);
        return;
    L30:
        throw new IllegalStateException("unexpected".toString());
    L15:
        if ((r111 instanceof d2) == false) goto L17;
        d2 r113 = (d2) r111;
    L18:
        if (r113 == null) goto L42;
        r110.B();
        r113.e(r100, r112);
        return;
    L42:
        return;
    L17:
        r113 = null;
        goto L18
    L5:
        r111.c(e.f504687l);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void E(kotlinx.coroutines.selects.l<?> r110, Object r111) {
        h r100 = (h) f504656h.get(this);
    L3:
        long r101 = f504652d.getAndIncrement(this);
        long r102 = 1152921504606846975L & r101;
        boolean r103 = t(r101, false);
        long r104 = e.f504677b;
        long r105 = r102 / r104;
        int r106 = (int) (r102 % r104);
        if (r100.f504984c == r105) goto L10;
        h r107 = a(this, r105, r100);
        if (r107 == null) goto L7;
        r100 = r107;
        goto L10
    L7:
        if (r103 == false) goto L3;
    L31:
        y(r111, r110);
        return;
    L10:
        int r108 = d(this, r100, r106, r111, r102, r110, r103);
        if (r108 == 0) goto L38;
        if (r108 == 1) goto L39;
        if (r108 == 2) goto L29;
        if (r108 == 3) goto L28;
        if (r108 == 4) goto L25;
        if (r108 != 5) goto L3;
        r100.b();
        goto L3
    L25:
        if (r102 >= o()) goto L31;
        r100.b();
        goto L31
    L28:
        throw new IllegalStateException("unexpected".toString());
    L29:
        if (r103 == false) goto L33;
        r100.i();
        goto L31
    L33:
        if ((r110 instanceof d2) == false) goto L35;
        d2 r112 = (d2) r110;
    L36:
        if (r112 == null) goto L56;
        b(this, r112, r100, r106);
        return;
    L56:
        return;
    L35:
        r112 = null;
    L39:
        r110.c(Unit.INSTANCE);
        return;
    L38:
        r100.b();
        goto L39
    }

    public final void F(d2 r100, boolean r101) {
        if ((r100 instanceof b) == false) goto L6;
        kotlinx.coroutines.i<Boolean> r102 = ((b) r100).f504667a;
        Result.Companion r103 = Result.Companion;
        r102.resumeWith(Result.m9449constructorimpl(Boolean.FALSE));
        return;
    L6:
        if ((r100 instanceof kotlinx.coroutines.i) == false) goto L13;
        Continuation r104 = (Continuation) r100;
        Result.Companion r105 = Result.Companion;
        if (r101 == false) goto L10;
        Throwable r106 = n();
    L11:
        r104.resumeWith(Result.m9449constructorimpl(ResultKt.createFailure(r106)));
        return;
    L10:
        r106 = p();
        goto L11
    L13:
        if ((r100 instanceof l) == false) goto L16;
        kotlinx.coroutines.j<g<? extends E>> r107 = ((l) r100).f504702a;
        Result.Companion r108 = Result.Companion;
        g.c r109 = g.f504696b;
        r107.resumeWith(Result.m9449constructorimpl(new g(new g.a(m()))));
        return;
    L16:
        if ((r100 instanceof a) == false) goto L22;
        a r110 = (a) r100;
        kotlinx.coroutines.j<? super Boolean> r111 = r110.f504665b;
        Intrinsics.checkNotNull(r111);
        r110.f504665b = null;
        r110.f504664a = e.f504687l;
        Throwable r112 = r110.f504666c.m();
        if (r112 != null) goto L20;
        Result.Companion r113 = Result.Companion;
        r111.resumeWith(Result.m9449constructorimpl(Boolean.FALSE));
        return;
    L20:
        Result.Companion r114 = Result.Companion;
        r111.resumeWith(Result.m9449constructorimpl(ResultKt.createFailure(r112)));
        return;
    L22:
        if ((r100 instanceof kotlinx.coroutines.selects.l) == false) goto L26;
        ((kotlinx.coroutines.selects.l) r100).f(this, e.f504687l);
        return;
    L26:
        throw new IllegalStateException(("Unexpected waiter: " + r100).toString());
    }

    public Object G(E r110, Continuation<? super Boolean> r210) {
        kotlinx.coroutines.j r100 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r210), 1);
        r100.C();
        if (this.f504662b != null) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L46;
        b r111 = new b(r100);
        h r102 = (h) f504656h.get(this);
    L8:
        long r103 = f504652d.getAndIncrement(this);
        long r112 = r103 & 1152921504606846975L;
        boolean r113 = t(r103, false);
        long r104 = e.f504677b;
        long r105 = r112 / r104;
        int r106 = (int) (r112 % r104);
        if (r102.f504984c == r105) goto L15;
        h r107 = a(this, r105, r102);
        if (r107 == null) goto L12;
        h r108 = r107;
    L16:
        h r114 = r108;
        int r109 = d(this, r108, r106, r110, r112, r111, r113);
        if (r109 == 0) goto L39;
        if (r109 == 1) goto L40;
        if (r109 == 2) goto L35;
        if (r109 == 3) goto L34;
        if (r109 == 4) goto L31;
        if (r109 != 5) goto L29;
        r114.b();
    L29:
        r102 = r114;
        goto L8
    L31:
        if (r112 >= o()) goto L37;
        r114.b();
    L37:
        Result.Companion r115 = Result.Companion;
        r100.resumeWith(Result.m9449constructorimpl(Boxing.boxBoolean(false)));
    L41:
        Object r116 = r100.B();
        if (r116 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L44;
        DebugProbesKt.probeCoroutineSuspended(r210);
    L44:
        return r116;
    L34:
        throw new IllegalStateException("unexpected".toString());
    L35:
        if (r113 == false) goto L38;
        r114.i();
        goto L37
    L38:
        b(this, r111, r114, r106);
    L40:
        Result.Companion r117 = Result.Companion;
        r100.resumeWith(Result.m9449constructorimpl(Boxing.boxBoolean(true)));
        goto L41
    L39:
        r114.b();
        goto L40
    L12:
        if (r113 == false) goto L8;
    L15:
        r108 = r102;
        goto L16
    L46:
        throw new IllegalStateException("the `onUndeliveredElement` feature is unsupported for `sendBroadcast(e)`".toString());
    L5:
        r101 = false;
        goto L6
    }

    public final boolean I(Object r100, E r101) {
        if ((r100 instanceof kotlinx.coroutines.selects.l) == true) goto L26;
        Function1<Throwable, Unit> r102 = null;
        if ((r100 instanceof l) == false) goto L12;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveCatching<E of kotlinx.coroutines.channels.BufferedChannel>");
        l r103 = (l) r100;
        kotlinx.coroutines.j<g<? extends E>> r104 = r103.f504702a;
        g.c r105 = g.f504696b;
        g r106 = new g(r101);
        Function1<E, Unit> r107 = this.f504662b;
        if (r107 == null) goto L27;
        r102 = OnUndeliveredElementKt.a(r107, r101, r103.f504702a.getContext());
    L27:
        return e.a(r104, r106, r102);
    L12:
        if ((r100 instanceof a) == false) goto L18;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator<E of kotlinx.coroutines.channels.BufferedChannel>");
        a r108 = (a) r100;
        kotlinx.coroutines.j<? super Boolean> r109 = r108.f504665b;
        Intrinsics.checkNotNull(r109);
        r108.f504665b = null;
        r108.f504664a = r101;
        Boolean r110 = Boolean.TRUE;
        Function1<E, Unit> r111 = r108.f504666c.f504662b;
        if (r111 == null) goto L28;
        r102 = OnUndeliveredElementKt.a(r111, r101, r109.getContext());
    L28:
        return e.a(r109, r110, r102);
    L18:
        if ((r100 instanceof kotlinx.coroutines.i) == false) goto L25;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<E of kotlinx.coroutines.channels.BufferedChannel>");
        kotlinx.coroutines.i r112 = (kotlinx.coroutines.i) r100;
        Function1<E, Unit> r113 = this.f504662b;
        if (r113 == null) goto L23;
        r102 = OnUndeliveredElementKt.a(r113, r101, r112.getContext());
    L23:
        return e.a(r112, r101, r102);
    L25:
        throw new IllegalStateException(("Unexpected receiver type: " + r100).toString());
    L26:
        return ((kotlinx.coroutines.selects.l) r100).f(this, r101);
    }

    public final boolean g(Throwable r110, boolean r111) {
        if (r111 == false) goto L9;
        AtomicLongFieldUpdater r112 = f504652d;
    L5:
        long r100 = r112.get(this);
        if (((int) (r100 >> 60)) != 0) goto L9;
        h<Object> r101 = e.f504676a;
        long r102 = ((long) 1) << 60;
        if (r112.compareAndSet(this, r100, r102 + (r100 & 1152921504606846975L)) == false) goto L5;
    L9:
        AtomicReferenceFieldUpdater r103 = f504659k;
        b0 r104 = e.f504694s;
    L11:
        if (r103.compareAndSet(this, r104, r110) == true) goto L12;
        if (r103.get(this) == r104) goto L11;
        boolean r113 = false;
    L17:
        if (r111 == false) goto L22;
        AtomicLongFieldUpdater r114 = f504652d;
    L19:
        long r105 = r114.get(this);
        h<Object> r106 = e.f504676a;
        long r107 = ((long) 3) << 60;
        if (r114.compareAndSet(this, r105, r107 + (r105 & 1152921504606846975L)) == false) goto L19;
    L31:
        isClosedForSend();
        x();
        if (r113 == false) goto L48;
        AtomicReferenceFieldUpdater r108 = f504660l;
    L34:
        Object r109 = r108.get(this);
        if (r109 != null) goto L37;
        b0 r115 = e.f504692q;
    L39:
        if (r108.compareAndSet(this, r109, r115) == true) goto L40;
        if (r108.get(this) == r109) goto L39;
        boolean r116 = false;
    L44:
        if (r116 == false) goto L34;
        if (r109 == null) goto L48;
        Function1 r117 = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r109, 1);
        ((Function1) r109).invoke(m());
        goto L48
    L40:
        r116 = true;
        goto L44
    L37:
        r115 = e.f504693r;
    L48:
        return r113;
    L22:
        AtomicLongFieldUpdater r118 = f504652d;
    L23:
        long r119 = r118.get(this);
        int r120 = (int) (r119 >> 60);
        if (r120 == 0) goto L28;
        if (r120 != 1) goto L31;
        long r121 = r119 & 1152921504606846975L;
        h<Object> r122 = e.f504676a;
        int r123 = 3;
    L30:
        if (r118.compareAndSet(this, r119, (((long) r123) << 60) + r121) == false) goto L23;
    L28:
        r121 = r119 & 1152921504606846975L;
        h<Object> r124 = e.f504676a;
        r123 = 2;
        goto L30
    L12:
        r113 = true;
        goto L17
    }

    public final h<E> k(long r110, h<E> r111) {
        AtomicReferenceFieldUpdater r100 = f504657i;
        h<Object> r101 = e.f504676a;
        BufferedChannelKt$createSegmentFunction$1 r102 = BufferedChannelKt$createSegmentFunction$1.INSTANCE;
    L3:
        Object r103 = kotlinx.coroutines.internal.d.a(r111, r110, r102);
        if (z.b(r103) == true) goto L29;
        y r104 = z.a(r103);
    L6:
        y r105 = (y) r100.get(this);
        if (r105.f504984c >= r104.f504984c) goto L22;
        if (r104.j() == false) goto L11;
    L13:
        if (r100.compareAndSet(this, r105, r104) == true) goto L14;
        if (r100.get(this) == r105) goto L13;
        boolean r106 = false;
    L18:
        if (r106 == true) goto L20;
        if (r104.f() == false) goto L6;
        r104.e();
        goto L6
    L20:
        if (r105.f() == false) goto L22;
        r105.e();
        goto L22
    L14:
        r106 = true;
        goto L18
    L11:
        boolean r107 = false;
    L23:
        if (r107 == false) goto L3;
    L22:
        r107 = true;
    L29:
        if (z.b(r103) == false) goto L33;
        isClosedForSend();
        if ((r111.f504984c * ((long) e.f504677b)) >= q()) goto L66;
        r111.b();
    L66:
        return null;
    L33:
        h<E> r112 = (h) z.a(r103);
        if (v() == false) goto L36;
    L55:
        long r108 = r112.f504984c;
        if (r108 <= r110) goto L96;
        long r109 = r108 * ((long) e.f504677b);
        AtomicLongFieldUpdater r113 = f504653e;
    L58:
        long r114 = r113.get(this);
        if (r114 >= r109) goto L64;
        if (f504653e.compareAndSet(this, r114, r109) == false) goto L58;
    L64:
        if ((r112.f504984c * ((long) e.f504677b)) >= q()) goto L66;
        r112.b();
        goto L66
    L96:
        return r112;
    L36:
        if (r110 > (l() / ((long) e.f504677b))) goto L55;
        AtomicReferenceFieldUpdater r115 = f504658j;
    L38:
        y r116 = (y) r115.get(this);
        if (r116.f504984c >= r112.f504984c) goto L55;
        if (r112.j() == false) goto L55;
    L43:
        if (r115.compareAndSet(this, r116, r112) == true) goto L44;
        if (r115.get(this) == r116) goto L43;
        boolean r117 = false;
    L48:
        if (r117 == true) goto L50;
        if (r112.f() == false) goto L38;
        r112.e();
        goto L38
    L50:
        if (r116.f() == false) goto L55;
        r116.e();
        goto L55
    L44:
        r117 = true;
        goto L48
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [kotlinx.coroutines.j] */
    /* JADX WARN: Type inference failed for: r1v40 */
    /* JADX WARN: Type inference failed for: r1v9 */
    @Override // kotlinx.coroutines.channels.SendChannel
    public Object send(E r210, Continuation<? super Unit> r211) {
        h r100 = (h) f504656h.get(this);
    L3:
        long r101 = f504652d.getAndIncrement(this);
        long r110 = r101 & 1152921504606846975L;
        boolean r111 = t(r101, false);
        long r102 = e.f504677b;
        long r103 = r110 / r102;
        int r104 = (int) (r110 % r102);
        if (r100.f504984c == r103) goto L12;
        h r105 = a(this, r103, r100);
        if (r105 == null) goto L7;
        h r106 = r105;
    L13:
        h r112 = r106;
        int r107 = d(this, r106, r104, r210, r110, null, r111);
        if (r107 == 0) goto L104;
        if (r107 == 1) goto L106;
        if (r107 == 2) goto L100;
        if (r107 == 3) goto L32;
        if (r107 == 4) goto L27;
        if (r107 != 5) goto L25;
        r112.b();
    L25:
        r100 = r112;
        goto L3
    L27:
        if (r110 >= o()) goto L29;
        r112.b();
    L29:
        Object r108 = z(r210, r211);
        if (r108 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L106;
        return r108;
    L32:
        BufferedChannel<E> r109 = this;
        kotlinx.coroutines.j r113 = kotlinx.coroutines.l.a(IntrinsicsKt.intercepted(r211));
        int r114 = d(r109, r112, r104, r210, r110, r113, false);     // Catch: Throwable -> L95
        if (r114 == 0) goto L83;
        if (r114 == 1) goto L68;
        if (r114 == 2) goto L82;
        if (r114 != 4) goto L39;
        r113 = r113;
        if (r110 >= o()) goto L76;
        r112.b();     // Catch: Throwable -> L79
    L76:
        Function1<E, Unit> r115 = this.f504662b;     // Catch: Throwable -> L79
        if (r115 == null) goto L81;
        OnUndeliveredElementKt.b(r115, r210, r113.getContext());     // Catch: Throwable -> L79
    L81:
        Throwable r116 = p();     // Catch: Throwable -> L79
        Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L79
        r113.resumeWith(Result.m9449constructorimpl(ResultKt.createFailure(r116)));     // Catch: Throwable -> L79
    L85:
        Object r118 = r113.B();
        if (r118 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L89;
        DebugProbesKt.probeCoroutineSuspended(r211);
    L89:
        if (r118 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L93;
        r118 = Unit.INSTANCE;
    L93:
        if (r118 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L106;
        return r118;
    L39:
        if (r114 != 5) goto L72;
        r112.b();     // Catch: Throwable -> L95
        h r119 = (h) f504656h.get(this);     // Catch: Throwable -> L95
    L41:
        long r120 = f504652d.getAndIncrement(this);     // Catch: Throwable -> L95
        long r212 = r120 & 1152921504606846975L;     // Catch: Throwable -> L95
        boolean r121 = t(r120, false);     // Catch: Throwable -> L95
        long r122 = e.f504677b;     // Catch: Throwable -> L95
        long r123 = r212 / r122;     // Catch: Throwable -> L95
        int r124 = (int) (r212 % r122);     // Catch: Throwable -> L95
        if (r119.f504984c == r123) goto L48;
        h r125 = a(this, r123, r119);     // Catch: Throwable -> L95
        if (r125 == null) goto L45;
        r119 = r125;
        goto L48
    L45:
        if (r121 == false) goto L41;
    L65:
        r113 = r113;
    L48:
        int r126 = d(this, r119, r124, r210, r212, r113, r121);     // Catch: Throwable -> L95
        if (r126 == 0) goto L69;
        if (r126 == 1) goto L68;
        if (r126 == 2) goto L63;
        if (r126 == 3) goto L62;
        if (r126 == 4) goto L59;
        if (r126 != 5) goto L41;
        r119.b();     // Catch: Throwable -> L95
        goto L41
    L59:
        if (r212 >= o()) goto L65;
        r119.b();     // Catch: Throwable -> L95
        goto L65
    L62:
        throw new IllegalStateException("unexpected".toString());     // Catch: Throwable -> L95
    L63:
        if (r121 == false) goto L66;
        r119.i();     // Catch: Throwable -> L95
        goto L65
    L66:
        r113 = r113;
        b(this, r113, r119, r124);     // Catch: Throwable -> L79
        goto L85
    L69:
        r119.b();     // Catch: Throwable -> L79
    L70:
        Result.Companion r127 = Result.Companion;     // Catch: Throwable -> L79
    L84:
        r113.resumeWith(Result.m9449constructorimpl(Unit.INSTANCE));     // Catch: Throwable -> L79
        goto L85
    L72:
        throw new IllegalStateException("unexpected".toString());     // Catch: Throwable -> L79
    L82:
        r113 = r113;
        b(this, r113, r112, r104);     // Catch: Throwable -> L79
    L68:
        r113 = r113;
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L79
        goto L84
    L83:
        r112.b();     // Catch: Throwable -> L79
    L79:
        th = th;
        ?? r129 = r109;
    L97:
        r129.H();
        throw th;
    L95:
        th = th;
        r129 = r113;
        goto L97
    L100:
        if (r111 == false) goto L106;
        r112.i();
        Object r130 = z(r210, r211);
        if (r130 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L106;
        return r130;
    L106:
        return Unit.INSTANCE;
    L104:
        r112.b();
        goto L106
    L7:
        if (r111 == false) goto L3;
        Object r131 = z(r210, r211);
        if (r131 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L106;
        return r131;
    L12:
        r106 = r100;
        goto L13
    }

    public final boolean t(long r110, boolean r111) {
        int r100 = (int) (r110 >> 60);
        if (r100 != 0) goto L5;
        return false;
    L5:
        if (r100 != 1) goto L7;
        return false;
    L7:
        if (r100 != 2) goto L9;
        h(r110 & 1152921504606846975L);
        if (r111 == true) goto L73;
    L74:
        return true;
    L73:
        if (r() == false) goto L74;
        return false;
    L9:
        if (r100 != 3) goto L69;
        h<E> r112 = h(r110 & 1152921504606846975L);
        Function1<E, Unit> r113 = this.f504662b;
        UndeliveredElementException r101 = null;
        Object r102 = null;
    L11:
        int r103 = e.f504677b - 1;
    L12:
        if ((-1) >= r103) goto L56;
        long r104 = (r112.f504984c * ((long) e.f504677b)) + ((long) r103);
    L14:
        Object r105 = r112.l(r103);
        if (r105 == e.f504684i) goto L58;
        if (r105 == e.f504679d) goto L19;
        if (r105 == e.f504680e) goto L53;
        if (r105 == null) goto L53;
        if ((r105 instanceof d2) == true) goto L42;
        if ((r105 instanceof n) == true) goto L42;
        b0 r106 = e.f504682g;
        if (r105 == r106) goto L58;
        if (r105 == e.f504681f) goto L58;
        if (r105 == r106) goto L14;
    L55:
        r103 = r103 - 1;
    L42:
        if (r104 < o()) goto L58;
        if ((r105 instanceof n) == false) goto L46;
        d2 r107 = ((n) r105).f504703a;
    L48:
        if (r112.k(r103, r105, e.f504687l) == false) goto L14;
        if (r113 == null) goto L51;
        r101 = OnUndeliveredElementKt.c(r113, r112.f504700f.get(r103 * 2), r101);
    L51:
        r102 = kotlinx.coroutines.internal.k.a(r102, r107);
        r112.n(r103, null);
        r112.i();
        goto L55
    L46:
        r107 = (d2) r105;
    L53:
        if (r112.k(r103, r105, e.f504687l) == false) goto L14;
        r112.i();
        goto L55
    L19:
        if (r104 < o()) goto L58;
        if (r112.k(r103, r105, e.f504687l) == false) goto L14;
        if (r113 == null) goto L24;
        r101 = OnUndeliveredElementKt.c(r113, r112.f504700f.get(r103 * 2), r101);
    L24:
        r112.n(r103, null);
        r112.i();
    L58:
        if (r102 != null) goto L60;
    L65:
        if (r101 == null) goto L74;
        throw r101;
    L60:
        if ((r102 instanceof ArrayList) == true) goto L62;
        F((d2) r102, false);
        goto L65
    L62:
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
        ArrayList r108 = (ArrayList) r102;
        int r114 = r108.size() - 1;
    L63:
        if ((-1) >= r114) goto L65;
        F((d2) ListProtector.get(r108, r114), false);
        r114 = r114 - 1;
        goto L63
    L56:
        r112 = (h) ((kotlinx.coroutines.internal.e) kotlinx.coroutines.internal.e.f504942b.get(r112));
        if (r112 != null) goto L11;
    L69:
        throw new IllegalStateException(("unexpected close status: " + r100).toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void w(long r100, h<E> r101) {
    L3:
        if (r101.f504984c >= r100) goto L9;
        h<E> r102 = (h) r101.c();
        if (r102 == null) goto L9;
        r101 = r102;
    L9:
        if (r101.d() == false) goto L14;
        h<E> r103 = (h) r101.c();
        if (r103 == null) goto L14;
        r101 = r103;
    L14:
        AtomicReferenceFieldUpdater r104 = f504658j;
    L15:
        y r105 = (y) r104.get(this);
        boolean r106 = true;
        if (r105.f504984c >= r101.f504984c) goto L30;
        boolean r107 = false;
        if (r101.j() == false) goto L20;
    L22:
        if (r104.compareAndSet(this, r105, r101) == true) goto L23;
        if (r104.get(this) == r105) goto L22;
    L26:
        if (r107 == true) goto L28;
        if (r101.f() == false) goto L15;
        r101.e();
        goto L15
    L28:
        if (r105.f() == false) goto L30;
        r105.e();
        goto L30
    L23:
        r107 = true;
        goto L26
    L20:
        r106 = false;
    L30:
        if (r106 == false) goto L9;
    }

    public final void y(E r100, kotlinx.coroutines.selects.l<?> r101) {
        Function1<E, Unit> r102 = this.f504662b;
        if (r102 == null) goto L5;
        OnUndeliveredElementKt.b(r102, r100, r101.getContext());
    L5:
        r101.c(e.f504687l);
    }

    public final Object z(E r100, Continuation<? super Unit> r101) {
        kotlinx.coroutines.j r102 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r101), 1);
        r102.C();
        Function1<E, Unit> r103 = this.f504662b;
        if (r103 == null) goto L7;
        UndeliveredElementException r104 = OnUndeliveredElementKt.c(r103, r100, null);
        if (r104 == null) goto L7;
        ExceptionsKt.addSuppressed(r104, p());
        Result.Companion r105 = Result.Companion;
        r102.resumeWith(Result.m9449constructorimpl(ResultKt.createFailure(r104)));
    L8:
        Object r106 = r102.B();
        if (r106 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L12;
        DebugProbesKt.probeCoroutineSuspended(r101);
    L12:
        if (r106 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L15;
        return r106;
    L15:
        return Unit.INSTANCE;
    L7:
        Throwable r107 = p();
        Result.Companion r108 = Result.Companion;
        r102.resumeWith(Result.m9449constructorimpl(ResultKt.createFailure(r107)));
        goto L8
    }

    public static final h a(BufferedChannel r110, long r111, h r112) {
        r110.getClass();
        AtomicReferenceFieldUpdater r100 = f504656h;
        h<Object> r101 = e.f504676a;
        BufferedChannelKt$createSegmentFunction$1 r102 = BufferedChannelKt$createSegmentFunction$1.INSTANCE;
    L3:
        Object r103 = kotlinx.coroutines.internal.d.a(r112, r111, r102);
        if (z.b(r103) == true) goto L27;
        y r104 = z.a(r103);
    L6:
        y r105 = (y) r100.get(r110);
        boolean r106 = true;
        if (r105.f504984c >= r104.f504984c) goto L21;
        boolean r107 = false;
        if (r104.j() == false) goto L11;
    L13:
        if (r100.compareAndSet(r110, r105, r104) == true) goto L14;
        if (r100.get(r110) == r105) goto L13;
    L17:
        if (r107 == true) goto L19;
        if (r104.f() == false) goto L6;
        r104.e();
        goto L6
    L19:
        if (r105.f() == false) goto L21;
        r105.e();
        goto L21
    L14:
        r107 = true;
        goto L17
    L11:
        r106 = false;
    L21:
        if (r106 == false) goto L3;
    L27:
        if (z.b(r103) == false) goto L31;
        r110.isClosedForSend();
        if ((r112.f504984c * ((long) e.f504677b)) >= r110.o()) goto L42;
        r112.b();
    L42:
        return null;
    L31:
        h r113 = (h) z.a(r103);
        long r108 = r113.f504984c;
        if (r108 <= r111) goto L63;
        long r109 = r108 * ((long) e.f504677b);
        AtomicLongFieldUpdater r114 = f504652d;
    L34:
        long r115 = r114.get(r110);
        long r116 = 1152921504606846975L & r115;
        if (r116 >= r109) goto L40;
        int r117 = (int) (r115 >> 60);
        h<Object> r118 = e.f504676a;
        long r119 = (((long) r117) << 60) + r116;
        if (f504652d.compareAndSet(r110, r115, r119) == false) goto L34;
    L40:
        if ((r113.f504984c * ((long) e.f504677b)) >= r110.o()) goto L42;
        r113.b();
        goto L42
    L63:
        return r113;
    }

    public final boolean J(Object r100, h<E> r101, int r102) {
        if ((r100 instanceof kotlinx.coroutines.i) == false) goto L6;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
        return e.a((kotlinx.coroutines.i) r100, Unit.INSTANCE, null);
    L6:
        if ((r100 instanceof kotlinx.coroutines.selects.l) == false) goto L15;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
        TrySelectDetailedResult r103 = ((SelectImplementation) r100).l(this, Unit.INSTANCE);
        if (r103 != TrySelectDetailedResult.REREGISTER) goto L11;
        r101.n(r102, null);
    L11:
        if (r103 != TrySelectDetailedResult.SUCCESSFUL) goto L13;
        return true;
    L13:
        return false;
    L15:
        if ((r100 instanceof b) == false) goto L19;
        return e.a(((b) r100).f504667a, Boolean.TRUE, null);
    L19:
        throw new IllegalStateException(("Unexpected waiter: " + r100).toString());
    }

    public static final void b(BufferedChannel r100, d2 r101, h r102, int r103) {
        r100.getClass();
        r101.e(r102, r103 + e.f504677b);
    }

    public final Object D(h<E> r110, int r111, long r112, Continuation<? super g<? extends E>> r113) {
        if ((r113 instanceof BufferedChannel$receiveCatchingOnNoWaiterSuspend$1) == false) goto L7;
        BufferedChannel$receiveCatchingOnNoWaiterSuspend$1 r100 = (BufferedChannel$receiveCatchingOnNoWaiterSuspend$1) r113;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r114 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        h r115 = (h) r100.L$1;
        BufferedChannel r116 = (BufferedChannel) r100.L$0;
        ResultKt.throwOnFailure(r114);
    L59:
        return ((g) r114).f504697a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r114);
        r100.L$0 = this;
        r100.L$1 = r110;
        r100.I$0 = r111;
        r100.J$0 = r112;
        r100.label = 1;
        kotlinx.coroutines.j r117 = kotlinx.coroutines.l.a(IntrinsicsKt.intercepted(r100));
        Intrinsics.checkNotNull(r117, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuationImpl<kotlinx.coroutines.channels.ChannelResult<E of kotlinx.coroutines.channels.BufferedChannel.receiveCatchingOnNoWaiterSuspend_GKJJFZk$lambda$38>>");     // Catch: Throwable -> L60
        l r104 = new l(r117);     // Catch: Throwable -> L60
        Object r105 = K(r110, r111, r112, r104);     // Catch: Throwable -> L60
        if (r105 != e.f504688m) goto L18;
        B();     // Catch: Throwable -> L60
        r104.e(r110, r111);     // Catch: Throwable -> L60
    L53:
        r114 = r117.B();
        if (r114 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L56;
        DebugProbesKt.probeCoroutineSuspended(r100);
    L56:
        if (r114 != r102) goto L59;
        return r102;
    L18:
        Function1<Throwable, Unit> r106 = null;
        if (r105 == e.f504690o) goto L21;
        r110.b();     // Catch: Throwable -> L60
        g.c r118 = g.f504696b;     // Catch: Throwable -> L60
        g r119 = new g(r105);     // Catch: Throwable -> L60
        Function1<E, Unit> r120 = this.f504662b;     // Catch: Throwable -> L60
        if (r120 != null) goto L51;
    L46:
        r117.h(r119, r106);     // Catch: Throwable -> L60
        goto L53
    L51:
        r106 = OnUndeliveredElementKt.a(r120, r105, r117.getContext());     // Catch: Throwable -> L60
        goto L46
    L21:
        if (r112 >= q()) goto L23;
        r110.b();     // Catch: Throwable -> L60
    L23:
        h<E> r121 = (h) f504657i.get(this);     // Catch: Throwable -> L60
    L25:
        if (isClosedForReceive() == true) goto L26;
        long r122 = f504653e.getAndIncrement(this);     // Catch: Throwable -> L60
        int r123 = e.f504677b;     // Catch: Throwable -> L60
        long r107 = r122 / ((long) r123);     // Catch: Throwable -> L60
        int r124 = (int) (r122 % ((long) r123));     // Catch: Throwable -> L60
        if (r121.f504984c == r107) goto L33;
        h<E> r108 = k(r107, r121);     // Catch: Throwable -> L60
        if (r108 == null) goto L25;
        r121 = r108;
    L33:
        Object r109 = K(r121, r124, r122, r104);     // Catch: Throwable -> L60
        if (r109 == e.f504688m) goto L35;
        if (r109 != e.f504690o) goto L42;
        if (r122 >= q()) goto L25;
        r121.b();     // Catch: Throwable -> L60
        goto L25
    L42:
        if (r109 == e.f504689n) goto L48;
        r121.b();     // Catch: Throwable -> L60
        g.c r125 = g.f504696b;     // Catch: Throwable -> L60
        r119 = new g(r109);     // Catch: Throwable -> L60
        Function1<E, Unit> r126 = this.f504662b;     // Catch: Throwable -> L60
        if (r126 == null) goto L46;
        r106 = OnUndeliveredElementKt.a(r126, r109, r117.getContext());     // Catch: Throwable -> L60
        goto L46
    L48:
        throw new IllegalStateException("unexpected".toString());     // Catch: Throwable -> L60
    L35:
        B();     // Catch: Throwable -> L60
        r104.e(r121, r124);     // Catch: Throwable -> L60
        goto L53
    L26:
        Result.Companion r127 = Result.Companion;     // Catch: Throwable -> L60
        g.c r128 = g.f504696b;     // Catch: Throwable -> L60
        r117.resumeWith(Result.m9449constructorimpl(new g(new g.a(m()))));     // Catch: Throwable -> L60
    L60:
        th = move-exception;
        r117.H();
        throw th;
    L7:
        r100 = new BufferedChannel$receiveCatchingOnNoWaiterSuspend$1(this, r113);
        goto L8
    }

    public final Object K(h<E> r100, int r101, long r110, Object r111) {
        Object r102 = r100.l(r101);
        if (r102 != null) goto L14;
        if (r110 < (f504652d.get(this) & 1152921504606846975L)) goto L19;
        if (r111 != null) goto L10;
        return e.f504689n;
    L10:
        if (r100.k(r101, r102, r111) == false) goto L19;
        j();
        return e.f504688m;
    L19:
        Object r103 = r100.l(r101);
        if (r103 == null) goto L53;
        if (r103 == e.f504680e) goto L53;
        if (r103 == e.f504679d) goto L27;
        b0 r104 = e.f504685j;
        if (r103 == r104) goto L87;
        if (r103 == e.f504683h) goto L88;
        if (r103 == e.f504687l) goto L37;
        if (r103 == e.f504682g) goto L19;
        if (r100.k(r101, r103, e.f504681f) == false) goto L19;
        boolean r112 = r103 instanceof n;
        if (r112 == false) goto L46;
        r103 = ((n) r103).f504703a;
    L46:
        if (J(r103, r100, r101) == false) goto L48;
        r100.o(r101, e.f504684i);
        j();
        Object r113 = r100.f504700f.get(r101 * 2);
        r100.n(r101, null);
        return r113;
    L48:
        r100.o(r101, r104);
        r100.m(r101, false);
        if (r112 == false) goto L91;
        j();
    L91:
        return e.f504690o;
    L37:
        j();
        return e.f504690o;
    L88:
        return e.f504690o;
    L87:
        return e.f504690o;
    L27:
        if (r100.k(r101, r103, e.f504684i) == false) goto L19;
        j();
        Object r114 = r100.f504700f.get(r101 * 2);
        r100.n(r101, null);
        return r114;
    L53:
        if (r110 < (f504652d.get(this) & 1152921504606846975L)) goto L55;
        if (r111 == null) goto L93;
        if (r100.k(r101, r103, r111) == false) goto L19;
        j();
        return e.f504688m;
    L93:
        return e.f504689n;
    L55:
        if (r100.k(r101, r103, e.f504683h) == false) goto L19;
        j();
        return e.f504690o;
    L14:
        if (r102 != e.f504679d) goto L19;
        if (r100.k(r101, r102, e.f504684i) == false) goto L19;
        j();
        Object r115 = r100.f504700f.get(r101 * 2);
        r100.n(r101, null);
        return r115;
    }

    public final int L(h<E> r100, int r101, E r102, long r110, Object r111, boolean r112) {
    L2:
        Object r103 = r100.l(r101);
        if (r103 == null) goto L5;
        if (r103 != e.f504680e) goto L27;
        if (r100.k(r101, r103, e.f504679d) == false) goto L2;
        return 1;
    L27:
        b0 r113 = e.f504686k;
        if (r103 != r113) goto L32;
        r100.n(r101, null);
        return 5;
    L32:
        if (r103 != e.f504683h) goto L36;
        r100.n(r101, null);
        return 5;
    L36:
        if (r103 != e.f504687l) goto L39;
        r100.n(r101, null);
        isClosedForSend();
        return 4;
    L39:
        r100.n(r101, null);
        if ((r103 instanceof n) == false) goto L43;
        r103 = ((n) r103).f504703a;
    L43:
        if (I(r103, r102) == false) goto L46;
        r100.o(r101, e.f504684i);
        A();
        return 0;
    L46:
        if (r100.f504700f.getAndSet((r101 * 2) + 1, r113) == r113) goto L48;
        r100.m(r101, true);
    L48:
        return 5;
    L5:
        if (e(r110) == false) goto L10;
        if (r112 == true) goto L10;
        if (r100.k(r101, null, e.f504679d) == false) goto L2;
        return 1;
    L10:
        if (r112 == true) goto L12;
        if (r111 == null) goto L16;
        if (r100.k(r101, null, r111) == false) goto L2;
        return 2;
    L16:
        return 3;
    L12:
        if (r100.k(r101, null, e.f504685j) == false) goto L2;
        r100.m(r101, false);
        return 4;
    }

    public static final int d(BufferedChannel r100, h r101, int r102, Object r103, long r104, Object r110, boolean r111) {
        r100.getClass();
        r101.n(r102, r103);
        if (r111 == true) goto L28;
        Object r105 = r101.l(r102);
        if (r105 != null) goto L18;
        if (r100.e(r104) == true) goto L10;
        if (r110 != null) goto L15;
        return 3;
    L15:
        if (r101.k(r102, null, r110) == false) goto L27;
        return 2;
    L27:
        return r100.L(r101, r102, r103, r104, r110, r111);
    L10:
        if (r101.k(r102, null, e.f504679d) == false) goto L27;
        return 1;
    L18:
        if ((r105 instanceof d2) == false) goto L27;
        r101.n(r102, null);
        if (r100.I(r105, r103) == false) goto L22;
        r101.o(r102, e.f504684i);
        r100.A();
        return 0;
    L22:
        b0 r106 = e.f504686k;
        if (r101.f504700f.getAndSet((r102 * 2) + 1, r106) == r106) goto L25;
        r101.m(r102, true);
    L25:
        return 5;
    L28:
        return r100.L(r101, r102, r103, r104, r110, r111);
    }
}
