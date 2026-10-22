package com.larus.avlink.notification;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.avlink.notification.DoraLinkStatusReporter", f = "DoraLinkStatusReporter.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {154, 172}, m = "doReport", n = {"result", "postBody", DBDefinition.RETRY_COUNT, "failCount", "result", "postBody", DBDefinition.RETRY_COUNT, "failCount", "needRetry"}, s = {"L$0", "L$1", "I$0", "I$1", "L$0", "L$1", "I$0", "I$1", "I$2"})
final class DoraLinkStatusReporter$doReport$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraLinkStatusReporter this$0;

    public DoraLinkStatusReporter$doReport$1(DoraLinkStatusReporter r100, Continuation<? super DoraLinkStatusReporter$doReport$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return DoraLinkStatusReporter.a(this.this$0, false, 0, 0, 0, this);
    }
}
