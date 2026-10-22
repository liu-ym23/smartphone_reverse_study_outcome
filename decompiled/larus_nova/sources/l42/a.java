package l42;

import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSetting;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.VSBarrageSetting;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.w;
import com.bytedance.android.livesdk.sharedpref.e;
import java.util.HashMap;
import java.util.Map;
import p22.o;

/* JADX INFO: loaded from: classes9.dex */
public interface a {
    public static final e<Boolean> A = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e<Boolean> f507314a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e<HashMap<String, String>> f507315b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e<Boolean> f507316c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final e<BarrageSetting> f507317d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final e<VSBarrageSetting> f507318e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final e<Boolean> f507319f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final e<Boolean> f507320g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final e<Boolean> f507321h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final e<Map<String, String>> f507322i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final e<w> f507323j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final e<Integer> f507324k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final e<Integer> f507325l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final e<Integer> f507326m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final e<Integer> f507327n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final e<Boolean> f507328o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final e<Integer> f507329p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final e<Integer> f507330q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final e<b> f507331r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final e<Integer> f507332s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final e<Boolean> f507333t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final e<Boolean> f507334u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final e<Integer> f507335v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final e<m42.a> f507336w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final e<Integer> f507337x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final e<o> f507338y = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final e<o> f507339z = null;

    static {
        Boolean r100 = Boolean.FALSE;
        f507314a = new e("public_screen_load_tip_show", r100);
        f507315b = new e("live_watch_duration_month", new HashMap());
        f507316c = new e("live_interactivity_test_log_enable", r100);
        f507317d = new e("live_barrage_setting", new BarrageSetting(false));
        f507318e = new e("vs_barrage_setting", VSBarrageSetting.getDefaultStyleSetting());
        f507319f = new e("vs_support_realtime_msg_debug", r100);
        f507320g = new e("landscape_block_enable", r100);
        f507321h = new e("danmaku_debug_enable", r100);
        f507322i = new e("live_last_selected_danmaku_tab_memory", new HashMap());
        f507323j = new e("live_input_recommend_shortcut_emoji", new w());
        f507324k = new e("live_keyboard_height_portrait", 0);
        f507325l = new e("live_keyboard_height_landscape", 0);
        f507326m = new e("live_keyboard_height_portrait_v3", 0);
        f507327n = new e("live_keyboard_height_landscape_v3", 0);
        Boolean r101 = Boolean.TRUE;
        f507328o = new e("live_screen_tab_send_confirm", r101);
        f507329p = new e("live_input_panel_last_audio", 0);
        f507330q = new e("live_input_panel_fusion_emoji_tips_show_times", 0);
        f507331r = new e("live_landscape_damaku_setting_reddot", new b());
        f507332s = new e("audience_enter_room_count", 0);
        f507333t = new e("live_video_preview_pin_switch", r101);
        f507334u = new e("live_expression_board_show_from_vip_page", r100);
        f507335v = new e("live_expression_last_select", 0);
        f507336w = new e("vs_live_landscape_damaku_setting_reddot", new m42.a());
        f507337x = new e("live_subscribe_emoji_tip_time", 0);
        o.f527446a.getClass();
        f507338y = new e("live_simple_danmaku_setting", new o(false, 3, 1.0f, 1.0f, 80.0f));
        f507339z = new e("live_simple_danmaku_setting", o.class);
        A = new e("live_user_operate_simple_damaku_setting", r100);
    }
}
