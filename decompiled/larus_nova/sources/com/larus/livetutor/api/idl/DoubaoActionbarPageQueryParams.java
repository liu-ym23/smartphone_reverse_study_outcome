package com.larus.livetutor.api.idl;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0013\u0010 \u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001bJF\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020\u0003HÖ\u0001J\t\u0010*\u001a\u00020\bHÖ\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R(\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006+"}, d2 = {"Lcom/larus/livetutor/api/idl/DoubaoActionbarPageQueryParams;", "Ljava/io/Serializable;", "queryType", "", "images", "", "Lcom/larus/livetutor/api/idl/Image;", "userTextQuery", "", "fixedQueryId", "", "<init>", "(Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;Ljava/lang/Long;)V", "getQueryType", "()Ljava/lang/Integer;", "setQueryType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getImages", "()Ljava/util/List;", "setImages", "(Ljava/util/List;)V", "getUserTextQuery", "()Ljava/lang/String;", "setUserTextQuery", "(Ljava/lang/String;)V", "getFixedQueryId", "()Ljava/lang/Long;", "setFixedQueryId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;Ljava/lang/Long;)Lcom/larus/livetutor/api/idl/DoubaoActionbarPageQueryParams;", "equals", "", "other", "", "hashCode", "toString", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoubaoActionbarPageQueryParams implements Serializable {

    @SerializedName("fixed_query_id")
    private Long fixedQueryId;

    @SerializedName("images")
    private List<Image> images;

    @SerializedName("query_type")
    private Integer queryType;

    @SerializedName("user_text_query")
    private String userTextQuery;

    public DoubaoActionbarPageQueryParams() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DoubaoActionbarPageQueryParams copy$default(DoubaoActionbarPageQueryParams r100, Integer r101, List r102, String r103, Long r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.queryType;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.images;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.userTextQuery;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.fixedQueryId;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final Integer component1() {
        return this.queryType;
    }

    public final List<Image> component2() {
        return this.images;
    }

    public final String component3() {
        return this.userTextQuery;
    }

    public final Long component4() {
        return this.fixedQueryId;
    }

    public final DoubaoActionbarPageQueryParams copy(Integer r100, List<Image> r101, String r102, Long r103) {
        return new DoubaoActionbarPageQueryParams(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DoubaoActionbarPageQueryParams) == true) goto L8;
        return false;
    L8:
        DoubaoActionbarPageQueryParams r101 = (DoubaoActionbarPageQueryParams) r100;
        if (Intrinsics.areEqual(this.queryType, r101.queryType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.images, r101.images) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.userTextQuery, r101.userTextQuery) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.fixedQueryId, r101.fixedQueryId) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.queryType;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<Image> r104 = this.images;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.userTextQuery;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.fixedQueryId;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
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
        return "DoubaoActionbarPageQueryParams(queryType=" + this.queryType + ", images=" + this.images + ", userTextQuery=" + this.userTextQuery + ", fixedQueryId=" + this.fixedQueryId + ')';
    }

    public final Long getFixedQueryId() {
        return this.fixedQueryId;
    }

    public final List<Image> getImages() {
        return this.images;
    }

    public final Integer getQueryType() {
        return this.queryType;
    }

    public final String getUserTextQuery() {
        return this.userTextQuery;
    }

    public final void setFixedQueryId(Long r100) {
        this.fixedQueryId = r100;
    }

    public final void setImages(List<Image> r100) {
        this.images = r100;
    }

    public final void setQueryType(Integer r100) {
        this.queryType = r100;
    }

    public final void setUserTextQuery(String r100) {
        this.userTextQuery = r100;
    }

    public DoubaoActionbarPageQueryParams(Integer r100, List<Image> r101, String r102, Long r103) {
        this.queryType = r100;
        this.images = r101;
        this.userTextQuery = r102;
        this.fixedQueryId = r103;
    }

    public /* synthetic */ DoubaoActionbarPageQueryParams(Integer r100, List r101, String r102, Long r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
