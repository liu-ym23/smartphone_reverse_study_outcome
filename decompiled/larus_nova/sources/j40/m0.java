package j40;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdk.config.j31;
import com.bytedance.android.livesdkapi.util.FrescoHostConfigUtil;

/* JADX INFO: loaded from: classes45.dex */
public final class m0 extends SettingKey<j31> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m0 f497261a = null;

    static {
        f497261a = new m0();
    }

    public m0() {
        super(FrescoHostConfigUtil.LIVE_FRESCO_CONFIG_KEY, "fresco图片库缓存key优化", new j31(), new j31());
    }
}
