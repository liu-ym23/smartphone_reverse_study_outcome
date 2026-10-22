package com.bytedance.ee.bear.list.share;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.bytedance.ee.bear.content.common.morepanel.ActionSheetDialogFragment;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.facade.common.lazy.LazyBaseFragment;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.sort.SortAndFilterFragment;
import com.bytedance.ee.bear.list.sort.SortFragment;
import com.bytedance.ee.bear.list.sort.SortScene;
import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e0 extends cd5.e {
    @Override // cd5.e
    public final String a() {
        return "shared";
    }

    @Override // cd5.e
    public final String b() {
        return "shared_file";
    }

    @Override // cd5.e
    public final String c() {
        return "sharetome";
    }

    @Override // wc5.f.a
    public final void Qi() {
        ConnectionService.NetworkState r1 = this.i;
        if (r1 != null) goto L5;
    L7:
        Context r2 = this.b;
        Toast.showFailureText(r2, r2.getString(2131887789), 0);
        return;
    L5:
        if (r1.a() == false) goto L7;
        lc5.p r3 = new lc5.p("ccm_space_shared_page_click", "shared", "sharetome", "filter", "ccm_space_header_filter_view", "", sbb.e.e.b, "", "", false, false, false, 0, null, "", null);
        lc5.f.a.I(r3);
        Bundle r4 = new Bundle();
        r4.putString("key_token", "shared_file");
        r4.putParcelable("key_sort_strategy", this.j);
        ActionSheetDialogFragment.ba0(this.a.getActivity(), SortFragment.class, r4);
    }

    @Override // wc5.f.a
    public final void eF() {
        ConnectionService.NetworkState r1 = this.i;
        if (r1 != null) goto L5;
    L7:
        Context r2 = this.b;
        Toast.showFailureText(r2, r2.getString(2131887789), 0);
        return;
    L5:
        if (r1.a() == false) goto L7;
        lc5.p r3 = new lc5.p("ccm_space_shared_page_click", "shared", "sharetome", "filter", "ccm_space_header_filter_view", "", sbb.e.e.b, "", "", false, false, false, 0, null, "", null);
        lc5.f.a.I(r3);
        Bundle r4 = new Bundle();
        r4.putString("key_module", "shared");
        r4.putString("key_sub_module", "sharetome");
        r4.putString("key_token", "shared_file");
        r4.putBoolean("key_sort_filter_enable", false);
        r4.putBoolean("key_reset_enable", false);
        r4.putBoolean("key_done_enable", false);
        r4.putParcelable("key_sort_strategy", this.j);
        ActionSheetDialogFragment.ba0(this.a.getActivity(), SortAndFilterFragment.class, r4);
    }

    @Override // cd5.e, wc5.f.a
    public final void WU(boolean r12) {
        super.WU(r12);
        lc5.r r13 = new lc5.r("ccm_space_shared_page_click", "shared", "sharetome", "", sbb.e.e.b, false, false, false, 0, "");
        lc5.f.a.O(r13);
    }

    @Override // cd5.e
    public final void f(FolderSortStrategy r5) {
        super.f(r5);
        wc5.f r0 = this.c;
        SortScene r1 = SortScene.ShareFileSort;
        r0.a(zd5.c.b(r1, r5.e, r5.f));
        this.d.a(zd5.c.b(r1, r5.e, r5.f));
    }

    @Override // cd5.e
    public final void d(BaseFragment r8, Context r9, View r10) {
        if (((ww4.a) org.koin.java.a.a(ww4.a.class)).a().d().a == false) goto L5;
        this.f = new p3(r9, r10);
        o3 r11 = new o3(r8, r9, new n3(this.k), this.f, this.k);
        this.e = r11;
        r11.create();
        return;
    L5:
        r10.findViewById(2131374280).setVisibility(8);
    }

    public e0(LazyBaseFragment r1, Context r2, AppBarLayout r3, ce5.a r4) {
        super(r1, r2, r3, r4);
    }
}
