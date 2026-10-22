package com.larus.avlink.impl.databinding;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes25.dex */
public final class LarusItemThumbnailBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f293246a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CheckBox f293247b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SimpleDraweeView f293248c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f293249d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f293246a;
    }

    public LarusItemThumbnailBinding(ConstraintLayout r100, CheckBox r101, SimpleDraweeView r102, TextView r103) {
        this.f293246a = r100;
        this.f293247b = r101;
        this.f293248c = r102;
        this.f293249d = r103;
    }
}
