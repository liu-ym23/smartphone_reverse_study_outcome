package com.larus.im.internal.tracking.network;

import androidx.core.app.NotificationCompat;
import com.larus.im.internal.delegate.d1;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f350340a = null;

    static {
        f350340a = new b();
    }

    public b() {
    }

    @Override // com.larus.im.internal.tracking.network.v
    public final void a(c r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        d1 r101 = d1.f348206b;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ouc.e0 r102 = new ouc.e0();
        ouc.j.c(r102, "path", r100.f350341a);
        ouc.j.c(r102, NotificationCompat.CATEGORY_TRANSPORT, r100.f350342b);
        ouc.j.b(r102, MonitorConstants.NET_CONNECTED, Long.valueOf(r100.f350343c));
        ouc.j.c(r102, "log_id", r100.f350344d);
        ouc.j.b(r102, "status_code", Long.valueOf(r100.f350345e));
        ouc.j.b(r102, "error_code", Long.valueOf(r100.f350346f));
        ouc.j.b(r102, "net_total", Long.valueOf(r100.f350347g));
        ouc.j.b(r102, "req_total", Long.valueOf(r100.f350348h));
        ouc.j.b(r102, "req_connect", Long.valueOf(r100.f350349i));
        ouc.j.b(r102, "req_dns", Long.valueOf(r100.f350350j));
        ouc.j.b(r102, "req_send", Long.valueOf(r100.f350351k));
        ouc.j.b(r102, "req_wait", Long.valueOf(r100.f350352l));
        ouc.j.b(r102, "req_receive", Long.valueOf(r100.f350353m));
        ouc.j.b(r102, "req_body_bytes", Long.valueOf(r100.f350354n));
        ouc.j.b(r102, "resp_body_bytes", Long.valueOf(r100.f350355o));
        ouc.j.b(r102, "cold_start_offset_ms", Long.valueOf(r100.f350356p));
        ouc.j.a(r102, "is_cold_start_request", Boolean.valueOf(r100.f350357q));
        r101.a("flow_network_request_performance", r102.a());
    }
}
