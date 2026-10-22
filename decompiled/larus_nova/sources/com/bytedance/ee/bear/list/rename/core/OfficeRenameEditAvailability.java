package com.bytedance.ee.bear.list.rename.core;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/list/rename/core/OfficeRenameEditAvailability;", "", "<init>", "(Ljava/lang/String;I)V", "Visible", "Prefetching", "Disabled", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
final enum OfficeRenameEditAvailability extends Enum<OfficeRenameEditAvailability> {
    public static final OfficeRenameEditAvailability Disabled = null;
    public static final OfficeRenameEditAvailability Prefetching = null;
    public static final OfficeRenameEditAvailability Visible = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OfficeRenameEditAvailability[] f229346a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f229347b = null;

    public static EnumEntries<OfficeRenameEditAvailability> getEntries() {
        return f229347b;
    }

    static {
        OfficeRenameEditAvailability r100 = new OfficeRenameEditAvailability("Visible", 0);
        Visible = r100;
        OfficeRenameEditAvailability r101 = new OfficeRenameEditAvailability("Prefetching", 1);
        Prefetching = r101;
        OfficeRenameEditAvailability r102 = new OfficeRenameEditAvailability("Disabled", 2);
        Disabled = r102;
        OfficeRenameEditAvailability[] r103 = {r100, r101, r102};
        f229346a = r103;
        f229347b = EnumEntriesKt.enumEntries(r103);
    }

    public static OfficeRenameEditAvailability[] values() {
        return (OfficeRenameEditAvailability[]) f229346a.clone();
    }

    public static OfficeRenameEditAvailability valueOf(String r100) {
        return (OfficeRenameEditAvailability) r27.a.a(OfficeRenameEditAvailability.class, r100);
    }

    public OfficeRenameEditAvailability(String r100, int r101) {
        super(r100, r101);
    }
}
