package com.bytedance.awemeopen.bizmodels.feed.poi;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/feed/poi/PoiTradeGoodsLifeAnchorSuffixStruct;", "Ljava/io/Serializable;", "content", "", "type", "", "style", "priority", "(Ljava/lang/String;III)V", "getContent", "()Ljava/lang/String;", "getPriority", "()I", "getStyle", "getType", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PoiTradeGoodsLifeAnchorSuffixStruct implements Serializable {

    @SerializedName("content")
    private final String content;

    @SerializedName("priority")
    private final int priority;

    @SerializedName("style")
    private final int style;

    @SerializedName("type")
    private final int type;

    public PoiTradeGoodsLifeAnchorSuffixStruct() {
        this(null, 0, 0, 0, 15, null);
    }

    public static /* synthetic */ PoiTradeGoodsLifeAnchorSuffixStruct copy$default(PoiTradeGoodsLifeAnchorSuffixStruct r100, String r101, int r102, int r103, int r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.content;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.type;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.style;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.priority;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.content;
    }

    public final int component2() {
        return this.type;
    }

    public final int component3() {
        return this.style;
    }

    public final int component4() {
        return this.priority;
    }

    public final PoiTradeGoodsLifeAnchorSuffixStruct copy(String r100, int r101, int r102, int r103) {
        return new PoiTradeGoodsLifeAnchorSuffixStruct(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PoiTradeGoodsLifeAnchorSuffixStruct) == true) goto L8;
        return false;
    L8:
        PoiTradeGoodsLifeAnchorSuffixStruct r101 = (PoiTradeGoodsLifeAnchorSuffixStruct) r100;
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L12;
        return false;
    L12:
        if (this.type == r101.type) goto L15;
        return false;
    L15:
        if (this.style == r101.style) goto L18;
        return false;
    L18:
        if (this.priority == r101.priority) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r100 = this.content;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (((((r101 * 31) + this.type) * 31) + this.style) * 31) + this.priority;
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public String toString() {
        return "PoiTradeGoodsLifeAnchorSuffixStruct(content=" + this.content + ", type=" + this.type + ", style=" + this.style + ", priority=" + this.priority + ')';
    }

    public final String getContent() {
        return this.content;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final int getStyle() {
        return this.style;
    }

    public final int getType() {
        return this.type;
    }

    public PoiTradeGoodsLifeAnchorSuffixStruct(String r100, int r101, int r102, int r103) {
        this.content = r100;
        this.type = r101;
        this.style = r102;
        this.priority = r103;
    }

    public /* synthetic */ PoiTradeGoodsLifeAnchorSuffixStruct(String r100, int r101, int r102, int r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = 0;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = 0;
    L14:
        this(r100, r101, r102, r103);
    }
}
