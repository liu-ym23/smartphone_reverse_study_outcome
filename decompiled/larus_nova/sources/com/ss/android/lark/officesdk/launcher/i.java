package com.ss.android.lark.officesdk.launcher;

import android.app.Application;
import dagger.Lazy;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class i implements fva.c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Inject
    public Lazy<com.ss.android.lark.app.initiator.a> f433449a;

    @Inject
    public i() {
    }

    @Override // fva.c.a
    public final com.ss.android.lark.app.initiator.b a(Application r100) {
        Intrinsics.checkNotNullParameter(r100, "application");
        Lazy<com.ss.android.lark.app.initiator.a> r101 = this.f433449a;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("appLauncher");
        r101 = null;
    L7:
        return r101.get();
    }
}
