package com.larus.disk.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/disk/api/ManualCacheCleanStatus;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "PARTIAL", "TASK_RUNNING", "DISABLED", "FAILED", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ManualCacheCleanStatus extends Enum<ManualCacheCleanStatus> {
    public static final ManualCacheCleanStatus DISABLED = null;
    public static final ManualCacheCleanStatus FAILED = null;
    public static final ManualCacheCleanStatus PARTIAL = null;
    public static final ManualCacheCleanStatus SUCCESS = null;
    public static final ManualCacheCleanStatus TASK_RUNNING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ManualCacheCleanStatus[] f330517a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f330518b = null;

    public static EnumEntries<ManualCacheCleanStatus> getEntries() {
        return f330518b;
    }

    static {
        ManualCacheCleanStatus r100 = new ManualCacheCleanStatus("SUCCESS", 0);
        SUCCESS = r100;
        ManualCacheCleanStatus r101 = new ManualCacheCleanStatus("PARTIAL", 1);
        PARTIAL = r101;
        ManualCacheCleanStatus r102 = new ManualCacheCleanStatus("TASK_RUNNING", 2);
        TASK_RUNNING = r102;
        ManualCacheCleanStatus r103 = new ManualCacheCleanStatus("DISABLED", 3);
        DISABLED = r103;
        ManualCacheCleanStatus r104 = new ManualCacheCleanStatus("FAILED", 4);
        FAILED = r104;
        ManualCacheCleanStatus[] r105 = {r100, r101, r102, r103, r104};
        f330517a = r105;
        f330518b = EnumEntriesKt.enumEntries(r105);
    }

    public static ManualCacheCleanStatus[] values() {
        return (ManualCacheCleanStatus[]) f330517a.clone();
    }

    public static ManualCacheCleanStatus valueOf(String r100) {
        return (ManualCacheCleanStatus) r27.a.a(ManualCacheCleanStatus.class, r100);
    }

    public ManualCacheCleanStatus(String r100, int r101) {
        super(r100, r101);
    }
}
