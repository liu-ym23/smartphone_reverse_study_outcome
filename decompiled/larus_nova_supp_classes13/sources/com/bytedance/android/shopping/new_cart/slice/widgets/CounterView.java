package com.bytedance.android.shopping.new_cart.slice.widgets;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.ecom.arch.slice.render.util.SlcDimensExtensionsKt;
import com.bytedance.android.ecom.arch.slice.render.util.SlcViewExtensionsKt;
import com.bytedance.android.ecom.arch.slice.render.widget.roundcorner.SlcRoundFrameLayout;
import com.bytedance.android.shopping.new_cart.container.CartObjectContainer;
import com.bytedance.android.shopping.new_cart.container.b0;
import com.bytedance.android.shopping.new_cart.container.s;
import com.bytedance.android.shopping.new_cart.slice.viewmanagers.q;
import com.bytedance.android.shopping.new_cart.utils.CartViewExtentionsKt;
import com.bytedance.android.shopping.new_cart.viewmodel.CartViewModel;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.android.ui.ec.widget.toast.ECToast;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CounterView extends SlcRoundFrameLayout implements View.OnClickListener {
    public final Lazy c;
    public final Lazy d;
    public boolean e;
    public int f;
    public int g;
    public int h;
    public String i;
    public String j;
    public String k;
    public int l;
    public final View m;
    public final TextView n;
    public final View o;
    public final ImageView p;
    public final ImageView q;
    public final EditText r;
    public long s;
    public final Lazy t;
    public final Lazy u;
    public final Lazy v;
    public final Lazy w;
    public final b0 x;

    public static final class a implements View.OnFocusChangeListener {
        public final /* synthetic */ CounterView a;

        public a(CounterView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View r7, boolean r8) {
            CartViewModel r0 = this.a.getCartVM();
            if (r0 == null) goto L6;
            CartViewModel.doEventAction$default(r0, "click_edit_product_num", MapsKt.mapOf(TuplesKt.to("type", "input")), null, 4, null);
            return;
        }
    }

    public static final class b {
    }

    static {
    }

    private final List<Integer> getBtnDecreaseHitSlop() {
        return (List) this.u.getValue();
    }

    private final List<Integer> getBtnIncreaseHitSlop() {
        return (List) this.v.getValue();
    }

    private final List<Integer> getNormalHitSlop() {
        return (List) this.t.getValue();
    }

    private final float getShrinkScale() {
        return ((Number) this.w.getValue()).floatValue();
    }

    public final CartViewModel getCartVM() {
        return (CartViewModel) this.c.getValue();
    }

    public final b0 getActions() {
        return this.x;
    }

    public final String getMaxLimitToast() {
        return this.j;
    }

    public final int getMaxQuantity() {
        return this.h;
    }

    public final String getMinLimitToast() {
        return this.i;
    }

    public final int getMinQuantity() {
        return this.g;
    }

    public final String getProductId() {
        return this.k;
    }

    public final int getQuantity() {
        return this.f;
    }

    public final void b(q r12) {
        Intrinsics.checkNotNullParameter(r12, "viewManager");
        View r1 = this.m;
        List<Integer> r0 = getNormalHitSlop();
        Object r6 = 12;
        if (CollectionsKt.getLastIndex(r0) < 0) goto L5;
        Object r2 = ListProtector.get(r0, 0);
    L6:
        int r3 = SlcDimensExtensionsKt.a((Number) r2, ((BaseSlcViewManager) r12).a.m());
        List<Integer> r4 = getNormalHitSlop();
        if (1 > CollectionsKt.getLastIndex(r4)) goto L9;
        Object r5 = ListProtector.get(r4, 1);
    L10:
        int r7 = SlcDimensExtensionsKt.a((Number) r5, ((BaseSlcViewManager) r12).a.m());
        List<Integer> r8 = getNormalHitSlop();
        if (2 > CollectionsKt.getLastIndex(r8)) goto L13;
        Object r9 = ListProtector.get(r8, 2);
    L14:
        int r10 = SlcDimensExtensionsKt.a((Number) r9, ((BaseSlcViewManager) r12).a.m());
        List<Integer> r11 = getNormalHitSlop();
        if (3 > CollectionsKt.getLastIndex(r11)) goto L17;
        Object r13 = ListProtector.get(r11, 3);
    L18:
        r12.c1(r1, r3, r7, r10, SlcDimensExtensionsKt.a((Number) r13, ((BaseSlcViewManager) r12).a.m()));
        ImageView r14 = this.p;
        List<Integer> r15 = getBtnDecreaseHitSlop();
        if (CollectionsKt.getLastIndex(r15) < 0) goto L21;
        Object r16 = ListProtector.get(r15, 0);
    L22:
        int r17 = SlcDimensExtensionsKt.a((Number) r16, ((BaseSlcViewManager) r12).a.m());
        List<Integer> r18 = getBtnDecreaseHitSlop();
        if (1 > CollectionsKt.getLastIndex(r18)) goto L25;
        Object r19 = ListProtector.get(r18, 1);
    L26:
        int r20 = SlcDimensExtensionsKt.a((Number) r19, ((BaseSlcViewManager) r12).a.m());
        List<Integer> r21 = getBtnDecreaseHitSlop();
        if (3 > CollectionsKt.getLastIndex(r21)) goto L29;
        Object r22 = ListProtector.get(r21, 3);
    L30:
        r12.c1(r14, r17, r20, 0, SlcDimensExtensionsKt.a((Number) r22, ((BaseSlcViewManager) r12).a.m()));
        ImageView r23 = this.q;
        List<Integer> r24 = getBtnIncreaseHitSlop();
        if (1 > CollectionsKt.getLastIndex(r24)) goto L33;
        Object r25 = ListProtector.get(r24, 1);
    L34:
        int r26 = SlcDimensExtensionsKt.a((Number) r25, ((BaseSlcViewManager) r12).a.m());
        List<Integer> r27 = getBtnIncreaseHitSlop();
        if (2 > CollectionsKt.getLastIndex(r27)) goto L37;
        Object r28 = ListProtector.get(r27, 2);
    L38:
        int r29 = SlcDimensExtensionsKt.a((Number) r28, ((BaseSlcViewManager) r12).a.m());
        List<Integer> r30 = getBtnIncreaseHitSlop();
        if (3 > CollectionsKt.getLastIndex(r30)) goto L41;
        r6 = ListProtector.get(r30, 3);
    L41:
        r12.c1(r23, 0, r26, r29, SlcDimensExtensionsKt.a((Number) r6, ((BaseSlcViewManager) r12).a.m()));
        return;
    L37:
        r28 = r6;
        goto L38
    L33:
        r25 = r6;
        goto L34
    L29:
        r22 = r6;
        goto L30
    L25:
        r19 = r6;
        goto L26
    L21:
        r16 = r6;
        goto L22
    L17:
        r13 = r6;
        goto L18
    L13:
        r9 = r6;
        goto L14
    L9:
        r5 = r6;
        goto L10
    L5:
        r2 = r6;
        goto L6
    }

    public final void c(com.bytedance.android.ecom.arch.slice.render.context.b r6) {
        Intrinsics.checkNotNullParameter(r6, "displayMetrics");
        ImageView r0 = this.p;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        r1.height = SlcDimensExtensionsKt.a(24, r6);
        r1.width = SlcDimensExtensionsKt.a(24, r6);
        Unit r3 = Unit.INSTANCE;
        r0.setLayoutParams(r1);
        ImageView r2 = this.q;
        ViewGroup.LayoutParams r4 = r2.getLayoutParams();
        r4.height = SlcDimensExtensionsKt.a(24, r6);
        r4.width = SlcDimensExtensionsKt.a(24, r6);
        r2.setLayoutParams(r4);
        EditText r5 = this.r;
        ViewGroup.LayoutParams r7 = r5.getLayoutParams();
        r7.height = SlcDimensExtensionsKt.a(24, r6);
        r7.width = SlcDimensExtensionsKt.a(40, r6);
        r5.setLayoutParams(r7);
        this.r.setTextSize(0, SlcDimensExtensionsKt.e(14, r6) * getShrinkScale());
        TextView r8 = this.n;
        ViewGroup.LayoutParams r9 = r8.getLayoutParams();
        r9.height = SlcDimensExtensionsKt.a(24, r6);
        r8.setLayoutParams(r9);
        this.n.setMinWidth(SlcDimensExtensionsKt.a(26, r6));
        this.n.setPadding(SlcDimensExtensionsKt.a(6, r6), 0, SlcDimensExtensionsKt.a(6, r6), 0);
        this.n.setTextSize(0, SlcDimensExtensionsKt.e(14, r6) * getShrinkScale());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d(int r22) {
        int r0 = r22;
        if (r0 >= this.g) goto L9;
        CartViewModel r8 = getCartVM();
        if (r8 == null) goto L7;
        CartViewModel.doEventAction$default(r8, "cart_list_toast_show", MapsKt.mapOf(new Pair[]{TuplesKt.to("toast_word", this.i), TuplesKt.to(PdpOpenThirdParam.KEY_PRODUCT_ID, this.k)}), null, 4, null);
    L7:
        ECToast.showToast$default(ECToast.INSTANCE, getContext(), this.i, 0, null, 8, null);
        e(this.g);
        r0 = this.g;
    L15:
        if (r0 != this.f) goto L17;
        return;
    L17:
        Map r1 = MapsKt.mapOf(TuplesKt.to("quantity", Integer.valueOf(r0)));
        BaseSlcViewManager r2 = SlcViewExtensionsKt.g(this);
        if (r2 == null) goto L21;
        r2.getTemplateContext().d(new SlcCommonAction("cartChangeQuantity", r1), this, r2.l(), null, null);
        return;
    L21:
        return;
    L9:
        if (r0 <= this.h) goto L15;
        CartViewModel r9 = getCartVM();
        if (r9 == null) goto L13;
        CartViewModel.doEventAction$default(r9, "cart_list_toast_show", MapsKt.mapOf(new Pair[]{TuplesKt.to("toast_word", this.j), TuplesKt.to(PdpOpenThirdParam.KEY_PRODUCT_ID, this.k)}), null, 4, null);
    L13:
        ECToast.showToast$default(ECToast.INSTANCE, getContext(), this.j, 0, null, 8, null);
        e(this.h);
        r0 = this.h;
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchHoverEvent(MotionEvent r1) {
        return super/*android.widget.FrameLayout*/.dispatchHoverEvent(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e(int r11) {
        this.r.setText(String.valueOf(r11));
        this.r.setSelection(String.valueOf(r11).length());
        bg3.a r0 = com.bytedance.android.shopping.new_cart.utils.a.a;
        com.bytedance.android.shopping.new_cart.utils.a.h(this.r, "input", "商品个数," + r11, false);
        this.n.setText(String.valueOf(r11));
        com.bytedance.android.shopping.new_cart.utils.a.h(this.n, "input", "数量" + r11, false);
        int r12 = g1.a;
        Drawable r5 = g1.a.b(getContext(), 2131235839);
        if (r5 == null) goto L6;
        float r13 = getShrinkScale();
        int r1 = s.a;
        int r14 = (int) (8 * (r13 * s.a(Boolean.valueOf(((Boolean) this.d.getValue()).booleanValue())).a));
        int r2 = com.bytedance.android.shopping.extensions.b.a(1);
        InsetDrawable r3 = new InsetDrawable(r5, 0, r2, 0, 0);
        r3.setBounds(0, 0, r14, r2 + r14);
        this.n.setCompoundDrawablesRelative(r3, null, null, null);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public final void onClick(View r14) {
        Intrinsics.checkNotNullParameter(r14, "v");
        long r0 = SystemClock.uptimeMillis();
        long r2 = r0 - this.s;
        this.s = r0;
        if (r2 > 0) goto L5;
        return;
    L5:
        int r15 = r14.getId();
        if (r15 != 2131364701) goto L11;
        this.r.clearFocus();
        CartViewExtentionsKt.c(this.r);
        d(this.f - 1);
        CartViewModel r3 = getCartVM();
        if (r3 == null) goto L26;
        CartViewModel.doEventAction$default(r3, "click_edit_product_num", MapsKt.mapOf(TuplesKt.to("type", "sub")), null, 4, null);
        return;
    L26:
        return;
    L11:
        if (r15 != 2131364741) goto L16;
        this.r.clearFocus();
        CartViewExtentionsKt.c(this.r);
        d(this.f + 1);
        CartViewModel r4 = getCartVM();
        if (r4 == null) goto L28;
        CartViewModel.doEventAction$default(r4, "click_edit_product_num", MapsKt.mapOf(TuplesKt.to("type", "add")), null, 4, null);
        return;
    L28:
        return;
    L16:
        if (r15 == 2131391233) goto L18;
        return;
    L18:
        if (this.l != 0) goto L31;
        Map r16 = MapsKt.mapOf(TuplesKt.to("counter_active", Boolean.TRUE));
        BaseSlcViewManager r1 = SlcViewExtensionsKt.g(this);
        if (r1 == null) goto L22;
        r1.getTemplateContext().d(new SlcCommonAction("cartCounterActive", r16), this, r1.l(), null, null);
    L22:
        CartViewModel r7 = getCartVM();
        if (r7 == null) goto L32;
        CartViewModel.doEventAction$default(r7, "cart_list_tab_click", MapsKt.mapOf(TuplesKt.to("tab_name", "stepper")), null, 4, null);
        return;
    L32:
        return;
    }

    public final void setActive(boolean r1) {
        this.e = r1;
    }

    public final void setMaxLimitToast(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.j = r2;
    }

    public final void setMaxQuantity(int r1) {
        this.h = r1;
    }

    public final void setMinLimitToast(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.i = r2;
    }

    public final void setMinQuantity(int r1) {
        this.g = r1;
    }

    public final void setProductId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.k = r2;
    }

    public final void setQuantity(int r1) {
        this.f = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CounterView(Context r4, b0 r5, final CartObjectContainer r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, null, 6, 0);
        this.x = r5;
        this.c = LazyKt.lazy(new CounterView$cartVM$2(r6));
        this.d = LazyKt.lazy(new CounterView$isSplitMode$2(r6));
        this.i = "";
        this.j = "";
        this.k = "";
        this.t = LazyKt.lazy(CounterView$normalHitSlop$2.INSTANCE);
        this.u = LazyKt.lazy(CounterView$btnDecreaseHitSlop$2.INSTANCE);
        this.v = LazyKt.lazy(CounterView$btnIncreaseHitSlop$2.INSTANCE);
        this.w = LazyKt.lazy(CounterView$shrinkScale$2.INSTANCE);
        LayoutInflater r7 = LayoutInflater.from(r4);
        r7.inflate(2131560396, this, true);
        this.o = findViewById(2131378684);
        ImageView r8 = (ImageView) findViewById(2131364701);
        this.p = r8;
        EditText r0 = (EditText) findViewById(2131371807);
        r0.setOnFocusChangeListener(new a(this));
        Unit r1 = Unit.INSTANCE;
        this.r = r0;
        ImageView r2 = (ImageView) findViewById(2131364741);
        this.q = r2;
        r7.inflate(2131560397, this, true);
        View r9 = findViewById(2131391233);
        this.m = r9;
        if (r9 == null) goto L7;
        this.n = (TextView) r9;
        r8.setOnClickListener(this);
        r2.setOnClickListener(this);
        r9.setOnClickListener(this);
        r0.setOnEditorActionListener(new g(this));
        r0.addTextChangedListener(new h(this));
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    }
}
