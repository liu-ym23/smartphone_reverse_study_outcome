package com.larus.drive.sdk.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.widget.CircleProgressBar;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDialogDriveDownloadBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CardView f341717a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f341718b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CircleProgressBar f341719c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f341717a;
    }

    public LarusDialogDriveDownloadBinding(CardView r100, ImageView r101, CircleProgressBar r102) {
        this.f341717a = r100;
        this.f341718b = r101;
        this.f341719c = r102;
    }
}
