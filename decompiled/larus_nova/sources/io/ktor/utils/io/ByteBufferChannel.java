package io.ktor.utils.io;

import androidx.collection.SieveCacheKt;
import com.amap.api.maps.MapsInitializer;
import io.ktor.utils.io.internal.WriteSessionImpl;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.ClosedReceiveChannelException;

/* JADX INFO: loaded from: classes41.dex */
public final class ByteBufferChannel implements b, ByteReadChannel, d, q, n, o {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f491989l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f491990m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f491991n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f491992o = null;
    private volatile /* synthetic */ Object _closed;
    private volatile /* synthetic */ Object _readOp;
    private volatile /* synthetic */ Object _state;
    volatile /* synthetic */ Object _writeOp;
    private volatile Job attachedJob;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f491993b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final io.ktor.utils.io.pool.e<io.ktor.utils.io.internal.h.c> f491994c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f491995d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f491996e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f491997f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final io.ktor.utils.io.internal.g f491998g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final WriteSessionImpl f491999h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final io.ktor.utils.io.internal.b<Boolean> f492000i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final io.ktor.utils.io.internal.b<Unit> f492001j;
    private volatile io.ktor.utils.io.internal.e joining;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Function1<Continuation<? super Unit>, Object> f492002k;
    private volatile long totalBytesRead;
    private volatile long totalBytesWritten;
    private volatile int writeSuspensionSize;

    public static final class a {
    }

    static {
        f491989l = AtomicReferenceFieldUpdater.newUpdater(ByteBufferChannel.class, Object.class, "_state");
        f491990m = AtomicReferenceFieldUpdater.newUpdater(ByteBufferChannel.class, Object.class, "_closed");
        f491991n = AtomicReferenceFieldUpdater.newUpdater(ByteBufferChannel.class, Object.class, "_readOp");
        f491992o = AtomicReferenceFieldUpdater.newUpdater(ByteBufferChannel.class, Object.class, "_writeOp");
    }

    @Override // io.ktor.utils.io.d
    public final Object A(byte r100, ContinuationImpl r101) {
        return V0(this, r100, r101);
    }

    public final void B0() {
        io.ktor.utils.io.internal.h r100 = null;
    L3:
        Object r101 = this._state;
        io.ktor.utils.io.internal.h r102 = (io.ktor.utils.io.internal.h) r101;
        io.ktor.utils.io.internal.h.b r103 = (io.ktor.utils.io.internal.h.b) r100;
        if (r103 == null) goto L6;
        r103.f492083b.f();
        E0();
        r100 = null;
    L6:
        io.ktor.utils.io.internal.h r104 = r102.f();
        if ((r104 instanceof io.ktor.utils.io.internal.h.b) == true) goto L9;
    L13:
        AtomicReferenceFieldUpdater r105 = f491989l;
    L14:
        boolean r106 = true;
        if (r105.compareAndSet(this, r101, r104) == true) goto L16;
        if (r105.get(this) == r101) goto L14;
        boolean r107 = false;
    L20:
        if (r107 == false) goto L3;
        io.ktor.utils.io.internal.h.a r108 = io.ktor.utils.io.internal.h.a.f492084c;
        if (r104 != r108) goto L29;
        io.ktor.utils.io.internal.h.b r109 = (io.ktor.utils.io.internal.h.b) r100;
        if (r109 == null) goto L26;
        y0(r109.f492085c);
    L26:
        E0();
        return;
    L29:
        if ((r104 instanceof io.ktor.utils.io.internal.h.b) == false) goto L57;
        io.ktor.utils.io.internal.j r110 = r104.f492083b;
        if (r110._availableForWrite$internal != r110.f492101a) goto L33;
        boolean r111 = true;
    L34:
        if (r111 == true) goto L36;
        return;
    L36:
        if (r104.f492083b.g() == false) goto L59;
        AtomicReferenceFieldUpdater r112 = f491989l;
    L39:
        if (r112.compareAndSet(this, r104, r108) == true) goto L44;
        if (r112.get(this) == r104) goto L39;
        r106 = false;
    L44:
        if (r106 == false) goto L60;
        r104.f492083b.f();
        y0(((io.ktor.utils.io.internal.h.b) r104).f492085c);
        E0();
        return;
    L60:
        return;
    L59:
        return;
    L33:
        r111 = false;
        goto L34
    L57:
        return;
    L16:
        r107 = true;
        goto L20
    L9:
        if (((io.ktor.utils.io.internal.h) this._state) != r102) goto L13;
        if (r104.f492083b.g() == false) goto L13;
        r104 = io.ktor.utils.io.internal.h.a.f492084c;
        r100 = r104;
        goto L13
    }

    public final void C0() {
        io.ktor.utils.io.internal.h r100 = null;
    L3:
        Object r101 = this._state;
        io.ktor.utils.io.internal.h r102 = ((io.ktor.utils.io.internal.h) r101).g();
        boolean r103 = true;
        if ((r102 instanceof io.ktor.utils.io.internal.h.b) == false) goto L11;
        io.ktor.utils.io.internal.j r104 = r102.f492083b;
        if (r104._availableForWrite$internal != r104.f492101a) goto L8;
        boolean r105 = true;
    L9:
        if (r105 == false) goto L11;
        r102 = io.ktor.utils.io.internal.h.a.f492084c;
        r100 = r102;
        goto L11
    L8:
        r105 = false;
    L11:
        AtomicReferenceFieldUpdater r106 = f491989l;
    L13:
        if (r106.compareAndSet(this, r101, r102) == true) goto L18;
        if (r106.get(this) == r101) goto L13;
        r103 = false;
    L18:
        if (r103 == false) goto L3;
        if (r102 != io.ktor.utils.io.internal.h.a.f492084c) goto L31;
        io.ktor.utils.io.internal.h.b r107 = (io.ktor.utils.io.internal.h.b) r100;
        if (r107 == null) goto L32;
        y0(r107.f492085c);
        return;
    L32:
        return;
    }

    @Override // io.ktor.utils.io.d
    public final Object I(int r100, Function1<? super ByteBuffer, Unit> r101, Continuation<? super Unit> r102) {
        return P0(this, r100, r101, r102);
    }

