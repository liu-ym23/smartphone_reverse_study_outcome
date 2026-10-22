package com.bytedance.android.window.shop.innerflow.holder.element.presenter;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.ec.sdk.helper.p;
import com.bytedance.android.ec.window.base.utils.playable.WindowPlayAbleType;
import com.bytedance.android.window.shop.innerflow.ECWindowInnerFlowViewModel;
import com.bytedance.android.window.shop.innerflow.holder.element.commentlist.CommentListAdapter;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECWindowInnerFlowHotCommentElementPresenter extends d<wp3.b> implements tp.c, View.OnClickListener {
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final CommentListAdapter j;
    public wp3.b k;
    public final Lazy l;
    public tp.b m;
    public Disposable n;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ ECWindowInnerFlowHotCommentElementPresenter a;

        public a(ECWindowInnerFlowHotCommentElementPresenter r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Long r4 = (Long) r3;
            ECWindowInnerFlowHotCommentElementPresenter r5 = this.a;
            r5.F().smoothScrollBy(0, r5.F().getMeasuredHeight());
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public static final class c implements Action {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void run() {
        }
    }

    public final boolean D3() {
        return true;
    }

    public final RecyclerView F() {
        return (RecyclerView) this.g.getValue();
    }

    public final Rect r() {
        return null;
    }

    public final void B() {
        Disposable r0 = this.n;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.n = null;
    }

    @Override // com.bytedance.android.window.shop.innerflow.holder.element.presenter.d
    public final void E() {
        Disposable r0 = this.n;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.k = null;
        ((TextView) this.h.getValue()).setText("");
        CommentListAdapter r1 = this.j;
        r1.getClass();
        r1.a = CollectionsKt.emptyList();
        r1.notifyDataSetChanged();
    }

    public final void R() {
        Disposable r0 = this.n;
        if (r0 == null) goto L8;
        if ((!r0.isDisposed()) != true) goto L8;
        return;
    L8:
        if (this.j.getItemCount() > 1) goto L10;
        return;
    L10:
        this.n = com.bytedance.android.ec.core.rxjava.a.b(2, 2, TimeUnit.SECONDS, Schedulers.computation()).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this), b.a, c.a);
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

    public final boolean g0() {
        tp.c.a.g(this);
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

    public final void v() {
        tp.c.a.h(this);
    }

    public final void x() {
        tp.c.a.c(this);
    }

    public final void z() {
        tp.c.a.d(this);
    }

    public ECWindowInnerFlowHotCommentElementPresenter(vp.c r2) {
        Intrinsics.checkNotNullParameter(r2, "hotElementPlayerProxy");
        super(yp3.b.a);
        r2.a = this;
        this.g = LazyKt.lazy(new ECWindowInnerFlowHotCommentElementPresenter$recyclerView$2(this));
        this.h = LazyKt.lazy(new ECWindowInnerFlowHotCommentElementPresenter$tvHotCommentCount$2(this));
        this.i = LazyKt.lazy(new ECWindowInnerFlowHotCommentElementPresenter$btGoToCommentPage$2(this));
        this.j = new CommentListAdapter();
        this.l = LazyKt.lazy(new ECWindowInnerFlowHotCommentElementPresenter$viewModel$2(this));
    }

    @Override // com.bytedance.android.window.shop.innerflow.holder.element.presenter.d
    public final void D(wp3.b r6) {
        wp3.b r7 = r6;
        this.k = r7;
        if (F().getAdapter() != null) goto L5;
        ECWindowInnerFlowViewModel r0 = ECQuickUtilKt.c(u(), ECWindowInnerFlowViewModel.class);
        F().setRecycledViewPool(r0.getFlyWeight().c);
        F().setAdapter(this.j);
        RecyclerView r1 = F();
        LinearLayoutManager r2 = new LinearLayoutManager(y().getContext(), 1, false);
        r2.setItemPrefetchEnabled(true);
        r2.setInitialPrefetchItemCount(2);
        Unit r3 = Unit.INSTANCE;
        r1.setLayoutManager(r2);
        new PagerSnapHelper().attachToRecyclerView(F());
        ((TextView) this.i.getValue()).setOnClickListener(this);
    L8:
        if (r7 == null) goto L18;
        ((TextView) this.h.getValue()).setText(r7.b);
        RecyclerView.Adapter r4 = F().getAdapter();
        if ((r4 instanceof CommentListAdapter) == true) goto L12;
        r4 = null;
    L12:
        CommentListAdapter r5 = (CommentListAdapter) r4;
        if (r5 == null) goto L19;
        Intrinsics.checkNotNullParameter(r7, "vo");
        r5.a = r7.a;
        r5.notifyDataSetChanged();
        return;
    L19:
        return;
    L18:
        return;
    L5:
        RecyclerView.Adapter r8 = F().getAdapter();
        if (r8 == null) goto L17;
        CommentListAdapter r9 = (CommentListAdapter) r8;
        r9.a = CollectionsKt.emptyList();
        r9.notifyDataSetChanged();
        goto L8
    L17:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.window.shop.innerflow.holder.element.commentlist.CommentListAdapter");
    }

    public final List<tp.c> L(Rect r2) {
        Intrinsics.checkNotNullParameter(r2, "visibleArea");
        return CollectionsKt.listOf(this);
    }

    public final void o2(tp.b r1) {
        this.m = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        Intrinsics.checkNotNullParameter(r6, "v");
        int r7 = rp.a.a;
        if (rp.a.a(((TextView) this.i.getValue()).getId()) == false) goto L5;
        return;
    L5:
        int r8 = com.bytedance.android.window.shop.innerflow.a.a;
        ECWindowInnerFlowViewModel r9 = (ECWindowInnerFlowViewModel) this.l.getValue();
        Pair[] r0 = new Pair[1];
        fo.b r1 = this.e;
        Context r2 = null;
        if (r1 == null) goto L8;
        String r3 = (String) r1.a(vp3.b.d);
    L9:
        if (r3 != null) goto L11;
        r3 = "";
    L11:
        r0[0] = TuplesKt.to("product_id", r3);
        com.bytedance.android.window.shop.innerflow.a.d(r9, "comment", r0);
        wp3.b r10 = this.k;
        if (r10 == null) goto L21;
        p r4 = p.a;
        QContext r5 = u();
        Context r11 = l0.c(r5.c());
        if ((r11 instanceof FragmentActivity) == false) goto L17;
        r2 = r11;
    L17:
        if (r2 != null) goto L19;
        r2 = r5.a();
    L19:
        r4.openSchema(r2, r10.c);
        return;
    L21:
        return;
    L8:
        r3 = null;
        goto L9
    }
}
