package com.bytedance.locallife.live.goodsshelves.bean;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/bean/v0;", "", "", "tagType", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "toolText", "c", "Lcom/bytedance/locallife/live/goodsshelves/bean/q0;", "couponAmountText", "Lcom/bytedance/locallife/live/goodsshelves/bean/q0;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/locallife/live/goodsshelves/bean/q0;", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class v0 {

    @SerializedName("coupon_amount_text")
    private final q0 couponAmountText;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_TAG_TYPE)
    private final String tagType;

    @SerializedName("tool_text")
    private final String toolText;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof v0) == true) goto L8;
        return false;
    L8:
        v0 r101 = (v0) r100;
        if (Intrinsics.areEqual(this.tagType, r101.tagType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.toolText, r101.toolText) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.couponAmountText, r101.couponAmountText) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.tagType;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.toolText;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        q0 r107 = this.couponAmountText;
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

    public final String toString() {
        return "ProductMarketingToolInfoData(tagType=" + this.tagType + ", toolText=" + this.toolText + ", couponAmountText=" + this.couponAmountText + ')';
    }

    public v0() {
        this.tagType = null;
        this.toolText = null;
        this.couponAmountText = null;
    }

    public final q0 a() {
        return this.couponAmountText;
    }

    public final String b() {
        return this.tagType;
    }

    public final String c() {
        return this.toolText;
    }
}
