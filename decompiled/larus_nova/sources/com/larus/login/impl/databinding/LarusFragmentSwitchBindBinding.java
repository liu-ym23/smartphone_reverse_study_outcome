package com.larus.login.impl.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.login.impl.switchbind.view.AccountCardView;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusFragmentSwitchBindBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f357557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AccountCardView f357558b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AccountCardView f357559c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f357557a;
    }

    public LarusFragmentSwitchBindBinding(ConstraintLayout r100, AccountCardView r101, AccountCardView r102) {
        this.f357557a = r100;
        this.f357558b = r101;
        this.f357559c = r102;
    }
}
