package com.larus.chat.common.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.view.FileExportTypeItemView;
import com.larus.common_ui.widget.roundlayout.RoundTextView;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusDialogFileExportTypeChooseBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f323947a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f323948b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FileExportTypeItemView f323949c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RoundTextView f323950d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FileExportTypeItemView f323951e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final FileExportTypeItemView f323952f;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f323947a;
    }

    public LarusDialogFileExportTypeChooseBinding(ConstraintLayout r100, AppCompatImageView r101, FileExportTypeItemView r102, RoundTextView r103, FileExportTypeItemView r104, FileExportTypeItemView r105) {
        this.f323947a = r100;
        this.f323948b = r101;
        this.f323949c = r102;
        this.f323950d = r103;
        this.f323951e = r104;
        this.f323952f = r105;
    }
}
