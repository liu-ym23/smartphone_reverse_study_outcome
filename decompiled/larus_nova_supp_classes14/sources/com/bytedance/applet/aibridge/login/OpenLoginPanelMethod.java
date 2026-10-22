package com.bytedance.applet.aibridge.login;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.larus.login.api.ITouristApi;
import com.larus.login.api.TouristManager;
import com.larus.platform.model.TriggerLoginScene;
import e3.d;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/applet/aibridge/login/OpenLoginPanelMethod;", "Lcom/bytedance/applet/aibridge/login/AbsOpenLoginPanelMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/login/AbsOpenLoginPanelMethodIDL$LoginParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/login/AbsOpenLoginPanelMethodIDL$LoginResultModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenLoginPanelMethod extends AbsOpenLoginPanelMethodIDL {
    public OpenLoginPanelMethod() {
    }

    public final void handle(d r5, ParamModel r6, h r7) {
        AbsOpenLoginPanelMethodIDL.a r8 = (AbsOpenLoginPanelMethodIDL.a) r6;
        Intrinsics.checkNotNullParameter(r5, "bridgeContext");
        Intrinsics.checkNotNullParameter(r8, "params");
        Intrinsics.checkNotNullParameter(r7, "callback");
        JSONObject r0 = r8.getTraceInfo();     // Catch: Exception -> L17
        if (r0 == null) goto L7;
        String r1 = r0.optString("enter_from", "");     // Catch: Exception -> L17
    L9:
        if (Intrinsics.areEqual(r1, "first_application_music_query") == false) goto L12;
        TriggerLoginScene r2 = TriggerLoginScene.TRIGGER_LOGIN_FIRST_APPLICATION_MUSIC_QUERY;     // Catch: Exception -> L17
    L15:
        b r3 = new b(r8);     // Catch: Exception -> L17
        Ref.ObjectRef r9 = new Ref.ObjectRef();     // Catch: Exception -> L17
        a r4 = new a(r3, r9);     // Catch: Exception -> L17
        r9.element = r4;     // Catch: Exception -> L17
        TouristManager r10 = TouristManager.a;     // Catch: Exception -> L17
        r10.s(r4);     // Catch: Exception -> L17
        ITouristApi.a.a(r10, r2, false, 2);     // Catch: Exception -> L17
        Intrinsics.checkNotNullParameter(AbsOpenLoginPanelMethodIDL.b.class, "<this>");     // Catch: Exception -> L17
        r7.b(c.a(AbsOpenLoginPanelMethodIDL.b.class), "");     // Catch: Exception -> L17
        return;
    L12:
        if (Intrinsics.areEqual(r1, "first_application_music_history_click") == false) goto L14;
        r2 = TriggerLoginScene.TRIGGER_LOGIN_FIRST_APPLICATION_MUSIC_HISTORY_CLICK;     // Catch: Exception -> L17
        goto L15
    L14:
        r2 = TriggerLoginScene.TRIGGER_LOGIN_CLICK_OTHERS;     // Catch: Exception -> L17
        goto L15
    L7:
        r1 = null;
    L17:
        h.a.a(r7, "unknown error", null, null, 14);
    }
}
