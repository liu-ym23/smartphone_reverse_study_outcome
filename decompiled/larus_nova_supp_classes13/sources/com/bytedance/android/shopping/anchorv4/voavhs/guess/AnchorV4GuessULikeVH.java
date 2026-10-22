package com.bytedance.android.shopping.anchorv4.voavhs.guess;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.anchorv3.detail.viewholder.AbsFullSpanVH;
import com.bytedance.android.shopping.anchorv4.log.GULShowManager;
import com.bytedance.android.shopping.anchorv4.log.VisibleLogManager;
import com.bytedance.android.shopping.anchorv4.vm.AnchorV4VM;
import com.bytedance.android.shopping.anchorv4.widgets.AnchorV4GuessULikeSDKView;
import com.bytedance.android.shopping.anchorv4.widgets.ECCoordinatorRecyclerView;
import com.bytedance.android.shopping.api.mall.feed.InitGYLComponentBehavior;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/guess/AnchorV4GuessULikeVH;", "Lcom/bytedance/android/shopping/anchorv3/detail/viewholder/AbsFullSpanVH;", "Lj63/a;", "Lcom/bytedance/android/shopping/anchorv4/log/d;", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4GuessULikeVH extends AbsFullSpanVH<j63.a> implements com.bytedance.android.shopping.anchorv4.log.d {
    public boolean m;
    public boolean n;
    public boolean o;
    public AnchorV4GuessULikeSDKView p;
    public final ViewGroup q;
    public final VisibleLogManager r;
    public final Context s;
    public final AnchorV4VM t;
    public com.bytedance.android.shopping.api.mall.feed.d u;

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

    public final void c4() {
        if (this.t.pageStatus().b == false) goto L7;
        com.bytedance.android.shopping.api.mall.feed.d r0 = this.u;
        if (r0 == null) goto L11;
        r0.f(InitGYLComponentBehavior.PRODUCT_DETAIL_CLICK_RECOMMEND);
        return;
    L11:
        return;
    L7:
        com.bytedance.android.shopping.api.mall.feed.d r1 = this.u;
        if (r1 == null) goto L13;
        r1.f(InitGYLComponentBehavior.PRODUCT_DETAIL_SCROLL_TO_GYL);
        return;
    }

    public final View t() {
        return ((RecyclerView.ViewHolder) this).itemView;
    }

    public final void a4(Object r8) {
        j63.a r9 = (j63.a) r8;
        Intrinsics.checkNotNullParameter(r9, "item");
        if (this.n == true) goto L45;
        View r0 = ((RecyclerView.ViewHolder) this).itemView;
        if (r0 == null) goto L44;
        this.p = (AnchorV4GuessULikeSDKView) r0;
        ViewParent r2 = null;
        if (this.u != null) goto L9;
        GULShowManager.a r1 = GULShowManager.i;
        Context r3 = this.s;
        com.bytedance.android.shopping.anchorv4.log.a r4 = new com.bytedance.android.shopping.anchorv4.log.a(this.t);
        r1.getClass();
        this.u = GULShowManager.a.a(r3, r4, null, false);
    L9:
        com.bytedance.android.shopping.api.mall.feed.d r5 = this.u;
        if (r5 == null) goto L13;
        r5.setFeedStateListener(new d(this));
    L13:
        if (this.t.pageStatus().x == false) goto L17;
        AnchorV4GuessULikeSDKView r6 = this.p;
        if (r6 == null) goto L18;
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        r7.height = -1;
        r6.setLayoutParams(r7);
    L18:
        com.bytedance.android.shopping.api.mall.feed.d r10 = this.u;
        if (r10 == null) goto L45;
        Object r11 = this.q;
        if (r11 == null) goto L42;
        ECCoordinatorRecyclerView r12 = (ECCoordinatorRecyclerView) r11;
        r12.setSecondaryScrollView(r10.getFeedView());
        r12.setSecondaryViewContainer(r10.getView());
        AnchorV4GuessULikeSDKView r13 = this.p;
        if (r13 != null) goto L25;
    L40:
        this.n = true;
        goto L45
    L25:
        if (r13.a != null) goto L40;
        RecyclerView r14 = r10.getFeedView();
        if (r14 == null) goto L29;
        r14.setOverScrollMode(2);
    L29:
        View r15 = r10.getView();
        if (r15 == null) goto L39;
        ViewParent r16 = r15.getParent();
        if (r16 != null) goto L34;
    L38:
        r13.addView(r15);
        goto L39
    L34:
        if ((r16 instanceof ViewGroup) == false) goto L36;
        r2 = r16;
    L36:
        if (r2 == null) goto L38;
        ((ViewGroup) r2).removeView(r15);
    L39:
        r13.a = r10;
        r13.b = r10.getFeedView();
        goto L40
    L42:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.anchorv4.widgets.ECCoordinatorRecyclerView");
    L17:
        c4();
        goto L18
    L44:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.anchorv4.widgets.AnchorV4GuessULikeSDKView");
    L45:
        this.r.b(this, r9, 0);
    }

    public AnchorV4GuessULikeVH(ViewGroup r5, VisibleLogManager r6, FragmentActivity r7, AnchorV4VM r8, com.bytedance.android.shopping.api.mall.feed.d r9) {
        Intrinsics.checkNotNullParameter(r5, "theView");
        Intrinsics.checkNotNullParameter(r6, "logManager");
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "anchorV4VM");
        super(new AnchorV4GuessULikeSDKView(r7, null, 6, 0), false);
        this.q = r5;
        this.r = r6;
        this.s = r7;
        this.t = r8;
        this.u = r9;
    }
}
