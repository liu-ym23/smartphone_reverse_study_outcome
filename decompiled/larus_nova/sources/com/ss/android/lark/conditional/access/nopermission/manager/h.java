package com.ss.android.lark.conditional.access.nopermission.manager;

import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes35.dex */
public final class h implements ozb.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f418176a = null;

    static {
        f418176a = new h();
    }

    public h() {
    }

    @Override // ozb.c
    public final /* synthetic */ void a() {
    }

    @Override // ozb.c
    public final void b(ozb.a r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        ScsLogger.d("SecurityPolicy_NoPermissionModuleManager", "maybeRestoreInterception: logout, cancel prober");
        com.ss.android.lark.conditional.access.nopermission.interception.b.f418092a.getClass();
        Job r101 = com.ss.android.lark.conditional.access.nopermission.interception.b.f418093b;
        if (r101 == null) goto L5;
        ScsLogger.d("SecurityPolicy_InterceptionRestoreProber", "cancel: probeUserId=" + com.ss.android.lark.conditional.access.nopermission.interception.b.f418094c);
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
    L5:
        com.ss.android.lark.conditional.access.nopermission.interception.b.f418093b = null;
        com.ss.android.lark.conditional.access.nopermission.interception.b.f418094c = "";
    }
}
