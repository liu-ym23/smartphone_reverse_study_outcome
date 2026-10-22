package com.bytedance.android.shopping.new_cart.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import com.bytedance.android.shopping.card_list.widgets.nest.CardListLinkedScrollView;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010!\u001a\u00020\u0017¢\u0006\u0004\b\"\u0010#J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003R\"\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001b\u0010\u001c\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006$"}, d2 = {"Lcom/bytedance/android/shopping/new_cart/widgets/CardListCartErrorView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/view/View$OnClickListener;", "Lcom/bytedance/android/shopping/card_list/container/init/CardListObjectContainer;", "objectContainer", "", "setObjectContainer", "Lcom/bytedance/android/shopping/new_cart/widgets/i;", "a", "Lcom/bytedance/android/shopping/new_cart/widgets/i;", "getViewState", "()Lcom/bytedance/android/shopping/new_cart/widgets/i;", "setViewState", "(Lcom/bytedance/android/shopping/new_cart/widgets/i;)V", "viewState", "Lcom/bytedance/android/shopping/new_cart/widgets/ErrorViewAction;", "b", "Lcom/bytedance/android/shopping/new_cart/widgets/ErrorViewAction;", "getViewAction", "()Lcom/bytedance/android/shopping/new_cart/widgets/ErrorViewAction;", "setViewAction", "(Lcom/bytedance/android/shopping/new_cart/widgets/ErrorViewAction;)V", "viewAction", "", "g", "Lkotlin/Lazy;", "getRlBarHeight", "()I", "rlBarHeight", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CardListCartErrorView extends ConstraintLayout implements View.OnClickListener {
    public static final /* synthetic */ int h = 0;
    public i a;
    public ErrorViewAction b;
    public View c;
    public final View d;
    public final View e;
    public CardListLinkedScrollView f;
    public final Lazy g;

    public CardListCartErrorView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CardListCartErrorView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final int getRlBarHeight() {
        return ((Number) this.g.getValue()).intValue();
    }

    public final ErrorViewAction getViewAction() {
        ErrorViewAction r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewAction");
    L5:
        return r0;
    }

    public final i getViewState() {
        i r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewState");
    L5:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void initView() {
        View r0 = this.e;
        ImageView r1 = null;
        if (r0 == null) goto L5;
        CardListLinkedScrollView r2 = (CardListLinkedScrollView) r0.findViewById(2131378044);
    L6:
        this.f = r2;
        if (r2 == null) goto L9;
        r2.setTopView(this.d);
    L9:
        CardListLinkedScrollView r3 = this.f;
        if (r3 == null) goto L18;
        i r4 = this.a;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewState");
    L14:
        r3.setViewState(r4.e);
        ErrorViewAction r5 = this.b;
        if (r5 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewAction");
    L17:
        r3.setViewAction(r5.d);
        r3.j();
    L18:
        int r6 = com.bytedance.ies.xbridge.base.utils.c.a;
        int r7 = com.bytedance.ies.xbridge.base.utils.c.a(getContext());
        View r8 = this.e;
        if (r8 == null) goto L21;
        View r9 = r8.findViewById(2131384675);
    L22:
        this.c = r9;
        if (r9 == null) goto L25;
        r9.setPadding(0, r7, 0, 0);
    L25:
        View r10 = this.c;
        if (r10 == null) goto L31;
        int r11 = getRlBarHeight();
        Intrinsics.checkNotNullParameter(r10, "$this$setHeight");
        ViewGroup.LayoutParams r12 = r10.getLayoutParams();
        if (r12 == null) goto L30;
        r12.height = r11;
    L30:
        r10.setLayoutParams(r12);
    L31:
        requestLayout();
        View r13 = this.d;
        if (r13 == null) goto L36;
        TextView r14 = (TextView) r13.findViewById(2131391305);
        if (r14 == null) goto L36;
        int r15 = com.bytedance.android.shopping.card_list.utils.f.a;
        com.bytedance.android.shopping.card_list.utils.f.b(r14, "button", r14.getText().toString(), false);
        Unit r16 = Unit.INSTANCE;
    L37:
        if (r14 == null) goto L39;
        r14.setOnClickListener(this);
    L39:
        View r17 = this.e;
        if (r17 == null) goto L42;
        r1 = (ImageView) r17.findViewById(2131376031);
    L42:
        if (r1 == null) goto L44;
        com.bytedance.android.shopping.card_list.utils.f.b(r1, "button", "返回", false);
    L44:
        Unit r18 = Unit.INSTANCE;
        if (r1 == null) goto L47;
        r1.setOnClickListener(this);
    L47:
        View r19 = this.e;
        if (r19 == null) goto L52;
        TextView r20 = (TextView) r19.findViewById(2131371743);
        if (r20 == null) goto L52;
        int r21 = com.bytedance.android.shopping.card_list.utils.f.a;
        com.bytedance.android.shopping.card_list.utils.f.b(r20, "text", r20.getText().toString(), true);
    L52:
        setBackgroundColor(ColorProtector.parseColor("#F5F6F9"));
        com.bytedance.android.shopping.card_list.utils.a.HandlerC0036a r22 = com.bytedance.android.shopping.card_list.utils.a.a;
        com.bytedance.android.shopping.card_list.utils.a.b(new CardListCartErrorView$hide$1(this));
        i r23 = this.a;
        if (r23 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("viewState");
    L55:
        i r24 = this.a;
        if (r24 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("viewState");
    L58:
        r23.b(r24.c, new CardListCartErrorView$initObserver$1(this), true);
        i r25 = this.a;
        if (r25 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("viewState");
    L61:
        i r26 = this.a;
        if (r26 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("viewState");
    L64:
        r25.b(r26.d, new CardListCartErrorView$initObserver$2(this), true);
        return;
    L36:
        r14 = null;
        goto L37
    L21:
        r9 = null;
        goto L22
    L5:
        r2 = null;
        goto L6
    }

    public static final /* synthetic */ int R5(CardListCartErrorView r0) {
        return r0.getRlBarHeight();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        Intrinsics.checkNotNullParameter(r3, "v");
        int r4 = r3.getId();
        if (r4 != 2131376031) goto L9;
        ErrorViewAction r5 = this.b;
        if (r5 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("viewAction");
    L7:
        r5.b.invoke();
        return;
    L9:
        if (r4 != 2131391305) goto L15;
        ErrorViewAction r6 = this.b;
        if (r6 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("viewAction");
    L13:
        r6.a.invoke();
        return;
    L15:
        if (r4 != 2131390122) goto L23;
        ErrorViewAction r7 = this.b;
        if (r7 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("viewAction");
    L19:
        r7.c.invoke();
        return;
    }

    public final void setObjectContainer(CardListObjectContainer r2) {
        Intrinsics.checkNotNullParameter(r2, "objectContainer");
        CardListLinkedScrollView r0 = this.f;
        if (r0 == null) goto L6;
        r0.setObjectContainer(r2);
        return;
    }

    public final void setViewAction(ErrorViewAction r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.b = r2;
    }

    public final void setViewState(i r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.a = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CardListCartErrorView(final Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.g = LazyKt.lazy(new CardListCartErrorView$rlBarHeight$2(r2));
        this.e = LayoutInflater.from(r2).inflate(2131559252, this, true);
        this.d = LayoutInflater.from(r2).inflate(2131559251, this, false);
    }

    public /* synthetic */ CardListCartErrorView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
