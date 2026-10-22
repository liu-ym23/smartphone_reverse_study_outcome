package io.ktor.util.cio;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.core.CloseableJVMKt;
import io.ktor.utils.io.jvm.nio.WritingKt;
import io.ktor.utils.io.s;
import java.io.Closeable;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lio/ktor/utils/io/s;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "io.ktor.util.cio.FileChannelsKt$writeChannel$1", f = "FileChannels.kt", i = {0, 0, 0}, l = {96}, m = "invokeSuspend", n = {"$this$use$iv", "file", "closed$iv"}, s = {"L$0", "L$1", "I$0"})
final class FileChannelsKt$writeChannel$1 extends SuspendLambda implements Function2<s, Continuation<? super Unit>, Object> {
    final /* synthetic */ File $this_writeChannel;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    public FileChannelsKt$writeChannel$1(File r100, Continuation<? super FileChannelsKt$writeChannel$1> r101) {
        this.$this_writeChannel = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        FileChannelsKt$writeChannel$1 r102 = new FileChannelsKt$writeChannel$1(this.$this_writeChannel, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(s r100, Continuation<? super Unit> r101) {
        return ((FileChannelsKt$writeChannel$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(s r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r102 = this.label;
        if (r102 == 0) goto L10;
        if (r102 != 1) goto L9;
        RandomAccessFile r103 = (RandomAccessFile) this.L$1;
        Closeable r104 = (Closeable) this.L$0;
        ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L18
        RandomAccessFile r105 = r103;
        r102 = r104;
    L15:
        r105.setLength(((Number) r100).longValue());     // Catch: Throwable -> L18
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L18
        r102.close();
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r100);
        s r107 = (s) this.L$0;
        RandomAccessFile r108 = new RandomAccessFile(this.$this_writeChannel, "rw");
        ByteReadChannel r109 = r107.getChannel();     // Catch: Throwable -> L18
        FileChannel r110 = r108.getChannel();     // Catch: Throwable -> L18
        this.L$0 = r108;     // Catch: Throwable -> L18
        this.L$1 = r108;     // Catch: Throwable -> L18
        this.I$0 = 0;     // Catch: Throwable -> L18
        this.label = 1;     // Catch: Throwable -> L18
        r100 = WritingKt.a(r109, r110, Long.MAX_VALUE, this);     // Catch: Throwable -> L18
        if (r100 != r101) goto L14;
        return r101;
    L14:
        r105 = r108;
        r102 = r108;
    L18:
        th = move-exception;
        r102.close();     // Catch: Throwable -> L21
    L23:
        throw th;     // Catch: Throwable -> L24
    L21:
        th = move-exception;
        CloseableJVMKt.a(th, th);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }
}
