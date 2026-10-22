package jv6;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R(\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Ljv6/l;", "", "", "cardInfo", "Ljava/lang/String;", "getCardInfo", "()Ljava/lang/String;", "", "extraInfo", "Ljava/util/Map;", "getExtraInfo", "()Ljava/util/Map;", "locallife-live-api_release"}, k = 1, mv = {1, 4, 3})
public final class l {

    @SerializedName("card_info")
    private final String cardInfo;

    @SerializedName("extra_info")
    private final Map<String, Object> extraInfo;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.cardInfo, r101.cardInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.extraInfo, r101.extraInfo) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r100 = this.cardInfo;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Map<String, Object> r104 = this.extraInfo;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "SharePanelInfo(cardInfo=" + this.cardInfo + ", extraInfo=" + this.extraInfo + ')';
    }

    public l() {
        this.cardInfo = null;
        this.extraInfo = null;
    }
}
