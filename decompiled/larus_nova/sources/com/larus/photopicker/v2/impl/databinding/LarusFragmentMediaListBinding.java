package com.larus.photopicker.v2.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes31.dex */
public final class LarusFragmentMediaListBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f364383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f364384b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RecyclerView f364385c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f364383a;
    }

    public LarusFragmentMediaListBinding(FrameLayout r100, TextView r101, RecyclerView r102) {
        this.f364383a = r100;
        this.f364384b = r101;
        this.f364385c = r102;
    }
}
