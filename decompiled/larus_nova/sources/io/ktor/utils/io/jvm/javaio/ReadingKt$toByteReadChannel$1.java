package io.ktor.utils.io.jvm.javaio;

import io.ktor.utils.io.u;
import java.io.InputStream;
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
@DebugMetadata(c = "io.ktor.utils.io.jvm.javaio.ReadingKt$toByteReadChannel$1", f = "Reading.kt", i = {0, 0}, l = {61}, m = "invokeSuspend", n = {"$this$writer", "buffer"}, s = {"L$0", "L$1"})
final class ReadingKt$toByteReadChannel$1 extends SuspendLambda implements Function2<u, Continuation<? super Unit>, Object> {
    final /* synthetic */ io.ktor.utils.io.pool.e<ByteBuffer> $pool;
    final /* synthetic */ InputStream $this_toByteReadChannel;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    public ReadingKt$toByteReadChannel$1(io.ktor.utils.io.pool.e<ByteBuffer> r100, InputStream r101, Continuation<? super ReadingKt$toByteReadChannel$1> r102) {
        this.$pool = r100;
        this.$this_toByteReadChannel = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        ReadingKt$toByteReadChannel$1 r102 = new ReadingKt$toByteReadChannel$1(this.$pool, this.$this_toByteReadChannel, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(u r100, Continuation<? super Unit> r101) {
        return ((ReadingKt$toByteReadChannel$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(u r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L12;
        if (r102 != 1) goto L11;
        ByteBuffer r103 = (ByteBuffer) this.L$1;
        u r104 = (u) this.L$0;
        ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L8
    L13:
        r103.clear();     // Catch: Throwable -> L8
        int r105 = this.$this_toByteReadChannel.read(r103.array(), r103.arrayOffset() + r103.position(), r103.remaining());     // Catch: Throwable -> L8
        if (r105 < 0) goto L20;
        if (r105 == 0) goto L13;
        r103.position(r103.position() + r105);     // Catch: Throwable -> L8
        r103.flip();     // Catch: Throwable -> L8
        io.ktor.utils.io.b r106 = r104.zl();     // Catch: Throwable -> L8
        this.L$0 = r104;     // Catch: Throwable -> L8
        this.L$1 = r103;     // Catch: Throwable -> L8
        this.label = 1;     // Catch: Throwable -> L8
        if (r106.x(r103, this) != r101) goto L13;
        return r101;
    L20:
        this.$pool.Rl(r103);
        this.$this_toByteReadChannel.close();
        return Unit.INSTANCE;
    L8:
        th = move-exception;
        r104.zl().close(th);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        this.$pool.Rl(r103);
        this.$this_toByteReadChannel.close();
        throw th;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r100);
        u r107 = (u) this.L$0;
        r103 = this.$pool.Q5();
        r104 = r107;
        goto L13
    }
}
