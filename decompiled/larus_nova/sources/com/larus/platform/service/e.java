package com.larus.platform.service;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.platform.IFlowSdkDepend;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes31.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f365730a = 0;

    static {
    }

    public static void a(final String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L10:
        if (r101 == false) goto L14;
        FLogger.f375446a.i("AigcMetadataCheckHelper", "skip empty filePath");
        return;
    L14:
        if (new PolarisFileWrapper(r100).exists() == true) goto L31;
        FLogger.f375446a.i("AigcMetadataCheckHelper", "skip non-existing file, path=" + r100);
        return;
    L31:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L25
        IFlowSdkDepend r103 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);     // Catch: Throwable -> L25
        if (r103 == null) goto L22;
        r103.D0();     // Catch: Throwable -> L25
        com.larus.home.impl.sdk.b1.f346144a.a(r100, new d(r100));     // Catch: Throwable -> L25
    L23:
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L25
    L27:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L33;
        FLogger.f375446a.e("AigcMetadataCheckHelper", "checkAndFix failed to start, path=" + r100, r105);
        return;
    L33:
        return;
    L22:
        FLogger.f375446a.i("AigcMetadataCheckHelper", "metadata check service is null, path=" + r100);     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L27
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L10
    }

    public static void b(String r100) {
        boolean r101 = false;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L10:
        if (r102 == false) goto L14;
        FLogger.f375446a.i("AigcMetadataCheckHelper", "skip empty filePath");
        return;
    L14:
        if (new PolarisFileWrapper(r100).exists() == true) goto L35;
        FLogger.f375446a.i("AigcMetadataCheckHelper", "skip non-existing file, path=" + r100);
        return;
    L35:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L25
        IFlowSdkDepend r104 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);     // Catch: Throwable -> L25
        if (r104 == null) goto L22;
        r104.D0();     // Catch: Throwable -> L25
        r101 = com.larus.home.impl.sdk.b1.f346144a.b(r100);     // Catch: Throwable -> L25
        FLogger.f375446a.i("AigcMetadataCheckHelper", "checkAndFix sync finish, success=" + r101 + ", path=" + r100);     // Catch: Throwable -> L25
    L23:
        Object r105 = Result.m9449constructorimpl(Boolean.valueOf(r101));     // Catch: Throwable -> L25
    L27:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L30;
        FLogger.f375446a.e("AigcMetadataCheckHelper", "checkAndFix sync failed, path=" + r100, r106);
    L30:
        Boolean r107 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r105) == false) goto L33;
        r105 = r107;
    L33:
        ((Boolean) r105).booleanValue();
        return;
    L22:
        FLogger.f375446a.i("AigcMetadataCheckHelper", "metadata check service is null, path=" + r100);     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L27
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L10
    }
}
