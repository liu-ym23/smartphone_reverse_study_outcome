package com.bytedance.kmp.ec.yata.common.perf;

import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class e extends AbsPerfMonitor {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f251492h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f251493i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f251494j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Boolean f251495k;

    @Override // com.bytedance.kmp.ec.yata.common.perf.AbsPerfMonitor
    public final Map<String, Object> b() {
        Pair[] r100 = new Pair[4];
        r100[0] = TuplesKt.to("node_name", this.f251492h);
        r100[1] = TuplesKt.to("trigger_type", this.f251493i);
        r100[2] = TuplesKt.to("operator_type", this.f251494j);
        if (Intrinsics.areEqual(this.f251495k, Boolean.FALSE) == false) goto L5;
        String r101 = "0";
    L6:
        r100[3] = TuplesKt.to("net_request_status", r101);
        return MapsKt.mapOf(r100);
    L5:
        r101 = "1";
        goto L6
    }

    @Override // com.bytedance.kmp.ec.yata.common.perf.AbsPerfMonitor
    public final String a() {
        return "YataPerfMonitor_Uplink_" + hashCode();
    }

    public e(long r100) {
        super(r100, PerfTriggerSource.UPLINK);
    }
}
