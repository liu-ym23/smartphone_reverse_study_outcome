package com.bytedance.android.shopping.store.slicecard.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.store.utils.ECImageHelper;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECShopTrustFloatBarContentView extends View {
    public static final int n = 0;
    public static final int o = 0;
    public static final int p = 0;
    public c a;
    public f b;
    public float c;
    public final TextPaint d;
    public final Paint e;
    public final Paint f;
    public final Paint g;
    public final Path h;
    public final RectF i;
    public final RectF j;
    public final CompositeDisposable k;
    public final Map<String, Bitmap> l;
    public final Lazy m;

    public static final class a {
    }

    private final Typeface getDouyinSansTypeface() {
        return (Typeface) this.m.getValue();
    }

    static {
        n = Color.rgb(122, 76, 28);
        o = Color.rgb(255, 245, 220);
        p = Color.rgb(154, 100, 37);
    }

    private final float getDefaultIconSizePx() {
        return com.bytedance.android.shopping.extensions.b.b(12);
    }

    private final float getDefaultTextSizePx() {
        return com.bytedance.android.shopping.extensions.b.b(12);
    }

    public final int e() {
        c r0 = this.a;
        if (r0 == null) goto L8;
        Integer r1 = r0.g;
        if (r1 == null) goto L8;
        return r1.intValue();
    L8:
        return getPaddingLeft();
    }

    public final void m() {
        f r0 = this.b;
        String r1 = null;
        if (r0 == null) goto L23;
        List r2 = CollectionsKt.plus(r0.a, r0.c);
        if (r2 == null) goto L23;
        ArrayList r3 = new ArrayList();
        Iterator r4 = r2.iterator();
    L8:
        if (r4.hasNext() == false) goto L18;
        h r5 = (h) r4.next();
        if ((r5 instanceof h.b) == true) goto L12;
        r5 = null;
    L12:
        h.b r6 = (h.b) r5;
        if (r6 == null) goto L15;
        String r7 = r6.a;
    L16:
        if (r7 == null) goto L8;
        r3.add(r7);
        goto L8
    L15:
        r7 = null;
        goto L16
    L18:
        String r8 = CollectionsKt.joinToString$default(r3, " ", null, null, 0, null, null, 62, null);
        if (r8 == null) goto L23;
        if ((!StringsKt.isBlank(r8)) == false) goto L23;
        r1 = r8;
    L23:
        setContentDescription(r1);
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        this.k.clear();
        ((LinkedHashMap) this.l).clear();
        super.onDetachedFromWindow();
    }

    public ECShopTrustFloatBarContentView(final Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4);
        this.c = 1.0f;
        TextPaint r0 = new TextPaint(1);
        r0.setSubpixelText(true);
        Unit r2 = Unit.INSTANCE;
        this.d = r0;
        Paint r1 = new Paint(1);
        r1.setStyle(Paint.Style.FILL);
        this.e = r1;
        Paint r3 = new Paint(1);
        r3.setStyle(Paint.Style.STROKE);
        r3.setStrokeWidth(com.bytedance.android.shopping.extensions.b.b(1));
        this.f = r3;
        this.g = new Paint(3);
        this.h = new Path();
        this.i = new RectF();
        this.j = new RectF();
        this.k = new CompositeDisposable();
        this.l = new LinkedHashMap();
        this.m = LazyKt.lazy(LazyThreadSafetyMode.NONE, new ECShopTrustFloatBarContentView$douyinSansTypeface$2(r4));
    }

    public static final /* synthetic */ Typeface a(ECShopTrustFloatBarContentView r0) {
        return r0.getDouyinSansTypeface();
    }

    public static String h(ECUrlModel r4) {
        if (r4 == null) goto L11;
        String r1 = r4.getUrlKey();
        if (r1 == null) goto L11;
        if ((!StringsKt.isBlank(r1)) == true) goto L10;
        r1 = null;
    L10:
        if (r1 == null) goto L11;
    L23:
        if (r1 != null) goto L31;
        if (r4 == null) goto L35;
        String r5 = r4.getUri();
        if (r5 != null) goto L28;
        return null;
    L28:
        if ((!StringsKt.isBlank(r5)) == true) goto L38;
        return null;
    L38:
        return r5;
    L35:
        return null;
    L31:
        return r1;
    L11:
        if (r4 == null) goto L22;
        List r2 = r4.getUrlList();
        if (r2 == null) goto L22;
        Iterator r3 = r2.iterator();
    L16:
        if (r3.hasNext() == false) goto L20;
        Object r6 = r3.next();
        if ((!StringsKt.isBlank((String) r6)) == false) goto L16;
    L21:
        r1 = (String) r6;
        goto L23
    L20:
        r6 = null;
    L22:
        r1 = null;
        goto L23
    }

    public final int d(int r2) {
        int r3 = r2 - e();
        c r0 = this.a;
        if (r0 == null) goto L7;
        Integer r1 = r0.g;
        if (r1 == null) goto L7;
        int r4 = r1.intValue();
    L9:
        return RangesKt.coerceAtLeast(r3 - r4, 0);
    L7:
        r4 = getPaddingRight();
        goto L9
    }

    public final void i(ECUrlModel r4) {
        final String r0 = h(r4);
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.l.containsKey(r0) == false) goto L8;
        return;
    L8:
        this.l.put(r0, null);
        Lazy r1 = ECImageHelper.a;
        com.bytedance.android.ec.core.imagex.b r5 = h0.g(r4, (r) ECImageHelper.a.getValue(), new ECShopTrustFloatBarContentView$preloadImage$1(this, r0));
        if (r5 == null) goto L12;
        this.k.add(r5);
        return;
    }

    public final List<h> l(List<g> r20) {
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r20.iterator();
    L4:
        if (r2.hasNext() == false) goto L65;
        g r3 = (g) r2.next();
        ArrayList r4 = new ArrayList();
        if (r3.c == null) goto L8;
    L9:
        float r5 = getDefaultIconSizePx();
        f r8 = b.a;
        Float r9 = r3.d;
        Float r10 = null;
        if (r9 != null) goto L12;
    L20:
        float r14 = r5;
    L21:
        Float r11 = r3.e;
        if (r11 != null) goto L24;
    L31:
        float r15 = r5;
        List<Float> r6 = r3.q;
        if (r6.size() < 4) goto L37;
        Float r12 = (Float) CollectionsKt.getOrNull(r6, 3);
        if (r12 == null) goto L42;
        float r13 = r12.floatValue();
    L41:
        float r16 = r13;
    L44:
        if (r6.size() < 4) goto L50;
        Float r7 = (Float) CollectionsKt.getOrNull(r6, 1);
        if (r7 == null) goto L55;
        float r17 = r7.floatValue();
    L54:
        float r18 = r17;
    L56:
        r4.add(new h.a(r3.c, r3.m, r14, r15, r16, r18, (r16 + r14) + r18));
    L58:
        if ((!StringsKt.isBlank(r3.a)) == false) goto L64;
        e r19 = r3.d(this.c, n, getDefaultTextSizePx(), new ECShopTrustFloatBarContentView$richTextToSegments$textStyle$1(this));
        String r21 = r3.a;
        int[] r110 = r19.b;
        if (r110 == null) goto L62;
        boolean r111 = true;
    L63:
        r4.add(new h.b(r21, r111, r19.a, r110, r19.c, Float.valueOf(r19.d), r19.e, r19.f));
        goto L64
    L62:
        r111 = false;
    L64:
        CollectionsKt.addAll(r1, r4);
    L55:
        r18 = 0.0f;
        goto L56
    L50:
        if (r6.size() < 2) goto L55;
        Float r22 = (Float) CollectionsKt.getOrNull(r6, 1);
        if (r22 == null) goto L55;
        r17 = r22.floatValue();
    L42:
        r16 = 0.0f;
        goto L44
    L37:
        if (r6.size() < 2) goto L42;
        Float r23 = (Float) CollectionsKt.getOrNull(r6, 0);
        if (r23 == null) goto L42;
        r13 = r23.floatValue();
        goto L41
    L24:
        if (r11.floatValue() <= 0.0f) goto L26;
        boolean r112 = true;
    L27:
        if (r112 == false) goto L29;
        r10 = r11;
    L29:
        if (r10 == null) goto L31;
        r5 = r10.floatValue();
        goto L31
    L26:
        r112 = false;
        goto L27
    L12:
        if (r9.floatValue() <= 0.0f) goto L14;
        boolean r113 = true;
    L15:
        if (r113 == true) goto L18;
        r9 = null;
    L18:
        if (r9 == null) goto L20;
        r14 = r9.floatValue();
        goto L21
    L14:
        r113 = false;
        goto L15
    L8:
        if (r3.m == null) goto L58;
    L65:
        return r1;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r5) {
        Intrinsics.checkNotNullParameter(r5, "canvas");
        super.onDraw(r5);
        f r0 = this.b;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.a.isEmpty() == true) goto L8;
    L10:
        g(r5, r0.a, e());
        g(r5, r0.c, e() + RangesKt.coerceAtLeast(d(getWidth()) - r0.d, 0.0f));
        return;
    L8:
        if (r0.c.isEmpty() == false) goto L10;
    }

    public static f k(f r3, int r4) {
        float r0 = r3.b;
        float r1 = r3.d;
        float r2 = r0 + r1;
        float r5 = 0.0f;
        if (r1 <= 0.0f) goto L6;
        r5 = com.bytedance.android.shopping.extensions.b.b(12);
    L6:
        if ((r2 + r5) > r4) goto L8;
        boolean r6 = true;
    L9:
        if (r6 == true) goto L13;
        return null;
    L13:
        return r3;
    L8:
        r6 = false;
        goto L9
    }

    public final f c(List<? extends h> r18, int r19) {
        float r2 = 0.0f;
        if (r19 <= 0) goto L5;
        ArrayList r3 = new ArrayList();
        Iterator<T> r4 = r18.iterator();
    L8:
        if (r4.hasNext() == false) goto L27;
        Object r5 = (h) r4.next();
        if ((r5 instanceof h.a) == false) goto L13;
        r2 = r2 + ((h.a) r5).g;
    L23:
        if (r5 == null) goto L8;
        r3.add(r5);
        goto L8
    L13:
        if ((r5 instanceof h.b) == false) goto L26;
        if (r2 < r19) goto L17;
        String r6 = "";
    L18:
        String r8 = r6;
        h.b r7 = (h.b) r5;
        Float r9 = r7.f;
        if (r9 == null) goto L21;
        float r10 = r9.floatValue();
    L22:
        Typeface r11 = r7.g;
        this.d.setTextSize(r10);
        this.d.setTypeface(r11);
        this.d.setShader(null);
        float r16 = this.d.measureText(r8);
        r2 = r2 + r16;
        boolean r12 = r7.b;
        Integer r13 = r7.c;
        int[] r14 = r7.d;
        float[] r15 = r7.e;
        Float r17 = r7.f;
        Typeface r110 = r7.g;
        float r111 = r7.h;
        Intrinsics.checkNotNullParameter(r8, "text");
        r5 = new h.b(r8, r12, r13, r14, r15, r17, r110, r111, r16);
        goto L23
    L21:
        r10 = getDefaultTextSizePx();
        goto L22
    L17:
        r6 = ((h.b) r5).a;
        goto L18
    L26:
        throw new NoWhenBranchMatchedException();
    L27:
        ArrayList r1 = new ArrayList();
        Iterator r20 = r3.iterator();
    L29:
        if (r20.hasNext() == false) goto L39;
        Object r21 = r20.next();
        h r22 = (h) r21;
        if ((r22 instanceof h.b) == true) goto L33;
    L35:
        boolean r23 = false;
    L36:
        if (r23 == true) goto L29;
        r1.add(r21);
        goto L29
    L33:
        if (StringsKt.isBlank(((h.b) r22).a) == false) goto L35;
        r23 = true;
        goto L36
    L39:
        return new f(r1, r2);
    L5:
        return new f(CollectionsKt.emptyList(), 0.0f);
    }

    public final f j(c r23, int r24) {
        if (r23 == null) goto L136;
        if (r24 <= 0) goto L137;
        boolean r12 = true;
        if (r23.e == null) goto L72;
        i r0 = r23.b;
        if (r0 == null) goto L11;
        List<g> r1 = r0.a;
    L12:
        if (r1 != null) goto L14;
        r1 = CollectionsKt.emptyList();
    L14:
        List<g> r15 = r1;
        i r2 = r23.d;
        if (r2 == null) goto L17;
        List<g> r3 = r2.a;
    L18:
        if (r3 != null) goto L20;
        r3 = CollectionsKt.emptyList();
    L20:
        List<g> r16 = CollectionsKt.take(r3, 8);
        if (r16.isEmpty() == true) goto L46;
        com.bytedance.android.shopping.store.slicecard.view.a r4 = r23.e;
        if (r4 == null) goto L28;
        i r5 = r4.a;
        if (r5 == null) goto L28;
        List<g> r6 = r5.a;
    L29:
        if (r6 != null) goto L31;
        r6 = CollectionsKt.emptyList();
    L31:
        List<g> r17 = r6;
        com.bytedance.android.shopping.store.slicecard.view.a r7 = r23.e;
        if (r7 == null) goto L36;
        i r8 = r7.b;
        if (r8 == null) goto L36;
        List<g> r9 = r8.a;
    L37:
        if (r9 != null) goto L39;
        r9 = CollectionsKt.emptyList();
    L39:
        List<g> r10 = r9;
        if (r10.isEmpty() == false) goto L42;
        r10 = r17;
    L42:
        List<g> r18 = r10;
        if (r17.isEmpty() == true) goto L45;
    L47:
        i r11 = r23.c;
        if (r11 == null) goto L50;
        List<g> r13 = r11.a;
    L51:
        if (r13 != null) goto L53;
        r13 = CollectionsKt.emptyList();
    L53:
        List r19 = CollectionsKt.take(r13, 2);
        int r14 = r19.size();
    L54:
        if (r14 < 0) goto L63;
        f r20 = c(l(CollectionsKt.take(r19, r14)), r24);
        float r21 = r20.b;
        float r22 = r24 - r21;
        if (r21 <= 0.0f) goto L58;
        float r25 = com.bytedance.android.shopping.extensions.b.b(12);
    L59:
        int r26 = r14;
        f r27 = k(b(r15, r16, r17, false, (int) RangesKt.coerceAtLeast(r22 - r25, 0.0f), r20), r24);
        if (r27 != null) goto L70;
        r14 = r26 - 1;
    L70:
        if (r27 == null) goto L72;
        return r27;
    L58:
        r25 = 0.0f;
        goto L59
    L63:
        int r28 = r16.size() - 1;
    L64:
        if (r28 < 1) goto L69;
        int r110 = r28;
        r27 = k(b(r15, CollectionsKt.take(r16, r28), r18, false, r24, b.a), r24);
        if (r27 != null) goto L70;
        r28 = r110 - 1;
        goto L64
    L69:
        r27 = b(r15, CollectionsKt.take(r16, 1), r18, true, r24, b.a);
        goto L70
    L50:
        r13 = null;
        goto L51
    L45:
        if (r18.isEmpty() == false) goto L47;
    L36:
        r9 = null;
    L28:
        r6 = null;
    L46:
        r27 = null;
        goto L70
    L17:
        r3 = null;
        goto L18
    L11:
        r1 = null;
    L72:
        i r29 = r23.b;
        if (r29 == null) goto L75;
        List<g> r30 = r29.a;
    L76:
        if (r30 != null) goto L78;
        r30 = CollectionsKt.emptyList();
    L78:
        List<g> r31 = r30;
        i r32 = r23.d;
        if (r32 == null) goto L81;
        List<g> r33 = r32.a;
    L82:
        if (r33 != null) goto L84;
        r33 = CollectionsKt.emptyList();
    L84:
        List<h> r34 = l(CollectionsKt.plus(r31, r33));
        i r35 = r23.c;
        if (r35 == null) goto L87;
        List<g> r36 = r35.a;
    L88:
        if (r36 != null) goto L90;
        r36 = CollectionsKt.emptyList();
    L90:
        f r37 = c(l(CollectionsKt.take(r36, 2)), r24);
        float r38 = r37.b;
        float r39 = r24 - r38;
        if (r38 <= 0.0f) goto L93;
        float r40 = com.bytedance.android.shopping.extensions.b.b(12);
    L94:
        f r41 = f.a(c(r34, (int) RangesKt.coerceAtLeast(r39 - r40, 0.0f)), r37.a, r37.b);
        if (k(r41, r24) != null) goto L98;
        r41 = c(r34, r24);
    L98:
        List<h> r42 = r41.a;
        if ((r42 instanceof Collection) == true) goto L101;
    L103:
        Iterator<T> r43 = r42.iterator();
    L105:
        if (r43.hasNext() == false) goto L109;
        if (b.a((h) r43.next()) == false) goto L105;
        boolean r44 = false;
    L110:
        if (r44 == false) goto L125;
        List<h> r45 = r41.c;
        if ((r45 instanceof Collection) == true) goto L114;
    L116:
        Iterator<T> r46 = r45.iterator();
    L118:
        if (r46.hasNext() == false) goto L122;
        if (b.a((h) r46.next()) == false) goto L118;
        r12 = false;
    L122:
        if (r12 == false) goto L125;
        return null;
    L114:
        if (r45.isEmpty() == false) goto L116;
    L125:
        return r41;
    L109:
        r44 = true;
        goto L110
    L101:
        if (r42.isEmpty() == false) goto L103;
    L93:
        r40 = 0.0f;
        goto L94
    L87:
        r36 = null;
        goto L88
    L81:
        r33 = null;
        goto L82
    L75:
        r30 = null;
        goto L76
    L137:
        return null;
    L136:
        return null;
    }

    @Override // android.view.View
    public final void onMeasure(int r5, int r6) {
        super.onMeasure(r5, r6);
        f r7 = j(this.a, d(getMeasuredWidth()));
        this.b = r7;
        c r0 = this.a;
        int r1 = 0;
        Float r2 = null;
        if (r0 == null) goto L15;
        Integer r3 = r0.f;
        if (r3 == null) goto L15;
        if (r3.intValue() <= 0) goto L9;
        boolean r4 = true;
    L10:
        if (r4 == true) goto L13;
        r3 = null;
    L13:
        if (r3 == null) goto L15;
        int r8 = r3.intValue();
    L34:
        setMeasuredDimension(getMeasuredWidth(), r8);
        m();
        return;
    L9:
        r4 = false;
    L15:
        if (r7 == null) goto L17;
        List r9 = CollectionsKt.plus(r7.a, r7.c);
    L18:
        if (r9 != null) goto L20;
        r9 = CollectionsKt.emptyList();
    L20:
        Iterator r10 = r9.iterator();
        if (r10.hasNext() == false) goto L28;
        float r11 = b.b((h) r10.next(), getDefaultTextSizePx());
    L25:
        if (r10.hasNext() == false) goto L27;
        r11 = Math.max(r11, b.b((h) r10.next(), getDefaultTextSizePx()));
        goto L25
    L27:
        r2 = Float.valueOf(r11);
    L28:
        if (r2 == null) goto L30;
        r1 = MathKt.roundToInt(r2.floatValue());
    L30:
        int r12 = (r1 + getPaddingTop()) + getPaddingBottom();
        if (View.MeasureSpec.getMode(r6) == Integer.MIN_VALUE) goto L33;
        r8 = r12;
        goto L34
    L33:
        r8 = RangesKt.coerceAtMost(r12, View.MeasureSpec.getSize(r6));
        goto L34
    L17:
        r9 = null;
        goto L18
    }

    public final void g(Canvas r24, List<? extends h> r25, float r26) {
        Iterator<T> r1 = r25.iterator();
        Canvas r3 = r24;
        float r2 = r26;
    L4:
        if (r1.hasNext() == false) goto L58;
        h r4 = (h) r1.next();
        if ((r4 instanceof h.a) == true) goto L7;
        if ((r4 instanceof h.b) == false) goto L4;
        h.b r5 = (h.b) r4;
        Float r6 = r5.f;
        if (r6 == null) goto L37;
        float r7 = r6.floatValue();
    L38:
        Typeface r8 = r5.g;
        this.d.setTextSize(r7);
        this.d.setTypeface(r8);
        float r9 = (getHeight() / 2.0f) - ((this.d.getFontMetrics().ascent + this.d.getFontMetrics().descent) / 2.0f);
        String r10 = r5.a;
        Integer r11 = r5.c;
        if (r11 == null) goto L41;
        int r12 = r11.intValue();
    L42:
        boolean r13 = r5.b;
        Float r14 = r5.f;
        if (r14 == null) goto L45;
        float r15 = r14.floatValue();
    L46:
        Typeface r16 = r5.g;
        int[] r17 = r5.d;
        float[] r18 = r5.e;
        float r19 = r5.h;
        this.d.setTextSize(r15);
        this.d.setTypeface(r16);
        this.d.setColor(r12);
        TextPaint r20 = this.d;
        if (r13 == false) goto L52;
        if (r17 == null) goto L52;
        if (r17.length < 2) goto L52;
        float r110 = r20.getFontMetrics().descent - this.d.getFontMetrics().ascent;
        float r111 = this.d.measureText(r10);
        float r112 = (r111 / 2.0f) + r2;
        float r21 = ((this.d.getFontMetrics().descent + this.d.getFontMetrics().ascent) / 2.0f) + r9;
        float r22 = ((float) Math.hypot(r111, r110)) / 2.0f;
        f r113 = b.a;
        double r114 = Math.toRadians((((r19 - 90.0f) % 360.0f) + 360.0f) % 360.0f);
        float r115 = (((float) Math.cos(r114)) * r22) + r112;
        float r116 = r21 + (r22 * ((float) Math.sin(r114)));
        float r23 = 2;
        LinearGradient r27 = new LinearGradient((r112 * r23) - r115, (r23 * r21) - r116, r115, r116, r17, r18, Shader.TileMode.CLAMP);
    L53:
        r20.setShader(r27);
        if (this.d.getShader() == null) goto L56;
        this.d.setAlpha(RangesKt.coerceIn(MathKt.roundToInt(255.0f), 0, 255));
    L56:
        r24.drawText(r10, r2, r9, this.d);
        this.d.setShader(null);
        r2 = r2 + r5.i;
        r3 = r24;
    L52:
        r27 = null;
        goto L53
    L45:
        r15 = getDefaultTextSizePx();
        goto L46
    L41:
        r12 = n;
        goto L42
    L37:
        r7 = getDefaultTextSizePx();
        goto L38
    L7:
        h.a r28 = (h.a) r4;
        float r29 = getHeight() / 2.0f;
        if (r28.a == null) goto L10;
    L12:
        float r30 = r28.e + r2;
        float r31 = r28.d;
        float r32 = r29 - (r31 / 2.0f);
        this.j.set(r30, r32, r28.c + r30, r31 + r32);
        float r33 = 1.0f;
        float r34 = RangesKt.coerceIn(1.0f - this.c, 0.0f, 1.0f);
        String r35 = h(r28.a);
        if (r35 != null) goto L15;
        Bitmap r36 = null;
    L16:
        ECUrlModel r37 = r28.b;
        if (r37 == null) goto L22;
        String r38 = h(r37);
        if (r38 == null) goto L22;
        Bitmap r117 = (Bitmap) ((LinkedHashMap) this.l).get(r38);
    L23:
        if (r117 == null) goto L25;
        f(r3, r117, this.j, r34);
    L25:
        if (r36 == null) goto L31;
        RectF r39 = this.j;
        if (r117 == null) goto L30;
        r33 = 1.0f - r34;
    L30:
        f(r3, r36, r39, r33);
    L31:
        r2 = r2 + r28.g;
    L22:
        r117 = null;
        goto L23
    L15:
        r36 = (Bitmap) ((LinkedHashMap) this.l).get(r35);
        goto L16
    L10:
        if (r28.b != null) goto L12;
        int r40 = RangesKt.coerceIn(MathKt.roundToInt(255.0f), 0, 255);
        float r41 = getDefaultIconSizePx();
        float r42 = r41 / 2.0f;
        this.i.set(r2, r29 - r42, r2 + r41, r42 + r29);
        this.e.setColor(o);
        this.e.setAlpha(r40);
        r3.drawOval(this.i, this.e);
        this.f.setColor(p);
        this.f.setAlpha(r40);
        r3.drawOval(this.i, this.f);
        this.h.reset();
        this.h.moveTo((0.28f * r41) + r2, r29);
        this.h.lineTo((0.43f * r41) + r2, (0.16f * r41) + r29);
        this.h.lineTo((0.74f * r41) + r2, r29 - (r41 * 0.18f));
        Paint r43 = this.f;
        Resources r44 = getContext().getResources();
        r43.setStrokeWidth(WindowDisplayMetricsOverride.apply(r44, r44.getDisplayMetrics()).density * 1.4f);
        this.f.setStrokeCap(Paint.Cap.ROUND);
        this.f.setStrokeJoin(Paint.Join.ROUND);
        r3.drawPath(this.h, this.f);
        goto L31
    }

    public final void f(Canvas r4, Bitmap r5, RectF r6, float r7) {
        if (r7 > 0.0f) goto L5;
        return;
    L5:
        this.g.setAlpha(RangesKt.coerceIn(MathKt.roundToInt((r7 * 1.0f) * 255), 0, 255));
        r4.drawBitmap(r5, null, r6, this.g);
    }

    public final f b(List<g> r25, List<g> r26, List<g> r27, boolean r28, int r29, f r30) {
        List<? extends h> r3 = new ArrayList();
        ArrayList r13 = new ArrayList();
        r13.addAll(r25);
        r13.addAll(r26);
        r13.addAll(r27);
        if (r28 == false) goto L71;
        float r14 = r29;
        String r4 = CollectionsKt.joinToString$default(r13, "", null, null, 0, null, ECShopTrustFloatBarContentView$buildEllipsizedLeadingSegments$mergedText$1.INSTANCE, 30, null);
        if (StringsKt.isBlank(r4) == false) goto L7;
        List<h> r5 = CollectionsKt.emptyList();
    L72:
        CollectionsKt.addAll(r3, r5);
        return f.a(c(r3, r29), r30.a, r30.b);
    L7:
        Iterator r6 = r13.iterator();
    L8:
        Typeface r9 = null;
        if (r6.hasNext() == false) goto L20;
        Object r7 = r6.next();
        String r10 = ((g) r7).b;
        if (r10 != null) goto L13;
    L16:
        boolean r11 = true;
    L18:
        if ((!r11) == false) goto L8;
    L21:
        g r8 = (g) r7;
        if (r8 == null) goto L26;
        String r12 = r8.b;
        if (r12 == null) goto L26;
        int r15 = s.a;
        Integer r16 = Integer.valueOf(s.a(r12, n));
    L27:
        g r17 = (g) CollectionsKt.firstOrNull(r13);
        if (r17 == null) goto L30;
        e r18 = r17.d(this.c, n, getDefaultTextSizePx(), new ECShopTrustFloatBarContentView$buildEllipsizedLeadingSegments$firstTextStyle$1(this));
    L32:
        if (r18 == null) goto L34;
        float r19 = r18.d;
    L35:
        if (r18 == null) goto L37;
        Typeface r110 = r18.e;
    L39:
        if (r14 > 0.0f) goto L41;
        String r20 = "";
    L42:
        String r111 = r20;
        if (r18 == null) goto L45;
        int[] r21 = r18.b;
    L46:
        if (r21 == null) goto L49;
        if (r16 != null) goto L49;
        boolean r112 = true;
    L50:
        if (r16 != null) goto L54;
        if (r18 == null) goto L53;
        r16 = r18.a;
        goto L54
    L53:
        Integer r113 = null;
    L55:
        if (r18 == null) goto L57;
        int[] r114 = r18.b;
    L58:
        if (r18 == null) goto L60;
        float[] r22 = r18.c;
    L61:
        if (r18 == null) goto L63;
        Float r23 = Float.valueOf(r18.d);
    L64:
        if (r18 == null) goto L66;
        r9 = r18.e;
    L66:
        Typeface r24 = r9;
        if (r18 == null) goto L69;
        float r210 = r18.f;
    L70:
        r5 = CollectionsKt.listOf(new h.b(r111, r112, r113, r114, r22, r23, r24, r210));
        goto L72
    L69:
        r210 = 0.0f;
        goto L70
    L63:
        r23 = null;
        goto L64
    L60:
        r22 = null;
        goto L61
    L57:
        r114 = null;
    L54:
        r113 = r16;
    L49:
        r112 = false;
        goto L50
    L45:
        r21 = null;
        goto L46
    L41:
        this.d.setTextSize(r19);
        this.d.setTypeface(r110);
        r20 = TextUtils.ellipsize(r4, this.d, r14, TextUtils.TruncateAt.END).toString();
        goto L42
    L37:
        r110 = null;
        goto L39
    L34:
        r19 = getDefaultTextSizePx();
        goto L35
    L30:
        r18 = null;
    L26:
        r16 = null;
        goto L27
    L13:
        if (StringsKt.isBlank(r10) == true) goto L16;
        r11 = false;
        goto L18
    L20:
        r7 = null;
        goto L21
    L71:
        r5 = l(r13);
        goto L72
    }
}
