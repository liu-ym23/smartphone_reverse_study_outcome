package com.bytedance.android.shopping.mall.homepage.card.loadview;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.list.ECHybridListAdapter;
import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.entity.k;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.ec.hybrid.list.view.ECHybridListContainer;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import s93.c;
import yj.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/loadview/LoadingViewCardVH;", "Lcom/bytedance/android/ec/hybrid/list/holder/BaseViewHolder;", "a", "b", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LoadingViewCardVH extends BaseViewHolder {
    public static final boolean q = false;
    public final View o;
    public final o93.a p;

    public static final class a {
    }

    public interface b {
        void a();
    }

    public final boolean C3() {
        return false;
    }

    static {
        int r0 = c.a;
        Object r1 = Boolean.TRUE;
        IHybridHostService r2 = com.bytedance.android.ec.hybrid.a.h();
        if (r2 == null) goto L10;
        g r3 = r2.getHostAB();
        if (r3 == null) goto L10;
        Object r4 = r3.a("ec_mall_feed_loading_layout_opt_enable", r1);
        if (r4 == null) goto L10;
        r1 = r4;
    L10:
        Lazy r5 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.c.a.b, "Key : ec_mall_feed_loading_layout_opt_enable, Value: " + r1);
        q = ((Boolean) r1).booleanValue();
    }

    public final void o() {
        super.o();
        o93.a r0 = this.p;
        r0.d.setVisibility(8);
        LottieAnimationView r1 = r0.a;
        if (r1 == null) goto L6;
        r1.cancelAnimation();
        return;
    }

    public final void onRelease() {
        super.onRelease();
        LottieAnimationView r0 = this.p.a;
        if (r0 == null) goto L6;
        r0.cancelAnimation();
        return;
    }

    public LoadingViewCardVH(View r1, ECHybridListContainer r2, o93.a r3) {
        super(r1);
        this.o = r2;
        this.p = r3;
    }

    public final void b4(Object r7, String r8, k.a r9) {
        Intrinsics.checkNotNullParameter(r8, "itemId");
        super.b4(r7, r8, r9);
        boolean r10 = r7 instanceof JSONObject;
        Object r11 = null;
        if (r10 == true) goto L5;
        Object r0 = null;
    L6:
        JSONObject r1 = (JSONObject) r0;
        if (r1 == null) goto L9;
        int r2 = r1.optInt("loading_view_type");
    L11:
        if (r2 == 1) goto L28;
        ECHybridListAdapter r3 = ((BaseViewHolder) this).g;
        if (r3 == null) goto L20;
        ECHybridListEngine r4 = r3.u;
        if (r4 == null) goto L20;
        BaseViewHolder r5 = r4.e("category_tab_section", "category_tab_section");
        if (r5 == null) goto L20;
        View r6 = ((RecyclerView.ViewHolder) r5).itemView;
    L21:
        if (r6 == null) goto L28;
        View r12 = this.o;
        if (r12 == null) goto L28;
        int r13 = r12.getHeight() - r6.getBottom();
        View r14 = this.p.d;
        ViewGroup.LayoutParams r15 = r14.getLayoutParams();
        if (q == false) goto L27;
        r15.width = this.o.getWidth();
    L27:
        r15.height = r13;
        r14.setLayoutParams(r15);
    L20:
        r6 = null;
    L28:
        if (r10 == true) goto L30;
        r7 = null;
    L30:
        JSONObject r16 = (JSONObject) r7;
        if (r16 == null) goto L34;
        r11 = r16.get("loading_status");
    L34:
        if (Intrinsics.areEqual(r11, 1) == false) goto L48;
        o93.a r17 = this.p;
        r17.d.setVisibility(0);
        LottieAnimationView r18 = r17.a;
        if (r18 == null) goto L38;
        r18.setVisibility(0);
    L38:
        View r19 = r17.b;
        if (r19 == null) goto L41;
        r19.setVisibility(8);
    L41:
        View r20 = r17.c;
        if (r20 == null) goto L44;
        r20.setVisibility(8);
    L44:
        LottieAnimationView r21 = r17.a;
        if (r21 == null) goto L70;
        r21.playAnimation();
        return;
    L70:
        return;
    L48:
        if (Intrinsics.areEqual(r11, 2) == false) goto L59;
        o93.a r22 = this.p;
        r22.d.setVisibility(0);
        View r23 = r22.c;
        if (r23 == null) goto L52;
        r23.setVisibility(0);
    L52:
        LottieAnimationView r24 = r22.a;
        if (r24 == null) goto L55;
        r24.setVisibility(8);
    L55:
        View r25 = r22.b;
        if (r25 == null) goto L72;
        r25.setVisibility(8);
        return;
    L72:
        return;
    L59:
        if (Intrinsics.areEqual(r11, 3) == false) goto L74;
        o93.a r26 = this.p;
        r26.d.setVisibility(0);
        View r27 = r26.b;
        if (r27 == null) goto L63;
        r27.setVisibility(0);
    L63:
        LottieAnimationView r28 = r26.a;
        if (r28 == null) goto L66;
        r28.setVisibility(8);
    L66:
        View r29 = r26.c;
        if (r29 == null) goto L75;
        r29.setVisibility(8);
        return;
    L75:
        return;
    L74:
        return;
    L9:
        r2 = 0;
        goto L11
    L5:
        r0 = r7;
        goto L6
    }
}
