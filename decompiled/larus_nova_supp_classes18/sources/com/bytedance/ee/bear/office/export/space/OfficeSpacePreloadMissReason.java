package com.bytedance.ee.bear.office.export.space;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/office/export/space/OfficeSpacePreloadMissReason;", "Ljava/io/Serializable;", "", "<init>", "(Ljava/lang/String;I)V", "LARK_DRIVE_DISABLED", "NO_REQUEST", "KEY_MISMATCH", "EXPIRED", "INFLIGHT", "EMPTY_RESULT", "FAILED", "UNSUPPORTED", "office-ccm-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeSpacePreloadMissReason extends Enum<OfficeSpacePreloadMissReason> implements Serializable {
    public static final OfficeSpacePreloadMissReason EMPTY_RESULT = null;
    public static final OfficeSpacePreloadMissReason EXPIRED = null;
    public static final OfficeSpacePreloadMissReason FAILED = null;
    public static final OfficeSpacePreloadMissReason INFLIGHT = null;
    public static final OfficeSpacePreloadMissReason KEY_MISMATCH = null;
    public static final OfficeSpacePreloadMissReason LARK_DRIVE_DISABLED = null;
    public static final OfficeSpacePreloadMissReason NO_REQUEST = null;
    public static final OfficeSpacePreloadMissReason UNSUPPORTED = null;
    public static final /* synthetic */ OfficeSpacePreloadMissReason[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<OfficeSpacePreloadMissReason> getEntries() {
        return b;
    }

    static {
        OfficeSpacePreloadMissReason r0 = new OfficeSpacePreloadMissReason("LARK_DRIVE_DISABLED", 0);
        LARK_DRIVE_DISABLED = r0;
        OfficeSpacePreloadMissReason r1 = new OfficeSpacePreloadMissReason("NO_REQUEST", 1);
        NO_REQUEST = r1;
        OfficeSpacePreloadMissReason r3 = new OfficeSpacePreloadMissReason("KEY_MISMATCH", 2);
        KEY_MISMATCH = r3;
        OfficeSpacePreloadMissReason r5 = new OfficeSpacePreloadMissReason("EXPIRED", 3);
        EXPIRED = r5;
        OfficeSpacePreloadMissReason r7 = new OfficeSpacePreloadMissReason("INFLIGHT", 4);
        INFLIGHT = r7;
        OfficeSpacePreloadMissReason r9 = new OfficeSpacePreloadMissReason("EMPTY_RESULT", 5);
        EMPTY_RESULT = r9;
        OfficeSpacePreloadMissReason r11 = new OfficeSpacePreloadMissReason("FAILED", 6);
        FAILED = r11;
        OfficeSpacePreloadMissReason r13 = new OfficeSpacePreloadMissReason("UNSUPPORTED", 7);
        UNSUPPORTED = r13;
        OfficeSpacePreloadMissReason[] r15 = {r0, r1, r3, r5, r7, r9, r11, r13};
        a = r15;
        b = EnumEntriesKt.enumEntries(r15);
    }

    public static OfficeSpacePreloadMissReason[] values() {
        return (OfficeSpacePreloadMissReason[]) a.clone();
    }

    public static OfficeSpacePreloadMissReason valueOf(String r1) {
        return (OfficeSpacePreloadMissReason) r27.a.a(OfficeSpacePreloadMissReason.class, r1);
    }

    public OfficeSpacePreloadMissReason(String r1, int r2) {
        super(r1, r2);
    }
}
