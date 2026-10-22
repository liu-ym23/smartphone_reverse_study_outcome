package com.larus.dora.impl.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemTextToggle;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDoraPageCameraSettingsBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f332874a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatTextView f332875b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ItemGroup f332876c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ItemTextToggle f332877d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f332878e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ItemTextToggle f332879f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final NovaTitleBarEx f332880g;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f332874a;
    }

    public LarusDoraPageCameraSettingsBinding(ConstraintLayout r100, AppCompatTextView r101, ItemGroup r102, ItemTextToggle r103, View r104, ItemTextToggle r105, NovaTitleBarEx r106) {
        this.f332874a = r100;
        this.f332875b = r101;
        this.f332876c = r102;
        this.f332877d = r103;
        this.f332878e = r104;
        this.f332879f = r105;
        this.f332880g = r106;
    }
}
