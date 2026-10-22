package com.bytedance.android.shopping.api.mall.common.homepage.card.common;

import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0011\b\u0007\u0018\u00002\u00020\u0001:\u000f\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData;", "", "()V", "Ad", "CardCommon", "CoinData", "ElementStyle", "Extra", "Impression", "InstantRecommendData", "MarketingData", "PriceCommon", "PriceContent", "Product", "Store", "UrlStruct", "User", "WindVaneEventData", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommonData {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J>\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0007HÖ\u0001R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Ad;", "", "id", "", "showAdTag", "", "RowData", "", "RawData", "(Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V", "getRawData", "()Ljava/lang/String;", "getRowData", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getShowAdTag", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Ad;", "equals", "other", "hashCode", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Ad {

        @SerializedName("raw_data")
        private final String RawData;

        @SerializedName("row_data")
        private final String RowData;

        @SerializedName("id")
        private final Integer id;

        @SerializedName("show_ad_tag")
        private final Boolean showAdTag;

        public Ad() {
            this(null, null, null, null, 15, null);
        }

        public static /* synthetic */ Ad copy$default(Ad r0, Integer r1, Boolean r2, String r3, String r4, int r5, Object r6) {
            if ((r5 & 1) == 0) goto L6;
            r1 = r0.id;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r2 = r0.showAdTag;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r3 = r0.RowData;
        L12:
            if ((r5 & 8) == 0) goto L15;
            r4 = r0.RawData;
        L15:
            return r0.copy(r1, r2, r3, r4);
        }

        public final Integer component1() {
            return this.id;
        }

        public final Boolean component2() {
            return this.showAdTag;
        }

        public final String component3() {
            return this.RowData;
        }

        public final String component4() {
            return this.RawData;
        }

        public final Ad copy(Integer r2, Boolean r3, String r4, String r5) {
            return new Ad(r2, r3, r4, r5);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof Ad) == false) goto L14;
            Ad r4 = (Ad) r3;
            if (Intrinsics.areEqual(this.id, r4.id) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.showAdTag, r4.showAdTag) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.RowData, r4.RowData) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.RawData, r4.RawData) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public int hashCode() {
            Integer r0 = this.id;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            Boolean r4 = this.showAdTag;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.RowData;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            String r10 = this.RawData;
            if (r10 == null) goto L18;
            r1 = r10.hashCode();
        L18:
            return r9 + r1;
        L13:
            r8 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public String toString() {
            return "Ad(id=" + this.id + ", showAdTag=" + this.showAdTag + ", RowData=" + this.RowData + ", RawData=" + this.RawData + ")";
        }

        public final Integer getId() {
            return this.id;
        }

        public final String getRawData() {
            return this.RawData;
        }

        public final String getRowData() {
            return this.RowData;
        }

        public final Boolean getShowAdTag() {
            return this.showAdTag;
        }

        public Ad(Integer r1, Boolean r2, String r3, String r4) {
            this.id = r1;
            this.showAdTag = r2;
            this.RowData = r3;
            this.RawData = r4;
        }

        public /* synthetic */ Ad(Integer r2, Boolean r3, String r4, String r5, int r6, DefaultConstructorMarker r7) {
            if ((r6 & 1) == 0) goto L6;
            r2 = null;
        L6:
            if ((r6 & 2) == 0) goto L9;
            r3 = null;
        L9:
            if ((r6 & 4) == 0) goto L12;
            r4 = null;
        L12:
            if ((r6 & 8) == 0) goto L14;
            r5 = null;
        L14:
            this(r2, r3, r4, r5);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$CardCommon;", "", "resourceId", "", "(Ljava/lang/String;)V", "getResourceId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class CardCommon {

        @SerializedName("resource_id")
        private final String resourceId;

        public CardCommon() {
            String r0 = null;
            this(r0, 1, r0);
        }

        public static /* synthetic */ CardCommon copy$default(CardCommon r0, String r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.resourceId;
        L6:
            return r0.copy(r1);
        }

        public final String component1() {
            return this.resourceId;
        }

        public final CardCommon copy(String r2) {
            return new CardCommon(r2);
        }

        public boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof CardCommon) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.resourceId, ((CardCommon) r2).resourceId) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public int hashCode() {
            String r0 = this.resourceId;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public String toString() {
            return "CardCommon(resourceId=" + this.resourceId + ")";
        }

        public final String getResourceId() {
            return this.resourceId;
        }

        public CardCommon(String r1) {
            this.resourceId = r1;
        }

        public /* synthetic */ CardCommon(String r1, int r2, DefaultConstructorMarker r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = null;
        L5:
            this(r1);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$CoinData;", "", "coinLynxSchema", "", "coinLynxHeight", "", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getCoinLynxHeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCoinLynxSchema", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$CoinData;", "equals", "", "other", "hashCode", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class CoinData {

        @SerializedName("coin_lynx_height")
        private final Integer coinLynxHeight;

        @SerializedName("coin_lynx_schema")
        private final String coinLynxSchema;

        /* JADX WARN: Multi-variable type inference failed */
        public CoinData() {
            Object[] r0 = 0 == true ? 1 : 0;
            this(null, r0, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ CoinData copy$default(CoinData r0, String r1, Integer r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.coinLynxSchema;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.coinLynxHeight;
        L9:
            return r0.copy(r1, r2);
        }

        public final String component1() {
            return this.coinLynxSchema;
        }

        public final Integer component2() {
            return this.coinLynxHeight;
        }

        public final CoinData copy(String r2, Integer r3) {
            return new CoinData(r2, r3);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof CoinData) == false) goto L10;
            CoinData r4 = (CoinData) r3;
            if (Intrinsics.areEqual(this.coinLynxSchema, r4.coinLynxSchema) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.coinLynxHeight, r4.coinLynxHeight) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public int hashCode() {
            String r0 = this.coinLynxSchema;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            Integer r4 = this.coinLynxHeight;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public String toString() {
            return "CoinData(coinLynxSchema=" + this.coinLynxSchema + ", coinLynxHeight=" + this.coinLynxHeight + ")";
        }

        public final Integer getCoinLynxHeight() {
            return this.coinLynxHeight;
        }

        public final String getCoinLynxSchema() {
            return this.coinLynxSchema;
        }

        public CoinData(String r1, Integer r2) {
            this.coinLynxSchema = r1;
            this.coinLynxHeight = r2;
        }

        public /* synthetic */ CoinData(String r2, Integer r3, int r4, DefaultConstructorMarker r5) {
            if ((r4 & 1) == 0) goto L6;
            r2 = null;
        L6:
            if ((r4 & 2) == 0) goto L8;
            r3 = null;
        L8:
            this(r2, r3);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\bQ\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001:\u0005{|}~\u007fBõ\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(\u0012\b\b\u0002\u0010)\u001a\u00020\u0019¢\u0006\u0002\u0010*J\u000b\u0010U\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u0010\u0010[\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u0010;J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\t\u0010^\u001a\u00020\u0019HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u001cHÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010j\u001a\u0004\u0018\u00010&HÆ\u0003J\u000b\u0010k\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010l\u001a\u0004\u0018\u00010(HÆ\u0003¢\u0006\u0002\u00105J\t\u0010m\u001a\u00020\u0019HÆ\u0003J\u000b\u0010n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010o\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010p\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010q\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010r\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010s\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jþ\u0002\u0010t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(2\b\b\u0002\u0010)\u001a\u00020\u0019HÆ\u0001¢\u0006\u0002\u0010uJ\u0013\u0010v\u001a\u00020\u00192\b\u0010w\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010x\u001a\u00020(HÖ\u0001J\t\u0010y\u001a\u00020zHÖ\u0001R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010,R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010,R\u0018\u0010!\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010,R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010,R\u0018\u0010 \u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010/R\u001a\u0010'\u001a\u0004\u0018\u00010(8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00106\u001a\u0004\b4\u00105R\u0016\u0010\u0018\u001a\u00020\u00198\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0018\u0010$\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010,R\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010<\u001a\u0004\b:\u0010;R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010,R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010/R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010,R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010,R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010/R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010,R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010,R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010/R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u0018\u0010#\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u0010,R\u0018\u0010\"\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010>R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001c8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bK\u0010LR\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u0010,R\u0016\u0010)\u001a\u00020\u00198\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bN\u00108R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bO\u0010/R\u0018\u0010%\u001a\u0004\u0018\u00010&8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bP\u0010QR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bR\u0010,R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bS\u0010/R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bT\u0010>¨\u0006\u0080\u0001"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle;", "", "infoLayout", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$LayoutStyle;", "avatarLayout", "userTextStyle", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$CusTextStyle;", "logoLayout", "logoTextLayout", "logoTextStyle", "hotLayout", "hotTextStyle", "arriveTimeIconLayout", "arriveTimeTextStyle", "arriveTimeTextLayout", "videoTitleLayout", "videoTitleStyle", "maskStyle", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$MaskStyle;", "height", "", "hotIconStyle", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$CommonColorStyle;", "viewStyle", "darkModeEnable", "", "redPacketLayout", "price", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$PriceContent;", "liveHeaderStateStyle", "liveHeaderEnterIconLayout", "coinLayout", "coinStyle", "coinIconLayout", "playerMaskStyle", "playerLayout", "feedbackLayout", "videoLikeStyle", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$VideoLikeStyle;", "colorfulCardStyle", "", "removeShadow", "(Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$CusTextStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$CusTextStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$CusTextStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$CusTextStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$CusTextStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$MaskStyle;Ljava/lang/Double;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$CommonColorStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$CommonColorStyle;ZLcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$PriceContent;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$CusTextStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$CusTextStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$CommonColorStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$VideoLikeStyle;Ljava/lang/Integer;Z)V", "getArriveTimeIconLayout", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$LayoutStyle;", "getArriveTimeTextLayout", "getArriveTimeTextStyle", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$CusTextStyle;", "getAvatarLayout", "getCoinIconLayout", "getCoinLayout", "getCoinStyle", "getColorfulCardStyle", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDarkModeEnable", "()Z", "getFeedbackLayout", "getHeight", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getHotIconStyle", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$CommonColorStyle;", "getHotLayout", "getHotTextStyle", "getInfoLayout", "getLiveHeaderEnterIconLayout", "getLiveHeaderStateStyle", "getLogoLayout", "getLogoTextLayout", "getLogoTextStyle", "getMaskStyle", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$MaskStyle;", "getPlayerLayout", "getPlayerMaskStyle", "getPrice", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$PriceContent;", "getRedPacketLayout", "getRemoveShadow", "getUserTextStyle", "getVideoLikeStyle", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$VideoLikeStyle;", "getVideoTitleLayout", "getVideoTitleStyle", "getViewStyle", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$CusTextStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$CusTextStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$CusTextStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$CusTextStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$CusTextStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$MaskStyle;Ljava/lang/Double;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$CommonColorStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$CommonColorStyle;ZLcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$PriceContent;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$CusTextStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$CusTextStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$CommonColorStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$VideoLikeStyle;Ljava/lang/Integer;Z)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle;", "equals", "other", "hashCode", "toString", "", "CommonColorStyle", "CusTextStyle", "LayoutStyle", "MaskStyle", "VideoLikeStyle", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ElementStyle {

        @SerializedName("arrive_time_icon_layout")
        private final LayoutStyle arriveTimeIconLayout;

        @SerializedName("arrive_time_text_layout")
        private final LayoutStyle arriveTimeTextLayout;

        @SerializedName("arrive_time_text_style")
        private final CusTextStyle arriveTimeTextStyle;

        @SerializedName("avatar_layout")
        private final LayoutStyle avatarLayout;

        @SerializedName("coin_icon_layout")
        private final LayoutStyle coinIconLayout;

        @SerializedName("coin_layout")
        private final LayoutStyle coinLayout;

        @SerializedName("coin_style")
        private final CusTextStyle coinStyle;

        @SerializedName("colorful_card_style")
        private final Integer colorfulCardStyle;

        @SerializedName("dark_mode_enable")
        private final boolean darkModeEnable;

        @SerializedName("feed_back_button_layout")
        private final LayoutStyle feedbackLayout;

        @SerializedName("height")
        private final Double height;

        @SerializedName("hot_icon_style")
        private final CommonColorStyle hotIconStyle;

        @SerializedName("hot_icon_layout")
        private final LayoutStyle hotLayout;

        @SerializedName("hot_text_style")
        private final CusTextStyle hotTextStyle;

        @SerializedName("info_layout")
        private final LayoutStyle infoLayout;

        @SerializedName("live_header_enter_icon_layout")
        private final LayoutStyle liveHeaderEnterIconLayout;

        @SerializedName("live_header_state_style")
        private final CusTextStyle liveHeaderStateStyle;

        @SerializedName("logo_icon_layout")
        private final LayoutStyle logoLayout;

        @SerializedName("logo_text_layout")
        private final LayoutStyle logoTextLayout;

        @SerializedName("logo_text_style")
        private final CusTextStyle logoTextStyle;

        @SerializedName("mask_style")
        private final MaskStyle maskStyle;

        @SerializedName("player_layout")
        private final LayoutStyle playerLayout;

        @SerializedName("player_mask_style")
        private final CommonColorStyle playerMaskStyle;

        @SerializedName("price")
        private final PriceContent price;

        @SerializedName("red_packet_layout")
        private final LayoutStyle redPacketLayout;

        @SerializedName("remove_shadow")
        private final boolean removeShadow;

        @SerializedName("user_text_style")
        private final CusTextStyle userTextStyle;

        @SerializedName("video_like_info")
        private final VideoLikeStyle videoLikeStyle;

        @SerializedName("video_title_layout")
        private final LayoutStyle videoTitleLayout;

        @SerializedName("video_title_style")
        private final CusTextStyle videoTitleStyle;

        @SerializedName("view_style")
        private final CommonColorStyle viewStyle;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$CommonColorStyle;", "", "color", "", "colorDark", "colorLight", "colorFrom", "colorTo", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getColor", "()Ljava/lang/String;", "getColorDark", "getColorFrom", "getColorLight", "getColorTo", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class CommonColorStyle {

            @SerializedName("color")
            private final String color;

            @SerializedName("color_dark")
            private final String colorDark;

            @SerializedName("color_from")
            private final String colorFrom;

            @SerializedName("color_light")
            private final String colorLight;

            @SerializedName("color_to")
            private final String colorTo;

            public CommonColorStyle() {
                this(null, null, null, null, null, 31, null);
            }

            public static /* synthetic */ CommonColorStyle copy$default(CommonColorStyle r3, String r4, String r5, String r6, String r7, String r8, int r9, Object r10) {
                if ((r9 & 1) == 0) goto L6;
                r4 = r3.color;
            L6:
                if ((r9 & 2) == 0) goto L8;
                r5 = r3.colorDark;
            L8:
                String r11 = r5;
                if ((r9 & 4) == 0) goto L11;
                r6 = r3.colorLight;
            L11:
                String r0 = r6;
                if ((r9 & 8) == 0) goto L14;
                r7 = r3.colorFrom;
            L14:
                String r1 = r7;
                if ((r9 & 16) == 0) goto L17;
                r8 = r3.colorTo;
            L17:
                String r12 = r4;
                return r3.copy(r12, r11, r0, r1, r8);
            }

            public final String component1() {
                return this.color;
            }

            public final String component2() {
                return this.colorDark;
            }

            public final String component3() {
                return this.colorLight;
            }

            public final String component4() {
                return this.colorFrom;
            }

            public final String component5() {
                return this.colorTo;
            }

            public final CommonColorStyle copy(String r8, String r9, String r10, String r11, String r12) {
                return new CommonColorStyle(r8, r9, r10, r11, r12);
            }

            public boolean equals(Object r3) {
                if (this != r3) goto L4;
                return true;
            L4:
                if ((r3 instanceof CommonColorStyle) == false) goto L16;
                CommonColorStyle r4 = (CommonColorStyle) r3;
                if (Intrinsics.areEqual(this.color, r4.color) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.colorDark, r4.colorDark) == true) goto L10;
                return false;
            L10:
                if (Intrinsics.areEqual(this.colorLight, r4.colorLight) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.colorFrom, r4.colorFrom) == true) goto L14;
                return false;
            L14:
                if (Intrinsics.areEqual(this.colorTo, r4.colorTo) == true) goto L25;
                return false;
            L25:
                return true;
            L16:
                return false;
            }

            public int hashCode() {
                String r0 = this.color;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = r0.hashCode();
            L6:
                int r3 = r2 * 31;
                String r4 = this.colorDark;
                if (r4 == null) goto L9;
                int r5 = r4.hashCode();
            L10:
                int r6 = (r3 + r5) * 31;
                String r7 = this.colorLight;
                if (r7 == null) goto L13;
                int r8 = r7.hashCode();
            L14:
                int r9 = (r6 + r8) * 31;
                String r10 = this.colorFrom;
                if (r10 == null) goto L17;
                int r11 = r10.hashCode();
            L18:
                int r12 = (r9 + r11) * 31;
                String r13 = this.colorTo;
                if (r13 == null) goto L22;
                r1 = r13.hashCode();
            L22:
                return r12 + r1;
            L17:
                r11 = 0;
                goto L18
            L13:
                r8 = 0;
                goto L14
            L9:
                r5 = 0;
                goto L10
            L5:
                r2 = 0;
                goto L6
            }

            public String toString() {
                return "CommonColorStyle(color=" + this.color + ", colorDark=" + this.colorDark + ", colorLight=" + this.colorLight + ", colorFrom=" + this.colorFrom + ", colorTo=" + this.colorTo + ")";
            }

            public final String getColor() {
                return this.color;
            }

            public final String getColorDark() {
                return this.colorDark;
            }

            public final String getColorFrom() {
                return this.colorFrom;
            }

            public final String getColorLight() {
                return this.colorLight;
            }

            public final String getColorTo() {
                return this.colorTo;
            }

            public CommonColorStyle(String r1, String r2, String r3, String r4, String r5) {
                this.color = r1;
                this.colorDark = r2;
                this.colorLight = r3;
                this.colorFrom = r4;
                this.colorTo = r5;
            }

            public /* synthetic */ CommonColorStyle(String r5, String r6, String r7, String r8, String r9, int r10, DefaultConstructorMarker r11) {
                if ((r10 & 1) == 0) goto L5;
                String r12 = null;
            L7:
                if ((r10 & 2) == 0) goto L9;
                String r1 = null;
            L11:
                if ((r10 & 4) == 0) goto L13;
                String r2 = null;
            L15:
                if ((r10 & 8) == 0) goto L17;
                String r3 = null;
            L19:
                if ((r10 & 16) == 0) goto L21;
                String r13 = null;
            L22:
                this(r12, r1, r2, r3, r13);
                return;
            L21:
                r13 = r9;
                goto L22
            L17:
                r3 = r8;
                goto L19
            L13:
                r2 = r7;
                goto L15
            L9:
                r1 = r6;
                goto L11
            L5:
                r12 = r5;
                goto L7
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003JV\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011¨\u0006!"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$CusTextStyle;", "", "color", "", "fontSize", "", "fontWeight", "colorDark", "backgroundColor", "backgroundColorTo", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBackgroundColor", "()Ljava/lang/String;", "getBackgroundColorTo", "getColor", "getColorDark", "getFontSize", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getFontWeight", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$CusTextStyle;", "equals", "", "other", "hashCode", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class CusTextStyle {

            @SerializedName("background_color")
            private final String backgroundColor;

            @SerializedName("background_color_to")
            private final String backgroundColorTo;

            @SerializedName("color")
            private final String color;

            @SerializedName("color_dark")
            private final String colorDark;

            @SerializedName("font_size")
            private final Integer fontSize;

            @SerializedName("font_weight")
            private final Integer fontWeight;

            public CusTextStyle() {
                this(null, null, null, null, null, null, 63, null);
            }

            public static /* synthetic */ CusTextStyle copy$default(CusTextStyle r4, String r5, Integer r6, Integer r7, String r8, String r9, String r10, int r11, Object r12) {
                if ((r11 & 1) == 0) goto L6;
                r5 = r4.color;
            L6:
                if ((r11 & 2) == 0) goto L8;
                r6 = r4.fontSize;
            L8:
                Integer r13 = r6;
                if ((r11 & 4) == 0) goto L11;
                r7 = r4.fontWeight;
            L11:
                Integer r0 = r7;
                if ((r11 & 8) == 0) goto L14;
                r8 = r4.colorDark;
            L14:
                String r1 = r8;
                if ((r11 & 16) == 0) goto L17;
                r9 = r4.backgroundColor;
            L17:
                String r2 = r9;
                if ((r11 & 32) == 0) goto L20;
                r10 = r4.backgroundColorTo;
            L20:
                String r14 = r5;
                return r4.copy(r14, r13, r0, r1, r2, r10);
            }

            public final String component1() {
                return this.color;
            }

            public final Integer component2() {
                return this.fontSize;
            }

            public final Integer component3() {
                return this.fontWeight;
            }

            public final String component4() {
                return this.colorDark;
            }

            public final String component5() {
                return this.backgroundColor;
            }

            public final String component6() {
                return this.backgroundColorTo;
            }

            public final CusTextStyle copy(String r9, Integer r10, Integer r11, String r12, String r13, String r14) {
                return new CusTextStyle(r9, r10, r11, r12, r13, r14);
            }

            public boolean equals(Object r3) {
                if (this != r3) goto L4;
                return true;
            L4:
                if ((r3 instanceof CusTextStyle) == false) goto L18;
                CusTextStyle r4 = (CusTextStyle) r3;
                if (Intrinsics.areEqual(this.color, r4.color) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.fontSize, r4.fontSize) == true) goto L10;
                return false;
            L10:
                if (Intrinsics.areEqual(this.fontWeight, r4.fontWeight) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.colorDark, r4.colorDark) == true) goto L14;
                return false;
            L14:
                if (Intrinsics.areEqual(this.backgroundColor, r4.backgroundColor) == true) goto L16;
                return false;
            L16:
                if (Intrinsics.areEqual(this.backgroundColorTo, r4.backgroundColorTo) == true) goto L28;
                return false;
            L28:
                return true;
            L18:
                return false;
            }

            public int hashCode() {
                String r0 = this.color;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = r0.hashCode();
            L6:
                int r3 = r2 * 31;
                Integer r4 = this.fontSize;
                if (r4 == null) goto L9;
                int r5 = r4.hashCode();
            L10:
                int r6 = (r3 + r5) * 31;
                Integer r7 = this.fontWeight;
                if (r7 == null) goto L13;
                int r8 = r7.hashCode();
            L14:
                int r9 = (r6 + r8) * 31;
                String r10 = this.colorDark;
                if (r10 == null) goto L17;
                int r11 = r10.hashCode();
            L18:
                int r12 = (r9 + r11) * 31;
                String r13 = this.backgroundColor;
                if (r13 == null) goto L21;
                int r14 = r13.hashCode();
            L22:
                int r15 = (r12 + r14) * 31;
                String r16 = this.backgroundColorTo;
                if (r16 == null) goto L26;
                r1 = r16.hashCode();
            L26:
                return r15 + r1;
            L21:
                r14 = 0;
                goto L22
            L17:
                r11 = 0;
                goto L18
            L13:
                r8 = 0;
                goto L14
            L9:
                r5 = 0;
                goto L10
            L5:
                r2 = 0;
                goto L6
            }

            public String toString() {
                return "CusTextStyle(color=" + this.color + ", fontSize=" + this.fontSize + ", fontWeight=" + this.fontWeight + ", colorDark=" + this.colorDark + ", backgroundColor=" + this.backgroundColor + ", backgroundColorTo=" + this.backgroundColorTo + ")";
            }

            public final String getBackgroundColor() {
                return this.backgroundColor;
            }

            public final String getBackgroundColorTo() {
                return this.backgroundColorTo;
            }

            public final String getColor() {
                return this.color;
            }

            public final String getColorDark() {
                return this.colorDark;
            }

            public final Integer getFontSize() {
                return this.fontSize;
            }

            public final Integer getFontWeight() {
                return this.fontWeight;
            }

            public CusTextStyle(String r1, Integer r2, Integer r3, String r4, String r5, String r6) {
                this.color = r1;
                this.fontSize = r2;
                this.fontWeight = r3;
                this.colorDark = r4;
                this.backgroundColor = r5;
                this.backgroundColorTo = r6;
            }

            public /* synthetic */ CusTextStyle(String r6, Integer r7, Integer r8, String r9, String r10, String r11, int r12, DefaultConstructorMarker r13) {
                if ((r12 & 1) == 0) goto L5;
                String r14 = null;
            L7:
                if ((r12 & 2) == 0) goto L9;
                Integer r1 = null;
            L11:
                if ((r12 & 4) == 0) goto L13;
                Integer r2 = null;
            L15:
                if ((r12 & 8) == 0) goto L17;
                String r3 = null;
            L19:
                if ((r12 & 16) == 0) goto L21;
                String r4 = null;
            L23:
                if ((r12 & 32) == 0) goto L25;
                String r15 = null;
            L26:
                this(r14, r1, r2, r3, r4, r15);
                return;
            L25:
                r15 = r11;
                goto L26
            L21:
                r4 = r10;
                goto L23
            L17:
                r3 = r9;
                goto L19
            L13:
                r2 = r8;
                goto L15
            L9:
                r1 = r7;
                goto L11
            L5:
                r14 = r6;
                goto L7
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Be\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u000bHÆ\u0003Jn\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u000bHÖ\u0001R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0011\u0010\u000eR\u001a\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0012\u0010\u000eR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0013\u0010\u000eR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0014\u0010\u000eR\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0017\u0010\u000e¨\u0006("}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$LayoutStyle;", "", "top", "", "bottom", "left", "right", "width", "height", "radius", "url", "", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;)V", "getBottom", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getHeight", "getLeft", "getRadius", "getRight", "getTop", "getUrl", "()Ljava/lang/String;", "getWidth", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$LayoutStyle;", "equals", "", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class LayoutStyle {

            @SerializedName("bottom")
            private final Double bottom;

            @SerializedName("height")
            private final Double height;

            @SerializedName("left")
            private final Double left;

            @SerializedName("radius")
            private final Double radius;

            @SerializedName("right")
            private final Double right;

            @SerializedName("top")
            private final Double top;

            @SerializedName("url")
            private final String url;

            @SerializedName("width")
            private final Double width;

            public LayoutStyle() {
                this(null, null, null, null, null, null, null, null, 255, null);
            }

            public static /* synthetic */ LayoutStyle copy$default(LayoutStyle r9, Double r10, Double r11, Double r12, Double r13, Double r14, Double r15, Double r16, String r17, int r18, Object r19) {
                if ((r18 & 1) == 0) goto L5;
                Double r2 = r9.top;
            L7:
                if ((r18 & 2) == 0) goto L9;
                Double r3 = r9.bottom;
            L11:
                if ((r18 & 4) == 0) goto L13;
                Double r4 = r9.left;
            L15:
                if ((r18 & 8) == 0) goto L17;
                Double r5 = r9.right;
            L19:
                if ((r18 & 16) == 0) goto L21;
                Double r6 = r9.width;
            L23:
                if ((r18 & 32) == 0) goto L25;
                Double r7 = r9.height;
            L27:
                if ((r18 & 64) == 0) goto L29;
                Double r8 = r9.radius;
            L31:
                if ((r18 & 128) == 0) goto L33;
                String r1 = r9.url;
            L35:
                return r9.copy(r2, r3, r4, r5, r6, r7, r8, r1);
            L33:
                r1 = r17;
                goto L35
            L29:
                r8 = r16;
                goto L31
            L25:
                r7 = r15;
                goto L27
            L21:
                r6 = r14;
                goto L23
            L17:
                r5 = r13;
                goto L19
            L13:
                r4 = r12;
                goto L15
            L9:
                r3 = r11;
                goto L11
            L5:
                r2 = r10;
                goto L7
            }

            public final Double component1() {
                return this.top;
            }

            public final Double component2() {
                return this.bottom;
            }

            public final Double component3() {
                return this.left;
            }

            public final Double component4() {
                return this.right;
            }

            public final Double component5() {
                return this.width;
            }

            public final Double component6() {
                return this.height;
            }

            public final Double component7() {
                return this.radius;
            }

            public final String component8() {
                return this.url;
            }

            public final LayoutStyle copy(Double r11, Double r12, Double r13, Double r14, Double r15, Double r16, Double r17, String r18) {
                return new LayoutStyle(r11, r12, r13, r14, r15, r16, r17, r18);
            }

            public boolean equals(Object r3) {
                if (this != r3) goto L4;
                return true;
            L4:
                if ((r3 instanceof LayoutStyle) == false) goto L22;
                LayoutStyle r4 = (LayoutStyle) r3;
                if (Intrinsics.areEqual(this.top, r4.top) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.bottom, r4.bottom) == true) goto L10;
                return false;
            L10:
                if (Intrinsics.areEqual(this.left, r4.left) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.right, r4.right) == true) goto L14;
                return false;
            L14:
                if (Intrinsics.areEqual(this.width, r4.width) == true) goto L16;
                return false;
            L16:
                if (Intrinsics.areEqual(this.height, r4.height) == true) goto L18;
                return false;
            L18:
                if (Intrinsics.areEqual(this.radius, r4.radius) == true) goto L20;
                return false;
            L20:
                if (Intrinsics.areEqual(this.url, r4.url) == true) goto L34;
                return false;
            L34:
                return true;
            L22:
                return false;
            }

            public int hashCode() {
                Double r0 = this.top;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = r0.hashCode();
            L6:
                int r3 = r2 * 31;
                Double r4 = this.bottom;
                if (r4 == null) goto L9;
                int r5 = r4.hashCode();
            L10:
                int r6 = (r3 + r5) * 31;
                Double r7 = this.left;
                if (r7 == null) goto L13;
                int r8 = r7.hashCode();
            L14:
                int r9 = (r6 + r8) * 31;
                Double r10 = this.right;
                if (r10 == null) goto L17;
                int r11 = r10.hashCode();
            L18:
                int r12 = (r9 + r11) * 31;
                Double r13 = this.width;
                if (r13 == null) goto L21;
                int r14 = r13.hashCode();
            L22:
                int r15 = (r12 + r14) * 31;
                Double r16 = this.height;
                if (r16 == null) goto L25;
                int r17 = r16.hashCode();
            L26:
                int r18 = (r15 + r17) * 31;
                Double r19 = this.radius;
                if (r19 == null) goto L29;
                int r20 = r19.hashCode();
            L30:
                int r21 = (r18 + r20) * 31;
                String r22 = this.url;
                if (r22 == null) goto L34;
                r1 = r22.hashCode();
            L34:
                return r21 + r1;
            L29:
                r20 = 0;
                goto L30
            L25:
                r17 = 0;
                goto L26
            L21:
                r14 = 0;
                goto L22
            L17:
                r11 = 0;
                goto L18
            L13:
                r8 = 0;
                goto L14
            L9:
                r5 = 0;
                goto L10
            L5:
                r2 = 0;
                goto L6
            }

            public String toString() {
                return "LayoutStyle(top=" + this.top + ", bottom=" + this.bottom + ", left=" + this.left + ", right=" + this.right + ", width=" + this.width + ", height=" + this.height + ", radius=" + this.radius + ", url=" + this.url + ")";
            }

            public final Double getBottom() {
                return this.bottom;
            }

            public final Double getHeight() {
                return this.height;
            }

            public final Double getLeft() {
                return this.left;
            }

            public final Double getRadius() {
                return this.radius;
            }

            public final Double getRight() {
                return this.right;
            }

            public final Double getTop() {
                return this.top;
            }

            public final String getUrl() {
                return this.url;
            }

            public final Double getWidth() {
                return this.width;
            }

            public LayoutStyle(Double r1, Double r2, Double r3, Double r4, Double r5, Double r6, Double r7, String r8) {
                this.top = r1;
                this.bottom = r2;
                this.left = r3;
                this.right = r4;
                this.width = r5;
                this.height = r6;
                this.radius = r7;
                this.url = r8;
            }

            public /* synthetic */ LayoutStyle(Double r10, Double r11, Double r12, Double r13, Double r14, Double r15, Double r16, String r17, int r18, DefaultConstructorMarker r19) {
                String r2 = null;
                if ((r18 & 1) == 0) goto L5;
                Double r1 = null;
            L7:
                if ((r18 & 2) == 0) goto L9;
                Double r3 = null;
            L11:
                if ((r18 & 4) == 0) goto L13;
                Double r4 = null;
            L15:
                if ((r18 & 8) == 0) goto L17;
                Double r5 = null;
            L19:
                if ((r18 & 16) == 0) goto L21;
                Double r6 = null;
            L23:
                if ((r18 & 32) == 0) goto L25;
                Double r7 = null;
            L27:
                if ((r18 & 64) == 0) goto L29;
                Double r8 = null;
            L31:
                if ((r18 & 128) != 0) goto L34;
                r2 = r17;
            L34:
                this(r1, r3, r4, r5, r6, r7, r8, r2);
                return;
            L29:
                r8 = r16;
                goto L31
            L25:
                r7 = r15;
                goto L27
            L21:
                r6 = r14;
                goto L23
            L17:
                r5 = r13;
                goto L19
            L13:
                r4 = r12;
                goto L15
            L9:
                r3 = r11;
                goto L11
            L5:
                r1 = r10;
                goto L7
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J2\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$MaskStyle;", "", "height", "", "colorFrom", "", "colorTo", "(Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;)V", "getColorFrom", "()Ljava/lang/String;", "getColorTo", "getHeight", "()Ljava/lang/Double;", "Ljava/lang/Double;", "component1", "component2", "component3", "copy", "(Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$MaskStyle;", "equals", "", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class MaskStyle {

            @SerializedName("color_from")
            private final String colorFrom;

            @SerializedName("color_to")
            private final String colorTo;

            @SerializedName("height")
            private final Double height;

            public MaskStyle() {
                this(null, null, null, 7, null);
            }

            public static /* synthetic */ MaskStyle copy$default(MaskStyle r0, Double r1, String r2, String r3, int r4, Object r5) {
                if ((r4 & 1) == 0) goto L6;
                r1 = r0.height;
            L6:
                if ((r4 & 2) == 0) goto L9;
                r2 = r0.colorFrom;
            L9:
                if ((r4 & 4) == 0) goto L12;
                r3 = r0.colorTo;
            L12:
                return r0.copy(r1, r2, r3);
            }

            public final Double component1() {
                return this.height;
            }

            public final String component2() {
                return this.colorFrom;
            }

            public final String component3() {
                return this.colorTo;
            }

            public final MaskStyle copy(Double r2, String r3, String r4) {
                return new MaskStyle(r2, r3, r4);
            }

            public boolean equals(Object r3) {
                if (this != r3) goto L4;
                return true;
            L4:
                if ((r3 instanceof MaskStyle) == false) goto L12;
                MaskStyle r4 = (MaskStyle) r3;
                if (Intrinsics.areEqual(this.height, r4.height) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.colorFrom, r4.colorFrom) == true) goto L10;
                return false;
            L10:
                if (Intrinsics.areEqual(this.colorTo, r4.colorTo) == true) goto L19;
                return false;
            L19:
                return true;
            L12:
                return false;
            }

            public int hashCode() {
                Double r0 = this.height;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = r0.hashCode();
            L6:
                int r3 = r2 * 31;
                String r4 = this.colorFrom;
                if (r4 == null) goto L9;
                int r5 = r4.hashCode();
            L10:
                int r6 = (r3 + r5) * 31;
                String r7 = this.colorTo;
                if (r7 == null) goto L14;
                r1 = r7.hashCode();
            L14:
                return r6 + r1;
            L9:
                r5 = 0;
                goto L10
            L5:
                r2 = 0;
                goto L6
            }

            public String toString() {
                return "MaskStyle(height=" + this.height + ", colorFrom=" + this.colorFrom + ", colorTo=" + this.colorTo + ")";
            }

            public final String getColorFrom() {
                return this.colorFrom;
            }

            public final String getColorTo() {
                return this.colorTo;
            }

            public final Double getHeight() {
                return this.height;
            }

            public MaskStyle(Double r1, String r2, String r3) {
                this.height = r1;
                this.colorFrom = r2;
                this.colorTo = r3;
            }

            public /* synthetic */ MaskStyle(Double r2, String r3, String r4, int r5, DefaultConstructorMarker r6) {
                if ((r5 & 1) == 0) goto L6;
                r2 = null;
            L6:
                if ((r5 & 2) == 0) goto L9;
                r3 = null;
            L9:
                if ((r5 & 4) == 0) goto L11;
                r4 = null;
            L11:
                this(r2, r3, r4);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$VideoLikeStyle;", "", "icon", "", "text", "(Ljava/lang/String;Ljava/lang/String;)V", "getIcon", "()Ljava/lang/String;", "getText", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class VideoLikeStyle {

            @SerializedName("icon")
            private final String icon;

            @SerializedName("text")
            private final String text;

            public VideoLikeStyle() {
                String r0 = null;
                this(r0, r0, 3, r0);
            }

            public static /* synthetic */ VideoLikeStyle copy$default(VideoLikeStyle r0, String r1, String r2, int r3, Object r4) {
                if ((r3 & 1) == 0) goto L6;
                r1 = r0.icon;
            L6:
                if ((r3 & 2) == 0) goto L9;
                r2 = r0.text;
            L9:
                return r0.copy(r1, r2);
            }

            public final String component1() {
                return this.icon;
            }

            public final String component2() {
                return this.text;
            }

            public final VideoLikeStyle copy(String r2, String r3) {
                return new VideoLikeStyle(r2, r3);
            }

            public boolean equals(Object r3) {
                if (this != r3) goto L4;
                return true;
            L4:
                if ((r3 instanceof VideoLikeStyle) == false) goto L10;
                VideoLikeStyle r4 = (VideoLikeStyle) r3;
                if (Intrinsics.areEqual(this.icon, r4.icon) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.text, r4.text) == true) goto L16;
                return false;
            L16:
                return true;
            L10:
                return false;
            }

            public int hashCode() {
                String r0 = this.icon;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = r0.hashCode();
            L6:
                int r3 = r2 * 31;
                String r4 = this.text;
                if (r4 == null) goto L10;
                r1 = r4.hashCode();
            L10:
                return r3 + r1;
            L5:
                r2 = 0;
                goto L6
            }

            public String toString() {
                return "VideoLikeStyle(icon=" + this.icon + ", text=" + this.text + ")";
            }

            public final String getIcon() {
                return this.icon;
            }

            public final String getText() {
                return this.text;
            }

            public VideoLikeStyle(String r1, String r2) {
                this.icon = r1;
                this.text = r2;
            }

            public /* synthetic */ VideoLikeStyle(String r2, String r3, int r4, DefaultConstructorMarker r5) {
                if ((r4 & 1) == 0) goto L6;
                r2 = null;
            L6:
                if ((r4 & 2) == 0) goto L8;
                r3 = null;
            L8:
                this(r2, r3);
            }
        }

        public ElementStyle() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, false, Integer.MAX_VALUE, null);
        }

        public static /* synthetic */ ElementStyle copy$default(ElementStyle r17, LayoutStyle r18, LayoutStyle r19, CusTextStyle r20, LayoutStyle r21, LayoutStyle r22, CusTextStyle r23, LayoutStyle r24, CusTextStyle r25, LayoutStyle r26, CusTextStyle r27, LayoutStyle r28, LayoutStyle r29, CusTextStyle r30, MaskStyle r31, Double r32, CommonColorStyle r33, CommonColorStyle r34, boolean r35, LayoutStyle r36, PriceContent r37, CusTextStyle r38, LayoutStyle r39, LayoutStyle r40, CusTextStyle r41, LayoutStyle r42, CommonColorStyle r43, LayoutStyle r44, LayoutStyle r45, VideoLikeStyle r46, Integer r47, boolean r48, int r49, Object r50) {
            if ((r49 & 1) == 0) goto L5;
            LayoutStyle r2 = r17.infoLayout;
        L7:
            if ((r49 & 2) == 0) goto L9;
            LayoutStyle r3 = r17.avatarLayout;
        L11:
            if ((r49 & 4) == 0) goto L13;
            CusTextStyle r4 = r17.userTextStyle;
        L15:
            if ((r49 & 8) == 0) goto L17;
            LayoutStyle r5 = r17.logoLayout;
        L19:
            if ((r49 & 16) == 0) goto L21;
            LayoutStyle r6 = r17.logoTextLayout;
        L23:
            if ((r49 & 32) == 0) goto L25;
            CusTextStyle r7 = r17.logoTextStyle;
        L27:
            if ((r49 & 64) == 0) goto L29;
            LayoutStyle r8 = r17.hotLayout;
        L31:
            if ((r49 & 128) == 0) goto L33;
            CusTextStyle r9 = r17.hotTextStyle;
        L35:
            if ((r49 & 256) == 0) goto L37;
            LayoutStyle r10 = r17.arriveTimeIconLayout;
        L39:
            if ((r49 & 512) == 0) goto L41;
            CusTextStyle r11 = r17.arriveTimeTextStyle;
        L43:
            if ((r49 & 1024) == 0) goto L45;
            LayoutStyle r12 = r17.arriveTimeTextLayout;
        L47:
            if ((r49 & 2048) == 0) goto L49;
            LayoutStyle r13 = r17.videoTitleLayout;
        L51:
            if ((r49 & 4096) == 0) goto L53;
            CusTextStyle r14 = r17.videoTitleStyle;
        L55:
            if ((r49 & 8192) == 0) goto L57;
            MaskStyle r15 = r17.maskStyle;
        L58:
            MaskStyle r310 = r15;
            if ((r49 & 16384) == 0) goto L61;
            Double r16 = r17.height;
        L62:
            Double r311 = r16;
            if ((r49 & 32768) == 0) goto L65;
            CommonColorStyle r110 = r17.hotIconStyle;
        L66:
            CommonColorStyle r312 = r110;
            if ((r49 & 65536) == 0) goto L69;
            CommonColorStyle r111 = r17.viewStyle;
        L70:
            CommonColorStyle r313 = r111;
            if ((r49 & 131072) == 0) goto L73;
            boolean r112 = r17.darkModeEnable;
        L74:
            boolean r314 = r112;
            if ((r49 & 262144) == 0) goto L77;
            LayoutStyle r113 = r17.redPacketLayout;
        L78:
            LayoutStyle r315 = r113;
            if ((r49 & 524288) == 0) goto L81;
            PriceContent r114 = r17.price;
        L82:
            PriceContent r316 = r114;
            if ((r49 & 1048576) == 0) goto L85;
            CusTextStyle r115 = r17.liveHeaderStateStyle;
        L86:
            CusTextStyle r317 = r115;
            if ((r49 & 2097152) == 0) goto L89;
            LayoutStyle r116 = r17.liveHeaderEnterIconLayout;
        L90:
            LayoutStyle r318 = r116;
            if ((r49 & 4194304) == 0) goto L93;
            LayoutStyle r117 = r17.coinLayout;
        L94:
            LayoutStyle r410 = r117;
            if ((r49 & 8388608) == 0) goto L97;
            CusTextStyle r118 = r17.coinStyle;
        L98:
            CusTextStyle r411 = r118;
            if ((r49 & 16777216) == 0) goto L101;
            LayoutStyle r119 = r17.coinIconLayout;
        L102:
            LayoutStyle r412 = r119;
            if ((r49 & 33554432) == 0) goto L105;
            CommonColorStyle r120 = r17.playerMaskStyle;
        L106:
            CommonColorStyle r413 = r120;
            if ((r49 & 67108864) == 0) goto L109;
            LayoutStyle r121 = r17.playerLayout;
        L110:
            LayoutStyle r414 = r121;
            if ((r49 & 134217728) == 0) goto L113;
            LayoutStyle r122 = r17.feedbackLayout;
        L114:
            LayoutStyle r415 = r122;
            if ((r49 & 268435456) == 0) goto L117;
            VideoLikeStyle r123 = r17.videoLikeStyle;
        L118:
            VideoLikeStyle r416 = r123;
            if ((r49 & 536870912) == 0) goto L121;
            Integer r124 = r17.colorfulCardStyle;
        L123:
            if ((r49 & 1073741824) == 0) goto L125;
            boolean r1 = r17.removeShadow;
        L127:
            return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r310, r311, r312, r313, r314, r315, r316, r317, r318, r410, r411, r412, r413, r414, r415, r416, r124, r1);
        L125:
            r1 = r48;
            goto L127
        L121:
            r124 = r47;
            goto L123
        L117:
            r123 = r46;
            goto L118
        L113:
            r122 = r45;
            goto L114
        L109:
            r121 = r44;
            goto L110
        L105:
            r120 = r43;
            goto L106
        L101:
            r119 = r42;
            goto L102
        L97:
            r118 = r41;
            goto L98
        L93:
            r117 = r40;
            goto L94
        L89:
            r116 = r39;
            goto L90
        L85:
            r115 = r38;
            goto L86
        L81:
            r114 = r37;
            goto L82
        L77:
            r113 = r36;
            goto L78
        L73:
            r112 = r35;
            goto L74
        L69:
            r111 = r34;
            goto L70
        L65:
            r110 = r33;
            goto L66
        L61:
            r16 = r32;
            goto L62
        L57:
            r15 = r31;
            goto L58
        L53:
            r14 = r30;
            goto L55
        L49:
            r13 = r29;
            goto L51
        L45:
            r12 = r28;
            goto L47
        L41:
            r11 = r27;
            goto L43
        L37:
            r10 = r26;
            goto L39
        L33:
            r9 = r25;
            goto L35
        L29:
            r8 = r24;
            goto L31
        L25:
            r7 = r23;
            goto L27
        L21:
            r6 = r22;
            goto L23
        L17:
            r5 = r21;
            goto L19
        L13:
            r4 = r20;
            goto L15
        L9:
            r3 = r19;
            goto L11
        L5:
            r2 = r18;
            goto L7
        }

        public final LayoutStyle component1() {
            return this.infoLayout;
        }

        public final CusTextStyle component10() {
            return this.arriveTimeTextStyle;
        }

        public final LayoutStyle component11() {
            return this.arriveTimeTextLayout;
        }

        public final LayoutStyle component12() {
            return this.videoTitleLayout;
        }

        public final CusTextStyle component13() {
            return this.videoTitleStyle;
        }

        public final MaskStyle component14() {
            return this.maskStyle;
        }

        public final Double component15() {
            return this.height;
        }

        public final CommonColorStyle component16() {
            return this.hotIconStyle;
        }

        public final CommonColorStyle component17() {
            return this.viewStyle;
        }

        public final boolean component18() {
            return this.darkModeEnable;
        }

        public final LayoutStyle component19() {
            return this.redPacketLayout;
        }

        public final LayoutStyle component2() {
            return this.avatarLayout;
        }

        public final PriceContent component20() {
            return this.price;
        }

        public final CusTextStyle component21() {
            return this.liveHeaderStateStyle;
        }

        public final LayoutStyle component22() {
            return this.liveHeaderEnterIconLayout;
        }

        public final LayoutStyle component23() {
            return this.coinLayout;
        }

        public final CusTextStyle component24() {
            return this.coinStyle;
        }

        public final LayoutStyle component25() {
            return this.coinIconLayout;
        }

        public final CommonColorStyle component26() {
            return this.playerMaskStyle;
        }

        public final LayoutStyle component27() {
            return this.playerLayout;
        }

        public final LayoutStyle component28() {
            return this.feedbackLayout;
        }

        public final VideoLikeStyle component29() {
            return this.videoLikeStyle;
        }

        public final CusTextStyle component3() {
            return this.userTextStyle;
        }

        public final Integer component30() {
            return this.colorfulCardStyle;
        }

        public final boolean component31() {
            return this.removeShadow;
        }

        public final LayoutStyle component4() {
            return this.logoLayout;
        }

        public final LayoutStyle component5() {
            return this.logoTextLayout;
        }

        public final CusTextStyle component6() {
            return this.logoTextStyle;
        }

        public final LayoutStyle component7() {
            return this.hotLayout;
        }

        public final CusTextStyle component8() {
            return this.hotTextStyle;
        }

        public final LayoutStyle component9() {
            return this.arriveTimeIconLayout;
        }

        public final ElementStyle copy(LayoutStyle r34, LayoutStyle r35, CusTextStyle r36, LayoutStyle r37, LayoutStyle r38, CusTextStyle r39, LayoutStyle r40, CusTextStyle r41, LayoutStyle r42, CusTextStyle r43, LayoutStyle r44, LayoutStyle r45, CusTextStyle r46, MaskStyle r47, Double r48, CommonColorStyle r49, CommonColorStyle r50, boolean r51, LayoutStyle r52, PriceContent r53, CusTextStyle r54, LayoutStyle r55, LayoutStyle r56, CusTextStyle r57, LayoutStyle r58, CommonColorStyle r59, LayoutStyle r60, LayoutStyle r61, VideoLikeStyle r62, Integer r63, boolean r64) {
            return new ElementStyle(r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof ElementStyle) == false) goto L68;
            ElementStyle r4 = (ElementStyle) r3;
            if (Intrinsics.areEqual(this.infoLayout, r4.infoLayout) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.avatarLayout, r4.avatarLayout) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.userTextStyle, r4.userTextStyle) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.logoLayout, r4.logoLayout) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.logoTextLayout, r4.logoTextLayout) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.logoTextStyle, r4.logoTextStyle) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.hotLayout, r4.hotLayout) == true) goto L20;
            return false;
        L20:
            if (Intrinsics.areEqual(this.hotTextStyle, r4.hotTextStyle) == true) goto L22;
            return false;
        L22:
            if (Intrinsics.areEqual(this.arriveTimeIconLayout, r4.arriveTimeIconLayout) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.arriveTimeTextStyle, r4.arriveTimeTextStyle) == true) goto L26;
            return false;
        L26:
            if (Intrinsics.areEqual(this.arriveTimeTextLayout, r4.arriveTimeTextLayout) == true) goto L28;
            return false;
        L28:
            if (Intrinsics.areEqual(this.videoTitleLayout, r4.videoTitleLayout) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.videoTitleStyle, r4.videoTitleStyle) == true) goto L32;
            return false;
        L32:
            if (Intrinsics.areEqual(this.maskStyle, r4.maskStyle) == true) goto L34;
            return false;
        L34:
            if (Intrinsics.areEqual(this.height, r4.height) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.hotIconStyle, r4.hotIconStyle) == true) goto L38;
            return false;
        L38:
            if (Intrinsics.areEqual(this.viewStyle, r4.viewStyle) == true) goto L40;
            return false;
        L40:
            if (this.darkModeEnable == r4.darkModeEnable) goto L42;
            return false;
        L42:
            if (Intrinsics.areEqual(this.redPacketLayout, r4.redPacketLayout) == true) goto L44;
            return false;
        L44:
            if (Intrinsics.areEqual(this.price, r4.price) == true) goto L46;
            return false;
        L46:
            if (Intrinsics.areEqual(this.liveHeaderStateStyle, r4.liveHeaderStateStyle) == true) goto L48;
            return false;
        L48:
            if (Intrinsics.areEqual(this.liveHeaderEnterIconLayout, r4.liveHeaderEnterIconLayout) == true) goto L50;
            return false;
        L50:
            if (Intrinsics.areEqual(this.coinLayout, r4.coinLayout) == true) goto L52;
            return false;
        L52:
            if (Intrinsics.areEqual(this.coinStyle, r4.coinStyle) == true) goto L54;
            return false;
        L54:
            if (Intrinsics.areEqual(this.coinIconLayout, r4.coinIconLayout) == true) goto L56;
            return false;
        L56:
            if (Intrinsics.areEqual(this.playerMaskStyle, r4.playerMaskStyle) == true) goto L58;
            return false;
        L58:
            if (Intrinsics.areEqual(this.playerLayout, r4.playerLayout) == true) goto L60;
            return false;
        L60:
            if (Intrinsics.areEqual(this.feedbackLayout, r4.feedbackLayout) == true) goto L62;
            return false;
        L62:
            if (Intrinsics.areEqual(this.videoLikeStyle, r4.videoLikeStyle) == true) goto L64;
            return false;
        L64:
            if (Intrinsics.areEqual(this.colorfulCardStyle, r4.colorfulCardStyle) == true) goto L66;
            return false;
        L66:
            if (this.removeShadow == r4.removeShadow) goto L103;
            return false;
        L103:
            return true;
        L68:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v36, types: [int] */
        /* JADX WARN: Type inference failed for: r0v62, types: [int] */
        /* JADX WARN: Type inference failed for: r2v112 */
        /* JADX WARN: Type inference failed for: r2v49, types: [int] */
        /* JADX WARN: Type inference failed for: r2v95 */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v1, types: [int] */
        /* JADX WARN: Type inference failed for: r3v2 */
        public int hashCode() {
            LayoutStyle r0 = this.infoLayout;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            LayoutStyle r4 = this.avatarLayout;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            CusTextStyle r7 = this.userTextStyle;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            LayoutStyle r10 = this.logoLayout;
            if (r10 == null) goto L17;
            int r11 = r10.hashCode();
        L18:
            int r12 = (r9 + r11) * 31;
            LayoutStyle r13 = this.logoTextLayout;
            if (r13 == null) goto L21;
            int r14 = r13.hashCode();
        L22:
            int r15 = (r12 + r14) * 31;
            CusTextStyle r16 = this.logoTextStyle;
            if (r16 == null) goto L25;
            int r17 = r16.hashCode();
        L26:
            int r18 = (r15 + r17) * 31;
            LayoutStyle r19 = this.hotLayout;
            if (r19 == null) goto L29;
            int r20 = r19.hashCode();
        L30:
            int r21 = (r18 + r20) * 31;
            CusTextStyle r22 = this.hotTextStyle;
            if (r22 == null) goto L33;
            int r23 = r22.hashCode();
        L34:
            int r24 = (r21 + r23) * 31;
            LayoutStyle r25 = this.arriveTimeIconLayout;
            if (r25 == null) goto L37;
            int r26 = r25.hashCode();
        L38:
            int r27 = (r24 + r26) * 31;
            CusTextStyle r28 = this.arriveTimeTextStyle;
            if (r28 == null) goto L41;
            int r29 = r28.hashCode();
        L42:
            int r30 = (r27 + r29) * 31;
            LayoutStyle r31 = this.arriveTimeTextLayout;
            if (r31 == null) goto L45;
            int r32 = r31.hashCode();
        L46:
            int r33 = (r30 + r32) * 31;
            LayoutStyle r34 = this.videoTitleLayout;
            if (r34 == null) goto L49;
            int r35 = r34.hashCode();
        L50:
            int r36 = (r33 + r35) * 31;
            CusTextStyle r37 = this.videoTitleStyle;
            if (r37 == null) goto L53;
            int r38 = r37.hashCode();
        L54:
            int r39 = (r36 + r38) * 31;
            MaskStyle r40 = this.maskStyle;
            if (r40 == null) goto L57;
            int r41 = r40.hashCode();
        L58:
            int r42 = (r39 + r41) * 31;
            Double r43 = this.height;
            if (r43 == null) goto L61;
            int r44 = r43.hashCode();
        L62:
            int r45 = (r42 + r44) * 31;
            CommonColorStyle r46 = this.hotIconStyle;
            if (r46 == null) goto L65;
            int r47 = r46.hashCode();
        L66:
            int r48 = (r45 + r47) * 31;
            CommonColorStyle r49 = this.viewStyle;
            if (r49 == null) goto L69;
            int r50 = r49.hashCode();
        L70:
            int r51 = (r48 + r50) * 31;
            boolean r52 = this.darkModeEnable;
            ?? r53 = 1;
            ?? r54 = r52;
            if (r52 == false) goto L73;
            r54 = 1;
        L73:
            int r55 = (r51 + r54) * 31;
            LayoutStyle r56 = this.redPacketLayout;
            if (r56 == null) goto L76;
            int r57 = r56.hashCode();
        L77:
            int r58 = (r55 + r57) * 31;
            PriceContent r59 = this.price;
            if (r59 == null) goto L80;
            int r60 = r59.hashCode();
        L81:
            int r61 = (r58 + r60) * 31;
            CusTextStyle r62 = this.liveHeaderStateStyle;
            if (r62 == null) goto L84;
            int r63 = r62.hashCode();
        L85:
            int r64 = (r61 + r63) * 31;
            LayoutStyle r65 = this.liveHeaderEnterIconLayout;
            if (r65 == null) goto L88;
            int r66 = r65.hashCode();
        L89:
            int r67 = (r64 + r66) * 31;
            LayoutStyle r68 = this.coinLayout;
            if (r68 == null) goto L92;
            int r69 = r68.hashCode();
        L93:
            int r70 = (r67 + r69) * 31;
            CusTextStyle r71 = this.coinStyle;
            if (r71 == null) goto L96;
            int r72 = r71.hashCode();
        L97:
            int r73 = (r70 + r72) * 31;
            LayoutStyle r74 = this.coinIconLayout;
            if (r74 == null) goto L100;
            int r75 = r74.hashCode();
        L101:
            int r76 = (r73 + r75) * 31;
            CommonColorStyle r77 = this.playerMaskStyle;
            if (r77 == null) goto L104;
            int r78 = r77.hashCode();
        L105:
            int r79 = (r76 + r78) * 31;
            LayoutStyle r80 = this.playerLayout;
            if (r80 == null) goto L108;
            int r81 = r80.hashCode();
        L109:
            int r82 = (r79 + r81) * 31;
            LayoutStyle r84 = this.feedbackLayout;
            if (r84 == null) goto L112;
            int r85 = r84.hashCode();
        L113:
            int r86 = (r82 + r85) * 31;
            VideoLikeStyle r87 = this.videoLikeStyle;
            if (r87 == null) goto L116;
            int r88 = r87.hashCode();
        L117:
            int r89 = (r86 + r88) * 31;
            Integer r90 = this.colorfulCardStyle;
            if (r90 == null) goto L120;
            r1 = r90.hashCode();
        L120:
            int r91 = (r89 + r1) * 31;
            boolean r92 = this.removeShadow;
            if (r92 == true) goto L125;
            r53 = r92;
        L125:
            return r91 + r53;
        L116:
            r88 = 0;
            goto L117
        L112:
            r85 = 0;
            goto L113
        L108:
            r81 = 0;
            goto L109
        L104:
            r78 = 0;
            goto L105
        L100:
            r75 = 0;
            goto L101
        L96:
            r72 = 0;
            goto L97
        L92:
            r69 = 0;
            goto L93
        L88:
            r66 = 0;
            goto L89
        L84:
            r63 = 0;
            goto L85
        L80:
            r60 = 0;
            goto L81
        L76:
            r57 = 0;
            goto L77
        L69:
            r50 = 0;
            goto L70
        L65:
            r47 = 0;
            goto L66
        L61:
            r44 = 0;
            goto L62
        L57:
            r41 = 0;
            goto L58
        L53:
            r38 = 0;
            goto L54
        L49:
            r35 = 0;
            goto L50
        L45:
            r32 = 0;
            goto L46
        L41:
            r29 = 0;
            goto L42
        L37:
            r26 = 0;
            goto L38
        L33:
            r23 = 0;
            goto L34
        L29:
            r20 = 0;
            goto L30
        L25:
            r17 = 0;
            goto L26
        L21:
            r14 = 0;
            goto L22
        L17:
            r11 = 0;
            goto L18
        L13:
            r8 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public String toString() {
            return "ElementStyle(infoLayout=" + this.infoLayout + ", avatarLayout=" + this.avatarLayout + ", userTextStyle=" + this.userTextStyle + ", logoLayout=" + this.logoLayout + ", logoTextLayout=" + this.logoTextLayout + ", logoTextStyle=" + this.logoTextStyle + ", hotLayout=" + this.hotLayout + ", hotTextStyle=" + this.hotTextStyle + ", arriveTimeIconLayout=" + this.arriveTimeIconLayout + ", arriveTimeTextStyle=" + this.arriveTimeTextStyle + ", arriveTimeTextLayout=" + this.arriveTimeTextLayout + ", videoTitleLayout=" + this.videoTitleLayout + ", videoTitleStyle=" + this.videoTitleStyle + ", maskStyle=" + this.maskStyle + ", height=" + this.height + ", hotIconStyle=" + this.hotIconStyle + ", viewStyle=" + this.viewStyle + ", darkModeEnable=" + this.darkModeEnable + ", redPacketLayout=" + this.redPacketLayout + ", price=" + this.price + ", liveHeaderStateStyle=" + this.liveHeaderStateStyle + ", liveHeaderEnterIconLayout=" + this.liveHeaderEnterIconLayout + ", coinLayout=" + this.coinLayout + ", coinStyle=" + this.coinStyle + ", coinIconLayout=" + this.coinIconLayout + ", playerMaskStyle=" + this.playerMaskStyle + ", playerLayout=" + this.playerLayout + ", feedbackLayout=" + this.feedbackLayout + ", videoLikeStyle=" + this.videoLikeStyle + ", colorfulCardStyle=" + this.colorfulCardStyle + ", removeShadow=" + this.removeShadow + ")";
        }

        public final LayoutStyle getArriveTimeIconLayout() {
            return this.arriveTimeIconLayout;
        }

        public final LayoutStyle getArriveTimeTextLayout() {
            return this.arriveTimeTextLayout;
        }

        public final CusTextStyle getArriveTimeTextStyle() {
            return this.arriveTimeTextStyle;
        }

        public final LayoutStyle getAvatarLayout() {
            return this.avatarLayout;
        }

        public final LayoutStyle getCoinIconLayout() {
            return this.coinIconLayout;
        }

        public final LayoutStyle getCoinLayout() {
            return this.coinLayout;
        }

        public final CusTextStyle getCoinStyle() {
            return this.coinStyle;
        }

        public final Integer getColorfulCardStyle() {
            return this.colorfulCardStyle;
        }

        public final boolean getDarkModeEnable() {
            return this.darkModeEnable;
        }

        public final LayoutStyle getFeedbackLayout() {
            return this.feedbackLayout;
        }

        public final Double getHeight() {
            return this.height;
        }

        public final CommonColorStyle getHotIconStyle() {
            return this.hotIconStyle;
        }

        public final LayoutStyle getHotLayout() {
            return this.hotLayout;
        }

        public final CusTextStyle getHotTextStyle() {
            return this.hotTextStyle;
        }

        public final LayoutStyle getInfoLayout() {
            return this.infoLayout;
        }

        public final LayoutStyle getLiveHeaderEnterIconLayout() {
            return this.liveHeaderEnterIconLayout;
        }

        public final CusTextStyle getLiveHeaderStateStyle() {
            return this.liveHeaderStateStyle;
        }

        public final LayoutStyle getLogoLayout() {
            return this.logoLayout;
        }

        public final LayoutStyle getLogoTextLayout() {
            return this.logoTextLayout;
        }

        public final CusTextStyle getLogoTextStyle() {
            return this.logoTextStyle;
        }

        public final MaskStyle getMaskStyle() {
            return this.maskStyle;
        }

        public final LayoutStyle getPlayerLayout() {
            return this.playerLayout;
        }

        public final CommonColorStyle getPlayerMaskStyle() {
            return this.playerMaskStyle;
        }

        public final PriceContent getPrice() {
            return this.price;
        }

        public final LayoutStyle getRedPacketLayout() {
            return this.redPacketLayout;
        }

        public final boolean getRemoveShadow() {
            return this.removeShadow;
        }

        public final CusTextStyle getUserTextStyle() {
            return this.userTextStyle;
        }

        public final VideoLikeStyle getVideoLikeStyle() {
            return this.videoLikeStyle;
        }

        public final LayoutStyle getVideoTitleLayout() {
            return this.videoTitleLayout;
        }

        public final CusTextStyle getVideoTitleStyle() {
            return this.videoTitleStyle;
        }

        public final CommonColorStyle getViewStyle() {
            return this.viewStyle;
        }

        public ElementStyle(LayoutStyle r3, LayoutStyle r4, CusTextStyle r5, LayoutStyle r6, LayoutStyle r7, CusTextStyle r8, LayoutStyle r9, CusTextStyle r10, LayoutStyle r11, CusTextStyle r12, LayoutStyle r13, LayoutStyle r14, CusTextStyle r15, MaskStyle r16, Double r17, CommonColorStyle r18, CommonColorStyle r19, boolean r20, LayoutStyle r21, PriceContent r22, CusTextStyle r23, LayoutStyle r24, LayoutStyle r25, CusTextStyle r26, LayoutStyle r27, CommonColorStyle r28, LayoutStyle r29, LayoutStyle r30, VideoLikeStyle r31, Integer r32, boolean r33) {
            this.infoLayout = r3;
            this.avatarLayout = r4;
            this.userTextStyle = r5;
            this.logoLayout = r6;
            this.logoTextLayout = r7;
            this.logoTextStyle = r8;
            this.hotLayout = r9;
            this.hotTextStyle = r10;
            this.arriveTimeIconLayout = r11;
            this.arriveTimeTextStyle = r12;
            this.arriveTimeTextLayout = r13;
            this.videoTitleLayout = r14;
            this.videoTitleStyle = r15;
            this.maskStyle = r16;
            this.height = r17;
            this.hotIconStyle = r18;
            this.viewStyle = r19;
            this.darkModeEnable = r20;
            this.redPacketLayout = r21;
            this.price = r22;
            this.liveHeaderStateStyle = r23;
            this.liveHeaderEnterIconLayout = r24;
            this.coinLayout = r25;
            this.coinStyle = r26;
            this.coinIconLayout = r27;
            this.playerMaskStyle = r28;
            this.playerLayout = r29;
            this.feedbackLayout = r30;
            this.videoLikeStyle = r31;
            this.colorfulCardStyle = r32;
            this.removeShadow = r33;
        }

        public /* synthetic */ ElementStyle(LayoutStyle r34, LayoutStyle r35, CusTextStyle r36, LayoutStyle r37, LayoutStyle r38, CusTextStyle r39, LayoutStyle r40, CusTextStyle r41, LayoutStyle r42, CusTextStyle r43, LayoutStyle r44, LayoutStyle r45, CusTextStyle r46, MaskStyle r47, Double r48, CommonColorStyle r49, CommonColorStyle r50, boolean r51, LayoutStyle r52, PriceContent r53, CusTextStyle r54, LayoutStyle r55, LayoutStyle r56, CusTextStyle r57, LayoutStyle r58, CommonColorStyle r59, LayoutStyle r60, LayoutStyle r61, VideoLikeStyle r62, Integer r63, boolean r64, int r65, DefaultConstructorMarker r66) {
            if ((r65 & 1) == 0) goto L5;
            LayoutStyle r1 = null;
        L7:
            if ((r65 & 2) == 0) goto L9;
            LayoutStyle r3 = null;
        L11:
            if ((r65 & 4) == 0) goto L13;
            CusTextStyle r4 = null;
        L15:
            if ((r65 & 8) == 0) goto L17;
            LayoutStyle r5 = null;
        L19:
            if ((r65 & 16) == 0) goto L21;
            LayoutStyle r6 = null;
        L23:
            if ((r65 & 32) == 0) goto L25;
            CusTextStyle r7 = null;
        L27:
            if ((r65 & 64) == 0) goto L29;
            LayoutStyle r8 = null;
        L31:
            if ((r65 & 128) == 0) goto L33;
            CusTextStyle r9 = null;
        L35:
            if ((r65 & 256) == 0) goto L37;
            LayoutStyle r10 = null;
        L39:
            if ((r65 & 512) == 0) goto L41;
            CusTextStyle r11 = null;
        L43:
            if ((r65 & 1024) == 0) goto L45;
            LayoutStyle r12 = null;
        L47:
            if ((r65 & 2048) == 0) goto L49;
            LayoutStyle r13 = null;
        L51:
            if ((r65 & 4096) == 0) goto L53;
            CusTextStyle r14 = null;
        L55:
            if ((r65 & 8192) == 0) goto L57;
            MaskStyle r15 = null;
        L59:
            if ((r65 & 16384) == 0) goto L61;
            Double r2 = null;
        L63:
            if ((r65 & 32768) == 0) goto L65;
            CommonColorStyle r16 = null;
        L67:
            if ((r65 & 65536) == 0) goto L69;
            CommonColorStyle r17 = null;
        L70:
            boolean r19 = false;
            if ((r65 & 131072) == 0) goto L73;
            boolean r18 = false;
        L75:
            if ((r65 & 262144) == 0) goto L77;
            LayoutStyle r20 = null;
        L79:
            if ((r65 & 524288) == 0) goto L81;
            PriceContent r21 = null;
        L83:
            if ((r65 & 1048576) == 0) goto L85;
            CusTextStyle r22 = null;
        L87:
            if ((r65 & 2097152) == 0) goto L89;
            LayoutStyle r23 = null;
        L91:
            if ((r65 & 4194304) == 0) goto L93;
            LayoutStyle r24 = null;
        L95:
            if ((r65 & 8388608) == 0) goto L97;
            CusTextStyle r25 = null;
        L99:
            if ((r65 & 16777216) == 0) goto L101;
            LayoutStyle r26 = null;
        L103:
            if ((r65 & 33554432) == 0) goto L105;
            CommonColorStyle r27 = null;
        L107:
            if ((r65 & 67108864) == 0) goto L109;
            LayoutStyle r28 = null;
        L111:
            if ((r65 & 134217728) == 0) goto L113;
            LayoutStyle r29 = null;
        L115:
            if ((r65 & 268435456) == 0) goto L117;
            VideoLikeStyle r30 = null;
        L119:
            if ((r65 & 536870912) == 0) goto L121;
            Integer r31 = null;
        L123:
            if ((r65 & 1073741824) != 0) goto L126;
            r19 = r64;
        L126:
            this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r2, r16, r17, r18, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r19);
            return;
        L121:
            r31 = r63;
            goto L123
        L117:
            r30 = r62;
            goto L119
        L113:
            r29 = r61;
            goto L115
        L109:
            r28 = r60;
            goto L111
        L105:
            r27 = r59;
            goto L107
        L101:
            r26 = r58;
            goto L103
        L97:
            r25 = r57;
            goto L99
        L93:
            r24 = r56;
            goto L95
        L89:
            r23 = r55;
            goto L91
        L85:
            r22 = r54;
            goto L87
        L81:
            r21 = r53;
            goto L83
        L77:
            r20 = r52;
            goto L79
        L73:
            r18 = r51;
            goto L75
        L69:
            r17 = r50;
            goto L70
        L65:
            r16 = r49;
            goto L67
        L61:
            r2 = r48;
            goto L63
        L57:
            r15 = r47;
            goto L59
        L53:
            r14 = r46;
            goto L55
        L49:
            r13 = r45;
            goto L51
        L45:
            r12 = r44;
            goto L47
        L41:
            r11 = r43;
            goto L43
        L37:
            r10 = r42;
            goto L39
        L33:
            r9 = r41;
            goto L35
        L29:
            r8 = r40;
            goto L31
        L25:
            r7 = r39;
            goto L27
        L21:
            r6 = r38;
            goto L23
        L17:
            r5 = r37;
            goto L19
        L13:
            r4 = r36;
            goto L15
        L9:
            r3 = r35;
            goto L11
        L5:
            r1 = r34;
            goto L7
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0019\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\bHÆ\u0003JL\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR&\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0004\u0010\u000eR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Extra;", "", "recommendInfo", "", "isLifeCard", "", "address", "bcm", "", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/Map;)V", "getAddress", "()Ljava/lang/String;", "getBcm", "()Ljava/util/Map;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getRecommendInfo", "setRecommendInfo", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/Map;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Extra;", "equals", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Extra {

        @SerializedName("address")
        private final String address;

        @SerializedName("bcm")
        private final Map<String, Object> bcm;

        @SerializedName("is_life_card")
        private final Boolean isLifeCard;

        @SerializedName("recommend_info")
        private String recommendInfo;

        public Extra() {
            this(null, null, null, null, 15, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Extra copy$default(Extra r0, String r1, Boolean r2, String r3, Map r4, int r5, Object r6) {
            if ((r5 & 1) == 0) goto L6;
            r1 = r0.recommendInfo;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r2 = r0.isLifeCard;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r3 = r0.address;
        L12:
            if ((r5 & 8) == 0) goto L15;
            r4 = r0.bcm;
        L15:
            return r0.copy(r1, r2, r3, r4);
        }

        public final String component1() {
            return this.recommendInfo;
        }

        public final Boolean component2() {
            return this.isLifeCard;
        }

        public final String component3() {
            return this.address;
        }

        public final Map<String, Object> component4() {
            return this.bcm;
        }

        public final Extra copy(String r2, Boolean r3, String r4, Map<String, ? extends Object> r5) {
            return new Extra(r2, r3, r4, r5);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof Extra) == false) goto L14;
            Extra r4 = (Extra) r3;
            if (Intrinsics.areEqual(this.recommendInfo, r4.recommendInfo) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.isLifeCard, r4.isLifeCard) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.address, r4.address) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.bcm, r4.bcm) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public int hashCode() {
            String r0 = this.recommendInfo;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            Boolean r4 = this.isLifeCard;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.address;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            Map<String, Object> r10 = this.bcm;
            if (r10 == null) goto L18;
            r1 = r10.hashCode();
        L18:
            return r9 + r1;
        L13:
            r8 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public String toString() {
            return "Extra(recommendInfo=" + this.recommendInfo + ", isLifeCard=" + this.isLifeCard + ", address=" + this.address + ", bcm=" + this.bcm + ")";
        }

        public final String getAddress() {
            return this.address;
        }

        public final Map<String, Object> getBcm() {
            return this.bcm;
        }

        public final String getRecommendInfo() {
            return this.recommendInfo;
        }

        public final Boolean isLifeCard() {
            return this.isLifeCard;
        }

        public final void setRecommendInfo(String r1) {
            this.recommendInfo = r1;
        }

        public Extra(String r1, Boolean r2, String r3, Map<String, ? extends Object> r4) {
            this.recommendInfo = r1;
            this.isLifeCard = r2;
            this.address = r3;
            this.bcm = r4;
        }

        public /* synthetic */ Extra(String r2, Boolean r3, String r4, Map r5, int r6, DefaultConstructorMarker r7) {
            if ((r6 & 1) == 0) goto L6;
            r2 = null;
        L6:
            if ((r6 & 2) == 0) goto L9;
            r3 = Boolean.FALSE;
        L9:
            if ((r6 & 4) == 0) goto L12;
            r4 = null;
        L12:
            if ((r6 & 8) == 0) goto L14;
            r5 = null;
        L14:
            this(r2, r3, r4, r5);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\nJ&\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Impression;", "", "id", "", "type", "", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getId", "()Ljava/lang/String;", "getType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Impression;", "equals", "", "other", "hashCode", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Impression {

        @SerializedName("id")
        private final String id;

        @SerializedName("type")
        private final Integer type;

        /* JADX WARN: Multi-variable type inference failed */
        public Impression() {
            Object[] r0 = 0 == true ? 1 : 0;
            this(null, r0, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ Impression copy$default(Impression r0, String r1, Integer r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.id;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.type;
        L9:
            return r0.copy(r1, r2);
        }

        public final String component1() {
            return this.id;
        }

        public final Integer component2() {
            return this.type;
        }

        public final Impression copy(String r2, Integer r3) {
            return new Impression(r2, r3);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof Impression) == false) goto L10;
            Impression r4 = (Impression) r3;
            if (Intrinsics.areEqual(this.id, r4.id) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.type, r4.type) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public int hashCode() {
            String r0 = this.id;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            Integer r4 = this.type;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public String toString() {
            return "Impression(id=" + this.id + ", type=" + this.type + ")";
        }

        public final String getId() {
            return this.id;
        }

        public final Integer getType() {
            return this.type;
        }

        public Impression(String r1, Integer r2) {
            this.id = r1;
            this.type = r2;
        }

        public /* synthetic */ Impression(String r2, Integer r3, int r4, DefaultConstructorMarker r5) {
            if ((r4 & 1) == 0) goto L6;
            r2 = null;
        L6:
            if ((r4 & 2) == 0) goto L8;
            r3 = null;
        L8:
            this(r2, r3);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\nJ>\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\nR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$InstantRecommendData;", "", "lynxData", "", "lynxSchema", "appendMargin", "", "appendHeight", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getAppendHeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAppendMargin", "getLynxData", "()Ljava/lang/String;", "getLynxSchema", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$InstantRecommendData;", "equals", "", "other", "hashCode", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class InstantRecommendData {

        @SerializedName("append_height")
        private final Integer appendHeight;

        @SerializedName("append_margin")
        private final Integer appendMargin;

        @SerializedName("lynx_data")
        private final String lynxData;

        @SerializedName("lynx_schema")
        private final String lynxSchema;

        public InstantRecommendData() {
            this(null, null, null, null, 15, null);
        }

        public static /* synthetic */ InstantRecommendData copy$default(InstantRecommendData r0, String r1, String r2, Integer r3, Integer r4, int r5, Object r6) {
            if ((r5 & 1) == 0) goto L6;
            r1 = r0.lynxData;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r2 = r0.lynxSchema;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r3 = r0.appendMargin;
        L12:
            if ((r5 & 8) == 0) goto L15;
            r4 = r0.appendHeight;
        L15:
            return r0.copy(r1, r2, r3, r4);
        }

        public final String component1() {
            return this.lynxData;
        }

        public final String component2() {
            return this.lynxSchema;
        }

        public final Integer component3() {
            return this.appendMargin;
        }

        public final Integer component4() {
            return this.appendHeight;
        }

        public final InstantRecommendData copy(String r2, String r3, Integer r4, Integer r5) {
            return new InstantRecommendData(r2, r3, r4, r5);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof InstantRecommendData) == false) goto L14;
            InstantRecommendData r4 = (InstantRecommendData) r3;
            if (Intrinsics.areEqual(this.lynxData, r4.lynxData) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.lynxSchema, r4.lynxSchema) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.appendMargin, r4.appendMargin) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.appendHeight, r4.appendHeight) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public int hashCode() {
            String r0 = this.lynxData;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.lynxSchema;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            Integer r7 = this.appendMargin;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            Integer r10 = this.appendHeight;
            if (r10 == null) goto L18;
            r1 = r10.hashCode();
        L18:
            return r9 + r1;
        L13:
            r8 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public String toString() {
            return "InstantRecommendData(lynxData=" + this.lynxData + ", lynxSchema=" + this.lynxSchema + ", appendMargin=" + this.appendMargin + ", appendHeight=" + this.appendHeight + ")";
        }

        public final Integer getAppendHeight() {
            return this.appendHeight;
        }

        public final Integer getAppendMargin() {
            return this.appendMargin;
        }

        public final String getLynxData() {
            return this.lynxData;
        }

        public final String getLynxSchema() {
            return this.lynxSchema;
        }

        public InstantRecommendData(String r1, String r2, Integer r3, Integer r4) {
            this.lynxData = r1;
            this.lynxSchema = r2;
            this.appendMargin = r3;
            this.appendHeight = r4;
        }

        public /* synthetic */ InstantRecommendData(String r2, String r3, Integer r4, Integer r5, int r6, DefaultConstructorMarker r7) {
            if ((r6 & 1) == 0) goto L6;
            r2 = null;
        L6:
            if ((r6 & 2) == 0) goto L9;
            r3 = null;
        L9:
            if ((r6 & 4) == 0) goto L12;
            r4 = null;
        L12:
            if ((r6 & 8) == 0) goto L14;
            r5 = null;
        L14:
            this(r2, r3, r4, r5);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003JQ\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\n¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$MarketingData;", "", "returnRewardPrefix", "", "returnReward", "returnRewardUnit", "isNewUser", "transMeta", "returnRewardIcon", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "()Ljava/lang/String;", "getReturnReward", "getReturnRewardIcon", "getReturnRewardPrefix", "getReturnRewardUnit", "getTransMeta", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class MarketingData {

        @SerializedName("is_new_user")
        private final String isNewUser;

        @SerializedName("return_reward")
        private final String returnReward;

        @SerializedName("return_reward_icon")
        private final String returnRewardIcon;

        @SerializedName("return_reward_prefix")
        private final String returnRewardPrefix;

        @SerializedName("return_reward_unit")
        private final String returnRewardUnit;

        @SerializedName("trans_meta")
        private final String transMeta;

        public MarketingData() {
            this(null, null, null, null, null, null, 63, null);
        }

        public static /* synthetic */ MarketingData copy$default(MarketingData r4, String r5, String r6, String r7, String r8, String r9, String r10, int r11, Object r12) {
            if ((r11 & 1) == 0) goto L6;
            r5 = r4.returnRewardPrefix;
        L6:
            if ((r11 & 2) == 0) goto L8;
            r6 = r4.returnReward;
        L8:
            String r13 = r6;
            if ((r11 & 4) == 0) goto L11;
            r7 = r4.returnRewardUnit;
        L11:
            String r0 = r7;
            if ((r11 & 8) == 0) goto L14;
            r8 = r4.isNewUser;
        L14:
            String r1 = r8;
            if ((r11 & 16) == 0) goto L17;
            r9 = r4.transMeta;
        L17:
            String r2 = r9;
            if ((r11 & 32) == 0) goto L20;
            r10 = r4.returnRewardIcon;
        L20:
            String r14 = r5;
            return r4.copy(r14, r13, r0, r1, r2, r10);
        }

        public final String component1() {
            return this.returnRewardPrefix;
        }

        public final String component2() {
            return this.returnReward;
        }

        public final String component3() {
            return this.returnRewardUnit;
        }

        public final String component4() {
            return this.isNewUser;
        }

        public final String component5() {
            return this.transMeta;
        }

        public final String component6() {
            return this.returnRewardIcon;
        }

        public final MarketingData copy(String r9, String r10, String r11, String r12, String r13, String r14) {
            return new MarketingData(r9, r10, r11, r12, r13, r14);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof MarketingData) == false) goto L18;
            MarketingData r4 = (MarketingData) r3;
            if (Intrinsics.areEqual(this.returnRewardPrefix, r4.returnRewardPrefix) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.returnReward, r4.returnReward) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.returnRewardUnit, r4.returnRewardUnit) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.isNewUser, r4.isNewUser) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.transMeta, r4.transMeta) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.returnRewardIcon, r4.returnRewardIcon) == true) goto L28;
            return false;
        L28:
            return true;
        L18:
            return false;
        }

        public int hashCode() {
            String r0 = this.returnRewardPrefix;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.returnReward;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.returnRewardUnit;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            String r10 = this.isNewUser;
            if (r10 == null) goto L17;
            int r11 = r10.hashCode();
        L18:
            int r12 = (r9 + r11) * 31;
            String r13 = this.transMeta;
            if (r13 == null) goto L21;
            int r14 = r13.hashCode();
        L22:
            int r15 = (r12 + r14) * 31;
            String r16 = this.returnRewardIcon;
            if (r16 == null) goto L26;
            r1 = r16.hashCode();
        L26:
            return r15 + r1;
        L21:
            r14 = 0;
            goto L22
        L17:
            r11 = 0;
            goto L18
        L13:
            r8 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public String toString() {
            return "MarketingData(returnRewardPrefix=" + this.returnRewardPrefix + ", returnReward=" + this.returnReward + ", returnRewardUnit=" + this.returnRewardUnit + ", isNewUser=" + this.isNewUser + ", transMeta=" + this.transMeta + ", returnRewardIcon=" + this.returnRewardIcon + ")";
        }

        public final String getReturnReward() {
            return this.returnReward;
        }

        public final String getReturnRewardIcon() {
            return this.returnRewardIcon;
        }

        public final String getReturnRewardPrefix() {
            return this.returnRewardPrefix;
        }

        public final String getReturnRewardUnit() {
            return this.returnRewardUnit;
        }

        public final String getTransMeta() {
            return this.transMeta;
        }

        public final String isNewUser() {
            return this.isNewUser;
        }

        public MarketingData(String r1, String r2, String r3, String r4, String r5, String r6) {
            this.returnRewardPrefix = r1;
            this.returnReward = r2;
            this.returnRewardUnit = r3;
            this.isNewUser = r4;
            this.transMeta = r5;
            this.returnRewardIcon = r6;
        }

        public /* synthetic */ MarketingData(String r6, String r7, String r8, String r9, String r10, String r11, int r12, DefaultConstructorMarker r13) {
            if ((r12 & 1) == 0) goto L5;
            String r14 = null;
        L7:
            if ((r12 & 2) == 0) goto L9;
            String r1 = null;
        L11:
            if ((r12 & 4) == 0) goto L13;
            String r2 = null;
        L15:
            if ((r12 & 8) == 0) goto L17;
            String r3 = null;
        L19:
            if ((r12 & 16) == 0) goto L21;
            String r4 = null;
        L23:
            if ((r12 & 32) == 0) goto L25;
            String r15 = null;
        L26:
            this(r14, r1, r2, r3, r4, r15);
            return;
        L25:
            r15 = r11;
            goto L26
        L21:
            r4 = r10;
            goto L23
        L17:
            r3 = r9;
            goto L19
        L13:
            r2 = r8;
            goto L15
        L9:
            r1 = r7;
            goto L11
        L5:
            r14 = r6;
            goto L7
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0017\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$PriceCommon;", "Ljava/io/Serializable;", "price", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$PriceContent;", "priceAbove", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/TextBaseUIParams;", "priceLabel", "salesCount", "showTags", "", "styleEnum", "", "(Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$PriceContent;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/TextBaseUIParams;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/TextBaseUIParams;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/TextBaseUIParams;Ljava/lang/Boolean;Ljava/lang/Integer;)V", "getPrice", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$PriceContent;", "getPriceAbove", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/TextBaseUIParams;", "getPriceLabel", "getSalesCount", "getShowTags", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getStyleEnum", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static class PriceCommon implements Serializable {

        @SerializedName("price")
        private final PriceContent price;

        @SerializedName("price_above")
        private final TextBaseUIParams priceAbove;

        @SerializedName("price_label")
        private final TextBaseUIParams priceLabel;

        @SerializedName("sales_count")
        private final TextBaseUIParams salesCount;

        @SerializedName("show_tags")
        private final Boolean showTags;

        @SerializedName("style_enum")
        private final Integer styleEnum;

        public PriceCommon() {
            this(null, null, null, null, null, null, 63, null);
        }

        public final PriceContent getPrice() {
            return this.price;
        }

        public final TextBaseUIParams getPriceAbove() {
            return this.priceAbove;
        }

        public final TextBaseUIParams getPriceLabel() {
            return this.priceLabel;
        }

        public final TextBaseUIParams getSalesCount() {
            return this.salesCount;
        }

        public final Boolean getShowTags() {
            return this.showTags;
        }

        public final Integer getStyleEnum() {
            return this.styleEnum;
        }

        public PriceCommon(PriceContent r1, TextBaseUIParams r2, TextBaseUIParams r3, TextBaseUIParams r4, Boolean r5, Integer r6) {
            this.price = r1;
            this.priceAbove = r2;
            this.priceLabel = r3;
            this.salesCount = r4;
            this.showTags = r5;
            this.styleEnum = r6;
        }

        public /* synthetic */ PriceCommon(PriceContent r6, TextBaseUIParams r7, TextBaseUIParams r8, TextBaseUIParams r9, Boolean r10, Integer r11, int r12, DefaultConstructorMarker r13) {
            if ((r12 & 1) == 0) goto L5;
            PriceContent r14 = null;
        L7:
            if ((r12 & 2) == 0) goto L9;
            TextBaseUIParams r1 = null;
        L11:
            if ((r12 & 4) == 0) goto L13;
            TextBaseUIParams r2 = null;
        L15:
            if ((r12 & 8) == 0) goto L17;
            TextBaseUIParams r3 = null;
        L19:
            if ((r12 & 16) == 0) goto L21;
            Boolean r4 = null;
        L23:
            if ((r12 & 32) == 0) goto L25;
            Integer r15 = null;
        L26:
            this(r14, r1, r2, r3, r4, r15);
            return;
        L25:
            r15 = r11;
            goto L26
        L21:
            r4 = r10;
            goto L23
        L17:
            r3 = r9;
            goto L19
        L13:
            r2 = r8;
            goto L15
        L9:
            r1 = r7;
            goto L11
        L5:
            r14 = r6;
            goto L7
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003JE\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$PriceContent;", "", "symbol", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/TextBaseUIParams;", "integers", "decimal", "unit", "style", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/ProductStyle;", "(Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/TextBaseUIParams;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/TextBaseUIParams;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/TextBaseUIParams;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/TextBaseUIParams;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/ProductStyle;)V", "getDecimal", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/TextBaseUIParams;", "getIntegers", "getStyle", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/ProductStyle;", "getSymbol", "getUnit", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class PriceContent {

        @SerializedName("decimals")
        private final TextBaseUIParams decimal;

        @SerializedName("integers")
        private final TextBaseUIParams integers;

        @SerializedName("client_style")
        private final ProductStyle style;

        @SerializedName("symbol")
        private final TextBaseUIParams symbol;

        @SerializedName("unit")
        private final TextBaseUIParams unit;

        public PriceContent() {
            this(null, null, null, null, null, 31, null);
        }

        public static /* synthetic */ PriceContent copy$default(PriceContent r3, TextBaseUIParams r4, TextBaseUIParams r5, TextBaseUIParams r6, TextBaseUIParams r7, ProductStyle r8, int r9, Object r10) {
            if ((r9 & 1) == 0) goto L6;
            r4 = r3.symbol;
        L6:
            if ((r9 & 2) == 0) goto L8;
            r5 = r3.integers;
        L8:
            TextBaseUIParams r11 = r5;
            if ((r9 & 4) == 0) goto L11;
            r6 = r3.decimal;
        L11:
            TextBaseUIParams r0 = r6;
            if ((r9 & 8) == 0) goto L14;
            r7 = r3.unit;
        L14:
            TextBaseUIParams r1 = r7;
            if ((r9 & 16) == 0) goto L17;
            r8 = r3.style;
        L17:
            TextBaseUIParams r12 = r4;
            return r3.copy(r12, r11, r0, r1, r8);
        }

        public final TextBaseUIParams component1() {
            return this.symbol;
        }

        public final TextBaseUIParams component2() {
            return this.integers;
        }

        public final TextBaseUIParams component3() {
            return this.decimal;
        }

        public final TextBaseUIParams component4() {
            return this.unit;
        }

        public final ProductStyle component5() {
            return this.style;
        }

        public final PriceContent copy(TextBaseUIParams r8, TextBaseUIParams r9, TextBaseUIParams r10, TextBaseUIParams r11, ProductStyle r12) {
            return new PriceContent(r8, r9, r10, r11, r12);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof PriceContent) == false) goto L16;
            PriceContent r4 = (PriceContent) r3;
            if (Intrinsics.areEqual(this.symbol, r4.symbol) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.integers, r4.integers) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.decimal, r4.decimal) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.unit, r4.unit) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.style, r4.style) == true) goto L25;
            return false;
        L25:
            return true;
        L16:
            return false;
        }

        public int hashCode() {
            TextBaseUIParams r0 = this.symbol;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            TextBaseUIParams r4 = this.integers;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            TextBaseUIParams r7 = this.decimal;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            TextBaseUIParams r10 = this.unit;
            if (r10 == null) goto L17;
            int r11 = r10.hashCode();
        L18:
            int r12 = (r9 + r11) * 31;
            ProductStyle r13 = this.style;
            if (r13 == null) goto L22;
            r1 = r13.hashCode();
        L22:
            return r12 + r1;
        L17:
            r11 = 0;
            goto L18
        L13:
            r8 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public String toString() {
            return "PriceContent(symbol=" + this.symbol + ", integers=" + this.integers + ", decimal=" + this.decimal + ", unit=" + this.unit + ", style=" + this.style + ")";
        }

        public final TextBaseUIParams getDecimal() {
            return this.decimal;
        }

        public final TextBaseUIParams getIntegers() {
            return this.integers;
        }

        public final ProductStyle getStyle() {
            return this.style;
        }

        public final TextBaseUIParams getSymbol() {
            return this.symbol;
        }

        public final TextBaseUIParams getUnit() {
            return this.unit;
        }

        public PriceContent(TextBaseUIParams r1, TextBaseUIParams r2, TextBaseUIParams r3, TextBaseUIParams r4, ProductStyle r5) {
            this.symbol = r1;
            this.integers = r2;
            this.decimal = r3;
            this.unit = r4;
            this.style = r5;
        }

        public /* synthetic */ PriceContent(TextBaseUIParams r5, TextBaseUIParams r6, TextBaseUIParams r7, TextBaseUIParams r8, ProductStyle r9, int r10, DefaultConstructorMarker r11) {
            if ((r10 & 1) == 0) goto L5;
            TextBaseUIParams r12 = null;
        L7:
            if ((r10 & 2) == 0) goto L9;
            TextBaseUIParams r1 = null;
        L11:
            if ((r10 & 4) == 0) goto L13;
            TextBaseUIParams r2 = null;
        L15:
            if ((r10 & 8) == 0) goto L17;
            TextBaseUIParams r3 = null;
        L19:
            if ((r10 & 16) == 0) goto L21;
            ProductStyle r13 = null;
        L22:
            this(r12, r1, r2, r3, r13);
            return;
        L21:
            r13 = r9;
            goto L22
        L17:
            r3 = r8;
            goto L19
        L13:
            r2 = r7;
            goto L15
        L9:
            r1 = r6;
            goto L11
        L5:
            r12 = r5;
            goto L7
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\bE\n\u0002\u0010\u000b\n\u0002\b\r\b\u0087\b\u0018\u00002\u00020\u0001:\trstuvwxyzBÍ\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\u0012\b\u0002\u0010#\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\n\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(¢\u0006\u0002\u0010)J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010R\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010+J\u000b\u0010S\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u0010\u0010V\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010+J\u000b\u0010W\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u001cHÆ\u0003J\u0010\u0010Z\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010+J\u0010\u0010[\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010+J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\"HÆ\u0003J\u0013\u0010`\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\nHÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010%HÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010(HÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010e\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010+J\u0013\u0010f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\nHÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010j\u001a\u0004\u0018\u00010\u0003HÆ\u0003JÖ\u0002\u0010k\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\u0012\b\u0002\u0010#\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\n2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(HÆ\u0001¢\u0006\u0002\u0010lJ\u0013\u0010m\u001a\u00020n2\b\u0010o\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010p\u001a\u00020\bHÖ\u0001J\t\u0010q\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0017\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010,\u001a\u0004\b*\u0010+R\u001a\u0010\u001d\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010,\u001a\u0004\b-\u0010+R\u001a\u0010\u001e\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010,\u001a\u0004\b.\u0010+R\u001a\u0010\u0011\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010,\u001a\u0004\b/\u0010+R \u0010#\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u00103R\u0018\u0010 \u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u00103R\u0018\u0010'\u001a\u0004\u0018\u00010(8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001c8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010;R\u0018\u0010&\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010;R\u0018\u0010!\u001a\u0004\u0018\u00010\"8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010;R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010;R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u0010IR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010;R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010,\u001a\u0004\bK\u0010+R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bL\u0010;R\u0018\u0010$\u001a\u0004\u0018\u00010%8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u0010NR \u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bO\u00101R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bP\u0010;¨\u0006{"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product;", "", "productId", "", "cover", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$UrlStruct;", "title", "sales", "", "tags", "", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$TagItem;", "price", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$Price;", "kolId", "secKolId", "promotionId", "commodityType", "recommendInfo", "productActivity", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$ProductActivity;", "recReason", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$RecReason;", "bizKind", "productIcon", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$ProductIcon;", "iconName", "extra", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$Extra;", "campaginSales", "campaginStock", "coverLong", "coverRecommend", "platformTextActivity", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$MarketingFloors;", "coupons", "shopInfo", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$ShopInfo;", "link", "decorationParam", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$DecorationParam;", "(Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$UrlStruct;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$Price;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$ProductActivity;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$RecReason;Ljava/lang/Integer;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$ProductIcon;Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$Extra;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$UrlStruct;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$UrlStruct;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$MarketingFloors;Ljava/util/List;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$ShopInfo;Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$DecorationParam;)V", "getBizKind", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCampaginSales", "getCampaginStock", "getCommodityType", "getCoupons", "()Ljava/util/List;", "getCover", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$UrlStruct;", "getCoverLong", "getCoverRecommend", "getDecorationParam", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$DecorationParam;", "getExtra", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$Extra;", "getIconName", "()Ljava/lang/String;", "getKolId", "getLink", "getPlatformTextActivity", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$MarketingFloors;", "getPrice", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$Price;", "getProductActivity", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$ProductActivity;", "getProductIcon", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$ProductIcon;", "getProductId", "getPromotionId", "getRecReason", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$RecReason;", "getRecommendInfo", "getSales", "getSecKolId", "getShopInfo", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$ShopInfo;", "getTags", "getTitle", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$UrlStruct;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$Price;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$ProductActivity;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$RecReason;Ljava/lang/Integer;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$ProductIcon;Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$Extra;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$UrlStruct;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$UrlStruct;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$MarketingFloors;Ljava/util/List;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$ShopInfo;Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$DecorationParam;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product;", "equals", "", "other", "hashCode", "toString", "DecorationParam", "Extra", "MarketingFloors", "Price", "ProductActivity", "ProductIcon", "RecReason", "ShopInfo", "TagItem", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Product {

        @SerializedName("biz_kind")
        private final Integer bizKind;

        @SerializedName("campagin_sales")
        private final Integer campaginSales;

        @SerializedName("campagin_stock")
        private final Integer campaginStock;

        @SerializedName("commodity_type")
        private final Integer commodityType;

        @SerializedName("coupons")
        private final List<Object> coupons;

        @SerializedName("cover")
        private final UrlStruct cover;

        @SerializedName("cover_long")
        private final UrlStruct coverLong;

        @SerializedName("cover_recommend")
        private final UrlStruct coverRecommend;

        @SerializedName("decoration_param")
        private final DecorationParam decorationParam;

        @SerializedName("extra")
        private final Extra extra;

        @SerializedName("icon_name")
        private final String iconName;

        @SerializedName("kol_id")
        private final String kolId;

        @SerializedName("link")
        private final String link;

        @SerializedName("platform_text_activity")
        private final MarketingFloors platformTextActivity;

        @SerializedName("price")
        private final Price price;

        @SerializedName("product_activity")
        private final ProductActivity productActivity;

        @SerializedName("product_icon")
        private final ProductIcon productIcon;

        @SerializedName(PdpOpenThirdParam.KEY_PRODUCT_ID)
        private final String productId;

        @SerializedName(PdpOpenThirdParam.KEY_PROMOTION_ID)
        private final String promotionId;

        @SerializedName("rec_reason")
        private final RecReason recReason;

        @SerializedName("recommend_info")
        private final String recommendInfo;

        @SerializedName("sales")
        private final Integer sales;

        @SerializedName("sec_kol_id")
        private final String secKolId;

        @SerializedName("shop_info")
        private final ShopInfo shopInfo;

        @SerializedName("tags")
        private final List<TagItem> tags;

        @SerializedName("title")
        private final String title;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$DecorationParam;", "", "showBorder", "", "tagText", "", "(Ljava/lang/Boolean;Ljava/lang/String;)V", "getShowBorder", "()Ljava/lang/Boolean;", "setShowBorder", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getTagText", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$DecorationParam;", "equals", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class DecorationParam {

            @SerializedName("show_border")
            private Boolean showBorder;

            @SerializedName("tag_text")
            private final String tagText;

            /* JADX WARN: Multi-variable type inference failed */
            public DecorationParam() {
                Object[] r0 = 0 == true ? 1 : 0;
                this(null, r0, 3, 0 == true ? 1 : 0);
            }

            public static /* synthetic */ DecorationParam copy$default(DecorationParam r0, Boolean r1, String r2, int r3, Object r4) {
                if ((r3 & 1) == 0) goto L6;
                r1 = r0.showBorder;
            L6:
                if ((r3 & 2) == 0) goto L9;
                r2 = r0.tagText;
            L9:
                return r0.copy(r1, r2);
            }

            public final Boolean component1() {
                return this.showBorder;
            }

            public final String component2() {
                return this.tagText;
            }

            public final DecorationParam copy(Boolean r2, String r3) {
                return new DecorationParam(r2, r3);
            }

            public boolean equals(Object r3) {
                if (this != r3) goto L4;
                return true;
            L4:
                if ((r3 instanceof DecorationParam) == false) goto L10;
                DecorationParam r4 = (DecorationParam) r3;
                if (Intrinsics.areEqual(this.showBorder, r4.showBorder) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.tagText, r4.tagText) == true) goto L16;
                return false;
            L16:
                return true;
            L10:
                return false;
            }

            public int hashCode() {
                Boolean r0 = this.showBorder;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = r0.hashCode();
            L6:
                int r3 = r2 * 31;
                String r4 = this.tagText;
                if (r4 == null) goto L10;
                r1 = r4.hashCode();
            L10:
                return r3 + r1;
            L5:
                r2 = 0;
                goto L6
            }

            public String toString() {
                return "DecorationParam(showBorder=" + this.showBorder + ", tagText=" + this.tagText + ")";
            }

            public final Boolean getShowBorder() {
                return this.showBorder;
            }

            public final String getTagText() {
                return this.tagText;
            }

            public final void setShowBorder(Boolean r1) {
                this.showBorder = r1;
            }

            public DecorationParam(Boolean r1, String r2) {
                this.showBorder = r1;
                this.tagText = r2;
            }

            public /* synthetic */ DecorationParam(Boolean r2, String r3, int r4, DefaultConstructorMarker r5) {
                if ((r4 & 1) == 0) goto L6;
                r2 = null;
            L6:
                if ((r4 & 2) == 0) goto L8;
                r3 = null;
            L8:
                this(r2, r3);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0019\b\u0087\b\u0018\u00002\u00020\u0001BU\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t¢\u0006\u0002\u0010\fJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\tHÆ\u0003J^\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\tHÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\t2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u0016\u0010\u000b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0011R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0012R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0011R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u001a\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0014\u0010\u000e¨\u0006\""}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$Extra;", "", "insuranceCommodityFlag", "", "similarLink", "", "coverIsWhiteBg", "isLiveCurrentProduct", "isSmartCoverlong", "", "titleType", "isCoverInPool", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ZLjava/lang/Integer;Z)V", "getCoverIsWhiteBg", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getInsuranceCommodityFlag", "()Z", "()Ljava/lang/String;", "getSimilarLink", "getTitleType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ZLjava/lang/Integer;Z)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$Extra;", "equals", "other", "hashCode", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Extra {

            @SerializedName("cover_is_white_bg")
            private final Integer coverIsWhiteBg;

            @SerializedName("insurance_commodity_flag")
            private final Integer insuranceCommodityFlag;

            @SerializedName("is_cover_in_pool")
            private final boolean isCoverInPool;

            @SerializedName("is_live_current_product")
            private final String isLiveCurrentProduct;

            @SerializedName("is_smart_coverlong")
            private final boolean isSmartCoverlong;

            @SerializedName("similar_link")
            private final String similarLink;

            @SerializedName("title_type")
            private final Integer titleType;

            public Extra() {
                this(null, null, null, null, false, null, false, 127, null);
            }

            public static /* synthetic */ Extra copy$default(Extra r5, Integer r6, String r7, Integer r8, String r9, boolean r10, Integer r11, boolean r12, int r13, Object r14) {
                if ((r13 & 1) == 0) goto L6;
                r6 = r5.insuranceCommodityFlag;
            L6:
                if ((r13 & 2) == 0) goto L8;
                r7 = r5.similarLink;
            L8:
                String r15 = r7;
                if ((r13 & 4) == 0) goto L11;
                r8 = r5.coverIsWhiteBg;
            L11:
                Integer r0 = r8;
                if ((r13 & 8) == 0) goto L14;
                r9 = r5.isLiveCurrentProduct;
            L14:
                String r1 = r9;
                if ((r13 & 16) == 0) goto L17;
                r10 = r5.isSmartCoverlong;
            L17:
                boolean r2 = r10;
                if ((r13 & 32) == 0) goto L20;
                r11 = r5.titleType;
            L20:
                Integer r3 = r11;
                if ((r13 & 64) == 0) goto L23;
                r12 = r5.isCoverInPool;
            L23:
                Integer r16 = r6;
                return r5.copy(r16, r15, r0, r1, r2, r3, r12);
            }

            public final Integer component1() {
                return this.insuranceCommodityFlag;
            }

            public final String component2() {
                return this.similarLink;
            }

            public final Integer component3() {
                return this.coverIsWhiteBg;
            }

            public final String component4() {
                return this.isLiveCurrentProduct;
            }

            public final boolean component5() {
                return this.isSmartCoverlong;
            }

            public final Integer component6() {
                return this.titleType;
            }

            public final boolean component7() {
                return this.isCoverInPool;
            }

            public final Extra copy(Integer r10, String r11, Integer r12, String r13, boolean r14, Integer r15, boolean r16) {
                return new Extra(r10, r11, r12, r13, r14, r15, r16);
            }

            public boolean equals(Object r3) {
                if (this != r3) goto L4;
                return true;
            L4:
                if ((r3 instanceof Extra) == false) goto L20;
                Extra r4 = (Extra) r3;
                if (Intrinsics.areEqual(this.insuranceCommodityFlag, r4.insuranceCommodityFlag) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.similarLink, r4.similarLink) == true) goto L10;
                return false;
            L10:
                if (Intrinsics.areEqual(this.coverIsWhiteBg, r4.coverIsWhiteBg) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.isLiveCurrentProduct, r4.isLiveCurrentProduct) == true) goto L14;
                return false;
            L14:
                if (this.isSmartCoverlong == r4.isSmartCoverlong) goto L16;
                return false;
            L16:
                if (Intrinsics.areEqual(this.titleType, r4.titleType) == true) goto L18;
                return false;
            L18:
                if (this.isCoverInPool == r4.isCoverInPool) goto L31;
                return false;
            L31:
                return true;
            L20:
                return false;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v10, types: [int] */
            /* JADX WARN: Type inference failed for: r0v14, types: [int] */
            /* JADX WARN: Type inference failed for: r2v10, types: [int] */
            /* JADX WARN: Type inference failed for: r2v12 */
            /* JADX WARN: Type inference failed for: r2v16 */
            /* JADX WARN: Type inference failed for: r3v0 */
            /* JADX WARN: Type inference failed for: r3v1, types: [int] */
            /* JADX WARN: Type inference failed for: r3v2 */
            public int hashCode() {
                Integer r0 = this.insuranceCommodityFlag;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = r0.hashCode();
            L6:
                int r3 = r2 * 31;
                String r4 = this.similarLink;
                if (r4 == null) goto L9;
                int r5 = r4.hashCode();
            L10:
                int r6 = (r3 + r5) * 31;
                Integer r7 = this.coverIsWhiteBg;
                if (r7 == null) goto L13;
                int r8 = r7.hashCode();
            L14:
                int r9 = (r6 + r8) * 31;
                String r10 = this.isLiveCurrentProduct;
                if (r10 == null) goto L17;
                int r11 = r10.hashCode();
            L18:
                int r12 = (r9 + r11) * 31;
                boolean r13 = this.isSmartCoverlong;
                ?? r14 = 1;
                ?? r15 = r13;
                if (r13 == false) goto L21;
                r15 = 1;
            L21:
                int r16 = (r12 + r15) * 31;
                Integer r17 = this.titleType;
                if (r17 == null) goto L24;
                r1 = r17.hashCode();
            L24:
                int r18 = (r16 + r1) * 31;
                boolean r19 = this.isCoverInPool;
                if (r19 == true) goto L29;
                r14 = r19;
            L29:
                return r18 + r14;
            L17:
                r11 = 0;
                goto L18
            L13:
                r8 = 0;
                goto L14
            L9:
                r5 = 0;
                goto L10
            L5:
                r2 = 0;
                goto L6
            }

            public String toString() {
                return "Extra(insuranceCommodityFlag=" + this.insuranceCommodityFlag + ", similarLink=" + this.similarLink + ", coverIsWhiteBg=" + this.coverIsWhiteBg + ", isLiveCurrentProduct=" + this.isLiveCurrentProduct + ", isSmartCoverlong=" + this.isSmartCoverlong + ", titleType=" + this.titleType + ", isCoverInPool=" + this.isCoverInPool + ")";
            }

            public final Integer getCoverIsWhiteBg() {
                return this.coverIsWhiteBg;
            }

            public final Integer getInsuranceCommodityFlag() {
                return this.insuranceCommodityFlag;
            }

            public final String getSimilarLink() {
                return this.similarLink;
            }

            public final Integer getTitleType() {
                return this.titleType;
            }

            public final boolean isCoverInPool() {
                return this.isCoverInPool;
            }

            public final String isLiveCurrentProduct() {
                return this.isLiveCurrentProduct;
            }

            public final boolean isSmartCoverlong() {
                return this.isSmartCoverlong;
            }

            public Extra(Integer r1, String r2, Integer r3, String r4, boolean r5, Integer r6, boolean r7) {
                this.insuranceCommodityFlag = r1;
                this.similarLink = r2;
                this.coverIsWhiteBg = r3;
                this.isLiveCurrentProduct = r4;
                this.isSmartCoverlong = r5;
                this.titleType = r6;
                this.isCoverInPool = r7;
            }

            public /* synthetic */ Extra(Integer r6, String r7, Integer r8, String r9, boolean r10, Integer r11, boolean r12, int r13, DefaultConstructorMarker r14) {
                Integer r0 = null;
                if ((r13 & 1) == 0) goto L5;
                Integer r15 = null;
            L7:
                if ((r13 & 2) == 0) goto L9;
                String r1 = null;
            L11:
                if ((r13 & 4) == 0) goto L13;
                Integer r2 = null;
            L15:
                if ((r13 & 8) == 0) goto L17;
                String r3 = null;
            L19:
                if ((r13 & 16) == 0) goto L21;
                boolean r4 = false;
            L23:
                if ((r13 & 32) != 0) goto L27;
                r0 = r11;
            L27:
                if ((r13 & 64) == 0) goto L29;
                boolean r16 = false;
            L30:
                this(r15, r1, r2, r3, r4, r0, r16);
                return;
            L29:
                r16 = r12;
                goto L30
            L21:
                r4 = r10;
                goto L23
            L17:
                r3 = r9;
                goto L19
            L13:
                r2 = r8;
                goto L15
            L9:
                r1 = r7;
                goto L11
            L5:
                r15 = r6;
                goto L7
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$MarketingFloors;", "", "title", "", "icon", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$UrlStruct;", "(Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$UrlStruct;)V", "getIcon", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$UrlStruct;", "getTitle", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class MarketingFloors {

            @SerializedName("icon")
            private final UrlStruct icon;

            @SerializedName("title")
            private final String title;

            /* JADX WARN: Multi-variable type inference failed */
            public MarketingFloors() {
                Object[] r0 = 0 == true ? 1 : 0;
                this(null, r0, 3, 0 == true ? 1 : 0);
            }

            public static /* synthetic */ MarketingFloors copy$default(MarketingFloors r0, String r1, UrlStruct r2, int r3, Object r4) {
                if ((r3 & 1) == 0) goto L6;
                r1 = r0.title;
            L6:
                if ((r3 & 2) == 0) goto L9;
                r2 = r0.icon;
            L9:
                return r0.copy(r1, r2);
            }

            public final String component1() {
                return this.title;
            }

            public final UrlStruct component2() {
                return this.icon;
            }

            public final MarketingFloors copy(String r2, UrlStruct r3) {
                return new MarketingFloors(r2, r3);
            }

            public boolean equals(Object r3) {
                if (this != r3) goto L4;
                return true;
            L4:
                if ((r3 instanceof MarketingFloors) == false) goto L10;
                MarketingFloors r4 = (MarketingFloors) r3;
                if (Intrinsics.areEqual(this.title, r4.title) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.icon, r4.icon) == true) goto L16;
                return false;
            L16:
                return true;
            L10:
                return false;
            }

            public int hashCode() {
                String r0 = this.title;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = r0.hashCode();
            L6:
                int r3 = r2 * 31;
                UrlStruct r4 = this.icon;
                if (r4 == null) goto L10;
                r1 = r4.hashCode();
            L10:
                return r3 + r1;
            L5:
                r2 = 0;
                goto L6
            }

            public String toString() {
                return "MarketingFloors(title=" + this.title + ", icon=" + this.icon + ")";
            }

            public final UrlStruct getIcon() {
                return this.icon;
            }

            public final String getTitle() {
                return this.title;
            }

            public MarketingFloors(String r1, UrlStruct r2) {
                this.title = r1;
                this.icon = r2;
            }

            public /* synthetic */ MarketingFloors(String r2, UrlStruct r3, int r4, DefaultConstructorMarker r5) {
                if ((r4 & 1) == 0) goto L6;
                r2 = null;
            L6:
                if ((r4 & 2) == 0) goto L8;
                r3 = null;
            L8:
                this(r2, r3);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\nJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003JV\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020\u0007HÖ\u0001R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0011\u0010\u000eR\u001a\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0012\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\f¨\u0006!"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$Price;", "", "minPrice", "", "maxPrice", "marketPrice", "typeText", "", "type", "hotSaleSkuId", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getHotSaleSkuId", "()Ljava/lang/String;", "getMarketPrice", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMaxPrice", "getMinPrice", "getType", "getTypeText", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$Price;", "equals", "", "other", "hashCode", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Price {

            @SerializedName("hot_sale_sku_id")
            private final String hotSaleSkuId;

            @SerializedName("market_price")
            private final Integer marketPrice;

            @SerializedName("max_price")
            private final Integer maxPrice;

            @SerializedName("min_price")
            private final Integer minPrice;

            @SerializedName("type")
            private final Integer type;

            @SerializedName("type_text")
            private final String typeText;

            public Price() {
                this(null, null, null, null, null, null, 63, null);
            }

            public static /* synthetic */ Price copy$default(Price r4, Integer r5, Integer r6, Integer r7, String r8, Integer r9, String r10, int r11, Object r12) {
                if ((r11 & 1) == 0) goto L6;
                r5 = r4.minPrice;
            L6:
                if ((r11 & 2) == 0) goto L8;
                r6 = r4.maxPrice;
            L8:
                Integer r13 = r6;
                if ((r11 & 4) == 0) goto L11;
                r7 = r4.marketPrice;
            L11:
                Integer r0 = r7;
                if ((r11 & 8) == 0) goto L14;
                r8 = r4.typeText;
            L14:
                String r1 = r8;
                if ((r11 & 16) == 0) goto L17;
                r9 = r4.type;
            L17:
                Integer r2 = r9;
                if ((r11 & 32) == 0) goto L20;
                r10 = r4.hotSaleSkuId;
            L20:
                Integer r14 = r5;
                return r4.copy(r14, r13, r0, r1, r2, r10);
            }

            public final Integer component1() {
                return this.minPrice;
            }

            public final Integer component2() {
                return this.maxPrice;
            }

            public final Integer component3() {
                return this.marketPrice;
            }

            public final String component4() {
                return this.typeText;
            }

            public final Integer component5() {
                return this.type;
            }

            public final String component6() {
                return this.hotSaleSkuId;
            }

            public final Price copy(Integer r9, Integer r10, Integer r11, String r12, Integer r13, String r14) {
                return new Price(r9, r10, r11, r12, r13, r14);
            }

            public boolean equals(Object r3) {
                if (this != r3) goto L4;
                return true;
            L4:
                if ((r3 instanceof Price) == false) goto L18;
                Price r4 = (Price) r3;
                if (Intrinsics.areEqual(this.minPrice, r4.minPrice) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.maxPrice, r4.maxPrice) == true) goto L10;
                return false;
            L10:
                if (Intrinsics.areEqual(this.marketPrice, r4.marketPrice) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.typeText, r4.typeText) == true) goto L14;
                return false;
            L14:
                if (Intrinsics.areEqual(this.type, r4.type) == true) goto L16;
                return false;
            L16:
                if (Intrinsics.areEqual(this.hotSaleSkuId, r4.hotSaleSkuId) == true) goto L28;
                return false;
            L28:
                return true;
            L18:
                return false;
            }

            public int hashCode() {
                Integer r0 = this.minPrice;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = r0.hashCode();
            L6:
                int r3 = r2 * 31;
                Integer r4 = this.maxPrice;
                if (r4 == null) goto L9;
                int r5 = r4.hashCode();
            L10:
                int r6 = (r3 + r5) * 31;
                Integer r7 = this.marketPrice;
                if (r7 == null) goto L13;
                int r8 = r7.hashCode();
            L14:
                int r9 = (r6 + r8) * 31;
                String r10 = this.typeText;
                if (r10 == null) goto L17;
                int r11 = r10.hashCode();
            L18:
                int r12 = (r9 + r11) * 31;
                Integer r13 = this.type;
                if (r13 == null) goto L21;
                int r14 = r13.hashCode();
            L22:
                int r15 = (r12 + r14) * 31;
                String r16 = this.hotSaleSkuId;
                if (r16 == null) goto L26;
                r1 = r16.hashCode();
            L26:
                return r15 + r1;
            L21:
                r14 = 0;
                goto L22
            L17:
                r11 = 0;
                goto L18
            L13:
                r8 = 0;
                goto L14
            L9:
                r5 = 0;
                goto L10
            L5:
                r2 = 0;
                goto L6
            }

            public String toString() {
                return "Price(minPrice=" + this.minPrice + ", maxPrice=" + this.maxPrice + ", marketPrice=" + this.marketPrice + ", typeText=" + this.typeText + ", type=" + this.type + ", hotSaleSkuId=" + this.hotSaleSkuId + ")";
            }

            public final String getHotSaleSkuId() {
                return this.hotSaleSkuId;
            }

            public final Integer getMarketPrice() {
                return this.marketPrice;
            }

            public final Integer getMaxPrice() {
                return this.maxPrice;
            }

            public final Integer getMinPrice() {
                return this.minPrice;
            }

            public final Integer getType() {
                return this.type;
            }

            public final String getTypeText() {
                return this.typeText;
            }

            public Price(Integer r1, Integer r2, Integer r3, String r4, Integer r5, String r6) {
                this.minPrice = r1;
                this.maxPrice = r2;
                this.marketPrice = r3;
                this.typeText = r4;
                this.type = r5;
                this.hotSaleSkuId = r6;
            }

            public /* synthetic */ Price(Integer r6, Integer r7, Integer r8, String r9, Integer r10, String r11, int r12, DefaultConstructorMarker r13) {
                if ((r12 & 1) == 0) goto L5;
                Integer r14 = null;
            L7:
                if ((r12 & 2) == 0) goto L9;
                Integer r1 = null;
            L11:
                if ((r12 & 4) == 0) goto L13;
                Integer r2 = null;
            L15:
                if ((r12 & 8) == 0) goto L17;
                String r3 = null;
            L19:
                if ((r12 & 16) == 0) goto L21;
                Integer r4 = null;
            L23:
                if ((r12 & 32) == 0) goto L25;
                String r15 = null;
            L26:
                this(r14, r1, r2, r3, r4, r15);
                return;
            L25:
                r15 = r11;
                goto L26
            L21:
                r4 = r10;
                goto L23
            L17:
                r3 = r9;
                goto L19
            L13:
                r2 = r8;
                goto L15
            L9:
                r1 = r7;
                goto L11
            L5:
                r14 = r6;
                goto L7
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\u0015B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$ProductActivity;", "", "activityType", "", "activityConfData", "", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getActivityConfData", "()Ljava/lang/String;", "getActivityType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/String;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$ProductActivity;", "equals", "", "other", "hashCode", "toString", "ProductActivityInfoData", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class ProductActivity {

            @SerializedName("activity_conf_data")
            private final String activityConfData;

            @SerializedName("activity_type")
            private final Integer activityType;

            @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001:\u0002CDBÑ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003JÕ\u0001\u0010<\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010@\u001a\u00020AHÖ\u0001J\t\u0010B\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0018R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0018R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0018R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0018R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0018R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0018¨\u0006E"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$ProductActivity$ProductActivityInfoData;", "", "productActivityType", "", "title", "subTitle", "styleType", "styleData", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$ProductActivity$ProductActivityInfoData$StyleData;", "feLogo", "innerShopUrl", "innerInsertType", "innerInsertObj", "link", "resourceId", "sellingPointsInfo", "innerTopicInfo", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$ProductActivity$ProductActivityInfoData$InnerTopicInfo;", "topicTag", "innerType", "blockName", "sceneId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$ProductActivity$ProductActivityInfoData$StyleData;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$ProductActivity$ProductActivityInfoData$InnerTopicInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBlockName", "()Ljava/lang/String;", "getFeLogo", "getInnerInsertObj", "getInnerInsertType", "getInnerShopUrl", "getInnerTopicInfo", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$ProductActivity$ProductActivityInfoData$InnerTopicInfo;", "getInnerType", "getLink", "getProductActivityType", "getResourceId", "getSceneId", "getSellingPointsInfo", "getStyleData", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$ProductActivity$ProductActivityInfoData$StyleData;", "getStyleType", "getSubTitle", "getTitle", "getTopicTag", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "InnerTopicInfo", "StyleData", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
            public static final class ProductActivityInfoData {

                @SerializedName("block_name")
                private final String blockName;

                @SerializedName("fe_logo")
                private final String feLogo;

                @SerializedName("inner_insert_obj")
                private final String innerInsertObj;

                @SerializedName("inner_insert_type")
                private final String innerInsertType;

                @SerializedName("inner_shop_url")
                private final String innerShopUrl;

                @SerializedName("inner_topic_info")
                private final InnerTopicInfo innerTopicInfo;

                @SerializedName("inner_type")
                private final String innerType;

                @SerializedName("link")
                private final String link;

                @SerializedName("product_activity_type")
                private final String productActivityType;

                @SerializedName("resource_id")
                private final String resourceId;

                @SerializedName("scene_id")
                private final String sceneId;

                @SerializedName("selling_points_info")
                private final String sellingPointsInfo;

                @SerializedName("style_data")
                private final StyleData styleData;

                @SerializedName("style_type")
                private final String styleType;

                @SerializedName("sub_title")
                private final String subTitle;

                @SerializedName("title")
                private final String title;

                @SerializedName("topic_tag")
                private final String topicTag;

                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$ProductActivity$ProductActivityInfoData$InnerTopicInfo;", "", "topicId", "", "topicText", "schemaType", "labelType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLabelType", "()Ljava/lang/String;", "getSchemaType", "getTopicId", "getTopicText", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
                public static final class InnerTopicInfo {

                    @SerializedName("label_type")
                    private final String labelType;

                    @SerializedName("schema_type")
                    private final String schemaType;

                    @SerializedName("topic_id")
                    private final String topicId;

                    @SerializedName("topic_text")
                    private final String topicText;

                    public InnerTopicInfo() {
                        this(null, null, null, null, 15, null);
                    }

                    public static /* synthetic */ InnerTopicInfo copy$default(InnerTopicInfo r0, String r1, String r2, String r3, String r4, int r5, Object r6) {
                        if ((r5 & 1) == 0) goto L6;
                        r1 = r0.topicId;
                    L6:
                        if ((r5 & 2) == 0) goto L9;
                        r2 = r0.topicText;
                    L9:
                        if ((r5 & 4) == 0) goto L12;
                        r3 = r0.schemaType;
                    L12:
                        if ((r5 & 8) == 0) goto L15;
                        r4 = r0.labelType;
                    L15:
                        return r0.copy(r1, r2, r3, r4);
                    }

                    public final String component1() {
                        return this.topicId;
                    }

                    public final String component2() {
                        return this.topicText;
                    }

                    public final String component3() {
                        return this.schemaType;
                    }

                    public final String component4() {
                        return this.labelType;
                    }

                    public final InnerTopicInfo copy(String r2, String r3, String r4, String r5) {
                        return new InnerTopicInfo(r2, r3, r4, r5);
                    }

                    public boolean equals(Object r3) {
                        if (this != r3) goto L4;
                        return true;
                    L4:
                        if ((r3 instanceof InnerTopicInfo) == false) goto L14;
                        InnerTopicInfo r4 = (InnerTopicInfo) r3;
                        if (Intrinsics.areEqual(this.topicId, r4.topicId) == true) goto L8;
                        return false;
                    L8:
                        if (Intrinsics.areEqual(this.topicText, r4.topicText) == true) goto L10;
                        return false;
                    L10:
                        if (Intrinsics.areEqual(this.schemaType, r4.schemaType) == true) goto L12;
                        return false;
                    L12:
                        if (Intrinsics.areEqual(this.labelType, r4.labelType) == true) goto L22;
                        return false;
                    L22:
                        return true;
                    L14:
                        return false;
                    }

                    public int hashCode() {
                        String r0 = this.topicId;
                        int r1 = 0;
                        if (r0 == null) goto L5;
                        int r2 = r0.hashCode();
                    L6:
                        int r3 = r2 * 31;
                        String r4 = this.topicText;
                        if (r4 == null) goto L9;
                        int r5 = r4.hashCode();
                    L10:
                        int r6 = (r3 + r5) * 31;
                        String r7 = this.schemaType;
                        if (r7 == null) goto L13;
                        int r8 = r7.hashCode();
                    L14:
                        int r9 = (r6 + r8) * 31;
                        String r10 = this.labelType;
                        if (r10 == null) goto L18;
                        r1 = r10.hashCode();
                    L18:
                        return r9 + r1;
                    L13:
                        r8 = 0;
                        goto L14
                    L9:
                        r5 = 0;
                        goto L10
                    L5:
                        r2 = 0;
                        goto L6
                    }

                    public String toString() {
                        return "InnerTopicInfo(topicId=" + this.topicId + ", topicText=" + this.topicText + ", schemaType=" + this.schemaType + ", labelType=" + this.labelType + ")";
                    }

                    public final String getLabelType() {
                        return this.labelType;
                    }

                    public final String getSchemaType() {
                        return this.schemaType;
                    }

                    public final String getTopicId() {
                        return this.topicId;
                    }

                    public final String getTopicText() {
                        return this.topicText;
                    }

                    public InnerTopicInfo(String r1, String r2, String r3, String r4) {
                        this.topicId = r1;
                        this.topicText = r2;
                        this.schemaType = r3;
                        this.labelType = r4;
                    }

                    public /* synthetic */ InnerTopicInfo(String r2, String r3, String r4, String r5, int r6, DefaultConstructorMarker r7) {
                        if ((r6 & 1) == 0) goto L6;
                        r2 = null;
                    L6:
                        if ((r6 & 2) == 0) goto L9;
                        r3 = null;
                    L9:
                        if ((r6 & 4) == 0) goto L12;
                        r4 = null;
                    L12:
                        if ((r6 & 8) == 0) goto L14;
                        r5 = null;
                    L14:
                        this(r2, r3, r4, r5);
                    }
                }

                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BY\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J]\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006!"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$ProductActivity$ProductActivityInfoData$StyleData;", "", "feBgurl", "", "feFontColor", "feLogoDefault", "innerBgurl", "innerFontColor", "topicBgurl", "feTopicBgurl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFeBgurl", "()Ljava/lang/String;", "getFeFontColor", "getFeLogoDefault", "getFeTopicBgurl", "getInnerBgurl", "getInnerFontColor", "getTopicBgurl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
                public static final class StyleData {

                    @SerializedName("fe_bgurl")
                    private final String feBgurl;

                    @SerializedName("fe_font_color")
                    private final String feFontColor;

                    @SerializedName("fe_logo_default")
                    private final String feLogoDefault;

                    @SerializedName("fe_topic_bgurl")
                    private final String feTopicBgurl;

                    @SerializedName("inner_bgurl")
                    private final String innerBgurl;

                    @SerializedName("inner_font_color")
                    private final String innerFontColor;

                    @SerializedName("topic_bgurl")
                    private final String topicBgurl;

                    public StyleData() {
                        this(null, null, null, null, null, null, null, 127, null);
                    }

                    public static /* synthetic */ StyleData copy$default(StyleData r5, String r6, String r7, String r8, String r9, String r10, String r11, String r12, int r13, Object r14) {
                        if ((r13 & 1) == 0) goto L6;
                        r6 = r5.feBgurl;
                    L6:
                        if ((r13 & 2) == 0) goto L8;
                        r7 = r5.feFontColor;
                    L8:
                        String r15 = r7;
                        if ((r13 & 4) == 0) goto L11;
                        r8 = r5.feLogoDefault;
                    L11:
                        String r0 = r8;
                        if ((r13 & 8) == 0) goto L14;
                        r9 = r5.innerBgurl;
                    L14:
                        String r1 = r9;
                        if ((r13 & 16) == 0) goto L17;
                        r10 = r5.innerFontColor;
                    L17:
                        String r2 = r10;
                        if ((r13 & 32) == 0) goto L20;
                        r11 = r5.topicBgurl;
                    L20:
                        String r3 = r11;
                        if ((r13 & 64) == 0) goto L23;
                        r12 = r5.feTopicBgurl;
                    L23:
                        String r16 = r6;
                        return r5.copy(r16, r15, r0, r1, r2, r3, r12);
                    }

                    public final String component1() {
                        return this.feBgurl;
                    }

                    public final String component2() {
                        return this.feFontColor;
                    }

                    public final String component3() {
                        return this.feLogoDefault;
                    }

                    public final String component4() {
                        return this.innerBgurl;
                    }

                    public final String component5() {
                        return this.innerFontColor;
                    }

                    public final String component6() {
                        return this.topicBgurl;
                    }

                    public final String component7() {
                        return this.feTopicBgurl;
                    }

                    public final StyleData copy(String r10, String r11, String r12, String r13, String r14, String r15, String r16) {
                        return new StyleData(r10, r11, r12, r13, r14, r15, r16);
                    }

                    public boolean equals(Object r3) {
                        if (this != r3) goto L4;
                        return true;
                    L4:
                        if ((r3 instanceof StyleData) == false) goto L20;
                        StyleData r4 = (StyleData) r3;
                        if (Intrinsics.areEqual(this.feBgurl, r4.feBgurl) == true) goto L8;
                        return false;
                    L8:
                        if (Intrinsics.areEqual(this.feFontColor, r4.feFontColor) == true) goto L10;
                        return false;
                    L10:
                        if (Intrinsics.areEqual(this.feLogoDefault, r4.feLogoDefault) == true) goto L12;
                        return false;
                    L12:
                        if (Intrinsics.areEqual(this.innerBgurl, r4.innerBgurl) == true) goto L14;
                        return false;
                    L14:
                        if (Intrinsics.areEqual(this.innerFontColor, r4.innerFontColor) == true) goto L16;
                        return false;
                    L16:
                        if (Intrinsics.areEqual(this.topicBgurl, r4.topicBgurl) == true) goto L18;
                        return false;
                    L18:
                        if (Intrinsics.areEqual(this.feTopicBgurl, r4.feTopicBgurl) == true) goto L31;
                        return false;
                    L31:
                        return true;
                    L20:
                        return false;
                    }

                    public int hashCode() {
                        String r0 = this.feBgurl;
                        int r1 = 0;
                        if (r0 == null) goto L5;
                        int r2 = r0.hashCode();
                    L6:
                        int r3 = r2 * 31;
                        String r4 = this.feFontColor;
                        if (r4 == null) goto L9;
                        int r5 = r4.hashCode();
                    L10:
                        int r6 = (r3 + r5) * 31;
                        String r7 = this.feLogoDefault;
                        if (r7 == null) goto L13;
                        int r8 = r7.hashCode();
                    L14:
                        int r9 = (r6 + r8) * 31;
                        String r10 = this.innerBgurl;
                        if (r10 == null) goto L17;
                        int r11 = r10.hashCode();
                    L18:
                        int r12 = (r9 + r11) * 31;
                        String r13 = this.innerFontColor;
                        if (r13 == null) goto L21;
                        int r14 = r13.hashCode();
                    L22:
                        int r15 = (r12 + r14) * 31;
                        String r16 = this.topicBgurl;
                        if (r16 == null) goto L25;
                        int r17 = r16.hashCode();
                    L26:
                        int r18 = (r15 + r17) * 31;
                        String r19 = this.feTopicBgurl;
                        if (r19 == null) goto L30;
                        r1 = r19.hashCode();
                    L30:
                        return r18 + r1;
                    L25:
                        r17 = 0;
                        goto L26
                    L21:
                        r14 = 0;
                        goto L22
                    L17:
                        r11 = 0;
                        goto L18
                    L13:
                        r8 = 0;
                        goto L14
                    L9:
                        r5 = 0;
                        goto L10
                    L5:
                        r2 = 0;
                        goto L6
                    }

                    public String toString() {
                        return "StyleData(feBgurl=" + this.feBgurl + ", feFontColor=" + this.feFontColor + ", feLogoDefault=" + this.feLogoDefault + ", innerBgurl=" + this.innerBgurl + ", innerFontColor=" + this.innerFontColor + ", topicBgurl=" + this.topicBgurl + ", feTopicBgurl=" + this.feTopicBgurl + ")";
                    }

                    public final String getFeBgurl() {
                        return this.feBgurl;
                    }

                    public final String getFeFontColor() {
                        return this.feFontColor;
                    }

                    public final String getFeLogoDefault() {
                        return this.feLogoDefault;
                    }

                    public final String getFeTopicBgurl() {
                        return this.feTopicBgurl;
                    }

                    public final String getInnerBgurl() {
                        return this.innerBgurl;
                    }

                    public final String getInnerFontColor() {
                        return this.innerFontColor;
                    }

                    public final String getTopicBgurl() {
                        return this.topicBgurl;
                    }

                    public StyleData(String r1, String r2, String r3, String r4, String r5, String r6, String r7) {
                        this.feBgurl = r1;
                        this.feFontColor = r2;
                        this.feLogoDefault = r3;
                        this.innerBgurl = r4;
                        this.innerFontColor = r5;
                        this.topicBgurl = r6;
                        this.feTopicBgurl = r7;
                    }

                    public /* synthetic */ StyleData(String r7, String r8, String r9, String r10, String r11, String r12, String r13, int r14, DefaultConstructorMarker r15) {
                        if ((r14 & 1) == 0) goto L5;
                        String r16 = null;
                    L7:
                        if ((r14 & 2) == 0) goto L9;
                        String r1 = null;
                    L11:
                        if ((r14 & 4) == 0) goto L13;
                        String r2 = null;
                    L15:
                        if ((r14 & 8) == 0) goto L17;
                        String r3 = null;
                    L19:
                        if ((r14 & 16) == 0) goto L21;
                        String r4 = null;
                    L23:
                        if ((r14 & 32) == 0) goto L25;
                        String r5 = null;
                    L27:
                        if ((r14 & 64) == 0) goto L29;
                        String r17 = null;
                    L30:
                        this(r16, r1, r2, r3, r4, r5, r17);
                        return;
                    L29:
                        r17 = r13;
                        goto L30
                    L25:
                        r5 = r12;
                        goto L27
                    L21:
                        r4 = r11;
                        goto L23
                    L17:
                        r3 = r10;
                        goto L19
                    L13:
                        r2 = r9;
                        goto L15
                    L9:
                        r1 = r8;
                        goto L11
                    L5:
                        r16 = r7;
                        goto L7
                    }
                }

                public ProductActivityInfoData() {
                    this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 131071, null);
                }

                public static /* synthetic */ ProductActivityInfoData copy$default(ProductActivityInfoData r17, String r18, String r19, String r20, String r21, StyleData r22, String r23, String r24, String r25, String r26, String r27, String r28, String r29, InnerTopicInfo r30, String r31, String r32, String r33, String r34, int r35, Object r36) {
                    if ((r35 & 1) == 0) goto L5;
                    String r2 = r17.productActivityType;
                L7:
                    if ((r35 & 2) == 0) goto L9;
                    String r3 = r17.title;
                L11:
                    if ((r35 & 4) == 0) goto L13;
                    String r4 = r17.subTitle;
                L15:
                    if ((r35 & 8) == 0) goto L17;
                    String r5 = r17.styleType;
                L19:
                    if ((r35 & 16) == 0) goto L21;
                    StyleData r6 = r17.styleData;
                L23:
                    if ((r35 & 32) == 0) goto L25;
                    String r7 = r17.feLogo;
                L27:
                    if ((r35 & 64) == 0) goto L29;
                    String r8 = r17.innerShopUrl;
                L31:
                    if ((r35 & 128) == 0) goto L33;
                    String r9 = r17.innerInsertType;
                L35:
                    if ((r35 & 256) == 0) goto L37;
                    String r10 = r17.innerInsertObj;
                L39:
                    if ((r35 & 512) == 0) goto L41;
                    String r11 = r17.link;
                L43:
                    if ((r35 & 1024) == 0) goto L45;
                    String r12 = r17.resourceId;
                L47:
                    if ((r35 & 2048) == 0) goto L49;
                    String r13 = r17.sellingPointsInfo;
                L51:
                    if ((r35 & 4096) == 0) goto L53;
                    InnerTopicInfo r14 = r17.innerTopicInfo;
                L55:
                    if ((r35 & 8192) == 0) goto L57;
                    String r15 = r17.topicTag;
                L58:
                    String r37 = r15;
                    if ((r35 & 16384) == 0) goto L61;
                    String r16 = r17.innerType;
                L62:
                    String r38 = r16;
                    if ((r35 & 32768) == 0) goto L65;
                    String r110 = r17.blockName;
                L67:
                    if ((r35 & 65536) == 0) goto L69;
                    String r1 = r17.sceneId;
                L71:
                    return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r37, r38, r110, r1);
                L69:
                    r1 = r34;
                    goto L71
                L65:
                    r110 = r33;
                    goto L67
                L61:
                    r16 = r32;
                    goto L62
                L57:
                    r15 = r31;
                    goto L58
                L53:
                    r14 = r30;
                    goto L55
                L49:
                    r13 = r29;
                    goto L51
                L45:
                    r12 = r28;
                    goto L47
                L41:
                    r11 = r27;
                    goto L43
                L37:
                    r10 = r26;
                    goto L39
                L33:
                    r9 = r25;
                    goto L35
                L29:
                    r8 = r24;
                    goto L31
                L25:
                    r7 = r23;
                    goto L27
                L21:
                    r6 = r22;
                    goto L23
                L17:
                    r5 = r21;
                    goto L19
                L13:
                    r4 = r20;
                    goto L15
                L9:
                    r3 = r19;
                    goto L11
                L5:
                    r2 = r18;
                    goto L7
                }

                public final String component1() {
                    return this.productActivityType;
                }

                public final String component10() {
                    return this.link;
                }

                public final String component11() {
                    return this.resourceId;
                }

                public final String component12() {
                    return this.sellingPointsInfo;
                }

                public final InnerTopicInfo component13() {
                    return this.innerTopicInfo;
                }

                public final String component14() {
                    return this.topicTag;
                }

                public final String component15() {
                    return this.innerType;
                }

                public final String component16() {
                    return this.blockName;
                }

                public final String component17() {
                    return this.sceneId;
                }

                public final String component2() {
                    return this.title;
                }

                public final String component3() {
                    return this.subTitle;
                }

                public final String component4() {
                    return this.styleType;
                }

                public final StyleData component5() {
                    return this.styleData;
                }

                public final String component6() {
                    return this.feLogo;
                }

                public final String component7() {
                    return this.innerShopUrl;
                }

                public final String component8() {
                    return this.innerInsertType;
                }

                public final String component9() {
                    return this.innerInsertObj;
                }

                public final ProductActivityInfoData copy(String r20, String r21, String r22, String r23, StyleData r24, String r25, String r26, String r27, String r28, String r29, String r30, String r31, InnerTopicInfo r32, String r33, String r34, String r35, String r36) {
                    return new ProductActivityInfoData(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36);
                }

                public boolean equals(Object r3) {
                    if (this != r3) goto L4;
                    return true;
                L4:
                    if ((r3 instanceof ProductActivityInfoData) == false) goto L40;
                    ProductActivityInfoData r4 = (ProductActivityInfoData) r3;
                    if (Intrinsics.areEqual(this.productActivityType, r4.productActivityType) == true) goto L8;
                    return false;
                L8:
                    if (Intrinsics.areEqual(this.title, r4.title) == true) goto L10;
                    return false;
                L10:
                    if (Intrinsics.areEqual(this.subTitle, r4.subTitle) == true) goto L12;
                    return false;
                L12:
                    if (Intrinsics.areEqual(this.styleType, r4.styleType) == true) goto L14;
                    return false;
                L14:
                    if (Intrinsics.areEqual(this.styleData, r4.styleData) == true) goto L16;
                    return false;
                L16:
                    if (Intrinsics.areEqual(this.feLogo, r4.feLogo) == true) goto L18;
                    return false;
                L18:
                    if (Intrinsics.areEqual(this.innerShopUrl, r4.innerShopUrl) == true) goto L20;
                    return false;
                L20:
                    if (Intrinsics.areEqual(this.innerInsertType, r4.innerInsertType) == true) goto L22;
                    return false;
                L22:
                    if (Intrinsics.areEqual(this.innerInsertObj, r4.innerInsertObj) == true) goto L24;
                    return false;
                L24:
                    if (Intrinsics.areEqual(this.link, r4.link) == true) goto L26;
                    return false;
                L26:
                    if (Intrinsics.areEqual(this.resourceId, r4.resourceId) == true) goto L28;
                    return false;
                L28:
                    if (Intrinsics.areEqual(this.sellingPointsInfo, r4.sellingPointsInfo) == true) goto L30;
                    return false;
                L30:
                    if (Intrinsics.areEqual(this.innerTopicInfo, r4.innerTopicInfo) == true) goto L32;
                    return false;
                L32:
                    if (Intrinsics.areEqual(this.topicTag, r4.topicTag) == true) goto L34;
                    return false;
                L34:
                    if (Intrinsics.areEqual(this.innerType, r4.innerType) == true) goto L36;
                    return false;
                L36:
                    if (Intrinsics.areEqual(this.blockName, r4.blockName) == true) goto L38;
                    return false;
                L38:
                    if (Intrinsics.areEqual(this.sceneId, r4.sceneId) == true) goto L61;
                    return false;
                L61:
                    return true;
                L40:
                    return false;
                }

                public int hashCode() {
                    String r0 = this.productActivityType;
                    int r1 = 0;
                    if (r0 == null) goto L5;
                    int r2 = r0.hashCode();
                L6:
                    int r3 = r2 * 31;
                    String r4 = this.title;
                    if (r4 == null) goto L9;
                    int r5 = r4.hashCode();
                L10:
                    int r6 = (r3 + r5) * 31;
                    String r7 = this.subTitle;
                    if (r7 == null) goto L13;
                    int r8 = r7.hashCode();
                L14:
                    int r9 = (r6 + r8) * 31;
                    String r10 = this.styleType;
                    if (r10 == null) goto L17;
                    int r11 = r10.hashCode();
                L18:
                    int r12 = (r9 + r11) * 31;
                    StyleData r13 = this.styleData;
                    if (r13 == null) goto L21;
                    int r14 = r13.hashCode();
                L22:
                    int r15 = (r12 + r14) * 31;
                    String r16 = this.feLogo;
                    if (r16 == null) goto L25;
                    int r17 = r16.hashCode();
                L26:
                    int r18 = (r15 + r17) * 31;
                    String r19 = this.innerShopUrl;
                    if (r19 == null) goto L29;
                    int r20 = r19.hashCode();
                L30:
                    int r21 = (r18 + r20) * 31;
                    String r22 = this.innerInsertType;
                    if (r22 == null) goto L33;
                    int r23 = r22.hashCode();
                L34:
                    int r24 = (r21 + r23) * 31;
                    String r25 = this.innerInsertObj;
                    if (r25 == null) goto L37;
                    int r26 = r25.hashCode();
                L38:
                    int r27 = (r24 + r26) * 31;
                    String r28 = this.link;
                    if (r28 == null) goto L41;
                    int r29 = r28.hashCode();
                L42:
                    int r30 = (r27 + r29) * 31;
                    String r31 = this.resourceId;
                    if (r31 == null) goto L45;
                    int r32 = r31.hashCode();
                L46:
                    int r33 = (r30 + r32) * 31;
                    String r34 = this.sellingPointsInfo;
                    if (r34 == null) goto L49;
                    int r35 = r34.hashCode();
                L50:
                    int r36 = (r33 + r35) * 31;
                    InnerTopicInfo r37 = this.innerTopicInfo;
                    if (r37 == null) goto L53;
                    int r38 = r37.hashCode();
                L54:
                    int r39 = (r36 + r38) * 31;
                    String r40 = this.topicTag;
                    if (r40 == null) goto L57;
                    int r41 = r40.hashCode();
                L58:
                    int r42 = (r39 + r41) * 31;
                    String r43 = this.innerType;
                    if (r43 == null) goto L61;
                    int r44 = r43.hashCode();
                L62:
                    int r45 = (r42 + r44) * 31;
                    String r46 = this.blockName;
                    if (r46 == null) goto L65;
                    int r47 = r46.hashCode();
                L66:
                    int r48 = (r45 + r47) * 31;
                    String r49 = this.sceneId;
                    if (r49 == null) goto L70;
                    r1 = r49.hashCode();
                L70:
                    return r48 + r1;
                L65:
                    r47 = 0;
                    goto L66
                L61:
                    r44 = 0;
                    goto L62
                L57:
                    r41 = 0;
                    goto L58
                L53:
                    r38 = 0;
                    goto L54
                L49:
                    r35 = 0;
                    goto L50
                L45:
                    r32 = 0;
                    goto L46
                L41:
                    r29 = 0;
                    goto L42
                L37:
                    r26 = 0;
                    goto L38
                L33:
                    r23 = 0;
                    goto L34
                L29:
                    r20 = 0;
                    goto L30
                L25:
                    r17 = 0;
                    goto L26
                L21:
                    r14 = 0;
                    goto L22
                L17:
                    r11 = 0;
                    goto L18
                L13:
                    r8 = 0;
                    goto L14
                L9:
                    r5 = 0;
                    goto L10
                L5:
                    r2 = 0;
                    goto L6
                }

                public String toString() {
                    return "ProductActivityInfoData(productActivityType=" + this.productActivityType + ", title=" + this.title + ", subTitle=" + this.subTitle + ", styleType=" + this.styleType + ", styleData=" + this.styleData + ", feLogo=" + this.feLogo + ", innerShopUrl=" + this.innerShopUrl + ", innerInsertType=" + this.innerInsertType + ", innerInsertObj=" + this.innerInsertObj + ", link=" + this.link + ", resourceId=" + this.resourceId + ", sellingPointsInfo=" + this.sellingPointsInfo + ", innerTopicInfo=" + this.innerTopicInfo + ", topicTag=" + this.topicTag + ", innerType=" + this.innerType + ", blockName=" + this.blockName + ", sceneId=" + this.sceneId + ")";
                }

                public final String getBlockName() {
                    return this.blockName;
                }

                public final String getFeLogo() {
                    return this.feLogo;
                }

                public final String getInnerInsertObj() {
                    return this.innerInsertObj;
                }

                public final String getInnerInsertType() {
                    return this.innerInsertType;
                }

                public final String getInnerShopUrl() {
                    return this.innerShopUrl;
                }

                public final InnerTopicInfo getInnerTopicInfo() {
                    return this.innerTopicInfo;
                }

                public final String getInnerType() {
                    return this.innerType;
                }

                public final String getLink() {
                    return this.link;
                }

                public final String getProductActivityType() {
                    return this.productActivityType;
                }

                public final String getResourceId() {
                    return this.resourceId;
                }

                public final String getSceneId() {
                    return this.sceneId;
                }

                public final String getSellingPointsInfo() {
                    return this.sellingPointsInfo;
                }

                public final StyleData getStyleData() {
                    return this.styleData;
                }

                public final String getStyleType() {
                    return this.styleType;
                }

                public final String getSubTitle() {
                    return this.subTitle;
                }

                public final String getTitle() {
                    return this.title;
                }

                public final String getTopicTag() {
                    return this.topicTag;
                }

                public ProductActivityInfoData(String r3, String r4, String r5, String r6, StyleData r7, String r8, String r9, String r10, String r11, String r12, String r13, String r14, InnerTopicInfo r15, String r16, String r17, String r18, String r19) {
                    this.productActivityType = r3;
                    this.title = r4;
                    this.subTitle = r5;
                    this.styleType = r6;
                    this.styleData = r7;
                    this.feLogo = r8;
                    this.innerShopUrl = r9;
                    this.innerInsertType = r10;
                    this.innerInsertObj = r11;
                    this.link = r12;
                    this.resourceId = r13;
                    this.sellingPointsInfo = r14;
                    this.innerTopicInfo = r15;
                    this.topicTag = r16;
                    this.innerType = r17;
                    this.blockName = r18;
                    this.sceneId = r19;
                }

                public /* synthetic */ ProductActivityInfoData(String r19, String r20, String r21, String r22, StyleData r23, String r24, String r25, String r26, String r27, String r28, String r29, String r30, InnerTopicInfo r31, String r32, String r33, String r34, String r35, int r36, DefaultConstructorMarker r37) {
                    if ((r36 & 1) == 0) goto L5;
                    String r1 = null;
                L7:
                    if ((r36 & 2) == 0) goto L9;
                    String r3 = null;
                L11:
                    if ((r36 & 4) == 0) goto L13;
                    String r4 = null;
                L15:
                    if ((r36 & 8) == 0) goto L17;
                    String r5 = null;
                L19:
                    if ((r36 & 16) == 0) goto L21;
                    StyleData r6 = null;
                L23:
                    if ((r36 & 32) == 0) goto L25;
                    String r7 = null;
                L27:
                    if ((r36 & 64) == 0) goto L29;
                    String r8 = null;
                L31:
                    if ((r36 & 128) == 0) goto L33;
                    String r9 = null;
                L35:
                    if ((r36 & 256) == 0) goto L37;
                    String r10 = null;
                L39:
                    if ((r36 & 512) == 0) goto L41;
                    String r11 = null;
                L43:
                    if ((r36 & 1024) == 0) goto L45;
                    String r12 = null;
                L47:
                    if ((r36 & 2048) == 0) goto L49;
                    String r13 = null;
                L51:
                    if ((r36 & 4096) == 0) goto L53;
                    InnerTopicInfo r14 = null;
                L55:
                    if ((r36 & 8192) == 0) goto L57;
                    String r15 = null;
                L59:
                    if ((r36 & 16384) == 0) goto L61;
                    String r2 = null;
                L63:
                    if ((r36 & 32768) == 0) goto L65;
                    String r16 = null;
                L67:
                    if ((r36 & 65536) == 0) goto L69;
                    String r0 = null;
                L70:
                    this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r2, r16, r0);
                    return;
                L69:
                    r0 = r35;
                    goto L70
                L65:
                    r16 = r34;
                    goto L67
                L61:
                    r2 = r33;
                    goto L63
                L57:
                    r15 = r32;
                    goto L59
                L53:
                    r14 = r31;
                    goto L55
                L49:
                    r13 = r30;
                    goto L51
                L45:
                    r12 = r29;
                    goto L47
                L41:
                    r11 = r28;
                    goto L43
                L37:
                    r10 = r27;
                    goto L39
                L33:
                    r9 = r26;
                    goto L35
                L29:
                    r8 = r25;
                    goto L31
                L25:
                    r7 = r24;
                    goto L27
                L21:
                    r6 = r23;
                    goto L23
                L17:
                    r5 = r22;
                    goto L19
                L13:
                    r4 = r21;
                    goto L15
                L9:
                    r3 = r20;
                    goto L11
                L5:
                    r1 = r19;
                    goto L7
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            public ProductActivity() {
                Object[] r0 = 0 == true ? 1 : 0;
                this(null, r0, 3, 0 == true ? 1 : 0);
            }

            public static /* synthetic */ ProductActivity copy$default(ProductActivity r0, Integer r1, String r2, int r3, Object r4) {
                if ((r3 & 1) == 0) goto L6;
                r1 = r0.activityType;
            L6:
                if ((r3 & 2) == 0) goto L9;
                r2 = r0.activityConfData;
            L9:
                return r0.copy(r1, r2);
            }

            public final Integer component1() {
                return this.activityType;
            }

            public final String component2() {
                return this.activityConfData;
            }

            public final ProductActivity copy(Integer r2, String r3) {
                return new ProductActivity(r2, r3);
            }

            public boolean equals(Object r3) {
                if (this != r3) goto L4;
                return true;
            L4:
                if ((r3 instanceof ProductActivity) == false) goto L10;
                ProductActivity r4 = (ProductActivity) r3;
                if (Intrinsics.areEqual(this.activityType, r4.activityType) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.activityConfData, r4.activityConfData) == true) goto L16;
                return false;
            L16:
                return true;
            L10:
                return false;
            }

            public int hashCode() {
                Integer r0 = this.activityType;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = r0.hashCode();
            L6:
                int r3 = r2 * 31;
                String r4 = this.activityConfData;
                if (r4 == null) goto L10;
                r1 = r4.hashCode();
            L10:
                return r3 + r1;
            L5:
                r2 = 0;
                goto L6
            }

            public String toString() {
                return "ProductActivity(activityType=" + this.activityType + ", activityConfData=" + this.activityConfData + ")";
            }

            public final String getActivityConfData() {
                return this.activityConfData;
            }

            public final Integer getActivityType() {
                return this.activityType;
            }

            public ProductActivity(Integer r1, String r2) {
                this.activityType = r1;
                this.activityConfData = r2;
            }

            public /* synthetic */ ProductActivity(Integer r2, String r3, int r4, DefaultConstructorMarker r5) {
                if ((r4 & 1) == 0) goto L6;
                r2 = null;
            L6:
                if ((r4 & 2) == 0) goto L8;
                r3 = null;
            L8:
                this(r2, r3);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000bJF\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$ProductIcon;", "", "uri", "", "urlList", "", "width", "", "height", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getHeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUri", "()Ljava/lang/String;", "getUrlList", "()Ljava/util/List;", "getWidth", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$ProductIcon;", "equals", "", "other", "hashCode", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class ProductIcon {

            @SerializedName("height")
            private final Integer height;

            @SerializedName("uri")
            private final String uri;

            @SerializedName("url_list")
            private final List<String> urlList;

            @SerializedName("width")
            private final Integer width;

            public ProductIcon() {
                this(null, null, null, null, 15, null);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ ProductIcon copy$default(ProductIcon r0, String r1, List r2, Integer r3, Integer r4, int r5, Object r6) {
                if ((r5 & 1) == 0) goto L6;
                r1 = r0.uri;
            L6:
                if ((r5 & 2) == 0) goto L9;
                r2 = r0.urlList;
            L9:
                if ((r5 & 4) == 0) goto L12;
                r3 = r0.width;
            L12:
                if ((r5 & 8) == 0) goto L15;
                r4 = r0.height;
            L15:
                return r0.copy(r1, r2, r3, r4);
            }

            public final String component1() {
                return this.uri;
            }

            public final List<String> component2() {
                return this.urlList;
            }

            public final Integer component3() {
                return this.width;
            }

            public final Integer component4() {
                return this.height;
            }

            public final ProductIcon copy(String r2, List<String> r3, Integer r4, Integer r5) {
                return new ProductIcon(r2, r3, r4, r5);
            }

            public boolean equals(Object r3) {
                if (this != r3) goto L4;
                return true;
            L4:
                if ((r3 instanceof ProductIcon) == false) goto L14;
                ProductIcon r4 = (ProductIcon) r3;
                if (Intrinsics.areEqual(this.uri, r4.uri) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.urlList, r4.urlList) == true) goto L10;
                return false;
            L10:
                if (Intrinsics.areEqual(this.width, r4.width) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.height, r4.height) == true) goto L22;
                return false;
            L22:
                return true;
            L14:
                return false;
            }

            public int hashCode() {
                String r0 = this.uri;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = r0.hashCode();
            L6:
                int r3 = r2 * 31;
                List<String> r4 = this.urlList;
                if (r4 == null) goto L9;
                int r5 = r4.hashCode();
            L10:
                int r6 = (r3 + r5) * 31;
                Integer r7 = this.width;
                if (r7 == null) goto L13;
                int r8 = r7.hashCode();
            L14:
                int r9 = (r6 + r8) * 31;
                Integer r10 = this.height;
                if (r10 == null) goto L18;
                r1 = r10.hashCode();
            L18:
                return r9 + r1;
            L13:
                r8 = 0;
                goto L14
            L9:
                r5 = 0;
                goto L10
            L5:
                r2 = 0;
                goto L6
            }

            public String toString() {
                return "ProductIcon(uri=" + this.uri + ", urlList=" + this.urlList + ", width=" + this.width + ", height=" + this.height + ")";
            }

            public final Integer getHeight() {
                return this.height;
            }

            public final String getUri() {
                return this.uri;
            }

            public final List<String> getUrlList() {
                return this.urlList;
            }

            public final Integer getWidth() {
                return this.width;
            }

            public ProductIcon(String r1, List<String> r2, Integer r3, Integer r4) {
                this.uri = r1;
                this.urlList = r2;
                this.width = r3;
                this.height = r4;
            }

            public /* synthetic */ ProductIcon(String r2, List r3, Integer r4, Integer r5, int r6, DefaultConstructorMarker r7) {
                if ((r6 & 1) == 0) goto L6;
                r2 = null;
            L6:
                if ((r6 & 2) == 0) goto L9;
                r3 = null;
            L9:
                if ((r6 & 4) == 0) goto L12;
                r4 = null;
            L12:
                if ((r6 & 8) == 0) goto L14;
                r5 = null;
            L14:
                this(r2, r3, r4, r5);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001:\u0001'BY\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\fJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003Jb\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010$\u001a\u00020\u0005J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\t\u0010&\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000e¨\u0006("}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$RecReason;", "", "type", "", "content", "", "cover", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$RecReason$Cover;", "rankId", "typeName", "sellingPointsInfo", "link", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$RecReason$Cover;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "getCover", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$RecReason$Cover;", "getLink", "getRankId", "getSellingPointsInfo", "getType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTypeName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$RecReason$Cover;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$RecReason;", "equals", "", "other", "getReasonTypeString", "hashCode", "toString", "Cover", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class RecReason {

            @SerializedName("content")
            private final String content;

            @SerializedName("cover")
            private final Cover cover;

            @SerializedName("link")
            private final String link;

            @SerializedName("rank_id")
            private final String rankId;

            @SerializedName("selling_points_info")
            private final String sellingPointsInfo;

            @SerializedName("type")
            private final Integer type;

            @SerializedName("type_name")
            private final String typeName;

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000bJF\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$RecReason$Cover;", "", "uri", "", "urlList", "", "width", "", "height", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getHeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUri", "()Ljava/lang/String;", "getUrlList", "()Ljava/util/List;", "getWidth", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$RecReason$Cover;", "equals", "", "other", "hashCode", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
            public static final class Cover {

                @SerializedName("height")
                private final Integer height;

                @SerializedName("uri")
                private final String uri;

                @SerializedName("url_list")
                private final List<String> urlList;

                @SerializedName("width")
                private final Integer width;

                public Cover() {
                    this(null, null, null, null, 15, null);
                }

                /* JADX WARN: Multi-variable type inference failed */
                public static /* synthetic */ Cover copy$default(Cover r0, String r1, List r2, Integer r3, Integer r4, int r5, Object r6) {
                    if ((r5 & 1) == 0) goto L6;
                    r1 = r0.uri;
                L6:
                    if ((r5 & 2) == 0) goto L9;
                    r2 = r0.urlList;
                L9:
                    if ((r5 & 4) == 0) goto L12;
                    r3 = r0.width;
                L12:
                    if ((r5 & 8) == 0) goto L15;
                    r4 = r0.height;
                L15:
                    return r0.copy(r1, r2, r3, r4);
                }

                public final String component1() {
                    return this.uri;
                }

                public final List<String> component2() {
                    return this.urlList;
                }

                public final Integer component3() {
                    return this.width;
                }

                public final Integer component4() {
                    return this.height;
                }

                public final Cover copy(String r2, List<String> r3, Integer r4, Integer r5) {
                    return new Cover(r2, r3, r4, r5);
                }

                public boolean equals(Object r3) {
                    if (this != r3) goto L4;
                    return true;
                L4:
                    if ((r3 instanceof Cover) == false) goto L14;
                    Cover r4 = (Cover) r3;
                    if (Intrinsics.areEqual(this.uri, r4.uri) == true) goto L8;
                    return false;
                L8:
                    if (Intrinsics.areEqual(this.urlList, r4.urlList) == true) goto L10;
                    return false;
                L10:
                    if (Intrinsics.areEqual(this.width, r4.width) == true) goto L12;
                    return false;
                L12:
                    if (Intrinsics.areEqual(this.height, r4.height) == true) goto L22;
                    return false;
                L22:
                    return true;
                L14:
                    return false;
                }

                public int hashCode() {
                    String r0 = this.uri;
                    int r1 = 0;
                    if (r0 == null) goto L5;
                    int r2 = r0.hashCode();
                L6:
                    int r3 = r2 * 31;
                    List<String> r4 = this.urlList;
                    if (r4 == null) goto L9;
                    int r5 = r4.hashCode();
                L10:
                    int r6 = (r3 + r5) * 31;
                    Integer r7 = this.width;
                    if (r7 == null) goto L13;
                    int r8 = r7.hashCode();
                L14:
                    int r9 = (r6 + r8) * 31;
                    Integer r10 = this.height;
                    if (r10 == null) goto L18;
                    r1 = r10.hashCode();
                L18:
                    return r9 + r1;
                L13:
                    r8 = 0;
                    goto L14
                L9:
                    r5 = 0;
                    goto L10
                L5:
                    r2 = 0;
                    goto L6
                }

                public String toString() {
                    return "Cover(uri=" + this.uri + ", urlList=" + this.urlList + ", width=" + this.width + ", height=" + this.height + ")";
                }

                public final Integer getHeight() {
                    return this.height;
                }

                public final String getUri() {
                    return this.uri;
                }

                public final List<String> getUrlList() {
                    return this.urlList;
                }

                public final Integer getWidth() {
                    return this.width;
                }

                public Cover(String r1, List<String> r2, Integer r3, Integer r4) {
                    this.uri = r1;
                    this.urlList = r2;
                    this.width = r3;
                    this.height = r4;
                }

                public /* synthetic */ Cover(String r2, List r3, Integer r4, Integer r5, int r6, DefaultConstructorMarker r7) {
                    if ((r6 & 1) == 0) goto L6;
                    r2 = null;
                L6:
                    if ((r6 & 2) == 0) goto L9;
                    r3 = null;
                L9:
                    if ((r6 & 4) == 0) goto L12;
                    r4 = null;
                L12:
                    if ((r6 & 8) == 0) goto L14;
                    r5 = null;
                L14:
                    this(r2, r3, r4, r5);
                }
            }

            public RecReason() {
                this(null, null, null, null, null, null, null, 127, null);
            }

            public static /* synthetic */ RecReason copy$default(RecReason r5, Integer r6, String r7, Cover r8, String r9, String r10, String r11, String r12, int r13, Object r14) {
                if ((r13 & 1) == 0) goto L6;
                r6 = r5.type;
            L6:
                if ((r13 & 2) == 0) goto L8;
                r7 = r5.content;
            L8:
                String r15 = r7;
                if ((r13 & 4) == 0) goto L11;
                r8 = r5.cover;
            L11:
                Cover r0 = r8;
                if ((r13 & 8) == 0) goto L14;
                r9 = r5.rankId;
            L14:
                String r1 = r9;
                if ((r13 & 16) == 0) goto L17;
                r10 = r5.typeName;
            L17:
                String r2 = r10;
                if ((r13 & 32) == 0) goto L20;
                r11 = r5.sellingPointsInfo;
            L20:
                String r3 = r11;
                if ((r13 & 64) == 0) goto L23;
                r12 = r5.link;
            L23:
                Integer r16 = r6;
                return r5.copy(r16, r15, r0, r1, r2, r3, r12);
            }

            public final Integer component1() {
                return this.type;
            }

            public final String component2() {
                return this.content;
            }

            public final Cover component3() {
                return this.cover;
            }

            public final String component4() {
                return this.rankId;
            }

            public final String component5() {
                return this.typeName;
            }

            public final String component6() {
                return this.sellingPointsInfo;
            }

            public final String component7() {
                return this.link;
            }

            public final RecReason copy(Integer r10, String r11, Cover r12, String r13, String r14, String r15, String r16) {
                return new RecReason(r10, r11, r12, r13, r14, r15, r16);
            }

            public boolean equals(Object r3) {
                if (this != r3) goto L4;
                return true;
            L4:
                if ((r3 instanceof RecReason) == false) goto L20;
                RecReason r4 = (RecReason) r3;
                if (Intrinsics.areEqual(this.type, r4.type) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.content, r4.content) == true) goto L10;
                return false;
            L10:
                if (Intrinsics.areEqual(this.cover, r4.cover) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.rankId, r4.rankId) == true) goto L14;
                return false;
            L14:
                if (Intrinsics.areEqual(this.typeName, r4.typeName) == true) goto L16;
                return false;
            L16:
                if (Intrinsics.areEqual(this.sellingPointsInfo, r4.sellingPointsInfo) == true) goto L18;
                return false;
            L18:
                if (Intrinsics.areEqual(this.link, r4.link) == true) goto L31;
                return false;
            L31:
                return true;
            L20:
                return false;
            }

            public int hashCode() {
                Integer r0 = this.type;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = r0.hashCode();
            L6:
                int r3 = r2 * 31;
                String r4 = this.content;
                if (r4 == null) goto L9;
                int r5 = r4.hashCode();
            L10:
                int r6 = (r3 + r5) * 31;
                Cover r7 = this.cover;
                if (r7 == null) goto L13;
                int r8 = r7.hashCode();
            L14:
                int r9 = (r6 + r8) * 31;
                String r10 = this.rankId;
                if (r10 == null) goto L17;
                int r11 = r10.hashCode();
            L18:
                int r12 = (r9 + r11) * 31;
                String r13 = this.typeName;
                if (r13 == null) goto L21;
                int r14 = r13.hashCode();
            L22:
                int r15 = (r12 + r14) * 31;
                String r16 = this.sellingPointsInfo;
                if (r16 == null) goto L25;
                int r17 = r16.hashCode();
            L26:
                int r18 = (r15 + r17) * 31;
                String r19 = this.link;
                if (r19 == null) goto L30;
                r1 = r19.hashCode();
            L30:
                return r18 + r1;
            L25:
                r17 = 0;
                goto L26
            L21:
                r14 = 0;
                goto L22
            L17:
                r11 = 0;
                goto L18
            L13:
                r8 = 0;
                goto L14
            L9:
                r5 = 0;
                goto L10
            L5:
                r2 = 0;
                goto L6
            }

            public String toString() {
                return "RecReason(type=" + this.type + ", content=" + this.content + ", cover=" + this.cover + ", rankId=" + this.rankId + ", typeName=" + this.typeName + ", sellingPointsInfo=" + this.sellingPointsInfo + ", link=" + this.link + ")";
            }

            public final String getReasonTypeString() {
                Integer r0 = this.type;
                if (r0 != null) goto L6;
            L8:
                if (r0 != null) goto L11;
            L13:
                if (r0 != null) goto L16;
            L18:
                if (r0 != null) goto L21;
            L23:
                return "";
            L21:
                if (r0.intValue() != 4) goto L23;
                return "product_ranking";
            L16:
                if (r0.intValue() != 2) goto L18;
                return "good_comment_rate";
            L11:
                if (r0.intValue() != 1) goto L13;
                return "history";
            L6:
                if (r0.intValue() != 3) goto L8;
                return "follow_recommend";
            }

            public final String getContent() {
                return this.content;
            }

            public final Cover getCover() {
                return this.cover;
            }

            public final String getLink() {
                return this.link;
            }

            public final String getRankId() {
                return this.rankId;
            }

            public final String getSellingPointsInfo() {
                return this.sellingPointsInfo;
            }

            public final Integer getType() {
                return this.type;
            }

            public final String getTypeName() {
                return this.typeName;
            }

            public RecReason(Integer r1, String r2, Cover r3, String r4, String r5, String r6, String r7) {
                this.type = r1;
                this.content = r2;
                this.cover = r3;
                this.rankId = r4;
                this.typeName = r5;
                this.sellingPointsInfo = r6;
                this.link = r7;
            }

            public /* synthetic */ RecReason(Integer r7, String r8, Cover r9, String r10, String r11, String r12, String r13, int r14, DefaultConstructorMarker r15) {
                if ((r14 & 1) == 0) goto L5;
                Integer r16 = null;
            L7:
                if ((r14 & 2) == 0) goto L9;
                String r1 = null;
            L11:
                if ((r14 & 4) == 0) goto L13;
                Cover r2 = null;
            L15:
                if ((r14 & 8) == 0) goto L17;
                String r3 = null;
            L19:
                if ((r14 & 16) == 0) goto L21;
                String r4 = null;
            L23:
                if ((r14 & 32) == 0) goto L25;
                String r5 = null;
            L27:
                if ((r14 & 64) == 0) goto L29;
                String r17 = null;
            L30:
                this(r16, r1, r2, r3, r4, r5, r17);
                return;
            L29:
                r17 = r13;
                goto L30
            L25:
                r5 = r12;
                goto L27
            L21:
                r4 = r11;
                goto L23
            L17:
                r3 = r10;
                goto L19
            L13:
                r2 = r9;
                goto L15
            L9:
                r1 = r8;
                goto L11
            L5:
                r16 = r7;
                goto L7
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J2\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$ShopInfo;", "", "id", "", "name", "", "link", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLink", "()Ljava/lang/String;", "getName", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$ShopInfo;", "equals", "", "other", "hashCode", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class ShopInfo {

            @SerializedName("id")
            private final Integer id;

            @SerializedName("link")
            private final String link;

            @SerializedName("name")
            private final String name;

            public ShopInfo() {
                this(null, null, null, 7, null);
            }

            public static /* synthetic */ ShopInfo copy$default(ShopInfo r0, Integer r1, String r2, String r3, int r4, Object r5) {
                if ((r4 & 1) == 0) goto L6;
                r1 = r0.id;
            L6:
                if ((r4 & 2) == 0) goto L9;
                r2 = r0.name;
            L9:
                if ((r4 & 4) == 0) goto L12;
                r3 = r0.link;
            L12:
                return r0.copy(r1, r2, r3);
            }

            public final Integer component1() {
                return this.id;
            }

            public final String component2() {
                return this.name;
            }

            public final String component3() {
                return this.link;
            }

            public final ShopInfo copy(Integer r2, String r3, String r4) {
                return new ShopInfo(r2, r3, r4);
            }

            public boolean equals(Object r3) {
                if (this != r3) goto L4;
                return true;
            L4:
                if ((r3 instanceof ShopInfo) == false) goto L12;
                ShopInfo r4 = (ShopInfo) r3;
                if (Intrinsics.areEqual(this.id, r4.id) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.name, r4.name) == true) goto L10;
                return false;
            L10:
                if (Intrinsics.areEqual(this.link, r4.link) == true) goto L19;
                return false;
            L19:
                return true;
            L12:
                return false;
            }

            public int hashCode() {
                Integer r0 = this.id;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = r0.hashCode();
            L6:
                int r3 = r2 * 31;
                String r4 = this.name;
                if (r4 == null) goto L9;
                int r5 = r4.hashCode();
            L10:
                int r6 = (r3 + r5) * 31;
                String r7 = this.link;
                if (r7 == null) goto L14;
                r1 = r7.hashCode();
            L14:
                return r6 + r1;
            L9:
                r5 = 0;
                goto L10
            L5:
                r2 = 0;
                goto L6
            }

            public String toString() {
                return "ShopInfo(id=" + this.id + ", name=" + this.name + ", link=" + this.link + ")";
            }

            public final Integer getId() {
                return this.id;
            }

            public final String getLink() {
                return this.link;
            }

            public final String getName() {
                return this.name;
            }

            public ShopInfo(Integer r1, String r2, String r3) {
                this.id = r1;
                this.name = r2;
                this.link = r3;
            }

            public /* synthetic */ ShopInfo(Integer r2, String r3, String r4, int r5, DefaultConstructorMarker r6) {
                if ((r5 & 1) == 0) goto L6;
                r2 = null;
            L6:
                if ((r5 & 2) == 0) goto L9;
                r3 = null;
            L9:
                if ((r5 & 4) == 0) goto L11;
                r4 = null;
            L11:
                this(r2, r3, r4);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J2\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$TagItem;", "", "type", "", "content", "", "extra", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "getExtra", "getType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$TagItem;", "equals", "", "other", "hashCode", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class TagItem {

            @SerializedName("content")
            private final String content;

            @SerializedName("extra")
            private final String extra;

            @SerializedName("type")
            private final Integer type;

            public TagItem() {
                this(null, null, null, 7, null);
            }

            public static /* synthetic */ TagItem copy$default(TagItem r0, Integer r1, String r2, String r3, int r4, Object r5) {
                if ((r4 & 1) == 0) goto L6;
                r1 = r0.type;
            L6:
                if ((r4 & 2) == 0) goto L9;
                r2 = r0.content;
            L9:
                if ((r4 & 4) == 0) goto L12;
                r3 = r0.extra;
            L12:
                return r0.copy(r1, r2, r3);
            }

            public final Integer component1() {
                return this.type;
            }

            public final String component2() {
                return this.content;
            }

            public final String component3() {
                return this.extra;
            }

            public final TagItem copy(Integer r2, String r3, String r4) {
                return new TagItem(r2, r3, r4);
            }

            public boolean equals(Object r3) {
                if (this != r3) goto L4;
                return true;
            L4:
                if ((r3 instanceof TagItem) == false) goto L12;
                TagItem r4 = (TagItem) r3;
                if (Intrinsics.areEqual(this.type, r4.type) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.content, r4.content) == true) goto L10;
                return false;
            L10:
                if (Intrinsics.areEqual(this.extra, r4.extra) == true) goto L19;
                return false;
            L19:
                return true;
            L12:
                return false;
            }

            public int hashCode() {
                Integer r0 = this.type;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = r0.hashCode();
            L6:
                int r3 = r2 * 31;
                String r4 = this.content;
                if (r4 == null) goto L9;
                int r5 = r4.hashCode();
            L10:
                int r6 = (r3 + r5) * 31;
                String r7 = this.extra;
                if (r7 == null) goto L14;
                r1 = r7.hashCode();
            L14:
                return r6 + r1;
            L9:
                r5 = 0;
                goto L10
            L5:
                r2 = 0;
                goto L6
            }

            public String toString() {
                return "TagItem(type=" + this.type + ", content=" + this.content + ", extra=" + this.extra + ")";
            }

            public final String getContent() {
                return this.content;
            }

            public final String getExtra() {
                return this.extra;
            }

            public final Integer getType() {
                return this.type;
            }

            public TagItem(Integer r1, String r2, String r3) {
                this.type = r1;
                this.content = r2;
                this.extra = r3;
            }

            public /* synthetic */ TagItem(Integer r2, String r3, String r4, int r5, DefaultConstructorMarker r6) {
                if ((r5 & 1) == 0) goto L6;
                r2 = null;
            L6:
                if ((r5 & 2) == 0) goto L9;
                r3 = null;
            L9:
                if ((r5 & 4) == 0) goto L11;
                r4 = null;
            L11:
                this(r2, r3, r4);
            }
        }

        public Product() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 67108863, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Product copy$default(Product r17, String r18, UrlStruct r19, String r20, Integer r21, List r22, Price r23, String r24, String r25, String r26, Integer r27, String r28, ProductActivity r29, RecReason r30, Integer r31, ProductIcon r32, String r33, Extra r34, Integer r35, Integer r36, UrlStruct r37, UrlStruct r38, MarketingFloors r39, List r40, ShopInfo r41, String r42, DecorationParam r43, int r44, Object r45) {
            if ((r44 & 1) == 0) goto L5;
            String r2 = r17.productId;
        L7:
            if ((r44 & 2) == 0) goto L9;
            UrlStruct r3 = r17.cover;
        L11:
            if ((r44 & 4) == 0) goto L13;
            String r4 = r17.title;
        L15:
            if ((r44 & 8) == 0) goto L17;
            Integer r5 = r17.sales;
        L19:
            if ((r44 & 16) == 0) goto L21;
            List r6 = r17.tags;
        L23:
            if ((r44 & 32) == 0) goto L25;
            Price r7 = r17.price;
        L27:
            if ((r44 & 64) == 0) goto L29;
            String r8 = r17.kolId;
        L31:
            if ((r44 & 128) == 0) goto L33;
            String r9 = r17.secKolId;
        L35:
            if ((r44 & 256) == 0) goto L37;
            String r10 = r17.promotionId;
        L39:
            if ((r44 & 512) == 0) goto L41;
            Integer r11 = r17.commodityType;
        L43:
            if ((r44 & 1024) == 0) goto L45;
            String r12 = r17.recommendInfo;
        L47:
            if ((r44 & 2048) == 0) goto L49;
            ProductActivity r13 = r17.productActivity;
        L51:
            if ((r44 & 4096) == 0) goto L53;
            RecReason r14 = r17.recReason;
        L55:
            if ((r44 & 8192) == 0) goto L57;
            Integer r15 = r17.bizKind;
        L58:
            Integer r310 = r15;
            if ((r44 & 16384) == 0) goto L61;
            ProductIcon r16 = r17.productIcon;
        L62:
            ProductIcon r311 = r16;
            if ((r44 & 32768) == 0) goto L65;
            String r110 = r17.iconName;
        L66:
            String r312 = r110;
            if ((r44 & 65536) == 0) goto L69;
            Extra r111 = r17.extra;
        L70:
            Extra r313 = r111;
            if ((r44 & 131072) == 0) goto L73;
            Integer r112 = r17.campaginSales;
        L74:
            Integer r314 = r112;
            if ((r44 & 262144) == 0) goto L77;
            Integer r113 = r17.campaginStock;
        L78:
            Integer r315 = r113;
            if ((r44 & 524288) == 0) goto L81;
            UrlStruct r114 = r17.coverLong;
        L82:
            UrlStruct r316 = r114;
            if ((r44 & 1048576) == 0) goto L85;
            UrlStruct r115 = r17.coverRecommend;
        L86:
            UrlStruct r317 = r115;
            if ((r44 & 2097152) == 0) goto L89;
            MarketingFloors r116 = r17.platformTextActivity;
        L90:
            MarketingFloors r318 = r116;
            if ((r44 & 4194304) == 0) goto L93;
            List r117 = r17.coupons;
        L94:
            List r46 = r117;
            if ((r44 & 8388608) == 0) goto L97;
            ShopInfo r118 = r17.shopInfo;
        L98:
            ShopInfo r47 = r118;
            if ((r44 & 16777216) == 0) goto L101;
            String r119 = r17.link;
        L103:
            if ((r44 & 33554432) == 0) goto L105;
            DecorationParam r1 = r17.decorationParam;
        L107:
            return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r310, r311, r312, r313, r314, r315, r316, r317, r318, r46, r47, r119, r1);
        L105:
            r1 = r43;
            goto L107
        L101:
            r119 = r42;
            goto L103
        L97:
            r118 = r41;
            goto L98
        L93:
            r117 = r40;
            goto L94
        L89:
            r116 = r39;
            goto L90
        L85:
            r115 = r38;
            goto L86
        L81:
            r114 = r37;
            goto L82
        L77:
            r113 = r36;
            goto L78
        L73:
            r112 = r35;
            goto L74
        L69:
            r111 = r34;
            goto L70
        L65:
            r110 = r33;
            goto L66
        L61:
            r16 = r32;
            goto L62
        L57:
            r15 = r31;
            goto L58
        L53:
            r14 = r30;
            goto L55
        L49:
            r13 = r29;
            goto L51
        L45:
            r12 = r28;
            goto L47
        L41:
            r11 = r27;
            goto L43
        L37:
            r10 = r26;
            goto L39
        L33:
            r9 = r25;
            goto L35
        L29:
            r8 = r24;
            goto L31
        L25:
            r7 = r23;
            goto L27
        L21:
            r6 = r22;
            goto L23
        L17:
            r5 = r21;
            goto L19
        L13:
            r4 = r20;
            goto L15
        L9:
            r3 = r19;
            goto L11
        L5:
            r2 = r18;
            goto L7
        }

        public final String component1() {
            return this.productId;
        }

        public final Integer component10() {
            return this.commodityType;
        }

        public final String component11() {
            return this.recommendInfo;
        }

        public final ProductActivity component12() {
            return this.productActivity;
        }

        public final RecReason component13() {
            return this.recReason;
        }

        public final Integer component14() {
            return this.bizKind;
        }

        public final ProductIcon component15() {
            return this.productIcon;
        }

        public final String component16() {
            return this.iconName;
        }

        public final Extra component17() {
            return this.extra;
        }

        public final Integer component18() {
            return this.campaginSales;
        }

        public final Integer component19() {
            return this.campaginStock;
        }

        public final UrlStruct component2() {
            return this.cover;
        }

        public final UrlStruct component20() {
            return this.coverLong;
        }

        public final UrlStruct component21() {
            return this.coverRecommend;
        }

        public final MarketingFloors component22() {
            return this.platformTextActivity;
        }

        public final List<Object> component23() {
            return this.coupons;
        }

        public final ShopInfo component24() {
            return this.shopInfo;
        }

        public final String component25() {
            return this.link;
        }

        public final DecorationParam component26() {
            return this.decorationParam;
        }

        public final String component3() {
            return this.title;
        }

        public final Integer component4() {
            return this.sales;
        }

        public final List<TagItem> component5() {
            return this.tags;
        }

        public final Price component6() {
            return this.price;
        }

        public final String component7() {
            return this.kolId;
        }

        public final String component8() {
            return this.secKolId;
        }

        public final String component9() {
            return this.promotionId;
        }

        public final Product copy(String r29, UrlStruct r30, String r31, Integer r32, List<TagItem> r33, Price r34, String r35, String r36, String r37, Integer r38, String r39, ProductActivity r40, RecReason r41, Integer r42, ProductIcon r43, String r44, Extra r45, Integer r46, Integer r47, UrlStruct r48, UrlStruct r49, MarketingFloors r50, List<? extends Object> r51, ShopInfo r52, String r53, DecorationParam r54) {
            return new Product(r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof Product) == false) goto L58;
            Product r4 = (Product) r3;
            if (Intrinsics.areEqual(this.productId, r4.productId) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.cover, r4.cover) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.title, r4.title) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.sales, r4.sales) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.tags, r4.tags) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.price, r4.price) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.kolId, r4.kolId) == true) goto L20;
            return false;
        L20:
            if (Intrinsics.areEqual(this.secKolId, r4.secKolId) == true) goto L22;
            return false;
        L22:
            if (Intrinsics.areEqual(this.promotionId, r4.promotionId) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.commodityType, r4.commodityType) == true) goto L26;
            return false;
        L26:
            if (Intrinsics.areEqual(this.recommendInfo, r4.recommendInfo) == true) goto L28;
            return false;
        L28:
            if (Intrinsics.areEqual(this.productActivity, r4.productActivity) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.recReason, r4.recReason) == true) goto L32;
            return false;
        L32:
            if (Intrinsics.areEqual(this.bizKind, r4.bizKind) == true) goto L34;
            return false;
        L34:
            if (Intrinsics.areEqual(this.productIcon, r4.productIcon) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.iconName, r4.iconName) == true) goto L38;
            return false;
        L38:
            if (Intrinsics.areEqual(this.extra, r4.extra) == true) goto L40;
            return false;
        L40:
            if (Intrinsics.areEqual(this.campaginSales, r4.campaginSales) == true) goto L42;
            return false;
        L42:
            if (Intrinsics.areEqual(this.campaginStock, r4.campaginStock) == true) goto L44;
            return false;
        L44:
            if (Intrinsics.areEqual(this.coverLong, r4.coverLong) == true) goto L46;
            return false;
        L46:
            if (Intrinsics.areEqual(this.coverRecommend, r4.coverRecommend) == true) goto L48;
            return false;
        L48:
            if (Intrinsics.areEqual(this.platformTextActivity, r4.platformTextActivity) == true) goto L50;
            return false;
        L50:
            if (Intrinsics.areEqual(this.coupons, r4.coupons) == true) goto L52;
            return false;
        L52:
            if (Intrinsics.areEqual(this.shopInfo, r4.shopInfo) == true) goto L54;
            return false;
        L54:
            if (Intrinsics.areEqual(this.link, r4.link) == true) goto L56;
            return false;
        L56:
            if (Intrinsics.areEqual(this.decorationParam, r4.decorationParam) == true) goto L88;
            return false;
        L88:
            return true;
        L58:
            return false;
        }

        public int hashCode() {
            String r0 = this.productId;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            UrlStruct r4 = this.cover;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.title;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            Integer r10 = this.sales;
            if (r10 == null) goto L17;
            int r11 = r10.hashCode();
        L18:
            int r12 = (r9 + r11) * 31;
            List<TagItem> r13 = this.tags;
            if (r13 == null) goto L21;
            int r14 = r13.hashCode();
        L22:
            int r15 = (r12 + r14) * 31;
            Price r16 = this.price;
            if (r16 == null) goto L25;
            int r17 = r16.hashCode();
        L26:
            int r18 = (r15 + r17) * 31;
            String r19 = this.kolId;
            if (r19 == null) goto L29;
            int r20 = r19.hashCode();
        L30:
            int r21 = (r18 + r20) * 31;
            String r22 = this.secKolId;
            if (r22 == null) goto L33;
            int r23 = r22.hashCode();
        L34:
            int r24 = (r21 + r23) * 31;
            String r25 = this.promotionId;
            if (r25 == null) goto L37;
            int r26 = r25.hashCode();
        L38:
            int r27 = (r24 + r26) * 31;
            Integer r28 = this.commodityType;
            if (r28 == null) goto L41;
            int r29 = r28.hashCode();
        L42:
            int r30 = (r27 + r29) * 31;
            String r31 = this.recommendInfo;
            if (r31 == null) goto L45;
            int r32 = r31.hashCode();
        L46:
            int r33 = (r30 + r32) * 31;
            ProductActivity r34 = this.productActivity;
            if (r34 == null) goto L49;
            int r35 = r34.hashCode();
        L50:
            int r36 = (r33 + r35) * 31;
            RecReason r37 = this.recReason;
            if (r37 == null) goto L53;
            int r38 = r37.hashCode();
        L54:
            int r39 = (r36 + r38) * 31;
            Integer r40 = this.bizKind;
            if (r40 == null) goto L57;
            int r41 = r40.hashCode();
        L58:
            int r42 = (r39 + r41) * 31;
            ProductIcon r43 = this.productIcon;
            if (r43 == null) goto L61;
            int r44 = r43.hashCode();
        L62:
            int r45 = (r42 + r44) * 31;
            String r46 = this.iconName;
            if (r46 == null) goto L65;
            int r47 = r46.hashCode();
        L66:
            int r48 = (r45 + r47) * 31;
            Extra r49 = this.extra;
            if (r49 == null) goto L69;
            int r50 = r49.hashCode();
        L70:
            int r51 = (r48 + r50) * 31;
            Integer r52 = this.campaginSales;
            if (r52 == null) goto L73;
            int r53 = r52.hashCode();
        L74:
            int r54 = (r51 + r53) * 31;
            Integer r55 = this.campaginStock;
            if (r55 == null) goto L77;
            int r56 = r55.hashCode();
        L78:
            int r57 = (r54 + r56) * 31;
            UrlStruct r58 = this.coverLong;
            if (r58 == null) goto L81;
            int r59 = r58.hashCode();
        L82:
            int r60 = (r57 + r59) * 31;
            UrlStruct r61 = this.coverRecommend;
            if (r61 == null) goto L85;
            int r62 = r61.hashCode();
        L86:
            int r63 = (r60 + r62) * 31;
            MarketingFloors r64 = this.platformTextActivity;
            if (r64 == null) goto L89;
            int r65 = r64.hashCode();
        L90:
            int r66 = (r63 + r65) * 31;
            List<Object> r67 = this.coupons;
            if (r67 == null) goto L93;
            int r68 = r67.hashCode();
        L94:
            int r69 = (r66 + r68) * 31;
            ShopInfo r70 = this.shopInfo;
            if (r70 == null) goto L97;
            int r71 = r70.hashCode();
        L98:
            int r72 = (r69 + r71) * 31;
            String r73 = this.link;
            if (r73 == null) goto L101;
            int r74 = r73.hashCode();
        L102:
            int r75 = (r72 + r74) * 31;
            DecorationParam r76 = this.decorationParam;
            if (r76 == null) goto L106;
            r1 = r76.hashCode();
        L106:
            return r75 + r1;
        L101:
            r74 = 0;
            goto L102
        L97:
            r71 = 0;
            goto L98
        L93:
            r68 = 0;
            goto L94
        L89:
            r65 = 0;
            goto L90
        L85:
            r62 = 0;
            goto L86
        L81:
            r59 = 0;
            goto L82
        L77:
            r56 = 0;
            goto L78
        L73:
            r53 = 0;
            goto L74
        L69:
            r50 = 0;
            goto L70
        L65:
            r47 = 0;
            goto L66
        L61:
            r44 = 0;
            goto L62
        L57:
            r41 = 0;
            goto L58
        L53:
            r38 = 0;
            goto L54
        L49:
            r35 = 0;
            goto L50
        L45:
            r32 = 0;
            goto L46
        L41:
            r29 = 0;
            goto L42
        L37:
            r26 = 0;
            goto L38
        L33:
            r23 = 0;
            goto L34
        L29:
            r20 = 0;
            goto L30
        L25:
            r17 = 0;
            goto L26
        L21:
            r14 = 0;
            goto L22
        L17:
            r11 = 0;
            goto L18
        L13:
            r8 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public String toString() {
            return "Product(productId=" + this.productId + ", cover=" + this.cover + ", title=" + this.title + ", sales=" + this.sales + ", tags=" + this.tags + ", price=" + this.price + ", kolId=" + this.kolId + ", secKolId=" + this.secKolId + ", promotionId=" + this.promotionId + ", commodityType=" + this.commodityType + ", recommendInfo=" + this.recommendInfo + ", productActivity=" + this.productActivity + ", recReason=" + this.recReason + ", bizKind=" + this.bizKind + ", productIcon=" + this.productIcon + ", iconName=" + this.iconName + ", extra=" + this.extra + ", campaginSales=" + this.campaginSales + ", campaginStock=" + this.campaginStock + ", coverLong=" + this.coverLong + ", coverRecommend=" + this.coverRecommend + ", platformTextActivity=" + this.platformTextActivity + ", coupons=" + this.coupons + ", shopInfo=" + this.shopInfo + ", link=" + this.link + ", decorationParam=" + this.decorationParam + ")";
        }

        public final Integer getBizKind() {
            return this.bizKind;
        }

        public final Integer getCampaginSales() {
            return this.campaginSales;
        }

        public final Integer getCampaginStock() {
            return this.campaginStock;
        }

        public final Integer getCommodityType() {
            return this.commodityType;
        }

        public final List<Object> getCoupons() {
            return this.coupons;
        }

        public final UrlStruct getCover() {
            return this.cover;
        }

        public final UrlStruct getCoverLong() {
            return this.coverLong;
        }

        public final UrlStruct getCoverRecommend() {
            return this.coverRecommend;
        }

        public final DecorationParam getDecorationParam() {
            return this.decorationParam;
        }

        public final Extra getExtra() {
            return this.extra;
        }

        public final String getIconName() {
            return this.iconName;
        }

        public final String getKolId() {
            return this.kolId;
        }

        public final String getLink() {
            return this.link;
        }

        public final MarketingFloors getPlatformTextActivity() {
            return this.platformTextActivity;
        }

        public final Price getPrice() {
            return this.price;
        }

        public final ProductActivity getProductActivity() {
            return this.productActivity;
        }

        public final ProductIcon getProductIcon() {
            return this.productIcon;
        }

        public final String getProductId() {
            return this.productId;
        }

        public final String getPromotionId() {
            return this.promotionId;
        }

        public final RecReason getRecReason() {
            return this.recReason;
        }

        public final String getRecommendInfo() {
            return this.recommendInfo;
        }

        public final Integer getSales() {
            return this.sales;
        }

        public final String getSecKolId() {
            return this.secKolId;
        }

        public final ShopInfo getShopInfo() {
            return this.shopInfo;
        }

        public final List<TagItem> getTags() {
            return this.tags;
        }

        public final String getTitle() {
            return this.title;
        }

        public Product(String r3, UrlStruct r4, String r5, Integer r6, List<TagItem> r7, Price r8, String r9, String r10, String r11, Integer r12, String r13, ProductActivity r14, RecReason r15, Integer r16, ProductIcon r17, String r18, Extra r19, Integer r20, Integer r21, UrlStruct r22, UrlStruct r23, MarketingFloors r24, List<? extends Object> r25, ShopInfo r26, String r27, DecorationParam r28) {
            this.productId = r3;
            this.cover = r4;
            this.title = r5;
            this.sales = r6;
            this.tags = r7;
            this.price = r8;
            this.kolId = r9;
            this.secKolId = r10;
            this.promotionId = r11;
            this.commodityType = r12;
            this.recommendInfo = r13;
            this.productActivity = r14;
            this.recReason = r15;
            this.bizKind = r16;
            this.productIcon = r17;
            this.iconName = r18;
            this.extra = r19;
            this.campaginSales = r20;
            this.campaginStock = r21;
            this.coverLong = r22;
            this.coverRecommend = r23;
            this.platformTextActivity = r24;
            this.coupons = r25;
            this.shopInfo = r26;
            this.link = r27;
            this.decorationParam = r28;
        }

        public /* synthetic */ Product(String r28, UrlStruct r29, String r30, Integer r31, List r32, Price r33, String r34, String r35, String r36, Integer r37, String r38, ProductActivity r39, RecReason r40, Integer r41, ProductIcon r42, String r43, Extra r44, Integer r45, Integer r46, UrlStruct r47, UrlStruct r48, MarketingFloors r49, List r50, ShopInfo r51, String r52, DecorationParam r53, int r54, DefaultConstructorMarker r55) {
            if ((r54 & 1) == 0) goto L5;
            String r1 = null;
        L7:
            if ((r54 & 2) == 0) goto L9;
            UrlStruct r3 = null;
        L11:
            if ((r54 & 4) == 0) goto L13;
            String r4 = null;
        L15:
            if ((r54 & 8) == 0) goto L17;
            Integer r5 = null;
        L19:
            if ((r54 & 16) == 0) goto L21;
            List r6 = null;
        L23:
            if ((r54 & 32) == 0) goto L25;
            Price r7 = null;
        L27:
            if ((r54 & 64) == 0) goto L29;
            String r8 = null;
        L31:
            if ((r54 & 128) == 0) goto L33;
            String r9 = null;
        L35:
            if ((r54 & 256) == 0) goto L37;
            String r10 = null;
        L39:
            if ((r54 & 512) == 0) goto L41;
            Integer r11 = null;
        L43:
            if ((r54 & 1024) == 0) goto L45;
            String r12 = null;
        L47:
            if ((r54 & 2048) == 0) goto L49;
            ProductActivity r13 = null;
        L51:
            if ((r54 & 4096) == 0) goto L53;
            RecReason r14 = null;
        L55:
            if ((r54 & 8192) == 0) goto L57;
            Integer r15 = null;
        L59:
            if ((r54 & 16384) == 0) goto L61;
            ProductIcon r2 = null;
        L63:
            if ((r54 & 32768) == 0) goto L65;
            String r16 = null;
        L67:
            if ((r54 & 65536) == 0) goto L69;
            Extra r17 = null;
        L71:
            if ((r54 & 131072) == 0) goto L73;
            Integer r18 = null;
        L75:
            if ((r54 & 262144) == 0) goto L77;
            Integer r19 = null;
        L79:
            if ((r54 & 524288) == 0) goto L81;
            UrlStruct r20 = null;
        L83:
            if ((r54 & 1048576) == 0) goto L85;
            UrlStruct r21 = null;
        L87:
            if ((r54 & 2097152) == 0) goto L89;
            MarketingFloors r22 = null;
        L91:
            if ((r54 & 4194304) == 0) goto L93;
            List r23 = null;
        L95:
            if ((r54 & 8388608) == 0) goto L97;
            ShopInfo r24 = null;
        L99:
            if ((r54 & 16777216) == 0) goto L101;
            String r25 = null;
        L103:
            if ((r54 & 33554432) == 0) goto L105;
            DecorationParam r0 = null;
        L106:
            this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r2, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r0);
            return;
        L105:
            r0 = r53;
            goto L106
        L101:
            r25 = r52;
            goto L103
        L97:
            r24 = r51;
            goto L99
        L93:
            r23 = r50;
            goto L95
        L89:
            r22 = r49;
            goto L91
        L85:
            r21 = r48;
            goto L87
        L81:
            r20 = r47;
            goto L83
        L77:
            r19 = r46;
            goto L79
        L73:
            r18 = r45;
            goto L75
        L69:
            r17 = r44;
            goto L71
        L65:
            r16 = r43;
            goto L67
        L61:
            r2 = r42;
            goto L63
        L57:
            r15 = r41;
            goto L59
        L53:
            r14 = r40;
            goto L55
        L49:
            r13 = r39;
            goto L51
        L45:
            r12 = r38;
            goto L47
        L41:
            r11 = r37;
            goto L43
        L37:
            r10 = r36;
            goto L39
        L33:
            r9 = r35;
            goto L35
        L29:
            r8 = r34;
            goto L31
        L25:
            r7 = r33;
            goto L27
        L21:
            r6 = r32;
            goto L23
        L17:
            r5 = r31;
            goto L19
        L13:
            r4 = r30;
            goto L15
        L9:
            r3 = r29;
            goto L11
        L5:
            r1 = r28;
            goto L7
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Store;", "", "distancePoint", "", "(Ljava/lang/String;)V", "getDistancePoint", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Store {

        @SerializedName("distance_point")
        private final String distancePoint;

        public Store() {
            String r0 = null;
            this(r0, 1, r0);
        }

        public static /* synthetic */ Store copy$default(Store r0, String r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.distancePoint;
        L6:
            return r0.copy(r1);
        }

        public final String component1() {
            return this.distancePoint;
        }

        public final Store copy(String r2) {
            return new Store(r2);
        }

        public boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof Store) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.distancePoint, ((Store) r2).distancePoint) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public int hashCode() {
            String r0 = this.distancePoint;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public String toString() {
            return "Store(distancePoint=" + this.distancePoint + ")";
        }

        public final String getDistancePoint() {
            return this.distancePoint;
        }

        public Store(String r1) {
            this.distancePoint = r1;
        }

        public /* synthetic */ Store(String r1, int r2, DefaultConstructorMarker r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = null;
        L5:
            this(r1);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000bJD\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$UrlStruct;", "", "uri", "", "urlList", "", "width", "", "height", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getHeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUri", "()Ljava/lang/String;", "getUrlList", "()Ljava/util/List;", "getWidth", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$UrlStruct;", "equals", "", "other", "hashCode", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class UrlStruct {

        @SerializedName("height")
        private final Integer height;

        @SerializedName("uri")
        private final String uri;

        @SerializedName("url_list")
        private final List<String> urlList;

        @SerializedName("width")
        private final Integer width;

        public UrlStruct() {
            this(null, null, null, null, 15, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ UrlStruct copy$default(UrlStruct r0, String r1, List r2, Integer r3, Integer r4, int r5, Object r6) {
            if ((r5 & 1) == 0) goto L6;
            r1 = r0.uri;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r2 = r0.urlList;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r3 = r0.width;
        L12:
            if ((r5 & 8) == 0) goto L15;
            r4 = r0.height;
        L15:
            return r0.copy(r1, r2, r3, r4);
        }

        public final String component1() {
            return this.uri;
        }

        public final List<String> component2() {
            return this.urlList;
        }

        public final Integer component3() {
            return this.width;
        }

        public final Integer component4() {
            return this.height;
        }

        public final UrlStruct copy(String r2, List<String> r3, Integer r4, Integer r5) {
            return new UrlStruct(r2, r3, r4, r5);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof UrlStruct) == false) goto L14;
            UrlStruct r4 = (UrlStruct) r3;
            if (Intrinsics.areEqual(this.uri, r4.uri) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.urlList, r4.urlList) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.width, r4.width) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.height, r4.height) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public int hashCode() {
            String r0 = this.uri;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            List<String> r4 = this.urlList;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            Integer r7 = this.width;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            Integer r10 = this.height;
            if (r10 == null) goto L18;
            r1 = r10.hashCode();
        L18:
            return r9 + r1;
        L13:
            r8 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public String toString() {
            return "UrlStruct(uri=" + this.uri + ", urlList=" + this.urlList + ", width=" + this.width + ", height=" + this.height + ")";
        }

        public final Integer getHeight() {
            return this.height;
        }

        public final String getUri() {
            return this.uri;
        }

        public final List<String> getUrlList() {
            return this.urlList;
        }

        public final Integer getWidth() {
            return this.width;
        }

        public UrlStruct(String r1, List<String> r2, Integer r3, Integer r4) {
            this.uri = r1;
            this.urlList = r2;
            this.width = r3;
            this.height = r4;
        }

        public /* synthetic */ UrlStruct(String r2, List r3, Integer r4, Integer r5, int r6, DefaultConstructorMarker r7) {
            if ((r6 & 1) == 0) goto L6;
            r2 = null;
        L6:
            if ((r6 & 2) == 0) goto L9;
            r3 = null;
        L9:
            if ((r6 & 4) == 0) goto L12;
            r4 = null;
        L12:
            if ((r6 & 8) == 0) goto L14;
            r5 = null;
        L14:
            this(r2, r3, r4, r5);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001:\u0001$BY\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jb\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020\b2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0007\u0010\u0011R\u001a\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\t\u0010\u0011R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010¨\u0006%"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$User;", "", "id", "", "avatar", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$User$Avatar;", "nickname", "isFollowed", "", "isLive", "roomId", "secId", "(Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$User$Avatar;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V", "getAvatar", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$User$Avatar;", "getId", "()Ljava/lang/String;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getNickname", "getRoomId", "getSecId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$User$Avatar;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$User;", "equals", "other", "hashCode", "", "toString", "Avatar", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class User {

        @SerializedName("avatar")
        private final Avatar avatar;

        @SerializedName("id")
        private final String id;

        @SerializedName("is_followed")
        private final Boolean isFollowed;

        @SerializedName("is_live")
        private final Boolean isLive;

        @SerializedName("nickname")
        private final String nickname;

        @SerializedName("room_id")
        private final String roomId;

        @SerializedName("sec_id")
        private final String secId;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000bJF\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$User$Avatar;", "", "uri", "", "urlList", "", "width", "", "height", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getHeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUri", "()Ljava/lang/String;", "getUrlList", "()Ljava/util/List;", "getWidth", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$User$Avatar;", "equals", "", "other", "hashCode", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Avatar {

            @SerializedName("height")
            private final Integer height;

            @SerializedName("uri")
            private final String uri;

            @SerializedName("url_list")
            private final List<String> urlList;

            @SerializedName("width")
            private final Integer width;

            public Avatar() {
                this(null, null, null, null, 15, null);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Avatar copy$default(Avatar r0, String r1, List r2, Integer r3, Integer r4, int r5, Object r6) {
                if ((r5 & 1) == 0) goto L6;
                r1 = r0.uri;
            L6:
                if ((r5 & 2) == 0) goto L9;
                r2 = r0.urlList;
            L9:
                if ((r5 & 4) == 0) goto L12;
                r3 = r0.width;
            L12:
                if ((r5 & 8) == 0) goto L15;
                r4 = r0.height;
            L15:
                return r0.copy(r1, r2, r3, r4);
            }

            public final String component1() {
                return this.uri;
            }

            public final List<String> component2() {
                return this.urlList;
            }

            public final Integer component3() {
                return this.width;
            }

            public final Integer component4() {
                return this.height;
            }

            public final Avatar copy(String r2, List<String> r3, Integer r4, Integer r5) {
                return new Avatar(r2, r3, r4, r5);
            }

            public boolean equals(Object r3) {
                if (this != r3) goto L4;
                return true;
            L4:
                if ((r3 instanceof Avatar) == false) goto L14;
                Avatar r4 = (Avatar) r3;
                if (Intrinsics.areEqual(this.uri, r4.uri) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.urlList, r4.urlList) == true) goto L10;
                return false;
            L10:
                if (Intrinsics.areEqual(this.width, r4.width) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.height, r4.height) == true) goto L22;
                return false;
            L22:
                return true;
            L14:
                return false;
            }

            public int hashCode() {
                String r0 = this.uri;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = r0.hashCode();
            L6:
                int r3 = r2 * 31;
                List<String> r4 = this.urlList;
                if (r4 == null) goto L9;
                int r5 = r4.hashCode();
            L10:
                int r6 = (r3 + r5) * 31;
                Integer r7 = this.width;
                if (r7 == null) goto L13;
                int r8 = r7.hashCode();
            L14:
                int r9 = (r6 + r8) * 31;
                Integer r10 = this.height;
                if (r10 == null) goto L18;
                r1 = r10.hashCode();
            L18:
                return r9 + r1;
            L13:
                r8 = 0;
                goto L14
            L9:
                r5 = 0;
                goto L10
            L5:
                r2 = 0;
                goto L6
            }

            public String toString() {
                return "Avatar(uri=" + this.uri + ", urlList=" + this.urlList + ", width=" + this.width + ", height=" + this.height + ")";
            }

            public final Integer getHeight() {
                return this.height;
            }

            public final String getUri() {
                return this.uri;
            }

            public final List<String> getUrlList() {
                return this.urlList;
            }

            public final Integer getWidth() {
                return this.width;
            }

            public Avatar(String r1, List<String> r2, Integer r3, Integer r4) {
                this.uri = r1;
                this.urlList = r2;
                this.width = r3;
                this.height = r4;
            }

            public /* synthetic */ Avatar(String r2, List r3, Integer r4, Integer r5, int r6, DefaultConstructorMarker r7) {
                if ((r6 & 1) == 0) goto L6;
                r2 = null;
            L6:
                if ((r6 & 2) == 0) goto L9;
                r3 = null;
            L9:
                if ((r6 & 4) == 0) goto L12;
                r4 = null;
            L12:
                if ((r6 & 8) == 0) goto L14;
                r5 = null;
            L14:
                this(r2, r3, r4, r5);
            }
        }

        public User() {
            this(null, null, null, null, null, null, null, 127, null);
        }

        public static /* synthetic */ User copy$default(User r5, String r6, Avatar r7, String r8, Boolean r9, Boolean r10, String r11, String r12, int r13, Object r14) {
            if ((r13 & 1) == 0) goto L6;
            r6 = r5.id;
        L6:
            if ((r13 & 2) == 0) goto L8;
            r7 = r5.avatar;
        L8:
            Avatar r15 = r7;
            if ((r13 & 4) == 0) goto L11;
            r8 = r5.nickname;
        L11:
            String r0 = r8;
            if ((r13 & 8) == 0) goto L14;
            r9 = r5.isFollowed;
        L14:
            Boolean r1 = r9;
            if ((r13 & 16) == 0) goto L17;
            r10 = r5.isLive;
        L17:
            Boolean r2 = r10;
            if ((r13 & 32) == 0) goto L20;
            r11 = r5.roomId;
        L20:
            String r3 = r11;
            if ((r13 & 64) == 0) goto L23;
            r12 = r5.secId;
        L23:
            String r16 = r6;
            return r5.copy(r16, r15, r0, r1, r2, r3, r12);
        }

        public final String component1() {
            return this.id;
        }

        public final Avatar component2() {
            return this.avatar;
        }

        public final String component3() {
            return this.nickname;
        }

        public final Boolean component4() {
            return this.isFollowed;
        }

        public final Boolean component5() {
            return this.isLive;
        }

        public final String component6() {
            return this.roomId;
        }

        public final String component7() {
            return this.secId;
        }

        public final User copy(String r10, Avatar r11, String r12, Boolean r13, Boolean r14, String r15, String r16) {
            return new User(r10, r11, r12, r13, r14, r15, r16);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof User) == false) goto L20;
            User r4 = (User) r3;
            if (Intrinsics.areEqual(this.id, r4.id) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.avatar, r4.avatar) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.nickname, r4.nickname) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.isFollowed, r4.isFollowed) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.isLive, r4.isLive) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.roomId, r4.roomId) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.secId, r4.secId) == true) goto L31;
            return false;
        L31:
            return true;
        L20:
            return false;
        }

        public int hashCode() {
            String r0 = this.id;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            Avatar r4 = this.avatar;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.nickname;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            Boolean r10 = this.isFollowed;
            if (r10 == null) goto L17;
            int r11 = r10.hashCode();
        L18:
            int r12 = (r9 + r11) * 31;
            Boolean r13 = this.isLive;
            if (r13 == null) goto L21;
            int r14 = r13.hashCode();
        L22:
            int r15 = (r12 + r14) * 31;
            String r16 = this.roomId;
            if (r16 == null) goto L25;
            int r17 = r16.hashCode();
        L26:
            int r18 = (r15 + r17) * 31;
            String r19 = this.secId;
            if (r19 == null) goto L30;
            r1 = r19.hashCode();
        L30:
            return r18 + r1;
        L25:
            r17 = 0;
            goto L26
        L21:
            r14 = 0;
            goto L22
        L17:
            r11 = 0;
            goto L18
        L13:
            r8 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public String toString() {
            return "User(id=" + this.id + ", avatar=" + this.avatar + ", nickname=" + this.nickname + ", isFollowed=" + this.isFollowed + ", isLive=" + this.isLive + ", roomId=" + this.roomId + ", secId=" + this.secId + ")";
        }

        public final Avatar getAvatar() {
            return this.avatar;
        }

        public final String getId() {
            return this.id;
        }

        public final String getNickname() {
            return this.nickname;
        }

        public final String getRoomId() {
            return this.roomId;
        }

        public final String getSecId() {
            return this.secId;
        }

        public final Boolean isFollowed() {
            return this.isFollowed;
        }

        public final Boolean isLive() {
            return this.isLive;
        }

        public User(String r1, Avatar r2, String r3, Boolean r4, Boolean r5, String r6, String r7) {
            this.id = r1;
            this.avatar = r2;
            this.nickname = r3;
            this.isFollowed = r4;
            this.isLive = r5;
            this.roomId = r6;
            this.secId = r7;
        }

        public /* synthetic */ User(String r7, Avatar r8, String r9, Boolean r10, Boolean r11, String r12, String r13, int r14, DefaultConstructorMarker r15) {
            if ((r14 & 1) == 0) goto L5;
            String r16 = null;
        L7:
            if ((r14 & 2) == 0) goto L9;
            Avatar r1 = null;
        L11:
            if ((r14 & 4) == 0) goto L13;
            String r2 = null;
        L15:
            if ((r14 & 8) == 0) goto L17;
            Boolean r3 = null;
        L19:
            if ((r14 & 16) == 0) goto L21;
            Boolean r4 = null;
        L23:
            if ((r14 & 32) == 0) goto L25;
            String r5 = null;
        L27:
            if ((r14 & 64) == 0) goto L29;
            String r17 = null;
        L30:
            this(r16, r1, r2, r3, r4, r5, r17);
            return;
        L29:
            r17 = r13;
            goto L30
        L25:
            r5 = r12;
            goto L27
        L21:
            r4 = r11;
            goto L23
        L17:
            r3 = r10;
            goto L19
        L13:
            r2 = r9;
            goto L15
        L9:
            r1 = r8;
            goto L11
        L5:
            r16 = r7;
            goto L7
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\nJ>\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\nR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$WindVaneEventData;", "", "windVaneLynxData", "", "windVaneSchema", "appendMargin", "", "appendHeight", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getAppendHeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAppendMargin", "getWindVaneLynxData", "()Ljava/lang/String;", "getWindVaneSchema", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$WindVaneEventData;", "equals", "", "other", "hashCode", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class WindVaneEventData {

        @SerializedName("append_height")
        private final Integer appendHeight;

        @SerializedName("append_margin")
        private final Integer appendMargin;

        @SerializedName("lynx_data")
        private final String windVaneLynxData;

        @SerializedName("lynx_schema")
        private final String windVaneSchema;

        public WindVaneEventData() {
            this(null, null, null, null, 15, null);
        }

        public static /* synthetic */ WindVaneEventData copy$default(WindVaneEventData r0, String r1, String r2, Integer r3, Integer r4, int r5, Object r6) {
            if ((r5 & 1) == 0) goto L6;
            r1 = r0.windVaneLynxData;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r2 = r0.windVaneSchema;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r3 = r0.appendMargin;
        L12:
            if ((r5 & 8) == 0) goto L15;
            r4 = r0.appendHeight;
        L15:
            return r0.copy(r1, r2, r3, r4);
        }

        public final String component1() {
            return this.windVaneLynxData;
        }

        public final String component2() {
            return this.windVaneSchema;
        }

        public final Integer component3() {
            return this.appendMargin;
        }

        public final Integer component4() {
            return this.appendHeight;
        }

        public final WindVaneEventData copy(String r2, String r3, Integer r4, Integer r5) {
            return new WindVaneEventData(r2, r3, r4, r5);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof WindVaneEventData) == false) goto L14;
            WindVaneEventData r4 = (WindVaneEventData) r3;
            if (Intrinsics.areEqual(this.windVaneLynxData, r4.windVaneLynxData) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.windVaneSchema, r4.windVaneSchema) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.appendMargin, r4.appendMargin) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.appendHeight, r4.appendHeight) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public int hashCode() {
            String r0 = this.windVaneLynxData;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.windVaneSchema;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            Integer r7 = this.appendMargin;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            Integer r10 = this.appendHeight;
            if (r10 == null) goto L18;
            r1 = r10.hashCode();
        L18:
            return r9 + r1;
        L13:
            r8 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public String toString() {
            return "WindVaneEventData(windVaneLynxData=" + this.windVaneLynxData + ", windVaneSchema=" + this.windVaneSchema + ", appendMargin=" + this.appendMargin + ", appendHeight=" + this.appendHeight + ")";
        }

        public final Integer getAppendHeight() {
            return this.appendHeight;
        }

        public final Integer getAppendMargin() {
            return this.appendMargin;
        }

        public final String getWindVaneLynxData() {
            return this.windVaneLynxData;
        }

        public final String getWindVaneSchema() {
            return this.windVaneSchema;
        }

        public WindVaneEventData(String r1, String r2, Integer r3, Integer r4) {
            this.windVaneLynxData = r1;
            this.windVaneSchema = r2;
            this.appendMargin = r3;
            this.appendHeight = r4;
        }

        public /* synthetic */ WindVaneEventData(String r2, String r3, Integer r4, Integer r5, int r6, DefaultConstructorMarker r7) {
            if ((r6 & 1) == 0) goto L6;
            r2 = null;
        L6:
            if ((r6 & 2) == 0) goto L9;
            r3 = null;
        L9:
            if ((r6 & 4) == 0) goto L12;
            r4 = null;
        L12:
            if ((r6 & 8) == 0) goto L14;
            r5 = null;
        L14:
            this(r2, r3, r4, r5);
        }
    }

    public CommonData() {
    }
}
