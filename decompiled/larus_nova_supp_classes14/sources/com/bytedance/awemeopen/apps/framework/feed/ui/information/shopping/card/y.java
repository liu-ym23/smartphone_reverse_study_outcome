package com.bytedance.awemeopen.apps.framework.feed.ui.information.shopping.card;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.lifecycle.Observer;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtTextView;
import com.bytedance.awemeopen.bizmodels.feed.shopping.card.DetailPromotion;
import com.bytedance.awemeopen.infra.base.image.AoImageView;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.awemeopen.writtenlayout.IWrittenLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class y extends com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c<a0, b0> {
    public static final Typeface v = null;
    public static final Interpolator w = null;
    public LinearLayout e;
    public LinearLayout f;
    public AoImageView g;
    public TextView h;
    public View i;
    public TextView j;
    public TextView k;
    public LinearLayout l;
    public DmtTextView m;
    public DmtTextView n;
    public DmtTextView o;
    public DmtTextView p;
    public AwemeFeedProductCard q;
    public Map<String, String> r;
    public String s;
    public List<String> t;
    public AnimatorSet u;

    public static final class a {
    }

    public static final class b extends IWrittenLayout {
        public final /* synthetic */ y c;

        public final View f() {
            ViewGroup.LayoutParams r0 = new ViewGroup.LayoutParams(-2, -2);
            final y r2 = this.c;
            Function1<FrameLayout, Unit> r1 = new ShoppingCardElementView$createView$1$createView$1(r2, this);
            Intrinsics.checkNotNullParameter(r0, "lparams");
            return n(r0, r1);
        }

        public b(y r1, Context r2) {
            this.c = r1;
            super(r2);
        }
    }

    public static final class c extends com.bytedance.awemeopen.apps.framework.utils.o {
        public final /* synthetic */ y d;

        @Override // com.bytedance.awemeopen.apps.framework.utils.o
        public final void a() {
            ((a0) this.d.b).a.b(Unit.INSTANCE);
        }

        public c(y r1) {
            this.d = r1;
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void e() {
        AoLogger.g("doFirstDelayAnimation", new Object[0]);
        final LinearLayout r1 = this.e;
        if (r1 == null) goto L115;
        final LinearLayout r2 = this.l;
        if (r2 != null) goto L7;
        return;
    L7:
        if (h() == true) goto L34;
        DmtTextView r3 = this.n;
        if (r3 == null) goto L18;
        CharSequence r4 = r3.getText();
        if (r4 == null) goto L18;
        if (r4.length() <= 0) goto L15;
        boolean r5 = true;
    L16:
        if (r5 != true) goto L18;
        boolean r6 = true;
    L19:
        if (r6 == true) goto L34;
        DmtTextView r7 = this.p;
        if (r7 == null) goto L30;
        CharSequence r8 = r7.getText();
        if (r8 == null) goto L30;
        if (r8.length() <= 0) goto L27;
        boolean r9 = true;
    L28:
        if (r9 != true) goto L30;
        boolean r10 = true;
    L31:
        if (r10 == true) goto L34;
        boolean r11 = false;
    L35:
        if (r11 == true) goto L38;
        return;
    L38:
        if (r1.getWidth() != 0) goto L40;
        r1.post(new l(this));
        return;
    L40:
        AoLogger.g("doFirstDelayAnimation, tags visible", new Object[0]);
        boolean r12 = h();
        if (r12 == true) goto L55;
        DmtTextView r13 = this.n;
        if (r13 == null) goto L52;
        CharSequence r14 = r13.getText();
        if (r14 == null) goto L52;
        if (r14.length() <= 0) goto L49;
        boolean r15 = true;
    L50:
        if (r15 != true) goto L52;
        boolean r16 = true;
    L53:
        if (r16 == false) goto L55;
        boolean r17 = true;
    L56:
        if (r12 == true) goto L70;
        DmtTextView r18 = this.p;
        if (r18 == null) goto L67;
        CharSequence r19 = r18.getText();
        if (r19 == null) goto L67;
        if (r19.length() <= 0) goto L64;
        boolean r20 = true;
    L65:
        if (r20 != true) goto L67;
        boolean r21 = true;
    L68:
        if (r21 == false) goto L70;
        boolean r22 = true;
    L71:
        AppCompatTextView r23 = this.m;
        int r24 = 8;
        if (r23 == null) goto L78;
        if (r12 == false) goto L76;
        int r25 = 0;
    L77:
        r23.setVisibility(r25);
        goto L78
    L76:
        r25 = 8;
    L78:
        AppCompatTextView r26 = this.n;
        if (r26 == null) goto L85;
        if (r17 == false) goto L83;
        int r27 = 0;
    L84:
        r26.setVisibility(r27);
        goto L85
    L83:
        r27 = 8;
    L85:
        AppCompatTextView r28 = this.p;
        if (r28 == null) goto L92;
        if (r22 == false) goto L90;
        int r29 = 0;
    L91:
        r28.setVisibility(r29);
        goto L92
    L90:
        r29 = 8;
    L92:
        AppCompatTextView r30 = this.o;
        if (r30 == null) goto L99;
        if (r17 == false) goto L98;
        if (r22 == false) goto L98;
        r24 = 0;
    L98:
        r30.setVisibility(r24);
    L99:
        AnimatorSet r31 = this.u;
        if (r31 == null) goto L102;
        r31.cancel();
    L102:
        r2.clearAnimation();
        r2.setVisibility(0);
        r2.setAlpha(0.0f);
        r2.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int r32 = RangesKt.coerceAtLeast(r2.getMeasuredHeight(), r2.getMinimumHeight());
        LinearLayout r33 = this.f;
        if (r33 == null) goto L105;
        int r34 = r33.getMeasuredHeight();
    L106:
        int r35 = RangesKt.coerceAtLeast((r34 + r1.getPaddingTop()) + r1.getPaddingBottom(), 0);
        int r36 = r32 + r35;
        ViewGroup.LayoutParams r37 = r2.getLayoutParams();
        if ((r37 instanceof ViewGroup.MarginLayoutParams) == false) goto L109;
        ViewGroup.MarginLayoutParams r38 = (ViewGroup.MarginLayoutParams) r37;
    L110:
        if (r38 != null) goto L112;
        int r39 = 0;
    L113:
        ValueAnimator r40 = ValueAnimator.ofInt(new int[]{r35, r36 + r39});
        r40.setDuration(320);
        Interpolator r41 = w;
        r40.setInterpolator(r41);
        r40.addUpdateListener(new n(r1));
        ValueAnimator r42 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r42.setDuration(320);
        r42.setInterpolator(r41);
        r42.addUpdateListener(new o(r2));
        AnimatorSet r43 = new AnimatorSet();
        r43.playTogether(new Animator[]{r40, r42});
        r43.addListener(new z(r2, r1, this));
        r43.start();
        this.u = r43;
        return;
    L112:
        r39 = r38.topMargin + r38.bottomMargin;
        goto L113
    L109:
        r38 = null;
        goto L110
    L105:
        r34 = 0;
        goto L106
    L64:
        r20 = false;
    L67:
        r21 = false;
    L70:
        r22 = false;
        goto L71
    L49:
        r15 = false;
    L52:
        r16 = false;
    L55:
        r17 = false;
        goto L56
    L27:
        r9 = false;
    L30:
        r10 = false;
        goto L31
    L15:
        r5 = false;
    L18:
        r6 = false;
    L34:
        r11 = true;
        goto L35
    }

    static {
        v = Typeface.create("sans-serif-medium", 0);
        w = PathInterpolatorCompat.create(0.0f, 0.4f, 0.2f, 1.0f);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final void c() {
        LinearLayout r0 = this.e;
        if (r0 == null) goto L5;
        r0.setOnClickListener(new c(this));
    L5:
        b0 r1 = (b0) this.c;
        Observer<com.bytedance.awemeopen.infra.base.image.b> r2 = new k(this);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "observer");
        r1.a.a(r2);
        b0 r3 = (b0) this.c;
        Observer<Triple<String, String, String>> r4 = new p(this);
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, "observer");
        r3.b.a(r4);
        b0 r5 = (b0) this.c;
        Observer<List<String>> r6 = new q(this);
        r5.getClass();
        Intrinsics.checkNotNullParameter(r6, "observer");
        r5.d.a(r6);
        b0 r7 = (b0) this.c;
        Observer<Map<String, String>> r8 = new r(this);
        r7.getClass();
        Intrinsics.checkNotNullParameter(r8, "observer");
        r7.c.a(r8);
        b0 r9 = (b0) this.c;
        Observer<Boolean> r10 = new s(this);
        r9.getClass();
        Intrinsics.checkNotNullParameter(r10, "observer");
        r9.e.a(r10);
        b0 r11 = (b0) this.c;
        Observer<List<DetailPromotion>> r12 = new t(this);
        r11.getClass();
        Intrinsics.checkNotNullParameter(r12, "observer");
        r11.f.a(r12);
        b0 r13 = (b0) this.c;
        Observer<Unit> r14 = new u(this);
        r13.getClass();
        Intrinsics.checkNotNullParameter(r14, "observer");
        r13.g.a(r14);
        b0 r15 = (b0) this.c;
        Observer<Unit> r16 = new v(this);
        r15.getClass();
        Intrinsics.checkNotNullParameter(r16, "observer");
        r15.i.a(r16);
    }

    public final boolean h() {
        DmtTextView r0 = this.m;
        if (r0 == null) goto L12;
        CharSequence r1 = r0.getText();
        if (r1 == null) goto L12;
        if (r1.length() <= 0) goto L9;
        boolean r2 = true;
    L10:
        if (r2 != true) goto L12;
        boolean r3 = true;
    L13:
        if (r3 == false) goto L26;
        Map<String, String> r4 = this.r;
        if (r4 == null) goto L17;
        String r5 = r4.get("anchor_coupon_info");
    L18:
        if (r5 != null) goto L20;
    L23:
        boolean r6 = true;
    L24:
        if (r6 == false) goto L26;
        return true;
    L20:
        if (r5.length() == 0) goto L23;
        r6 = false;
        goto L24
    L17:
        r5 = null;
    L26:
        return false;
    L9:
        r2 = false;
    L12:
        r3 = false;
        goto L13
    }

    public final void i() {
        Map<String, String> r0 = this.r;
        TextView r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.get("anchor_coupon_info");
    L6:
        boolean r3 = true;
        if (r2 != null) goto L9;
    L12:
        boolean r4 = true;
    L14:
        if (r4 == true) goto L22;
        TextView r5 = this.k;
        if (r5 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("suffixTextView");
        r5 = null;
    L18:
        x54.b.d(r5);
        TextView r6 = this.k;
        if (r6 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("suffixTextView");
        r6 = null;
    L21:
        r6.setText(" · " + r2);
    L45:
        final LinearLayout r7 = this.e;
        if (r7 == null) goto L64;
        LinearLayout r8 = this.f;
        if (r8 == null) goto L51;
        ViewGroup.LayoutParams r9 = r8.getLayoutParams();
    L52:
        if (r9 == null) goto L55;
        r9.width = -2;
    L55:
        TextView r10 = this.j;
        if (r10 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
    L59:
        r1.setMaxWidth(Integer.MAX_VALUE);
        r7.setMinimumWidth(0);
        LinearLayout r11 = this.f;
        if (r11 == null) goto L62;
        r11.requestLayout();
    L62:
        r7.post(new m(this, r7));
        return;
    L58:
        r1 = r10;
        goto L59
    L51:
        r9 = null;
        goto L52
    L64:
        return;
    L22:
        String r12 = this.s;
        if (r12 != null) goto L25;
    L28:
        if (r3 == true) goto L41;
        TextView r13 = this.j;
        if (r13 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
        r13 = null;
    L33:
        if (r13.getVisibility() != 0) goto L41;
        TextView r14 = this.k;
        if (r14 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("suffixTextView");
        r14 = null;
    L37:
        x54.b.d(r14);
        TextView r15 = this.k;
        if (r15 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("suffixTextView");
        r15 = null;
    L40:
        r15.setText(" · " + this.s);
    L41:
        TextView r16 = this.k;
        if (r16 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("suffixTextView");
        r16 = null;
    L44:
        x54.b.a(r16);
        goto L45
    L25:
        if (r12.length() == 0) goto L28;
        r3 = false;
        goto L28
    L9:
        if (r2.length() == 0) goto L12;
        r4 = false;
        goto L14
    L5:
        r2 = null;
        goto L6
    }

    public final void j() {
        Map<String, String> r0 = this.r;
        if (r0 == null) goto L5;
        String r1 = r0.get("anchor_coupon_info");
    L6:
        int r2 = 0;
        if (r1 != null) goto L9;
    L12:
        boolean r3 = true;
    L14:
        if ((!r3) == true) goto L16;
        return;
    L16:
        List<String> r4 = this.t;
        if (r4 != null) goto L19;
    L21:
        boolean r5 = false;
    L22:
        String r6 = this.s;
        if (r6 != null) goto L25;
    L28:
        boolean r7 = true;
    L29:
        CharSequence r8 = "";
        if (r7 == true) goto L49;
        AppCompatTextView r9 = this.n;
        if (r9 == null) goto L35;
        r9.setText(this.s);
    L35:
        if (r5 == false) goto L45;
        AppCompatTextView r10 = this.p;
        if (r10 == null) goto L86;
        List<String> r11 = this.t;
        if (r11 == null) goto L44;
        CharSequence r12 = (String) CollectionsKt.firstOrNull(r11);
        if (r12 == null) goto L44;
        r8 = r12;
    L44:
        r10.setText(r8);
        return;
    L86:
        return;
    L45:
        AppCompatTextView r13 = this.p;
        if (r13 == null) goto L87;
        r13.setText("");
        return;
    L87:
        return;
    L49:
        if (r5 == false) goto L74;
        AppCompatTextView r14 = this.n;
        if (r14 == null) goto L60;
        List<String> r15 = this.t;
        if (r15 == null) goto L58;
        CharSequence r16 = (String) CollectionsKt.firstOrNull(r15);
        if (r16 == null) goto L58;
    L59:
        r14.setText(r16);
    L58:
        r16 = "";
    L60:
        AppCompatTextView r17 = this.p;
        if (r17 == null) goto L88;
        List<String> r18 = this.t;
        if (r18 == null) goto L66;
        r2 = r18.size();
    L66:
        if (r2 <= 1) goto L73;
        List<String> r19 = this.t;
        if (r19 == null) goto L73;
        CharSequence r20 = (String) CollectionsKt.getOrNull(r19, 1);
        if (r20 == null) goto L73;
        r8 = r20;
    L73:
        r17.setText(r8);
        return;
    L88:
        return;
    L74:
        AppCompatTextView r21 = this.n;
        if (r21 == null) goto L78;
        r21.setText("");
    L78:
        AppCompatTextView r22 = this.p;
        if (r22 == null) goto L89;
        r22.setText("");
        return;
    L89:
        return;
    L25:
        if (r6.length() == 0) goto L28;
        r7 = false;
        goto L29
    L19:
        if ((!r4.isEmpty()) != true) goto L21;
        r5 = true;
        goto L22
    L9:
        if (r1.length() == 0) goto L12;
        r3 = false;
        goto L14
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final View a(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "parentView");
        return new b(this, getContext()).j();
    }

    public final int f(View r2) {
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        if ((r3 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r4 = (ViewGroup.MarginLayoutParams) r3;
    L6:
        if (r4 != null) goto L10;
        return 0;
    L10:
        return r4.getMarginStart() + r4.getMarginEnd();
    L5:
        r4 = null;
        goto L6
    }

    public final void g(boolean r4) {
        AnimatorSet r0 = this.u;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.u = null;
        if (r4 == false) goto L8;
        this.r = null;
        this.s = null;
        this.t = null;
    L8:
        LinearLayout r1 = this.e;
        if (r1 == null) goto L11;
        r1.setVisibility(0);
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        r2.height = -2;
        r1.setLayoutParams(r2);
        r1.requestLayout();
    L11:
        LinearLayout r3 = this.l;
        if (r3 == null) goto L14;
        r3.setAlpha(0.0f);
        r3.setVisibility(8);
        r3.requestLayout();
    L14:
        AppCompatTextView r5 = this.m;
        if (r5 == null) goto L19;
        r5.setVisibility(8);
        if (r4 == false) goto L19;
        r5.setText("");
    L19:
        AppCompatTextView r6 = this.n;
        if (r6 == null) goto L24;
        r6.setVisibility(8);
        if (r4 == false) goto L24;
        r6.setText("");
    L24:
        AppCompatTextView r7 = this.p;
        if (r7 == null) goto L29;
        r7.setVisibility(8);
        if (r4 == false) goto L29;
        r7.setText("");
    L29:
        AppCompatTextView r8 = this.o;
        if (r8 == null) goto L34;
        r8.setVisibility(8);
        return;
    }

    public y(Context r2, a0 r3, b0 r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "event");
        Intrinsics.checkNotNullParameter(r4, "model");
        super(r2, r3, r4);
    }

    public final int d(int r6, List<? extends View> r7, TextView r8, View r9) {
        if (r6 > 0) goto L4;
        return Integer.MAX_VALUE;
    L4:
        if (r8.getVisibility() != 0) goto L41;
        ArrayList r0 = new ArrayList();
        Iterator<T> r10 = r7.iterator();
    L7:
        boolean r2 = false;
        boolean r3 = true;
        if (r10.hasNext() == false) goto L14;
        Object r1 = r10.next();
        if (((View) r1).getVisibility() != 0) goto L12;
        r2 = true;
    L12:
        if (r2 == false) goto L7;
        r0.add(r1);
        goto L7
    L14:
        Iterator r11 = r0.iterator();
        int r4 = 0;
    L16:
        if (r11.hasNext() == false) goto L18;
        View r5 = (View) r11.next();
        r4 = r4 + (r5.getMeasuredWidth() + f(r5));
        goto L16
    L18:
        CharSequence r12 = r8.getText();
        if (r12 == null) goto L21;
        String r13 = r12.toString();
    L22:
        if (r13 != null) goto L25;
        r13 = "";
    L25:
        if (r13.length() == 0) goto L28;
        r3 = false;
    L28:
        if (r3 == false) goto L30;
        int r14 = 0;
    L32:
        return RangesKt.coerceAtMost(r14 + f(r8), RangesKt.coerceAtLeast((r6 - r4) - f(r9), 0));
    L30:
        r14 = (int) r8.getPaint().measureText(r13);
        goto L32
    L21:
        r13 = null;
        goto L22
    L41:
        return Integer.MAX_VALUE;
    }
}
