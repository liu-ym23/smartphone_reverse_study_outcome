package io.ktor.util.cio;

import io.ktor.utils.io.u;
import io.ktor.utils.io.w;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lio/ktor/utils/io/w;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "io.ktor.util.cio.FileChannelsKt$readChannel$1$3$1", f = "FileChannels.kt", i = {0}, l = {49}, m = "invokeSuspend", n = {"$this$writeSuspendSession"}, s = {"L$0"})
public final class FileChannelsKt$readChannel$1$3$1 extends SuspendLambda implements Function2<w, Continuation<? super Unit>, Object> {
    final /* synthetic */ u $$this$writer;
    final /* synthetic */ FileChannel $fileChannel;
    private /* synthetic */ Object L$0;
    int label;

    public FileChannelsKt$readChannel$1$3$1(u r100, FileChannel r101, Continuation<? super FileChannelsKt$readChannel$1$3$1> r102) {
        this.$$this$writer = r100;
        this.$fileChannel = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        FileChannelsKt$readChannel$1$3$1 r102 = new FileChannelsKt$readChannel$1$3$1(this.$$this$writer, this.$fileChannel, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(w r100, Continuation<? super Unit> r101) {
        return ((FileChannelsKt$readChannel$1$3$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(w r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        w r103 = (w) this.L$0;
        ResultKt.throwOnFailure(r100);
    L9:
        io.ktor.utils.io.core.internal.a r104 = r103.a(1);
        if (r104 == null) goto L11;
        FileChannel r105 = this.$fileChannel;
        Intrinsics.checkNotNullParameter(r105, "<this>");
        Intrinsics.checkNotNullParameter(r104, "buffer");
        int r106 = r104.f492024e - r104.f492022c;
        int r107 = 0;
        if (r106 == 0) goto L25;
        if (1 > r106) goto L19;
        r107 = 1;
    L19:
        if (r107 == 0) goto L32;
        ByteBuffer r108 = r104.f492020a.duplicate();
        Intrinsics.checkNotNull(r108);
        int r109 = r104.f492022c;
        r108.limit(r104.f492024e);
        r108.position(r109);
        int r110 = r105.read(r108);
        int r111 = r108.position() - r109;
        if (r111 < 0) goto L30;
        if (r111 > r106) goto L30;
        r104.a(r111);
        r107 = r110;
    L30:
        throw new IllegalStateException("Wrong buffer position change: " + r111 + ". Position should be moved forward only by at most size bytes (size = 1)");
    L32:
        throw new IllegalArgumentException(("size 1 is greater than buffer's remaining capacity " + r106).toString());
    L25:
        if (r107 == (-1)) goto L28;
        r103.b(r107);
        goto L9
    L28:
        return Unit.INSTANCE;
    L11:
        this.$$this$writer.zl().flush();
        this.L$0 = r103;
        this.label = 1;
        if (r103.c(1, this) != r101) goto L9;
        return r101;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        r103 = (w) this.L$0;
        goto L9
    }
}
