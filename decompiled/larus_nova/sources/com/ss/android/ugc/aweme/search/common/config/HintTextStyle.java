package com.ss.android.ugc.aweme.search.common.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/config/HintTextStyle;", "", "", "color", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "ec-search-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HintTextStyle {

    @SerializedName("color")
    private final String color;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof HintTextStyle) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.color, ((HintTextStyle) r100).color) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        String r100 = this.color;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "HintTextStyle(color=" + this.color + ")";
    }

    public HintTextStyle() {
        Intrinsics.checkNotNullParameter("#80161823", "color");
        this.color = "#80161823";
    }

    public final String a() {
        return this.color;
    }
}
