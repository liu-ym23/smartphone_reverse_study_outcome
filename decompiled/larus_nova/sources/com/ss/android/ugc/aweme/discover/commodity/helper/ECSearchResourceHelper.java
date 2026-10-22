package com.ss.android.ugc.aweme.discover.commodity.helper;

import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/helper/ECSearchResourceHelper;", "", "<init>", "()V", "ECSearchTokenKey", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchResourceHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f450038a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ECSearchResourceHelper f450039b = null;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0019\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001a¨\u0006\u001b"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/helper/ECSearchResourceHelper$ECSearchTokenKey;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "ECSearchResultPageRadiusToken", "ECSearchCardRadius50Token", "ECSearchCardRadius100Token", "ECSearchCardRadius150Token", "ECSearchCardRadius200Token", "ECSearchCardRadius300Token", "ECSearchElementRadius100Token", "ECSearchElementRadius200Token", "ECSearchElementRadius300Token", "ECSearchEmptyPaddingToken", "ECSearchLimitedPaddingToken", "ECSearchGridPaddingToken", "ECSearch1XHalfPaddingToken", "ECSearch2xGridPaddingToken", "ECSearch2XHalfModulePaddingToken", "ECSearch3XModulePaddingToken", "ECSearch4XModulePaddingToken", "ECSearch5XPaddingToken", "ECSearch6XPaddingToken", "ECSearch8XPaddingToken", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum ECSearchTokenKey extends Enum<ECSearchTokenKey> {
        public static final ECSearchTokenKey ECSearch1XHalfPaddingToken = null;
        public static final ECSearchTokenKey ECSearch2XHalfModulePaddingToken = null;
        public static final ECSearchTokenKey ECSearch2xGridPaddingToken = null;
        public static final ECSearchTokenKey ECSearch3XModulePaddingToken = null;
        public static final ECSearchTokenKey ECSearch4XModulePaddingToken = null;
        public static final ECSearchTokenKey ECSearch5XPaddingToken = null;
        public static final ECSearchTokenKey ECSearch6XPaddingToken = null;
        public static final ECSearchTokenKey ECSearch8XPaddingToken = null;
        public static final ECSearchTokenKey ECSearchCardRadius100Token = null;
        public static final ECSearchTokenKey ECSearchCardRadius150Token = null;
        public static final ECSearchTokenKey ECSearchCardRadius200Token = null;
        public static final ECSearchTokenKey ECSearchCardRadius300Token = null;
        public static final ECSearchTokenKey ECSearchCardRadius50Token = null;
        public static final ECSearchTokenKey ECSearchElementRadius100Token = null;
        public static final ECSearchTokenKey ECSearchElementRadius200Token = null;
        public static final ECSearchTokenKey ECSearchElementRadius300Token = null;
        public static final ECSearchTokenKey ECSearchEmptyPaddingToken = null;
        public static final ECSearchTokenKey ECSearchGridPaddingToken = null;
        public static final ECSearchTokenKey ECSearchLimitedPaddingToken = null;
        public static final ECSearchTokenKey ECSearchResultPageRadiusToken = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ECSearchTokenKey[] f450040a = null;
        private final String value;

        public static ECSearchTokenKey valueOf(String r100) {
            return (ECSearchTokenKey) a.a(ECSearchTokenKey.class, r100);
        }

        public static ECSearchTokenKey[] values() {
            return (ECSearchTokenKey[]) f450040a.clone();
        }

        static {
            ECSearchTokenKey r100 = new ECSearchTokenKey("ECSearchResultPageRadiusToken", 0, "ec_search_result_page_radius_token");
            ECSearchResultPageRadiusToken = r100;
            ECSearchTokenKey r101 = new ECSearchTokenKey("ECSearchCardRadius50Token", 1, "ec_search_card_radius_50_token");
            ECSearchCardRadius50Token = r101;
            ECSearchTokenKey r102 = new ECSearchTokenKey("ECSearchCardRadius100Token", 2, "ec_search_card_radius_100_token");
            ECSearchCardRadius100Token = r102;
            ECSearchTokenKey r103 = new ECSearchTokenKey("ECSearchCardRadius150Token", 3, "ec_search_card_radius_150_token");
            ECSearchCardRadius150Token = r103;
            ECSearchTokenKey r104 = new ECSearchTokenKey("ECSearchCardRadius200Token", 4, "ec_search_card_radius_200_token");
            ECSearchCardRadius200Token = r104;
            ECSearchTokenKey r105 = new ECSearchTokenKey("ECSearchCardRadius300Token", 5, "ec_search_card_radius_300_token");
            ECSearchCardRadius300Token = r105;
            ECSearchTokenKey r106 = new ECSearchTokenKey("ECSearchElementRadius100Token", 6, "ec_search_element_radius_100_token");
            ECSearchElementRadius100Token = r106;
            ECSearchTokenKey r107 = new ECSearchTokenKey("ECSearchElementRadius200Token", 7, "ec_search_element_radius_200_token");
            ECSearchElementRadius200Token = r107;
            ECSearchTokenKey r108 = new ECSearchTokenKey("ECSearchElementRadius300Token", 8, "ec_search_element_radius_300_token");
            ECSearchElementRadius300Token = r108;
            ECSearchTokenKey r109 = new ECSearchTokenKey("ECSearchEmptyPaddingToken", 9, "ec_search_empty_padding_token");
            ECSearchEmptyPaddingToken = r109;
            ECSearchTokenKey r110 = new ECSearchTokenKey("ECSearchLimitedPaddingToken", 10, "ec_search_limited_padding_token");
            ECSearchLimitedPaddingToken = r110;
            ECSearchTokenKey r111 = new ECSearchTokenKey("ECSearchGridPaddingToken", 11, "ec_search_grid_padding_token");
            ECSearchGridPaddingToken = r111;
            ECSearchTokenKey r112 = new ECSearchTokenKey("ECSearch1XHalfPaddingToken", 12, "ec_search_1xhalf_padding_token");
            ECSearch1XHalfPaddingToken = r112;
            ECSearchTokenKey r113 = new ECSearchTokenKey("ECSearch2xGridPaddingToken", 13, "ec_search_2x_grid_padding_token");
            ECSearch2xGridPaddingToken = r113;
            ECSearchTokenKey r114 = new ECSearchTokenKey("ECSearch2XHalfModulePaddingToken", 14, "ec_search_2xhalf_module_padding_token");
            ECSearch2XHalfModulePaddingToken = r114;
            ECSearchTokenKey r115 = new ECSearchTokenKey("ECSearch3XModulePaddingToken", 15, "ec_search_3x_module_padding_token");
            ECSearch3XModulePaddingToken = r115;
            ECSearchTokenKey r116 = new ECSearchTokenKey("ECSearch4XModulePaddingToken", 16, "ec_search_4x_module_padding_token");
            ECSearch4XModulePaddingToken = r116;
            ECSearchTokenKey r117 = new ECSearchTokenKey("ECSearch5XPaddingToken", 17, "ec_search_5x_padding_token");
            ECSearch5XPaddingToken = r117;
            ECSearchTokenKey r118 = new ECSearchTokenKey("ECSearch6XPaddingToken", 18, "ec_search_6x_padding_token");
            ECSearch6XPaddingToken = r118;
            ECSearchTokenKey r119 = new ECSearchTokenKey("ECSearch8XPaddingToken", 19, "ec_search_8x_padding_token");
            ECSearch8XPaddingToken = r119;
            f450040a = new ECSearchTokenKey[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119};
        }

        public final String getValue() {
            return this.value;
        }

        public ECSearchTokenKey(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    private ECSearchResourceHelper() {
    }

    static {
        f450039b = new ECSearchResourceHelper();
        f450038a = LazyKt.lazy(ECSearchResourceHelper$ecSearchStandardUITokenValue$2.INSTANCE);
    }

    public final float a() {
        return b(this, ECSearchTokenKey.ECSearchGridPaddingToken);
    }

    public static float b(ECSearchResourceHelper r100, ECSearchTokenKey r101) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "tokenKey");
        Integer r102 = (Integer) ((Map) f450038a.getValue()).get(r101.getValue());
        if (r102 == null) goto L5;
        int r103 = r102.intValue();
    L7:
        return r103;
    L5:
        r103 = 0;
        goto L7
    }
}
