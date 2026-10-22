package com.larus.dora.api.device.ota.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/larus/dora/api/device/ota/model/OTAUpdateMeta;", "Ljava/io/Serializable;", "descText", "", "descType", "descDetail", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDescText", "()Ljava/lang/String;", "setDescText", "(Ljava/lang/String;)V", "getDescType", "setDescType", "getDescDetail", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OTAUpdateMeta implements Serializable {

    @SerializedName("desc_detail")
    private final String descDetail;

    @SerializedName("desc_text")
    private String descText;

    @SerializedName("desc_type")
    private String descType;

    public OTAUpdateMeta() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ OTAUpdateMeta copy$default(OTAUpdateMeta r100, String r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.descText;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.descType;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.descDetail;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.descText;
    }

    public final String component2() {
        return this.descType;
    }

    public final String component3() {
        return this.descDetail;
    }

    public final OTAUpdateMeta copy(String r100, String r101, String r102) {
        return new OTAUpdateMeta(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OTAUpdateMeta) == true) goto L8;
        return false;
    L8:
        OTAUpdateMeta r101 = (OTAUpdateMeta) r100;
        if (Intrinsics.areEqual(this.descText, r101.descText) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.descType, r101.descType) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.descDetail, r101.descDetail) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.descText;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.descType;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.descDetail;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "OTAUpdateMeta(descText=" + this.descText + ", descType=" + this.descType + ", descDetail=" + this.descDetail + ')';
    }

    public final String getDescDetail() {
        return this.descDetail;
    }

    public final String getDescText() {
        return this.descText;
    }

    public final String getDescType() {
        return this.descType;
    }

    public final void setDescText(String r100) {
        this.descText = r100;
    }

    public final void setDescType(String r100) {
        this.descType = r100;
    }

    public OTAUpdateMeta(String r100, String r101, String r102) {
        this.descText = r100;
        this.descType = r101;
        this.descDetail = r102;
    }

    public /* synthetic */ OTAUpdateMeta(String r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
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
