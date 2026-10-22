package j40;

import com.bytedance.android.live.core.setting.SettingKey;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes45.dex */
public final class b3 extends SettingKey<Map<String, ? extends Map<String, ? extends String>>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b3 f497173a = null;

    static {
        f497173a = new b3();
    }

    public b3() {
        super("live_strategy_filter_config_v2", "策略埋点过滤配置V2", new HashMap(), new HashMap());
    }
}
