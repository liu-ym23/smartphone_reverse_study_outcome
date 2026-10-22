package com.larus.chat.gallery.impl.preview.toolbar.action;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.chat.gallery.impl.preview.toolbar.action.SetPrivateAction", f = "SetPrivateAction.kt", i = {0, 0}, l = {148}, m = "resolveCreationIdFromMessage", n = {"messageId", DBDefinition.TASK_ID}, s = {"L$0", "L$1"})
public final class SetPrivateAction$resolveCreationIdFromMessage$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SetPrivateAction this$0;

    public SetPrivateAction$resolveCreationIdFromMessage$1(SetPrivateAction r100, Continuation<? super SetPrivateAction$resolveCreationIdFromMessage$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        SetPrivateAction r101 = this.this$0;
        int r102 = SetPrivateAction.f324699a;
        return r101.d(null, this);
    }
}
