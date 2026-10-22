package com.bytedance.ee.bear.bitable.homepage.recommend;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;
import android.util.Size;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class r extends ReplacementSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f213038a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f213039b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f213040c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f213041d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f213042e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Drawable f213043f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Size f213044g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f213045h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f213046i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f213047j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f213048k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f213049l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f213050m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public RectF f213051n;

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        Intrinsics.checkNotNullParameter(r101, "text");
        r100.setTextSize(this.f213039b);
        r100.setFakeBoldText(this.f213042e);
        int r105 = (((int) r100.measureText(r101, r102, r103)) + this.f213048k) + this.f213049l;
        Size r106 = this.f213044g;
        if (r106 == null) goto L5;
        int r107 = r106.getWidth();
    L6:
        int r108 = (r105 + r107) + this.f213047j;
        this.f213045h = r108;
        return (r108 + 0) + this.f213046i;
    L5:
        r107 = 0;
        goto L6
    }

    public r(int r100, int r101, int r102, int r103, Drawable r104, Size r105) {
        this.f213038a = r100;
        this.f213039b = r101;
        this.f213040c = r102;
        this.f213041d = r103;
        this.f213042e = false;
        this.f213043f = r104;
        this.f213044g = r105;
        this.f213046i = UIHelper.dp2px(4.0f);
        this.f213047j = UIHelper.dp2px(2.0f);
        this.f213048k = UIHelper.dp2px(4.0f);
        this.f213049l = UIHelper.dp2px(4.0f);
        this.f213050m = UIHelper.dp2px(4.0f);
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r110, CharSequence r111, int r112, int r210, float r211, int r212, int r213, int r214, Paint r215) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        Intrinsics.checkNotNullParameter(r111, "text");
        Intrinsics.checkNotNullParameter(r215, "paint");
        r215.setTextSize(this.f213039b);
        r215.setFakeBoldText(this.f213042e);
        int r100 = 0;
        if (this.f213051n != null) goto L5;
        int r101 = UIHelper.dp2px(2.0f);
        float r102 = 0 + r211;
        this.f213051n = new RectF(r102, r212 + r101, this.f213045h + r102, (r212 + r101) + this.f213041d);
    L5:
        r215.setColor(this.f213040c);
        RectF r103 = this.f213051n;
        if (r103 == null) goto L49;
        float r104 = this.f213050m;
        r110.drawRoundRect(r103, r104, r104, r215);
        Drawable r105 = this.f213043f;
        if (r105 == null) goto L35;
        RectF r106 = this.f213051n;
        if (r106 == null) goto L34;
        int r113 = (((int) r211) + 0) + this.f213048k;
        float r114 = r106.top;
        float r107 = r106.bottom - r114;
        if (r105 == null) goto L17;
        Size r115 = this.f213044g;
        if (r115 == null) goto L16;
        int r116 = r115.getHeight();
    L18:
        float r117 = r114 + ((r107 - r116) / 2);
        int r118 = (int) r117;
        Drawable r119 = this.f213043f;
        if (r119 == null) goto L24;
        Size r120 = this.f213044g;
        if (r120 == null) goto L23;
        int r121 = r120.getWidth();
    L25:
        int r122 = r121 + r113;
        Drawable r123 = this.f213043f;
        if (r123 == null) goto L31;
        Size r124 = this.f213044g;
        if (r124 == null) goto L30;
        int r125 = r124.getHeight();
    L32:
        r105.setBounds(new Rect(r113, r118, r122, (int) (r117 + r125)));
        r105.draw(r110);
        goto L35
    L30:
        r125 = r123.getIntrinsicHeight();
        goto L32
    L31:
        r125 = 0;
        goto L32
    L23:
        r121 = r119.getIntrinsicWidth();
        goto L25
    L24:
        r121 = 0;
        goto L25
    L16:
        r116 = r105.getIntrinsicHeight();
        goto L18
    L17:
        r116 = 0;
        goto L18
    L34:
        throw new IllegalArgumentException("Required value was null.".toString());
    L35:
        float r108 = this.f213039b;
        r215.setTextSize(r108);
        r215.setColor(this.f213038a);
        Paint.FontMetricsInt r109 = r215.getFontMetricsInt();
        float r126 = (0 + r211) + this.f213048k;
        Drawable r127 = this.f213043f;
        if (r127 == null) goto L42;
        Size r128 = this.f213044g;
        if (r128 == null) goto L40;
        int r129 = r128.getWidth();
    L41:
        r100 = r129;
        goto L42
    L40:
        r129 = r127.getIntrinsicWidth();
    L42:
        float r130 = (r126 + r100) + this.f213047j;
        RectF r131 = this.f213051n;
        if (r131 == null) goto L47;
        float r132 = r131.bottom;
        r110.drawText(r111, r112, r210, r130, (r132 - (((r132 - r131.top) - r108) / 2)) - (r109.descent / 2), r215);
        return;
    L47:
        throw new IllegalArgumentException("Required value was null.".toString());
    L49:
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
