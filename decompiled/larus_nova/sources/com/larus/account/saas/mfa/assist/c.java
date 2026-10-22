package com.larus.account.saas.mfa.assist;

import com.larus.account.saas.runtime.internal.delegate.SaasApp;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.Unit;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: classes24.dex */
public final class c implements d48.c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i<Unit> f286424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f286425b;

    @Override // d48.c.a
    public final void onAppLifeCycleChange(boolean r100) {
        if (r100 == false) goto L4;
        return;
    L4:
        if (this.f286424a.isActive() == true) goto L6;
        return;
    L6:
        if (this.f286425b.compareAndSet(false, true) == false) goto L11;
        SaasApp.f286460a.g(this);
        i<Unit> r101 = this.f286424a;
        Result.Companion r102 = Result.Companion;
        r101.resumeWith(Result.m9449constructorimpl(Unit.INSTANCE));
        return;
    }

    public c(j r100, AtomicBoolean r101) {
        this.f286424a = r100;
        this.f286425b = r101;
    }
}
