package com.bytedance.awemeopen.infra.base.npth;

import com.bytedance.awemeopen.infra.base.env.AoEnv;
import com.bytedance.awemeopen.infra.base.event.b;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.awemeopen.infra.base.task.AoPool;
import com.bytedance.awemeopen.servicesapi.monitor.AoEnsureService;
import com.bytedance.awemeopen.servicesapi.npth.AoNpthService;
import com.bytedance.bdp.bdpbase.service.IBdpService;
import com.lynx.tasm.LynxError;
import j64.a;
import java.util.HashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class AoExceptionReporter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AoNpthService f198706a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AoEnsureService f198707b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f198708c = null;

    public AoExceptionReporter() {
    }

    static {
        IBdpService r100 = a.a(AoNpthService.class);
        Intrinsics.checkNotNull(r100);
        f198706a = (AoNpthService) r100;
        IBdpService r101 = a.a(AoEnsureService.class);
        Intrinsics.checkNotNull(r101);
        f198707b = (AoEnsureService) r101;
        f198708c = "aosdk";
    }

    public static void a(ErrorPriority r110, String r111, String r112, String r113, final Throwable r114) {
        Intrinsics.checkNotNullParameter(r110, "priority");
        Intrinsics.checkNotNullParameter(r111, "type");
        Intrinsics.checkNotNullParameter(r112, "sign");
        Intrinsics.checkNotNullParameter(r113, "errInfo");
        Intrinsics.checkNotNullParameter(r114, LynxError.LYNX_THROWABLE);
        HashMap r100 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("priority", String.valueOf(r110.getPriorityNum())), TuplesKt.to("type", r111), TuplesKt.to("sign", r112), TuplesKt.to("errInfo", r113)});
        f198707b.ensureNotReachHere(r114, f198708c + '_' + r110.name() + '_' + r111 + '_' + r112, r100);
        int r101 = r110.getPriorityNum();
        if (r113.length() <= 300) goto L5;
        r113 = r113.substring(0, 300);
    L5:
        b.C2872b r102 = b.a("ao_special_error");
        r102.d("priority", Integer.valueOf(r101));
        r102.d("type", r111);
        r102.d("sign", r112);
        r102.d("err_info", r113);
        r102.d(LynxError.LYNX_THROWABLE, r114);
        r102.a().b();
        final String r115 = r100.toString();
        AoLogger.c("AoExceptionReporter", new Object[]{"reportCustomException: data:" + r115 + ",exception: " + r114});
        if (AoEnv.i() == true) goto L8;
        return;
    L8:
        if (r110 != ErrorPriority.f198710p0) goto L12;
        final long r116 = 3000;
        AoPool.e(new AoExceptionReporter$reportCustomException$1(r116, r115, r114), 3000);
        return;
    }

    public static /* synthetic */ void b(ErrorPriority r100, String r101, String r102, String r103, int r104) {
        if ((r104 & 4) == 0) goto L6;
        r102 = "";
    L6:
        if ((r104 & 16) == 0) goto L8;
        Throwable r105 = new Throwable();
    L9:
        a(r100, r101, r102, r103, r105);
        return;
    L8:
        r105 = null;
        goto L9
    }
}
