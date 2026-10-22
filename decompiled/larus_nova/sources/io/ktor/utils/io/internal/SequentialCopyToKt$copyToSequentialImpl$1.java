package io.ktor.utils.io.internal;

import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.internal.SequentialCopyToKt", f = "SequentialCopyTo.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {26, 31, 39}, m = "copyToSequentialImpl", n = {"$this$copyToSequentialImpl", "dst", VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, "remainingLimit", "$this$copyToSequentialImpl", "dst", VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, "remainingLimit", "$this$copyToSequentialImpl", "dst", VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, "remainingLimit", "transferred"}, s = {"L$0", "L$1", "J$0", "J$1", "L$0", "L$1", "J$0", "J$1", "L$0", "L$1", "J$0", "J$1", "J$2"})
public final class SequentialCopyToKt$copyToSequentialImpl$1 extends ContinuationImpl {
    long J$0;
    long J$1;
    long J$2;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    public SequentialCopyToKt$copyToSequentialImpl$1(Continuation<? super SequentialCopyToKt$copyToSequentialImpl$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return SequentialCopyToKt.a(null, null, 0, this);
    }
}
