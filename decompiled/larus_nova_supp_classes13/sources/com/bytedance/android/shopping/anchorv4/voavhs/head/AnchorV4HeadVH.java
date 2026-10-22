package com.bytedance.android.shopping.anchorv4.voavhs.head;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.anchorv3.detail.viewholder.AbsFullSpanVH;
import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.anchorv4.dto.components.TagsScrollBoxComponent;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.log.VisibleLogManager;
import com.bytedance.android.shopping.anchorv4.vm.AnchorV4VM;
import com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.ExtensionsKt;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.google.gson.internal.LinkedTreeMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/AnchorV4HeadVH;", "Lcom/bytedance/android/shopping/anchorv3/detail/viewholder/AbsFullSpanVH;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/AnchorV4HeadVO;", "Lcom/bytedance/android/shopping/anchorv4/log/d;", "Lcom/bytedance/android/shopping/anchorv4/vm/h;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/a;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4HeadVH extends AbsFullSpanVH<AnchorV4HeadVO> implements com.bytedance.android.shopping.anchorv4.log.d, com.bytedance.android.shopping.anchorv4.vm.h, com.bytedance.android.shopping.anchorv4.voavhs.base.design.a {
    public static final /* synthetic */ int s = 0;
    public AnchorV4HeadVO m;
    public final Lazy n;
    public final Lazy o;
    public final ViewGroup p;
    public final VisibleLogManager q;
    public final AnchorV4VM r;

    public final void onVisible() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.a
    public final Function0<Unit> p0(Action r1) {
        return null;
    }

    public final int M0() {
        return com.bytedance.android.shopping.extensions.b.b(60);
    }

    public final void onCreate() {
        this.r.watchPageStatusChange(this);
    }

    public final void onDestroy() {
        View r0 = ((RecyclerView.ViewHolder) this).itemView;
        if (r0 == null) goto L7;
        ((AnchorV4HeadView) r0).h();
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.anchorv4.voavhs.head.AnchorV4HeadView");
    }

    public final void onPause() {
        View r0 = ((RecyclerView.ViewHolder) this).itemView;
        if (r0 == null) goto L7;
        ((AnchorV4HeadView) r0).i();
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.anchorv4.voavhs.head.AnchorV4HeadView");
    }

    public final void onResume() {
        View r0 = ((RecyclerView.ViewHolder) this).itemView;
        if (r0 == null) goto L7;
        ((AnchorV4HeadView) r0).j();
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.anchorv4.voavhs.head.AnchorV4HeadView");
    }

    public final void onScan() {
        View r0 = ((RecyclerView.ViewHolder) this).itemView;
        if (r0 == null) goto L7;
        ExtensionsKt.b((ViewGroup) r0, this);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public final void onStart() {
        View r0 = ((RecyclerView.ViewHolder) this).itemView;
        if (r0 == null) goto L7;
        ((AnchorV4HeadView) r0).k();
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.anchorv4.voavhs.head.AnchorV4HeadView");
    }

    public final void onStop() {
        View r0 = ((RecyclerView.ViewHolder) this).itemView;
        if (r0 == null) goto L7;
        ((AnchorV4HeadView) r0).l();
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.anchorv4.voavhs.head.AnchorV4HeadView");
    }

    public final View t() {
        return ((RecyclerView.ViewHolder) this).itemView;
    }

    public final void S2(float r2) {
        View r0 = ((RecyclerView.ViewHolder) this).itemView;
        if (r0 == null) goto L7;
        ((AnchorV4HeadView) r0).m(r2);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.anchorv4.voavhs.head.AnchorV4HeadView");
    }

    public final void a2(boolean r2) {
        View r0 = ((RecyclerView.ViewHolder) this).itemView;
        if (r0 == null) goto L7;
        ((AnchorV4HeadView) r0).f(r2);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.anchorv4.voavhs.head.AnchorV4HeadView");
    }

    public final void a4(Object r11) {
        AnchorV4HeadVO r12 = (AnchorV4HeadVO) r11;
        Intrinsics.checkNotNullParameter(r12, "item");
        View r0 = ((RecyclerView.ViewHolder) this).itemView;
        if (r0 == null) goto L23;
        AnchorV4HeadView r1 = (AnchorV4HeadView) r0;
        CommonMeta r2 = this.r.commonMeta();
        if (r2 == null) goto L7;
        String r3 = r2.getProductId();
    L8:
        List<b> r4 = r12.extractHeadViewNodeGroupList(r3);
        TagsScrollBoxComponent r5 = r12.getFloatButtonElements();
        AnchorV4VM r6 = this.r;
        com.bytedance.android.shopping.anchorv4.vm.i r7 = r6.pathParams();
        l53.b r8 = this.r.getCollisionNegotiator();
        AnchorV4HeadMeta r9 = r12.getHeadMeta();
        if (r9 == null) goto L11;
        LinkedTreeMap<String, Object> r10 = r9.getTrackMeta();
    L12:
        AnchorV4HeadMeta r13 = r12.getHeadMeta();
        if (r13 == null) goto L15;
        HeadBusinessMeta r14 = r13.getBusinessMeta();
    L16:
        r1.g(r12, r4, r5, r6, r7, r8, r10, r14);
        Unit r15 = Unit.INSTANCE;
        this.m = r12;
        View r16 = ((RecyclerView.ViewHolder) this).itemView;
        if (r16 == null) goto L21;
        ExtensionsKt.e((ViewGroup) r16, this);
        this.q.b(this, r12, 0);
        this.r.registerRefreshDetailInfoListener(new AnchorV4HeadVH$listenDetailInfoChange$1(this));
        return;
    L21:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L15:
        r14 = null;
        goto L16
    L11:
        r10 = null;
        goto L12
    L7:
        r3 = null;
        goto L8
    L23:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.anchorv4.voavhs.head.AnchorV4HeadView");
    }

    public final void b2(boolean r2) {
        View r0 = ((RecyclerView.ViewHolder) this).itemView;
        if (r0 == null) goto L7;
        ((AnchorV4HeadView) r0).n(r2);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.anchorv4.voavhs.head.AnchorV4HeadView");
    }

    public static final void c4(AnchorV4HeadVH r10, List r11) {
        View r0 = ((RecyclerView.ViewHolder) r10).itemView;
        if (r0 == null) goto L15;
        AnchorV4HeadView r1 = (AnchorV4HeadView) r0;
        TagsScrollBoxComponent r4 = ((AnchorV4HeadVO) r10.getItem()).getFloatButtonElements();
        AnchorV4VM r5 = r10.r;
        com.bytedance.android.shopping.anchorv4.vm.i r6 = r5.pathParams();
        l53.b r7 = r10.r.getCollisionNegotiator();
        AnchorV4HeadMeta r2 = ((AnchorV4HeadVO) r10.getItem()).getHeadMeta();
        if (r2 == null) goto L7;
        LinkedTreeMap<String, Object> r8 = r2.getTrackMeta();
    L8:
        AnchorV4HeadMeta r12 = ((AnchorV4HeadVO) r10.getItem()).getHeadMeta();
        if (r12 == null) goto L11;
        HeadBusinessMeta r9 = r12.getBusinessMeta();
    L12:
        r1.g(null, r11, r4, r5, r6, r7, r8, r9);
        return;
    L11:
        r9 = null;
        goto L12
    L7:
        r8 = null;
        goto L8
    L15:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.anchorv4.voavhs.head.AnchorV4HeadView");
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.a
    public final void l0(Action r2, Object r3) {
        ((a) this.n.getValue()).l0(r2, r3);
    }

    public AnchorV4HeadVH(ViewGroup r3, VisibleLogManager r4, AnchorV4VM r5) {
        Intrinsics.checkNotNullParameter(r3, "viewGroup");
        Intrinsics.checkNotNullParameter(r4, "logManager");
        Intrinsics.checkNotNullParameter(r5, "anchorV4VM");
        super(new AnchorV4HeadView(r3.getContext()), false);
        this.p = r3;
        this.q = r4;
        this.r = r5;
        this.n = LazyKt.lazy(new AnchorV4HeadVH$actionHandler$2(this));
        this.o = LazyKt.lazy(new AnchorV4HeadVH$headerOutAbility$2(this));
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.a
    public final void O0(View r2, Action r3, Object r4) {
        Intrinsics.checkNotNullParameter(r2, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r3, "action");
        ((a) this.n.getValue()).O0(r2, r3, r4);
    }
}
