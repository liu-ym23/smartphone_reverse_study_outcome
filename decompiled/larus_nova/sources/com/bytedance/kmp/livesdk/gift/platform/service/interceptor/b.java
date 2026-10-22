package com.bytedance.kmp.livesdk.gift.platform.service.interceptor;

import com.bytedance.android.scope.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.livesdk.revenue.service.user.a f252466a;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    public b(com.bytedance.android.livesdk.revenue.service.user.a r100) {
        Intrinsics.checkNotNullParameter(r100, "revUserService");
        this.f252466a = r100;
    }
}
