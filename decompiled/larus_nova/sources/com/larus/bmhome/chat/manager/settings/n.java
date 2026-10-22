package com.larus.bmhome.chat.manager.settings;

import com.larus.bmhome.view.item.ItemTextToggle;

/* JADX INFO: loaded from: classes25.dex */
public final class n implements com.larus.common_ui.dialog.u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ItemTextToggle f306825a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SettingOptionViewModel f306826b;

    @Override // com.larus.common_ui.dialog.u
    public final void cancel() {
        this.f306825a.getToggleView().setChecked(this.f306826b.isPersonalizedRecommendEnable());
    }

    public n(ItemTextToggle r100, SettingOptionViewModel r101) {
        this.f306825a = r100;
        this.f306826b = r101;
    }
}
