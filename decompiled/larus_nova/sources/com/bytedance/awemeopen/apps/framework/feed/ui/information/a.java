package com.bytedance.awemeopen.apps.framework.feed.ui.information;

import com.bytedance.awemeopen.infra.base.settings.AoSettings;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final double f195989a = 0.0d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final double f195990b = 0.0d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f195991c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f195992d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final boolean f195993e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final boolean f195994f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final boolean f195995g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final boolean f195996h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final boolean f195997i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final boolean f195998j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final boolean f195999k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final boolean f196000l = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final boolean f196001m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final boolean f196002n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final boolean f196003o = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final boolean f196004p = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final boolean f196005q = false;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final boolean f196006r = false;

    static {
        JSONObject r100 = AoSettings.a("ao_sdk_custom_config");
        if (r100 == null) goto L5;
        double r101 = r100.optDouble("left_invoke_desc_threshold");
    L6:
        f195989a = r101;
        JSONObject r102 = AoSettings.a("ao_sdk_custom_config");
        if (r102 == null) goto L9;
        double r103 = r102.optDouble("desc_collapse_threshold");
    L10:
        f195990b = r103;
        JSONObject r104 = AoSettings.a("ao_sdk_custom_config");
        int r105 = 2;
        if (r104 == null) goto L13;
        int r106 = r104.optInt("desc_collapse_max_line");
    L14:
        f195991c = r106;
        JSONObject r107 = AoSettings.a("ao_sdk_custom_config");
        boolean r108 = true;
        if (r107 == null) goto L20;
        int r109 = r107.optInt("desc_collapse_line", 2);
        if (r109 < 1) goto L20;
        r105 = r109;
    L20:
        f195992d = r105;
        JSONObject r110 = AoSettings.a("ao_sdk_custom_config");
        boolean r111 = false;
        if (r110 == null) goto L23;
        boolean r112 = r110.optBoolean("disable_music");
    L24:
        f195993e = r112;
        JSONObject r113 = AoSettings.a("ao_sdk_custom_config");
        if (r113 == null) goto L27;
        boolean r114 = r113.optBoolean("disable_aweme_toast");
    L28:
        f195994f = r114;
        JSONObject r115 = AoSettings.a("ao_sdk_custom_config");
        if (r115 == null) goto L31;
        boolean r116 = r115.optBoolean("force_enable_music_info");
    L32:
        f195995g = r116;
        JSONObject r117 = AoSettings.a("ao_flow_config");
        if (r117 == null) goto L35;
        boolean r118 = r117.optBoolean("hide_music_marquee");
    L36:
        f195996h = r118;
        JSONObject r119 = AoSettings.a("ao_host_inject_config");
        if (r119 == null) goto L39;
        boolean r120 = r119.optBoolean("enable_feed_inject_view", true);
    L40:
        f195997i = r120;
        JSONObject r121 = AoSettings.a("ao_host_inject_config");
        if (r121 == null) goto L43;
        boolean r122 = r121.optBoolean("enable_photos_inject_over_line", true);
    L44:
        f195998j = r122;
        JSONObject r123 = AoSettings.a("ao_sdk_custom_config");
        if (r123 == null) goto L47;
        boolean r124 = r123.optBoolean("enable_video_pinch", false);
    L48:
        f195999k = r124;
        JSONObject r125 = AoSettings.a("ao_sdk_custom_config");
        if (r125 == null) goto L51;
        boolean r126 = r125.optBoolean("enable_pinch_clip", true);
    L52:
        f196000l = r126;
        JSONObject r127 = AoSettings.a("ao_sdk_custom_config");
        if (r127 == null) goto L55;
        boolean r128 = r127.optBoolean("enable_photo_pinch", false);
    L56:
        f196001m = r128;
        JSONObject r129 = AoSettings.a("aos_anchor_config");
        if (r129 == null) goto L59;
        boolean r130 = r129.optBoolean("enable_checkin_type", false);
    L60:
        f196002n = r130;
        JSONObject r131 = AoSettings.a("ao_sdk_custom_config");
        if (r131 == null) goto L63;
        boolean r132 = r131.optBoolean("enable_vvp_rsp_fix", true);
    L64:
        f196003o = r132;
        JSONObject r133 = AoSettings.a("ao_sdk_custom_config");
        if (r133 == null) goto L67;
        r111 = r133.optBoolean("enable_profile_dynamic_cover", false);
    L67:
        f196004p = r111;
        JSONObject r134 = AoSettings.a("ao_sdk_custom_config");
        if (r134 == null) goto L70;
        boolean r135 = r134.optBoolean("enable_local_life_second_line_opt", true);
    L71:
        f196005q = r135;
        JSONObject r136 = AoSettings.a("ao_sdk_custom_config");
        if (r136 == null) goto L74;
        r108 = r136.optBoolean("enable_short_video_progress_bar", true);
    L74:
        f196006r = r108;
        return;
    L70:
        r135 = true;
        goto L71
    L63:
        r132 = true;
        goto L64
    L59:
        r130 = false;
        goto L60
    L55:
        r128 = false;
        goto L56
    L51:
        r126 = true;
        goto L52
    L47:
        r124 = false;
        goto L48
    L43:
        r122 = true;
        goto L44
    L39:
        r120 = true;
        goto L40
    L35:
        r118 = false;
        goto L36
    L31:
        r116 = false;
        goto L32
    L27:
        r114 = false;
        goto L28
    L23:
        r112 = false;
        goto L24
    L13:
        r106 = 2;
        goto L14
    L9:
        r103 = 0.8d;
        goto L10
    L5:
        r101 = 0.35d;
        goto L6
    }
}
