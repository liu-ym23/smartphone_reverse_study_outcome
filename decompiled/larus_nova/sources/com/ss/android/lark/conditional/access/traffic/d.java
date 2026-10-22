package com.ss.android.lark.conditional.access.traffic;

import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.sdk.g;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class d implements g.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f418435a;

    public d(a r100) {
        this.f418435a = r100;
    }

    @Override // com.ss.android.lark.sdk.g.b
    public final void a(byte[] r100) {
        if (Intrinsics.areEqual(qqb.a.d(), "") == true) goto L5;
        String r101 = qqb.a.d();
    L6:
        int r102 = ScsLogger.f440428a;
        ScsLogger.a("SecurityPolicy_GlobalScopeRegulateNetworkTrafficPush", "doListen, callback request:" + r100 + ", sid:, fromServerPipe:false, offlinePush:false");
        CoreThreadPool.getSerialTaskHandler().post(new c(r101, this.f418435a, r100));
        return;
    L5:
        r101 = qqb.a.i(qqb.a.e());
        goto L6
    }
}
