package com.bytedance.applet.aibridge.camera;

import androidx.collection.LruCache;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.larus.platform.service.w0;
import com.larus.utils.logger.FLogger;
import e3.d;
import f3.h;
import java.util.HashMap;
import java.util.Iterator;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import zb8.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J&\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002¨\u0006\u000f"}, d2 = {"Lcom/bytedance/applet/aibridge/camera/StartCameraAndSendMethod;", "Lcom/bytedance/applet/aibridge/camera/AbsStartCameraAndSendMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/camera/AbsStartCameraAndSendMethodIDL$StartCameraAndSendMethodParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/camera/AbsStartCameraAndSendMethodIDL$StartCameraAndSendMethodResultModel;", "handleHealthScene", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StartCameraAndSendMethod extends AbsStartCameraAndSendMethodIDL {

    public static final class a {
    }

    static {
    }

    public StartCameraAndSendMethod() {
    }

    public final void handle(d r18, ParamModel r19, h r20) {
        AbsStartCameraAndSendMethodIDL.a r1 = (AbsStartCameraAndSendMethodIDL.a) r19;
        Intrinsics.checkNotNullParameter(r18, "bridgeContext");
        Intrinsics.checkNotNullParameter(r1, "params");
        Intrinsics.checkNotNullParameter(r20, "callback");
        if (Intrinsics.areEqual(r1.getScene(), "health") == false) goto L47;
        String r2 = null;
        xe8.a r7 = w0.a(null);
        if ((r7 instanceof xe8.a) == false) goto L7;
        xe8.a r8 = r7;
    L8:
        if (r8 != null) goto L10;
    L43:
        FLogger r3 = FLogger.a;
        StringBuilder r9 = new StringBuilder("fail_reason: not_in_chat, valid conversationId is ");
        if (r8 == null) goto L46;
        r2 = r8.getConversationId();
    L46:
        r9.append(r2);
        r3.i("StartCameraAndSendMethod", r9.toString());
        Intrinsics.checkNotNullParameter(AbsStartCameraAndSendMethodIDL.b.class, "<this>");
        AbsStartCameraAndSendMethodIDL.b r4 = c.a(AbsStartCameraAndSendMethodIDL.b.class);
        AbsStartCameraAndSendMethodIDL.b r5 = r4;
        r5.setResult(0);
        r5.setFailReason("not_in_chat");
        r20.b(r4, "");
        return;
    L10:
        if (Intrinsics.areEqual(r8.getConversationId(), r1.getConversationId()) == false) goto L43;
        HashMap r11 = new HashMap();
        JSONObject r6 = new JSONObject();
        r6.put("ban_action_bar_auto_shift", CommentScene.COMMENTSCENE_NO_AWEME);
        r11.put("chat_key", Long.valueOf(r8.getChatUniqueKey()));
        JSONObject r10 = r1.getExtraInfo();
        if (r10 != null) goto L15;
    L17:
        JSONObject r12 = r1.getMsgExt();
        if (r12 == null) goto L23;
        Iterator<String> r13 = r12.keys();
    L21:
        if (r13.hasNext() == false) goto L23;
        String r14 = r13.next();
        r6.put(r14, r12.opt(r14));
    L23:
        JSONObject r15 = r1.getTraceInfo();
        if (r15 == null) goto L39;
        Iterator<String> r16 = r15.keys();
    L27:
        if (r16.hasNext() == false) goto L39;
        String r17 = r16.next();
        Object r110 = r15.opt(r17);
        if (r110 == null) goto L27;
        if (Intrinsics.areEqual(r17, "content_source_entrance") == true) goto L33;
        r11.put(r17, r110);
        r6.put(r17, r110);
        goto L27
    L33:
        LruCache r111 = ko8.a.a;
        String r112 = r1.getConversationId();
        if ((r110 instanceof String) == false) goto L36;
        String r113 = (String) r110;
    L37:
        ko8.a.k(r112, r113);
        goto L27
    L36:
        r113 = null;
    L39:
        r11.put("extra_params", r6);
        e r21 = r8.WF().getAbility(e.class);
        if (r21 == null) goto L42;
        e.a.b(r21, "health_second_camera", r11, null, null, null, false, 120);
    L42:
        FLogger.a.i("StartCameraAndSendMethod", "startCamera, scene[health], conversationId[" + r1.getConversationId() + ']');
        Intrinsics.checkNotNullParameter(AbsStartCameraAndSendMethodIDL.b.class, "<this>");
        AbsStartCameraAndSendMethodIDL.b r22 = c.a(AbsStartCameraAndSendMethodIDL.b.class);
        r22.setResult(1);
        r20.b(r22, "");
        return;
    L15:
        if (r10.has("disable_text_check") == false) goto L17;
        r6.put("disable_text_check", r10.opt("disable_text_check"));
        goto L17
    L7:
        r8 = null;
        goto L8
    L47:
        FLogger.a.i("StartCameraAndSendMethod", "fail_reason: unknown_scene");
        Intrinsics.checkNotNullParameter(AbsStartCameraAndSendMethodIDL.b.class, "<this>");
        AbsStartCameraAndSendMethodIDL.b r23 = c.a(AbsStartCameraAndSendMethodIDL.b.class);
        AbsStartCameraAndSendMethodIDL.b r24 = r23;
        r24.setResult(0);
        r24.setFailReason("unknown_scene");
        r20.b(r23, "");
    }
}
