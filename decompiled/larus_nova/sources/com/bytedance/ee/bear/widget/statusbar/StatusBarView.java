package com.bytedance.ee.bear.widget.statusbar;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes18.dex */
public class StatusBarView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f239955a;

    public StatusBarView(Context r100) {
        this(r100, null);
    }

    public StatusBarView(Context r100, AttributeSet r101) {
        super(r100, r101);
        Resources r102 = r100.getResources();
        int r103 = r102.getIdentifier("status_bar_height", "dimen", "android");
        if (r103 <= 0) goto L5;
        int r104 = r102.getDimensionPixelSize(r103);
    L6:
        this.f239955a = r104;
        return;
    L5:
        r104 = 0;
        goto L6
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        setMeasuredDimension(View.MeasureSpec.getSize(r100), this.f239955a);
    }
}
