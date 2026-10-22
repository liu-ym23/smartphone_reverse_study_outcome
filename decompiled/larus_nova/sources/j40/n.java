package j40;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdkapi.model.CommunityFoldFixConfig;

/* JADX INFO: loaded from: classes45.dex */
public final class n extends SettingKey<CommunityFoldFixConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f497266a = null;

    static {
        f497266a = new n();
    }

    public n() {
        super("live_community_fold_fix_config", "折叠屏修复适配社区配置", new CommunityFoldFixConfig(), new CommunityFoldFixConfig());
    }
}
