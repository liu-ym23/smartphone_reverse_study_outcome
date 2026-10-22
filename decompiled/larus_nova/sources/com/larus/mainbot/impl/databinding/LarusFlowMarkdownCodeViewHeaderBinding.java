package com.larus.mainbot.impl.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.layout.widget.ShimmerLinearLayout;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusFlowMarkdownCodeViewHeaderBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ShimmerLinearLayout f358597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ShimmerLinearLayout f358598b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f358599c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SimpleDraweeView f358600d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f358601e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f358597a;
    }

    public LarusFlowMarkdownCodeViewHeaderBinding(ShimmerLinearLayout r100, ShimmerLinearLayout r101, AppCompatImageView r102, SimpleDraweeView r103, TextView r104) {
        this.f358597a = r100;
        this.f358598b = r101;
        this.f358599c = r102;
        this.f358600d = r103;
        this.f358601e = r104;
    }
}
