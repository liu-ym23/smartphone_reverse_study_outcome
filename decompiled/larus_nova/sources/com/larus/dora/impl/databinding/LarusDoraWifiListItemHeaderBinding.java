package com.larus.dora.impl.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.item.ItemGroupTitle;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDoraWifiListItemHeaderBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f333331a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ItemGroupTitle f333332b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f333331a;
    }

    public LarusDoraWifiListItemHeaderBinding(ConstraintLayout r100, ItemGroupTitle r101) {
        this.f333331a = r100;
        this.f333332b = r101;
    }
}
