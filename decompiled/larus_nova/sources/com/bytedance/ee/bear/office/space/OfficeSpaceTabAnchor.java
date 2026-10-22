package com.bytedance.ee.bear.office.space;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/office/space/OfficeSpaceTabAnchor;", "", "<init>", "(Ljava/lang/String;I)V", "PARENT_START", "MENU_END", "RIGHT_ACTIONS_START", "PARENT_END", "office-space_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeSpaceTabAnchor extends Enum<OfficeSpaceTabAnchor> {
    public static final OfficeSpaceTabAnchor MENU_END = null;
    public static final OfficeSpaceTabAnchor PARENT_END = null;
    public static final OfficeSpaceTabAnchor PARENT_START = null;
    public static final OfficeSpaceTabAnchor RIGHT_ACTIONS_START = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OfficeSpaceTabAnchor[] f236077a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f236078b = null;

    public static EnumEntries<OfficeSpaceTabAnchor> getEntries() {
        return f236078b;
    }

    static {
        OfficeSpaceTabAnchor r100 = new OfficeSpaceTabAnchor("PARENT_START", 0);
        PARENT_START = r100;
        OfficeSpaceTabAnchor r101 = new OfficeSpaceTabAnchor("MENU_END", 1);
        MENU_END = r101;
        OfficeSpaceTabAnchor r102 = new OfficeSpaceTabAnchor("RIGHT_ACTIONS_START", 2);
        RIGHT_ACTIONS_START = r102;
        OfficeSpaceTabAnchor r103 = new OfficeSpaceTabAnchor("PARENT_END", 3);
        PARENT_END = r103;
        OfficeSpaceTabAnchor[] r104 = {r100, r101, r102, r103};
        f236077a = r104;
        f236078b = EnumEntriesKt.enumEntries(r104);
    }

    public static OfficeSpaceTabAnchor[] values() {
        return (OfficeSpaceTabAnchor[]) f236077a.clone();
    }

    public static OfficeSpaceTabAnchor valueOf(String r100) {
        return (OfficeSpaceTabAnchor) r27.a.a(OfficeSpaceTabAnchor.class, r100);
    }

    public OfficeSpaceTabAnchor(String r100, int r101) {
        super(r100, r101);
    }
}
