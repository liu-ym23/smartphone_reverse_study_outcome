package com.larus.dora.impl.settings;

import com.bytedance.news.common.settings.SettingsManager;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes27.dex */
public final /* synthetic */ class q0 implements Function0 {
    public /* synthetic */ q0() {
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return ((IDoraSettings) SettingsManager.obtain(IDoraSettings.class)).doraOnboardingOpeningRemarks();
    }
}
