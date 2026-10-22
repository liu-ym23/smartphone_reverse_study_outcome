package com.bytedance.awemeopen.apps.framework.landscape;

import android.graphics.SurfaceTexture;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.awemeopen.infra.base.player.AoVideoView;
import com.bytedance.awemeopen.infra.base.settings.AoSettings;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g {
    public static WeakReference<com.bytedance.awemeopen.infra.base.player.g> a;
    public static WeakReference<SurfaceTexture> b;
    public static String c;
    public static Boolean d;
    public static final boolean e = false;
    public static final boolean f = false;
    public static final boolean g = false;
    public static final boolean h = false;
    public static WeakReference<AoVideoView> i;

    static {
        a = new WeakReference(null);
        b = new WeakReference(null);
        c = "";
        JSONObject r2 = AoSettings.a("ao_video_landscape_config");
        boolean r3 = true;
        if (r2 == null) goto L5;
        boolean r4 = r2.optBoolean("enable_reuse", true);
    L6:
        e = r4;
        JSONObject r5 = AoSettings.a("ao_video_landscape_config");
        if (r5 == null) goto L9;
        boolean r6 = r5.optBoolean("enable_surface_reuse", true);
    L10:
        f = r6;
        JSONObject r7 = AoSettings.a("ao_video_landscape_config");
        if (r7 == null) goto L13;
        boolean r8 = r7.optBoolean("enable_reset_surface_source", true);
    L14:
        g = r8;
        JSONObject r0 = AoSettings.a("ao_video_landscape_config");
        if (r0 == null) goto L17;
        r3 = r0.optBoolean("enable_fix_pause_to_landscape", true);
    L17:
        h = r3;
        i = new WeakReference(null);
        return;
    L13:
        r8 = true;
        goto L14
    L9:
        r6 = true;
        goto L10
    L5:
        r4 = true;
        goto L6
    }

    public static com.bytedance.awemeopen.infra.base.player.g a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "aid");
        StringBuilder r1 = new StringBuilder("enable, ");
        boolean r2 = e;
        r1.append(r2);
        r1.append(", aid: ");
        r1.append(r4);
        r1.append('&');
        r1.append(c);
        r1.append(", peek is ");
        r1.append(a.get());
        AoLogger.b("land_player_holder", new Object[]{r1.toString()});
        if (r2 == true) goto L5;
        return null;
    L5:
        if (Intrinsics.areEqual(c, r4) == true) goto L8;
        return null;
    L8:
        return a.get();
    }

    public static void b(Boolean r1) {
        if (h == false) goto L6;
        d = r1;
        return;
    }
}
