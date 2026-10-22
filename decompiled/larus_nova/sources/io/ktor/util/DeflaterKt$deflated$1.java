package io.ktor.util;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.u;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lio/ktor/utils/io/u;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "io.ktor.util.DeflaterKt$deflated$1", f = "Deflater.kt", i = {}, l = {110}, m = "invokeSuspend", n = {}, s = {})
final class DeflaterKt$deflated$1 extends SuspendLambda implements Function2<u, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $gzip;
    final /* synthetic */ io.ktor.utils.io.pool.e<ByteBuffer> $pool;
    final /* synthetic */ ByteReadChannel $this_deflated;
    private /* synthetic */ Object L$0;
    int label;

    public DeflaterKt$deflated$1(ByteReadChannel r100, boolean r101, io.ktor.utils.io.pool.e<ByteBuffer> r102, Continuation<? super DeflaterKt$deflated$1> r103) {
        this.$this_deflated = r100;
        this.$gzip = r101;
        this.$pool = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        DeflaterKt$deflated$1 r102 = new DeflaterKt$deflated$1(this.$this_deflated, this.$gzip, this.$pool, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(u r100, Continuation<? super Unit> r101) {
        return ((DeflaterKt$deflated$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(u r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        u r103 = (u) this.L$0;
        ByteReadChannel r104 = this.$this_deflated;
        io.ktor.utils.io.b r105 = r103.zl();
        boolean r106 = this.$gzip;
        io.ktor.utils.io.pool.e<ByteBuffer> r107 = this.$pool;
        this.label = 1;
        if (DeflaterKt.a(r104, r105, r106, r107, this) != r101) goto L12;
        return r101;
    }
}
