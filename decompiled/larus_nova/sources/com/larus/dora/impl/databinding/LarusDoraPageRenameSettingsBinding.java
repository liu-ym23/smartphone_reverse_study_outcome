package com.larus.dora.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.NovaTitleBarEx;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDoraPageRenameSettingsBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f333237a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f333238b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatEditText f333239c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f333240d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f333241e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final NovaTitleBarEx f333242f;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f333237a;
    }

    public LarusDoraPageRenameSettingsBinding(ConstraintLayout r100, ImageView r101, AppCompatEditText r102, AppCompatTextView r103, View r104, NovaTitleBarEx r105) {
        this.f333237a = r100;
        this.f333238b = r101;
        this.f333239c = r102;
        this.f333240d = r103;
        this.f333241e = r104;
        this.f333242f = r105;
    }
}
