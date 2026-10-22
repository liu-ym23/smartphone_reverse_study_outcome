package com.larus.doc.sdk.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusLayoutDrivePreviewLoadingBinding implements ViewBinding {
    public final ProgressBar drivePreviewLoadingProgress;
    public final ConstraintLayout drivePreviewLoadingRoot;
    private final ConstraintLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LarusLayoutDrivePreviewLoadingBinding bind(View r100) {
        ProgressBar r101 = (ProgressBar) ViewBindings.findChildViewById(r100, R.id.drive_preview_loading_progress);
        if (r101 == null) goto L7;
        ConstraintLayout r102 = (ConstraintLayout) r100;
        return new LarusLayoutDrivePreviewLoadingBinding(r102, r101, r102);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(R.id.drive_preview_loading_progress)));
    }

    public static LarusLayoutDrivePreviewLoadingBinding inflate(LayoutInflater r100) {
        return inflate(r100, null, false);
    }

    private LarusLayoutDrivePreviewLoadingBinding(ConstraintLayout r100, ProgressBar r101, ConstraintLayout r102) {
        this.rootView = r100;
        this.drivePreviewLoadingProgress = r101;
        this.drivePreviewLoadingRoot = r102;
    }

    public static LarusLayoutDrivePreviewLoadingBinding inflate(LayoutInflater r100, ViewGroup r101, boolean r102) {
        View r103 = r100.inflate(R.layout.larus_layout_drive_preview_loading, r101, false);
        if (r102 == false) goto L6;
        r101.addView(r103);
    L6:
        return bind(r103);
    }
}
