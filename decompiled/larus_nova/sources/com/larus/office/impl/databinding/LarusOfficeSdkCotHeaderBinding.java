package com.larus.office.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.layout.widget.ShimmerLinearLayout;
import com.larus.office.plugins.input.view.CotHeaderView;

/* JADX INFO: loaded from: classes29.dex */
public final class LarusOfficeSdkCotHeaderBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f362183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ShimmerLinearLayout f362184b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SimpleDraweeView f362185c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f362186d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FrameLayout f362187e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f362188f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextSwitcher f362189g;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f362183a;
    }

    public LarusOfficeSdkCotHeaderBinding(CotHeaderView r100, ShimmerLinearLayout r101, SimpleDraweeView r102, TextView r103, FrameLayout r104, TextView r105, TextSwitcher r106) {
        this.f362183a = r100;
        this.f362184b = r101;
        this.f362185c = r102;
        this.f362186d = r103;
        this.f362187e = r104;
        this.f362188f = r105;
        this.f362189g = r106;
    }
}
