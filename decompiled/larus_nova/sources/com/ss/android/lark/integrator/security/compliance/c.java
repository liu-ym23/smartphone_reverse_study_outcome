package com.ss.android.lark.integrator.security.compliance;

import com.ss.android.lark.officesdk.api.service.capacity.IOfficeAppBaseInfo;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes36.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f428061a = null;

    static {
        f428061a = new c();
    }

    public c() {
    }

    public static boolean a() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L10
        IOfficeAppBaseInfo r101 = (IOfficeAppBaseInfo) OfficeSDKManager.getHostGlobalService(IOfficeAppBaseInfo.class);     // Catch: Throwable -> L10
        if (r101 == null) goto L7;
        boolean r102 = true;
        if (r101.isEnterpriseAccount() != true) goto L7;
    L8:
        Object r103 = Result.m9449constructorimpl(Boolean.valueOf(r102));     // Catch: Throwable -> L10
    L12:
        Boolean r104 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r103) == false) goto L16;
        r103 = r104;
    L16:
        return ((Boolean) r103).booleanValue();
    L7:
        r102 = false;
    L10:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }
}
