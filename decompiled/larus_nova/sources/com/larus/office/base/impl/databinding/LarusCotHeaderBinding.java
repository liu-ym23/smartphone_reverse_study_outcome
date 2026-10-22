package com.larus.office.base.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.layout.widget.ShimmerLinearLayout;
import com.larus.office.base.view.CotHeaderView;

/* JADX INFO: loaded from: classes29.dex */
public final class LarusCotHeaderBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f360539a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ShimmerLinearLayout f360540b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SimpleDraweeView f360541c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f360542d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FrameLayout f360543e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f360544f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextSwitcher f360545g;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f360539a;
    }

    public LarusCotHeaderBinding(CotHeaderView r100, ShimmerLinearLayout r101, SimpleDraweeView r102, TextView r103, FrameLayout r104, TextView r105, TextSwitcher r106) {
        this.f360539a = r100;
        this.f360540b = r101;
        this.f360541c = r102;
        this.f360542d = r103;
        this.f360543e = r104;
        this.f360544f = r105;
        this.f360545g = r106;
    }
}
