package com.bytedance.android.livesdk.livecommerce.room.controller.related;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final /* synthetic */ class a {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;
    public static final /* synthetic */ int[] c = null;

    static {
        int[] r0 = new int[IRelatedInfoManager$FromSource.values().length];
        a = r0;
        r0[IRelatedInfoManager$FromSource.JUMP_SCHEMA.ordinal()] = 1;
        r0[IRelatedInfoManager$FromSource.LIVE_LIST_TAB_RESORT_ABILITY.ordinal()] = 2;
        int[] r1 = new int[IRelatedInfoManager$Scene.values().length];
        b = r1;
        IRelatedInfoManager$Scene r2 = IRelatedInfoManager$Scene.PROMOTION_LIST;
        r1[r2.ordinal()] = 1;
        int[] r3 = new int[IRelatedInfoManager$Scene.values().length];
        c = r3;
        r3[r2.ordinal()] = 1;
        r3[IRelatedInfoManager$Scene.GOODS_LIST_TAB.ordinal()] = 2;
        r3[IRelatedInfoManager$Scene.CARRY_ON_CARD.ordinal()] = 3;
    }
}
