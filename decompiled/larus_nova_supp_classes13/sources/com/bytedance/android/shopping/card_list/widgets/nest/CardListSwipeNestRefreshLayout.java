package com.bytedance.android.shopping.card_list.widgets.nest;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.widget.NestedScrollView;
import com.bytedance.android.ec.core.utils.f;
import com.bytedance.android.shopping.card_list.widgets.CardListRefreshHeadView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/shopping/card_list/widgets/nest/CardListSwipeNestRefreshLayout;", "Landroidx/core/widget/NestedScrollView;", "Lcom/bytedance/android/shopping/card_list/widgets/nest/a;", "a", "Lcom/bytedance/android/shopping/card_list/widgets/nest/a;", "getViewState", "()Lcom/bytedance/android/shopping/card_list/widgets/nest/a;", "setViewState", "(Lcom/bytedance/android/shopping/card_list/widgets/nest/a;)V", "viewState", "Lcom/bytedance/android/shopping/card_list/widgets/nest/BodyViewAction;", "b", "Lcom/bytedance/android/shopping/card_list/widgets/nest/BodyViewAction;", "getViewAction", "()Lcom/bytedance/android/shopping/card_list/widgets/nest/BodyViewAction;", "setViewAction", "(Lcom/bytedance/android/shopping/card_list/widgets/nest/BodyViewAction;)V", "viewAction", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CardListSwipeNestRefreshLayout extends NestedScrollView {
    public static final /* synthetic */ int h = 0;
    public com.bytedance.android.shopping.card_list.widgets.nest.a a;
    public BodyViewAction b;
    public final int c;
    public CardListRefreshHeadView d;
    public CardListLinkedScrollView e;
    public boolean f;
    public boolean g;

    public static final class a implements View.OnLayoutChangeListener {
        public final /* synthetic */ CardListSwipeNestRefreshLayout a;

        public a(CardListSwipeNestRefreshLayout r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            this.a.getViewState().d.e.setValue(Integer.valueOf(r5 - r3));
        }
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ CardListSwipeNestRefreshLayout a;

        public b(CardListSwipeNestRefreshLayout r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r3) {
            CardListSwipeNestRefreshLayout r0 = this.a;     // Catch: Throwable -> L11
            Object r4 = r3.getAnimatedValue();     // Catch: Throwable -> L11
            if ((r4 instanceof Integer) == true) goto L5;
            r4 = null;
        L5:
            Integer r5 = (Integer) r4;     // Catch: Throwable -> L11
            if (r5 == null) goto L8;
            int r6 = r5.intValue();     // Catch: Throwable -> L11
        L9:
            float r7 = Math.max(0.0f, r6);     // Catch: Throwable -> L11
            int r1 = CardListSwipeNestRefreshLayout.h;     // Catch: Throwable -> L11
            r0.e(r7);     // Catch: Throwable -> L11
            return;
        L8:
            r6 = 0;
        }
    }

    public CardListSwipeNestRefreshLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CardListSwipeNestRefreshLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
    }

    public final BodyViewAction getViewAction() {
        BodyViewAction r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewAction");
    L5:
        return r0;
    }

    public final com.bytedance.android.shopping.card_list.widgets.nest.a getViewState() {
        com.bytedance.android.shopping.card_list.widgets.nest.a r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewState");
    L5:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void f() {
        this.e = (CardListLinkedScrollView) findViewById(2131378044);
        this.d = (CardListRefreshHeadView) findViewById(2131383443);
        CardListLinkedScrollView r0 = this.e;
        if (r0 == null) goto L11;
        com.bytedance.android.shopping.card_list.widgets.nest.a r2 = this.a;
        if (r2 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("viewState");
    L7:
        r0.setViewState(r2.d);
        BodyViewAction r3 = this.b;
        if (r3 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("viewAction");
    L10:
        r0.setViewAction(r3.d);
        r0.j();
    L11:
        addOnLayoutChangeListener(new a(this));
        com.bytedance.android.shopping.card_list.widgets.nest.a r1 = this.a;
        if (r1 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewState");
    L14:
        com.bytedance.android.shopping.card_list.widgets.nest.a r4 = this.a;
        if (r4 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewState");
    L17:
        r1.b(r4.c, new CardListSwipeNestRefreshLayout$initObserver$1(this), true);
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
    public final void e(float r5) {
        BodyViewAction r0 = this.b;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("viewAction");
    L6:
        if (r0.c == true) goto L9;
        return;
    L9:
        if (((int) r5) > 0) goto L13;
        CardListRefreshHeadView r1 = this.d;
        if (r1 == null) goto L13;
        r1.b();
    L13:
        int r2 = CardListRefreshHeadView.c;
        int r3 = CardListRefreshHeadView.c;
        if (r5 >= r3) goto L18;
        CardListRefreshHeadView r4 = this.d;
        if (r4 == null) goto L21;
        r4.setTranslationY(r5);
    L21:
        NestedScrollView r6 = this.e;
        if (r6 == null) goto L25;
        r6.setTranslationY(Math.max(0.0f, r5));
        return;
    L25:
        return;
    L18:
        CardListRefreshHeadView r7 = this.d;
        if (r7 == null) goto L21;
        r7.setTranslationY(((r5 - r3) / 2) + r3);
        goto L21
    }

    public final void g(boolean r4) {
        if (this.g == false) goto L5;
        return;
    L5:
        int r0 = 0;
        if (r4 == true) goto L13;
        NestedScrollView r1 = this.e;
        if (r1 == null) goto L10;
        int r2 = (int) r1.getTranslationY();
    L11:
        if (r2 != 0) goto L13;
        return;
    L10:
        r2 = 0;
    L13:
        int[] r3 = new int[2];
        NestedScrollView r5 = this.e;
        if (r5 == null) goto L16;
        int r6 = (int) r5.getTranslationY();
    L17:
        r3[0] = r6;
        if (r4 == false) goto L20;
        r0 = this.c;
    L20:
        r3[1] = r0;
        ValueAnimator r7 = ValueAnimator.ofInt(r3);
        r7.setDuration(100);
        r7.addUpdateListener(new b(this));
        f.a(r7, new CardListSwipeNestRefreshLayout$scrollByAnimator$$inlined$apply$lambda$2(this));
        this.g = true;
        r7.start();
        return;
    L16:
        r6 = 0;
        goto L17
    }

    public final void setViewAction(BodyViewAction r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.b = r2;
    }

    public final void setViewState(com.bytedance.android.shopping.card_list.widgets.nest.a r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.a = r2;
    }

    public final void onStopNestedScroll(View r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "target");
        if (r6 != 0) goto L24;
        NestedScrollView r0 = this.e;
        boolean r1 = false;
        if (r0 == null) goto L7;
        int r2 = (int) r0.getTranslationY();
    L9:
        if (r2 <= this.c) goto L11;
        r1 = true;
    L11:
        if (r2 <= 0) goto L24;
        g(r1);
        if (r1 == false) goto L24;
        if (this.f == true) goto L24;
        this.f = true;
        CardListRefreshHeadView r3 = this.d;
        if (r3 == null) goto L20;
        r3.a();
    L20:
        BodyViewAction r4 = this.b;
        if (r4 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("viewAction");
    L23:
        r4.a.invoke();
        goto L24
    L7:
        r2 = 0;
    L24:
        super.onStopNestedScroll(r5, r6);
    }

    public CardListSwipeNestRefreshLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.c = com.bytedance.android.shopping.extensions.b.b(80);
    }

    public /* synthetic */ CardListSwipeNestRefreshLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final void onNestedPreScroll(View r10, int r11, int r12, int[] r13, int r14) {
        Intrinsics.checkNotNullParameter(r10, "target");
        Intrinsics.checkNotNullParameter(r13, "consumed");
        int r1 = r12 - r13[1];
        NestedScrollView r2 = this.e;
        if (r2 == null) goto L5;
        int r3 = (int) r2.getTranslationY();
    L7:
        if (this.g == true) goto L13;
        if (r1 <= 0) goto L12;
        if (r3 <= 0) goto L12;
        r1 = Math.min(r1, r3);
        e(Math.max(0, r3 - r1));
    L12:
        r1 = 0;
    L13:
        int r4 = r13[1] + r1;
        r13[1] = r4;
        super.onNestedPreScroll(r10, r11, r12 - r4, r13, r14);
        return;
    L5:
        r3 = 0;
        goto L7
    }

    public final void onNestedScroll(View r9, int r10, int r11, int r12, int r13, int r14, int[] r15) {
        Intrinsics.checkNotNullParameter(r9, "target");
        Intrinsics.checkNotNullParameter(r15, "consumed");
        if (r13 >= 0) goto L15;
        if (r14 != 0) goto L15;
        BodyViewAction r16 = this.b;
        if (r16 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("viewAction");
    L9:
        if (((Boolean) r16.b.invoke(Integer.valueOf(r13))).booleanValue() == true) goto L15;
        NestedScrollView r17 = this.e;
        if (r17 == null) goto L13;
        float r18 = r17.getTranslationY();
    L14:
        e(Math.max(0.0f, r18 - (Math.max(0.2f, (300 - Math.abs(r18)) / 300.0f) * r13)));
        r15[1] = r15[1] + r13;
        int r3 = r13;
    L16:
        super.onNestedScroll(r9, r10, r3, r12, r13 - r3, r14, r15);
        return;
    L13:
        r18 = 0.0f;
    L15:
        r3 = 0;
        goto L16
    }
}
