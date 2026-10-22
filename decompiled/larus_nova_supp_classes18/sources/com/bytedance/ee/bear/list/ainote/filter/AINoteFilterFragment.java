package com.bytedance.ee.bear.list.ainote.filter;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.content.common.morepanel.a;
import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.unbundle.BenefitManagerAPI;
import com.bytedance.ee.bear.unbundle.BenefitStore;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import d0c.b;
import d0c.c;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import e0c.l;
import f0c.h;
import hc5.e;
import hc5.f;
import kotlin.jvm.internal.Intrinsics;
import y9c.d;
import zd5.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class AINoteFilterFragment extends f implements a, c {
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
    public a.a v;
    public View w;
    public e x;

    public final void afterUserOffline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void afterUserOnline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.-CC.$default$generatedComponent(this);
    }

    public final /* synthetic */ m getPassport() {
        return b.a(this);
    }

    public final void onUserOffline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void onUserOnline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ l provideComponent() {
        return b.b(this);
    }

    public final void tk() {
    }

    public AINoteFilterFragment() {
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
        d.c(getActivity(), 2131100558);
        if (Build.VERSION.SDK_INT < 26) goto L8;
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L9;
        r0.getWindow().addFlags(Integer.MIN_VALUE);
        r0.getWindow().clearFlags(134217728);
        r0.getWindow().setNavigationBarColor(d.c(getActivity(), 2131100558));
        return;
    L9:
        return;
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m3provideComponent() {
        return provideComponent();
    }

    public final void onCreate(Bundle r5) {
        super.onCreate(r5);
        Bundle r6 = getArguments();
        if (r6 == null) goto L6;
        this.g = r6.getString("key_module", "");
        this.h = r6.getString("key_sub_module", "");
        this.i = r6.getString("key_token", "");
        this.j = r6.getString("key_path", "");
        this.k = r6.getBoolean("key_type_filter_enable", true);
        this.n = r6.getBoolean("key_reset_enable", false);
        this.o = r6.getBoolean("key_done_enable", false);
        this.l = r6.getBoolean("key_sort_filter_enable", true);
        this.m = r6.getBoolean("key_sort_asc_enable", true);
        this.q = r6.getInt("key_default_type_pos", this.q);
        this.r = r6.getInt("key_default_sort_pos", this.r);
        this.s = r6.getInt("key_sort_title_res", 0);
        this.t = (FolderSortStrategy) r6.getParcelable("key_sort_strategy");
        this.u = r6.getString("key_view_model_tag", "");
        this.p = r6.getBoolean("key_filter_folder");
        return;
    }

    public final void uC(hw4.a r1) {
        this.v = r1;
    }

    public final void onViewCreated(View r28, Bundle r29) {
        super.onViewCreated(r28, r29);
        ce5.a r9 = new ce5.a(this);
        com.bytedance.ee.bear.list.sort.h r2 = new com.bytedance.ee.bear.list.sort.h(this.w, getContext(), this.k, this.l, this.m, this.n, this.o, this.q, this.r, this.g, this.h, this.j, this.i, this.s);
        BenefitStore r0 = ((BenefitManagerAPI) r9.a(BenefitManagerAPI.class)).n1();
        e r12 = new e(this, r2, i.a(this.i, this.p, r0), this.v, this.g, this.h, this.j, this.t, r9, this.u);
        this.x = r12;
        r12.create();
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        View r5 = r2.inflate(2131563485, r3, false);
        this.w = r5;
        return r5;
    }
}
