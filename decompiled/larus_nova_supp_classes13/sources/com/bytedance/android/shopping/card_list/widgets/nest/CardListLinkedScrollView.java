package com.bytedance.android.shopping.card_list.widgets.nest;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import com.bytedance.android.shopping.card_list.widgets.CardListGULView;
import com.bytedance.android.shopping.card_list.widgets.LoadMoreFooterView;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0006¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rJ\u0010\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010R$\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00068\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006 "}, d2 = {"Lcom/bytedance/android/shopping/card_list/widgets/nest/CardListLinkedScrollView;", "Lcom/bytedance/android/shopping/card_list/widgets/nest/CardListTwoRevNestedScrollView;", "", "enable", "", "setViewAccessibility", "", "height", "setLoadMoreFooterViewHeight", "Landroidx/recyclerview/widget/RecyclerView;", "getYataBody", "Lcom/bytedance/android/shopping/card_list/widgets/CardListGULView;", "getGul", "Lcom/bytedance/android/shopping/card_list/container/init/CardListObjectContainer;", "objectContainer", "setObjectContainer", "Landroid/view/View;", FreqActions.ACTION_VIEW, "setTopView", "value", "p", "I", "setOuterHeight", "(I)V", "outerHeight", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CardListLinkedScrollView extends CardListTwoRevNestedScrollView {
    public static final /* synthetic */ int q = 0;
    public final RecyclerView m;
    public final CardListGULView n;
    public final LoadMoreFooterView o;
    public int p;

    public CardListLinkedScrollView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CardListLinkedScrollView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
    }

    public final void j() {
        d r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewState");
    L5:
        Function1<Integer, Boolean> r2 = new CardListTwoRevNestedScrollView$initView$1(this);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r0.f = r2;
        d r1 = this.a;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewState");
    L8:
        Function0<Boolean> r3 = new CardListTwoRevNestedScrollView$initView$2(this);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        CardListGULView r4 = this.n;
        r4.setViewState(getViewState().c);
        com.bytedance.android.shopping.card_list.widgets.a r5 = getViewAction().f;
        CardListLinkedScrollView$initView$1$1$1 r6 = new CardListLinkedScrollView$initView$1$1$1(this);
        r5.getClass();
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r5.a = r6;
        Unit r7 = Unit.INSTANCE;
        r4.setViewAction(r5);
        this.n.f();
        d r8 = getViewState();
        Function0<Boolean> r9 = new CardListLinkedScrollView$initView$2(this);
        r8.getClass();
        Intrinsics.checkNotNullParameter(r9, "<set-?>");
        r8.k = r9;
        getViewState().b(getViewState().d, new CardListLinkedScrollView$initObserver$1(this), true);
        getViewState().b(getViewState().e, new CardListLinkedScrollView$initObserver$2(this), false);
        getViewState().b(getViewState().g, new CardListLinkedScrollView$initObserver$3(this), true);
        getViewState().b(getViewState().h, new CardListLinkedScrollView$initObserver$4(this), true);
        getViewState().b(getViewState().i, new CardListLinkedScrollView$initObserver$5(this), true);
        getViewState().b(getViewState().j, new CardListLinkedScrollView$initObserver$6(this), true);
        getViewState().b(getViewState().l, new CardListLinkedScrollView$initObserver$7(this), true);
        getViewState().b(getViewState().m, new CardListLinkedScrollView$initObserver$8(this), true);
    }

    public final CardListGULView getGul() {
        return this.n;
    }

    public final RecyclerView getYataBody() {
        return this.m;
    }

    private final void setLoadMoreFooterViewHeight(int r3) {
        NestedScrollView r0 = this.o;
        Intrinsics.checkNotNullParameter(r0, "$this$setHeight");
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if (r1 == null) goto L5;
        r1.height = r3;
    L5:
        r0.setLayoutParams(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setOuterHeight(int r3) {
        if (this.p == r3) goto L13;
        RecyclerView r0 = this.m;
        if ((r0 instanceof MaxHeightRecyclerView) == true) goto L7;
        r0 = null;
    L7:
        MaxHeightRecyclerView r1 = (MaxHeightRecyclerView) r0;
        if (r1 == null) goto L10;
        r1.setMaxHeight(r3);
    L10:
        this.n.setOuterHeight(r3);
        ViewGroup.LayoutParams r2 = getLayoutParams();
        if (r2 == null) goto L13;
        r2.height = r3;
    L13:
        this.p = r3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setViewAccessibility(boolean r1) {
        com.bytedance.android.ec.core.utils.a.a(this, r1);
    }

    public final void setObjectContainer(CardListObjectContainer r2) {
        Intrinsics.checkNotNullParameter(r2, "objectContainer");
        this.n.setObjectContainer(r2);
    }

    public final void setTopView(View r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        ViewGroup r0 = getInnerLayout();
        if (r0 == null) goto L7;
        r0.removeView(this.m);
    L7:
        ViewGroup r1 = getInnerLayout();
        if (r1 == null) goto L11;
        r1.addView(r3, 0);
        return;
    }

    public static final /* synthetic */ void g(CardListLinkedScrollView r0, int r1) {
        r0.setLoadMoreFooterViewHeight(r1);
    }

    public static final /* synthetic */ void h(CardListLinkedScrollView r0, int r1) {
        r0.setOuterHeight(r1);
    }

    public static final /* synthetic */ void i(CardListLinkedScrollView r0, boolean r1) {
        r0.setViewAccessibility(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CardListLinkedScrollView(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        LayoutInflater.from(r3).inflate(2131559260, this, true);
        setInnerLayout((ViewGroup) findViewById(2131367728));
        RecyclerView r6 = findViewById(2131365196);
        r6.setLayoutManager(new LinearLayoutManager(r3, 1, false));
        f("rev1", r6);
        Unit r7 = Unit.INSTANCE;
        this.m = r6;
        CardListGULView r8 = (CardListGULView) findViewById(2131380660);
        r8.setSetUpCallBack(new CardListLinkedScrollView$$special$$inlined$apply$lambda$1(this));
        this.n = r8;
        this.o = (LoadMoreFooterView) findViewById(2131378951);
    }

    public /* synthetic */ CardListLinkedScrollView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
