package q41;

import com.bytedance.android.live.base.abtest.ClientABTestKey;

/* JADX INFO: loaded from: classes47.dex */
public interface a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ClientABTestKey<Boolean> f531619a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ClientABTestKey<Boolean> f531620b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ClientABTestKey<Boolean> f531621c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ClientABTestKey<Boolean> f531622d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ClientABTestKey<Boolean> f531623e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ClientABTestKey<Boolean> f531624f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ClientABTestKey<Boolean> f531625g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ClientABTestKey<Boolean> f531626h = null;

    static {
        Boolean r100 = Boolean.FALSE;
        f531619a = new ClientABTestKey("ttlive_rev_link_feed_multi_enable", Boolean.class, r100, 1);
        f531620b = new ClientABTestKey("ttlive_rev_link_enter_opt", Boolean.class, r100, 1);
        f531621c = new ClientABTestKey("ttlive_rev_link_multi_enter_opt", Boolean.class, r100, 1);
        f531622d = new ClientABTestKey("ttlive_rev_link_feed_half_screen_expose", Boolean.class, r100, 1);
        f531623e = new ClientABTestKey("ttlive_rev_link_feed_opt", Boolean.class, r100, 1);
        f531624f = new ClientABTestKey("live_pre_request_other_anchors_profile", Boolean.class, r100, 1);
        f531625g = new ClientABTestKey("live_default_select_recharge_preview_gift", Boolean.class, r100, 1);
        f531626h = new ClientABTestKey("live_big_gift_combo_click_opt", Boolean.class, r100, 1);
    }
}
