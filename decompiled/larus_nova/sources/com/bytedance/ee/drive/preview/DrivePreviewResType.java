package com.bytedance.ee.drive.preview;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/drive/preview/DrivePreviewResType;", "", "<init>", "(Ljava/lang/String;I)V", "LOCAL_FILE", "SPACE_FILE", "THIRD_PARTY_FILE", "contentmanager-drive-export-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DrivePreviewResType extends Enum<DrivePreviewResType> {
    public static final DrivePreviewResType LOCAL_FILE = null;
    public static final DrivePreviewResType SPACE_FILE = null;
    public static final DrivePreviewResType THIRD_PARTY_FILE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DrivePreviewResType[] f242673a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f242674b = null;

    public static EnumEntries<DrivePreviewResType> getEntries() {
        return f242674b;
    }

    static {
        DrivePreviewResType r100 = new DrivePreviewResType("LOCAL_FILE", 0);
        LOCAL_FILE = r100;
        DrivePreviewResType r101 = new DrivePreviewResType("SPACE_FILE", 1);
        SPACE_FILE = r101;
        DrivePreviewResType r102 = new DrivePreviewResType("THIRD_PARTY_FILE", 2);
        THIRD_PARTY_FILE = r102;
        DrivePreviewResType[] r103 = {r100, r101, r102};
        f242673a = r103;
        f242674b = EnumEntriesKt.enumEntries(r103);
    }

    public static DrivePreviewResType[] values() {
        return (DrivePreviewResType[]) f242673a.clone();
    }

    public static DrivePreviewResType valueOf(String r100) {
        return (DrivePreviewResType) r27.a.a(DrivePreviewResType.class, r100);
    }

    public DrivePreviewResType(String r100, int r101) {
        super(r100, r101);
    }
}
