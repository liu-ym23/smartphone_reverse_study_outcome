package th3;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u001c\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010$\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001a\u0010\u0013\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u001a\u0010\u0015\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R\u001a\u0010\u0017\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u001a\u0010\u0019\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006R\u001a\u0010\u001b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006R\u001a\u0010\u001d\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006R\u001a\u0010 \u001a\u00020\u001f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010\u0004\u001a\u0004\b%\u0010\u0006R\u001c\u0010&\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010\u0004\u001a\u0004\b'\u0010\u0006R\u001c\u0010(\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010\u0004\u001a\u0004\b)\u0010\u0006R*\u0010+\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010*8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.¨\u0006/"}, d2 = {"Lth3/b;", "", "", "ecomPageType", "Ljava/lang/String;", "h", "()Ljava/lang/String;", "promotionId", "o", "productId", OfficeSDKRequestTag.KEY_NEW_USER, "originType", "m", "originId", "l", "comboId", "e", "comboNum", "f", "specDesc", "q", "deviceId", ce.f26391f, "extra", RXScreenCaptureService.KEY_INDEX, "authorId", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "secAuthorId", "p", RemoteMessageConst.Notification.CHANNEL_ID, "c", "", "channelType", "I", "d", "()I", "bcmChain", "b", "foodTakeoutCustomPropertyList", ce.f26395j, "foodTakeoutSalePackageList", ce.f26396k, "", "extraParamsMap", "Ljava/util/Map;", "getExtraParamsMap", "()Ljava/util/Map;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("author_id")
    private final String authorId;

    @SerializedName("bcm_chain")
    private final String bcmChain;

    @SerializedName("product_channel_id")
    private final String channelId;

    @SerializedName("product_channel_type")
    private final int channelType;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_COMBO_ID)
    private final String comboId;

    @SerializedName("combo_num")
    private final String comboNum;

    @SerializedName("device_id")
    private final String deviceId;

    @SerializedName("ecom_page_type")
    private final String ecomPageType;

    @SerializedName("extra")
    private final String extra;

    @SerializedName("extra_params_map")
    private final Map<String, Object> extraParamsMap;

    @SerializedName("custom_property_list")
    private final String foodTakeoutCustomPropertyList;

    @SerializedName("sale_package_list")
    private final String foodTakeoutSalePackageList;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_ORIGIN_ID)
    private final String originId;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_ORIGIN_TYPE)
    private final String originType;

    @SerializedName("product_id")
    private final String productId;

    @SerializedName("campaign_id")
    private final String promotionId;

    @SerializedName("sec_author_id")
    private final String secAuthorId;

    @SerializedName("spec_desc")
    private final String specDesc;

    public b() {
        throw null;
    }

    public final String a() {
        return this.authorId;
    }

    public final String b() {
        return this.bcmChain;
    }

    public final String c() {
        return this.channelId;
    }

    public final int d() {
        return this.channelType;
    }

    public final String e() {
        return this.comboId;
    }

    public final String f() {
        return this.comboNum;
    }

    public final String g() {
        return this.deviceId;
    }

    public final String h() {
        return this.ecomPageType;
    }

    public final String i() {
        return this.extra;
    }

    public final String j() {
        return this.foodTakeoutCustomPropertyList;
    }

    public final String k() {
        return this.foodTakeoutSalePackageList;
    }

    public final String l() {
        return this.originId;
    }

    public final String m() {
        return this.originType;
    }

    public final String n() {
        return this.productId;
    }

    public final String o() {
        return this.promotionId;
    }

    public final String p() {
        return this.secAuthorId;
    }

    public final String q() {
        return this.specDesc;
    }

    public b(String r110, String r111, String r112, String r113, String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, int r218, String r219, String r310, String r311) {
        Intrinsics.checkNotNullParameter("native", "ecomPageType");
        Intrinsics.checkNotNullParameter(r110, "promotionId");
        Intrinsics.checkNotNullParameter(r111, "productId");
        Intrinsics.checkNotNullParameter(r112, "originType");
        Intrinsics.checkNotNullParameter(r113, "originId");
        Intrinsics.checkNotNullParameter(r210, "comboId");
        Intrinsics.checkNotNullParameter(r211, "comboNum");
        Intrinsics.checkNotNullParameter(r212, "specDesc");
        Intrinsics.checkNotNullParameter(r213, "deviceId");
        Intrinsics.checkNotNullParameter(r214, "extra");
        Intrinsics.checkNotNullParameter(r215, "authorId");
        Intrinsics.checkNotNullParameter(r216, "secAuthorId");
        Intrinsics.checkNotNullParameter(r217, RemoteMessageConst.Notification.CHANNEL_ID);
        this.ecomPageType = "native";
        this.promotionId = r110;
        this.productId = r111;
        this.originType = r112;
        this.originId = r113;
        this.comboId = r210;
        this.comboNum = r211;
        this.specDesc = r212;
        this.deviceId = r213;
        this.extra = r214;
        this.authorId = r215;
        this.secAuthorId = r216;
        this.channelId = r217;
        this.channelType = r218;
        this.bcmChain = r219;
        this.foodTakeoutCustomPropertyList = r310;
        this.foodTakeoutSalePackageList = r311;
        this.extraParamsMap = null;
    }
}
