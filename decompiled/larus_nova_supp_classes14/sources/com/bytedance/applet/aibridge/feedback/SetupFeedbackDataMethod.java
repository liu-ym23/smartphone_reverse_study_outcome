package com.bytedance.applet.aibridge.feedback;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.larus.im.bean.message.MsgFeedbackType;
import com.larus.utils.logger.FLogger;
import f3.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J6\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002¨\u0006\u0013"}, d2 = {"Lcom/bytedance/applet/aibridge/feedback/SetupFeedbackDataMethod;", "Lcom/bytedance/applet/aibridge/feedback/AbsSetupFeedbackDataMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/feedback/AbsSetupFeedbackDataMethodIDL$SubmitFeedbackParam;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/feedback/AbsSetupFeedbackDataMethodIDL$SubmitFeedbackResult;", "sendFeedback", "message", "Lcom/larus/im/bean/message/Message;", "feedbackType", "Lcom/larus/im/bean/message/MsgFeedbackType;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SetupFeedbackDataMethod extends AbsSetupFeedbackDataMethodIDL {
    public static final /* synthetic */ int b = 0;

    public static final class a {
    }

    static {
    }

    public SetupFeedbackDataMethod() {
    }

    public final void handle(e3.d r9, ParamModel r10, h r11) {
        AbsSetupFeedbackDataMethodIDL.a r3 = (AbsSetupFeedbackDataMethodIDL.a) r10;
        Intrinsics.checkNotNullParameter(r9, "bridgeContext");
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r11, "callback");
        FLogger.a.v("js_fb_setup", "start,[messageId]" + r3.getMessageId() + ":[conversationId]" + r3.getConversationId() + ":[feedbackType]" + r3.getFeedbackType() + ":[feedbackDetailType]" + r3.getFeedbackDetailType() + ":[entityId]" + r3.getEntityId() + ":[entityType]" + r3.getEntityType());
        MsgFeedbackType.a r12 = MsgFeedbackType.Companion;
        int r0 = r3.getFeedbackType();
        r12.getClass();
        MsgFeedbackType r4 = MsgFeedbackType.a.a(r0);
        if (r4 != null) goto L5;
        h.a.a(r11, "unknown feedbackType: " + r3.getFeedbackType(), null, null, 14);
        return;
    L5:
        com.larus.im.d.e().m(r3.getMessageId(), new c(this, r9, r3, r4, r11));
    }
}
