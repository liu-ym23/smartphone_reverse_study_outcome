package com.bytedance.ee.bear.list.sort;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/list/sort/SortScene;", "", "<init>", "(Ljava/lang/String;I)V", "FolderSort", "RecentSort", "ManualOfflineSort", "ShareFileSort", "MineSort", "SubordinateSort", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SortScene extends Enum<SortScene> {
    public static final SortScene FolderSort = null;
    public static final SortScene ManualOfflineSort = null;
    public static final SortScene MineSort = null;
    public static final SortScene RecentSort = null;
    public static final SortScene ShareFileSort = null;
    public static final SortScene SubordinateSort = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SortScene[] f229680a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f229681b = null;

    public static EnumEntries<SortScene> getEntries() {
        return f229681b;
    }

    static {
        SortScene r100 = new SortScene("FolderSort", 0);
        FolderSort = r100;
        SortScene r101 = new SortScene("RecentSort", 1);
        RecentSort = r101;
        SortScene r102 = new SortScene("ManualOfflineSort", 2);
        ManualOfflineSort = r102;
        SortScene r103 = new SortScene("ShareFileSort", 3);
        ShareFileSort = r103;
        SortScene r104 = new SortScene("MineSort", 4);
        MineSort = r104;
        SortScene r105 = new SortScene("SubordinateSort", 5);
        SubordinateSort = r105;
        SortScene[] r110 = {r100, r101, r102, r103, r104, r105};
        f229680a = r110;
        f229681b = EnumEntriesKt.enumEntries(r110);
    }

    public static SortScene[] values() {
        return (SortScene[]) f229680a.clone();
    }

    public static SortScene valueOf(String r100) {
        return (SortScene) r27.a.a(SortScene.class, r100);
    }

    public SortScene(String r100, int r101) {
        super(r100, r101);
    }
}
