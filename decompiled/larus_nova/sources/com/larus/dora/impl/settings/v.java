package com.larus.dora.impl.settings;

import com.bytedance.news.common.settings.SettingsManager;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes27.dex */
public final /* synthetic */ class v implements Function0 {
    public /* synthetic */ v() {
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        String r100 = ((IDoraSettings) SettingsManager.obtain(IDoraSettings.class)).doraHealthAgentWebUrl();
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }
}
