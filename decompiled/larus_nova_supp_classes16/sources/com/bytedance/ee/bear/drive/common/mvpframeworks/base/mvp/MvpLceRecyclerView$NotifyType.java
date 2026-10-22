package com.bytedance.ee.bear.drive.common.mvpframeworks.base.mvp;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final enum MvpLceRecyclerView$NotifyType extends Enum<MvpLceRecyclerView$NotifyType> {
    public static final MvpLceRecyclerView$NotifyType DataSetChanged = null;
    public static final MvpLceRecyclerView$NotifyType ItemChanged = null;
    public static final MvpLceRecyclerView$NotifyType ItemInsert = null;
    public static final MvpLceRecyclerView$NotifyType ItemMoved = null;
    public static final MvpLceRecyclerView$NotifyType ItemRangeChanged = null;
    public static final MvpLceRecyclerView$NotifyType ItemRangeInsert = null;
    public static final MvpLceRecyclerView$NotifyType ItemRangeRemoved = null;
    public static final MvpLceRecyclerView$NotifyType ItemRemoved = null;
    public static final /* synthetic */ MvpLceRecyclerView$NotifyType[] a = null;

    static {
        MvpLceRecyclerView$NotifyType r0 = new MvpLceRecyclerView$NotifyType("ItemChanged", 0);
        ItemChanged = r0;
        MvpLceRecyclerView$NotifyType r1 = new MvpLceRecyclerView$NotifyType("ItemInsert", 1);
        ItemInsert = r1;
        MvpLceRecyclerView$NotifyType r3 = new MvpLceRecyclerView$NotifyType("ItemRemoved", 2);
        ItemRemoved = r3;
        MvpLceRecyclerView$NotifyType r5 = new MvpLceRecyclerView$NotifyType("ItemMoved", 3);
        ItemMoved = r5;
        MvpLceRecyclerView$NotifyType r7 = new MvpLceRecyclerView$NotifyType("ItemRangeChanged", 4);
        ItemRangeChanged = r7;
        MvpLceRecyclerView$NotifyType r9 = new MvpLceRecyclerView$NotifyType("ItemRangeInsert", 5);
        ItemRangeInsert = r9;
        MvpLceRecyclerView$NotifyType r11 = new MvpLceRecyclerView$NotifyType("ItemRangeRemoved", 6);
        ItemRangeRemoved = r11;
        MvpLceRecyclerView$NotifyType r13 = new MvpLceRecyclerView$NotifyType("DataSetChanged", 7);
        DataSetChanged = r13;
        a = new MvpLceRecyclerView$NotifyType[]{r0, r1, r3, r5, r7, r9, r11, r13};
    }

    public static MvpLceRecyclerView$NotifyType[] values() {
        return (MvpLceRecyclerView$NotifyType[]) a.clone();
    }

    public static MvpLceRecyclerView$NotifyType valueOf(String r1) {
        return (MvpLceRecyclerView$NotifyType) a.a(MvpLceRecyclerView$NotifyType.class, r1);
    }

    public MvpLceRecyclerView$NotifyType(String r1, int r2) {
        super(r1, r2);
    }
}
