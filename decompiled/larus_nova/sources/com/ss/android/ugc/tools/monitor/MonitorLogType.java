package com.ss.android.ugc.tools.monitor;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/ugc/tools/monitor/MonitorLogType;", "", "", "logType", "Ljava/lang/String;", "getLogType", "()Ljava/lang/String;", "lib-runtime_release"}, k = 1, mv = {1, 4, 1})
public final enum MonitorLogType extends Enum<MonitorLogType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MonitorLogType[] f454832a = null;
    private final String logType;

    static {
        f454832a = new MonitorLogType[0];
    }

    public static MonitorLogType valueOf(String r100) {
        return (MonitorLogType) a.a(MonitorLogType.class, r100);
    }

    public static MonitorLogType[] values() {
        return (MonitorLogType[]) f454832a.clone();
    }

    public final String getLogType() {
        return this.logType;
    }
}
