package com.larus.community.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.larus.common_ui.widget.roundlayout.RoundLinearLayout;
import com.larus.community.impl.share.CreationShareSegmentedControlView;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusCommunityPictureShareDialogLayoutBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoundLinearLayout f329141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f329142b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CreationShareSegmentedControlView f329143c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FrameLayout f329144d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ViewPager2 f329145e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f329141a;
    }

    public LarusCommunityPictureShareDialogLayoutBinding(RoundLinearLayout r100, AppCompatImageView r101, CreationShareSegmentedControlView r102, FrameLayout r103, ViewPager2 r104) {
        this.f329141a = r100;
        this.f329142b = r101;
        this.f329143c = r102;
        this.f329144d = r103;
        this.f329145e = r104;
    }
}
