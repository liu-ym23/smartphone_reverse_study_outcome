package com.larus.slides.biz.impl.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.ItemTextToggle;

/* JADX INFO: loaded from: classes31.dex */
public final class LarusPageSlidesPermissionSettingsBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f369337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ItemTextToggle f369338b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final NovaTitleBarEx f369339c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f369337a;
    }

    public LarusPageSlidesPermissionSettingsBinding(ConstraintLayout r100, ItemTextToggle r101, NovaTitleBarEx r102) {
        this.f369337a = r100;
        this.f369338b = r101;
        this.f369339c = r102;
    }
}
