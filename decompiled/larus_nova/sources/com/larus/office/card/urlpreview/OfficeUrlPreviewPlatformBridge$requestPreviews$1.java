package com.larus.office.card.urlpreview;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.office.card.urlpreview.OfficeUrlPreviewPlatformBridge", f = "OfficeUrlPreviewPlatformBridge.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {1304, 68}, m = "requestPreviews", n = {"messageId", "urls", "$this$withLock_u24default$iv", "messageId", "$this$withLock_u24default$iv", "plan", "requestUrls"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$4"})
public final class OfficeUrlPreviewPlatformBridge$requestPreviews$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OfficeUrlPreviewPlatformBridge this$0;

    public OfficeUrlPreviewPlatformBridge$requestPreviews$1(OfficeUrlPreviewPlatformBridge r100, Continuation<? super OfficeUrlPreviewPlatformBridge$requestPreviews$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.o(null, null, this);
    }
}
