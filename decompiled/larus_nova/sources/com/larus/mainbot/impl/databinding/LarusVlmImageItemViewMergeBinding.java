package com.larus.mainbot.impl.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.standarduikit.vlm.view.viewholder.VlmItemView;
import com.larus.common_ui.widget.roundlayout.RoundTextView;
import com.larus.common_ui.widget.shimmer.ShimmerMaskView;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusVlmImageItemViewMergeBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f358827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SimpleDraweeView f358828b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ShimmerMaskView f358829c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RoundTextView f358830d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SimpleDraweeView f358831e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f358832f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View f358833g;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f358827a;
    }

    public LarusVlmImageItemViewMergeBinding(VlmItemView r100, SimpleDraweeView r101, ShimmerMaskView r102, RoundTextView r103, SimpleDraweeView r104, TextView r105, View r106) {
        this.f358827a = r100;
        this.f358828b = r101;
        this.f358829c = r102;
        this.f358830d = r103;
        this.f358831e = r104;
        this.f358832f = r105;
        this.f358833g = r106;
    }
}
