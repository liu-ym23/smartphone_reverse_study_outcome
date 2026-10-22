package com.bytedance.android.shopping.store.slicecard;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u001c\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001d¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/shopping/store/slicecard/SliceActionType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "Companion", "a", "GROUP", "PRODUCT_ADD_CART", "TRACK", "TOAST", "UPDATE_ITEM_STATES", "UPDATE_ITEM_STATUS_SELF", "OPEN_SCHEMA", "OPEN_LIVE_ROOM_SCHEMA", "FOLLOW_SHOP", "PRODUCT_SUBSCRIBE", "TRACK_SHOW_PRODUCT", "OPEN_PRODUCT_DETAIL", "SHARE", "SEARCH", "CLICK_SORT_ITEM", "CLICK_SWITCH_LAYOUT", "CLOSE_SHOP", "CLOSE_SPLIT", "OPEN_PRODUCT_DETAIL_WITH_CALLBACK", "CLOSE", "PUBLISH_X_EVENT", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum SliceActionType extends Enum<SliceActionType> {
    public static final SliceActionType CLICK_SORT_ITEM = null;
    public static final SliceActionType CLICK_SWITCH_LAYOUT = null;
    public static final SliceActionType CLOSE = null;
    public static final SliceActionType CLOSE_SHOP = null;
    public static final SliceActionType CLOSE_SPLIT = null;
    public static final a Companion = null;
    public static final SliceActionType FOLLOW_SHOP = null;
    public static final SliceActionType GROUP = null;
    public static final SliceActionType OPEN_LIVE_ROOM_SCHEMA = null;
    public static final SliceActionType OPEN_PRODUCT_DETAIL = null;
    public static final SliceActionType OPEN_PRODUCT_DETAIL_WITH_CALLBACK = null;
    public static final SliceActionType OPEN_SCHEMA = null;
    public static final SliceActionType PRODUCT_ADD_CART = null;
    public static final SliceActionType PRODUCT_SUBSCRIBE = null;
    public static final SliceActionType PUBLISH_X_EVENT = null;
    public static final SliceActionType SEARCH = null;
    public static final SliceActionType SHARE = null;
    public static final SliceActionType TOAST = null;
    public static final SliceActionType TRACK = null;
    public static final SliceActionType TRACK_SHOW_PRODUCT = null;
    public static final SliceActionType UPDATE_ITEM_STATES = null;
    public static final SliceActionType UPDATE_ITEM_STATUS_SELF = null;
    public static final /* synthetic */ SliceActionType[] a = null;
    private final String type;

    public static final class a {
        public a() {
        }

        public static SliceActionType a(String r5) {
            Intrinsics.checkNotNullParameter(r5, "type");
            SliceActionType[] r0 = SliceActionType.values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            SliceActionType r3 = r0[r2];
            if (Intrinsics.areEqual(r3.getType(), r5) == true) goto L12;
            r2 = r2 + 1;
            goto L3
        L12:
            return r3;
        L8:
            return null;
        }
    }

    public static SliceActionType valueOf(String r1) {
        return (SliceActionType) r27.a.a(SliceActionType.class, r1);
    }

    public static SliceActionType[] values() {
        return (SliceActionType[]) a.clone();
    }

    static {
        SliceActionType r1 = new SliceActionType("GROUP", 0, "Group");
        GROUP = r1;
        SliceActionType r2 = new SliceActionType("PRODUCT_ADD_CART", 1, "ProductAddCart");
        PRODUCT_ADD_CART = r2;
        SliceActionType r3 = new SliceActionType("TRACK", 2, "Track");
        TRACK = r3;
        SliceActionType r4 = new SliceActionType("TOAST", 3, "Toast");
        TOAST = r4;
        SliceActionType r5 = new SliceActionType("UPDATE_ITEM_STATES", 4, "UpdateItemStates");
        UPDATE_ITEM_STATES = r5;
        SliceActionType r6 = new SliceActionType("UPDATE_ITEM_STATUS_SELF", 5, "UpdateSelfItemStates");
        UPDATE_ITEM_STATUS_SELF = r6;
        SliceActionType r7 = new SliceActionType("OPEN_SCHEMA", 6, "OpenSchema");
        OPEN_SCHEMA = r7;
        SliceActionType r8 = new SliceActionType("OPEN_LIVE_ROOM_SCHEMA", 7, "OpenLiveRoomSchema");
        OPEN_LIVE_ROOM_SCHEMA = r8;
        SliceActionType r9 = new SliceActionType("FOLLOW_SHOP", 8, "FollowShop");
        FOLLOW_SHOP = r9;
        SliceActionType r10 = new SliceActionType("PRODUCT_SUBSCRIBE", 9, "ProductSubscribe");
        PRODUCT_SUBSCRIBE = r10;
        SliceActionType r11 = new SliceActionType("TRACK_SHOW_PRODUCT", 10, "TrackShowProduct");
        TRACK_SHOW_PRODUCT = r11;
        SliceActionType r12 = new SliceActionType("OPEN_PRODUCT_DETAIL", 11, "OpenProductDetail");
        OPEN_PRODUCT_DETAIL = r12;
        SliceActionType r13 = new SliceActionType("SHARE", 12, "Share");
        SHARE = r13;
        SliceActionType r14 = new SliceActionType("SEARCH", 13, "Search");
        SEARCH = r14;
        SliceActionType r15 = new SliceActionType("CLICK_SORT_ITEM", 14, "ClickSortItem");
        CLICK_SORT_ITEM = r15;
        SliceActionType r16 = new SliceActionType("CLICK_SWITCH_LAYOUT", 15, "ClickSwitchLayout");
        CLICK_SWITCH_LAYOUT = r16;
        SliceActionType r17 = new SliceActionType("CLOSE_SHOP", 16, "CloseShop");
        CLOSE_SHOP = r17;
        SliceActionType r18 = new SliceActionType("CLOSE_SPLIT", 17, "CloseSplit");
        CLOSE_SPLIT = r18;
        SliceActionType r19 = new SliceActionType("OPEN_PRODUCT_DETAIL_WITH_CALLBACK", 18, "OpenProductDetailWithCallback");
        OPEN_PRODUCT_DETAIL_WITH_CALLBACK = r19;
        SliceActionType r20 = new SliceActionType("CLOSE", 19, "ClosePage");
        CLOSE = r20;
        SliceActionType r21 = new SliceActionType("PUBLISH_X_EVENT", 20, "PublishXEvent");
        PUBLISH_X_EVENT = r21;
        a = new SliceActionType[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21};
        Companion = new a();
    }

    public final String getType() {
        return this.type;
    }

    public SliceActionType(String r1, int r2, String r3) {
        super(r1, r2);
        this.type = r3;
    }
}
