package nv6;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R(\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lnv6/o;", "", "", "groupPurchaseCardInfo", "Ljava/lang/String;", "getGroupPurchaseCardInfo", "()Ljava/lang/String;", "groupPurchaseExtra", "getGroupPurchaseExtra", "eventFrom", "getEventFrom", "", "lifeExtraInfoMap", "Ljava/util/Map;", "getLifeExtraInfoMap", "()Ljava/util/Map;", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class o {

    @SerializedName("event_from")
    private final String eventFrom;

    @SerializedName("group_purchase_card_info")
    private final String groupPurchaseCardInfo;

    @SerializedName("group_purchase_extra")
    private final String groupPurchaseExtra;

    @SerializedName("life_extra_info_map")
    private final Map<String, String> lifeExtraInfoMap;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (Intrinsics.areEqual(this.groupPurchaseCardInfo, r101.groupPurchaseCardInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.groupPurchaseExtra, r101.groupPurchaseExtra) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.eventFrom, r101.eventFrom) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.lifeExtraInfoMap, r101.lifeExtraInfoMap) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r100 = this.groupPurchaseCardInfo;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.groupPurchaseExtra;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.eventFrom;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Map<String, String> r110 = this.lifeExtraInfoMap;
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
        return "GroupPurchaseCardParams(groupPurchaseCardInfo=" + this.groupPurchaseCardInfo + ", groupPurchaseExtra=" + this.groupPurchaseExtra + ", eventFrom=" + this.eventFrom + ", lifeExtraInfoMap=" + this.lifeExtraInfoMap + ')';
    }

    public o() {
        this.groupPurchaseCardInfo = null;
        this.groupPurchaseExtra = null;
        this.eventFrom = null;
        this.lifeExtraInfoMap = null;
    }
}
