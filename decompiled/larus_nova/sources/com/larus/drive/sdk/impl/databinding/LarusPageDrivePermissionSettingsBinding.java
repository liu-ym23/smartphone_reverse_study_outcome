package com.larus.drive.sdk.impl.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.ItemTextToggle;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusPageDrivePermissionSettingsBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f341753a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ItemTextToggle f341754b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final NovaTitleBarEx f341755c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f341753a;
    }

    public LarusPageDrivePermissionSettingsBinding(ConstraintLayout r100, ItemTextToggle r101, NovaTitleBarEx r102) {
        this.f341753a = r100;
        this.f341754b = r101;
        this.f341755c = r102;
    }
}
