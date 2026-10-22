package io.ktor.util.cio;

import io.ktor.utils.io.b;
import io.ktor.utils.io.core.CloseableJVMKt;
import io.ktor.utils.io.u;
import java.io.Closeable;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lio/ktor/utils/io/u;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "io.ktor.util.cio.FileChannelsKt$readChannel$1", f = "FileChannels.kt", i = {0, 0, 1, 1}, l = {44, 63}, m = "invokeSuspend", n = {"$this$use$iv", "closed$iv", "$this$use$iv", "closed$iv"}, s = {"L$0", "I$0", "L$0", "I$0"})
final class FileChannelsKt$readChannel$1 extends SuspendLambda implements Function2<u, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $endInclusive;
    final /* synthetic */ long $fileLength;
    final /* synthetic */ long $start;
    final /* synthetic */ File $this_readChannel;
    int I$0;
    private /* synthetic */ Object L$0;
    int label;

    public FileChannelsKt$readChannel$1(long r100, long r101, long r102, File r103, Continuation<? super FileChannelsKt$readChannel$1> r104) {
        this.$start = r100;
        this.$endInclusive = r101;
        this.$fileLength = r102;
        this.$this_readChannel = r103;
        super(2, r104);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r110, Continuation<?> r111) {
        FileChannelsKt$readChannel$1 r100 = new FileChannelsKt$readChannel$1(this.$start, this.$endInclusive, this.$fileLength, this.$this_readChannel, r111);
        r100.L$0 = r110;
        return r100;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(u r100, Continuation<? super Unit> r101) {
        return ((FileChannelsKt$readChannel$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(u r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.io.RandomAccessFile, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v4 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L14;
        if (r101 == 1) goto L9;
        if (r101 == 2) goto L9;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ?? r102 = (Closeable) this.L$0;
        ResultKt.throwOnFailure(r110);     // Catch: Throwable -> L12
        r102 = r102;
    L37:
        Unit r111 = Unit.INSTANCE;     // Catch: Throwable -> L12
        r102.close();
        return Unit.INSTANCE;
    L12:
        th = th;
        ?? r103 = r102;
    L53:
        r103.close();     // Catch: Throwable -> L44
    L46:
        throw th;     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        throw th;
    L44:
        th = move-exception;
        CloseableJVMKt.a(th, th);     // Catch: Throwable -> L47
        goto L46
    L14:
        ResultKt.throwOnFailure(r110);
        u r112 = (u) this.L$0;
        long r104 = this.$start;
        if (r104 < 0) goto L17;
        boolean r105 = true;
    L18:
        if (r105 == false) goto L52;
        long r106 = this.$endInclusive;
        long r107 = this.$fileLength;
        if (r106 > (r107 - 1)) goto L22;
        boolean r113 = true;
    L23:
        if (r113 == false) goto L50;
        r103 = new RandomAccessFile(this.$this_readChannel, "r");
        long r108 = this.$start;
        final long r114 = this.$endInclusive;
        final FileChannel r109 = r103.getChannel();     // Catch: Throwable -> L41
        if (r108 <= 0) goto L29;
        r109.position(r108);     // Catch: Throwable -> L41
    L29:
        if (r114 != (-1)) goto L33;
        b r115 = r112.zl();     // Catch: Throwable -> L41
        FileChannelsKt$readChannel$1$3$1 r116 = new FileChannelsKt$readChannel$1$3$1(r112, r109, null);     // Catch: Throwable -> L41
        this.L$0 = r103;     // Catch: Throwable -> L41
        this.I$0 = 0;     // Catch: Throwable -> L41
        this.label = 1;     // Catch: Throwable -> L41
        if (r115.k(r116, this) != r100) goto L36;
        return r100;
    L36:
        r102 = r103;
        goto L37
    L33:
        final Ref.LongRef r117 = new Ref.LongRef();     // Catch: Throwable -> L41
        r117.element = r108;     // Catch: Throwable -> L41
        b r118 = r112.zl();     // Catch: Throwable -> L41
        Function1<ByteBuffer, Boolean> r119 = new FileChannelsKt$readChannel$1$3$2(r114, r117, r109);     // Catch: Throwable -> L41
        this.L$0 = r103;     // Catch: Throwable -> L41
        this.I$0 = 0;     // Catch: Throwable -> L41
        this.label = 2;     // Catch: Throwable -> L41
        if (r118.g(r119, this) != r100) goto L36;
        return r100;
    L41:
        th = th;
        goto L53
    L50:
        throw new IllegalArgumentException(("endInclusive points to the position out of the file: file size = " + r107 + ", endInclusive = " + r106).toString());
    L22:
        r113 = false;
        goto L23
    L52:
        throw new IllegalArgumentException(("start position shouldn't be negative but it is " + r104).toString());
    L17:
        r105 = false;
        goto L18
    }
}
