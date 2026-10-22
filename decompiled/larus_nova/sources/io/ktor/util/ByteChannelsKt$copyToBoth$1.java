package io.ktor.util;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.core.CloseableJVMKt;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "io.ktor.util.ByteChannelsKt$copyToBoth$1", f = "ByteChannels.kt", i = {1, 1, 1, 2, 2}, l = {61, 63, 64}, m = "invokeSuspend", n = {"$this$use$iv", "it", "closed$iv", "$this$use$iv", "closed$iv"}, s = {"L$0", "L$4", "I$0", "L$0", "I$0"})
final class ByteChannelsKt$copyToBoth$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ io.ktor.utils.io.d $first;
    final /* synthetic */ io.ktor.utils.io.d $second;
    final /* synthetic */ ByteReadChannel $this_copyToBoth;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    public ByteChannelsKt$copyToBoth$1(ByteReadChannel r100, io.ktor.utils.io.d r101, io.ktor.utils.io.d r102, Continuation<? super ByteChannelsKt$copyToBoth$1> r103) {
        this.$this_copyToBoth = r100;
        this.$first = r101;
        this.$second = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ByteChannelsKt$copyToBoth$1(this.$this_copyToBoth, this.$first, this.$second, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ByteChannelsKt$copyToBoth$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00e4 -> B:96:0x00e6). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x00fa -> B:46:0x00e8). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L24;
        if (r101 == 1) goto L89;
        if (r101 == 2) goto L14;
        if (r101 != 3) goto L13;
        ByteReadChannel r102 = (ByteReadChannel) this.L$3;
        io.ktor.utils.io.d r103 = (io.ktor.utils.io.d) this.L$2;
        io.ktor.utils.io.d r104 = (io.ktor.utils.io.d) this.L$1;
        Closeable r105 = (Closeable) this.L$0;
        ResultKt.throwOnFailure(r110);     // Catch: Throwable -> L10
        io.ktor.utils.io.d r106 = r104;
        ByteReadChannel r107 = r102;
        Object r108 = r100;
        ByteChannelsKt$copyToBoth$1 r109 = this;
    L96:
        Unit r111 = Unit.INSTANCE;     // Catch: Throwable -> L47
    L46:
        ByteChannelsKt$copyToBoth$1 r112 = r109;
        r100 = r108;
        r105.close();     // Catch: Throwable -> L74
    L26:
        if (r112.$this_copyToBoth.E() == false) goto L28;
    L70:
        Throwable r113 = r112.$this_copyToBoth.d();     // Catch: Throwable -> L74
        if (r113 != null) goto L73;
        io.ktor.utils.io.e.a(r112.$first);
        io.ktor.utils.io.d r114 = r112.$second;
    L78:
        io.ktor.utils.io.e.a(r114);
        return Unit.INSTANCE;
    L73:
        throw r113;     // Catch: Throwable -> L74
    L28:
        if (r112.$first.c() == true) goto L30;
    L31:
        ByteReadChannel r115 = r112.$this_copyToBoth;     // Catch: Throwable -> L74
        r112.L$0 = null;     // Catch: Throwable -> L74
        r112.L$1 = null;     // Catch: Throwable -> L74
        r112.L$2 = null;     // Catch: Throwable -> L74
        r112.L$3 = null;     // Catch: Throwable -> L74
        r112.L$4 = null;     // Catch: Throwable -> L74
        r112.label = 1;     // Catch: Throwable -> L74
        Object r116 = r115.h(4096, r112);     // Catch: Throwable -> L74
        if (r116 != r100) goto L34;
        return r100;
    L34:
        Object r117 = r100;
        r109 = r112;
        r110 = r116;
        r108 = r117;
    L104:
        Closeable r118 = (Closeable) r110;     // Catch: Throwable -> L68
        io.ktor.utils.io.d r119 = r109.$first;     // Catch: Throwable -> L68
        io.ktor.utils.io.d r120 = r109.$second;     // Catch: Throwable -> L68
        ByteReadChannel r121 = r109.$this_copyToBoth;     // Catch: Throwable -> L68
        io.ktor.utils.io.core.k r122 = (io.ktor.utils.io.core.k) r118;     // Catch: Throwable -> L59
        io.ktor.utils.io.core.k r123 = r122.v();     // Catch: Throwable -> L51
        r109.L$0 = r118;     // Catch: Throwable -> L51
        r109.L$1 = r119;     // Catch: Throwable -> L51
        r109.L$2 = r120;     // Catch: Throwable -> L51
        r109.L$3 = r121;     // Catch: Throwable -> L51
        r109.L$4 = r122;     // Catch: Throwable -> L51
        int r124 = 0;
        r109.I$0 = 0;     // Catch: Throwable -> L51
        r109.label = 2;     // Catch: Throwable -> L51
        if (r119.l(r123, r109) != r108) goto L40;
        return r108;
    L40:
        r106 = r119;
        io.ktor.utils.io.core.k r125 = r122;
        io.ktor.utils.io.d r126 = r120;
        r107 = r121;
    L102:
        io.ktor.utils.io.core.k r127 = r125.v();     // Catch: Throwable -> L49
        r109.L$0 = r118;     // Catch: Throwable -> L49
        r109.L$1 = r106;     // Catch: Throwable -> L49
        r109.L$2 = r126;     // Catch: Throwable -> L49
        r109.L$3 = r107;     // Catch: Throwable -> L49
        r109.L$4 = null;     // Catch: Throwable -> L49
        r109.I$0 = r124;     // Catch: Throwable -> L49
        r109.label = 3;     // Catch: Throwable -> L49
        if (r126.l(r127, r109) != r108) goto L44;
        return r108;
    L44:
        r103 = r126;
        r105 = r118;
    L49:
        th = move-exception;
        io.ktor.utils.io.d r128 = r126;
        r105 = r118;
        Throwable th10 = th;
        r103 = r128;
    L100:
        r107.cancel(th10);     // Catch: Throwable -> L57
        r106.close(th10);     // Catch: Throwable -> L57
        Boxing.boxBoolean(r103.close(th10));     // Catch: Throwable -> L57
    L57:
        Throwable th11 = th;
    L91:
        r105.close();     // Catch: Throwable -> L63
    L65:
        throw th11;     // Catch: Throwable -> L66
    L63:
        th = move-exception;
        CloseableJVMKt.a(th11, th);     // Catch: Throwable -> L66
    L66:
        th = move-exception;
        throw th;     // Catch: Throwable -> L68
    L51:
        th = move-exception;
        r105 = r118;
        th10 = th;
        r106 = r119;
        r103 = r120;
        r107 = r121;
    L59:
        th = move-exception;
        r105 = r118;
        th11 = th;
    L68:
        Throwable th12 = th;
    L93:
        r109.$first.close(th12);     // Catch: Throwable -> L80
        r109.$second.close(th12);     // Catch: Throwable -> L80
        io.ktor.utils.io.e.a(r109.$first);
        r114 = r109.$second;
    L80:
        th = move-exception;
        io.ktor.utils.io.e.a(r109.$first);
        io.ktor.utils.io.e.a(r109.$second);
        throw th;
    L30:
        if (r112.$second.c() == true) goto L70;
    L74:
        th = move-exception;
        r109 = r112;
        th12 = th;
    L47:
        th10 = th;
    L10:
        th10 = th;
    L19:
        r106 = r104;
        r107 = r102;
        r108 = r100;
        r109 = this;
        goto L100
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        int r129 = this.I$0;
        r125 = (io.ktor.utils.io.core.k) this.L$4;
        r107 = (ByteReadChannel) this.L$3;
        r126 = (io.ktor.utils.io.d) this.L$2;
        r106 = (io.ktor.utils.io.d) this.L$1;
        Closeable r130 = (Closeable) this.L$0;
        ResultKt.throwOnFailure(r110);     // Catch: Throwable -> L17
        r124 = r129;
        r118 = r130;
        r108 = r100;
        r109 = this;
    L17:
        th10 = th;
        r102 = r107;
        r103 = r126;
        r104 = r106;
        r105 = r130;
        goto L19
    L89:
        ResultKt.throwOnFailure(r110);     // Catch: Throwable -> L22
        r108 = r100;
        r109 = this;
    L22:
        th12 = th;
        r109 = this;
        goto L93
    L24:
        ResultKt.throwOnFailure(r110);
        r112 = this;
        goto L26
    }
}
