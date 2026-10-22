package com.bytedance.locallife.groupon.struct;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR$\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/j;", "", "", "cardType", "Ljava/lang/Integer;", "getCardType", "()Ljava/lang/Integer;", "setCardType", "(Ljava/lang/Integer;)V", "", "initData", "Ljava/lang/String;", "getInitData", "()Ljava/lang/String;", "setInitData", "(Ljava/lang/String;)V", "schema", "getSchema", "setSchema", "id", "getId", "setId", "type", "getType", "setType", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final class j {

    @SerializedName("cardType")
    private Integer cardType;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private String f258844id;

    @SerializedName("initData")
    private String initData;

    @SerializedName("schema")
    private String schema;

    @SerializedName("type")
    private String type;

    public j() {
        this.cardType = -1;
        this.initData = null;
        this.schema = null;
        this.f258844id = null;
        this.type = null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.cardType, r101.cardType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.initData, r101.initData) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.schema, r101.schema) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f258844id, r101.f258844id) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.cardType;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.initData;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.schema;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f258844id;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.type;
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

    public final String toString() {
        return "UpdateDataStruct(cardType=" + this.cardType + ", initData=" + this.initData + ", schema=" + this.schema + ", id=" + this.f258844id + ", type=" + this.type + ')';
    }

    public final String getType() {
        return this.type;
    }
}
