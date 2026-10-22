package com.ss.android.lark.ug.banner.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes38.dex */
public class CloseIcon extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f444405a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Path f444406b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f444407c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f444408d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f444409e;

    public CloseIcon(Context r100) {
        super(r100);
        this.f444407c = UIUtils.getColor(getContext(), R.color.lkui_N600);
        this.f444408d = TypedValue.applyDimension(1, 1.3f, UIUtils.getDisplayMetrics(getContext()));
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
        int r101 = getWidth();
        int r102 = getHeight();
        Paint r103 = this.f444405a;
        if (r103 != null) goto L6;
        Paint r104 = new Paint();
        this.f444405a = r104;
        r104.setStyle(Paint.Style.STROKE);
        this.f444405a.setColor(this.f444407c);
        this.f444405a.setStrokeWidth(this.f444408d);
        this.f444409e = false;
    L8:
        Path r105 = this.f444406b;
        if (r105 != null) goto L11;
        this.f444406b = new Path();
    L12:
        int r106 = getPaddingStart();
        int r107 = getPaddingTop();
        int r108 = r101 - getPaddingEnd();
        int r109 = r102 - getPaddingBottom();
        float r110 = r106;
        float r111 = r107;
        this.f444406b.moveTo(r110, r111);
        float r112 = r108;
        float r113 = r109;
        this.f444406b.lineTo(r112, r113);
        this.f444406b.moveTo(r110, r113);
        this.f444406b.lineTo(r112, r111);
        this.f444406b.close();
        r100.drawPath(this.f444406b, this.f444405a);
        return;
    L11:
        r105.reset();
        goto L12
    L6:
        if (this.f444409e == false) goto L8;
        r103.setColor(this.f444407c);
        this.f444405a.setStrokeWidth(this.f444408d);
        this.f444409e = false;
        goto L8
    }

    public void setIconColor(int r100) {
        this.f444407c = r100;
        this.f444409e = true;
        postInvalidate();
    }

    public void setIconLineWidth(float r100) {
        this.f444408d = r100;
        this.f444409e = true;
        postInvalidate();
    }

    public CloseIcon(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f444407c = UIUtils.getColor(getContext(), R.color.lkui_N600);
        this.f444408d = TypedValue.applyDimension(1, 1.3f, UIUtils.getDisplayMetrics(getContext()));
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
    }

    public CloseIcon(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f444407c = UIUtils.getColor(getContext(), R.color.lkui_N600);
        this.f444408d = TypedValue.applyDimension(1, 1.3f, UIUtils.getDisplayMetrics(getContext()));
    }
}
