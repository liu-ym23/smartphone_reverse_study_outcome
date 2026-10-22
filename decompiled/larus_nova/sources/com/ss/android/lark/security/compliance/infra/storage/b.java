package com.ss.android.lark.security.compliance.infra.storage;

import com.ss.android.lark.diskmanage.Biz;
import ebb.g;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Singleton
public final class b implements g {
    @Inject
    public b() {
    }

    @Override // ebb.g
    public final void b() {
    }

    @Override // ebb.g
    public final Biz getBiz() {
        return Biz.SECURITY_AND_COMPLIANCE;
    }

    @Override // ebb.g
    public final cbb.a a(cbb.d r100) {
        Intrinsics.checkNotNullParameter(r100, "remoteConfig");
        return new cbb.a(false, 0, 7);
    }
}
