package com.ss.android.lark.storage.kv.statistics;

import com.ss.android.lark.storage.monitor.MonitorEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public class c extends MonitorEvent {
    public c() {
        Intrinsics.checkNotNullParameter("infra_unistore_monitor_error_dev", "eventName");
        Intrinsics.checkNotNullParameter("", "repoName");
        super("infra_unistore_monitor_error_dev", -1);
    }
}
