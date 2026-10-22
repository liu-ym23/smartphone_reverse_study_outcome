package com.ss.android.lark.security.compliance.infra.network.userscpoe;

import com.ss.android.lark.utils.LarkContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements com.ss.android.lark.security.compliance.infra.network.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y4c.a f440458a;

    public b() {
        this.f440458a = (y4c.a) LarkContext.spiByDwarf(y4c.a.class);
    }

    @Override // com.ss.android.lark.security.compliance.infra.network.f
    public final void a(com.ss.android.lark.security.compliance.infra.network.g r100, com.ss.android.lark.security.compliance.infra.network.e r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "callback");
        new g(this.f440458a.g()).a(r100, r101);
    }
}
