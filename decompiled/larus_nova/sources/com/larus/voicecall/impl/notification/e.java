package com.larus.voicecall.impl.notification;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.z2;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: loaded from: classes32.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MutableSharedFlow<Integer> f378408a = null;

    static {
        f378408a = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
    }

    public static PendingIntent a(String r100) {
        AppHost.Companion r101 = AppHost.f326268a;
        Application r102 = r101.getApplication();
        if (z2.f365865a.Z2() == false) goto L5;
        Class r103 = RealtimeCallRTCMicAndPlaybackService.class;
    L6:
        Intent r104 = new Intent(r102, r103);
        r104.setAction(r100);
        Application r105 = r101.getApplication();
        if (Build.VERSION.SDK_INT < 23) goto L9;
        int r106 = 201326592;
    L11:
        return PendingIntent.getService(r105, 101, r104, r106);
    L9:
        r106 = AMapEngineUtils.HALF_MAX_P20_WIDTH;
        goto L11
    L5:
        r103 = RTCService.class;
        goto L6
    }
}
