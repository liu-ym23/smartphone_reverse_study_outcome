package com.bytedance.awemeopen.bizmodels.feed.anchor;

import com.larus.media.MediaScene;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b'\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(¨\u0006)"}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/feed/anchor/AnchorBusinessType;", "", "", "TYPE", "I", "getTYPE", "()I", "setTYPE", "(I)V", "NO_TYPE", "WIKIPEDIA", "WIKIHOW", "POI", "SHOP", "MICRO_APP", "ARTICLE", "ANCHOR_SHOP_LINK", "SEEDING", "YELP", "TRIP_ADVISOR", "GAME", "MEDIUM", "UG", "COUPON", "MICRO_GAME", "OPEN_PLATFORM_ANCHOR", "MIXED_VIDEO", "BRAND_WIKI", "INDIA_MOVIE", "IDOL", "OPERATION", "ANCHOR_RESSO", "MOMENT", "ANCHOR_RESSO_EXCLUSIVE", "CAR", "NET_SERVICE", "DONATION_STICKER", "PHOTO_MV_ANCHOR", MediaScene.NEWS, "COMMON_TYPE", "CLOUD_GAME", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final enum AnchorBusinessType extends Enum<AnchorBusinessType> {
    public static final AnchorBusinessType ANCHOR_RESSO = null;
    public static final AnchorBusinessType ANCHOR_RESSO_EXCLUSIVE = null;
    public static final AnchorBusinessType ANCHOR_SHOP_LINK = null;
    public static final AnchorBusinessType ARTICLE = null;
    public static final AnchorBusinessType BRAND_WIKI = null;
    public static final AnchorBusinessType CAR = null;
    public static final AnchorBusinessType CLOUD_GAME = null;
    public static final AnchorBusinessType COMMON_TYPE = null;
    public static final AnchorBusinessType COUPON = null;
    public static final AnchorBusinessType DONATION_STICKER = null;
    public static final AnchorBusinessType GAME = null;
    public static final AnchorBusinessType IDOL = null;
    public static final AnchorBusinessType INDIA_MOVIE = null;
    public static final AnchorBusinessType MEDIUM = null;
    public static final AnchorBusinessType MICRO_APP = null;
    public static final AnchorBusinessType MICRO_GAME = null;
    public static final AnchorBusinessType MIXED_VIDEO = null;
    public static final AnchorBusinessType MOMENT = null;
    public static final AnchorBusinessType NET_SERVICE = null;
    public static final AnchorBusinessType NEWS = null;
    public static final AnchorBusinessType NO_TYPE = null;
    public static final AnchorBusinessType OPEN_PLATFORM_ANCHOR = null;
    public static final AnchorBusinessType OPERATION = null;
    public static final AnchorBusinessType PHOTO_MV_ANCHOR = null;
    public static final AnchorBusinessType POI = null;
    public static final AnchorBusinessType SEEDING = null;
    public static final AnchorBusinessType SHOP = null;
    public static final AnchorBusinessType TRIP_ADVISOR = null;
    public static final AnchorBusinessType UG = null;
    public static final AnchorBusinessType WIKIHOW = null;
    public static final AnchorBusinessType WIKIPEDIA = null;
    public static final AnchorBusinessType YELP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AnchorBusinessType[] f198176a = null;
    private int TYPE;

    public static AnchorBusinessType valueOf(String r100) {
        return (AnchorBusinessType) a.a(AnchorBusinessType.class, r100);
    }

    public static AnchorBusinessType[] values() {
        return (AnchorBusinessType[]) f198176a.clone();
    }

    static {
        AnchorBusinessType r100 = new AnchorBusinessType("NO_TYPE", 0, -1);
        NO_TYPE = r100;
        AnchorBusinessType r101 = new AnchorBusinessType("WIKIPEDIA", 1, 0);
        WIKIPEDIA = r101;
        AnchorBusinessType r102 = new AnchorBusinessType("WIKIHOW", 2, 1);
        WIKIHOW = r102;
        AnchorBusinessType r103 = new AnchorBusinessType("POI", 3, 2);
        POI = r103;
        AnchorBusinessType r104 = new AnchorBusinessType("SHOP", 4, 3);
        SHOP = r104;
        AnchorBusinessType r105 = new AnchorBusinessType("MICRO_APP", 5, 4);
        MICRO_APP = r105;
        AnchorBusinessType r110 = new AnchorBusinessType("ARTICLE", 6, 5);
        ARTICLE = r110;
        AnchorBusinessType r111 = new AnchorBusinessType("ANCHOR_SHOP_LINK", 7, 6);
        ANCHOR_SHOP_LINK = r111;
        AnchorBusinessType r112 = new AnchorBusinessType("SEEDING", 8, 7);
        SEEDING = r112;
        AnchorBusinessType r113 = new AnchorBusinessType("YELP", 9, 8);
        YELP = r113;
        AnchorBusinessType r114 = new AnchorBusinessType("TRIP_ADVISOR", 10, 9);
        TRIP_ADVISOR = r114;
        AnchorBusinessType r115 = new AnchorBusinessType("GAME", 11, 10);
        GAME = r115;
        AnchorBusinessType r106 = new AnchorBusinessType("MEDIUM", 12, 11);
        MEDIUM = r106;
        AnchorBusinessType r107 = new AnchorBusinessType("UG", 13, 12);
        UG = r107;
        AnchorBusinessType r108 = new AnchorBusinessType("COUPON", 14, 13);
        COUPON = r108;
        AnchorBusinessType r109 = new AnchorBusinessType("MICRO_GAME", 15, 14);
        MICRO_GAME = r109;
        AnchorBusinessType r116 = new AnchorBusinessType("OPEN_PLATFORM_ANCHOR", 16, 15);
        OPEN_PLATFORM_ANCHOR = r116;
        AnchorBusinessType r117 = new AnchorBusinessType("MIXED_VIDEO", 17, 16);
        MIXED_VIDEO = r117;
        AnchorBusinessType r118 = new AnchorBusinessType("BRAND_WIKI", 18, 17);
        BRAND_WIKI = r118;
        AnchorBusinessType r119 = new AnchorBusinessType("INDIA_MOVIE", 19, 18);
        INDIA_MOVIE = r119;
        AnchorBusinessType r120 = new AnchorBusinessType("IDOL", 20, 21);
        IDOL = r120;
        AnchorBusinessType r121 = new AnchorBusinessType("OPERATION", 21, 22);
        OPERATION = r121;
        AnchorBusinessType r122 = new AnchorBusinessType("ANCHOR_RESSO", 22, 23);
        ANCHOR_RESSO = r122;
        AnchorBusinessType r123 = new AnchorBusinessType("MOMENT", 23, 25);
        MOMENT = r123;
        AnchorBusinessType r124 = new AnchorBusinessType("ANCHOR_RESSO_EXCLUSIVE", 24, 27);
        ANCHOR_RESSO_EXCLUSIVE = r124;
        AnchorBusinessType r125 = new AnchorBusinessType("CAR", 25, 1000);
        CAR = r125;
        AnchorBusinessType r126 = new AnchorBusinessType("NET_SERVICE", 26, 1001);
        NET_SERVICE = r126;
        AnchorBusinessType r127 = new AnchorBusinessType("DONATION_STICKER", 27, 19);
        DONATION_STICKER = r127;
        AnchorBusinessType r128 = new AnchorBusinessType("PHOTO_MV_ANCHOR", 28, 10001);
        PHOTO_MV_ANCHOR = r128;
        AnchorBusinessType r129 = new AnchorBusinessType(MediaScene.NEWS, 29, 32);
        NEWS = r129;
        AnchorBusinessType r130 = new AnchorBusinessType("COMMON_TYPE", 30, -100);
        COMMON_TYPE = r130;
        AnchorBusinessType r131 = new AnchorBusinessType("CLOUD_GAME", 31, -2);
        CLOUD_GAME = r131;
        f198176a = new AnchorBusinessType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131};
    }

    public final int getTYPE() {
        return this.TYPE;
    }

    public final void setTYPE(int r100) {
        this.TYPE = r100;
    }

    public AnchorBusinessType(String r100, int r101, int r102) {
        super(r100, r101);
        this.TYPE = r102;
    }
}
