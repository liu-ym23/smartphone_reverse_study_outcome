package com.bytedance.applet.jsb;

import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import com.larus.audioplayer.api.news.NewsUrlAudioManagerDelegate;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class j0 extends bx7.c {
    public final String getName() {
        return "applet.playAudio";
    }

    public j0() {
    }

    public final void a(dx7.b r19, ux7.d.d r20, IvyBridgePlatformType r21) {
        Intrinsics.checkNotNullParameter(r19, "params");
        Intrinsics.checkNotNullParameter(r20, "callback");
        Intrinsics.checkNotNullParameter(r21, "type");
        String r3 = r19.getString("url");
        JSONObject r14 = new JSONObject(cx7.a.d(r19, "extra", "{}"));     // Catch: JSONException -> L22
        String r1 = r14.optString("scene");     // Catch: JSONException -> L22
        String r9 = r14.optString("title");     // Catch: JSONException -> L22
        String r10 = r14.optString("artist");     // Catch: JSONException -> L22
        String r4 = r14.optString("album_art_url");     // Catch: JSONException -> L22
        int r6 = r14.optInt("sourceType");     // Catch: JSONException -> L22
        String r8 = r14.optString("videoModel");     // Catch: JSONException -> L22
        Intrinsics.checkNotNull(r1);     // Catch: JSONException -> L22
        Intrinsics.checkNotNull(r8);     // Catch: JSONException -> L22
        Intrinsics.checkNotNull(r9);     // Catch: JSONException -> L22
        Intrinsics.checkNotNull(r10);     // Catch: JSONException -> L22
        if (r4 != null) goto L6;
    L9:
        boolean r5 = true;
    L10:
        if (r5 == false) goto L12;
        String r11 = null;
    L13:
        b88.d r7 = new b88.d(r1, r6, r3, r8, r9, r10, r11, r14.optString("conversation_id"), r14.optString("message_id"), r14.optString("applet_id"));     // Catch: JSONException -> L22
        if ((!StringsKt.isBlank(r3)) == true) goto L16;
    L20:
        NewsUrlAudioManagerDelegate.b.i(r7, a.a);     // Catch: JSONException -> L22
        j0 r12 = this;
    L23:
        bx7.c.d(r12, r20, new LinkedHashMap());
        return;
    L16:
        if (Intrinsics.areEqual("news", r1) == false) goto L20;
        JSONObject r0 = r14.optJSONObject("trace_info");     // Catch: JSONException -> L22
        if (r0 == null) goto L20;
        a.b.put(r3, r0);     // Catch: JSONException -> L22
        goto L20
    L12:
        r11 = r4;
        goto L13
    L6:
        if (StringsKt.isBlank(r4) == true) goto L9;
        r5 = false;
    L22:
        r12 = this;
        bx7.c.c(r12, r20, -3, null, 12);
        goto L23
    }
}
