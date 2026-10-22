package com.ss.android.lark.abtest.feature.launch;

import com.ss.android.lark.abtest.api.ABTestExperimentPlugin;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
@ABTestExperimentPlugin
public final class a implements hua.a {
    public a() {
    }

    @Override // hua.a
    public final String getBizName() {
        return "Launch-base";
    }

    @Override // hua.a
    public final List<iua.a<?>> a() {
        return LaunchAbTestConfig.f408536a;
    }
}
