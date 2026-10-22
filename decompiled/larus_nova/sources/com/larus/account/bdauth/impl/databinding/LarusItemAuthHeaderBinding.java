package com.larus.account.bdauth.impl.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes24.dex */
public final class LarusItemAuthHeaderBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f286225a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f286226b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f286227c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f286225a;
    }

    public LarusItemAuthHeaderBinding(ConstraintLayout r100, TextView r101, TextView r102) {
        this.f286225a = r100;
        this.f286226b = r101;
        this.f286227c = r102;
    }
}
