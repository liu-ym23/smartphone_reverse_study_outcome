package com.larus.bmhome.chat.list.cell.nested_file;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.list.cell.nested_file.AttachmentUtil", f = "AttachmentUtil.kt", i = {}, l = {29}, m = "getAudioDetailUrl", n = {}, s = {})
public final class AttachmentUtil$getAudioDetailUrl$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AttachmentUtil this$0;

    public AttachmentUtil$getAudioDetailUrl$1(AttachmentUtil r100, Continuation<? super AttachmentUtil$getAudioDetailUrl$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, null, this);
    }
}
