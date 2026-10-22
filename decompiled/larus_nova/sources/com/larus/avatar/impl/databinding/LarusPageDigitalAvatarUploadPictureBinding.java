package com.larus.avatar.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.larus.avatar.impl.upload.widget.RotateImageView;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.common_ui.widget.roundlayout.RoundFrameLayout;

/* JADX INFO: loaded from: classes23.dex */
public final class LarusPageDigitalAvatarUploadPictureBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f290770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f290771b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RecyclerView f290772c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FrameLayout f290773d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AppCompatTextView f290774e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final RotateImageView f290775f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final NovaTitleBarEx f290776g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final RoundFrameLayout f290777h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AppCompatTextView f290778i;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f290770a;
    }

    public LarusPageDigitalAvatarUploadPictureBinding(ConstraintLayout r100, ImageView r101, RecyclerView r102, FrameLayout r103, AppCompatTextView r104, RotateImageView r105, NovaTitleBarEx r106, RoundFrameLayout r107, AppCompatTextView r108) {
        this.f290770a = r100;
        this.f290771b = r101;
        this.f290772c = r102;
        this.f290773d = r103;
        this.f290774e = r104;
        this.f290775f = r105;
        this.f290776g = r106;
        this.f290777h = r107;
        this.f290778i = r108;
    }
}
