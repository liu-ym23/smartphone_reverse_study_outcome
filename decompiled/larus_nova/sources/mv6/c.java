package mv6;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lmv6/c;", "", "", "lotteryId", "Ljava/lang/String;", "getLotteryId", "()Ljava/lang/String;", "cardId", "getCardId", "componentId", "getComponentId", "", "luckyUids", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("card_id")
    private final String cardId;

    @SerializedName("component_id")
    private final String componentId;

    @SerializedName("lottery_id")
    private final String lotteryId;

    @SerializedName("lucky_uids")
    private final List<String> luckyUids;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.lotteryId, r101.lotteryId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.cardId, r101.cardId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.componentId, r101.componentId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.luckyUids, r101.luckyUids) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r100 = this.lotteryId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.cardId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.componentId;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        List<String> r110 = this.luckyUids;
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
        return "DrawLotteryResult(lotteryId=" + this.lotteryId + ", cardId=" + this.cardId + ", componentId=" + this.componentId + ", luckyUids=" + this.luckyUids + ')';
    }

    public c() {
        this.lotteryId = "";
        this.cardId = "";
        this.componentId = "";
        this.luckyUids = null;
    }

    public final List<String> a() {
        return this.luckyUids;
    }
}
