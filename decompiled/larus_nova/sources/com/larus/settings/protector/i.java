package com.larus.settings.protector;

import com.bytedance.news.common.settings.SettingsManager;
import com.bytedance.news.common.settings.SettingsUpdateListener;
import com.bytedance.news.common.settings.api.SettingsData;
import com.larus.utils.l0;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes4.dex */
public final class i implements SettingsUpdateListener {
    public i() {
    }

    @Override // com.bytedance.news.common.settings.SettingsUpdateListener
    public final void onSettingsUpdate(SettingsData r100) {
        Lazy r101 = j.f368556a;
        l0.b(new f("onSettingsUpdate"));
        SettingsManager.unregisterListener(this);
    }
}
