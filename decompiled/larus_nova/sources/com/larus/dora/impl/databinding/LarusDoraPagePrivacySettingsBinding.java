package com.larus.dora.impl.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.ItemTextToggle;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDoraPagePrivacySettingsBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f333196a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ItemTextToggle f333197b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f333198c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final NovaTitleBarEx f333199d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f333196a;
    }

    public LarusDoraPagePrivacySettingsBinding(ConstraintLayout r100, ItemTextToggle r101, View r102, NovaTitleBarEx r103) {
        this.f333196a = r100;
        this.f333197b = r101;
        this.f333198c = r102;
        this.f333199d = r103;
    }
}
