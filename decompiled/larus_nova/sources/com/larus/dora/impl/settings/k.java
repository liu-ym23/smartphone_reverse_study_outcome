package com.larus.dora.impl.settings;

import com.bytedance.news.common.settings.SettingsManager;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes27.dex */
public final /* synthetic */ class k implements Function0 {
    public /* synthetic */ k() {
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return ((IDoraSettings) SettingsManager.obtain(IDoraSettings.class)).doraGAmbientVolumeConfig();
    }
}
