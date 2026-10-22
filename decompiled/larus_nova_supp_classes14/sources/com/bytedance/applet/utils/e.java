package com.bytedance.applet.utils;

import androidx.fragment.app.FragmentActivity;
import com.larus.platform.api.g1;
import com.larus.platform.model.LocateScene;
import com.larus.platform.service.i2;
import com.larus.platform.service.l1;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e implements com.bytedance.applet.event.o {

    public static final class a {
    }

    static {
    }

    public e() {
    }

    @Override // com.bytedance.applet.event.o
    public final boolean a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "apiName");
        return Intrinsics.areEqual(r2, "get_high_precision_location");
    }

    @Override // com.bytedance.applet.event.o
    public final void b(String r7, String r8, String r9, String r10, String r11, String r12, String r13, com.bytedance.applet.event.a r14) {
        Intrinsics.checkNotNullParameter(r7, "botId");
        Intrinsics.checkNotNullParameter(r8, "conversationId");
        Intrinsics.checkNotNullParameter(r9, "appId");
        Intrinsics.checkNotNullParameter(r10, "apiName");
        Intrinsics.checkNotNullParameter(r11, "param");
        Intrinsics.checkNotNullParameter(r12, "msgId");
        Intrinsics.checkNotNullParameter(r13, "questionId");
        Intrinsics.checkNotNullParameter(r14, "uiUAppActionCallback");
        FLogger.a.i("LocationUiAppActionInterceptor", "doUiUProcess apiName=" + r10 + " msgId=" + r12 + " questionId=" + r13);
        JSONObject r15 = new JSONObject(r11).optJSONObject("data");     // Catch: JSONException -> L12
        if (r15 == null) goto L7;
        String r16 = r15.optString("pluginParams");     // Catch: JSONException -> L12
        if (r16 == null) goto L7;
    L8:
        JSONObject r17 = new JSONObject(r16).optJSONObject("extraInfo");     // Catch: JSONException -> L12
        if (r17 != null) goto L14;
        r17 = new JSONObject();     // Catch: JSONException -> L12
    L14:
        String r18 = r17.optString("toolSceneId", "");
        int r19 = i.a;
        LocateScene r20 = LocateScene.AGENT_TOOL;
        f r21 = new f(r12, r13, r14, this);
        JSONObject r4 = new JSONObject();
        r4.put("tool_name", r10);
        r4.put("tool_scene_id", r18);
        Unit r22 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(r20, "scene");
        Intrinsics.checkNotNullParameter(r21, "callback");
        gd9.i r23 = com.larus.im.b.a;
        Intrinsics.checkNotNull(r23);
        FragmentActivity r24 = r23.a().e();
        if ((r24 instanceof FragmentActivity) == false) goto L17;
        FragmentActivity r25 = r24;
    L18:
        FragmentActivity r0 = r25;
        l1 r26 = l1.a;
        if (r26.c() == true) goto L21;
        d.a.a(r21, false, false, true, 2);
        return;
    L21:
        int r110 = uv3.c.a;
        gd9.i r111 = com.larus.im.b.a;
        Intrinsics.checkNotNull(r111);
        if (uv3.c.b(r111.getApplication()) == false) goto L24;
        r26.f(r20, new g(r21), r4);
        return;
    L24:
        i2 r27 = i2.b;
        g1.a.b(r0, CollectionsKt.listOf(new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"}), new h(r21, r20, r4), null, r4, 8);
        return;
    L17:
        r25 = null;
    L7:
        r16 = "{}";
    L12:
        e = move-exception;
        FLogger.a.e("LocationUiAppActionInterceptor", "doUiUProcess extraInfo json error error=" + e, e);
        r17 = new JSONObject();
        goto L14
    }
}
