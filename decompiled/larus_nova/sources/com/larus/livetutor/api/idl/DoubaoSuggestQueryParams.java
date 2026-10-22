package com.larus.livetutor.api.idl;

import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001BK\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0013\u0010#\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010&\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001cJR\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010(J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020\u0003HÖ\u0001J\t\u0010.\u001a\u00020\bHÖ\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R(\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001e¨\u0006/"}, d2 = {"Lcom/larus/livetutor/api/idl/DoubaoSuggestQueryParams;", "Ljava/io/Serializable;", "queryType", "", "images", "", "Lcom/larus/livetutor/api/idl/Image;", "userTextQuery", "", "fixedQueryId", "", RemoteMessageConst.MSGID, "<init>", "(Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)V", "getQueryType", "()Ljava/lang/Integer;", "setQueryType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getImages", "()Ljava/util/List;", "setImages", "(Ljava/util/List;)V", "getUserTextQuery", "()Ljava/lang/String;", "setUserTextQuery", "(Ljava/lang/String;)V", "getFixedQueryId", "()Ljava/lang/Long;", "setFixedQueryId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getMsgId", "setMsgId", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)Lcom/larus/livetutor/api/idl/DoubaoSuggestQueryParams;", "equals", "", "other", "", "hashCode", "toString", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoubaoSuggestQueryParams implements Serializable {

    @SerializedName("fixed_query_id")
    private Long fixedQueryId;

    @SerializedName("images")
    private List<Image> images;

    @SerializedName("msg_id")
    private Long msgId;

    @SerializedName("query_type")
    private Integer queryType;

    @SerializedName("user_text_query")
    private String userTextQuery;

    public DoubaoSuggestQueryParams() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DoubaoSuggestQueryParams copy$default(DoubaoSuggestQueryParams r100, Integer r101, List r102, String r103, Long r104, Long r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.queryType;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.images;
    L8:
        List r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.userTextQuery;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.fixedQueryId;
    L14:
        Long r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.msgId;
    L17:
        Integer r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
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

    public final Long component5() {
        return this.msgId;
    }

    public final DoubaoSuggestQueryParams copy(Integer r100, List<Image> r101, String r110, Long r111, Long r112) {
        return new DoubaoSuggestQueryParams(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DoubaoSuggestQueryParams) == true) goto L8;
        return false;
    L8:
        DoubaoSuggestQueryParams r101 = (DoubaoSuggestQueryParams) r100;
        if (Intrinsics.areEqual(this.queryType, r101.queryType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.images, r101.images) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.userTextQuery, r101.userTextQuery) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.fixedQueryId, r101.fixedQueryId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.msgId, r101.msgId) == true) goto L23;
        return false;
    L23:
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
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Long r113 = this.msgId;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
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
        return "DoubaoSuggestQueryParams(queryType=" + this.queryType + ", images=" + this.images + ", userTextQuery=" + this.userTextQuery + ", fixedQueryId=" + this.fixedQueryId + ", msgId=" + this.msgId + ')';
    }

    public final Long getFixedQueryId() {
        return this.fixedQueryId;
    }

    public final List<Image> getImages() {
        return this.images;
    }

    public final Long getMsgId() {
        return this.msgId;
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

    public final void setMsgId(Long r100) {
        this.msgId = r100;
    }

    public final void setQueryType(Integer r100) {
        this.queryType = r100;
    }

    public final void setUserTextQuery(String r100) {
        this.userTextQuery = r100;
    }

    public DoubaoSuggestQueryParams(Integer r100, List<Image> r101, String r102, Long r103, Long r104) {
        this.queryType = r100;
        this.images = r101;
        this.userTextQuery = r102;
        this.fixedQueryId = r103;
        this.msgId = r104;
    }

    public /* synthetic */ DoubaoSuggestQueryParams(Integer r100, List r101, String r102, Long r103, Long r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        Integer r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        List r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        String r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        Long r107 = null;
    L19:
        if ((r110 & 16) == 0) goto L21;
        Long r113 = null;
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
