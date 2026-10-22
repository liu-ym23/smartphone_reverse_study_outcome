package com.ss.android.lark.chat.service.impl;

import com.facebook.keyframes.model.KFAnimation;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chat.service.impl.EditMessageService", f = "EditMessageService.kt", i = {0, 0, 0}, l = {225}, m = "uploadRichTextMediaIfNeed", n = {"chatId", "uploadId", KFAnimation.PROPERTY_TYPE_JSON_FIELD}, s = {"L$0", "L$1", "L$2"})
final class EditMessageService$uploadRichTextMediaIfNeed$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ EditMessageService this$0;

    public EditMessageService$uploadRichTextMediaIfNeed$1(EditMessageService r100, Continuation<? super EditMessageService$uploadRichTextMediaIfNeed$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return EditMessageService.a(this.this$0, null, null, this);
    }
}
