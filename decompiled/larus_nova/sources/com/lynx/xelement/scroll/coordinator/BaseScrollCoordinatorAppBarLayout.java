package com.lynx.xelement.scroll.coordinator;

import android.content.Context;
import android.util.AttributeSet;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: loaded from: classes32.dex */
public abstract class BaseScrollCoordinatorAppBarLayout extends AppBarLayout implements CoordinatorLayout.AttachedBehavior {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f384247a;

    public void setToolbarDragEnabled(boolean r100) {
    }

    public BaseScrollCoordinatorAppBarLayout(Context r100) {
        super(r100);
        this.f384247a = true;
    }

    public void setScrollEnabled(boolean r100) {
        this.f384247a = r100;
    }

    public BaseScrollCoordinatorAppBarLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f384247a = true;
    }
}
