package com.bytedance.caijing.sdk.infra.base.account;

import android.app.Activity;
import com.bytedance.caijing.sdk.infra.base.api.account.CJAccountService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import xc4.b;
import xc4.d;
import xc4.f;

/* JADX INFO: loaded from: classes15.dex */
public final class CJAccount {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f202203a = null;

    static {
        f202203a = LazyKt.lazy(CJAccount$accountService$2.INSTANCE);
    }

    public static f a() {
        return ((CJAccountService) f202203a.getValue()).getHostCurrentUserInfo();
    }

    public static void b(Activity r100, b r101, d r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        ((CJAccountService) f202203a.getValue()).hostShowLogin(r100, r101, r102);
    }
}
