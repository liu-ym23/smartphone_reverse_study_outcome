package com.bytedance.ee.bear.list.sort;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.unbundle.BenefitManagerAPI;
import com.bytedance.ee.bear.unbundle.BenefitStore;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SortAndFilterFragment extends zd5.d implements com.bytedance.ee.bear.content.common.morepanel.a, d0c.c {
    public String g;
    public String h;
    public String i;
    public String j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public int q;
    public int r;
    public int s;
    public FolderSortStrategy t;
    public String u;
    public com.bytedance.ee.bear.content.common.morepanel.a.a v;
    public View w;
    public d x;

    public final void afterUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void afterUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.-CC.$default$generatedComponent(this);
    }

    public final /* synthetic */ com.ss.android.lark.passportc.api.m getPassport() {
        return d0c.b.a(this);
    }

    public final void onUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void onUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ e0c.l provideComponent() {
        return d0c.b.b(this);
    }

    public final void tk() {
    }

    public SortAndFilterFragment() {
        this.k = true;
        this.l = true;
        this.m = true;
        this.n = true;
        this.o = true;
        this.p = false;
        this.q = 0;
        this.r = 0;
        this.s = 0;
    }

    public final UserSession e9() {
        return PassportcConvention.b(this);
    L5:
        return new ce5.a().b;
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        this.x.destroy();
    }

    public final void onStart() {
        super/*androidx.fragment.app.Fragment*/.onStart();
        int r0 = y9c.d.c(getActivity(), 2131100558);
        if (Build.VERSION.SDK_INT < 26) goto L6;
        getActivity().getWindow().addFlags(Integer.MIN_VALUE);
        getActivity().getWindow().clearFlags(134217728);
        getActivity().getWindow().setNavigationBarColor(r0);
        return;
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m51provideComponent() {
        return provideComponent();
    }

    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        Bundle r5 = getArguments();
        if (r5 == null) goto L6;
        this.g = r5.getString("key_module", "");
        this.h = r5.getString("key_sub_module", "");
        this.i = r5.getString("key_token", "");
        this.j = r5.getString("key_path", "");
        this.k = r5.getBoolean("key_type_filter_enable", true);
        this.n = r5.getBoolean("key_reset_enable", true);
        this.o = r5.getBoolean("key_done_enable", true);
        this.l = r5.getBoolean("key_sort_filter_enable", true);
        this.m = r5.getBoolean("key_sort_asc_enable", true);
        this.q = r5.getInt("key_default_type_pos", this.q);
        this.r = r5.getInt("key_default_sort_pos", this.r);
        this.s = r5.getInt("key_sort_title_res", 0);
        this.t = (FolderSortStrategy) r5.getParcelable("key_sort_strategy");
        this.u = r5.getString("key_view_model_tag", "");
        this.p = r5.getBoolean("key_filter_folder");
        return;
    }

    public final void uC(hw4.a r1) {
        this.v = r1;
    }

    public final void onViewCreated(View r28, Bundle r29) {
        super.onViewCreated(r28, r29);
        ce5.a r9 = new ce5.a(this);
        h r2 = new h(this.w, getContext(), this.k, this.l, this.m, this.n, this.o, this.q, this.r, this.g, this.h, this.j, this.i, this.s);
        BenefitStore r0 = ((BenefitManagerAPI) r9.a(BenefitManagerAPI.class)).n1();
        d r12 = new d(this, r2, zd5.i.a(this.i, this.p, r0), this.v, this.g, this.h, this.j, this.t, r9, this.u);
        this.x = r12;
        r12.create();
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        View r5 = r2.inflate(2131563485, r3, false);
        this.w = r5;
        return r5;
    }
}
