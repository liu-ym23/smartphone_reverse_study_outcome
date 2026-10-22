package th3;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010$\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001a\u0010\u0010\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006R*\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lth3/a;", "", "", "productId", "Ljava/lang/String;", RXScreenCaptureService.KEY_INDEX, "()Ljava/lang/String;", "comboId", "d", "comboNum", "e", "extra", "f", RemoteMessageConst.Notification.CHANNEL_ID, "b", "", "channelType", "I", "c", "()I", "bcmChain", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "foodTakeoutCustomPropertyList", ce.f26391f, "foodTakeoutSalePackageList", "h", "", "extraParamsMap", "Ljava/util/Map;", "getExtraParamsMap", "()Ljava/util/Map;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

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

    @SerializedName("extra")
    private final String extra;

    @SerializedName("extra_params_map")
    private final Map<String, Object> extraParamsMap;

    @SerializedName("custom_property_list")
    private final String foodTakeoutCustomPropertyList;

    @SerializedName("sale_package_list")
    private final String foodTakeoutSalePackageList;

    @SerializedName("product_id")
    private final String productId;

    public a() {
        throw null;
    }

    public final String a() {
        return this.bcmChain;
    }

    public final String b() {
        return this.channelId;
    }

    public final int c() {
        return this.channelType;
    }

    public final String d() {
        return this.comboId;
    }

    public final String e() {
        return this.comboNum;
    }

    public final String f() {
        return this.extra;
    }

    public final String g() {
        return this.foodTakeoutCustomPropertyList;
    }

    public final String h() {
        return this.foodTakeoutSalePackageList;
    }

    public final String i() {
        return this.productId;
    }

    public a(String r100, String r101, String r102, String r103, String r104, int r105, String r106, String r107, String r110) {
        Intrinsics.checkNotNullParameter(r100, "productId");
        Intrinsics.checkNotNullParameter(r101, "comboId");
        Intrinsics.checkNotNullParameter(r102, "comboNum");
        Intrinsics.checkNotNullParameter(r103, "extra");
        Intrinsics.checkNotNullParameter(r104, RemoteMessageConst.Notification.CHANNEL_ID);
        this.productId = r100;
        this.comboId = r101;
        this.comboNum = r102;
        this.extra = r103;
        this.channelId = r104;
        this.channelType = r105;
        this.bcmChain = r106;
        this.foodTakeoutCustomPropertyList = r107;
        this.foodTakeoutSalePackageList = r110;
        this.extraParamsMap = null;
    }
}
