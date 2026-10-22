package com.bytedance.ee.bear.office.export.space;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \t2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceTab;", "Ljava/io/Serializable;", "", "<init>", "(Ljava/lang/String;I)V", "RECENT", "MINE", "SHARED", "FAVORITE", "Companion", "office-ccm-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeSpaceTab extends Enum<OfficeSpaceTab> implements Serializable {
    public static final a Companion = null;
    public static final OfficeSpaceTab FAVORITE = null;
    public static final OfficeSpaceTab MINE = null;
    public static final OfficeSpaceTab RECENT = null;
    public static final OfficeSpaceTab SHARED = null;
    public static final /* synthetic */ OfficeSpaceTab[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<OfficeSpaceTab> getEntries() {
        return b;
    }

    static {
        OfficeSpaceTab r0 = new OfficeSpaceTab("RECENT", 0);
        RECENT = r0;
        OfficeSpaceTab r1 = new OfficeSpaceTab("MINE", 1);
        MINE = r1;
        OfficeSpaceTab r3 = new OfficeSpaceTab("SHARED", 2);
        SHARED = r3;
        OfficeSpaceTab r5 = new OfficeSpaceTab("FAVORITE", 3);
        FAVORITE = r5;
        OfficeSpaceTab[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
        Companion = new a();
    }

    public static OfficeSpaceTab[] values() {
        return (OfficeSpaceTab[]) a.clone();
    }

    public static OfficeSpaceTab valueOf(String r1) {
        return (OfficeSpaceTab) r27.a.a(OfficeSpaceTab.class, r1);
    }

    public OfficeSpaceTab(String r1, int r2) {
        super(r1, r2);
    }
}
