package hu;

import com.bytedance.android.gamecp.common.setting.SettingKey;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SettingKey<Boolean> f487193a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<String> f487194b = null;

    static {
        Boolean r100 = Boolean.FALSE;
        f487193a = new SettingKey("live_sdk_enable_slardar_sampled_report_key", "Slardar上报采样前置过滤", r100, r100, true);
        f487194b = CollectionsKt.mutableListOf(new String[]{"ttlive_network_apm", "tlive_setting_monitor", "widget_unload_data_center_null", "ttlive_audience_enter_room_full_new_all"});
    }
}
