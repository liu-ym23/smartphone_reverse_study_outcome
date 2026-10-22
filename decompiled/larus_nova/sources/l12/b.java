package l12;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0012\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0017\u001a\u00020\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Ll12/b;", "", "Lorg/json/JSONObject;", "contextFeatures", "Lorg/json/JSONObject;", "getContextFeatures", "()Lorg/json/JSONObject;", "", "level", "I", "getLevel", "()I", "", "roomId", "Ljava/lang/String;", "getRoomId", "()Ljava/lang/String;", "", "available", "J", "getAvailable", "()J", "Ll12/e;", "strategyContext", "Ll12/e;", "getStrategyContext", "()Ll12/e;", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("available")
    private final long available;

    @SerializedName("context_features")
    private final JSONObject contextFeatures;

    @SerializedName("level")
    private final int level;

    @SerializedName("room_id")
    private final String roomId;

    @SerializedName("strategy_context")
    private final e strategyContext;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L16;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.contextFeatures, r101.contextFeatures) == true) goto L8;
        return false;
    L8:
        if (this.level == r101.level) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.roomId, r101.roomId) == true) goto L12;
        return false;
    L12:
        if (this.available == r101.available) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.strategyContext, r101.strategyContext) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        JSONObject r100 = this.contextFeatures;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.level) * 31;
        String r104 = this.roomId;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        long r107 = this.available;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        e r109 = this.strategyContext;
        if (r109 == null) goto L14;
        r101 = r109.hashCode();
    L14:
        return r108 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "GiftListResponseModel(contextFeatures=" + this.contextFeatures + ", level=" + this.level + ", roomId=" + this.roomId + ", available=" + this.available + ", strategyContext=" + this.strategyContext + ")";
    }
}
