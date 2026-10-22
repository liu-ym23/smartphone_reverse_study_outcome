package com.ss.lark.android.encryption.utils;

import com.alipay.sdk.m.p.e;
import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.bytedance.lark.rustclient.api.p;
import ikc.f;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class SCMonitorKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f456823a = null;

    static {
        f456823a = LazyKt.lazy(SCMonitorKt$isEnableMonitor$2.INSTANCE);
    }

    public static final void a(boolean r100, boolean r101, Exception r102) {
        Intrinsics.checkNotNullParameter(r102, "e");
        ikc.b r103 = f.f490295a.f490293b;
        Pair[] r104 = new Pair[5];
        r104[0] = TuplesKt.to("scene", "rust");
        if (r100 == false) goto L5;
        String r105 = "truncate";
    L6:
        r104[1] = TuplesKt.to("type", r105);
        r104[2] = TuplesKt.to(LBSLightLocationTraceLogger.ENCRYPT, Boolean.valueOf(r101));
        r104[3] = TuplesKt.to("error_code", -101);
        r104[4] = TuplesKt.to("error_msg", r102);
        ikc.a.a(r103, "scs_file_stream_encryption", MapsKt.mutableMapOf(r104), null, 0, 28);
        return;
    L5:
        r105 = "append";
        goto L6
    }

    public static final void b(MonitorStatus r100, RustMethod r101, Integer r110, p r111) {
        Intrinsics.checkNotNullParameter(r100, "status");
        Intrinsics.checkNotNullParameter(r101, e.f25671s);
        if (((Boolean) f456823a.getValue()).booleanValue() == true) goto L5;
        return;
    L5:
        ikc.b r102 = f.f490295a.f490293b;
        Pair[] r103 = new Pair[4];
        r103[0] = TuplesKt.to("status", Integer.valueOf(r100.getValue()));
        r103[1] = TuplesKt.to("event", r101.getValue());
        r103[2] = TuplesKt.to("error_code", r110);
        if (r111 == null) goto L8;
        String r104 = r111.c();
    L9:
        r103[3] = TuplesKt.to("error_msg", r104);
        ikc.a.a(r102, "scs_file_stream_sync_request", MapsKt.mutableMapOf(r103), null, 0, 28);
        return;
    L8:
        r104 = null;
        goto L9
    }

    public static /* synthetic */ void c(MonitorStatus r100, RustMethod r101, Integer r102, int r103) {
        if ((r103 & 4) == 0) goto L5;
        r102 = null;
    L5:
        b(r100, r101, r102, null);
    }
}
