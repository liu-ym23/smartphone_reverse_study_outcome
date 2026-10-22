package com.larus.mainbot.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusBlockItemPodcastBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f358481a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f358482b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f358483c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RelativeLayout f358484d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SimpleDraweeView f358485e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ImageView f358486f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ProgressBar f358487g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ConstraintLayout f358488h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TextView f358489i;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f358481a;
    }

    public LarusBlockItemPodcastBinding(FrameLayout r100, TextView r101, TextView r102, RelativeLayout r103, SimpleDraweeView r104, ImageView r105, ProgressBar r106, ConstraintLayout r107, TextView r108) {
        this.f358481a = r100;
        this.f358482b = r101;
        this.f358483c = r102;
        this.f358484d = r103;
        this.f358485e = r104;
        this.f358486f = r105;
        this.f358487g = r106;
        this.f358488h = r107;
        this.f358489i = r108;
    }
}
