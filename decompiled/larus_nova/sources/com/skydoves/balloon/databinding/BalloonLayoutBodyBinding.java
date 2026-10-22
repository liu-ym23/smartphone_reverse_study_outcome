package com.skydoves.balloon.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import com.skydoves.balloon.radius.RadiusLayout;
import com.skydoves.balloon.vectortext.VectorTextView;

/* JADX INFO: loaded from: classes34.dex */
public final class BalloonLayoutBodyBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f406138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f406139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f406140c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RadiusLayout f406141d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FrameLayout f406142e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final VectorTextView f406143f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final FrameLayout f406144g;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f406138a;
    }

    public BalloonLayoutBodyBinding(FrameLayout r100, FrameLayout r101, ImageView r102, RadiusLayout r103, FrameLayout r104, VectorTextView r105, FrameLayout r106) {
        this.f406138a = r100;
        this.f406139b = r101;
        this.f406140c = r102;
        this.f406141d = r103;
        this.f406142e = r104;
        this.f406143f = r105;
        this.f406144g = r106;
    }
}
