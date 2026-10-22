package com.larus.voicecall.impl.museum;

import com.ixigua.lib.track.TrackParams;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f378389a = 0;

    static {
    }

    public static void a(RealtimeCallParam r100, a r101) {
        Intrinsics.checkNotNullParameter(r101, "banner");
        if (f.a() == true) goto L5;
        return;
    L5:
        String r102 = r101.f378382j;
        if (r102 != null) goto L10;
        if (r100 == null) goto L9;
        r102 = r100.f288745e;
        goto L10
    L9:
        r102 = null;
    L10:
        String r103 = e.c(r101.f378377e);
        JSONObject r104 = new JSONObject();
        Intrinsics.checkNotNullParameter(r104, "params");
        if (r102 != null) goto L19;
    L13:
        r104.put("trigger_scene", r103);     // Catch: JSONException -> L15
        r104.put(com.bytedance.android.ec.core.event.a.KEY_CARD_TYPE, "museum_extension");     // Catch: JSONException -> L15
    L17:
        TrackParams r105 = new TrackParams().merge(r104);
        by7.a r106 = new by7.a("museum_card_show");
        r106.f21463a.merge(r105);
        r106.b();
        return;
    L15:
        e = move-exception;
        FLogger.f375446a.e("RealtimeEventHelper", "error in RealtimeEventHelper mobMuseumCardShow " + e.getLocalizedMessage());
        goto L17
    L19:
        r104.put("call_id", r102);     // Catch: JSONException -> L15
        goto L13
    }
}
