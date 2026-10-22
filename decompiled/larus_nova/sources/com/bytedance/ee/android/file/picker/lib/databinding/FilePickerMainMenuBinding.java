package com.bytedance.ee.android.file.picker.lib.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.bytedance.ee.android.file.picker.lib.v2.ui.view.PickerMenuView;

/* JADX INFO: loaded from: classes15.dex */
public final class FilePickerMainMenuBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f206002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f206003b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f206004c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f206005d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f206002a;
    }

    public FilePickerMainMenuBinding(PickerMenuView r100, TextView r101, TextView r102, View r103) {
        this.f206002a = r100;
        this.f206003b = r101;
        this.f206004c = r102;
        this.f206005d = r103;
    }
}
