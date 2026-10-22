package com.bytedance.awemeopen.apps.framework.landscape;

import android.graphics.SurfaceTexture;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.awemeopen.infra.base.player.AoVideoView;
import com.bytedance.awemeopen.infra.base.settings.AoSettings;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static WeakReference<com.bytedance.awemeopen.infra.base.player.g> f197135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static WeakReference<SurfaceTexture> f197136b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f197137c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Boolean f197138d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final boolean f197139e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final boolean f197140f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final boolean f197141g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final boolean f197142h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static WeakReference<AoVideoView> f197143i;

    static {
        f197135a = new WeakReference(null);
        f197136b = new WeakReference(null);
        f197137c = "";
        JSONObject r100 = AoSettings.a("ao_video_landscape_config");
        boolean r101 = true;
        if (r100 == null) goto L5;
        boolean r102 = r100.optBoolean("enable_reuse", true);
    L6:
        f197139e = r102;
        JSONObject r103 = AoSettings.a("ao_video_landscape_config");
        if (r103 == null) goto L9;
        boolean r104 = r103.optBoolean("enable_surface_reuse", true);
    L10:
        f197140f = r104;
        JSONObject r105 = AoSettings.a("ao_video_landscape_config");
        if (r105 == null) goto L13;
        boolean r106 = r105.optBoolean("enable_reset_surface_source", true);
    L14:
        f197141g = r106;
        JSONObject r107 = AoSettings.a("ao_video_landscape_config");
        if (r107 == null) goto L17;
        r101 = r107.optBoolean("enable_fix_pause_to_landscape", true);
    L17:
        f197142h = r101;
        f197143i = new WeakReference(null);
        return;
    L13:
        r106 = true;
        goto L14
    L9:
        r104 = true;
        goto L10
    L5:
        r102 = true;
        goto L6
    }

    public static com.bytedance.awemeopen.infra.base.player.g a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "aid");
        StringBuilder r101 = new StringBuilder("enable, ");
        boolean r102 = f197139e;
        r101.append(r102);
        r101.append(", aid: ");
        r101.append(r100);
        r101.append(Typography.amp);
        r101.append(f197137c);
        r101.append(", peek is ");
        r101.append(f197135a.get());
        AoLogger.b("land_player_holder", new Object[]{r101.toString()});
        if (r102 == true) goto L5;
        return null;
    L5:
        if (Intrinsics.areEqual(f197137c, r100) == true) goto L8;
        return null;
    L8:
        return f197135a.get();
    }

    public static void b(Boolean r100) {
        if (f197142h == false) goto L6;
        f197138d = r100;
        return;
    }
}
