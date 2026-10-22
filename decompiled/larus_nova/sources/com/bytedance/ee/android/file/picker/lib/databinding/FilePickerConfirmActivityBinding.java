package com.bytedance.ee.android.file.picker.lib.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.ss.android.lark.ui.CommonTitleBar;

/* JADX INFO: loaded from: classes15.dex */
public final class FilePickerConfirmActivityBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f205976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecyclerView f205977b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CommonTitleBar f205978c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f205976a;
    }

    public FilePickerConfirmActivityBinding(ConstraintLayout r100, RecyclerView r101, CommonTitleBar r102) {
        this.f205976a = r100;
        this.f205977b = r101;
        this.f205978c = r102;
    }
}
