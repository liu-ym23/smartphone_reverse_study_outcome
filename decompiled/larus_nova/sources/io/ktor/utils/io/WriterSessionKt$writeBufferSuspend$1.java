package io.ktor.utils.io;

import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.WriterSessionKt", f = "WriterSession.kt", i = {0, 0}, l = {93}, m = "writeBufferSuspend", n = {AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "desiredSpace"}, s = {"L$0", "I$0"})
public final class WriterSessionKt$writeBufferSuspend$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public WriterSessionKt$writeBufferSuspend$1(Continuation<? super WriterSessionKt$writeBufferSuspend$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return WriterSessionKt.d(null, 0, this);
    }
}
