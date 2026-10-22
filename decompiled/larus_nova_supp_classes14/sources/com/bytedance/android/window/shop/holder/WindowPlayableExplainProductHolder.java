package com.bytedance.android.window.shop.holder;

import android.content.Context;
import android.graphics.Rect;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.window.base.utils.playable.WindowPlayAbleType;
import com.bytedance.android.window.shop.holder.presenter.ECWindowPlayableProductOptVideoElementPresenter;
import com.bytedance.android.window.shop.holder.presenter.WindowExplainBackContentElementPresenter;
import com.bytedance.android.window.shop.product.presenter.others.ECWindowProductCardTagInfoElementPresenter;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import com.bytedance.android.window.shop.repository.tab.entity.k;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/window/shop/holder/WindowPlayableExplainProductHolder;", "Ltp/c;", "Lcom/bytedance/android/window/shop/holder/ShopWindowGenericHolder;", "Lcom/bytedance/android/window/shop/repository/tab/entity/k;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowPlayableExplainProductHolder extends ShopWindowGenericHolder<k> implements tp.c {
    public final ECWindowPlayableProductOptVideoElementPresenter v;
    public final WindowLayoutType w;
    public final vp.c x;

    public final void B() {
        this.x.B();
    }

    public final boolean D3() {
        return this.x.D3();
    }

    public final void R() {
        this.x.R();
    }

    public final boolean g0() {
        return this.x.g0();
    }

    public final boolean isPlaying() {
        return this.x.isPlaying();
    }

    public final tp.b m() {
        return this.x.m();
    }

    public final void o2(tp.b r2) {
        this.x.o2(r2);
    }

    public final Rect r() {
        this.x.getClass();
        return null;
    }

    public final void startPlay() {
        this.x.startPlay();
    }

    public final void stopPlay() {
        this.x.stopPlay();
    }

    public final void v() {
        this.x.v();
    }

    public final void M() {
        vp.c r0 = this.x;
        r0.getClass();
        tp.c.a.a(r0);
    }

    public final WindowPlayAbleType P() {
        this.x.getClass();
        return WindowPlayAbleType.OTHER;
    }

    public final void U0() {
        vp.c r0 = this.x;
        r0.getClass();
        tp.c.a.b(r0);
    }

    public final void pausePlay() {
        vp.c r0 = this.x;
        r0.getClass();
        tp.c.a.e(r0);
    }

    public final boolean resumePlay() {
        vp.c r0 = this.x;
        r0.getClass();
        return tp.c.a.f(r0);
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowItemHolder
    public final boolean s4() {
        WindowLayoutType r0 = this.w;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isSingleColumn() != true) goto L7;
        return true;
    }

    public final void x() {
        vp.c r0 = this.x;
        r0.getClass();
        tp.c.a.c(r0);
    }

    public final void z() {
        vp.c r0 = this.x;
        r0.getClass();
        tp.c.a.d(r0);
    }

    public final List<tp.c> L(Rect r2) {
        Intrinsics.checkNotNullParameter(r2, "visibleArea");
        return this.v.L(r2);
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowItemHolder
    public final Rect r4(int r7) {
        StaggeredGridLayoutManager.LayoutParams r8 = ((RecyclerView.ViewHolder) this).itemView.getLayoutParams();
        if (r8 == null) goto L10;
        if ((r8.getSpanIndex() % 2) != 1) goto L8;
        return new Rect(d.a(Double.valueOf(4.5d)), 0, d.a(8), d.a(9));
    L8:
        return new Rect(d.a(8), 0, d.a(Double.valueOf(4.5d)), d.a(9));
    L10:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowGenericHolder
    public final QIPresenter u4(Fragment r5) {
        Intrinsics.checkNotNullParameter(r5, "fragment");
        com.bytedance.android.ec.window.base.utils.quick.b r0 = new com.bytedance.android.ec.window.base.utils.quick.b();
        r0.b(new ECWindowProductCardTagInfoElementPresenter(r5), WindowPlayableExplainProductHolder$generatePresenter$1.INSTANCE);
        r0.b(this.v, WindowPlayableExplainProductHolder$generatePresenter$2.INSTANCE);
        r0.a(new WindowExplainBackContentElementPresenter(((RecyclerView.ViewHolder) this).itemView, r5, this.w));
        return r0;
    }

    public WindowPlayableExplainProductHolder(Fragment r7, WindowLayoutType r8) {
        vp.c r0 = new vp.c();
        Intrinsics.checkNotNullParameter(r7, "fragment");
        Intrinsics.checkNotNullParameter(r0, "playableProxy");
        ShoppingAsyncInflater.a r1 = ShoppingAsyncInflater.e;
        Context r2 = r7.requireContext();
        r1.getClass();
        ShoppingAsyncInflater r3 = ShoppingAsyncInflater.a.a(r2);
        boolean r4 = true;
        if (r8 != null) goto L5;
    L7:
        int r5 = 2131561017;
    L8:
        super(r7, com.bytedance.android.ec.opt.asyncInflate.c.a(r3, r5, null, 4));
        this.w = r8;
        this.x = r0;
        if (r8 != null) goto L11;
    L13:
        r4 = false;
    L14:
        this.v = new ECWindowPlayableProductOptVideoElementPresenter(r0, r4);
        return;
    L11:
        if (r8.isSingleColumn() != true) goto L13;
    L5:
        if (r8.isSingleColumn() != true) goto L7;
        r5 = 2131561018;
        goto L8
    }
}
