package ae5;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.bytedance.ee.bear.content.common.morepanel.ActionSheetDialogFragment;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.facade.common.lazy.LazyBaseFragment;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.homepage.title.SubMenuView;
import com.bytedance.ee.bear.list.homepage.title.SubMenuViewPad;
import com.bytedance.ee.bear.list.recent.RecentSort;
import com.bytedance.ee.bear.list.sort.FilterType;
import com.bytedance.ee.bear.list.sort.SortAndFilterFragment;
import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class l extends cd5.e {
    public SubMenuViewPad l;

    @Override // wc5.f.a
    public final void Qi() {
    }

    @Override // cd5.e
    public final String a() {
        return "favorites";
    }

    @Override // cd5.e
    public final String b() {
        return "star";
    }

    @Override // wc5.f.a
    public final void eF() {
        ConnectionService.NetworkState r1 = this.i;
        if (r1 != null) goto L5;
    L18:
        Context r2 = this.b;
        Toast.showFailureText(r2, r2.getString(2131887789), 0);
        return;
    L5:
        if (r1.a() == false) goto L18;
        lc5.p r3 = new lc5.p("ccm_space_favorites_page_click", "favorites", "none", "filter", "ccm_space_header_filter_view", "", sbb.e.e.b, "", "", false, false, false, 0, null, "", null);
        lc5.f.a.I(r3);
        Bundle r4 = new Bundle();
        r4.putString("key_module", "favorites");
        r4.putString("key_token", "star");
        r4.putBoolean("key_sort_filter_enable", false);
        r4.putBoolean("key_reset_enable", false);
        r4.putBoolean("key_done_enable", false);
        r4.putParcelable("key_sort_strategy", this.j);
        if (this.l == null) goto L9;
    L13:
        SubMenuViewPad r5 = this.l;
        if (r5 != null) goto L16;
        View r6 = null;
    L17:
        ActionSheetDialogFragment.ca0(this.a.getActivity(), SortAndFilterFragment.class, r4, r6);
        return;
    L16:
        r6 = r5.getIvFilterIcon();
        goto L17
    L9:
        if (this.a.getParentFragment() == null) goto L13;
        if (this.a.getParentFragment().getView() == null) goto L13;
        this.l = (SubMenuViewPad) this.a.getParentFragment().getView().findViewById(2131387539);
        goto L13
    }

    @Override // cd5.e, wc5.f.a
    public final void WU(boolean r12) {
        super.WU(r12);
        lc5.r r13 = new lc5.r("ccm_space_favorites_page_click", "favorites", "none", "", sbb.e.e.b, false, false, false, 0, "");
        lc5.f.a.O(r13);
    }

    @Override // cd5.e
    public final void f(FolderSortStrategy r4) {
        super.f(r4);
        SubMenuViewPad r0 = this.l;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r4.getType() != FilterType.ALL.getType()) goto L7;
        SubMenuView.FilterState r1 = SubMenuView.FilterState.DEFAULT;
    L8:
        r0.setFilterState(r1);
        SubMenuViewPad r2 = this.l;
        if (RecentSort.getSort(r4.e).getSortPos() == 0) goto L11;
        boolean r5 = true;
    L12:
        r2.setSelectedSortState(r5);
        return;
    L11:
        r5 = false;
        goto L12
    L7:
        r1 = SubMenuView.FilterState.CHECKED;
        goto L8
    }

    @Override // cd5.e
    public final void d(BaseFragment r1, Context r2, View r3) {
        r3.setVisibility(8);
    }

    public l(LazyBaseFragment r1, Context r2, AppBarLayout r3, ce5.a r4) {
        super(r1, r2, r3, r4);
    }
}
