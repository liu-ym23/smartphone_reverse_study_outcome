package com.larus.home.impl.sdk;

import androidx.fragment.app.FragmentActivity;
import com.larus.login.api.LoginService;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class q1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q1 f346225a = null;

    static {
        f346225a = new q1();
    }

    public q1() {
    }

    public final void b(FragmentActivity r100, Function0 r101, Function0 r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "confirmCallback");
        Intrinsics.checkNotNullParameter(r102, "cancelCallback");
        LoginService.f356989a.x(r100, r101, r102, r103);
    }

    public final void a(FragmentActivity r100, Function0 r110, Function0 r111, Function0 r112, Function0 r113, Function0 r114) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r110, "cancelCallback");
        Intrinsics.checkNotNullParameter(r111, "logoutCallback");
        Intrinsics.checkNotNullParameter(r112, "logoutAllCallback");
        Intrinsics.checkNotNullParameter(r113, "confirmLogoutAllCallback");
        Intrinsics.checkNotNullParameter(r114, "cancelLogoutAllCallback");
        LoginService.f356989a.C(r100, r110, r111, r112, r113, r114);
    }
}
