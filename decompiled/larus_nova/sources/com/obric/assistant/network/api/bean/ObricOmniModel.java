package com.obric.assistant.network.api.bean;

import com.google.gson.annotations.SerializedName;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import vea.k;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0015JJ\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\nHÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0007\u0010\u0012R\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Lcom/obric/assistant/network/api/bean/ObricOmniModel;", "", "displayModel", "", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "modelItemIndex", "Lcom/obric/assistant/network/api/bean/ObricOmniModelItemIndex;", "isSupportedModel", "", "oldItemKey", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/obric/assistant/network/api/bean/ObricOmniModelItemIndex;Ljava/lang/Boolean;Ljava/lang/Integer;)V", "getDisplayModel", "()Ljava/lang/String;", "getModel", "getModelItemIndex", "()Lcom/obric/assistant/network/api/bean/ObricOmniModelItemIndex;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getOldItemKey", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/obric/assistant/network/api/bean/ObricOmniModelItemIndex;Ljava/lang/Boolean;Ljava/lang/Integer;)Lcom/obric/assistant/network/api/bean/ObricOmniModel;", "equals", "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricOmniModel {

    @SerializedName("display_model")
    private final String displayModel;

    @SerializedName("is_supported_model")
    private final Boolean isSupportedModel;

    @SerializedName(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL)
    private final String model;

    @SerializedName("model_item_index")
    private final k modelItemIndex;

    @SerializedName("old_item_key")
    private final Integer oldItemKey;

    public ObricOmniModel() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ ObricOmniModel copy$default(ObricOmniModel r100, String r101, String r102, k r103, Boolean r104, Integer r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.displayModel;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.model;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.modelItemIndex;
    L11:
        k r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.isSupportedModel;
    L14:
        Boolean r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.oldItemKey;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.displayModel;
    }

    public final String component2() {
        return this.model;
    }

    public final k component3() {
        return this.modelItemIndex;
    }

    public final Boolean component4() {
        return this.isSupportedModel;
    }

    public final Integer component5() {
        return this.oldItemKey;
    }

    public final ObricOmniModel copy(String r100, String r101, k r110, Boolean r111, Integer r112) {
        return new ObricOmniModel(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ObricOmniModel) == true) goto L8;
        return false;
    L8:
        ObricOmniModel r101 = (ObricOmniModel) r100;
        if (Intrinsics.areEqual(this.displayModel, r101.displayModel) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.model, r101.model) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.modelItemIndex, r101.modelItemIndex) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.isSupportedModel, r101.isSupportedModel) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.oldItemKey, r101.oldItemKey) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r100 = this.displayModel;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.model;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        k r107 = this.modelItemIndex;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.isSupportedModel;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.oldItemKey;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "ObricOmniModel(displayModel=" + this.displayModel + ", model=" + this.model + ", modelItemIndex=" + this.modelItemIndex + ", isSupportedModel=" + this.isSupportedModel + ", oldItemKey=" + this.oldItemKey + ')';
    }

    public final String getDisplayModel() {
        return this.displayModel;
    }

    public final String getModel() {
        return this.model;
    }

    public final k getModelItemIndex() {
        return this.modelItemIndex;
    }

    public final Integer getOldItemKey() {
        return this.oldItemKey;
    }

    public final Boolean isSupportedModel() {
        return this.isSupportedModel;
    }

    public ObricOmniModel(String r100, String r101, k r102, Boolean r103, Integer r104) {
        this.displayModel = r100;
        this.model = r101;
        this.modelItemIndex = r102;
        this.isSupportedModel = r103;
        this.oldItemKey = r104;
    }

    public /* synthetic */ ObricOmniModel(String r100, String r101, k r102, Boolean r103, Integer r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        String r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        String r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        k r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        Boolean r107 = null;
    L19:
        if ((r110 & 16) == 0) goto L21;
        Integer r113 = null;
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
