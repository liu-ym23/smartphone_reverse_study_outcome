package com.bytedance.applet.aibridge.feedback;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.larus.utils.logger.FLogger;
import f3.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/applet/aibridge/feedback/GetFeedbackDataMethod;", "Lcom/bytedance/applet/aibridge/feedback/AbsGetFeedbackDataMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/feedback/AbsGetFeedbackDataMethodIDL$GetFeedbackParam;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/feedback/AbsGetFeedbackDataMethodIDL$GetFeedbackResult;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetFeedbackDataMethod extends AbsGetFeedbackDataMethodIDL {

    public static final class a {
    }

    static {
    }

    public GetFeedbackDataMethod() {
    }

    public final void handle(e3.d r3, ParamModel r4, final h r5) {
        final AbsGetFeedbackDataMethodIDL.a r6 = (AbsGetFeedbackDataMethodIDL.a) r4;
        Intrinsics.checkNotNullParameter(r3, "bridgeContext");
        Intrinsics.checkNotNullParameter(r6, "params");
        Intrinsics.checkNotNullParameter(r5, "callback");
        FLogger.a.v("js_fb_get", "start;[messageId]" + r6.getMessageId() + "[entityId]" + r6.getEntityId() + "[entityType]" + r6.getEntityType() + "[scene]" + r6.getScene());
        com.larus.im.d.e().m(r6.getMessageId(), new AnonymousClass1(r6, r5, this));
    }
}
