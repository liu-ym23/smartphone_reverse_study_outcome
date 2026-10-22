package com.bytedance.ee.bear.office.common.upload;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/office/common/upload/OfficeUploadActionType;", "", "<init>", "(Ljava/lang/String;I)V", "MEDIA", "FILE", "office-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeUploadActionType extends Enum<OfficeUploadActionType> {
    public static final OfficeUploadActionType FILE = null;
    public static final OfficeUploadActionType MEDIA = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OfficeUploadActionType[] f235262a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f235263b = null;

    public static EnumEntries<OfficeUploadActionType> getEntries() {
        return f235263b;
    }

    static {
        OfficeUploadActionType r100 = new OfficeUploadActionType("MEDIA", 0);
        MEDIA = r100;
        OfficeUploadActionType r101 = new OfficeUploadActionType("FILE", 1);
        FILE = r101;
        OfficeUploadActionType[] r102 = {r100, r101};
        f235262a = r102;
        f235263b = EnumEntriesKt.enumEntries(r102);
    }

    public static OfficeUploadActionType[] values() {
        return (OfficeUploadActionType[]) f235262a.clone();
    }

    public static OfficeUploadActionType valueOf(String r100) {
        return (OfficeUploadActionType) r27.a.a(OfficeUploadActionType.class, r100);
    }

    public OfficeUploadActionType(String r100, int r101) {
        super(r100, r101);
    }
}
