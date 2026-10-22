package com.larus.bmhome.chat.trace;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import com.obric.trace.ObricActionBarTrackType;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f310216a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f310217b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f310218c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long f310219d;

    static {
    }

    public static void a(boolean r100, long r101) {
        long r102 = System.currentTimeMillis() - f310219d;
        if (r100 == false) goto L5;
        String r103 = "pic";
    L6:
        float r104 = r101 / 1024.0f;
        String r110 = f310216a;
        String r105 = f310217b;
        String r106 = f310218c;
        JSONObject r107 = new JSONObject();
        Intrinsics.checkNotNullParameter(r107, "params");
        if (r110 == null) goto L12;
        r107.put("click_from", r110);     // Catch: JSONException -> L9
    L9:
        e = move-exception;
        FLogger.f375446a.e("UploadEventHelper", "error in UploadEventHelper clickCamera " + e.getLocalizedMessage());
    L24:
        TrackParams r108 = new TrackParams().merge(r107);
        by7.a r109 = new by7.a("upload_duration");
        r109.f21463a.merge(r108);
        r109.b();
        f310216a = null;
        f310217b = null;
        f310218c = null;
        f310219d = 0;
        return;
    L12:
        if (r102 <= 0) goto L15;
        r107.put("duration", r102);     // Catch: JSONException -> L9
    L15:
        if (r104 <= 0.0f) goto L17;
        r107.put("size", Float.valueOf(r104));     // Catch: JSONException -> L9
    L17:
        r107.put("type", r103);     // Catch: JSONException -> L9
        if (r105 == null) goto L20;
        r107.put(ObricActionBarTrackType.KEY_ACTION_BAR_TEMPLATE_ID, r105);     // Catch: JSONException -> L9
    L20:
        if (r106 == null) goto L24;
        r107.put("action_bar_template_type", r106);     // Catch: JSONException -> L9
        goto L24
    L5:
        r103 = "file";
        goto L6
    }
}
