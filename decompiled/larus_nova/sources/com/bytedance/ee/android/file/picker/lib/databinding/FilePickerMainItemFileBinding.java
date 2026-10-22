package com.bytedance.ee.android.file.picker.lib.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.ee.android.file.picker.lib.v2.ui.view.FileInfoView;
import com.larksuite.component.ui.button.LKUICheckBox;

/* JADX INFO: loaded from: classes15.dex */
public final class FilePickerMainItemFileBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f205998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LKUICheckBox f205999b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FileInfoView f206000c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f206001d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f205998a;
    }

    public FilePickerMainItemFileBinding(ConstraintLayout r100, LKUICheckBox r101, FileInfoView r102, View r103) {
        this.f205998a = r100;
        this.f205999b = r101;
        this.f206000c = r102;
        this.f206001d = r103;
    }
}
