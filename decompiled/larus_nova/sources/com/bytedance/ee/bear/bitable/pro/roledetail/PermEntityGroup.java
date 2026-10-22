package com.bytedance.ee.bear.bitable.pro.roledetail;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/bitable/pro/roledetail/PermEntityGroup;", "", "<init>", "(Ljava/lang/String;I)V", "PermName", "DashboardPerm", "TablePerm", "DocxPerm", "AutomationPerm", "OtherPerm", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PermEntityGroup extends Enum<PermEntityGroup> {
    public static final PermEntityGroup AutomationPerm = null;
    public static final PermEntityGroup DashboardPerm = null;
    public static final PermEntityGroup DocxPerm = null;
    public static final PermEntityGroup OtherPerm = null;
    public static final PermEntityGroup PermName = null;
    public static final PermEntityGroup TablePerm = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PermEntityGroup[] f215244a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f215245b = null;

    public static EnumEntries<PermEntityGroup> getEntries() {
        return f215245b;
    }

    static {
        PermEntityGroup r100 = new PermEntityGroup("PermName", 0);
        PermName = r100;
        PermEntityGroup r101 = new PermEntityGroup("DashboardPerm", 1);
        DashboardPerm = r101;
        PermEntityGroup r102 = new PermEntityGroup("TablePerm", 2);
        TablePerm = r102;
        PermEntityGroup r103 = new PermEntityGroup("DocxPerm", 3);
        DocxPerm = r103;
        PermEntityGroup r104 = new PermEntityGroup("AutomationPerm", 4);
        AutomationPerm = r104;
        PermEntityGroup r105 = new PermEntityGroup("OtherPerm", 5);
        OtherPerm = r105;
        PermEntityGroup[] r110 = {r100, r101, r102, r103, r104, r105};
        f215244a = r110;
        f215245b = EnumEntriesKt.enumEntries(r110);
    }

    public static PermEntityGroup[] values() {
        return (PermEntityGroup[]) f215244a.clone();
    }

    public static PermEntityGroup valueOf(String r100) {
        return (PermEntityGroup) a.a(PermEntityGroup.class, r100);
    }

    public PermEntityGroup(String r100, int r101) {
        super(r100, r101);
    }
}
