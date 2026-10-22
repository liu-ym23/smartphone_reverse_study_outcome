package com.bytedance.ee.bear.office.export.space;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \t2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceTab;", "Ljava/io/Serializable;", "", "<init>", "(Ljava/lang/String;I)V", "RECENT", "MINE", "SHARED", "FAVORITE", "Companion", "office-ccm-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeSpaceTab extends Enum<OfficeSpaceTab> implements Serializable {
    public static final a Companion = null;
    public static final OfficeSpaceTab FAVORITE = null;
    public static final OfficeSpaceTab MINE = null;
    public static final OfficeSpaceTab RECENT = null;
    public static final OfficeSpaceTab SHARED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OfficeSpaceTab[] f235475a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f235476b = null;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<OfficeSpaceTab> getEntries() {
        return f235476b;
    }

    static {
        OfficeSpaceTab r100 = new OfficeSpaceTab("RECENT", 0);
        RECENT = r100;
        OfficeSpaceTab r101 = new OfficeSpaceTab("MINE", 1);
        MINE = r101;
        OfficeSpaceTab r102 = new OfficeSpaceTab("SHARED", 2);
        SHARED = r102;
        OfficeSpaceTab r103 = new OfficeSpaceTab("FAVORITE", 3);
        FAVORITE = r103;
        OfficeSpaceTab[] r104 = {r100, r101, r102, r103};
        f235475a = r104;
        f235476b = EnumEntriesKt.enumEntries(r104);
        Companion = new a();
    }

    public static OfficeSpaceTab[] values() {
        return (OfficeSpaceTab[]) f235475a.clone();
    }

    public static OfficeSpaceTab valueOf(String r100) {
        return (OfficeSpaceTab) r27.a.a(OfficeSpaceTab.class, r100);
    }

    public OfficeSpaceTab(String r100, int r101) {
        super(r100, r101);
    }
}
