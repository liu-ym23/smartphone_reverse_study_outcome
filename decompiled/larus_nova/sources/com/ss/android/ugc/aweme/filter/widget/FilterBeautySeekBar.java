package com.ss.android.ugc.aweme.filter.widget;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatSeekBar;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.tools.utils.i;
import com.ss.android.ugc.tools.view.style.FontType;
import com.ss.android.ugc.tools.view.style.StyleCentre;
import com.ss.android.ugc.tools.view.style.b;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes40.dex */
public class FilterBeautySeekBar extends AppCompatSeekBar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f450851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f450852b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f450853c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f450854d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f450855e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f450856f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f450857g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f450858h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f450859i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f450860j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f450861k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float f450862l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Paint f450863m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f450864n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f450865o;

    @Override // android.widget.ProgressBar
    public synchronized int getProgress() {
        monitor-enter(this);
        int r100 = super.getProgress();     // Catch: Throwable -> L13
        String r101 = String.valueOf(r100);     // Catch: Throwable -> L13
        this.f450852b = r101;     // Catch: Throwable -> L13
        if ("0".equals(r101) == false) goto L6;
    L8:
        Paint r102 = this.f450853c;     // Catch: Throwable -> L13
        if (r102 == null) goto L11;
        this.f450854d = r102.measureText(this.f450852b);     // Catch: Throwable -> L13
    L11:
        monitor-exit(this);
        return r100;
    L6:
        if (this.f450864n == false) goto L8;
        this.f450852b += GXTemplateKey.GAIAX_PE;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public FilterBeautySeekBar(Context r100) {
        this(r100, null);
    }

    @Override // androidx.appcompat.widget.AppCompatSeekBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final synchronized void onDraw(Canvas r100) {
        monitor-enter(this);
        super.onDraw(r100);     // Catch: Throwable -> L16
        Rect r101 = getProgressDrawable().getBounds();     // Catch: Throwable -> L16
        float r102 = getProgress() / getMax();     // Catch: Throwable -> L16
        float r103 = this.f450861k / 100.0f;     // Catch: Throwable -> L16
        if (i.c(this) == false) goto L7;
        r102 = 1.0f - r102;     // Catch: Throwable -> L16
        r103 = 1.0f - r103;     // Catch: Throwable -> L16
    L7:
        if (this.f450865o == false) goto L10;
        r100.drawText(this.f450852b, ((r101.width() * r102) - (this.f450854d / 2.0f)) + this.f450855e, this.f450859i, this.f450853c);     // Catch: Throwable -> L16
    L10:
        if (this.f450861k != (-1)) goto L12;
    L14:
        monitor-exit(this);
        return;
    L12:
        if (this.f450860j == false) goto L14;
        r100.drawCircle((r101.width() * r103) + this.f450855e, ((getHeight() + this.f450857g) - this.f450858h) / 2.0f, a(getContext(), this.f450862l), this.f450863m);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    public void setDefaultDotProgress(int r100) {
        this.f450861k = r100;
        invalidate();
    }

    public void setDisplayPercent(boolean r100) {
        this.f450864n = r100;
    }

    public void setShowText(boolean r100) {
        this.f450865o = r100;
    }

    public void setTextColor(int r100) {
        this.f450853c.setColor(r100);
        invalidate();
    }

    public void setTextSize(float r100) {
        Paint r101 = this.f450853c;
        if (r101 == null) goto L6;
        r101.setTextSize(r100);
        invalidate();
        return;
    }

    public FilterBeautySeekBar(Context r100, AttributeSet r101) {
        this(r100, r101, R.attr.seekBarStyle);
    }

    public static float a(Context r100, float r101) {
        Resources r102 = r100.getResources();
        return (r101 * WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density) + 0.5f;
    }

    public FilterBeautySeekBar(Context r100, AttributeSet r110, int r111) {
        super(r100, r110, r111);
        this.f450852b = "";
        this.f450859i = a(getContext(), 10.0f);
        this.f450865o = true;
        TypedArray r112 = r100.getTheme().obtainStyledAttributes(r110, new int[]{com.larus.nova.R.attr.bottomPadding, com.larus.nova.R.attr.defaultDotColor, com.larus.nova.R.attr.defaultDotProgress, com.larus.nova.R.attr.defaultDotRadio, com.larus.nova.R.attr.leftPadding, com.larus.nova.R.attr.rateTextColor, com.larus.nova.R.attr.rateTextFont, com.larus.nova.R.attr.rateTextSize, com.larus.nova.R.attr.rightPadding, com.larus.nova.R.attr.showDefaultDot, com.larus.nova.R.attr.textBaselineHeight, com.larus.nova.R.attr.topPadding}, r111, 0);
        int r113 = r112.getIndexCount();
        int r101 = 0;
        int r102 = 0;
    L4:
        if (r101 >= r113) goto L13;
        int r103 = r112.getIndex(r101);
        if (r103 != 5) goto L9;
        r102 = r112.getColor(r103, -1);
    L11:
        r101 = r101 + 1;
        goto L4
    L9:
        if (r103 != 7) goto L11;
        this.f450851a = r112.getDimension(r103, 15.0f);
        goto L11
    L13:
        if (r112.hasValue(4) == false) goto L15;
        this.f450855e = r112.getDimension(4, 0.0f);
    L17:
        if (r112.hasValue(8) == false) goto L19;
        this.f450856f = r112.getDimension(8, 0.0f);
    L21:
        if (r112.hasValue(11) == false) goto L23;
        this.f450857g = r112.getDimension(11, 0.0f);
    L25:
        if (r112.hasValue(0) == false) goto L27;
        this.f450858h = r112.getDimension(0, 0.0f);
    L29:
        if (r112.hasValue(10) == false) goto L31;
        this.f450859i = r112.getDimension(10, 10.0f);
    L31:
        this.f450860j = r112.getBoolean(9, false);
        this.f450861k = r112.getInt(2, -1);
        int r104 = r112.getColor(1, -1);
        this.f450862l = r112.getFloat(3, 2.5f);
        String r114 = r112.getString(6);
        r112.recycle();
        Paint r115 = new Paint();
        this.f450853c = r115;
        r115.setAntiAlias(true);
        r115.setColor(r102);
        if (TextUtils.isEmpty(r114) == true) goto L37;
        Typeface r116 = StyleCentre.a(r114);
        if (r116 != null) goto L36;
        r116 = Typeface.defaultFromStyle(1);
    L36:
        r115.setTypeface(r116);
    L43:
        r115.setTextSize(this.f450851a);
        Rect r117 = new Rect();
        String r105 = String.valueOf(getProgress());
        this.f450852b = r105;
        r115.getTextBounds(r105, 0, r105.length(), r117);
        Paint r118 = new Paint();
        this.f450863m = r118;
        r118.setAntiAlias(true);
        r118.setColor(r104);
        setPadding((int) this.f450855e, (int) this.f450857g, (int) this.f450856f, (int) this.f450858h);
        getViewTreeObserver().addOnGlobalLayoutListener(new AnonymousClass1(this));
        return;
    L37:
        FontType r119 = FontType.MEDIUM;
        KProperty[] r106 = StyleCentre.f454921a;
        Intrinsics.checkNotNullParameter(r119, "fontType");
        StyleCentre r107 = StyleCentre.f454924d;
        r107.getClass();
        b r108 = (b) StyleCentre.f454922b.getValue(r107, StyleCentre.f454921a[0]);
        if (r108 == null) goto L40;
        r119.getVALUE();
        Typeface r120 = r108.a();
    L41:
        if (r120 == null) goto L43;
        r115.setTypeface(r120);
        goto L43
    L40:
        r120 = null;
        goto L41
    L27:
        this.f450858h = this.f450857g;
        goto L29
    L23:
        this.f450857g = a(r100, 13.0f);
        goto L25
    L19:
        this.f450856f = this.f450855e;
        goto L21
    L15:
        this.f450855e = a(r100, 10.0f);
        goto L17
    }
}
