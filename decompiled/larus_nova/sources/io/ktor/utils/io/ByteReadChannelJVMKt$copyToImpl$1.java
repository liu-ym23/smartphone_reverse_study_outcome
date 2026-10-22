package io.ktor.utils.io;

import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelJVMKt", f = "ByteReadChannelJVM.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {309, 312}, m = "copyToImpl", n = {"$this$copyToImpl", "dst", "buffer", VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, "dstNeedsFlush", "copied", "$this$copyToImpl", "dst", "buffer", VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, "dstNeedsFlush", "copied", "size"}, s = {"L$0", "L$1", "L$2", "J$0", "I$0", "J$1", "L$0", "L$1", "L$2", "J$0", "I$0", "J$1", "I$1"})
public final class ByteReadChannelJVMKt$copyToImpl$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    long J$0;
    long J$1;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    public ByteReadChannelJVMKt$copyToImpl$1(Continuation<? super ByteReadChannelJVMKt$copyToImpl$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return ByteReadChannelJVMKt.b(null, null, 0, this);
    }
}
