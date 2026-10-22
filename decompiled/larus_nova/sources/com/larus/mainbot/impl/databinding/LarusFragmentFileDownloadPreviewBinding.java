package com.larus.mainbot.impl.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.common_ui.widget.roundlayout.RoundTextView;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusFragmentFileDownloadPreviewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f358626a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f358627b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RoundTextView f358628c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SimpleDraweeView f358629d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f358630e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f358626a;
    }

    public LarusFragmentFileDownloadPreviewBinding(ConstraintLayout r100, AppCompatImageView r101, RoundTextView r102, SimpleDraweeView r103, TextView r104) {
        this.f358626a = r100;
        this.f358627b = r101;
        this.f358628c = r102;
        this.f358629d = r103;
        this.f358630e = r104;
    }
}
