package com.ss.android.lark.integrator.security.compliance;

import android.app.Activity;
import android.content.Context;
import com.ss.android.lark.conditional.access.nopermission.ui.NoPermissionActivity;
import com.ss.android.lark.conditional.access.nopermission.ui.u;
import com.ss.android.lark.conditional.access.nopermission.viewmodel.NoPermissionViewModel;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.passport.signinsdk_api.base.policy.PolicyAgreement;
import com.ss.android.lark.passport_api.IPassportApi;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes36.dex */
public final class ConditionalAccessModuleDependency$passportDependency$1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ConditionalAccessModuleDependency f428044a;

    public final void b(Context r100, String r101, NoPermissionViewModel.C117971 r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter("scs-mfa-verify", "scope");
        Intrinsics.checkNotNullParameter(r101, "scopeVerifyToken");
        Intrinsics.checkNotNullParameter(r102, "callback");
    }

    public final void c(PolicyAgreement r100) {
        Intrinsics.checkNotNullParameter(r100, "policyAgreement");
    }

    public final void i(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter("scs-mfa-verify", "scope");
        Intrinsics.checkNotNullParameter(r101, "scopeVerifyToken");
    }

    public ConditionalAccessModuleDependency$passportDependency$1(ConditionalAccessModuleDependency r100) {
        this.f428044a = r100;
    }

    public final boolean d(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L11
        IPassportApi r102 = (IPassportApi) ApiUtils.getApi(IPassportApi.class);     // Catch: Throwable -> L11
        if (r102 != null) goto L6;
    L8:
        boolean r103 = false;
    L9:
        Object r104 = Result.m9449constructorimpl(Boolean.valueOf(r103));     // Catch: Throwable -> L11
    L13:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L16;
        int r106 = ScsLogger.f440428a;
        ScsLogger.c("OfficeSDKCondAccessDep", "isPassportActivity by IPassportApi failed: " + ExceptionsKt.stackTraceToString(r105));
    L16:
        Boolean r107 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r104) == false) goto L20;
        r104 = r107;
    L20:
        if (((Boolean) r104).booleanValue() == false) goto L23;
        return true;
    L23:
        return StringsKt.startsWith$default(r100.getClass().getName(), "com.larus.login.", false, 2, null);
    L6:
        if (r102.isPassportActivity(r100) != true) goto L8;
        r103 = true;
    L11:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    public final void e(NoPermissionActivity r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        oyb.a r101 = (oyb.a) OfficeSDKManager.getHostGlobalService(oyb.a.class);
        if (r101 != null) goto L6;
        ScsLogger.c("OfficeSDKCondAccessDep", "jumpToSwitchUserListActivity failed, IFlowPassportService not found");
        return;
    L6:
        ScsLogger.d("OfficeSDKCondAccessDep", "jumpToSwitchUserListActivity");
        r101.q();
    }

    public final void g(mzb.a r100) {
        Intrinsics.checkNotNullParameter(r100, "onUserListChangeListener");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl((xzb.a) ApiUtils.getApi(xzb.a.class));     // Catch: Throwable -> L5
    L7:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L11;
        int r104 = ScsLogger.f440428a;
        ScsLogger.c("OfficeSDKCondAccessDep", "registerUserListChangeListener failed, get IPassportUserApi error: " + ExceptionsKt.stackTraceToString(r103));
    L11:
        if (Result.m9455isFailureimpl(r102) == false) goto L13;
        r102 = null;
    L13:
        xzb.a r105 = (xzb.a) r102;
        if (r105 != null) goto L17;
        ScsLogger.e("OfficeSDKCondAccessDep", "registerUserListChangeListener skipped, IPassportUserApi not found");
        return;
    L17:
        r105.registerUserListChangeListener(r100);
        return;
    L5:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public final void h(qzb.a r100) {
        Intrinsics.checkNotNullParameter(r100, "onUserSwitchListener");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl((IPassportApi) ApiUtils.getApi(IPassportApi.class));     // Catch: Throwable -> L5
    L7:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L11;
        int r104 = ScsLogger.f440428a;
        ScsLogger.c("OfficeSDKCondAccessDep", "registerUserSwitchListener failed, get IPassportApi error: " + ExceptionsKt.stackTraceToString(r103));
    L11:
        if (Result.m9455isFailureimpl(r102) == false) goto L13;
        r102 = null;
    L13:
        IPassportApi r105 = (IPassportApi) r102;
        if (r105 != null) goto L17;
        ScsLogger.e("OfficeSDKCondAccessDep", "registerUserSwitchListener skipped, IPassportApi not found");
        return;
    L17:
        r105.registerUserSwitchListener(r100);
        return;
    L5:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public final void j(mzb.a r100) {
        Intrinsics.checkNotNullParameter(r100, "onUserListChangeListener");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl((xzb.a) ApiUtils.getApi(xzb.a.class));     // Catch: Throwable -> L5
    L7:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L11;
        int r104 = ScsLogger.f440428a;
        ScsLogger.c("OfficeSDKCondAccessDep", "unregisterUserListChangeListener failed, get IPassportUserApi error: " + ExceptionsKt.stackTraceToString(r103));
    L11:
        if (Result.m9455isFailureimpl(r102) == false) goto L13;
        r102 = null;
    L13:
        xzb.a r105 = (xzb.a) r102;
        if (r105 != null) goto L17;
        ScsLogger.e("OfficeSDKCondAccessDep", "unregisterUserListChangeListener skipped, IPassportUserApi not found");
        return;
    L17:
        r105.unregisterUserListChangeListener(r100);
        return;
    L5:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public final void k(qzb.a r100) {
        Intrinsics.checkNotNullParameter(r100, "onUserSwitchListener");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl((IPassportApi) ApiUtils.getApi(IPassportApi.class));     // Catch: Throwable -> L5
    L7:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L11;
        int r104 = ScsLogger.f440428a;
        ScsLogger.c("OfficeSDKCondAccessDep", "unregisterUserSwitchListener failed, get IPassportApi error: " + ExceptionsKt.stackTraceToString(r103));
    L11:
        if (Result.m9455isFailureimpl(r102) == false) goto L13;
        r102 = null;
    L13:
        IPassportApi r105 = (IPassportApi) r102;
        if (r105 != null) goto L17;
        ScsLogger.e("OfficeSDKCondAccessDep", "unregisterUserSwitchListener skipped, IPassportApi not found");
        return;
    L17:
        r105.unregisterUserSwitchListener(r100);
        return;
    L5:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public final void a(String r100, final k8b.d r101) {
        Intrinsics.checkNotNullParameter(r100, "challengeCode");
        Intrinsics.checkNotNullParameter(r101, "callback");
        oyb.a r102 = (oyb.a) OfficeSDKManager.getHostGlobalService(oyb.a.class);
        if (r102 != null) goto L6;
        ScsLogger.c("OfficeSDKCondAccessDep", "authorizeDeviceTokenClaimsChallenge failed, IFlowPassportService not found");
        r101.a(k8b.b.e.f502136a);
        return;
    L6:
        Map<String, String> r103 = MapsKt.mapOf(TuplesKt.to("cac_challenge_code", r100));
        final ConditionalAccessModuleDependency r104 = this.f428044a;
        r102.s1(r103, new ConditionalAccessModuleDependency$passportDependency$1$authorizeDeviceTokenClaimsChallenge$1(r101, r104));
    }

    public final void f(NoPermissionActivity r100, final u.a r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "callback");
        oyb.a r102 = (oyb.a) OfficeSDKManager.getHostGlobalService(oyb.a.class);
        if (r102 != null) goto L6;
        ScsLogger.c("OfficeSDKCondAccessDep", "logout failed, IFlowPassportService not found");
        r101.onError();
        return;
    L6:
        ScsLogger.d("OfficeSDKCondAccessDep", "logout");
        r102.R(new ConditionalAccessModuleDependency$passportDependency$1$logout$1(r101));
    }
}
