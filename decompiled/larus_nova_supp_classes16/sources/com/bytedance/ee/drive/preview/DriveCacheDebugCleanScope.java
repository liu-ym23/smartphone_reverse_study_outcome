package com.bytedance.ee.drive.preview;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/drive/preview/DriveCacheDebugCleanScope;", "", "<init>", "(Ljava/lang/String;I)V", "ALL", "CLEANABLE", "contentmanager-drive-export-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DriveCacheDebugCleanScope extends Enum<DriveCacheDebugCleanScope> {
    public static final DriveCacheDebugCleanScope ALL = null;
    public static final DriveCacheDebugCleanScope CLEANABLE = null;
    public static final /* synthetic */ DriveCacheDebugCleanScope[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DriveCacheDebugCleanScope> getEntries() {
        return b;
    }

    static {
        DriveCacheDebugCleanScope r0 = new DriveCacheDebugCleanScope("ALL", 0);
        ALL = r0;
        DriveCacheDebugCleanScope r1 = new DriveCacheDebugCleanScope("CLEANABLE", 1);
        CLEANABLE = r1;
        DriveCacheDebugCleanScope[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static DriveCacheDebugCleanScope[] values() {
        return (DriveCacheDebugCleanScope[]) a.clone();
    }

    public static DriveCacheDebugCleanScope valueOf(String r1) {
        return (DriveCacheDebugCleanScope) r27.a.a(DriveCacheDebugCleanScope.class, r1);
    }

    public DriveCacheDebugCleanScope(String r1, int r2) {
        super(r1, r2);
    }
}
