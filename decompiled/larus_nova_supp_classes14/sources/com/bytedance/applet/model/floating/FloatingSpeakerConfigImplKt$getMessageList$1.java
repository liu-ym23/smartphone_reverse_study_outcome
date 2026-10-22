package com.bytedance.applet.model.floating;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.model.floating.FloatingSpeakerConfigImplKt", f = "FloatingSpeakerConfigImpl.kt", i = {1}, l = {457, 541}, m = "getMessageList", n = {"request"}, s = {"L$0"})
public final class FloatingSpeakerConfigImplKt$getMessageList$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public FloatingSpeakerConfigImplKt$getMessageList$1(Continuation<? super FloatingSpeakerConfigImplKt$getMessageList$1> r1) {
        super(r1);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return FloatingSpeakerConfigImplKt.d(null, null, this);
    }
}
