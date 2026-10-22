package io.ktor.utils.io;

import java.io.EOFException;
import java.nio.ByteBuffer;
import kotlin.Deprecated;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.ClosedSendChannelException;

/* JADX INFO: loaded from: classes41.dex */
public final class ByteChannelSequentialJVM extends ByteChannelSequentialBase {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f492009g = 0;
    private volatile Job attachedJob;

    public static final /* synthetic */ void k0(ByteChannelSequentialJVM r100) {
        r100.attachedJob = null;
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
        Job.DefaultImpls.invokeOnCompletion$default(r110, true, false, new ByteChannelSequentialJVM$attachJob$1(this), 2, null);
    }

    public final void l0(ByteBuffer r100) {
        int r101 = r100.remaining();
        int r102 = T();
        if (U() == false) goto L8;
        Throwable r103 = d();
        if (r103 == null) goto L7;
        throw r103;
    L7:
        throw new ClosedSendChannelException("Channel closed for write");
    L8:
        if (r101 != 0) goto L11;
    L13:
        N();
        return;
    L11:
        if (r101 <= r102) goto L17;
        if (r102 == 0) goto L13;
        r100.limit();
        r100.limit(r100.position() + r102);
        io.ktor.utils.io.core.r.a(null, r100);
        throw null;
    L17:
        io.ktor.utils.io.core.r.a(null, r100);
        throw null;
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object B(ByteBuffer r100, ContinuationImpl r101) {
        Throwable r102 = d();
        if (r102 == null) goto L5;
        throw r102;
    L5:
        if (U() == false) goto L11;
        if (w() != 0) goto L11;
        return Boxing.boxInt(-1);
    L11:
        throw null;
    }

    @Override // io.ktor.utils.io.d
    public final Object g(Function1<? super ByteBuffer, Boolean> r100, Continuation<? super Unit> r101) {
        if ((r101 instanceof ByteChannelSequentialJVM$writeWhile$1) == false) goto L7;
        ByteChannelSequentialJVM$writeWhile$1 r102 = (ByteChannelSequentialJVM$writeWhile$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L12;
        Ref.BooleanRef r107 = (Ref.BooleanRef) r102.L$2;
        Function1 r108 = (Function1) r102.L$1;
        ByteChannelSequentialJVM r109 = (ByteChannelSequentialJVM) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L24:
        r109.getClass();
        throw null;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        if (U() == false) goto L20;
        Throwable r110 = d();
        if (r110 == null) goto L19;
        throw r110;
    L19:
        throw new ClosedSendChannelException("Channel closed for write");
    L20:
        Ref.BooleanRef r111 = new Ref.BooleanRef();
        r102.L$0 = this;
        r102.L$1 = r100;
        r102.L$2 = r111;
        r102.label = 1;
        if (P(1, r102) != r105) goto L23;
        return r105;
    L23:
        r109 = this;
    L7:
        r102 = new ByteChannelSequentialJVM$writeWhile$1(this, r101);
        goto L8
    }

    public final Object m0(ByteBuffer r100, Continuation<? super Integer> r101) {
        if ((r101 instanceof ByteChannelSequentialJVM$writeAvailableSuspend$1) == false) goto L7;
        ByteChannelSequentialJVM$writeAvailableSuspend$1 r102 = (ByteChannelSequentialJVM$writeAvailableSuspend$1) r101;
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
        ByteChannelSequentialJVM r107 = (ByteChannelSequentialJVM) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L20:
        r102.L$0 = null;
        r102.L$1 = null;
        r102.label = 2;
        r107.l0(r100);
        if (r100.hasRemaining() == true) goto L23;
        Object r108 = Boxing.boxInt(0);
    L24:
        r104 = r108;
        if (r104 != r105) goto L27;
        return r105;
    L23:
        r108 = r107.m0(r100, r102);
        goto L24
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
        r102 = new ByteChannelSequentialJVM$writeAvailableSuspend$1(this, r101);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x004d -> B:20:0x0050). Please report as a decompilation issue!!! */
    public final Object n0(ByteBuffer r100, Continuation<? super Unit> r101) {
        if ((r101 instanceof ByteChannelSequentialJVM$writeFullySuspend$1) == false) goto L7;
        ByteChannelSequentialJVM$writeFullySuspend$1 r102 = (ByteChannelSequentialJVM$writeFullySuspend$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        r100 = (ByteBuffer) r102.L$1;
        ByteChannelSequentialJVM r107 = (ByteChannelSequentialJVM) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L20:
        r107.l0(r100);
        r107.N();
    L16:
        if (r100.hasRemaining() == false) goto L22;
        r102.L$0 = r107;
        r102.L$1 = r100;
        r102.label = 1;
        if (r107.P(1, r102) != r105) goto L20;
        return r105;
    L22:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        r107 = this;
    L7:
        r102 = new ByteChannelSequentialJVM$writeFullySuspend$1(this, r101);
        goto L8
    }

    @Override // io.ktor.utils.io.d
    public final Object x(ByteBuffer r100, ContinuationImpl r101) {
        l0(r100);
        if (r100.hasRemaining() == false) goto L5;
        Object r102 = n0(r100, r101);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r102;
    L10:
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }

    @Override // io.ktor.utils.io.d
    public final Object I(int r100, Function1<? super ByteBuffer, Unit> r101, Continuation<? super Unit> r102) {
        if ((r102 instanceof ByteChannelSequentialJVM$write$1) == false) goto L7;
        ByteChannelSequentialJVM$write$1 r103 = (ByteChannelSequentialJVM$write$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L12;
        Function1 r108 = (Function1) r103.L$1;
        ByteChannelSequentialJVM r109 = (ByteChannelSequentialJVM) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L24:
        r109.getClass();
        throw null;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        if (U() == false) goto L20;
        Throwable r110 = d();
        if (r110 == null) goto L19;
        throw r110;
    L19:
        throw new ClosedSendChannelException("Channel closed for write");
    L20:
        r103.L$0 = this;
        r103.L$1 = r101;
        r103.I$0 = r100;
        r103.label = 1;
        if (P(r100, r103) != r106) goto L23;
        return r106;
    L23:
        r109 = this;
    L7:
        r103 = new ByteChannelSequentialJVM$write$1(this, r102);
        goto L8
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object m(int r100, Function1<? super ByteBuffer, Unit> r101, Continuation<? super Unit> r102) {
        if ((r102 instanceof ByteChannelSequentialJVM$read$1) == false) goto L7;
        ByteChannelSequentialJVM$read$1 r103 = (ByteChannelSequentialJVM$read$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        r100 = r103.I$0;
        Function1 r108 = (Function1) r103.L$1;
        ByteChannelSequentialJVM r109 = (ByteChannelSequentialJVM) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L24:
        if (((Boolean) r105).booleanValue() == false) goto L26;
        r109.getClass();
        throw null;
    L26:
        throw new EOFException("Channel closed while " + r100 + " bytes expected");
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        if (r100 < 0) goto L17;
        boolean r110 = true;
    L18:
        if (r110 == false) goto L30;
        r103.L$0 = this;
        r103.L$1 = r101;
        r103.I$0 = r100;
        r103.label = 1;
        r105 = f(r100, r103);
        if (r105 != r106) goto L22;
        return r106;
    L22:
        r109 = this;
        goto L24
    L30:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L17:
        r110 = false;
    L7:
        r103 = new ByteChannelSequentialJVM$read$1(this, r102);
        goto L8
    }
}
