package com.larus.dora.impl.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.ItemTextToggle;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDoraGEnvObserveWifiBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f332607a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ItemTextToggle f332608b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final NovaTitleBarEx f332609c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f332607a;
    }

    public LarusDoraGEnvObserveWifiBinding(ConstraintLayout r100, ItemTextToggle r101, NovaTitleBarEx r102) {
        this.f332607a = r100;
        this.f332608b = r101;
        this.f332609c = r102;
    }
}
