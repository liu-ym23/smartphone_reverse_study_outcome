package com.ss.android.lark.widget.linked_emojicon.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.text.style.ReplacementSpan;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import java.util.Objects;

/* JADX INFO: loaded from: classes38.dex */
public final class a extends ReplacementSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f446429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f446430b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f446431c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f446432d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f446433e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f446434f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f446435g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f446436h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Context f446437i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f446438j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Path f446439k;

    public final int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.f446429a), Integer.valueOf(this.f446430b), Integer.valueOf(this.f446431c), this.f446432d, Float.valueOf(this.f446433e), Float.valueOf(this.f446434f), Integer.valueOf(this.f446435g), Integer.valueOf(this.f446436h), Integer.valueOf(this.f446438j)});
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L31:
        return false;
    L8:
        if (a.class != r100.getClass()) goto L31;
        a r101 = (a) r100;
        if (this.f446429a == r101.f446429a) goto L13;
    L29:
        return false;
    L13:
        if (this.f446430b != r101.f446430b) goto L29;
        if (this.f446431c != r101.f446431c) goto L29;
        if (Float.compare(r101.f446433e, this.f446433e) != 0) goto L29;
        if (Float.compare(r101.f446434f, this.f446434f) != 0) goto L29;
        if (this.f446435g != r101.f446435g) goto L29;
        if (this.f446436h != r101.f446436h) goto L29;
        if (this.f446438j != r101.f446438j) goto L29;
        if (Objects.equals(this.f446432d, r101.f446432d) == false) goto L29;
        return true;
    }

    public a(String r100, Context r101, int r102, int r103) {
        this.f446429a = 10;
        this.f446430b = 10;
        this.f446433e = 1.0f;
        this.f446437i = r101;
        this.f446432d = r100;
        this.f446435g = UIUtils.dp2px(r101, 1.0f);
        this.f446436h = UIUtils.dp2px(r101, 3.0f);
        if (r102 <= 0) goto L5;
        this.f446429a = r102;
    L5:
        if (r103 <= 0) goto L7;
        this.f446430b = r103;
    L7:
        this.f446433e = 0.6f;
        this.f446439k = new Path();
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        int r105 = (int) r100.measureText(r101, r102, r103);
        this.f446431c = r105;
        int r106 = this.f446430b;
        int r107 = this.f446429a;
        int r108 = r105 % (r106 + r107);
        if (r108 <= r106) goto L5;
        this.f446438j = (r108 - r106) / 2;
    L6:
        return r105;
    L5:
        this.f446438j = (r108 + r107) / 2;
        goto L6
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r110, CharSequence r111, int r112, int r113, float r114, int r115, int r116, int r117, Paint r210) {
        r110.drawText(r111, r112, r113, r114, r116, r210);
        this.f446434f = r210.measureText(this.f446432d);
        this.f446439k.reset();
        this.f446439k.moveTo(r114, this.f446436h + r116);
        this.f446439k.lineTo(this.f446434f + r114, this.f446436h + r116);
        r210.setAntiAlias(true);
        r210.setColor(this.f446437i.getResources().getColor(R.color.ud_N900));
        r210.setAlpha((int) (this.f446433e * 255.0f));
        r210.setStyle(Paint.Style.STROKE);
        r210.setPathEffect(new DashPathEffect(new float[]{this.f446430b, this.f446429a}, -this.f446438j));
        r210.setStrokeWidth(this.f446435g);
        r110.drawPath(this.f446439k, r210);
    }
}
