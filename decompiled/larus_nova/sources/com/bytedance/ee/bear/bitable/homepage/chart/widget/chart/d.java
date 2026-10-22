package com.bytedance.ee.bear.bitable.homepage.chart.widget.chart;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: classes15.dex */
public abstract class d extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f212700a;

    public final void a() {
        if (this.f212700a == true) goto L6;
        this.f212700a = true;
        ((c) ((DwarfComponentProvider) UnsafeCasts.unsafeCast(this)).provideComponent()).q1((ChartItemView) UnsafeCasts.unsafeCast(this));
        return;
    }

    public d(Context r100, AttributeSet r101) {
        super(r100, r101);
        a();
    }

    public d(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        a();
    }
}
