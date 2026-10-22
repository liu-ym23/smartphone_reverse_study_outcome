package com.bytedance.ee.bear.office.export.space;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/office/export/space/OfficeSpacePreloadLevelState;", "Ljava/io/Serializable;", "", "<init>", "(Ljava/lang/String;I)V", "PENDING", "RUNNING", "SUCCESS", "FAILED", "SKIPPED", "UNSUPPORTED", "office-ccm-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeSpacePreloadLevelState extends Enum<OfficeSpacePreloadLevelState> implements Serializable {
    public static final OfficeSpacePreloadLevelState FAILED = null;
    public static final OfficeSpacePreloadLevelState PENDING = null;
    public static final OfficeSpacePreloadLevelState RUNNING = null;
    public static final OfficeSpacePreloadLevelState SKIPPED = null;
    public static final OfficeSpacePreloadLevelState SUCCESS = null;
    public static final OfficeSpacePreloadLevelState UNSUPPORTED = null;
    public static final /* synthetic */ OfficeSpacePreloadLevelState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<OfficeSpacePreloadLevelState> getEntries() {
        return b;
    }

    static {
        OfficeSpacePreloadLevelState r0 = new OfficeSpacePreloadLevelState("PENDING", 0);
        PENDING = r0;
        OfficeSpacePreloadLevelState r1 = new OfficeSpacePreloadLevelState("RUNNING", 1);
        RUNNING = r1;
        OfficeSpacePreloadLevelState r3 = new OfficeSpacePreloadLevelState("SUCCESS", 2);
        SUCCESS = r3;
        OfficeSpacePreloadLevelState r5 = new OfficeSpacePreloadLevelState("FAILED", 3);
        FAILED = r5;
        OfficeSpacePreloadLevelState r7 = new OfficeSpacePreloadLevelState("SKIPPED", 4);
        SKIPPED = r7;
        OfficeSpacePreloadLevelState r9 = new OfficeSpacePreloadLevelState("UNSUPPORTED", 5);
        UNSUPPORTED = r9;
        OfficeSpacePreloadLevelState[] r11 = {r0, r1, r3, r5, r7, r9};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
    }

    public static OfficeSpacePreloadLevelState[] values() {
        return (OfficeSpacePreloadLevelState[]) a.clone();
    }

    public static OfficeSpacePreloadLevelState valueOf(String r1) {
        return (OfficeSpacePreloadLevelState) r27.a.a(OfficeSpacePreloadLevelState.class, r1);
    }

    public OfficeSpacePreloadLevelState(String r1, int r2) {
        super(r1, r2);
    }
}
