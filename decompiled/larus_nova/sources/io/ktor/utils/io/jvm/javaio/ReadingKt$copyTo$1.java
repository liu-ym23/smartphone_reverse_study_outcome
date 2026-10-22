package io.ktor.utils.io.jvm.javaio;

import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.jvm.javaio.ReadingKt", f = "Reading.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {29}, m = "copyTo", n = {"$this$copyTo", "channel", "buffer", VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, "copied", "bufferSize", "rc"}, s = {"L$0", "L$1", "L$2", "J$0", "J$1", "J$2", "I$0"})
final class ReadingKt$copyTo$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    long J$1;
    long J$2;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    public ReadingKt$copyTo$1(Continuation<? super ReadingKt$copyTo$1> r100) {
        super(r100);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x006f -> B:26:0x008a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0085 -> B:25:0x0088). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        this.result = r110;
        int r100 = this.label | Integer.MIN_VALUE;
        this.label = r100;
        if ((r100 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r100 - Integer.MIN_VALUE;
        ReadingKt$copyTo$1 r101 = this;
    L6:
        Object r102 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        int r105 = r101.I$0;
        long r106 = r101.J$2;
        long r107 = r101.J$1;
        long r111 = r101.J$0;
        byte[] r112 = (byte[]) r101.L$2;
        io.ktor.utils.io.d r113 = (io.ktor.utils.io.d) r101.L$1;
        InputStream r114 = (InputStream) r101.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L30
    L25:
        r107 = r107 + ((long) r105);     // Catch: Throwable -> L30
    L17:
        if (r107 >= r111) goto L27;
        r105 = r114.read(r112, 0, (int) Math.min(r111 - r107, r106));     // Catch: Throwable -> L30
        if (r105 == (-1)) goto L27;
        if (r105 <= 0) goto L17;
        r101.L$0 = r114;     // Catch: Throwable -> L30
        r101.L$1 = r113;     // Catch: Throwable -> L30
        r101.L$2 = r112;     // Catch: Throwable -> L30
        r101.J$0 = r111;     // Catch: Throwable -> L30
        r101.J$1 = r107;     // Catch: Throwable -> L30
        r101.J$2 = r106;     // Catch: Throwable -> L30
        r101.I$0 = r105;     // Catch: Throwable -> L30
        r101.label = 1;     // Catch: Throwable -> L30
        if (r113.t(r112, 0, r105, r101) != r103) goto L25;
    L29:
        return r103;
    L27:
        r103 = Boxing.boxLong(r107);     // Catch: Throwable -> L30
        io.ktor.utils.io.pool.a.f492133a.Rl(r112);
        goto L29
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        r112 = io.ktor.utils.io.pool.a.f492133a.Q5();
        r106 = r112.length;     // Catch: Throwable -> L30
        r107 = 0;
        r113 = null;
        r114 = null;
        r111 = 0;
    L30:
        th = move-exception;
        io.ktor.utils.io.pool.a.f492133a.Rl(r112);
        throw th;
    L5:
        r101 = new ReadingKt$copyTo$1(this);
        goto L6
    }
}
