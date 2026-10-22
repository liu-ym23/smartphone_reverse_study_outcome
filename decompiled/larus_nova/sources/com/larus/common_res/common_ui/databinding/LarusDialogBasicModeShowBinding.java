package com.larus.common_res.common_ui.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.widget.UrlSpanTextView;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDialogBasicModeShowBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f326654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RelativeLayout f326655b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final UrlSpanTextView f326656c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f326657d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AppCompatTextView f326658e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f326654a;
    }

    public LarusDialogBasicModeShowBinding(ConstraintLayout r100, RelativeLayout r101, UrlSpanTextView r102, AppCompatTextView r103, AppCompatTextView r104) {
        this.f326654a = r100;
        this.f326655b = r101;
        this.f326656c = r102;
        this.f326657d = r103;
        this.f326658e = r104;
    }
}
