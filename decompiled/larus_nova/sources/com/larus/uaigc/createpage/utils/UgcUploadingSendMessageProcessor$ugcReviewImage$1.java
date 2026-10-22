package com.larus.uaigc.createpage.utils;

import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.uaigc.createpage.utils.UgcUploadingSendMessageProcessor", f = "NestedFileSendMessageProcessor.kt", i = {}, l = {90}, m = "ugcReviewImage", n = {}, s = {})
public final class UgcUploadingSendMessageProcessor$ugcReviewImage$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UgcUploadingSendMessageProcessor this$0;

    public UgcUploadingSendMessageProcessor$ugcReviewImage$1(UgcUploadingSendMessageProcessor r100, Continuation<? super UgcUploadingSendMessageProcessor$ugcReviewImage$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        UgcUploadingSendMessageProcessor r101 = this.this$0;
        Set<String> r102 = UgcUploadingSendMessageProcessor.f372624a;
        return r101.f(null, this);
    }
}
