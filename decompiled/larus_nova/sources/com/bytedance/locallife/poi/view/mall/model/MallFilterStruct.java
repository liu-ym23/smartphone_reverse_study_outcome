package com.bytedance.locallife.poi.view.mall.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003JI\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011¨\u0006 "}, d2 = {"Lcom/bytedance/locallife/poi/view/mall/model/MallFilterStruct;", "Ljava/io/Serializable;", "optionText", "", "optionType", "optionValue", "childOptions", "", "isSelected", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Z)V", "getChildOptions", "()Ljava/util/List;", "()Z", "setSelected", "(Z)V", "getOptionText", "()Ljava/lang/String;", "getOptionType", "getOptionValue", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "toString", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class MallFilterStruct implements Serializable {

    @SerializedName("child_options")
    private final List<MallFilterStruct> childOptions;
    private boolean isSelected;

    @SerializedName("option_text")
    private final String optionText;

    @SerializedName("option_type")
    private final String optionType;

    @SerializedName("option_value")
    private final String optionValue;

    public MallFilterStruct() {
        this(null, null, null, null, false, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MallFilterStruct copy$default(MallFilterStruct r100, String r101, String r102, String r103, List r104, boolean r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.optionText;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.optionType;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.optionValue;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.childOptions;
    L14:
        List r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.isSelected;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.optionText;
    }

    public final String component2() {
        return this.optionType;
    }

    public final String component3() {
        return this.optionValue;
    }

    public final List<MallFilterStruct> component4() {
        return this.childOptions;
    }

    public final boolean component5() {
        return this.isSelected;
    }

    public final MallFilterStruct copy(String r100, String r101, String r110, List<MallFilterStruct> r111, boolean r112) {
        return new MallFilterStruct(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MallFilterStruct) == true) goto L8;
        return false;
    L8:
        MallFilterStruct r101 = (MallFilterStruct) r100;
        if (Intrinsics.areEqual(this.optionText, r101.optionText) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.optionType, r101.optionType) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.optionValue, r101.optionValue) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.childOptions, r101.childOptions) == true) goto L21;
        return false;
    L21:
        if (this.isSelected == r101.isSelected) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r100 = this.optionText;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.optionType;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.optionValue;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        List<MallFilterStruct> r110 = this.childOptions;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        int r111 = (r109 + r101) * 31;
        if (this.isSelected == false) goto L21;
        int r112 = 1231;
    L23:
        return r111 + r112;
    L21:
        r112 = 1237;
        goto L23
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
        return "MallFilterStruct(optionText=" + this.optionText + ", optionType=" + this.optionType + ", optionValue=" + this.optionValue + ", childOptions=" + this.childOptions + ", isSelected=" + this.isSelected + ')';
    }

    public final List<MallFilterStruct> getChildOptions() {
        return this.childOptions;
    }

    public final String getOptionText() {
        return this.optionText;
    }

    public final String getOptionType() {
        return this.optionType;
    }

    public final String getOptionValue() {
        return this.optionValue;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setSelected(boolean r100) {
        this.isSelected = r100;
    }

    public MallFilterStruct(String r100, String r101, String r102, List<MallFilterStruct> r103, boolean r104) {
        this.optionText = r100;
        this.optionType = r101;
        this.optionValue = r102;
        this.childOptions = r103;
        this.isSelected = r104;
    }

    public /* synthetic */ MallFilterStruct(String r100, String r101, String r102, List r103, boolean r104, int r105, DefaultConstructorMarker r110) {
        List r106 = null;
        if ((r105 & 1) == 0) goto L5;
        String r111 = null;
    L7:
        if ((r105 & 2) == 0) goto L9;
        String r107 = null;
    L11:
        if ((r105 & 4) == 0) goto L13;
        String r108 = null;
    L15:
        if ((r105 & 8) != 0) goto L19;
        r106 = r103;
    L19:
        if ((r105 & 16) == 0) goto L21;
        boolean r109 = false;
    L22:
        this(r111, r107, r108, r106, r109);
        return;
    L21:
        r109 = r104;
        goto L22
    L13:
        r108 = r102;
        goto L15
    L9:
        r107 = r101;
        goto L11
    L5:
        r111 = r100;
        goto L7
    }
}
