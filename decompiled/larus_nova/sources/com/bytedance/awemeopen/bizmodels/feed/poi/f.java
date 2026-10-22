package com.bytedance.awemeopen.bizmodels.feed.poi;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/feed/poi/f;", "", "", "suffixType", "Ljava/lang/Integer;", "getSuffixType", "()Ljava/lang/Integer;", "setSuffixType", "(Ljava/lang/Integer;)V", "", "suffixDesc", "Ljava/lang/String;", "getSuffixDesc", "()Ljava/lang/String;", "setSuffixDesc", "(Ljava/lang/String;)V", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final class f {

    @SerializedName("suffix_desc")
    private String suffixDesc;

    @SerializedName("suffix_type")
    private Integer suffixType;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.suffixType, r101.suffixType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.suffixDesc, r101.suffixDesc) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.suffixType;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.suffixDesc;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "PoiAnchorSuffixStruct(suffixType=" + this.suffixType + ", suffixDesc=" + this.suffixDesc + ')';
    }
}
