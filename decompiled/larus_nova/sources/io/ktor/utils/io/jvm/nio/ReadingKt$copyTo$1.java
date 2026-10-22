package io.ktor.utils.io.jvm.nio;

import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import io.ktor.utils.io.d;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.jvm.nio.ReadingKt", f = "Reading.kt", i = {0, 0, 0, 0, 0, 0}, l = {42}, m = "copyTo", n = {"ch", "copied", "eof", "copy", VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, "needFlush"}, s = {"L$0", "L$1", "L$2", "L$3", "J$0", "I$0"})
final class ReadingKt$copyTo$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;

    public ReadingKt$copyTo$1(Continuation<? super ReadingKt$copyTo$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        this.result = r110;
        int r111 = this.label | Integer.MIN_VALUE;
        this.label = r111;
        if ((r111 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r111 - Integer.MIN_VALUE;
        ReadingKt$copyTo$1 r112 = this;
    L6:
        Object r100 = r112.result;
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = r112.label;
        if (r102 != 0) goto L9;
        ResultKt.throwOnFailure(r100);
        final Ref.LongRef r103 = new Ref.LongRef();
        final Ref.BooleanRef r104 = new Ref.BooleanRef();
        final long r105 = 0;
        final ReadableByteChannel r106 = null;
        new ReadingKt$copyTo$copy$1(r105, r103, r106, r104);
        throw null;
    L9:
        if (r102 != 1) goto L23;
        int r107 = r112.I$0;
        long r108 = r112.J$0;
        Function1<? super ByteBuffer, Unit> r109 = (Function1) r112.L$3;
        Ref.BooleanRef r113 = (Ref.BooleanRef) r112.L$2;
        Ref.LongRef r114 = (Ref.LongRef) r112.L$1;
        d r115 = (d) r112.L$0;
        ResultKt.throwOnFailure(r100);
    L11:
        if (r107 == 0) goto L13;
        r115.flush();
    L13:
        long r116 = r114.element;
        if (r116 >= r108) goto L21;
        if (r113.element == true) goto L21;
        r112.L$0 = r115;
        r112.L$1 = r114;
        r112.L$2 = r113;
        r112.L$3 = r109;
        r112.J$0 = r108;
        r112.I$0 = r107;
        r112.label = 1;
        if (r115.I(1, r109, r112) != r101) goto L11;
        return r101;
    L21:
        return Boxing.boxLong(r116);
    L23:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L5:
        r112 = new ReadingKt$copyTo$1(this);
        goto L6
    }
}
