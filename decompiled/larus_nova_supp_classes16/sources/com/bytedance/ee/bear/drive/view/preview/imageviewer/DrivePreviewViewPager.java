package com.bytedance.ee.bear.drive.view.preview.imageviewer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DrivePreviewViewPager extends ViewPager {
    public boolean a;

    public DrivePreviewViewPager(Context r1) {
        super(r1);
        this.a = true;
    }

    public final boolean onInterceptTouchEvent(MotionEvent r4) {
    L9:
        e = move-exception;
        tt5.a.b("DrivePhotoViewPager", "onInterceptTouchEvent " + e.getMessage());
        return false;
    L4:
        if (this.a == false) goto L14;
        if (super.onInterceptTouchEvent(r4) == false) goto L15;
        return true;
    L15:
        return false;
    L14:
        return false;
    }

    public void setEnableSwipe(boolean r1) {
        this.a = r1;
    }

    public DrivePreviewViewPager(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.a = true;
    }
}
