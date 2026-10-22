package com.bytedance.ee.bear.office.export.space;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/office/export/space/OfficeFolderSource;", "Ljava/io/Serializable;", "", "<init>", "(Ljava/lang/String;I)V", "RECENT", "MINE", "SHARED", "FAVORITE", "FOLDER_CHILD", "office-ccm-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeFolderSource extends Enum<OfficeFolderSource> implements Serializable {
    public static final OfficeFolderSource FAVORITE = null;
    public static final OfficeFolderSource FOLDER_CHILD = null;
    public static final OfficeFolderSource MINE = null;
    public static final OfficeFolderSource RECENT = null;
    public static final OfficeFolderSource SHARED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OfficeFolderSource[] f235448a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f235449b = null;

    public static EnumEntries<OfficeFolderSource> getEntries() {
        return f235449b;
    }

    static {
        OfficeFolderSource r100 = new OfficeFolderSource("RECENT", 0);
        RECENT = r100;
        OfficeFolderSource r101 = new OfficeFolderSource("MINE", 1);
        MINE = r101;
        OfficeFolderSource r102 = new OfficeFolderSource("SHARED", 2);
        SHARED = r102;
        OfficeFolderSource r103 = new OfficeFolderSource("FAVORITE", 3);
        FAVORITE = r103;
        OfficeFolderSource r104 = new OfficeFolderSource("FOLDER_CHILD", 4);
        FOLDER_CHILD = r104;
        OfficeFolderSource[] r105 = {r100, r101, r102, r103, r104};
        f235448a = r105;
        f235449b = EnumEntriesKt.enumEntries(r105);
    }

    public static OfficeFolderSource[] values() {
        return (OfficeFolderSource[]) f235448a.clone();
    }

    public static OfficeFolderSource valueOf(String r100) {
        return (OfficeFolderSource) r27.a.a(OfficeFolderSource.class, r100);
    }

    public OfficeFolderSource(String r100, int r101) {
        super(r100, r101);
    }
}
