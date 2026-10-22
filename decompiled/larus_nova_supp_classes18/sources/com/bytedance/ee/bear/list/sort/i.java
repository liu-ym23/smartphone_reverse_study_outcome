package com.bytedance.ee.bear.list.sort;

import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.facade.common.LifeCycleFragment;
import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.larksuite.framework.mvp.BasePresenter;
import com.larksuite.framework.mvp.IView;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import zd5.o;
import zd5.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i extends BasePresenter<zd5.g, b, b.a> {
    public final LifeCycleFragment a;
    public final com.bytedance.ee.bear.content.common.morepanel.a.a b;
    public SortAndFilterViewModel c;
    public final FolderSortStrategy d;
    public Disposable e;
    public final ce5.a f;

    public class a implements b.a {
        public final /* synthetic */ i a;

        @Override // com.bytedance.ee.bear.list.sort.b.a
        public final void onClickClose() {
            StringBuilder r0 = new StringBuilder("onClickClose(): ");
            if (this.a.b == null) goto L5;
            boolean r1 = true;
        L6:
            r0.append(r1);
            tt5.a.h("SortPresenter", r0.toString());
            hw4.a r2 = this.a.b;
            if (r2 == null) goto L10;
            r2.a();
            return;
        L10:
            return;
        L5:
            r1 = false;
            goto L6
        }

        public a(i r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.list.sort.b.a
        public final void g6(final FolderSortStrategy r4) {
            tt5.a.h("SortPresenter", "onClickSort()...sortStrategy = " + r4);
            final i r0 = this.a;
            r0.getClass();
            r0.e = Flowable.just(Boolean.TRUE).observeOn(fo5.d.b()).subscribe(new o(r0, r4), new p(r0));
            hw4.a r5 = r0.b;
            if (r5 == null) goto L6;
            r5.a();
            return;
        }
    }

    public final IView.IViewDelegate createViewDelegate() {
        return new a(this);
    }

    public final void create() {
        super.create();
        tt5.a.h("SortPresenter", "create()...");
        this.c = (SortAndFilterViewModel) ViewModelProviders.of(this.a.getActivity()).get(SortAndFilterViewModel.class);
        ((b) getView()).S2(((zd5.g) getModel()).k7(this.f));
        if (this.d == null) goto L5;
        ((b) getView()).H(this.d);
    L5:
        this.c.setSortAndFilterMenuState(1);
    }

    public final void destroy() {
        super.destroy();
        tt5.a.h("SortPresenter", "destroy()...");
        this.c.setSortAndFilterMenuState(0);
        Disposable r0 = this.e;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isDisposed() == true) goto L9;
        this.e.dispose();
        return;
    }

    static {
    }

    public i(LifeCycleFragment r1, m r2, zd5.b r3, com.bytedance.ee.bear.content.common.morepanel.a.a r4, FolderSortStrategy r5, ce5.a r6) {
        super(r3, r2);
        this.a = r1;
        this.b = r4;
        this.d = r5;
        this.f = r6;
    }
}
