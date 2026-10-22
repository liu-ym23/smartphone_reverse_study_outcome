package jv6;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR(\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Ljv6/k;", "", "Ljv6/o;", "refluxInfo", "Ljv6/o;", "getRefluxInfo", "()Ljv6/o;", "Ljv6/l;", "panelInfo", "Ljv6/l;", "getPanelInfo", "()Ljv6/l;", "", "", "roomInfo", "Ljava/util/Map;", "getRoomInfo", "()Ljava/util/Map;", "locallife-live-api_release"}, k = 1, mv = {1, 4, 3})
public final class k {

    @SerializedName("panel_info")
    private final l panelInfo;

    @SerializedName("reflux_info")
    private final o refluxInfo;

    @SerializedName("room_info")
    private final Map<String, String> roomInfo;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.refluxInfo, r101.refluxInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.panelInfo, r101.panelInfo) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.roomInfo, r101.roomInfo) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        o r100 = this.refluxInfo;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        l r104 = this.panelInfo;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, String> r107 = this.roomInfo;
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
        return "ShareCouponShareInfo(refluxInfo=" + this.refluxInfo + ", panelInfo=" + this.panelInfo + ", roomInfo=" + this.roomInfo + ')';
    }

    public k() {
        this.refluxInfo = null;
        this.panelInfo = null;
        this.roomInfo = null;
    }
}
