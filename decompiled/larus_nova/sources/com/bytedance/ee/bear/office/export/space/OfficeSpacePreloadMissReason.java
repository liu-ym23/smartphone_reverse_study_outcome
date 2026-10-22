package com.bytedance.ee.bear.office.export.space;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes18.dex */
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

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OfficeSpacePreloadMissReason[] f235469a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f235470b = null;

    public static EnumEntries<OfficeSpacePreloadMissReason> getEntries() {
        return f235470b;
    }

    static {
        OfficeSpacePreloadMissReason r100 = new OfficeSpacePreloadMissReason("LARK_DRIVE_DISABLED", 0);
        LARK_DRIVE_DISABLED = r100;
        OfficeSpacePreloadMissReason r101 = new OfficeSpacePreloadMissReason("NO_REQUEST", 1);
        NO_REQUEST = r101;
        OfficeSpacePreloadMissReason r102 = new OfficeSpacePreloadMissReason("KEY_MISMATCH", 2);
        KEY_MISMATCH = r102;
        OfficeSpacePreloadMissReason r103 = new OfficeSpacePreloadMissReason("EXPIRED", 3);
        EXPIRED = r103;
        OfficeSpacePreloadMissReason r104 = new OfficeSpacePreloadMissReason("INFLIGHT", 4);
        INFLIGHT = r104;
        OfficeSpacePreloadMissReason r105 = new OfficeSpacePreloadMissReason("EMPTY_RESULT", 5);
        EMPTY_RESULT = r105;
        OfficeSpacePreloadMissReason r110 = new OfficeSpacePreloadMissReason("FAILED", 6);
        FAILED = r110;
        OfficeSpacePreloadMissReason r111 = new OfficeSpacePreloadMissReason("UNSUPPORTED", 7);
        UNSUPPORTED = r111;
        OfficeSpacePreloadMissReason[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
        f235469a = r112;
        f235470b = EnumEntriesKt.enumEntries(r112);
    }

    public static OfficeSpacePreloadMissReason[] values() {
        return (OfficeSpacePreloadMissReason[]) f235469a.clone();
    }

    public static OfficeSpacePreloadMissReason valueOf(String r100) {
        return (OfficeSpacePreloadMissReason) r27.a.a(OfficeSpacePreloadMissReason.class, r100);
    }

    public OfficeSpacePreloadMissReason(String r100, int r101) {
        super(r100, r101);
    }
}
