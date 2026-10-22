package com.ss.android.lark.security.compliance.infra.network.userscpoe;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.security.compliance.infra.network.f f440461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<String, Boolean> f440462b;

    /* JADX WARN: Multi-variable type inference failed */
    public d(com.ss.android.lark.security.compliance.infra.network.f r100, Function1<? super String, Boolean> r101) {
        Intrinsics.checkNotNullParameter(r100, "mHttpFetcher");
        Intrinsics.checkNotNullParameter(r101, "switchOnPredicate");
        this.f440461a = r100;
        this.f440462b = r101;
    }

    public final <T> void a(com.ss.android.lark.security.compliance.infra.network.g r100, com.ss.android.lark.security.compliance.infra.network.d<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "callback");
        if (r100.getHost().length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L9;
        int r103 = v4c.a.f553226a;
        r100.c("https://" + jcb.b.c().a("security_and_compliance"));
    L9:
        if (this.f440462b.invoke("scs.scs_infra.sla").booleanValue() == false) goto L11;
        v4c.c.c(r100);
    L11:
        this.f440461a.a(r100, new c(r101, r100));
        return;
    L5:
        r102 = false;
        goto L6
    }
}
