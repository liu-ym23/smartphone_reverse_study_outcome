package com.ss.android.lark.storage.kv.statistics;

import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class d extends c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f441088d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f441089e;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.storage.monitor.MonitorEvent
    public final Map<String, Object> c() {
        Map<String, Object> r100 = super.c();
        HashMap r101 = (HashMap) r100;
        r101.put("type", this.f441088d);
        r101.put("target_event", this.f441089e);
        return r100;
    }

    public d(String r100) {
        Intrinsics.checkNotNullParameter("file", "type");
        Intrinsics.checkNotNullParameter(r100, "targetEvent");
        int r101 = b.f441087a;
        this.f441088d = "file";
        this.f441089e = r100;
    }
}
