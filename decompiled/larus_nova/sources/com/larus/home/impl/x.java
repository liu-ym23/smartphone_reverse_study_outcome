package com.larus.home.impl;

import android.content.Intent;
import android.net.Uri;
import android.os.SystemClock;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.larus.commercemembership.api.ICommerceMembershipService;
import com.larus.common.apphost.AppHost;
import com.larus.common.mssdk.api.ISecPrivacyService;
import com.larus.reach.api.ReachService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes29.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f346385a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f346386b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f346387c;

    static {
        f346385a = new Object();
    }

    public static void a(Intent r110, String r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r111, "from");
        if (AppHost.f326268a.isOversea() == false) goto L5;
        return;
    L5:
        ISecPrivacyService.f326368a.getClass();
        ISecPrivacyService r100 = ISecPrivacyService.a.a();
        boolean r101 = false;
        if (r100 != null) goto L8;
    L10:
        boolean r102 = false;
    L11:
        if (r102 == true) goto L13;
        return;
    L13:
        if (r110 == null) goto L63;
        Uri r103 = r110.getData();
        if (r103 != null) goto L18;
        return;
    L18:
        if (Intrinsics.areEqual(r110.getAction(), CommonConstant.ACTION.HWID_SCHEME_URL) == true) goto L20;
        return;
    L20:
        String r113 = UriProtector.getQueryParameter(r103, "pc_activity");
        if (r113 != null) goto L23;
    L26:
        boolean r104 = true;
    L27:
        if (r104 == false) goto L29;
        return;
    L29:
        String r105 = r103.getScheme() + '|' + r103.getAuthority() + '|' + r103.getPath() + '|' + r113;
        long r106 = SystemClock.elapsedRealtime();
        Object r107 = f346385a;
        monitor-enter(r107);
    L60:
        th = move-exception;
        throw th;
    L32:
        if (Intrinsics.areEqual(r105, f346386b) == true) goto L35;
    L38:
        f346386b = r105;     // Catch: Throwable -> L60
        f346387c = r106;     // Catch: Throwable -> L60
        monitor-exit(r107);
        boolean r108 = false;
    L41:
        if (r108 == false) goto L44;
        FLogger.f375446a.i("PcActivitySchemaPull", "skip duplicated trigger from=" + r111 + " key=" + r105);
        return;
    L44:
        FLogger.f375446a.i("PcActivitySchemaPull", "trigger pull from=" + r111 + " pcActivity=" + r113 + " uri=" + r103);
        ReachService r114 = (ReachService) ServiceManager.get().getService(ReachService.class);
        if (r114 != null) goto L47;
    L49:
        if (r101 == false) goto L54;
        ICommerceMembershipService.f325827a.getClass();
        ICommerceMembershipService r115 = ICommerceMembershipService.a.a();
        if (r115 == null) goto L66;
        r115.k();
        return;
    L66:
        return;
    L54:
        if (r112 == true) goto L56;
        return;
    L56:
        ICommerceMembershipService.f325827a.getClass();
        ICommerceMembershipService r116 = ICommerceMembershipService.a.a();
        if (r116 == null) goto L67;
        r116.d(r113);
        return;
    L67:
        return;
    L47:
        if (r114.g() != true) goto L49;
        r101 = true;
        goto L49
    L35:
        if ((r106 - f346387c) >= 5000) goto L38;
        monitor-exit(r107);
        r108 = true;
        goto L41
    L23:
        if (StringsKt.isBlank(r113) == true) goto L26;
        r104 = false;
        goto L27
    L63:
        return;
    L8:
        if (r100.h() != true) goto L10;
        r102 = true;
        goto L11
    }
}
