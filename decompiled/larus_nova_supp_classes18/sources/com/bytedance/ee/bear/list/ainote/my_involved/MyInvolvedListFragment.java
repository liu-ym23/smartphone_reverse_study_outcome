package com.bytedance.ee.bear.list.ainote.my_involved;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.utils.ContextsKt;
import d0c.b;
import d0c.c;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import e0c.l;
import f0c.h;
import gc5.p;
import gc5.v;
import ic5.a;
import kotlin.jvm.internal.Intrinsics;
import wc5.d;
import wc5.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class MyInvolvedListFragment extends a implements e, v.c, c {
    public View g;
    public p h;
    public v i;

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

    @Override // wc5.e
    public final /* synthetic */ void onPageSelected() {
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

    public final UserSession e9() {
        if ((getActivity() instanceof c) == false) goto L7;
        return getActivity().e9();
    L7:
        return new ce5.a().b;
    }

    @Override // ic5.a
    public Context getContext() {
        return ContextsKt.findActivity(super.getContext());
    }

    public final void onDestroy() {
        super.onDestroy();
        p r0 = this.h;
        if (r0 == null) goto L6;
        r0.destroy();
        return;
    }

    @Override // gc5.v.c
    public final void onRefresh() {
        if ((getParentFragment() instanceof d) == false) goto L6;
        getParentFragment().Cu();
        return;
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        p r0 = this.h;
        if (r0 == null) goto L6;
        r0.onResume();
        return;
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m4provideComponent() {
        return provideComponent();
    }

    public MyInvolvedListFragment() {
    }

    @Override // wc5.e
    public final void Co(SmartRefreshLayout r2) {
        v r0 = this.i;
        if (r0 == null) goto L6;
        r0.J3(r2);
        return;
    }

    @Override // wc5.e
    public final void d2(cqa.h r1) {
        p r2 = this.h;
        if (r2 == null) goto L6;
        r2.onRefresh();
        return;
    }

    @Override // wc5.e
    public final void setUserVisibleHint(boolean r2) {
        super/*androidx.fragment.app.Fragment*/.setUserVisibleHint(r2);
        p r0 = this.h;
        if (r0 == null) goto L6;
        r0.setUserVisibleHint(r2);
        return;
    }

    public final void onViewCreated(View r10, Bundle r11) {
        super.onViewCreated(r10, r11);
        ce5.a r12 = new ce5.a(this);
        if (getParentFragment() != null) goto L5;
    L7:
        String r13 = "other";
    L8:
        this.i = new v(getContext(), this.g, this, this, r12, "my_involved", r13);
        ic5.e r2 = new ic5.e(this, getContext(), r12);
        p r7 = new p(this.i, r2, getContext(), this, r12, r13);
        this.h = r7;
        r7.create();
        return;
    L5:
        if (getParentFragment().getArguments() == null) goto L7;
        r13 = getParentFragment().getArguments().getString("extra_from", "other");
        goto L8
    }

    @Override // gc5.v.c
    public final void t(int r2, int r3) {
        if ((getParentFragment() instanceof d) == false) goto L6;
        getParentFragment().t(r2, r3);
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        View r5 = r2.inflate(2131563476, r3, false);
        this.g = r5;
        return r5;
    }
}
