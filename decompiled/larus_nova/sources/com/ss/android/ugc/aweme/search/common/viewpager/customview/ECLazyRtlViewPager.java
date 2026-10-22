package com.ss.android.ugc.aweme.search.common.viewpager.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.PagerAdapter;
import com.ss.android.ugc.aweme.search.common.viewpager.ECLazyFragmentPagerAdapter;

/* JADX INFO: loaded from: classes40.dex */
public class ECLazyRtlViewPager extends ECRtlViewPager {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f452563e = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Boolean f452564d;

    public ECLazyRtlViewPager(Context r100) {
        super(r100);
        this.f452564d = Boolean.TRUE;
        addOnPageChangeListener(new AnonymousClass1(this));
    }

    @Override // com.ss.android.ugc.aweme.search.common.viewpager.customview.ECRtlViewPager, androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
    L8:
        e = move-exception;
        e.printStackTrace();
        return false;
    L4:
        if (this.f452564d.booleanValue() == false) goto L7;
        return super.onInterceptTouchEvent(r100);
    L7:
        return false;
    }

    @Override // com.ss.android.ugc.aweme.search.common.viewpager.customview.ECRtlViewPager, androidx.viewpager.widget.ViewPager, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
    L8:
        e = move-exception;
        e.printStackTrace();
        return false;
    L3:
        if (this.f452564d.booleanValue() == false) goto L6;
        return super.onTouchEvent(r100);
    L6:
        return true;
    }

    @Override // com.ss.android.ugc.aweme.search.common.viewpager.customview.ECRtlViewPager, androidx.viewpager.widget.ViewPager
    public void setAdapter(PagerAdapter r100) {
        ECLazyFragmentPagerAdapter r101 = (ECLazyFragmentPagerAdapter) r100;
        super.setAdapter(r100);
    }

    @Override // com.ss.android.ugc.aweme.search.common.viewpager.customview.ECRtlViewPager, androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int r100) {
        super.setCurrentItem(r100, this.f452564d.booleanValue());
    }

    public void setScroll(Boolean r100) {
        this.f452564d = r100;
    }

    public ECLazyRtlViewPager(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f452564d = Boolean.TRUE;
        addOnPageChangeListener(new AnonymousClass1(this));
    }
}
