package com.larus.livetutor.api.idl;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010)\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\fHÆ\u0003JV\u0010-\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010.J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u000102HÖ\u0003J\t\u00103\u001a\u00020\u0005HÖ\u0001J\t\u00104\u001a\u00020\tHÖ\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR \u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R \u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001e\"\u0004\b\"\u0010 R \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u00065"}, d2 = {"Lcom/larus/livetutor/api/idl/FixedQuery;", "Ljava/io/Serializable;", "queryId", "", "grade", "", "cover", "Lcom/larus/livetutor/api/idl/Image;", "categoryTag", "", "queryText", "queryType", "Lcom/larus/livetutor/api/idl/QueryType;", "<init>", "(Ljava/lang/Long;Ljava/lang/Integer;Lcom/larus/livetutor/api/idl/Image;Ljava/lang/String;Ljava/lang/String;Lcom/larus/livetutor/api/idl/QueryType;)V", "getQueryId", "()Ljava/lang/Long;", "setQueryId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getGrade", "()Ljava/lang/Integer;", "setGrade", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getCover", "()Lcom/larus/livetutor/api/idl/Image;", "setCover", "(Lcom/larus/livetutor/api/idl/Image;)V", "getCategoryTag", "()Ljava/lang/String;", "setCategoryTag", "(Ljava/lang/String;)V", "getQueryText", "setQueryText", "getQueryType", "()Lcom/larus/livetutor/api/idl/QueryType;", "setQueryType", "(Lcom/larus/livetutor/api/idl/QueryType;)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Long;Ljava/lang/Integer;Lcom/larus/livetutor/api/idl/Image;Ljava/lang/String;Ljava/lang/String;Lcom/larus/livetutor/api/idl/QueryType;)Lcom/larus/livetutor/api/idl/FixedQuery;", "equals", "", "other", "", "hashCode", "toString", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FixedQuery implements Serializable {

    @SerializedName("category_tag")
    private String categoryTag;

    @SerializedName("cover")
    private Image cover;

    @SerializedName("grade")
    private Integer grade;

    @SerializedName("query_id")
    private Long queryId;

    @SerializedName("query_text")
    private String queryText;

    @SerializedName("query_type")
    private QueryType queryType;

    public FixedQuery() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ FixedQuery copy$default(FixedQuery r100, Long r101, Integer r102, Image r103, String r104, String r105, QueryType r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.queryId;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.grade;
    L8:
        Integer r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.cover;
    L11:
        Image r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.categoryTag;
    L14:
        String r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.queryText;
    L17:
        String r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.queryType;
    L20:
        Long r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final Long component1() {
        return this.queryId;
    }

    public final Integer component2() {
        return this.grade;
    }

    public final Image component3() {
        return this.cover;
    }

    public final String component4() {
        return this.categoryTag;
    }

    public final String component5() {
        return this.queryText;
    }

    public final QueryType component6() {
        return this.queryType;
    }

    public final FixedQuery copy(Long r100, Integer r110, Image r111, String r112, String r113, QueryType r114) {
        return new FixedQuery(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FixedQuery) == true) goto L8;
        return false;
    L8:
        FixedQuery r101 = (FixedQuery) r100;
        if (Intrinsics.areEqual(this.queryId, r101.queryId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.grade, r101.grade) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.cover, r101.cover) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.categoryTag, r101.categoryTag) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.queryText, r101.queryText) == true) goto L24;
        return false;
    L24:
        if (this.queryType == r101.queryType) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        Long r100 = this.queryId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.grade;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Image r107 = this.cover;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.categoryTag;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.queryText;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        QueryType r116 = this.queryType;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
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
        return "FixedQuery(queryId=" + this.queryId + ", grade=" + this.grade + ", cover=" + this.cover + ", categoryTag=" + this.categoryTag + ", queryText=" + this.queryText + ", queryType=" + this.queryType + ')';
    }

    public final String getCategoryTag() {
        return this.categoryTag;
    }

    public final Image getCover() {
        return this.cover;
    }

    public final Integer getGrade() {
        return this.grade;
    }

    public final Long getQueryId() {
        return this.queryId;
    }

    public final String getQueryText() {
        return this.queryText;
    }

    public final QueryType getQueryType() {
        return this.queryType;
    }

    public final void setCategoryTag(String r100) {
        this.categoryTag = r100;
    }

    public final void setCover(Image r100) {
        this.cover = r100;
    }

    public final void setGrade(Integer r100) {
        this.grade = r100;
    }

    public final void setQueryId(Long r100) {
        this.queryId = r100;
    }

    public final void setQueryText(String r100) {
        this.queryText = r100;
    }

    public final void setQueryType(QueryType r100) {
        this.queryType = r100;
    }

    public FixedQuery(Long r100, Integer r101, Image r102, String r103, String r104, QueryType r105) {
        this.queryId = r100;
        this.grade = r101;
        this.cover = r102;
        this.categoryTag = r103;
        this.queryText = r104;
        this.queryType = r105;
    }

    public /* synthetic */ FixedQuery(Long r100, Integer r101, Image r102, String r103, String r110, QueryType r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        Long r114 = null;
    L7:
        if ((r112 & 2) == 0) goto L9;
        Integer r104 = null;
    L11:
        if ((r112 & 4) == 0) goto L13;
        Image r105 = null;
    L15:
        if ((r112 & 8) == 0) goto L17;
        String r106 = null;
    L19:
        if ((r112 & 16) == 0) goto L21;
        String r107 = null;
    L23:
        if ((r112 & 32) == 0) goto L25;
        QueryType r115 = null;
    L26:
        this(r114, r104, r105, r106, r107, r115);
        return;
    L25:
        r115 = r111;
        goto L26
    L21:
        r107 = r110;
        goto L23
    L17:
        r106 = r103;
        goto L19
    L13:
        r105 = r102;
        goto L15
    L9:
        r104 = r101;
        goto L11
    L5:
        r114 = r100;
        goto L7
    }
}
