package w4c;

import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.security.compliance.infra.settings.LscSettingConfig;

/* JADX INFO: loaded from: classes38.dex */
public final class c {
    public static final LscSettingConfig a() {
        LscSettingConfig r100 = (LscSettingConfig) SettingManager.getInstance().get(LscSettingConfig.class);
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new LscSettingConfig();
    }
}
