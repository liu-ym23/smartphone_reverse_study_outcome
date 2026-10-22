package com.bytedance.ee.bear.bitable.databinding;

import android.view.View;
import android.view.ViewStub;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.larksuite.component.universe_design.emptystate.UDEmptyState;

/* JADX INFO: loaded from: classes15.dex */
public final class BitableUikitEmptyLayoutBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f211059a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final UDEmptyState f211060b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ViewStub f211061c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Guideline f211062d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f211059a;
    }

    public BitableUikitEmptyLayoutBinding(ConstraintLayout r100, UDEmptyState r101, ViewStub r102, Guideline r103) {
        this.f211059a = r100;
        this.f211060b = r101;
        this.f211061c = r102;
        this.f211062d = r103;
    }
}
