package cd5;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.facade.common.lazy.LazyBaseFragment;
import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.homepage.title.SubMenuView;
import com.bytedance.ee.bear.list.sort.FilterType;
import com.bytedance.ee.bear.list.sort.SortAndFilterViewModel;
import com.bytedance.ee.bear.list.t3;
import com.google.android.material.appbar.AppBarLayout;
import dd5.p1;
import dd5.s1;
import wc5.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class e implements f.a, p1 {
    public LazyBaseFragment a;
    public Context b;
    public f c;
    public f d;
    public com.bytedance.ee.bear.list.homepage.banner.a e;
    public com.bytedance.ee.bear.list.homepage.banner.c f;
    public yc5.b g;
    public final View h;
    public ConnectionService.NetworkState i;
    public FolderSortStrategy j;
    public final ce5.a k;

    public abstract String a();

    public String b() {
        return "";
    }

    public String c() {
        return "none";
    }

    public abstract void d(BaseFragment r1, Context r2, View r3);

    public e(ce5.a r1) {
        this.k = r1;
    }

    @Override // dd5.p1
    public final void Mj(boolean r2) {
        this.c.b(r2);
        this.d.b(r2);
    }

    @Override // wc5.f.a
    public void WU(boolean r4) {
        Mj(r4);
        s1.a.a.f((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), r4, c());
    }

    public void e(final AppBarLayout r3) {
        f r0 = (f) r3.findViewById(2131374462);
        this.c = r0;
        r0.setViewDelegate(this);
        f r1 = (f) this.a.findViewById(2131372628);
        this.d = r1;
        r1.setViewDelegate(this);
        Mj(t3.a);
        r3.addOnOffsetChangedListener(new a(this, r3));
    }

    public void f(FolderSortStrategy r5) {
        this.j = r5;
        f r0 = this.c;
        int r1 = r5.getType();
        FilterType r2 = FilterType.ALL;
        if (r1 != r2.getType()) goto L5;
        SubMenuView.FilterState r3 = SubMenuView.FilterState.DEFAULT;
    L6:
        r0.setFilterState(r3);
        f r4 = this.d;
        if (r5.getType() != r2.getType()) goto L9;
        SubMenuView.FilterState r6 = SubMenuView.FilterState.DEFAULT;
    L10:
        r4.setFilterState(r6);
        return;
    L9:
        r6 = SubMenuView.FilterState.CHECKED;
        goto L10
    L5:
        r3 = SubMenuView.FilterState.CHECKED;
        goto L6
    }

    public e(LazyBaseFragment r2, Context r3, AppBarLayout r4, ce5.a r5) {
        this.a = r2;
        this.b = r3;
        this.h = r4.findViewById(2131380933);
        this.k = r5;
        d(r2, r3, r4.findViewById(2131374280));
        e(r4);
        tt5.a.h("BaseHomeHeader", "initNotification()...");
        this.g = new yc5.b(this.b, r4, new d(this));
        if (this.a.getActivity() == null) goto L5;
        ((SortAndFilterViewModel) ViewModelProviders.of(this.a.getActivity()).get(SortAndFilterViewModel.class)).getSortStrategyLiveData().observe(this.a, new b(this));
    L5:
        j.a.a.a().observe(this.a, new c(this));
        s1.a.a.a(this);
        this.k = r5;
    }
}
