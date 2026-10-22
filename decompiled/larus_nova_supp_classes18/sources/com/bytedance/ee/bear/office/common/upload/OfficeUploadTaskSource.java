package com.bytedance.ee.bear.office.common.upload;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/office/common/upload/OfficeUploadTaskSource;", "", "<init>", "(Ljava/lang/String;I)V", "LOCAL", "RECOVERED", "office-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeUploadTaskSource extends Enum<OfficeUploadTaskSource> {
    public static final OfficeUploadTaskSource LOCAL = null;
    public static final OfficeUploadTaskSource RECOVERED = null;
    public static final /* synthetic */ OfficeUploadTaskSource[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<OfficeUploadTaskSource> getEntries() {
        return b;
    }

    static {
        OfficeUploadTaskSource r0 = new OfficeUploadTaskSource("LOCAL", 0);
        LOCAL = r0;
        OfficeUploadTaskSource r1 = new OfficeUploadTaskSource("RECOVERED", 1);
        RECOVERED = r1;
        OfficeUploadTaskSource[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static OfficeUploadTaskSource[] values() {
        return (OfficeUploadTaskSource[]) a.clone();
    }

    public static OfficeUploadTaskSource valueOf(String r1) {
        return (OfficeUploadTaskSource) r27.a.a(OfficeUploadTaskSource.class, r1);
    }

    public OfficeUploadTaskSource(String r1, int r2) {
        super(r1, r2);
    }
}
