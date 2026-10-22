package com.bytedance.locallife.live.goodsshelves.bean;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/bean/m;", "", "", "footerType", "Ljava/lang/Integer;", "getFooterType", "()Ljava/lang/Integer;", "", "Lcom/bytedance/locallife/live/goodsshelves/bean/x;", "footerText", "Ljava/util/List;", "getFooterText", "()Ljava/util/List;", "needResetFilter", "getNeedResetFilter", "", "validTabId", "Ljava/lang/Long;", "getValidTabId", "()Ljava/lang/Long;", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class m {

    @SerializedName("footer_text")
    private final List<x> footerText;

    @SerializedName("footer_type")
    private final Integer footerType;

    @SerializedName("need_reset_filter")
    private final Integer needResetFilter;

    @SerializedName("valid_tab_id")
    private final Long validTabId;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.footerType, r101.footerType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.footerText, r101.footerText) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.needResetFilter, r101.needResetFilter) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.validTabId, r101.validTabId) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.footerType;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<x> r104 = this.footerText;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.needResetFilter;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.validTabId;
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
        return "LiveLifeBFFCardFooterInfo(footerType=" + this.footerType + ", footerText=" + this.footerText + ", needResetFilter=" + this.needResetFilter + ", validTabId=" + this.validTabId + ')';
    }
}
