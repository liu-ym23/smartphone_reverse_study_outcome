package com.bytedance.ee.bear.office.export.space;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/office/export/space/OfficeSpacePreloadCancelReason;", "Ljava/io/Serializable;", "", "<init>", "(Ljava/lang/String;I)V", "RELEASE", "TIMEOUT", "ACCOUNT_CHANGED", "LARK_DRIVE_DISABLED", "LOW_MEMORY", "office-ccm-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeSpacePreloadCancelReason extends Enum<OfficeSpacePreloadCancelReason> implements Serializable {
    public static final OfficeSpacePreloadCancelReason ACCOUNT_CHANGED = null;
    public static final OfficeSpacePreloadCancelReason LARK_DRIVE_DISABLED = null;
    public static final OfficeSpacePreloadCancelReason LOW_MEMORY = null;
    public static final OfficeSpacePreloadCancelReason RELEASE = null;
    public static final OfficeSpacePreloadCancelReason TIMEOUT = null;
    public static final /* synthetic */ OfficeSpacePreloadCancelReason[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<OfficeSpacePreloadCancelReason> getEntries() {
        return b;
    }

    static {
        OfficeSpacePreloadCancelReason r0 = new OfficeSpacePreloadCancelReason("RELEASE", 0);
        RELEASE = r0;
        OfficeSpacePreloadCancelReason r1 = new OfficeSpacePreloadCancelReason("TIMEOUT", 1);
        TIMEOUT = r1;
        OfficeSpacePreloadCancelReason r3 = new OfficeSpacePreloadCancelReason("ACCOUNT_CHANGED", 2);
        ACCOUNT_CHANGED = r3;
        OfficeSpacePreloadCancelReason r5 = new OfficeSpacePreloadCancelReason("LARK_DRIVE_DISABLED", 3);
        LARK_DRIVE_DISABLED = r5;
        OfficeSpacePreloadCancelReason r7 = new OfficeSpacePreloadCancelReason("LOW_MEMORY", 4);
        LOW_MEMORY = r7;
        OfficeSpacePreloadCancelReason[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static OfficeSpacePreloadCancelReason[] values() {
        return (OfficeSpacePreloadCancelReason[]) a.clone();
    }

    public static OfficeSpacePreloadCancelReason valueOf(String r1) {
        return (OfficeSpacePreloadCancelReason) r27.a.a(OfficeSpacePreloadCancelReason.class, r1);
    }

    public OfficeSpacePreloadCancelReason(String r1, int r2) {
        super(r1, r2);
    }
}
