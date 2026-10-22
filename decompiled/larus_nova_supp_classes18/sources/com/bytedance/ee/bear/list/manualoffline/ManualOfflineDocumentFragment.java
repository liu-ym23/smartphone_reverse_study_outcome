package com.bytedance.ee.bear.list.manualoffline;

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
import id5.o;
import kotlin.jvm.internal.Intrinsics;
import wc5.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class ManualOfflineDocumentFragment extends id5.a implements e, a.InterfaceC0020a, c {
    public View g;
    public o h;
    public a i;

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

    @Override // id5.a
    public Context getContext() {
        return ContextsKt.findActivity(super.getContext());
    }

    public final void onDestroy() {
        super.onDestroy();
        o r0 = this.h;
        if (r0 == null) goto L6;
        r0.destroy();
        return;
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        o r0 = this.h;
        if (r0 == null) goto L6;
        r0.onResume();
        return;
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m23provideComponent() {
        return provideComponent();
    }

    public ManualOfflineDocumentFragment() {
    }

    @Override // wc5.e
    public final void Co(SmartRefreshLayout r2) {
        a r0 = this.i;
        if (r0 == null) goto L6;
        r0.F3(r2);
        return;
    }

    @Override // wc5.e
    public final void d2(cqa.h r1) {
        o r2 = this.h;
        if (r2 == null) goto L6;
        r2.onRefresh();
        return;
    }

    @Override // wc5.e
    public final void setUserVisibleHint(boolean r2) {
        super/*androidx.fragment.app.Fragment*/.setUserVisibleHint(r2);
        o r0 = this.h;
        if (r0 == null) goto L6;
        r0.setUserVisibleHint(r2);
        return;
    }

    public final void onViewCreated(View r7, Bundle r8) {
        super.onViewCreated(r7, r8);
        ce5.a r9 = new ce5.a(this);
        this.i = new a(getContext(), this.g, this, this, r9);
        id5.m r2 = new id5.m(this, getContext(), r9);
        o r10 = new o(this.i, r2, getContext(), this, r9);
        this.h = r10;
        r10.create();
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        View r5 = r2.inflate(2131563476, r3, false);
        this.g = r5;
        return r5;
    }
}
