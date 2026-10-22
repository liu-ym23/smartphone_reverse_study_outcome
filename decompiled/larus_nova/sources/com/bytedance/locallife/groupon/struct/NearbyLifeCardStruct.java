package com.bytedance.locallife.groupon.struct;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.locallife.dito.common.data.UrlModel;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b#\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0091\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0013J\t\u00106\u001a\u00020\u0003HÆ\u0003J\u0011\u00107\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\fHÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0011\u0010>\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fHÆ\u0003J\u0010\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010+J\u000b\u0010@\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u009a\u0001\u0010A\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010BJ\u0013\u0010C\u001a\u00020D2\b\u0010E\u001a\u0004\u0018\u00010FHÖ\u0003J\u001c\u0010G\u001a\u0004\u0018\u0001HH\"\n\b\u0000\u0010H\u0018\u0001*\u00020\u0001H\u0086\b¢\u0006\u0002\u0010IJ\t\u0010J\u001a\u00020\u0003HÖ\u0001J\t\u0010K\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R&\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010,\u001a\u0004\b*\u0010+R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010.R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u0015R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010'R\u001e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u0017R \u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010'\"\u0004\b4\u00105¨\u0006L"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/NearbyLifeCardStruct;", "Ljava/io/Serializable;", "cardType", "", "relatedId", "", "cardJson", "insertIndex", "musicUrl", "Lcom/bytedance/locallife/dito/common/data/UrlModel;", "bgImg", "reports", "", "Lcom/bytedance/locallife/groupon/struct/NearbyNameValuePair;", "cardStyle", "cardPutType", "Lcom/bytedance/locallife/groupon/struct/NearbyLifeCardExpType;", "bgImgList", "reqId", "(ILjava/lang/String;Ljava/lang/String;ILcom/bytedance/locallife/dito/common/data/UrlModel;Lcom/bytedance/locallife/dito/common/data/UrlModel;Ljava/util/List;Ljava/lang/Integer;Lcom/bytedance/locallife/groupon/struct/NearbyLifeCardExpType;Ljava/util/List;Ljava/lang/String;)V", "getBgImg", "()Lcom/bytedance/locallife/dito/common/data/UrlModel;", "getBgImgList", "()Ljava/util/List;", "cardDataMap", "", "Lcom/bytedance/locallife/groupon/struct/NearbyLifeCardType;", "getCardDataMap", "()Ljava/util/Map;", "setCardDataMap", "(Ljava/util/Map;)V", "cardInsertTime", "", "getCardInsertTime", "()Ljava/lang/Long;", "setCardInsertTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getCardJson", "()Ljava/lang/String;", "getCardPutType", "()Lcom/bytedance/locallife/groupon/struct/NearbyLifeCardExpType;", "getCardStyle", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCardType", "()I", "getInsertIndex", "getMusicUrl", "getRelatedId", "getReports", "getReqId", "setReqId", "(Ljava/lang/String;)V", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ILjava/lang/String;Ljava/lang/String;ILcom/bytedance/locallife/dito/common/data/UrlModel;Lcom/bytedance/locallife/dito/common/data/UrlModel;Ljava/util/List;Ljava/lang/Integer;Lcom/bytedance/locallife/groupon/struct/NearbyLifeCardExpType;Ljava/util/List;Ljava/lang/String;)Lcom/bytedance/locallife/groupon/struct/NearbyLifeCardStruct;", "equals", "", "other", "", "getNearbyCardDetail", ExifInterface.GPS_DIRECTION_TRUE, "()Ljava/io/Serializable;", "hashCode", "toString", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class NearbyLifeCardStruct implements Serializable {

    @SerializedName("bg_img")
    private final UrlModel bgImg;

    @SerializedName("bg_img_list")
    private final List<UrlModel> bgImgList;
    private Map<NearbyLifeCardType, Serializable> cardDataMap;
    private Long cardInsertTime;

    @SerializedName("card_detail")
    private final String cardJson;

    @SerializedName("card_put_type")
    private final NearbyLifeCardExpType cardPutType;

    @SerializedName("card_style")
    private final Integer cardStyle;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_CARD_TYPE)
    private final int cardType;

    @SerializedName("index_on_force_insert")
    private final int insertIndex;

    @SerializedName("music_url")
    private final UrlModel musicUrl;

    @SerializedName("related_aweme_id")
    private final String relatedId;

    @SerializedName("report_values")
    private final List<NearbyNameValuePair> reports;

    @SerializedName("req_id")
    private String reqId;

    public NearbyLifeCardStruct() {
        this(0, null, null, 0, null, null, null, null, null, null, null, 2047, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NearbyLifeCardStruct copy$default(NearbyLifeCardStruct r110, int r111, String r112, String r113, int r114, UrlModel r115, UrlModel r116, List r117, Integer r210, NearbyLifeCardExpType r211, List r212, String r213, int r214, Object r215) {
        if ((r214 & 1) == 0) goto L5;
        int r100 = r110.cardType;
    L7:
        if ((r214 & 2) == 0) goto L9;
        String r101 = r110.relatedId;
    L11:
        if ((r214 & 4) == 0) goto L13;
        String r102 = r110.cardJson;
    L15:
        if ((r214 & 8) == 0) goto L17;
        int r103 = r110.insertIndex;
    L19:
        if ((r214 & 16) == 0) goto L21;
        UrlModel r104 = r110.musicUrl;
    L23:
        if ((r214 & 32) == 0) goto L25;
        UrlModel r105 = r110.bgImg;
    L27:
        if ((r214 & 64) == 0) goto L29;
        List r106 = r110.reports;
    L31:
        if ((r214 & 128) == 0) goto L33;
        Integer r107 = r110.cardStyle;
    L35:
        if ((r214 & 256) == 0) goto L37;
        NearbyLifeCardExpType r118 = r110.cardPutType;
    L39:
        if ((r214 & 512) == 0) goto L41;
        List r119 = r110.bgImgList;
    L43:
        if ((r214 & 1024) == 0) goto L45;
        String r108 = r110.reqId;
    L47:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r118, r119, r108);
    L45:
        r108 = r213;
        goto L47
    L41:
        r119 = r212;
        goto L43
    L37:
        r118 = r211;
        goto L39
    L33:
        r107 = r210;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final int component1() {
        return this.cardType;
    }

    public final List<UrlModel> component10() {
        return this.bgImgList;
    }

    public final String component11() {
        return this.reqId;
    }

    public final String component2() {
        return this.relatedId;
    }

    public final String component3() {
        return this.cardJson;
    }

    public final int component4() {
        return this.insertIndex;
    }

    public final UrlModel component5() {
        return this.musicUrl;
    }

    public final UrlModel component6() {
        return this.bgImg;
    }

    public final List<NearbyNameValuePair> component7() {
        return this.reports;
    }

    public final Integer component8() {
        return this.cardStyle;
    }

    public final NearbyLifeCardExpType component9() {
        return this.cardPutType;
    }

    public final NearbyLifeCardStruct copy(int r110, String r111, String r112, int r113, UrlModel r114, UrlModel r115, List<NearbyNameValuePair> r210, Integer r211, NearbyLifeCardExpType r212, List<? extends UrlModel> r213, String r214) {
        return new NearbyLifeCardStruct(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof NearbyLifeCardStruct) == true) goto L8;
        return false;
    L8:
        NearbyLifeCardStruct r101 = (NearbyLifeCardStruct) r100;
        if (this.cardType == r101.cardType) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.relatedId, r101.relatedId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.cardJson, r101.cardJson) == true) goto L18;
        return false;
    L18:
        if (this.insertIndex == r101.insertIndex) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.musicUrl, r101.musicUrl) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.bgImg, r101.bgImg) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.reports, r101.reports) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.cardStyle, r101.cardStyle) == true) goto L33;
        return false;
    L33:
        if (this.cardPutType == r101.cardPutType) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.bgImgList, r101.bgImgList) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.reqId, r101.reqId) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public int hashCode() {
        int r100 = this.cardType * 31;
        String r101 = this.relatedId;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.cardJson;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((r104 + r106) * 31) + this.insertIndex) * 31;
        UrlModel r108 = this.musicUrl;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        UrlModel r111 = this.bgImg;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        List<NearbyNameValuePair> r114 = this.reports;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        Integer r117 = this.cardStyle;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (r116 + r118) * 31;
        NearbyLifeCardExpType r120 = this.cardPutType;
        if (r120 != null) goto L29;
        int r121 = 0;
    L30:
        int r122 = (r119 + r121) * 31;
        List<UrlModel> r123 = this.bgImgList;
        if (r123 != null) goto L33;
        int r124 = 0;
    L34:
        int r125 = (r122 + r124) * 31;
        String r126 = this.reqId;
        if (r126 == null) goto L39;
        r102 = r126.hashCode();
    L39:
        return r125 + r102;
    L33:
        r124 = r123.hashCode();
        goto L34
    L29:
        r121 = r120.hashCode();
        goto L30
    L25:
        r118 = r117.hashCode();
        goto L26
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "NearbyLifeCardStruct(cardType=" + this.cardType + ", relatedId=" + this.relatedId + ", cardJson=" + this.cardJson + ", insertIndex=" + this.insertIndex + ", musicUrl=" + this.musicUrl + ", bgImg=" + this.bgImg + ", reports=" + this.reports + ", cardStyle=" + this.cardStyle + ", cardPutType=" + this.cardPutType + ", bgImgList=" + this.bgImgList + ", reqId=" + this.reqId + ')';
    }

    public final /* synthetic */ <T extends Serializable> T getNearbyCardDetail() {
        NearbyLifeCardType[] r100 = NearbyLifeCardType.values();
        int r101 = r100.length;
        boolean r102 = false;
        int r103 = 0;
    L3:
        Object r104 = null;
        if (r103 >= r101) goto L12;
        NearbyLifeCardType r105 = r100[r103];
        if (r105.getType() != getCardType()) goto L8;
        boolean r106 = true;
    L9:
        if (r106 == true) goto L13;
        r103 = r103 + 1;
    L13:
        if (r105 != null) goto L15;
        return null;
    L15:
        if (r105 == NearbyLifeCardType.NOTHING) goto L50;
        String r107 = getCardJson();
        if (r107 != null) goto L19;
    L20:
        r102 = true;
    L21:
        if (r102 == true) goto L51;
        Serializable r108 = getCardDataMap().get(r105);
        if (r108 == null) goto L45;
        Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) r108;
    L45:
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L34
        Gson r110 = com.bytedance.locallife.common.utils.d.b();     // Catch: Throwable -> L34
        String r111 = getCardJson();     // Catch: Throwable -> L34
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);     // Catch: Throwable -> L34
        Serializable r112 = (Serializable) r110.fromJson(r111, Serializable.class);     // Catch: Throwable -> L34
        if (r112 == null) goto L31;
        getCardDataMap().put(r105, r112);     // Catch: Throwable -> L34
        Serializable r113 = r112;     // Catch: Throwable -> L34
    L32:
        Object r114 = Result.m9449constructorimpl(r113);     // Catch: Throwable -> L34
    L36:
        Throwable r115 = Result.m9452exceptionOrNullimpl(r114);
        if (r115 == null) goto L40;
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        Serializable.class.toString();
        r115.getMessage();
    L40:
        if (Result.m9455isFailureimpl(r114) == true) goto L44;
        r104 = r114;
    L44:
        return (T) r104;
    L31:
        r113 = null;
    L34:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L36
    L51:
        return null;
    L19:
        if (r107.length() != 0) goto L21;
    L50:
        return null;
    L8:
        r106 = false;
        goto L9
    L12:
        r105 = null;
        goto L13
    }

    public final UrlModel getBgImg() {
        return this.bgImg;
    }

    public final List<UrlModel> getBgImgList() {
        return this.bgImgList;
    }

    public final Map<NearbyLifeCardType, Serializable> getCardDataMap() {
        return this.cardDataMap;
    }

    public final Long getCardInsertTime() {
        return this.cardInsertTime;
    }

    public final String getCardJson() {
        return this.cardJson;
    }

    public final NearbyLifeCardExpType getCardPutType() {
        return this.cardPutType;
    }

    public final Integer getCardStyle() {
        return this.cardStyle;
    }

    public final int getCardType() {
        return this.cardType;
    }

    public final int getInsertIndex() {
        return this.insertIndex;
    }

    public final UrlModel getMusicUrl() {
        return this.musicUrl;
    }

    public final String getRelatedId() {
        return this.relatedId;
    }

    public final List<NearbyNameValuePair> getReports() {
        return this.reports;
    }

    public final String getReqId() {
        return this.reqId;
    }

    public final void setCardDataMap(Map<NearbyLifeCardType, Serializable> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.cardDataMap = r100;
    }

    public final void setCardInsertTime(Long r100) {
        this.cardInsertTime = r100;
    }

    public final void setReqId(String r100) {
        this.reqId = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NearbyLifeCardStruct(int r100, String r101, String r102, int r103, UrlModel r104, UrlModel r105, List<NearbyNameValuePair> r106, Integer r107, NearbyLifeCardExpType r108, List<? extends UrlModel> r110, String r111) {
        this.cardType = r100;
        this.relatedId = r101;
        this.cardJson = r102;
        this.insertIndex = r103;
        this.musicUrl = r104;
        this.bgImg = r105;
        this.reports = r106;
        this.cardStyle = r107;
        this.cardPutType = r108;
        this.bgImgList = r110;
        this.reqId = r111;
        this.cardDataMap = new LinkedHashMap();
    }

    public /* synthetic */ NearbyLifeCardStruct(int r110, String r111, String r112, int r113, UrlModel r114, UrlModel r115, List r116, Integer r210, NearbyLifeCardExpType r211, List r212, String r213, int r214, DefaultConstructorMarker r215) {
        if ((r214 & 1) == 0) goto L5;
        int r100 = NearbyLifeCardType.NOTHING.getType();
    L6:
        String r101 = "";
        if ((r214 & 2) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r214 & 4) != 0) goto L15;
        r101 = r112;
    L15:
        if ((r214 & 8) == 0) goto L17;
        int r103 = 0;
    L18:
        String r104 = null;
        if ((r214 & 16) == 0) goto L21;
        UrlModel r105 = null;
    L23:
        if ((r214 & 32) == 0) goto L25;
        UrlModel r106 = null;
    L27:
        if ((r214 & 64) == 0) goto L29;
        List r107 = null;
    L31:
        if ((r214 & 128) == 0) goto L33;
        Integer r108 = null;
    L35:
        if ((r214 & 256) == 0) goto L37;
        NearbyLifeCardExpType r117 = null;
    L39:
        if ((r214 & 512) == 0) goto L41;
        List r118 = null;
    L43:
        if ((r214 & 1024) != 0) goto L46;
        r104 = r213;
    L46:
        this(r100, r102, r101, r103, r105, r106, r107, r108, r117, r118, r104);
        return;
    L41:
        r118 = r212;
        goto L43
    L37:
        r117 = r211;
        goto L39
    L33:
        r108 = r210;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r103 = r113;
        goto L18
    L9:
        r102 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L6
    }
}
