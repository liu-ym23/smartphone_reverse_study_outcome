package j40;

import com.bytedance.android.live.core.setting.SettingKey;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes45.dex */
public final class a3 extends SettingKey<Map<String, ? extends Map<String, ? extends String>>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a3 f497167a = null;

    static {
        f497167a = new a3();
    }

    public a3() {
        super("live_strategy_filter_config", "策略埋点过滤配置", new HashMap(), new HashMap());
    }
}
