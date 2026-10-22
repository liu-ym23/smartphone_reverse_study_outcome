package com.bytedance.ee.bear.drive.view.preview.imageviewer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: loaded from: classes16.dex */
public class DrivePreviewViewPager extends ViewPager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f224992a;

    public DrivePreviewViewPager(Context r100) {
        super(r100);
        this.f224992a = true;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
    L9:
        e = move-exception;
        tt5.a.b("DrivePhotoViewPager", "onInterceptTouchEvent " + e.getMessage());
        return false;
    L4:
        if (this.f224992a == false) goto L14;
        if (super.onInterceptTouchEvent(r100) == false) goto L15;
        return true;
    L15:
        return false;
    L14:
        return false;
    }

    public void setEnableSwipe(boolean r100) {
        this.f224992a = r100;
    }

    public DrivePreviewViewPager(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f224992a = true;
    }
}
