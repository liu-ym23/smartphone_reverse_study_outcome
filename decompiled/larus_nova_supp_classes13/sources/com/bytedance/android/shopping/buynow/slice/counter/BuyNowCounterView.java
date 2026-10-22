package com.bytedance.android.shopping.buynow.slice.counter;

import android.content.Context;
import android.graphics.Typeface;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.ecom.arch.slice.render.util.SlcDimensExtensionsKt;
import com.bytedance.android.ecom.arch.slice.render.util.SlcViewExtensionsKt;
import com.bytedance.android.ecom.arch.slice.render.widget.roundcorner.SlcRoundFrameLayout;
import com.bytedance.android.shopping.buynow.utils.ViewUtilsKt;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.ui.ec.widget.toast.ECToast;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u00015B'\b\u0007\u0012\u0006\u0010/\u001a\u00020.\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u000100\u0012\b\b\u0002\u00102\u001a\u00020\n¢\u0006\u0004\b3\u00104R\"\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0015\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\"\u0010\u0019\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0010R\"\u0010!\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010%\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u001c\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010 R\"\u0010)\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010\u001c\u001a\u0004\b'\u0010\u001e\"\u0004\b(\u0010 R\"\u0010-\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010\u001c\u001a\u0004\b+\u0010\u001e\"\u0004\b,\u0010 ¨\u00066"}, d2 = {"Lcom/bytedance/android/shopping/buynow/slice/counter/BuyNowCounterView;", "Lcom/bytedance/android/ecom/arch/slice/render/widget/roundcorner/SlcRoundFrameLayout;", "Landroid/view/View$OnClickListener;", "", "c", "Z", "isActive", "()Z", "setActive", "(Z)V", "", "d", "I", "getQuantity", "()I", "setQuantity", "(I)V", "quantity", "e", "getMinQuantity", "setMinQuantity", "minQuantity", "f", "getMaxQuantity", "setMaxQuantity", "maxQuantity", "", "g", "Ljava/lang/String;", "getMinLimitToast", "()Ljava/lang/String;", "setMinLimitToast", "(Ljava/lang/String;)V", "minLimitToast", "h", "getMaxLimitToast", "setMaxLimitToast", "maxLimitToast", "i", "getProductId", "setProductId", "productId", "j", "getChangeQuantityEvent", "setChangeQuantityEvent", "changeQuantityEvent", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BuyNowCounterView extends SlcRoundFrameLayout implements View.OnClickListener {
    public static final /* synthetic */ int u = 0;
    public boolean c;
    public int d;
    public int e;
    public int f;
    public String g;
    public String h;
    public String i;
    public String j;
    public final LinearLayout k;
    public final ImageView l;
    public final ImageView m;
    public final EditText n;
    public long o;
    public boolean p;
    public boolean q;
    public final boolean r;
    public final View s;
    public final View t;

    public static final class a implements View.OnFocusChangeListener {
        public final /* synthetic */ EditText a;

        public a(EditText r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View r1, boolean r2) {
            if (r2 == false) goto L9;
            WeakReference<EditText> r3 = d.a;
            EditText r4 = this.a;
            if (r4 != null) goto L6;
            d.a = null;
        L7:
            d.b = true;
            return;
        L6:
            d.a = new WeakReference(r4);
            goto L7
        }
    }

    public static final class b {
    }

    static {
    }

    public BuyNowCounterView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public BuyNowCounterView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final String getChangeQuantityEvent() {
        return this.j;
    }

    public final String getMaxLimitToast() {
        return this.h;
    }

    public final int getMaxQuantity() {
        return this.f;
    }

    public final String getMinLimitToast() {
        return this.g;
    }

    public final int getMinQuantity() {
        return this.e;
    }

    public final String getProductId() {
        return this.i;
    }

    public final int getQuantity() {
        return this.d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.widget.FrameLayout*/.onAttachedToWindow();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.widget.FrameLayout*/.onDetachedFromWindow();
    }

    public final void c(com.bytedance.android.ecom.arch.slice.render.context.b r8) {
        Intrinsics.checkNotNullParameter(r8, "displayMetrics");
        if (this.r == false) goto L29;
        LinearLayout r0 = this.k;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        r1.height = SlcDimensExtensionsKt.a(24, r8);
        Unit r3 = Unit.INSTANCE;
        r0.setLayoutParams(r1);
        ImageView r2 = this.l;
        ViewGroup.LayoutParams r4 = r2.getLayoutParams();
        r4.height = SlcDimensExtensionsKt.a(24, r8);
        r4.width = SlcDimensExtensionsKt.a(24, r8);
        r2.setLayoutParams(r4);
        ImageView r5 = this.m;
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
        r6.height = SlcDimensExtensionsKt.a(24, r8);
        r6.width = SlcDimensExtensionsKt.a(24, r8);
        r5.setLayoutParams(r6);
        EditText r7 = this.n;
        ViewGroup.LayoutParams r9 = r7.getLayoutParams();
        r9.height = SlcDimensExtensionsKt.a(24, r8);
        r9.width = SlcDimensExtensionsKt.a(34, r8);
        r7.setLayoutParams(r9);
        int r10 = SlcDimensExtensionsKt.a(4, r8);
        int r11 = SlcDimensExtensionsKt.a(1, r8);
        View r12 = this.s;
        LinearLayout.LayoutParams r13 = null;
        if (r12 == null) goto L17;
        if (r12 == null) goto L8;
        ViewGroup.LayoutParams r14 = r12.getLayoutParams();
    L10:
        if ((r14 instanceof LinearLayout.LayoutParams) == true) goto L12;
        r14 = null;
    L12:
        LinearLayout.LayoutParams r15 = (LinearLayout.LayoutParams) r14;
        if (r15 == null) goto L15;
        r15.width = r11;
        r15.height = SlcDimensExtensionsKt.a(16, r8);
        r15.topMargin = r10;
        r15.bottomMargin = r10;
    L16:
        r12.setLayoutParams(r15);
        goto L17
    L15:
        r15 = null;
        goto L16
    L8:
        r14 = null;
    L17:
        View r16 = this.t;
        if (r16 == null) goto L30;
        if (r16 == null) goto L21;
        ViewGroup.LayoutParams r17 = r16.getLayoutParams();
    L23:
        if ((r17 instanceof LinearLayout.LayoutParams) == true) goto L25;
        r17 = null;
    L25:
        LinearLayout.LayoutParams r18 = (LinearLayout.LayoutParams) r17;
        if (r18 == null) goto L28;
        r18.width = r11;
        r18.height = SlcDimensExtensionsKt.a(16, r8);
        r18.topMargin = r10;
        r18.bottomMargin = r10;
        r13 = r18;
    L28:
        r16.setLayoutParams(r13);
        goto L30
    L21:
        r17 = null;
    L30:
        this.n.setTextSize(0, SlcDimensExtensionsKt.e(14, r8));
        return;
    L29:
        LinearLayout r19 = this.k;
        ViewGroup.LayoutParams r20 = r19.getLayoutParams();
        r20.height = SlcDimensExtensionsKt.a(20, r8);
        Unit r21 = Unit.INSTANCE;
        r19.setLayoutParams(r20);
        ImageView r22 = this.l;
        ViewGroup.LayoutParams r23 = r22.getLayoutParams();
        r23.height = SlcDimensExtensionsKt.a(20, r8);
        r23.width = SlcDimensExtensionsKt.a(20, r8);
        r22.setLayoutParams(r23);
        ImageView r24 = this.m;
        ViewGroup.LayoutParams r25 = r24.getLayoutParams();
        r25.height = SlcDimensExtensionsKt.a(20, r8);
        r25.width = SlcDimensExtensionsKt.a(20, r8);
        r24.setLayoutParams(r25);
        EditText r26 = this.n;
        ViewGroup.LayoutParams r27 = r26.getLayoutParams();
        r27.height = SlcDimensExtensionsKt.a(20, r8);
        r27.width = SlcDimensExtensionsKt.a(36, r8);
        r26.setLayoutParams(r27);
        goto L30
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d(int r8) {
        if (r8 >= this.e) goto L9;
        if (k.c(this.g) == false) goto L7;
        ECToast.showToast$default(ECToast.INSTANCE, getContext(), this.g, 0, null, 8, null);
    L7:
        int r9 = this.e;
        this.n.setText(String.valueOf(r9));
        r8 = this.e;
    L16:
        if (r8 != this.d) goto L18;
        return;
    L18:
        Map r10 = MapsKt.mapOf(TuplesKt.to("quantity", Integer.valueOf(r8)));
        BaseSlcViewManager r0 = SlcViewExtensionsKt.g(this);
        if (r0 == null) goto L22;
        SlcCommonAction r2 = new SlcCommonAction(this.j, r10);
        r0.a.d(r2, this, r0.l(), null, null);
        return;
    L22:
        return;
    L9:
        if (r8 > this.f) goto L11;
        this.n.setText(String.valueOf(r8));
        goto L16
    L11:
        if (k.c(this.h) == false) goto L13;
        ECToast.showToast$default(ECToast.INSTANCE, getContext(), this.h, 0, null, 8, null);
    L13:
        int r11 = this.f;
        this.n.setText(String.valueOf(r11));
        r8 = this.f;
        goto L16
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchHoverEvent(MotionEvent r1) {
        return super/*android.widget.FrameLayout*/.dispatchHoverEvent(r1);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        Intrinsics.checkNotNullParameter(r6, "v");
        long r0 = SystemClock.uptimeMillis();
        long r2 = r0 - this.o;
        this.o = r0;
        if (r2 > 0) goto L5;
        return;
    L5:
        int r7 = r6.getId();
        if (r7 != 2131364701) goto L9;
        this.n.clearFocus();
        ViewUtilsKt.a(this.n);
        d(this.d - 1);
        return;
    L9:
        if (r7 != 2131364741) goto L13;
        this.n.clearFocus();
        ViewUtilsKt.a(this.n);
        d(this.d + 1);
        return;
    }

    public final void setActive(boolean r1) {
        this.c = r1;
    }

    public final void setChangeQuantityEvent(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.j = r2;
    }

    public final void setMaxLimitToast(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.h = r2;
    }

    public final void setMaxQuantity(int r1) {
        this.f = r1;
    }

    public final void setMinLimitToast(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.g = r2;
    }

    public final void setMinQuantity(int r1) {
        this.e = r1;
    }

    public final void setProductId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.i = r2;
    }

    public final void setQuantity(int r1) {
        this.d = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BuyNowCounterView(Context r9, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        super(r9, null, 6, 0);
        this.d = 1;
        this.e = 1;
        this.f = 1;
        this.g = "";
        this.h = "";
        this.i = "";
        this.j = "";
        this.p = true;
        this.q = true;
        ECSettingKeys.j.getClass();
        if (ECSettingKeys.U() != 1) goto L5;
        boolean r0 = true;
    L6:
        this.r = r0;
        int r2 = com.bytedance.android.shopping.buynow.opt.a.a;
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(this, "parentView");
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r9).aU(2131559218, this, true);
        LinearLayout r12 = (LinearLayout) findViewById(2131378684);
        this.k = r12;
        ImageView r3 = (ImageView) findViewById(2131364701);
        this.l = r3;
        EditText r4 = (EditText) findViewById(2131371807);
        r4.setOnFocusChangeListener(new a(r4));
        Unit r5 = Unit.INSTANCE;
        this.n = r4;
        ImageView r6 = (ImageView) findViewById(2131364741);
        this.m = r6;
        if (r0 == false) goto L9;
        r6.setImageResource(2131232444);
        r3.setImageResource(2131232442);
        r4.getPaint().setTypeface(Typeface.create("sans-serif-medium", 0));
        View r1 = new View(r9);
        r1.setBackgroundResource(2131232440);
        this.s = r1;
        View r7 = new View(r9);
        r7.setBackgroundResource(2131232440);
        this.t = r7;
        LinearLayout.LayoutParams r13 = new LinearLayout.LayoutParams(-2, -1);
        r13.gravity = 17;
        r12.addView(r1, 1, r13);
        LinearLayout.LayoutParams r14 = new LinearLayout.LayoutParams(-2, -1);
        r14.gravity = 17;
        r12.addView(r7, 3, r14);
    L10:
        r3.setOnClickListener(this);
        r6.setOnClickListener(this);
        r4.setOnEditorActionListener(new com.bytedance.android.shopping.buynow.slice.counter.a(this));
        WeakReference<EditText> r15 = d.a;
        d.c = new BuyNowCounterView$doBindManager$1(this);
        return;
    L9:
        r6.setImageResource(2131232439);
        r3.setImageResource(2131232437);
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    public /* synthetic */ BuyNowCounterView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final void b(boolean r2, int r3, int r4, int r5, String r6, String r7, String r8, String r9) {
        Intrinsics.checkNotNullParameter(r6, "minLimitToast");
        Intrinsics.checkNotNullParameter(r7, "maxLimitToast");
        Intrinsics.checkNotNullParameter(r8, "productId");
        Intrinsics.checkNotNullParameter(r9, "changeQuantityEvent");
        if (this.c == false) goto L6;
        if (r2 == true) goto L6;
        d(com.bytedance.android.ecom.arch.slice.render.util.b.f(this.n.getText().toString(), r3));
    L6:
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.g = r6;
        this.h = r7;
        this.i = r8;
        this.j = r9;
        this.n.setText(String.valueOf(r3));
        boolean r10 = false;
        if (this.e >= this.d) goto L9;
        boolean r11 = true;
    L11:
        if (r11 == this.q) goto L18;
        this.q = r11;
        if (r11 == false) goto L16;
        this.l.setImageResource(2131232437);
        goto L18
    L16:
        this.l.setImageResource(2131232436);
    L18:
        if (this.d >= this.f) goto L21;
        r10 = true;
    L21:
        if (r10 == this.p) goto L27;
        this.p = r10;
        if (r10 == false) goto L26;
        this.m.setImageResource(2131232439);
        goto L27
    L26:
        this.m.setImageResource(2131232438);
    L27:
        if (r2 == false) goto L30;
        d.b = true;
        return;
    L30:
        return;
    L9:
        r11 = false;
        goto L11
    }
}
