package com.bytedance.locallife.model.poi.resp;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J+\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/locallife/model/poi/resp/PoiCommonEntryStruct;", "Ljava/io/Serializable;", "schemaType", "", "schemaUrl", "", "title", "(ILjava/lang/String;Ljava/lang/String;)V", "getSchemaType", "()I", "getSchemaUrl", "()Ljava/lang/String;", "getTitle", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class PoiCommonEntryStruct implements Serializable {

    @SerializedName("schema_type")
    private final int schemaType;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SCHEMA_URL)
    private final String schemaUrl;

    @SerializedName("title")
    private final String title;

    public PoiCommonEntryStruct() {
        this(0, null, null, 7, null);
    }

    public static /* synthetic */ PoiCommonEntryStruct copy$default(PoiCommonEntryStruct r100, int r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.schemaType;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.schemaUrl;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.title;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final int component1() {
        return this.schemaType;
    }

    public final String component2() {
        return this.schemaUrl;
    }

    public final String component3() {
        return this.title;
    }

    public final PoiCommonEntryStruct copy(int r100, String r101, String r102) {
        return new PoiCommonEntryStruct(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PoiCommonEntryStruct) == true) goto L8;
        return false;
    L8:
        PoiCommonEntryStruct r101 = (PoiCommonEntryStruct) r100;
        if (this.schemaType == r101.schemaType) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.schemaUrl, r101.schemaUrl) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = this.schemaType * 31;
        String r101 = this.schemaUrl;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.title;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "PoiCommonEntryStruct(schemaType=" + this.schemaType + ", schemaUrl=" + this.schemaUrl + ", title=" + this.title + ')';
    }

    public final int getSchemaType() {
        return this.schemaType;
    }

    public final String getSchemaUrl() {
        return this.schemaUrl;
    }

    public final String getTitle() {
        return this.title;
    }

    public PoiCommonEntryStruct(int r100, String r101, String r102) {
        this.schemaType = r100;
        this.schemaUrl = r101;
        this.title = r102;
    }

    public /* synthetic */ PoiCommonEntryStruct(int r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
