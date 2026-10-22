package com.bytedance.locallife.model.poi.resp;

import com.bytedance.android.shopping.slice.action.entity.SendClosePdpEventParam;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.EventConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J+\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/bytedance/locallife/model/poi/resp/PoiLynxStruct;", "Ljava/io/Serializable;", "lynxUrl", "", "rawData", "height", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "cardType", "getCardType", "()I", "setCardType", "(I)V", "getHeight", "getLynxUrl", "()Ljava/lang/String;", "getRawData", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class PoiLynxStruct implements Serializable {
    private int cardType;

    @SerializedName("height")
    private final int height;

    @SerializedName(SendClosePdpEventParam.KEY_LYNX_URL)
    private final String lynxUrl;

    @SerializedName(EventConstant.Key.RAW_DATA)
    private final String rawData;

    public PoiLynxStruct() {
        this(null, null, 0, 7, null);
    }

    public static /* synthetic */ PoiLynxStruct copy$default(PoiLynxStruct r100, String r101, String r102, int r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.lynxUrl;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.rawData;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.height;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.lynxUrl;
    }

    public final String component2() {
        return this.rawData;
    }

    public final int component3() {
        return this.height;
    }

    public final PoiLynxStruct copy(String r100, String r101, int r102) {
        return new PoiLynxStruct(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PoiLynxStruct) == true) goto L8;
        return false;
    L8:
        PoiLynxStruct r101 = (PoiLynxStruct) r100;
        if (Intrinsics.areEqual(this.lynxUrl, r101.lynxUrl) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.rawData, r101.rawData) == true) goto L15;
        return false;
    L15:
        if (this.height == r101.height) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.lynxUrl;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.rawData;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return ((r103 + r101) * 31) + this.height;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "PoiLynxStruct(lynxUrl=" + this.lynxUrl + ", rawData=" + this.rawData + ", height=" + this.height + ')';
    }

    public final int getCardType() {
        return this.cardType;
    }

    public final int getHeight() {
        return this.height;
    }

    public final String getLynxUrl() {
        return this.lynxUrl;
    }

    public final String getRawData() {
        return this.rawData;
    }

    public final void setCardType(int r100) {
        this.cardType = r100;
    }

    public PoiLynxStruct(String r100, String r101, int r102) {
        this.lynxUrl = r100;
        this.rawData = r101;
        this.height = r102;
    }

    public /* synthetic */ PoiLynxStruct(String r100, String r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = 0;
    L11:
        this(r100, r101, r102);
    }
}
