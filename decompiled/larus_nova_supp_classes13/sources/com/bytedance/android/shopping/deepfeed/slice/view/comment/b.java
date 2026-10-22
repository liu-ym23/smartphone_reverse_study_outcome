package com.bytedance.android.shopping.deepfeed.slice.view.comment;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.MetricAffectingSpan;
import android.text.style.ReplacementSpan;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b extends com.bytedance.android.ecom.arch.slice.render.elements.b<AppCompatTextView> {
    public static final /* synthetic */ int H3 = 0;

    public static final class a extends MetricAffectingSpan {
        public final int a;

        public a(int r1) {
            this.a = r1;
        }

        @Override // android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r3) {
            Intrinsics.checkNotNullParameter(r3, "textPaint");
            r3.baselineShift += this.a;
        }

        @Override // android.text.style.MetricAffectingSpan
        public final void updateMeasureState(TextPaint r3) {
            Intrinsics.checkNotNullParameter(r3, "textPaint");
            r3.baselineShift += this.a;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.shopping.deepfeed.slice.view.comment.b$b, reason: collision with other inner class name */
    public static final class C0054b {
        public C0054b() {
        }

        public static final Typeface a(Typeface r2, int r3) {
            int r0 = b.H3;
            if (r2 != null) goto L6;
            r2 = Typeface.DEFAULT;
        L6:
            if (Build.VERSION.SDK_INT < 28) goto L9;
            return Typeface.create(r2, r3, true);
        L9:
            return Typeface.create(r2, 3);
        }

        public static final int b(Context r1, float r2) {
            int r0 = b.H3;
            if (r1 == null) goto L9;
            Resources r3 = r1.getResources();
            if (r3 == null) goto L9;
            DisplayMetrics r4 = WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics());
            if (r4 == null) goto L9;
            float r5 = r4.density;
        L10:
            float r6 = r5 * r2;
            if (r2 < 0) goto L13;
            float r7 = 0.5f;
        L15:
            return (int) (r6 + r7);
        L13:
            r7 = -0.5f;
        L9:
            r5 = 1.0f;
            goto L10
        }
    }

    public static final class c extends ReplacementSpan {
        public final Matrix a;
        public LinearGradient b;
        public float c;
        public float d;
        public final String e;

        public c(String r2) {
            Intrinsics.checkNotNullParameter(r2, "text");
            this.e = r2;
            this.a = new Matrix();
            this.c = -1.0f;
            this.d = -1.0f;
        }

        @Override // android.text.style.ReplacementSpan
        public final int getSize(Paint r1, CharSequence r2, int r3, int r4, Paint.FontMetricsInt r5) {
            Intrinsics.checkNotNullParameter(r1, "paint");
            Intrinsics.checkNotNullParameter(r2, "text");
            return (int) r1.measureText(this.e);
        }

        @Override // android.text.style.ReplacementSpan
        public final void draw(Canvas r21, CharSequence r22, int r23, int r24, float r25, int r26, int r27, int r28, Paint r29) {
            Intrinsics.checkNotNullParameter(r21, "canvas");
            Intrinsics.checkNotNullParameter(r22, "text");
            Intrinsics.checkNotNullParameter(r29, "paint");
            if (this.e.length() != 0) goto L5;
            boolean r5 = true;
        L6:
            if (r5 == false) goto L8;
            return;
        L8:
            Shader r6 = r29.getShader();
            int r8 = r29.getColor();
            float r9 = RangesKt.coerceAtLeast(r29.measureText(this.e), 1.0f);
            float r10 = RangesKt.coerceAtLeast(r28 - r26, 1.0f);
            if (this.b != null) goto L11;
        L15:
            double r11 = Math.toRadians(99.48d);
            Pair r12 = TuplesKt.to(Float.valueOf((float) Math.sin(r11)), Float.valueOf((float) (-Math.cos(r11))));
            this.b = new LinearGradient(0.0f, 0.0f, r9 * ((Number) r12.getFirst()).floatValue(), ((Number) r12.getSecond()).floatValue() * r10, new int[]{ColorProtector.parseColor("#A20A32"), ColorProtector.parseColor("#1D1724"), ColorProtector.parseColor("#161823")}, new float[]{0.0465f, 0.4277f, 0.8986f}, Shader.TileMode.CLAMP);
            this.c = r9;
            this.d = r10;
        L16:
            this.a.reset();
            this.a.setTranslate(r25, r26);
            LinearGradient r3 = this.b;
            if (r3 == null) goto L19;
            r3.setLocalMatrix(this.a);
        L19:
            r29.setShader(this.b);
            r21.drawText(this.e, r25, r27, r29);
            r29.setShader(r6);
            r29.setColor(r8);
            return;
        L11:
            if (this.c != r9) goto L15;
            if (this.d != r10) goto L15;
        L5:
            r5 = false;
            goto L6
        }
    }

    public static final class d extends MetricAffectingSpan {
        public final int a;

        public d(int r1) {
            this.a = r1;
        }

        @Override // android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r3) {
            Intrinsics.checkNotNullParameter(r3, "textPaint");
            int r0 = b.H3;
            r3.setTypeface(C0054b.a(r3.getTypeface(), this.a));
        }

        @Override // android.text.style.MetricAffectingSpan
        public final void updateMeasureState(TextPaint r3) {
            Intrinsics.checkNotNullParameter(r3, "textPaint");
            int r0 = b.H3;
            r3.setTypeface(C0054b.a(r3.getTypeface(), this.a));
        }
    }

    static {
        new C0054b();
    }

    public b(SlcTemplateContext r2) {
        Intrinsics.checkNotNullParameter(r2, "templateCtx");
        super(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.util.ArrayList] */
    public final void H0(Map<String, ? extends Object> r13) {
        Intrinsics.checkNotNullParameter(r13, "props");
        AppCompatTextView r0 = k1();
        if (r0 == null) goto L87;
        Context r1 = r0.getContext();
        Object r14 = r13.get("title");
        List r3 = null;
        if ((r14 instanceof Map) == true) goto L7;
        r14 = null;
    L7:
        Map r15 = (Map) r14;
        if (r15 == null) goto L10;
        Object r2 = r15.get("text");
    L12:
        if ((r2 instanceof List) == true) goto L14;
        r2 = null;
    L14:
        List r4 = (List) r2;
        if (r4 == null) goto L23;
        List r5 = r4;
        List r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator r7 = r5.iterator();
    L18:
        if (r7.hasNext() == false) goto L24;
        Object r8 = r7.next();
        if ((r8 instanceof String) == true) goto L22;
        r8 = null;
    L22:
        r6.add((String) r8);
    L24:
        if (r6 != 0) goto L26;
        r6 = CollectionsKt.emptyList();
    L26:
        CharSequence r9 = "";
        if (r6.isEmpty() == true) goto L73;
        if (r15 == null) goto L31;
        Object r16 = r15.get("highlights");
    L33:
        if ((r16 instanceof List) == true) goto L35;
        r16 = null;
    L35:
        List r17 = (List) r16;
        if (r17 == null) goto L50;
        ArrayList r10 = new ArrayList();
        Iterator r18 = r17.iterator();
    L39:
        if (r18.hasNext() == false) goto L49;
        Object r11 = r18.next();
        if ((r11 instanceof Number) == false) goto L44;
        Integer r12 = Integer.valueOf(((Number) r11).intValue());
    L47:
        if (r12 == null) goto L39;
        r10.add(r12);
        goto L39
    L44:
        if ((r11 instanceof String) == false) goto L46;
        r12 = StringsKt.toIntOrNull((String) r11);
        goto L47
    L46:
        r12 = null;
        goto L47
    L49:
        r3 = r10;
    L50:
        if (r3 != null) goto L52;
        r3 = CollectionsKt.emptyList();
    L52:
        Set r19 = CollectionsKt.toSet(r3);
        SpannableStringBuilder r20 = new SpannableStringBuilder();
        Iterator r21 = r6.iterator();
        int r22 = 0;
    L54:
        if (r21.hasNext() == false) goto L72;
        Object r23 = r21.next();
        int r24 = r22 + 1;
        if (r22 >= 0) goto L58;
        CollectionsKt.throwIndexOverflow();
    L58:
        String r25 = (String) r23;
        if (r25 != null) goto L61;
        r25 = "";
    L61:
        int r26 = r20.length();
        r20.append(r25);
        if (r25.length() != 0) goto L64;
        boolean r110 = true;
    L65:
        if (r110 == true) goto L71;
        if (r19.contains(Integer.valueOf(r22)) == false) goto L70;
        r20.setSpan(new c(r25), r26, r20.length(), 33);
        r20.setSpan(new AbsoluteSizeSpan((int) 24.0f, true), r26, r20.length(), 33);
        r20.setSpan(new d(900), r26, r20.length(), 33);
        goto L71
    L70:
        r20.setSpan(new d(700), r26, r20.length(), 33);
        r20.setSpan(new a(C0054b.b(r1, -2.0f)), r26, r20.length(), 33);
    L71:
        r22 = r24;
        goto L54
    L64:
        r110 = false;
        goto L65
    L72:
        r9 = r20;
        goto L73
    L31:
        r16 = null;
    L73:
        r0.setText(r9);
        return;
    L23:
        r6 = 0;
        goto L24
    L10:
        r2 = null;
        goto L12
    }

    public final View n1(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        AppCompatTextView r0 = new AppCompatTextView(r5);
        r0.setBackground(th.a.e(r5, true).getDrawable(2131247980));
        r0.setEllipsize(TextUtils.TruncateAt.END);
        r0.setMaxLines(1);
        r0.setGravity(17);
        r0.setTextColor(ColorProtector.parseColor("#282828"));
        r0.setTextSize(1, 16.0f);
        r0.setTypeface(C0054b.a(r0.getTypeface(), 700));
        r0.setPadding(C0054b.b(r5, 10.0f), r0.getPaddingTop(), r0.getPaddingRight(), r0.getPaddingBottom());
        return r0;
    }
}
