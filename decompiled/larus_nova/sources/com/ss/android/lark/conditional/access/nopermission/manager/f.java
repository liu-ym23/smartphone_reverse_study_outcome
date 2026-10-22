package com.ss.android.lark.conditional.access.nopermission.manager;

import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class f implements nzb.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f418174a = null;

    static {
        f418174a = new f();
    }

    public f() {
    }

    @Override // nzb.b
    public final void a(nzb.a r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        ScsLogger.d("SecurityPolicy_NoPermissionModuleManager", "maybeRestoreInterception: login event received, kick prober");
        com.ss.android.lark.conditional.access.nopermission.interception.b.f418092a.getClass();
        com.ss.android.lark.conditional.access.nopermission.interception.b.a();
    }
}
