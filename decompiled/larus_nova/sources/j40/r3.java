package j40;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdkapi.model.LiveUnifyBoxConfig;

/* JADX INFO: loaded from: classes45.dex */
public final class r3 extends SettingKey<LiveUnifyBoxConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r3 f497293a = null;

    static {
        f497293a = new r3();
    }

    public r3() {
        super("live_unify_box_setting", "集装箱配置", new LiveUnifyBoxConfig(), new LiveUnifyBoxConfig());
    }
}
