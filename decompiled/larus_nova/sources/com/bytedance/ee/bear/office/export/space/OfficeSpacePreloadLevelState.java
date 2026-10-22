package com.bytedance.ee.bear.office.export.space;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/office/export/space/OfficeSpacePreloadLevelState;", "Ljava/io/Serializable;", "", "<init>", "(Ljava/lang/String;I)V", "PENDING", "RUNNING", "SUCCESS", "FAILED", "SKIPPED", "UNSUPPORTED", "office-ccm-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeSpacePreloadLevelState extends Enum<OfficeSpacePreloadLevelState> implements Serializable {
    public static final OfficeSpacePreloadLevelState FAILED = null;
    public static final OfficeSpacePreloadLevelState PENDING = null;
    public static final OfficeSpacePreloadLevelState RUNNING = null;
    public static final OfficeSpacePreloadLevelState SKIPPED = null;
    public static final OfficeSpacePreloadLevelState SUCCESS = null;
    public static final OfficeSpacePreloadLevelState UNSUPPORTED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OfficeSpacePreloadLevelState[] f235467a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f235468b = null;

    public static EnumEntries<OfficeSpacePreloadLevelState> getEntries() {
        return f235468b;
    }

    static {
        OfficeSpacePreloadLevelState r100 = new OfficeSpacePreloadLevelState("PENDING", 0);
        PENDING = r100;
        OfficeSpacePreloadLevelState r101 = new OfficeSpacePreloadLevelState("RUNNING", 1);
        RUNNING = r101;
        OfficeSpacePreloadLevelState r102 = new OfficeSpacePreloadLevelState("SUCCESS", 2);
        SUCCESS = r102;
        OfficeSpacePreloadLevelState r103 = new OfficeSpacePreloadLevelState("FAILED", 3);
        FAILED = r103;
        OfficeSpacePreloadLevelState r104 = new OfficeSpacePreloadLevelState("SKIPPED", 4);
        SKIPPED = r104;
        OfficeSpacePreloadLevelState r105 = new OfficeSpacePreloadLevelState("UNSUPPORTED", 5);
        UNSUPPORTED = r105;
        OfficeSpacePreloadLevelState[] r110 = {r100, r101, r102, r103, r104, r105};
        f235467a = r110;
        f235468b = EnumEntriesKt.enumEntries(r110);
    }

    public static OfficeSpacePreloadLevelState[] values() {
        return (OfficeSpacePreloadLevelState[]) f235467a.clone();
    }

    public static OfficeSpacePreloadLevelState valueOf(String r100) {
        return (OfficeSpacePreloadLevelState) r27.a.a(OfficeSpacePreloadLevelState.class, r100);
    }

    public OfficeSpacePreloadLevelState(String r100, int r101) {
        super(r100, r101);
    }
}
