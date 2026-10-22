package j40;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdkapi.model.VSOptimizeConfig;

/* JADX INFO: loaded from: classes45.dex */
public final class z3 extends SettingKey<VSOptimizeConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z3 f497333a = null;

    static {
        f497333a = new z3();
    }

    public z3() {
        super("live_vs_optimize_config", "节目直播体验优化", new VSOptimizeConfig(), new VSOptimizeConfig());
    }
}
