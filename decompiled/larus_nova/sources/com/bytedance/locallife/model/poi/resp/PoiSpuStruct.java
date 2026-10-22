package com.bytedance.locallife.model.poi.resp;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\bC\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BÇ\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0003\u0012,\b\u0002\u0010\"\u001a&\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010$\u0018\u00010#j\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010$\u0018\u0001`%¢\u0006\u0002\u0010&J\u000b\u0010N\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010O\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u00108J\u000b\u0010P\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\t\u0010S\u001a\u00020\u0005HÆ\u0003J\t\u0010T\u001a\u00020\u000fHÆ\u0003J\t\u0010U\u001a\u00020\u0005HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010X\u001a\u0004\u0018\u00010\u001dHÆ\u0003¢\u0006\u0002\u0010/J\u0010\u0010Y\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010,J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010[\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010,J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010^\u001a&\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010$\u0018\u00010#j\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010$\u0018\u0001`%HÆ\u0003J\u0010\u0010_\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010,J\u0010\u0010`\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010,J\u000b\u0010a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010d\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fHÆ\u0003J\u0010\u0010e\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u00108JÐ\u0002\u0010f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u000f2\b\b\u0002\u0010\u0018\u001a\u00020\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00032,\b\u0002\u0010\"\u001a&\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010$\u0018\u00010#j\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010$\u0018\u0001`%HÆ\u0001¢\u0006\u0002\u0010gJ\u0013\u0010h\u001a\u00020i2\b\u0010j\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010k\u001a\u00020\u0005HÖ\u0001J\t\u0010l\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0018\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010-\u001a\u0004\b+\u0010,R\u001a\u0010\u001c\u001a\u0004\u0018\u00010\u001d8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00100\u001a\u0004\b.\u0010/R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010*R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0018\u0010 \u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010*R\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00109\u001a\u0004\b7\u00108R\u0016\u0010\u0016\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010(R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00109\u001a\u0004\b=\u00108R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010*R\u001a\u0010\u001f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010-\u001a\u0004\b?\u0010,R\u001e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010*R\u0018\u0010!\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010*R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010*R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010*R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010-\u001a\u0004\bH\u0010,R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010-\u001a\u0004\bI\u0010,R:\u0010\"\u001a&\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010$\u0018\u00010#j\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010$\u0018\u0001`%8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR\u0016\u0010\u0017\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bL\u0010M¨\u0006m"}, d2 = {"Lcom/bytedance/locallife/model/poi/resp/PoiSpuStruct;", "Ljava/io/Serializable;", "spuId", "", "status", "", "spuType", "customerSource", "customerName", "spuName", "serviceTypeBury", "saleTags", "", "Lcom/bytedance/locallife/model/poi/resp/PoiSpuTag;", "price", "", "originPrice", "imageTag", "spuStat", "Lcom/bytedance/locallife/model/poi/resp/SpuStatInfoStruct;", "poiInfo", "Lcom/bytedance/locallife/model/poi/resp/SimplePoiInfoStruct;", "poiCount", "validTimeEnd", "consumptionTimes", "iconServiceType", "Lcom/bytedance/locallife/model/poi/resp/PoiIconServiceType;", "priceSuffix", "discount", "", "discountInfo", "productTypeFromCenter", "mulApplicablePoiPageUrl", "specialSaleText", "trackParams", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Long;Ljava/lang/Long;Lcom/bytedance/locallife/model/poi/resp/PoiSpuTag;Lcom/bytedance/locallife/model/poi/resp/SpuStatInfoStruct;Lcom/bytedance/locallife/model/poi/resp/SimplePoiInfoStruct;IJILcom/bytedance/locallife/model/poi/resp/PoiIconServiceType;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;)V", "getConsumptionTimes", "()I", "getCustomerName", "()Ljava/lang/String;", "getCustomerSource", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDiscount", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getDiscountInfo", "getIconServiceType", "()Lcom/bytedance/locallife/model/poi/resp/PoiIconServiceType;", "getImageTag", "()Lcom/bytedance/locallife/model/poi/resp/PoiSpuTag;", "getMulApplicablePoiPageUrl", "getOriginPrice", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getPoiCount", "getPoiInfo", "()Lcom/bytedance/locallife/model/poi/resp/SimplePoiInfoStruct;", "getPrice", "getPriceSuffix", "getProductTypeFromCenter", "getSaleTags", "()Ljava/util/List;", "getServiceTypeBury", "getSpecialSaleText", "getSpuId", "getSpuName", "getSpuStat", "()Lcom/bytedance/locallife/model/poi/resp/SpuStatInfoStruct;", "getSpuType", "getStatus", "getTrackParams", "()Ljava/util/HashMap;", "getValidTimeEnd", "()J", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Long;Ljava/lang/Long;Lcom/bytedance/locallife/model/poi/resp/PoiSpuTag;Lcom/bytedance/locallife/model/poi/resp/SpuStatInfoStruct;Lcom/bytedance/locallife/model/poi/resp/SimplePoiInfoStruct;IJILcom/bytedance/locallife/model/poi/resp/PoiIconServiceType;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;)Lcom/bytedance/locallife/model/poi/resp/PoiSpuStruct;", "equals", "", "other", "hashCode", "toString", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class PoiSpuStruct implements Serializable {

    @SerializedName("consumption_times")
    private final int consumptionTimes;

    @SerializedName("customer_name")
    private final String customerName;

    @SerializedName("customer_source")
    private final Integer customerSource;

    @SerializedName("discount")
    private final Double discount;

    @SerializedName("discount_info")
    private final String discountInfo;

    @SerializedName("icon_service_type")
    private final PoiIconServiceType iconServiceType;

    @SerializedName("image_tag")
    private final PoiSpuTag imageTag;

    @SerializedName("mul_applicable_poi_page_url")
    private final String mulApplicablePoiPageUrl;

    @SerializedName("origin_price")
    private final Long originPrice;

    @SerializedName("poi_count")
    private final int poiCount;

    @SerializedName("poi_info")
    private final SimplePoiInfoStruct poiInfo;

    @SerializedName("price")
    private final Long price;

    @SerializedName("price_suffix")
    private final String priceSuffix;

    @SerializedName("product_type_from_center")
    private final Integer productTypeFromCenter;

    @SerializedName("sale_tags")
    private final List<PoiSpuTag> saleTags;

    @SerializedName("service_type_bury")
    private final String serviceTypeBury;

    @SerializedName("special_sale_text")
    private final String specialSaleText;

    @SerializedName("spu_id")
    private final String spuId;

    @SerializedName("spu_name")
    private final String spuName;

    @SerializedName("spu_stat")
    private final SpuStatInfoStruct spuStat;

    @SerializedName("spu_type")
    private final Integer spuType;

    @SerializedName("status")
    private final Integer status;

    @SerializedName("track_params")
    private final HashMap<String, Object> trackParams;

    @SerializedName("valid_time_end")
    private final long validTimeEnd;

    public PoiSpuStruct() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, 0, 0, 0, null, null, null, null, null, null, null, null, 16777215, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PoiSpuStruct copy$default(PoiSpuStruct r110, String r111, Integer r112, Integer r210, Integer r211, String r212, String r213, String r214, List r215, Long r216, Long r217, PoiSpuTag r218, SpuStatInfoStruct r219, SimplePoiInfoStruct r310, int r311, long r312, int r313, PoiIconServiceType r314, String r315, Double r316, String r317, Integer r318, String r410, String r411, HashMap r412, int r413, Object r414) {
        if ((r413 & 1) == 0) goto L5;
        String r100 = r110.spuId;
    L7:
        if ((r413 & 2) == 0) goto L9;
        Integer r101 = r110.status;
    L11:
        if ((r413 & 4) == 0) goto L13;
        Integer r102 = r110.spuType;
    L15:
        if ((r413 & 8) == 0) goto L17;
        Integer r103 = r110.customerSource;
    L19:
        if ((r413 & 16) == 0) goto L21;
        String r104 = r110.customerName;
    L23:
        if ((r413 & 32) == 0) goto L25;
        String r105 = r110.spuName;
    L27:
        if ((r413 & 64) == 0) goto L29;
        String r106 = r110.serviceTypeBury;
    L31:
        if ((r413 & 128) == 0) goto L33;
        List r107 = r110.saleTags;
    L35:
        if ((r413 & 256) == 0) goto L37;
        Long r113 = r110.price;
    L39:
        if ((r413 & 512) == 0) goto L41;
        Long r114 = r110.originPrice;
    L43:
        if ((r413 & 1024) == 0) goto L45;
        PoiSpuTag r115 = r110.imageTag;
    L47:
        if ((r413 & 2048) == 0) goto L49;
        SpuStatInfoStruct r116 = r110.spuStat;
    L51:
        if ((r413 & 4096) == 0) goto L53;
        SimplePoiInfoStruct r117 = r110.poiInfo;
    L55:
        if ((r413 & 8192) == 0) goto L57;
        int r118 = r110.poiCount;
    L58:
        int r319 = r118;
        SimplePoiInfoStruct r320 = r117;
        if ((r413 & 16384) == 0) goto L61;
        long r119 = r110.validTimeEnd;
    L62:
        long r321 = r119;
        if ((r413 & 32768) == 0) goto L65;
        int r120 = r110.consumptionTimes;
    L67:
        if ((65536 & r413) == 0) goto L69;
        PoiIconServiceType r121 = r110.iconServiceType;
    L70:
        PoiIconServiceType r322 = r121;
        if ((r413 & 131072) == 0) goto L73;
        String r122 = r110.priceSuffix;
    L74:
        String r323 = r122;
        if ((r413 & 262144) == 0) goto L77;
        Double r123 = r110.discount;
    L78:
        Double r324 = r123;
        if ((r413 & 524288) == 0) goto L81;
        String r124 = r110.discountInfo;
    L82:
        String r325 = r124;
        if ((r413 & 1048576) == 0) goto L85;
        Integer r125 = r110.productTypeFromCenter;
    L86:
        Integer r326 = r125;
        if ((r413 & 2097152) == 0) goto L89;
        String r126 = r110.mulApplicablePoiPageUrl;
    L90:
        String r415 = r126;
        if ((r413 & 4194304) == 0) goto L93;
        String r127 = r110.specialSaleText;
    L95:
        if ((r413 & 8388608) == 0) goto L97;
        HashMap r108 = r110.trackParams;
    L99:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r320, r319, r321, r120, r322, r323, r324, r325, r326, r415, r127, r108);
    L97:
        r108 = r412;
        goto L99
    L93:
        r127 = r411;
        goto L95
    L89:
        r126 = r410;
        goto L90
    L85:
        r125 = r318;
        goto L86
    L81:
        r124 = r317;
        goto L82
    L77:
        r123 = r316;
        goto L78
    L73:
        r122 = r315;
        goto L74
    L69:
        r121 = r314;
        goto L70
    L65:
        r120 = r313;
        goto L67
    L61:
        r119 = r312;
        goto L62
    L57:
        r118 = r311;
        goto L58
    L53:
        r117 = r310;
        goto L55
    L49:
        r116 = r219;
        goto L51
    L45:
        r115 = r218;
        goto L47
    L41:
        r114 = r217;
        goto L43
    L37:
        r113 = r216;
        goto L39
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.spuId;
    }

    public final Long component10() {
        return this.originPrice;
    }

    public final PoiSpuTag component11() {
        return this.imageTag;
    }

    public final SpuStatInfoStruct component12() {
        return this.spuStat;
    }

    public final SimplePoiInfoStruct component13() {
        return this.poiInfo;
    }

    public final int component14() {
        return this.poiCount;
    }

    public final long component15() {
        return this.validTimeEnd;
    }

    public final int component16() {
        return this.consumptionTimes;
    }

    public final PoiIconServiceType component17() {
        return this.iconServiceType;
    }

    public final String component18() {
        return this.priceSuffix;
    }

    public final Double component19() {
        return this.discount;
    }

    public final Integer component2() {
        return this.status;
    }

    public final String component20() {
        return this.discountInfo;
    }

    public final Integer component21() {
        return this.productTypeFromCenter;
    }

    public final String component22() {
        return this.mulApplicablePoiPageUrl;
    }

    public final String component23() {
        return this.specialSaleText;
    }

    public final HashMap<String, Object> component24() {
        return this.trackParams;
    }

    public final Integer component3() {
        return this.spuType;
    }

    public final Integer component4() {
        return this.customerSource;
    }

    public final String component5() {
        return this.customerName;
    }

    public final String component6() {
        return this.spuName;
    }

    public final String component7() {
        return this.serviceTypeBury;
    }

    public final List<PoiSpuTag> component8() {
        return this.saleTags;
    }

    public final Long component9() {
        return this.price;
    }

    public final PoiSpuStruct copy(String r210, Integer r211, Integer r310, Integer r311, String r312, String r313, String r314, List<PoiSpuTag> r315, Long r316, Long r317, PoiSpuTag r318, SpuStatInfoStruct r319, SimplePoiInfoStruct r410, int r411, long r412, int r413, PoiIconServiceType r414, String r415, Double r416, String r417, Integer r418, String r510, String r511, HashMap<String, Object> r512) {
        return new PoiSpuStruct(r210, r211, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, r415, r416, r417, r418, r510, r511, r512);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PoiSpuStruct) == true) goto L8;
        return false;
    L8:
        PoiSpuStruct r101 = (PoiSpuStruct) r100;
        if (Intrinsics.areEqual(this.spuId, r101.spuId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.status, r101.status) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.spuType, r101.spuType) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.customerSource, r101.customerSource) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.customerName, r101.customerName) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.spuName, r101.spuName) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.serviceTypeBury, r101.serviceTypeBury) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.saleTags, r101.saleTags) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.price, r101.price) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.originPrice, r101.originPrice) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.imageTag, r101.imageTag) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.spuStat, r101.spuStat) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.poiInfo, r101.poiInfo) == true) goto L48;
        return false;
    L48:
        if (this.poiCount == r101.poiCount) goto L51;
        return false;
    L51:
        if (this.validTimeEnd == r101.validTimeEnd) goto L54;
        return false;
    L54:
        if (this.consumptionTimes == r101.consumptionTimes) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.iconServiceType, r101.iconServiceType) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.priceSuffix, r101.priceSuffix) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.discount, r101.discount) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.discountInfo, r101.discountInfo) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.productTypeFromCenter, r101.productTypeFromCenter) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.mulApplicablePoiPageUrl, r101.mulApplicablePoiPageUrl) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.specialSaleText, r101.specialSaleText) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.trackParams, r101.trackParams) == true) goto L80;
        return false;
    L80:
        return true;
    }

    public int hashCode() {
        String r100 = this.spuId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.status;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.spuType;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.customerSource;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.customerName;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.spuName;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.serviceTypeBury;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        List<PoiSpuTag> r122 = this.saleTags;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Long r125 = this.price;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Long r128 = this.originPrice;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        PoiSpuTag r131 = this.imageTag;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        SpuStatInfoStruct r134 = this.spuStat;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        SimplePoiInfoStruct r137 = this.poiInfo;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (((r136 + r138) * 31) + this.poiCount) * 31;
        long r140 = this.validTimeEnd;
        int r141 = (((r139 + ((int) (r140 ^ (r140 >>> 32)))) * 31) + this.consumptionTimes) * 31;
        PoiIconServiceType r142 = this.iconServiceType;
        if (r142 != null) goto L57;
        int r143 = 0;
    L58:
        int r144 = (r141 + r143) * 31;
        String r145 = this.priceSuffix;
        if (r145 != null) goto L61;
        int r146 = 0;
    L62:
        int r147 = (r144 + r146) * 31;
        Double r148 = this.discount;
        if (r148 != null) goto L65;
        int r149 = 0;
    L66:
        int r150 = (r147 + r149) * 31;
        String r151 = this.discountInfo;
        if (r151 != null) goto L69;
        int r152 = 0;
    L70:
        int r153 = (r150 + r152) * 31;
        Integer r154 = this.productTypeFromCenter;
        if (r154 != null) goto L73;
        int r155 = 0;
    L74:
        int r156 = (r153 + r155) * 31;
        String r157 = this.mulApplicablePoiPageUrl;
        if (r157 != null) goto L77;
        int r158 = 0;
    L78:
        int r159 = (r156 + r158) * 31;
        String r160 = this.specialSaleText;
        if (r160 != null) goto L81;
        int r161 = 0;
    L82:
        int r162 = (r159 + r161) * 31;
        HashMap<String, Object> r163 = this.trackParams;
        if (r163 == null) goto L87;
        r101 = r163.hashCode();
    L87:
        return r162 + r101;
    L81:
        r161 = r160.hashCode();
        goto L82
    L77:
        r158 = r157.hashCode();
        goto L78
    L73:
        r155 = r154.hashCode();
        goto L74
    L69:
        r152 = r151.hashCode();
        goto L70
    L65:
        r149 = r148.hashCode();
        goto L66
    L61:
        r146 = r145.hashCode();
        goto L62
    L57:
        r143 = r142.hashCode();
        goto L58
    L53:
        r138 = r137.hashCode();
        goto L54
    L49:
        r135 = r134.hashCode();
        goto L50
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "PoiSpuStruct(spuId=" + this.spuId + ", status=" + this.status + ", spuType=" + this.spuType + ", customerSource=" + this.customerSource + ", customerName=" + this.customerName + ", spuName=" + this.spuName + ", serviceTypeBury=" + this.serviceTypeBury + ", saleTags=" + this.saleTags + ", price=" + this.price + ", originPrice=" + this.originPrice + ", imageTag=" + this.imageTag + ", spuStat=" + this.spuStat + ", poiInfo=" + this.poiInfo + ", poiCount=" + this.poiCount + ", validTimeEnd=" + this.validTimeEnd + ", consumptionTimes=" + this.consumptionTimes + ", iconServiceType=" + this.iconServiceType + ", priceSuffix=" + this.priceSuffix + ", discount=" + this.discount + ", discountInfo=" + this.discountInfo + ", productTypeFromCenter=" + this.productTypeFromCenter + ", mulApplicablePoiPageUrl=" + this.mulApplicablePoiPageUrl + ", specialSaleText=" + this.specialSaleText + ", trackParams=" + this.trackParams + ')';
    }

    public final int getConsumptionTimes() {
        return this.consumptionTimes;
    }

    public final String getCustomerName() {
        return this.customerName;
    }

    public final Integer getCustomerSource() {
        return this.customerSource;
    }

    public final Double getDiscount() {
        return this.discount;
    }

    public final String getDiscountInfo() {
        return this.discountInfo;
    }

    public final PoiIconServiceType getIconServiceType() {
        return this.iconServiceType;
    }

    public final PoiSpuTag getImageTag() {
        return this.imageTag;
    }

    public final String getMulApplicablePoiPageUrl() {
        return this.mulApplicablePoiPageUrl;
    }

    public final Long getOriginPrice() {
        return this.originPrice;
    }

    public final int getPoiCount() {
        return this.poiCount;
    }

    public final SimplePoiInfoStruct getPoiInfo() {
        return this.poiInfo;
    }

    public final Long getPrice() {
        return this.price;
    }

    public final String getPriceSuffix() {
        return this.priceSuffix;
    }

    public final Integer getProductTypeFromCenter() {
        return this.productTypeFromCenter;
    }

    public final List<PoiSpuTag> getSaleTags() {
        return this.saleTags;
    }

    public final String getServiceTypeBury() {
        return this.serviceTypeBury;
    }

    public final String getSpecialSaleText() {
        return this.specialSaleText;
    }

    public final String getSpuId() {
        return this.spuId;
    }

    public final String getSpuName() {
        return this.spuName;
    }

    public final SpuStatInfoStruct getSpuStat() {
        return this.spuStat;
    }

    public final Integer getSpuType() {
        return this.spuType;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final HashMap<String, Object> getTrackParams() {
        return this.trackParams;
    }

    public final long getValidTimeEnd() {
        return this.validTimeEnd;
    }

    public PoiSpuStruct(String r100, Integer r101, Integer r102, Integer r103, String r104, String r105, String r110, List<PoiSpuTag> r111, Long r112, Long r113, PoiSpuTag r114, SpuStatInfoStruct r115, SimplePoiInfoStruct r116, int r117, long r118, int r210, PoiIconServiceType r211, String r212, Double r213, String r214, Integer r215, String r216, String r217, HashMap<String, Object> r218) {
        this.spuId = r100;
        this.status = r101;
        this.spuType = r102;
        this.customerSource = r103;
        this.customerName = r104;
        this.spuName = r105;
        this.serviceTypeBury = r110;
        this.saleTags = r111;
        this.price = r112;
        this.originPrice = r113;
        this.imageTag = r114;
        this.spuStat = r115;
        this.poiInfo = r116;
        this.poiCount = r117;
        this.validTimeEnd = r118;
        this.consumptionTimes = r210;
        this.iconServiceType = r211;
        this.priceSuffix = r212;
        this.discount = r213;
        this.discountInfo = r214;
        this.productTypeFromCenter = r215;
        this.mulApplicablePoiPageUrl = r216;
        this.specialSaleText = r217;
        this.trackParams = r218;
    }

    public /* synthetic */ PoiSpuStruct(String r210, Integer r211, Integer r212, Integer r310, String r311, String r312, String r313, List r314, Long r315, Long r316, PoiSpuTag r317, SpuStatInfoStruct r318, SimplePoiInfoStruct r319, int r410, long r411, int r412, PoiIconServiceType r413, String r414, Double r415, String r416, Integer r417, String r418, String r510, HashMap r511, int r512, DefaultConstructorMarker r513) {
        if ((r512 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r512 & 2) == 0) goto L9;
        Integer r101 = null;
    L11:
        if ((r512 & 4) == 0) goto L13;
        Integer r102 = null;
    L15:
        if ((r512 & 8) == 0) goto L17;
        Integer r103 = null;
    L19:
        if ((r512 & 16) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r512 & 32) == 0) goto L25;
        String r105 = null;
    L27:
        if ((r512 & 64) == 0) goto L29;
        String r106 = null;
    L31:
        if ((r512 & 128) == 0) goto L33;
        List r107 = null;
    L35:
        if ((r512 & 256) == 0) goto L37;
        Long r110 = null;
    L39:
        if ((r512 & 512) == 0) goto L41;
        Long r111 = null;
    L43:
        if ((r512 & 1024) == 0) goto L45;
        PoiSpuTag r112 = null;
    L47:
        if ((r512 & 2048) == 0) goto L49;
        SpuStatInfoStruct r113 = null;
    L51:
        if ((r512 & 4096) == 0) goto L53;
        SimplePoiInfoStruct r114 = null;
    L55:
        if ((r512 & 8192) == 0) goto L57;
        int r115 = 1;
    L59:
        if ((r512 & 16384) == 0) goto L61;
        long r116 = 0;
    L63:
        if ((32768 & r512) == 0) goto L65;
        int r108 = 0;
    L67:
        if ((r512 & 65536) == 0) goto L69;
        PoiIconServiceType r117 = null;
    L71:
        if ((r512 & 131072) == 0) goto L73;
        String r118 = null;
    L75:
        if ((r512 & 262144) == 0) goto L77;
        Double r213 = null;
    L79:
        if ((r512 & 524288) == 0) goto L81;
        String r214 = null;
    L83:
        if ((r512 & 1048576) == 0) goto L85;
        Integer r215 = null;
    L87:
        if ((r512 & 2097152) == 0) goto L89;
        String r216 = null;
    L91:
        if ((r512 & 4194304) == 0) goto L93;
        String r217 = null;
    L95:
        if ((r512 & 8388608) == 0) goto L97;
        HashMap r109 = null;
    L98:
        this(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r115, r116, r108, r117, r118, r213, r214, r215, r216, r217, r109);
        return;
    L97:
        r109 = r511;
        goto L98
    L93:
        r217 = r510;
        goto L95
    L89:
        r216 = r418;
        goto L91
    L85:
        r215 = r417;
        goto L87
    L81:
        r214 = r416;
        goto L83
    L77:
        r213 = r415;
        goto L79
    L73:
        r118 = r414;
        goto L75
    L69:
        r117 = r413;
        goto L71
    L65:
        r108 = r412;
        goto L67
    L61:
        r116 = r411;
        goto L63
    L57:
        r115 = r410;
        goto L59
    L53:
        r114 = r319;
        goto L55
    L49:
        r113 = r318;
        goto L51
    L45:
        r112 = r317;
        goto L47
    L41:
        r111 = r316;
        goto L43
    L37:
        r110 = r315;
        goto L39
    L33:
        r107 = r314;
        goto L35
    L29:
        r106 = r313;
        goto L31
    L25:
        r105 = r312;
        goto L27
    L21:
        r104 = r311;
        goto L23
    L17:
        r103 = r310;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
