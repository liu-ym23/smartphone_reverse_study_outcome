package com.bytedance.ee.bear.onboarding.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import j08.b;

/* JADX INFO: loaded from: classes18.dex */
public class MaskView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f236185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PorterDuffXfermode f236186b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RectF f236187c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f236188d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f236189e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f236190f;

    public MaskView(Context r100) {
        this(r100, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
        this.f236185a.setXfermode(null);
        this.f236185a.setColor(this.f236189e);
        r100.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.f236185a);
        this.f236185a.setXfermode(this.f236186b);
        this.f236185a.setColor(this.f236190f);
        RectF r101 = this.f236187c;
        int r102 = this.f236188d;
        r100.drawRoundRect(r101, r102, r102, this.f236185a);
    }

    public void setHighRect(RectF r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f236187c = r100;
        invalidate();
    }

    public void setHighlightRectRadius(int r100) {
        this.f236188d = r100;
    }

    public void setMaskColor(int r100) {
        this.f236189e = r100;
    }

    public MaskView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public MaskView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f236187c = new RectF();
        this.f236189e = b.b(getResources().getColor(R.color.lkui_N1000), 0.1f);
        this.f236190f = getResources().getColor(R.color.lkui_transparent);
        Resources r103 = getResources();
        this.f236188d = (int) (WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()).density * 8.0f);
        Paint r104 = new Paint();
        this.f236185a = r104;
        r104.setAntiAlias(true);
        this.f236185a.setDither(true);
        this.f236185a.setStyle(Paint.Style.FILL);
        this.f236186b = new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP);
        setLayerType(1, null);
    }
}
