package com.ss.android.lark.conditional.access.auth.v2;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class f0 implements ozb.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SecurityPolicyAuthManager f417796a;

    public f0(SecurityPolicyAuthManager r100) {
        this.f417796a = r100;
    }

    @Override // ozb.c
    public final /* synthetic */ void a() {
    }

    @Override // ozb.c
    public final void b(ozb.a r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        ArrayList<String> r101 = com.ss.android.lark.conditional.access.utils.c.f418483a;
        com.ss.android.lark.conditional.access.utils.c.b("SecurityPolicy_SecurityPolicyAuthManager", "call Logout", false);
        this.f417796a.m();
    }
}
