package com.bytedance.android.livesdk.livecommerce.room.controller.related;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"com/bytedance/android/livesdk/livecommerce/room/controller/related/IRelatedInfoManager$Scene", "", "Lcom/bytedance/android/livesdk/livecommerce/room/controller/related/IRelatedInfoManager$Scene;", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "ENTER_ROOM_API", "PROMOTION_LIST", "CARRY_ON_CARD", "GOODS_LIST_TAB", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum IRelatedInfoManager$Scene extends Enum<IRelatedInfoManager$Scene> {
    public static final IRelatedInfoManager$Scene CARRY_ON_CARD = null;
    public static final IRelatedInfoManager$Scene ENTER_ROOM_API = null;
    public static final IRelatedInfoManager$Scene GOODS_LIST_TAB = null;
    public static final IRelatedInfoManager$Scene PROMOTION_LIST = null;
    public static final /* synthetic */ IRelatedInfoManager$Scene[] a = null;
    private final String value;

    static {
        IRelatedInfoManager$Scene r1 = new IRelatedInfoManager$Scene("ENTER_ROOM_API", 0, "enter_room");
        ENTER_ROOM_API = r1;
        IRelatedInfoManager$Scene r2 = new IRelatedInfoManager$Scene("PROMOTION_LIST", 1, "promotion_list_top");
        PROMOTION_LIST = r2;
        IRelatedInfoManager$Scene r3 = new IRelatedInfoManager$Scene("CARRY_ON_CARD", 2, "related_card");
        CARRY_ON_CARD = r3;
        IRelatedInfoManager$Scene r4 = new IRelatedInfoManager$Scene("GOODS_LIST_TAB", 3, "goods_list_tab");
        GOODS_LIST_TAB = r4;
        a = new IRelatedInfoManager$Scene[]{r1, r2, r3, r4};
    }

    public static IRelatedInfoManager$Scene valueOf(String r1) {
        return (IRelatedInfoManager$Scene) r27.a.a(IRelatedInfoManager$Scene.class, r1);
    }

    public static IRelatedInfoManager$Scene[] values() {
        return (IRelatedInfoManager$Scene[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public IRelatedInfoManager$Scene(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
