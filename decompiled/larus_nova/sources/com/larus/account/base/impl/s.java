package com.larus.account.base.impl;

import com.larus.account.base.model.LoginPlatform;
import com.larus.login.impl.f2;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class s implements n38.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n38.h f286185a;

    public s(f2 r100) {
        this.f286185a = r100;
    }

    @Override // n38.h
    public final void b(LoginPlatform r100, String r101, Boolean r102) {
        m38.a r103 = m38.a.f511783a;
        boolean r104 = Intrinsics.areEqual(r102, Boolean.TRUE);
        r103.getClass();
        m38.a.f511785c = r104;
        if (r101 != null) goto L5;
        String r105 = "";
    L6:
        m38.a.c(r103, r105, r100);
        this.f286185a.b(r100, r101, r102);
        return;
    L5:
        r105 = r101;
        goto L6
    }

    @Override // n38.h
    public final void a(LoginPlatform r110, int r111, String r112, String r113, String r114, Integer r115, String r116, Map r117) {
        m38.a.f511783a.getClass();
        n38.h.a.a(this.f286185a, r110, r111, r112, r113, null, null, null, null, 480);
    }
}
