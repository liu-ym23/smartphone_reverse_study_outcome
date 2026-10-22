package com.bytedance.awemeopen.infra.base.live;

import com.bytedance.awemeopen.servicesapi.context.AoHostService;
import com.bytedance.awemeopen.servicesapi.livepreview.AoLiveService;
import j64.a;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import n64.c;

/* JADX INFO: loaded from: classes46.dex */
public final class AoLive {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static AoLiveService f198644a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f198645b = null;

    static {
        f198645b = LazyKt.lazy(AoLive$hostService$2.INSTANCE);
    }

    public static boolean b() {
        if (f198644a != null) goto L5;
        f198644a = (AoLiveService) a.a(AoLiveService.class);
    L5:
        AoLiveService r100 = f198644a;
        if (r100 == null) goto L8;
        boolean r101 = r100.supportLive();
    L9:
        if (r101 == true) goto L13;
        AoHostService r102 = (AoHostService) f198645b.getValue();
        if (r102 == null) goto L13;
        r102.J1();
    L13:
        return r101;
    L8:
        r101 = false;
        goto L9
    }

    public static c a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "rawData");
        AoLiveService r101 = f198644a;
        if (r101 == null) goto L7;
        c r102 = r101.F0();
        if (r102 == null) goto L7;
        return r102;
    L7:
        return new c();
    }
}
