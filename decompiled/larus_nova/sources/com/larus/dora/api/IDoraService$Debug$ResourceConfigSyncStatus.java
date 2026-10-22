package com.larus.dora.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/dora/api/IDoraService$Debug$ResourceConfigSyncStatus;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "SKIPPED", "INVALID_CONFIG", "DOWNLOAD_FAILED", "VERIFY_FAILED", "INSTALL_FAILED", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum IDoraService$Debug$ResourceConfigSyncStatus extends Enum<IDoraService$Debug$ResourceConfigSyncStatus> {
    public static final IDoraService$Debug$ResourceConfigSyncStatus DOWNLOAD_FAILED = null;
    public static final IDoraService$Debug$ResourceConfigSyncStatus INSTALL_FAILED = null;
    public static final IDoraService$Debug$ResourceConfigSyncStatus INVALID_CONFIG = null;
    public static final IDoraService$Debug$ResourceConfigSyncStatus SKIPPED = null;
    public static final IDoraService$Debug$ResourceConfigSyncStatus SUCCESS = null;
    public static final IDoraService$Debug$ResourceConfigSyncStatus VERIFY_FAILED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IDoraService$Debug$ResourceConfigSyncStatus[] f331724a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f331725b = null;

    public static EnumEntries<IDoraService$Debug$ResourceConfigSyncStatus> getEntries() {
        return f331725b;
    }

    static {
        IDoraService$Debug$ResourceConfigSyncStatus r100 = new IDoraService$Debug$ResourceConfigSyncStatus("SUCCESS", 0);
        SUCCESS = r100;
        IDoraService$Debug$ResourceConfigSyncStatus r101 = new IDoraService$Debug$ResourceConfigSyncStatus("SKIPPED", 1);
        SKIPPED = r101;
        IDoraService$Debug$ResourceConfigSyncStatus r102 = new IDoraService$Debug$ResourceConfigSyncStatus("INVALID_CONFIG", 2);
        INVALID_CONFIG = r102;
        IDoraService$Debug$ResourceConfigSyncStatus r103 = new IDoraService$Debug$ResourceConfigSyncStatus("DOWNLOAD_FAILED", 3);
        DOWNLOAD_FAILED = r103;
        IDoraService$Debug$ResourceConfigSyncStatus r104 = new IDoraService$Debug$ResourceConfigSyncStatus("VERIFY_FAILED", 4);
        VERIFY_FAILED = r104;
        IDoraService$Debug$ResourceConfigSyncStatus r105 = new IDoraService$Debug$ResourceConfigSyncStatus("INSTALL_FAILED", 5);
        INSTALL_FAILED = r105;
        IDoraService$Debug$ResourceConfigSyncStatus[] r110 = {r100, r101, r102, r103, r104, r105};
        f331724a = r110;
        f331725b = EnumEntriesKt.enumEntries(r110);
    }

    public static IDoraService$Debug$ResourceConfigSyncStatus[] values() {
        return (IDoraService$Debug$ResourceConfigSyncStatus[]) f331724a.clone();
    }

    public static IDoraService$Debug$ResourceConfigSyncStatus valueOf(String r100) {
        return (IDoraService$Debug$ResourceConfigSyncStatus) a.a(IDoraService$Debug$ResourceConfigSyncStatus.class, r100);
    }

    public IDoraService$Debug$ResourceConfigSyncStatus(String r100, int r101) {
        super(r100, r101);
    }
}
