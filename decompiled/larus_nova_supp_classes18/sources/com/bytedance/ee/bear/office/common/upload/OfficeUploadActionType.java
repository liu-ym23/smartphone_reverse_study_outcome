package com.bytedance.ee.bear.office.common.upload;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/office/common/upload/OfficeUploadActionType;", "", "<init>", "(Ljava/lang/String;I)V", "MEDIA", "FILE", "office-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeUploadActionType extends Enum<OfficeUploadActionType> {
    public static final OfficeUploadActionType FILE = null;
    public static final OfficeUploadActionType MEDIA = null;
    public static final /* synthetic */ OfficeUploadActionType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<OfficeUploadActionType> getEntries() {
        return b;
    }

    static {
        OfficeUploadActionType r0 = new OfficeUploadActionType("MEDIA", 0);
        MEDIA = r0;
        OfficeUploadActionType r1 = new OfficeUploadActionType("FILE", 1);
        FILE = r1;
        OfficeUploadActionType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static OfficeUploadActionType[] values() {
        return (OfficeUploadActionType[]) a.clone();
    }

    public static OfficeUploadActionType valueOf(String r1) {
        return (OfficeUploadActionType) r27.a.a(OfficeUploadActionType.class, r1);
    }

    public OfficeUploadActionType(String r1, int r2) {
        super(r1, r2);
    }
}
