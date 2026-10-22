package com.larus.home.impl;

import android.content.Intent;
import com.larus.common.apphost.AppHost;
import com.larus.common.mssdk.api.ISecPrivacyService;
import com.larus.deeplink.api.IDeeplinkService;
import com.larus.platform.api.ExternalRouteEntry;
import com.larus.reach.api.ReachService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f344162a = 0;

    static {
    }

    public static void a(Intent r100, ExternalRouteEntry r101) {
        Intrinsics.checkNotNullParameter(r100, "intent");
        Intrinsics.checkNotNullParameter(r101, "entry");
        com.larus.platform.api.q r102 = null;
        ISecPrivacyService.f326368a.getClass();     // Catch: Exception -> L5 CancellationException -> L44
        ISecPrivacyService r103 = ISecPrivacyService.a.a();     // Catch: Exception -> L5 CancellationException -> L44
    L7:
        if (r103 != null) goto L46;
        FLogger.f375446a.w("ExternalRoute", "skip external route sidecar, reason=privacy_service_unavailable");
        return;
    L46:
        Boolean r104 = Boolean.valueOf(r103.h());     // Catch: Exception -> L12 CancellationException -> L42
    L14:
        if (r104 != null) goto L16;
        return;
    L16:
        if (r104.booleanValue() == true) goto L50;
        FLogger.f375446a.i("ExternalRoute", "skip external route sidecar, reason=privacy_not_agreed");
        return;
    L50:
        IDeeplinkService r105 = (IDeeplinkService) ServiceManager.get().getService(IDeeplinkService.class);     // Catch: Exception -> L23 CancellationException -> L39
        if (r105 == null) goto L25;
        r102 = r105.h(r100, r101);     // Catch: Exception -> L23 CancellationException -> L39
    L25:
        if (r102 != null) goto L28;
        return;
    L28:
        if (AppHost.f326268a.isOversea() == false) goto L48;
        return;
    L48:
        ReachService r106 = (ReachService) ServiceManager.get().getService(ReachService.class);     // Catch: Exception -> L34 CancellationException -> L37
        if (r106 == null) goto L54;
        r106.b(r102);     // Catch: Exception -> L34 CancellationException -> L37
        Unit r107 = Unit.INSTANCE;     // Catch: Exception -> L34 CancellationException -> L37
    L55:
        return;
    L54:
        return;
    L37:
        e = move-exception;
        throw e;
    L34:
        e = move-exception;
        FLogger.f375446a.e("ExternalRoute", "external route sidecar failed, stage=notify_reach", e);
        return;
    L39:
        e = move-exception;
        throw e;
    L23:
        e = move-exception;
        FLogger.f375446a.e("ExternalRoute", "external route sidecar failed, stage=start_session", e);
        goto L25
    L42:
        e = move-exception;
        throw e;
    L12:
        e = move-exception;
        FLogger.f375446a.e("ExternalRoute", "external route sidecar failed, stage=privacy_check", e);
        r104 = null;
        goto L14
    L44:
        e = move-exception;
        throw e;
    L5:
        e = move-exception;
        FLogger.f375446a.e("ExternalRoute", "external route sidecar failed, stage=privacy_service", e);
        r103 = null;
        goto L7
    }
}
