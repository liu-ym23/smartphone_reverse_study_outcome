package com.bytedance.ee.bear.list.rename.core;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/list/rename/core/OfficeRenameEditAvailability;", "", "<init>", "(Ljava/lang/String;I)V", "Visible", "Prefetching", "Disabled", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
final enum OfficeRenameEditAvailability extends Enum<OfficeRenameEditAvailability> {
    public static final OfficeRenameEditAvailability Disabled = null;
    public static final OfficeRenameEditAvailability Prefetching = null;
    public static final OfficeRenameEditAvailability Visible = null;
    public static final /* synthetic */ OfficeRenameEditAvailability[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<OfficeRenameEditAvailability> getEntries() {
        return b;
    }

    static {
        OfficeRenameEditAvailability r0 = new OfficeRenameEditAvailability("Visible", 0);
        Visible = r0;
        OfficeRenameEditAvailability r1 = new OfficeRenameEditAvailability("Prefetching", 1);
        Prefetching = r1;
        OfficeRenameEditAvailability r3 = new OfficeRenameEditAvailability("Disabled", 2);
        Disabled = r3;
        OfficeRenameEditAvailability[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static OfficeRenameEditAvailability[] values() {
        return (OfficeRenameEditAvailability[]) a.clone();
    }

    public static OfficeRenameEditAvailability valueOf(String r1) {
        return (OfficeRenameEditAvailability) r27.a.a(OfficeRenameEditAvailability.class, r1);
    }

    public OfficeRenameEditAvailability(String r1, int r2) {
        super(r1, r2);
    }
}
