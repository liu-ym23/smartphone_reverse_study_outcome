package com.bytedance.android.shopping.deepfeed.slice.view.customview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.view.View;
import com.bytedance.android.ec.core.utils.font.ECFontHelper;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CharIterator;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.CharRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c extends View {
    public final Paint a;
    public final Paint b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public boolean k;
    public boolean l;
    public float m;
    public float n;
    public float o;
    public float p;
    public float q;
    public float r;
    public float s;
    public long t;
    public boolean u;
    public Paint.Align v;
    public ValueAnimator w;
    public boolean x;
    public g y;
    public final SlcTemplateContext z;

    public static final class a {
    }

    static {
    }

    public final float g() {
        return RangesKt.coerceIn(this.t / 200, 0.0f, 1.0f);
    }

    public final boolean i() {
        String r0 = this.j;
        int r2 = 0;
    L4:
        if (r2 >= r0.length()) goto L15;
        if (r0.charAt(r2) == 0) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == true) goto L10;
        r2 = r2 + 1;
        goto L4
    L10:
        return true;
    L8:
        r3 = false;
        goto L9
    L15:
        return false;
    }

    public final boolean j() {
        String r0 = this.i;
        int r2 = 0;
    L4:
        if (r2 >= r0.length()) goto L15;
        if (r0.charAt(r2) == 0) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == true) goto L10;
        r2 = r2 + 1;
        goto L4
    L10:
        return true;
    L8:
        r3 = false;
        goto L9
    L15:
        return false;
    }

    public final String l() {
        if (this.k == true) goto L8;
        if (this.l == false) goto L8;
        return StringsKt.repeat("0", RangesKt.coerceAtMost(this.d.length(), 2));
    L8:
        return this.f;
    }

    public final void o() {
        Paint.FontMetrics r0 = this.a.getFontMetrics();
        Paint.FontMetrics r1 = this.b.getFontMetrics();
        float r2 = r0.bottom;
        float r3 = r0.top;
        this.o = r2 - r3;
        float r4 = r1.bottom;
        float r5 = r1.top;
        this.p = r4 - r5;
        float r6 = Math.max(-r3, -r5);
        this.q = r6;
        this.r = r6 + Math.max(r0.bottom, r1.bottom);
        CharIterator r7 = new CharRange('0', '9').iterator();
        if (r7.hasNext() == false) goto L19;
        CharIterator r8 = r7;
        char r9 = r8.nextChar();
        float r10 = this.a.measureText(String.valueOf(r9));
    L6:
        if (r7.hasNext() == false) goto L8;
        char r11 = r8.nextChar();
        r10 = Math.max(r10, this.a.measureText(String.valueOf(r11)));
        goto L6
    L8:
        this.m = RangesKt.coerceAtLeast(r10, this.a.measureText("."));
        CharIterator r12 = new CharRange('0', '9').iterator();
        if (r12.hasNext() == false) goto L17;
        CharIterator r13 = r12;
        char r14 = r13.nextChar();
        float r15 = this.b.measureText(String.valueOf(r14));
    L12:
        if (r12.hasNext() == false) goto L14;
        char r16 = r13.nextChar();
        r15 = Math.max(r15, this.b.measureText(String.valueOf(r16)));
        goto L12
    L14:
        this.n = RangesKt.coerceAtLeast(r15, this.b.measureText("."));
        return;
    L17:
        throw new NoSuchElementException();
    L19:
        throw new NoSuchElementException();
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        ValueAnimator r0 = this.w;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.x = true;
        this.s = 1.0f;
        this.t = Long.MAX_VALUE;
        requestLayout();
        invalidate();
        this.w = null;
        super.onDetachedFromWindow();
    }

    public static String m(String r1) {
        if (r1 == null) goto L4;
        String r2 = StringsKt.trim(r1).toString();
    L5:
        if (r2 != null) goto L8;
        r2 = "";
    L8:
        if (r2.length() != 0) goto L10;
        boolean r0 = true;
    L11:
        if (r0 == false) goto L14;
        return "0";
    L14:
        return r2;
    L10:
        r0 = false;
        goto L11
    L4:
        r2 = null;
        goto L5
    }

    public final float k(float r4) {
        int r0 = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int r1 = d.a[this.v.ordinal()];
        if (r1 == 1) goto L9;
        if (r1 == 2) goto L11;
        return getPaddingLeft() + ((r0 - r4) / 2.0f);
    L11:
        return (getPaddingLeft() + r0) - r4;
    L9:
        return getPaddingLeft();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r12) {
        Intrinsics.checkNotNullParameter(r12, "canvas");
        super.onDraw(r12);
        boolean r1 = true;
        if (this.c.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == true) goto L15;
        return;
    L15:
        if (this.x == true) goto L27;
        String r3 = l();
        boolean r4 = this.k;
        if (r4 == true) goto L23;
        if (r4 == false) goto L20;
    L22:
        boolean r5 = false;
    L24:
        String r6 = this.e;
        f(r12, r6, r3, r5, k(n(r6, r3, r5, false)));
        return;
    L20:
        if (this.l == false) goto L22;
    L23:
        r5 = true;
        goto L24
    L27:
        if (this.s < 1.0f) goto L29;
    L54:
        String r7 = this.c;
        String r8 = this.d;
        boolean r9 = this.l;
        f(r12, r7, r8, r9, k(n(r7, r8, r9, false)));
        return;
    L29:
        if (this.g.length() != 0) goto L31;
        boolean r10 = true;
    L32:
        if (r10 == true) goto L34;
    L41:
        boolean r11 = j();
        boolean r13 = i();
        float r14 = k(n(this.g, this.i, r11, false));
        float r15 = r14 + ((k(n(this.h, this.j, r13, false)) - r14) * RangesKt.coerceIn((this.t - 70) / 200, 0.0f, 1.0f));
        float r16 = getPaddingTop() + this.q;
        float r17 = c(r12, this.g, this.h, r15, r16, false);
        if (r11 == true) goto L44;
        if (r13 == true) goto L44;
        return;
    L44:
        boolean r18 = j();
        boolean r19 = i();
        if (r18 == false) goto L48;
        if (r19 == false) goto L48;
        r12.drawText(".", r17, r16, this.b);
    L52:
        c(r12, this.i, this.j, r17 + this.b.measureText("."), r16, true);
        return;
    L48:
        if (r18 == false) goto L50;
        d(r12, '.', r17, r16, 1.0f - g(), this.b);
        goto L52
    L50:
        if (r19 == false) goto L52;
        d(r12, '.', r17, r16, g(), this.b);
        goto L52
    L34:
        if (this.i.length() == 0) goto L37;
        r1 = false;
    L37:
        if (r1 == false) goto L41;
        if (this.k == true) goto L41;
    L31:
        r10 = false;
        goto L32
    L8:
        if (this.l == true) goto L11;
        r2 = false;
        goto L12
    L5:
        r0 = false;
        goto L6
    }

    public c(Context r3, SlcTemplateContext r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "slcTemplateContext");
        super(r3, null, 0);
        this.z = r4;
        Paint r5 = new Paint(1);
        r5.setColor(ColorProtector.parseColor("#FF161823"));
        r5.setTextAlign(Paint.Align.LEFT);
        Unit r1 = Unit.INSTANCE;
        this.a = r5;
        Paint r6 = new Paint(1);
        r6.setColor(ColorProtector.parseColor("#FF161823"));
        r6.setTextAlign(Paint.Align.LEFT);
        this.b = r6;
        this.c = "";
        this.d = "";
        this.e = "";
        this.f = "";
        this.g = "";
        this.h = "";
        this.i = "";
        this.j = "";
        this.s = 1.0f;
        this.u = true;
        this.v = Paint.Align.CENTER;
        this.x = true;
    }

    public static BigDecimal b(String r5, String r6) {
        if (r5 == null) goto L49;
        String r7 = StringsKt.trim(r5).toString();
        if (r6 == null) goto L47;
        String r8 = StringsKt.take(StringsKt.trim(r6).toString(), 2);
        boolean r2 = false;
        if (r7.length() != 0) goto L9;
        boolean r1 = true;
    L10:
        Object r4 = null;
        if (r1 == false) goto L19;
        if (r8.length() != 0) goto L15;
        boolean r3 = true;
    L16:
        if (r3 == false) goto L19;
        return null;
    L15:
        r3 = false;
    L19:
        if (r7.length() != 0) goto L21;
        boolean r9 = true;
    L22:
        if (r9 == false) goto L25;
        r7 = "0";
    L28:
        if (r8.length() != 0) goto L30;
        r2 = true;
    L30:
        if (r2 == true) goto L50;
        r7 = r7 + '.' + r8;
    L50:
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L38
        if (r7 == null) goto L37;
        Object r11 = Result.constructor-impl(new BigDecimal(StringsKt.trim(r7).toString()));     // Catch: Throwable -> L38
    L41:
        if (Result.isFailure-impl(r11) == true) goto L45;
        r4 = r11;
    L45:
        return (BigDecimal) r4;
    L37:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L41
    L25:
        if (Intrinsics.areEqual(r7, "-") == false) goto L28;
        r7 = "-0";
        goto L28
    L21:
        r9 = false;
        goto L22
    L9:
        r1 = false;
        goto L10
    L47:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L49:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    public static void p(Paint r3, Integer r4) {
        if (r4 == null) goto L4;
        int r5 = r4.intValue();
    L5:
        Typeface r0 = ECFontHelper.e.b("DouyinNumberABC", r5, false);
        if (r0 == null) goto L8;
    L14:
        r3.setTypeface(r0);
        return;
    L8:
        if (Build.VERSION.SDK_INT < 28) goto L11;
        r0 = Typeface.create(Typeface.DEFAULT, r5, false);
        goto L14
    L11:
        if (r5 < 600) goto L13;
        r0 = Typeface.DEFAULT_BOLD;
        goto L14
    L13:
        r0 = Typeface.DEFAULT;
        goto L14
    L4:
        r5 = 400;
        goto L5
    }

    public final List<Character> h(char r6, char r7) {
        int r8 = r6 - '0';
        int r9 = r7 - '0';
        if (this.u == false) goto L5;
        int r10 = ((r9 - r8) + 10) % 10;
    L6:
        if (r10 != 0) goto L8;
        r10 = 10;
    L8:
        IntRange r0 = new IntRange(0, r10);
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        IntIterator r1 = r0.iterator();
    L10:
        if (r1.hasNext() == false) goto L17;
        int r3 = r1.nextInt();
        if (this.u == false) goto L14;
        int r4 = r3 + r8;
    L15:
        r11.add(Character.valueOf((char) ((r4 % 10) + 48)));
        goto L10
    L14:
        r4 = (r8 - r3) + 10;
        goto L15
    L17:
        if (r11.size() > 5) goto L20;
        return r11;
    L20:
        return CollectionsKt.listOfNotNull(new Character[]{(Character) CollectionsKt.getOrNull(r11, 0), (Character) CollectionsKt.getOrNull(r11, 1), (Character) CollectionsKt.getOrNull(r11, r11.size() - 3), (Character) CollectionsKt.getOrNull(r11, r11.size() - 2), (Character) CollectionsKt.getOrNull(r11, r11.size() - 1)});
    L5:
        r10 = ((r8 - r9) + 10) % 10;
        goto L6
    }

    @Override // android.view.View
    public final void onMeasure(int r9, int r10) {
        o();
        boolean r3 = false;
        float r0 = n(this.c, this.d, this.l, false);
        String r1 = this.e;
        String r2 = l();
        boolean r4 = this.k;
        if (r4 == true) goto L9;
        if (r4 == false) goto L6;
    L8:
        boolean r5 = false;
    L10:
        float r6 = Math.max(n(r1, r2, r5, false), Math.max(n(this.g, this.i, j(), true), n(this.h, this.j, i(), true)));
        if (this.x == true) goto L13;
    L14:
        r3 = true;
    L15:
        if (r3 == false) goto L17;
        r0 = Math.max(r0, r6);
    L17:
        int r7 = (((int) r0) + getPaddingLeft()) + getPaddingRight();
        int r8 = (((int) this.r) + getPaddingTop()) + getPaddingBottom();
        setMeasuredDimension(View.resolveSize(r7, r9), View.resolveSize(r8, r10));
        return;
    L13:
        if (this.s >= 1.0f) goto L15;
    L6:
        if (this.l == false) goto L8;
    L9:
        r5 = true;
        goto L10
    }

    public final float a(char r3, boolean r4, boolean r5) {
        if (r4 == false) goto L4;
        Paint r0 = this.b;
    L5:
        if (r3 != 0) goto L10;
        if (r4 == false) goto L18;
        return this.n;
    L18:
        return this.m;
    L10:
        if (Character.isDigit(r3) == false) goto L16;
        if (r5 == false) goto L16;
        if (r4 == false) goto L20;
        return this.n;
    L20:
        return this.m;
    L16:
        return r0.measureText(String.valueOf(r3));
    L4:
        r0 = this.a;
        goto L5
    }

    public final float n(String r9, String r10, boolean r11, boolean r12) {
        int r0 = 0;
        double r1 = 0;
        double r4 = r1;
        int r3 = 0;
    L4:
        if (r3 >= r9.length()) goto L6;
        r4 = r4 + ((double) a(r9.charAt(r3), false, r12));
        r3 = r3 + 1;
        goto L4
    L6:
        float r13 = (float) r4;
        if (r11 == false) goto L13;
        float r14 = this.b.measureText(".");
    L10:
        if (r0 >= r10.length()) goto L12;
        r1 = r1 + ((double) a(r10.charAt(r0), true, r12));
        r0 = r0 + 1;
        goto L10
    L12:
        float r15 = r14 + ((float) r1);
    L15:
        return r13 + r15;
    L13:
        r15 = 0.0f;
        goto L15
    }

    public final float e(Canvas r8, String r9, float r10, float r11, boolean r12) {
        int r1 = 0;
    L4:
        if (r1 >= r9.length()) goto L10;
        char r2 = r9.charAt(r1);
        if (r12 == false) goto L8;
        Paint r3 = this.b;
    L9:
        int r4 = r3.getAlpha();
        r3.setAlpha(RangesKt.coerceIn((int) (r4 * 1.0f), 0, 255));
        r8.drawText(String.valueOf(r2), r10, r11, r3);
        r3.setAlpha(r4);
        r10 = r10 + a(r2, r12, false);
        r1 = r1 + 1;
        goto L4
    L8:
        r3 = this.a;
        goto L9
    L10:
        return r10;
    }

    public final void f(Canvas r10, String r11, String r12, boolean r13, float r14) {
        float r7 = getPaddingTop() + this.q;
        float r8 = e(r10, r11, r14, r7, false);
        if (r13 == false) goto L6;
        d(r10, '.', r8, r7, 1.0f, this.b);
        e(r10, r12, r8 + this.b.measureText("."), r7, true);
        return;
    }

    public static void d(Canvas r3, char r4, float r5, float r6, float r7, Paint r8) {
        if (r4 != 0) goto L4;
        return;
    L4:
        int r0 = r8.getAlpha();
        r8.setAlpha(RangesKt.coerceIn((int) (r0 * r7), 0, 255));
        r3.drawText(String.valueOf(r4), r5, r6, r8);
        r8.setAlpha(r0);
    }

    public final float c(Canvas r19, String r20, String r21, float r22, float r23, boolean r24) {
        int r10 = Math.max(r20.length(), r21.length());
        float r12 = r22;
        int r13 = 0;
    L3:
        if (r13 >= r10) goto L51;
        if (r13 >= 0) goto L6;
    L8:
        char r15 = 0;
    L9:
        if (r13 >= 0) goto L11;
    L13:
        char r5 = 0;
    L14:
        if (r24 == false) goto L16;
        Paint r1 = this.b;
    L17:
        Paint r4 = r1;
        if (r15 != 0) goto L20;
        char r11 = r5;
        d(r19, r5, r12, r23, g(), r4);
    L50:
        r12 = r12 + Math.max(a(r15, r24, true), a(r11, r24, true));
        r13 = r13 + 1;
        goto L3
    L20:
        r11 = r5;
        float r2 = 1.0f;
        if (r11 != 0) goto L23;
        d(r19, r15, r12, r23, 1.0f - g(), r4);
        goto L50
    L23:
        if (r15 != r11) goto L26;
        r19.drawText(String.valueOf(r11), r12, r23, r4);
        goto L50
    L26:
        if (Character.isDigit(r15) == true) goto L28;
    L49:
        float r3 = r12;
        d(r19, r15, r3, r23, 1.0f - g(), r4);
        d(r19, r11, r3, r23, g(), r4);
        goto L50
    L28:
        if (Character.isDigit(r11) == false) goto L49;
        List<Character> r6 = h(r15, r11);
        float r7 = this.s * (r6.size() - 1);
        if (this.u == true) goto L34;
        r2 = -1.0f;
    L34:
        if (r4 != this.b) goto L36;
        float r8 = this.p;
    L37:
        Iterator<T> r9 = r6.iterator();
        int r14 = 0;
    L39:
        if (r9.hasNext() == false) goto L50;
        Object r16 = r9.next();
        int r17 = r14 + 1;
        if (r14 >= 0) goto L43;
        CollectionsKt.throwIndexOverflow();
    L43:
        char r18 = ((Character) r16).charValue();
        float r25 = (((r14 - r7) * r8) * r2) + r23;
        float r26 = r2;
        if (r25 <= (-r8)) goto L48;
        if (r25 >= (getHeight() + r8)) goto L48;
        r19.drawText(String.valueOf(r18), r12, r25, r4);
    L48:
        r2 = r26;
        r14 = r17;
        goto L39
    L36:
        r8 = this.o;
        goto L37
    L16:
        r1 = this.a;
        goto L17
    L11:
        if (r13 > StringsKt.getLastIndex(r21)) goto L13;
        r5 = r21.charAt(r13);
        goto L14
    L6:
        if (r13 > StringsKt.getLastIndex(r20)) goto L8;
        r15 = r20.charAt(r13);
        goto L9
    L51:
        return r12;
    }
}
