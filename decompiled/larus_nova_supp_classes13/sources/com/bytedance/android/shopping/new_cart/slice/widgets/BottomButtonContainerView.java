package com.bytedance.android.shopping.new_cart.slice.widgets;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.utils.d2;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.ecom.arch.slice.render.util.SlcDimensExtensionsKt;
import com.bytedance.android.ecom.arch.slice.render.util.SlcViewExtensionsKt;
import com.bytedance.android.ecom.arch.slice.render.widget.roundcorner.SlcRoundLinearlayout;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.bytedance.android.shopping.new_cart.container.b0;
import com.bytedance.android.shopping.new_cart.utils.CartCommonLog;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class BottomButtonContainerView extends SlcRoundLinearlayout {
    public final int a;
    public int b;
    public final b0 c;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ LinearLayout a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ BottomButtonContainerView d;
        public final /* synthetic */ com.bytedance.android.ecom.arch.slice.render.context.b e;
        public final /* synthetic */ List f;

        public a(LinearLayout r1, String r2, String r3, BottomButtonContainerView r4, com.bytedance.android.ecom.arch.slice.render.context.b r5, List r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
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
        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            View r0 = new View(this.a.getContext());
            r0.setLayoutParams(new LinearLayout.LayoutParams(0, -1));
            r0.setBackground(r10.getBackground());
            if (Intrinsics.areEqual(this.c, "delete") == false) goto L6;
            this.d.addView(r0);
            BottomButtonContainerView.b(this.d, r0, this.c, this.e, 1);
            return;
        L6:
            if (Intrinsics.areEqual(this.c, "collect") == false) goto L23;
            SlcRoundLinearlayout r1 = this.d;
            int r4 = r1.getChildCount();
            int r5 = 0;
        L8:
            if (r5 >= r4) goto L22;
            View r6 = r1.getChildAt(r5);
            if ((!Intrinsics.areEqual(r6, r10)) == false) goto L21;
            int r7 = s.a;
            Integer r8 = s.b(this.b);
            if (r8 == null) goto L14;
            int r9 = r8.intValue();
        L15:
            r6.setBackgroundColor(r9);
            TextView r11 = (TextView) r6.findViewById(2131388772);
            if (r11 == null) goto L18;
            r11.setVisibility(8);
        L18:
            ECDraweeView r12 = r6.findViewById(2131374718);
            if (r12 == null) goto L21;
            r12.setVisibility(8);
            goto L21
        L14:
            r9 = 0;
        L21:
            r5 = r5 + 1;
            goto L8
        L22:
            this.d.addView(r0);
            BottomButtonContainerView.b(this.d, r0, this.c, this.e, this.f.size());
            return;
        L23:
            BaseSlcViewManager r13 = SlcViewExtensionsKt.g(this.d);
            if (r13 == null) goto L33;
            r13.a.d(new SlcCommonAction(this.c + "Click", MapsKt.emptyMap()), this.d, r13.l(), null, null);
            return;
        }
    }

    private final int getScreenWidth() {
        b0 r0 = this.c;
        if (r0 == null) goto L9;
        Function0<Integer> r1 = r0.f;
        if (r1 == null) goto L9;
        Integer r2 = (Integer) r1.invoke();
        if (r2 == null) goto L9;
        return r2.intValue();
    L9:
        return 0;
    }

    public final b0 getActions() {
        return this.c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchTouchEvent(final MotionEvent r6) {
        if (r6 != null) goto L5;
        return false;
    L5:
        int r1 = r6.getAction();
        if (r1 != 0) goto L8;
        this.b = (int) r6.getRawX();
    L30:
        return super/*android.widget.LinearLayout*/.dispatchTouchEvent(r6);
    L8:
        if (r1 != 1) goto L10;
        final int r2 = Math.abs(((int) r6.getRawX()) - this.b);
        Lazy r4 = CartCommonLog.a;
        CartCommonLog.a("BottomButtonContainerView", new AnonymousClass2(this, r2, r6));
        if (r2 <= ViewConfiguration.get(getContext()).getScaledTouchSlop()) goto L30;
        b0 r7 = this.c;
        if (r7 == null) goto L27;
        Function0<WeakReference<ProductCardContainerView>> r8 = r7.a;
        if (r8 == null) goto L27;
        WeakReference r9 = (WeakReference) r8.invoke();
        if (r9 == null) goto L27;
        ProductCardContainerView r10 = (ProductCardContainerView) r9.get();
        if (r10 == null) goto L27;
        ProductCardContainerView.g(r10, false);
    L27:
        return true;
    L10:
        if (r1 != 2) goto L30;
        final int r0 = Math.abs(((int) r6.getRawX()) - this.b);
        Lazy r3 = CartCommonLog.a;
        CartCommonLog.a("BottomButtonContainerView", new AnonymousClass1(this, r0, r6));
        if (r0 <= ViewConfiguration.get(getContext()).getScaledTouchSlop()) goto L30;
        getParent().requestDisallowInterceptTouchEvent(true);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BottomButtonContainerView(Context r3, b0 r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, null, 0);
        this.c = r4;
        this.a = 70;
        setOrientation(0);
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c(List<? extends Map<String, ? extends Object>> r21, com.bytedance.android.ecom.arch.slice.render.context.b r22) {
        Intrinsics.checkNotNullParameter(r22, "displayMetrics");
        removeAllViews();
        if (r21 == null) goto L76;
        Iterator<T> r9 = r21.iterator();
    L6:
        if (r9.hasNext() == false) goto L80;
        Map r0 = (Map) r9.next();
        Object r1 = null;
        if (r0 == null) goto L10;
        Object r2 = r0.get("text");
    L12:
        if ((r2 instanceof String) == true) goto L14;
        r2 = null;
    L14:
        String r3 = (String) r2;
        if (r0 == null) goto L17;
        Object r4 = r0.get("fontSize");
    L19:
        if ((r4 instanceof Float) == true) goto L21;
        r4 = null;
    L21:
        Float r5 = (Float) r4;
        if (r0 == null) goto L24;
        Object r6 = r0.get("bold");
    L26:
        if ((r6 instanceof Integer) == true) goto L28;
        r6 = null;
    L28:
        Integer r7 = (Integer) r6;
        if (r0 == null) goto L31;
        Object r8 = r0.get("color");
    L33:
        if ((r8 instanceof String) == true) goto L35;
        r8 = null;
    L35:
        String r10 = (String) r8;
        if (r0 == null) goto L38;
        Object r11 = r0.get("bg");
    L40:
        if ((r11 instanceof String) == true) goto L42;
        r11 = null;
    L42:
        String r12 = (String) r11;
        if (r0 == null) goto L45;
        Object r13 = r0.get("url");
    L47:
        if ((r13 instanceof String) == true) goto L49;
        r13 = null;
    L49:
        String r14 = (String) r13;
        if (r0 == null) goto L52;
        Object r15 = r0.get("key");
    L54:
        if ((r15 instanceof String) == false) goto L57;
        r1 = r15;
    L57:
        String r16 = (String) r1;
        LinearLayout r17 = new LinearLayout(getContext());
        r17.setOrientation(1);
        r17.setLayoutParams(new LinearLayout.LayoutParams(SlcDimensExtensionsKt.a(Integer.valueOf(this.a), r22), -1));
        Integer r18 = s.b(r12);
        if (r18 == null) goto L60;
        r17.setBackgroundColor(r18.intValue());
    L60:
        ECDraweeView r19 = new ECDraweeView(r17.getContext(), null, 0, 6, null);
        r19.setId(2131374718);
        r19.setLayoutParams(new LinearLayout.LayoutParams(SlcDimensExtensionsKt.a(20, r22), SlcDimensExtensionsKt.a(20, r22)));
        r17.setGravity(17);
        d2.d(r19, 0, 0, 0, SlcDimensExtensionsKt.a(2, r22));
        h0.e(r19, r14, null, null, null, 120);
        TextView r110 = new TextView(r17.getContext());
        r110.setId(2131388772);
        r110.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        r110.setText(r3);
        Integer r20 = s.b(r10);
        if (r20 == null) goto L63;
        r110.setTextColor(r20.intValue());
    L63:
        if (r5 == null) goto L65;
        float r23 = SlcDimensExtensionsKt.e(r5, r22);
    L66:
        r110.setTextSize(0, r23);
        r110.setGravity(17);
        if (r7 != null) goto L70;
    L71:
        if (r7 == null) goto L74;
        int r24 = r7.intValue();
    L75:
        ViewExtensionsKt.e(r110, r110.getPaint(), r24);
        r17.addView(r19);
        r17.addView(r110);
        r17.setOnClickListener(new a(r17, r12, r16, this, r22, r21));
        addView(r17);
    L74:
        r24 = 500;
        goto L75
    L70:
        if (r7.intValue() == 0) goto L74;
    L65:
        r23 = SlcDimensExtensionsKt.e(14, r22);
        goto L66
    L52:
        r15 = null;
        goto L54
    L45:
        r13 = null;
        goto L47
    L38:
        r11 = null;
        goto L40
    L31:
        r8 = null;
        goto L33
    L24:
        r6 = null;
        goto L26
    L17:
        r4 = null;
        goto L19
    L10:
        r2 = null;
        goto L12
    L80:
        return;
    }

    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.view.ViewGroup, com.bytedance.android.shopping.new_cart.slice.widgets.ProductCardContainerView] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    public static final void b(final BottomButtonContainerView r5, final View r6, String r7, com.bytedance.android.ecom.arch.slice.render.context.b r8, int r9) {
        r5.getClass();
        ViewParent r0 = r6.getParent();
        final ?? r2 = 0;
        r2 = 0;
        r2 = 0;
        if ((r0 instanceof ViewGroup) == true) goto L5;
        r0 = null;
    L5:
        ViewGroup r1 = (ViewGroup) r0;
        if (r1 == null) goto L8;
        r1.setLayoutDirection(0);
    L8:
        b0 r3 = r5.c;
        if (r3 == null) goto L15;
        Function0<WeakReference<ProductCardContainerView>> r4 = r3.a;
        if (r4 == null) goto L15;
        WeakReference r10 = (WeakReference) r4.invoke();
        if (r10 == null) goto L15;
        r2 = (ProductCardContainerView) r10.get();
    L15:
        if (r2 == 0) goto L17;
        final float r11 = r2.getTranslationX();
    L18:
        if (r2 == 0) goto L20;
        int r12 = r2.getWidth();
    L21:
        ValueAnimator r13 = ValueAnimator.ofInt(new int[]{0, r12 - (SlcDimensExtensionsKt.a(Integer.valueOf(r5.a), r8) * r9)});
        r13.setDuration(200);
        r13.addUpdateListener(new BottomButtonContainerView$startButtonAnimation$$inlined$apply$lambda$1(r5, r6, r2, r11));
        r13.addListener(new com.bytedance.android.shopping.new_cart.slice.widgets.a(r5, r6, r7));
        r13.start();
        return;
    L20:
        r12 = r5.getScreenWidth();
        goto L21
    L17:
        r11 = 0.0f;
        goto L18
    }
}
