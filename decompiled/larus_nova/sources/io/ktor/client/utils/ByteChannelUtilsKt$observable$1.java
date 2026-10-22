package io.ktor.client.utils;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.pool.e;
import io.ktor.utils.io.u;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lio/ktor/utils/io/u;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "io.ktor.client.utils.ByteChannelUtilsKt$observable$1", f = "ByteChannelUtils.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3}, l = {23, 24, 26, 31}, m = "invokeSuspend", n = {"$this$writer", "$this$useInstance$iv", "instance$iv", "byteArray", "total", "bytesSend", "$this$writer", "$this$useInstance$iv", "instance$iv", "byteArray", "total", "bytesSend", "read", "$this$writer", "$this$useInstance$iv", "instance$iv", "byteArray", "total", "bytesSend", "$this$useInstance$iv", "instance$iv"}, s = {"L$0", "L$1", "L$4", "L$5", "J$0", "J$1", "L$0", "L$1", "L$4", "L$5", "J$0", "J$1", "I$0", "L$0", "L$1", "L$4", "L$5", "J$0", "J$1", "L$0", "L$1"})
final class ByteChannelUtilsKt$observable$1 extends SuspendLambda implements Function2<u, Continuation<? super Unit>, Object> {
    final /* synthetic */ Long $contentLength;
    final /* synthetic */ Function3<Long, Long, Continuation<? super Unit>, Object> $listener;
    final /* synthetic */ ByteReadChannel $this_observable;
    int I$0;
    long J$0;
    long J$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public ByteChannelUtilsKt$observable$1(Long r100, ByteReadChannel r101, Function3<? super Long, ? super Long, ? super Continuation<? super Unit>, ? extends Object> r102, Continuation<? super ByteChannelUtilsKt$observable$1> r103) {
        this.$contentLength = r100;
        this.$this_observable = r101;
        this.$listener = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        ByteChannelUtilsKt$observable$1 r102 = new ByteChannelUtilsKt$observable$1(this.$contentLength, this.$this_observable, this.$listener, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(u r100, Continuation<? super Unit> r101) {
        return ((ByteChannelUtilsKt$observable$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(u r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x0161 -> B:51:0x0172). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r210) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        int r102 = 0;
        int r103 = 2;
        int r104 = 1;
        if (r101 == 0) goto L30;
        if (r101 == 1) goto L25;
        if (r101 == 2) goto L20;
        if (r101 == 3) goto L15;
        if (r101 != 4) goto L14;
        Object r105 = this.L$1;
        e r106 = (e) this.L$0;
        ResultKt.throwOnFailure(r210);     // Catch: Throwable -> L11
    L62:
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L11
        r106.Rl(r105);
        return Unit.INSTANCE;
    L11:
        th = th;
    L65:
        Object r110 = r105;
        e r108 = r106;
    L66:
        r108.Rl(r110);
        throw th;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        long r111 = this.J$1;
        long r112 = this.J$0;
        byte[] r109 = (byte[]) this.L$5;
        Object r113 = this.L$4;
        Function3<Long, Long, Continuation<? super Unit>, Object> r114 = (Function3) this.L$3;
        ByteReadChannel r115 = (ByteReadChannel) this.L$2;
        e r116 = (e) this.L$1;
        u r117 = (u) this.L$0;
        ResultKt.throwOnFailure(r210);     // Catch: Throwable -> L18
        ByteChannelUtilsKt$observable$1 r118 = this;
        u r119 = r117;
        Function3<Long, Long, Continuation<? super Unit>, Object> r120 = r114;
        byte[] r121 = r109;
        ByteReadChannel r122 = r115;
        long r123 = r112;
        r105 = r113;
        long r124 = r111;
    L51:
        r102 = 0;
        r103 = 2;
        r104 = 1;
    L74:
    L52:
        th = th;
        r106 = r116;
        goto L65
    L38:
        if (r122.E() == true) goto L54;
        r118.L$0 = r119;     // Catch: Throwable -> L52
        r118.L$1 = r116;     // Catch: Throwable -> L52
        r118.L$2 = r122;     // Catch: Throwable -> L52
        r118.L$3 = r120;     // Catch: Throwable -> L52
        r118.L$4 = r105;     // Catch: Throwable -> L52
        r118.L$5 = r121;     // Catch: Throwable -> L52
        r118.J$0 = r123;     // Catch: Throwable -> L52
        r118.J$1 = r124;     // Catch: Throwable -> L52
        r118.label = r104;     // Catch: Throwable -> L52
        Object r125 = r122.r(r121, r102, r121.length, r118);     // Catch: Throwable -> L52
        if (r125 != r100) goto L42;
        return r100;
    L42:
        int r126 = ((Number) r125).intValue();     // Catch: Throwable -> L52
        io.ktor.utils.io.b r127 = r119.zl();     // Catch: Throwable -> L52
        r118.L$0 = r119;     // Catch: Throwable -> L52
        r118.L$1 = r116;     // Catch: Throwable -> L52
        r118.L$2 = r122;     // Catch: Throwable -> L52
        r118.L$3 = r120;     // Catch: Throwable -> L52
        r118.L$4 = r105;     // Catch: Throwable -> L52
        r118.L$5 = r121;     // Catch: Throwable -> L52
        r118.J$0 = r123;     // Catch: Throwable -> L52
        r118.J$1 = r124;     // Catch: Throwable -> L52
        r118.I$0 = r126;     // Catch: Throwable -> L52
        r118.label = r103;     // Catch: Throwable -> L52
        if (r127.t(r121, 0, r126, r118) != r100) goto L45;
        return r100;
    L45:
        ByteChannelUtilsKt$observable$1 r128 = r118;
        long r129 = r124;
        r110 = r105;
        e r130 = r116;
        int r131 = r126;
        byte[] r132 = r121;
        Function3<Long, Long, Continuation<? super Unit>, Object> r133 = r120;
        long r134 = r129;
        long r211 = r123;
        byte[] r135 = r132;
        u r136 = r119;
        long r137 = r211;
    L46:
        long r138 = r134 + ((long) r131);
        Long r139 = Boxing.boxLong(r138);     // Catch: Throwable -> L23
        Long r140 = Boxing.boxLong(r137);     // Catch: Throwable -> L23
        r128.L$0 = r136;     // Catch: Throwable -> L23
        r128.L$1 = r130;     // Catch: Throwable -> L23
        r128.L$2 = r122;     // Catch: Throwable -> L23
        r128.L$3 = r133;     // Catch: Throwable -> L23
        r128.L$4 = r110;     // Catch: Throwable -> L23
        r128.L$5 = r135;     // Catch: Throwable -> L23
        r128.J$0 = r137;     // Catch: Throwable -> L23
        r128.J$1 = r138;     // Catch: Throwable -> L23
        r128.label = 3;     // Catch: Throwable -> L23
        if (r133.invoke(r139, r140, r128) != r100) goto L50;
        return r100;
    L50:
        r105 = r110;
        long r141 = r137;
        r118 = r128;
        r119 = r136;
        Function3<Long, Long, Continuation<? super Unit>, Object> r142 = r133;
        r121 = r135;
        r123 = r141;
        r120 = r142;
        r116 = r130;
        r124 = r138;
    L23:
        th = th;
        r108 = r130;
        goto L66
    L54:
        Throwable r143 = r122.d();     // Catch: Throwable -> L52
        r119.zl().close(r143);     // Catch: Throwable -> L52
        if (r143 == null) goto L57;
    L61:
        r106 = r116;
        goto L62
    L57:
        if (r124 != 0) goto L61;
        Long r144 = Boxing.boxLong(r124);     // Catch: Throwable -> L52
        Long r145 = Boxing.boxLong(r123);     // Catch: Throwable -> L52
        r118.L$0 = r116;     // Catch: Throwable -> L52
        r118.L$1 = r105;     // Catch: Throwable -> L52
        r118.L$2 = null;     // Catch: Throwable -> L52
        r118.L$3 = null;     // Catch: Throwable -> L52
        r118.L$4 = null;     // Catch: Throwable -> L52
        r118.L$5 = null;     // Catch: Throwable -> L52
        r118.label = 4;     // Catch: Throwable -> L52
        if (r120.invoke(r144, r145, r118) != r100) goto L61;
        return r100;
    L20:
        r131 = this.I$0;
        r134 = this.J$1;
        long r146 = this.J$0;
        r135 = (byte[]) this.L$5;
        r110 = this.L$4;
        Function3<Long, Long, Continuation<? super Unit>, Object> r147 = (Function3) this.L$3;
        ByteReadChannel r148 = (ByteReadChannel) this.L$2;
        r130 = (e) this.L$1;
        r136 = (u) this.L$0;
        ResultKt.throwOnFailure(r210);     // Catch: Throwable -> L23
        r128 = this;
        r133 = r147;
        r122 = r148;
        r137 = r146;
        goto L46
    L25:
        long r149 = this.J$1;
        r123 = this.J$0;
        byte[] r150 = (byte[]) this.L$5;
        r110 = this.L$4;
        Function3<Long, Long, Continuation<? super Unit>, Object> r151 = (Function3) this.L$3;
        r122 = (ByteReadChannel) this.L$2;
        e r152 = (e) this.L$1;
        r119 = (u) this.L$0;
        ResultKt.throwOnFailure(r210);     // Catch: Throwable -> L28
        r125 = r210;
        r118 = this;
        r121 = r150;
        r105 = r110;
        r124 = r149;
        r120 = r151;
        r116 = r152;
    L28:
        th = th;
        r108 = r152;
        goto L66
    L30:
        ResultKt.throwOnFailure(r210);
        u r153 = (u) this.L$0;
        r116 = io.ktor.utils.io.pool.a.f492133a;
        Long r154 = this.$contentLength;
        ByteReadChannel r155 = this.$this_observable;
        Function3<Long, Long, Continuation<? super Unit>, Object> r156 = this.$listener;
        Object r157 = r116.Q5();
        r121 = (byte[]) r157;     // Catch: Throwable -> L18
        if (r154 == null) goto L35;
        long r158 = r154.longValue();     // Catch: Throwable -> L18
    L36:
        r119 = r153;
        r120 = r156;
        r105 = r157;
        r124 = 0;
        long r159 = r158;
        r118 = this;
        r122 = r155;
        r123 = r159;
        goto L74
    L35:
        r158 = -1;
    L18:
        th = th;
        goto L66
    }
}
