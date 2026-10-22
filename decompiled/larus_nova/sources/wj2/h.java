package wj2;

import com.bytedance.android.ec.local.api.ab.ECLiveSettingPanel;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;

/* JADX INFO: loaded from: classes10.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f559978a = 0;

    @ECLiveSettingPanel(desc = "商品列表直播流自适应功能开关", key = "ec_live_list_panel_event_switch")
    public static boolean a() {
        return ((Boolean) EComABUtils.getLiveSettingValue("ec_live_list_panel_event_switch", Boolean.TRUE)).booleanValue();
    }

    static {
    }
}
