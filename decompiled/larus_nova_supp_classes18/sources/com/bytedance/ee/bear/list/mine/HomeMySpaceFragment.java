package com.bytedance.ee.bear.list.mine;

import android.content.Context;
import cd5.e;
import com.bytedance.ee.bear.facade.common.lazy.LazyBaseFragment;
import com.google.android.material.appbar.AppBarLayout;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.entity.UserSession;
import d0c.b;
import d0c.c;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import e0c.l;
import f0c.h;
import jd5.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class HomeMySpaceFragment extends f implements c {
    public final void afterUserOffline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void afterUserOnline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    @Override // com.bytedance.ee.bear.list.homepage.BaseHomeFragment
    public final int da0() {
        return 2131563495;
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

    public final UserSession e9() {
        if ((getActivity() instanceof c) == false) goto L7;
        return getActivity().e9();
    L7:
        return new ce5.a().b;
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m24provideComponent() {
        return provideComponent();
    }

    public HomeMySpaceFragment() {
    }

    @Override // com.bytedance.ee.bear.list.homepage.BaseHomeFragment
    public final e ba0(LazyBaseFragment r3, Context r4, AppBarLayout r5) {
        return new jd5.h(r3, r4, r5, new ce5.a(this));
    }
}
