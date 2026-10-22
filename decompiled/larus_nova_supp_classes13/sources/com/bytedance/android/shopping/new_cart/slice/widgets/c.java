package com.bytedance.android.shopping.new_cart.slice.widgets;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.bytedance.android.ec.core.utils.font.ECFontHelper;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.util.SlcDimensExtensionsKt;
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
    public String b;
    public String c;
    public float d;
    public float e;
    public float f;
    public float g;
    public long h;
    public boolean i;
    public Paint.Align j;
    public ValueAnimator k;
    public final SlcTemplateContext l;

    public static final class a {
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ c a;

        public b(c r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r4) {
            c r0 = this.a;
            Object r1 = r4.getAnimatedValue();
            if (r1 == null) goto L7;
            r0.g = ((Float) r1).floatValue();
            c r2 = this.a;
            r2.h = r4.getCurrentPlayTime();
            this.a.invalidate();
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    static {
    }

    public final float e() {
        return RangesKt.coerceIn(this.h / 200, 0.0f, 1.0f);
    }

    public final void j() {
        Paint.FontMetrics r0 = this.a.getFontMetrics();
        float r1 = r0.bottom;
        float r2 = r0.top;
        this.e = r1 - r2;
        this.f = -r2;
        CharIterator r3 = new CharRange('0', '9').iterator();
        if (r3.hasNext() == false) goto L11;
        CharIterator r4 = r3;
        char r5 = r4.nextChar();
        float r6 = this.a.measureText(String.valueOf(r5));
    L6:
        if (r3.hasNext() == false) goto L8;
        char r7 = r4.nextChar();
        r6 = Math.max(r6, this.a.measureText(String.valueOf(r7)));
        goto L6
    L8:
        this.d = RangesKt.coerceAtLeast(r6, this.a.measureText("."));
        return;
    L11:
        throw new NoSuchElementException();
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        ValueAnimator r0 = this.k;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.k = null;
        super.onDetachedFromWindow();
    }

    public static String b(String r2) {
        if (r2 == null) goto L4;
        String r3 = StringsKt.trim(r2).toString();
    L5:
        String r4 = r3;
        if (r3 != null) goto L9;
        r4 = "";
    L9:
        if (r4.length() != 0) goto L11;
        boolean r1 = true;
    L12:
        if (r1 == false) goto L23;
        return "";
    L23:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L16
        Object r5 = Result.constructor-impl(new BigDecimal(r4).movePointLeft(2).stripTrailingZeros().toPlainString());     // Catch: Throwable -> L16
    L18:
        Object r6 = r4;
        if (Result.exceptionOrNull-impl(r5) != null) goto L22;
        r6 = r5;
    L22:
        return (String) r6;
    L16:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    L11:
        r1 = false;
        goto L12
    L4:
        r3 = null;
        goto L5
    }

    public static BigDecimal i(String r1) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        if (r1 == null) goto L6;
        Object r2 = Result.constructor-impl(new BigDecimal(StringsKt.trim(r1).toString()));     // Catch: Throwable -> L7
    L10:
        if (Result.isFailure-impl(r2) == false) goto L13;
        r2 = null;
    L13:
        return (BigDecimal) r2;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public final float c(char r2) {
        if (r2 != 0) goto L5;
        return this.d;
    L5:
        if (Character.isDigit(r2) == false) goto L8;
        return this.d;
    L8:
        return this.a.measureText(String.valueOf(r2));
    }

    public final float g(String r4) {
        int r0 = (getWidth() - getPaddingLeft()) - getPaddingRight();
        float r5 = h(r4);
        int r1 = d.a[this.j.ordinal()];
        if (r1 == 1) goto L9;
        if (r1 == 2) goto L11;
        return getPaddingLeft() + ((r0 - r5) / 2.0f);
    L11:
        return (getPaddingLeft() + r0) - r5;
    L9:
        return getPaddingLeft();
    }

    public final float h(String r6) {
        int r0 = 0;
        double r1 = 0;
    L4:
        if (r0 >= r6.length()) goto L7;
        r1 = r1 + ((double) c(r6.charAt(r0)));
        r0 = r0 + 1;
        goto L4
    L7:
        return (float) r1;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r20) {
        Intrinsics.checkNotNullParameter(r20, "canvas");
        super.onDraw(r20);
        boolean r1 = true;
        if (this.b.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        float r9 = 1.0f;
        if (this.g < 1.0f) goto L11;
    L53:
        String r2 = this.b;
        float r3 = g(r2);
        int r4 = this.a.getAlpha();
        int r8 = 0;
        this.a.setAlpha(RangesKt.coerceIn((int) (r4 * 1.0f), 0, 255));
        float r5 = getPaddingTop() + this.f;
    L55:
        if (r8 >= r2.length()) goto L57;
        char r6 = r2.charAt(r8);
        r20.drawText(String.valueOf(r6), r3, r5, this.a);
        r3 = r3 + c(r6);
        r8 = r8 + 1;
        goto L55
    L57:
        this.a.setAlpha(r4);
        return;
    L11:
        if (this.c.length() == 0) goto L14;
        r1 = false;
    L14:
        if (r1 == true) goto L53;
        int r10 = Math.max(this.b.length(), this.c.length());
        String r11 = StringsKt.padStart(this.c, r10, 0);
        String r12 = StringsKt.padStart(this.b, r10, 0);
        float r7 = g(r11);
        float r13 = r7 + ((g(r12) - r7) * RangesKt.coerceIn((this.h - 70) / 200, 0.0f, 1.0f));
        float r14 = getPaddingTop() + this.f;
        float r15 = r13;
        int r16 = 0;
    L17:
        if (r16 >= r10) goto L52;
        char r17 = r11.charAt(r16);
        char r18 = r12.charAt(r16);
        if (r17 != 0) goto L22;
        char r19 = r18;
        char r110 = r17;
        d(r20, r18, r15, r14, e());
    L21:
        char r111 = r110;
    L51:
        r15 = r15 + Math.max(c(r111), c(r19));
        r16 = r16 + 1;
        r10 = r10;
        r9 = 1.0f;
        goto L17
    L22:
        r19 = r18;
        r110 = r17;
        if (r19 != 0) goto L26;
        d(r20, r110, r15, r14, r9 - e());
        goto L21
    L26:
        if (r110 != r19) goto L30;
        r20.drawText(String.valueOf(r19), r15, r14, this.a);
    L28:
        r111 = r110;
        goto L51
    L30:
        if (Character.isDigit(r110) == true) goto L32;
    L50:
        float r21 = r15;
        r111 = r110;
        d(r20, r110, r21, r14, 1.0f - e());
        d(r20, r19, r21, r14, e());
        goto L51
    L32:
        if (Character.isDigit(r19) == false) goto L50;
        List<Character> r22 = f(r110, r19);
        float r23 = this.g * (r22.size() - 1);
        if (this.i == false) goto L36;
        float r24 = 1.0f;
    L37:
        Iterator r25 = r22.iterator();
        int r26 = 0;
    L39:
        if (r25.hasNext() == false) goto L28;
        Object r27 = r25.next();
        int r112 = r26 + 1;
        if (r26 >= 0) goto L43;
        CollectionsKt.throwIndexOverflow();
    L43:
        char r28 = ((Character) r27).charValue();
        float r29 = this.e;
        float r30 = (((r26 - r23) * r29) * r24) + r14;
        if (r30 <= (-r29)) goto L48;
        Iterator r113 = r25;
        if (r30 >= (getHeight() + this.e)) goto L49;
        r20.drawText(String.valueOf(r28), r15, r30, this.a);
    L49:
        r26 = r112;
        r25 = r113;
        goto L39
    L48:
        r113 = r25;
        goto L49
    L36:
        r24 = -1.0f;
        goto L37
    L52:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public c(Context r3, SlcTemplateContext r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "slcTemplateContext");
        super(r3, null, 0);
        this.l = r4;
        Paint r5 = new Paint(1);
        r5.setColor(ColorProtector.parseColor("#FF161823"));
        r5.setTextAlign(Paint.Align.LEFT);
        Unit r0 = Unit.INSTANCE;
        this.a = r5;
        this.b = "";
        this.c = "";
        this.g = 1.0f;
        this.i = true;
        this.j = Paint.Align.CENTER;
    }

    public final List<Character> f(char r6, char r7) {
        int r8 = r6 - '0';
        int r9 = r7 - '0';
        if (this.i == false) goto L5;
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
        if (this.i == false) goto L14;
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
    public final void onMeasure(int r4, int r5) {
        j();
        int r0 = (((int) Math.max(h(this.b), h(this.c))) + getPaddingLeft()) + getPaddingRight();
        int r1 = (((int) this.e) + getPaddingTop()) + getPaddingBottom();
        setMeasuredDimension(View.resolveSize(r0, r4), View.resolveSize(r1, r5));
    }

    public final void d(Canvas r5, char r6, float r7, float r8, float r9) {
        if (r6 != 0) goto L4;
        return;
    L4:
        int r0 = this.a.getAlpha();
        this.a.setAlpha(RangesKt.coerceIn((int) (r0 * r9), 0, 255));
        r5.drawText(String.valueOf(r6), r7, r8, this.a);
        this.a.setAlpha(r0);
    }

    public final void a(String r20, String r21, boolean r22, String r23, Float r24, Integer r25, String r26) {
        String r2 = b(r21);
        String r3 = b(r20);
        boolean r5 = true;
        if (r3.length() <= 0) goto L5;
        boolean r4 = true;
    L6:
        Long r7 = null;
        if (r4 == true) goto L10;
        r3 = null;
    L10:
        if (r3 != null) goto L12;
        r3 = this.b;
    L12:
        if (r21 == null) goto L15;
        BigDecimal r6 = i(r21);
        if (r6 == null) goto L15;
    L16:
        if (r20 == null) goto L19;
        BigDecimal r8 = i(r20);
        if (r8 == null) goto L19;
    L21:
        if (r6.compareTo(r8) < 0) goto L23;
        boolean r9 = true;
    L24:
        this.i = r9;
        Paint r10 = this.a;
        Integer r11 = s.b(r23);
        if (r11 == null) goto L27;
        int r12 = r11.intValue();
    L28:
        r10.setColor(r12);
        Paint r13 = this.a;
        if (r24 == null) goto L31;
        float r14 = r24.floatValue();
    L32:
        r13.setTextSize(SlcDimensExtensionsKt.a(Double.valueOf(r14), this.l.m()));
        if (r25 == null) goto L35;
        int r15 = r25.intValue();
    L36:
        Paint r16 = this.a;
        Typeface r17 = ECFontHelper.e.b("DouyinNumberABC", r15, false);
        if (r17 == null) goto L39;
    L45:
        r16.setTypeface(r17);
        if (r26 == null) goto L52;
        ArrayList r18 = new ArrayList(r26.length());
        int r19 = 0;
    L49:
        if (r19 >= r26.length()) goto L51;
        r18.add(Character.valueOf(Character.toLowerCase(r26.charAt(r19))));
        r19 = r19 + 1;
        goto L49
    L51:
        String r1 = CollectionsKt.joinToString$default(r18, "", null, null, 0, null, null, 62, null);
    L53:
        if (r1 != null) goto L56;
    L70:
        Paint.Align r27 = Paint.Align.CENTER;
    L71:
        this.j = r27;
        j();
        ValueAnimator r28 = this.k;
        if (r28 == null) goto L74;
        r28.cancel();
    L74:
        this.c = r3;
        this.b = r2;
        if (r22 == true) goto L77;
    L125:
        this.g = 1.0f;
        this.h = Long.MAX_VALUE;
        invalidate();
    L126:
        requestLayout();
        return;
    L77:
        if ((!Intrinsics.areEqual(r3, r2)) == false) goto L125;
        String r29 = this.c;
        String r30 = this.b;
        int r31 = 0;
    L80:
        if (r31 >= r29.length()) goto L85;
        if (Character.isDigit(r29.charAt(r31)) == true) goto L83;
        r31 = r31 + 1;
        goto L80
    L83:
        boolean r32 = true;
    L86:
        if (r32 == false) goto L97;
        int r33 = 0;
    L89:
        if (r33 >= r30.length()) goto L94;
        if (Character.isDigit(r30.charAt(r33)) == true) goto L92;
        r33 = r33 + 1;
        goto L89
    L92:
        boolean r34 = true;
    L95:
        if (r34 == false) goto L97;
    L98:
        if (r5 == false) goto L125;
        this.g = 0.0f;
        this.h = 0;
        String r35 = this.c;
        String r36 = this.b;
        int r37 = Math.max(r35.length(), r36.length());
        String r38 = StringsKt.padStart(r35, r37, 0);
        String r39 = StringsKt.padStart(r36, r37, 0);
        IntIterator r40 = RangesKt.until(0, r37).iterator();
        long r41 = 1;
        if (r40.hasNext() == false) goto L122;
        IntIterator r42 = r40;
        int r43 = r42.nextInt();
        char r44 = r38.charAt(r43);
        char r45 = r39.charAt(r43);
        if (Character.isDigit(r44) == true) goto L105;
    L108:
        long r46 = 1;
    L109:
        r7 = Long.valueOf(r46);
    L111:
        if (r40.hasNext() == false) goto L122;
        int r47 = r42.nextInt();
        char r48 = r38.charAt(r47);
        char r49 = r39.charAt(r47);
        if (Character.isDigit(r48) == true) goto L115;
    L118:
        long r50 = 1;
    L119:
        Long r51 = Long.valueOf(r50);
        if (r7.compareTo(r51) >= 0) goto L111;
        r7 = r51;
        goto L111
    L115:
        if (Character.isDigit(r49) == false) goto L118;
        if (r48 == r49) goto L118;
        r50 = f(r48, r49).size();
        goto L119
    L105:
        if (Character.isDigit(r45) == false) goto L108;
        if (r44 == r45) goto L108;
        r46 = f(r44, r45).size();
    L122:
        if (r7 == null) goto L124;
        r41 = r7.longValue();
    L124:
        long r52 = Math.max(r41 * 100, 270);
        ValueAnimator r53 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r53.setDuration(r52);
        r53.setInterpolator(new LinearInterpolator());
        r53.addUpdateListener(new b(this));
        r53.start();
        Unit r54 = Unit.INSTANCE;
        this.k = r53;
        goto L126
    L94:
        r34 = false;
    L97:
        r5 = false;
        goto L98
    L85:
        r32 = false;
        goto L86
    L56:
        switch(r1.hashCode()) {
            case 100571: goto L68;
            case 3317767: goto L65;
            case 108511772: goto L62;
            case 109757538: goto L59;
            default: goto L70;
        };
    L59:
        if (r1.equals("start") == false) goto L70;
    L66:
        r27 = Paint.Align.LEFT;
        goto L71
    L62:
        if (r1.equals("right") == false) goto L70;
    L69:
        r27 = Paint.Align.RIGHT;
        goto L71
    L65:
        if (r1.equals("left") == false) goto L70;
    L68:
        if (r1.equals("end") == false) goto L70;
    L52:
        r1 = null;
        goto L53
    L39:
        if (Build.VERSION.SDK_INT < 28) goto L42;
        r17 = Typeface.create(Typeface.DEFAULT, r15, false);
        goto L45
    L42:
        if (r15 < 600) goto L44;
        r17 = Typeface.DEFAULT_BOLD;
        goto L45
    L44:
        r17 = Typeface.DEFAULT;
        goto L45
    L35:
        r15 = 400;
        goto L36
    L31:
        r14 = 14.0f;
        goto L32
    L27:
        r12 = ColorProtector.parseColor("#FF161823");
        goto L28
    L23:
        r9 = false;
    L19:
        r8 = BigDecimal.ZERO;
    L15:
        r6 = BigDecimal.ZERO;
        goto L16
    L5:
        r4 = false;
        goto L6
    }
}
