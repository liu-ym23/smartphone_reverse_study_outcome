package com.larus.account.base.impl;

import com.larus.account.base.model.LoginPlatform;
import com.larus.utils.o0;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class n implements n38.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f286176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n38.h f286177b;

    public n(String r100, n38.h r101) {
        this.f286176a = r100;
        this.f286177b = r101;
    }

    @Override // n38.h
    public final void b(LoginPlatform r100, String r101, Boolean r102) {
        m38.a r103 = m38.a.f511783a;
        boolean r104 = Intrinsics.areEqual(r102, Boolean.TRUE);
        r103.getClass();
        m38.a.f511785c = r104;
        if (o0.d(this.f286176a) == false) goto L5;
        String r105 = "authorized";
    L8:
        m38.a.c(r103, r105, r100);
        this.f286177b.b(r100, r101, r102);
        return;
    L5:
        if (r101 != null) goto L7;
        r105 = "";
        goto L8
    L7:
        r105 = r101;
        goto L8
    }

    @Override // n38.h
    public final void a(LoginPlatform r110, int r111, String r112, String r113, String r114, Integer r115, String r116, Map r117) {
        m38.a.f511783a.getClass();
        this.f286177b.a(r110, r111, r112, r113, r114, r115, r116, r117);
    }
}
