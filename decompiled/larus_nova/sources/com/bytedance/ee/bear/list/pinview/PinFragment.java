package com.bytedance.ee.bear.list.pinview;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.larus.nova.R;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.utils.ContextsKt;
import d0c.b;
import d0c.c;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import e0c.l;
import f0c.h;
import kotlin.jvm.internal.Intrinsics;
import od5.a;
import od5.d;
import od5.e;

/* JADX INFO: loaded from: classes18.dex */
public class PinFragment extends a implements c {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public e f229170p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public View f229171q;

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOffline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOnline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider, dagger.hilt.internal.GeneratedComponentManager
    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.CC.$default$generatedComponent(this);
    }

    @Override // com.ss.android.lark.passportc.api.r
    public final /* synthetic */ m getPassport() {
        return b.a(this);
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOffline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOnline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // d0c.c, dagger.hilt.android.dwarf.DwarfComponentProvider
    public final /* synthetic */ l provideComponent() {
        return b.b(this);
    }

    @Override // com.bytedance.ee.bear.facade.common.lazy.LazyFragment
    public final void X90() {
        e r100 = this.f229170p;
        if (r100 == null) goto L6;
        r100.setUserVisibleHint(true);
        return;
    }

    public void ca0() {
        tt5.a.h("PinFragment", "initMVP()...");
        ce5.a r100 = new ce5.a(this);
        e r101 = new e(new od5.m(getContext(), this.f229171q, this, r100), new d(this, getContext(), r100), getContext(), this, r100);
        this.f229170p = r101;
        r101.create();
    }

    @Override // com.bytedance.ee.bear.facade.common.lazy.LazyFragment
    public final void Y90() {
        super.Y90();
        tt5.a.h("PinFragment", "onResume()...");
        e r100 = this.f229170p;
        if (r100 == null) goto L6;
        r100.onResume();
        return;
    }

    @Override // d0c.c
    public final UserSession e9() {
        if ((getActivity() instanceof c) == false) goto L7;
        return ((c) getActivity()).e9();
    L7:
        return PassportcConvention.b(this);
    L9:
        return new ce5.a().f23447b;
    }

    @Override // od5.a, com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public Context getContext() {
        return ContextsKt.findActivity(super.getContext());
    }

    @Override // com.bytedance.ee.bear.facade.common.lazy.LazyBaseFragment, com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        tt5.a.h("PinFragment", "onDestroy()...");
        e r100 = this.f229170p;
        if (r100 == null) goto L6;
        r100.destroy();
        return;
    }

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider
    public final /* bridge */ /* synthetic */ Object provideComponent() {
        return provideComponent();
    }

    public PinFragment() {
    }

    @Override // com.bytedance.ee.bear.facade.common.lazy.LazyFragment
    public final void V90(Bundle r100) {
        tt5.a.h("PinFragment", "onCreateViewLazy()...");
        View r101 = View.inflate(getContext(), R.layout.list_doc_sub_list, null);
        this.f229171q = r101;
        aa0(r101);
        ca0();
    }

    @Override // com.bytedance.ee.bear.facade.common.lazy.LazyFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean r100) {
        super.setUserVisibleHint(r100);
        tt5.a.h("PinFragment", "setUserVisibleHint()...isVisibleToUser = " + r100);
        if (r100 == false) goto L8;
        e r101 = this.f229170p;
        if (r101 == null) goto L9;
        r101.onRefresh();
        return;
    L9:
        return;
    }
}
