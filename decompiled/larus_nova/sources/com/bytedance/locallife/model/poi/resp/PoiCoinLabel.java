package com.bytedance.locallife.model.poi.resp;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J5\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/bytedance/locallife/model/poi/resp/PoiCoinLabel;", "Ljava/io/Serializable;", "style", "", "text", "", "amount", "iconUrl", "(ILjava/lang/String;ILjava/lang/String;)V", "getAmount", "()I", "getIconUrl", "()Ljava/lang/String;", "getStyle", "getText", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class PoiCoinLabel implements Serializable {

    @SerializedName("amount")
    private final int amount;

    @SerializedName("icon_url")
    private final String iconUrl;

    @SerializedName("style")
    private final int style;

    @SerializedName("text")
    private final String text;

    public PoiCoinLabel() {
        this(0, null, 0, null, 15, null);
    }

    public static /* synthetic */ PoiCoinLabel copy$default(PoiCoinLabel r100, int r101, String r102, int r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.style;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.text;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.amount;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.iconUrl;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final int component1() {
        return this.style;
    }

    public final String component2() {
        return this.text;
    }

    public final int component3() {
        return this.amount;
    }

    public final String component4() {
        return this.iconUrl;
    }

    public final PoiCoinLabel copy(int r100, String r101, int r102, String r103) {
        return new PoiCoinLabel(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PoiCoinLabel) == true) goto L8;
        return false;
    L8:
        PoiCoinLabel r101 = (PoiCoinLabel) r100;
        if (this.style == r101.style) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L15;
        return false;
    L15:
        if (this.amount == r101.amount) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.iconUrl, r101.iconUrl) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = this.style * 31;
        String r101 = this.text;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((r100 + r103) * 31) + this.amount) * 31;
        String r105 = this.iconUrl;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "PoiCoinLabel(style=" + this.style + ", text=" + this.text + ", amount=" + this.amount + ", iconUrl=" + this.iconUrl + ')';
    }

    public final int getAmount() {
        return this.amount;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final int getStyle() {
        return this.style;
    }

    public final String getText() {
        return this.text;
    }

    public PoiCoinLabel(int r100, String r101, int r102, String r103) {
        this.style = r100;
        this.text = r101;
        this.amount = r102;
        this.iconUrl = r103;
    }

    public /* synthetic */ PoiCoinLabel(int r100, String r101, int r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = 0;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
