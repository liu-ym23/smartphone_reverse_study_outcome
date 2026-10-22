package com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model;

import com.google.gson.annotations.SerializedName;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001:\u0002BCB\u0093\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\u0002\u0010\u0018J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u0015\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00170\u0016HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u00103\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010$J\u000b\u00104\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u0010\u00108\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010$J\u000b\u00109\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u009c\u0001\u0010:\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00170\u0016HÆ\u0001¢\u0006\u0002\u0010;J\u0013\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010?\u001a\u00020\u0007HÖ\u0001J\u0006\u0010@\u001a\u00020\u0003J\t\u0010A\u001a\u00020\u0003HÖ\u0001R\u001d\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010%\u001a\u0004\b#\u0010$R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010%\u001a\u0004\b*\u0010$R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.¨\u0006D"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECCommonCard;", "", "tagUrl", "", "wysiwygParam", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/WysiwygParam;", "type", "", "product", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECProductStruct;", "user", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECUserStruct;", "live", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECLiveStruct;", "coupon", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/Coupon4Activity;", "position", "extra", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECCommonCard$Extra;", "entrancePit", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$Data$EntrancePit;", "animItems", "", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECCommonCard$AnimItem;", "(Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/WysiwygParam;Ljava/lang/Integer;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECProductStruct;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECUserStruct;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECLiveStruct;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/Coupon4Activity;Ljava/lang/Integer;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECCommonCard$Extra;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$Data$EntrancePit;Ljava/util/Map;)V", "getAnimItems", "()Ljava/util/Map;", "getCoupon", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/Coupon4Activity;", "getEntrancePit", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$Data$EntrancePit;", "getExtra", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECCommonCard$Extra;", "getLive", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECLiveStruct;", "getPosition", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getProduct", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECProductStruct;", "getTagUrl", "()Ljava/lang/String;", "getType", "getUser", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECUserStruct;", "getWysiwygParam", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/WysiwygParam;", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/WysiwygParam;Ljava/lang/Integer;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECProductStruct;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECUserStruct;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECLiveStruct;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/Coupon4Activity;Ljava/lang/Integer;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECCommonCard$Extra;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$Data$EntrancePit;Ljava/util/Map;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECCommonCard;", "equals", "", "other", "hashCode", "recommendFromItem", "toString", "AnimItem", "Extra", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECCommonCard {
    private final Map<Integer, AnimItem> animItems;

    @SerializedName("coupon")
    private final Coupon4Activity coupon;

    @SerializedName("entrance_pit")
    private final ChannelVO.Data.EntrancePit entrancePit;

    @SerializedName("extra")
    private final Extra extra;

    @SerializedName("live")
    private final ECLiveStruct live;

    @SerializedName("position")
    private final Integer position;

    @SerializedName("product")
    private final ECProductStruct product;

    @SerializedName("tag_url")
    private final String tagUrl;

    @SerializedName("type")
    private final Integer type;

    @SerializedName("user")
    private final ECUserStruct user;

    @SerializedName("wysiwyg_param")
    private final WysiwygParam wysiwygParam;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Bq\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010$\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010%\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0010Jz\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\u0003HÖ\u0001J\t\u0010,\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0017\u0010\u0010R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0019\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u001b\u0010\u0013R\u0015\u0010\r\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u001c\u0010\u0010¨\u0006-"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECCommonCard$AnimItem;", "", "tagType", "", "tagContent", "", "imageUrl", "idx", "subIdx", "pictureType", "delayTime", "", "interval", "times", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "getDelayTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getIdx", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getImageUrl", "()Ljava/lang/String;", "getInterval", "getPictureType", "getSubIdx", "getTagContent", "getTagType", "getTimes", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECCommonCard$AnimItem;", "equals", "", "other", "hashCode", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class AnimItem {
        private final Long delayTime;
        private final Integer idx;
        private final String imageUrl;
        private final Long interval;
        private final String pictureType;
        private final Integer subIdx;
        private final String tagContent;
        private final Integer tagType;
        private final Long times;

        public AnimItem() {
            this(null, null, null, null, null, null, null, null, null, 511, null);
        }

        public static /* synthetic */ AnimItem copy$default(AnimItem r10, Integer r11, String r12, String r13, Integer r14, Integer r15, String r16, Long r17, Long r18, Long r19, int r20, Object r21) {
            if ((r20 & 1) == 0) goto L5;
            Integer r2 = r10.tagType;
        L7:
            if ((r20 & 2) == 0) goto L9;
            String r3 = r10.tagContent;
        L11:
            if ((r20 & 4) == 0) goto L13;
            String r4 = r10.imageUrl;
        L15:
            if ((r20 & 8) == 0) goto L17;
            Integer r5 = r10.idx;
        L19:
            if ((r20 & 16) == 0) goto L21;
            Integer r6 = r10.subIdx;
        L23:
            if ((r20 & 32) == 0) goto L25;
            String r7 = r10.pictureType;
        L27:
            if ((r20 & 64) == 0) goto L29;
            Long r8 = r10.delayTime;
        L31:
            if ((r20 & 128) == 0) goto L33;
            Long r9 = r10.interval;
        L35:
            if ((r20 & 256) == 0) goto L37;
            Long r1 = r10.times;
        L39:
            return r10.copy(r2, r3, r4, r5, r6, r7, r8, r9, r1);
        L37:
            r1 = r19;
            goto L39
        L33:
            r9 = r18;
            goto L35
        L29:
            r8 = r17;
            goto L31
        L25:
            r7 = r16;
            goto L27
        L21:
            r6 = r15;
            goto L23
        L17:
            r5 = r14;
            goto L19
        L13:
            r4 = r13;
            goto L15
        L9:
            r3 = r12;
            goto L11
        L5:
            r2 = r11;
            goto L7
        }

        public final Integer component1() {
            return this.tagType;
        }

        public final String component2() {
            return this.tagContent;
        }

        public final String component3() {
            return this.imageUrl;
        }

        public final Integer component4() {
            return this.idx;
        }

        public final Integer component5() {
            return this.subIdx;
        }

        public final String component6() {
            return this.pictureType;
        }

        public final Long component7() {
            return this.delayTime;
        }

        public final Long component8() {
            return this.interval;
        }

        public final Long component9() {
            return this.times;
        }

        public final AnimItem copy(Integer r12, String r13, String r14, Integer r15, Integer r16, String r17, Long r18, Long r19, Long r20) {
            return new AnimItem(r12, r13, r14, r15, r16, r17, r18, r19, r20);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof AnimItem) == false) goto L24;
            AnimItem r4 = (AnimItem) r3;
            if (Intrinsics.areEqual(this.tagType, r4.tagType) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.tagContent, r4.tagContent) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.imageUrl, r4.imageUrl) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.idx, r4.idx) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.subIdx, r4.subIdx) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.pictureType, r4.pictureType) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.delayTime, r4.delayTime) == true) goto L20;
            return false;
        L20:
            if (Intrinsics.areEqual(this.interval, r4.interval) == true) goto L22;
            return false;
        L22:
            if (Intrinsics.areEqual(this.times, r4.times) == true) goto L37;
            return false;
        L37:
            return true;
        L24:
            return false;
        }

        public int hashCode() {
            Integer r0 = this.tagType;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.tagContent;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.imageUrl;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            Integer r10 = this.idx;
            if (r10 == null) goto L17;
            int r11 = r10.hashCode();
        L18:
            int r12 = (r9 + r11) * 31;
            Integer r13 = this.subIdx;
            if (r13 == null) goto L21;
            int r14 = r13.hashCode();
        L22:
            int r15 = (r12 + r14) * 31;
            String r16 = this.pictureType;
            if (r16 == null) goto L25;
            int r17 = r16.hashCode();
        L26:
            int r18 = (r15 + r17) * 31;
            Long r19 = this.delayTime;
            if (r19 == null) goto L29;
            int r20 = r19.hashCode();
        L30:
            int r21 = (r18 + r20) * 31;
            Long r22 = this.interval;
            if (r22 == null) goto L33;
            int r23 = r22.hashCode();
        L34:
            int r24 = (r21 + r23) * 31;
            Long r25 = this.times;
            if (r25 == null) goto L38;
            r1 = r25.hashCode();
        L38:
            return r24 + r1;
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
            return "AnimItem(tagType=" + this.tagType + ", tagContent=" + this.tagContent + ", imageUrl=" + this.imageUrl + ", idx=" + this.idx + ", subIdx=" + this.subIdx + ", pictureType=" + this.pictureType + ", delayTime=" + this.delayTime + ", interval=" + this.interval + ", times=" + this.times + ")";
        }

        public final Long getDelayTime() {
            return this.delayTime;
        }

        public final Integer getIdx() {
            return this.idx;
        }

        public final String getImageUrl() {
            return this.imageUrl;
        }

        public final Long getInterval() {
            return this.interval;
        }

        public final String getPictureType() {
            return this.pictureType;
        }

        public final Integer getSubIdx() {
            return this.subIdx;
        }

        public final String getTagContent() {
            return this.tagContent;
        }

        public final Integer getTagType() {
            return this.tagType;
        }

        public final Long getTimes() {
            return this.times;
        }

        public AnimItem(Integer r1, String r2, String r3, Integer r4, Integer r5, String r6, Long r7, Long r8, Long r9) {
            this.tagType = r1;
            this.tagContent = r2;
            this.imageUrl = r3;
            this.idx = r4;
            this.subIdx = r5;
            this.pictureType = r6;
            this.delayTime = r7;
            this.interval = r8;
            this.times = r9;
        }

        public /* synthetic */ AnimItem(Integer r11, String r12, String r13, Integer r14, Integer r15, String r16, Long r17, Long r18, Long r19, int r20, DefaultConstructorMarker r21) {
            Long r2 = null;
            if ((r20 & 1) == 0) goto L5;
            Integer r1 = null;
        L7:
            if ((r20 & 2) == 0) goto L9;
            String r3 = null;
        L11:
            if ((r20 & 4) == 0) goto L13;
            String r4 = null;
        L15:
            if ((r20 & 8) == 0) goto L17;
            Integer r5 = null;
        L19:
            if ((r20 & 16) == 0) goto L21;
            Integer r6 = null;
        L23:
            if ((r20 & 32) == 0) goto L25;
            String r7 = null;
        L27:
            if ((r20 & 64) == 0) goto L29;
            Long r8 = null;
        L31:
            if ((r20 & 128) == 0) goto L33;
            Long r9 = null;
        L35:
            if ((r20 & 256) != 0) goto L38;
            r2 = r19;
        L38:
            this(r1, r3, r4, r5, r6, r7, r8, r9, r2);
            return;
        L33:
            r9 = r18;
            goto L35
        L29:
            r8 = r17;
            goto L31
        L25:
            r7 = r16;
            goto L27
        L21:
            r6 = r15;
            goto L23
        L17:
            r5 = r14;
            goto L19
        L13:
            r4 = r13;
            goto L15
        L9:
            r3 = r12;
            goto L11
        L5:
            r1 = r11;
            goto L7
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECCommonCard$Extra;", "", "recommendInfo", "", "(Ljava/lang/String;)V", "getRecommendInfo", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Extra {

        @SerializedName("recommend_info")
        private final String recommendInfo;

        public Extra() {
            String r0 = null;
            this(r0, 1, r0);
        }

        public static /* synthetic */ Extra copy$default(Extra r0, String r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.recommendInfo;
        L6:
            return r0.copy(r1);
        }

        public final String component1() {
            return this.recommendInfo;
        }

        public final Extra copy(String r2) {
            return new Extra(r2);
        }

        public boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof Extra) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.recommendInfo, ((Extra) r2).recommendInfo) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public int hashCode() {
            String r0 = this.recommendInfo;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public String toString() {
            return "Extra(recommendInfo=" + this.recommendInfo + ")";
        }

        public final String getRecommendInfo() {
            return this.recommendInfo;
        }

        public Extra(String r1) {
            this.recommendInfo = r1;
        }

        public /* synthetic */ Extra(String r1, int r2, DefaultConstructorMarker r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = null;
        L5:
            this(r1);
        }
    }

    public ECCommonCard() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ECCommonCard copy$default(ECCommonCard r12, String r13, WysiwygParam r14, Integer r15, ECProductStruct r16, ECUserStruct r17, ECLiveStruct r18, Coupon4Activity r19, Integer r20, Extra r21, ChannelVO.Data.EntrancePit r22, Map r23, int r24, Object r25) {
        if ((r24 & 1) == 0) goto L5;
        String r2 = r12.tagUrl;
    L7:
        if ((r24 & 2) == 0) goto L9;
        WysiwygParam r3 = r12.wysiwygParam;
    L11:
        if ((r24 & 4) == 0) goto L13;
        Integer r4 = r12.type;
    L15:
        if ((r24 & 8) == 0) goto L17;
        ECProductStruct r5 = r12.product;
    L19:
        if ((r24 & 16) == 0) goto L21;
        ECUserStruct r6 = r12.user;
    L23:
        if ((r24 & 32) == 0) goto L25;
        ECLiveStruct r7 = r12.live;
    L27:
        if ((r24 & 64) == 0) goto L29;
        Coupon4Activity r8 = r12.coupon;
    L31:
        if ((r24 & 128) == 0) goto L33;
        Integer r9 = r12.position;
    L35:
        if ((r24 & 256) == 0) goto L37;
        Extra r10 = r12.extra;
    L39:
        if ((r24 & 512) == 0) goto L41;
        ChannelVO.Data.EntrancePit r11 = r12.entrancePit;
    L43:
        if ((r24 & 1024) == 0) goto L45;
        Map r1 = r12.animItems;
    L47:
        return r12.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r1);
    L45:
        r1 = r23;
        goto L47
    L41:
        r11 = r22;
        goto L43
    L37:
        r10 = r21;
        goto L39
    L33:
        r9 = r20;
        goto L35
    L29:
        r8 = r19;
        goto L31
    L25:
        r7 = r18;
        goto L27
    L21:
        r6 = r17;
        goto L23
    L17:
        r5 = r16;
        goto L19
    L13:
        r4 = r15;
        goto L15
    L9:
        r3 = r14;
        goto L11
    L5:
        r2 = r13;
        goto L7
    }

    public final String component1() {
        return this.tagUrl;
    }

    public final ChannelVO.Data.EntrancePit component10() {
        return this.entrancePit;
    }

    public final Map<Integer, AnimItem> component11() {
        return this.animItems;
    }

    public final WysiwygParam component2() {
        return this.wysiwygParam;
    }

    public final Integer component3() {
        return this.type;
    }

    public final ECProductStruct component4() {
        return this.product;
    }

    public final ECUserStruct component5() {
        return this.user;
    }

    public final ECLiveStruct component6() {
        return this.live;
    }

    public final Coupon4Activity component7() {
        return this.coupon;
    }

    public final Integer component8() {
        return this.position;
    }

    public final Extra component9() {
        return this.extra;
    }

    public final ECCommonCard copy(String r14, WysiwygParam r15, Integer r16, ECProductStruct r17, ECUserStruct r18, ECLiveStruct r19, Coupon4Activity r20, Integer r21, Extra r22, ChannelVO.Data.EntrancePit r23, Map<Integer, AnimItem> r24) {
        Intrinsics.checkNotNullParameter(r24, "animItems");
        return new ECCommonCard(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof ECCommonCard) == false) goto L28;
        ECCommonCard r4 = (ECCommonCard) r3;
        if (Intrinsics.areEqual(this.tagUrl, r4.tagUrl) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.wysiwygParam, r4.wysiwygParam) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.type, r4.type) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.product, r4.product) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.user, r4.user) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.live, r4.live) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.coupon, r4.coupon) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.position, r4.position) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.extra, r4.extra) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.entrancePit, r4.entrancePit) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.animItems, r4.animItems) == true) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    public int hashCode() {
        String r0 = this.tagUrl;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        WysiwygParam r4 = this.wysiwygParam;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.type;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        ECProductStruct r10 = this.product;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        ECUserStruct r13 = this.user;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        ECLiveStruct r16 = this.live;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        Coupon4Activity r19 = this.coupon;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        Integer r22 = this.position;
        if (r22 == null) goto L33;
        int r23 = r22.hashCode();
    L34:
        int r24 = (r21 + r23) * 31;
        Extra r25 = this.extra;
        if (r25 == null) goto L37;
        int r26 = r25.hashCode();
    L38:
        int r27 = (r24 + r26) * 31;
        ChannelVO.Data.EntrancePit r28 = this.entrancePit;
        if (r28 == null) goto L41;
        int r29 = r28.hashCode();
    L42:
        int r30 = (r27 + r29) * 31;
        Map<Integer, AnimItem> r31 = this.animItems;
        if (r31 == null) goto L46;
        r1 = r31.hashCode();
    L46:
        return r30 + r1;
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
        return "ECCommonCard(tagUrl=" + this.tagUrl + ", wysiwygParam=" + this.wysiwygParam + ", type=" + this.type + ", product=" + this.product + ", user=" + this.user + ", live=" + this.live + ", coupon=" + this.coupon + ", position=" + this.position + ", extra=" + this.extra + ", entrancePit=" + this.entrancePit + ", animItems=" + this.animItems + ")";
    }

    public final String recommendFromItem() {
        ECProductStruct r0 = this.product;
        if (r0 == null) goto L5;
        String r1 = r0.getRecommendInfo();
    L6:
        if (r1 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == false) goto L19;
        Extra r3 = this.extra;
        if (r3 == null) goto L17;
        String r4 = r3.getRecommendInfo();
        if (r4 == null) goto L17;
        return r4;
    L17:
        return "";
    L19:
        return r1;
    L8:
        if (r1.length() == 0) goto L11;
        r2 = false;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    public final Map<Integer, AnimItem> getAnimItems() {
        return this.animItems;
    }

    public final Coupon4Activity getCoupon() {
        return this.coupon;
    }

    public final ChannelVO.Data.EntrancePit getEntrancePit() {
        return this.entrancePit;
    }

    public final Extra getExtra() {
        return this.extra;
    }

    public final ECLiveStruct getLive() {
        return this.live;
    }

    public final Integer getPosition() {
        return this.position;
    }

    public final ECProductStruct getProduct() {
        return this.product;
    }

    public final String getTagUrl() {
        return this.tagUrl;
    }

    public final Integer getType() {
        return this.type;
    }

    public final ECUserStruct getUser() {
        return this.user;
    }

    public final WysiwygParam getWysiwygParam() {
        return this.wysiwygParam;
    }

    public ECCommonCard(String r2, WysiwygParam r3, Integer r4, ECProductStruct r5, ECUserStruct r6, ECLiveStruct r7, Coupon4Activity r8, Integer r9, Extra r10, ChannelVO.Data.EntrancePit r11, Map<Integer, AnimItem> r12) {
        Intrinsics.checkNotNullParameter(r12, "animItems");
        this.tagUrl = r2;
        this.wysiwygParam = r3;
        this.type = r4;
        this.product = r5;
        this.user = r6;
        this.live = r7;
        this.coupon = r8;
        this.position = r9;
        this.extra = r10;
        this.entrancePit = r11;
        this.animItems = r12;
    }

    public /* synthetic */ ECCommonCard(String r13, WysiwygParam r14, Integer r15, ECProductStruct r16, ECUserStruct r17, ECLiveStruct r18, Coupon4Activity r19, Integer r20, Extra r21, ChannelVO.Data.EntrancePit r22, Map r23, int r24, DefaultConstructorMarker r25) {
        ChannelVO.Data.EntrancePit r2 = null;
        if ((r24 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r24 & 2) == 0) goto L9;
        WysiwygParam r3 = null;
    L11:
        if ((r24 & 4) == 0) goto L13;
        Integer r4 = null;
    L15:
        if ((r24 & 8) == 0) goto L17;
        ECProductStruct r5 = null;
    L19:
        if ((r24 & 16) == 0) goto L21;
        ECUserStruct r6 = null;
    L23:
        if ((r24 & 32) == 0) goto L25;
        ECLiveStruct r7 = null;
    L27:
        if ((r24 & 64) == 0) goto L29;
        Coupon4Activity r8 = null;
    L31:
        if ((r24 & 128) == 0) goto L33;
        Integer r9 = null;
    L35:
        if ((r24 & 256) == 0) goto L37;
        Extra r10 = null;
    L39:
        if ((r24 & 512) != 0) goto L43;
        r2 = r22;
    L43:
        if ((r24 & 1024) == 0) goto L45;
        Map r0 = new LinkedHashMap();
    L46:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r2, r0);
        return;
    L45:
        r0 = r23;
        goto L46
    L37:
        r10 = r21;
        goto L39
    L33:
        r9 = r20;
        goto L35
    L29:
        r8 = r19;
        goto L31
    L25:
        r7 = r18;
        goto L27
    L21:
        r6 = r17;
        goto L23
    L17:
        r5 = r16;
        goto L19
    L13:
        r4 = r15;
        goto L15
    L9:
        r3 = r14;
        goto L11
    L5:
        r1 = r13;
        goto L7
    }
}
