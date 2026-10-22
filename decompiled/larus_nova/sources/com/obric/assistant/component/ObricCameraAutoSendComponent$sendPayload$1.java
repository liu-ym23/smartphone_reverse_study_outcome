package com.obric.assistant.component;

import com.bytedance.common.wschannel.WsConstants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.component.ObricCameraAutoSendComponent", f = "ObricCameraAutoSendComponent.kt", i = {0}, l = {61}, m = "sendPayload", n = {WsConstants.KEY_PAYLOAD}, s = {"L$0"})
final class ObricCameraAutoSendComponent$sendPayload$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ObricCameraAutoSendComponent this$0;

    public ObricCameraAutoSendComponent$sendPayload$1(ObricCameraAutoSendComponent r100, Continuation<? super ObricCameraAutoSendComponent$sendPayload$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return ObricCameraAutoSendComponent.Y2(this.this$0, null, this);
    }
}
