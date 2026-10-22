package com.bytedance.ee.bear.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.ee.util.ui.ColorUtils;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public class RoundColorView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f240118a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f240119b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f240120c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f240121d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f240122e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Paint f240123f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RectF f240124g;

    private RectF getBounds() {
        if (this.f240124g != null) goto L5;
        this.f240124g = new RectF();
    L5:
        this.f240124g.set(0.0f, 0.0f, getWidth(), getHeight());
        return this.f240124g;
    }

    private float getOffset() {
        if (this.f240120c != (-1.0f)) goto L6;
        double r100 = getWidth();
        this.f240120c = (float) (((double) ((float) ((Math.sqrt(Math.pow(r100, 2.0d) * 2.0d) - r100) / 2.0d))) / Math.sqrt(2.0d));
    L6:
        return this.f240120c;
    }

    private Paint getPaint() {
        if (this.f240123f != null) goto L6;
        this.f240123f = new Paint(1);
    L6:
        return this.f240123f;
    }

    public int getColor() {
        return this.f240118a;
    }

    public int getInnerBorderColor() {
        return this.f240119b;
    }

    public RoundColorView(Context r100) {
        super(r100);
        this.f240120c = -1.0f;
        this.f240121d = false;
        this.f240122e = false;
    }

    private void setBorderColor(String r100) {
        if (TextUtils.equals(r100, "#f5f5f5") == false) goto L5;
    L8:
        boolean r101 = true;
    L9:
        this.f240122e = r101;
        if (r101 == false) goto L20;
        int r102 = getContext().getResources().getColor(R.color.lkui_N300);
        int r103 = ColorUtils.f243151a;
        Intrinsics.checkNotNullParameter(r100, "solidColor");
        float[] r104 = new float[3];     // Catch: Exception -> L14
        Color.colorToHSV(Color.parseColor(r100), r104);     // Catch: Exception -> L14
        r104[2] = (float) (((double) r104[2]) * 0.9d);     // Catch: Exception -> L14
        r102 = Color.HSVToColor(r104);     // Catch: Exception -> L14
    L16:
        setInnerBorderColor(r102);
        return;
    L14:
        e = move-exception;
        e.printStackTrace();
        tt5.a.d("ColorUtils", "Bad color :" + r100);
        goto L16
    L20:
        return;
    L5:
        if (TextUtils.equals(r100, "#ffffff") == true) goto L8;
        r101 = false;
        goto L9
    }

    public final void a(AttributeSet r100) {
        if (r100 == null) goto L5;
        TypedArray r101 = getContext().obtainStyledAttributes(r100, new int[]{R.attr.color, R.attr.innerBorderColor}, 0, 0);
        int r102 = r101.getColor(0, this.f240118a);
        this.f240118a = r102;
        this.f240119b = r101.getColor(1, r102);
        r101.recycle();
        return;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
        float r101 = getWidth();
        float r102 = getHeight();
        Paint r103 = getPaint();
        r103.setStyle(Paint.Style.FILL);
        r103.setColor(this.f240118a);
        float r104 = r101 / 2.0f;
        float r105 = r102 / 2.0f;
        r100.drawRoundRect(getBounds(), r104, r105, r103);
        int r106 = com.bytedance.ee.util.ui.n.d(1);
        if (this.f240122e == false) goto L6;
        r103.setStyle(Paint.Style.STROKE);
        r103.setColor(this.f240119b);
        float r107 = r106;
        r103.setStrokeWidth(r107);
        r100.drawCircle(r104, r105, r104 - (r107 / 2.0f), r103);
    L6:
        if (this.f240121d == false) goto L9;
        r103.setColor(-65536);
        float r108 = getOffset() + (r106 / 2.0f);
        r100.drawLine(r108, r108, r101 - r108, r102 - r108, r103);
        return;
    }

    public void setClear(boolean r100) {
        this.f240121d = r100;
    }

    public void setColor(String r100) {
        setBorderColor(r100);
        setColor(Color.parseColor(r100));     // Catch: Exception -> L5
        return;
    L5:
        tt5.a.d("RoundColorView", "Bad color :" + r100);
    }

    public void setInnerBorderColor(int r100) {
        if (this.f240119b == r100) goto L6;
        this.f240119b = r100;
        invalidate();
        return;
    }

    public void setNeedBorder(boolean r100) {
        this.f240122e = r100;
    }

    public void setColor(int r100) {
        if (this.f240118a == r100) goto L6;
        this.f240118a = r100;
        invalidate();
        return;
    }

    public RoundColorView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f240120c = -1.0f;
        this.f240121d = false;
        this.f240122e = false;
        a(r101);
    }

    public RoundColorView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f240120c = -1.0f;
        this.f240121d = false;
        this.f240122e = false;
        a(r101);
    }
}
