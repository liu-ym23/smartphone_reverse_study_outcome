package j40;

import android.util.SparseArray;
import com.bytedance.android.live.core.cache.LruCache;
import java.util.HashMap;
import java.util.Map;
import kotlin.Pair;

/* JADX INFO: loaded from: classes45.dex */
public interface f4 {
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> A = null;
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> B = null;
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> C = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> f497198a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Integer> f497199b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> f497200c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> f497201d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> f497202e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Long> f497203f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> f497204g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> f497205h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> f497206i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> f497207j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> f497208k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> f497209l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> f497210m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Map<String, String>> f497211n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<SparseArray<Pair<Long, Integer>>> f497212o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Map<String, Pair<Long, Integer>>> f497213p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> f497214q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> f497215r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<com.bytedance.android.livesdk.model.d0> f497216s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Long> f497217t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<LruCache<String, Integer>> f497218u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Long> f497219v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Long> f497220w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<com.bytedance.android.livesdk.model.z0> f497221x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> f497222y = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> f497223z = null;

    static {
        Boolean r100 = Boolean.TRUE;
        f497198a = new com.bytedance.android.livesdk.sharedpref.e("live_pk_adjust_gift", r100);
        f497199b = new com.bytedance.android.livesdk.sharedpref.e("slide_click_position", 0);
        Boolean r101 = Boolean.FALSE;
        f497200c = new com.bytedance.android.livesdk.sharedpref.e("live_hamlet_avatar_guide_shown", r101);
        f497201d = new com.bytedance.android.livesdk.sharedpref.e("live_permanent_chat_room_entrance_clicked", r101);
        f497202e = new com.bytedance.android.livesdk.sharedpref.e("live_permanent_guest_entrance_clicked", r101);
        f497203f = new com.bytedance.android.livesdk.sharedpref.e("live_pad_rotate_toast_time", -1L);
        f497204g = new com.bytedance.android.livesdk.sharedpref.e("live_gen_play_show", r101);
        f497205h = new com.bytedance.android.livesdk.sharedpref.e("live_publish_show", r101);
        new com.bytedance.android.livesdk.sharedpref.e("live_gen_play_backup_show", r101);
        new com.bytedance.android.livesdk.sharedpref.e("live_playback_or_highlight", r101);
        new com.bytedance.android.livesdk.sharedpref.e("live_real_time_playback_show", r101);
        f497206i = new com.bytedance.android.livesdk.sharedpref.e("live_gen_play_open", r101);
        new com.bytedance.android.livesdk.sharedpref.e("live_gen_play_open_use_default", r100);
        f497207j = new com.bytedance.android.livesdk.sharedpref.e("live_real_time_playback_is_open", r101);
        f497208k = new com.bytedance.android.livesdk.sharedpref.e("live_play_auto_publish", r101);
        new com.bytedance.android.livesdk.sharedpref.e("live_play_auto_publish_use_default", r100);
        f497209l = new com.bytedance.android.livesdk.sharedpref.e("live_replay_product_exposit_switch", r101);
        f497210m = new com.bytedance.android.livesdk.sharedpref.e("live_replay_product_exposit_switch_enable", r100);
        f497211n = new com.bytedance.android.livesdk.sharedpref.e("live_common_short_touch_animation_record", new HashMap());
        f497212o = new com.bytedance.android.livesdk.sharedpref.e("live_short_touch_animation_show_times", new SparseArray());
        f497213p = new com.bytedance.android.livesdk.sharedpref.e("live_short_touch_bubble_show_times", new HashMap());
        new com.bytedance.android.livesdk.sharedpref.e("cash_exchange_gift_send_shown_number", 0);
        f497214q = new com.bytedance.android.livesdk.sharedpref.e("cash_exchange_gift_send_checked", r101);
        f497215r = new com.bytedance.android.livesdk.sharedpref.e("cash_exchange_toolbar_popup_shown", r101);
        new com.bytedance.android.livesdk.sharedpref.e("income_balance_visible_authority", r101);
        f497216s = new com.bytedance.android.livesdk.sharedpref.e("live_vs_paid_camera_ui_show_config", new com.bytedance.android.livesdk.model.d0(new HashMap(), new HashMap()));
        f497217t = new com.bytedance.android.livesdk.sharedpref.e("match_last_tab_id", 0L);
        f497218u = new com.bytedance.android.livesdk.sharedpref.e("business_configure_show_time", new LruCache(100));
        new com.bytedance.android.livesdk.sharedpref.e("live_fetch_skin_recent_time", 0L);
        f497219v = new com.bytedance.android.livesdk.sharedpref.e("live_log_rankinfo_recent_time", 0L);
        f497220w = new com.bytedance.android.livesdk.sharedpref.e("live_log_rankcount_recent_time", 0L);
        new com.bytedance.android.livesdk.sharedpref.e("live_trial_dialog_show", 0L);
        f497221x = new com.bytedance.android.livesdk.sharedpref.e("live_dynamic_strategy_frequency_info", new com.bytedance.android.livesdk.model.z0());
        f497222y = new com.bytedance.android.livesdk.sharedpref.e("replay_show_enlarge_gesture_guide", r100);
        f497223z = new com.bytedance.android.livesdk.sharedpref.e("replay_show_fast_forward_gesture_guide", r100);
        A = new com.bytedance.android.livesdk.sharedpref.e("calendar_permission_denied", r101);
        B = new com.bytedance.android.livesdk.sharedpref.e("timon_calendar_write_permission_denied", r101);
        C = new com.bytedance.android.livesdk.sharedpref.e("guest_link_open", r101);
        new com.bytedance.android.livesdk.sharedpref.e("live_setting_entr_guide_show_time", 0);
    }
}
