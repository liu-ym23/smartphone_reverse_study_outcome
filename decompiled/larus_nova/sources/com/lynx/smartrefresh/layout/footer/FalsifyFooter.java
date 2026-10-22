package com.lynx.smartrefresh.layout.footer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.larus.nova.R;
import com.lynx.smartrefresh.layout.SmartRefreshLayout;
import com.lynx.smartrefresh.layout.constant.RefreshState;
import m6a.e;
import m6a.h;
import m6a.i;
import p6a.b;

/* JADX INFO: loaded from: classes32.dex */
public class FalsifyFooter extends b implements e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public h f381569d;

    public FalsifyFooter(Context r100) {
        this(r100, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r110) {
        super.dispatchDraw(r110);
        if (isInEditMode() == false) goto L6;
        int r100 = r6a.b.c(5.0f);
        Context r101 = getContext();
        Paint r102 = new Paint();
        r102.setStyle(Paint.Style.STROKE);
        r102.setColor(-858993460);
        r102.setStrokeWidth(r6a.b.c(1.0f));
        float r103 = r100;
        r102.setPathEffect(new DashPathEffect(new float[]{r103, r103, r103, r103}, 1.0f));
        r110.drawRect(r103, r103, getWidth() - r100, getBottom() - r100, r102);
        TextView r104 = new TextView(r101);
        r104.setText(r101.getString(R.string.srl_component_falsify, new Object[]{getClass().getSimpleName(), Float.valueOf(getHeight() / r6a.b.f536385b)}));
        r104.setTextColor(-858993460);
        r104.setGravity(17);
        r104.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getHeight(), 1073741824));
        r104.layout(0, 0, getWidth(), getHeight());
        r104.draw(r110);
        return;
    }

    public FalsifyFooter(Context r100, AttributeSet r101) {
        super(r100, r101, 0);
    }

    @Override // p6a.b, m6a.g
    public final void j(SmartRefreshLayout.i r100, int r101, int r102) {
        this.f381569d = r100;
        r100.f381548a.K = false;
    }

    @Override // p6a.b, m6a.g
    public final void k(i r100, int r101, int r102) {
        h r103 = this.f381569d;
        if (r103 == null) goto L6;
        SmartRefreshLayout.i r104 = (SmartRefreshLayout.i) r103;
        r104.d(RefreshState.None);
        h r105 = this.f381569d;
        SmartRefreshLayout.i r106 = (SmartRefreshLayout.i) r105;
        r106.d(RefreshState.LoadFinish);
        return;
    }
}
