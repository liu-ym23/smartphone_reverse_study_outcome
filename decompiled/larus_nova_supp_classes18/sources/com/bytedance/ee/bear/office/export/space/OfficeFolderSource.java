package com.bytedance.ee.bear.office.export.space;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/office/export/space/OfficeFolderSource;", "Ljava/io/Serializable;", "", "<init>", "(Ljava/lang/String;I)V", "RECENT", "MINE", "SHARED", "FAVORITE", "FOLDER_CHILD", "office-ccm-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeFolderSource extends Enum<OfficeFolderSource> implements Serializable {
    public static final OfficeFolderSource FAVORITE = null;
    public static final OfficeFolderSource FOLDER_CHILD = null;
    public static final OfficeFolderSource MINE = null;
    public static final OfficeFolderSource RECENT = null;
    public static final OfficeFolderSource SHARED = null;
    public static final /* synthetic */ OfficeFolderSource[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<OfficeFolderSource> getEntries() {
        return b;
    }

    static {
        OfficeFolderSource r0 = new OfficeFolderSource("RECENT", 0);
        RECENT = r0;
        OfficeFolderSource r1 = new OfficeFolderSource("MINE", 1);
        MINE = r1;
        OfficeFolderSource r3 = new OfficeFolderSource("SHARED", 2);
        SHARED = r3;
        OfficeFolderSource r5 = new OfficeFolderSource("FAVORITE", 3);
        FAVORITE = r5;
        OfficeFolderSource r7 = new OfficeFolderSource("FOLDER_CHILD", 4);
        FOLDER_CHILD = r7;
        OfficeFolderSource[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static OfficeFolderSource[] values() {
        return (OfficeFolderSource[]) a.clone();
    }

    public static OfficeFolderSource valueOf(String r1) {
        return (OfficeFolderSource) r27.a.a(OfficeFolderSource.class, r1);
    }

    public OfficeFolderSource(String r1, int r2) {
        super(r1, r2);
    }
}
