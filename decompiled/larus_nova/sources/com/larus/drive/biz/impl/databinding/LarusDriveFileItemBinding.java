package com.larus.drive.biz.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDriveFileItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f341107a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f341108b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SimpleDraweeView f341109c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f341110d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f341111e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f341112f;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f341107a;
    }

    public LarusDriveFileItemBinding(FrameLayout r100, ImageView r101, SimpleDraweeView r102, View r103, TextView r104, TextView r105) {
        this.f341107a = r100;
        this.f341108b = r101;
        this.f341109c = r102;
        this.f341110d = r103;
        this.f341111e = r104;
        this.f341112f = r105;
    }
}
