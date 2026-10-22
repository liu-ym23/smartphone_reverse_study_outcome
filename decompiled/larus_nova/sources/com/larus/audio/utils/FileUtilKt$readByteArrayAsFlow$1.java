package com.larus.audio.utils;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.audio.utils.FileUtilKt$readByteArrayAsFlow$1", f = "FileUtil.kt", i = {0, 0, 0}, l = {250}, m = "invokeSuspend", n = {"$this$flow", "stream", "buffer"}, s = {"L$0", "L$2", "L$3"})
final class FileUtilKt$readByteArrayAsFlow$1 extends SuspendLambda implements Function2<FlowCollector<? super byte[]>, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $blockSize;
    final /* synthetic */ File $this_readByteArrayAsFlow;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    public FileUtilKt$readByteArrayAsFlow$1(File r100, int r101, Continuation<? super FileUtilKt$readByteArrayAsFlow$1> r102) {
        this.$this_readByteArrayAsFlow = r100;
        this.$blockSize = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        FileUtilKt$readByteArrayAsFlow$1 r102 = new FileUtilKt$readByteArrayAsFlow$1(this.$this_readByteArrayAsFlow, this.$blockSize, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super byte[]> r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(FlowCollector<? super byte[]> r100, Continuation<? super Unit> r101) {
        return ((FileUtilKt$readByteArrayAsFlow$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.io.BufferedInputStream, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v6 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L12;
        if (r102 != 1) goto L11;
        byte[] r103 = (byte[]) this.L$3;
        BufferedInputStream r104 = (BufferedInputStream) this.L$2;
        Closeable r105 = (Closeable) this.L$1;
        FlowCollector r106 = (FlowCollector) this.L$0;
        ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L8
        ?? r107 = r104;
    L15:
        int r108 = r107.read(r103);     // Catch: Throwable -> L8
        if (r108 == (-1)) goto L24;
        if (r108 != r103.length) goto L20;
        byte[] r109 = r103;
    L21:
        this.L$0 = r106;     // Catch: Throwable -> L8
        this.L$1 = r105;     // Catch: Throwable -> L8
        this.L$2 = r107;     // Catch: Throwable -> L8
        this.L$3 = r103;     // Catch: Throwable -> L8
        this.label = 1;     // Catch: Throwable -> L8
        if (r106.emit(r109, this) != r101) goto L15;
        return r101;
    L20:
        r109 = Arrays.copyOf(r103, r108);     // Catch: Throwable -> L8
        goto L21
    L24:
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L8
        CloseableKt.closeFinally(r105, null);
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r100);
        FlowCollector r111 = (FlowCollector) this.L$0;
        r105 = new BufferedInputStream(new PolarisFileInputStreamWrapper(this.$this_readByteArrayAsFlow), this.$blockSize);
        r103 = new byte[this.$blockSize];     // Catch: Throwable -> L8
        r106 = r111;
        r107 = r105;
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        CloseableKt.closeFinally(r105, th);
        throw th;
    }
}
