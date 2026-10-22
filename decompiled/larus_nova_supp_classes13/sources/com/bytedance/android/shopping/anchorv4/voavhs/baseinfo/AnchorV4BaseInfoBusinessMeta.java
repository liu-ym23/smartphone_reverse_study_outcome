package com.bytedance.android.shopping.anchorv4.voavhs.baseinfo;

import com.bytedance.android.shopping.anchorv4.bottom.CollectMeta;
import com.bytedance.android.shopping.anchorv4.bottom.LikeMeta;
import com.bytedance.android.shopping.anchorv4.bottom.SkuMeta;
import com.bytedance.android.shopping.anchorv4.dto.adapter.JsonToStringAdapter;
import com.bytedance.android.shopping.anchorv4.nav.ShareMeta;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u008f\u0001\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0016J\u0011\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u00102\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u00103\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010(J\u000b\u00104\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u0098\u0001\u00106\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u00107J\u0013\u00108\u001a\u00020\f2\b\u00109\u001a\u0004\u0018\u00010:HÖ\u0003J\t\u0010;\u001a\u00020\u000eHÖ\u0001J\t\u0010<\u001a\u00020\u0006HÖ\u0001R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u000b\u0010\u001dR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0018R\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010)\u001a\u0004\b'\u0010(R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0018¨\u0006="}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/baseinfo/AnchorV4BaseInfoBusinessMeta;", "Ljava/io/Serializable;", "bannerMetaList", "", "Lcom/bytedance/android/shopping/anchorv4/voavhs/baseinfo/AnchorV4BannerMeta;", "rankUrl", "", "aboardInfo", "taxDesc", "skuMeta", "Lcom/bytedance/android/shopping/anchorv4/bottom/SkuMeta;", "isPreselected", "", "termCount", "", "like", "Lcom/bytedance/android/shopping/anchorv4/bottom/LikeMeta;", "collect", "Lcom/bytedance/android/shopping/anchorv4/bottom/CollectMeta;", "share", "Lcom/bytedance/android/shopping/anchorv4/nav/ShareMeta;", "windowUrl", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/shopping/anchorv4/bottom/SkuMeta;Ljava/lang/Boolean;Ljava/lang/Integer;Lcom/bytedance/android/shopping/anchorv4/bottom/LikeMeta;Lcom/bytedance/android/shopping/anchorv4/bottom/CollectMeta;Lcom/bytedance/android/shopping/anchorv4/nav/ShareMeta;Ljava/lang/String;)V", "getAboardInfo", "()Ljava/lang/String;", "getBannerMetaList", "()Ljava/util/List;", "getCollect", "()Lcom/bytedance/android/shopping/anchorv4/bottom/CollectMeta;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLike", "()Lcom/bytedance/android/shopping/anchorv4/bottom/LikeMeta;", "getRankUrl", "getShare", "()Lcom/bytedance/android/shopping/anchorv4/nav/ShareMeta;", "getSkuMeta", "()Lcom/bytedance/android/shopping/anchorv4/bottom/SkuMeta;", "getTaxDesc", "getTermCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getWindowUrl", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/shopping/anchorv4/bottom/SkuMeta;Ljava/lang/Boolean;Ljava/lang/Integer;Lcom/bytedance/android/shopping/anchorv4/bottom/LikeMeta;Lcom/bytedance/android/shopping/anchorv4/bottom/CollectMeta;Lcom/bytedance/android/shopping/anchorv4/nav/ShareMeta;Ljava/lang/String;)Lcom/bytedance/android/shopping/anchorv4/voavhs/baseinfo/AnchorV4BaseInfoBusinessMeta;", "equals", "other", "", "hashCode", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4BaseInfoBusinessMeta implements Serializable {

    @SerializedName("aboard_info")
    @JsonAdapter(JsonToStringAdapter.class)
    private final String aboardInfo;

    @SerializedName("banner_meta_list")
    private final List<AnchorV4BannerMeta> bannerMetaList;

    @SerializedName("collect")
    private final CollectMeta collect;

    @SerializedName("is_preselected")
    private final Boolean isPreselected;

    @SerializedName("like")
    private final LikeMeta like;

    @SerializedName("rank_url")
    private final String rankUrl;

    @SerializedName("share")
    private final ShareMeta share;

    @SerializedName("sku_meta")
    private final SkuMeta skuMeta;

    @SerializedName("tax_desc")
    @JsonAdapter(JsonToStringAdapter.class)
    private final String taxDesc;

    @SerializedName("term_count")
    private final Integer termCount;

    @SerializedName("window_url")
    private final String windowUrl;

    public AnchorV4BaseInfoBusinessMeta() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AnchorV4BaseInfoBusinessMeta copy$default(AnchorV4BaseInfoBusinessMeta r12, List r13, String r14, String r15, String r16, SkuMeta r17, Boolean r18, Integer r19, LikeMeta r20, CollectMeta r21, ShareMeta r22, String r23, int r24, Object r25) {
        if ((r24 & 1) == 0) goto L5;
        List r2 = r12.bannerMetaList;
    L7:
        if ((r24 & 2) == 0) goto L9;
        String r3 = r12.rankUrl;
    L11:
        if ((r24 & 4) == 0) goto L13;
        String r4 = r12.aboardInfo;
    L15:
        if ((r24 & 8) == 0) goto L17;
        String r5 = r12.taxDesc;
    L19:
        if ((r24 & 16) == 0) goto L21;
        SkuMeta r6 = r12.skuMeta;
    L23:
        if ((r24 & 32) == 0) goto L25;
        Boolean r7 = r12.isPreselected;
    L27:
        if ((r24 & 64) == 0) goto L29;
        Integer r8 = r12.termCount;
    L31:
        if ((r24 & 128) == 0) goto L33;
        LikeMeta r9 = r12.like;
    L35:
        if ((r24 & 256) == 0) goto L37;
        CollectMeta r10 = r12.collect;
    L39:
        if ((r24 & 512) == 0) goto L41;
        ShareMeta r11 = r12.share;
    L43:
        if ((r24 & 1024) == 0) goto L45;
        String r1 = r12.windowUrl;
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

    public final List<AnchorV4BannerMeta> component1() {
        return this.bannerMetaList;
    }

    public final ShareMeta component10() {
        return this.share;
    }

    public final String component11() {
        return this.windowUrl;
    }

    public final String component2() {
        return this.rankUrl;
    }

    public final String component3() {
        return this.aboardInfo;
    }

    public final String component4() {
        return this.taxDesc;
    }

    public final SkuMeta component5() {
        return this.skuMeta;
    }

    public final Boolean component6() {
        return this.isPreselected;
    }

    public final Integer component7() {
        return this.termCount;
    }

    public final LikeMeta component8() {
        return this.like;
    }

    public final CollectMeta component9() {
        return this.collect;
    }

    public final AnchorV4BaseInfoBusinessMeta copy(List<AnchorV4BannerMeta> r14, String r15, String r16, String r17, SkuMeta r18, Boolean r19, Integer r20, LikeMeta r21, CollectMeta r22, ShareMeta r23, String r24) {
        return new AnchorV4BaseInfoBusinessMeta(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof AnchorV4BaseInfoBusinessMeta) == false) goto L28;
        AnchorV4BaseInfoBusinessMeta r4 = (AnchorV4BaseInfoBusinessMeta) r3;
        if (Intrinsics.areEqual(this.bannerMetaList, r4.bannerMetaList) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.rankUrl, r4.rankUrl) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.aboardInfo, r4.aboardInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.taxDesc, r4.taxDesc) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.skuMeta, r4.skuMeta) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.isPreselected, r4.isPreselected) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.termCount, r4.termCount) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.like, r4.like) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.collect, r4.collect) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.share, r4.share) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.windowUrl, r4.windowUrl) == true) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    public int hashCode() {
        List<AnchorV4BannerMeta> r0 = this.bannerMetaList;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.rankUrl;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.aboardInfo;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.taxDesc;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        SkuMeta r13 = this.skuMeta;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        Boolean r16 = this.isPreselected;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        Integer r19 = this.termCount;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        LikeMeta r22 = this.like;
        if (r22 == null) goto L33;
        int r23 = r22.hashCode();
    L34:
        int r24 = (r21 + r23) * 31;
        CollectMeta r25 = this.collect;
        if (r25 == null) goto L37;
        int r26 = r25.hashCode();
    L38:
        int r27 = (r24 + r26) * 31;
        ShareMeta r28 = this.share;
        if (r28 == null) goto L41;
        int r29 = r28.hashCode();
    L42:
        int r30 = (r27 + r29) * 31;
        String r31 = this.windowUrl;
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
        return "AnchorV4BaseInfoBusinessMeta(bannerMetaList=" + this.bannerMetaList + ", rankUrl=" + this.rankUrl + ", aboardInfo=" + this.aboardInfo + ", taxDesc=" + this.taxDesc + ", skuMeta=" + this.skuMeta + ", isPreselected=" + this.isPreselected + ", termCount=" + this.termCount + ", like=" + this.like + ", collect=" + this.collect + ", share=" + this.share + ", windowUrl=" + this.windowUrl + ")";
    }

    public final String getAboardInfo() {
        return this.aboardInfo;
    }

    public final List<AnchorV4BannerMeta> getBannerMetaList() {
        return this.bannerMetaList;
    }

    public final CollectMeta getCollect() {
        return this.collect;
    }

    public final LikeMeta getLike() {
        return this.like;
    }

    public final String getRankUrl() {
        return this.rankUrl;
    }

    public final ShareMeta getShare() {
        return this.share;
    }

    public final SkuMeta getSkuMeta() {
        return this.skuMeta;
    }

    public final String getTaxDesc() {
        return this.taxDesc;
    }

    public final Integer getTermCount() {
        return this.termCount;
    }

    public final String getWindowUrl() {
        return this.windowUrl;
    }

    public final Boolean isPreselected() {
        return this.isPreselected;
    }

    public AnchorV4BaseInfoBusinessMeta(List<AnchorV4BannerMeta> r1, String r2, String r3, String r4, SkuMeta r5, Boolean r6, Integer r7, LikeMeta r8, CollectMeta r9, ShareMeta r10, String r11) {
        this.bannerMetaList = r1;
        this.rankUrl = r2;
        this.aboardInfo = r3;
        this.taxDesc = r4;
        this.skuMeta = r5;
        this.isPreselected = r6;
        this.termCount = r7;
        this.like = r8;
        this.collect = r9;
        this.share = r10;
        this.windowUrl = r11;
    }

    public /* synthetic */ AnchorV4BaseInfoBusinessMeta(List r13, String r14, String r15, String r16, SkuMeta r17, Boolean r18, Integer r19, LikeMeta r20, CollectMeta r21, ShareMeta r22, String r23, int r24, DefaultConstructorMarker r25) {
        String r2 = null;
        if ((r24 & 1) == 0) goto L5;
        List r1 = null;
    L7:
        if ((r24 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r24 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r24 & 8) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r24 & 16) == 0) goto L21;
        SkuMeta r6 = null;
    L23:
        if ((r24 & 32) == 0) goto L25;
        Boolean r7 = null;
    L27:
        if ((r24 & 64) == 0) goto L29;
        Integer r8 = null;
    L31:
        if ((r24 & 128) == 0) goto L33;
        LikeMeta r9 = null;
    L35:
        if ((r24 & 256) == 0) goto L37;
        CollectMeta r10 = null;
    L39:
        if ((r24 & 512) == 0) goto L41;
        ShareMeta r11 = null;
    L43:
        if ((r24 & 1024) != 0) goto L46;
        r2 = r23;
    L46:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r2);
        return;
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
        r1 = r13;
        goto L7
    }
}
