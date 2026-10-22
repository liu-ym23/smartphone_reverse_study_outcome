package com.bytedance.android.shopping.card_list.slice.widgets;

import android.content.Context;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.ecom.arch.slice.render.util.SlcDimensExtensionsKt;
import com.bytedance.android.ecom.arch.slice.render.util.SlcViewExtensionsKt;
import com.bytedance.android.ecom.arch.slice.render.widget.roundcorner.SlcRoundFrameLayout;
import com.bytedance.android.shopping.card_list.common_params.CardListContainerConfig;
import com.bytedance.android.shopping.card_list.components.CardListSliceCustomWidgetAdapterComponent;
import com.bytedance.android.shopping.card_list.components.CardListTrackerComponent;
import com.bytedance.android.shopping.card_list.components.s;
import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import com.bytedance.android.shopping.card_list.utils.CardListExtentionsKt;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.android.ui.ec.widget.toast.ECToast;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CounterView extends SlcRoundFrameLayout implements View.OnClickListener {
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public boolean g;
    public int h;
    public int i;
    public int j;
    public String k;
    public String l;
    public String m;
    public int n;
    public final View o;
    public final TextView p;
    public final View q;
    public final ImageView r;
    public final ImageView s;
    public final EditText t;
    public long u;
    public final List<Integer> v;
    public final List<Integer> w;
    public final List<Integer> x;
    public final Lazy y;
    public final boolean z;

    public static final class a implements View.OnFocusChangeListener {
        public final /* synthetic */ CounterView a;

        public a(CounterView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View r3, boolean r4) {
            CardListTrackerComponent r5 = CounterView.d(this.a);
            if (r5 == null) goto L6;
            CardListTrackerComponent.h(r5, "click_edit_product_num", MapsKt.mapOf(TuplesKt.to("type", "input")), 4);
            return;
        }
    }

    public static final class b {
    }

    static {
    }

    private final s getActions() {
        return (s) this.e.getValue();
    }

    private final CardListObjectContainer getObjectContainer() {
        return (CardListObjectContainer) this.d.getValue();
    }

    private final CardListSliceCustomWidgetAdapterComponent getProvider() {
        return (CardListSliceCustomWidgetAdapterComponent) this.c.getValue();
    }

    private final float getShrinkScale() {
        return ((Number) this.y.getValue()).floatValue();
    }

    private final CardListTrackerComponent getTrackerComponent() {
        return (CardListTrackerComponent) this.f.getValue();
    }

    public final boolean getEnableLargeTextMode() {
        return this.z;
    }

    public final String getMaxLimitToast() {
        return this.l;
    }

    public final int getMaxQuantity() {
        return this.j;
    }

    public final String getMinLimitToast() {
        return this.k;
    }

    public final int getMinQuantity() {
        return this.i;
    }

    public final String getProductId() {
        return this.m;
    }

    public final int getQuantity() {
        return this.h;
    }

    public static final /* synthetic */ CardListObjectContainer b(CounterView r0) {
        return r0.getObjectContainer();
    }

    public static final /* synthetic */ CardListSliceCustomWidgetAdapterComponent c(CounterView r0) {
        return r0.getProvider();
    }

    public static final /* synthetic */ CardListTrackerComponent d(CounterView r0) {
        return r0.getTrackerComponent();
    }

    public final void f(com.bytedance.android.ecom.arch.slice.render.context.b r6) {
        Intrinsics.checkNotNullParameter(r6, "displayMetrics");
        ImageView r0 = this.r;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        r1.height = SlcDimensExtensionsKt.a(24, r6);
        r1.width = SlcDimensExtensionsKt.a(24, r6);
        Unit r3 = Unit.INSTANCE;
        r0.setLayoutParams(r1);
        ImageView r2 = this.s;
        ViewGroup.LayoutParams r4 = r2.getLayoutParams();
        r4.height = SlcDimensExtensionsKt.a(24, r6);
        r4.width = SlcDimensExtensionsKt.a(24, r6);
        r2.setLayoutParams(r4);
        EditText r5 = this.t;
        ViewGroup.LayoutParams r7 = r5.getLayoutParams();
        r7.height = SlcDimensExtensionsKt.a(24, r6);
        r7.width = SlcDimensExtensionsKt.a(40, r6);
        r5.setLayoutParams(r7);
        this.t.setTextSize(0, SlcDimensExtensionsKt.e(14, r6) * getShrinkScale());
        TextView r8 = this.p;
        ViewGroup.LayoutParams r9 = r8.getLayoutParams();
        r9.height = SlcDimensExtensionsKt.a(24, r6);
        r8.setLayoutParams(r9);
        this.p.setPadding(SlcDimensExtensionsKt.a(4, r6), 0, SlcDimensExtensionsKt.a(4, r6), 0);
        this.p.setTextSize(0, SlcDimensExtensionsKt.e(14, r6) * getShrinkScale());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void g(int r11) {
        if (r11 >= this.i) goto L9;
        CardListTrackerComponent r12 = getTrackerComponent();
        if (r12 == null) goto L7;
        CardListTrackerComponent.h(r12, "cart_list_toast_show", MapsKt.mapOf(new Pair[]{TuplesKt.to("toast_word", this.k), TuplesKt.to(PdpOpenThirdParam.KEY_PRODUCT_ID, this.m)}), 4);
    L7:
        ECToast.showToast$default(ECToast.INSTANCE, getContext(), this.k, 0, null, 8, null);
        h(this.i);
        r11 = this.i;
    L15:
        if (r11 != this.h) goto L17;
        return;
    L17:
        Map r13 = MapsKt.mapOf(TuplesKt.to("quantity", Integer.valueOf(r11)));
        BaseSlcViewManager r0 = SlcViewExtensionsKt.g(this);
        if (r0 == null) goto L21;
        r0.a.d(new SlcCommonAction("cartChangeQuantity", r13), this, r0.l(), null, null);
        return;
    L21:
        return;
    L9:
        if (r11 <= this.j) goto L15;
        CardListTrackerComponent r14 = getTrackerComponent();
        if (r14 == null) goto L13;
        CardListTrackerComponent.h(r14, "cart_list_toast_show", MapsKt.mapOf(new Pair[]{TuplesKt.to("toast_word", this.l), TuplesKt.to(PdpOpenThirdParam.KEY_PRODUCT_ID, this.m)}), 4);
    L13:
        ECToast.showToast$default(ECToast.INSTANCE, getContext(), this.l, 0, null, 8, null);
        h(this.j);
        r11 = this.j;
        goto L15
    }

    public final void h(int r6) {
        this.t.setText(String.valueOf(r6));
        this.t.setSelection(String.valueOf(r6).length());
        int r0 = com.bytedance.android.shopping.card_list.utils.f.a;
        com.bytedance.android.shopping.card_list.utils.f.b(this.t, "input", "商品个数," + r6, false);
        this.p.setText("x" + r6);
        com.bytedance.android.shopping.card_list.utils.f.b(this.p, "input", "数量" + r6, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public final void onClick(View r9) {
        Intrinsics.checkNotNullParameter(r9, "v");
        long r0 = SystemClock.uptimeMillis();
        long r2 = r0 - this.u;
        this.u = r0;
        if (r2 > 0) goto L5;
        return;
    L5:
        int r10 = r9.getId();
        if (r10 != 2131364701) goto L11;
        this.t.clearFocus();
        CardListExtentionsKt.h(this.t);
        g(this.h - 1);
        CardListTrackerComponent r11 = getTrackerComponent();
        if (r11 == null) goto L32;
        CardListTrackerComponent.h(r11, "click_edit_product_num", MapsKt.mapOf(TuplesKt.to("type", "sub")), 4);
        return;
    L32:
        return;
    L11:
        if (r10 != 2131364741) goto L16;
        this.t.clearFocus();
        CardListExtentionsKt.h(this.t);
        g(this.h + 1);
        CardListTrackerComponent r12 = getTrackerComponent();
        if (r12 == null) goto L34;
        CardListTrackerComponent.h(r12, "click_edit_product_num", MapsKt.mapOf(TuplesKt.to("type", "add")), 4);
        return;
    L34:
        return;
    L16:
        if (r10 == 2131391233) goto L18;
        return;
    L18:
        if (this.n != 0) goto L37;
        Map r13 = MapsKt.mapOf(TuplesKt.to("counter_active", Boolean.TRUE));
        BaseSlcViewManager r1 = SlcViewExtensionsKt.g(this);
        if (r1 == null) goto L22;
        r1.a.d(new SlcCommonAction("cartCounterActive", r13), this, r1.l(), null, null);
    L22:
        CardListObjectContainer r14 = getObjectContainer();
        if (r14 == null) goto L38;
        CardListContainerConfig r15 = r14.f;
        if (r15 == null) goto L39;
        String r16 = r15.getStandardClickEventName();
        if (r16 == null) goto L40;
        CardListTrackerComponent r3 = getTrackerComponent();
        if (r3 == null) goto L41;
        CardListTrackerComponent.h(r3, r16, MapsKt.mapOf(TuplesKt.to("tab_name", "stepper")), 4);
        return;
    L41:
        return;
    L40:
        return;
    L39:
        return;
    L38:
        return;
    }

    public final void setActive(boolean r1) {
        this.g = r1;
    }

    public final void setMaxLimitToast(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.l = r2;
    }

    public final void setMaxQuantity(int r1) {
        this.j = r1;
    }

    public final void setMinLimitToast(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.k = r2;
    }

    public final void setMinQuantity(int r1) {
        this.i = r1;
    }

    public final void setProductId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.m = r2;
    }

    public final void setQuantity(int r1) {
        this.h = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CounterView(Context r7, final SlcTemplateContext r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "slcTemplateContext");
        super(r7, null, 6, 0);
        this.z = r9;
        this.c = LazyKt.lazy(new CounterView$provider$2(r8));
        this.d = LazyKt.lazy(new CounterView$objectContainer$2(this));
        this.e = LazyKt.lazy(new CounterView$actions$2(this));
        this.f = LazyKt.lazy(new CounterView$trackerComponent$2(this));
        this.k = "";
        this.l = "";
        this.m = "";
        this.v = CollectionsKt.listOf(new Integer[]{12, 12, 12, 12});
        this.w = CollectionsKt.listOf(new Integer[]{12, 12, 0, 12});
        this.x = CollectionsKt.listOf(new Integer[]{0, 12, 12, 12});
        this.y = LazyKt.lazy(new CounterView$shrinkScale$2(this));
        LayoutInflater r10 = LayoutInflater.from(r7);
        r10.inflate(2131560391, this, true);
        this.q = findViewById(2131378684);
        ImageView r11 = (ImageView) findViewById(2131364701);
        this.r = r11;
        EditText r12 = (EditText) findViewById(2131371807);
        r12.setOnFocusChangeListener(new a(this));
        Unit r0 = Unit.INSTANCE;
        this.t = r12;
        ImageView r1 = (ImageView) findViewById(2131364741);
        this.s = r1;
        r10.inflate(2131560392, this, true);
        View r13 = findViewById(2131391233);
        this.o = r13;
        if (r13 == null) goto L7;
        this.p = (TextView) r13;
        r11.setOnClickListener(this);
        r1.setOnClickListener(this);
        r13.setOnClickListener(this);
        r12.setOnEditorActionListener(new h(this));
        r12.addTextChangedListener(new i(this));
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e(boolean r5, int r6, int r7, int r8, String r9, String r10, String r11, int r12) {
        Intrinsics.checkNotNullParameter(r9, "minLimitToast");
        Intrinsics.checkNotNullParameter(r10, "maxLimitToast");
        Intrinsics.checkNotNullParameter(r11, "productId");
        if (this.g == false) goto L10;
        if (r5 == true) goto L10;
        Integer r0 = CardListExtentionsKt.b(this.t.getText().toString());
        if (r0 == null) goto L8;
        int r1 = r0.intValue();
    L9:
        g(r1);
        goto L10
    L8:
        r1 = r7;
    L10:
        this.n = r12;
        boolean r13 = true;
        if (r5 == true) goto L13;
        this.q.setVisibility(8);
        this.o.setVisibility(0);
    L27:
        if (this.g == r5) goto L29;
        requestLayout();
        invalidate();
    L29:
        this.g = r5;
        this.h = r6;
        this.i = r7;
        this.j = r8;
        this.k = r9;
        this.l = r10;
        this.m = r11;
        h(r6);
        if (this.i >= this.h) goto L32;
        boolean r14 = true;
    L34:
        if (r14 == false) goto L36;
        this.r.setImageResource(2131232515);
        int r15 = com.bytedance.android.shopping.card_list.utils.f.a;
        com.bytedance.android.shopping.card_list.utils.f.b(this.r, "button", "减少商品数量", false);
    L38:
        if (this.h < this.j) goto L41;
        r13 = false;
    L41:
        if (r13 == false) goto L43;
        this.s.setImageResource(2131232517);
        com.bytedance.android.shopping.card_list.utils.f.b(this.s, "button", "增加商品数量", false);
    L44:
        TextView r16 = this.p;
        ViewExtensionsKt.e(r16, r16.getPaint(), 500);
        this.p.setBackgroundColor(ContextCompat.getColor(getContext(), 2131101211));
        EditText r17 = this.t;
        ViewExtensionsKt.e(r17, r17.getPaint(), 500);
        return;
    L43:
        this.s.setImageResource(2131232516);
        com.bytedance.android.shopping.card_list.utils.f.b(this.s, "button", this.h + "为最大数量, 不可增加", false);
        goto L44
    L36:
        this.r.setImageResource(2131232514);
        int r18 = com.bytedance.android.shopping.card_list.utils.f.a;
        com.bytedance.android.shopping.card_list.utils.f.b(this.r, "button", this.h + "为最小数量, 不可减少", false);
        goto L38
    L32:
        r14 = false;
        goto L34
    L13:
        if (this.q.getVisibility() == 0) goto L15;
        boolean r2 = true;
    L16:
        this.q.setVisibility(0);
        this.o.setVisibility(8);
        s r3 = getActions();
        if (r3 == null) goto L21;
        Function1<Boolean, Unit> r4 = r3.d;
        if (r4 == null) goto L21;
        Unit r19 = (Unit) r4.invoke(Boolean.TRUE);
    L21:
        if (r2 == false) goto L27;
        if (com.bytedance.android.ec.core.utils.a.c() == false) goto L27;
        post(new g(this));
        goto L27
    L15:
        r2 = false;
        goto L16
    }
}
