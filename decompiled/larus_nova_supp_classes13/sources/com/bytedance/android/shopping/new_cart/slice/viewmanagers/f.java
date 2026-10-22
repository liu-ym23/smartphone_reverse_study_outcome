package com.bytedance.android.shopping.new_cart.slice.viewmanagers;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.TextViewCompat;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.shopping.new_cart.widgets.CartRootFrameLayoutContainer;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f extends com.bytedance.android.ecom.arch.slice.render.elements.flexbox.b {
    public String W3;
    public List<String> X3;
    public BubbleView Y3;
    public TextView Z3;
    public ECDraweeView a4;
    public ECDraweeView b4;
    public t c4;
    public Rect d4;
    public boolean e4;

    public f(SlcTemplateContext r19) {
        Intrinsics.checkNotNullParameter(r19, "context");
        super(r19);
        ((BaseSlcViewManager) this).j3 = true;
        ((BaseSlcViewManager) this).k3 = true;
        this.c4 = new t(getContext());
        this.Y3 = new BubbleView(getContext());
        TextView r2 = new TextView(getContext());
        r2.setId(View.generateViewId());
        r2.setTextSize(12.0f);
        TextViewCompat.setLineHeight(r2, com.bytedance.android.shopping.extensions.b.a(17));
        r2.setTextColor(com.bytedance.android.shopping.extensions.k.o("#161823"));
        r2.setTypeface(r2.getTypeface(), 1);
        r2.setGravity(8388659);
        Unit r1 = Unit.INSTANCE;
        this.Z3 = r2;
        ViewGroup.LayoutParams r3 = new ConstraintLayout.LayoutParams(-2, -2);
        ConstraintLayout r4 = this.Y3;
        if (r4 == null) goto L5;
        r4.addView(this.Z3, r3);
    L5:
        ECDraweeView r5 = new ECDraweeView(getContext(), null, 0, 6, null);
        h0.e(r5, "https://p26-piu.byteimg.com/tos-cn-i-8jisjyls3a/c7317b4edf01439f8d95907774ac3344~tplv-8jisjyls3a-3:0:0:q75.png", new com.bytedance.android.ec.core.imagex.r("ec_cart", "ec_cart_discount_info"), null, null, 120);
        this.a4 = r5;
        ViewGroup.LayoutParams r6 = new ConstraintLayout.LayoutParams(com.bytedance.android.shopping.extensions.b.a(12), com.bytedance.android.shopping.extensions.b.a(12));
        TextView r7 = this.Z3;
        if (r7 == null) goto L8;
        int r8 = r7.getId();
    L9:
        ((ConstraintLayout.LayoutParams) r6).leftToRight = r8;
        ConstraintLayout r9 = this.Y3;
        if (r9 == null) goto L12;
        r9.addView(this.a4, r6);
    L12:
        ECDraweeView r10 = new ECDraweeView(getContext(), null, 0, 6, null);
        h0.e(r10, "https://p6-piu.byteimg.com/tos-cn-i-8jisjyls3a/fcfc5bf2bcb34c7680b2b6d567d832c0~tplv-8jisjyls3a-3:0:0:q75.png", new com.bytedance.android.ec.core.imagex.r("ec_cart", "ec_cart_discount_info"), null, null, 120);
        this.b4 = r10;
        return;
    L8:
        r8 = -1;
        goto L9
    }

    public final void H0(Map<String, ? extends Object> r8) {
        Intrinsics.checkNotNullParameter(r8, "props");
        Object r0 = r8.get("anchor_slice_key");
        Rect r2 = null;
        if ((r0 instanceof String) == true) goto L5;
        r0 = null;
    L5:
        this.W3 = (String) r0;
        Object r9 = r8.get("bubble_content");
        if ((r9 instanceof List) == true) goto L8;
        r9 = null;
    L8:
        List<String> r10 = (List) r9;
        this.X3 = r10;
        int r1 = 0;
        if (this.W3 == null) goto L42;
        List<String> r11 = r10;
        if (r11 != null) goto L13;
    L16:
        boolean r12 = true;
    L17:
        if (r12 == true) goto L42;
        String r13 = this.W3;
        if (r13 == null) goto L27;
        BaseSlcViewManager r3 = M(r13);
        if ((r3 instanceof com.bytedance.android.ecom.arch.slice.render.elements.text.b) == true) goto L24;
        r3 = null;
    L24:
        com.bytedance.android.ecom.arch.slice.render.elements.text.b r4 = (com.bytedance.android.ecom.arch.slice.render.elements.text.b) r3;
        if (r4 == null) goto L27;
        r2 = r4.i(r13);
    L27:
        this.d4 = r2;
        if (r2 == null) goto L41;
        L1(true);
        List<String> r14 = this.X3;
        if (r14 == null) goto L47;
        TextView r5 = this.Z3;
        if (r5 == null) goto L48;
        r5.setMaxLines(r14.size());
        Iterator<T> r6 = r14.iterator();
        String r7 = "";
    L35:
        if (r6.hasNext() == false) goto L40;
        r7 = r7 + ((String) r6.next()).toString();
        if (r1 >= (r14.size() - 1)) goto L39;
        r7 = r7 + "\n";
    L39:
        r1 = r1 + 1;
        goto L35
    L40:
        r5.setText(r7);
        return;
    L48:
        return;
    L47:
        return;
    L41:
        L1(false);
        Unit r15 = Unit.INSTANCE;
        return;
    L13:
        if (r11.isEmpty() == true) goto L16;
        r12 = false;
    L42:
        L1(false);
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
    public final void L1(boolean r5) {
        t r0 = this.c4;
        int r1 = 8;
        if (r0 == null) goto L8;
        if (r5 == false) goto L6;
        int r3 = 0;
    L7:
        r0.setVisibility(r3);
        goto L8
    L6:
        r3 = 8;
    L8:
        ConstraintLayout r2 = this.Y3;
        if (r2 == null) goto L14;
        if (r5 == false) goto L12;
        int r4 = 0;
    L13:
        r2.setVisibility(r4);
        goto L14
    L12:
        r4 = 8;
    L14:
        ECDraweeView r6 = this.b4;
        if (r6 == null) goto L20;
        if (r5 == false) goto L18;
        r1 = 0;
    L18:
        r6.setVisibility(r1);
        return;
    }

    public final void v0(Map<String, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCtx");
        View r3 = this.c4;
        if (r3 == null) goto L5;
        K1((ViewGroup) getView(), r3);
    L5:
        ConstraintLayout r4 = this.Y3;
        if (r4 == null) goto L8;
        K1((ViewGroup) getView(), r4);
    L8:
        View r5 = this.b4;
        if (r5 == null) goto L12;
        K1((ViewGroup) getView(), r5);
        return;
    }

    public final Map<String, Object> z0(Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r3, "dataCtx");
        ConstraintLayout r0 = this.Y3;
        if (r0 == null) goto L5;
        getView().removeView(r0);
    L5:
        ECDraweeView r1 = this.b4;
        if (r1 == null) goto L8;
        getView().removeView(r1);
    L8:
        t r2 = this.c4;
        if (r2 == null) goto L11;
        getView().removeView(r2);
    L11:
        L1(false);
        return r3;
    }

    public final void K1(ViewGroup r2, View r3) {
        if (r3.getParent() == null) goto L9;
        ViewParent r0 = r3.getParent();
        if (r0 == null) goto L8;
        ((ViewGroup) r0).removeView(r3);
        goto L9
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L9:
        r2.addView(r3);
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
    public final void v(int r10, int r11, int r12, int r13) {
        super/*com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewGroupManager*/.v(r10, r11, r12, r13);
        if (this.e4 == true) goto L26;
        View r14 = getView();
    L5:
        Object r15 = null;
        if ((r14 instanceof CartRootFrameLayoutContainer) == true) goto L7;
        Object r16 = r14.getParent();
        if ((r16 instanceof View) == true) goto L11;
        r16 = null;
    L11:
        r14 = (View) r16;
        if (r14 != null) goto L5;
        ViewGroup r17 = null;
    L14:
        BubbleView r18 = this.Y3;
        if ((r18 instanceof CartRootFrameLayoutContainer.a) == true) goto L17;
        r18 = null;
    L17:
        if (r18 != null) goto L19;
    L25:
        this.e4 = true;
        goto L26
    L19:
        if ((r17 instanceof CartRootFrameLayoutContainer) == false) goto L22;
        r15 = r17;
    L22:
        CartRootFrameLayoutContainer r19 = (CartRootFrameLayoutContainer) r15;
        if (r19 == null) goto L25;
        r19.b(r18);
        goto L25
    L7:
        r17 = (ViewGroup) r14;
    L26:
        Rect r110 = this.d4;
        if (r110 == null) goto L91;
        String r111 = this.W3;
        if (r111 == null) goto L92;
        BaseSlcViewManager r112 = M(r111);
        if (r112 == null) goto L93;
        View r113 = r112.getView();
        if (r113 == null) goto L94;
        ConstraintLayout r114 = this.Y3;
        if (r114 == null) goto L37;
        r114.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    L37:
        t r115 = this.c4;
        if (r115 == null) goto L44;
        ConstraintLayout r4 = this.Y3;
        if (r4 == null) goto L42;
        int r5 = r4.getMeasuredWidth();
    L43:
        r115.measure(View.MeasureSpec.makeMeasureSpec(r5, 1073741824), View.MeasureSpec.makeMeasureSpec(com.bytedance.android.shopping.extensions.b.a(7) + com.bytedance.android.shopping.extensions.b.a(8), 1073741824));
        goto L44
    L42:
        r5 = 0;
    L44:
        ECDraweeView r116 = this.b4;
        if (r116 == null) goto L47;
        r116.measure(View.MeasureSpec.makeMeasureSpec(com.bytedance.android.shopping.extensions.b.a(20), 1073741824), View.MeasureSpec.makeMeasureSpec(com.bytedance.android.shopping.extensions.b.a(7), 1073741824));
    L47:
        ConstraintLayout r117 = this.Y3;
        if (r117 == null) goto L50;
        int r118 = r117.getMeasuredWidth();
    L51:
        ConstraintLayout r2 = this.Y3;
        if (r2 == null) goto L54;
        int r3 = r2.getMeasuredHeight();
    L55:
        ECDraweeView r6 = this.b4;
        if (r6 == null) goto L58;
        int r7 = r6.getMeasuredWidth();
    L59:
        ECDraweeView r8 = this.b4;
        if (r8 == null) goto L62;
        int r9 = r8.getMeasuredHeight();
    L63:
        if (r118 <= 0) goto L95;
        if (r7 <= 0) goto L96;
        if (r3 <= 0) goto L97;
        if (r9 <= 0) goto L98;
        int[] r20 = new int[2];
        getView().getLocationOnScreen(r20);
        int r21 = r20[0];
        int r22 = r20[1];
        int[] r23 = new int[2];
        r113.getLocationOnScreen(r23);
        int r119 = r23[0];
        int r120 = r23[1];
        int r0 = r110.left + r119;
        int r121 = (r110.top + r120) - r22;
        int r1 = (r0 - r21) + (r110.width() / 2);
        int r122 = r1 - (r118 / 2);
        int r123 = r122 + r118;
        int r24 = com.bytedance.android.shopping.extensions.b.a(24);
        int r25 = getView().getWidth() - r24;
        if (r122 >= r24) goto L70;
        if (r122 <= 0) goto L70;
    L78:
        int r124 = r118 + r122;
        int r125 = r121 - r9;
        int r126 = r125 - r3;
        int r26 = r1 - (r7 / 2);
        int r27 = r7 + r26;
        int r28 = r9 + r125;
        ConstraintLayout r29 = this.Y3;
        if (r29 == null) goto L81;
        r29.layout(r122, r126, r124, r125);
    L81:
        t r127 = this.c4;
        if (r127 == null) goto L84;
        r127.layout(r122, r125 - com.bytedance.android.shopping.extensions.b.a(8), r124, r28);
    L84:
        ECDraweeView r128 = this.b4;
        if (r128 == null) goto L99;
        r128.layout(r26, r125, r27, r28);
        return;
    L99:
        return;
    L70:
        if (r123 <= r25) goto L75;
        if (r123 < getView().getWidth()) goto L78;
    L75:
        if (Math.abs(r122 - r24) >= Math.abs(r123 - r25)) goto L77;
        r122 = r24;
        goto L78
    L77:
        r122 = r25 - r118;
        goto L78
    L98:
        return;
    L97:
        return;
    L96:
        return;
    L95:
        return;
    L62:
        r9 = 0;
        goto L63
    L58:
        r7 = 0;
        goto L59
    L54:
        r3 = 0;
        goto L55
    L50:
        r118 = 0;
        goto L51
    L94:
        return;
    L93:
        return;
    L92:
        return;
    }
}
