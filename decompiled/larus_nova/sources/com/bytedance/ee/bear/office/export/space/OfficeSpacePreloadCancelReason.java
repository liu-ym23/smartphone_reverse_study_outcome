package com.bytedance.ee.bear.office.export.space;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/office/export/space/OfficeSpacePreloadCancelReason;", "Ljava/io/Serializable;", "", "<init>", "(Ljava/lang/String;I)V", "RELEASE", "TIMEOUT", "ACCOUNT_CHANGED", "LARK_DRIVE_DISABLED", "LOW_MEMORY", "office-ccm-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeSpacePreloadCancelReason extends Enum<OfficeSpacePreloadCancelReason> implements Serializable {
    public static final OfficeSpacePreloadCancelReason ACCOUNT_CHANGED = null;
    public static final OfficeSpacePreloadCancelReason LARK_DRIVE_DISABLED = null;
    public static final OfficeSpacePreloadCancelReason LOW_MEMORY = null;
    public static final OfficeSpacePreloadCancelReason RELEASE = null;
    public static final OfficeSpacePreloadCancelReason TIMEOUT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OfficeSpacePreloadCancelReason[] f235463a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f235464b = null;

    public static EnumEntries<OfficeSpacePreloadCancelReason> getEntries() {
        return f235464b;
    }

    static {
        OfficeSpacePreloadCancelReason r100 = new OfficeSpacePreloadCancelReason("RELEASE", 0);
        RELEASE = r100;
        OfficeSpacePreloadCancelReason r101 = new OfficeSpacePreloadCancelReason("TIMEOUT", 1);
        TIMEOUT = r101;
        OfficeSpacePreloadCancelReason r102 = new OfficeSpacePreloadCancelReason("ACCOUNT_CHANGED", 2);
        ACCOUNT_CHANGED = r102;
        OfficeSpacePreloadCancelReason r103 = new OfficeSpacePreloadCancelReason("LARK_DRIVE_DISABLED", 3);
        LARK_DRIVE_DISABLED = r103;
        OfficeSpacePreloadCancelReason r104 = new OfficeSpacePreloadCancelReason("LOW_MEMORY", 4);
        LOW_MEMORY = r104;
        OfficeSpacePreloadCancelReason[] r105 = {r100, r101, r102, r103, r104};
        f235463a = r105;
        f235464b = EnumEntriesKt.enumEntries(r105);
    }

    public static OfficeSpacePreloadCancelReason[] values() {
        return (OfficeSpacePreloadCancelReason[]) f235463a.clone();
    }

    public static OfficeSpacePreloadCancelReason valueOf(String r100) {
        return (OfficeSpacePreloadCancelReason) r27.a.a(OfficeSpacePreloadCancelReason.class, r100);
    }

    public OfficeSpacePreloadCancelReason(String r100, int r101) {
        super(r100, r101);
    }
}
