package com.bytedance.android.shopping.new_cart.widgets.nest;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.opt.ab.p;
import com.bytedance.android.shopping.new_cart.utils.CartSettingUtils;
import com.bytedance.android.shopping.new_cart.widgets.CartRefreshHeadView;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010/\u001a\u00020.\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u000100\u0012\b\b\u0002\u00102\u001a\u00020\u0016¢\u0006\u0004\b3\u00104J\u0014\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002R$\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u001d\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010%\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010-\u001a\u00020&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u00065"}, d2 = {"Lcom/bytedance/android/shopping/new_cart/widgets/nest/CartSwipeNestRefreshLayoutV2;", "Landroidx/core/widget/NestedScrollView;", "Lkotlin/Function0;", "", "listener", "setOnRefreshListener", "Lcom/bytedance/android/shopping/new_cart/widgets/CartRefreshHeadView;", "d", "Lcom/bytedance/android/shopping/new_cart/widgets/CartRefreshHeadView;", "getHeaderView", "()Lcom/bytedance/android/shopping/new_cart/widgets/CartRefreshHeadView;", "setHeaderView", "(Lcom/bytedance/android/shopping/new_cart/widgets/CartRefreshHeadView;)V", "headerView", "Lcom/bytedance/android/shopping/new_cart/widgets/nest/CartLinkedScrollViewV2;", "e", "Lcom/bytedance/android/shopping/new_cart/widgets/nest/CartLinkedScrollViewV2;", "getBodyView", "()Lcom/bytedance/android/shopping/new_cart/widgets/nest/CartLinkedScrollViewV2;", "setBodyView", "(Lcom/bytedance/android/shopping/new_cart/widgets/nest/CartLinkedScrollViewV2;)V", "bodyView", "", "f", "I", "getFooterHeightForRoundCorner", "()I", "setFooterHeightForRoundCorner", "(I)V", "footerHeightForRoundCorner", "Landroid/view/View;", "g", "Landroid/view/View;", "getFooterView", "()Landroid/view/View;", "setFooterView", "(Landroid/view/View;)V", "footerView", "", "i", "Z", "getOnAnimate", "()Z", "setOnAnimate", "(Z)V", "onAnimate", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CartSwipeNestRefreshLayoutV2 extends NestedScrollView {
    public static final /* synthetic */ int j = 0;
    public Function0<Unit> a;
    public final boolean b;
    public final int c;
    public CartRefreshHeadView d;
    public CartLinkedScrollViewV2 e;
    public int f;
    public View g;
    public boolean h;
    public boolean i;

    public static final class a implements View.OnLayoutChangeListener {
        public final /* synthetic */ CartSwipeNestRefreshLayoutV2 a;

        public a(CartSwipeNestRefreshLayoutV2 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            View r10 = this.a.getFooterView();
            int r11 = 0;
            if (r10 != null) goto L5;
        L7:
            boolean r12 = false;
        L8:
            if (r12 == false) goto L10;
            int r13 = this.a.getFooterHeightForRoundCorner();
        L11:
            int r14 = r5 - r3;
            int r15 = r14 - r13;
            CartLinkedScrollViewV2 r16 = this.a.getBodyView();
            if (r16 != null) goto L14;
        L15:
            CartLinkedScrollViewV2 r17 = this.a.getBodyView();
            if (r17 == null) goto L19;
            r17.setOuterHeight(r15);
        L19:
            if (CartSettingUtils.a() == false) goto L23;
            CartLinkedScrollViewV2 r18 = this.a.getBodyView();
            if (r18 == null) goto L23;
            r18.setPhysicalHeight(r14);
        L23:
            if (r12 == false) goto L25;
            r11 = this.a.getFooterHeightForRoundCorner();
        L25:
            CartLinkedScrollViewV2 r19 = this.a.getBodyView();
            if (r19 == null) goto L29;
            r19.r(r11);
            return;
        L29:
            return;
        L14:
            if (r16.getOuterHeight() == r15) goto L19;
        L10:
            r13 = 0;
            goto L11
        L5:
            if (r10.getVisibility() != 0) goto L7;
            r12 = true;
            goto L8
        }
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ CartSwipeNestRefreshLayoutV2 a;

        public b(CartSwipeNestRefreshLayoutV2 r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r3) {
            CartSwipeNestRefreshLayoutV2 r0 = this.a;     // Catch: Throwable -> L11
            Object r4 = r3.getAnimatedValue();     // Catch: Throwable -> L11
            if ((r4 instanceof Integer) == true) goto L5;
            r4 = null;
        L5:
            Integer r5 = (Integer) r4;     // Catch: Throwable -> L11
            if (r5 == null) goto L8;
            int r6 = r5.intValue();     // Catch: Throwable -> L11
        L9:
            float r7 = Math.max(0.0f, r6);     // Catch: Throwable -> L11
            int r1 = CartSwipeNestRefreshLayoutV2.j;     // Catch: Throwable -> L11
            r0.e(r7);     // Catch: Throwable -> L11
            return;
        L8:
            r6 = 0;
        }
    }

    public CartSwipeNestRefreshLayoutV2(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CartSwipeNestRefreshLayoutV2(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
    }

    public final CartLinkedScrollViewV2 getBodyView() {
        return this.e;
    }

    public final int getFooterHeightForRoundCorner() {
        return this.f;
    }

    public final View getFooterView() {
        return this.g;
    }

    public final CartRefreshHeadView getHeaderView() {
        return this.d;
    }

    public final boolean getOnAnimate() {
        return this.i;
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
        if (((int) r5) > 0) goto L7;
        CartRefreshHeadView r0 = this.d;
        if (r0 == null) goto L7;
        r0.b();
    L7:
        int r1 = CartRefreshHeadView.c;
        int r2 = CartRefreshHeadView.c;
        if (r5 >= r2) goto L12;
        CartRefreshHeadView r3 = this.d;
        if (r3 == null) goto L15;
        r3.setTranslationY(r5);
    L15:
        NestedScrollView r4 = this.e;
        if (r4 == null) goto L19;
        r4.setTranslationY(Math.max(0.0f, r5));
        return;
    L19:
        return;
    L12:
        CartRefreshHeadView r6 = this.d;
        if (r6 == null) goto L15;
        r6.setTranslationY(((r5 - r2) / 2) + r2);
        goto L15
    }

    public final void f(boolean r4) {
        if (this.i == false) goto L5;
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
        com.bytedance.android.ec.core.utils.f.a(r7, new CartSwipeNestRefreshLayoutV2$scrollByAnimator$$inlined$apply$lambda$2(this));
        this.i = true;
        r7.start();
        return;
    L16:
        r6 = 0;
        goto L17
    }

    public final void setBodyView(CartLinkedScrollViewV2 r1) {
        this.e = r1;
    }

    public final void setFooterHeightForRoundCorner(int r1) {
        this.f = r1;
    }

    public final void setFooterView(View r1) {
        this.g = r1;
    }

    public final void setHeaderView(CartRefreshHeadView r1) {
        this.d = r1;
    }

    public final void setOnAnimate(boolean r1) {
        this.i = r1;
    }

    public final void setOnRefreshListener(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.a = r2;
    }

    public final void onStopNestedScroll(View r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "target");
        if (r6 != 0) goto L23;
        NestedScrollView r0 = this.e;
        boolean r1 = false;
        if (r0 == null) goto L7;
        int r2 = (int) r0.getTranslationY();
    L9:
        if (r2 <= this.c) goto L11;
        r1 = true;
    L11:
        if (r2 <= 0) goto L23;
        f(r1);
        if (r1 == false) goto L23;
        if (this.h == true) goto L23;
        this.h = true;
        CartRefreshHeadView r3 = this.d;
        if (r3 == null) goto L20;
        r3.a();
    L20:
        Function0<Unit> r4 = this.a;
        if (r4 == null) goto L23;
        Unit r7 = (Unit) r4.invoke();
        goto L23
    L7:
        r2 = 0;
    L23:
        super.onStopNestedScroll(r5, r6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CartSwipeNestRefreshLayoutV2(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        ECSettingKeys.j.getClass();
        int r5 = p.a;
        int r6 = com.bytedance.android.ec.core.abtest.e.a;
        Object r7 = com.bytedance.android.ec.core.abtest.e.a(Boolean.TRUE, Boolean.FALSE);
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r1 = jj4.b.b;     // Catch: Throwable -> L7
        Object r8 = jj4.a.a("yata_cart_list_v2_pull_down_opt", Boolean.class, r7, false);     // Catch: Throwable -> L7
        if (r8 != null) goto L13;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L13:
        this.b = ((Boolean) r8).booleanValue();
        ECSettingKeys.j.getClass();
        int r9 = p.a;
        Object r10 = 80;
        jj4.b r11 = jj4.b.b;     // Catch: Throwable -> L18
        Object r12 = jj4.a.a("yata_cart_pull_refresh_threshold", Integer.class, r10, false);     // Catch: Throwable -> L18
        if (r12 != null) goto L24;
        Intrinsics.throwNpe();     // Catch: Throwable -> L18
    L24:
        this.c = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(((Number) r12).intValue()));
        addOnLayoutChangeListener(new a(this));
        return;
    L18:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L23;
        r10 = r14;
    L23:
        r12 = r10;
    L7:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        Object r16 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r16) == true) goto L12;
        r7 = r16;
    L12:
        r8 = r7;
        goto L13
    }

    public /* synthetic */ CartSwipeNestRefreshLayoutV2(Context r1, AttributeSet r2, int r3, int r4) {
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
        if (this.i == true) goto L13;
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
    public final void onNestedScroll(View r10, int r11, int r12, int r13, int r14, int r15, int[] r16) {
        Intrinsics.checkNotNullParameter(r10, "target");
        Intrinsics.checkNotNullParameter(r16, "consumed");
        if (r14 >= 0) goto L28;
        if (r15 != 0) goto L28;
        if (this.b == false) goto L23;
        CartLinkedScrollViewV2 r3 = this.e;
        if (r3 == null) goto L28;
        CartTwoRevNestedScrollView.a r4 = r3.k;
        if (r4.e.canScrollVertically(r14) == true) goto L21;
        RecyclerView r5 = r4.e.e;
        if (r5 != null) goto L14;
    L15:
        RecyclerView r6 = r4.e.f;
        if (r6 != null) goto L18;
    L20:
        boolean r7 = false;
    L22:
        if (r7 == true) goto L28;
    L18:
        if (r6.canScrollVertically(r14) != true) goto L20;
    L14:
        if (r5.canScrollVertically(r14) != true) goto L15;
    L21:
        r7 = true;
    L23:
        NestedScrollView r1 = this.e;
        if (r1 == null) goto L26;
        float r2 = r1.getTranslationY();
    L27:
        e(Math.max(0.0f, r2 - (Math.max(0.2f, (300 - Math.abs(r2)) / 300.0f) * r14)));
        r16[1] = r16[1] + r14;
        int r8 = r14;
    L29:
        super.onNestedScroll(r10, r11, r8, r13, r14 - r8, r15, r16);
        return;
    L26:
        r2 = 0.0f;
    L28:
        r8 = 0;
        goto L29
    }
}
