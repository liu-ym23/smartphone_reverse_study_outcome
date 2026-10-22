package com.larus.doc.sdk.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDocScreenShotLayoutBinding implements ViewBinding {
    public final ConstraintLayout docScreenShotRootView;
    public final FrameLayout docScreenShotView;
    private final ConstraintLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LarusDocScreenShotLayoutBinding bind(View r100) {
        ConstraintLayout r101 = (ConstraintLayout) r100;
        FrameLayout r102 = (FrameLayout) ViewBindings.findChildViewById(r100, R.id.doc_screen_shot_view);
        if (r102 == null) goto L7;
        return new LarusDocScreenShotLayoutBinding(r101, r101, r102);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(R.id.doc_screen_shot_view)));
    }

    public static LarusDocScreenShotLayoutBinding inflate(LayoutInflater r100) {
        return inflate(r100, null, false);
    }

    private LarusDocScreenShotLayoutBinding(ConstraintLayout r100, ConstraintLayout r101, FrameLayout r102) {
        this.rootView = r100;
        this.docScreenShotRootView = r101;
        this.docScreenShotView = r102;
    }

    public static LarusDocScreenShotLayoutBinding inflate(LayoutInflater r100, ViewGroup r101, boolean r102) {
        View r103 = r100.inflate(R.layout.larus_doc_screen_shot_layout, r101, false);
        if (r102 == false) goto L6;
        r101.addView(r103);
    L6:
        return bind(r103);
    }
}
