package com.bytedance.ee.bear.office.space;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/office/space/OfficeSpaceTabAlignment;", "", "<init>", "(Ljava/lang/String;I)V", "CENTER", "START", "office-space_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeSpaceTabAlignment extends Enum<OfficeSpaceTabAlignment> {
    public static final OfficeSpaceTabAlignment CENTER = null;
    public static final OfficeSpaceTabAlignment START = null;
    public static final /* synthetic */ OfficeSpaceTabAlignment[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<OfficeSpaceTabAlignment> getEntries() {
        return b;
    }

    static {
        OfficeSpaceTabAlignment r0 = new OfficeSpaceTabAlignment("CENTER", 0);
        CENTER = r0;
        OfficeSpaceTabAlignment r1 = new OfficeSpaceTabAlignment("START", 1);
        START = r1;
        OfficeSpaceTabAlignment[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static OfficeSpaceTabAlignment[] values() {
        return (OfficeSpaceTabAlignment[]) a.clone();
    }

    public static OfficeSpaceTabAlignment valueOf(String r1) {
        return (OfficeSpaceTabAlignment) r27.a.a(OfficeSpaceTabAlignment.class, r1);
    }

    public OfficeSpaceTabAlignment(String r1, int r2) {
        super(r1, r2);
    }
}
