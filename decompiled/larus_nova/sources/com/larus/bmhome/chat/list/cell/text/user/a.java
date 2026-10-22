package com.larus.bmhome.chat.list.cell.text.user;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: classes25.dex */
public final class a extends ReplacementSpan {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final float f306435f = 0.0f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f306436g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Typeface f306437h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f306438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f306439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f306440c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f306441d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Drawable f306442e;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.list.cell.text.user.a$a, reason: collision with other inner class name */
    public static final class C4062a {
    }

    static {
        Integer r100 = 17;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        float r101 = r100.floatValue();
        Resources r102 = Resources.getSystem();
        f306435f = r101 * WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).scaledDensity;
        f306436g = c7.e(Float.valueOf(25.5f));
        f306437h = Typeface.create("sans-serif-medium", 0);
    }

    public final void a(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "icon");
        this.f306442e = r100;
        this.f306441d = true;
    }

    public /* synthetic */ a(Drawable r100, int r101, int r102) {
        this(r100, r101, r102, false, false);
    }

    public a(Drawable r100, int r101, int r102, boolean r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "icon");
        this.f306438a = r101;
        this.f306439b = r102;
        this.f306440c = r103;
        this.f306441d = r104;
        this.f306442e = r100;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r110, Paint.FontMetricsInt r111) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        Intrinsics.checkNotNullParameter(r101, "text");
        float r103 = r100.getTextSize();
        Typeface r104 = r100.getTypeface();
        float r105 = r100.getLetterSpacing();
        r100.setTextSize(f306435f);
        r100.setTypeface(f306437h);
        r100.setLetterSpacing(0.0f);
        if (r111 != null) goto L18;
    L5:
        int r112 = this.f306438a + this.f306439b;     // Catch: Throwable -> L11
        if (this.f306440c == false) goto L13;
        if (r102 >= r110) goto L13;
        if (r101.charAt(r102) != '@') goto L13;
        r102 = r102 + 1;     // Catch: Throwable -> L11
    L13:
        int r113 = r112 + ((int) r100.measureText(r101, r102, r110));
        r100.setTextSize(r103);
        r100.setTypeface(r104);
        r100.setLetterSpacing(r105);
        return r113;
    L11:
        th = move-exception;
        r100.setTextSize(r103);
        r100.setTypeface(r104);
        r100.setLetterSpacing(r105);
        throw th;
    L18:
        Paint.FontMetricsInt r106 = r100.getFontMetricsInt();     // Catch: Throwable -> L11
        int r107 = f306436g;     // Catch: Throwable -> L11
        int r108 = r106.descent;     // Catch: Throwable -> L11
        int r109 = r106.ascent;     // Catch: Throwable -> L11
        int r114 = r109 - ((r107 - (r108 - r109)) / 2);     // Catch: Throwable -> L11
        r111.ascent = r114;     // Catch: Throwable -> L11
        int r115 = r107 + r114;     // Catch: Throwable -> L11
        r111.descent = r115;     // Catch: Throwable -> L11
        r111.top = r114;     // Catch: Throwable -> L11
        r111.bottom = r115;     // Catch: Throwable -> L11
        r111.leading = 0;     // Catch: Throwable -> L11
        goto L5
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r110, CharSequence r111, int r112, int r113, float r114, int r210, int r211, int r212, Paint r213) {
        int r100 = r112;
        Intrinsics.checkNotNullParameter(r110, "canvas");
        Intrinsics.checkNotNullParameter(r111, "text");
        Intrinsics.checkNotNullParameter(r213, "paint");
        float r115 = r213.getTextSize();
        Typeface r116 = r213.getTypeface();
        float r117 = r213.getLetterSpacing();
        r213.setTextSize(f306435f);
        r213.setTypeface(f306437h);
        r213.setLetterSpacing(0.0f);
    L20:
        th = move-exception;
        r213.setTextSize(r115);
        r213.setTypeface(r116);
        r213.setLetterSpacing(r117);
        throw th;
    L4:
        if (this.f306440c == true) goto L6;
    L8:
        float r101 = r211 + (((r213.getFontMetrics().ascent + r213.getFontMetrics().descent) - this.f306438a) / 2.0f);     // Catch: Throwable -> L20
        r110.save();     // Catch: Throwable -> L20
        r110.translate(r114, r101);     // Catch: Throwable -> L20
        Drawable r102 = this.f306442e;     // Catch: Throwable -> L20
        int r103 = this.f306438a;     // Catch: Throwable -> L20
        r102.setBounds(0, 0, r103, r103);     // Catch: Throwable -> L20
        this.f306442e.draw(r110);     // Catch: Throwable -> L20
        r110.restore();     // Catch: Throwable -> L20
    L10:
        if (this.f306440c == false) goto L17;
        if (r100 >= r113) goto L17;
        if (r111.charAt(r112) != '@') goto L17;
        r100 = r100 + 1;     // Catch: Throwable -> L20
    L17:
        r110.drawText(r111, r100, r113, this.f306439b + (this.f306438a + r114), r211, r213);     // Catch: Throwable -> L20
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L20
        r213.setTextSize(r115);
        r213.setTypeface(r116);
        r213.setLetterSpacing(r117);
        return;
    L6:
        if (this.f306441d == true) goto L8;
        r110.drawText("@", r114, r211, r213);     // Catch: Throwable -> L20
        goto L10
    }
}
