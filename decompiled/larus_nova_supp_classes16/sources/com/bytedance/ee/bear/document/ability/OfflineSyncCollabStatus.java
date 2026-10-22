package com.bytedance.ee.bear.document.ability;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/bear/document/ability/OfflineSyncCollabStatus;", "", "<init>", "(Ljava/lang/String;I)V", "USER_CHANGES", "ACCEPT_COMMIT", "DOCX_OFFLINE_CREATE_EMPTY", "ERROR", "UNKNOWN", "docs-document-sdk-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfflineSyncCollabStatus extends Enum<OfflineSyncCollabStatus> {
    public static final OfflineSyncCollabStatus ACCEPT_COMMIT = null;
    public static final OfflineSyncCollabStatus DOCX_OFFLINE_CREATE_EMPTY = null;
    public static final OfflineSyncCollabStatus ERROR = null;
    public static final OfflineSyncCollabStatus UNKNOWN = null;
    public static final OfflineSyncCollabStatus USER_CHANGES = null;
    public static final /* synthetic */ OfflineSyncCollabStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<OfflineSyncCollabStatus> getEntries() {
        return b;
    }

    static {
        OfflineSyncCollabStatus r0 = new OfflineSyncCollabStatus("USER_CHANGES", 0);
        USER_CHANGES = r0;
        OfflineSyncCollabStatus r1 = new OfflineSyncCollabStatus("ACCEPT_COMMIT", 1);
        ACCEPT_COMMIT = r1;
        OfflineSyncCollabStatus r3 = new OfflineSyncCollabStatus("DOCX_OFFLINE_CREATE_EMPTY", 2);
        DOCX_OFFLINE_CREATE_EMPTY = r3;
        OfflineSyncCollabStatus r5 = new OfflineSyncCollabStatus("ERROR", 3);
        ERROR = r5;
        OfflineSyncCollabStatus r7 = new OfflineSyncCollabStatus("UNKNOWN", 4);
        UNKNOWN = r7;
        OfflineSyncCollabStatus[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static OfflineSyncCollabStatus[] values() {
        return (OfflineSyncCollabStatus[]) a.clone();
    }

    public static OfflineSyncCollabStatus valueOf(String r1) {
        return (OfflineSyncCollabStatus) a.a(OfflineSyncCollabStatus.class, r1);
    }

    public OfflineSyncCollabStatus(String r1, int r2) {
        super(r1, r2);
    }
}
