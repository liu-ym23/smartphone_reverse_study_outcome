package com.bytedance.android.shopping.feed.event.goodprice.enums;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/shopping/feed/event/goodprice/enums/LocationType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "INFLOW_MAIN_CARD_TAG", "INFLOW_RESOURCE_CARD_MAIN", "INFLOW_RESOURCE_CARD_SEARCH", "INFLOW_MAIN_CARD_TITLE", "INFLOW_MAIN_CARD_IMAGE", "INFLOW_MAIN_CARD_IMAGE_WIDTH_FEEDBACK", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LocationType extends Enum<LocationType> {
    public static final LocationType INFLOW_MAIN_CARD_IMAGE = null;
    public static final LocationType INFLOW_MAIN_CARD_IMAGE_WIDTH_FEEDBACK = null;
    public static final LocationType INFLOW_MAIN_CARD_TAG = null;
    public static final LocationType INFLOW_MAIN_CARD_TITLE = null;
    public static final LocationType INFLOW_RESOURCE_CARD_MAIN = null;
    public static final LocationType INFLOW_RESOURCE_CARD_SEARCH = null;
    public static final /* synthetic */ LocationType[] a = null;
    private final String type;

    static {
        LocationType r1 = new LocationType("INFLOW_MAIN_CARD_TAG", 0, "inflow_main_card_tag");
        INFLOW_MAIN_CARD_TAG = r1;
        LocationType r2 = new LocationType("INFLOW_RESOURCE_CARD_MAIN", 1, "inflow_resource_card_main");
        INFLOW_RESOURCE_CARD_MAIN = r2;
        LocationType r3 = new LocationType("INFLOW_RESOURCE_CARD_SEARCH", 2, "inflow_resource_card_search");
        INFLOW_RESOURCE_CARD_SEARCH = r3;
        LocationType r4 = new LocationType("INFLOW_MAIN_CARD_TITLE", 3, "inflow_main_card_title");
        INFLOW_MAIN_CARD_TITLE = r4;
        LocationType r5 = new LocationType("INFLOW_MAIN_CARD_IMAGE", 4, "inflow_main_card_image");
        INFLOW_MAIN_CARD_IMAGE = r5;
        LocationType r6 = new LocationType("INFLOW_MAIN_CARD_IMAGE_WIDTH_FEEDBACK", 5, "inflow_main_card_image_with_feedback");
        INFLOW_MAIN_CARD_IMAGE_WIDTH_FEEDBACK = r6;
        a = new LocationType[]{r1, r2, r3, r4, r5, r6};
    }

    public static LocationType valueOf(String r1) {
        return (LocationType) a.a(LocationType.class, r1);
    }

    public static LocationType[] values() {
        return (LocationType[]) a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public LocationType(String r1, int r2, String r3) {
        super(r1, r2);
        this.type = r3;
    }
}
