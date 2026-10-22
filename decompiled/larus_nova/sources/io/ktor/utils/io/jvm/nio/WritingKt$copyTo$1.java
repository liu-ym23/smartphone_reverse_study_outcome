package io.ktor.utils.io.jvm.nio;

import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.jvm.nio.WritingKt", f = "Writing.kt", i = {0, 0, 0, 0}, l = {50}, m = "copyTo", n = {"$this$copyTo", "copied", "copy", VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT}, s = {"L$0", "L$1", "L$2", "J$0"})
public final class WritingKt$copyTo$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    public WritingKt$copyTo$1(Continuation<? super WritingKt$copyTo$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return WritingKt.a(null, null, 0, this);
    }
}
