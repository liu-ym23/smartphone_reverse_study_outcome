package com.larus.avatar.impl.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.widget.UrlSpanTextView;

/* JADX INFO: loaded from: classes23.dex */
public final class LarusDialogScanCameraAuthorizationBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f290742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f290743b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f290744c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final UrlSpanTextView f290745d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f290742a;
    }

    public LarusDialogScanCameraAuthorizationBinding(ConstraintLayout r100, TextView r101, View r102, UrlSpanTextView r103) {
        this.f290742a = r100;
        this.f290743b = r101;
        this.f290744c = r102;
        this.f290745d = r103;
    }
}
