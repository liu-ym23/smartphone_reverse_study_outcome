package com.bytedance.ee.bear.list.sort;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/list/sort/SortScene;", "", "<init>", "(Ljava/lang/String;I)V", "FolderSort", "RecentSort", "ManualOfflineSort", "ShareFileSort", "MineSort", "SubordinateSort", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SortScene extends Enum<SortScene> {
    public static final SortScene FolderSort = null;
    public static final SortScene ManualOfflineSort = null;
    public static final SortScene MineSort = null;
    public static final SortScene RecentSort = null;
    public static final SortScene ShareFileSort = null;
    public static final SortScene SubordinateSort = null;
    public static final /* synthetic */ SortScene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<SortScene> getEntries() {
        return b;
    }

    static {
        SortScene r0 = new SortScene("FolderSort", 0);
        FolderSort = r0;
        SortScene r1 = new SortScene("RecentSort", 1);
        RecentSort = r1;
        SortScene r3 = new SortScene("ManualOfflineSort", 2);
        ManualOfflineSort = r3;
        SortScene r5 = new SortScene("ShareFileSort", 3);
        ShareFileSort = r5;
        SortScene r7 = new SortScene("MineSort", 4);
        MineSort = r7;
        SortScene r9 = new SortScene("SubordinateSort", 5);
        SubordinateSort = r9;
        SortScene[] r11 = {r0, r1, r3, r5, r7, r9};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
    }

    public static SortScene[] values() {
        return (SortScene[]) a.clone();
    }

    public static SortScene valueOf(String r1) {
        return (SortScene) r27.a.a(SortScene.class, r1);
    }

    public SortScene(String r1, int r2) {
        super(r1, r2);
    }
}
