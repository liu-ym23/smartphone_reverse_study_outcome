package com.bytedance.locallife.model.poi.resp;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.poi.model.PoiImageUrlModel;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b0\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B¿\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\r\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00101\u001a\u00020\rHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00108\u001a\u00020\u000bHÆ\u0003J\t\u00109\u001a\u00020\rHÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003JÃ\u0001\u0010;\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0014\u001a\u00020\r2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010<\u001a\u00020\u000b2\b\u0010=\u001a\u0004\u0018\u00010>HÖ\u0003J\t\u0010?\u001a\u00020\rHÖ\u0001J\t\u0010@\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0014\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001eR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001aR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001aR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001aR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001aR\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0018R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*¨\u0006A"}, d2 = {"Lcom/bytedance/locallife/model/poi/resp/QAInfo;", "Ljava/io/Serializable;", "redirectUrl", "", "qaCount", "fullPromptText", "shortPromptText", "iconUrl", "Lcom/ss/android/ugc/aweme/poi/model/PoiImageUrlModel;", "footerPromptText", "ugcEmtpy", "", "showEmptyRateCard", "", "headerModuleTitle", "schemaUrl", "schemaContent", "rateImg", "rateContent", "nextRateContent", "folded", "mobParams", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/ugc/aweme/poi/model/PoiImageUrlModel;Ljava/lang/String;ZILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/ugc/aweme/poi/model/PoiImageUrlModel;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getFolded", "()I", "getFooterPromptText", "()Ljava/lang/String;", "getFullPromptText", "getHeaderModuleTitle", "getIconUrl", "()Lcom/ss/android/ugc/aweme/poi/model/PoiImageUrlModel;", "getMobParams", "getNextRateContent", "getQaCount", "getRateContent", "getRateImg", "getRedirectUrl", "getSchemaContent", "getSchemaUrl", "getShortPromptText", "getShowEmptyRateCard", "getUgcEmtpy", "()Z", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "toString", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class QAInfo implements Serializable {

    @SerializedName("show_load_more_top_right")
    private final int folded;

    @SerializedName("footer_prompt_text")
    private final String footerPromptText;

    @SerializedName("full_prompt_text")
    private final String fullPromptText;

    @SerializedName("header_module_title")
    private final String headerModuleTitle;

    @SerializedName("icon_url")
    private final PoiImageUrlModel iconUrl;

    @SerializedName("mob_params")
    private final String mobParams;

    @SerializedName("next_rate_content")
    private final String nextRateContent;

    @SerializedName("qa_discussion_count_text")
    private final String qaCount;

    @SerializedName("rate_content")
    private final String rateContent;

    @SerializedName("rate_img")
    private final PoiImageUrlModel rateImg;

    @SerializedName("qa_page_redirect_url")
    private final String redirectUrl;

    @SerializedName("schema_content")
    private final String schemaContent;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SCHEMA_URL)
    private final String schemaUrl;

    @SerializedName("short_prompt_text")
    private final String shortPromptText;

    @SerializedName("show_empty_rate_card")
    private final int showEmptyRateCard;

    @SerializedName("ugc_empty")
    private final boolean ugcEmtpy;

    public QAInfo() {
        this(null, null, null, null, null, null, false, 0, null, null, null, null, null, null, 0, null, 65535, null);
    }

    public static /* synthetic */ QAInfo copy$default(QAInfo r110, String r111, String r112, String r210, String r211, PoiImageUrlModel r212, String r213, boolean r214, int r215, String r216, String r217, String r218, PoiImageUrlModel r219, String r310, String r311, int r312, String r313, int r314, Object r315) {
        if ((r314 & 1) == 0) goto L5;
        String r100 = r110.redirectUrl;
    L7:
        if ((r314 & 2) == 0) goto L9;
        String r101 = r110.qaCount;
    L11:
        if ((r314 & 4) == 0) goto L13;
        String r102 = r110.fullPromptText;
    L15:
        if ((r314 & 8) == 0) goto L17;
        String r103 = r110.shortPromptText;
    L19:
        if ((r314 & 16) == 0) goto L21;
        PoiImageUrlModel r104 = r110.iconUrl;
    L23:
        if ((r314 & 32) == 0) goto L25;
        String r105 = r110.footerPromptText;
    L27:
        if ((r314 & 64) == 0) goto L29;
        boolean r106 = r110.ugcEmtpy;
    L31:
        if ((r314 & 128) == 0) goto L33;
        int r107 = r110.showEmptyRateCard;
    L35:
        if ((r314 & 256) == 0) goto L37;
        String r113 = r110.headerModuleTitle;
    L39:
        if ((r314 & 512) == 0) goto L41;
        String r114 = r110.schemaUrl;
    L43:
        if ((r314 & 1024) == 0) goto L45;
        String r115 = r110.schemaContent;
    L47:
        if ((r314 & 2048) == 0) goto L49;
        PoiImageUrlModel r116 = r110.rateImg;
    L51:
        if ((r314 & 4096) == 0) goto L53;
        String r117 = r110.rateContent;
    L55:
        if ((r314 & 8192) == 0) goto L57;
        String r118 = r110.nextRateContent;
    L58:
        String r316 = r118;
        if ((r314 & 16384) == 0) goto L61;
        int r119 = r110.folded;
    L63:
        if ((r314 & 32768) == 0) goto L65;
        String r108 = r110.mobParams;
    L67:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r316, r119, r108);
    L65:
        r108 = r313;
        goto L67
    L61:
        r119 = r312;
        goto L63
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
        return this.redirectUrl;
    }

    public final String component10() {
        return this.schemaUrl;
    }

    public final String component11() {
        return this.schemaContent;
    }

    public final PoiImageUrlModel component12() {
        return this.rateImg;
    }

    public final String component13() {
        return this.rateContent;
    }

    public final String component14() {
        return this.nextRateContent;
    }

    public final int component15() {
        return this.folded;
    }

    public final String component16() {
        return this.mobParams;
    }

    public final String component2() {
        return this.qaCount;
    }

    public final String component3() {
        return this.fullPromptText;
    }

    public final String component4() {
        return this.shortPromptText;
    }

    public final PoiImageUrlModel component5() {
        return this.iconUrl;
    }

    public final String component6() {
        return this.footerPromptText;
    }

    public final boolean component7() {
        return this.ugcEmtpy;
    }

    public final int component8() {
        return this.showEmptyRateCard;
    }

    public final String component9() {
        return this.headerModuleTitle;
    }

    public final QAInfo copy(String r110, String r210, String r211, String r212, PoiImageUrlModel r213, String r214, boolean r215, int r216, String r217, String r218, String r219, PoiImageUrlModel r310, String r311, String r312, int r313, String r314) {
        return new QAInfo(r110, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof QAInfo) == true) goto L8;
        return false;
    L8:
        QAInfo r101 = (QAInfo) r100;
        if (Intrinsics.areEqual(this.redirectUrl, r101.redirectUrl) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.qaCount, r101.qaCount) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.fullPromptText, r101.fullPromptText) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.shortPromptText, r101.shortPromptText) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.iconUrl, r101.iconUrl) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.footerPromptText, r101.footerPromptText) == true) goto L27;
        return false;
    L27:
        if (this.ugcEmtpy == r101.ugcEmtpy) goto L30;
        return false;
    L30:
        if (this.showEmptyRateCard == r101.showEmptyRateCard) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.headerModuleTitle, r101.headerModuleTitle) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.schemaUrl, r101.schemaUrl) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.schemaContent, r101.schemaContent) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.rateImg, r101.rateImg) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.rateContent, r101.rateContent) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.nextRateContent, r101.nextRateContent) == true) goto L51;
        return false;
    L51:
        if (this.folded == r101.folded) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.mobParams, r101.mobParams) == true) goto L56;
        return false;
    L56:
        return true;
    }

    public int hashCode() {
        String r100 = this.redirectUrl;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.qaCount;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.fullPromptText;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.shortPromptText;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        PoiImageUrlModel r113 = this.iconUrl;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.footerPromptText;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        if (this.ugcEmtpy == false) goto L29;
        int r119 = 1231;
    L30:
        int r120 = (((r118 + r119) * 31) + this.showEmptyRateCard) * 31;
        String r121 = this.headerModuleTitle;
        if (r121 != null) goto L33;
        int r122 = 0;
    L34:
        int r123 = (r120 + r122) * 31;
        String r124 = this.schemaUrl;
        if (r124 != null) goto L37;
        int r125 = 0;
    L38:
        int r126 = (r123 + r125) * 31;
        String r127 = this.schemaContent;
        if (r127 != null) goto L41;
        int r128 = 0;
    L42:
        int r129 = (r126 + r128) * 31;
        PoiImageUrlModel r130 = this.rateImg;
        if (r130 != null) goto L45;
        int r131 = 0;
    L46:
        int r132 = (r129 + r131) * 31;
        String r133 = this.rateContent;
        if (r133 != null) goto L49;
        int r134 = 0;
    L50:
        int r135 = (r132 + r134) * 31;
        String r136 = this.nextRateContent;
        if (r136 != null) goto L53;
        int r137 = 0;
    L54:
        int r138 = (((r135 + r137) * 31) + this.folded) * 31;
        String r139 = this.mobParams;
        if (r139 == null) goto L59;
        r101 = r139.hashCode();
    L59:
        return r138 + r101;
    L53:
        r137 = r136.hashCode();
        goto L54
    L49:
        r134 = r133.hashCode();
        goto L50
    L45:
        r131 = r130.hashCode();
        goto L46
    L41:
        r128 = r127.hashCode();
        goto L42
    L37:
        r125 = r124.hashCode();
        goto L38
    L33:
        r122 = r121.hashCode();
        goto L34
    L29:
        r119 = 1237;
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
        return "QAInfo(redirectUrl=" + this.redirectUrl + ", qaCount=" + this.qaCount + ", fullPromptText=" + this.fullPromptText + ", shortPromptText=" + this.shortPromptText + ", iconUrl=" + this.iconUrl + ", footerPromptText=" + this.footerPromptText + ", ugcEmtpy=" + this.ugcEmtpy + ", showEmptyRateCard=" + this.showEmptyRateCard + ", headerModuleTitle=" + this.headerModuleTitle + ", schemaUrl=" + this.schemaUrl + ", schemaContent=" + this.schemaContent + ", rateImg=" + this.rateImg + ", rateContent=" + this.rateContent + ", nextRateContent=" + this.nextRateContent + ", folded=" + this.folded + ", mobParams=" + this.mobParams + ')';
    }

    public final int getFolded() {
        return this.folded;
    }

    public final String getFooterPromptText() {
        return this.footerPromptText;
    }

    public final String getFullPromptText() {
        return this.fullPromptText;
    }

    public final String getHeaderModuleTitle() {
        return this.headerModuleTitle;
    }

    public final PoiImageUrlModel getIconUrl() {
        return this.iconUrl;
    }

    public final String getMobParams() {
        return this.mobParams;
    }

    public final String getNextRateContent() {
        return this.nextRateContent;
    }

    public final String getQaCount() {
        return this.qaCount;
    }

    public final String getRateContent() {
        return this.rateContent;
    }

    public final PoiImageUrlModel getRateImg() {
        return this.rateImg;
    }

    public final String getRedirectUrl() {
        return this.redirectUrl;
    }

    public final String getSchemaContent() {
        return this.schemaContent;
    }

    public final String getSchemaUrl() {
        return this.schemaUrl;
    }

    public final String getShortPromptText() {
        return this.shortPromptText;
    }

    public final int getShowEmptyRateCard() {
        return this.showEmptyRateCard;
    }

    public final boolean getUgcEmtpy() {
        return this.ugcEmtpy;
    }

    public QAInfo(String r100, String r101, String r102, String r103, PoiImageUrlModel r104, String r105, boolean r106, int r110, String r111, String r112, String r113, PoiImageUrlModel r114, String r115, String r116, int r117, String r118) {
        this.redirectUrl = r100;
        this.qaCount = r101;
        this.fullPromptText = r102;
        this.shortPromptText = r103;
        this.iconUrl = r104;
        this.footerPromptText = r105;
        this.ugcEmtpy = r106;
        this.showEmptyRateCard = r110;
        this.headerModuleTitle = r111;
        this.schemaUrl = r112;
        this.schemaContent = r113;
        this.rateImg = r114;
        this.rateContent = r115;
        this.nextRateContent = r116;
        this.folded = r117;
        this.mobParams = r118;
    }

    public /* synthetic */ QAInfo(String r110, String r111, String r210, String r211, PoiImageUrlModel r212, String r213, boolean r214, int r215, String r216, String r217, String r218, PoiImageUrlModel r219, String r310, String r311, int r312, String r313, int r314, DefaultConstructorMarker r315) {
        String r100 = "";
        if ((r314 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r314 & 2) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r314 & 4) == 0) goto L13;
        String r103 = "";
    L15:
        if ((r314 & 8) == 0) goto L17;
        String r104 = "";
    L19:
        if ((r314 & 16) == 0) goto L21;
        PoiImageUrlModel r105 = null;
    L23:
        if ((r314 & 32) != 0) goto L27;
        r100 = r213;
    L27:
        if ((r314 & 64) == 0) goto L29;
        boolean r106 = false;
    L31:
        if ((r314 & 128) == 0) goto L33;
        int r112 = 0;
    L35:
        if ((r314 & 256) == 0) goto L37;
        String r113 = null;
    L39:
        if ((r314 & 512) == 0) goto L41;
        String r114 = null;
    L43:
        if ((r314 & 1024) == 0) goto L45;
        String r115 = null;
    L47:
        if ((r314 & 2048) == 0) goto L49;
        PoiImageUrlModel r116 = null;
    L51:
        if ((r314 & 4096) == 0) goto L53;
        String r117 = null;
    L55:
        if ((r314 & 8192) == 0) goto L57;
        String r107 = null;
    L59:
        if ((r314 & 16384) == 0) goto L61;
        int r108 = 0;
    L63:
        if ((r314 & 32768) == 0) goto L65;
        String r109 = null;
    L66:
        this(r101, r102, r103, r104, r105, r100, r106, r112, r113, r114, r115, r116, r117, r107, r108, r109);
        return;
    L65:
        r109 = r313;
        goto L66
    L61:
        r108 = r312;
        goto L63
    L57:
        r107 = r311;
        goto L59
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
        r112 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L21:
        r105 = r212;
        goto L23
    L17:
        r104 = r211;
        goto L19
    L13:
        r103 = r210;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
