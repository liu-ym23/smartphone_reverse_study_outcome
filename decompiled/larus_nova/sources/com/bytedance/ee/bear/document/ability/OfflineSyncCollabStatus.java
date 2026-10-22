package com.bytedance.ee.bear.document.ability;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/bear/document/ability/OfflineSyncCollabStatus;", "", "<init>", "(Ljava/lang/String;I)V", "USER_CHANGES", "ACCEPT_COMMIT", "DOCX_OFFLINE_CREATE_EMPTY", "ERROR", "UNKNOWN", "docs-document-sdk-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfflineSyncCollabStatus extends Enum<OfflineSyncCollabStatus> {
    public static final OfflineSyncCollabStatus ACCEPT_COMMIT = null;
    public static final OfflineSyncCollabStatus DOCX_OFFLINE_CREATE_EMPTY = null;
    public static final OfflineSyncCollabStatus ERROR = null;
    public static final OfflineSyncCollabStatus UNKNOWN = null;
    public static final OfflineSyncCollabStatus USER_CHANGES = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OfflineSyncCollabStatus[] f218670a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f218671b = null;

    public static EnumEntries<OfflineSyncCollabStatus> getEntries() {
        return f218671b;
    }

    static {
        OfflineSyncCollabStatus r100 = new OfflineSyncCollabStatus("USER_CHANGES", 0);
        USER_CHANGES = r100;
        OfflineSyncCollabStatus r101 = new OfflineSyncCollabStatus("ACCEPT_COMMIT", 1);
        ACCEPT_COMMIT = r101;
        OfflineSyncCollabStatus r102 = new OfflineSyncCollabStatus("DOCX_OFFLINE_CREATE_EMPTY", 2);
        DOCX_OFFLINE_CREATE_EMPTY = r102;
        OfflineSyncCollabStatus r103 = new OfflineSyncCollabStatus("ERROR", 3);
        ERROR = r103;
        OfflineSyncCollabStatus r104 = new OfflineSyncCollabStatus("UNKNOWN", 4);
        UNKNOWN = r104;
        OfflineSyncCollabStatus[] r105 = {r100, r101, r102, r103, r104};
        f218670a = r105;
        f218671b = EnumEntriesKt.enumEntries(r105);
    }

    public static OfflineSyncCollabStatus[] values() {
        return (OfflineSyncCollabStatus[]) f218670a.clone();
    }

    public static OfflineSyncCollabStatus valueOf(String r100) {
        return (OfflineSyncCollabStatus) a.a(OfflineSyncCollabStatus.class, r100);
    }

    public OfflineSyncCollabStatus(String r100, int r101) {
        super(r100, r101);
    }
}
