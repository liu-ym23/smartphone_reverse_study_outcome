package com.bytedance.applet.aibridge.video;

import android.app.Activity;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentConstants$CmtLongPanelStrategy;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonSyntaxException;
import com.larus.common.apphost.AppHost;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.r2;
import com.larus.platform.uimodel.MediaEntity;
import com.larus.platform.uimodel.MediaEntityContainer;
import com.larus.platform.uimodel.VideoParam;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import e3.d;
import f3.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import k3.c;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u001e\u0010\r\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u001e\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00120\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002¨\u0006\u0016"}, d2 = {"Lcom/bytedance/applet/aibridge/video/OpenAwemeVideoMethod;", "Lcom/bytedance/applet/aibridge/video/AbsOpenAwemeVideoMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/video/AbsOpenAwemeVideoMethodIDL$OpenAwemeVideoMethodParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/video/AbsOpenAwemeVideoMethodIDL$OpenAwemeVideoMethodResultModel;", "onResultFalse", "msg", "", "getMapFromJSONObject", "", "", "json", "Lorg/json/JSONObject;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenAwemeVideoMethod extends AbsOpenAwemeVideoMethodIDL {

    public static final class a {
    }

    static {
    }

    public OpenAwemeVideoMethod() {
    }

    public final void handle(d r62, ParamModel r63, h r64) {
        AbsOpenAwemeVideoMethodIDL.a r0 = (AbsOpenAwemeVideoMethodIDL.a) r63;
        Intrinsics.checkNotNullParameter(r62, "bridgeContext");
        Intrinsics.checkNotNullParameter(r0, "params");
        Intrinsics.checkNotNullParameter(r64, "callback");
        Intrinsics.checkNotNullParameter(AbsOpenAwemeVideoMethodIDL.b.class, "<this>");
        AbsOpenAwemeVideoMethodIDL.b r2 = c.a(AbsOpenAwemeVideoMethodIDL.b.class);
        Activity r4 = AppHost.a.a().getCurrentActivity();
        if (r4 != null) goto L5;
        Intrinsics.checkNotNullParameter(AbsOpenAwemeVideoMethodIDL.b.class, "<this>");
        AbsOpenAwemeVideoMethodIDL.b r1 = c.a(AbsOpenAwemeVideoMethodIDL.b.class);
        AbsOpenAwemeVideoMethodIDL.b r3 = r1;
        r3.setMsg("context empty");
        r3.setResult(false);
        r64.b(r1, "");
        return;
    L5:
        ArrayList r7 = new ArrayList();
        ArrayList r15 = new ArrayList();
        Gson r8 = new Gson();
        Iterator r9 = r0.getVideoList().iterator();
    L7:
        if (r9.hasNext() == false) goto L13;
        JsonElement r10 = (JsonElement) r9.next();
        zv3.a r11 = (zv3.a) GsonProtectorUtils.fromJson(r8, r10.toString(), zv3.a.class);     // Catch: JsonSyntaxException -> L11
        r7.add(r11);     // Catch: JsonSyntaxException -> L11
        r15.add(new MediaEntity(null, r11.c(), null, null, null, null, null, null, null, null, null, null, r11.d(), null, null, null, 0, null, null, null, null, null, null, null, 16773117, null));     // Catch: JsonSyntaxException -> L11
    L11:
        e = move-exception;
        FLogger.a.e("OpenAwemeVideoMethod", "wrong video info: " + r10, e);
        Intrinsics.checkNotNullParameter(AbsOpenAwemeVideoMethodIDL.b.class, "<this>");
        AbsOpenAwemeVideoMethodIDL.b r5 = c.a(AbsOpenAwemeVideoMethodIDL.b.class);
        AbsOpenAwemeVideoMethodIDL.b r6 = r5;
        r6.setMsg("wrong video info: " + r10);
        r6.setResult(false);
        r64.b(r5, "");
        return;
    L13:
        zv3.a r12 = (zv3.a) ListProtector.get(r7, r0.getIndex());
        JSONObject r13 = r0.getQueryParams();
        if (r13 == null) goto L16;
        String r16 = r13.toString();
    L17:
        MediaEntityContainer r14 = new MediaEntityContainer(null, r15, null, null, r0.getHasMore(), 0, 0, r16, 109, null);
        MediaEntity r17 = (MediaEntity) CollectionsKt.firstOrNull(r15);
        if (r17 == null) goto L20;
        Integer r18 = r17.getSource_from();
    L21:
        String r19 = r0.getBotId();
        String r110 = r0.getMessageId();
        String r111 = r0.getConversationId();
        String r20 = r12.a();
        if (r20 != null) goto L24;
        String r112 = "";
    L25:
        int r113 = r0.getIndex();
        String r114 = r0.getEnterVideoType();
        JSONObject r21 = r0.getEnterTraceInfo();
        LinkedHashMap r115 = new LinkedHashMap();
        if (r21 == null) goto L36;
        Iterator<String> r22 = r21.keys();
    L30:
        if (r22.hasNext() == false) goto L36;
        String r116 = r22.next();
        Iterator<String> r65 = r22;
        Object r23 = r21.opt(r116);
        if (r23 == null) goto L35;
        r115.put(r116, r23);
    L35:
        r22 = r65;
    L36:
        String r24 = r0.getBotId();
        if (r24 == null) goto L39;
        r115.put("bot_id", r24);
    L39:
        String r25 = r0.getMessageId();
        if (r25 == null) goto L42;
        r115.put("message_id", r25);
    L42:
        r115.put("position", Integer.valueOf(r0.getIndex()));
        String r26 = r12.c();
        if (r26 == null) goto L45;
        r115.put("video_id", r26);
    L45:
        JSONObject r27 = r0.getLeaveTraceInfo();
        if (r27 == null) goto L48;
        r27.put("bot_id", r0.getBotId());
        JSONObject r28 = r27;
    L49:
        String r29 = r0.getSceneId();
        if (r29 != null) goto L52;
        String r117 = "";
    L53:
        Integer r30 = r12.b();
        if (r30 == null) goto L56;
        int r210 = r30.intValue();
    L57:
        Integer r31 = r12.e();
        if (r31 == null) goto L60;
        int r60 = r31.intValue();
    L61:
        VideoParam r32 = new VideoParam(r15, r14, r18, r19, r110, r111, null, r113, r114, r112, r117, r115, r28, r210, r60, null, false, r0.getSectionId(), r0.getReqId(), CommentConstants$CmtLongPanelStrategy.DEFAULT, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, 0, null, null, -950208, 131071);
        FLogger.a.i("OpenAwemeVideoMethod", "openVideoActivity, itemId: " + r12.c());
        IFlowSdkDepend r33 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r33 == null) goto L66;
        r2 r34 = r33.A0();
        if (r34 == null) goto L66;
        r34.p(r4, "", r32);
    L66:
        r2.setResult(true);
        r64.b(r2, "");
        return;
    L60:
        r60 = 10;
        goto L61
    L56:
        r210 = 10;
        goto L57
    L52:
        r117 = r29;
        goto L53
    L48:
        r28 = null;
        goto L49
    L24:
        r112 = r20;
        goto L25
    L20:
        r18 = null;
        goto L21
    L16:
        r16 = null;
        goto L17
    }
}
