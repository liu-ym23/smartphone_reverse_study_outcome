package com.larus.bmhome.share.network;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.share.network.SharePanelShowHelper", f = "SharePanelShowHelper.kt", i = {}, l = {243}, m = "doRequestCodePreviewShareApi", n = {}, s = {})
final class SharePanelShowHelper$doRequestCodePreviewShareApi$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SharePanelShowHelper this$0;

    public SharePanelShowHelper$doRequestCodePreviewShareApi$1(SharePanelShowHelper r100, Continuation<? super SharePanelShowHelper$doRequestCodePreviewShareApi$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return SharePanelShowHelper.a(this.this$0, null, this);
    }
}
