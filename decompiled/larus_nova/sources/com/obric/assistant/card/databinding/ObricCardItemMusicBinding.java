package com.obric.assistant.card.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.obric.assistant.card.layout.viewholder.MusicCircularProgressView;

/* JADX INFO: loaded from: classes32.dex */
public final class ObricCardItemMusicBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f386120a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SimpleDraweeView f386121b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f386122c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppCompatImageView f386123d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AppCompatImageView f386124e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final FrameLayout f386125f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MusicCircularProgressView f386126g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f386127h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TextView f386128i;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f386120a;
    }

    public ObricCardItemMusicBinding(ConstraintLayout r100, SimpleDraweeView r101, FrameLayout r102, AppCompatImageView r103, AppCompatImageView r104, FrameLayout r105, MusicCircularProgressView r106, TextView r107, TextView r108) {
        this.f386120a = r100;
        this.f386121b = r101;
        this.f386122c = r102;
        this.f386123d = r103;
        this.f386124e = r104;
        this.f386125f = r105;
        this.f386126g = r106;
        this.f386127h = r107;
        this.f386128i = r108;
    }
}
