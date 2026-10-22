package com.larus.account.saas.security.kickout;

import h48.d;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes24.dex */
public final class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f286512a;

    @Override // h48.d
    public final void confirm() {
        Function0<Unit> r100 = this.f286512a;
        if (r100 == null) goto L6;
        r100.invoke();
        return;
    }

    public a(Function0<Unit> r100) {
        this.f286512a = r100;
    }
}
