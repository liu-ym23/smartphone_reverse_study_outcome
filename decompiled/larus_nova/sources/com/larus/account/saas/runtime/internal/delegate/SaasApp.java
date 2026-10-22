package com.larus.account.saas.runtime.internal.delegate;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import com.larus.account.saas.runtime.depend.ToastType;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class SaasApp implements d48.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SaasApp f286460a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f286461b = null;

    public SaasApp() {
    }

    static {
        f286460a = new SaasApp();
        f286461b = LazyKt.lazy(SaasApp$impl$2.INSTANCE);
    }

    public static d48.c a() {
        return (d48.c) f286461b.getValue();
    }

    @Override // d48.c
    public final boolean b() {
        return a().b();
    }

    @Override // d48.c
    public final Activity currentActivity() {
        return a().currentActivity();
    }

    @Override // d48.c
    public final String e() {
        return a().e();
    }

    @Override // d48.c
    public final Application getApplication() {
        return a().getApplication();
    }

    @Override // d48.c
    public final boolean isTeenMode() {
        return a().isTeenMode();
    }

    public final String c(int r100) {
        return getApplication().getString(r100);
    }

    @Override // d48.c
    public final void g(d48.c.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        a().g(r100);
    }

    @Override // d48.c
    public final void h(com.larus.account.saas.mfa.assist.c r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        a().h(r100);
    }

    @Override // d48.c
    public final boolean f(ToastType r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "text");
        return a().f(r100, r101);
    }

    @Override // d48.c
    public boolean startActivity(Activity r100, Intent r101) {
        Intrinsics.checkNotNullParameter(r101, "intent");
        return a().startActivity(r100, r101);
    }
}
