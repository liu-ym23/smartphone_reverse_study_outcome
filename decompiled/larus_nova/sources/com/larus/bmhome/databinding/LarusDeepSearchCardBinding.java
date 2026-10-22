package com.larus.bmhome.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusDeepSearchCardBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f310828a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f310829b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f310830c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SimpleDraweeView f310831d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f310832e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f310828a;
    }

    public LarusDeepSearchCardBinding(ConstraintLayout r100, TextView r101, AppCompatImageView r102, SimpleDraweeView r103, TextView r104) {
        this.f310828a = r100;
        this.f310829b = r101;
        this.f310830c = r102;
        this.f310831d = r103;
        this.f310832e = r104;
    }
}
