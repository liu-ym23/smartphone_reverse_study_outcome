package com.bytedance.android.livesdk.livecommerce.promotionlist.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\r\u0018\u0000 +2\u00020\u0001:\u0001,B\u0007¢\u0006\u0004\b)\u0010*R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R$\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0016\u0010\u0010R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u000e\u001a\u0004\b\u0018\u0010\u0010R\u001a\u0010\u001a\u001a\u00020\u00198\u0006X\u0087D¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u000e\u001a\u0004\b\u001f\u0010\u0010R(\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010 8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b%\u0010\t\u001a\u0004\b&\u0010\u000bR\u001a\u0010'\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b'\u0010\u0004\u001a\u0004\b(\u0010\u0006¨\u0006-"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotionlist/model/LivePromotionPageRoomInfo;", "Ljava/io/Serializable;", "", "roomType", "I", "getRoomType", "()I", "", "minimumGuaranteeAddress", "J", "getMinimumGuaranteeAddress", "()J", "", "hourlyPurchaseShopId", "Ljava/lang/String;", "getHourlyPurchaseShopId", "()Ljava/lang/String;", "storeId", "getStoreId", "setStoreId", "(Ljava/lang/String;)V", "receiveAddressId", "getReceiveAddressId", "addressType", "getAddressType", "", "userChooseStore", "Z", "getUserChooseStore", "()Z", "addressStrategy", "getAddressStrategy", "", "eventParams", "Ljava/util/Map;", "getEventParams", "()Ljava/util/Map;", "virtualRoomId", "getVirtualRoomId", "instantRoomType", "getInstantRoomType", "<init>", "()V", "Companion", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LivePromotionPageRoomInfo implements Serializable {
    public static final a Companion = null;
    public static final int INSTANT_ROOM_TYPE_FOOD_TAKEOUT = 102;
    public static final int INSTANT_ROOM_TYPE_HOUR_ARRIVED = 101;
    public static final int ROOM_TYPE_FLASH = 1;
    public static final int ROOM_TYPE_HOUR_ARRIVED = 2;
    public static final int ROOM_TYPE_NORMAL = 0;

    @SerializedName("address_strategy_type")
    private final String addressStrategy;

    @SerializedName("address_type")
    private final String addressType;

    @SerializedName("event_params")
    private final Map<String, String> eventParams;

    @SerializedName("hourly_purchase_shop_id")
    private final String hourlyPurchaseShopId;

    @SerializedName("instant_room_type")
    private final int instantRoomType;

    @SerializedName("minimum_guarantee_address")
    private final long minimumGuaranteeAddress;

    @SerializedName("receive_address_id")
    private final String receiveAddressId;

    @SerializedName("room_type")
    private final int roomType;

    @SerializedName("store_id")
    private String storeId;

    @SerializedName("user_choose_store")
    private final boolean userChooseStore;

    @SerializedName("virtual_room_id")
    private final long virtualRoomId;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public LivePromotionPageRoomInfo() {
    }

    public final String getAddressStrategy() {
        return this.addressStrategy;
    }

    public final String getAddressType() {
        return this.addressType;
    }

    public final Map<String, String> getEventParams() {
        return this.eventParams;
    }

    public final String getHourlyPurchaseShopId() {
        return this.hourlyPurchaseShopId;
    }

    public final int getInstantRoomType() {
        return this.instantRoomType;
    }

    public final long getMinimumGuaranteeAddress() {
        return this.minimumGuaranteeAddress;
    }

    public final String getReceiveAddressId() {
        return this.receiveAddressId;
    }

    public final int getRoomType() {
        return this.roomType;
    }

    public final String getStoreId() {
        return this.storeId;
    }

    public final boolean getUserChooseStore() {
        return this.userChooseStore;
    }

    public final long getVirtualRoomId() {
        return this.virtualRoomId;
    }

    public final void setStoreId(String r1) {
        this.storeId = r1;
    }
}
