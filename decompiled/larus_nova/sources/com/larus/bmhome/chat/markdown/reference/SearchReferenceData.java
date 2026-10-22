package com.larus.bmhome.chat.markdown.reference;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.im.bean.message.Reference;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b#\b\u0087\b\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0011\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010(\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0010HÆ\u0003J\u0090\u0001\u0010-\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0010HÆ\u0001¢\u0006\u0002\u0010.J\u0013\u0010/\u001a\u00020\u00102\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u00020\nHÖ\u0001J\t\u00102\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001e\u0010\u001cR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0014R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0014R\u0016\u0010\u000f\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\"¨\u00063"}, d2 = {"Lcom/larus/bmhome/chat/markdown/reference/SearchReferenceData;", "", "title", "", "reference", "", "Lcom/larus/im/bean/message/Reference;", "queries", "searchLoadingText", "stage", "", "idx", "icon", "iconDark", "toolType", "isHeaderWrapContent", "", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getTitle", "()Ljava/lang/String;", com.alipay.sdk.m.x.d.f25925o, "(Ljava/lang/String;)V", "getReference", "()Ljava/util/List;", "getQueries", "getSearchLoadingText", "getStage", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getIdx", "getIcon", "getIconDark", "getToolType", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lcom/larus/bmhome/chat/markdown/reference/SearchReferenceData;", "equals", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchReferenceData {

    @SerializedName("icon")
    private final String icon;

    @SerializedName("icon_dark")
    private final String iconDark;

    @SerializedName("idx")
    private final Integer idx;

    @SerializedName("is_header_wrap_content")
    private final boolean isHeaderWrapContent;

    @SerializedName("queries")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<String> queries;

    @SerializedName("data")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<Reference> reference;

    @SerializedName("search_loading_text")
    private final String searchLoadingText;

    @SerializedName("stage")
    private final Integer stage;

    @SerializedName("title")
    private String title;

    @SerializedName("tool_type")
    private final String toolType;

    public SearchReferenceData() {
        this(null, null, null, null, null, null, null, null, null, false, 1023, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SearchReferenceData copy$default(SearchReferenceData r110, String r111, List r112, List r113, String r114, Integer r115, Integer r116, String r117, String r118, String r210, boolean r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        String r100 = r110.title;
    L7:
        if ((r212 & 2) == 0) goto L9;
        List r101 = r110.reference;
    L11:
        if ((r212 & 4) == 0) goto L13;
        List r102 = r110.queries;
    L15:
        if ((r212 & 8) == 0) goto L17;
        String r103 = r110.searchLoadingText;
    L19:
        if ((r212 & 16) == 0) goto L21;
        Integer r104 = r110.stage;
    L23:
        if ((r212 & 32) == 0) goto L25;
        Integer r105 = r110.idx;
    L27:
        if ((r212 & 64) == 0) goto L29;
        String r106 = r110.icon;
    L31:
        if ((r212 & 128) == 0) goto L33;
        String r107 = r110.iconDark;
    L35:
        if ((r212 & 256) == 0) goto L37;
        String r119 = r110.toolType;
    L39:
        if ((r212 & 512) == 0) goto L41;
        boolean r108 = r110.isHeaderWrapContent;
    L43:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r119, r108);
    L41:
        r108 = r211;
        goto L43
    L37:
        r119 = r210;
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

    public final boolean component10() {
        return this.isHeaderWrapContent;
    }

    public final List<Reference> component2() {
        return this.reference;
    }

    public final List<String> component3() {
        return this.queries;
    }

    public final String component4() {
        return this.searchLoadingText;
    }

    public final Integer component5() {
        return this.stage;
    }

    public final Integer component6() {
        return this.idx;
    }

    public final String component7() {
        return this.icon;
    }

    public final String component8() {
        return this.iconDark;
    }

    public final String component9() {
        return this.toolType;
    }

    public final SearchReferenceData copy(String r110, List<Reference> r111, List<String> r112, String r113, Integer r114, Integer r115, String r116, String r210, String r211, boolean r212) {
        return new SearchReferenceData(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SearchReferenceData) == true) goto L8;
        return false;
    L8:
        SearchReferenceData r101 = (SearchReferenceData) r100;
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.reference, r101.reference) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.queries, r101.queries) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.searchLoadingText, r101.searchLoadingText) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.stage, r101.stage) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.idx, r101.idx) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.iconDark, r101.iconDark) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.toolType, r101.toolType) == true) goto L36;
        return false;
    L36:
        if (this.isHeaderWrapContent == r101.isHeaderWrapContent) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        String r100 = this.title;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<Reference> r104 = this.reference;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<String> r107 = this.queries;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.searchLoadingText;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.stage;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.idx;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.icon;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.iconDark;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.toolType;
        if (r125 == null) goto L38;
        r101 = r125.hashCode();
    L38:
        int r126 = (r124 + r101) * 31;
        if (this.isHeaderWrapContent == false) goto L41;
        int r127 = 1231;
    L43:
        return r126 + r127;
    L41:
        r127 = 1237;
        goto L43
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
        return "SearchReferenceData(title=" + this.title + ", reference=" + this.reference + ", queries=" + this.queries + ", searchLoadingText=" + this.searchLoadingText + ", stage=" + this.stage + ", idx=" + this.idx + ", icon=" + this.icon + ", iconDark=" + this.iconDark + ", toolType=" + this.toolType + ", isHeaderWrapContent=" + this.isHeaderWrapContent + ')';
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getIconDark() {
        return this.iconDark;
    }

    public final Integer getIdx() {
        return this.idx;
    }

    public final List<String> getQueries() {
        return this.queries;
    }

    public final List<Reference> getReference() {
        return this.reference;
    }

    public final String getSearchLoadingText() {
        return this.searchLoadingText;
    }

    public final Integer getStage() {
        return this.stage;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getToolType() {
        return this.toolType;
    }

    public final boolean isHeaderWrapContent() {
        return this.isHeaderWrapContent;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }

    public SearchReferenceData(String r100, List<Reference> r101, List<String> r102, String r103, Integer r104, Integer r105, String r106, String r107, String r108, boolean r110) {
        this.title = r100;
        this.reference = r101;
        this.queries = r102;
        this.searchLoadingText = r103;
        this.stage = r104;
        this.idx = r105;
        this.icon = r106;
        this.iconDark = r107;
        this.toolType = r108;
        this.isHeaderWrapContent = r110;
    }

    public /* synthetic */ SearchReferenceData(String r110, List r111, List r112, String r113, Integer r114, Integer r115, String r116, String r117, String r210, boolean r211, int r212, DefaultConstructorMarker r213) {
        String r100 = null;
        if ((r212 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r212 & 2) == 0) goto L9;
        List r102 = null;
    L11:
        if ((r212 & 4) == 0) goto L13;
        List r103 = null;
    L15:
        if ((r212 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r212 & 16) == 0) goto L21;
        Integer r105 = -1;
    L23:
        if ((r212 & 32) == 0) goto L25;
        Integer r106 = -1;
    L27:
        if ((r212 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r212 & 128) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r212 & 256) != 0) goto L39;
        r100 = r210;
    L39:
        if ((r212 & 512) == 0) goto L41;
        boolean r109 = false;
    L42:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r100, r109);
        return;
    L41:
        r109 = r211;
        goto L42
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
