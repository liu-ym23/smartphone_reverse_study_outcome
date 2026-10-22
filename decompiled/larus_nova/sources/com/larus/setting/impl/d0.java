package com.larus.setting.impl;

import com.larus.setting.impl.databinding.LarusBottomSheetDataPermissonBinding;

/* JADX INFO: loaded from: classes31.dex */
public final class d0 implements com.larus.common_ui.dialog.p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LarusBottomSheetDataPermissonBinding f368124a;

    @Override // com.larus.common_ui.dialog.p0
    public final void confirm() {
        this.f368124a.f368139f.getToggleView().setChecked(true);
        bt9.a.a(false, true);
    }

    public d0(LarusBottomSheetDataPermissonBinding r100) {
        this.f368124a = r100;
    }
}
