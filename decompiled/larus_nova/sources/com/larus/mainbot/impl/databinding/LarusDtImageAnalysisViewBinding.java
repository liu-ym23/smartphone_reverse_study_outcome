package com.larus.mainbot.impl.databinding;

import android.view.View;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.markdown.view.DeepThinkImageAnalysisViewArch;
import com.larus.common_ui.widget.shimmer.ShimmerMaskView;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusDtImageAnalysisViewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f358590a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SimpleDraweeView f358591b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SimpleDraweeView f358592c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ShimmerMaskView f358593d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f358590a;
    }

    public LarusDtImageAnalysisViewBinding(DeepThinkImageAnalysisViewArch r100, SimpleDraweeView r101, SimpleDraweeView r102, ShimmerMaskView r103) {
        this.f358590a = r100;
        this.f358591b = r101;
        this.f358592c = r102;
        this.f358593d = r103;
    }
}
