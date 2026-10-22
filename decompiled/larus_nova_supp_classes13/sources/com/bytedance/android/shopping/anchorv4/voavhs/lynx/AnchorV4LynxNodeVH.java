package com.bytedance.android.shopping.anchorv4.voavhs.lynx;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.shopping.anchorv3.detail.viewholder.AbsFullSpanVH;
import com.bytedance.android.shopping.anchorv4.dto.ConfigModel;
import com.bytedance.android.shopping.anchorv4.dto.business.ComponentDTO;
import com.bytedance.android.shopping.anchorv4.dto.business.VO;
import com.bytedance.android.shopping.anchorv4.voavhs.ComponentIDs;
import com.bytedance.android.shopping.utils.LargeFontModeUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import ti.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/lynx/AnchorV4LynxNodeVH;", "Lcom/bytedance/android/shopping/anchorv3/detail/viewholder/AbsFullSpanVH;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/lynx/a;", "Lcom/bytedance/android/shopping/anchorv4/log/d;", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4LynxNodeVH extends AbsFullSpanVH<com.bytedance.android.shopping.anchorv4.voavhs.lynx.a> implements com.bytedance.android.shopping.anchorv4.log.d {
    public static final /* synthetic */ int o = 0;
    public final ViewGroup m;
    public final e n;

    public static final class a {
    }

    static {
    }

    public final void onScan() {
    }

    public final void onVisible() {
    }

    public final int M0() {
        return com.bytedance.android.shopping.extensions.b.b(60);
    }

    public final void onDestroy() {
        View r0 = ((RecyclerView.ViewHolder) this).itemView;
        if ((r0 instanceof c) == true) goto L5;
        r0 = null;
    L5:
        c r1 = (c) r0;
        if (r1 == null) goto L11;
        l r2 = r1.a;
        if (r2 == null) goto L12;
        r2.release();
        return;
    L12:
        return;
    }

    public final View t() {
        return ((RecyclerView.ViewHolder) this).itemView;
    }

    public final void a4(Object r7) {
        com.bytedance.android.shopping.anchorv4.voavhs.lynx.a r8 = (com.bytedance.android.shopping.anchorv4.voavhs.lynx.a) r7;
        Intrinsics.checkNotNullParameter(r8, "item");
        View r0 = ((RecyclerView.ViewHolder) this).itemView;
        if (r0 == null) goto L55;
        ((c) r0).a(r8);
        Unit r1 = Unit.INSTANCE;
        ComponentDTO r2 = r8.f;
        ViewGroup.LayoutParams r3 = null;
        if (r2 == null) goto L7;
        String r4 = r2.getComponentId();
    L9:
        if (Intrinsics.areEqual(r4, ComponentIDs.SHOP_COUPONS.getId()) == false) goto L11;
    L21:
        ViewGroup.LayoutParams r5 = ((RecyclerView.ViewHolder) this).itemView.getLayoutParams();
        if ((r5 instanceof ViewGroup.MarginLayoutParams) == false) goto L25;
        r3 = r5;
    L25:
        ViewGroup.MarginLayoutParams r6 = (ViewGroup.MarginLayoutParams) r3;
        if (r6 == null) goto L28;
        r6.topMargin = -com.bytedance.android.shopping.extensions.b.b(8);
        r6.bottomMargin = com.bytedance.android.shopping.extensions.b.b(12);
    L29:
        ComponentDTO r9 = r8.f;
        if (r9 == null) goto L52;
        VO r10 = r9.getVo();
        if (r10 == null) goto L52;
        ConfigModel r11 = r10.getConfig();
        if (r11 == null) goto L52;
        if (r11.getClientScale() != true) goto L52;
        ComponentDTO r12 = r8.f;
        if (r12 == null) goto L46;
        VO r13 = r12.getVo();
        if (r13 == null) goto L46;
        ConfigModel r14 = r13.getConfig();
        if (r14 == null) goto L46;
        if (r14.getFontScale() != true) goto L46;
        float r15 = LargeFontModeUtil.a();
    L47:
        View r16 = ((RecyclerView.ViewHolder) this).itemView;
        float r17 = this.n.T();
        Intrinsics.checkNotNullParameter(r16, "$this$resizeForLargeMode");
        ViewGroup.LayoutParams r18 = r16.getLayoutParams();
        if (r15 <= 0.0f) goto L50;
        int r19 = com.bytedance.android.ec.hybrid.list.util.c.a;
        int r20 = (int) (com.bytedance.android.ec.hybrid.list.util.c.d(Float.valueOf(r17)) / r15);
    L51:
        r18.width = r20;
        r16.setLayoutParams(r18);
        float r21 = (k1.m(r16.getContext()) / r17) * r15;
        r16.setPivotX(0.0f);
        r16.setPivotY(0.0f);
        r16.setScaleX(r21);
        r16.setScaleY(r21);
        goto L52
    L50:
        int r22 = com.bytedance.android.ec.hybrid.list.util.c.a;
        r20 = com.bytedance.android.ec.hybrid.list.util.c.d(Float.valueOf(r17));
    L46:
        r15 = 1.0f;
    L52:
        this.n.b(this, r8);
        this.n.u(new AnchorV4LynxNodeVH$listenDataChange$1(this));
        return;
    L28:
        View r23 = ((RecyclerView.ViewHolder) this).itemView;
        ViewGroup.MarginLayoutParams r24 = new ViewGroup.MarginLayoutParams(-1, -2);
        r24.topMargin = -com.bytedance.android.shopping.extensions.b.b(8);
        r24.bottomMargin = com.bytedance.android.shopping.extensions.b.b(12);
        r23.setLayoutParams(r24);
        goto L29
    L11:
        if (Intrinsics.areEqual(r4, ComponentIDs.SHOP_CONFIGURED_GOODS.getId()) == true) goto L21;
        ViewGroup.LayoutParams r25 = ((RecyclerView.ViewHolder) this).itemView.getLayoutParams();
        if ((r25 instanceof ViewGroup.MarginLayoutParams) == false) goto L17;
        r3 = r25;
    L17:
        ViewGroup.MarginLayoutParams r26 = (ViewGroup.MarginLayoutParams) r3;
        if (r26 == null) goto L20;
        r26.topMargin = com.bytedance.android.shopping.extensions.b.b(0);
        r26.bottomMargin = com.bytedance.android.shopping.extensions.b.b(0);
        goto L29
    L20:
        View r27 = ((RecyclerView.ViewHolder) this).itemView;
        ViewGroup.MarginLayoutParams r28 = new ViewGroup.MarginLayoutParams(-1, -2);
        r28.topMargin = com.bytedance.android.shopping.extensions.b.b(0);
        r28.bottomMargin = com.bytedance.android.shopping.extensions.b.b(0);
        r27.setLayoutParams(r28);
        goto L29
    L7:
        r4 = null;
        goto L9
    L55:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.anchorv4.voavhs.lynx.AnchorV4LynxNodeView");
    }

    public AnchorV4LynxNodeVH(ViewGroup r3, e r4) {
        Intrinsics.checkNotNullParameter(r3, "viewGroup");
        Intrinsics.checkNotNullParameter(r4, "depend");
        super(new c(r3.getContext(), r4), true);
        this.m = r3;
        this.n = r4;
    }
}
