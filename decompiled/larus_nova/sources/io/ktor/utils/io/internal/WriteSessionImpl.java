package io.ktor.utils.io.internal;

import io.ktor.utils.io.ByteBufferChannel;
import io.ktor.utils.io.w;
import java.nio.ByteBuffer;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class WriteSessionImpl implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f492060a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ByteBufferChannel f492061b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ByteBuffer f492062c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public io.ktor.utils.io.core.internal.a f492063d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public j f492064e;

    public final void d() {
        ByteBufferChannel r100 = this.f492061b;
        r100.z0();
        this.f492061b = r100;
        ByteBuffer r101 = r100.H0();
        if (r101 != null) goto L5;
        return;
    L5:
        this.f492062c = r101;
        io.ktor.utils.io.core.internal.a r102 = io.ktor.utils.io.core.g.a(this.f492061b.X().f492082a, null);
        this.f492063d = r102;
        io.ktor.utils.io.core.g.c(r102, this.f492062c);
        this.f492064e = this.f492061b.X().f492083b;
    }

    public final void e() {
        int r100 = this.f492060a;
        if (r100 <= 0) goto L5;
        this.f492064e.a(r100);
        this.f492060a = 0;
    L5:
        this.f492061b.C0();
        this.f492061b.M0();
    }

    public WriteSessionImpl(ByteBufferChannel r100) {
        Intrinsics.checkNotNullParameter(r100, "channel");
        r100.z0();
        this.f492061b = r100;
        io.ktor.utils.io.core.internal.a r101 = io.ktor.utils.io.core.internal.a.f492030m;
        this.f492062c = r101.f492020a;
        this.f492063d = r101;
        this.f492064e = r100.X().f492083b;
    }

    @Override // io.ktor.utils.io.v
    public final io.ktor.utils.io.core.internal.a a(int r100) {
        int r101 = this.f492060a;
        j r102 = this.f492064e;
    L3:
        int r103 = r102._availableForWrite$internal;
        if (r103 < 0) goto L5;
        if (j.f492099c.compareAndSet(r102, r103, 0) == false) goto L3;
    L8:
        int r104 = r101 + r103;
        this.f492060a = r104;
        if (r104 >= r100) goto L11;
        return null;
    L11:
        this.f492061b.f0(this.f492062c, r104);
        if (this.f492062c.remaining() >= r100) goto L14;
        return null;
    L14:
        io.ktor.utils.io.core.g.c(this.f492063d, this.f492062c);
        return this.f492063d;
    L5:
        r103 = 0;
        goto L8
    }

    @Override // io.ktor.utils.io.v
    public final void b(int r100) {
        if (r100 < 0) goto L8;
        int r101 = this.f492060a;
        if (r100 > r101) goto L8;
        this.f492060a = r101 - r100;
        ByteBufferChannel r102 = this.f492061b;
        ByteBuffer r103 = this.f492062c;
        j r104 = this.f492064e;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "buffer");
        Intrinsics.checkNotNullParameter(r104, "capacity");
        r102.T(r103, r104, r100);
        return;
    L8:
        if (r100 >= 0) goto L12;
        throw new IllegalArgumentException("Written bytes count shouldn't be negative: " + r100);
    L12:
        throw new IllegalStateException("Unable to mark " + r100 + " bytes as written: only " + this.f492060a + " were pre-locked.");
    }

    @Override // io.ktor.utils.io.w
    public final Object c(int r100, ContinuationImpl r101) {
        if (this.f492061b.b0() == null) goto L9;
        Object r102 = f(r100, r101);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
        return r102;
    L8:
        return Unit.INSTANCE;
    L9:
        int r103 = this.f492060a;
        if (r103 >= r100) goto L12;
        if (r103 <= 0) goto L15;
        this.f492064e.a(r103);
        this.f492060a = 0;
    L15:
        Object r104 = this.f492061b.O0(r100, r101);
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L19;
        return r104;
    L19:
        return Unit.INSTANCE;
    L12:
        return Unit.INSTANCE;
    }

    public final Object f(int r100, Continuation<? super Unit> r101) {
        if ((r101 instanceof WriteSessionImpl$tryAwaitJoinSwitch$1) == false) goto L7;
        WriteSessionImpl$tryAwaitJoinSwitch$1 r102 = (WriteSessionImpl$tryAwaitJoinSwitch$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        WriteSessionImpl r107 = (WriteSessionImpl) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L21:
        ByteBufferChannel r108 = r107.f492061b;
        r108.z0();
        r107.f492061b = r108;
        ByteBuffer r109 = r108.H0();
        if (r109 == null) goto L26;
        r107.f492062c = r109;
        io.ktor.utils.io.core.internal.a r110 = io.ktor.utils.io.core.g.a(r107.f492061b.X().f492082a, null);
        r107.f492063d = r110;
        io.ktor.utils.io.core.g.c(r110, r107.f492062c);
        r107.f492064e = r107.f492061b.X().f492083b;
    L26:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        int r111 = this.f492060a;
        if (r111 <= 0) goto L17;
        this.f492064e.a(r111);
        this.f492060a = 0;
    L17:
        this.f492061b.a0(1);
        this.f492061b.C0();
        this.f492061b.M0();
        ByteBufferChannel r112 = this.f492061b;
        r102.L$0 = this;
        r102.label = 1;
        if (r112.O0(r100, r102) != r105) goto L20;
        return r105;
    L20:
        r107 = this;
    L7:
        r102 = new WriteSessionImpl$tryAwaitJoinSwitch$1(this, r101);
        goto L8
    }
}
