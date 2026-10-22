package com.larus.common_ui.refresh;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import q19.c;

/* JADX INFO: loaded from: classes27.dex */
public abstract class AbsRefreshHeaderLayout extends FrameLayout {
    public abstract void a(SuperSwipeRefreshLayout r100, c r101);

    public abstract void b(SuperSwipeRefreshLayout r100);

    public abstract void c(SuperSwipeRefreshLayout r100, int r101);

    public abstract void d();

    public AbsRefreshHeaderLayout(Context r100) {
        this(r100, null);
    }

    public AbsRefreshHeaderLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public AbsRefreshHeaderLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