    @Override // io.ktor.utils.io.d
    public final void flush() {
        a0(1);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object i(ByteBuffer r100, long r101, long r102, long r103, Continuation r104) {
        return d0(this, r100, r101, r102, r103, r104);
    }

    @Override // io.ktor.utils.io.d
    @Deprecated(message = "Use write { } instead.")
    public final Object k(Function2<? super w, ? super Continuation<? super Unit>, ? extends Object> r100, Continuation<? super Unit> r101) {
        return g1(this, r100, r101);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object n(Continuation r100) {
        return w0(this, Integer.MAX_VALUE, r100);
    }

    @Override // io.ktor.utils.io.d
    public final Object o(short r100, ContinuationImpl r101) {
        return c1(this, r100, r101);
    }

    @Override // io.ktor.utils.io.d
    public final Object q(long r100, ContinuationImpl r101) {
        return a1(this, r100, r101);
    }

    @Override // io.ktor.utils.io.d
    public final Object v(int r100, Continuation<? super Unit> r101) {
        return Z0(this, r100, r101);
    }

    @Override // io.ktor.utils.io.n
    public final void C() {
        this.f491998g.c();
        io.ktor.utils.io.internal.h r100 = (io.ktor.utils.io.internal.h) this._state;
        if ((r100 instanceof io.ktor.utils.io.internal.h.d) == false) goto L5;
    L6:
        B0();
        M0();
        return;
    L5:
        if ((r100 instanceof io.ktor.utils.io.internal.h.e) == true) goto L6;
    }

    public final void D0() {
        Throwable r100 = null;
        Continuation r101 = (Continuation) f491991n.getAndSet(this, null);
        if (r101 == null) goto L11;
        io.ktor.utils.io.internal.c r102 = (io.ktor.utils.io.internal.c) this._closed;
        if (r102 == null) goto L7;
        r100 = r102.f492072a;
    L7:
        if (r100 == null) goto L9;
        Result.Companion r103 = Result.Companion;
        r101.resumeWith(Result.m9449constructorimpl(ResultKt.createFailure(r100)));
        return;
    L9:
        Result.Companion r104 = Result.Companion;
        r101.resumeWith(Result.m9449constructorimpl(Boolean.TRUE));
        return;
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final boolean E() {
        if (((io.ktor.utils.io.internal.h) this._state) == io.ktor.utils.io.internal.h.f.f492094c) goto L5;
    L7:
        return false;
    L5:
        if (((io.ktor.utils.io.internal.c) this._closed) == null) goto L7;
        return true;
    }

    public final void E0() {
    L2:
        Continuation r100 = (Continuation) this._writeOp;
        if (r100 == null) goto L4;
        io.ktor.utils.io.internal.c r101 = (io.ktor.utils.io.internal.c) this._closed;
        if (r101 == null) goto L8;
    L16:
        AtomicReferenceFieldUpdater r102 = f491992o;
    L18:
        if (r102.compareAndSet(this, r100, null) == true) goto L19;
        if (r102.get(this) == r100) goto L18;
        boolean r103 = false;
    L23:
        if (r103 == false) goto L2;
        if (r101 != null) goto L26;
        Result.Companion r104 = Result.Companion;
        Object r105 = Unit.INSTANCE;
    L27:
        r100.resumeWith(Result.m9449constructorimpl(r105));
        return;
    L26:
        Result.Companion r106 = Result.Companion;
        r105 = ResultKt.createFailure(r101.a());
        goto L27
    L19:
        r103 = true;
        goto L23
    L8:
        if (this.joining == null) goto L16;
        io.ktor.utils.io.internal.h r107 = (io.ktor.utils.io.internal.h) this._state;
        if ((r107 instanceof io.ktor.utils.io.internal.h.g) == true) goto L16;
        if ((r107 instanceof io.ktor.utils.io.internal.h.e) == true) goto L16;
        if (r107 == io.ktor.utils.io.internal.h.f.f492094c) goto L16;
        return;
    }

    public final ByteBuffer G0() {
    L2:
        Object r100 = this._state;
        io.ktor.utils.io.internal.h r101 = (io.ktor.utils.io.internal.h) r100;
        boolean r102 = true;
        if (Intrinsics.areEqual(r101, io.ktor.utils.io.internal.h.f.f492094c) == false) goto L5;
        boolean r103 = true;
    L7:
        if (r103 == true) goto L8;
        io.ktor.utils.io.internal.c r104 = (io.ktor.utils.io.internal.c) this._closed;
        if (r104 == null) goto L24;
        Throwable r105 = r104.f492072a;
        if (r105 == null) goto L24;
        io.ktor.utils.io.a.a(r105);
        throw null;
    L24:
        if (r101.f492083b._availableForRead$internal == 0) goto L25;
        io.ktor.utils.io.internal.h r106 = r101.d();
        AtomicReferenceFieldUpdater r107 = f491989l;
    L28:
        if (r107.compareAndSet(this, r100, r106) == true) goto L33;
        if (r107.get(this) == r100) goto L28;
        r102 = false;
    L33:
        if (r102 == false) goto L2;
        ByteBuffer r108 = r106.b();
        e0(r108, this.f491996e, r106.f492083b._availableForRead$internal);
        return r108;
    L25:
        return null;
    L8:
        io.ktor.utils.io.internal.c r109 = (io.ktor.utils.io.internal.c) this._closed;
        if (r109 == null) goto L15;
        Throwable r110 = r109.f492072a;
        if (r110 == null) goto L15;
        io.ktor.utils.io.a.a(r110);
        throw null;
    L15:
        return null;
    L5:
        r103 = Intrinsics.areEqual(r101, io.ktor.utils.io.internal.h.a.f492084c);
        goto L7
    }

    public final ByteBuffer H0() {
        Continuation r100 = (Continuation) this._writeOp;
        if (r100 != null) goto L55;
        io.ktor.utils.io.internal.h r101 = null;
        io.ktor.utils.io.internal.h.c r102 = null;
    L5:
        Object r103 = this._state;
        io.ktor.utils.io.internal.h r104 = (io.ktor.utils.io.internal.h) r103;
        if (this.joining != null) goto L7;
        if (((io.ktor.utils.io.internal.c) this._closed) != null) goto L12;
        if (r104 != io.ktor.utils.io.internal.h.a.f492084c) goto L22;
        if (r102 != null) goto L20;
        r102 = this.f491994c.Q5();
        r102.f492083b.f();
    L20:
        io.ktor.utils.io.internal.h r105 = r102.f492090g;
    L31:
        io.ktor.utils.io.internal.h r106 = r105;
        io.ktor.utils.io.internal.h.c r107 = r102;
        AtomicReferenceFieldUpdater r108 = f491989l;
    L33:
        if (r108.compareAndSet(this, r103, r106) == true) goto L34;
        if (r108.get(this) == r103) goto L33;
        boolean r109 = false;
    L38:
        if (r109 == true) goto L40;
        r102 = r107;
        goto L5
    L40:
        if (((io.ktor.utils.io.internal.c) this._closed) != null) goto L51;
        ByteBuffer r110 = r106.c();
        if (r107 == null) goto L49;
        if (r104 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("old");
    L47:
        if (r101 == io.ktor.utils.io.internal.h.a.f492084c) goto L49;
        y0(r107);
        goto L49
    L45:
        r101 = r104;
    L49:
        e0(r110, this.f491997f, r106.f492083b._availableForWrite$internal);
        return r110;
    L51:
        C0();
        M0();
        io.ktor.utils.io.internal.c r111 = (io.ktor.utils.io.internal.c) this._closed;
        Intrinsics.checkNotNull(r111);
        io.ktor.utils.io.a.a(r111.a());
        throw null;
    L34:
        r109 = true;
        goto L38
    L22:
        if (r104 == io.ktor.utils.io.internal.h.f.f492094c) goto L23;
        r105 = r104.e();
        goto L31
    L23:
        if (r102 == null) goto L26;
        y0(r102);
    L26:
        if (this.joining == null) goto L28;
        return null;
    L28:
        io.ktor.utils.io.internal.c r112 = (io.ktor.utils.io.internal.c) this._closed;
        Intrinsics.checkNotNull(r112);
        io.ktor.utils.io.a.a(r112.a());
        throw null;
    L12:
        if (r102 == null) goto L14;
        y0(r102);
    L14:
        io.ktor.utils.io.internal.c r113 = (io.ktor.utils.io.internal.c) this._closed;
        Intrinsics.checkNotNull(r113);
        io.ktor.utils.io.a.a(r113.a());
        throw null;
    L7:
        if (r102 == null) goto L9;
        y0(r102);
    L9:
        return null;
    L55:
        throw new IllegalStateException("Write operation is already in progress: " + r100);
    }

    public final boolean I0() {
        if (this.joining != null) goto L5;
    L9:
        return false;
    L5:
        if (((io.ktor.utils.io.internal.h) this._state) != io.ktor.utils.io.internal.h.a.f492084c) goto L7;
    L8:
        return true;
    L7:
        if ((((io.ktor.utils.io.internal.h) this._state) instanceof io.ktor.utils.io.internal.h.b) == false) goto L9;
        goto L8
    }

    @Override // io.ktor.utils.io.o
    public final w L() {
        WriteSessionImpl r100 = this.f491999h;
        r100.d();
        return r100;
    }

    public final void M0() {
        if (((io.ktor.utils.io.internal.c) this._closed) != null) goto L5;
        return;
    L5:
        if (L0(false) == false) goto L13;
        io.ktor.utils.io.internal.e r100 = this.joining;
        if (r100 == null) goto L10;
        Z(r100);
    L10:
        D0();
        E0();
        return;
    }

    public final io.ktor.utils.io.internal.h X() {
        return (io.ktor.utils.io.internal.h) this._state;
    }

    @Override // io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.d
    public final boolean c() {
        if (((io.ktor.utils.io.internal.c) this._closed) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.d
    public final Throwable d() {
        io.ktor.utils.io.internal.c r100 = (io.ktor.utils.io.internal.c) this._closed;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f492072a;
    }

    public final String toString() {
        return "ByteBufferChannel(" + hashCode() + ", " + ((io.ktor.utils.io.internal.h) this._state) + ')';
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final int w() {
        return ((io.ktor.utils.io.internal.h) this._state).f492083b._availableForRead$internal;
    }

    public final void z0() {
        io.ktor.utils.io.internal.e r100 = this.joining;
        if (r100 == null) goto L6;
        A0(this, r100);
        return;
    }

    @Override // io.ktor.utils.io.n
    public final t H() {
        return this.f491998g;
    }

    @Override // io.ktor.utils.io.d
    public final boolean J() {
        return this.f491993b;
    }

    public final io.ktor.utils.io.internal.e b0() {
        return this.joining;
    }

    public ByteBufferChannel(ByteBuffer r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        this(false, io.ktor.utils.io.internal.f.f492078d, 0);
        io.ktor.utils.io.internal.h.c r101 = new io.ktor.utils.io.internal.h.c(r100.slice(), 0);
        r101.f492083b.e();
        this._state = r101.f492090g;
        C0();
        e.a(this);
        M0();
    }

    public static final io.ktor.utils.io.internal.c M(ByteBufferChannel r100) {
        return (io.ktor.utils.io.internal.c) r100._closed;
    }

    public static final /* synthetic */ int N(ByteBufferChannel r100) {
        return r100.writeSuspensionSize;
    }

    public static final /* synthetic */ void P(ByteBufferChannel r100) {
        r100.attachedJob = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v4, types: [T, java.lang.Integer] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0093 -> B:40:0x0096). Please report as a decompilation issue!!! */
    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object F(Continuation<? super Integer> r110) {
        if ((r110 instanceof ByteBufferChannel$readInt$1) == false) goto L7;
        ByteBufferChannel$readInt$1 r100 = (ByteBufferChannel$readInt$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r111 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        int r104 = r100.I$0;
        ByteBufferChannel r105 = (ByteBufferChannel) r100.L$0;
        ResultKt.throwOnFailure(r111);
    L41:
        if (((Boolean) r111).booleanValue() == false) goto L44;
    L15:
        Ref.ObjectRef r112 = new Ref.ObjectRef();
        ByteBuffer r106 = r105.G0();
        boolean r107 = false;
        if (r106 == null) goto L31;
        io.ktor.utils.io.internal.j r108 = ((io.ktor.utils.io.internal.h) r105._state).f492083b;
        if (r108._availableForRead$internal != 0) goto L23;
    L30:
        r105.B0();
        r105.M0();
        goto L31
    L23:
        if (r108.i(r104) == false) goto L30;
        if (r106.remaining() >= r104) goto L28;
        F0(r106, r104);     // Catch: Throwable -> L45
    L28:
        r112.element = Boxing.boxInt(r106.getInt());     // Catch: Throwable -> L45
        r105.S(r106, r108, r104);     // Catch: Throwable -> L45
        r107 = true;
    L45:
        th = move-exception;
        r105.B0();
        r105.M0();
        throw th;
    L31:
        if (r107 == false) goto L37;
        T r113 = r112.element;
        if (r113 != 0) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("result");
        return null;
    L36:
        return (Number) r113;
    L37:
        r100.L$0 = r105;
        r100.I$0 = r104;
        r100.label = 1;
        r111 = r105.t0(r104, r100);
        if (r111 != r102) goto L41;
        return r102;
    L44:
        throw new ClosedReceiveChannelException("EOF while " + r104 + " bytes expected");
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        r104 = 4;
        r105 = this;
    L7:
        r100 = new ByteBufferChannel$readInt$1(this, r110);
        goto L8
    }

    @Override // io.ktor.utils.io.o
    public final void G(int r100) {
        this.f491999h.b(r100);
        this.f491999h.e();
    }

    @Override // io.ktor.utils.io.b
    @Deprecated(message = "\n    We're migrating to the new kotlinx-io library.\n    This declaration is deprecated and will be removed in Ktor 4.0.0\n    If you have any problems with migration, please contact us in \n    https://youtrack.jetbrains.com/issue/KTOR-6030/Migrate-to-new-kotlinx.io-library\n    ")
    public final void K(Job r110) {
        Intrinsics.checkNotNullParameter(r110, "job");
        Job r100 = this.attachedJob;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        this.attachedJob = r110;
        Job.DefaultImpls.invokeOnCompletion$default(r110, true, false, new ByteBufferChannel$attachJob$1(this), 2, null);
    }

    public final boolean K0(io.ktor.utils.io.internal.e r100) {
        if (L0(true) == true) goto L6;
        return false;
    L6:
        Z(r100);
        Continuation r101 = (Continuation) f491991n.getAndSet(this, null);
        if (r101 == null) goto L9;
        Result.Companion r102 = Result.Companion;
        r101.resumeWith(Result.m9449constructorimpl(ResultKt.createFailure(new IllegalStateException("Joining is in progress"))));
    L9:
        E0();
        return true;
    }

    public final boolean L0(boolean r110) {
        io.ktor.utils.io.internal.h.c r100 = null;
    L3:
        Object r101 = this._state;
        io.ktor.utils.io.internal.h r102 = (io.ktor.utils.io.internal.h) r101;
        io.ktor.utils.io.internal.c r103 = (io.ktor.utils.io.internal.c) this._closed;
        if (r100 == null) goto L11;
        if (r103 == null) goto L7;
        Throwable r104 = r103.f492072a;
    L8:
        if (r104 != null) goto L10;
        r100.f492083b.f();
    L10:
        E0();
        r100 = null;
        goto L11
    L7:
        r104 = null;
    L11:
        io.ktor.utils.io.internal.h.f r105 = io.ktor.utils.io.internal.h.f.f492094c;
        if (r102 == r105) goto L13;
        boolean r106 = false;
        if (r102 == io.ktor.utils.io.internal.h.a.f492084c) goto L34;
        if (r103 != null) goto L19;
    L28:
        if (r110 == false) goto L46;
        if ((r102 instanceof io.ktor.utils.io.internal.h.b) == false) goto L46;
        if (r102.f492083b.g() == false) goto L46;
        r100 = ((io.ktor.utils.io.internal.h.b) r102).f492085c;
    L46:
        return false;
    L19:
        if ((r102 instanceof io.ktor.utils.io.internal.h.b) == false) goto L28;
        if (r102.f492083b.g() == true) goto L25;
        if (r103.f492072a == null) goto L28;
    L25:
        if (r103.f492072a == null) goto L27;
        io.ktor.utils.io.internal.j r107 = r102.f492083b;
        r107.getClass();
        io.ktor.utils.io.internal.j.f492099c.getAndSet(r107, 0);
    L27:
        r100 = ((io.ktor.utils.io.internal.h.b) r102).f492085c;
    L34:
        AtomicReferenceFieldUpdater r108 = f491989l;
    L36:
        if (r108.compareAndSet(this, r101, r105) == true) goto L37;
        if (r108.get(this) == r101) goto L36;
    L40:
        if (r106 == false) goto L3;
        if (r100 != null) goto L43;
    L45:
        return true;
    L43:
        if (((io.ktor.utils.io.internal.h) this._state) != io.ktor.utils.io.internal.h.f.f492094c) goto L45;
        y0(r100);
        goto L45
    L37:
        r106 = true;
        goto L40
    L13:
        return true;
    }

    public final int N0(io.ktor.utils.io.core.k r100) {
        io.ktor.utils.io.internal.e r101 = this.joining;
        if (r101 == null) goto L5;
        A0(this, r101);
    L5:
        ByteBuffer r102 = H0();
        if (r102 != null) goto L8;
        return 0;
    L8:
        io.ktor.utils.io.internal.j r103 = ((io.ktor.utils.io.internal.h) this._state).f492083b;
        io.ktor.utils.io.internal.c r104 = (io.ktor.utils.io.internal.c) this._closed;     // Catch: Throwable -> L23
        if (r104 != null) goto L21;
        int r105 = r103.j((int) Math.min(r100.k(), r102.remaining()));     // Catch: Throwable -> L23
        if (r105 <= 0) goto L15;
        r102.limit(r102.position() + r105);     // Catch: Throwable -> L23
        io.ktor.utils.io.core.i.a(r100, r102);     // Catch: Throwable -> L23
        T(r102, r103, r105);     // Catch: Throwable -> L23
    L15:
        if (r103.d() == false) goto L17;
    L18:
        a0(1);
    L19:
        C0();
        M0();
        return r105;
    L17:
        if (this.f491993b == false) goto L19;
    L21:
        io.ktor.utils.io.a.a(r104.a());     // Catch: Throwable -> L23
        throw null;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        if (r103.d() == false) goto L27;
    L28:
        a0(1);
    L29:
        C0();
        M0();
        throw th;
    L27:
        if (this.f491993b == false) goto L29;
        goto L28
    }

    public final int Q0(io.ktor.utils.io.core.a r100) {
        io.ktor.utils.io.internal.e r101 = this.joining;
        if (r101 == null) goto L5;
        A0(this, r101);
    L5:
        ByteBuffer r102 = H0();
        int r103 = 0;
        if (r102 != null) goto L8;
        return 0;
    L8:
        io.ktor.utils.io.internal.j r104 = ((io.ktor.utils.io.internal.h) this._state).f492083b;
        io.ktor.utils.io.internal.c r105 = (io.ktor.utils.io.internal.c) this._closed;     // Catch: Throwable -> L24
        if (r105 != null) goto L22;
    L11:
        int r106 = r104.j(Math.min(r100.f492022c - r100.f492021b, r102.remaining()));     // Catch: Throwable -> L24
        if (r106 == 0) goto L14;
        io.ktor.utils.io.core.g.b(r100, r102, r106);     // Catch: Throwable -> L24
        r103 = r103 + r106;     // Catch: Throwable -> L24
        e0(r102, V(r102, this.f491997f + r103), r104._availableForWrite$internal);     // Catch: Throwable -> L24
        goto L11
    L14:
        T(r102, r104, r103);     // Catch: Throwable -> L24
        if (r104.d() == false) goto L18;
    L19:
        a0(1);
    L20:
        C0();
        M0();
        return r103;
    L18:
        if (this.f491993b == false) goto L20;
    L22:
        io.ktor.utils.io.a.a(r105.a());     // Catch: Throwable -> L24
        throw null;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        if (r104.d() == false) goto L28;
    L29:
        a0(1);
    L30:
        C0();
        M0();
        throw th;
    L28:
        if (this.f491993b == false) goto L30;
        goto L29
    }

    public final int R0(ByteBuffer r100) {
        io.ktor.utils.io.internal.e r101 = this.joining;
        if (r101 == null) goto L5;
        A0(this, r101);
    L5:
        ByteBuffer r102 = H0();
        if (r102 != null) goto L8;
        return 0;
    L8:
        io.ktor.utils.io.internal.j r103 = ((io.ktor.utils.io.internal.h) this._state).f492083b;
        io.ktor.utils.io.internal.c r104 = (io.ktor.utils.io.internal.c) this._closed;     // Catch: Throwable -> L33
        if (r104 != null) goto L31;
        int r105 = r100.limit();     // Catch: Throwable -> L33
        int r106 = 0;
    L12:
        int r107 = r105 - r100.position();     // Catch: Throwable -> L33
        if (r107 == 0) goto L23;
        int r108 = r103.j(Math.min(r107, r102.remaining()));     // Catch: Throwable -> L33
        if (r108 == 0) goto L23;
        if (r108 <= 0) goto L18;
        boolean r109 = true;
    L19:
        if (r109 == false) goto L22;
        r100.limit(r100.position() + r108);     // Catch: Throwable -> L33
        r102.put(r100);     // Catch: Throwable -> L33
        r106 = r106 + r108;     // Catch: Throwable -> L33
        e0(r102, V(r102, this.f491997f + r106), r103._availableForWrite$internal);     // Catch: Throwable -> L33
        goto L12
    L22:
        throw new IllegalArgumentException("Failed requirement.".toString());     // Catch: Throwable -> L33
    L18:
        r109 = false;
    L23:
        r100.limit(r105);     // Catch: Throwable -> L33
        T(r102, r103, r106);     // Catch: Throwable -> L33
        if (r103.d() == false) goto L27;
    L28:
        a0(1);
    L29:
        C0();
        M0();
        return r106;
    L27:
        if (this.f491993b == false) goto L29;
    L31:
        io.ktor.utils.io.a.a(r104.a());     // Catch: Throwable -> L33
        throw null;     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        if (r103.d() == false) goto L37;
    L38:
        a0(1);
    L39:
        C0();
        M0();
        throw th;
    L37:
        if (this.f491993b == false) goto L39;
        goto L38
    }

    public final void U(ByteBuffer r100) {
        int r101 = r100.capacity() - this.f491995d;
        int r102 = r100.position();
        int r103 = r101;
    L3:
        if (r103 >= r102) goto L5;
        r100.put(r103 - r101, r100.get(r103));
        r103 = r103 + 1;
        goto L3
    }

    public final void Z(io.ktor.utils.io.internal.e r100) {
        if (((io.ktor.utils.io.internal.c) this._closed) != null) goto L5;
        return;
    L5:
        this.joining = null;
        r100.getClass();
        throw null;
    }

    @Override // io.ktor.utils.io.p
    public final void a(int r100) {
        if (r100 < 0) goto L4;
        boolean r101 = true;
    L5:
        if (r101 == false) goto L14;
        io.ktor.utils.io.internal.h r102 = (io.ktor.utils.io.internal.h) this._state;
        if (r102.f492083b.i(r100) == false) goto L12;
        if (r100 <= 0) goto L15;
        S(r102.b(), r102.f492083b, r100);
        return;
    L15:
        return;
    L12:
        throw new IllegalStateException("Unable to consume " + r100 + " bytes: not enough available bytes");
    L14:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L4:
        r101 = false;
        goto L5
    }

    public final void a0(int r100) {
    L2:
        io.ktor.utils.io.internal.h r101 = (io.ktor.utils.io.internal.h) this._state;
        io.ktor.utils.io.internal.h.f r102 = io.ktor.utils.io.internal.h.f.f492094c;
        if (r101 == r102) goto L4;
        r101.f492083b.c();
        if (r101 != ((io.ktor.utils.io.internal.h) this._state)) goto L2;
        int r103 = r101.f492083b._availableForWrite$internal;
        if (r101.f492083b._availableForRead$internal < 1) goto L10;
        D0();
    L10:
        io.ktor.utils.io.internal.e r104 = this.joining;
        if (r103 < r100) goto L20;
        if (r104 != null) goto L14;
    L15:
        E0();
        return;
    L14:
        if (((io.ktor.utils.io.internal.h) this._state) == r102) goto L15;
        return;
    L20:
        return;
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final boolean cancel(Throwable r100) {
        if (r100 != null) goto L5;
        r100 = new CancellationException("Channel has been cancelled");
    L5:
        return close(r100);
    }

    @Override // io.ktor.utils.io.d
    public final boolean close(Throwable r100) {
        boolean r101 = false;
        if (((io.ktor.utils.io.internal.c) this._closed) == null) goto L5;
        return false;
    L5:
        if (r100 != null) goto L7;
        io.ktor.utils.io.internal.c r102 = io.ktor.utils.io.internal.c.f492071b;
    L8:
        ((io.ktor.utils.io.internal.h) this._state).f492083b.c();
        AtomicReferenceFieldUpdater r103 = f491990m;
    L10:
        if (r103.compareAndSet(this, null, r102) == true) goto L11;
        if (r103.get(this) == null) goto L10;
        boolean r104 = false;
    L15:
        if (r104 == true) goto L17;
        return false;
    L17:
        ((io.ktor.utils.io.internal.h) this._state).f492083b.c();
        io.ktor.utils.io.internal.j r105 = ((io.ktor.utils.io.internal.h) this._state).f492083b;
        if (r105._availableForWrite$internal != r105.f492101a) goto L20;
        boolean r106 = true;
    L21:
        if (r106 == true) goto L23;
        if (r100 != null) goto L23;
    L24:
        Continuation r107 = (Continuation) f491991n.getAndSet(this, null);
        if (r107 == null) goto L32;
        if (r100 == null) goto L29;
        Result.Companion r108 = Result.Companion;
        r107.resumeWith(Result.m9449constructorimpl(ResultKt.createFailure(r100)));
        goto L32
    L29:
        if (((io.ktor.utils.io.internal.h) this._state).f492083b._availableForRead$internal <= 0) goto L31;
        r101 = true;
    L31:
        r107.resumeWith(Result.m9449constructorimpl(Boolean.valueOf(r101)));
    L32:
        Continuation r109 = (Continuation) f491992o.getAndSet(this, null);
        if (r109 == null) goto L40;
        Result.Companion r110 = Result.Companion;
        if (r100 != null) goto L37;
        Throwable r111 = new ClosedWriteChannelException("Byte channel was closed");
    L38:
        r109.resumeWith(Result.m9449constructorimpl(ResultKt.createFailure(r111)));
        goto L40
    L37:
        r111 = r100;
    L40:
        if (((io.ktor.utils.io.internal.h) this._state) != io.ktor.utils.io.internal.h.f.f492094c) goto L44;
        io.ktor.utils.io.internal.e r112 = this.joining;
        if (r112 == null) goto L44;
        Z(r112);
    L44:
        if (r100 == null) goto L50;
        Job r113 = this.attachedJob;
        if (r113 == null) goto L48;
        Job.DefaultImpls.cancel$default(r113, null, 1, null);
    L48:
        this.f492000i.c(r100);
        this.f492001j.c(r100);
        return true;
    L50:
        this.f492001j.c(new ClosedWriteChannelException("Byte channel was closed"));
        io.ktor.utils.io.internal.b<Boolean> r114 = this.f492000i;
        Boolean r115 = Boolean.valueOf(((io.ktor.utils.io.internal.h) this._state).f492083b.c());
        r114.getClass();
        Intrinsics.checkNotNullParameter(r115, "value");
        r114.resumeWith(Result.m9449constructorimpl(r115));
        io.ktor.utils.io.internal.b.a r116 = (io.ktor.utils.io.internal.b.a) io.ktor.utils.io.internal.b.f492067b.getAndSet(r114, null);
        if (r116 == null) goto L53;
        r116.a();
    L53:
        return true;
    L23:
        M0();
        goto L24
    L20:
        r106 = false;
        goto L21
    L11:
        r104 = true;
        goto L15
    L7:
        r102 = new io.ktor.utils.io.internal.c(r100);
        goto L8
    }

    public final boolean f1(int r100) {
        io.ktor.utils.io.internal.e r101 = this.joining;
        io.ktor.utils.io.internal.h r102 = (io.ktor.utils.io.internal.h) this._state;
        if (((io.ktor.utils.io.internal.c) this._closed) == null) goto L6;
        return false;
    L6:
        if (r101 != null) goto L13;
        if (r102.f492083b._availableForWrite$internal < r100) goto L10;
        return false;
    L10:
        if (r102 == io.ktor.utils.io.internal.h.a.f492084c) goto L20;
    L11:
        return true;
    L20:
        return false;
    L13:
        if (r102 != io.ktor.utils.io.internal.h.f.f492094c) goto L15;
        return false;
    L15:
        if ((r102 instanceof io.ktor.utils.io.internal.h.g) == false) goto L17;
        return false;
    L17:
        if ((r102 instanceof io.ktor.utils.io.internal.h.e) == false) goto L11;
        return false;
    }

    public final int g0(ByteBuffer r100) {
        ByteBuffer r101 = G0();
        int r102 = 0;
        if (r101 == null) goto L17;
        io.ktor.utils.io.internal.j r103 = ((io.ktor.utils.io.internal.h) this._state).f492083b;
    L18:
        th = move-exception;
        B0();
        M0();
        throw th;
    L7:
        if (r103._availableForRead$internal == 0) goto L16;
        int r104 = r101.capacity() - this.f491995d;     // Catch: Throwable -> L18
    L10:
        int r105 = r100.remaining();     // Catch: Throwable -> L18
        if (r105 == 0) goto L16;
        int r106 = this.f491996e;     // Catch: Throwable -> L18
        int r107 = r103.h(Math.min(r104 - r106, r105));     // Catch: Throwable -> L18
        if (r107 == 0) goto L16;
        r101.limit(r106 + r107);     // Catch: Throwable -> L18
        r101.position(r106);     // Catch: Throwable -> L18
        r100.put(r101);     // Catch: Throwable -> L18
        S(r101, r103, r107);     // Catch: Throwable -> L18
        r102 = r102 + r107;
    L16:
        B0();
        M0();
    L17:
        return r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v3, types: [T, java.lang.Long] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0095 -> B:40:0x0098). Please report as a decompilation issue!!! */
    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object j(Continuation<? super Long> r110) {
        if ((r110 instanceof ByteBufferChannel$readLong$1) == false) goto L7;
        ByteBufferChannel$readLong$1 r100 = (ByteBufferChannel$readLong$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r111 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        int r104 = r100.I$0;
        ByteBufferChannel r105 = (ByteBufferChannel) r100.L$0;
        ResultKt.throwOnFailure(r111);
    L41:
        if (((Boolean) r111).booleanValue() == false) goto L44;
    L15:
        Ref.ObjectRef r112 = new Ref.ObjectRef();
        ByteBuffer r106 = r105.G0();
        boolean r107 = false;
        if (r106 == null) goto L31;
        io.ktor.utils.io.internal.j r108 = ((io.ktor.utils.io.internal.h) r105._state).f492083b;
        if (r108._availableForRead$internal != 0) goto L23;
    L30:
        r105.B0();
        r105.M0();
        goto L31
    L23:
        if (r108.i(r104) == false) goto L30;
        if (r106.remaining() >= r104) goto L28;
        F0(r106, r104);     // Catch: Throwable -> L45
    L28:
        r112.element = Boxing.boxLong(r106.getLong());     // Catch: Throwable -> L45
        r105.S(r106, r108, r104);     // Catch: Throwable -> L45
        r107 = true;
    L45:
        th = move-exception;
        r105.B0();
        r105.M0();
        throw th;
    L31:
        if (r107 == false) goto L37;
        T r113 = r112.element;
        if (r113 != 0) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("result");
        return null;
    L36:
        return (Number) r113;
    L37:
        r100.L$0 = r105;
        r100.I$0 = r104;
        r100.label = 1;
        r111 = r105.t0(r104, r100);
        if (r111 != r102) goto L41;
        return r102;
    L44:
        throw new ClosedReceiveChannelException("EOF while " + r104 + " bytes expected");
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        r104 = 8;
        r105 = this;
    L7:
        r100 = new ByteBufferChannel$readLong$1(this, r110);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v3, types: [T, java.lang.Long] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00a2 -> B:41:0x00a5). Please report as a decompilation issue!!! */
    public final Object n0(Continuation<? super Double> r110) {
        if ((r110 instanceof ByteBufferChannel$readDouble$1) == false) goto L7;
        ByteBufferChannel$readDouble$1 r100 = (ByteBufferChannel$readDouble$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r111 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        int r104 = r100.I$0;
        ByteBufferChannel r105 = (ByteBufferChannel) r100.L$0;
        ResultKt.throwOnFailure(r111);
    L42:
        if (((Boolean) r111).booleanValue() == false) goto L45;
    L15:
        Ref.ObjectRef r112 = new Ref.ObjectRef();
        ByteBuffer r106 = r105.G0();
        boolean r107 = false;
        if (r106 == null) goto L31;
        io.ktor.utils.io.internal.j r108 = ((io.ktor.utils.io.internal.h) r105._state).f492083b;
        if (r108._availableForRead$internal != 0) goto L23;
    L30:
        r105.B0();
        r105.M0();
        goto L31
    L23:
        if (r108.i(r104) == false) goto L30;
        if (r106.remaining() >= r104) goto L28;
        F0(r106, r104);     // Catch: Throwable -> L46
    L28:
        r112.element = Boxing.boxLong(r106.getLong());     // Catch: Throwable -> L46
        r105.S(r106, r108, r104);     // Catch: Throwable -> L46
        r107 = true;
    L46:
        th = move-exception;
        r105.B0();
        r105.M0();
        throw th;
    L31:
        if (r107 == false) goto L38;
        T r113 = r112.element;
        if (r113 != 0) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("result");
        Number r114 = null;
    L37:
        return Boxing.boxDouble(Double.longBitsToDouble(r114.longValue()));
    L35:
        r114 = (Number) r113;
        goto L37
    L38:
        r100.L$0 = r105;
        r100.I$0 = r104;
        r100.label = 1;
        r111 = r105.t0(r104, r100);
        if (r111 != r102) goto L42;
        return r102;
    L45:
        throw new ClosedReceiveChannelException("EOF while " + r104 + " bytes expected");
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        r104 = 8;
        r105 = this;
    L7:
        r100 = new ByteBufferChannel$readDouble$1(this, r110);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v4, types: [T, java.lang.Integer] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00a0 -> B:41:0x00a3). Please report as a decompilation issue!!! */
    public final Object o0(Continuation<? super Float> r110) {
        if ((r110 instanceof ByteBufferChannel$readFloat$1) == false) goto L7;
        ByteBufferChannel$readFloat$1 r100 = (ByteBufferChannel$readFloat$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r111 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        int r104 = r100.I$0;
        ByteBufferChannel r105 = (ByteBufferChannel) r100.L$0;
        ResultKt.throwOnFailure(r111);
    L42:
        if (((Boolean) r111).booleanValue() == false) goto L45;
    L15:
        Ref.ObjectRef r112 = new Ref.ObjectRef();
        ByteBuffer r106 = r105.G0();
        boolean r107 = false;
        if (r106 == null) goto L31;
        io.ktor.utils.io.internal.j r108 = ((io.ktor.utils.io.internal.h) r105._state).f492083b;
        if (r108._availableForRead$internal != 0) goto L23;
    L30:
        r105.B0();
        r105.M0();
        goto L31
    L23:
        if (r108.i(r104) == false) goto L30;
        if (r106.remaining() >= r104) goto L28;
        F0(r106, r104);     // Catch: Throwable -> L46
    L28:
        r112.element = Boxing.boxInt(r106.getInt());     // Catch: Throwable -> L46
        r105.S(r106, r108, r104);     // Catch: Throwable -> L46
        r107 = true;
    L46:
        th = move-exception;
        r105.B0();
        r105.M0();
        throw th;
    L31:
        if (r107 == false) goto L38;
        T r113 = r112.element;
        if (r113 != 0) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("result");
        Number r114 = null;
    L37:
        return Boxing.boxFloat(Float.intBitsToFloat(r114.intValue()));
    L35:
        r114 = (Number) r113;
        goto L37
    L38:
        r100.L$0 = r105;
        r100.I$0 = r104;
        r100.label = 1;
        r111 = r105.t0(r104, r100);
        if (r111 != r102) goto L42;
        return r102;
    L45:
        throw new ClosedReceiveChannelException("EOF while " + r104 + " bytes expected");
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        r104 = 4;
        r105 = this;
    L7:
        r100 = new ByteBufferChannel$readFloat$1(this, r110);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v4, types: [T, java.lang.Short] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0093 -> B:40:0x0096). Please report as a decompilation issue!!! */
    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object s(Continuation<? super Short> r110) {
        if ((r110 instanceof ByteBufferChannel$readShort$1) == false) goto L7;
        ByteBufferChannel$readShort$1 r100 = (ByteBufferChannel$readShort$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r111 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        int r104 = r100.I$0;
        ByteBufferChannel r105 = (ByteBufferChannel) r100.L$0;
        ResultKt.throwOnFailure(r111);
    L41:
        if (((Boolean) r111).booleanValue() == false) goto L44;
    L15:
        Ref.ObjectRef r112 = new Ref.ObjectRef();
        ByteBuffer r106 = r105.G0();
        boolean r107 = false;
        if (r106 == null) goto L31;
        io.ktor.utils.io.internal.j r108 = ((io.ktor.utils.io.internal.h) r105._state).f492083b;
        if (r108._availableForRead$internal != 0) goto L23;
    L30:
        r105.B0();
        r105.M0();
        goto L31
    L23:
        if (r108.i(r104) == false) goto L30;
        if (r106.remaining() >= r104) goto L28;
        F0(r106, r104);     // Catch: Throwable -> L45
    L28:
        r112.element = Boxing.boxShort(r106.getShort());     // Catch: Throwable -> L45
        r105.S(r106, r108, r104);     // Catch: Throwable -> L45
        r107 = true;
    L45:
        th = move-exception;
        r105.B0();
        r105.M0();
        throw th;
    L31:
        if (r107 == false) goto L37;
        T r113 = r112.element;
        if (r113 != 0) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("result");
        return null;
    L36:
        return (Number) r113;
    L37:
        r100.L$0 = r105;
        r100.I$0 = r104;
        r100.label = 1;
        r111 = r105.t0(r104, r100);
        if (r111 != r102) goto L41;
        return r102;
    L44:
        throw new ClosedReceiveChannelException("EOF while " + r104 + " bytes expected");
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        r104 = 2;
        r105 = this;
    L7:
        r100 = new ByteBufferChannel$readShort$1(this, r110);
        goto L8
    }

    public final void y0(io.ktor.utils.io.internal.h.c r100) {
        this.f491994c.Rl(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v4, types: [T, java.lang.Byte] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0092 -> B:40:0x0095). Please report as a decompilation issue!!! */
    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object z(Continuation<? super Byte> r110) {
        if ((r110 instanceof ByteBufferChannel$readByte$1) == false) goto L7;
        ByteBufferChannel$readByte$1 r100 = (ByteBufferChannel$readByte$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r111 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        int r104 = r100.I$0;
        ByteBufferChannel r105 = (ByteBufferChannel) r100.L$0;
        ResultKt.throwOnFailure(r111);
    L41:
        if (((Boolean) r111).booleanValue() == false) goto L44;
    L15:
        Ref.ObjectRef r112 = new Ref.ObjectRef();
        ByteBuffer r106 = r105.G0();
        boolean r107 = false;
        if (r106 == null) goto L31;
        io.ktor.utils.io.internal.j r108 = ((io.ktor.utils.io.internal.h) r105._state).f492083b;
        if (r108._availableForRead$internal != 0) goto L23;
    L30:
        r105.B0();
        r105.M0();
        goto L31
    L23:
        if (r108.i(r104) == false) goto L30;
        if (r106.remaining() >= r104) goto L28;
        F0(r106, r104);     // Catch: Throwable -> L45
    L28:
        r112.element = Boxing.boxByte(r106.get());     // Catch: Throwable -> L45
        r105.S(r106, r108, r104);     // Catch: Throwable -> L45
        r107 = true;
    L45:
        th = move-exception;
        r105.B0();
        r105.M0();
        throw th;
    L31:
        if (r107 == false) goto L37;
        T r113 = r112.element;
        if (r113 != 0) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("result");
        return null;
    L36:
        return (Number) r113;
    L37:
        r100.L$0 = r105;
        r100.I$0 = r104;
        r100.label = 1;
        r111 = r105.t0(r104, r100);
        if (r111 != r102) goto L41;
        return r102;
    L44:
        throw new ClosedReceiveChannelException("EOF while " + r104 + " bytes expected");
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        r104 = 1;
        r105 = this;
    L7:
        r100 = new ByteBufferChannel$readByte$1(this, r110);
        goto L8
    }

    public static void A0(ByteBufferChannel r100, io.ktor.utils.io.internal.e r101) {
        if (((io.ktor.utils.io.internal.h) r100._state) == io.ktor.utils.io.internal.h.f.f492094c) goto L6;
        return;
    L6:
        throw null;
    }

    public static void F0(ByteBuffer r100, int r101) {
        int r102 = r100.remaining();
        r100.limit(r100.position() + r101);
        int r103 = r101 - r102;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        r100.put((r100.capacity() - 8) + r104, r100.get(r104));
        r104 = r104 + 1;
        goto L3
    }

    public static final Object O(ByteBufferChannel r100, Continuation r110) {
        r100.getClass();
        if ((r110 instanceof ByteBufferChannel$joinFromSuspend$1) == false) goto L7;
        ByteBufferChannel$joinFromSuspend$1 r101 = (ByteBufferChannel$joinFromSuspend$1) r110;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r111 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        boolean r105 = false;
        if (r104 == 0) goto L16;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        ResultKt.throwOnFailure(r111);
    L43:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        boolean r106 = r101.Z$0;
        ByteBufferChannel r107 = (ByteBufferChannel) r101.L$1;
        ByteBufferChannel r108 = (ByteBufferChannel) r101.L$0;
        ResultKt.throwOnFailure(r111);
    L20:
        if (r106 == true) goto L22;
    L24:
        r108.a0(1);
        r101.L$0 = null;
        r101.L$1 = null;
        r101.label = 2;
        if (((io.ktor.utils.io.internal.c) r107._closed) == null) goto L27;
        Object r109 = Unit.INSTANCE;
    L40:
        if (r109 != r103) goto L43;
        return r103;
    L27:
        io.ktor.utils.io.internal.e r112 = r107.joining;
        if (r112 == null) goto L30;
        r109 = r112.a(r101);
        if (r109 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L40;
        r109 = Unit.INSTANCE;
        goto L40
    L30:
        if (((io.ktor.utils.io.internal.c) r107._closed) == null) goto L32;
        r105 = true;
    L32:
        if (r105 == false) goto L35;
        r109 = Unit.INSTANCE;
        goto L40
    L35:
        throw new IllegalStateException("Only works for joined.".toString());
    L22:
        if (r107.E() == false) goto L24;
        e.a(r108);
        return Unit.INSTANCE;
    L16:
        ResultKt.throwOnFailure(r111);
        r101.L$0 = r100;
        r101.L$1 = null;
        r101.Z$0 = false;
        r101.label = 1;
        if (r100.W(null, Long.MAX_VALUE, r101) == r103) goto L45;
        r108 = r100;
        r107 = null;
        r106 = false;
        goto L20
    L45:
        return r103;
    L7:
        r101 = new ByteBufferChannel$joinFromSuspend$1(r100, r110);
        goto L8
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object B(ByteBuffer r100, ContinuationImpl r101) {
        int r102 = g0(r100);
        if (r102 == 0) goto L5;
    L10:
        if (r102 <= 0) goto L12;
    L16:
        return Boxing.boxInt(r102);
    L12:
        if (r100.hasRemaining() == false) goto L16;
        return k0(r100, r101);
    L5:
        if (((io.ktor.utils.io.internal.c) this._closed) == null) goto L10;
        if (((io.ktor.utils.io.internal.h) this._state).f492083b.c() == false) goto L9;
        r102 = g0(r100);
        goto L16
    L9:
        r102 = -1;
        goto L16
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object D(io.ktor.utils.io.core.internal.a r100, ContinuationImpl r101) {
        boolean r102 = false;
        int r103 = i0(this, r100, 0, 6);
        if (r103 == 0) goto L5;
    L10:
        if (r103 <= 0) goto L12;
    L18:
        return Boxing.boxInt(r103);
    L12:
        if (r100.f492024e <= r100.f492022c) goto L14;
        r102 = true;
    L14:
        if (r102 == false) goto L18;
        return j0(r100, r101);
    L5:
        if (((io.ktor.utils.io.internal.c) this._closed) == null) goto L10;
        if (((io.ktor.utils.io.internal.h) this._state).f492083b.c() == false) goto L9;
        r103 = i0(this, r100, 0, 6);
        goto L18
    L9:
        r103 = -1;
        goto L18
    }

    public final void J0(int r100, io.ktor.utils.io.internal.b r101) {
    L2:
        io.ktor.utils.io.internal.h r102 = (io.ktor.utils.io.internal.h) this._state;
        boolean r103 = true;
        if (r102.f492083b._availableForRead$internal < r100) goto L5;
    L13:
        boolean r104 = false;
    L14:
        if (r104 == false) goto L15;
        io.ktor.utils.io.internal.c r105 = (io.ktor.utils.io.internal.c) this._closed;
        if (r105 != null) goto L18;
    L34:
        if (((Continuation) this._readOp) != null) goto L36;
        boolean r106 = true;
    L37:
        if (r106 == false) goto L97;
        if (((io.ktor.utils.io.internal.c) this._closed) != null) goto L54;
        io.ktor.utils.io.internal.h r107 = (io.ktor.utils.io.internal.h) this._state;
        if (r107.f492083b._availableForRead$internal < r100) goto L43;
    L51:
        boolean r108 = false;
    L52:
        if (r108 == false) goto L54;
        boolean r109 = true;
    L55:
        if (r109 == false) goto L92;
        AtomicReferenceFieldUpdater r110 = f491991n;
    L59:
        if (r110.compareAndSet(this, null, r101) == true) goto L60;
        if (r110.get(this) == null) goto L59;
        boolean r111 = false;
    L64:
        if (r111 == false) goto L34;
        if (((io.ktor.utils.io.internal.c) this._closed) != null) goto L81;
        io.ktor.utils.io.internal.h r112 = (io.ktor.utils.io.internal.h) this._state;
        if (r112.f492083b._availableForRead$internal < r100) goto L70;
    L78:
        boolean r113 = false;
    L79:
        if (r113 == false) goto L81;
        boolean r114 = true;
    L82:
        if (r114 == true) goto L93;
        AtomicReferenceFieldUpdater r115 = f491991n;
    L85:
        if (r115.compareAndSet(this, r101, null) == true) goto L86;
        if (r115.get(this) == r101) goto L85;
        boolean r116 = false;
    L90:
        if (r116 == true) goto L92;
    L86:
        r116 = true;
    L93:
        if (r103 == false) goto L2;
    L94:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return;
    L70:
        if (this.joining != null) goto L72;
    L77:
        r113 = true;
        goto L79
    L72:
        if (((Continuation) this._writeOp) == null) goto L77;
        if (r112 == io.ktor.utils.io.internal.h.a.f492084c) goto L78;
        if ((r112 instanceof io.ktor.utils.io.internal.h.b) == true) goto L78;
    L81:
        r114 = false;
        goto L82
    L60:
        r111 = true;
    L92:
        r103 = false;
        goto L93
    L43:
        if (this.joining != null) goto L45;
    L50:
        r108 = true;
        goto L52
    L45:
        if (((Continuation) this._writeOp) == null) goto L50;
        if (r107 == io.ktor.utils.io.internal.h.a.f492084c) goto L51;
        if ((r107 instanceof io.ktor.utils.io.internal.h.b) == true) goto L51;
    L54:
        r109 = false;
        goto L55
    L97:
        throw new IllegalStateException("Operation is already in progress".toString());
    L36:
        r106 = false;
        goto L37
    L18:
        Throwable r117 = r105.f492072a;
        if (r117 == null) goto L22;
        Result.Companion r118 = Result.Companion;
        r101.resumeWith(Result.m9449constructorimpl(ResultKt.createFailure(r117)));
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return;
    L22:
        boolean r119 = ((io.ktor.utils.io.internal.h) this._state).f492083b.c();
        if (((io.ktor.utils.io.internal.h) this._state).f492083b._availableForRead$internal < r100) goto L25;
        boolean r120 = true;
    L26:
        Result.Companion r121 = Result.Companion;
        if (r119 == false) goto L30;
        if (r120 == false) goto L30;
    L31:
        r101.resumeWith(Result.m9449constructorimpl(Boolean.valueOf(r103)));
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return;
    L30:
        r103 = false;
        goto L31
    L25:
        r120 = false;
        goto L26
    L15:
        Result.Companion r122 = Result.Companion;
        r101.resumeWith(Result.m9449constructorimpl(Boolean.TRUE));
        goto L94
    L5:
        if (this.joining != null) goto L7;
    L12:
        r104 = true;
        goto L14
    L7:
        if (((Continuation) this._writeOp) == null) goto L12;
        if (r102 == io.ktor.utils.io.internal.h.a.f492084c) goto L13;
        if ((r102 instanceof io.ktor.utils.io.internal.h.b) == true) goto L13;
        goto L12
    }

    public final Object O0(int r100, ContinuationImpl r101) {
        if (f1(r100) == true) goto L10;
        io.ktor.utils.io.internal.c r102 = (io.ktor.utils.io.internal.c) this._closed;
        if (r102 == null) goto L7;
        io.ktor.utils.io.a.a(r102.a());
        throw null;
    L7:
        return Unit.INSTANCE;
    L10:
        this.writeSuspensionSize = r100;
        if (this.attachedJob == null) goto L20;
        Object r103 = this.f492002k.invoke(r101);
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L16;
        DebugProbesKt.probeCoroutineSuspended(r101);
    L16:
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L19;
        return r103;
    L19:
        return Unit.INSTANCE;
    L20:
        io.ktor.utils.io.internal.b<Unit> r104 = this.f492001j;
        this.f492002k.invoke(r104);
        Object r105 = r104.e(IntrinsicsKt.intercepted(r101));
        if (r105 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L24;
        DebugProbesKt.probeCoroutineSuspended(r101);
    L24:
        if (r105 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L27;
        return r105;
    L27:
        return Unit.INSTANCE;
    }

    public final Object Q(int r100, Continuation<? super Boolean> r101) {
        if ((r101 instanceof ByteBufferChannel$awaitAtLeastSuspend$1) == false) goto L7;
        ByteBufferChannel$awaitAtLeastSuspend$1 r102 = (ByteBufferChannel$awaitAtLeastSuspend$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ByteBufferChannel r107 = (ByteBufferChannel) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L18:
        boolean r108 = ((Boolean) r104).booleanValue();
        if (r108 == false) goto L24;
        if (((io.ktor.utils.io.internal.h) r107._state).a() == false) goto L24;
        r107.G0();
    L24:
        return Boxing.boxBoolean(r108);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        r102.L$0 = this;
        r102.label = 1;
        r104 = t0(r100, r102);
        if (r104 != r105) goto L17;
        return r105;
    L17:
        r107 = this;
    L7:
        r102 = new ByteBufferChannel$awaitAtLeastSuspend$1(this, r101);
        goto L8
    }

    public final Object T0(io.ktor.utils.io.core.internal.a r100, Continuation<? super Integer> r101) {
        if ((r101 instanceof ByteBufferChannel$writeAvailableSuspend$3) == false) goto L7;
        ByteBufferChannel$writeAvailableSuspend$3 r102 = (ByteBufferChannel$writeAvailableSuspend$3) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L20;
        if (r106 != 1) goto L12;
        r100 = (io.ktor.utils.io.core.internal.a) r102.L$1;
        ByteBufferChannel r107 = (ByteBufferChannel) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L24:
        io.ktor.utils.io.internal.e r108 = r107.joining;
        if (r108 == null) goto L27;
        A0(r107, r108);
    L27:
        r102.L$0 = null;
        r102.L$1 = null;
        r102.label = 3;
        io.ktor.utils.io.internal.e r109 = r107.joining;
        if (r109 == null) goto L30;
        A0(r107, r109);
    L30:
        int r110 = r107.Q0(r100);
        if (r110 <= 0) goto L34;
        Object r111 = Boxing.boxInt(r110);
    L33:
        r104 = r111;
        if (r104 != r105) goto L40;
        return r105;
    L40:
        return r104;
    L34:
        io.ktor.utils.io.internal.e r112 = r107.joining;
        if (r112 == null) goto L37;
        A0(r107, r112);
    L37:
        r111 = r107.T0(r100, r102);
        goto L33
    L12:
        if (r106 == 2) goto L17;
        if (r106 != 3) goto L16;
        ResultKt.throwOnFailure(r104);
        goto L40
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r104);
        return r104;
    L20:
        ResultKt.throwOnFailure(r104);
        r102.L$0 = this;
        r102.L$1 = r100;
        r102.label = 1;
        if (d1(1, r102) != r105) goto L23;
        return r105;
    L23:
        r107 = this;
    L7:
        r102 = new ByteBufferChannel$writeAvailableSuspend$3(this, r101);
        goto L8
    }

    public final Object U0(ByteBuffer r100, Continuation<? super Integer> r101) {
        if ((r101 instanceof ByteBufferChannel$writeAvailableSuspend$1) == false) goto L7;
        ByteBufferChannel$writeAvailableSuspend$1 r102 = (ByteBufferChannel$writeAvailableSuspend$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L20;
        if (r106 != 1) goto L12;
        r100 = (ByteBuffer) r102.L$1;
        ByteBufferChannel r107 = (ByteBufferChannel) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L24:
        io.ktor.utils.io.internal.e r108 = r107.joining;
        if (r108 == null) goto L27;
        A0(r107, r108);
    L27:
        r102.L$0 = null;
        r102.L$1 = null;
        r102.label = 3;
        io.ktor.utils.io.internal.e r109 = r107.joining;
        if (r109 == null) goto L30;
        A0(r107, r109);
    L30:
        int r110 = r107.R0(r100);
        if (r110 <= 0) goto L34;
        Object r111 = Boxing.boxInt(r110);
    L33:
        r104 = r111;
        if (r104 != r105) goto L40;
        return r105;
    L40:
        return r104;
    L34:
        io.ktor.utils.io.internal.e r112 = r107.joining;
        if (r112 == null) goto L37;
        A0(r107, r112);
    L37:
        r111 = r107.U0(r100, r102);
        goto L33
    L12:
        if (r106 == 2) goto L17;
        if (r106 != 3) goto L16;
        ResultKt.throwOnFailure(r104);
        goto L40
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r104);
        return r104;
    L20:
        ResultKt.throwOnFailure(r104);
        r102.L$0 = this;
        r102.L$1 = r100;
        r102.label = 1;
        if (d1(1, r102) != r105) goto L23;
        return r105;
    L23:
        r107 = this;
    L7:
        r102 = new ByteBufferChannel$writeAvailableSuspend$1(this, r101);
        goto L8
    }

    public final int V(ByteBuffer r100, int r101) {
        if (r101 >= (r100.capacity() - this.f491995d)) goto L5;
        return r101;
    L5:
        return r101 - (r100.capacity() - this.f491995d);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x005b -> B:27:0x005e). Please report as a decompilation issue!!! */
    public final Object W0(io.ktor.utils.io.core.a r100, Continuation<? super Unit> r101) {
        if ((r101 instanceof ByteBufferChannel$writeFullySuspend$3) == false) goto L7;
        ByteBufferChannel$writeFullySuspend$3 r102 = (ByteBufferChannel$writeFullySuspend$3) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L18;
        if (r106 != 1) goto L12;
        r100 = (io.ktor.utils.io.core.a) r102.L$1;
        ByteBufferChannel r107 = (ByteBufferChannel) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L27:
        io.ktor.utils.io.internal.e r108 = r107.joining;
        if (r108 == null) goto L30;
        A0(r107, r108);
    L30:
        r107.Q0(r100);
    L20:
        if (r100.f492022c <= r100.f492021b) goto L22;
        boolean r109 = true;
    L23:
        if (r109 == false) goto L32;
        r102.L$0 = r107;
        r102.L$1 = r100;
        r102.label = 1;
        if (r107.O0(1, r102) != r105) goto L27;
        return r105;
    L32:
        return Unit.INSTANCE;
    L22:
        r109 = false;
        goto L23
    L12:
        if (r106 != 2) goto L16;
        ResultKt.throwOnFailure(r104);
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r104);
        r107 = this;
    L7:
        r102 = new ByteBufferChannel$writeFullySuspend$3(this, r101);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0056 -> B:24:0x0059). Please report as a decompilation issue!!! */
    public final Object X0(ByteBuffer r100, Continuation<? super Unit> r101) {
        if ((r101 instanceof ByteBufferChannel$writeFullySuspend$1) == false) goto L7;
        ByteBufferChannel$writeFullySuspend$1 r102 = (ByteBufferChannel$writeFullySuspend$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L18;
        if (r106 != 1) goto L12;
        r100 = (ByteBuffer) r102.L$1;
        ByteBufferChannel r107 = (ByteBufferChannel) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L24:
        io.ktor.utils.io.internal.e r108 = r107.joining;
        if (r108 == null) goto L27;
        A0(r107, r108);
    L27:
        r107.R0(r100);
    L20:
        if (r100.hasRemaining() == false) goto L29;
        r102.L$0 = r107;
        r102.L$1 = r100;
        r102.label = 1;
        if (r107.O0(1, r102) != r105) goto L24;
        return r105;
    L29:
        return Unit.INSTANCE;
    L12:
        if (r106 != 2) goto L16;
        ResultKt.throwOnFailure(r104);
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r104);
        r107 = this;
    L7:
        r102 = new ByteBufferChannel$writeFullySuspend$1(this, r101);
        goto L8
    }

    @Override // io.ktor.utils.io.p
    public final ByteBuffer b(int r100, int r101) {
        io.ktor.utils.io.internal.h r102 = (io.ktor.utils.io.internal.h) this._state;
        int r103 = r102.f492083b._availableForRead$internal;
        int r104 = this.f491996e;
        if (r103 >= (r101 + r100)) goto L6;
        return null;
    L6:
        if (r102.a() == true) goto L17;
        if ((r102 instanceof io.ktor.utils.io.internal.h.d) == false) goto L10;
    L12:
        ByteBuffer r105 = r102.b();
        e0(r105, V(r105, r104 + r100), r103 - r100);
        if (r105.remaining() >= r101) goto L15;
        return null;
    L15:
        return r105;
    L10:
        if ((r102 instanceof io.ktor.utils.io.internal.h.e) == true) goto L12;
    L17:
        if (G0() != null) goto L20;
        return null;
    L20:
        return b(r100, r101);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x005e -> B:28:0x0061). Please report as a decompilation issue!!! */
    public final Object b1(io.ktor.utils.io.core.k r100, Continuation<? super Unit> r101) {
        if ((r101 instanceof ByteBufferChannel$writePacketSuspend$1) == false) goto L7;
        ByteBufferChannel$writePacketSuspend$1 r102 = (ByteBufferChannel$writePacketSuspend$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L22;
        if (r106 != 1) goto L12;
        r100 = (io.ktor.utils.io.core.k) r102.L$1;
        ByteBufferChannel r107 = (ByteBufferChannel) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L31
    L28:
        io.ktor.utils.io.internal.e r108 = r107.joining;     // Catch: Throwable -> L31
        if (r108 == null) goto L33;
        A0(r107, r108);     // Catch: Throwable -> L31
    L33:
        r107.N0(r100);     // Catch: Throwable -> L31
    L24:
        if ((!r100.i()) == false) goto L35;
        r102.L$0 = r107;     // Catch: Throwable -> L31
        r102.L$1 = r100;     // Catch: Throwable -> L31
        r102.label = 1;     // Catch: Throwable -> L31
        if (r107.d1(1, r102) != r105) goto L28;
        return r105;
    L35:
        r100.q();
        return Unit.INSTANCE;
    L12:
        if (r106 != 2) goto L18;
        io.ktor.utils.io.core.k r109 = (io.ktor.utils.io.core.k) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L31
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L31
        r109.q();
        return r110;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L22:
        ResultKt.throwOnFailure(r104);
        r107 = this;
    L31:
        th = move-exception;
        r100.q();
        throw th;
    L7:
        r102 = new ByteBufferChannel$writePacketSuspend$1(this, r101);
        goto L8
    }

    public final Object d1(int r100, Continuation<? super Unit> r110) {
        if ((r110 instanceof ByteBufferChannel$writeSuspend$3) == false) goto L7;
        ByteBufferChannel$writeSuspend$3 r101 = (ByteBufferChannel$writeSuspend$3) r110;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r111 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        r100 = r101.I$0;
        ByteBufferChannel r105 = (ByteBufferChannel) r101.L$0;
        ResultKt.throwOnFailure(r111);
    L16:
        if (r105.f1(r100) == false) goto L63;
        r101.L$0 = r105;
        r101.I$0 = r100;
        r101.label = 1;
        kotlinx.coroutines.j r112 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r101), 1);
        r112.C();
    L18:
        io.ktor.utils.io.internal.c r106 = (io.ktor.utils.io.internal.c) r105._closed;
        if (r106 != null) goto L61;
        if (r105.f1(r100) == false) goto L22;
    L23:
        boolean r107 = false;
        if (((Continuation) r105._writeOp) != null) goto L26;
        boolean r108 = true;
    L27:
        if (r108 == false) goto L60;
        if (r105.f1(r100) == false) goto L50;
        AtomicReferenceFieldUpdater r109 = f491992o;
    L33:
        if (r109.compareAndSet(r105, null, r112) == true) goto L34;
        if (r109.get(r105) == null) goto L33;
        boolean r113 = false;
    L38:
        if (r113 == false) goto L23;
        if (r105.f1(r100) == true) goto L49;
        AtomicReferenceFieldUpdater r114 = f491992o;
    L43:
        if (r114.compareAndSet(r105, r112, null) == true) goto L44;
        if (r114.get(r105) == r112) goto L43;
        boolean r115 = false;
    L48:
        if (r115 == true) goto L50;
    L44:
        r115 = true;
    L49:
        r107 = true;
        goto L50
    L34:
        r113 = true;
    L50:
        if (r107 == false) goto L18;
    L51:
        r105.a0(r100);
        if (r105.I0() == false) goto L54;
        r105.D0();
    L54:
        Object r116 = r112.B();
        if (r116 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L57;
        DebugProbesKt.probeCoroutineSuspended(r101);
    L57:
        if (r116 != r103) goto L16;
        return r103;
    L60:
        throw new IllegalStateException("Operation is already in progress".toString());
    L26:
        r108 = false;
        goto L27
    L22:
        Result.Companion r117 = Result.Companion;
        r112.resumeWith(Result.m9449constructorimpl(Unit.INSTANCE));
        goto L51
    L61:
        io.ktor.utils.io.a.a(r106.a());
        throw null;
    L63:
        io.ktor.utils.io.internal.c r118 = (io.ktor.utils.io.internal.c) r105._closed;
        if (r118 == null) goto L66;
        io.ktor.utils.io.a.a(r118.a());
        throw null;
    L66:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        r105 = this;
    L7:
        r101 = new ByteBufferChannel$writeSuspend$3(this, r110);
        goto L8
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object e(int r100, Continuation<? super io.ktor.utils.io.core.k> r101) {
        io.ktor.utils.io.internal.c r102 = (io.ktor.utils.io.internal.c) this._closed;
        if (r102 == null) goto L9;
        Throwable r103 = r102.f492072a;
        if (r103 == null) goto L9;
        io.ktor.utils.io.a.a(r103);
        throw null;
    L9:
        if (r100 == 0) goto L31;
        io.ktor.utils.io.core.j r104 = new io.ktor.utils.io.core.j(null);
        ByteBuffer r105 = io.ktor.utils.io.internal.f.f492076b.Q5();
    L12:
        if (r100 <= 0) goto L23;
        r105.clear();     // Catch: Throwable -> L20
        if (r105.remaining() <= r100) goto L16;
        r105.limit(r100);     // Catch: Throwable -> L20
    L16:
        int r106 = g0(r105);     // Catch: Throwable -> L20
        if (r106 == 0) goto L23;
        r105.flip();     // Catch: Throwable -> L20
        io.ktor.utils.io.core.r.a(r104, r105);     // Catch: Throwable -> L20
        r100 = r100 - r106;
    L20:
        th = move-exception;
        io.ktor.utils.io.internal.f.f492076b.Rl(r105);
        r104.close();
        throw th;
    L23:
        if (r100 != 0) goto L26;
        io.ktor.utils.io.internal.f.f492076b.Rl(r105);
        return r104.m();
    L26:
        return r0(r100, r104, r105, r101);
    L31:
        return io.ktor.utils.io.core.k.f492034h;
    }

    @Override // io.ktor.utils.io.q
    public final Object f(int r100, Continuation<? super Boolean> r101) {
        boolean r102 = false;
        if (r100 < 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L35;
        if (r100 > 4088) goto L10;
        r102 = true;
    L10:
        if (r102 == false) goto L33;
        if (((io.ktor.utils.io.internal.h) this._state).f492083b._availableForRead$internal < r100) goto L21;
        if (((io.ktor.utils.io.internal.h) this._state).a() == false) goto L16;
    L17:
        G0();
    L19:
        return Boxing.boxBoolean(true);
    L16:
        if ((((io.ktor.utils.io.internal.h) this._state) instanceof io.ktor.utils.io.internal.h.g) == false) goto L19;
    L21:
        if (((io.ktor.utils.io.internal.h) this._state).a() == true) goto L31;
        if ((((io.ktor.utils.io.internal.h) this._state) instanceof io.ktor.utils.io.internal.h.g) == true) goto L31;
        if (r100 != 1) goto L29;
        return u0(1, r101);
    L29:
        return t0(r100, r101);
    L31:
        return Q(r100, r101);
    L33:
        throw new IllegalArgumentException(("atLeast parameter shouldn't be larger than max buffer size of 4088: " + r100).toString());
    L35:
        throw new IllegalArgumentException(("atLeast parameter shouldn't be negative: " + r100).toString());
    L5:
        r103 = false;
        goto L6
    }

    public final void f0(ByteBuffer r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "buffer");
        e0(r100, this.f491997f, r101);
    }

    @Override // io.ktor.utils.io.d
    public final Object g(Function1<? super ByteBuffer, Boolean> r100, Continuation<? super Unit> r101) {
        io.ktor.utils.io.internal.e r102 = this.joining;
        if (r102 == null) goto L5;
        A0(this, r102);
    L5:
        ByteBuffer r103 = H0();
        boolean r104 = true;
        if (r103 == null) goto L18;
        io.ktor.utils.io.internal.j r105 = ((io.ktor.utils.io.internal.h) this._state).f492083b;
        io.ktor.utils.io.internal.c r106 = (io.ktor.utils.io.internal.c) this._closed;     // Catch: Throwable -> L31
        if (r106 != null) goto L29;
        boolean r107 = h1(r103, r105, r100);     // Catch: Throwable -> L31
        if (r105.d() == false) goto L15;
    L16:
        a0(1);
    L17:
        C0();
        M0();
        r104 = r107;
        goto L18
    L15:
        if (this.f491993b == false) goto L17;
    L29:
        io.ktor.utils.io.a.a(r106.a());     // Catch: Throwable -> L31
        throw null;     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        if (r105.d() == false) goto L35;
    L36:
        a0(1);
    L37:
        C0();
        M0();
        throw th;
    L35:
        if (this.f491993b == false) goto L37;
    L18:
        if (r104 == false) goto L40;
        io.ktor.utils.io.internal.c r108 = (io.ktor.utils.io.internal.c) this._closed;
        if (r108 != null) goto L27;
        Object r109 = i1(r100, r101);
        if (r109 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L26;
        return r109;
    L26:
        return Unit.INSTANCE;
    L27:
        io.ktor.utils.io.a.a(r108.a());
        throw null;
    L40:
        return Unit.INSTANCE;
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object h(long r100, Continuation<? super io.ktor.utils.io.core.k> r101) {
        if (c() == false) goto L29;
        Throwable r102 = d();
        if (r102 != null) goto L26;
        io.ktor.utils.io.core.j r103 = new io.ktor.utils.io.core.j(null);
        io.ktor.utils.io.core.internal.a r104 = io.ktor.utils.io.core.internal.c.c(r103, 1, null);     // Catch: Throwable -> L23
    L30:
        if ((r104.f492024e - r104.f492022c) <= r100) goto L11;
        r104.f((int) r100);     // Catch: Throwable -> L20
    L11:
        boolean r105 = false;
        r100 = r100 - ((long) i0(this, r104, 0, 6));     // Catch: Throwable -> L20
        if (r100 > 0) goto L14;
    L16:
        if (r105 == false) goto L19;
        r104 = io.ktor.utils.io.core.internal.c.c(r103, 1, r104);     // Catch: Throwable -> L20
        goto L30
    L19:
        r103.a();     // Catch: Throwable -> L23
        return r103.m();
    L14:
        if (E() == true) goto L16;
        r105 = true;
        goto L16
    L20:
        th = move-exception;
        r103.a();     // Catch: Throwable -> L23
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        r103.close();
        throw th;
    L26:
        io.ktor.utils.io.a.a(r102);
        throw null;
    L29:
        return s0(r100, r101);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00b6 -> B:33:0x00b9). Please report as a decompilation issue!!! */
    public final Object i1(Function1<? super ByteBuffer, Boolean> r110, Continuation<? super Unit> r111) {
        if ((r111 instanceof ByteBufferChannel$writeWhileSuspend$1) == false) goto L7;
        ByteBufferChannel$writeWhileSuspend$1 r100 = (ByteBufferChannel$writeWhileSuspend$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L20;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        ResultKt.throwOnFailure(r102);
    L60:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        long r105 = r100.J$0;
        ByteBufferChannel r106 = (ByteBufferChannel) r100.L$8;
        ByteBuffer r112 = (ByteBuffer) r100.L$7;
        io.ktor.utils.io.internal.j r113 = (io.ktor.utils.io.internal.j) r100.L$6;
        io.ktor.utils.io.internal.j r114 = (io.ktor.utils.io.internal.j) r100.L$5;
        ByteBufferChannel r115 = (ByteBufferChannel) r100.L$4;
        ByteBufferChannel r116 = (ByteBufferChannel) r100.L$3;
        Ref.BooleanRef r117 = (Ref.BooleanRef) r100.L$2;
        Function1<? super ByteBuffer, Boolean> r107 = (Function1) r100.L$1;
        ByteBufferChannel r108 = (ByteBufferChannel) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L18
        Function1<? super ByteBuffer, Boolean> r109 = r107;
    L34:
        if (r106.joining != null) goto L41;
        if (r106.h1(r112, r113, r109) == true) goto L39;
        r117.element = false;     // Catch: Throwable -> L18
        goto L41
    L39:
        if (((io.ktor.utils.io.internal.c) r106._closed) != null) goto L41;
    L30:
        r100.L$0 = r108;     // Catch: Throwable -> L18
        r100.L$1 = r109;     // Catch: Throwable -> L18
        r100.L$2 = r117;     // Catch: Throwable -> L18
        r100.L$3 = r116;     // Catch: Throwable -> L18
        r100.L$4 = r115;     // Catch: Throwable -> L18
        r100.L$5 = r114;     // Catch: Throwable -> L18
        r100.L$6 = r113;     // Catch: Throwable -> L18
        r100.L$7 = r112;     // Catch: Throwable -> L18
        r100.L$8 = r106;     // Catch: Throwable -> L18
        r100.J$0 = r105;     // Catch: Throwable -> L18
        r100.label = 1;     // Catch: Throwable -> L18
        if (r106.d1(1, r100) != r103) goto L34;
        return r103;
    L41:
        if (r114.d() == false) goto L43;
    L44:
        r115.a0(1);
    L45:
        if (r115 == r116) goto L47;
        r116.totalBytesWritten += r115.totalBytesWritten - r105;
    L47:
        r115.C0();
        r115.M0();
    L49:
        if (r117.element == false) goto L51;
        io.ktor.utils.io.internal.c r118 = (io.ktor.utils.io.internal.c) r108._closed;
        if (r118 == null) goto L55;
        io.ktor.utils.io.a.a(r118.a());
        throw null;
    L55:
        if (r108.joining == null) goto L62;
        r100.L$0 = null;
        r100.L$1 = null;
        r100.L$2 = null;
        r100.L$3 = null;
        r100.L$4 = null;
        r100.L$5 = null;
        r100.L$6 = null;
        r100.L$7 = null;
        r100.L$8 = null;
        r100.label = 2;
        if (r108.g(r109, r100) != r103) goto L60;
        return r103;
    L62:
        return Unit.INSTANCE;
    L51:
        return Unit.INSTANCE;
    L43:
        if (r115.f491993b == false) goto L45;
    L18:
        th = th;
        io.ktor.utils.io.internal.j r119 = r114;
    L71:
        if (r119.d() == false) goto L73;
    L74:
        r115.a0(1);
    L75:
        if (r115 == r116) goto L77;
        r116.totalBytesWritten += r115.totalBytesWritten - r105;
    L77:
        r115.C0();
        r115.M0();
        throw th;
    L73:
        if (r115.f491993b == false) goto L75;
    L20:
        ResultKt.throwOnFailure(r102);
        Ref.BooleanRef r120 = new Ref.BooleanRef();
        r120.element = true;
        io.ktor.utils.io.internal.e r121 = this.joining;
        if (r121 == null) goto L23;
        A0(this, r121);
    L23:
        ByteBuffer r122 = H0();
        if (r122 != null) goto L26;
        r117 = r120;
        r108 = this;
        r109 = r110;
        goto L49
    L26:
        r119 = ((io.ktor.utils.io.internal.h) this._state).f492083b;
        r105 = this.totalBytesWritten;
        io.ktor.utils.io.internal.c r123 = (io.ktor.utils.io.internal.c) this._closed;     // Catch: Throwable -> L68
        if (r123 != null) goto L66;
        r117 = r120;
        r108 = this;
        r115 = r108;
        r116 = r115;
        r112 = r122;
        r113 = r119;
        r114 = r113;
        r109 = r110;
        r106 = r116;
        goto L30
    L66:
        io.ktor.utils.io.a.a(r123.a());     // Catch: Throwable -> L68
        throw null;     // Catch: Throwable -> L68
    L68:
        th = th;
        r115 = this;
        r116 = r115;
    L7:
        r100 = new ByteBufferChannel$writeWhileSuspend$1(this, r111);
        goto L8
    }

    public final Object j0(io.ktor.utils.io.core.internal.a r100, Continuation<? super Integer> r101) {
        if ((r101 instanceof ByteBufferChannel$readAvailableSuspend$3) == false) goto L7;
        ByteBufferChannel$readAvailableSuspend$3 r102 = (ByteBufferChannel$readAvailableSuspend$3) r101;
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
    L27:
        return r104;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r100 = (io.ktor.utils.io.core.internal.a) r102.L$1;
        ByteBufferChannel r107 = (ByteBufferChannel) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L21:
        if (((Boolean) r104).booleanValue() == false) goto L23;
        r102.L$0 = null;
        r102.L$1 = null;
        r102.label = 2;
        r104 = r107.D(r100, r102);
        if (r104 != r105) goto L27;
        return r105;
    L23:
        return Boxing.boxInt(-1);
    L16:
        ResultKt.throwOnFailure(r104);
        r102.L$0 = this;
        r102.L$1 = r100;
        r102.label = 1;
        r104 = t0(1, r102);
        if (r104 != r105) goto L19;
        return r105;
    L19:
        r107 = this;
    L7:
        r102 = new ByteBufferChannel$readAvailableSuspend$3(this, r101);
        goto L8
    }

    public final Object k0(ByteBuffer r100, Continuation<? super Integer> r101) {
        if ((r101 instanceof ByteBufferChannel$readAvailableSuspend$2) == false) goto L7;
        ByteBufferChannel$readAvailableSuspend$2 r102 = (ByteBufferChannel$readAvailableSuspend$2) r101;
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
    L27:
        return r104;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r100 = (ByteBuffer) r102.L$1;
        ByteBufferChannel r107 = (ByteBufferChannel) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L21:
        if (((Boolean) r104).booleanValue() == false) goto L23;
        r102.L$0 = null;
        r102.L$1 = null;
        r102.label = 2;
        r104 = r107.B(r100, r102);
        if (r104 != r105) goto L27;
        return r105;
    L23:
        return Boxing.boxInt(-1);
    L16:
        ResultKt.throwOnFailure(r104);
        r102.L$0 = this;
        r102.L$1 = r100;
        r102.label = 1;
        r104 = t0(1, r102);
        if (r104 != r105) goto L19;
        return r105;
    L19:
        r107 = this;
    L7:
        r102 = new ByteBufferChannel$readAvailableSuspend$2(this, r101);
        goto L8
    }

    @Override // io.ktor.utils.io.d
    public final Object l(io.ktor.utils.io.core.k r100, ContinuationImpl r101) {
        io.ktor.utils.io.internal.e r102 = this.joining;
        if (r102 == null) goto L23;
        A0(this, r102);
    L23:
    L20:
        th = move-exception;
        r100.q();
        throw th;
    L6:
        if ((!r100.i()) == false) goto L10;
        if (N0(r100) != 0) goto L23;
    L10:
        if (r100.k() <= 0) goto L19;
        io.ktor.utils.io.internal.e r103 = this.joining;
        if (r103 == null) goto L14;
        A0(this, r103);
    L14:
        Object r104 = b1(r100, r101);
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L29;
        return r104;
    L29:
        return Unit.INSTANCE;
    L19:
        return Unit.INSTANCE;
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object p(long r100, Continuation<? super Long> r110) {
        long r101 = 0;
        if (r100 < 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L29;
        ByteBuffer r103 = G0();
        if (r103 != null) goto L10;
    L9:
        long r104 = r101;
        if (r104 == r100) goto L24;
        if (E() == true) goto L24;
        return Y(r104, r100, r110);
    L24:
        return Boxing.boxLong(r104);
    L10:
        io.ktor.utils.io.internal.j r105 = ((io.ktor.utils.io.internal.h) this._state).f492083b;
    L25:
        th = move-exception;
        B0();
        M0();
        throw th;
    L12:
        if (r105._availableForRead$internal == 0) goto L16;
        int r106 = r105.h((int) Math.min(SieveCacheKt.NodeLinkMask, r100));     // Catch: Throwable -> L25
        S(r103, r105, r106);     // Catch: Throwable -> L25
        r101 = ((long) r106) + 0;
    L16:
        B0();
        M0();
        goto L9
    L29:
        throw new IllegalArgumentException(("max shouldn't be negative: " + r100).toString());
    L5:
        r102 = false;
        goto L6
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0098 -> B:31:0x009b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00a5 -> B:35:0x00a6). Please report as a decompilation issue!!! */
    public final Object s0(long r110, Continuation<? super io.ktor.utils.io.core.k> r111) {
        if ((r111 instanceof ByteBufferChannel$readRemainingSuspend$1) == false) goto L7;
        ByteBufferChannel$readRemainingSuspend$1 r100 = (ByteBufferChannel$readRemainingSuspend$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L18;
        if (r103 != 1) goto L17;
        io.ktor.utils.io.core.internal.a r113 = (io.ktor.utils.io.core.internal.a) r100.L$4;
        io.ktor.utils.io.core.q r114 = (io.ktor.utils.io.core.q) r100.L$3;
        Ref.LongRef r104 = (Ref.LongRef) r100.L$2;
        io.ktor.utils.io.core.j r105 = (io.ktor.utils.io.core.j) r100.L$1;
        ByteBufferChannel r106 = (ByteBufferChannel) r100.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: Throwable -> L14
        r105 = r105;
        r114 = r114;
    L31:
        io.ktor.utils.io.core.j r107 = r105;
        io.ktor.utils.io.core.q r115 = r114;
        if (((Boolean) r112).booleanValue() == false) goto L34;
        boolean r116 = true;
        io.ktor.utils.io.core.j r108 = r105;
        io.ktor.utils.io.core.q r117 = r114;
    L35:
        if (r116 == false) goto L38;
        r113 = io.ktor.utils.io.core.internal.c.c(r117, 1, r113);     // Catch: Throwable -> L14
        io.ktor.utils.io.core.j r109 = r108;
        io.ktor.utils.io.core.q r118 = r117;
    L21:
        long r119 = r113.f492024e - r113.f492022c;     // Catch: Throwable -> L14
        long r120 = r104.element;     // Catch: Throwable -> L14
        if (r119 <= r120) goto L24;
        r113.f((int) r120);     // Catch: Throwable -> L14
    L24:
        long r121 = r104.element - ((long) i0(r106, r113, 0, 6));     // Catch: Throwable -> L14
        r104.element = r121;     // Catch: Throwable -> L14
        r107 = r109;
        r115 = r118;
        if (r121 <= 0) goto L34;
        r107 = r109;
        r115 = r118;
        if (r106.E() == true) goto L34;
        r100.L$0 = r106;     // Catch: Throwable -> L14
        r100.L$1 = r109;     // Catch: Throwable -> L14
        r100.L$2 = r104;     // Catch: Throwable -> L14
        r100.L$3 = r118;     // Catch: Throwable -> L14
        r100.L$4 = r113;     // Catch: Throwable -> L14
        r100.label = 1;     // Catch: Throwable -> L14
        r112 = r106.t0(1, r100);     // Catch: Throwable -> L14
        r105 = r109;
        r114 = r118;
        if (r112 != r102) goto L31;
        return r102;
    L38:
        r117.a();     // Catch: Throwable -> L45
        Throwable r122 = r106.d();     // Catch: Throwable -> L45
        if (r122 == null) goto L41;
        throw r122;     // Catch: Throwable -> L45
    L41:
        return r108.m();
    L34:
        r116 = false;
        r108 = r107;
        r117 = r115;
        goto L35
    L14:
        th = move-exception;
        r114.a();     // Catch: Throwable -> L45
        throw th;     // Catch: Throwable -> L45
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r112);
        io.ktor.utils.io.core.j r123 = new io.ktor.utils.io.core.j(null);
        Ref.LongRef r124 = new Ref.LongRef();     // Catch: Throwable -> L47
        r124.element = r110;     // Catch: Throwable -> L47
        r113 = io.ktor.utils.io.core.internal.c.c(r123, 1, null);     // Catch: Throwable -> L47
        r106 = this;
        io.ktor.utils.io.core.j r125 = r123;
        r104 = r124;
        r109 = r125;
        r118 = r125;
    L47:
        th = th;
    L48:
        r123.close();
        throw th;
    L45:
        th = th;
        r123 = r105;
    L7:
        r100 = new ByteBufferChannel$readRemainingSuspend$1(this, r111);
        goto L8
    }

    public final Object t0(int r100, Continuation<? super Boolean> r101) {
        boolean r102 = true;
        if (((io.ktor.utils.io.internal.h) this._state).f492083b._availableForRead$internal >= r100) goto L5;
        io.ktor.utils.io.internal.c r103 = (io.ktor.utils.io.internal.c) this._closed;
        if (r103 == null) goto L24;
        Throwable r104 = r103.f492072a;
        if (r104 != null) goto L22;
        io.ktor.utils.io.internal.j r105 = ((io.ktor.utils.io.internal.h) this._state).f492083b;
        if (r105.c() == true) goto L13;
    L15:
        r102 = false;
    L17:
        if (((Continuation) this._readOp) != null) goto L21;
        return Boxing.boxBoolean(r102);
    L21:
        throw new IllegalStateException("Read operation is already in progress");
    L13:
        if (r105._availableForRead$internal < r100) goto L15;
    L22:
        io.ktor.utils.io.a.a(r104);
        throw null;
    L24:
        if (r100 != 1) goto L28;
        return u0(1, r101);
    L28:
        return v0(r100, r101);
    L5:
        return Boxing.boxBoolean(true);
    }

    public final Object u0(int r100, Continuation<? super Boolean> r101) {
        if ((r101 instanceof ByteBufferChannel$readSuspendImpl$1) == false) goto L7;
        ByteBufferChannel$readSuspendImpl$1 r102 = (ByteBufferChannel$readSuspendImpl$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L18;
        if (r106 != 1) goto L17;
        ByteBufferChannel r107 = (ByteBufferChannel) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L14
    L38:
        return r104;
    L14:
        Throwable th10 = th;
    L41:
        r107._readOp = null;
        throw th10;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r104);
        io.ktor.utils.io.internal.h r108 = (io.ktor.utils.io.internal.h) this._state;
        if (r108.f492083b._availableForRead$internal < r100) goto L21;
    L29:
        boolean r109 = false;
    L30:
        if (r109 == false) goto L32;
        r102.L$0 = this;     // Catch: Throwable -> L39
        r102.I$0 = r100;     // Catch: Throwable -> L39
        r102.label = 1;     // Catch: Throwable -> L39
        io.ktor.utils.io.internal.b<Boolean> r110 = this.f492000i;     // Catch: Throwable -> L39
        J0(r100, r110);     // Catch: Throwable -> L39
        r104 = r110.e(IntrinsicsKt.intercepted(r102));     // Catch: Throwable -> L39
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L36;
        DebugProbesKt.probeCoroutineSuspended(r102);     // Catch: Throwable -> L39
    L36:
        if (r104 != r105) goto L38;
        return r105;
    L39:
        th = move-exception;
        th10 = th;
        r107 = this;
        goto L41
    L32:
        return Boxing.boxBoolean(true);
    L21:
        if (this.joining != null) goto L23;
    L28:
        r109 = true;
        goto L30
    L23:
        if (((Continuation) this._writeOp) == null) goto L28;
        if (r108 == io.ktor.utils.io.internal.h.a.f492084c) goto L29;
        if ((r108 instanceof io.ktor.utils.io.internal.h.b) == true) goto L29;
    L7:
        r102 = new ByteBufferChannel$readSuspendImpl$1(this, r101);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x0088 -> B:39:0x008b). Please report as a decompilation issue!!! */
    public final Object v0(int r100, Continuation<? super Boolean> r101) {
        if ((r101 instanceof ByteBufferChannel$readSuspendLoop$1) == false) goto L7;
        ByteBufferChannel$readSuspendLoop$1 r102 = (ByteBufferChannel$readSuspendLoop$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        boolean r107 = false;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        r100 = r102.I$0;
        ByteBufferChannel r108 = (ByteBufferChannel) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L40:
        if (((Boolean) r104).booleanValue() == false) goto L42;
    L16:
        if (((io.ktor.utils.io.internal.h) r108._state).f492083b._availableForRead$internal >= r100) goto L18;
        io.ktor.utils.io.internal.c r109 = (io.ktor.utils.io.internal.c) r108._closed;
        if (r109 == null) goto L36;
        Throwable r110 = r109.f492072a;
        if (r110 != null) goto L34;
        io.ktor.utils.io.internal.j r111 = ((io.ktor.utils.io.internal.h) r108._state).f492083b;
        if (r111.c() == false) goto L29;
        if (r111._availableForRead$internal < r100) goto L29;
        r107 = true;
    L29:
        if (((Continuation) r108._readOp) != null) goto L33;
        return Boxing.boxBoolean(r107);
    L33:
        throw new IllegalStateException("Read operation is already in progress");
    L34:
        io.ktor.utils.io.a.a(r110);
        throw null;
    L36:
        r102.L$0 = r108;
        r102.I$0 = r100;
        r102.label = 1;
        r104 = r108.u0(r100, r102);
        if (r104 != r105) goto L40;
        return r105;
    L18:
        return Boxing.boxBoolean(true);
    L42:
        return Boxing.boxBoolean(false);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        r108 = this;
    L7:
        r102 = new ByteBufferChannel$readSuspendLoop$1(this, r101);
        goto L8
    }

    @Override // io.ktor.utils.io.d
    public final Object x(ByteBuffer r100, ContinuationImpl r101) {
        io.ktor.utils.io.internal.e r102 = this.joining;
        if (r102 == null) goto L5;
        A0(this, r102);
    L5:
        R0(r100);
        if (r100.hasRemaining() == false) goto L13;
        Object r103 = X0(r100, r101);
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L12;
        return r103;
    L12:
        return Unit.INSTANCE;
    L13:
        return Unit.INSTANCE;
    }

    @Override // io.ktor.utils.io.d
    public final Object y(io.ktor.utils.io.core.a r100, ContinuationImpl r101) {
        Q0(r100);
        if (r100.f492022c <= r100.f492021b) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L13;
        Object r103 = W0(r100, r101);
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L12;
        return r103;
    L12:
        return Unit.INSTANCE;
    L13:
        return Unit.INSTANCE;
    L5:
        r102 = false;
        goto L6
    }

    public ByteBufferChannel(boolean r100, io.ktor.utils.io.pool.e<io.ktor.utils.io.internal.h.c> r101, int r102) {
        Intrinsics.checkNotNullParameter(r101, "pool");
        this.f491993b = r100;
        this.f491994c = r101;
        this.f491995d = r102;
        this._state = io.ktor.utils.io.internal.h.a.f492084c;
        this._closed = null;
        this._readOp = null;
        this._writeOp = null;
        this.f491998g = new io.ktor.utils.io.internal.g(this);
        this.f491999h = new WriteSessionImpl(this);
        this.f492000i = new io.ktor.utils.io.internal.b();
        this.f492001j = new io.ktor.utils.io.internal.b();
        this.f492002k = new ByteBufferChannel$writeSuspension$1(this);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x010a -> B:54:0x010d). Please report as a decompilation issue!!! */
    public static Object V0(ByteBufferChannel r100, byte r101, Continuation<? super Unit> r110) {
        if ((r110 instanceof ByteBufferChannel$writeByte$1) == false) goto L7;
        ByteBufferChannel$writeByte$1 r102 = (ByteBufferChannel$writeByte$1) r110;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r111 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(r102.label) {
            case 0: goto L20;
            case 1: goto L19;
            case 2: goto L19;
            case 3: goto L19;
            case 4: goto L18;
            case 5: goto L13;
            case 6: goto L19;
            case 7: goto L19;
            case 8: goto L12;
            default: goto L11;
        };
    L12:
        byte r105 = r102.B$0;
        ByteBufferChannel r106 = (ByteBufferChannel) r102.L$1;
        io.ktor.utils.io.internal.e r107 = (io.ktor.utils.io.internal.e) r102.L$0;
        ResultKt.throwOnFailure(r111);
    L60:
        if (((io.ktor.utils.io.internal.h) r106._state) == io.ktor.utils.io.internal.h.f.f492094c) goto L64;
        r102.L$0 = r107;
        r102.L$1 = r106;
        r102.L$2 = null;
        r102.B$0 = r105;
        r102.label = 8;
        if (r106.d1(1, r102) != r104) goto L60;
        return r104;
    L64:
        r107.getClass();
        r102.L$0 = null;
        r102.L$1 = null;
        r102.L$2 = null;
        r102.label = 7;
        throw null;
    L13:
        int r108 = r102.I$0;
        byte r109 = r102.B$0;
        ByteBuffer r112 = (ByteBuffer) r102.L$2;
        ByteBufferChannel r113 = (ByteBufferChannel) r102.L$1;
        io.ktor.utils.io.internal.j r114 = (io.ktor.utils.io.internal.j) r102.L$0;
        ResultKt.throwOnFailure(r111);     // Catch: Throwable -> L16
        byte r115 = r109;
        int r116 = r108;
        r100 = r113;
    L55:
        if (r100.joining == null) goto L69;
        r100.C0();
        r107 = r100.joining;
        Intrinsics.checkNotNull(r107);
        if (((io.ktor.utils.io.internal.h) r100._state) == io.ktor.utils.io.internal.h.f.f492094c) goto L66;
        r106 = r100;
        r105 = r115;
        goto L60
    L66:
        r107.getClass();
        r102.L$0 = null;
        r102.L$1 = null;
        r102.L$2 = null;
        r102.label = 6;
        throw null;
    L69:
        if (r114.k(r116) == true) goto L71;
        boolean r117 = false;
    L81:
        if (r117 == true) goto L88;
    L91:
        r102.L$0 = r114;     // Catch: Throwable -> L83
        r102.L$1 = r100;     // Catch: Throwable -> L83
        r102.L$2 = r112;     // Catch: Throwable -> L83
        r102.B$0 = r115;     // Catch: Throwable -> L83
        r102.I$0 = r116;     // Catch: Throwable -> L83
        r102.label = 5;     // Catch: Throwable -> L83
        if (r100.d1(r116, r102) != r104) goto L55;
        return r104;
    L83:
        th = move-exception;
        r113 = r100;
        Throwable th10 = th;
    L85:
        r113.C0();
        r113.M0();
        throw th10;
    L88:
        return Unit.INSTANCE;
    L71:
        r100.f0(r112, r116);
        if (r112.remaining() >= r116) goto L74;
        r112.limit(r112.capacity());
        r112.put(r115);
        r100.U(r112);
    L75:
        r100.T(r112, r114, r116);
        if (r114.d() == false) goto L78;
    L79:
        r100.a0(1);
    L80:
        r100.C0();
        r100.M0();
        r117 = true;
        goto L81
    L78:
        if (r100.f491993b == false) goto L80;
    L74:
        r112.put(r115);
    L16:
        th10 = th;
        goto L85
    L18:
        r101 = r102.B$0;
        r100 = (ByteBufferChannel) r102.L$1;
        io.ktor.utils.io.internal.e r118 = (io.ktor.utils.io.internal.e) r102.L$0;
        ResultKt.throwOnFailure(r111);
    L28:
        if (((io.ktor.utils.io.internal.h) r100._state) == io.ktor.utils.io.internal.h.f.f492094c) goto L32;
        r102.L$0 = r118;
        r102.L$1 = r100;
        r102.B$0 = r101;
        r102.label = 4;
        if (r100.d1(1, r102) != r104) goto L28;
        return r104;
    L32:
        r118.getClass();
        r102.L$0 = null;
        r102.L$1 = null;
        r102.label = 3;
        throw null;
    L19:
        ResultKt.throwOnFailure(r111);
        goto L88
    L20:
        ResultKt.throwOnFailure(r111);
        io.ktor.utils.io.internal.e r119 = r100.joining;
        if (r119 == null) goto L23;
        A0(r100, r119);
    L23:
        ByteBuffer r120 = r100.H0();
        if (r120 != null) goto L36;
        r118 = r100.joining;
        Intrinsics.checkNotNull(r118);
        if (((io.ktor.utils.io.internal.h) r100._state) != io.ktor.utils.io.internal.h.f.f492094c) goto L28;
        r118.getClass();
        r102.label = 2;
        throw null;
    L36:
        io.ktor.utils.io.internal.j r121 = ((io.ktor.utils.io.internal.h) r100._state).f492083b;
        if (r121.k(1) == true) goto L39;
        boolean r122 = false;
    L49:
        if (r122 == true) goto L88;
        r114 = r121;
        r112 = r120;
        r115 = r101;
        r116 = 1;
        goto L91
    L39:
        r100.f0(r120, 1);
        if (r120.remaining() >= 1) goto L42;
        r120.limit(r120.capacity());
        r120.put(r101);
        r100.U(r120);
    L43:
        r100.T(r120, r121, 1);
        if (r121.d() == false) goto L46;
    L47:
        r100.a0(1);
    L48:
        r100.C0();
        r100.M0();
        r122 = true;
        goto L49
    L46:
        if (r100.f491993b == false) goto L48;
    L42:
        r120.put(r101);
        goto L43
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r102 = new ByteBufferChannel$writeByte$1(r100, r110);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x0106 -> B:54:0x0109). Please report as a decompilation issue!!! */
    public static Object Z0(ByteBufferChannel r100, int r110, Continuation<? super Unit> r111) {
        if ((r111 instanceof ByteBufferChannel$writeInt$1) == false) goto L7;
        ByteBufferChannel$writeInt$1 r101 = (ByteBufferChannel$writeInt$1) r111;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r112 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = 4;
        switch(r101.label) {
            case 0: goto L20;
            case 1: goto L19;
            case 2: goto L19;
            case 3: goto L19;
            case 4: goto L18;
            case 5: goto L13;
            case 6: goto L19;
            case 7: goto L19;
            case 8: goto L12;
            default: goto L11;
        };
    L12:
        int r105 = r101.I$0;
        ByteBufferChannel r113 = (ByteBufferChannel) r101.L$1;
        io.ktor.utils.io.internal.e r106 = (io.ktor.utils.io.internal.e) r101.L$0;
        ResultKt.throwOnFailure(r112);
    L60:
        if (((io.ktor.utils.io.internal.h) r113._state) == io.ktor.utils.io.internal.h.f.f492094c) goto L64;
        r101.L$0 = r106;
        r101.L$1 = r113;
        r101.L$2 = null;
        r101.I$0 = r105;
        r101.label = 8;
        if (r113.d1(1, r101) != r103) goto L60;
        return r103;
    L64:
        r106.getClass();
        r101.L$0 = null;
        r101.L$1 = null;
        r101.L$2 = null;
        r101.label = 7;
        throw null;
    L13:
        int r107 = r101.I$1;
        r110 = r101.I$0;
        ByteBuffer r108 = (ByteBuffer) r101.L$2;
        ByteBufferChannel r109 = (ByteBufferChannel) r101.L$1;
        io.ktor.utils.io.internal.j r114 = (io.ktor.utils.io.internal.j) r101.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: Throwable -> L16
        r104 = r107;
        r100 = r109;
    L55:
        if (r100.joining == null) goto L69;
        r100.C0();
        r106 = r100.joining;
        Intrinsics.checkNotNull(r106);
        if (((io.ktor.utils.io.internal.h) r100._state) == io.ktor.utils.io.internal.h.f.f492094c) goto L66;
        int r115 = r110;
        r113 = r100;
        r105 = r115;
        goto L60
    L66:
        r106.getClass();
        r101.L$0 = null;
        r101.L$1 = null;
        r101.L$2 = null;
        r101.label = 6;
        throw null;
    L69:
        if (r114.k(r104) == true) goto L71;
        boolean r116 = false;
    L81:
        if (r116 == true) goto L88;
    L89:
        r101.L$0 = r114;     // Catch: Throwable -> L83
        r101.L$1 = r100;     // Catch: Throwable -> L83
        r101.L$2 = r108;     // Catch: Throwable -> L83
        r101.I$0 = r110;     // Catch: Throwable -> L83
        r101.I$1 = r104;     // Catch: Throwable -> L83
        r101.label = 5;     // Catch: Throwable -> L83
        if (r100.d1(r104, r101) != r103) goto L55;
        return r103;
    L83:
        th = move-exception;
        r109 = r100;
        Throwable th10 = th;
    L85:
        r109.C0();
        r109.M0();
        throw th10;
    L88:
        return Unit.INSTANCE;
    L71:
        r100.f0(r108, r104);
        if (r108.remaining() >= r104) goto L74;
        r108.limit(r108.capacity());
        r108.putInt(r110);
        r100.U(r108);
    L75:
        r100.T(r108, r114, r104);
        if (r114.d() == false) goto L78;
    L79:
        r100.a0(1);
    L80:
        r100.C0();
        r100.M0();
        r116 = true;
        goto L81
    L78:
        if (r100.f491993b == false) goto L80;
    L74:
        r108.putInt(r110);
    L16:
        th10 = th;
        goto L85
    L18:
        r110 = r101.I$0;
        r100 = (ByteBufferChannel) r101.L$1;
        io.ktor.utils.io.internal.e r117 = (io.ktor.utils.io.internal.e) r101.L$0;
        ResultKt.throwOnFailure(r112);
    L28:
        if (((io.ktor.utils.io.internal.h) r100._state) == io.ktor.utils.io.internal.h.f.f492094c) goto L32;
        r101.L$0 = r117;
        r101.L$1 = r100;
        r101.I$0 = r110;
        r101.label = 4;
        if (r100.d1(1, r101) != r103) goto L28;
        return r103;
    L32:
        r117.getClass();
        r101.L$0 = null;
        r101.L$1 = null;
        r101.label = 3;
        throw null;
    L19:
        ResultKt.throwOnFailure(r112);
        goto L88
    L20:
        ResultKt.throwOnFailure(r112);
        io.ktor.utils.io.internal.e r118 = r100.joining;
        if (r118 == null) goto L23;
        A0(r100, r118);
    L23:
        ByteBuffer r119 = r100.H0();
        if (r119 != null) goto L36;
        r117 = r100.joining;
        Intrinsics.checkNotNull(r117);
        if (((io.ktor.utils.io.internal.h) r100._state) != io.ktor.utils.io.internal.h.f.f492094c) goto L28;
        r117.getClass();
        r101.label = 2;
        throw null;
    L36:
        io.ktor.utils.io.internal.j r120 = ((io.ktor.utils.io.internal.h) r100._state).f492083b;
        if (r120.k(4) == true) goto L39;
        boolean r121 = false;
    L49:
        if (r121 == true) goto L88;
        r114 = r120;
        r108 = r119;
        goto L89
    L39:
        r100.f0(r119, 4);
        if (r119.remaining() >= 4) goto L42;
        r119.limit(r119.capacity());
        r119.putInt(r110);
        r100.U(r119);
    L43:
        r100.T(r119, r120, 4);
        if (r120.d() == false) goto L46;
    L47:
        r100.a0(1);
    L48:
        r100.C0();
        r100.M0();
        r121 = true;
        goto L49
    L46:
        if (r100.f491993b == false) goto L48;
    L42:
        r119.putInt(r110);
        goto L43
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r101 = new ByteBufferChannel$writeInt$1(r100, r111);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x010b -> B:54:0x010e). Please report as a decompilation issue!!! */
    public static Object a1(ByteBufferChannel r110, long r111, Continuation<? super Unit> r112) {
        if ((r112 instanceof ByteBufferChannel$writeLong$1) == false) goto L7;
        ByteBufferChannel$writeLong$1 r100 = (ByteBufferChannel$writeLong$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(r100.label) {
            case 0: goto L20;
            case 1: goto L19;
            case 2: goto L19;
            case 3: goto L19;
            case 4: goto L18;
            case 5: goto L13;
            case 6: goto L19;
            case 7: goto L19;
            case 8: goto L12;
            default: goto L11;
        };
    L12:
        long r114 = r100.J$0;
        ByteBufferChannel r115 = (ByteBufferChannel) r100.L$1;
        io.ktor.utils.io.internal.e r103 = (io.ktor.utils.io.internal.e) r100.L$0;
        ResultKt.throwOnFailure(r113);
    L60:
        if (((io.ktor.utils.io.internal.h) r115._state) == io.ktor.utils.io.internal.h.f.f492094c) goto L64;
        r100.L$0 = r103;
        r100.L$1 = r115;
        r100.L$2 = null;
        r100.J$0 = r114;
        r100.label = 8;
        if (r115.d1(1, r100) != r102) goto L60;
        return r102;
    L64:
        r103.getClass();
        r100.L$0 = null;
        r100.L$1 = null;
        r100.L$2 = null;
        r100.label = 7;
        throw null;
    L13:
        int r116 = r100.I$0;
        long r117 = r100.J$0;
        ByteBuffer r104 = (ByteBuffer) r100.L$2;
        ByteBufferChannel r105 = (ByteBufferChannel) r100.L$1;
        io.ktor.utils.io.internal.j r106 = (io.ktor.utils.io.internal.j) r100.L$0;
        ResultKt.throwOnFailure(r113);     // Catch: Throwable -> L16
        long r118 = r117;
        int r119 = r116;
        r110 = r105;
    L55:
        if (r110.joining == null) goto L69;
        r110.C0();
        r103 = r110.joining;
        Intrinsics.checkNotNull(r103);
        if (((io.ktor.utils.io.internal.h) r110._state) == io.ktor.utils.io.internal.h.f.f492094c) goto L66;
        long r107 = r118;
        r115 = r110;
        r114 = r107;
        goto L60
    L66:
        r103.getClass();
        r100.L$0 = null;
        r100.L$1 = null;
        r100.L$2 = null;
        r100.label = 6;
        throw null;
    L69:
        if (r106.k(r119) == true) goto L71;
        boolean r108 = false;
    L81:
        if (r108 == true) goto L88;
    L89:
        r100.L$0 = r106;     // Catch: Throwable -> L83
        r100.L$1 = r110;     // Catch: Throwable -> L83
        r100.L$2 = r104;     // Catch: Throwable -> L83
        r100.J$0 = r118;     // Catch: Throwable -> L83
        r100.I$0 = r119;     // Catch: Throwable -> L83
        r100.label = 5;     // Catch: Throwable -> L83
        if (r110.d1(r119, r100) != r102) goto L55;
        return r102;
    L83:
        th = move-exception;
        r105 = r110;
        Throwable th10 = th;
    L85:
        r105.C0();
        r105.M0();
        throw th10;
    L88:
        return Unit.INSTANCE;
    L71:
        r110.f0(r104, r119);
        if (r104.remaining() >= r119) goto L74;
        r104.limit(r104.capacity());
        r104.putLong(r118);
        r110.U(r104);
    L75:
        r110.T(r104, r106, r119);
        if (r106.d() == false) goto L78;
    L79:
        r110.a0(1);
    L80:
        r110.C0();
        r110.M0();
        r108 = true;
        goto L81
    L78:
        if (r110.f491993b == false) goto L80;
    L74:
        r104.putLong(r118);
    L16:
        th10 = th;
        goto L85
    L18:
        r111 = r100.J$0;
        r110 = (ByteBufferChannel) r100.L$1;
        io.ktor.utils.io.internal.e r109 = (io.ktor.utils.io.internal.e) r100.L$0;
        ResultKt.throwOnFailure(r113);
    L28:
        if (((io.ktor.utils.io.internal.h) r110._state) == io.ktor.utils.io.internal.h.f.f492094c) goto L32;
        r100.L$0 = r109;
        r100.L$1 = r110;
        r100.J$0 = r111;
        r100.label = 4;
        if (r110.d1(1, r100) != r102) goto L28;
        return r102;
    L32:
        r109.getClass();
        r100.L$0 = null;
        r100.L$1 = null;
        r100.label = 3;
        throw null;
    L19:
        ResultKt.throwOnFailure(r113);
        goto L88
    L20:
        ResultKt.throwOnFailure(r113);
        io.ktor.utils.io.internal.e r120 = r110.joining;
        if (r120 == null) goto L23;
        A0(r110, r120);
    L23:
        ByteBuffer r121 = r110.H0();
        if (r121 != null) goto L36;
        r109 = r110.joining;
        Intrinsics.checkNotNull(r109);
        if (((io.ktor.utils.io.internal.h) r110._state) != io.ktor.utils.io.internal.h.f.f492094c) goto L28;
        r109.getClass();
        r100.label = 2;
        throw null;
    L36:
        io.ktor.utils.io.internal.j r122 = ((io.ktor.utils.io.internal.h) r110._state).f492083b;
        if (r122.k(8) == true) goto L39;
        boolean r123 = false;
    L49:
        if (r123 == true) goto L88;
        r106 = r122;
        r104 = r121;
        r118 = r111;
        r119 = 8;
        goto L89
    L39:
        r110.f0(r121, 8);
        if (r121.remaining() >= 8) goto L42;
        r121.limit(r121.capacity());
        r121.putLong(r111);
        r110.U(r121);
    L43:
        r110.T(r121, r122, 8);
        if (r122.d() == false) goto L46;
    L47:
        r110.a0(1);
    L48:
        r110.C0();
        r110.M0();
        r123 = true;
        goto L49
    L46:
        if (r110.f491993b == false) goto L48;
    L42:
        r121.putLong(r111);
        goto L43
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r100 = new ByteBufferChannel$writeLong$1(r110, r112);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated(message = "Use read { } instead.")
    public static <R> Object c0(ByteBufferChannel r100, Function2<? super q, ? super Continuation<? super R>, ? extends Object> r101, Continuation<? super R> r102) {
        if ((r102 instanceof ByteBufferChannel$lookAheadSuspend$1) == false) goto L7;
        ByteBufferChannel$lookAheadSuspend$1 r103 = (ByteBufferChannel$lookAheadSuspend$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean r107 = true;
        switch(r103.label) {
            case 0: goto L26;
            case 1: goto L25;
            case 2: goto L24;
            case 3: goto L19;
            case 4: goto L18;
            case 5: goto L17;
            case 6: goto L12;
            default: goto L11;
        };
    L12:
        Ref.ObjectRef r108 = (Ref.ObjectRef) r103.L$2;
        Ref.ObjectRef r109 = (Ref.ObjectRef) r103.L$1;
        ByteBufferChannel r110 = (ByteBufferChannel) r103.L$0;
        ResultKt.throwOnFailure(r105);     // Catch: Throwable -> L15
        T r111 = r105;
    L69:
        r108.element = r111;     // Catch: Throwable -> L15
        io.ktor.utils.io.internal.h r112 = (io.ktor.utils.io.internal.h) r110._state;
        if (r112.a() == false) goto L73;
    L80:
        Ref.ObjectRef r113 = r109;
    L95:
        return r113.element;
    L73:
        if (r112 == io.ktor.utils.io.internal.h.f.f492094c) goto L80;
        if ((r112 instanceof io.ktor.utils.io.internal.h.d) == false) goto L77;
    L78:
        r110.B0();
    L79:
        r110.M0();
        goto L80
    L77:
        if ((r112 instanceof io.ktor.utils.io.internal.h.e) == false) goto L79;
    L15:
        th = move-exception;
        th = th;
        r100 = r110;
    L83:
        io.ktor.utils.io.internal.h r114 = (io.ktor.utils.io.internal.h) r100._state;
        if (r114.a() == false) goto L86;
    L93:
        throw th;
    L86:
        if (r114 == io.ktor.utils.io.internal.h.f.f492094c) goto L93;
        if ((r114 instanceof io.ktor.utils.io.internal.h.d) == false) goto L90;
    L91:
        r100.B0();
    L92:
        r100.M0();
        goto L93
    L90:
        if ((r114 instanceof io.ktor.utils.io.internal.h.e) == false) goto L92;
    L17:
        ResultKt.throwOnFailure(r105);
        Object r115 = r105;
    L64:
        return r115;
    L18:
        ResultKt.throwOnFailure(r105);
        Object r116 = r105;
    L58:
        return r116;
    L19:
        Ref.ObjectRef r117 = (Ref.ObjectRef) r103.L$4;
        ByteBufferChannel r118 = (ByteBufferChannel) r103.L$3;
        Ref.ObjectRef r119 = (Ref.ObjectRef) r103.L$2;
        Function2<? super q, ? super Continuation<? super R>, ? extends Object> r120 = (Function2) r103.L$1;
        ByteBufferChannel r121 = (ByteBufferChannel) r103.L$0;
        ResultKt.throwOnFailure(r105);     // Catch: Throwable -> L22
        T r122 = r105;
    L50:
        r117.element = r122;     // Catch: Throwable -> L22
        r118.B0();
        r118.M0();
        r113 = r119;
        r101 = r120;
        r100 = r121;
    L52:
        if (r107 == true) goto L95;
        Throwable r123 = r100.d();
        if (r123 == null) goto L60;
        io.ktor.utils.io.internal.d r124 = new io.ktor.utils.io.internal.d(r123);
        r103.L$0 = null;
        r103.L$1 = null;
        r103.L$2 = null;
        r103.L$3 = null;
        r103.L$4 = null;
        r103.label = 4;
        Object r125 = r101.invoke(r124, r103);
        r116 = r125;
        if (r125 != r106) goto L58;
        return r106;
    L60:
        if (((io.ktor.utils.io.internal.h) r100._state) != io.ktor.utils.io.internal.h.f.f492094c) goto L104;
        io.ktor.utils.io.internal.k r126 = io.ktor.utils.io.internal.k.f492102b;
        r103.L$0 = null;
        r103.L$1 = null;
        r103.L$2 = null;
        r103.L$3 = null;
        r103.L$4 = null;
        r103.label = 5;
        Object r127 = r101.invoke(r126, r103);
        r115 = r127;
        if (r127 != r106) goto L64;
        return r106;
    L104:
        r103.L$0 = r100;     // Catch: Throwable -> L82
        r103.L$1 = r113;     // Catch: Throwable -> L82
        r103.L$2 = r113;     // Catch: Throwable -> L82
        r103.L$3 = null;     // Catch: Throwable -> L82
        r103.L$4 = null;     // Catch: Throwable -> L82
        r103.label = 6;     // Catch: Throwable -> L82
        Object r128 = r101.invoke(r100, r103);     // Catch: Throwable -> L82
        if (r128 != r106) goto L68;
        return r106;
    L68:
        r110 = r100;
        r108 = r113;
        r111 = r128;
        r109 = r108;
    L82:
        th = th;
    L22:
        th = move-exception;
        ByteBufferChannel r129 = r118;
        th = th;
        r100 = r129;
    L98:
        r100.B0();
        r100.M0();
        throw th;
    L24:
        ResultKt.throwOnFailure(r105);
        Object r130 = r105;
    L37:
        return r130;
    L25:
        ResultKt.throwOnFailure(r105);
        Object r131 = r105;
    L31:
        return r131;
    L26:
        ResultKt.throwOnFailure(r105);
        Throwable r132 = r100.d();
        if (r132 == null) goto L33;
        io.ktor.utils.io.internal.d r133 = new io.ktor.utils.io.internal.d(r132);
        r103.label = 1;
        Object r134 = r101.invoke(r133, r103);
        r131 = r134;
        if (r134 != r106) goto L31;
        return r106;
    L33:
        if (((io.ktor.utils.io.internal.h) r100._state) != io.ktor.utils.io.internal.h.f.f492094c) goto L38;
        io.ktor.utils.io.internal.k r135 = io.ktor.utils.io.internal.k.f492102b;
        r103.label = 2;
        Object r136 = r101.invoke(r135, r103);
        r130 = r136;
        if (r136 != r106) goto L37;
        return r106;
    L38:
        r113 = new Ref.ObjectRef();
        if (r100.G0() != null) goto L100;
    L45:
        r107 = false;
        goto L52
    L100:
    L97:
        th = th;
        goto L98
    L43:
        if (((io.ktor.utils.io.internal.h) r100._state).f492083b._availableForRead$internal != 0) goto L46;
        r100.B0();
        r100.M0();
        goto L45
    L46:
        r103.L$0 = r100;     // Catch: Throwable -> L97
        r103.L$1 = r101;     // Catch: Throwable -> L97
        r103.L$2 = r113;     // Catch: Throwable -> L97
        r103.L$3 = r100;     // Catch: Throwable -> L97
        r103.L$4 = r113;     // Catch: Throwable -> L97
        r103.label = 3;     // Catch: Throwable -> L97
        Object r137 = r101.invoke(r100, r103);     // Catch: Throwable -> L97
        if (r137 != r106) goto L49;
        return r106;
    L49:
        r121 = r100;
        r120 = r101;
        r118 = r121;
        r117 = r113;
        r122 = r137;
        r119 = r117;
        goto L50
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r103 = new ByteBufferChannel$lookAheadSuspend$1(r100, r102);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x0108 -> B:55:0x010b). Please report as a decompilation issue!!! */
    public static Object c1(ByteBufferChannel r100, short r110, Continuation<? super Unit> r111) {
        if ((r111 instanceof ByteBufferChannel$writeShort$1) == false) goto L7;
        ByteBufferChannel$writeShort$1 r101 = (ByteBufferChannel$writeShort$1) r111;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r112 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(r101.label) {
            case 0: goto L20;
            case 1: goto L19;
            case 2: goto L19;
            case 3: goto L19;
            case 4: goto L18;
            case 5: goto L13;
            case 6: goto L19;
            case 7: goto L19;
            case 8: goto L12;
            default: goto L11;
        };
    L12:
        short r104 = r101.S$0;
        ByteBufferChannel r113 = (ByteBufferChannel) r101.L$1;
        io.ktor.utils.io.internal.e r105 = (io.ktor.utils.io.internal.e) r101.L$0;
        ResultKt.throwOnFailure(r112);
    L61:
        if (((io.ktor.utils.io.internal.h) r113._state) == io.ktor.utils.io.internal.h.f.f492094c) goto L65;
        r101.L$0 = r105;
        r101.L$1 = r113;
        r101.L$2 = null;
        r101.S$0 = r104;
        r101.label = 8;
        if (r113.d1(1, r101) != r103) goto L61;
        return r103;
    L65:
        r105.getClass();
        r101.L$0 = null;
        r101.L$1 = null;
        r101.L$2 = null;
        r101.label = 7;
        throw null;
    L13:
        int r106 = r101.I$0;
        r110 = r101.S$0;
        ByteBuffer r107 = (ByteBuffer) r101.L$2;
        ByteBufferChannel r108 = (ByteBufferChannel) r101.L$1;
        io.ktor.utils.io.internal.j r109 = (io.ktor.utils.io.internal.j) r101.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: Throwable -> L16
        ByteBuffer r114 = r107;
        int r115 = r106;
        r100 = r108;
    L56:
        if (r100.joining == null) goto L70;
        r100.C0();
        r105 = r100.joining;
        Intrinsics.checkNotNull(r105);
        if (((io.ktor.utils.io.internal.h) r100._state) == io.ktor.utils.io.internal.h.f.f492094c) goto L67;
        short r116 = r110;
        r113 = r100;
        r104 = r116;
        goto L61
    L67:
        r105.getClass();
        r101.L$0 = null;
        r101.L$1 = null;
        r101.L$2 = null;
        r101.label = 6;
        throw null;
    L70:
        if (r109.k(r115) == true) goto L72;
        boolean r117 = false;
    L82:
        if (r117 == true) goto L89;
    L90:
        r101.L$0 = r109;     // Catch: Throwable -> L84
        r101.L$1 = r100;     // Catch: Throwable -> L84
        r101.L$2 = r114;     // Catch: Throwable -> L84
        r101.S$0 = r110;     // Catch: Throwable -> L84
        r101.I$0 = r115;     // Catch: Throwable -> L84
        r101.label = 5;     // Catch: Throwable -> L84
        if (r100.d1(r115, r101) != r103) goto L56;
        return r103;
    L84:
        th = move-exception;
        r108 = r100;
        Throwable th10 = th;
    L86:
        r108.C0();
        r108.M0();
        throw th10;
    L89:
        return Unit.INSTANCE;
    L72:
        r100.f0(r114, r115);
        if (r114.remaining() >= r115) goto L75;
        r114.limit(r114.capacity());
        r114.putShort(r110);
        r100.U(r114);
    L76:
        r100.T(r114, r109, r115);
        if (r109.d() == false) goto L79;
    L80:
        r100.a0(1);
    L81:
        r100.C0();
        r100.M0();
        r117 = true;
        goto L82
    L79:
        if (r100.f491993b == false) goto L81;
    L75:
        r114.putShort(r110);
    L16:
        th10 = th;
        goto L86
    L18:
        r110 = r101.S$0;
        r100 = (ByteBufferChannel) r101.L$1;
        io.ktor.utils.io.internal.e r118 = (io.ktor.utils.io.internal.e) r101.L$0;
        ResultKt.throwOnFailure(r112);
    L29:
        if (((io.ktor.utils.io.internal.h) r100._state) == io.ktor.utils.io.internal.h.f.f492094c) goto L33;
        r101.L$0 = r118;
        r101.L$1 = r100;
        r101.S$0 = r110;
        r101.label = 4;
        if (r100.d1(1, r101) != r103) goto L29;
        return r103;
    L33:
        r118.getClass();
        r101.L$0 = null;
        r101.L$1 = null;
        r101.label = 3;
        throw null;
    L19:
        ResultKt.throwOnFailure(r112);
        goto L89
    L20:
        ResultKt.throwOnFailure(r112);
        io.ktor.utils.io.internal.e r119 = r100.joining;
        if (r119 == null) goto L23;
        A0(r100, r119);
    L23:
        r114 = r100.H0();
        r115 = 2;
        if (r114 != null) goto L37;
        io.ktor.utils.io.internal.e r120 = r100.joining;
        Intrinsics.checkNotNull(r120);
        if (((io.ktor.utils.io.internal.h) r100._state) == io.ktor.utils.io.internal.h.f.f492094c) goto L35;
        r118 = r120;
        goto L29
    L35:
        r120.getClass();
        r101.label = 2;
        throw null;
    L37:
        io.ktor.utils.io.internal.j r121 = ((io.ktor.utils.io.internal.h) r100._state).f492083b;
        if (r121.k(2) == true) goto L40;
        boolean r122 = false;
    L50:
        if (r122 == true) goto L89;
        r109 = r121;
        goto L90
    L40:
        r100.f0(r114, 2);
        if (r114.remaining() >= 2) goto L43;
        r114.limit(r114.capacity());
        r114.putShort(r110);
        r100.U(r114);
    L44:
        r100.T(r114, r121, 2);
        if (r121.d() == false) goto L47;
    L48:
        r100.a0(1);
    L49:
        r100.C0();
        r100.M0();
        r122 = true;
        goto L50
    L47:
        if (r100.f491993b == false) goto L49;
    L43:
        r114.putShort(r110);
        goto L44
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r101 = new ByteBufferChannel$writeShort$1(r100, r111);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.lang.Object, kotlin.Unit] */
    @Deprecated(message = "Use write { } instead.")
    public static /* synthetic */ Object g1(WriteSessionImpl r100, Function2<? super w, ? super Continuation<? super Unit>, ? extends Object> r101, Continuation<? super Unit> r102) {
        if ((r102 instanceof ByteBufferChannel$writeSuspendSession$1) == false) goto L7;
        ByteBufferChannel$writeSuspendSession$1 r103 = (ByteBufferChannel$writeSuspendSession$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L16;
        if (r107 != 1) goto L15;
        WriteSessionImpl r108 = (WriteSessionImpl) r103.L$0;
        ResultKt.throwOnFailure(r105);     // Catch: Throwable -> L22
    L20:
        r108.e();
        r100 = Unit.INSTANCE;
        return r100;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r105);
        r108 = r100.f491999h;
        r108.d();
        r103.L$0 = r108;     // Catch: Throwable -> L22
        r103.label = 1;     // Catch: Throwable -> L22
        if (r101.invoke(r108, r103) != r106) goto L20;
        return r106;
    L22:
        th = move-exception;
        r100.e();
        throw th;
    L7:
        r103 = new ByteBufferChannel$writeSuspendSession$1(r100, r102);
        goto L8
    }

    public static Object w0(ByteBufferChannel r100, int r101, Continuation<? super String> r102) {
        if ((r102 instanceof ByteBufferChannel$readUTF8Line$1) == false) goto L7;
        ByteBufferChannel$readUTF8Line$1 r103 = (ByteBufferChannel$readUTF8Line$1) r102;
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
        if (((Boolean) r105).booleanValue() == true) goto L29;
        return null;
    L29:
        return r108.toString();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        StringBuilder r109 = new StringBuilder();
        r103.L$0 = r109;
        r103.label = 1;
        if (((io.ktor.utils.io.internal.h) r100._state) != io.ktor.utils.io.internal.h.f.f492094c) goto L20;
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
        r111 = r100.x0(r109, r101, r103);
    L7:
        r103 = new ByteBufferChannel$readUTF8Line$1(r100, r102);
        goto L8
    }

    public final Object R(int r100, Function1<? super ByteBuffer, Unit> r101, Continuation<? super Unit> r102) {
        if ((r102 instanceof ByteBufferChannel$awaitFreeSpaceOrDelegate$1) == false) goto L7;
        ByteBufferChannel$awaitFreeSpaceOrDelegate$1 r103 = (ByteBufferChannel$awaitFreeSpaceOrDelegate$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L18;
        if (r107 != 1) goto L12;
        Function1 r108 = (Function1) r103.L$1;
        ByteBufferChannel r109 = (ByteBufferChannel) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L22:
        io.ktor.utils.io.internal.e r110 = r109.joining;
        if (r110 == null) goto L26;
        A0(r109, r110);
    L26:
        return Unit.INSTANCE;
    L12:
        if (r107 != 2) goto L16;
        ResultKt.throwOnFailure(r105);
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r105);
        r103.L$0 = this;
        r103.L$1 = r101;
        r103.I$0 = r100;
        r103.label = 1;
        if (d1(r100, r103) != r106) goto L21;
        return r106;
    L21:
        r109 = this;
    L7:
        r103 = new ByteBufferChannel$awaitFreeSpaceOrDelegate$1(this, r102);
        goto L8
    }

    public final void S(ByteBuffer r100, io.ktor.utils.io.internal.j r101, int r102) {
        if (r102 < 0) goto L4;
        boolean r103 = true;
    L5:
        if (r103 == false) goto L9;
        this.f491996e = V(r100, this.f491996e + r102);
        r101.a(r102);
        this.totalBytesRead += (long) r102;
        E0();
        return;
    L9:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L4:
        r103 = false;
        goto L5
    }

    public final int S0(byte[] r100, int r101, int r110) {
        io.ktor.utils.io.internal.e r102 = this.joining;
        if (r102 == null) goto L5;
        A0(this, r102);
    L5:
        ByteBuffer r103 = H0();
        if (r103 != null) goto L8;
        return 0;
    L8:
        io.ktor.utils.io.internal.j r104 = ((io.ktor.utils.io.internal.h) this._state).f492083b;
        io.ktor.utils.io.internal.c r105 = (io.ktor.utils.io.internal.c) this._closed;     // Catch: Throwable -> L31
        if (r105 != null) goto L29;
        int r106 = 0;
    L12:
        int r107 = r104.j(Math.min(r110 - r106, r103.remaining()));     // Catch: Throwable -> L31
        if (r107 == 0) goto L21;
        if (r107 <= 0) goto L16;
        boolean r108 = true;
    L17:
        if (r108 == false) goto L20;
        r103.put(r100, r101 + r106, r107);     // Catch: Throwable -> L31
        r106 = r106 + r107;     // Catch: Throwable -> L31
        e0(r103, V(r103, this.f491997f + r106), r104._availableForWrite$internal);     // Catch: Throwable -> L31
        goto L12
    L20:
        throw new IllegalArgumentException("Failed requirement.".toString());     // Catch: Throwable -> L31
    L16:
        r108 = false;
        goto L17
    L21:
        T(r103, r104, r106);     // Catch: Throwable -> L31
        if (r104.d() == false) goto L25;
    L26:
        a0(1);
    L27:
        C0();
        M0();
        return r106;
    L25:
        if (this.f491993b == false) goto L27;
    L29:
        io.ktor.utils.io.a.a(r105.a());     // Catch: Throwable -> L31
        throw null;     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        if (r104.d() == false) goto L35;
    L36:
        a0(1);
    L37:
        C0();
        M0();
        throw th;
    L35:
        if (this.f491993b == false) goto L37;
        goto L36
    }

    public final void T(ByteBuffer r100, io.ktor.utils.io.internal.j r101, int r102) {
        if (r102 < 0) goto L4;
        boolean r103 = true;
    L5:
        if (r103 == false) goto L9;
        this.f491997f = V(r100, this.f491997f + r102);
        r101.b(r102);
        this.totalBytesWritten += (long) r102;
        return;
    L9:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L4:
        r103 = false;
        goto L5
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:133:0x02de -> B:15:0x0046). Please report as a decompilation issue!!! */
    public final Object W(ByteBufferChannel r210, long r211, Continuation r212) {
        if ((r212 instanceof ByteBufferChannel$copyDirect$1) == false) goto L7;
        ByteBufferChannel$copyDirect$1 r100 = (ByteBufferChannel$copyDirect$1) r212;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L26;
        if (r104 == 1) goto L21;
        if (r104 == 2) goto L18;
        if (r104 != 3) goto L17;
        boolean r105 = r100.Z$0;
        long r106 = r100.J$0;
        Ref.LongRef r110 = (Ref.LongRef) r100.L$3;
        io.ktor.utils.io.internal.e r111 = (io.ktor.utils.io.internal.e) r100.L$2;
        ByteBufferChannel r112 = (ByteBufferChannel) r100.L$1;
        ByteBufferChannel r113 = (ByteBufferChannel) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L41
    L15:
        ByteBufferChannel$copyDirect$1 r107 = r100;
        Object r114 = r103;
        long r108 = r106;
        Ref.LongRef r109 = r110;
        io.ktor.utils.io.internal.e r115 = r111;
    L159:
        ByteBufferChannel r116 = r112;
    L37:
        if (r109.element >= r108) goto L177;
        io.ktor.utils.io.internal.e r117 = r113.joining;     // Catch: Throwable -> L41
        if (r117 == null) goto L43;
        A0(r113, r117);     // Catch: Throwable -> L41
    L43:
        ByteBuffer r118 = r113.H0();     // Catch: Throwable -> L41
        if (r118 != null) goto L46;
        r112 = r116;
        r106 = r108;
        r100 = r107;
        r110 = r109;
        r111 = r115;
        r103 = r114;
    L127:
        if (r111 == null) goto L135;
        if (r112.K0(r111) == false) goto L132;
    L150:
        r109 = r110;
        goto L177
    L132:
        if (((io.ktor.utils.io.internal.h) r112._state).f492083b.c() == false) goto L135;
        r112.E0();     // Catch: Throwable -> L41
    L135:
        if (r110.element >= r106) goto L150;
        r113.a0(1);     // Catch: Throwable -> L41
        if (r112.w() != 0) goto L153;
        r100.L$0 = r113;     // Catch: Throwable -> L41
        r100.L$1 = r112;     // Catch: Throwable -> L41
        r100.L$2 = r111;     // Catch: Throwable -> L41
        r100.L$3 = r110;     // Catch: Throwable -> L41
        r100.L$4 = null;     // Catch: Throwable -> L41
        r100.L$5 = null;     // Catch: Throwable -> L41
        r100.L$6 = null;     // Catch: Throwable -> L41
        r100.L$7 = null;     // Catch: Throwable -> L41
        r100.L$8 = null;     // Catch: Throwable -> L41
        r100.L$9 = null;     // Catch: Throwable -> L41
        r100.J$0 = r106;     // Catch: Throwable -> L41
        r100.Z$0 = r105;     // Catch: Throwable -> L41
        r100.label = 2;     // Catch: Throwable -> L41
        Object r119 = r112.u0(1, r100);     // Catch: Throwable -> L41
        if (r119 != r103) goto L142;
        return r103;
    L142:
        if (((Boolean) r119).booleanValue() == false) goto L147;
        if (r111 == null) goto L153;
        if (r112.K0(r111) == false) goto L153;
    L147:
        if (r111 == null) goto L150;
        if (r112.K0(r111) == true) goto L150;
    L153:
        if (r113.joining == null) goto L210;
        r100.L$0 = r113;     // Catch: Throwable -> L41
        r100.L$1 = r112;     // Catch: Throwable -> L41
        r100.L$2 = r111;     // Catch: Throwable -> L41
        r100.L$3 = r110;     // Catch: Throwable -> L41
        r100.L$4 = null;     // Catch: Throwable -> L41
        r100.L$5 = null;     // Catch: Throwable -> L41
        r100.L$6 = null;     // Catch: Throwable -> L41
        r100.L$7 = null;     // Catch: Throwable -> L41
        r100.L$8 = null;     // Catch: Throwable -> L41
        r100.L$9 = null;     // Catch: Throwable -> L41
        r100.J$0 = r106;     // Catch: Throwable -> L41
        r100.Z$0 = r105;     // Catch: Throwable -> L41
        r100.label = 3;     // Catch: Throwable -> L41
        if (r113.O0(1, r100) != r103) goto L158;
        return r103;
    L158:
        r107 = r100;
        r114 = r103;
        r108 = r106;
        r109 = r110;
        r115 = r111;
        goto L159
    L210:
        r107 = r100;
        r114 = r103;
        r108 = r106;
        r109 = r110;
        r115 = r111;
        goto L159
    L46:
        io.ktor.utils.io.internal.j r120 = ((io.ktor.utils.io.internal.h) r113._state).f492083b;     // Catch: Throwable -> L41
        long r121 = r113.totalBytesWritten;     // Catch: Throwable -> L41
        io.ktor.utils.io.internal.c r122 = (io.ktor.utils.io.internal.c) r113._closed;     // Catch: Throwable -> L166
        if (r122 != null) goto L164;
        long r123 = r108;
        r100 = r107;
        io.ktor.utils.io.internal.e r124 = r115;
        ByteBuffer r125 = r118;
        long r213 = r121;
        ByteBufferChannel r126 = r113;
        ByteBufferChannel r127 = r126;
        boolean r128 = r105;
        Ref.LongRef r129 = r109;
        io.ktor.utils.io.internal.j r130 = r120;
        ByteBufferChannel r131 = r127;
    L198:
    L160:
        Throwable th10 = th;
        long r132 = r213;
    L162:
        ByteBufferChannel r133 = r131;
    L163:
        io.ktor.utils.io.internal.j r134 = r120;
        long r135 = r132;
    L169:
        if (r134.d() == false) goto L171;
    L172:
        r133.a0(1);     // Catch: Throwable -> L41
    L173:
        if (r133 == r126) goto L175;
        r126.totalBytesWritten += r133.totalBytesWritten - r135;     // Catch: Throwable -> L41
    L175:
        r133.C0();     // Catch: Throwable -> L41
        r133.M0();     // Catch: Throwable -> L41
        throw th10;     // Catch: Throwable -> L41
    L171:
        if (r133.f491993b == false) goto L173;
    L51:
        if (r129.element >= r123) goto L117;
        int r136 = r130._availableForWrite$internal;     // Catch: Throwable -> L160
        if (r136 != 0) goto L70;
        r100.L$0 = r113;     // Catch: Throwable -> L160
        r100.L$1 = r116;     // Catch: Throwable -> L160
        r100.L$2 = r124;     // Catch: Throwable -> L160
        r100.L$3 = r129;     // Catch: Throwable -> L160
        r100.L$4 = r126;     // Catch: Throwable -> L160
        r100.L$5 = r131;     // Catch: Throwable -> L160
        r100.L$6 = r120;     // Catch: Throwable -> L160
        r100.L$7 = r130;     // Catch: Throwable -> L160
        r100.L$8 = r125;     // Catch: Throwable -> L160
        r100.L$9 = r127;     // Catch: Throwable -> L160
        r100.J$0 = r123;     // Catch: Throwable -> L160
        r100.Z$0 = r128;     // Catch: Throwable -> L160
        long r137 = r213;
        r100.J$1 = r137;     // Catch: Throwable -> L68
        ByteBuffer r138 = r125;
        r100.label = 1;     // Catch: Throwable -> L68
        ByteBufferChannel r214 = r116;
        Object r139 = r114;
        if (r127.O0(1, r100) != r139) goto L60;
        return r139;
    L60:
        ByteBufferChannel r215 = r127;
        io.ktor.utils.io.internal.j r140 = r130;
        boolean r141 = r128;
        r133 = r131;
        r134 = r120;
        r135 = r137;
        long r142 = r123;
        ByteBufferChannel r143 = r215;
    L185:
    L66:
        th10 = th;
        goto L169
    L62:
        if (r143.joining != null) goto L65;
        r114 = r139;
        r132 = r135;
        ByteBufferChannel r144 = r214;
        r136 = r140._availableForWrite$internal;     // Catch: Throwable -> L66
        r120 = r134;
        ByteBuffer r145 = r138;
        r131 = r133;
        r128 = r141;
        r130 = r140;
        r127 = r143;
        r123 = r142;
    L195:
        r127.e0(r145, r127.f491997f, r136);     // Catch: Throwable -> L114
        Ref.IntRef r146 = new Ref.IntRef();     // Catch: Throwable -> L114
        ByteBufferChannel$copyDirect$1 r216 = r100;
        ByteBuffer r147 = r144.G0();     // Catch: Throwable -> L114
        io.ktor.utils.io.internal.e r217 = r124;
        if (r147 != null) goto L75;
        ByteBufferChannel r218 = r131;
    L74:
        ByteBufferChannel r148 = r126;
        io.ktor.utils.io.internal.j r219 = r120;
        ByteBufferChannel r220 = r113;
    L206:
        int r149 = r146.element;     // Catch: Throwable -> L102
        if (r149 > 0) goto L97;
        r100 = r216;
        r124 = r217;
        r131 = r218;
        r116 = r144;
        Object r150 = r114;
        r126 = r148;
        long r151 = r132;
        r120 = r219;
        r128 = r128;
        r113 = r220;
    L119:
        if (r120.d() == false) goto L121;
    L122:
        r131.a0(1);     // Catch: Throwable -> L41
    L123:
        if (r131 == r126) goto L126;
        r126.totalBytesWritten += r131.totalBytesWritten - r151;     // Catch: Throwable -> L41
    L126:
        r131.C0();     // Catch: Throwable -> L41
        r131.M0();     // Catch: Throwable -> L41
        r100 = r100;
        r103 = r150;
        r105 = r128;
        r110 = r129;
        r106 = r123;
        r112 = r116;
        r111 = r124;
        goto L127
    L121:
        if (r131.f491993b == false) goto L123;
    L97:
        r127 = r127;
        r127.T(r145, r130, r149);     // Catch: Throwable -> L102
        long r152 = r129.element;     // Catch: Throwable -> L102
        int r153 = r146.element;     // Catch: Throwable -> L102
        r129.element = r152 + ((long) r153);     // Catch: Throwable -> L102
        if ((r136 - r153) == 0) goto L100;
        if (r128 == false) goto L101;
        r100 = r216;
        r124 = r217;
        r131 = r218;
        r126 = r148;
        r213 = r132;
        r120 = r219;
        r128 = r128;
        r113 = r220;
        ByteBufferChannel r221 = r144;
        r125 = r145;
        r116 = r221;
    L100:
        r127.a0(1);     // Catch: Throwable -> L102
    L101:
        r100 = r216;
        r124 = r217;
        r131 = r218;
        r126 = r148;
        r213 = r132;
        r120 = r219;
        r128 = r128;
        r113 = r220;
        ByteBufferChannel r222 = r144;
        r125 = r145;
        r116 = r222;
    L102:
        th10 = th;
    L116:
        r133 = r218;
        r126 = r148;
        r135 = r132;
        r134 = r219;
        goto L169
    L75:
        io.ktor.utils.io.internal.j r154 = ((io.ktor.utils.io.internal.h) r144._state).f492083b;     // Catch: Throwable -> L114
        r218 = r131;
    L110:
        th = th;
        r148 = r126;
        r219 = r120;
    L109:
        r220 = r113;
    L112:
        r144.B0();     // Catch: Throwable -> L102
        r144.M0();     // Catch: Throwable -> L102
        throw th;     // Catch: Throwable -> L102
    L78:
        if (r154._availableForRead$internal == 0) goto L208;
        r148 = r126;
        r219 = r120;
        r128 = r128;
        r220 = r113;
        int r155 = r130.j((int) Math.min(r147.remaining(), Math.min(r145.remaining(), r123 - r129.element)));     // Catch: Throwable -> L106
        if (r155 > 0) goto L91;
    L93:
        r144.B0();     // Catch: Throwable -> L102
        r144.M0();     // Catch: Throwable -> L102
        goto L206
    L91:
        if (r154.i(r155) == false) goto L105;
        r147.limit(r147.position() + r155);     // Catch: Throwable -> L106
        r145.put(r147);     // Catch: Throwable -> L106
        r146.element = r155;     // Catch: Throwable -> L106
        r144.S(r147, r154, r155);     // Catch: Throwable -> L106
        goto L93
    L105:
        throw new AssertionError();     // Catch: Throwable -> L106
    L106:
        th = th;
    L108:
        th = th;
        goto L109
    L208:
        r144.B0();     // Catch: Throwable -> L81
        r144.M0();     // Catch: Throwable -> L81
    L81:
        th10 = th;
        r133 = r218;
    L114:
        th10 = th;
        r218 = r131;
        r148 = r126;
        r219 = r120;
        r220 = r113;
        goto L116
    L65:
        r116 = r214;
        r123 = r142;
        r151 = r135;
        r120 = r134;
        r131 = r133;
        r128 = r141;
        r150 = r139;
    L68:
        th10 = th;
        r132 = r137;
        goto L162
    L70:
        r132 = r213;
        ByteBufferChannel r223 = r116;
        r145 = r125;
        r144 = r223;
        goto L195
    L117:
        r150 = r114;
        r151 = r213;
        goto L119
    L164:
        io.ktor.utils.io.a.a(r122.a());     // Catch: Throwable -> L166
        throw null;     // Catch: Throwable -> L166
    L166:
        th10 = th;
        r134 = r120;
        r135 = r121;
        r133 = r113;
        r126 = r133;
    L177:
        if (r105 == false) goto L180;
        r113.a0(1);     // Catch: Throwable -> L41
    L180:
        return Boxing.boxLong(r109.element);
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        r105 = r100.Z$0;
        r106 = r100.J$0;
        r110 = (Ref.LongRef) r100.L$3;
        r111 = (io.ktor.utils.io.internal.e) r100.L$2;
        r112 = (ByteBufferChannel) r100.L$1;
        r113 = (ByteBufferChannel) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L41
        r119 = r102;
        goto L142
    L21:
        r135 = r100.J$1;
        r141 = r100.Z$0;
        r142 = r100.J$0;
        r143 = (ByteBufferChannel) r100.L$9;
        ByteBuffer r156 = (ByteBuffer) r100.L$8;
        r140 = (io.ktor.utils.io.internal.j) r100.L$7;
        r134 = (io.ktor.utils.io.internal.j) r100.L$6;
        r133 = (ByteBufferChannel) r100.L$5;
        r126 = (ByteBufferChannel) r100.L$4;
        r129 = (Ref.LongRef) r100.L$3;
        io.ktor.utils.io.internal.e r157 = (io.ktor.utils.io.internal.e) r100.L$2;
        ByteBufferChannel r158 = (ByteBufferChannel) r100.L$1;
        ByteBufferChannel r159 = (ByteBufferChannel) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L24
        r138 = r156;
        r139 = r103;
        r113 = r159;
        r124 = r157;
        r214 = r158;
    L24:
        th10 = th;
        goto L169
    L26:
        r114 = r103;
        ResultKt.throwOnFailure(r102);
        if (r210.E() == false) goto L204;
        if (r210.d() == null) goto L32;
        close(r210.d());
    L32:
        return Boxing.boxLong(0);
    L204:
        r105 = this.f491993b;
        r113 = this;
        r107 = r100;
        r109 = new Ref.LongRef();     // Catch: Throwable -> L181
        r115 = null;
        r116 = r210;
        r108 = r211;
    L181:
        th = th;
    L183:
        close(th);
        throw th;
    L41:
        th = th;
    L7:
        r100 = new ByteBufferChannel$copyDirect$1(this, r212);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x009b -> B:33:0x009e). Please report as a decompilation issue!!! */
    public final Object Y(long r110, long r111, Continuation<? super Long> r112) {
        if ((r112 instanceof ByteBufferChannel$discardSuspend$1) == false) goto L7;
        ByteBufferChannel$discardSuspend$1 r100 = (ByteBufferChannel$discardSuspend$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        long r114 = r100.J$0;
        Ref.LongRef r115 = (Ref.LongRef) r100.L$1;
        ByteBufferChannel r116 = (ByteBufferChannel) r100.L$0;
        ResultKt.throwOnFailure(r113);
    L34:
        if (((Boolean) r113).booleanValue() == true) goto L16;
    L40:
        return Boxing.boxLong(r115.element);
    L16:
        if (r115.element >= r114) goto L40;
        ByteBuffer r117 = r116.G0();
        if (r117 == null) goto L24;
        io.ktor.utils.io.internal.j r104 = ((io.ktor.utils.io.internal.h) r116._state).f492083b;
    L36:
        th = move-exception;
        r116.B0();
        r116.M0();
        throw th;
    L22:
        if (r104._availableForRead$internal != 0) goto L25;
        r116.B0();
        r116.M0();
        goto L24
    L25:
        int r105 = r104.h((int) Math.min(SieveCacheKt.NodeLinkMask, r114 - r115.element));     // Catch: Throwable -> L36
        r116.S(r117, r104, r105);     // Catch: Throwable -> L36
        r115.element += (long) r105;     // Catch: Throwable -> L36
        r116.B0();
        r116.M0();
        boolean r118 = true;
    L27:
        if (r118 == true) goto L16;
        if (r116.E() == true) goto L40;
        r100.L$0 = r116;
        r100.L$1 = r115;
        r100.J$0 = r114;
        r100.label = 1;
        r113 = r116.t0(1, r100);
        if (r113 != r102) goto L34;
        return r102;
    L24:
        r118 = false;
        goto L27
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r113);
        Ref.LongRef r119 = new Ref.LongRef();
        r119.element = r110;
        r114 = r111;
        r115 = r119;
        r116 = this;
    L7:
        r100 = new ByteBufferChannel$discardSuspend$1(this, r112);
        goto L8
    }

    public final void e0(ByteBuffer r100, int r101, int r102) {
        boolean r103 = true;
        if (r101 < 0) goto L5;
        boolean r104 = true;
    L7:
        if (r104 == false) goto L17;
        if (r102 >= 0) goto L11;
        r103 = false;
    L11:
        if (r103 == false) goto L15;
        int r105 = r102 + r101;
        r100.limit(RangesKt.coerceAtMost(r105, r100.capacity() - this.f491995d));
        r100.position(r101);
        return;
    L15:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L17:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        r104 = false;
        goto L7
    }

    public final int h0(byte[] r100, int r101, int r110) {
        ByteBuffer r102 = G0();
        int r103 = 0;
        if (r102 == null) goto L17;
        io.ktor.utils.io.internal.j r104 = ((io.ktor.utils.io.internal.h) this._state).f492083b;
    L18:
        th = move-exception;
        B0();
        M0();
        throw th;
    L7:
        if (r104._availableForRead$internal == 0) goto L16;
        int r105 = r102.capacity() - this.f491995d;     // Catch: Throwable -> L18
    L10:
        int r106 = r110 - r103;     // Catch: Throwable -> L18
        if (r106 == 0) goto L16;
        int r107 = this.f491996e;     // Catch: Throwable -> L18
        int r108 = r104.h(Math.min(r105 - r107, r106));     // Catch: Throwable -> L18
        if (r108 == 0) goto L16;
        r102.limit(r107 + r108);     // Catch: Throwable -> L18
        r102.position(r107);     // Catch: Throwable -> L18
        r102.get(r100, r101 + r103, r108);     // Catch: Throwable -> L18
        S(r102, r104, r108);     // Catch: Throwable -> L18
        r103 = r103 + r108;
    L16:
        B0();
        M0();
    L17:
        return r103;
    }

    public final boolean h1(ByteBuffer r100, io.ktor.utils.io.internal.j r110, Function1<? super ByteBuffer, Boolean> r111) {
        int r101 = r100.capacity() - this.f491995d;
        boolean r102 = true;
    L3:
        if (r102 == false) goto L32;
    L4:
        int r103 = r110._availableForWrite$internal;
        boolean r104 = false;
        if (r103 < 1) goto L6;
        if (io.ktor.utils.io.internal.j.f492099c.compareAndSet(r110, r103, 0) == false) goto L4;
    L9:
        if (r103 == 0) goto L32;
        int r105 = this.f491997f;
        int r106 = RangesKt.coerceAtMost(r105 + r103, r101);
        r100.limit(r106);
        r100.position(r105);
        boolean r107 = r111.invoke(r100).booleanValue();     // Catch: Throwable -> L29
        if (r100.limit() != r106) goto L15;
        boolean r108 = true;
    L16:
        if (r108 == false) goto L28;
        int r109 = r100.position() - r105;
        if (r109 < 0) goto L20;
        r104 = true;
    L20:
        if (r104 == false) goto L26;
        T(r100, r110, r109);
        if (r109 >= r103) goto L24;
        r110.a(r103 - r109);
    L24:
        r102 = r107;
        goto L3
    L26:
        throw new IllegalStateException("Position has been moved backward: pushback is not supported.".toString());
    L28:
        throw new IllegalStateException("Buffer limit modified.".toString());
    L15:
        r108 = false;
    L29:
        th = move-exception;
        r110.a(r103);
        throw th;
    L6:
        r103 = 0;
    L32:
        return r102;
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object m(int r100, Function1<? super ByteBuffer, Unit> r101, Continuation<? super Unit> r110) {
        boolean r102 = true;
        boolean r103 = false;
        if (r100 < 0) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L55;
        ByteBuffer r105 = G0();
        if (r105 == null) goto L38;
        io.ktor.utils.io.internal.j r106 = ((io.ktor.utils.io.internal.h) this._state).f492083b;
    L51:
        th = move-exception;
        B0();
        M0();
        throw th;
    L12:
        if (r106._availableForRead$internal == 0) goto L36;
        int r107 = r106._availableForRead$internal;     // Catch: Throwable -> L51
        if (r107 <= 0) goto L36;
        if (r107 < r100) goto L36;
        int r108 = r105.position();     // Catch: Throwable -> L51
        int r109 = r105.limit();     // Catch: Throwable -> L51
        r101.invoke(r105);     // Catch: Throwable -> L51
        if (r109 != r105.limit()) goto L21;
        boolean r111 = true;
    L22:
        if (r111 == false) goto L35;
        int r112 = r105.position() - r108;     // Catch: Throwable -> L51
        if (r112 < 0) goto L26;
        r103 = true;
    L26:
        if (r103 == false) goto L33;
        if (r106.i(r112) == false) goto L31;
        S(r105, r106, r112);     // Catch: Throwable -> L51
    L37:
        B0();
        M0();
        r103 = r102;
        goto L38
    L31:
        throw new IllegalStateException("Check failed.".toString());     // Catch: Throwable -> L51
    L33:
        throw new IllegalStateException("Position has been moved backward: pushback is not supported.".toString());     // Catch: Throwable -> L51
    L35:
        throw new IllegalStateException("Buffer limit modified.".toString());     // Catch: Throwable -> L51
    L21:
        r111 = false;
    L36:
        r102 = false;
    L38:
        if (r103 == true) goto L50;
        if (E() == false) goto L45;
        if (r100 <= 0) goto L45;
        throw new EOFException("Got EOF but at least " + r100 + " bytes were expected");
    L45:
        Object r113 = m0(r100, r101, r110);
        if (r113 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L57;
        return r113;
    L57:
        return Unit.INSTANCE;
    L50:
        return Unit.INSTANCE;
    L55:
        throw new IllegalArgumentException("min should be positive or zero".toString());
    L5:
        r104 = false;
        goto L6
    }

    public final Object m0(int r100, Function1<? super ByteBuffer, Unit> r101, Continuation<? super Unit> r102) {
        if ((r102 instanceof ByteBufferChannel$readBlockSuspend$1) == false) goto L7;
        ByteBufferChannel$readBlockSuspend$1 r103 = (ByteBufferChannel$readBlockSuspend$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L16;
        if (r107 == 1) goto L15;
        if (r107 != 2) goto L14;
        ResultKt.throwOnFailure(r105);
    L31:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r100 = r103.I$0;
        r101 = (Function1) r103.L$1;
        ByteBufferChannel r108 = (ByteBufferChannel) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L21:
        if (((Boolean) r105).booleanValue() == true) goto L27;
        if (r100 > 0) goto L26;
        return Unit.INSTANCE;
    L26:
        throw new EOFException("Got EOF but at least " + r100 + " bytes were expected");
    L27:
        r103.L$0 = null;
        r103.L$1 = null;
        r103.label = 2;
        if (r108.m(r100, r101, r103) != r106) goto L31;
        return r106;
    L16:
        ResultKt.throwOnFailure(r105);
        int r109 = RangesKt.coerceAtLeast(r100, 1);
        r103.L$0 = this;
        r103.L$1 = r101;
        r103.I$0 = r100;
        r103.label = 1;
        r105 = t0(r109, r103);
        if (r105 != r106) goto L19;
        return r106;
    L19:
        r108 = this;
    L7:
        r103 = new ByteBufferChannel$readBlockSuspend$1(this, r102);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0054 -> B:21:0x0057). Please report as a decompilation issue!!! */
    public final Object p0(ByteBuffer r100, int r101, Continuation<? super Integer> r102) {
        if ((r102 instanceof ByteBufferChannel$readFullySuspend$1) == false) goto L7;
        ByteBufferChannel$readFullySuspend$1 r103 = (ByteBufferChannel$readFullySuspend$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        int r108 = r103.I$0;
        ByteBuffer r109 = (ByteBuffer) r103.L$1;
        ByteBufferChannel r110 = (ByteBufferChannel) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L22:
        if (((Boolean) r105).booleanValue() == false) goto L25;
        ByteBuffer r111 = r109;
        r101 = r108 + r110.g0(r109);
        r100 = r111;
    L16:
        if (r100.hasRemaining() == false) goto L27;
        r103.L$0 = r110;
        r103.L$1 = r100;
        r103.I$0 = r101;
        r103.label = 1;
        r105 = r110.t0(1, r103);
        if (r105 != r106) goto L20;
        return r106;
    L20:
        int r112 = r101;
        r109 = r100;
        r108 = r112;
        goto L22
    L27:
        return Boxing.boxInt(r101);
    L25:
        throw new ClosedReceiveChannelException("Unexpected EOF: expected " + r109.remaining() + " more bytes");
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        r110 = this;
    L7:
        r103 = new ByteBufferChannel$readFullySuspend$1(this, r102);
        goto L8
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object u(byte[] r100, int r101, ContinuationImpl r102) {
        int r103 = h0(r100, 0, r101);
        if (r103 >= r101) goto L10;
        Object r104 = q0(r100, 0 + r103, r101 - r103, r102);
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
        return r104;
    L8:
        return Unit.INSTANCE;
    L10:
        return Unit.INSTANCE;
    }

    public final Object x0(Appendable r210, int r211, Continuation<? super Boolean> r212) {
        if ((r212 instanceof ByteBufferChannel$readUTF8LineToUtf8Suspend$1) == false) goto L7;
        ByteBufferChannel$readUTF8LineToUtf8Suspend$1 r100 = (ByteBufferChannel$readUTF8LineToUtf8Suspend$1) r212;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
        ByteBufferChannel r102 = this;
    L8:
        Object r103 = r100.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r100.label;
        if (r105 == 0) goto L24;
        if (r105 == 1) goto L19;
        if (r105 != 2) goto L18;
        Ref.BooleanRef r106 = (Ref.BooleanRef) r100.L$3;
        Ref.BooleanRef r107 = (Ref.BooleanRef) r100.L$2;
        Ref.IntRef r108 = (Ref.IntRef) r100.L$1;
        ByteBufferChannel r109 = (ByteBufferChannel) r100.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: EOFException -> L15
    L16:
        final Ref.BooleanRef r110 = r106;
        ByteBufferChannel r111 = r109;
    L67:
        Ref.BooleanRef r112 = r107;
        Ref.IntRef r113 = r108;
    L70:
        if (r111.E() == false) goto L74;
        if (r113.element <= 0) goto L74;
    L79:
        boolean r114 = true;
    L81:
        return Boxing.boxBoolean(r114);
    L74:
        if (r110.element == true) goto L79;
        if (r112.element == true) goto L79;
        r114 = false;
        goto L81
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        int r115 = r100.I$0;
        Ref.IntRef r116 = (Ref.IntRef) r100.L$8;
        Ref.ObjectRef r117 = (Ref.ObjectRef) r100.L$7;
        char[] r118 = (char[]) r100.L$6;
        Ref.BooleanRef r119 = (Ref.BooleanRef) r100.L$5;
        Ref.BooleanRef r120 = (Ref.BooleanRef) r100.L$4;
        Ref.IntRef r121 = (Ref.IntRef) r100.L$3;
        Ref.IntRef r122 = (Ref.IntRef) r100.L$2;
        Appendable r123 = (Appendable) r100.L$1;
        ByteBufferChannel r124 = (ByteBufferChannel) r100.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: EOFException -> L22
    L23:
        Appendable r125 = r123;
        char[] r126 = r118;
        r112 = r120;
        Ref.IntRef r127 = r116;
        Object r128 = r104;
        r111 = r124;
        Ref.ObjectRef r129 = r117;
        r110 = r119;
        r113 = r122;
        Ref.IntRef r130 = r121;
        ByteBufferChannel$readUTF8LineToUtf8Suspend$1 r131 = r100;
        int r132 = r115;
    L26:
        if (r111.E() == false) goto L28;
    L50:
        T r133 = r129.element;
        if (r133 == 0) goto L54;
        io.ktor.utils.io.pool.c r134 = io.ktor.utils.io.internal.f.f492076b;
        Intrinsics.checkNotNull(r133);
        r134.Rl(r133);
    L54:
        if (r111.E() == true) goto L70;
        if (r112.element == false) goto L70;
        if (r110.element == true) goto L70;
        Function1<ByteBuffer, Unit> r135 = new ByteBufferChannel$readUTF8LineToUtf8Suspend$3(r110);     // Catch: EOFException -> L64
        r131.L$0 = r111;     // Catch: EOFException -> L64
        r131.L$1 = r113;     // Catch: EOFException -> L64
        r131.L$2 = r112;     // Catch: EOFException -> L64
        r131.L$3 = r110;     // Catch: EOFException -> L64
        r131.L$4 = null;     // Catch: EOFException -> L64
        r131.L$5 = null;     // Catch: EOFException -> L64
        r131.L$6 = null;     // Catch: EOFException -> L64
        r131.L$7 = null;     // Catch: EOFException -> L64
        r131.L$8 = null;     // Catch: EOFException -> L64
        r131.label = 2;     // Catch: EOFException -> L64
        if (r111.m(1, r135, r131) != r128) goto L66;
        return r128;
    L66:
        r107 = r112;
        r108 = r113;
        goto L67
    L28:
        if (r110.element == true) goto L50;
        if (r112.element == true) goto L50;
        if (r132 != Integer.MAX_VALUE) goto L34;
    L87:
        int r136 = r130.element;     // Catch: EOFException -> L47
        final Ref.IntRef r213 = r130;
        final Ref.ObjectRef r137 = r129;
        final char[] r214 = r126;
        final int r138 = r132;
        Ref.ObjectRef r139 = r129;
        final Ref.IntRef r140 = r113;
        final Ref.BooleanRef r141 = r110;
        final Ref.BooleanRef r142 = r112;
        final Appendable r215 = r125;
        final Ref.IntRef r216 = r127;
        Function1<ByteBuffer, Unit> r143 = new ByteBufferChannel$readUTF8LineToUtf8Suspend$2(r137, r138, r214, r140, r213, r141, r142, r215, r216);     // Catch: EOFException -> L44
        r131.L$0 = r111;     // Catch: EOFException -> L44
        r131.L$1 = r125;     // Catch: EOFException -> L44
        r131.L$2 = r113;     // Catch: EOFException -> L44
        Ref.IntRef r144 = r213;
        r131.L$3 = r144;     // Catch: EOFException -> L83
        r131.L$4 = r112;     // Catch: EOFException -> L83
        r131.L$5 = r110;     // Catch: EOFException -> L83
        char[] r145 = r214;
        r131.L$6 = r145;     // Catch: EOFException -> L82
        r131.L$7 = r139;     // Catch: EOFException -> L82
        r131.L$8 = r127;     // Catch: EOFException -> L82
        r131.I$0 = r132;     // Catch: EOFException -> L82
        r131.label = 1;     // Catch: EOFException -> L82
        if (r111.m(r136, r143, r131) != r128) goto L48;
        return r128;
    L48:
        r129 = r139;
        r126 = r145;
        r130 = r144;
    L101:
        r129 = r139;
        r126 = r145;
        r130 = r144;
    L45:
        r145 = r214;
    L44:
        r144 = r213;
    L47:
        r144 = r130;
        r145 = r126;
        r139 = r129;
        goto L101
    L34:
        if (r113.element > r132) goto L50;
    L24:
        ResultKt.throwOnFailure(r103);
        Ref.IntRef r146 = new Ref.IntRef();
        Ref.IntRef r147 = new Ref.IntRef();
        r147.element = 1;
        Ref.BooleanRef r148 = new Ref.BooleanRef();
        r110 = new Ref.BooleanRef();
        Ref.ObjectRef r149 = new Ref.ObjectRef();
        r127 = new Ref.IntRef();
        r130 = r147;
        r126 = new char[8192];
        r129 = r149;
        r113 = r146;
        r131 = r100;
        r112 = r148;
        r125 = r210;
        r132 = r211;
        r128 = r104;
        r111 = r102;
    L7:
        r102 = this;
        r100 = new ByteBufferChannel$readUTF8LineToUtf8Suspend$1(r102, r212);
        goto L8
    }

    public static Object P0(ByteBufferChannel r110, int r111, Function1<? super ByteBuffer, Unit> r112, Continuation<? super Unit> r113) {
        if ((r113 instanceof ByteBufferChannel$write$1) == false) goto L7;
        ByteBufferChannel$write$1 r100 = (ByteBufferChannel$write$1) r113;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r114 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        r111 = r100.I$0;
        r112 = (Function1) r100.L$1;
        r110 = (ByteBufferChannel) r100.L$0;
        ResultKt.throwOnFailure(r114);
    L23:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r112, "block");
        if (r111 <= 0) goto L26;
        boolean r115 = true;
    L27:
        if (r115 == false) goto L96;
        if (r111 > 4088) goto L30;
        boolean r116 = true;
    L31:
        if (r116 == false) goto L94;
        io.ktor.utils.io.internal.e r117 = r110.joining;
        if (r117 == null) goto L35;
        A0(r110, r117);
    L35:
        ByteBuffer r118 = r110.H0();
        if (r118 != null) goto L38;
        boolean r119 = false;
        int r120 = 0;
    L69:
        if (r119 == true) goto L71;
        r120 = -1;
    L71:
        if (r120 >= 0) goto L73;
        r100.L$0 = r110;
        r100.L$1 = r112;
        r100.I$0 = r111;
        r100.label = 1;
        if (r110.R(r111, r112, r100) != r102) goto L23;
        return r102;
    L73:
        return Unit.INSTANCE;
    L38:
        io.ktor.utils.io.internal.j r104 = ((io.ktor.utils.io.internal.h) r110._state).f492083b;
        io.ktor.utils.io.internal.c r105 = (io.ktor.utils.io.internal.c) r110._closed;     // Catch: Throwable -> L85
        if (r105 != null) goto L83;
    L41:
        int r106 = r104._availableForWrite$internal;     // Catch: Throwable -> L85
        if (r106 < r111) goto L43;
        if (io.ktor.utils.io.internal.j.f492099c.compareAndSet(r104, r106, 0) == false) goto L41;
    L46:
        if (r106 > 0) goto L48;
        r119 = false;
        r120 = 0;
    L64:
        if (r104.d() == false) goto L66;
    L67:
        r110.a0(1);
    L68:
        r110.C0();
        r110.M0();
        goto L69
    L66:
        if (r110.f491993b == false) goto L68;
    L48:
        r110.e0(r118, r110.f491997f, r106);     // Catch: Throwable -> L85
        int r107 = r118.position();     // Catch: Throwable -> L85
        int r121 = r118.limit();     // Catch: Throwable -> L85
        r112.invoke(r118);     // Catch: Throwable -> L85
        if (r121 != r118.limit()) goto L51;
        boolean r122 = true;
    L52:
        if (r122 == false) goto L82;
        r120 = r118.position() - r107;     // Catch: Throwable -> L85
        if (r120 < 0) goto L56;
        boolean r108 = true;
    L57:
        if (r108 == false) goto L80;
        if (r120 < 0) goto L78;
        r110.T(r118, r104, r120);     // Catch: Throwable -> L85
        if (r120 >= r106) goto L62;
        r104.a(r106 - r120);     // Catch: Throwable -> L85
    L62:
        r119 = true;
        goto L64
    L78:
        throw new IllegalStateException();     // Catch: Throwable -> L85
    L80:
        throw new IllegalStateException("Position has been moved backward: pushback is not supported".toString());     // Catch: Throwable -> L85
    L56:
        r108 = false;
        goto L57
    L82:
        throw new IllegalStateException("Buffer limit modified".toString());     // Catch: Throwable -> L85
    L51:
        r122 = false;
        goto L52
    L43:
        r106 = 0;
        goto L46
    L83:
        io.ktor.utils.io.a.a(r105.a());     // Catch: Throwable -> L85
        throw null;     // Catch: Throwable -> L85
    L85:
        th = move-exception;
        if (r104.d() == false) goto L89;
    L90:
        r110.a0(1);
    L91:
        r110.C0();
        r110.M0();
        throw th;
    L89:
        if (r110.f491993b == false) goto L91;
    L94:
        throw new IllegalArgumentException(("Min(" + r111 + ") shouldn't be greater than 4088").toString());
    L30:
        r116 = false;
        goto L31
    L96:
        throw new IllegalArgumentException("min should be positive".toString());
    L26:
        r115 = false;
        goto L27
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r114);
        if (r111 <= 0) goto L17;
        boolean r123 = true;
    L18:
        if (r123 == false) goto L100;
        if (r111 > 4088) goto L21;
        boolean r124 = true;
    L22:
        if (r124 == true) goto L23;
        throw new IllegalArgumentException(("Min(" + r111 + ") should'nt be greater than (4088)").toString());
    L21:
        r124 = false;
        goto L22
    L100:
        throw new IllegalArgumentException("min should be positive".toString());
    L17:
        r123 = false;
    L7:
        r100 = new ByteBufferChannel$write$1(r110, r113);
        goto L8
    }

    public static int i0(ByteBufferChannel r100, io.ktor.utils.io.core.a r101, int r102, int r110) {
        if ((r110 & 4) == 0) goto L5;
        r102 = r101.f492024e - r101.f492022c;
    L5:
        int r111 = 0;
    L6:
        ByteBuffer r103 = r100.G0();
        boolean r104 = true;
        if (r103 == null) goto L13;
        io.ktor.utils.io.internal.j r105 = ((io.ktor.utils.io.internal.h) r100._state).f492083b;
        if (r105._availableForRead$internal != 0) goto L14;
        r100.B0();
        r100.M0();
        goto L13
    L14:
        int r106 = r101.f492024e - r101.f492022c;     // Catch: Throwable -> L33
        int r107 = r105.h(Math.min(r103.remaining(), Math.min(r106, r102)));     // Catch: Throwable -> L33
        if (r107 > 0) goto L18;
        boolean r108 = false;
    L22:
        r100.B0();
        r100.M0();
    L23:
        r111 = r111 + r107;
        r102 = r102 - r107;
        if (r108 == false) goto L32;
        if (r101.f492024e > r101.f492022c) goto L29;
        r104 = false;
    L29:
        if (r104 == false) goto L32;
        if (((io.ktor.utils.io.internal.h) r100._state).f492083b._availableForRead$internal > 0) goto L6;
    L32:
        return r111;
    L18:
        if (r106 >= r103.remaining()) goto L20;
        r103.limit(r103.position() + r106);     // Catch: Throwable -> L33
    L20:
        io.ktor.utils.io.core.e.a(r101, r103);     // Catch: Throwable -> L33
        r100.S(r103, r105, r107);     // Catch: Throwable -> L33
        r108 = true;
    L33:
        th = move-exception;
        r100.B0();
        r100.M0();
        throw th;
    L13:
        r108 = false;
        r107 = 0;
        goto L23
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0066 -> B:26:0x0069). Please report as a decompilation issue!!! */
    public final Object Y0(byte[] r100, int r101, int r102, Continuation<? super Unit> r103) {
        if ((r103 instanceof ByteBufferChannel$writeFullySuspend$5) == false) goto L7;
        ByteBufferChannel$writeFullySuspend$5 r104 = (ByteBufferChannel$writeFullySuspend$5) r103;
        int r105 = r104.label;
        if ((r105 & Integer.MIN_VALUE) == 0) goto L7;
        r104.label = r105 - Integer.MIN_VALUE;
    L8:
        Object r106 = r104.result;
        Object r107 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r108 = r104.label;
        if (r108 == 0) goto L14;
        if (r108 != 1) goto L13;
        int r109 = r104.I$1;
        r101 = r104.I$0;
        byte[] r110 = (byte[]) r104.L$1;
        ByteBufferChannel r111 = (ByteBufferChannel) r104.L$0;
        ResultKt.throwOnFailure(r106);
    L26:
        int r112 = ((Number) r106).intValue();
        r101 = r101 + r112;
        byte[] r113 = r110;
        r102 = r109 - r112;
        r100 = r113;
    L15:
        if (r102 <= 0) goto L28;
        r104.L$0 = r111;
        r104.L$1 = r100;
        r104.I$0 = r101;
        r104.I$1 = r102;
        r104.label = 1;
        io.ktor.utils.io.internal.e r114 = r111.joining;
        if (r114 == null) goto L19;
        A0(r111, r114);
    L19:
        int r115 = r111.S0(r100, r101, r102);
        if (r115 <= 0) goto L22;
        r106 = Boxing.boxInt(r115);
    L23:
        if (r106 != r107) goto L25;
        return r107;
    L25:
        int r116 = r102;
        r110 = r100;
        r109 = r116;
        goto L26
    L22:
        r106 = r111.e1(r100, r101, r102, r104);
        goto L23
    L28:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r106);
        r111 = this;
    L7:
        r104 = new ByteBufferChannel$writeFullySuspend$5(this, r103);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0059 -> B:22:0x005c). Please report as a decompilation issue!!! */
    public final Object e1(byte[] r100, int r101, int r102, Continuation<? super Integer> r103) {
        if ((r103 instanceof ByteBufferChannel$writeSuspend$1) == false) goto L7;
        ByteBufferChannel$writeSuspend$1 r104 = (ByteBufferChannel$writeSuspend$1) r103;
        int r105 = r104.label;
        if ((r105 & Integer.MIN_VALUE) == 0) goto L7;
        r104.label = r105 - Integer.MIN_VALUE;
    L8:
        Object r106 = r104.result;
        Object r107 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r108 = r104.label;
        if (r108 == 0) goto L18;
        if (r108 != 1) goto L12;
        int r109 = r104.I$1;
        r101 = r104.I$0;
        byte[] r110 = (byte[]) r104.L$1;
        ByteBufferChannel r111 = (ByteBufferChannel) r104.L$0;
        ResultKt.throwOnFailure(r106);
        r102 = r109;
        r100 = r110;
    L22:
        io.ktor.utils.io.internal.e r112 = r111.joining;
        if (r112 == null) goto L25;
        A0(r111, r112);
    L25:
        int r113 = r111.S0(r100, r101, r102);
        if (r113 > 0) goto L28;
    L19:
        r104.L$0 = r111;
        r104.L$1 = r100;
        r104.I$0 = r101;
        r104.I$1 = r102;
        r104.label = 1;
        if (r111.O0(1, r104) != r107) goto L22;
        return r107;
    L28:
        return Boxing.boxInt(r113);
    L12:
        if (r108 != 2) goto L16;
        ResultKt.throwOnFailure(r106);
        return r106;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r106);
        r111 = this;
    L7:
        r104 = new ByteBufferChannel$writeSuspend$1(this, r103);
        goto L8
    }

    public final Object l0(byte[] r100, int r101, int r102, Continuation<? super Integer> r103) {
        if ((r103 instanceof ByteBufferChannel$readAvailableSuspend$1) == false) goto L7;
        ByteBufferChannel$readAvailableSuspend$1 r104 = (ByteBufferChannel$readAvailableSuspend$1) r103;
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
    L27:
        return r106;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r102 = r104.I$1;
        r101 = r104.I$0;
        r100 = (byte[]) r104.L$1;
        ByteBufferChannel r109 = (ByteBufferChannel) r104.L$0;
        ResultKt.throwOnFailure(r106);
    L21:
        if (((Boolean) r106).booleanValue() == false) goto L23;
        r104.L$0 = null;
        r104.L$1 = null;
        r104.label = 2;
        r106 = r109.r(r100, r101, r102, r104);
        if (r106 != r107) goto L27;
        return r107;
    L23:
        return Boxing.boxInt(-1);
    L16:
        ResultKt.throwOnFailure(r106);
        r104.L$0 = this;
        r104.L$1 = r100;
        r104.I$0 = r101;
        r104.I$1 = r102;
        r104.label = 1;
        r106 = t0(1, r104);
        if (r106 != r107) goto L19;
        return r107;
    L19:
        r109 = this;
    L7:
        r104 = new ByteBufferChannel$readAvailableSuspend$1(this, r103);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0057 -> B:19:0x005e). Please report as a decompilation issue!!! */
    public final Object q0(byte[] r100, int r101, int r110, Continuation<? super Unit> r111) {
        if ((r111 instanceof ByteBufferChannel$readFullySuspend$3) == false) goto L7;
        ByteBufferChannel$readFullySuspend$3 r102 = (ByteBufferChannel$readFullySuspend$3) r111;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r112 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        int r106 = r102.I$2;
        int r107 = r102.I$1;
        int r113 = r102.I$0;
        byte[] r108 = (byte[]) r102.L$1;
        ByteBufferChannel r109 = (ByteBufferChannel) r102.L$0;
        ResultKt.throwOnFailure(r112);
    L20:
        if (((Boolean) r112).booleanValue() == false) goto L27;
        int r114 = r113 + r106;
        int r115 = r107 - r106;
        int r116 = r109.h0(r108, r114, r115);
        if (r116 >= r115) goto L24;
        r101 = r114;
        r110 = r115;
        r100 = r108;
    L15:
        r102.L$0 = r109;
        r102.L$1 = r100;
        r102.I$0 = r101;
        r102.I$1 = r110;
        r102.I$2 = r116;
        r102.label = 1;
        Object r117 = r109.t0(1, r102);
        if (r117 != r104) goto L18;
        return r104;
    L18:
        r108 = r100;
        r106 = r116;
        r112 = r117;
        int r118 = r110;
        r113 = r101;
        r107 = r118;
        goto L20
    L24:
        return Unit.INSTANCE;
    L27:
        throw new ClosedReceiveChannelException("Unexpected EOF: expected " + r107 + " more bytes");
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        r116 = 0;
        r109 = this;
    L7:
        r102 = new ByteBufferChannel$readFullySuspend$3(this, r111);
        goto L8
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object r(byte[] r100, int r101, int r102, ContinuationImpl r103) {
        int r104 = h0(r100, r101, r102);
        if (r104 == 0) goto L5;
    L10:
        if (r104 > 0) goto L15;
        if (r102 == 0) goto L15;
        return l0(r100, r101, r102, r103);
    L15:
        return Boxing.boxInt(r104);
    L5:
        if (((io.ktor.utils.io.internal.c) this._closed) == null) goto L10;
        if (((io.ktor.utils.io.internal.h) this._state).f492083b.c() == false) goto L9;
        r104 = h0(r100, r101, r102);
        goto L15
    L9:
        r104 = -1;
        goto L15
    }

    public final Object r0(int r100, io.ktor.utils.io.core.j r101, ByteBuffer r102, Continuation<? super io.ktor.utils.io.core.k> r110) {
        if ((r110 instanceof ByteBufferChannel$readPacketSuspend$1) == false) goto L7;
        ByteBufferChannel$readPacketSuspend$1 r103 = (ByteBufferChannel$readPacketSuspend$1) r110;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r111 = r103.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r103.label;
        if (r106 == 0) goto L18;
        if (r106 != 1) goto L17;
        r100 = r103.I$0;
        ByteBuffer r107 = (ByteBuffer) r103.L$2;
        io.ktor.utils.io.core.j r108 = (io.ktor.utils.io.core.j) r103.L$1;
        ByteBufferChannel r109 = (ByteBufferChannel) r103.L$0;
        ResultKt.throwOnFailure(r111);     // Catch: Throwable -> L14
        r102 = r107;
        r101 = r108;
    L44:
        int r112 = ((Number) r111).intValue();     // Catch: Throwable -> L33
        r102.flip();     // Catch: Throwable -> L33
        io.ktor.utils.io.core.r.a(r101, r102);     // Catch: Throwable -> L33
        r100 = r100 - r112;     // Catch: Throwable -> L33
    L19:
        if (r100 <= 0) goto L30;
        r102.clear();     // Catch: Throwable -> L33
        if (r102.remaining() <= r100) goto L23;
        r102.limit(r100);     // Catch: Throwable -> L33
    L23:
        r103.L$0 = r109;     // Catch: Throwable -> L33
        r103.L$1 = r101;     // Catch: Throwable -> L33
        r103.L$2 = r102;     // Catch: Throwable -> L33
        r103.I$0 = r100;     // Catch: Throwable -> L33
        r103.label = 1;     // Catch: Throwable -> L33
        int r113 = r109.g0(r102);     // Catch: Throwable -> L33
        if (r102.hasRemaining() == true) goto L26;
        r111 = Boxing.boxInt(r113);     // Catch: Throwable -> L33
        if (r111 != r105) goto L44;
        return r105;
    L26:
        r111 = r109.p0(r102, r113, r103);     // Catch: Throwable -> L33
        if (r111 != r105) goto L44;
        goto L44
    L30:
        io.ktor.utils.io.core.k r114 = r101.m();     // Catch: Throwable -> L33
        io.ktor.utils.io.internal.f.f492076b.Rl(r102);
        return r114;
    L33:
        Throwable th10 = th;
        ByteBuffer r115 = r102;
        r108 = r101;
        r107 = r115;
    L40:
        r108.close();     // Catch: Throwable -> L37
        throw th10;     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        io.ktor.utils.io.internal.f.f492076b.Rl(r107);
        throw th;
    L14:
        th10 = th;
        goto L40
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r111);
        r109 = this;
    L7:
        r103 = new ByteBufferChannel$readPacketSuspend$1(this, r110);
        goto L8
    }

    @Override // io.ktor.utils.io.d
    public final Object t(byte[] r100, int r101, int r102, Continuation<? super Unit> r103) {
        io.ktor.utils.io.internal.e r104 = this.joining;
        if (r104 == null) goto L5;
        A0(this, r104);
    L5:
        if (r102 <= 0) goto L9;
        int r105 = S0(r100, r101, r102);
        if (r105 == 0) goto L9;
        r101 = r101 + r105;
        r102 = r102 - r105;
    L9:
        if (r102 == 0) goto L19;
        Object r106 = Y0(r100, r101, r102, r103);
        if (r106 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L15;
        return r106;
    L15:
        return Unit.INSTANCE;
    L19:
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Object d0(ByteBufferChannel r110, final ByteBuffer r111, final long r112, long r210, final long r211, Continuation r212) {
        if ((r212 instanceof ByteBufferChannel$peekTo$1) == false) goto L7;
        ByteBufferChannel$peekTo$1 r100 = (ByteBufferChannel$peekTo$1) r212;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L16;
        if (r104 != 1) goto L15;
        Ref.IntRef r105 = (Ref.IntRef) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: EOFException -> L23
    L22:
        return Boxing.boxLong(r105.element);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r102);
        final Ref.IntRef r106 = new Ref.IntRef();
        int r107 = (int) RangesKt.coerceAtMost(r210 + 0, MapsInitializer.alc_level_ALL);
        final long r108 = 0;
        Function1<? super ByteBuffer, Unit> r113 = new ByteBufferChannel$peekTo$2(r108, r211, r111, r112, r106);     // Catch: EOFException -> L24
        r100.L$0 = r106;     // Catch: EOFException -> L24
        r100.label = 1;     // Catch: EOFException -> L24
        if (r110.m(r107, r113, r100) != r103) goto L20;
        return r103;
    L20:
        r105 = r106;
    L7:
        r100 = new ByteBufferChannel$peekTo$1(r110, r212);
        goto L8
    }
}
