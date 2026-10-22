package com.bytedance.awemeopen.apps.framework.feed.follow;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.PagerAdapter;
import com.bytedance.awemeopen.apps.framework.utils.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class FlippableViewPager extends DmtViewPager {
    public LazyFragmentPagerAdapter h1;
    public final boolean k1;
    public boolean p1;
    public float v1;
    public boolean x1;

    @Override // android.view.View
    public final boolean performAccessibilityAction(int r1, Bundle r2) {
        return true;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.follow.DmtViewPager
    public final boolean e() {
        if (this.h1 == null) goto L7;
        return false;
    L7:
        return this.B;
    }

    public boolean getEnablePaging() {
        return this.k1;
    }

    public boolean getIgnoreInstPageWhenScroll() {
        return this.p1;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.follow.DmtViewPager
    public final boolean n() {
        return this.x1;
    }

    public FlippableViewPager(Context r2) {
        super(r2);
        this.k1 = true;
        this.p1 = false;
        this.v1 = 0.1f;
        this.x1 = false;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.follow.DmtViewPager, android.view.View
    public final boolean canScrollHorizontally(int r2) {
        if (this.k1 == true) goto L5;
    L7:
        return false;
    L5:
        if (super.canScrollHorizontally(r2) == false) goto L7;
        return true;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.follow.DmtViewPager, android.view.View
    public void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.follow.DmtViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r5) {
        Context r1 = getContext();     // Catch: Exception -> L15
        if (((d0.c(r1) - d0.b(r1)) - x54.a.a(75)) >= r5.getRawY()) goto L6;
        boolean r2 = true;
    L7:
        if (r2 == false) goto L10;
        return false;
    L10:
        if (this.k1 == false) goto L20;
        if (super.onInterceptTouchEvent(r5) == false) goto L21;
        return true;
    L21:
        return false;
    L20:
        return false;
    L6:
        r2 = false;
    L15:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.follow.DmtViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent r3) {
    L9:
        e = move-exception;
        e.printStackTrace();
        return false;
    L4:
        if (this.k1 == false) goto L14;
        if (super.onTouchEvent(r3) == false) goto L15;
        return true;
    L15:
        return false;
    L14:
        return false;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.follow.DmtViewPager
    public void setAdapter(PagerAdapter r2) {
        super.setAdapter(r2);
        if ((r2 instanceof LazyFragmentPagerAdapter) == false) goto L5;
        LazyFragmentPagerAdapter r3 = (LazyFragmentPagerAdapter) r2;
    L6:
        this.h1 = r3;
        return;
    L5:
        r3 = null;
        goto L6
    }

    public void setForceDispatchOnSelected(boolean r1) {
        this.x1 = r1;
    }

    public void setIgnoreInstPageWhenScroll(boolean r1) {
        this.p1 = r1;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.follow.DmtViewPager
    public void setOffscreenPageLimit(int r1) {
        throw new UnsupportedOperationException();
    }

    public void setStartLoadingOffset(float r1) {
        this.v1 = r1;
    }

    public FlippableViewPager(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.k1 = true;
        this.p1 = false;
        this.v1 = 0.1f;
        this.x1 = false;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.follow.DmtViewPager
    public final void p(int r5, float r6, int r7) {
        if (this.h1 != null) goto L5;
    L24:
        super.p(r5, r6, r7);
        return;
    L5:
        if (this.p1 == true) goto L24;
        boolean r1 = false;
        if (getCurrentItem() != r5) goto L16;
        int r0 = r5 + 1;
        if (r6 < this.v1) goto L24;
        if (this.h1.a.get(r0) == null) goto L13;
        r1 = true;
    L13:
        if (r1 == false) goto L24;
        this.h1.startUpdate(this);
        this.h1.g(this, r0);
        this.h1.finishUpdate(this);
        goto L24
    L16:
        if (getCurrentItem() <= r5) goto L24;
        if ((1.0f - r6) < this.v1) goto L24;
        if (this.h1.a.get(r5) == null) goto L22;
        r1 = true;
    L22:
        if (r1 == false) goto L24;
        this.h1.startUpdate(this);
        this.h1.g(this, r5);
        this.h1.finishUpdate(this);
        goto L24
    }
}
