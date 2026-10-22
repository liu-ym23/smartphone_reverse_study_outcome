package com.bytedance.locallife.poi.view.mall.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\bJ,\u0010\u000e\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\bR\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/locallife/poi/view/mall/model/MallFilterModel;", "Ljava/io/Serializable;", "optionList", "", "Lcom/bytedance/locallife/poi/view/mall/model/MallFilterStruct;", "isFullPage", "", "(Ljava/util/List;Ljava/lang/Boolean;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getOptionList", "()Ljava/util/List;", "component1", "component2", "copy", "(Ljava/util/List;Ljava/lang/Boolean;)Lcom/bytedance/locallife/poi/view/mall/model/MallFilterModel;", "equals", "other", "", "hashCode", "", "toString", "", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class MallFilterModel implements Serializable {

    @SerializedName("is_full_page")
    private final Boolean isFullPage;

    @SerializedName("filter_options")
    private final List<MallFilterStruct> optionList;

    /* JADX WARN: Multi-variable type inference failed */
    public MallFilterModel() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MallFilterModel copy$default(MallFilterModel r100, List r101, Boolean r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.optionList;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.isFullPage;
    L9:
        return r100.copy(r101, r102);
    }

    public final List<MallFilterStruct> component1() {
        return this.optionList;
    }

    public final Boolean component2() {
        return this.isFullPage;
    }

    public final MallFilterModel copy(List<MallFilterStruct> r100, Boolean r101) {
        return new MallFilterModel(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MallFilterModel) == true) goto L8;
        return false;
    L8:
        MallFilterModel r101 = (MallFilterModel) r100;
        if (Intrinsics.areEqual(this.optionList, r101.optionList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.isFullPage, r101.isFullPage) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        List<MallFilterStruct> r100 = this.optionList;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.isFullPage;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "MallFilterModel(optionList=" + this.optionList + ", isFullPage=" + this.isFullPage + ')';
    }

    public final List<MallFilterStruct> getOptionList() {
        return this.optionList;
    }

    public final Boolean isFullPage() {
        return this.isFullPage;
    }

    public MallFilterModel(List<MallFilterStruct> r100, Boolean r101) {
        this.optionList = r100;
        this.isFullPage = r101;
    }

    public /* synthetic */ MallFilterModel(List r100, Boolean r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
