package com.bytedance.applet.jsb;

import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import com.larus.audioplayer.api.music.IMusicPlayManager;
import com.larus.audioplayer.api.music.MusicPlayManagerDelegate;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class k0 extends bx7.c {
    public final String getName() {
        return "applet.playMusic";
    }

    public k0() {
    }

    public final void a(dx7.b r26, ux7.d.d r27, IvyBridgePlatformType r28) {
        Intrinsics.checkNotNullParameter(r26, "params");
        Intrinsics.checkNotNullParameter(r27, "callback");
        Intrinsics.checkNotNullParameter(r28, "type");
        JSONObject r8 = new JSONObject(cx7.a.d(r26, "music_info", ""));     // Catch: JSONException -> L22
        String r18 = cx7.a.d(r26, "call_id", "");     // Catch: JSONException -> L22
        String r1 = r8.optString("music_id");     // Catch: JSONException -> L22
        String r11 = r8.optString("video_model_str");     // Catch: JSONException -> L22
        String r12 = r8.optString("title");     // Catch: JSONException -> L22
        String r13 = r8.optString("artist");     // Catch: JSONException -> L22
        String r17 = r8.optString("album_art_url");     // Catch: JSONException -> L22
        boolean r4 = false;
        boolean r15 = r8.optBoolean("is_favorite", false);     // Catch: JSONException -> L22
        boolean r3 = r8.optBoolean("has_pre", false);     // Catch: JSONException -> L22
        boolean r14 = r8.optBoolean("has_next", false);     // Catch: JSONException -> L22
        boolean r23 = r8.optBoolean("is_auto_play", false);     // Catch: JSONException -> L22
        if (r1 != null) goto L6;
    L9:
        boolean r9 = true;
    L10:
        if (r9 == true) goto L19;
        if (r11 != null) goto L13;
    L14:
        r4 = true;
    L15:
        if (r4 == true) goto L19;
        Intrinsics.checkNotNull(r12);     // Catch: JSONException -> L22
        Intrinsics.checkNotNull(r13);     // Catch: JSONException -> L22
        a88.e r5 = new a88.e(r1, r11, r12, r13, false, r15, false, r17, r18, "", "", null, 8368);     // Catch: JSONException -> L22
        IMusicPlayManager.a.a(MusicPlayManagerDelegate.b, r5, c0.a, new e1(r1, r14, r3), r23, 16);     // Catch: JSONException -> L22
    L24:
        bx7.c.d(this, r27, new LinkedHashMap());
        return;
    L13:
        if (StringsKt.isBlank(r11) == false) goto L15;
    L19:
        int r2 = 12;
        bx7.c.c(this, r27, -3, null, 12);     // Catch: JSONException -> L26
        return;
    L23:
        bx7.c.c(this, r27, -3, null, r2);
        goto L24
    L6:
        if (StringsKt.isBlank(r1) == true) goto L9;
        r9 = false;
    L22:
        r2 = 12;
        goto L23
    }
}
