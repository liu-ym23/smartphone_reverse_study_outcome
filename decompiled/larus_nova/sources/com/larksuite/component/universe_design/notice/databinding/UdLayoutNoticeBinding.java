package com.larksuite.component.universe_design.notice.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes24.dex */
public final class UdLayoutNoticeBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f285209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f285210b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f285211c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f285212d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f285213e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f285214f;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f285209a;
    }

    public UdLayoutNoticeBinding(ConstraintLayout r100, ImageView r101, ImageView r102, TextView r103, TextView r104, TextView r105) {
        this.f285209a = r100;
        this.f285210b = r101;
        this.f285211c = r102;
        this.f285212d = r103;
        this.f285213e = r104;
        this.f285214f = r105;
    }
}
