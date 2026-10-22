package com.bytedance.locallife.poi.view.mall.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/bytedance/locallife/poi/view/mall/model/CommonSpuInfo;", "Ljava/io/Serializable;", "spuInfo", "Lcom/bytedance/locallife/poi/view/mall/model/SpuInfoCell;", "spuIconUrl", "", "(Lcom/bytedance/locallife/poi/view/mall/model/SpuInfoCell;Ljava/lang/String;)V", "getSpuIconUrl", "()Ljava/lang/String;", "getSpuInfo", "()Lcom/bytedance/locallife/poi/view/mall/model/SpuInfoCell;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class CommonSpuInfo implements Serializable {

    @SerializedName("icon_url")
    private final String spuIconUrl;

    @SerializedName("common_spu_info")
    private final SpuInfoCell spuInfo;

    /* JADX WARN: Multi-variable type inference failed */
    public CommonSpuInfo() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ CommonSpuInfo copy$default(CommonSpuInfo r100, SpuInfoCell r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.spuInfo;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.spuIconUrl;
    L9:
        return r100.copy(r101, r102);
    }

    public final SpuInfoCell component1() {
        return this.spuInfo;
    }

    public final String component2() {
        return this.spuIconUrl;
    }

    public final CommonSpuInfo copy(SpuInfoCell r100, String r101) {
        return new CommonSpuInfo(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CommonSpuInfo) == true) goto L8;
        return false;
    L8:
        CommonSpuInfo r101 = (CommonSpuInfo) r100;
        if (Intrinsics.areEqual(this.spuInfo, r101.spuInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.spuIconUrl, r101.spuIconUrl) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        SpuInfoCell r100 = this.spuInfo;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.spuIconUrl;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "CommonSpuInfo(spuInfo=" + this.spuInfo + ", spuIconUrl=" + this.spuIconUrl + ')';
    }

    public final String getSpuIconUrl() {
        return this.spuIconUrl;
    }

    public final SpuInfoCell getSpuInfo() {
        return this.spuInfo;
    }

    public CommonSpuInfo(SpuInfoCell r100, String r101) {
        this.spuInfo = r100;
        this.spuIconUrl = r101;
    }

    public /* synthetic */ CommonSpuInfo(SpuInfoCell r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
