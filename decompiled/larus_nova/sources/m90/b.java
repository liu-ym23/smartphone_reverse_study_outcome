package m90;

import android.util.Pair;
import android.util.SparseArray;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.livesdk.sharedpref.e;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes45.dex */
public interface b {
    public static final c<Integer> A = null;
    public static final c<Boolean> B = null;
    public static final c<Boolean> C = null;
    public static final c<Boolean> D = null;
    public static final c<Boolean> E = null;
    public static final c<Pair<String, String>> F = null;
    public static final c<Map<String, String>> G = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c<Boolean> f512543a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c<Boolean> f512544b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c<Integer> f512545c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c<Map<String, Double>> f512546d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c<Boolean> f512547e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final c<Map<String, Boolean>> f512548f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final c<Long> f512549g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final c<Boolean> f512550h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final c<Integer> f512551i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final c<Boolean> f512552j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final c<Boolean> f512553k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final c<Boolean> f512554l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final c<Integer> f512555m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final c<Boolean> f512556n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final c<Boolean> f512557o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final c<Boolean> f512558p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final c<Integer> f512559q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final c<String> f512560r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final c<Map<String, Long>> f512561s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final c<String> f512562t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final c<String> f512563u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final e<Boolean> f512564v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final e<Boolean> f512565w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final e<Boolean> f512566x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final c<Long> f512567y = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final c<Boolean> f512568z = null;

    static {
        new HashMap();
        new EnumMap(LiveEffectContextFactoryDelegate$Type.class);
        new HashMap();
        new EnumMap(LiveEffectContextFactoryDelegate$Type.class);
        Boolean r100 = Boolean.TRUE;
        new EnumMap(LiveEffectContextFactoryDelegate$Type.class);
        f512543a = new c("live_enable_beauty", r100);
        f512544b = new c("live_enable_av_adjust", r100);
        new EnumMap(LiveEffectContextFactoryDelegate$Type.class);
        new HashMap();
        new EnumMap(LiveEffectContextFactoryDelegate$Type.class);
        f512545c = new c("live_beauty_template_id", -1);
        f512546d = new c("LIVE_BEAUTY_TEMPLATE_ID_MAP", new HashMap());
        Boolean r101 = Boolean.FALSE;
        f512547e = new c("live_beauty_template_has_show_confirm", r101);
        new EnumMap(LiveEffectContextFactoryDelegate$Type.class);
        new HashMap();
        new EnumMap(LiveEffectContextFactoryDelegate$Type.class);
        new HashMap();
        new EnumMap(LiveEffectContextFactoryDelegate$Type.class);
        new HashMap();
        new EnumMap(LiveEffectContextFactoryDelegate$Type.class);
        new HashMap();
        new EnumMap(LiveEffectContextFactoryDelegate$Type.class);
        new EnumMap(LiveEffectContextFactoryDelegate$Type.class);
        f512548f = new c("gesture_magic_guide_v2", new HashMap());
        new HashMap();
        new EnumMap(LiveEffectContextFactoryDelegate$Type.class);
        new EnumMap(LiveEffectContextFactoryDelegate$Type.class);
        new EnumMap(LiveEffectContextFactoryDelegate$Type.class);
        f512549g = new c("live_gesture_magic_current_sticker_id", 0L);
        f512550h = new c("live_enable_makeup", r100);
        new EnumMap(LiveEffectContextFactoryDelegate$Type.class);
        new c("current_sticker_page_position", 0);
        new c("current_sticker_page_position_for_gift_menu", 0);
        f512551i = new c("current_sticker_position", 0);
        new EnumMap(LiveEffectContextFactoryDelegate$Type.class);
        f512552j = new c("live_enable_body_beauty", r100);
        f512553k = new c("live_body_beauty_tab_dot_show", r100);
        f512554l = new c("live_beauty_sticker_tab_dot_show", r100);
        f512555m = new c("current_page_position", 0);
        new c("current_page_position_for_gift_menu", 0);
        new c("load_but_invisible_stickers", new SparseArray());
        new c("load_but_invisible_stickers_for_gift_menu", new SparseArray());
        new c("current_showing_stickers", new HashMap());
        new c("current_showing_stickers_for_gift_menu", new HashMap());
        f512556n = new c("is_current_tab_clicked", r101);
        f512557o = new c("is_current_tab_clicked_for_gift_menu", r101);
        f512558p = new c("is_current_search_using_recommend_keyword", r101);
        f512559q = new c("current_search_result_type", 0);
        f512560r = new c("current_search_id", "");
        f512561s = new c("force_insert_sticker_time_record", new HashMap());
        new c("live_set_recommend_sticker_time", 0L);
        new EnumMap(LiveEffectContextFactoryDelegate$Type.class);
        new EnumMap(LiveEffectContextFactoryDelegate$Type.class);
        f512562t = new c("live_beauty_preset_template", "");
        f512563u = new c("live_beauty_preset_template_select", "");
        f512564v = new e("live_preview_effect_has_show_guide", r101);
        f512565w = new e("live_effect_multi_anchor_share_enable", r101);
        f512566x = new e("live_effect_multi_anchor_share_enable_default_open", r100);
        new e("live_effect_multi_anchor_share_has_show_tips_new", r101);
        new e("live_effect_multi_anchor_share_has_show_guide", r101);
        new EnumMap(LiveEffectContextFactoryDelegate$Type.class);
        new EnumMap(LiveEffectContextFactoryDelegate$Type.class);
        new EnumMap(LiveEffectContextFactoryDelegate$Type.class);
        new EnumMap(LiveEffectContextFactoryDelegate$Type.class);
        new EnumMap(LiveEffectContextFactoryDelegate$Type.class);
        f512567y = new c("live_sound_effect_selected_id", 0L);
        f512568z = new c("live_sound_effect_show_audition_popup", r100);
        new EnumMap(LiveEffectContextFactoryDelegate$Type.class);
        A = new c("live_no_beauty_switch_guide_popup", 0);
        B = new c("live_open_commodity_no_filter_switch", r100);
        C = new c("live_is_commodity_no_filter_default_open", r100);
        D = new c("live_open_commodity_no_filter_mode", r101);
        new EnumMap(LiveEffectContextFactoryDelegate$Type.class);
        new c("live_campaign_sticker_show_record", new HashMap());
        new c("live_interact_sticker_info", "");
        new EnumMap(LiveEffectContextFactoryDelegate$Type.class);
        E = new c("live_aigc_sticker_instruction_has_show", r101);
        new c("live_interact_sticker_show_record", new HashMap());
        F = new c("LIVE_BEAUTY_MODE", new Pair("normal", "普通模式"));
        G = new c("LIVE_EFFECT_EXTRA_INFO", new HashMap());
    }
}
