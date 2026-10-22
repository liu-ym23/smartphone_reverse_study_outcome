package com.bytedance.locallife.model.poi.resp;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u0000 \"2\u00020\u0001:\u0001#B;\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b \u0010!J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0002HÆ\u0003J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J=\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u0002HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0002HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017R\u001a\u0010\f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0015\u001a\u0004\b\u001c\u0010\u0017R\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0015\u001a\u0004\b\u001d\u0010\u0017\"\u0004\b\u001e\u0010\u001f¨\u0006$"}, d2 = {"Lcom/bytedance/locallife/model/poi/resp/PoiUgcTag;", "Ljava/io/Serializable;", "", "component1", "", "component2", "component3", "component4", "component5", "optionType", "displayText", "sortBy", "filterBy", "count", "copy", "toString", "hashCode", "", "other", "", "equals", "I", "getOptionType", "()I", "Ljava/lang/String;", "getDisplayText", "()Ljava/lang/String;", "getSortBy", "getFilterBy", "getCount", "setCount", "(I)V", "<init>", "(ILjava/lang/String;III)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final class PoiUgcTag implements Serializable {
    public static final a Companion = null;
    public static final long serialVersionUID = 1;

    @SerializedName("count")
    private int count;

    @SerializedName("display_text")
    private final String displayText;

    @SerializedName("filter_by")
    private final int filterBy;

    @SerializedName("option_type")
    private final int optionType;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SORT_BY)
    private final int sortBy;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public PoiUgcTag() {
        this(0, null, 0, 0, 0, 31, null);
    }

    public static /* synthetic */ PoiUgcTag copy$default(PoiUgcTag r100, int r101, String r102, int r103, int r104, int r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.optionType;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.displayText;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.sortBy;
    L11:
        int r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.filterBy;
    L14:
        int r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.count;
    L17:
        int r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final int component1() {
        return this.optionType;
    }

    public final String component2() {
        return this.displayText;
    }

    public final int component3() {
        return this.sortBy;
    }

    public final int component4() {
        return this.filterBy;
    }

    public final int component5() {
        return this.count;
    }

    public final PoiUgcTag copy(int r100, String r101, int r110, int r111, int r112) {
        return new PoiUgcTag(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PoiUgcTag) == true) goto L8;
        return false;
    L8:
        PoiUgcTag r101 = (PoiUgcTag) r100;
        if (this.optionType == r101.optionType) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.displayText, r101.displayText) == true) goto L15;
        return false;
    L15:
        if (this.sortBy == r101.sortBy) goto L18;
        return false;
    L18:
        if (this.filterBy == r101.filterBy) goto L21;
        return false;
    L21:
        if (this.count == r101.count) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r100 = this.optionType * 31;
        String r101 = this.displayText;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((((((r100 + r102) * 31) + this.sortBy) * 31) + this.filterBy) * 31) + this.count;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "PoiUgcTag(optionType=" + this.optionType + ", displayText=" + this.displayText + ", sortBy=" + this.sortBy + ", filterBy=" + this.filterBy + ", count=" + this.count + ')';
    }

    public final int getCount() {
        return this.count;
    }

    public final String getDisplayText() {
        return this.displayText;
    }

    public final int getFilterBy() {
        return this.filterBy;
    }

    public final int getOptionType() {
        return this.optionType;
    }

    public final int getSortBy() {
        return this.sortBy;
    }

    public final void setCount(int r100) {
        this.count = r100;
    }

    public PoiUgcTag(int r100, String r101, int r102, int r103, int r104) {
        this.optionType = r100;
        this.displayText = r101;
        this.sortBy = r102;
        this.filterBy = r103;
        this.count = r104;
    }

    public /* synthetic */ PoiUgcTag(int r100, String r101, int r102, int r103, int r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        int r112 = 0;
    L7:
        if ((r110 & 2) == 0) goto L9;
        r101 = "";
    L9:
        String r105 = r101;
        if ((r110 & 4) == 0) goto L12;
        int r106 = 0;
    L14:
        if ((r110 & 8) == 0) goto L16;
        int r107 = 0;
    L18:
        if ((r110 & 16) == 0) goto L20;
        int r113 = 0;
    L21:
        this(r112, r105, r106, r107, r113);
        return;
    L20:
        r113 = r104;
        goto L21
    L16:
        r107 = r103;
        goto L18
    L12:
        r106 = r102;
        goto L14
    L5:
        r112 = r100;
        goto L7
    }
}
