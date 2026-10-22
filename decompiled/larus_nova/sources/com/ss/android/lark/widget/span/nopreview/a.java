package com.ss.android.lark.widget.span.nopreview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.TypedValue;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes38.dex */
public final class a extends Drawable {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f448735k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f448736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f448737b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f448738c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f448739d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f448740e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f448741f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextPaint f448742g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Paint f448743h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final RectF f448744i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final StaticLayout f448745j;

    /* JADX INFO: renamed from: com.ss.android.lark.widget.span.nopreview.a$a, reason: collision with other inner class name */
    public static final class C5434a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f448746a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f448747b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f448748c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f448749d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f448750e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f448751f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f448752g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f448753h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public float f448754i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f448755j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final int f448756k;

        /* JADX INFO: renamed from: com.ss.android.lark.widget.span.nopreview.a$a$a, reason: collision with other inner class name */
        public static final class C5435a {
        }

        static {
        }

        public final a a() {
            return new a(this.f448747b, this.f448748c, this.f448749d, this.f448750e, this.f448751f, this.f448752g, this.f448753h, this.f448754i, this.f448755j, this.f448756k, this.f448746a);
        }

        public C5434a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f448746a = r100;
            this.f448747b = UDColorUtils.getColor(r100, R.color.bg_float_overlay);
            this.f448748c = UDColorUtils.getColor(r100, R.color.text_placeholder);
            Resources r101 = r100.getResources();
            this.f448749d = TypedValue.applyDimension(2, 16, WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()));
            this.f448750e = rec.a.a(r100, 200);
            this.f448751f = rec.a.a(r100, 120);
            this.f448752g = "";
            this.f448755j = UDColorUtils.getColor(r100, R.color.line_border_card);
            this.f448756k = 3;
        }
    }

    public static final class b {
        @JvmStatic
        public static C5434a a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return new C5434a(r100);
        }
    }

    static {
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        if (this.f448742g.getAlpha() >= 255) goto L6;
        return -3;
    L6:
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.f448738c;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.f448737b;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        r100.save();
        this.f448744i.set(getBounds());
        RectF r101 = this.f448744i;
        float r102 = this.f448739d;
        r101.inset(r102, r102);
        this.f448743h.setColor(a(this.f448736a, this.f448742g.getAlpha()));
        this.f448743h.setStyle(Paint.Style.FILL);
        RectF r103 = this.f448744i;
        float r104 = this.f448740e;
        r100.drawRoundRect(r103, r104, r104, this.f448743h);
        RectF r105 = this.f448744i;
        float r106 = (-this.f448739d) / 2;
        r105.inset(r106, r106);
        this.f448743h.setColor(a(this.f448741f, this.f448742g.getAlpha()));
        this.f448743h.setStyle(Paint.Style.STROKE);
        this.f448743h.setStrokeWidth(this.f448739d);
        RectF r107 = this.f448744i;
        float r108 = this.f448740e;
        r100.drawRoundRect(r107, r108, r108, this.f448743h);
        r100.restore();
        r100.save();
        r100.translate((this.f448737b - this.f448745j.getWidth()) / 2.0f, (this.f448738c - this.f448745j.getHeight()) / 2.0f);
        this.f448745j.draw(r100);
        r100.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
        this.f448742g.setAlpha(r100);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
        this.f448742g.setColorFilter(r100);
        invalidateSelf();
    }

    public static int a(int r100, int r101) {
        return Color.argb(MathKt.roundToInt((r101 / 255.0f) * Color.alpha(r100)), Color.red(r100), Color.green(r100), Color.blue(r100));
    }

    public a(int r110, int r111, float r112, int r113, int r114, String r210, float r211, float r212, int r213, int r214, Context r215) {
        this.f448736a = r110;
        this.f448737b = r113;
        this.f448738c = r114;
        this.f448739d = r211;
        this.f448740e = r212;
        this.f448741f = r213;
        TextPaint r100 = new TextPaint();
        r100.setTextSize(r112);
        r100.setAntiAlias(true);
        r100.setColor(r111);
        this.f448742g = r100;
        Paint r101 = new Paint();
        r101.setAntiAlias(true);
        this.f448743h = r101;
        this.f448744i = new RectF();
        int r102 = Math.max(r113 - (rec.a.a(r215, 12) * 2), 0);
        int r103 = Build.VERSION.SDK_INT;
        if (r103 < 23) goto L8;
        StaticLayout.Builder r104 = StaticLayout.Builder.obtain(r210, 0, r210.length(), r100, r102).setAlignment(Layout.Alignment.ALIGN_CENTER).setIncludePad(false).setLineSpacing(0.0f, 1.0f).setEllipsize(TextUtils.TruncateAt.END).setEllipsizedWidth(r102).setMaxLines(r214);
        if (r103 < 29) goto L7;
        r104.setBreakStrategy(2);
    L7:
        StaticLayout r105 = r104.build();
    L9:
        this.f448745j = r105;
        setBounds(0, 0, r113, r114);
        return;
    L8:
        r105 = new StaticLayout(r210, r100, r102, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
        goto L9
    }
}
