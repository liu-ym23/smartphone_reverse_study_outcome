package com.larus.platform.exp;

import com.larus.home.impl.sdk.o2;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import hq9.d2;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes31.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f365385a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile Boolean f365386b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile Boolean f365387c;

    static {
        f365385a = new i();
    }

    public i() {
    }

    public static Boolean b() {
        Object r100 = null;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L13
        IFlowSdkDepend r102 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);     // Catch: Throwable -> L13
        if (r102 == null) goto L10;
        o2 r103 = r102.x0();     // Catch: Throwable -> L13
        if (r103 == null) goto L10;
        d2 r104 = r103.getLarkDriveConfigV2();     // Catch: Throwable -> L13
        if (r104 == null) goto L10;
        Boolean r105 = Boolean.valueOf(r104.a());     // Catch: Throwable -> L13
    L11:
        Object r106 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L13
    L15:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L19;
        FLogger.f375446a.w("LarkOfficeExp", "readLarkDriveListEnabledOrNull failed", r107);
    L19:
        if (Result.m9455isFailureimpl(r106) == true) goto L23;
        r100 = r106;
    L23:
        return (Boolean) r100;
    L10:
        r105 = null;
    L13:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    public static Boolean c() {
        Object r100 = null;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L11
        IFlowSdkDepend r102 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);     // Catch: Throwable -> L11
        if (r102 == null) goto L8;
        o2 r103 = r102.x0();     // Catch: Throwable -> L11
        if (r103 == null) goto L8;
        Boolean r104 = Boolean.valueOf(r103.f4());     // Catch: Throwable -> L11
    L9:
        Object r105 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L11
    L13:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L17;
        FLogger.f375446a.w("LarkOfficeExp", "readOfficeMiniAppEnableOrNull failed", r106);
    L17:
        if (Result.m9455isFailureimpl(r105) == true) goto L21;
        r100 = r105;
    L21:
        return (Boolean) r100;
    L8:
        r104 = null;
    L11:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    public final boolean a() {
        AccountService r100 = AccountService.f365697a;
        boolean r101 = false;
        if (r100.isLogin().booleanValue() == true) goto L6;
        FLogger.f375446a.i("LarkOfficeExp", "isLarkDriveListEnabled account is not login, fallback=false without cache");
        return false;
    L6:
        Boolean r102 = f365387c;
        if (r102 == null) goto L10;
        boolean r103 = r102.booleanValue();
        FLogger.f375446a.i("LarkOfficeExp", "isLarkDriveListEnabled cached=" + r103);
        return r103;
    L10:
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L12:
        if (r100.isLogin().booleanValue() == true) goto L14;
        FLogger.f375446a.i("LarkOfficeExp", "isLarkDriveListEnabled account is not login after lock, fallback=false without cache");     // Catch: Throwable -> L23
    L21:
        monitor-exit(this);
        return r101;
    L14:
        Boolean r104 = f365387c;     // Catch: Throwable -> L23
        if (r104 == null) goto L17;
        r101 = r104.booleanValue();     // Catch: Throwable -> L23
        FLogger.f375446a.i("LarkOfficeExp", "isLarkDriveListEnabled cachedAfterLock=" + r101);     // Catch: Throwable -> L23
        goto L21
    L17:
        f365385a.getClass();     // Catch: Throwable -> L23
        Boolean r105 = b();     // Catch: Throwable -> L23
        if (r105 != null) goto L20;
        FLogger.f375446a.w("LarkOfficeExp", "isLarkDriveListEnabled settings service is not ready, fallback=false without cache");     // Catch: Throwable -> L23
        goto L21
    L20:
        f365387c = r105;     // Catch: Throwable -> L23
        FLogger.f375446a.i("LarkOfficeExp", "isLarkDriveListEnabled initSnapshot=" + r105);     // Catch: Throwable -> L23
        r101 = r105.booleanValue();     // Catch: Throwable -> L23
        goto L21
    }
}
