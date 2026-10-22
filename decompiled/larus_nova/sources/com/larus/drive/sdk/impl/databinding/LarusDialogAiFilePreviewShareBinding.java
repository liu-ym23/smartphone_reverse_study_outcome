package com.larus.drive.sdk.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.widget.roundlayout.RoundLinearLayout;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDialogAiFilePreviewShareBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoundLinearLayout f341693a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f341694b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f341695c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ProgressBar f341696d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AppCompatTextView f341697e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f341693a;
    }

    public LarusDialogAiFilePreviewShareBinding(RoundLinearLayout r100, AppCompatImageView r101, FrameLayout r102, ProgressBar r103, AppCompatTextView r104) {
        this.f341693a = r100;
        this.f341694b = r101;
        this.f341695c = r102;
        this.f341696d = r103;
        this.f341697e = r104;
    }
}
