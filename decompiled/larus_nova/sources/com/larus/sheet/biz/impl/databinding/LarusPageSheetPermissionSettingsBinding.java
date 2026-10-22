package com.larus.sheet.biz.impl.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.ItemTextToggle;

/* JADX INFO: loaded from: classes31.dex */
public final class LarusPageSheetPermissionSettingsBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f368958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ItemTextToggle f368959b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final NovaTitleBarEx f368960c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f368958a;
    }

    public LarusPageSheetPermissionSettingsBinding(ConstraintLayout r100, ItemTextToggle r101, NovaTitleBarEx r102) {
        this.f368958a = r100;
        this.f368959b = r101;
        this.f368960c = r102;
    }
}
