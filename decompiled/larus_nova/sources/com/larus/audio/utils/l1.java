package com.larus.audio.utils;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes24.dex */
public final class l1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f290069a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f290070b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f290071c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long f290072d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f290073e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f290074f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f290075g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static String f290076h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static String f290077i;

    static {
        f290069a = -1;
        f290070b = -1;
        f290071c = -1;
        f290072d = -1;
    }

    public static void b() {
        if (f290069a != (-1)) goto L5;
        return;
    L5:
        long r100 = System.currentTimeMillis();
        long r101 = f290069a;
        long r102 = r100 - r101;
        long r103 = f290070b;
        if (r103 != (-1)) goto L8;
        return;
    L8:
        if (r103 < r101) goto L81;
        long r104 = r103 - r101;
        boolean r110 = f290073e;
        long r111 = 0;
        if (r110 == true) goto L13;
        long r112 = 0;
    L31:
        boolean r113 = f290074f;
        if (r113 == true) goto L40;
        long r114 = f290071c;
        if (r114 != (-1)) goto L36;
        return;
    L36:
        if (r114 < r103) goto L79;
        long r115 = r114 - r103;
    L41:
        if (r110 == false) goto L43;
        long r105 = f290072d;
    L46:
        long r106 = r100 - r105;
    L47:
        if (r113 == false) goto L49;
        r111 = 1;
    L49:
        String r107 = f290076h;
        String r108 = f290075g;
        String r109 = f290077i;
        Long r116 = Long.valueOf(r102);
        Long r117 = Long.valueOf(r111);
        Long r118 = Long.valueOf(r104);
        Long r119 = Long.valueOf(r115);
        Long r120 = Long.valueOf(r106);
        Long r121 = Long.valueOf(r112);
        JSONObject r122 = new JSONObject();
        Intrinsics.checkNotNullParameter(r122, "params");
        if (r107 != null) goto L74;
    L54:
        if (r116 == null) goto L56;
        r122.put("total", r116.longValue());     // Catch: JSONException -> L52
    L56:
        if (r117 == null) goto L58;
        r122.put("is_hit_cache", r117.longValue());     // Catch: JSONException -> L52
    L58:
        if (r118 == null) goto L60;
        r122.put("request_media", r118.longValue());     // Catch: JSONException -> L52
    L60:
        if (r119 == null) goto L62;
        r122.put("download", r119.longValue());     // Catch: JSONException -> L52
    L62:
        if (r120 == null) goto L64;
        r122.put("play_delay", r120.longValue());     // Catch: JSONException -> L52
    L64:
        if (r121 == null) goto L66;
        r122.put("pitch_speech_process", r121.longValue());     // Catch: JSONException -> L52
    L66:
        if (r108 == null) goto L68;
        r122.put("speaker_id", r108);     // Catch: JSONException -> L52
    L68:
        if (r109 == null) goto L72;
        r122.put("speaker_name", r109);     // Catch: JSONException -> L52
    L52:
        e = move-exception;
        FLogger.f375446a.e("VoiceEventHelper", "error in VoiceEventHelper mobVoiceAuditionDuration " + e.getLocalizedMessage());
    L72:
        TrackParams r123 = new TrackParams().merge(r122);
        by7.a r124 = new by7.a("voice_audition_duration");
        r124.f21463a.merge(r123);
        r124.b();
        return;
    L74:
        r122.put("voice_id", r107);     // Catch: JSONException -> L52
        goto L54
    L43:
        if (r113 == false) goto L45;
        r106 = r100 - r103;
        goto L47
    L45:
        r105 = f290071c;
        goto L46
    L79:
        return;
    L40:
        r115 = 0;
        goto L41
    L13:
        if (f290074f == false) goto L21;
        long r125 = f290072d;
        if (r125 != (-1)) goto L17;
        return;
    L17:
        if (r125 < r103) goto L76;
        r112 = r125 - r103;
        goto L31
    L76:
        return;
    L21:
        long r126 = f290072d;
        if (r126 == (-1)) goto L29;
        long r127 = f290071c;
        if (r127 != (-1)) goto L26;
        return;
    L26:
        if (r126 < r127) goto L78;
        r112 = r126 - r127;
        goto L31
    L78:
        return;
    L29:
        return;
    }

    public static void c() {
        f290069a = -1;
        f290070b = -1;
        f290071c = -1;
        f290072d = -1;
        f290073e = false;
        f290074f = false;
        f290077i = null;
        f290075g = null;
        f290076h = null;
    }

    public static void a(boolean r100) {
        if (r100 == false) goto L4;
        f290070b = System.currentTimeMillis();
        return;
    L4:
        c();
    }
}
