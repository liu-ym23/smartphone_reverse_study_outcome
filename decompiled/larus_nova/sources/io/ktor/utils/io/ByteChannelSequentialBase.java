package io.ktor.utils.io;

import com.amap.api.maps.MapsInitializer;
import io.ktor.utils.io.core.internal.UTF8Kt;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes41.dex */
public abstract class ByteChannelSequentialBase implements b, ByteReadChannel, d, t, n, o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f492003b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f492004c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f492005d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f492006e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f492007f = null;
    private volatile /* synthetic */ int _availableForRead;
    private volatile /* synthetic */ Object _closed;
    private volatile /* synthetic */ Object _lastReadView;
    private volatile /* synthetic */ long _totalBytesRead;
    private volatile /* synthetic */ long _totalBytesWritten;
    private volatile /* synthetic */ int channelSize;
    private volatile /* synthetic */ int lastReadAvailable$delegate;
    private volatile /* synthetic */ Object lastReadView$delegate;

    public static final class a implements w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ByteChannelSequentialBase f492008a;

        public a(ByteChannelSequentialBase r100) {
            this.f492008a = r100;
        }

        @Override // io.ktor.utils.io.v
        public final io.ktor.utils.io.core.internal.a a(int r100) {
            if (this.f492008a.T() != 0) goto L5;
            return null;
        L5:
            this.f492008a.getClass();
            throw null;
        }

        @Override // io.ktor.utils.io.v
        public final void b(int r100) {
            this.f492008a.getClass();
            throw null;
        }

        @Override // io.ktor.utils.io.w
        public final Object c(int r100, ContinuationImpl r101) {
            if (this.f492008a.T() >= r100) goto L10;
            Unit r102 = this.f492008a.P(r100, r101);
            if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
            return r102;
        L8:
            return Unit.INSTANCE;
        L10:
            return Unit.INSTANCE;
        }
    }

    static {
        f492003b = AtomicLongFieldUpdater.newUpdater(ByteChannelSequentialBase.class, "_totalBytesRead");
        f492004c = AtomicLongFieldUpdater.newUpdater(ByteChannelSequentialBase.class, "_totalBytesWritten");
        f492005d = AtomicIntegerFieldUpdater.newUpdater(ByteChannelSequentialBase.class, "_availableForRead");
        f492006e = AtomicIntegerFieldUpdater.newUpdater(ByteChannelSequentialBase.class, "channelSize");
        f492007f = AtomicReferenceFieldUpdater.newUpdater(ByteChannelSequentialBase.class, Object.class, "_closed");
    }

    @Override // io.ktor.utils.io.d
    public final Object A(byte r100, ContinuationImpl r101) {
        return d0(this, r100, r101);
    }

    @Override // io.ktor.utils.io.n
    public final t H() {
        return this;
    }

    @Override // io.ktor.utils.io.d
    public final boolean J() {
        return false;
    }

    @Override // io.ktor.utils.io.d
    public final Object l(io.ktor.utils.io.core.k r100, ContinuationImpl r101) {
        return i0(this, r100, r101);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object n(Continuation r100) {
        return a0(this, Integer.MAX_VALUE, r100);
    }

    @Override // io.ktor.utils.io.d
    public final Object o(short r100, ContinuationImpl r101) {
        return j0(this, r100, r101);
    }

    @Override // io.ktor.utils.io.d
    public final Object q(long r100, ContinuationImpl r101) {
        return h0(this, r100, r101);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object r(byte[] r100, int r101, int r102, ContinuationImpl r103) {
        return W(this, r100, r101, r102, r103);
    }

    @Override // io.ktor.utils.io.d
    public final Object t(byte[] r100, int r101, int r102, Continuation<? super Unit> r103) {
        return f0(this, r100, r101, r102, r103);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object u(byte[] r100, int r101, ContinuationImpl r102) {
        return X(this, r100, r101, r102);
    }

    @Override // io.ktor.utils.io.d
    public final Object v(int r100, Continuation<? super Unit> r101) {
        return g0(this, r100, r101);
    }

    @Override // io.ktor.utils.io.d
    public final Object y(io.ktor.utils.io.core.a r100, ContinuationImpl r101) {
        return e0(this, r100, r101);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final boolean E() {
        i r100 = (i) this._closed;
        if (r100 == null) goto L5;
        Throwable r101 = r100.f492059a;
    L7:
        if (r101 == null) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L12;
        return true;
    L12:
        if (U() == true) goto L14;
    L16:
        return false;
    L14:
        if (this.channelSize != 0) goto L16;
        return true;
    L9:
        r102 = false;
        goto L10
    L5:
        r101 = null;
        goto L7
    }

    @Override // io.ktor.utils.io.o
    public final w L() {
        return new a(this);
    }

    public final void N() {
        boolean r100 = false;
        f492006e.getAndAdd(this, 0);
        f492004c.addAndGet(this, 0);
        if (this.channelSize < 0) goto L5;
        r100 = true;
    L5:
        if (r100 == false) goto L14;
        if (U() == false) goto L9;
        throw null;
    L9:
        if (T() == 0) goto L11;
        return;
    L11:
        throw null;
    L14:
        throw new IllegalStateException(("Readable bytes count is negative: " + this.channelSize + ", 0 in " + this).toString());
    }

    public final void S() {
        io.ktor.utils.io.core.internal.a r100 = (io.ktor.utils.io.core.internal.a) this.lastReadView$delegate;
        int r101 = r100.f492022c - r100.f492021b;
        int r102 = this.lastReadAvailable$delegate - r101;
        io.ktor.utils.io.core.internal.a r103 = (io.ktor.utils.io.core.internal.a) this.lastReadView$delegate;
        int r104 = io.ktor.utils.io.core.a.f492019g;
        io.ktor.utils.io.core.internal.a r105 = io.ktor.utils.io.core.internal.a.f492030m;
        if (r103 != r105) goto L9;
        if (r102 > 0) goto L7;
        this.lastReadAvailable$delegate = 0;
        AtomicReferenceFieldUpdater r106 = io.ktor.utils.io.core.internal.a.f492027j;
        this.lastReadView$delegate = r105;
        return;
    L7:
        M(r102);
        throw null;
    L9:
        io.ktor.utils.io.core.internal.c.a(null, (io.ktor.utils.io.core.internal.a) this.lastReadView$delegate);
        throw null;
    }

    public final int T() {
        return Math.max(0, 4088 - this.channelSize);
    }

    public final boolean U() {
        if (this._closed == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.d
    public final Throwable d() {
        i r100 = (i) this._closed;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f492059a;
    }

    @Override // io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.d
    public final boolean c() {
        return U();
    }

    @Override // io.ktor.utils.io.n
    public final void C() {
        S();
    }

    @Override // io.ktor.utils.io.d
    public final void flush() {
        throw null;
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final int w() {
        return this._availableForRead;
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object F(Continuation<? super Integer> r100) {
        throw null;
    }

    @Override // io.ktor.utils.io.o
    public final void G(int r100) {
        throw null;
    }

    public final void M(int r100) {
        boolean r101 = false;
        if (r100 < 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L24;
        int r103 = -r100;
        f492006e.getAndAdd(this, r103);
        f492003b.addAndGet(this, r100);
        f492005d.getAndAdd(this, r103);
        if (this.channelSize < 0) goto L10;
        boolean r104 = true;
    L12:
        if (r104 == false) goto L22;
        if (this._availableForRead < 0) goto L16;
        r101 = true;
    L16:
        if (r101 == false) goto L20;
        throw null;
    L20:
        throw new IllegalStateException(("Readable bytes count is negative: " + this._availableForRead + ", " + r100 + " in " + this).toString());
    L22:
        throw new IllegalStateException(("Readable bytes count is negative: " + this._availableForRead + ", " + r100 + " in " + this).toString());
    L10:
        r104 = false;
        goto L12
    L24:
        throw new IllegalArgumentException(("Can't read negative amount of bytes: " + r100).toString());
    L5:
        r102 = false;
        goto L6
    }

    @Override // io.ktor.utils.io.r
    public final io.ktor.utils.io.core.internal.a a(int r100) {
        Throwable r101 = d();
        if (r101 == null) goto L5;
        throw r101;
    L5:
        S();
        throw null;
    }

    @Override // io.ktor.utils.io.r
    public final int b(int r100) {
        Throwable r101 = d();
        if (r101 != null) goto L9;
        if (r100 != 0) goto L8;
        return 0;
    L8:
        throw null;
    L9:
        throw r101;
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final boolean cancel(Throwable r100) {
        if (d() == null) goto L5;
        return false;
    L5:
        if (U() == true) goto L13;
        if (r100 != null) goto L9;
        r100 = new CancellationException("Channel cancelled");
    L9:
        close(r100);
        return false;
    L13:
        return false;
    }

    @Override // io.ktor.utils.io.d
    public final boolean close(Throwable r100) {
        if (r100 != null) goto L4;
        i r101 = j.f492103a;
    L5:
        AtomicReferenceFieldUpdater r102 = f492007f;
    L7:
        if (r102.compareAndSet(this, null, r101) == true) goto L8;
        if (r102.get(this) == null) goto L7;
        boolean r103 = false;
    L12:
        if (r103 == true) goto L14;
        return false;
    L14:
        if (r100 == null) goto L16;
        throw null;
    L16:
        throw null;
    L8:
        r103 = true;
        goto L12
    L4:
        r101 = new i(r100);
        goto L5
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object j(Continuation<? super Long> r100) {
        throw null;
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object s(Continuation<? super Short> r100) {
        throw null;
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object z(Continuation<? super Byte> r100) {
        throw null;
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object D(io.ktor.utils.io.core.internal.a r100, ContinuationImpl r101) {
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type io.ktor.utils.io.core.Buffer");
        return V(r100, r101);
    }

    public final Unit O(final int r100, Continuation r101) {
        if ((r101 instanceof ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1) == false) goto L7;
        ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1 r102 = (ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        r100 = r102.I$0;
        final ByteChannelSequentialBase r106 = (ByteChannelSequentialBase) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L16:
        if (r106._availableForRead >= r100) goto L23;
        if (r106.E() == true) goto L23;
        new ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$2(r106, r100);
        r102.L$0 = r106;
        r102.I$0 = r100;
        r102.label = 1;
        throw null;
    L23:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        r106 = this;
    L7:
        r102 = new ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1(this, r101);
        goto L8
    }

    public final Unit P(int r100, Continuation r101) {
        if ((r101 instanceof ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1) == false) goto L7;
        ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1 r102 = (ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 != 0) goto L11;
        ResultKt.throwOnFailure(r104);
        ByteChannelSequentialBase r106 = this;
    L17:
        if (r106.T() >= r100) goto L24;
        if (r106.U() == true) goto L24;
        throw null;
    L24:
        return Unit.INSTANCE;
    L11:
        if (r105 != 1) goto L14;
        r100 = r102.I$0;
        r106 = (ByteChannelSequentialBase) r102.L$0;
        ResultKt.throwOnFailure(r104);
        goto L17
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r102 = new ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1(this, r101);
        goto L8
    }

    public final Object Q(int r100, Continuation<? super Boolean> r101) {
        if ((r101 instanceof ByteChannelSequentialBase$awaitSuspend$1) == false) goto L7;
        ByteChannelSequentialBase$awaitSuspend$1 r102 = (ByteChannelSequentialBase$awaitSuspend$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L12;
        ByteChannelSequentialBase r107 = (ByteChannelSequentialBase) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L23:
        r107.getClass();
        throw null;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        if (r100 < 0) goto L17;
        boolean r108 = true;
    L18:
        if (r108 == false) goto L26;
        r102.L$0 = this;
        r102.I$0 = r100;
        r102.label = 1;
        if (O(r100, r102) != r105) goto L22;
        return r105;
    L22:
        r107 = this;
        goto L23
    L26:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L17:
        r108 = false;
    L7:
        r102 = new ByteChannelSequentialBase$awaitSuspend$1(this, r101);
        goto L8
    }

    public final void R(int r100, io.ktor.utils.io.core.j r101) {
        Throwable r102 = d();
        if (r102 == null) goto L8;
        if (r101 == null) goto L16;
        r101.close();
        throw r102;
    L16:
        throw r102;
    L8:
        if (U() == true) goto L10;
        return;
    L10:
        if (this._availableForRead >= r100) goto L17;
        if (r101 == null) goto L14;
        r101.close();
    L14:
        throw new EOFException(r100 + " bytes required but EOF reached");
    }

    public final Object V(io.ktor.utils.io.core.a r100, Continuation<? super Integer> r101) {
        if ((r101 instanceof ByteChannelSequentialBase$readAvailable$2) == false) goto L7;
        ByteChannelSequentialBase$readAvailable$2 r102 = (ByteChannelSequentialBase$readAvailable$2) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L12;
        io.ktor.utils.io.core.a r107 = (io.ktor.utils.io.core.a) r102.L$1;
        ByteChannelSequentialBase r108 = (ByteChannelSequentialBase) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L32:
        r108.getClass();
        throw null;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        Throwable r109 = d();
        if (r109 == null) goto L17;
        throw r109;
    L17:
        if (U() == false) goto L23;
        if (this._availableForRead != 0) goto L23;
        return Boxing.boxInt(-1);
    L23:
        if ((r100.f492024e - r100.f492022c) != 0) goto L27;
        return Boxing.boxInt(0);
    L27:
        if (this._availableForRead != 0) goto L31;
        r102.L$0 = this;
        r102.L$1 = r100;
        r102.label = 1;
        if (Q(1, r102) != r105) goto L31;
        return r105;
    L31:
        r108 = this;
    L7:
        r102 = new ByteChannelSequentialBase$readAvailable$2(this, r101);
        goto L8
    }

    public final Object b0(io.ktor.utils.io.core.internal.a r100, Continuation<? super Integer> r101) {
        if ((r101 instanceof ByteChannelSequentialBase$writeAvailableSuspend$1) == false) goto L7;
        ByteChannelSequentialBase$writeAvailableSuspend$1 r102 = (ByteChannelSequentialBase$writeAvailableSuspend$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L16;
        if (r106 == 1) goto L15;
        if (r106 != 2) goto L14;
        ResultKt.throwOnFailure(r104);
    L29:
        return r104;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r100 = (io.ktor.utils.io.core.internal.a) r102.L$1;
        ByteChannelSequentialBase r107 = (ByteChannelSequentialBase) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L20:
        r102.L$0 = null;
        r102.L$1 = null;
        r102.label = 2;
        r107.getClass();
        int r108 = r100.f492022c - r100.f492021b;
        if (r108 != 0) goto L24;
        Object r109 = Boxing.boxInt(0);
    L23:
        r104 = r109;
        if (r104 != r105) goto L29;
        return r105;
    L24:
        int r110 = Math.min(r108, r107.T());
        if (r110 != 0) goto L30;
        r109 = r107.b0(r100, r102);
        goto L23
    L30:
        io.ktor.utils.io.core.s.a(r100, r110);
        throw null;
    L16:
        ResultKt.throwOnFailure(r104);
        r102.L$0 = this;
        r102.L$1 = r100;
        r102.label = 1;
        if (P(1, r102) != r105) goto L19;
        return r105;
    L19:
        r107 = this;
    L7:
        r102 = new ByteChannelSequentialBase$writeAvailableSuspend$1(this, r101);
        goto L8
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object e(int r100, Continuation<? super io.ktor.utils.io.core.k> r101) {
        R(r100, null);
        AtomicReferenceFieldUpdater r102 = io.ktor.utils.io.core.internal.a.f492027j;
        io.ktor.utils.io.core.m r103 = io.ktor.utils.io.core.c.f492026a;
        Intrinsics.checkNotNullParameter(r103, "pool");
        Intrinsics.checkNotNullParameter(r103, "pool");
        ByteBuffer r104 = jsc.c.f500279b;
        throw null;
    }

    @Override // io.ktor.utils.io.t
    public final Object f(int r100, Continuation<? super Boolean> r101) {
        boolean r102 = false;
        if (r100 < 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L20;
        if (r100 > MapsInitializer.alc_level_ALL) goto L10;
        r102 = true;
    L10:
        if (r102 == false) goto L18;
        S();
        if (r100 != 0) goto L16;
        return Boxing.boxBoolean(!E());
    L16:
        throw null;
    L18:
        throw new IllegalArgumentException(("atLeast parameter shouldn't be larger than max buffer size of 4088: " + r100).toString());
    L20:
        throw new IllegalArgumentException(("atLeast parameter shouldn't be negative: " + r100).toString());
    L5:
        r103 = false;
        goto L6
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object h(long r100, Continuation<? super io.ktor.utils.io.core.k> r101) {
        Throwable r102 = d();
        if (r102 != null) goto L6;
        AtomicReferenceFieldUpdater r103 = io.ktor.utils.io.core.internal.a.f492027j;
        io.ktor.utils.io.core.m r104 = io.ktor.utils.io.core.c.f492026a;
        Intrinsics.checkNotNullParameter(r104, "pool");
        Intrinsics.checkNotNullParameter(r104, "pool");
        ByteBuffer r105 = jsc.c.f500279b;
        throw null;
    L6:
        throw r102;
    }

    @Override // io.ktor.utils.io.d
    @Deprecated(message = "Use write { } instead.")
    public final Object k(Function2<? super w, ? super Continuation<? super Unit>, ? extends Object> r100, Continuation<? super Unit> r101) {
        Object r102 = r100.invoke(new a(this), r101);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return Unit.INSTANCE;
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object p(long r100, Continuation<? super Long> r101) {
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [io.ktor.utils.io.ByteChannelSequentialBase, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v1, types: [io.ktor.utils.io.ByteChannelSequentialBase] */
    /* JADX WARN: Type inference failed for: r4v2, types: [io.ktor.utils.io.ByteChannelSequentialBase] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.Object, kotlin.Unit] */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    @Deprecated(message = "Use read instead.")
    public static /* synthetic */ Object Z(ByteChannelSequentialBase r100, Function2<? super t, ? super Continuation<? super Unit>, ? extends Object> r101, Continuation<? super Unit> r102) {
        if ((r102 instanceof ByteChannelSequentialBase$readSuspendableSession$1) == false) goto L7;
        ByteChannelSequentialBase$readSuspendableSession$1 r103 = (ByteChannelSequentialBase$readSuspendableSession$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L16;
        if (r107 != 1) goto L15;
        ByteChannelSequentialBase r108 = (ByteChannelSequentialBase) r103.L$0;
        ResultKt.throwOnFailure(r105);     // Catch: Throwable -> L22
        ?? r109 = r108;
    L20:
        r109.S();
        r100 = Unit.INSTANCE;
        return r100;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r105);
        r103.L$0 = r100;     // Catch: Throwable -> L22
        r103.label = 1;     // Catch: Throwable -> L22
        Object r110 = r101.invoke(r100, r103);     // Catch: Throwable -> L22
        r109 = r100;
        if (r110 != r106) goto L20;
        return r106;
    L22:
        th = move-exception;
        r100.S();
        throw th;
    L7:
        r103 = new ByteChannelSequentialBase$readSuspendableSession$1(r100, r102);
        goto L8
    }

    public static Object a0(final ByteChannelSequentialBase r100, int r101, Continuation<? super String> r102) {
        if ((r102 instanceof ByteChannelSequentialBase$readUTF8Line$1) == false) goto L7;
        ByteChannelSequentialBase$readUTF8Line$1 r103 = (ByteChannelSequentialBase$readUTF8Line$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        StringBuilder r108 = (StringBuilder) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L25:
        if (((Boolean) r105).booleanValue() == true) goto L28;
        return null;
    L28:
        return r108.toString();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        StringBuilder r109 = new StringBuilder();
        r103.L$0 = r109;
        r103.label = 1;
        if (r100.E() == false) goto L20;
        Throwable r110 = r100.d();
        if (r110 != null) goto L19;
        Object r111 = Boxing.boxBoolean(false);
    L21:
        if (r111 != r106) goto L23;
        return r106;
    L23:
        r105 = r111;
        r108 = r109;
        goto L25
    L19:
        throw r110;
    L20:
        r111 = UTF8Kt.a(r109, r101, new ByteChannelSequentialBase$readUTF8LineTo$2(r100, null), new ByteChannelSequentialBase$readUTF8LineTo$3(r100), r103);
    L7:
        r103 = new ByteChannelSequentialBase$readUTF8Line$1(r100, r102);
        goto L8
    }

    public static /* synthetic */ Object d0(ByteChannelSequentialBase r100, byte r101, Continuation<? super Unit> r102) {
        if ((r102 instanceof ByteChannelSequentialBase$writeByte$1) == false) goto L7;
        ByteChannelSequentialBase$writeByte$1 r103 = (ByteChannelSequentialBase$writeByte$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L12;
        r100 = (ByteChannelSequentialBase) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L17:
        r100.getClass();
        throw null;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        r103.L$0 = r100;
        r103.B$0 = r101;
        r103.label = 1;
        if (r100.P(1, r103) != r106) goto L17;
        return r106;
    L7:
        r103 = new ByteChannelSequentialBase$writeByte$1(r100, r102);
        goto L8
    }

    public static Object e0(ByteChannelSequentialBase r100, io.ktor.utils.io.core.a r101, Continuation<? super Unit> r102) {
        if ((r102 instanceof ByteChannelSequentialBase$writeFully$1) == false) goto L7;
        ByteChannelSequentialBase$writeFully$1 r103 = (ByteChannelSequentialBase$writeFully$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        r101 = (io.ktor.utils.io.core.a) r103.L$1;
        r100 = (ByteChannelSequentialBase) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L17:
        int r108 = r101.f492022c;
        r100.getClass();
        io.ktor.utils.io.core.s.a(r101, r101.f492022c - r101.f492021b);
        throw null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        r103.L$0 = r100;
        r103.L$1 = r101;
        r103.label = 1;
        if (r100.P(1, r103) != r106) goto L17;
        return r106;
    L7:
        r103 = new ByteChannelSequentialBase$writeFully$1(r100, r102);
        goto L8
    }

    public static Object g0(ByteChannelSequentialBase r100, int r101, Continuation<? super Unit> r102) {
        if ((r102 instanceof ByteChannelSequentialBase$writeInt$1) == false) goto L7;
        ByteChannelSequentialBase$writeInt$1 r103 = (ByteChannelSequentialBase$writeInt$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L12;
        r100 = (ByteChannelSequentialBase) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L17:
        r100.getClass();
        Intrinsics.checkNotNullParameter(null, "<this>");
        throw null;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        r103.L$0 = r100;
        r103.I$0 = r101;
        r103.label = 1;
        if (r100.P(4, r103) != r106) goto L17;
        return r106;
    L7:
        r103 = new ByteChannelSequentialBase$writeInt$1(r100, r102);
        goto L8
    }

    public static Object h0(ByteChannelSequentialBase r100, long r101, Continuation<? super Unit> r102) {
        if ((r102 instanceof ByteChannelSequentialBase$writeLong$1) == false) goto L7;
        ByteChannelSequentialBase$writeLong$1 r103 = (ByteChannelSequentialBase$writeLong$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L12;
        r100 = (ByteChannelSequentialBase) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L17:
        r100.getClass();
        Intrinsics.checkNotNullParameter(null, "<this>");
        throw null;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        r103.L$0 = r100;
        r103.J$0 = r101;
        r103.label = 1;
        if (r100.P(8, r103) != r106) goto L17;
        return r106;
    L7:
        r103 = new ByteChannelSequentialBase$writeLong$1(r100, r102);
        goto L8
    }

    public static /* synthetic */ Object i0(ByteChannelSequentialBase r100, io.ktor.utils.io.core.k r101, Continuation<? super Unit> r102) {
        if ((r102 instanceof ByteChannelSequentialBase$writePacket$1) == false) goto L7;
        ByteChannelSequentialBase$writePacket$1 r103 = (ByteChannelSequentialBase$writePacket$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L12;
        r101 = (io.ktor.utils.io.core.k) r103.L$1;
        r100 = (ByteChannelSequentialBase) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L17:
        r101.getClass();
        r100.getClass();
        throw null;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        r103.L$0 = r100;
        r103.L$1 = r101;
        r103.label = 1;
        if (r100.P(1, r103) != r106) goto L17;
        return r106;
    L7:
        r103 = new ByteChannelSequentialBase$writePacket$1(r100, r102);
        goto L8
    }

    public static /* synthetic */ Object j0(ByteChannelSequentialBase r100, short r101, Continuation<? super Unit> r102) {
        if ((r102 instanceof ByteChannelSequentialBase$writeShort$1) == false) goto L7;
        ByteChannelSequentialBase$writeShort$1 r103 = (ByteChannelSequentialBase$writeShort$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L12;
        r101 = r103.S$0;
        r100 = (ByteChannelSequentialBase) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L17:
        r100.getClass();
        io.ktor.utils.io.core.t.a(null, r101);
        throw null;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        r103.L$0 = r100;
        r103.S$0 = r101;
        r103.label = 1;
        if (r100.P(2, r103) != r106) goto L17;
        return r106;
    L7:
        r103 = new ByteChannelSequentialBase$writeShort$1(r100, r102);
        goto L8
    }

    public static Object X(ByteChannelSequentialBase r100, byte[] r101, int r102, Continuation r103) {
        if ((r103 instanceof ByteChannelSequentialBase$readFully$6) == false) goto L7;
        ByteChannelSequentialBase$readFully$6 r104 = (ByteChannelSequentialBase$readFully$6) r103;
        int r105 = r104.label;
        if ((r105 & Integer.MIN_VALUE) == 0) goto L7;
        r104.label = r105 - Integer.MIN_VALUE;
    L8:
        Object r106 = r104.result;
        Object r107 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r108 = r104.label;
        if (r108 == 0) goto L16;
        if (r108 == 1) goto L15;
        if (r108 != 2) goto L14;
        ResultKt.throwOnFailure(r106);
    L30:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r102 = r104.I$1;
        int r109 = r104.I$0;
        r101 = (byte[]) r104.L$1;
        ByteChannelSequentialBase r110 = (ByteChannelSequentialBase) r104.L$0;
        ResultKt.throwOnFailure(r106);
    L20:
        int r111 = ((Number) r106).intValue();
        if (r111 != r102) goto L25;
        return Unit.INSTANCE;
    L25:
        if (r111 == (-1)) goto L32;
        r104.L$0 = null;
        r104.L$1 = null;
        r104.label = 2;
        if (r110.Y(r101, r109 + r111, r102 - r111, r104) != r107) goto L30;
        return r107;
    L32:
        throw new EOFException("Unexpected end of stream");
    L16:
        ResultKt.throwOnFailure(r106);
        r104.L$0 = r100;
        r104.L$1 = r101;
        r104.I$0 = 0;
        r104.I$1 = r102;
        r104.label = 1;
        r100.getClass();
        Object r112 = W(r100, r101, 0, r102, r104);
        if (r112 != r107) goto L19;
        return r107;
    L19:
        r106 = r112;
        r110 = r100;
        r109 = 0;
    L7:
        r104 = new ByteChannelSequentialBase$readFully$6(r100, r103);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0069 -> B:12:0x0039). Please report as a decompilation issue!!! */
    public final Object Y(byte[] r100, int r101, int r110, Continuation<? super Unit> r111) {
        if ((r111 instanceof ByteChannelSequentialBase$readFullySuspend$2) == false) goto L7;
        ByteChannelSequentialBase$readFullySuspend$2 r102 = (ByteChannelSequentialBase$readFullySuspend$2) r111;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r112 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L15;
        if (r105 != 1) goto L14;
        int r106 = r102.I$2;
        int r107 = r102.I$1;
        int r113 = r102.I$0;
        byte[] r108 = (byte[]) r102.L$1;
        ByteChannelSequentialBase r109 = (ByteChannelSequentialBase) r102.L$0;
        ResultKt.throwOnFailure(r112);
        ByteChannelSequentialBase$readFullySuspend$2 r114 = r102;
        int r115 = r107;
        byte[] r116 = r108;
    L12:
        Object r117 = r104;
        ByteChannelSequentialBase$readFullySuspend$2 r118 = r114;
        int r119 = ((Number) r112).intValue();
        if (r119 == (-1)) goto L25;
        r106 = r106 + r119;
        int r120 = r115;
        r102 = r118;
        r104 = r117;
    L16:
        if (r106 >= r120) goto L27;
        r102.L$0 = r109;
        r102.L$1 = r116;
        r102.I$0 = r113;
        r102.I$1 = r120;
        r102.I$2 = r106;
        r102.label = 1;
        r109.getClass();
        Object r121 = W(r109, r116, r113 + r106, r120 - r106, r102);
        if (r121 != r104) goto L20;
        return r104;
    L20:
        r114 = r102;
        r115 = r120;
        r112 = r121;
        goto L12
    L27:
        return Unit.INSTANCE;
    L25:
        throw new EOFException("Unexpected end of stream");
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r112);
        r109 = this;
        r120 = r110;
        r113 = r101;
        r116 = r100;
        r106 = 0;
    L7:
        r102 = new ByteChannelSequentialBase$readFullySuspend$2(this, r111);
        goto L8
    }

    public final Object c0(byte[] r100, int r101, int r102, Continuation<? super Integer> r103) {
        if ((r103 instanceof ByteChannelSequentialBase$writeAvailableSuspend$2) == false) goto L7;
        ByteChannelSequentialBase$writeAvailableSuspend$2 r104 = (ByteChannelSequentialBase$writeAvailableSuspend$2) r103;
        int r105 = r104.label;
        if ((r105 & Integer.MIN_VALUE) == 0) goto L7;
        r104.label = r105 - Integer.MIN_VALUE;
    L8:
        Object r106 = r104.result;
        Object r107 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r108 = r104.label;
        if (r108 == 0) goto L16;
        if (r108 == 1) goto L15;
        if (r108 != 2) goto L14;
        ResultKt.throwOnFailure(r106);
    L29:
        return r106;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r102 = r104.I$1;
        r101 = r104.I$0;
        r100 = (byte[]) r104.L$1;
        ByteChannelSequentialBase r109 = (ByteChannelSequentialBase) r104.L$0;
        ResultKt.throwOnFailure(r106);
    L20:
        r104.L$0 = null;
        r104.L$1 = null;
        r104.label = 2;
        if (r102 != 0) goto L24;
        r109.getClass();
        Object r110 = Boxing.boxInt(0);
    L23:
        r106 = r110;
        if (r106 != r107) goto L29;
        return r107;
    L24:
        int r111 = Math.min(r102, r109.T());
        if (r111 != 0) goto L30;
        r110 = r109.c0(r100, r101, r102, r104);
        goto L23
    L30:
        io.ktor.utils.io.core.s.b(null, r100, r101, r111);
        throw null;
    L16:
        ResultKt.throwOnFailure(r106);
        r104.L$0 = this;
        r104.L$1 = r100;
        r104.I$0 = r101;
        r104.I$1 = r102;
        r104.label = 1;
        if (P(1, r104) != r107) goto L19;
        return r107;
    L19:
        r109 = this;
    L7:
        r104 = new ByteChannelSequentialBase$writeAvailableSuspend$2(this, r103);
        goto L8
    }

    public static Object W(ByteChannelSequentialBase r100, byte[] r101, int r102, int r103, Continuation<? super Integer> r104) {
        if ((r104 instanceof ByteChannelSequentialBase$readAvailable$4) == false) goto L7;
        ByteChannelSequentialBase$readAvailable$4 r105 = (ByteChannelSequentialBase$readAvailable$4) r104;
        int r106 = r105.label;
        if ((r106 & Integer.MIN_VALUE) == 0) goto L7;
        r105.label = r106 - Integer.MIN_VALUE;
    L8:
        Object r107 = r105.result;
        Object r108 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r109 = r105.label;
        if (r109 == 0) goto L14;
        if (r109 != 1) goto L12;
        byte[] r110 = (byte[]) r105.L$1;
        r100 = (ByteChannelSequentialBase) r105.L$0;
        ResultKt.throwOnFailure(r107);
    L30:
        r100.getClass();
        throw null;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r107);
        Throwable r111 = r100.d();
        if (r111 == null) goto L17;
        throw r111;
    L17:
        if (r100.U() == true) goto L19;
    L22:
        if (r103 != 0) goto L26;
        return Boxing.boxInt(0);
    L26:
        if (r100._availableForRead != 0) goto L30;
        r105.L$0 = r100;
        r105.L$1 = r101;
        r105.I$0 = r102;
        r105.I$1 = r103;
        r105.label = 1;
        if (r100.Q(1, r105) != r108) goto L30;
        return r108;
    L19:
        if (r100._availableForRead != 0) goto L22;
        return Boxing.boxInt(-1);
    L7:
        r105 = new ByteChannelSequentialBase$readAvailable$4(r100, r104);
        goto L8
    }

    public static /* synthetic */ Object f0(ByteChannelSequentialBase r100, byte[] r101, int r102, int r103, Continuation<? super Unit> r104) {
        if ((r104 instanceof ByteChannelSequentialBase$writeFully$2) == false) goto L7;
        ByteChannelSequentialBase$writeFully$2 r105 = (ByteChannelSequentialBase$writeFully$2) r104;
        int r106 = r105.label;
        if ((r106 & Integer.MIN_VALUE) == 0) goto L7;
        r105.label = r106 - Integer.MIN_VALUE;
    L8:
        Object r107 = r105.result;
        Object r108 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r109 = r105.label;
        if (r109 == 0) goto L14;
        if (r109 != 1) goto L12;
        int r110 = r105.I$1;
        r102 = r105.I$0;
        r101 = (byte[]) r105.L$1;
        ByteChannelSequentialBase r111 = (ByteChannelSequentialBase) r105.L$0;
        ResultKt.throwOnFailure(r107);
        int r112 = r110;
        r100 = r111;
    L19:
        io.ktor.utils.io.core.s.b(null, r101, r102, Math.min(r100.T(), r112 - r102));
        throw null;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r107);
        r112 = r103 + r102;
        if (r102 >= r112) goto L22;
        r105.L$0 = r100;
        r105.L$1 = r101;
        r105.I$0 = r102;
        r105.I$1 = r112;
        r105.label = 1;
        if (r100.P(1, r105) != r108) goto L19;
        return r108;
    L22:
        return Unit.INSTANCE;
    L7:
        r105 = new ByteChannelSequentialBase$writeFully$2(r100, r104);
        goto L8
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object i(ByteBuffer r110, long r210, long r211, long r212, Continuation r213) {
        if ((r213 instanceof ByteChannelSequentialBase$peekTo$1) == false) goto L7;
        ByteChannelSequentialBase$peekTo$1 r100 = (ByteChannelSequentialBase$peekTo$1) r213;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        ByteChannelSequentialBase$peekTo$1 r111 = r100;
        Object r102 = r111.result;
        Object r112 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r111.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        Ref.LongRef r104 = (Ref.LongRef) r111.L$0;
        ResultKt.throwOnFailure(r102);
    L19:
        return Boxing.boxLong(r104.element);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        Ref.LongRef r113 = new Ref.LongRef();
        ByteChannelSequentialBase$peekTo$2 r114 = new ByteChannelSequentialBase$peekTo$2(r211, 0, r113, r212, r110, r210, null);
        r111.L$0 = r113;
        r111.label = 1;
        if (Z(this, r114, r111) != r112) goto L17;
        return r112;
    L17:
        r104 = r113;
    L7:
        r100 = new ByteChannelSequentialBase$peekTo$1(this, r213);
        goto L8
    }
}
