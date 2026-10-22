package com.bytedance.ee.bear.bitable.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.ee.bear.bitable.card.view.table.EmptyCoverView;

/* JADX INFO: loaded from: classes15.dex */
public final class BitableCardCoverPageViewPagerBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f210621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final EmptyCoverView f210622b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RelativeLayout f210623c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f210624d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ViewPager f210625e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final FrameLayout f210626f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextView f210627g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LinearLayout f210628h;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f210621a;
    }

    public BitableCardCoverPageViewPagerBinding(FrameLayout r100, EmptyCoverView r101, RelativeLayout r102, TextView r103, ViewPager r104, FrameLayout r105, TextView r106, LinearLayout r107) {
        this.f210621a = r100;
        this.f210622b = r101;
        this.f210623c = r102;
        this.f210624d = r103;
        this.f210625e = r104;
        this.f210626f = r105;
        this.f210627g = r106;
        this.f210628h = r107;
    }
}
