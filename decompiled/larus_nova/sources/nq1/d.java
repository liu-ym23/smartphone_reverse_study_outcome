package nq1;

import com.bytedance.android.livesdk.chatroom.vs_base.base.setting.config.ReplayBarrageFilterKeywordSetting;
import com.bytedance.android.livesdk.chatroom.vs_base.base.setting.config.ReplayBarrageSetting;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VideoResolutionItem;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e<VideoResolutionItem> f520092a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e<VideoResolutionItem> f520093b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e<Boolean> f520094c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final e<Boolean> f520095d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final e<Boolean> f520096e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final e<Boolean> f520097f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final e<Boolean> f520098g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final e<Boolean> f520099h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final e<ReplayBarrageSetting> f520100i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final e<ReplayBarrageSetting> f520101j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final e<Boolean> f520102k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final e<Boolean> f520103l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final e<Boolean> f520104m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final e<Boolean> f520105n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final e<Boolean> f520106o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final e<Boolean> f520107p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final e<Boolean> f520108q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final e<Map<String, Number>> f520109r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final e<Boolean> f520110s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final e<Integer> f520111t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final e<Long> f520112u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final e<Integer> f520113v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final e<Integer> f520114w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final e<HashSet<Object>> f520115x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final e<HashMap<String, String>> f520116y = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final e<HashMap<String, String>> f520117z = null;

    static {
        f520092a = new e("live_replay_last_selected_resolution", new VideoResolutionItem(null, null, 3, null));
        f520093b = new e("live_replay_selected_resolution", new VideoResolutionItem(null, null, 3, null));
        Boolean r100 = Boolean.FALSE;
        f520094c = new e("replay_float_window_guide_show", r100);
        f520095d = new e("replay_float_window_used", r100);
        f520096e = new e("replay_float_window_open_notified", r100);
        f520097f = new e("replay_cache_cancel_task_has_confirmed", r100);
        f520098g = new e("replay_float_window_open", r100);
        f520099h = new e("replay_landscape_block_enable", r100);
        f520100i = new e("replay_barrage_setting", ReplayBarrageSetting.getDefaultStyleSetting());
        f520101j = new e("replay_barrage_portrait_setting", ReplayBarrageSetting.getDefaultPortraitStyleSetting());
        Boolean r101 = Boolean.TRUE;
        f520102k = new e("replay_over_write_barrage_setting", r101);
        new e("replay_play_barrage_filter_keyword", new ReplayBarrageFilterKeywordSetting());
        f520103l = new e("replay_danmaku_debug_enable", r100);
        new e("replay_danmu_setting_function_reddot_type", new LinkedHashMap());
        new e("replay_color_danmu_filter_reddot_clicked", r100);
        f520104m = new e("replay_first_open_hdr", r101);
        f520105n = new e("replay_player_view_lock_pop_can_show", r101);
        f520106o = new e("replay_toolbar_more_has_clicked_red_dot_portrait", r100);
        f520107p = new e("replay_toolbar_more_has_clicked_red_dot_landscape", r100);
        f520108q = new e("replay_support_realtime_msg_debug", r100);
        f520109r = new e("replay_privilege_clarity_frequency", new LinkedHashMap());
        f520110s = new e("vs_interactive_debug_enable", r100);
        f520111t = new e("vs_bubble_show_count", 0);
        f520112u = new e("vs_bubble_show_last_time", 0L);
        f520113v = new e("live_keyboard_height_portrait_v3", 0);
        f520114w = new e("live_keyboard_height_landscape_v3", 0);
        f520115x = new e("live_vs_board_dress_reddot_clicked", new HashSet());
        f520116y = new e("live_vs_board_last_select_skin", new HashMap());
        f520117z = new e("live_vs_board_last_select_badge", new HashMap());
    }
}
