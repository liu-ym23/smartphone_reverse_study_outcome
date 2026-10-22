package com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model;

import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.legou.NewerOneOff;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001:\u00039:;B\u008f\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\r\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010\u0015J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0011\u0010.\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\rHÆ\u0003J\u0011\u0010/\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\rHÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u0011\u00101\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\rHÆ\u0003J\u0093\u0001\u00102\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\r2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÆ\u0001J\u0013\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00106\u001a\u000207HÖ\u0001J\t\u00108\u001a\u00020\u000bHÖ\u0001R\u001e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0017R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'¨\u0006<"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/HeaderCardData;", "", "toolList", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/HeaderCardData$ToolList;", "searchCart", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ToolVO;", "channelCards", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/HeaderCardData$ChannelCards;", "middleArea", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/HeaderCardData$MiddleArea;", "bffEcomSceneId", "", "activityListECPerf", "", "tooListECPerf", "btmData", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/BtmData;", "cycleActivityList", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO;", "newerOneOff", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/legou/NewerOneOff;", "(Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/HeaderCardData$ToolList;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ToolVO;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/HeaderCardData$ChannelCards;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/HeaderCardData$MiddleArea;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/BtmData;Ljava/util/List;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/legou/NewerOneOff;)V", "getActivityListECPerf", "()Ljava/util/List;", "getBffEcomSceneId", "()Ljava/lang/String;", "getBtmData", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/BtmData;", "getChannelCards", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/HeaderCardData$ChannelCards;", "getCycleActivityList", "getMiddleArea", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/HeaderCardData$MiddleArea;", "getNewerOneOff", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/legou/NewerOneOff;", "getSearchCart", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ToolVO;", "getTooListECPerf", "getToolList", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/HeaderCardData$ToolList;", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "ChannelCards", "MiddleArea", "ToolList", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HeaderCardData {

    @SerializedName("activity_list_ec_perf")
    private final List<String> activityListECPerf;

    @SerializedName("bff_ecom_scene_id")
    private final String bffEcomSceneId;

    @SerializedName("btm_data")
    private final BtmData btmData;

    @SerializedName("channel_cards")
    private final ChannelCards channelCards;

    @SerializedName("cycle_activity")
    private final List<ChannelVO> cycleActivityList;

    @SerializedName("middle_area")
    private final MiddleArea middleArea;

    @SerializedName("newer_one_off")
    private final NewerOneOff newerOneOff;

    @SerializedName("search_cart")
    private final ToolVO searchCart;

    @SerializedName("tool_list_ec_perf")
    private final List<String> tooListECPerf;

    @SerializedName("tool_list")
    private final ToolList toolList;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u001a\b\u0002\u0010\u0002\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u001b\u0010\f\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0006HÆ\u0003J1\u0010\u000e\u001a\u00020\u00002\u001a\b\u0002\u0010\u0002\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR(\u0010\u0002\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/HeaderCardData$ChannelCards;", "", "data", "", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO;", "btmData", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/BtmData;", "(Ljava/util/List;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/BtmData;)V", "getBtmData", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/BtmData;", "getData", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ChannelCards {

        @SerializedName("btm")
        private final BtmData btmData;

        @SerializedName("cards")
        private final List<List<ChannelVO>> data;

        /* JADX WARN: Multi-variable type inference failed */
        public ChannelCards() {
            Object[] r0 = 0 == true ? 1 : 0;
            this(null, r0, 3, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ChannelCards copy$default(ChannelCards r0, List r1, BtmData r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.data;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.btmData;
        L9:
            return r0.copy(r1, r2);
        }

        public final List<List<ChannelVO>> component1() {
            return this.data;
        }

        public final BtmData component2() {
            return this.btmData;
        }

        public final ChannelCards copy(List<? extends List<ChannelVO>> r2, BtmData r3) {
            return new ChannelCards(r2, r3);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof ChannelCards) == false) goto L10;
            ChannelCards r4 = (ChannelCards) r3;
            if (Intrinsics.areEqual(this.data, r4.data) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.btmData, r4.btmData) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public int hashCode() {
            List<List<ChannelVO>> r0 = this.data;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            BtmData r4 = this.btmData;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public String toString() {
            return "ChannelCards(data=" + this.data + ", btmData=" + this.btmData + ")";
        }

        public final BtmData getBtmData() {
            return this.btmData;
        }

        public final List<List<ChannelVO>> getData() {
            return this.data;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public ChannelCards(List<? extends List<ChannelVO>> r1, BtmData r2) {
            this.data = r1;
            this.btmData = r2;
        }

        public /* synthetic */ ChannelCards(List r2, BtmData r3, int r4, DefaultConstructorMarker r5) {
            if ((r4 & 1) == 0) goto L6;
            r2 = null;
        L6:
            if ((r4 & 2) == 0) goto L8;
            r3 = null;
        L8:
            this(r2, r3);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/HeaderCardData$MiddleArea;", "", "activityList", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/HeaderCardData$ChannelCards;", "(Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/HeaderCardData$ChannelCards;)V", "getActivityList", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/HeaderCardData$ChannelCards;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class MiddleArea {

        @SerializedName("activity_list")
        private final ChannelCards activityList;

        public MiddleArea() {
            ChannelCards r0 = null;
            this(r0, 1, r0);
        }

        public static /* synthetic */ MiddleArea copy$default(MiddleArea r0, ChannelCards r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.activityList;
        L6:
            return r0.copy(r1);
        }

        public final ChannelCards component1() {
            return this.activityList;
        }

        public final MiddleArea copy(ChannelCards r2) {
            return new MiddleArea(r2);
        }

        public boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof MiddleArea) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.activityList, ((MiddleArea) r2).activityList) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public int hashCode() {
            ChannelCards r0 = this.activityList;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public String toString() {
            return "MiddleArea(activityList=" + this.activityList + ")";
        }

        public final ChannelCards getActivityList() {
            return this.activityList;
        }

        public MiddleArea(ChannelCards r1) {
            this.activityList = r1;
        }

        public /* synthetic */ MiddleArea(ChannelCards r1, int r2, DefaultConstructorMarker r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = null;
        L5:
            this(r1);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0013\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u0010\t\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/HeaderCardData$ToolList;", "", "data", "", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ToolVO;", "(Ljava/util/List;)V", "getData", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ToolList {

        @SerializedName("data")
        private final List<ToolVO> data;

        public ToolList() {
            List r0 = null;
            this(r0, 1, r0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ToolList copy$default(ToolList r0, List r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.data;
        L6:
            return r0.copy(r1);
        }

        public final List<ToolVO> component1() {
            return this.data;
        }

        public final ToolList copy(List<ToolVO> r2) {
            return new ToolList(r2);
        }

        public boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof ToolList) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.data, ((ToolList) r2).data) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public int hashCode() {
            List<ToolVO> r0 = this.data;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public String toString() {
            return "ToolList(data=" + this.data + ")";
        }

        public final List<ToolVO> getData() {
            return this.data;
        }

        public ToolList(List<ToolVO> r1) {
            this.data = r1;
        }

        public /* synthetic */ ToolList(List r1, int r2, DefaultConstructorMarker r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = null;
        L5:
            this(r1);
        }
    }

    public HeaderCardData() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HeaderCardData copy$default(HeaderCardData r11, ToolList r12, ToolVO r13, ChannelCards r14, MiddleArea r15, String r16, List r17, List r18, BtmData r19, List r20, NewerOneOff r21, int r22, Object r23) {
        if ((r22 & 1) == 0) goto L5;
        ToolList r2 = r11.toolList;
    L7:
        if ((r22 & 2) == 0) goto L9;
        ToolVO r3 = r11.searchCart;
    L11:
        if ((r22 & 4) == 0) goto L13;
        ChannelCards r4 = r11.channelCards;
    L15:
        if ((r22 & 8) == 0) goto L17;
        MiddleArea r5 = r11.middleArea;
    L19:
        if ((r22 & 16) == 0) goto L21;
        String r6 = r11.bffEcomSceneId;
    L23:
        if ((r22 & 32) == 0) goto L25;
        List r7 = r11.activityListECPerf;
    L27:
        if ((r22 & 64) == 0) goto L29;
        List r8 = r11.tooListECPerf;
    L31:
        if ((r22 & 128) == 0) goto L33;
        BtmData r9 = r11.btmData;
    L35:
        if ((r22 & 256) == 0) goto L37;
        List r10 = r11.cycleActivityList;
    L39:
        if ((r22 & 512) == 0) goto L41;
        NewerOneOff r1 = r11.newerOneOff;
    L43:
        return r11.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r1);
    L41:
        r1 = r21;
        goto L43
    L37:
        r10 = r20;
        goto L39
    L33:
        r9 = r19;
        goto L35
    L29:
        r8 = r18;
        goto L31
    L25:
        r7 = r17;
        goto L27
    L21:
        r6 = r16;
        goto L23
    L17:
        r5 = r15;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r3 = r13;
        goto L11
    L5:
        r2 = r12;
        goto L7
    }

    public final ToolList component1() {
        return this.toolList;
    }

    public final NewerOneOff component10() {
        return this.newerOneOff;
    }

    public final ToolVO component2() {
        return this.searchCart;
    }

    public final ChannelCards component3() {
        return this.channelCards;
    }

    public final MiddleArea component4() {
        return this.middleArea;
    }

    public final String component5() {
        return this.bffEcomSceneId;
    }

    public final List<String> component6() {
        return this.activityListECPerf;
    }

    public final List<String> component7() {
        return this.tooListECPerf;
    }

    public final BtmData component8() {
        return this.btmData;
    }

    public final List<ChannelVO> component9() {
        return this.cycleActivityList;
    }

    public final HeaderCardData copy(ToolList r13, ToolVO r14, ChannelCards r15, MiddleArea r16, String r17, List<String> r18, List<String> r19, BtmData r20, List<ChannelVO> r21, NewerOneOff r22) {
        return new HeaderCardData(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof HeaderCardData) == false) goto L26;
        HeaderCardData r4 = (HeaderCardData) r3;
        if (Intrinsics.areEqual(this.toolList, r4.toolList) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.searchCart, r4.searchCart) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.channelCards, r4.channelCards) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.middleArea, r4.middleArea) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.bffEcomSceneId, r4.bffEcomSceneId) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.activityListECPerf, r4.activityListECPerf) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.tooListECPerf, r4.tooListECPerf) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.btmData, r4.btmData) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.cycleActivityList, r4.cycleActivityList) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.newerOneOff, r4.newerOneOff) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    public int hashCode() {
        ToolList r0 = this.toolList;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        ToolVO r4 = this.searchCart;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        ChannelCards r7 = this.channelCards;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        MiddleArea r10 = this.middleArea;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.bffEcomSceneId;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        List<String> r16 = this.activityListECPerf;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        List<String> r19 = this.tooListECPerf;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        BtmData r22 = this.btmData;
        if (r22 == null) goto L33;
        int r23 = r22.hashCode();
    L34:
        int r24 = (r21 + r23) * 31;
        List<ChannelVO> r25 = this.cycleActivityList;
        if (r25 == null) goto L37;
        int r26 = r25.hashCode();
    L38:
        int r27 = (r24 + r26) * 31;
        NewerOneOff r28 = this.newerOneOff;
        if (r28 == null) goto L42;
        r1 = r28.hashCode();
    L42:
        return r27 + r1;
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
        return "HeaderCardData(toolList=" + this.toolList + ", searchCart=" + this.searchCart + ", channelCards=" + this.channelCards + ", middleArea=" + this.middleArea + ", bffEcomSceneId=" + this.bffEcomSceneId + ", activityListECPerf=" + this.activityListECPerf + ", tooListECPerf=" + this.tooListECPerf + ", btmData=" + this.btmData + ", cycleActivityList=" + this.cycleActivityList + ", newerOneOff=" + this.newerOneOff + ")";
    }

    public final List<String> getActivityListECPerf() {
        return this.activityListECPerf;
    }

    public final String getBffEcomSceneId() {
        return this.bffEcomSceneId;
    }

    public final BtmData getBtmData() {
        return this.btmData;
    }

    public final ChannelCards getChannelCards() {
        return this.channelCards;
    }

    public final List<ChannelVO> getCycleActivityList() {
        return this.cycleActivityList;
    }

    public final MiddleArea getMiddleArea() {
        return this.middleArea;
    }

    public final NewerOneOff getNewerOneOff() {
        return this.newerOneOff;
    }

    public final ToolVO getSearchCart() {
        return this.searchCart;
    }

    public final List<String> getTooListECPerf() {
        return this.tooListECPerf;
    }

    public final ToolList getToolList() {
        return this.toolList;
    }

    public HeaderCardData(ToolList r1, ToolVO r2, ChannelCards r3, MiddleArea r4, String r5, List<String> r6, List<String> r7, BtmData r8, List<ChannelVO> r9, NewerOneOff r10) {
        this.toolList = r1;
        this.searchCart = r2;
        this.channelCards = r3;
        this.middleArea = r4;
        this.bffEcomSceneId = r5;
        this.activityListECPerf = r6;
        this.tooListECPerf = r7;
        this.btmData = r8;
        this.cycleActivityList = r9;
        this.newerOneOff = r10;
    }

    public /* synthetic */ HeaderCardData(ToolList r12, ToolVO r13, ChannelCards r14, MiddleArea r15, String r16, List r17, List r18, BtmData r19, List r20, NewerOneOff r21, int r22, DefaultConstructorMarker r23) {
        NewerOneOff r2 = null;
        if ((r22 & 1) == 0) goto L5;
        ToolList r1 = null;
    L7:
        if ((r22 & 2) == 0) goto L9;
        ToolVO r3 = null;
    L11:
        if ((r22 & 4) == 0) goto L13;
        ChannelCards r4 = null;
    L15:
        if ((r22 & 8) == 0) goto L17;
        MiddleArea r5 = null;
    L19:
        if ((r22 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r22 & 32) == 0) goto L25;
        List r7 = null;
    L27:
        if ((r22 & 64) == 0) goto L29;
        List r8 = null;
    L31:
        if ((r22 & 128) == 0) goto L33;
        BtmData r9 = null;
    L35:
        if ((r22 & 256) == 0) goto L37;
        List r10 = null;
    L39:
        if ((r22 & 512) != 0) goto L42;
        r2 = r21;
    L42:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r2);
        return;
    L37:
        r10 = r20;
        goto L39
    L33:
        r9 = r19;
        goto L35
    L29:
        r8 = r18;
        goto L31
    L25:
        r7 = r17;
        goto L27
    L21:
        r6 = r16;
        goto L23
    L17:
        r5 = r15;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r3 = r13;
        goto L11
    L5:
        r1 = r12;
        goto L7
    }
}
