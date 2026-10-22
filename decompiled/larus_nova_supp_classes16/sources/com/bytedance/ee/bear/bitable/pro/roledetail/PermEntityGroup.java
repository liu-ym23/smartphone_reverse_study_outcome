package com.bytedance.ee.bear.bitable.pro.roledetail;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/bitable/pro/roledetail/PermEntityGroup;", "", "<init>", "(Ljava/lang/String;I)V", "PermName", "DashboardPerm", "TablePerm", "DocxPerm", "AutomationPerm", "OtherPerm", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PermEntityGroup extends Enum<PermEntityGroup> {
    public static final PermEntityGroup AutomationPerm = null;
    public static final PermEntityGroup DashboardPerm = null;
    public static final PermEntityGroup DocxPerm = null;
    public static final PermEntityGroup OtherPerm = null;
    public static final PermEntityGroup PermName = null;
    public static final PermEntityGroup TablePerm = null;
    public static final /* synthetic */ PermEntityGroup[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<PermEntityGroup> getEntries() {
        return b;
    }

    static {
        PermEntityGroup r0 = new PermEntityGroup("PermName", 0);
        PermName = r0;
        PermEntityGroup r1 = new PermEntityGroup("DashboardPerm", 1);
        DashboardPerm = r1;
        PermEntityGroup r3 = new PermEntityGroup("TablePerm", 2);
        TablePerm = r3;
        PermEntityGroup r5 = new PermEntityGroup("DocxPerm", 3);
        DocxPerm = r5;
        PermEntityGroup r7 = new PermEntityGroup("AutomationPerm", 4);
        AutomationPerm = r7;
        PermEntityGroup r9 = new PermEntityGroup("OtherPerm", 5);
        OtherPerm = r9;
        PermEntityGroup[] r11 = {r0, r1, r3, r5, r7, r9};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
    }

    public static PermEntityGroup[] values() {
        return (PermEntityGroup[]) a.clone();
    }

    public static PermEntityGroup valueOf(String r1) {
        return (PermEntityGroup) a.a(PermEntityGroup.class, r1);
    }

    public PermEntityGroup(String r1, int r2) {
        super(r1, r2);
    }
}
