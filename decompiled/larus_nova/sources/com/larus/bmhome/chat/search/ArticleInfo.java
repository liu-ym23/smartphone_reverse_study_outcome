package com.larus.bmhome.chat.search;

import com.google.gson.annotations.SerializedName;
import com.larus.im.bean.message.ItemData;
import com.larus.im.bean.message.ItemType;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0097\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\n\u0010!\u001a\u0004\u0018\u00010\u0003H\u0016J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010.\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u009e\u0001\u00102\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00103J\u0013\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u000107HÖ\u0003J\t\u00108\u001a\u00020\fHÖ\u0001J\t\u00109\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0013R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0013R\u0014\u0010\"\u001a\u00020#X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%¨\u0006:"}, d2 = {"Lcom/larus/bmhome/chat/search/ArticleInfo;", "Lcom/larus/im/bean/message/ItemData;", "cardId", "", "summary", "title", "siteName", RuleConditionBean.OPEN_URL_KEY, "iconUrl", "docId", "imageUrl", "sourceFrom", "", "sourceId", "sourceForBaike", "searchId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCardId", "()Ljava/lang/String;", "getSummary", "getTitle", "getSiteName", "getOpenUrl", "getIconUrl", "getDocId", "getImageUrl", "getSourceFrom", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSourceId", "getSourceForBaike", "getSearchId", "getId", "searchItemType", "Lcom/larus/im/bean/message/ItemType;", "getSearchItemType", "()Lcom/larus/im/bean/message/ItemType;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/bmhome/chat/search/ArticleInfo;", "equals", "", "other", "", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ArticleInfo extends ItemData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient ItemType f308596a;

    @SerializedName("id")
    private final String cardId;

    @SerializedName("doc_id")
    private final String docId;

    @SerializedName("logo_url")
    private final String iconUrl;

    @SerializedName("image_url")
    private final String imageUrl;

    @SerializedName("url")
    private final String openUrl;

    @SerializedName("search_id")
    private final String searchId;

    @SerializedName("sitename")
    private final String siteName;

    @SerializedName("source_for_baike")
    private final String sourceForBaike;

    @SerializedName("source_from")
    private final Integer sourceFrom;

    @SerializedName("source_id")
    private final String sourceId;

    @SerializedName("summary")
    private final String summary;

    @SerializedName("title")
    private final String title;

    public ArticleInfo() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, UnixStat.PERM_MASK, null);
    }

    public static /* synthetic */ ArticleInfo copy$default(ArticleInfo r110, String r111, String r112, String r113, String r114, String r115, String r116, String r210, String r211, Integer r212, String r213, String r214, String r215, int r216, Object r217) {
        if ((r216 & 1) == 0) goto L5;
        String r100 = r110.cardId;
    L7:
        if ((r216 & 2) == 0) goto L9;
        String r101 = r110.summary;
    L11:
        if ((r216 & 4) == 0) goto L13;
        String r102 = r110.title;
    L15:
        if ((r216 & 8) == 0) goto L17;
        String r103 = r110.siteName;
    L19:
        if ((r216 & 16) == 0) goto L21;
        String r104 = r110.openUrl;
    L23:
        if ((r216 & 32) == 0) goto L25;
        String r105 = r110.iconUrl;
    L27:
        if ((r216 & 64) == 0) goto L29;
        String r106 = r110.docId;
    L31:
        if ((r216 & 128) == 0) goto L33;
        String r107 = r110.imageUrl;
    L35:
        if ((r216 & 256) == 0) goto L37;
        Integer r117 = r110.sourceFrom;
    L39:
        if ((r216 & 512) == 0) goto L41;
        String r118 = r110.sourceId;
    L43:
        if ((r216 & 1024) == 0) goto L45;
        String r119 = r110.sourceForBaike;
    L47:
        if ((r216 & 2048) == 0) goto L49;
        String r108 = r110.searchId;
    L51:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r117, r118, r119, r108);
    L49:
        r108 = r215;
        goto L51
    L45:
        r119 = r214;
        goto L47
    L41:
        r118 = r213;
        goto L43
    L37:
        r117 = r212;
        goto L39
    L33:
        r107 = r211;
        goto L35
    L29:
        r106 = r210;
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
        return this.cardId;
    }

    public final String component10() {
        return this.sourceId;
    }

    public final String component11() {
        return this.sourceForBaike;
    }

    public final String component12() {
        return this.searchId;
    }

    public final String component2() {
        return this.summary;
    }

    public final String component3() {
        return this.title;
    }

    public final String component4() {
        return this.siteName;
    }

    public final String component5() {
        return this.openUrl;
    }

    public final String component6() {
        return this.iconUrl;
    }

    public final String component7() {
        return this.docId;
    }

    public final String component8() {
        return this.imageUrl;
    }

    public final Integer component9() {
        return this.sourceFrom;
    }

    public final ArticleInfo copy(String r110, String r111, String r112, String r113, String r114, String r210, String r211, String r212, Integer r213, String r214, String r215, String r216) {
        return new ArticleInfo(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215, r216);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ArticleInfo) == true) goto L8;
        return false;
    L8:
        ArticleInfo r101 = (ArticleInfo) r100;
        if (Intrinsics.areEqual(this.cardId, r101.cardId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.summary, r101.summary) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.siteName, r101.siteName) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.openUrl, r101.openUrl) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.iconUrl, r101.iconUrl) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.docId, r101.docId) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.imageUrl, r101.imageUrl) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.sourceFrom, r101.sourceFrom) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.sourceId, r101.sourceId) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.sourceForBaike, r101.sourceForBaike) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.searchId, r101.searchId) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public int hashCode() {
        String r100 = this.cardId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.summary;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.title;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.siteName;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.openUrl;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.iconUrl;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.docId;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.imageUrl;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Integer r125 = this.sourceFrom;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.sourceId;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.sourceForBaike;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.searchId;
        if (r134 == null) goto L51;
        r101 = r134.hashCode();
    L51:
        return r133 + r101;
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
        return "ArticleInfo(cardId=" + this.cardId + ", summary=" + this.summary + ", title=" + this.title + ", siteName=" + this.siteName + ", openUrl=" + this.openUrl + ", iconUrl=" + this.iconUrl + ", docId=" + this.docId + ", imageUrl=" + this.imageUrl + ", sourceFrom=" + this.sourceFrom + ", sourceId=" + this.sourceId + ", sourceForBaike=" + this.sourceForBaike + ", searchId=" + this.searchId + ')';
    }

    public final String getCardId() {
        return this.cardId;
    }

    public final String getDocId() {
        return this.docId;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    @Override // com.larus.im.bean.message.ItemData
    public String getId() {
        return this.docId;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final String getOpenUrl() {
        return this.openUrl;
    }

    @Override // com.larus.im.bean.message.ItemData
    public String getSearchId() {
        return this.searchId;
    }

    @Override // com.larus.im.bean.message.ItemData
    public ItemType getSearchItemType() {
        return this.f308596a;
    }

    public final String getSiteName() {
        return this.siteName;
    }

    public final String getSourceForBaike() {
        return this.sourceForBaike;
    }

    public final Integer getSourceFrom() {
        return this.sourceFrom;
    }

    public final String getSourceId() {
        return this.sourceId;
    }

    public final String getSummary() {
        return this.summary;
    }

    public final String getTitle() {
        return this.title;
    }

    public ArticleInfo(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, Integer r108, String r110, String r111, String r112) {
        this.cardId = r100;
        this.summary = r101;
        this.title = r102;
        this.siteName = r103;
        this.openUrl = r104;
        this.iconUrl = r105;
        this.docId = r106;
        this.imageUrl = r107;
        this.sourceFrom = r108;
        this.sourceId = r110;
        this.sourceForBaike = r111;
        this.searchId = r112;
        this.f308596a = ItemType.TYPE_CARD_IMAGE_TEXT;
    }

    public /* synthetic */ ArticleInfo(String r110, String r111, String r112, String r113, String r114, String r115, String r210, String r211, Integer r212, String r213, String r214, String r215, int r216, DefaultConstructorMarker r217) {
        String r100 = null;
        if ((r216 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r216 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r216 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r216 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r216 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r216 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r216 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r216 & 128) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r216 & 256) == 0) goto L37;
        Integer r116 = null;
    L39:
        if ((r216 & 512) == 0) goto L41;
        String r117 = null;
    L43:
        if ((r216 & 1024) == 0) goto L45;
        String r118 = null;
    L47:
        if ((r216 & 2048) != 0) goto L50;
        r100 = r215;
    L50:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r116, r117, r118, r100);
        return;
    L45:
        r118 = r214;
        goto L47
    L41:
        r117 = r213;
        goto L43
    L37:
        r116 = r212;
        goto L39
    L33:
        r108 = r211;
        goto L35
    L29:
        r107 = r210;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
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
