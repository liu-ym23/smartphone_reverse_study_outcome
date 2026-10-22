package wt;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.gamecp.api.GamePropInfo")
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u0007R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0007R\u001e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0004R\u001e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0011R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0007R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0007¨\u0006\u001b"}, d2 = {"Lwt/e;", "", "", "propId", "Ljava/lang/String;", "", "skuId", "Ljava/lang/Long;", "propName", "propDescription", Keys.API_PARAM_KEY_PLATFORM_TYPE, "propUrl", "sellingPrice", "marketPrice", "", "Lwt/l;", "subPropList", "Ljava/util/List;", "", "isIntroducing", "Z", "guideDescription", "guideImages", "propType", "afterCouponPrice", "<init>", "()V", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e implements vh7.h {

    @SerializedName("after_coupon_price")
    public Long afterCouponPrice;

    @SerializedName("guide_description")
    public String guideDescription;

    @SerializedName("guide_images")
    public List<String> guideImages;

    @SerializedName("is_introducing")
    public boolean isIntroducing;

    @SerializedName("market_price")
    public Long marketPrice;

    @SerializedName("platform_type")
    public Long platformType;

    @SerializedName("prop_description")
    public String propDescription;

    @SerializedName("prop_id")
    public String propId;

    @SerializedName("prop_name")
    public String propName;

    @SerializedName("prop_type")
    public Long propType;

    @SerializedName("prop_icon")
    public String propUrl;

    @SerializedName("selling_price")
    public Long sellingPrice;

    @SerializedName("prop_sku_id")
    public Long skuId;

    @SerializedName("sub_items")
    public List<l> subPropList;

    public e() {
        this.propId = "";
        this.skuId = 0L;
        this.propName = "";
        this.propDescription = "";
        this.platformType = 0L;
        this.propUrl = "";
        this.sellingPrice = 0L;
        this.marketPrice = 0L;
        this.guideDescription = "";
        this.propType = 0L;
        this.afterCouponPrice = 0L;
    }

    public e(am3.g r100) {
        this.subPropList = new ArrayList();
        this.guideImages = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L22;
        switch(r102) {
            case 1: goto L21;
            case 2: goto L20;
            case 3: goto L19;
            case 4: goto L18;
            case 5: goto L17;
            case 6: goto L16;
            case 7: goto L6;
            case 8: goto L6;
            case 9: goto L15;
            case 10: goto L14;
            case 11: goto L6;
            case 12: goto L12;
            case 13: goto L11;
            case 14: goto L6;
            case 15: goto L6;
            case 16: goto L10;
            case 17: goto L9;
            case 18: goto L8;
            case 19: goto L7;
            default: goto L6;
        };
    L7:
        this.afterCouponPrice = Long.valueOf(r100.j());
        goto L3
    L8:
        this.propType = Long.valueOf(r100.j());
        goto L3
    L9:
        List r103 = this.guideImages;
        Object r104 = am3.h.c(r100);
    L13:
        r103.add(r104);
        goto L3
    L10:
        this.guideDescription = am3.h.c(r100);
        goto L3
    L11:
        this.isIntroducing = am3.h.a(r100);
        goto L3
    L12:
        r103 = this.subPropList;
        r104 = new l(r100);
        goto L13
    L14:
        this.sellingPrice = Long.valueOf(r100.j());
        goto L3
    L15:
        this.marketPrice = Long.valueOf(r100.j());
        goto L3
    L16:
        this.propUrl = am3.h.c(r100);
        goto L3
    L17:
        this.platformType = Long.valueOf(r100.j());
        goto L3
    L18:
        this.propDescription = am3.h.c(r100);
        goto L3
    L19:
        this.propName = am3.h.c(r100);
        goto L3
    L20:
        this.skuId = Long.valueOf(r100.j());
        goto L3
    L21:
        this.propId = am3.h.c(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L22:
        r100.d(r101);
        if (this.propId != null) goto L26;
        this.propId = "";
    L26:
        if (this.skuId != null) goto L29;
        this.skuId = 0L;
    L29:
        if (this.propName != null) goto L32;
        this.propName = "";
    L32:
        if (this.propDescription != null) goto L35;
        this.propDescription = "";
    L35:
        if (this.platformType != null) goto L38;
        this.platformType = 0L;
    L38:
        if (this.propUrl != null) goto L41;
        this.propUrl = "";
    L41:
        if (this.sellingPrice != null) goto L44;
        this.sellingPrice = 0L;
    L44:
        if (this.marketPrice != null) goto L47;
        this.marketPrice = 0L;
    L47:
        if (this.guideDescription != null) goto L50;
        this.guideDescription = "";
    L50:
        if (this.propType != null) goto L53;
        this.propType = 0L;
    L53:
        if (this.afterCouponPrice != null) goto L87;
        this.afterCouponPrice = 0L;
        return;
    }
}
