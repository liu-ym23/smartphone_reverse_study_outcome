package com.bytedance.ee.bear.list.pinview;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class PinFragment extends a implements c {
    public e p;
    public View q;

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

    public final void X90() {
        e r0 = this.p;
        if (r0 == null) goto L6;
        r0.setUserVisibleHint(true);
        return;
    }

    public void ca0() {
        tt5.a.h("PinFragment", "initMVP()...");
        ce5.a r7 = new ce5.a(this);
        e r0 = new e(new od5.m(getContext(), this.q, this, r7), new d(this, getContext(), r7), getContext(), this, r7);
        this.p = r0;
        r0.create();
    }

    public final void Y90() {
        super.Y90();
        tt5.a.h("PinFragment", "onResume()...");
        e r0 = this.p;
        if (r0 == null) goto L6;
        r0.onResume();
        return;
    }

    public final UserSession e9() {
        if ((getActivity() instanceof c) == false) goto L7;
        return getActivity().e9();
    L7:
        return PassportcConvention.b(this);
    L9:
        return new ce5.a().b;
    }

    @Override // od5.a
    public Context getContext() {
        return ContextsKt.findActivity(super.getContext());
    }

    public final void onDestroy() {
        super/*com.bytedance.ee.bear.facade.common.lazy.LazyBaseFragment*/.onDestroy();
        tt5.a.h("PinFragment", "onDestroy()...");
        e r0 = this.p;
        if (r0 == null) goto L6;
        r0.destroy();
        return;
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m34provideComponent() {
        return provideComponent();
    }

    public PinFragment() {
    }

    public final void V90(Bundle r3) {
        tt5.a.h("PinFragment", "onCreateViewLazy()...");
        View r4 = View.inflate(getContext(), 2131563476, null);
        this.q = r4;
        aa0(r4);
        ca0();
    }

    public void setUserVisibleHint(boolean r3) {
        super.setUserVisibleHint(r3);
        tt5.a.h("PinFragment", "setUserVisibleHint()...isVisibleToUser = " + r3);
        if (r3 == false) goto L8;
        e r4 = this.p;
        if (r4 == null) goto L9;
        r4.onRefresh();
        return;
    L9:
        return;
    }
}
