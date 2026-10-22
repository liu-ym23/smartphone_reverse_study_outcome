package com.bytedance.ee.drive.preview;

import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/drive/preview/DriveCacheDebugCleanScope;", "", "<init>", "(Ljava/lang/String;I)V", AccountType.ALL, "CLEANABLE", "contentmanager-drive-export-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DriveCacheDebugCleanScope extends Enum<DriveCacheDebugCleanScope> {
    public static final DriveCacheDebugCleanScope ALL = null;
    public static final DriveCacheDebugCleanScope CLEANABLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DriveCacheDebugCleanScope[] f242670a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f242671b = null;

    public static EnumEntries<DriveCacheDebugCleanScope> getEntries() {
        return f242671b;
    }

    static {
        DriveCacheDebugCleanScope r100 = new DriveCacheDebugCleanScope(AccountType.ALL, 0);
        ALL = r100;
        DriveCacheDebugCleanScope r101 = new DriveCacheDebugCleanScope("CLEANABLE", 1);
        CLEANABLE = r101;
        DriveCacheDebugCleanScope[] r102 = {r100, r101};
        f242670a = r102;
        f242671b = EnumEntriesKt.enumEntries(r102);
    }

    public static DriveCacheDebugCleanScope[] values() {
        return (DriveCacheDebugCleanScope[]) f242670a.clone();
    }

    public static DriveCacheDebugCleanScope valueOf(String r100) {
        return (DriveCacheDebugCleanScope) r27.a.a(DriveCacheDebugCleanScope.class, r100);
    }

    public DriveCacheDebugCleanScope(String r100, int r101) {
        super(r100, r101);
    }
}
