package io.ktor.utils.io;

import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0, 0}, l = {519, 520}, m = "readFullySuspend", n = {"this", "dst", OfficeSDKRequestTag.KEY_NEW_USER}, s = {"L$0", "L$1", "I$0"})
final class ByteChannelSequentialBase$readFullySuspend$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ByteChannelSequentialBase this$0;

    public ByteChannelSequentialBase$readFullySuspend$1(ByteChannelSequentialBase r100, Continuation<? super ByteChannelSequentialBase$readFullySuspend$1> r101) {
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
        ByteChannelSequentialBase$readFullySuspend$1 r104 = this;
    L6:
        Object r105 = r104.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r104.label;
        boolean r108 = true;
        if (r107 == 0) goto L14;
        if (r107 == 1) goto L13;
        if (r107 != 2) goto L12;
        ResultKt.throwOnFailure(r105);
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        int r109 = r104.I$0;
        io.ktor.utils.io.core.a r110 = (io.ktor.utils.io.core.a) r104.L$1;
        ByteChannelSequentialBase r111 = (ByteChannelSequentialBase) r104.L$0;
        ResultKt.throwOnFailure(r105);
        int r112 = r109;
        r101 = r111;
    L18:
        r104.L$0 = null;
        r104.L$1 = null;
        r104.label = 2;
        r101.getClass();
        if (r112 > (r110.f492024e - r110.f492022c)) goto L21;
        boolean r113 = true;
    L22:
        if (r113 == false) goto L32;
        if (r112 >= 0) goto L26;
        r108 = false;
    L26:
        if (r108 == false) goto L30;
        r101.d().getClass();
        Throwable r114 = r101.d();
        Intrinsics.checkNotNull(r114);
        throw r114;
    L30:
        throw new IllegalArgumentException("n shouldn't be negative".toString());
    L32:
        throw new IllegalArgumentException(("Not enough space in the destination buffer to write " + r112 + " bytes").toString());
    L21:
        r113 = false;
        goto L22
    L14:
        ResultKt.throwOnFailure(r105);
        r104.L$0 = r101;
        r104.L$1 = null;
        r104.I$0 = 0;
        r104.label = 1;
        if (r101.Q(0, r104) == r106) goto L33;
        r110 = null;
        r112 = 0;
        goto L18
    L33:
        return r106;
    L5:
        r104 = new ByteChannelSequentialBase$readFullySuspend$1(r101, this);
        goto L6
    }
}
