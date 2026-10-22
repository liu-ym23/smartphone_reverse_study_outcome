package mv6;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b¨\u0006\f"}, d2 = {"Lmv6/g;", "", "", "", "cardIds", "Ljava/util/List;", "getCardIds", "()Ljava/util/List;", "", "isValid", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class g {

    @SerializedName("card_ids")
    private final List<String> cardIds;

    @SerializedName(LocationMonitorConst.IS_VALID)
    private final Boolean isValid;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.cardIds, r101.cardIds) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.isValid, r101.isValid) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        List<String> r100 = this.cardIds;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.isValid;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "RefreshGrouponInfo(cardIds=" + this.cardIds + ", isValid=" + this.isValid + ')';
    }

    public g() {
        Boolean r100 = Boolean.FALSE;
        this.cardIds = null;
        this.isValid = r100;
    }
}
