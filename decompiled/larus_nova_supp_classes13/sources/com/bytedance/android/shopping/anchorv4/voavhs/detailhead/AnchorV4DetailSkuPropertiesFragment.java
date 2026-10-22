package com.bytedance.android.shopping.anchorv4.voavhs.detailhead;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.shopping.anchorv3.repository.dto.AttrItem;
import com.bytedance.android.shopping.anchorv3.repository.dto.ProductFormat;
import com.bytedance.android.shopping.anchorv3.repository.dto.ProductFormatGroup;
import com.bytedance.android.shopping.anchorv3.view.AnchorV4QualificationNewDesignView;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.jedi.JediBaseFragment;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.commerce.uikit.flowlayout.TagFlowLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/detailhead/AnchorV4DetailSkuPropertiesFragment;", "Lcom/bytedance/android/shopping/jedi/JediBaseFragment;", "<init>", "()V", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4DetailSkuPropertiesFragment extends JediBaseFragment {
    public static final /* synthetic */ int o = 0;
    public View g;
    public TextView h;
    public TextView i;
    public ExpandableLinearLayoutV4 j;
    public DetailSkuPropertiesFragmentParams k;
    public final List<u> l;
    public boolean m;
    public final int n;

    public static final class a {
    }

    static {
    }

    public final boolean S90() {
        t r0 = this.k.getViewModel();
        if (r0 == null) goto L7;
        CommonMeta r1 = r0.a();
        if (r1 == null) goto L7;
        Boolean r2 = Boolean.valueOf(r1.getEnablePDPOptimize());
    L9:
        return com.bytedance.android.shopping.extensions.k.i(r2);
    L7:
        r2 = null;
        goto L9
    }

    public final void onResume() {
        super.onResume();
        if (this.m == true) goto L97;
        this.m = true;
        AnchorV4DetailSkuVO r0 = this.k.getVo();
        if (r0 == null) goto L8;
        List<AnchorV4SubProduct> r1 = r0.getSubProducts();
    L9:
        if (r1 != null) goto L11;
    L86:
        View r2 = this.g;
        if (r2 == null) goto L96;
        r2.setVisibility(8);
        return;
    L96:
        return;
    L11:
        if (r0.getSubProducts().isEmpty() == true) goto L86;
        ((ArrayList) this.l).clear();
        AnchorV4SubProduct r3 = (AnchorV4SubProduct) ListProtector.get(r0.getSubProducts(), 0);
        TextView r4 = this.h;
        if (r4 == null) goto L20;
        ProductFormatGroup r5 = r3.getProductFormatGroup();
        if (r5 == null) goto L18;
        String r6 = r5.getGroupName();
    L19:
        r4.setText(r6);
        goto L20
    L18:
        r6 = null;
    L20:
        StringBuilder r7 = new StringBuilder("x ");
        if (r3.getCombineNum() > 0) goto L23;
        int r8 = 1;
    L24:
        r7.append(r8);
        TextView r9 = this.i;
        if (r9 == null) goto L27;
        r9.setText(r7.toString());
    L27:
        ProductFormatGroup r10 = r3.getProductFormatGroup();
        if (r10 == null) goto L30;
        List r11 = r10.getProductFormat();
    L31:
        ExpandableLinearLayoutV4 r12 = this.j;
        if (r12 != null) goto L34;
    L71:
        ExpandableLinearLayoutV4 r13 = this.j;
        if (r13 == null) goto L75;
        r13.setStateChangeListener(new o(this));
    L75:
        if (S90() == false) goto L93;
        View r14 = this.g;
        if (r14 == null) goto L94;
        ViewGroup.LayoutParams r15 = r14.getLayoutParams();
        if ((r15 instanceof ViewGroup.MarginLayoutParams) == true) goto L81;
        ViewGroup.LayoutParams r16 = null;
    L82:
        ViewGroup.MarginLayoutParams r17 = (ViewGroup.MarginLayoutParams) r16;
        if (r17 == null) goto L85;
        r17.bottomMargin = com.bytedance.android.shopping.extensions.b.b(11);
        r17.leftMargin = com.bytedance.android.shopping.extensions.b.b(12);
        r17.rightMargin = com.bytedance.android.shopping.extensions.b.b(12);
        r14.setLayoutParams(r17);
    L85:
        r14.setBackgroundResource(2131247875);
        return;
    L81:
        r16 = r15;
        goto L82
    L94:
        return;
    L93:
        return;
    L34:
        if (r12.getChildCount() <= 0) goto L36;
        r12.removeAllViews();
    L36:
        if (r11 == null) goto L60;
        int r18 = r11.size();
        int r19 = this.n;
        if (r18 > r19) goto L41;
        r19 = r11.size();
    L41:
        int r110 = r19;
        int r111 = 0;
    L42:
        if (r111 >= r110) goto L60;
        ProductFormat r20 = (ProductFormat) ListProtector.get(r11, r111);
        Context r21 = r12.getContext();
        ShoppingAsyncInflater.e.getClass();
        View r112 = ShoppingAsyncInflater.a.a(r21).aU(2131560497, this.j, false);
        ((TextView) r112.findViewById(2131391606)).setText(r20.getName());
        TagFlowLayout r113 = r112.findViewById(2131388106);
        AnchorV4QualificationNewDesignView r22 = r112.findViewById(2131383521);
        t r23 = this.k.getViewModel();
        if (r23 == null) goto L48;
        CommonMeta r24 = r23.a();
        if (r24 == null) goto L48;
        String r25 = r24.getShopId();
    L49:
        q r26 = new q(this);
        int r27 = AnchorV4QualificationNewDesignView.m;
        if (Intrinsics.areEqual(r20.getNewDesign(), Boolean.TRUE) == false) goto L58;
        wg.a.h(r22, true);
        wg.a.h(r113, false);
        AttrItem r28 = (AttrItem) CollectionsKt.getOrNull(r20.getMessage(), 0);
        if (r28 == null) goto L54;
        String r29 = r28.getDesc();
    L55:
        if (r29 != null) goto L57;
        r29 = "";
    L57:
        r22.d(r29, r20, r25, r26);
        ((ArrayList) this.l).add(r22);
    L59:
        r12.a(r112);
        r111 = r111 + 1;
        goto L42
    L54:
        r29 = null;
        goto L55
    L58:
        wg.a.h(r113, true);
        wg.a.h(r22, false);
        r113.setTagAdapter(new p(this, r20, r25, r26, r20.getMessage()));
    L48:
        r25 = null;
    L60:
        AnchorV4DetailSkuVO r30 = this.k.getVo();
        if (r30 != null) goto L63;
    L70:
        r12.post(new n(this, r11));
        goto L71
    L63:
        if (r30.getShowBottomView() != true) goto L70;
        Boolean r31 = Boolean.valueOf(S90());
        if (r31 == null) goto L68;
        r31.booleanValue();
        r12.h = r31.booleanValue();
    L68:
        if (r12.b == true) goto L70;
        r12.addView(r12.c(r12.h));
        r12.b = true;
        goto L70
    L30:
        r11 = null;
        goto L31
    L23:
        r8 = r3.getCombineNum();
        goto L24
    L8:
        r1 = null;
        goto L9
    }

    public AnchorV4DetailSkuPropertiesFragment() {
        this.k = new DetailSkuPropertiesFragmentParams(0, null, null, 7, null);
        this.l = new ArrayList();
        this.n = 5;
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.m = false;
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, FreqActions.ACTION_VIEW);
        super.onViewCreated(r2, r3);
        this.g = r2.findViewById(2131387579);
        this.h = (TextView) r2.findViewById(2131368904);
        this.i = (TextView) r2.findViewById(2131368903);
        this.j = (ExpandableLinearLayoutV4) r2.findViewById(2131371907);
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return u63.a.a(requireContext(), 2131560483, r3, false);
    }
}
