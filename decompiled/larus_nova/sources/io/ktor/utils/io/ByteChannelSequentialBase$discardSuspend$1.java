package io.ktor.utils.io;

import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0, 0}, l = {673}, m = "discardSuspend", n = {"this", BitableFieldEditAnalytic.ProgressFieldEditScene.MAX, "discarded"}, s = {"L$0", "J$0", "J$1"})
final class ByteChannelSequentialBase$discardSuspend$1 extends ContinuationImpl {
    long J$0;
    long J$1;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ByteChannelSequentialBase this$0;

    public ByteChannelSequentialBase$discardSuspend$1(ByteChannelSequentialBase r100, Continuation<? super ByteChannelSequentialBase$discardSuspend$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        ByteChannelSequentialBase r101 = this.this$0;
        AtomicLongFieldUpdater r102 = ByteChannelSequentialBase.f492003b;
        r101.getClass();
        int r103 = this.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r103 - Integer.MIN_VALUE;
        ByteChannelSequentialBase$discardSuspend$1 r104 = this;
    L6:
        Object r105 = r104.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r104.label;
        if (r107 == 0) goto L12;
        if (r107 != 1) goto L11;
        long r108 = r104.J$1;
        r101 = (ByteChannelSequentialBase) r104.L$0;
        ResultKt.throwOnFailure(r105);
    L17:
        if (((Boolean) r105).booleanValue() == true) goto L23;
        Throwable r109 = r101.d();
        if (r109 == null) goto L21;
        throw r109;
    L21:
        return Boxing.boxLong(r108);
    L23:
        r101.getClass();
        throw null;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r105);
        r104.L$0 = r101;
        r104.J$0 = 0;
        r104.J$1 = 0;
        r104.label = 1;
        r105 = r101.f(1, r104);
        if (r105 == r106) goto L25;
        r108 = 0;
        goto L17
    L25:
        return r106;
    L5:
        r104 = new ByteChannelSequentialBase$discardSuspend$1(r101, this);
        goto L6
    }
}
