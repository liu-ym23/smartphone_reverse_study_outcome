package com.larus.dora.impl.databinding;

import android.view.View;
import androidx.viewbinding.ViewBinding;
import com.obric.oui.image.OImage;
import com.obric.oui.lisitem.OUICardConstraintLayout;
import com.obric.oui.text.OTextView;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDoraItemObricDeviceHomeQuickActionBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OUICardConstraintLayout f332762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OImage f332763b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OTextView f332764c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f332762a;
    }

    public LarusDoraItemObricDeviceHomeQuickActionBinding(OUICardConstraintLayout r100, OImage r101, OTextView r102) {
        this.f332762a = r100;
        this.f332763b = r101;
        this.f332764c = r102;
    }
}
