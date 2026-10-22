package com.bytedance.android.window.shop.holder;

import android.graphics.Rect;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.android.ec.core.widget.RoundedFrameLayout;
import com.bytedance.android.ec.hybrid.card.api.ECLynxCardErrorType;
import com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle;
import com.bytedance.android.ec.hybrid.card.util.k;
import com.bytedance.android.ec.window.base.product.lynxcard.ECLynxCardEvent;
import com.bytedance.android.window.shop.holder.presenter.HeadAnimationPresenter;
import com.bytedance.android.window.shop.product.presenter.lynxCard.ECLynxCardPresenter;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import com.bytedance.android.window.shop.repository.tab.entity.f;
import com.bytedance.android.window.shop.repository.tab.entity.v;
import com.ss.android.ugc.aweme.kiwi.presenter.QGroupPresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/window/shop/holder/WindowLynxHolder;", "Lcom/bytedance/android/window/shop/holder/ShopWindowGenericHolder;", "Lcom/bytedance/android/window/shop/repository/tab/entity/v;", "Lcom/bytedance/android/ec/hybrid/card/api/IECLynxCardLifeCycle;", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowLynxHolder extends ShopWindowGenericHolder<v> implements IECLynxCardLifeCycle {
    public final Function2<v, ECLynxCardEvent, Unit> A;
    public final boolean B;
    public float v;
    public WindowLayoutType w;
    public v x;
    public final Lazy y;
    public final Fragment z;

    public static final class a {
    }

    static {
    }

    public final void createViewDuration(long r1) {
    }

    public final void onCreateKitViewEnd(long r1) {
    }

    public final void onDestroy() {
    }

    public final void onFirstScreen() {
    }

    public final void onLoadStart() {
    }

    public final void onLoadSuccess() {
    }

    public final void onPreCreateView(boolean r1) {
    }

    public final void onRealSuccess() {
    }

    public final void onReceivedError(com.bytedance.lynx.service.model.b r1) {
    }

    public final void onRuntimeReady() {
    }

    public final void onTimingSetup(Map<String, ? extends Object> r1) {
    }

    public final void onTimingSetupPref(k r1) {
    }

    public final void onTimingUpdatePref(k r1) {
    }

    public final void onTransDataTime(long r1, long r3) {
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowGenericHolder
    public final boolean v4() {
        return false;
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowItemHolder
    public final boolean s4() {
        v r0 = this.x;
        if (r0 == null) goto L7;
        v.b r1 = r0.k;
        if (r1 == null) goto L7;
        Boolean r2 = r1.b();
    L9:
        if (Intrinsics.areEqual(r2, Boolean.FALSE) == true) goto L11;
        WindowLayoutType r3 = this.w;
        if (r3 != null) goto L17;
    L19:
        return false;
    L17:
        if (r3.isSingleColumn() != true) goto L19;
        return true;
    L11:
        if (this.v <= 0.5f) goto L20;
        return true;
    L20:
        return false;
    L7:
        r2 = null;
        goto L9
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowGenericHolder, com.bytedance.android.window.shop.holder.ShopWindowItemHolder
    public final void q4(f r2) {
        v r3 = (v) r2;
        Intrinsics.checkNotNullParameter(r3, "vo");
        v.b r0 = r3.k;
        if (r0 == null) goto L5;
        this.v = r0.d();
    L5:
        this.x = r3;
        super.q4(r3);
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowItemHolder
    public final Rect r4(int r10) {
        v r11 = this.x;
        if (r11 == null) goto L10;
        v.b r12 = r11.k;
        if (r12 == null) goto L10;
        v.c r13 = r12.a();
        if (r13 == null) goto L10;
        return new Rect(d.a(Integer.valueOf(r13.b())), d.a(Integer.valueOf(r13.d())), d.a(Integer.valueOf(r13.c())), d.a(Integer.valueOf(r13.a())));
    L10:
        StaggeredGridLayoutManager.LayoutParams r14 = ((RecyclerView.ViewHolder) this).itemView.getLayoutParams();
        if (r14 == null) goto L40;
        int r15 = r14.getSpanIndex();
        v r0 = this.x;
        if (r0 == null) goto L17;
        v.b r1 = r0.k;
        if (r1 == null) goto L17;
        Boolean r2 = r1.b();
    L19:
        if ((!Intrinsics.areEqual(r2, Boolean.TRUE)) == true) goto L21;
        WindowLayoutType r3 = this.w;
        if (r3 == null) goto L38;
        if (r3.isDoubleColumn() != true) goto L38;
        if ((r15 % 2) != 1) goto L36;
        return new Rect(d.a(Double.valueOf(4.5d)), 0, d.a(12), d.a(9));
    L36:
        return new Rect(d.a(12), 0, d.a(Double.valueOf(4.5d)), d.a(9));
    L38:
        return new Rect(d.a(12), 0, d.a(12), d.a(8));
    L21:
        if (this.v <= 0.5f) goto L24;
        return new Rect(d.a(12), d.a(8), d.a(12), d.a(8));
    L24:
        if ((r15 % 2) != 1) goto L27;
        return new Rect(d.a(Double.valueOf(4.5d)), 0, d.a(12), d.a(9));
    L27:
        return new Rect(d.a(12), 0, d.a(Double.valueOf(4.5d)), d.a(9));
    L17:
        r2 = null;
        goto L19
    L40:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowGenericHolder
    public final QIPresenter u4(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        QGroupPresenter r3 = new QGroupPresenter();
        r3.a((ECLynxCardPresenter) this.y.getValue());
        if (this.B == false) goto L5;
        r3.a(new HeadAnimationPresenter());
    L5:
        return r3;
    }

    public final void useCache(@IECLynxCardLifeCycle.ECLynxCardCacheType String r2) {
        Intrinsics.checkNotNullParameter(r2, "cache");
        Intrinsics.checkNotNullParameter(r2, "cache");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WindowLynxHolder(Fragment r3, Function2<? super v, ? super ECLynxCardEvent, Unit> r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "fragment");
        Intrinsics.checkNotNullParameter(r4, "callback");
        RoundedFrameLayout r0 = new RoundedFrameLayout(r3.getContext());
        r0.setId(2131370930);
        r0.setMinimumHeight(5);
        Unit r1 = Unit.INSTANCE;
        super(r3, r0);
        this.z = r3;
        this.A = r4;
        this.B = r5;
        this.v = 1.0f;
        this.w = WindowLayoutType.DOUBLECOLUMN;
        this.y = LazyKt.lazy(new WindowLynxHolder$lynxCardPresenter$2(this));
    }

    public final void onLoadFailed(ECLynxCardErrorType r1, Integer r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "type");
        Intrinsics.checkNotNullParameter(r1, "type");
    }
}
