package com.bytedance.applet.aibridge.video;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeDefaultValue;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.annotation.DefaultType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.utils.g;
import com.bytedance.applet.model.floating.c;
import e3.d;
import f3.h;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0011\u0012B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010H\u0016R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/bytedance/applet/aibridge/video/DeepResearchPodcastPlayStartedMethod;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/applet/aibridge/video/DeepResearchPodcastPlayStartedMethod$DeepResearchPodcastPlayStartedParamModel;", "Lcom/bytedance/applet/aibridge/video/DeepResearchPodcastPlayStartedMethod$DeepResearchPodcastPlayStartedResultModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "DeepResearchPodcastPlayStartedParamModel", "DeepResearchPodcastPlayStartedResultModel", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DeepResearchPodcastPlayStartedMethod extends CoreAIBridgeMethod<a, b> {

    @AIBridgeParamModel
    public interface a extends ParamModel {
        @AIBridgeParamField(defaultValue = @AIBridgeDefaultValue(type = DefaultType.STRING), keyPath = "resource_id", required = false)
        String getResourceId();
    }

    @AIBridgeResultModel
    public interface b extends ResultModel {
    }

    public final String getName() {
        return "flow.deepResearchPodcastPlayStarted";
    }

    public DeepResearchPodcastPlayStartedMethod() {
    }

    public final void handle(d r4, ParamModel r5, h r6) {
        a r7 = (a) r5;
        Intrinsics.checkNotNullParameter(r4, "bridgeContext");
        Intrinsics.checkNotNullParameter(r7, "params");
        Intrinsics.checkNotNullParameter(r6, "callback");
        g r8 = g.a;
        r8.i("flow.deepResearchPodcastPlayStarted", "received DeepResearchPodcastPlayStartedMethod event resource_id=" + r7.getResourceId());
        c r0 = c.a;
        String r9 = r7.getResourceId();
        if (r9 != null) goto L5;
        r9 = "";
    L5:
        Intrinsics.checkNotNullParameter(r9, "resourceId");
        c.f = r9;
        JSONObject r1 = new JSONObject();
        Intrinsics.checkNotNullParameter(r1, "$this$publishEvent");
        r1.put("resource_id", r9);
        Unit r10 = Unit.INSTANCE;
        r8.i("FloatingAbilityImpl", "send event：EVENT_DEEP_RESEARCH_PODCAST_STARTED payload=" + r1);
        c.b.setValue(TuplesKt.to("EVENT_DEEP_RESEARCH_PODCAST_STARTED", r1));
        Intrinsics.checkNotNullParameter(b.class, "<this>");
        r6.b(k3.c.a(b.class), "");
    }
}
