package com.bytedance.ee.bear.list.homepage.title;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.content.common.morepanel.ActionSheetDialogFragment;
import com.bytedance.ee.bear.contract.d;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.lark.space.m;
import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.sort.SortAndFilterFragment;
import com.bytedance.ee.bear.list.sort.SortAndFilterViewModel;
import com.bytedance.ee.bear.list.sort.SortFragment;
import com.bytedance.ee.util.ui.n;
import dd5.p1;
import dd5.s1;
import lc5.p;
import wc5.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class a implements f.a, p1 {
    public FolderSortStrategy a;
    public SortAndFilterViewModel b;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.list.homepage.title.a$a, reason: collision with other inner class name */
    public static final class C0017a {
    }

    static {
    }

    public abstract int a();

    public abstract String b();

    public abstract Fragment c();

    public abstract String d();

    public abstract String e();

    public abstract SubMenuViewPad f();

    public abstract String g();

    @Override // wc5.f.a
    public final void Qi() {
        boolean r2 = true;
        if (j.a.a.getNetworkState().a() == true) goto L6;
        r2 = false;
    L6:
        if (r2 == false) goto L11;
        Bundle r0 = c().getArguments();
        if (r0 != null) goto L10;
        r0 = new Bundle();
    L10:
        r0.putString("key_token", e());
        r0.putParcelable("key_sort_strategy", this.a);
        r0.putBoolean("key_sort_asc_enable", false);
        r0.putInt("key_default_sort_pos", a());
        r0.putInt("maxWidth", n.d(450));
        ActionSheetDialogFragment.ca0(getActivity(), SortFragment.class, r0, f().getIvSortIcon());
        return;
    L11:
        Toast.showFailureText(getContext(), b(), 0);
    }

    @Override // wc5.f.a
    public final void eF() {
        boolean r2 = true;
        if (j.a.a.getNetworkState().a() == true) goto L6;
        r2 = false;
    L6:
        if (r2 == false) goto L11;
        Bundle r0 = c().getArguments();
        if (r0 != null) goto L10;
        r0 = new Bundle();
    L10:
        r0.putString("key_module", d());
        r0.putString("key_sub_module", g());
        r0.putString("key_token", e());
        r0.putBoolean("key_sort_asc_enable", false);
        r0.putBoolean("key_sort_filter_enable", false);
        r0.putBoolean("key_reset_enable", false);
        r0.putBoolean("key_done_enable", false);
        r0.putInt("key_sort_title_res", 2131887915);
        r0.putParcelable("key_sort_strategy", this.a);
        r0.putInt("key_default_sort_pos", 2);
        ActionSheetDialogFragment.ca0(getActivity(), SortAndFilterFragment.class, r0, f().getIvFilterIcon());
    L12:
        lc5.f.a.I(new p(d(), g(), "filter", "ccm_space_header_filter_view", g(), "ccm_base_homepage_landing_click"));
        return;
    L11:
        Toast.showFailureText(getContext(), b(), 0);
        goto L12
    }

    public a() {
        if (this.b != null) goto L5;
        this.b = (SortAndFilterViewModel) ViewModelProviders.of(getActivity()).get(SortAndFilterViewModel.class);
    L5:
        SortAndFilterViewModel r0 = this.b;
        if (r0 == null) goto L11;
        LiveData<FolderSortStrategy> r1 = r0.getSortStrategyLiveData();
        if (r1 == null) goto L12;
        m r2 = (m) this;
        r1.observe(r2.c.getViewLifecycleOwner(), new bd5.c(r2));
        return;
    L12:
        return;
    }

    public final FragmentActivity getActivity() {
        return c().requireActivity();
    }

    public final Context getContext() {
        return c().requireContext();
    }

    @Override // wc5.f.a
    public final void WU(boolean r11) {
        tt5.a.h(c().getClass().getName(), "onClickGrid()...showGrid = " + r11);
        ((m) this).Mj(r11);
        s1.a.a.f((d) org.koin.java.a.c(d.class, null, null, 6), r11, g());
        lc5.f.a.G(d(), g(), g(), "ccm_space_home_page_click", "", "");
    }
}
