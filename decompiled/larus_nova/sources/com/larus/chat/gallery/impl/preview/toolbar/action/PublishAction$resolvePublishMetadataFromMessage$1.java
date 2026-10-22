package com.larus.chat.gallery.impl.preview.toolbar.action;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.chat.gallery.impl.preview.toolbar.action.PublishAction", f = "PublishAction.kt", i = {0, 0, 0}, l = {244}, m = "resolvePublishMetadataFromMessage", n = {"metadata", "messageId", DBDefinition.TASK_ID}, s = {"L$0", "L$1", "L$2"})
public final class PublishAction$resolvePublishMetadataFromMessage$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PublishAction this$0;

    public PublishAction$resolvePublishMetadataFromMessage$1(PublishAction r100, Continuation<? super PublishAction$resolvePublishMetadataFromMessage$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        PublishAction r101 = this.this$0;
        int r102 = PublishAction.f324696a;
        return r101.f(null, this);
    }
}
