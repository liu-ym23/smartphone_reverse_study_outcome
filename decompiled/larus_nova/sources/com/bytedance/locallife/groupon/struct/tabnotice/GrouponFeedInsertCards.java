package com.bytedance.locallife.groupon.struct.tabnotice;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.EventConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\b\u0087\b\u0018\u00002\u00020\u0001B_\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0011\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010$\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u0010%\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u000fHÆ\u0003Jh\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0002\u0010(J\u0006\u0010)\u001a\u00020\u0003J\u0013\u0010*\u001a\u00020\u00032\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\nHÖ\u0001J\u0006\u0010-\u001a\u00020\u0003J\u0006\u0010.\u001a\u00020\u0003J\t\u0010/\u001a\u00020\bHÖ\u0001R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001f\u0010\u001b¨\u00060"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/tabnotice/GrouponFeedInsertCards;", "", "enable", "", "exposeCardConf", "", "Lcom/bytedance/locallife/groupon/struct/tabnotice/ExposeCardConf;", "grouponFrontCardRawData", "", "insertCardType", "", "showInsertCard", "newCardData", "Lcom/google/gson/JsonObject;", "cardOrders", "Lcom/google/gson/JsonArray;", "(Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/google/gson/JsonObject;Lcom/google/gson/JsonArray;)V", "getCardOrders", "()Lcom/google/gson/JsonArray;", "getEnable", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getExposeCardConf", "()Ljava/util/List;", "getGrouponFrontCardRawData", "()Ljava/lang/String;", "getInsertCardType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getNewCardData", "()Lcom/google/gson/JsonObject;", "getShowInsertCard", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/google/gson/JsonObject;Lcom/google/gson/JsonArray;)Lcom/bytedance/locallife/groupon/struct/tabnotice/GrouponFeedInsertCards;", "enableShowInsertCard", "equals", "other", "hashCode", "isInteractionCardType", "isInteractionUndertakeCardType", "toString", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class GrouponFeedInsertCards {

    @SerializedName("card_orders")
    private final JsonArray cardOrders;

    @SerializedName("enable_groupon_guide_cards")
    private final Boolean enable;

    @SerializedName("expose_card_conf")
    private final List<ExposeCardConf> exposeCardConf;

    @SerializedName(EventConstant.Key.RAW_DATA)
    private final String grouponFrontCardRawData;

    @SerializedName("insert_card_type")
    private final Integer insertCardType;

    @SerializedName("new_card_data")
    private final JsonObject newCardData;

    @SerializedName("show_insert_card")
    private final Integer showInsertCard;

    public GrouponFeedInsertCards() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GrouponFeedInsertCards copy$default(GrouponFeedInsertCards r100, Boolean r101, List r102, String r103, Integer r104, Integer r110, JsonObject r111, JsonArray r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.enable;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.exposeCardConf;
    L8:
        List r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.grouponFrontCardRawData;
    L11:
        String r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.insertCardType;
    L14:
        Integer r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.showInsertCard;
    L17:
        Integer r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.newCardData;
    L20:
        JsonObject r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.cardOrders;
    L23:
        Boolean r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final Boolean component1() {
        return this.enable;
    }

    public final List<ExposeCardConf> component2() {
        return this.exposeCardConf;
    }

    public final String component3() {
        return this.grouponFrontCardRawData;
    }

    public final Integer component4() {
        return this.insertCardType;
    }

    public final Integer component5() {
        return this.showInsertCard;
    }

    public final JsonObject component6() {
        return this.newCardData;
    }

    public final JsonArray component7() {
        return this.cardOrders;
    }

    public final GrouponFeedInsertCards copy(Boolean r110, List<ExposeCardConf> r111, String r112, Integer r113, Integer r114, JsonObject r115, JsonArray r116) {
        return new GrouponFeedInsertCards(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GrouponFeedInsertCards) == true) goto L8;
        return false;
    L8:
        GrouponFeedInsertCards r101 = (GrouponFeedInsertCards) r100;
        if (Intrinsics.areEqual(this.enable, r101.enable) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.exposeCardConf, r101.exposeCardConf) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.grouponFrontCardRawData, r101.grouponFrontCardRawData) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.insertCardType, r101.insertCardType) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.showInsertCard, r101.showInsertCard) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.newCardData, r101.newCardData) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.cardOrders, r101.cardOrders) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        Boolean r100 = this.enable;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<ExposeCardConf> r104 = this.exposeCardConf;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.grouponFrontCardRawData;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.insertCardType;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.showInsertCard;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        JsonObject r116 = this.newCardData;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        JsonArray r119 = this.cardOrders;
        if (r119 == null) goto L31;
        r101 = r119.hashCode();
    L31:
        return r118 + r101;
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
        return "GrouponFeedInsertCards(enable=" + this.enable + ", exposeCardConf=" + this.exposeCardConf + ", grouponFrontCardRawData=" + this.grouponFrontCardRawData + ", insertCardType=" + this.insertCardType + ", showInsertCard=" + this.showInsertCard + ", newCardData=" + this.newCardData + ", cardOrders=" + this.cardOrders + ')';
    }

    public final boolean enableShowInsertCard() {
        Integer r100 = this.showInsertCard;
        if (r100 != null) goto L6;
    L8:
        return false;
    L6:
        if (r100.intValue() != 1) goto L8;
        return true;
    }

    public final boolean isInteractionCardType() {
        Integer r100 = this.insertCardType;
        if (r100 != null) goto L6;
    L8:
        return false;
    L6:
        if (r100.intValue() != 2) goto L8;
        return true;
    }

    public final boolean isInteractionUndertakeCardType() {
        Integer r100 = this.insertCardType;
        if (r100 != null) goto L6;
    L8:
        return false;
    L6:
        if (r100.intValue() != 3) goto L8;
        return true;
    }

    public final JsonArray getCardOrders() {
        return this.cardOrders;
    }

    public final Boolean getEnable() {
        return this.enable;
    }

    public final List<ExposeCardConf> getExposeCardConf() {
        return this.exposeCardConf;
    }

    public final String getGrouponFrontCardRawData() {
        return this.grouponFrontCardRawData;
    }

    public final Integer getInsertCardType() {
        return this.insertCardType;
    }

    public final JsonObject getNewCardData() {
        return this.newCardData;
    }

    public final Integer getShowInsertCard() {
        return this.showInsertCard;
    }

    public GrouponFeedInsertCards(Boolean r100, List<ExposeCardConf> r101, String r102, Integer r103, Integer r104, JsonObject r105, JsonArray r106) {
        this.enable = r100;
        this.exposeCardConf = r101;
        this.grouponFrontCardRawData = r102;
        this.insertCardType = r103;
        this.showInsertCard = r104;
        this.newCardData = r105;
        this.cardOrders = r106;
    }

    public /* synthetic */ GrouponFeedInsertCards(Boolean r100, List r101, String r102, Integer r110, Integer r111, JsonObject r112, JsonArray r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        Boolean r116 = null;
    L7:
        if ((r114 & 2) == 0) goto L9;
        List r103 = null;
    L11:
        if ((r114 & 4) == 0) goto L13;
        String r104 = null;
    L15:
        if ((r114 & 8) == 0) goto L17;
        Integer r105 = null;
    L19:
        if ((r114 & 16) == 0) goto L21;
        Integer r106 = null;
    L23:
        if ((r114 & 32) == 0) goto L25;
        JsonObject r107 = null;
    L27:
        if ((r114 & 64) == 0) goto L29;
        JsonArray r117 = null;
    L30:
        this(r116, r103, r104, r105, r106, r107, r117);
        return;
    L29:
        r117 = r113;
        goto L30
    L25:
        r107 = r112;
        goto L27
    L21:
        r106 = r111;
        goto L23
    L17:
        r105 = r110;
        goto L19
    L13:
        r104 = r102;
        goto L15
    L9:
        r103 = r101;
        goto L11
    L5:
        r116 = r100;
        goto L7
    }
}
