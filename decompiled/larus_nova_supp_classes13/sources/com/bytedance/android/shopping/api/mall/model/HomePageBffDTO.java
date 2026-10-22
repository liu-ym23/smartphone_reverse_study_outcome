package com.bytedance.android.shopping.api.mall.model;

import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListDTO;
import com.bytedance.android.ec.hybrid.list.entity.k;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b*\b\u0087\b\u0018\u00002\u00020\u0001B\u008b\u0001\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\t\u0012\u0016\b\u0002\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\bM\u0010NJ\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0017\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000bHÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u008d\u0001\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\t2\u0016\b\u0002\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0014HÆ\u0001J\t\u0010!\u001a\u00020\fHÖ\u0001J\t\u0010#\u001a\u00020\"HÖ\u0001J\u0013\u0010&\u001a\u00020%2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003R$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R$\u0010\u0017\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u00101\u001a\u0004\b2\u00103R$\u0010\u0019\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u00101\u001a\u0004\b4\u00103\"\u0004\b5\u00106R$\u0010\u001a\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R0\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010A\u001a\u0004\bB\u0010CR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010D\u001a\u0004\bE\u0010FR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010G\u001a\u0004\bH\u0010IR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010J\u001a\u0004\bK\u0010L¨\u0006O"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/model/HomePageBffDTO;", "", "Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECHybridListDTO;", "component1", "Lcom/bytedance/android/ec/hybrid/list/entity/k;", "component2", "Lcom/bytedance/android/shopping/api/mall/model/SingleCardData;", "component3", "component4", "Lcom/bytedance/android/shopping/api/mall/model/BffBizInfo;", "component5", "", "", "component6", "Lcom/bytedance/android/shopping/api/mall/model/BackgroundWrapper;", "component7", "Lcom/bytedance/android/shopping/api/mall/model/MallCategoryTabAreaInfo;", "component8", "Lcom/bytedance/android/shopping/api/mall/model/PendantWrapper;", "component9", "Lcom/bytedance/android/shopping/api/mall/model/HomepageExtra;", "component10", "feed", "feedVO", "popup", "topBar", "bizInfo", "dynamicParams", "background", "mallCategoryTabAreaInfo", "pendantWrapper", "extra", "copy", "toString", "", "hashCode", "other", "", "equals", "Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECHybridListDTO;", "getFeed", "()Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECHybridListDTO;", "setFeed", "(Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECHybridListDTO;)V", "Lcom/bytedance/android/ec/hybrid/list/entity/k;", "getFeedVO", "()Lcom/bytedance/android/ec/hybrid/list/entity/k;", "setFeedVO", "(Lcom/bytedance/android/ec/hybrid/list/entity/k;)V", "Lcom/bytedance/android/shopping/api/mall/model/SingleCardData;", "getPopup", "()Lcom/bytedance/android/shopping/api/mall/model/SingleCardData;", "getTopBar", "setTopBar", "(Lcom/bytedance/android/shopping/api/mall/model/SingleCardData;)V", "Lcom/bytedance/android/shopping/api/mall/model/BffBizInfo;", "getBizInfo", "()Lcom/bytedance/android/shopping/api/mall/model/BffBizInfo;", "setBizInfo", "(Lcom/bytedance/android/shopping/api/mall/model/BffBizInfo;)V", "Ljava/util/Map;", "getDynamicParams", "()Ljava/util/Map;", "setDynamicParams", "(Ljava/util/Map;)V", "Lcom/bytedance/android/shopping/api/mall/model/BackgroundWrapper;", "getBackground", "()Lcom/bytedance/android/shopping/api/mall/model/BackgroundWrapper;", "Lcom/bytedance/android/shopping/api/mall/model/MallCategoryTabAreaInfo;", "getMallCategoryTabAreaInfo", "()Lcom/bytedance/android/shopping/api/mall/model/MallCategoryTabAreaInfo;", "Lcom/bytedance/android/shopping/api/mall/model/PendantWrapper;", "getPendantWrapper", "()Lcom/bytedance/android/shopping/api/mall/model/PendantWrapper;", "Lcom/bytedance/android/shopping/api/mall/model/HomepageExtra;", "getExtra", "()Lcom/bytedance/android/shopping/api/mall/model/HomepageExtra;", "<init>", "(Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECHybridListDTO;Lcom/bytedance/android/ec/hybrid/list/entity/k;Lcom/bytedance/android/shopping/api/mall/model/SingleCardData;Lcom/bytedance/android/shopping/api/mall/model/SingleCardData;Lcom/bytedance/android/shopping/api/mall/model/BffBizInfo;Ljava/util/Map;Lcom/bytedance/android/shopping/api/mall/model/BackgroundWrapper;Lcom/bytedance/android/shopping/api/mall/model/MallCategoryTabAreaInfo;Lcom/bytedance/android/shopping/api/mall/model/PendantWrapper;Lcom/bytedance/android/shopping/api/mall/model/HomepageExtra;)V", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HomePageBffDTO {

    @SerializedName("background")
    private final BackgroundWrapper background;

    @SerializedName("biz_info")
    private BffBizInfo bizInfo;

    @SerializedName("dynamic_params")
    private Map<String, ? extends Object> dynamicParams;

    @SerializedName("extra")
    private final HomepageExtra extra;

    @SerializedName("feed")
    private ECHybridListDTO feed;
    private volatile transient k feedVO;

    @SerializedName("mall_category_tab_area_info")
    private final MallCategoryTabAreaInfo mallCategoryTabAreaInfo;

    @SerializedName("pendant")
    private final PendantWrapper pendantWrapper;

    @SerializedName("popup")
    private final SingleCardData popup;

    @SerializedName("top_bar")
    private SingleCardData topBar;

    public HomePageBffDTO() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HomePageBffDTO copy$default(HomePageBffDTO r11, ECHybridListDTO r12, k r13, SingleCardData r14, SingleCardData r15, BffBizInfo r16, Map r17, BackgroundWrapper r18, MallCategoryTabAreaInfo r19, PendantWrapper r20, HomepageExtra r21, int r22, Object r23) {
        if ((r22 & 1) == 0) goto L5;
        ECHybridListDTO r2 = r11.feed;
    L7:
        if ((r22 & 2) == 0) goto L9;
        k r3 = r11.feedVO;
    L11:
        if ((r22 & 4) == 0) goto L13;
        SingleCardData r4 = r11.popup;
    L15:
        if ((r22 & 8) == 0) goto L17;
        SingleCardData r5 = r11.topBar;
    L19:
        if ((r22 & 16) == 0) goto L21;
        BffBizInfo r6 = r11.bizInfo;
    L23:
        if ((r22 & 32) == 0) goto L25;
        Map r7 = r11.dynamicParams;
    L27:
        if ((r22 & 64) == 0) goto L29;
        BackgroundWrapper r8 = r11.background;
    L31:
        if ((r22 & 128) == 0) goto L33;
        MallCategoryTabAreaInfo r9 = r11.mallCategoryTabAreaInfo;
    L35:
        if ((r22 & 256) == 0) goto L37;
        PendantWrapper r10 = r11.pendantWrapper;
    L39:
        if ((r22 & 512) == 0) goto L41;
        HomepageExtra r1 = r11.extra;
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

    public final ECHybridListDTO component1() {
        return this.feed;
    }

    public final HomepageExtra component10() {
        return this.extra;
    }

    public final k component2() {
        return this.feedVO;
    }

    public final SingleCardData component3() {
        return this.popup;
    }

    public final SingleCardData component4() {
        return this.topBar;
    }

    public final BffBizInfo component5() {
        return this.bizInfo;
    }

    public final Map<String, Object> component6() {
        return this.dynamicParams;
    }

    public final BackgroundWrapper component7() {
        return this.background;
    }

    public final MallCategoryTabAreaInfo component8() {
        return this.mallCategoryTabAreaInfo;
    }

    public final PendantWrapper component9() {
        return this.pendantWrapper;
    }

    public final HomePageBffDTO copy(ECHybridListDTO r13, k r14, SingleCardData r15, SingleCardData r16, BffBizInfo r17, Map<String, ? extends Object> r18, BackgroundWrapper r19, MallCategoryTabAreaInfo r20, PendantWrapper r21, HomepageExtra r22) {
        return new HomePageBffDTO(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof HomePageBffDTO) == false) goto L26;
        HomePageBffDTO r4 = (HomePageBffDTO) r3;
        if (Intrinsics.areEqual(this.feed, r4.feed) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.feedVO, r4.feedVO) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.popup, r4.popup) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.topBar, r4.topBar) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.bizInfo, r4.bizInfo) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.dynamicParams, r4.dynamicParams) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.background, r4.background) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.mallCategoryTabAreaInfo, r4.mallCategoryTabAreaInfo) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.pendantWrapper, r4.pendantWrapper) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.extra, r4.extra) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    public int hashCode() {
        ECHybridListDTO r0 = this.feed;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        k r4 = this.feedVO;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        SingleCardData r7 = this.popup;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        SingleCardData r10 = this.topBar;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        BffBizInfo r13 = this.bizInfo;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        Map<String, ? extends Object> r16 = this.dynamicParams;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        BackgroundWrapper r19 = this.background;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        MallCategoryTabAreaInfo r22 = this.mallCategoryTabAreaInfo;
        if (r22 == null) goto L33;
        int r23 = r22.hashCode();
    L34:
        int r24 = (r21 + r23) * 31;
        PendantWrapper r25 = this.pendantWrapper;
        if (r25 == null) goto L37;
        int r26 = r25.hashCode();
    L38:
        int r27 = (r24 + r26) * 31;
        HomepageExtra r28 = this.extra;
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
        return "HomePageBffDTO(feed=" + this.feed + ", feedVO=" + this.feedVO + ", popup=" + this.popup + ", topBar=" + this.topBar + ", bizInfo=" + this.bizInfo + ", dynamicParams=" + this.dynamicParams + ", background=" + this.background + ", mallCategoryTabAreaInfo=" + this.mallCategoryTabAreaInfo + ", pendantWrapper=" + this.pendantWrapper + ", extra=" + this.extra + ")";
    }

    public final BackgroundWrapper getBackground() {
        return this.background;
    }

    public final BffBizInfo getBizInfo() {
        return this.bizInfo;
    }

    public final Map<String, Object> getDynamicParams() {
        return this.dynamicParams;
    }

    public final HomepageExtra getExtra() {
        return this.extra;
    }

    public final ECHybridListDTO getFeed() {
        return this.feed;
    }

    public final k getFeedVO() {
        return this.feedVO;
    }

    public final MallCategoryTabAreaInfo getMallCategoryTabAreaInfo() {
        return this.mallCategoryTabAreaInfo;
    }

    public final PendantWrapper getPendantWrapper() {
        return this.pendantWrapper;
    }

    public final SingleCardData getPopup() {
        return this.popup;
    }

    public final SingleCardData getTopBar() {
        return this.topBar;
    }

    public final void setBizInfo(BffBizInfo r1) {
        this.bizInfo = r1;
    }

    public final void setDynamicParams(Map<String, ? extends Object> r1) {
        this.dynamicParams = r1;
    }

    public final void setFeed(ECHybridListDTO r1) {
        this.feed = r1;
    }

    public final void setFeedVO(k r1) {
        this.feedVO = r1;
    }

    public final void setTopBar(SingleCardData r1) {
        this.topBar = r1;
    }

    public HomePageBffDTO(ECHybridListDTO r1, k r2, SingleCardData r3, SingleCardData r4, BffBizInfo r5, Map<String, ? extends Object> r6, BackgroundWrapper r7, MallCategoryTabAreaInfo r8, PendantWrapper r9, HomepageExtra r10) {
        this.feed = r1;
        this.feedVO = r2;
        this.popup = r3;
        this.topBar = r4;
        this.bizInfo = r5;
        this.dynamicParams = r6;
        this.background = r7;
        this.mallCategoryTabAreaInfo = r8;
        this.pendantWrapper = r9;
        this.extra = r10;
    }

    public /* synthetic */ HomePageBffDTO(ECHybridListDTO r12, k r13, SingleCardData r14, SingleCardData r15, BffBizInfo r16, Map r17, BackgroundWrapper r18, MallCategoryTabAreaInfo r19, PendantWrapper r20, HomepageExtra r21, int r22, DefaultConstructorMarker r23) {
        HomepageExtra r2 = null;
        if ((r22 & 1) == 0) goto L5;
        ECHybridListDTO r1 = null;
    L7:
        if ((r22 & 2) == 0) goto L9;
        k r3 = null;
    L11:
        if ((r22 & 4) == 0) goto L13;
        SingleCardData r4 = null;
    L15:
        if ((r22 & 8) == 0) goto L17;
        SingleCardData r5 = null;
    L19:
        if ((r22 & 16) == 0) goto L21;
        BffBizInfo r6 = null;
    L23:
        if ((r22 & 32) == 0) goto L25;
        Map r7 = null;
    L27:
        if ((r22 & 64) == 0) goto L29;
        BackgroundWrapper r8 = null;
    L31:
        if ((r22 & 128) == 0) goto L33;
        MallCategoryTabAreaInfo r9 = null;
    L35:
        if ((r22 & 256) == 0) goto L37;
        PendantWrapper r10 = null;
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
