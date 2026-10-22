package com.bytedance.locallife.dito.data;

import com.bytedance.locallife.dito.common.lynx.DitoLynxNativeModule;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R@\u0010\u0007\u001a(\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005\u0018\u00010\u0002j\u0004\u0018\u0001`\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/bytedance/locallife/dito/data/g;", "", "", "", "", "Lcom/bytedance/locallife/dito/utils/ColorCard;", "Lcom/bytedance/locallife/dito/utils/ColorCards;", "colorCard", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "", DitoLynxNativeModule.HALF_CONTAINER_TYPE, "Ljava/lang/Integer;", "d", "()Ljava/lang/Integer;", "", "ditoEnableStickSubViewVariableHeight", "Ljava/lang/Boolean;", "c", "()Ljava/lang/Boolean;", "autoBlurIme", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "dito-core-saas_release"}, k = 1, mv = {1, 4, 3})
public final class g {

    @SerializedName("auto_blur_ime")
    private final Boolean autoBlurIme;

    @SerializedName("colorCard")
    private final Map<String, List<String>> colorCard;

    @SerializedName("dito_enable_stick_sub_view_variable_height")
    private final Boolean ditoEnableStickSubViewVariableHeight;

    @SerializedName("half_container_type")
    private final Integer halfContainerType;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.colorCard, r101.colorCard) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.halfContainerType, r101.halfContainerType) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.ditoEnableStickSubViewVariableHeight, r101.ditoEnableStickSubViewVariableHeight) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.autoBlurIme, r101.autoBlurIme) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        Map<String, List<String>> r100 = this.colorCard;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.halfContainerType;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.ditoEnableStickSubViewVariableHeight;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.autoBlurIme;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
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

    public final String toString() {
        return "DitoPageInfoExtraConfig(colorCard=" + this.colorCard + ", halfContainerType=" + this.halfContainerType + ", ditoEnableStickSubViewVariableHeight=" + this.ditoEnableStickSubViewVariableHeight + ", autoBlurIme=" + this.autoBlurIme + ')';
    }

    public g() {
        this.colorCard = null;
        this.halfContainerType = null;
        this.ditoEnableStickSubViewVariableHeight = null;
        this.autoBlurIme = null;
    }

    public final Boolean a() {
        return this.autoBlurIme;
    }

    public final Map<String, List<String>> b() {
        return this.colorCard;
    }

    public final Boolean c() {
        return this.ditoEnableStickSubViewVariableHeight;
    }

    public final Integer d() {
        return this.halfContainerType;
    }
}
