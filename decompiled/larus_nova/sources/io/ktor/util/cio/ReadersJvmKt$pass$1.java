package io.ktor.util.cio;

import io.ktor.utils.io.ByteReadChannel;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 176)
@DebugMetadata(c = "io.ktor.util.cio.ReadersJvmKt", f = "ReadersJvm.kt", i = {0, 0, 0}, l = {18}, m = "pass", n = {"$this$pass", "buffer", "block"}, s = {"L$0", "L$1", "L$2"})
final class ReadersJvmKt$pass$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    public ReadersJvmKt$pass$1(Continuation<? super ReadersJvmKt$pass$1> r100) {
        super(r100);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0058 -> B:18:0x005b). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        int r101 = this.label | Integer.MIN_VALUE;
        this.label = r101;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r101 - Integer.MIN_VALUE;
        ReadersJvmKt$pass$1 r102 = this;
    L6:
        Object r103 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L12;
        if (r105 != 1) goto L11;
        Function1 r106 = (Function1) r102.L$2;
        ByteBuffer r107 = (ByteBuffer) r102.L$1;
        ByteReadChannel r108 = (ByteReadChannel) r102.L$0;
        ResultKt.throwOnFailure(r103);
    L18:
        r107.flip();
        r106.invoke(r107);
    L14:
        if (r108.E() == true) goto L19;
        r107.clear();
        r102.L$0 = r108;
        r102.L$1 = r107;
        r102.L$2 = r106;
        r102.label = 1;
        if (r108.B(r107, r102) != r104) goto L18;
        return r104;
    L19:
        Throwable r109 = r108.d();
        if (r109 == null) goto L22;
        throw r109;
    L22:
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r103);
        r106 = null;
        r107 = null;
        r108 = null;
        goto L14
    L5:
        r102 = new ReadersJvmKt$pass$1(this);
        goto L6
    }
}
