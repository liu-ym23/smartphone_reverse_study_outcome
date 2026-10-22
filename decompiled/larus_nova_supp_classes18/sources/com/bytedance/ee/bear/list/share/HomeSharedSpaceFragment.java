package com.bytedance.ee.bear.list.share;

import android.content.Context;
import com.bytedance.ee.bear.facade.common.lazy.LazyBaseFragment;
import com.google.android.material.appbar.AppBarLayout;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.utils.ContextsKt;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class HomeSharedSpaceFragment extends h implements d0c.c {
    public final void afterUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void afterUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    @Override // com.bytedance.ee.bear.list.homepage.BaseHomeFragment
    public final int da0() {
        return 2131563501;
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

    public final UserSession e9() {
        if ((getActivity() instanceof d0c.c) == false) goto L7;
        return getActivity().e9();
    L7:
        return new ce5.a().b;
    }

    @Override // com.bytedance.ee.bear.list.share.h
    public Context getContext() {
        return ContextsKt.findActivity(super.getContext());
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m39provideComponent() {
        return provideComponent();
    }

    public HomeSharedSpaceFragment() {
    }

    @Override // com.bytedance.ee.bear.list.homepage.BaseHomeFragment
    public final cd5.e ba0(LazyBaseFragment r3, Context r4, AppBarLayout r5) {
        return new e0(r3, r4, r5, new ce5.a(this));
    }
}
