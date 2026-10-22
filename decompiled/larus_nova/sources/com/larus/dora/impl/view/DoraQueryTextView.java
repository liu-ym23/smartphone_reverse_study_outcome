package com.larus.dora.impl.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.content.res.AppCompatResources;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import v19.c7;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0004\n\u0002\b\u0013\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010*\u001a\u00020+H\u0002J\u0010\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020\u0007H\u0003J\u0018\u0010.\u001a\u00020+2\u0006\u0010/\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u0007H\u0015J \u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u0007H\u0002J \u00104\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u00072\u0006\u00105\u001a\u00020\u0007H\u0002J\u0010\u00106\u001a\u00020+2\u0006\u00107\u001a\u000208H\u0014J\u0010\u00109\u001a\u00020+2\u0006\u00107\u001a\u000208H\u0002J\u0010\u0010:\u001a\u00020+2\u0006\u00107\u001a\u000208H\u0002J\u0010\u0010;\u001a\u00020+2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010<\u001a\u00020+2\u0006\u0010=\u001a\u00020>J\u000e\u0010?\u001a\u00020+2\u0006\u0010@\u001a\u00020\u0007J\u000e\u0010A\u001a\u00020+2\u0006\u0010\u0013\u001a\u00020\u0007J\u0016\u0010B\u001a\u00020+2\u0006\u0010C\u001a\u00020\u00162\u0006\u0010D\u001a\u00020\u0016J(\u0010E\u001a\u00020+2\u0006\u0010F\u001a\u00020\u00072\u0006\u0010G\u001a\u00020\u00072\u0006\u0010H\u001a\u00020\u00072\u0006\u0010I\u001a\u00020\u0007H\u0016J\u000e\u0010J\u001a\u00020+2\u0006\u0010K\u001a\u00020\u0007J\u000e\u0010L\u001a\u00020+2\u0006\u0010M\u001a\u00020\u0012J\u0016\u0010N\u001a\u00020+2\u0006\u0010O\u001a\u00020\u00072\u0006\u0010P\u001a\u00020\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n \u0019*\u0004\u0018\u00010\u00180\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Q"}, d2 = {"Lcom/larus/dora/impl/view/DoraQueryTextView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "text", "", "startImage", "Landroid/graphics/drawable/Drawable;", "imageWidth", "imageHeight", "imageTextSpacing", "isImageVisible", "", "fontWeight", "textColor", "textSize", "", "baseTypeface", "Landroid/graphics/Typeface;", "kotlin.jvm.PlatformType", "lineSpacingMultiplier", "lineSpacingExtra", "paddingLeft", "paddingTop", "paddingRight", "paddingBottom", "textPaint", "Landroid/text/TextPaint;", "staticLayout", "Landroid/text/StaticLayout;", "imageRect", "Landroid/graphics/Rect;", "firstLineText", "remainingText", "textLineHeight", "firstLineWidth", "configTextPaint", "", "splitTextIntoLines", "availableWidth", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "calculateFinalWidth", "parentMode", "parentSize", "calculateFinalHeight", "availableHeight", "onDraw", "canvas", "Landroid/graphics/Canvas;", "drawFirstLine", "drawRemainingLines", "setText", "setTextSize", "dp", "", "setTextColor", "color", "setTextFontWeight", "setLineSpacing", "extra", "multiplier", "setPadding", "left", "top", "right", "bottom", "setStartImage", "resId", "setImageVisible", "visible", "setImageSize", "width", "height", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraQueryTextView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f338206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Drawable f338207b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f338208c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f338209d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f338210e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f338211f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f338212g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f338213h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f338214i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Typeface f338215j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float f338216k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f338217l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f338218m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f338219n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f338220o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final TextPaint f338221p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public StaticLayout f338222q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Rect f338223r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f338224s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f338225t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f338226u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f338227v;

    public DoraQueryTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public DoraQueryTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void a() {
        TextPaint r100 = this.f338221p;
        r100.setColor(this.f338213h);
        r100.setTextSize(this.f338214i);
        r100.setTextAlign(Paint.Align.LEFT);
        r100.setTypeface(this.f338215j);
        boolean r101 = true;
        r100.setAntiAlias(true);
        this.f338226u = r100.descent() - r100.ascent();
        if (Build.VERSION.SDK_INT < 28) goto L6;
        r100.setTypeface(Typeface.create(this.f338215j, this.f338212g, false));
        return;
    L6:
        if (this.f338212g >= 500) goto L9;
        r101 = false;
    L9:
        r100.setFakeBoldText(r101);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.onDraw(r110);
        boolean r100 = true;
        if (this.f338206a.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        return;
    L9:
        if (this.f338211f == true) goto L11;
    L13:
        float r102 = this.f338227v;
    L14:
        float r103 = getWidth() - r102;
        float r104 = 2;
        int r105 = (int) (r103 / r104);
        float r106 = Math.max(this.f338209d, this.f338226u);
        float r107 = this.f338218m;
        float r108 = (r106 / r104) + r107;
        float r109 = r107 - this.f338221p.ascent();
        if (this.f338211f == true) goto L17;
    L24:
        int r111 = this.f338217l;
        if (this.f338211f == true) goto L27;
    L29:
        int r112 = 0;
    L30:
        r110.drawText(this.f338224s, (r111 + r112) + r105, r109, this.f338221p);
        if (this.f338225t.length() == 0) goto L34;
        r100 = false;
    L34:
        if (r100 == false) goto L36;
        return;
    L36:
        if (this.f338222q == null) goto L50;
        float r113 = this.f338218m + RangesKt.coerceAtLeast(this.f338209d, this.f338226u * this.f338216k);
        float r114 = this.f338217l;
        int r115 = r110.save();
        r110.translate(r114, r113);
        StaticLayout r116 = this.f338222q;     // Catch: Throwable -> L43
        if (r116 == null) goto L42;
        r116.draw(r110);     // Catch: Throwable -> L43
    L42:
        r110.restoreToCount(r115);
        return;
    L43:
        th = move-exception;
        r110.restoreToCount(r115);
        throw th;
    L50:
        return;
    L27:
        if (this.f338207b == null) goto L29;
        r112 = this.f338208c + this.f338210e;
        goto L30
    L17:
        if (this.f338207b == null) goto L24;
        int r117 = this.f338209d;
        int r118 = (int) (r108 - (r117 / 2));
        Rect r119 = this.f338223r;
        int r120 = this.f338217l;
        r119.set(r120 + r105, r118, (r120 + this.f338208c) + r105, r117 + r118);
        Drawable r121 = this.f338207b;
        if (r121 == null) goto L21;
        r121.setBounds(this.f338223r);
    L21:
        Drawable r122 = this.f338207b;
        if (r122 == null) goto L24;
        r122.draw(r110);
        goto L24
    L11:
        if (this.f338207b == null) goto L13;
        r102 = (this.f338208c + this.f338210e) + this.f338227v;
        goto L14
    L5:
        r101 = false;
        goto L6
    }

    public final void setImageVisible(boolean r100) {
        this.f338211f = r100;
        invalidate();
        requestLayout();
    }

    public final void setStartImage(int r100) {
        Drawable r101 = AppCompatResources.getDrawable(getContext(), r100);
        this.f338207b = r101;
        if (r101 == null) goto L5;
        r101.setBounds(0, 0, this.f338208c, this.f338209d);
    L5:
        invalidate();
        requestLayout();
    }

    public final void setText(String r100) {
        if (r100 != null) goto L4;
        r100 = "";
    L4:
        this.f338206a = r100;
        invalidate();
        requestLayout();
    }

    public final void setTextColor(int r100) {
        this.f338213h = r100;
        a();
        invalidate();
    }

    public final void setTextFontWeight(int r100) {
        this.f338212g = RangesKt.coerceIn(r100, 100, 900);
        a();
        invalidate();
    }

    public final void setTextSize(Number r100) {
        Intrinsics.checkNotNullParameter(r100, "dp");
        this.f338214i = c7.c(r100);
        a();
        invalidate();
        requestLayout();
    }

    public final void b(int r100, int r101) {
        this.f338208c = RangesKt.coerceAtLeast(r100, 0);
        this.f338209d = RangesKt.coerceAtLeast(r101, 0);
        Drawable r102 = this.f338207b;
        if (r102 == null) goto L5;
        r102.setBounds(0, 0, r100, r101);
    L5:
        invalidate();
        requestLayout();
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r110) {
        super.onMeasure(r100, r110);
        int r101 = View.MeasureSpec.getSize(r100);
        int r111 = View.MeasureSpec.getSize(r110);
        int r102 = (r101 - this.f338217l) - this.f338219n;
        int r112 = (r111 - this.f338218m) - this.f338220o;
        boolean r103 = true;
        int r104 = 0;
        if (this.f338206a.length() != 0) goto L5;
        boolean r105 = true;
    L6:
        float r106 = 0.0f;
        String r107 = "";
        if (r105 == false) goto L10;
        this.f338224s = "";
        this.f338225t = "";
        this.f338227v = 0.0f;
    L31:
        if (this.f338211f == true) goto L33;
    L35:
        float r108 = this.f338227v;
    L36:
        StaticLayout r109 = this.f338222q;
        if (r109 == null) goto L39;
        r106 = r109.getWidth();
    L39:
        int r113 = RangesKt.coerceAtMost((int) RangesKt.coerceAtLeast(r108, r106), r102);
        if (this.f338211f == true) goto L42;
    L44:
        float r114 = this.f338226u * this.f338216k;
    L45:
        int r115 = (int) r114;
        StaticLayout r116 = this.f338222q;
        if (r116 == null) goto L48;
        r104 = r116.getHeight();
    L48:
        setMeasuredDimension((r113 + this.f338217l) + this.f338219n, (RangesKt.coerceAtMost(r115 + r104, r112) + this.f338218m) + this.f338220o);
        return;
    L42:
        if (this.f338207b == null) goto L44;
        r114 = RangesKt.coerceAtLeast(this.f338209d, this.f338226u * this.f338216k);
        goto L45
    L33:
        if (this.f338207b == null) goto L35;
        r108 = (this.f338208c + this.f338210e) + this.f338227v;
        goto L36
    L10:
        if (this.f338211f == true) goto L12;
    L14:
        int r117 = 0;
    L15:
        String r118 = this.f338206a;
        StaticLayout r119 = StaticLayout.Builder.obtain(r118, 0, r118.length(), this.f338221p, r102 - r117).setLineSpacing(0.0f, this.f338216k).setIncludePad(false).build();
        if (r119.getLineCount() <= 0) goto L18;
        int r120 = r119.getLineEnd(0);
    L19:
        this.f338224s = this.f338206a.substring(0, r120);
        if (r120 >= this.f338206a.length()) goto L22;
        r107 = this.f338206a.substring(r120);
    L22:
        this.f338225t = r107;
        this.f338227v = this.f338221p.measureText(this.f338224s);
        if (this.f338225t.length() > 0) goto L26;
        r103 = false;
    L26:
        if (r103 == false) goto L28;
        String r121 = this.f338225t;
        StaticLayout r122 = StaticLayout.Builder.obtain(r121, 0, r121.length(), this.f338221p, r102).setLineSpacing(0.0f, this.f338216k).setAlignment(Layout.Alignment.ALIGN_CENTER).setIncludePad(false).build();
    L29:
        this.f338222q = r122;
        goto L31
    L28:
        r122 = null;
        goto L29
    L18:
        r120 = 0;
        goto L19
    L12:
        if (this.f338207b == null) goto L14;
        r117 = this.f338208c + this.f338210e;
        goto L15
    L5:
        r105 = false;
        goto L6
    }

    public DoraQueryTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f338206a = "";
        this.f338210e = c7.b(3);
        this.f338211f = true;
        this.f338212g = 400;
        this.f338213h = -16777216;
        this.f338214i = c7.c(17);
        this.f338215j = Typeface.create("PingFang SC", 0);
        this.f338216k = 1.2f;
        this.f338221p = new TextPaint(1);
        this.f338223r = new Rect();
        this.f338224s = "";
        this.f338225t = "";
        a();
    }

    public /* synthetic */ DoraQueryTextView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void setPadding(int r100, int r101, int r102, int r103) {
        this.f338217l = r100;
        this.f338218m = r101;
        this.f338219n = r102;
        this.f338220o = r103;
        invalidate();
        requestLayout();
    }
}
