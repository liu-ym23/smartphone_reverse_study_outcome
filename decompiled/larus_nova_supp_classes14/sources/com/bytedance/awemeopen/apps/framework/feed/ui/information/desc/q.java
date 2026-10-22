package com.bytedance.awemeopen.apps.framework.feed.ui.information.desc;

import android.animation.Animator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.MovementMethod;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.Observer;
import com.bytedance.awemeopen.apps.framework.feed.desc.FeedLongDescAnimator;
import com.bytedance.awemeopen.apps.framework.feed.desc.ScrollMentionTextView;
import com.bytedance.awemeopen.apps.framework.utils.d0;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class q extends com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c<s, t> {
    public ViewGroup e;
    public ViewGroup f;
    public ScrollMentionTextView g;
    public ViewGroup h;
    public TextView i;
    public boolean j;
    public int k;
    public int l;
    public int m;
    public int n;
    public boolean o;
    public boolean p;
    public int q;
    public SpannableStringBuilder r;
    public SpannableStringBuilder s;
    public final int t;
    public final List<ViewTreeObserver.OnPreDrawListener> u;
    public final a v;

    public static final class a implements ViewTreeObserver.OnPreDrawListener {
        public final /* synthetic */ q a;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v18 */
        /* JADX WARN: Type inference failed for: r2v19, types: [android.widget.TextView] */
        /* JADX WARN: Type inference failed for: r2v20 */
        /* JADX WARN: Type inference failed for: r5v0 */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.widget.TextView, com.bytedance.awemeopen.apps.framework.feed.desc.MentionTextView, com.bytedance.awemeopen.apps.framework.feed.desc.ScrollMentionTextView] */
        /* JADX WARN: Type inference failed for: r5v2 */
        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            q r0 = this.a;
            ((ArrayList) r0.u).remove(this);
            AppCompatTextView r1 = r0.g;
            if (r1 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("mDescView");
            r1 = null;
        L5:
            r1.getViewTreeObserver().removeOnPreDrawListener(this);
            final q r4 = this.a;
            ScrollMentionTextView r2 = r4.g;
            if (r2 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("mDescView");
            final ?? r5 = 0;
        L9:
            Function0<Integer> r3 = ((t) r4.c).g;
            if (r3 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("withOutDescHeight");
            r3 = null;
        L13:
            int r6 = ((Number) r3.invoke()).intValue();
            Function0<Integer> r7 = ((t) r4.c).h;
            if (r7 != null) goto L17;
            Intrinsics.throwUninitializedPropertyAccessException("userNameHeight");
            r7 = null;
        L17:
            int r8 = ((Number) r7.invoke()).intValue();
            int r9 = com.bytedance.awemeopen.apps.framework.feed.desc.d.a;
            int r10 = com.bytedance.awemeopen.apps.framework.feed.ui.information.a.d;
            Context r11 = r4.getContext();
            Intrinsics.checkNotNullParameter(r11, "context");
            int r12 = r11.getString(2131894294).length() + 1;
            CharSequence r13 = r5.getText();
            Layout r14 = r5.getLayout();
            if (r14 == null) goto L21;
            r4.k = q.f(r5, r14.getLineCount());
            r14.getLineCount();
        L21:
            if (r4.l != 0) goto L23;
            r4.l = q.f(r5, r10);
        L23:
            int r15 = d0.c(r4.getContext());
            if (r5.getLineCount() < r10) goto L26;
            int r16 = r4.l;
        L27:
            double r17 = r6 + r16;
            double r18 = (r17 * 1.0d) / ((double) r15);
            int r19 = r8 + r16;
            ViewGroup r20 = r4.e;
            if (r20 != null) goto L30;
            Intrinsics.throwUninitializedPropertyAccessException("mRootContainer");
            r20 = null;
        L30:
            ViewGroup.LayoutParams r21 = r20.getLayoutParams();
            Intrinsics.checkNotNull(r21, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            double r110 = (((double) (r19 + ((LinearLayout.LayoutParams) r21).bottomMargin)) * 1.0d) / r17;
            double r111 = com.bytedance.awemeopen.apps.framework.feed.ui.information.a.a;
            if (r18 >= r111) goto L35;
            if (r110 <= com.bytedance.awemeopen.apps.framework.feed.ui.information.a.b) goto L35;
        L36:
            r10 = com.bytedance.awemeopen.apps.framework.feed.ui.information.a.c;
        L38:
            if (r5.getLineCount() != 0) goto L40;
            int r22 = r10;
        L41:
            r5.getLineCount();
            Objects.toString(r5.getText());
            if (r22 <= r10) goto L151;
            int r112 = r10 - 1;
            if (r14 != null) goto L162;
        L48:
            float r23 = 0.0f;
        L49:
            if (r14 == null) goto L51;
            int r113 = r14.getLineEnd(r112);
            int r114 = r113 - r14.getLineStart(r112);
            r5.getText().length();
        L52:
            CharSequence r115 = r5.getText();
            if (r113 != 0) goto L55;
            r113 = r115.length() / 2;
        L55:
            float r116 = r5.getWidth() - r23;
            TextView r24 = r4.i;
            if (r24 != null) goto L59;
            Intrinsics.throwUninitializedPropertyAccessException("mDescToggleView");
            r24 = null;
        L59:
            if (r24.getWidth() <= 0) goto L64;
            TextView r25 = r4.i;
            if (r25 != null) goto L63;
            Intrinsics.throwUninitializedPropertyAccessException("mDescToggleView");
            r25 = null;
        L63:
            int r26 = r25.getWidth();
        L65:
            int r27 = MathKt.roundToInt(r5.getPaint().measureText("... ")) + r26;
            Resources r28 = Resources.getSystem();
            int r29 = r27 + MathKt.roundToInt(TypedValue.applyDimension(1, 4, WindowDisplayMetricsOverride.apply(r28, r28.getDisplayMetrics())));
            float r30 = r29;
            if (r116 < r30) goto L68;
            int r31 = 0;
        L86:
            CharSequence r32 = StringsKt.removeSuffix(com.bytedance.awemeopen.apps.framework.feed.desc.e.a(r115, r31, r113), "\n");
            r4.h(r32);
            Objects.toString(r32);
            r4.r = new SpannableStringBuilder(SpannableString.valueOf(r13));
            int r33 = r5.getLineCount();
            Layout r34 = r5.getLayout();
            SpannableStringBuilder r117 = new SpannableStringBuilder(r32);
            if (r34 != null) goto L89;
            SpannableStringBuilder r210 = r117;
        L135:
            SpannableStringBuilder r118 = r210;
        L136:
            SpannableStringBuilder r35 = r118.append("...");
            Objects.toString(r35);
            r4.h(r35);
            r4.j = true;
            ViewGroup r36 = r4.h;
            if (r36 != null) goto L139;
            Intrinsics.throwUninitializedPropertyAccessException("mDescToggleContainer");
            r36 = null;
        L139:
            x54.b.d(r36);
            TextView r37 = r4.i;
            if (r37 != null) goto L142;
            Intrinsics.throwUninitializedPropertyAccessException("mDescToggleView");
            r37 = null;
        L142:
            x54.b.d(r37);
            ViewGroup r38 = r4.e;
            if (r38 != null) goto L145;
            Intrinsics.throwUninitializedPropertyAccessException("mRootContainer");
            r38 = null;
        L145:
            r38.requestLayout();
            r4.s = r35;
            ScrollMentionTextView r39 = r4.g;
            if (r39 != null) goto L148;
            Intrinsics.throwUninitializedPropertyAccessException("mDescView");
            ?? r40 = 0;
        L149:
            r40.post(new h(r4, r5));
            return true;
        L148:
            r40 = r39;
            goto L149
        L89:
            if (r33 != r10) goto L108;
            float r41 = r5.getWidth() - r34.getLineWidth(r112);
            int r42 = r34.getLineEnd(r112);
            int r119 = r34.getLineStart(r112);
            float r43 = r34.getLineWidth(r112) / (r42 - r119);
            float r44 = r41 - r30;
            int r120 = (int) (r44 / r43);
            r210 = r117;
            int r121 = r113 + r120;
            if (r41 != r116) goto L93;
            boolean r45 = true;
        L94:
            if (r45 == true) goto L135;
            if (r121 >= r42) goto L135;
            if (r121 <= r119) goto L135;
            if (Math.abs(r44) <= r43) goto L135;
            if (r120 <= 0) goto L103;
            int r46 = 0;
            if (StringsKt.contains$default(com.bytedance.awemeopen.apps.framework.feed.desc.e.a(r115, r113 - 1, r121).toString(), "\n", false, 2, null) == false) goto L104;
            CharSequence r47 = r32;
        L105:
            Objects.toString(r47);
            if (TextUtils.equals(r47, r32) == true) goto L135;
            r118 = new SpannableStringBuilder(r47);
            r4.h(r118);
        L104:
            r47 = StringsKt.removeSuffix(com.bytedance.awemeopen.apps.framework.feed.desc.e.a(r115, r46, r121), "\n");
            goto L105
        L103:
            r46 = 0;
            goto L104
        L93:
            r45 = false;
            goto L94
        L108:
            r210 = r117;
            if (r33 <= r10) goto L135;
            int r48 = r5.getWidth();
            r5.getLineCount();
            CharSequence r122 = r32;
            int r123 = 0;
        L112:
            if (r123 >= 4) goto L135;
            if (r5.getLayout().getLineCount() < r10) goto L135;
            int r124 = r5.getLayout().getLineEnd(r112);
            int r125 = r5.getLayout().getLineStart(r112);
            float r49 = r5.getLayout().getLineWidth(r112);
            float r126 = r48;
            float r127 = r126 - r49;
            float r50 = r49 / ((r124 - r125) + 1);
            float r128 = r127 - r30;
            if (r5.getLayout().getLineCount() > r10) goto L124;
            if (r128 < 0.0f) goto L124;
            if (r128 >= r50) goto L135;
        L124:
            int r129 = r124 - MathKt.roundToInt(Math.abs(r128) / r50);
            int r130 = r10 - 2;
            int r131 = r10;
            if (r130 < 0) goto L131;
            int r51 = r5.getLayout().getLineEnd(r130);
            if (r129 >= r51) goto L131;
            if (((r126 - r5.getLayout().getLineWidth(r130)) - r30) < r50) goto L131;
            r129 = r51;
        L131:
            r122 = StringsKt.removeSuffix(com.bytedance.awemeopen.apps.framework.feed.desc.e.a(r122, 0, r129), "\n");
            Objects.toString(r122);
            if (TextUtils.equals(r122, r32) == true) goto L135;
            SpannableStringBuilder r52 = new SpannableStringBuilder(r122);
            r4.h(r52);
            r123 = r123 + 1;
            r210 = r52;
            r10 = r131;
            goto L112
        L68:
            if (r113 < r12) goto L75;
            int r53 = r113 - r12;
            int r54 = r53 + 2;
            if (r54 > r115.length()) goto L75;
            if (PatternProtector.compile("(?:[\\uD83C\\uDF00-\\uD83D\\uDDFF]|[\\uD83E\\uDD00-\\uD83E\\uDDFF]|[\\uD83D\\uDE00-\\uD83D\\uDE4F]|[\\uD83D\\uDE80-\\uD83D\\uDEFF]|[\\u2600-\\u26FF]\\uFE0F?|[\\u2700-\\u27BF]\\uFE0F?|\\u24C2\\uFE0F?|[\\uD83C\\uDDE6-\\uD83C\\uDDFF]{1,2}|[\\uD83C\\uDD70\\uD83C\\uDD71\\uD83C\\uDD7E\\uD83C\\uDD7F\\uD83C\\uDD8E\\uD83C\\uDD91-\\uD83C\\uDD9A]\\uFE0F?|[\\u0023\\u002A\\u0030-\\u0039]\\uFE0F?\\u20E3|[\\u2194-\\u2199\\u21A9-\\u21AA]\\uFE0F?|[\\u2B05-\\u2B07\\u2B1B\\u2B1C\\u2B50\\u2B55]\\uFE0F?|[\\u2934\\u2935]\\uFE0F?|[\\u3030\\u303D]\\uFE0F?|[\\u3297\\u3299]\\uFE0F?|[\\uD83C\\uDE01\\uD83C\\uDE02\\uD83C\\uDE1A\\uD83C\\uDE2F\\uD83C\\uDE32-\\uD83C\\uDE3A\\uD83C\\uDE50\\uD83C\\uDE51]\\uFE0F?|[\\u203C\\u2049]\\uFE0F?|[\\u25AA\\u25AB\\u25B6\\u25C0\\u25FB-\\u25FE]\\uFE0F?|[\\u00A9\\u00AE]\\uFE0F?|[\\u2122\\u2139]\\uFE0F?|\\uD83C\\uDC04\\uFE0F?|\\uD83C\\uDCCF\\uFE0F?|[\\u231A\\u231B\\u2328\\u23CF\\u23E9-\\u23F3\\u23F8-\\u23FA]\\uFE0F?)").matcher(r115.subSequence(r53, r54).toString()).find() == false) goto L75;
            r31 = 0;
            int r55 = Math.max(0, r53);
        L74:
            r113 = r55;
        L75:
            int r56 = r29 - ((int) r116);
            Objects.toString(r115);
            int r57 = 3;
            float r58 = r5.getPaint().measureText(com.bytedance.awemeopen.apps.framework.feed.desc.e.a(r115, r113 - 3, r113).toString());     // Catch: Exception -> L83
        L77:
            if (r57 >= r114) goto L85;
            if (r58 >= r56) goto L85;
            r57 = r57 + 1;     // Catch: Exception -> L83
            r58 = r5.getPaint().measureText(com.bytedance.awemeopen.apps.framework.feed.desc.e.a(r115, r113 - r57, r113).toString());     // Catch: Exception -> L83
        L85:
            r31 = 0;
            r55 = Math.max(0, r113 - r57);
        L83:
            e = move-exception;
            e.toString();
            goto L85
        L64:
            Resources r59 = Resources.getSystem();
            r26 = MathKt.roundToInt(TypedValue.applyDimension(1, 40, WindowDisplayMetricsOverride.apply(r59, r59.getDisplayMetrics())));
            goto L65
        L51:
            r114 = 0;
            r113 = 0;
            goto L52
        L162:
            r23 = r14.getLineWidth(r112);     // Catch: Exception -> L47
        L151:
            if (r4.j == true) goto L174;
            ViewGroup r60 = r4.h;
            if (r60 != null) goto L155;
            Intrinsics.throwUninitializedPropertyAccessException("mDescToggleContainer");
            r60 = null;
        L155:
            x54.b.a(r60);
            TextView r61 = r4.i;
            if (r61 != null) goto L158;
            Intrinsics.throwUninitializedPropertyAccessException("mDescToggleView");
            TextView r62 = null;
        L159:
            x54.b.a(r62);
            r4.r = new SpannableStringBuilder(SpannableString.valueOf(r13));
            return true;
        L158:
            r62 = r61;
            goto L159
        L174:
            return true;
        L40:
            r22 = r5.getLineCount();
        L35:
            if (r18 < r111) goto L38;
        L26:
            r16 = r4.k;
            goto L27
        L8:
            r5 = r2;
            goto L9
        }

        public a(q r1) {
            this.a = r1;
        }
    }

    public static final class b extends com.bytedance.awemeopen.apps.framework.utils.o {
        public final /* synthetic */ q d;

        @Override // com.bytedance.awemeopen.apps.framework.utils.o
        public final void a() {
            q r0 = this.d;
            if (r0.r != null) goto L5;
            return;
        L5:
            if (r0.s == null) goto L18;
            ViewGroup r1 = r0.h;
            if (r1 != null) goto L9;
            Intrinsics.throwUninitializedPropertyAccessException("mDescToggleContainer");
            r1 = null;
        L9:
            Object r2 = r1.getTag(this.d.t);
            if (r2 != null) goto L12;
            r2 = Boolean.FALSE;
        L12:
            boolean r3 = Intrinsics.areEqual(r2, Boolean.FALSE);
            if (r3 == false) goto L15;
            ((s) this.d.b).b.b(Unit.INSTANCE);
            q r4 = this.d;
            SpannableStringBuilder r5 = r4.r;
            Intrinsics.checkNotNull(r5);
            q.g(r4, r5, r3);
            return;
        L15:
            q r6 = this.d;
            SpannableStringBuilder r7 = r6.s;
            Intrinsics.checkNotNull(r7);
            q.g(r6, r7, r3);
            return;
        }

        public b(q r1) {
            this.d = r1;
            super(0);
        }
    }

    public final void d() {
        Iterator<T> r0 = this.u.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        ViewTreeObserver.OnPreDrawListener r1 = (ViewTreeObserver.OnPreDrawListener) r0.next();
        AppCompatTextView r2 = this.g;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mDescView");
        r2 = null;
    L8:
        r2.getViewTreeObserver().removeOnPreDrawListener(r1);
        goto L4
    L9:
        ((ArrayList) this.u).clear();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final void c() {
        this.e = (ViewGroup) b().findViewById(2131368827);
        this.f = (ViewGroup) b().findViewById(2131368856);
        this.g = (ScrollMentionTextView) b().findViewById(2131368819);
        this.h = (ViewGroup) b().findViewById(2131367785);
        this.i = (TextView) b().findViewById(2131391636);
        ViewGroup r0 = this.h;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mDescToggleContainer");
        r0 = null;
    L5:
        r0.setOnClickListener(new b(this));
        t r1 = (t) this.c;
        Observer<Unit> r2 = new i(this);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "observer");
        r1.c.a(r2);
        t r3 = (t) this.c;
        Observer<Unit> r4 = new j(this);
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, "observer");
        r3.e.a(r4);
        t r5 = (t) this.c;
        Observer<t.a> r6 = new k(this);
        r5.getClass();
        Intrinsics.checkNotNullParameter(r6, "observer");
        r5.a.a(r6);
        t r7 = (t) this.c;
        Observer<Unit> r8 = new l(this);
        r7.getClass();
        Intrinsics.checkNotNullParameter(r8, "observer");
        r7.d.a(r8);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final View a(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "parentView");
        return LayoutInflater.from(getContext()).inflate(2131558610, r4, false);
    }

    public final void e(boolean r4) {
        ScrollMentionTextView r1 = null;
        if (r4 == false) goto L15;
        ScrollMentionTextView r5 = this.g;
        if (r5 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mDescView");
        r5 = null;
    L7:
        r5.setCanScroll(true);
        ScrollMentionTextView r6 = this.g;
        if (r6 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mDescView");
        r6 = null;
    L10:
        r6.setLastLineFadeEnable(true);
        ScrollMentionTextView r7 = this.g;
        if (r7 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mDescView");
    L14:
        r1.setOnClickListener(new p(this));
        return;
    L13:
        r1 = r7;
        goto L14
    L15:
        ScrollMentionTextView r8 = this.g;
        if (r8 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mDescView");
        r8 = null;
    L18:
        r8.setCanScroll(false);
        ScrollMentionTextView r9 = this.g;
        if (r9 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mDescView");
        r9 = null;
    L21:
        r9.setLastLineFadeEnable(false);
        ScrollMentionTextView r10 = this.g;
        if (r10 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mDescView");
        r10 = null;
    L24:
        r10.setOnClickListener(null);
    }

    public final void h(CharSequence r2) {
        AppCompatTextView r0 = this.g;     // Catch: Exception -> L7
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mDescView");     // Catch: Exception -> L7
        r0 = null;
    L5:
        r0.setText(r2);     // Catch: Exception -> L7
        return;
    }

    public final void i(boolean r3) {
        AppCompatTextView r0 = this.g;     // Catch: IndexOutOfBoundsException -> L22
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mDescView");     // Catch: IndexOutOfBoundsException -> L22
        r0 = null;
    L5:
        if (r3 == false) goto L8;
        MovementMethod r4 = com.bytedance.awemeopen.apps.framework.feed.desc.b.a;     // Catch: IndexOutOfBoundsException -> L22
    L20:
        r0.setMovementMethod(r4);     // Catch: IndexOutOfBoundsException -> L22
        return;
    L8:
        if (com.bytedance.awemeopen.apps.framework.feed.desc.a.a == null) goto L10;
    L19:
        r4 = com.bytedance.awemeopen.apps.framework.feed.desc.a.a;     // Catch: IndexOutOfBoundsException -> L22
        goto L20
    L10:
        monitor-enter(com.bytedance.awemeopen.apps.framework.feed.desc.c.class);     // Catch: IndexOutOfBoundsException -> L22
    L16:
        th = move-exception;
        throw th;     // Catch: IndexOutOfBoundsException -> L22
    L12:
        if (com.bytedance.awemeopen.apps.framework.feed.desc.a.a != null) goto L14;
        com.bytedance.awemeopen.apps.framework.feed.desc.a.a = new com.bytedance.awemeopen.apps.framework.feed.desc.a();     // Catch: Throwable -> L16
    L14:
        monitor-exit(com.bytedance.awemeopen.apps.framework.feed.desc.c.class);     // Catch: Throwable -> L16
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int f(ScrollMentionTextView r2, int r3) {
        Layout r0 = r2.getLayout();
        if (r0 == null) goto L7;
        TextPaint r1 = r0.getPaint();
        if (r1 == null) goto L7;
        Paint.FontMetrics r4 = r1.getFontMetrics();
    L8:
        if (r4 != null) goto L10;
        return 0;
    L10:
        return (int) ((r3 * (r4.bottom - r4.top)) + ((r3 - 1) * r2.getLineSpacingExtra()));
    L7:
        r4 = null;
        goto L8
    }

    public q(Context r2, s r3, t r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "event");
        Intrinsics.checkNotNullParameter(r4, "model");
        super(r2, r3, r4);
        this.t = 2131363066;
        this.u = new ArrayList();
        this.v = new a(this);
    }

    public static void g(final q r16, final SpannableStringBuilder r17, boolean r18) {
        ViewGroup r3 = r16.h;
        if (r3 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mDescToggleContainer");
        r3 = null;
    L6:
        if (r3.getVisibility() == 0) goto L9;
        return;
    L9:
        if (r16.p == r18) goto L140;
        AppCompatTextView r4 = r16.g;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mDescView");
        r4 = null;
    L14:
        r16.p = r18;
        ViewGroup r7 = r16.h;
        if (r7 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mDescToggleContainer");
        r7 = null;
    L17:
        r7.setTag(r16.t, Boolean.valueOf(r18));
        if (r18 == true) goto L20;
        r4.postDelayed(new m(r16, r17), 250);
    L21:
        AppCompatTextView r5 = r16.g;
        if (r5 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mDescView");
        r5 = null;
    L24:
        r5.scrollTo(0, 0);
        r16.i(r18);
        if (r18 == true) goto L27;
        int r8 = r16.n;
    L59:
        if (r18 == true) goto L61;
    L63:
        boolean r9 = false;
    L64:
        r16.o = r9;
        final Ref.IntRef r10 = new Ref.IntRef();
        if (r18 == false) goto L85;
        r16.m = r8;
        int r11 = r4.getLineCount();
        float r13 = r4.getWidth();
        Layout r6 = r4.getLayout();
        if (r6 == null) goto L69;
        float r12 = r6.getLineWidth(r11 - 1);
    L70:
        float r14 = r13 - r12;
        if (r16.o == true) goto L81;
        r16.e(false);
        TextView r15 = r16.i;
        if (r15 != null) goto L75;
        Intrinsics.throwUninitializedPropertyAccessException("mDescToggleView");
        r15 = null;
    L75:
        int r19 = r15.getWidth();
        Resources r110 = Resources.getSystem();
        if (r14 >= (r19 + MathKt.roundToInt(TypedValue.applyDimension(1, 24, WindowDisplayMetricsOverride.apply(r110, r110.getDisplayMetrics()))))) goto L89;
        TextView r20 = r16.i;
        if (r20 != null) goto L80;
        Intrinsics.throwUninitializedPropertyAccessException("mDescToggleView");
        r20 = null;
    L80:
        int r21 = r20.getHeight();
        Resources r22 = Resources.getSystem();
        r10.element = r21 + MathKt.roundToInt(TypedValue.applyDimension(1, 4, WindowDisplayMetricsOverride.apply(r22, r22.getDisplayMetrics())));
        Function0<Unit> r23 = new DescElementView$onToggleClick$2(r16, r10);
    L90:
        r r24 = new r(r16, r18, r17);
        if (r18 == false) goto L114;
        Animator[] r1 = new Animator[1];
        ScrollMentionTextView r25 = r16.g;
        if (r25 != null) goto L95;
        Intrinsics.throwUninitializedPropertyAccessException("mDescView");
        r25 = null;
    L95:
        r1[0] = FeedLongDescAnimator.a(r25, r16.n, r16.m, r24);
        List r2 = CollectionsKt.mutableListOf(r1);
        TextView r26 = r16.i;
        if (r26 != null) goto L98;
        Intrinsics.throwUninitializedPropertyAccessException("mDescToggleView");
        r26 = null;
    L98:
        r26.setAlpha(0.0f);
        TextView r27 = r16.i;
        if (r27 != null) goto L101;
        Intrinsics.throwUninitializedPropertyAccessException("mDescToggleView");
        r27 = null;
    L101:
        r27.setText(2131894202);
        if (r23 != null) goto L104;
    L109:
        FeedLongDescAnimator.c(r2);
        TextView r28 = r16.i;
        if (r28 != null) goto L112;
        Intrinsics.throwUninitializedPropertyAccessException("mDescToggleView");
        TextView r29 = null;
    L113:
        r29.postDelayed(new n(r16), 300);
    L137:
        ((t) r16.c).b.b(Boolean.valueOf(r18));
        return;
    L112:
        r29 = r28;
        goto L113
    L104:
        if (r10.element == 0) goto L109;
        ViewGroup r30 = r16.f;
        if (r30 != null) goto L108;
        Intrinsics.throwUninitializedPropertyAccessException("mDescContainer");
        r30 = null;
    L108:
        r2.add(FeedLongDescAnimator.b(r30, 0, r10.element, 300));
        goto L109
    L114:
        Animator[] r31 = new Animator[1];
        ScrollMentionTextView r32 = r16.g;
        if (r32 != null) goto L117;
        Intrinsics.throwUninitializedPropertyAccessException("mDescView");
        r32 = null;
    L117:
        r31[0] = FeedLongDescAnimator.a(r32, r16.m, r16.n, r24);
        List r33 = CollectionsKt.mutableListOf(r31);
        TextView r34 = r16.i;
        if (r34 != null) goto L120;
        Intrinsics.throwUninitializedPropertyAccessException("mDescToggleView");
        r34 = null;
    L120:
        r34.setAlpha(0.0f);
        TextView r35 = r16.i;
        if (r35 != null) goto L123;
        Intrinsics.throwUninitializedPropertyAccessException("mDescToggleView");
        r35 = null;
    L123:
        r35.setText(2131894191);
        ViewGroup r36 = r16.f;
        if (r36 != null) goto L126;
        Intrinsics.throwUninitializedPropertyAccessException("mDescContainer");
        r36 = null;
    L126:
        int r37 = r36.getPaddingBottom();
        if (r37 == 0) goto L132;
        ViewGroup r38 = r16.f;
        if (r38 != null) goto L131;
        Intrinsics.throwUninitializedPropertyAccessException("mDescContainer");
        r38 = null;
    L131:
        r33.add(FeedLongDescAnimator.b(r38, r37, 0, 50));
    L132:
        FeedLongDescAnimator.c(r33);
        TextView r39 = r16.i;
        if (r39 != null) goto L135;
        Intrinsics.throwUninitializedPropertyAccessException("mDescToggleView");
        TextView r40 = null;
    L136:
        r40.postDelayed(new o(r16), 300);
        goto L137
    L135:
        r40 = r39;
    L89:
        r23 = null;
        goto L90
    L81:
        r16.e(true);
        TextView r41 = r16.i;
        if (r41 != null) goto L84;
        Intrinsics.throwUninitializedPropertyAccessException("mDescToggleView");
        r41 = null;
    L84:
        int r42 = r41.getHeight();
        Resources r43 = Resources.getSystem();
        r10.element = r42 + MathKt.roundToInt(TypedValue.applyDimension(1, 4, WindowDisplayMetricsOverride.apply(r43, r43.getDisplayMetrics())));
        r23 = new DescElementView$onToggleClick$3(r16, r10);
        goto L90
    L69:
        r12 = 0.0f;
        goto L70
    L85:
        r16.e(false);
        ViewGroup r44 = r16.f;
        if (r44 != null) goto L88;
        Intrinsics.throwUninitializedPropertyAccessException("mDescContainer");
        r44 = null;
    L88:
        r44.setPadding(0, 0, 0, 0);
        goto L89
    L61:
        if (r8 == r16.k) goto L63;
        r9 = true;
        goto L64
    L27:
        if (r16.q != 0) goto L57;
        int r45 = d0.c(r16.getContext());
        int r46 = (int) (r45 * 0.5f);
        AppCompatTextView r111 = r16.g;
        if (r111 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("mDescView");
        r111 = null;
    L31:
        int r112 = r111.getLineHeight();
        if (r112 == 0) goto L56;
        Function0<Integer> r113 = ((t) r16.c).f;
        if (r113 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("descExpandTopY");
        r113 = null;
    L38:
        int r114 = ((Number) r113.invoke()).intValue();
        if (r114 != 0) goto L42;
        int r47 = Math.min(r16.k, r46);
    L41:
        r46 = r47;
        goto L56
    L42:
        int[] r115 = new int[2];
        r111.getLocationOnScreen(r115);
        int r116 = Math.abs((r115[1] + r111.getHeight()) - r114);
        if (r116 <= r45) goto L46;
        r116 = r46;
    L46:
        if (r116 < r16.n) goto L49;
        r46 = r116;
    L49:
        float r48 = r112 + r111.getLineSpacingExtra();
        float r49 = ((((int) (r46 / r48)) * r48) - MathKt.roundToInt(r48 / 2.0f)) - r48;
        int r50 = r16.k;
        if (r50 != 0) goto L52;
    L54:
        r47 = MathKt.roundToInt(r49);
        goto L41
    L52:
        if (r50 >= r49) goto L54;
        r46 = r50;
    L56:
        r16.q = r46;
    L57:
        r8 = r16.q;
        goto L59
    L20:
        r16.h(r17);
        goto L21
    }
}
