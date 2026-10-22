package com.bytedance.android.shopping.deepfeed.ui.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.shopping.deepfeed.fold.DeepFeedFoldHelper;
import com.bytedance.android.shopping.deepfeed.ui.vh.AbsDeepFeedProductVH;
import com.bytedance.android.shopping.deepfeed.viewmodel.DeepFeedProductViewModel;
import com.bytedance.android.shopping.deepfeed.weights.common.ProductMarqueeTextView;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.facebook.drawee.view.SimpleDraweeView;
import com.gyf.barlibrary.ImmersionBar;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class DeepFeedTopBarManager implements com.bytedance.android.shopping.deepfeed.ui.c {
    public ImageView a;
    public LottieAnimationView b;
    public ConstraintLayout c;
    public SimpleDraweeView d;
    public SimpleDraweeView e;
    public ProductMarqueeTextView f;
    public boolean g;
    public final Lazy h;
    public final View i;
    public final Fragment j;

    @Override // com.bytedance.android.shopping.deepfeed.ui.c
    public final void B() {
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.c
    public final boolean o() {
        return this.g;
    }

    public static final boolean a(DeepFeedTopBarManager r1) {
        r1.getClass();
        Lazy r0 = DeepFeedFoldHelper.a;
        DeepFeedFoldHelper.b(r1.j.getActivity());
        return false;
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.c
    public final void e(float r2) {
        ConstraintLayout r0 = this.c;
        if (r0 == null) goto L6;
        r0.setAlpha(r2);
        return;
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.c
    public final void l(boolean r3) {
        if (r3 == true) goto L16;
        if (tc3.f.b() == false) goto L12;
        ImageView r4 = this.a;
        if (r4 == null) goto L9;
        r4.setVisibility(8);
    L9:
        LottieAnimationView r5 = this.b;
        if (r5 == null) goto L27;
        r5.setVisibility(8);
        return;
    L27:
        return;
    L12:
        ImageView r6 = this.a;
        if (r6 == null) goto L29;
        r6.setVisibility(8);
        return;
    L29:
        return;
    L16:
        if (tc3.f.b() == false) goto L23;
        LottieAnimationView r7 = this.b;
        if (r7 == null) goto L20;
        r7.setVisibility(0);
    L20:
        ImageView r8 = this.a;
        if (r8 == null) goto L31;
        r8.setVisibility(8);
        return;
    L31:
        return;
    L23:
        ImageView r9 = this.a;
        if (r9 == null) goto L33;
        r9.setVisibility(0);
        return;
    }

    public DeepFeedTopBarManager(View r2, Fragment r3) {
        Intrinsics.checkNotNullParameter(r2, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r3, "fragment");
        this.i = r2;
        this.j = r3;
        this.h = LazyKt.lazy(DeepFeedTopBarManager$imageCallerContext$2.INSTANCE);
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.c
    public final void f(final DeepFeedProductViewModel r8, com.bytedance.android.shopping.deepfeed.action.b r9, Function0<? extends AbsDeepFeedProductVH> r10) {
        Intrinsics.checkNotNullParameter(r8, "viewModel");
        Intrinsics.checkNotNullParameter(r9, "deepFeedContext");
        Intrinsics.checkNotNullParameter(r10, "curVH");
        View r0 = this.i;
        Fragment r1 = this.j;
        View r2 = r0.findViewById(2131389050);
        if (r2 == null) goto L5;
        r2.setVisibility(0);
        Lazy r4 = DeepFeedFoldHelper.a;
        DeepFeedFoldHelper.b(r1.getActivity());
        ImmersionBar.with(r1).titleBar(r2).init();
    L5:
        ImageView r3 = (ImageView) r0.findViewById(2131376031);
        if (r3 == null) goto L8;
        r3.setOnClickListener(new j(this, r1));
        Unit r5 = Unit.INSTANCE;
    L8:
        ImageView r6 = (ImageView) this.i.findViewById(2131376252);
        LottieAnimationView r7 = null;
        if (r6 == null) goto L12;
        r6.setOnClickListener(new m(this));
        Unit r11 = Unit.INSTANCE;
    L12:
        if (this.j.getActivity() == null) goto L15;
        Lazy r12 = DeepFeedFoldHelper.a;
        DeepFeedFoldHelper.b(this.j.getActivity());
    L15:
        final View r13 = this.i;
        r9.getClass();
        ConstraintLayout r14 = r13.findViewById(2131386223);
        this.c = r14;
        if (r14 == null) goto L18;
        r14.setVisibility(0);
    L18:
        this.d = r13.findViewById(2131386248);
        this.e = r13.findViewById(2131386225);
        ProductMarqueeTextView r15 = (ProductMarqueeTextView) r13.findViewById(2131386263);
        this.f = r15;
        if (r15 == null) goto L21;
        a r16 = a.e;
        r15.setTextSize(0, a.C0061a.a(r13.getContext(), 16));
    L21:
        ProductMarqueeTextView r17 = this.f;
        if (r17 == null) goto L24;
        r17.setWeight(500);
    L24:
        int r18 = k1.q();
        if (r18 <= 0) goto L36;
        ConstraintLayout r19 = this.c;
        if (r19 == null) goto L29;
        ViewGroup.LayoutParams r20 = r19.getLayoutParams();
    L31:
        if ((r20 instanceof ViewGroup.MarginLayoutParams) == true) goto L33;
        r20 = null;
    L33:
        ViewGroup.MarginLayoutParams r21 = (ViewGroup.MarginLayoutParams) r20;
        if (r21 == null) goto L36;
        r21.topMargin = r18;
        Lazy r22 = DeepFeedFoldHelper.a;
        DeepFeedFoldHelper.b(this.j.getActivity());
        goto L36
    L29:
        r20 = null;
    L36:
        Intrinsics.checkNotNullParameter(new DeepFeedTopBarManager$initShopView$2(this, r13, r8), "callback");
        View r23 = this.i;
        if (tc3.f.b() == false) goto L50;
        LottieAnimationView r24 = r23.findViewById(2131365241);
        if (r24 == null) goto L44;
        AbsDeepFeedProductVH r25 = (AbsDeepFeedProductVH) r10.invoke();
        if (r25 == null) goto L43;
        r7 = r25.m;
    L43:
        r8.logShowCartEntrance("c958668.d226180", r23, r7);
        r24.setOnClickListener(new k(r8, r23, r10));
        int r26 = re3.b.a;
        Intrinsics.checkNotNullParameter(r24, FreqActions.ACTION_VIEW);
        new WeakReference(r24);
        r24.setAnimation("shopping_deep_feed_cart_lottie.json");
        Unit r27 = Unit.INSTANCE;
        r7 = r24;
    L44:
        this.b = r7;
        if (r7 == null) goto L47;
        r7.setVisibility(0);
    L47:
        ImageView r28 = (ImageView) r23.findViewById(2131376076);
        this.a = r28;
        if (r28 == null) goto L58;
        r28.setVisibility(8);
        return;
    L58:
        return;
    L50:
        LottieAnimationView r29 = (ImageView) r23.findViewById(2131376076);
        if (r29 == null) goto L56;
        AbsDeepFeedProductVH r30 = (AbsDeepFeedProductVH) r10.invoke();
        if (r30 == null) goto L55;
        r7 = r30.m;
    L55:
        r8.logShowCartEntrance("c958668.d226180", r23, r7);
        r29.setOnClickListener(new l(r8, r23, r10));
        int r31 = re3.b.a;
        Intrinsics.checkNotNullParameter(r29, FreqActions.ACTION_VIEW);
        new WeakReference(r29);
        Unit r32 = Unit.INSTANCE;
        r7 = r29;
    L56:
        this.a = r7;
    }
}
