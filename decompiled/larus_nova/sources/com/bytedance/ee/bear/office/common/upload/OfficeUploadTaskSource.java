package com.bytedance.ee.bear.office.common.upload;

import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/office/common/upload/OfficeUploadTaskSource;", "", "<init>", "(Ljava/lang/String;I)V", AccountType.LOCAL, "RECOVERED", "office-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeUploadTaskSource extends Enum<OfficeUploadTaskSource> {
    public static final OfficeUploadTaskSource LOCAL = null;
    public static final OfficeUploadTaskSource RECOVERED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OfficeUploadTaskSource[] f235316a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f235317b = null;

    public static EnumEntries<OfficeUploadTaskSource> getEntries() {
        return f235317b;
    }

    static {
        OfficeUploadTaskSource r100 = new OfficeUploadTaskSource(AccountType.LOCAL, 0);
        LOCAL = r100;
        OfficeUploadTaskSource r101 = new OfficeUploadTaskSource("RECOVERED", 1);
        RECOVERED = r101;
        OfficeUploadTaskSource[] r102 = {r100, r101};
        f235316a = r102;
        f235317b = EnumEntriesKt.enumEntries(r102);
    }

    public static OfficeUploadTaskSource[] values() {
        return (OfficeUploadTaskSource[]) f235316a.clone();
    }

    public static OfficeUploadTaskSource valueOf(String r100) {
        return (OfficeUploadTaskSource) r27.a.a(OfficeUploadTaskSource.class, r100);
    }

    public OfficeUploadTaskSource(String r100, int r101) {
        super(r100, r101);
    }
}
