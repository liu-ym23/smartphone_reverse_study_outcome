package com.larus.dora.obric.device_management.setting.earbuds.doubao_agent;

import android.widget.CompoundButton;

/* JADX INFO: loaded from: classes27.dex */
public final /* synthetic */ class n implements CompoundButton.OnCheckedChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DoraObricEarbudsDoubaoAgentSettingsFragment f340027a;

    public /* synthetic */ n(DoraObricEarbudsDoubaoAgentSettingsFragment r100) {
        this.f340027a = r100;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r100, boolean r101) {
        DoraObricEarbudsDoubaoAgentSettingsFragment r102 = this.f340027a;
        int r103 = DoraObricEarbudsDoubaoAgentSettingsFragment.B;
        r102.fa0().updateConvStartEndSoundEnable(r101);
    }
}
