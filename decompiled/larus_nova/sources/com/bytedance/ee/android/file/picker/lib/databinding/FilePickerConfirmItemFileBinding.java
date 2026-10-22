package com.bytedance.ee.android.file.picker.lib.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.ee.android.file.picker.lib.v2.ui.view.FileInfoView;

/* JADX INFO: loaded from: classes15.dex */
public final class FilePickerConfirmItemFileBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f205979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FileInfoView f205980b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f205981c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f205979a;
    }

    public FilePickerConfirmItemFileBinding(ConstraintLayout r100, FileInfoView r101, View r102) {
        this.f205979a = r100;
        this.f205980b = r101;
        this.f205981c = r102;
    }
}
