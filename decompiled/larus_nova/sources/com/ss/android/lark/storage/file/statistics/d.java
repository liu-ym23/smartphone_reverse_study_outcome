package com.ss.android.lark.storage.file.statistics;

import com.ss.android.lark.storage.monitor.MonitorEvent;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class d extends MonitorEvent {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f441033d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f441034e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f441035f;

    @Override // com.ss.android.lark.storage.monitor.MonitorEvent
    public final Map<String, Object> c() {
        Map<String, Object> r100 = super.c();
        if (this.f441035f == false) goto L5;
        String r101 = "read";
    L6:
        HashMap r102 = (HashMap) r100;
        r102.put("access_type", r101);
        r102.put("file_dir", this.f441033d);
        r102.put("file_size", Long.valueOf(this.f441034e));
        return r100;
    L5:
        r101 = "write";
        goto L6
    }

    public d(String r100, boolean r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "fileDir");
        super("infra_unistore_file_read_write_dev", r102);
        this.f441033d = r100;
        this.f441034e = -1;
        this.f441035f = r101;
    }
}
