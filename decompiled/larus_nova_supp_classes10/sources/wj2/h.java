package wj2;

import com.bytedance.android.ec.local.api.ab.ECLiveSettingPanel;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h {
    public static final /* synthetic */ int a = 0;

    @ECLiveSettingPanel(desc = "商品列表直播流自适应功能开关", key = "ec_live_list_panel_event_switch")
    public static boolean a() {
        return ((Boolean) EComABUtils.getLiveSettingValue("ec_live_list_panel_event_switch", Boolean.TRUE)).booleanValue();
    }

    static {
    }
}
