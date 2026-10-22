package com.bytedance.locallife.live.goodsshelves.bean;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/bean/u0;", "", "", "toolType", "I", "getToolType", "()I", "Lcom/bytedance/locallife/live/goodsshelves/bean/v0;", "marketingToolInfo", "Lcom/bytedance/locallife/live/goodsshelves/bean/v0;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/locallife/live/goodsshelves/bean/v0;", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class u0 {

    @SerializedName("marketing_tool_info")
    private final v0 marketingToolInfo;

    @SerializedName("tool_type")
    private final int toolType;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof u0) == true) goto L8;
        return false;
    L8:
        u0 r101 = (u0) r100;
        if (this.toolType == r101.toolType) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.marketingToolInfo, r101.marketingToolInfo) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.toolType * 31;
        v0 r101 = this.marketingToolInfo;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "ProductMarketingExpressionData(toolType=" + this.toolType + ", marketingToolInfo=" + this.marketingToolInfo + ')';
    }

    public u0() {
        this.toolType = 0;
        this.marketingToolInfo = null;
    }

    public final v0 a() {
        return this.marketingToolInfo;
    }
}
