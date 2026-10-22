package com.larus.office.minutes.impl.applet;

import com.larus.utils.logger.FLogger;
import com.ss.android.lark.officesdk.minutes.api.recording.common.depend.IOfficeSDKAuthorizeService;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: classes29.dex */
public final class b implements Function1<Boolean, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f362284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i<IOfficeSDKAuthorizeService.a> f362285b;

    public b(j r100) {
        this.f362284a = "android.permission.ACCESS_FINE_LOCATION";
        this.f362285b = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Boolean r100) {
        if (r100.booleanValue() == false) goto L5;
        FLogger.f375446a.i("MmAuthorizeServiceImpl", "authorizeSystemPermission: permission=" + this.f362284a + " granted");
        this.f362285b.resumeWith(Result.m9449constructorimpl(new IOfficeSDKAuthorizeService.a()));
    L7:
        return Unit.INSTANCE;
    L5:
        FLogger.f375446a.i("MmAuthorizeServiceImpl", "authorizeSystemPermission: permission=" + this.f362284a + " denied");
        this.f362285b.resumeWith(Result.m9449constructorimpl(new IOfficeSDKAuthorizeService.a(false, "system_permission_denied")));
        goto L7
    }
}
