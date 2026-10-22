package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.SocialConstants;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B}\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u001c\u001a\u00020\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u0011\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u007f\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R$\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011¨\u0006."}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmFeatureDetail;", "Ljava/io/Serializable;", "title", "", "titlePart2", SocialConstants.PARAM_APP_DESC, "descPart2", "content", "", "buyBtnContent", "introLink", "dataTracking", "", "subscriptTag", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getTitlePart2", "getDesc", "getDescPart2", "getContent", "()Ljava/util/List;", "getBuyBtnContent", "getIntroLink", "getDataTracking", "()Ljava/util/Map;", "getSubscriptTag", "getReplaceTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "", "toString", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MmFeatureDetail implements Serializable {

    @SerializedName("buy_btn")
    private final String buyBtnContent;

    @SerializedName("content")
    private final List<String> content;

    @SerializedName("data_tracking")
    private final Map<String, String> dataTracking;

    @SerializedName(SocialConstants.PARAM_APP_DESC)
    private final String desc;

    @SerializedName("desc_part2")
    private final String descPart2;

    @SerializedName("intro_link")
    private final String introLink;

    @SerializedName("subscript")
    private final String subscriptTag;

    @SerializedName("title")
    private final String title;

    @SerializedName("title_part2")
    private final String titlePart2;

    public MmFeatureDetail() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MmFeatureDetail copy$default(MmFeatureDetail r110, String r111, String r112, String r113, String r114, List r115, String r116, String r117, Map r118, String r119, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        String r100 = r110.title;
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r101 = r110.titlePart2;
    L11:
        if ((r210 & 4) == 0) goto L13;
        String r102 = r110.desc;
    L15:
        if ((r210 & 8) == 0) goto L17;
        String r103 = r110.descPart2;
    L19:
        if ((r210 & 16) == 0) goto L21;
        List r104 = r110.content;
    L23:
        if ((r210 & 32) == 0) goto L25;
        String r105 = r110.buyBtnContent;
    L27:
        if ((r210 & 64) == 0) goto L29;
        String r106 = r110.introLink;
    L31:
        if ((r210 & 128) == 0) goto L33;
        Map r107 = r110.dataTracking;
    L35:
        if ((r210 & 256) == 0) goto L37;
        String r108 = r110.subscriptTag;
    L39:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    L37:
        r108 = r119;
        goto L39
    L33:
        r107 = r118;
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

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.titlePart2;
    }

    public final String component3() {
        return this.desc;
    }

    public final String component4() {
        return this.descPart2;
    }

    public final List<String> component5() {
        return this.content;
    }

    public final String component6() {
        return this.buyBtnContent;
    }

    public final String component7() {
        return this.introLink;
    }

    public final Map<String, String> component8() {
        return this.dataTracking;
    }

    public final String component9() {
        return this.subscriptTag;
    }

    public final MmFeatureDetail copy(String r110, String r111, String r112, String r113, List<String> r114, String r115, String r116, Map<String, String> r117, String r210) {
        Intrinsics.checkNotNullParameter(r110, "title");
        Intrinsics.checkNotNullParameter(r111, "titlePart2");
        Intrinsics.checkNotNullParameter(r112, SocialConstants.PARAM_APP_DESC);
        Intrinsics.checkNotNullParameter(r113, "descPart2");
        return new MmFeatureDetail(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MmFeatureDetail) == true) goto L8;
        return false;
    L8:
        MmFeatureDetail r101 = (MmFeatureDetail) r100;
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.titlePart2, r101.titlePart2) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.desc, r101.desc) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.descPart2, r101.descPart2) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.buyBtnContent, r101.buyBtnContent) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.introLink, r101.introLink) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.dataTracking, r101.dataTracking) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.subscriptTag, r101.subscriptTag) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        int r100 = ((((((this.title.hashCode() * 31) + this.titlePart2.hashCode()) * 31) + this.desc.hashCode()) * 31) + this.descPart2.hashCode()) * 31;
        List<String> r101 = this.content;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.buyBtnContent;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.introLink;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        Map<String, String> r111 = this.dataTracking;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.subscriptTag;
        if (r114 == null) goto L23;
        r102 = r114.hashCode();
    L23:
        return r113 + r102;
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
        return "MmFeatureDetail(title=" + this.title + ", titlePart2=" + this.titlePart2 + ", desc=" + this.desc + ", descPart2=" + this.descPart2 + ", content=" + this.content + ", buyBtnContent=" + this.buyBtnContent + ", introLink=" + this.introLink + ", dataTracking=" + this.dataTracking + ", subscriptTag=" + this.subscriptTag + ')';
    }

    public final String getReplaceTitle() {
        return StringsKt.replace$default(this.title, "\\n", "\n", false, 4, null);
    }

    public final String getBuyBtnContent() {
        return this.buyBtnContent;
    }

    public final List<String> getContent() {
        return this.content;
    }

    public final Map<String, String> getDataTracking() {
        return this.dataTracking;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getDescPart2() {
        return this.descPart2;
    }

    public final String getIntroLink() {
        return this.introLink;
    }

    public final String getSubscriptTag() {
        return this.subscriptTag;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getTitlePart2() {
        return this.titlePart2;
    }

    public MmFeatureDetail(String r100, String r101, String r102, String r103, List<String> r104, String r105, String r106, Map<String, String> r107, String r110) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r101, "titlePart2");
        Intrinsics.checkNotNullParameter(r102, SocialConstants.PARAM_APP_DESC);
        Intrinsics.checkNotNullParameter(r103, "descPart2");
        this.title = r100;
        this.titlePart2 = r101;
        this.desc = r102;
        this.descPart2 = r103;
        this.content = r104;
        this.buyBtnContent = r105;
        this.introLink = r106;
        this.dataTracking = r107;
        this.subscriptTag = r110;
    }

    public /* synthetic */ MmFeatureDetail(String r110, String r111, String r112, String r113, List r114, String r115, String r116, Map r117, String r118, int r210, DefaultConstructorMarker r211) {
        String r100 = "";
        if ((r210 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r210 & 4) == 0) goto L13;
        String r103 = "";
    L15:
        if ((r210 & 8) != 0) goto L18;
        r100 = r113;
    L18:
        String r104 = null;
        if ((r210 & 16) == 0) goto L21;
        List r105 = null;
    L23:
        if ((r210 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r210 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r210 & 128) == 0) goto L33;
        Map r108 = null;
    L35:
        if ((r210 & 256) != 0) goto L38;
        r104 = r118;
    L38:
        this(r101, r102, r103, r100, r105, r106, r107, r108, r104);
        return;
    L33:
        r108 = r117;
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
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
