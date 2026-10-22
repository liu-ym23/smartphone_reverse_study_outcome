package com.larus.av_call.databinding;

import android.view.View;
import android.view.ViewStub;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes24.dex */
public final class LarusFragmentInstantCallBaseBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f290510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewStub f290511b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ViewStub f290512c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ViewStub f290513d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f290510a;
    }

    public LarusFragmentInstantCallBaseBinding(ConstraintLayout r100, ViewStub r101, ViewStub r102, ViewStub r103) {
        this.f290510a = r100;
        this.f290511b = r101;
        this.f290512c = r102;
        this.f290513d = r103;
    }
}
