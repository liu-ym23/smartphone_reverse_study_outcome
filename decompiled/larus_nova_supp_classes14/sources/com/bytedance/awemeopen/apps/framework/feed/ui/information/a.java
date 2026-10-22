package com.bytedance.awemeopen.apps.framework.feed.ui.information;

import com.bytedance.awemeopen.infra.base.settings.AoSettings;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static final double a = 0.0d;
    public static final double b = 0.0d;
    public static final int c = 0;
    public static final int d = 0;
    public static final boolean e = false;
    public static final boolean f = false;
    public static final boolean g = false;
    public static final boolean h = false;
    public static final boolean i = false;
    public static final boolean j = false;
    public static final boolean k = false;
    public static final boolean l = false;
    public static final boolean m = false;
    public static final boolean n = false;
    public static final boolean o = false;
    public static final boolean p = false;
    public static final boolean q = false;
    public static final boolean r = false;

    static {
        JSONObject r1 = AoSettings.a("ao_sdk_custom_config");
        if (r1 == null) goto L5;
        double r2 = r1.optDouble("left_invoke_desc_threshold");
    L6:
        a = r2;
        JSONObject r3 = AoSettings.a("ao_sdk_custom_config");
        if (r3 == null) goto L9;
        double r4 = r3.optDouble("desc_collapse_threshold");
    L10:
        b = r4;
        JSONObject r5 = AoSettings.a("ao_sdk_custom_config");
        int r6 = 2;
        if (r5 == null) goto L13;
        int r7 = r5.optInt("desc_collapse_max_line");
    L14:
        c = r7;
        JSONObject r8 = AoSettings.a("ao_sdk_custom_config");
        boolean r9 = true;
        if (r8 == null) goto L20;
        int r10 = r8.optInt("desc_collapse_line", 2);
        if (r10 < 1) goto L20;
        r6 = r10;
    L20:
        d = r6;
        JSONObject r11 = AoSettings.a("ao_sdk_custom_config");
        boolean r12 = false;
        if (r11 == null) goto L23;
        boolean r13 = r11.optBoolean("disable_music");
    L24:
        e = r13;
        JSONObject r14 = AoSettings.a("ao_sdk_custom_config");
        if (r14 == null) goto L27;
        boolean r15 = r14.optBoolean("disable_aweme_toast");
    L28:
        f = r15;
        JSONObject r16 = AoSettings.a("ao_sdk_custom_config");
        if (r16 == null) goto L31;
        boolean r17 = r16.optBoolean("force_enable_music_info");
    L32:
        g = r17;
        JSONObject r18 = AoSettings.a("ao_flow_config");
        if (r18 == null) goto L35;
        boolean r19 = r18.optBoolean("hide_music_marquee");
    L36:
        h = r19;
        JSONObject r20 = AoSettings.a("ao_host_inject_config");
        if (r20 == null) goto L39;
        boolean r21 = r20.optBoolean("enable_feed_inject_view", true);
    L40:
        i = r21;
        JSONObject r22 = AoSettings.a("ao_host_inject_config");
        if (r22 == null) goto L43;
        boolean r23 = r22.optBoolean("enable_photos_inject_over_line", true);
    L44:
        j = r23;
        JSONObject r24 = AoSettings.a("ao_sdk_custom_config");
        if (r24 == null) goto L47;
        boolean r25 = r24.optBoolean("enable_video_pinch", false);
    L48:
        k = r25;
        JSONObject r26 = AoSettings.a("ao_sdk_custom_config");
        if (r26 == null) goto L51;
        boolean r27 = r26.optBoolean("enable_pinch_clip", true);
    L52:
        l = r27;
        JSONObject r28 = AoSettings.a("ao_sdk_custom_config");
        if (r28 == null) goto L55;
        boolean r29 = r28.optBoolean("enable_photo_pinch", false);
    L56:
        m = r29;
        JSONObject r30 = AoSettings.a("aos_anchor_config");
        if (r30 == null) goto L59;
        boolean r31 = r30.optBoolean("enable_checkin_type", false);
    L60:
        n = r31;
        JSONObject r32 = AoSettings.a("ao_sdk_custom_config");
        if (r32 == null) goto L63;
        boolean r33 = r32.optBoolean("enable_vvp_rsp_fix", true);
    L64:
        o = r33;
        JSONObject r34 = AoSettings.a("ao_sdk_custom_config");
        if (r34 == null) goto L67;
        r12 = r34.optBoolean("enable_profile_dynamic_cover", false);
    L67:
        p = r12;
        JSONObject r35 = AoSettings.a("ao_sdk_custom_config");
        if (r35 == null) goto L70;
        boolean r36 = r35.optBoolean("enable_local_life_second_line_opt", true);
    L71:
        q = r36;
        JSONObject r0 = AoSettings.a("ao_sdk_custom_config");
        if (r0 == null) goto L74;
        r9 = r0.optBoolean("enable_short_video_progress_bar", true);
    L74:
        r = r9;
        return;
    L70:
        r36 = true;
        goto L71
    L63:
        r33 = true;
        goto L64
    L59:
        r31 = false;
        goto L60
    L55:
        r29 = false;
        goto L56
    L51:
        r27 = true;
        goto L52
    L47:
        r25 = false;
        goto L48
    L43:
        r23 = true;
        goto L44
    L39:
        r21 = true;
        goto L40
    L35:
        r19 = false;
        goto L36
    L31:
        r17 = false;
        goto L32
    L27:
        r15 = false;
        goto L28
    L23:
        r13 = false;
        goto L24
    L13:
        r7 = 2;
        goto L14
    L9:
        r4 = 0.8d;
        goto L10
    L5:
        r2 = 0.35d;
        goto L6
    }
}
