package com.bytedance.locallife.model.poi.resp;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.poi.model.PoiImageUrlModel;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\bHÆ\u0003J3\u0010\u0017\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0006HÖ\u0001R \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/bytedance/locallife/model/poi/resp/RecFoodsDetailGroup;", "Ljava/io/Serializable;", "recFoods", "", "Lcom/bytedance/locallife/model/poi/resp/RecFood;", "recFoodListData", "", "recFoodIcon", "Lcom/ss/android/ugc/aweme/poi/model/PoiImageUrlModel;", "(Ljava/util/List;Ljava/lang/String;Lcom/ss/android/ugc/aweme/poi/model/PoiImageUrlModel;)V", "getRecFoodIcon", "()Lcom/ss/android/ugc/aweme/poi/model/PoiImageUrlModel;", "setRecFoodIcon", "(Lcom/ss/android/ugc/aweme/poi/model/PoiImageUrlModel;)V", "getRecFoodListData", "()Ljava/lang/String;", "setRecFoodListData", "(Ljava/lang/String;)V", "getRecFoods", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class RecFoodsDetailGroup implements Serializable {

    @SerializedName("rec_food_icon")
    private PoiImageUrlModel recFoodIcon;

    @SerializedName("rec_food_list_data")
    private String recFoodListData;

    @SerializedName("rec_foods")
    private final List<RecFood> recFoods;

    public RecFoodsDetailGroup() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RecFoodsDetailGroup copy$default(RecFoodsDetailGroup r100, List r101, String r102, PoiImageUrlModel r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.recFoods;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.recFoodListData;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.recFoodIcon;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final List<RecFood> component1() {
        return this.recFoods;
    }

    public final String component2() {
        return this.recFoodListData;
    }

    public final PoiImageUrlModel component3() {
        return this.recFoodIcon;
    }

    public final RecFoodsDetailGroup copy(List<RecFood> r100, String r101, PoiImageUrlModel r102) {
        return new RecFoodsDetailGroup(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RecFoodsDetailGroup) == true) goto L8;
        return false;
    L8:
        RecFoodsDetailGroup r101 = (RecFoodsDetailGroup) r100;
        if (Intrinsics.areEqual(this.recFoods, r101.recFoods) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.recFoodListData, r101.recFoodListData) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.recFoodIcon, r101.recFoodIcon) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        List<RecFood> r100 = this.recFoods;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.recFoodListData;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        PoiImageUrlModel r107 = this.recFoodIcon;
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
        return "RecFoodsDetailGroup(recFoods=" + this.recFoods + ", recFoodListData=" + this.recFoodListData + ", recFoodIcon=" + this.recFoodIcon + ')';
    }

    public final PoiImageUrlModel getRecFoodIcon() {
        return this.recFoodIcon;
    }

    public final String getRecFoodListData() {
        return this.recFoodListData;
    }

    public final List<RecFood> getRecFoods() {
        return this.recFoods;
    }

    public final void setRecFoodIcon(PoiImageUrlModel r100) {
        this.recFoodIcon = r100;
    }

    public final void setRecFoodListData(String r100) {
        this.recFoodListData = r100;
    }

    public RecFoodsDetailGroup(List<RecFood> r100, String r101, PoiImageUrlModel r102) {
        this.recFoods = r100;
        this.recFoodListData = r101;
        this.recFoodIcon = r102;
    }

    public /* synthetic */ RecFoodsDetailGroup(List r100, String r101, PoiImageUrlModel r102, int r103, DefaultConstructorMarker r104) {
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
