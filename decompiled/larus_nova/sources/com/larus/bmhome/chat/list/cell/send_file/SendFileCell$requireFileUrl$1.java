package com.larus.bmhome.chat.list.cell.send_file;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.list.cell.send_file.SendFileCell", f = "SendFileCell.kt", i = {0}, l = {242, 242, 244}, m = "requireFileUrl", n = {"file"}, s = {"L$0"})
final class SendFileCell$requireFileUrl$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SendFileCell this$0;

    public SendFileCell$requireFileUrl$1(SendFileCell r100, Continuation<? super SendFileCell$requireFileUrl$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return SendFileCell.o(this.this$0, null, this);
    }
}
