package com.bytedance.awemeopen.apps.framework.feed.follow;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.PagerAdapter;
import com.bytedance.awemeopen.apps.framework.utils.d0;

/* JADX INFO: loaded from: classes14.dex */
public class FlippableViewPager extends DmtViewPager {

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public LazyFragmentPagerAdapter f194712h1;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public final boolean f194713k1;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public boolean f194714p1;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public float f194715v1;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    public boolean f194716x1;

    @Override // android.view.View
    public final boolean performAccessibilityAction(int r100, Bundle r101) {
        return true;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.follow.DmtViewPager
    public final boolean e() {
        if (this.f194712h1 == null) goto L7;
        return false;
    L7:
        return this.B;
    }

    public boolean getEnablePaging() {
        return this.f194713k1;
    }

    public boolean getIgnoreInstPageWhenScroll() {
        return this.f194714p1;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.follow.DmtViewPager
    public final boolean n() {
        return this.f194716x1;
    }

    public FlippableViewPager(Context r100) {
        super(r100);
        this.f194713k1 = true;
        this.f194714p1 = false;
        this.f194715v1 = 0.1f;
        this.f194716x1 = false;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.follow.DmtViewPager, android.view.View
    public final boolean canScrollHorizontally(int r100) {
        if (this.f194713k1 == true) goto L5;
    L7:
        return false;
    L5:
        if (super.canScrollHorizontally(r100) == false) goto L7;
        return true;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.follow.DmtViewPager, android.view.View
    public void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.follow.DmtViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r100) {
        Context r101 = getContext();     // Catch: Exception -> L15
        if (((d0.c(r101) - d0.b(r101)) - x54.a.a(75)) >= r100.getRawY()) goto L6;
        boolean r102 = true;
    L7:
        if (r102 == false) goto L10;
        return false;
    L10:
        if (this.f194713k1 == false) goto L20;
        if (super.onInterceptTouchEvent(r100) == false) goto L21;
        return true;
    L21:
        return false;
    L20:
        return false;
    L6:
        r102 = false;
    L15:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.follow.DmtViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent r100) {
    L9:
        e = move-exception;
        e.printStackTrace();
        return false;
    L4:
        if (this.f194713k1 == false) goto L14;
        if (super.onTouchEvent(r100) == false) goto L15;
        return true;
    L15:
        return false;
    L14:
        return false;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.follow.DmtViewPager
    public void setAdapter(PagerAdapter r100) {
        super.setAdapter(r100);
        if ((r100 instanceof LazyFragmentPagerAdapter) == false) goto L5;
        LazyFragmentPagerAdapter r101 = (LazyFragmentPagerAdapter) r100;
    L6:
        this.f194712h1 = r101;
        return;
    L5:
        r101 = null;
        goto L6
    }

    public void setForceDispatchOnSelected(boolean r100) {
        this.f194716x1 = r100;
    }

    public void setIgnoreInstPageWhenScroll(boolean r100) {
        this.f194714p1 = r100;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.follow.DmtViewPager
    public void setOffscreenPageLimit(int r100) {
        throw new UnsupportedOperationException();
    }

    public void setStartLoadingOffset(float r100) {
        this.f194715v1 = r100;
    }

    public FlippableViewPager(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f194713k1 = true;
        this.f194714p1 = false;
        this.f194715v1 = 0.1f;
        this.f194716x1 = false;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.follow.DmtViewPager
    public final void p(int r100, float r101, int r102) {
        if (this.f194712h1 != null) goto L5;
    L24:
        super.p(r100, r101, r102);
        return;
    L5:
        if (this.f194714p1 == true) goto L24;
        boolean r103 = false;
        if (getCurrentItem() != r100) goto L16;
        int r104 = r100 + 1;
        if (r101 < this.f194715v1) goto L24;
        if (this.f194712h1.f194720a.get(r104) == null) goto L13;
        r103 = true;
    L13:
        if (r103 == false) goto L24;
        this.f194712h1.startUpdate(this);
        this.f194712h1.g(this, r104);
        this.f194712h1.finishUpdate(this);
        goto L24
    L16:
        if (getCurrentItem() <= r100) goto L24;
        if ((1.0f - r101) < this.f194715v1) goto L24;
        if (this.f194712h1.f194720a.get(r100) == null) goto L22;
        r103 = true;
    L22:
        if (r103 == false) goto L24;
        this.f194712h1.startUpdate(this);
        this.f194712h1.g(this, r100);
        this.f194712h1.finishUpdate(this);
        goto L24
    }
}
