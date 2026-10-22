package j40;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdkapi.model.CoinConfig;

/* JADX INFO: loaded from: classes45.dex */
public final class m extends SettingKey<CoinConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f497260a = null;

    static {
        f497260a = new m();
    }

    public m() {
        super("live_coin_config", "货币单位", new CoinConfig(), new CoinConfig());
    }
}
