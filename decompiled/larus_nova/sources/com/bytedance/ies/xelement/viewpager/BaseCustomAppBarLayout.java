package com.bytedance.ies.xelement.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: loaded from: classes19.dex */
public abstract class BaseCustomAppBarLayout extends AppBarLayout implements CoordinatorLayout.AttachedBehavior {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f250428a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f250429b;

    public BaseCustomAppBarLayout(Context r100) {
        super(r100);
        this.f250428a = true;
        this.f250429b = true;
    }

    public void setIsEnableTabbarDrag(boolean r100) {
        this.f250428a = r100;
    }

    public void setScrollEnable(boolean r100) {
        this.f250429b = r100;
    }

    public BaseCustomAppBarLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f250428a = true;
        this.f250429b = true;
    }
}
