package yw6;

import com.bytedance.locallife.common.adapter.JsonToStringAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"Lyw6/g;", "", "Lyw6/c;", "bubbleIcon", "Lyw6/c;", "getBubbleIcon", "()Lyw6/c;", "", "bubbleStatusTextMap", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "bubbleText", "b", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class g {

    @SerializedName("bubble_icon")
    private final c bubbleIcon;

    @SerializedName("bubble_status_text_map")
    @JsonAdapter(JsonToStringAdapter.class)
    private final String bubbleStatusTextMap;

    @SerializedName("bubble_text")
    private final String bubbleText;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.bubbleIcon, r101.bubbleIcon) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bubbleStatusTextMap, r101.bubbleStatusTextMap) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.bubbleText, r101.bubbleText) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        c r100 = this.bubbleIcon;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.bubbleStatusTextMap;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.bubbleText;
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
        return "CouponShareBubbleInfo(bubbleIcon=" + this.bubbleIcon + ", bubbleStatusTextMap=" + this.bubbleStatusTextMap + ", bubbleText=" + this.bubbleText + ')';
    }

    public g() {
        this.bubbleIcon = null;
        this.bubbleStatusTextMap = null;
        this.bubbleText = null;
    }

    public final String a() {
        return this.bubbleStatusTextMap;
    }

    public final String b() {
        return this.bubbleText;
    }
}
