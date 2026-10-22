package com.scwang.smartrefresh.layout.footer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.larus.nova.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import cqa.d;
import cqa.g;
import cqa.h;
import fqa.b;

/* JADX INFO: loaded from: classes34.dex */
public class FalsifyFooter extends b implements d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public g f405951d;

    public FalsifyFooter(Context r100) {
        this(r100, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r110) {
        super.dispatchDraw(r110);
        if (isInEditMode() == false) goto L6;
        int r100 = hqa.b.c(5.0f);
        Context r101 = getContext();
        Paint r102 = new Paint();
        r102.setStyle(Paint.Style.STROKE);
        r102.setColor(-858993460);
        r102.setStrokeWidth(hqa.b.c(1.0f));
        float r103 = r100;
        r102.setPathEffect(new DashPathEffect(new float[]{r103, r103, r103, r103}, 1.0f));
        r110.drawRect(r103, r103, getWidth() - r100, getBottom() - r100, r102);
        TextView r104 = new TextView(r101);
        r104.setText(r101.getString(R.string.srl_component_falsify, new Object[]{getClass().getSimpleName(), Float.valueOf(getHeight() / hqa.b.f486829b)}));
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

    @Override // fqa.b, cqa.f
    public final void g(SmartRefreshLayout.j r100, int r101, int r102) {
        this.f405951d = r100;
        r100.f405930a.K = false;
    }

    @Override // fqa.b, cqa.f
    public final void i(h r100, int r101, int r102) {
        g r103 = this.f405951d;
        if (r103 == null) goto L6;
        SmartRefreshLayout.j r104 = (SmartRefreshLayout.j) r103;
        r104.d(RefreshState.None);
        g r105 = this.f405951d;
        SmartRefreshLayout.j r106 = (SmartRefreshLayout.j) r105;
        r106.d(RefreshState.LoadFinish);
        return;
    }
}
