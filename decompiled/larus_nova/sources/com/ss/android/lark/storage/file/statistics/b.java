package com.ss.android.lark.storage.file.statistics;

import com.ss.android.lark.storage.monitor.MonitorEvent;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b extends MonitorEvent {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f441029d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f441030e;

    @Override // com.ss.android.lark.storage.monitor.MonitorEvent
    public final boolean b() {
        if (this.f441029d.length() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ss.android.lark.storage.monitor.MonitorEvent
    public final Map<String, Object> c() {
        Map<String, Object> r100 = super.c();
        HashMap r101 = (HashMap) r100;
        r101.put("error_type", this.f441029d);
        r101.put("file_dir", this.f441030e);
        return r100;
    }

    public b(String r100) {
        Intrinsics.checkNotNullParameter("fs_not_found", "errorType");
        Intrinsics.checkNotNullParameter(r100, "fileDir");
        super("infra_unistore_file_error_dev", -1);
        this.f441029d = "fs_not_found";
        this.f441030e = r100;
    }
}
