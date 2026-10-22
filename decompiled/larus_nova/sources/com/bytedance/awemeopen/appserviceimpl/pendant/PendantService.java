package com.bytedance.awemeopen.appserviceimpl.pendant;

import c34.a;
import com.bytedance.awemeopen.domain.pendant.PendantDomain;
import com.bytedance.awemeopen.pendant.serviceapi.AoPendantService;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes44.dex */
public final class PendantService implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f198139a;

    @Override // k24.a
    public final void x0() {
    }

    @Override // c34.a
    public final void i() {
        AoPendantService r100 = (AoPendantService) ((PendantDomain) this.f198139a.getValue()).f198430a.getValue();
        if (r100 == null) goto L6;
        r100.i();
        return;
    }

    public PendantService() {
        this.f198139a = LazyKt.lazy(PendantService$pendantDomain$2.INSTANCE);
    }
}
