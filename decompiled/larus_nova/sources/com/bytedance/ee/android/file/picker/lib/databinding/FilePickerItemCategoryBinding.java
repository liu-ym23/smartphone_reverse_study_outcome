package com.bytedance.ee.android.file.picker.lib.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes15.dex */
public final class FilePickerItemCategoryBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f205988a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f205989b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f205990c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f205988a;
    }

    public FilePickerItemCategoryBinding(ConstraintLayout r100, ImageView r101, TextView r102) {
        this.f205988a = r100;
        this.f205989b = r101;
        this.f205990c = r102;
    }
}
