package com.obric.assistant.task;

import com.google.gson.annotations.SerializedName;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/obric/assistant/task/ObricOmniModelItem;", "", "displayModel", "", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getDisplayModel", "()Ljava/lang/String;", "getModel", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricOmniModelItem {

    @SerializedName("display_model")
    private final String displayModel;

    @SerializedName(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL)
    private final String model;

    /* JADX WARN: Multi-variable type inference failed */
    public ObricOmniModelItem() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ObricOmniModelItem copy$default(ObricOmniModelItem r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.displayModel;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.model;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.displayModel;
    }

    public final String component2() {
        return this.model;
    }

    public final ObricOmniModelItem copy(String r100, String r101) {
        return new ObricOmniModelItem(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ObricOmniModelItem) == true) goto L8;
        return false;
    L8:
        ObricOmniModelItem r101 = (ObricOmniModelItem) r100;
        if (Intrinsics.areEqual(this.displayModel, r101.displayModel) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.model, r101.model) == true) goto L14;
        return false;
    L14:
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
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "ObricOmniModelItem(displayModel=" + this.displayModel + ", model=" + this.model + ')';
    }

    public final String getDisplayModel() {
        return this.displayModel;
    }

    public final String getModel() {
        return this.model;
    }

    public ObricOmniModelItem(String r100, String r101) {
        this.displayModel = r100;
        this.model = r101;
    }

    public /* synthetic */ ObricOmniModelItem(String r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
