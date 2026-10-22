package com.bytedance.kmp.ec.yata.common.perf;

import com.bytedance.kmp.ec.yata.common.platform.h;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class d extends AbsPerfMonitor {
    @Override // com.bytedance.kmp.ec.yata.common.perf.AbsPerfMonitor
    public final String a() {
        return "YataPerfMonitor_Refresh_" + hashCode();
    }

    public final void g() {
        AbsPerfMonitor.c(this, c.f251475c);
    }

    public final void h() {
        AbsPerfMonitor.d(this, c.f251475c);
    }

    @Override // com.bytedance.kmp.ec.yata.common.perf.AbsPerfMonitor
    public final Map<String, Object> b() {
        return MapsKt.emptyMap();
    }

    public d(String r100) {
        int r101 = h.f251540a;
        long r102 = System.currentTimeMillis();
        Intrinsics.checkNotNullParameter(r100, "bizScene");
        super(r102, PerfTriggerSource.REFRESH);
        f(r100);
    }
}
