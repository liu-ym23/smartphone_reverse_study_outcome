package com.larus.common_res.common_ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.larus.common_ui.view.CommonSlideRootContainer;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusFragmentCommonSlideBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f326709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f326710b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ViewPager2 f326711c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FrameLayout f326712d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CommonSlideRootContainer f326713e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ImageView f326714f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ImageView f326715g;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f326709a;
    }

    public static LarusFragmentCommonSlideBinding a(LayoutInflater r100, ViewGroup r110) {
        View r101 = r100.inflate(R.layout.larus_fragment_common_slide, r110, false);
        int r111 = R.id.back;
        ImageView r102 = (ImageView) ViewBindings.findChildViewById(r101, R.id.back);
        if (r102 == null) goto L17;
        r111 = R.id.common_pager;
        ViewPager2 r103 = (ViewPager2) ViewBindings.findChildViewById(r101, R.id.common_pager);
        if (r103 == null) goto L17;
        r111 = R.id.container;
        FrameLayout r104 = (FrameLayout) ViewBindings.findChildViewById(r101, R.id.container);
        if (r104 == null) goto L17;
        r111 = R.id.dismiss_container;
        CommonSlideRootContainer r105 = (CommonSlideRootContainer) ViewBindings.findChildViewById(r101, R.id.dismiss_container);
        if (r105 == null) goto L17;
        r111 = R.id.more;
        ImageView r106 = (ImageView) ViewBindings.findChildViewById(r101, R.id.more);
        if (r106 == null) goto L17;
        r111 = R.id.share;
        ImageView r107 = (ImageView) ViewBindings.findChildViewById(r101, R.id.share);
        if (r107 == null) goto L17;
        return new LarusFragmentCommonSlideBinding((FrameLayout) r101, r102, r103, r104, r105, r106, r107);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r101.getResources().getResourceName(r111)));
    }

    public LarusFragmentCommonSlideBinding(FrameLayout r100, ImageView r101, ViewPager2 r102, FrameLayout r103, CommonSlideRootContainer r104, ImageView r105, ImageView r106) {
        this.f326709a = r100;
        this.f326710b = r101;
        this.f326711c = r102;
        this.f326712d = r103;
        this.f326713e = r104;
        this.f326714f = r105;
        this.f326715g = r106;
    }
}
