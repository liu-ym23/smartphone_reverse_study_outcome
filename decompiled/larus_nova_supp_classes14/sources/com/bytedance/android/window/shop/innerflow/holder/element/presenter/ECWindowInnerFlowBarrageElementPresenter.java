package com.bytedance.android.window.shop.innerflow.holder.element.presenter;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.android.ec.window.base.utils.playable.WindowPlayAbleType;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.android.window.shop.innerflow.holder.element.barrage.BarrageListAdapter;
import com.bytedance.android.window.shop.innerflow.holder.element.barrage.BarrageRecycleView;
import com.bytedance.android.window.shop.innerflow.widget.ControllerState;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECWindowInnerFlowBarrageElementPresenter extends d<wp3.a> implements tp.c {
    public static final /* synthetic */ int q = 0;
    public final Lazy g;
    public final Lazy h;
    public final BarrageListAdapter i;
    public final Lazy j;
    public int k;
    public wp3.a l;
    public tp.b m;
    public Disposable n;
    public final vp.c o;
    public final boolean p;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/window/shop/innerflow/holder/element/presenter/ECWindowInnerFlowBarrageElementPresenter$SpacesItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class SpacesItemDecoration extends RecyclerView.ItemDecoration {
        public final int a;
        public final int b;
        public final int c;
        public final int d;
        public final /* synthetic */ ECWindowInnerFlowBarrageElementPresenter e;

        public SpacesItemDecoration(ECWindowInnerFlowBarrageElementPresenter r1, int r2, int r3) {
            this.e = r1;
            this.a = r2;
            this.b = r3;
            this.c = 0;
            this.d = 0;
        }

        public final void getItemOffsets(Rect r2, View r3, RecyclerView r4, RecyclerView.State r5) {
            Intrinsics.checkNotNullParameter(r2, "outRect");
            Intrinsics.checkNotNullParameter(r3, "view");
            Intrinsics.checkNotNullParameter(r4, "parent");
            Intrinsics.checkNotNullParameter(r5, "state");
            r2.left = this.a;
            r2.right = this.c;
            r2.bottom = this.d;
            r2.top = this.b;
            RecyclerView.LayoutParams r6 = r3.getLayoutParams();
            if (r6 == null) goto L13;
            int r7 = r6.getViewLayoutPosition();
            if (r7 != 0) goto L7;
            r2.left = this.e.k;
            return;
        L7:
            if (r7 == 1) goto L9;
            r2.left = this.a;
            return;
        L9:
            r2.left = this.e.k + com.bytedance.android.shopping.extensions.b.b(60);
            return;
        L13:
            throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        }
    }

    public static final class a {
    }

    static {
    }

    public final boolean D3() {
        return true;
    }

    @Override // com.bytedance.android.window.shop.innerflow.holder.element.presenter.d
    public final void E() {
        this.l = null;
        BarrageListAdapter r0 = this.i;
        ((ArrayList) r0.a).clear();
        r0.notifyDataSetChanged();
    }

    public final BarrageRecycleView F() {
        return (BarrageRecycleView) this.j.getValue();
    }

    public final Rect r() {
        return null;
    }

    public final void G() {
        wp3.a r0 = this.l;
        if (r0 == null) goto L9;
        RecyclerView.Adapter r1 = F().getAdapter();
        if (r1 == null) goto L8;
        BarrageListAdapter r2 = (BarrageListAdapter) r1;
        Intrinsics.checkNotNullParameter(r0, "vo");
        ((ArrayList) r2.a).clear();
        r2.notifyDataSetChanged();
        List<wp3.a.C0181a> r3 = r2.a;
        ArrayList r4 = (ArrayList) r3;
        r4.addAll(r0.a);
        r2.notifyItemRangeInserted(0, r0.a.size());
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.window.shop.innerflow.holder.element.barrage.BarrageListAdapter");
    }

    public final void I() {
        Disposable r0 = this.n;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.n = com.bytedance.android.ec.core.rxjava.a.a(0, ECDraweeView.ROUND, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.window.shop.innerflow.holder.element.presenter.a(this), b.a, c.a);
    }

    public final void R() {
        if (((ControllerState) ((QLiveData) this.h.getValue()).a()) != ControllerState.DISABLED) goto L5;
        return;
    L5:
        G();
        F().setVisibility(0);
        I();
    }

    public final boolean isPlaying() {
        Disposable r0 = this.n;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.isDisposed() == true) goto L9;
        return true;
    L9:
        return false;
    }

    public final void v() {
        Disposable r0 = this.n;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.n = null;
    }

    public final void B() {
        F().setVisibility(8);
        Disposable r0 = this.n;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.n = null;
    }

    public final boolean g0() {
        I();
        return true;
    }

    public final void pausePlay() {
        v();
        M();
    }

    public final boolean resumePlay() {
        g0();
        U0();
        return true;
    }

    public final void startPlay() {
        R();
        x();
    }

    public final void stopPlay() {
        B();
        z();
    }

    public final void M() {
        tp.c.a.a(this);
    }

    public final WindowPlayAbleType P() {
        return WindowPlayAbleType.OTHER;
    }

    public final void U0() {
        tp.c.a.b(this);
    }

    public final tp.b m() {
        return this.m;
    }

    public final void x() {
        tp.c.a.c(this);
    }

    public final void z() {
        tp.c.a.d(this);
    }

    @Override // com.bytedance.android.window.shop.innerflow.holder.element.presenter.d
    public final void D(wp3.a r5) {
        wp3.a r6 = r5;
        if (F().getAdapter() != null) goto L5;
        F().setAdapter(this.i);
        F().setLayoutManager(new StaggeredGridLayoutManager(2, 0));
        SpacesItemDecoration r0 = new SpacesItemDecoration(this, com.bytedance.android.shopping.extensions.b.b(42), com.bytedance.android.shopping.extensions.b.b(11));
        F().addItemDecoration(r0);
    L8:
        this.l = r6;
        Resources r7 = u().c().getResources();
        this.k = WindowDisplayMetricsOverride.apply(r7, r7.getDisplayMetrics()).widthPixels;
        this.o.a = this;
        G();
        return;
    L5:
        RecyclerView.Adapter r1 = F().getAdapter();
        if (r1 == null) goto L11;
        BarrageListAdapter r2 = (BarrageListAdapter) r1;
        ((ArrayList) r2.a).clear();
        r2.notifyDataSetChanged();
        goto L8
    L11:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.window.shop.innerflow.holder.element.barrage.BarrageListAdapter");
    }

    public final List<tp.c> L(Rect r2) {
        Intrinsics.checkNotNullParameter(r2, "visibleArea");
        if (this.p == false) goto L6;
        return CollectionsKt.listOf(this);
    L6:
        return CollectionsKt.emptyList();
    }

    public final void o2(tp.b r1) {
        this.m = r1;
    }

    public ECWindowInnerFlowBarrageElementPresenter(vp.c r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "barrageElementPlayerProxy");
        super(yp3.a.a);
        this.o = r2;
        this.p = r3;
        this.g = LazyKt.lazy(new ECWindowInnerFlowBarrageElementPresenter$viewModel$2(this));
        this.h = LazyKt.lazy(new ECWindowInnerFlowBarrageElementPresenter$barrageState$2(this));
        this.i = new BarrageListAdapter();
        this.j = LazyKt.lazy(new ECWindowInnerFlowBarrageElementPresenter$recyclerView$2(this));
    }
}
