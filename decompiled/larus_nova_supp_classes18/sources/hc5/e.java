package hc5;

import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.appsetting.downgrade.DowngradeSettingUtil;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiViewModelProvider;
import com.bytedance.ee.bear.facade.common.LifeCycleFragment;
import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.sort.SortAndFilterViewModel;
import com.bytedance.ee.bear.list.sort.h;
import com.larksuite.framework.mvp.BasePresenter;
import com.larksuite.framework.mvp.IView;
import io.reactivex.Flowable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e extends BasePresenter<zd5.f, com.bytedance.ee.bear.list.sort.a, com.bytedance.ee.bear.list.sort.a.InterfaceC0035a> {
    public final LifeCycleFragment a;
    public final com.bytedance.ee.bear.content.common.morepanel.a.a b;
    public final String c;
    public final String d;
    public final String e;
    public SortAndFilterViewModel f;
    public FolderSortStrategy g;
    public final ce5.a h;
    public final String i;

    public class a implements com.bytedance.ee.bear.list.sort.a.InterfaceC0035a {
        public final /* synthetic */ e a;

        @Override // com.bytedance.ee.bear.list.sort.a.InterfaceC0035a
        public final void onClickClose() {
            StringBuilder r0 = new StringBuilder("onClickClose(): ");
            if (this.a.b == null) goto L5;
            boolean r1 = true;
        L6:
            r0.append(r1);
            tt5.a.h("AINoteSortAndFilterPresenter", r0.toString());
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

        public a(e r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.list.sort.a.InterfaceC0035a
        public final void y2(FolderSortStrategy r3) {
            tt5.a.h("AINoteSortAndFilterPresenter", "onClickReset()...sortStrategy = " + r3);
            e.H8(this.a, r3);
        }

        @Override // com.bytedance.ee.bear.list.sort.a.InterfaceC0035a
        public final void z2(FolderSortStrategy r3) {
            tt5.a.h("AINoteSortAndFilterPresenter", "onClickDone()...sortStrategy = " + r3);
            e.H8(this.a, r3);
        }
    }

    public final IView.IViewDelegate createViewDelegate() {
        return new a(this);
    }

    public final void create() {
        super.create();
        tt5.a.h("AINoteSortAndFilterPresenter", "create()...");
        if (TextUtils.isEmpty(this.i) == false) goto L5;
    L7:
        this.f = (SortAndFilterViewModel) ViewModelProviders.of(this.a.getActivity()).get(SortAndFilterViewModel.class);
    L8:
        ((com.bytedance.ee.bear.list.sort.a) getView()).h7(((zd5.f) getModel()).G6(), ((zd5.f) getModel()).x7());
        if (this.g == null) goto L11;
        ((com.bytedance.ee.bear.list.sort.a) getView()).H(this.g);
    L11:
        this.f.setSortAndFilterMenuState(1);
        lc5.f.c((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), this.c);
        lc5.f.i(this.c, this.d, this.e);
        return;
    L5:
        if (DowngradeSettingUtil.a("downgradeSortFilterViewModel") == true) goto L7;
        FragmentActivity r0 = this.a.getActivity();
        ViewModelProvider.NewInstanceFactory r1 = ForsetiViewModelProvider.c;
        this.f = (SortAndFilterViewModel) ForsetiViewModelProvider.a.a(r0).get(this.i, SortAndFilterViewModel.class);
        goto L8
    }

    public final void destroy() {
        super.destroy();
        tt5.a.h("AINoteSortAndFilterPresenter", "destroy()...");
        this.f.setSortAndFilterMenuState(0);
    }

    static {
    }

    public static void H8(final e r2, final FolderSortStrategy r3) {
        r2.g = r3;
        Flowable.just(Boolean.TRUE).observeOn(fo5.d.b()).subscribe(new c(r2, r3), new d());
        hw4.a r4 = r2.b;
        if (r4 == null) goto L6;
        r4.a();
        return;
    }

    public e(LifeCycleFragment r1, h r2, zd5.a r3, com.bytedance.ee.bear.content.common.morepanel.a.a r4, String r5, String r6, String r7, FolderSortStrategy r8, ce5.a r9, String r10) {
        super(r3, r2);
        this.a = r1;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
    }
}
