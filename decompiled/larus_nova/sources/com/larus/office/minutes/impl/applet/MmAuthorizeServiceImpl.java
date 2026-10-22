package com.larus.office.minutes.impl.applet;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.permission.AppletAuthorizeHelper;
import com.bytedance.ai.applet.permission.AppletSettingHelper;
import com.bytedance.ai.applet.permission.f;
import com.bytedance.ai.applet.permission.g;
import com.larus.platform.service.i2;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.officesdk.minutes.api.recording.common.depend.IOfficeSDKAuthorizeService;
import com.ss.android.lark.utils.LarkContext;
import java.util.List;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: classes29.dex */
public final class MmAuthorizeServiceImpl implements IOfficeSDKAuthorizeService {

    public static final class a {
    }

    static {
    }

    public MmAuthorizeServiceImpl() {
    }

    @Override // com.ss.android.lark.officesdk.minutes.api.recording.common.depend.IOfficeSDKAuthorizeService
    public final boolean Q0() {
        Intrinsics.checkNotNullParameter("android.permission.ACCESS_FINE_LOCATION", "permission");
        if (ContextCompat.checkSelfPermission(LarkContext.getApplication(), "android.permission.ACCESS_FINE_LOCATION") != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ss.android.lark.officesdk.minutes.api.recording.common.depend.IOfficeSDKAuthorizeService
    public final Object S1(IOfficeSDKAuthorizeService.Scope r100, Continuation<? super Boolean> r101) {
        if ((r101 instanceof MmAuthorizeServiceImpl$queryAppletPermission$1) == false) goto L7;
        MmAuthorizeServiceImpl$queryAppletPermission$1 r102 = (MmAuthorizeServiceImpl$queryAppletPermission$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        boolean r107 = false;
        if (r106 == 0) goto L16;
        if (r106 != 1) goto L15;
        r100 = (IOfficeSDKAuthorizeService.Scope) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Exception -> L27
    L23:
        g r108 = (g) r104;     // Catch: Exception -> L27
        FLogger.f375446a.i("MmAuthorizeServiceImpl", "queryAppletPermission: scope=" + r100.getValue() + ", reason=" + r108.f34950a + ", authSetting=" + r108.f34951b);     // Catch: Exception -> L27
        Boolean r109 = r108.f34951b.get(r100.getValue());     // Catch: Exception -> L27
        if (r109 == null) goto L30;
        r107 = r109.booleanValue();     // Catch: Exception -> L27
    L30:
        return Boxing.boxBoolean(r107);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r104);
        List<String> r110 = MmRecordingAppletApplication.f362280q;
        AppletApplication r111 = MmRecordingAppletApplication.a.a();
        if (r111 != null) goto L20;
        FLogger.f375446a.e("MmAuthorizeServiceImpl", "queryAppletPermission: active installedApp not found");
        return Boxing.boxBoolean(false);
    L20:
        AppletSettingHelper r112 = (AppletSettingHelper) r111.h().f34402f.getValue();     // Catch: Exception -> L27
        r102.L$0 = r100;     // Catch: Exception -> L27
        r102.label = 1;     // Catch: Exception -> L27
        int r113 = AppletSettingHelper.f34925b;     // Catch: Exception -> L27
        r104 = r112.c(null, r102);     // Catch: Exception -> L27
        if (r104 != r105) goto L23;
        return r105;
    L27:
        e = move-exception;
        FLogger.f375446a.e("MmAuthorizeServiceImpl", "queryAppletPermission: exception=" + e.getMessage());
    L7:
        r102 = new MmAuthorizeServiceImpl$queryAppletPermission$1(this, r101);
        goto L8
    }

    @Override // com.ss.android.lark.officesdk.minutes.api.recording.common.depend.IOfficeSDKAuthorizeService
    public final Object c1(IOfficeSDKAuthorizeService.Scope r110, Continuation<? super IOfficeSDKAuthorizeService.a> r111) {
        if ((r111 instanceof MmAuthorizeServiceImpl$authorizeAppletPermission$1) == false) goto L7;
        MmAuthorizeServiceImpl$authorizeAppletPermission$1 r100 = (MmAuthorizeServiceImpl$authorizeAppletPermission$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        MmAuthorizeServiceImpl$authorizeAppletPermission$1 r102 = r100;
        Object r112 = r102.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        if (r104 == 0) goto L16;
        if (r104 != 1) goto L15;
        r110 = (IOfficeSDKAuthorizeService.Scope) r102.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: Exception -> L25
    L23:
        f r113 = (f) r112;     // Catch: Exception -> L25
        FLogger.f375446a.i("MmAuthorizeServiceImpl", "authorizeAppletPermission: scope=" + r110.getValue() + ", success=" + r113.f34946a);     // Catch: Exception -> L25
        return new IOfficeSDKAuthorizeService.a(r113.f34946a, r113.f34947b);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r112);
        List<String> r114 = MmRecordingAppletApplication.f362280q;
        AppletApplication r115 = MmRecordingAppletApplication.a.a();
        if (r115 != null) goto L20;
        FLogger.f375446a.e("MmAuthorizeServiceImpl", "authorizeAppletPermission: active installedApp not found");
        return new IOfficeSDKAuthorizeService.a(false, "AppletApplication not found");
    L20:
        AppletAuthorizeHelper r105 = r115.h().a();     // Catch: Exception -> L25
        String r116 = r110.getValue();     // Catch: Exception -> L25
        r102.L$0 = r110;     // Catch: Exception -> L25
        r102.label = 1;     // Catch: Exception -> L25
        r112 = AppletAuthorizeHelper.e(r105, r116, false, null, null, null, r102, 30);     // Catch: Exception -> L25
        if (r112 != r103) goto L23;
        return r103;
    L25:
        e = move-exception;
        FLogger.f375446a.e("MmAuthorizeServiceImpl", "authorizeAppletPermission: exception=" + e.getMessage());
        return new IOfficeSDKAuthorizeService.a(false, e.getMessage());
    L7:
        r100 = new MmAuthorizeServiceImpl$authorizeAppletPermission$1(this, r111);
        goto L8
    }

    @Override // com.ss.android.lark.officesdk.minutes.api.recording.common.depend.IOfficeSDKAuthorizeService
    public final Object e0(FragmentActivity r100, Continuation r101) {
        if (Q0() == false) goto L6;
        FLogger.f375446a.i("MmAuthorizeServiceImpl", "authorizeSystemPermission: permission=android.permission.ACCESS_FINE_LOCATION already granted");
        return new IOfficeSDKAuthorizeService.a();
    L6:
        if (r100 != null) goto L11;
        List<String> r102 = MmRecordingAppletApplication.f362280q;
        AppletApplication r103 = MmRecordingAppletApplication.a.a();
        if (r103 == null) goto L10;
        r100 = r103.f34085d;
        goto L11
    L10:
        r100 = null;
    L11:
        if (r100 != null) goto L14;
        FLogger.f375446a.e("MmAuthorizeServiceImpl", "authorizeSystemPermission: activity is null");
        return new IOfficeSDKAuthorizeService.a(false, "activity is null");
    L14:
        j r104 = new j(IntrinsicsKt.intercepted(r101), 1);
        r104.C();
        i2.f365748b.a(r100, CollectionsKt.listOf("android.permission.ACCESS_FINE_LOCATION"), new b(r104));
        Object r105 = r104.B();
        if (r105 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L17;
        DebugProbesKt.probeCoroutineSuspended(r101);
    L17:
        return r105;
    }
}
