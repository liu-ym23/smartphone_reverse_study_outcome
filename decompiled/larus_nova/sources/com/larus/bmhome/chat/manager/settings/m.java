package com.larus.bmhome.chat.manager.settings;

import com.larus.common_ui.dialog.p0;

/* JADX INFO: loaded from: classes25.dex */
public final class m implements p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SettingOptionViewModel f306824a;

    @Override // com.larus.common_ui.dialog.p0
    public final void confirm() {
        this.f306824a.togglePersonalizedRecommendEnable(false);
    }

    public m(SettingOptionViewModel r100) {
        this.f306824a = r100;
    }
}
