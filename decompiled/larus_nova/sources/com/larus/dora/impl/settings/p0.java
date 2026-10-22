package com.larus.dora.impl.settings;

import com.bytedance.news.common.settings.SettingsManager;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class p0 implements Function0 {
    public /* synthetic */ p0() {
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return ((IDoraSettings) SettingsManager.obtain(IDoraSettings.class)).doraGuideConfig();
    }
}
