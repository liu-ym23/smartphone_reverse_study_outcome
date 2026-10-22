package com.bytedance.applet.aibridge.tts;

import android.view.View;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.model.AppletRuntimeManager;
import e3.d;
import f3.h;
import k2.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u001e\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002¨\u0006\u0010"}, d2 = {"Lcom/bytedance/applet/aibridge/tts/GetTTSSwitchMethod;", "Lcom/bytedance/applet/aibridge/tts/AbsGetTTSSwitchMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/tts/AbsGetTTSSwitchMethodIDL$GetTTSSwitchParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/tts/AbsGetTTSSwitchMethodIDL$GetTTSSwitchResultModel;", "localGetTtsStatus", "botId", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetTTSSwitchMethod extends AbsGetTTSSwitchMethodIDL {
    public GetTTSSwitchMethod() {
    }

    public final void handle(d r7, ParamModel r8, h r9) {
        Intrinsics.checkNotNullParameter(r7, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsGetTTSSwitchMethodIDL.a) r8, "params");
        Intrinsics.checkNotNullParameter(r9, "callback");
        View r10 = r7.getEngineView();
        AppletRuntimeManager.INSTANCE.getClass();
        i r11 = AppletRuntimeManager.d(r10);
        if (r11 == null) goto L8;
        String r12 = r11.getBotId();
        if (r12 == null) goto L9;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new GetTTSSwitchMethod$localGetTtsStatus$1(r9, r12, null), 3, null);
        return;
    L9:
        return;
    }
}
