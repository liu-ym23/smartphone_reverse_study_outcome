package com.bytedance.ee.bear.drive.common.mvpframeworks.base.mvp;

import r27.a;

/* JADX INFO: loaded from: classes16.dex */
public final enum MvpLceRecyclerView$NotifyType extends Enum<MvpLceRecyclerView$NotifyType> {
    public static final MvpLceRecyclerView$NotifyType DataSetChanged = null;
    public static final MvpLceRecyclerView$NotifyType ItemChanged = null;
    public static final MvpLceRecyclerView$NotifyType ItemInsert = null;
    public static final MvpLceRecyclerView$NotifyType ItemMoved = null;
    public static final MvpLceRecyclerView$NotifyType ItemRangeChanged = null;
    public static final MvpLceRecyclerView$NotifyType ItemRangeInsert = null;
    public static final MvpLceRecyclerView$NotifyType ItemRangeRemoved = null;
    public static final MvpLceRecyclerView$NotifyType ItemRemoved = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MvpLceRecyclerView$NotifyType[] f224082a = null;

    static {
        MvpLceRecyclerView$NotifyType r100 = new MvpLceRecyclerView$NotifyType("ItemChanged", 0);
        ItemChanged = r100;
        MvpLceRecyclerView$NotifyType r101 = new MvpLceRecyclerView$NotifyType("ItemInsert", 1);
        ItemInsert = r101;
        MvpLceRecyclerView$NotifyType r102 = new MvpLceRecyclerView$NotifyType("ItemRemoved", 2);
        ItemRemoved = r102;
        MvpLceRecyclerView$NotifyType r103 = new MvpLceRecyclerView$NotifyType("ItemMoved", 3);
        ItemMoved = r103;
        MvpLceRecyclerView$NotifyType r104 = new MvpLceRecyclerView$NotifyType("ItemRangeChanged", 4);
        ItemRangeChanged = r104;
        MvpLceRecyclerView$NotifyType r105 = new MvpLceRecyclerView$NotifyType("ItemRangeInsert", 5);
        ItemRangeInsert = r105;
        MvpLceRecyclerView$NotifyType r110 = new MvpLceRecyclerView$NotifyType("ItemRangeRemoved", 6);
        ItemRangeRemoved = r110;
        MvpLceRecyclerView$NotifyType r111 = new MvpLceRecyclerView$NotifyType("DataSetChanged", 7);
        DataSetChanged = r111;
        f224082a = new MvpLceRecyclerView$NotifyType[]{r100, r101, r102, r103, r104, r105, r110, r111};
    }

    public static MvpLceRecyclerView$NotifyType[] values() {
        return (MvpLceRecyclerView$NotifyType[]) f224082a.clone();
    }

    public static MvpLceRecyclerView$NotifyType valueOf(String r100) {
        return (MvpLceRecyclerView$NotifyType) a.a(MvpLceRecyclerView$NotifyType.class, r100);
    }

    public MvpLceRecyclerView$NotifyType(String r100, int r101) {
        super(r100, r101);
    }
}
