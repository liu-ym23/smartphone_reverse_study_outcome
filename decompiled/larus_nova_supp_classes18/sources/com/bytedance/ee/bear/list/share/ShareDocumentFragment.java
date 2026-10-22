package com.bytedance.ee.bear.list.share;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.utils.ContextsKt;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class ShareDocumentFragment extends k implements wc5.e, e2.a, d0c.c {
    public View g;
    public c2 h;
    public e2 i;

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

    @Override // wc5.e
    public final /* synthetic */ void onPageSelected() {
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

    public final UserSession e9() {
        if ((getActivity() instanceof d0c.c) == false) goto L7;
        return getActivity().e9();
    L7:
        return new ce5.a().b;
    }

    @Override // com.bytedance.ee.bear.list.share.k
    public Context getContext() {
        return ContextsKt.findActivity(super.getContext());
    }

    public final void onDestroy() {
        super.onDestroy();
        c2 r0 = this.h;
        if (r0 == null) goto L6;
        r0.destroy();
        return;
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        c2 r0 = this.h;
        if (r0 == null) goto L6;
        r0.onResume();
        return;
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m42provideComponent() {
        return provideComponent();
    }

    public ShareDocumentFragment() {
    }

    @Override // wc5.e
    public final void Co(SmartRefreshLayout r4) {
        e2 r0 = this.i;
        if (r0 == null) goto L6;
        tt5.a.h("ShareDocumentView", "setRefreshLayout()...refreshLayout = " + r4);
        r0.j = r4;
        r0.z2();
        return;
    }

    @Override // wc5.e
    public final void d2(cqa.h r1) {
        c2 r2 = this.h;
        if (r2 == null) goto L6;
        r2.onRefresh();
        return;
    }

    @Override // wc5.e
    public final void setUserVisibleHint(boolean r2) {
        super/*androidx.fragment.app.Fragment*/.setUserVisibleHint(r2);
        c2 r0 = this.h;
        if (r0 == null) goto L6;
        r0.setUserVisibleHint(r2);
        return;
    }

    public final void onViewCreated(View r7, Bundle r8) {
        super.onViewCreated(r7, r8);
        ce5.a r9 = new ce5.a(this);
        this.i = new e2(getContext(), this.g, this, this, r9);
        x1 r2 = new x1(this, getContext(), r9);
        c2 r10 = new c2(this.i, r2, getContext(), this, r9);
        this.h = r10;
        r10.create();
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        View r5 = r2.inflate(2131563476, r3, false);
        this.g = r5;
        return r5;
    }
}
