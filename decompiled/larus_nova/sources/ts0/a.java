package ts0;

import android.util.LongSparseArray;
import com.bytedance.android.livesdk.sharedpref.e;
import java.util.HashMap;

/* JADX INFO: loaded from: classes47.dex */
public interface a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e<us0.a> f547336a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e<HashMap<String, Boolean>> f547337b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e<Boolean> f547338c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final e<Boolean> f547339d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final e<Boolean> f547340e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final e<Integer> f547341f = null;

    static {
        f547336a = new e("live_anchor_group_purchase_tip_cache", new us0.a());
        new e("live_anchor_has_vip_cache", new LongSparseArray());
        f547337b = new e("live_anchor_has_vip_cache_v2", new HashMap());
        Boolean r100 = Boolean.FALSE;
        f547338c = new e("gift_exhibition_entry_is_clicked", r100);
        f547339d = new e("live_ec_flash_red_dot_click_ever", r100);
        f547340e = new e("live_clear_screen_optimize", r100);
        f547341f = new e("live_profile_dynamic_sweep_anim_count", 0);
    }
}
