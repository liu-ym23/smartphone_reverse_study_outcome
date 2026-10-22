package com.bytedance.ies.xelement.banner;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes19.dex */
public class BannerViewPager extends ViewPager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f249803a;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BannerViewPager f249804a;

        @Override // java.lang.Runnable
        public final void run() {
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        L13:
            return;
        L3:
            if (this.f249804a.getAdapter() == null) goto L9;
            this.f249804a.getAdapter().notifyDataSetChanged();     // Catch: Throwable -> L6
            return;
        }

        public a(BannerViewPager r100) {
            this.f249804a = r100;
        }
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        post(new a(this));
    }

    public BannerViewPager(Context r100) {
        super(r100);
        this.f249803a = true;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (this.f249803a == true) goto L5;
        return false;
    L5:
        if (getCurrentItem() != 0) goto L10;
        if (getChildCount() != 0) goto L10;
        return false;
    L10:
        return super.onInterceptTouchEvent(r100);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (this.f249803a == true) goto L5;
    L13:
        return false;
    L5:
        if (getCurrentItem() == 0) goto L7;
    L14:
        return super.onTouchEvent(r100);
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L13
    L7:
        if (getChildCount() != 0) goto L14;
        return false;
    }

    public void setScrollable(boolean r100) {
        this.f249803a = r100;
    }

    public BannerViewPager(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f249803a = true;
        setLayerType(2, null);
    }
}
