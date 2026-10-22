package com.bytedance.lark.policy.utils;

import com.ss.android.lark.appsetting.api.SettingManager;

/* JADX INFO: loaded from: classes20.dex */
public final class c {
    static {
    }

    public static boolean a() {
        return c().c();
    }

    public static boolean b() {
        return c().e();
    }

    public static PolicyEngineSettingConfig c() {
        PolicyEngineSettingConfig r100 = (PolicyEngineSettingConfig) SettingManager.getInstance().get(PolicyEngineSettingConfig.class);
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new PolicyEngineSettingConfig();
    }
}
