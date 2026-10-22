package com.larus.platform.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\u0000j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\f"}, d2 = {"Lcom/larus/platform/api/FlowDriveFileType;", "", "<init>", "(Ljava/lang/String;I)V", "FILE", "IMAGE", "VIDEO", "AUDIO", "NON_FILE", "isMediaType", "", "toMixCategory", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FlowDriveFileType extends Enum<FlowDriveFileType> {
    public static final FlowDriveFileType AUDIO = null;
    public static final FlowDriveFileType FILE = null;
    public static final FlowDriveFileType IMAGE = null;
    public static final FlowDriveFileType NON_FILE = null;
    public static final FlowDriveFileType VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FlowDriveFileType[] f364772a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f364773b = null;

    public static EnumEntries<FlowDriveFileType> getEntries() {
        return f364773b;
    }

    static {
        FlowDriveFileType r100 = new FlowDriveFileType("FILE", 0);
        FILE = r100;
        FlowDriveFileType r101 = new FlowDriveFileType("IMAGE", 1);
        IMAGE = r101;
        FlowDriveFileType r102 = new FlowDriveFileType("VIDEO", 2);
        VIDEO = r102;
        FlowDriveFileType r103 = new FlowDriveFileType("AUDIO", 3);
        AUDIO = r103;
        FlowDriveFileType r104 = new FlowDriveFileType("NON_FILE", 4);
        NON_FILE = r104;
        FlowDriveFileType[] r105 = {r100, r101, r102, r103, r104};
        f364772a = r105;
        f364773b = EnumEntriesKt.enumEntries(r105);
    }

    public static FlowDriveFileType[] values() {
        return (FlowDriveFileType[]) f364772a.clone();
    }

    public final boolean isMediaType() {
        if (this != IMAGE) goto L5;
    L8:
        return true;
    L5:
        if (this == VIDEO) goto L8;
        return false;
    }

    public final FlowDriveFileType toMixCategory() {
        if (isMediaType() == false) goto L6;
        return IMAGE;
    L6:
        return FILE;
    }

    public static FlowDriveFileType valueOf(String r100) {
        return (FlowDriveFileType) r27.a.a(FlowDriveFileType.class, r100);
    }

    public FlowDriveFileType(String r100, int r101) {
        super(r100, r101);
    }
}
