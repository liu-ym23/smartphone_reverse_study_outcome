package com.bytedance.locallife.model.poi.resp;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u000f\b\u0086\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB5\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u001b\u0010\u001cJ\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0006HÆ\u0003J7\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001J\t\u0010\r\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0013\u001a\u0004\b\u0016\u0010\u0015R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u0017\u0010\u000b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001f"}, d2 = {"Lcom/bytedance/locallife/model/poi/resp/PoiDouDiscountTabStruct;", "Ljava/io/Serializable;", "", "component1", "component2", "component3", "", "component4", "douDiscountId", "name", "rankCode", "selectState", "copy", "toString", "", "hashCode", "", "other", "equals", "Ljava/lang/String;", "getDouDiscountId", "()Ljava/lang/String;", "getName", "getRankCode", "Z", "getSelectState", "()Z", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final class PoiDouDiscountTabStruct implements Serializable {
    public static final a Companion = null;
    public static final long serialVersionUID = 1;

    @SerializedName("dou_discount_id")
    private final String douDiscountId;

    @SerializedName("name")
    private final String name;

    @SerializedName("rank_code")
    private final String rankCode;
    private final boolean selectState;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public PoiDouDiscountTabStruct() {
        this(null, null, null, false, 15, null);
    }

    public static /* synthetic */ PoiDouDiscountTabStruct copy$default(PoiDouDiscountTabStruct r100, String r101, String r102, String r103, boolean r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.douDiscountId;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.name;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.rankCode;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.selectState;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.douDiscountId;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.rankCode;
    }

    public final boolean component4() {
        return this.selectState;
    }

    public final PoiDouDiscountTabStruct copy(String r100, String r101, String r102, boolean r103) {
        return new PoiDouDiscountTabStruct(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PoiDouDiscountTabStruct) == true) goto L8;
        return false;
    L8:
        PoiDouDiscountTabStruct r101 = (PoiDouDiscountTabStruct) r100;
        if (Intrinsics.areEqual(this.douDiscountId, r101.douDiscountId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.rankCode, r101.rankCode) == true) goto L18;
        return false;
    L18:
        if (this.selectState == r101.selectState) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r100 = this.douDiscountId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.name;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.rankCode;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        int r108 = (r106 + r101) * 31;
        if (this.selectState == false) goto L17;
        int r109 = 1231;
    L19:
        return r108 + r109;
    L17:
        r109 = 1237;
        goto L19
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "PoiDouDiscountTabStruct(douDiscountId=" + this.douDiscountId + ", name=" + this.name + ", rankCode=" + this.rankCode + ", selectState=" + this.selectState + ')';
    }

    public final String getDouDiscountId() {
        return this.douDiscountId;
    }

    public final String getName() {
        return this.name;
    }

    public final String getRankCode() {
        return this.rankCode;
    }

    public final boolean getSelectState() {
        return this.selectState;
    }

    public PoiDouDiscountTabStruct(String r100, String r101, String r102, boolean r103) {
        this.douDiscountId = r100;
        this.name = r101;
        this.rankCode = r102;
        this.selectState = r103;
    }

    public /* synthetic */ PoiDouDiscountTabStruct(String r100, String r101, String r102, boolean r103, int r104, DefaultConstructorMarker r105) {
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
        r103 = false;
    L14:
        this(r100, r101, r102, r103);
    }
}
