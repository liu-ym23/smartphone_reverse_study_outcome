package com.bytedance.android.shopping.deepfeed.weights;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ec.core.utils.d2;
import com.bytedance.android.shopping.deepfeed.fold.DeepFeedFoldHelper;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductPackData;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductPackDataElements;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductV2;
import com.bytedance.android.shopping.infeed.data.idl.ad.AdBaseInfo;
import he3.p0;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/weights/DeepFeedProductAbilityView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/android/shopping/deepfeed/weights/DeepFeedProductAbilityBuyAndCart;", "c", "Lcom/bytedance/android/shopping/deepfeed/weights/DeepFeedProductAbilityBuyAndCart;", "getAbilityBuyAndCart", "()Lcom/bytedance/android/shopping/deepfeed/weights/DeepFeedProductAbilityBuyAndCart;", "abilityBuyAndCart", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeepFeedProductAbilityView extends ConstraintLayout {
    public DeepFeedAbilityComment a;
    public DeepFeedAbilityCollect b;
    public final DeepFeedProductAbilityBuyAndCart c;
    public final ViewStub d;
    public ConstraintLayout e;
    public final ImageView f;

    public DeepFeedProductAbilityView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public DeepFeedProductAbilityView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final DeepFeedProductAbilityBuyAndCart getAbilityBuyAndCart() {
        return this.c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DeepFeedProductAbilityView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        ViewGroup.inflate(r2, 2131564639, this);
        this.d = (ViewStub) findViewById(2131368689);
        ViewStub r5 = (ViewStub) findViewById(2131368700);
        DeepFeedProductAbilityBuyAndCart r6 = (DeepFeedProductAbilityBuyAndCart) findViewById(2131375252);
        this.c = r6;
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        com.bytedance.android.shopping.deepfeed.ui.view.a r0 = com.bytedance.android.shopping.deepfeed.ui.view.a.e;
        r7.width = com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(r2, 225);
        r6.setLayoutParams(r7);
        this.f = (ImageView) findViewById(2131362198);
        if (tc3.f.a() == false) goto L6;
        ViewGroup.LayoutParams r8 = r6.getLayoutParams();
        r8.height = com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(getContext(), 38);
        r6.setLayoutParams(r8);
        return;
    }

    public /* synthetic */ DeepFeedProductAbilityView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5(InFeedProductV2 r5, boolean r6, com.bytedance.android.shopping.deepfeed.action.h r7, final com.bytedance.android.shopping.deepfeed.action.i r8) {
        Intrinsics.checkNotNullParameter(r7, "dfContext");
        Intrinsics.checkNotNullParameter(r8, "parentAbility");
        int r0 = 0;
        if (r6 == true) goto L18;
        if (r5 == null) goto L16;
        Intrinsics.checkNotNullParameter(r5, "$this$isShoaAiInUnder");
        Intrinsics.checkNotNullParameter(r7, "deepFeedContext");
        List<he3.q> r9 = com.bytedance.android.shopping.deepfeed.utlis.g.a(r5);
        if (r9 != null) goto L8;
    L11:
        boolean r10 = true;
    L12:
        if (r10 == true) goto L16;
        if (r5.getDynamicData().j == true) goto L16;
        r7.m();
        goto L16
    L8:
        if (r9.isEmpty() == true) goto L11;
        r10 = false;
    L16:
        getLayoutParams().height = com.bytedance.android.shopping.extensions.b.b(70);
        setBackgroundResource(2131247870);
    L29:
        if (tc3.f.a() == false) goto L31;
        ViewGroup.LayoutParams r11 = this.c.getLayoutParams();
        com.bytedance.android.shopping.deepfeed.ui.view.a r1 = com.bytedance.android.shopping.deepfeed.ui.view.a.e;
        r11.width = com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(getContext(), 212);
        this.c.setLayoutParams(r11);
    L31:
        AdBaseInfo r12 = null;
        if (r5 == null) goto L40;
        InFeedProductPackData r2 = r5.getPackData();
        if (r2 == null) goto L40;
        InFeedProductPackDataElements r3 = r2.getElements();
        if (r3 == null) goto L40;
        List<p0> r4 = r3.getProducts();
        if (r4 == null) goto L40;
        p0 r13 = (p0) CollectionsKt.firstOrNull(r4);
    L41:
        r7.k();
        if (this.e != null) goto L61;
        View r14 = this.d.inflate();
        if ((r14 instanceof ConstraintLayout) == true) goto L46;
        r14 = null;
    L46:
        ConstraintLayout r15 = (ConstraintLayout) r14;
        this.e = r15;
        if (r15 == null) goto L49;
        DeepFeedAbilityCollect r16 = (DeepFeedAbilityCollect) r15.findViewById(2131368694);
    L50:
        this.b = r16;
        ConstraintLayout r17 = this.e;
        if (r17 == null) goto L53;
        DeepFeedAbilityComment r18 = (DeepFeedAbilityComment) r17.findViewById(2131368696);
    L54:
        this.a = r18;
        ConstraintLayout r19 = this.b;
        if (r19 == null) goto L57;
        r19.setOnClickListener(new DeepFeedProductAbilityView$showAbilityNoShop$1(this, r8));
    L57:
        DeepFeedAbilityComment r20 = this.a;
        if (r20 == null) goto L61;
        r20.setOnClickListener(new a(r8));
        goto L61
    L53:
        r18 = null;
        goto L54
    L49:
        r16 = null;
    L61:
        if (tc3.f.b() == false) goto L85;
        ConstraintLayout r21 = this.b;
        if (r21 == null) goto L65;
        ViewGroup.LayoutParams r22 = r21.getLayoutParams();
    L67:
        if ((r22 instanceof ConstraintLayout.LayoutParams) == true) goto L69;
        r22 = null;
    L69:
        ConstraintLayout.LayoutParams r23 = (ConstraintLayout.LayoutParams) r22;
        if (r23 == null) goto L72;
        ((ViewGroup.MarginLayoutParams) r23).height = -1;
    L72:
        ConstraintLayout r24 = this.b;
        if (r24 == null) goto L75;
        r24.setLayoutParams(r23);
    L75:
        ConstraintLayout r25 = this.b;
        if (r25 == null) goto L78;
        d2.d(r25, 0, 0, 0, 0);
    L78:
        DeepFeedAbilityComment r26 = this.a;
        if (r26 == null) goto L85;
        ViewGroup.LayoutParams r27 = r26.getLayoutParams();
        if (r27 == null) goto L85;
        com.bytedance.android.shopping.deepfeed.ui.view.a r28 = com.bytedance.android.shopping.deepfeed.ui.view.a.e;
        r27.height = com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(getContext(), 38);
        DeepFeedAbilityComment r29 = this.a;
        if (r29 == null) goto L85;
        r29.setLayoutParams(r27);
        goto L85
    L65:
        r22 = null;
    L85:
        DeepFeedFoldHelper.a();
        ConstraintLayout r30 = this.e;
        if (r30 == null) goto L88;
        r30.setVisibility(0);
    L88:
        if (r13 == null) goto L96;
        DeepFeedAbilityComment r31 = this.a;
        if (r31 == null) goto L92;
        r31.a(r13, false);
    L92:
        DeepFeedAbilityCollect r32 = this.b;
        if (r32 == null) goto L95;
        r32.R5(r13, false);
    L95:
        DeepFeedProductAbilityBuyAndCart r33 = this.c;
        r7.f();
        r33.a(r13, false);
    L96:
        if (r13 != null) goto L104;
        DeepFeedAbilityComment r34 = this.a;
        if (r34 == null) goto L100;
        r34.b();
    L100:
        DeepFeedAbilityCollect r35 = this.b;
        if (r35 == null) goto L103;
        r35.T5();
    L103:
        DeepFeedProductAbilityBuyAndCart r36 = this.c;
        r36.b.setVisibility(0);
        r36.a.setBackgroundResource(2131247866);
        r36.a.getLayoutParams().width = com.bytedance.android.shopping.extensions.b.b(108);
    L104:
        ImageView r37 = this.f;
        if (r5 == null) goto L113;
        InFeedProductPackData r38 = r5.getPackData();
        if (r38 == null) goto L113;
        InFeedProductPackDataElements r39 = r38.getElements();
        if (r39 == null) goto L113;
        ie3.a r40 = r39.getAd();
        if (r40 == null) goto L113;
        r12 = r40.a();
    L113:
        if (r12 != null) goto L116;
        r0 = 8;
    L116:
        r37.setVisibility(r0);
        return;
    L40:
        r13 = null;
        goto L41
    L18:
        if (tc3.f.a() == false) goto L26;
        Integer r41 = tc3.f.c();
        if (r41 != null) goto L23;
    L25:
        getLayoutParams().height = com.bytedance.android.shopping.extensions.b.b(64);
    L27:
        setBackgroundResource(2131247871);
        goto L29
    L23:
        if (r41.intValue() != 2) goto L25;
        getLayoutParams().height = com.bytedance.android.shopping.extensions.b.b(62);
        goto L27
    L26:
        getLayoutParams().height = com.bytedance.android.shopping.extensions.b.b(60);
        goto L27
    }
}
