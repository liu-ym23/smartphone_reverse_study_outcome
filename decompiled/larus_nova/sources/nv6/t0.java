package nv6;

import com.bytedance.locallife.live.goodsshelves.bean.LiveGoodsShelvesCard;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lnv6/t0;", "", "", "serverTime", "J", "getServerTime", "()J", "", "Lcom/bytedance/locallife/live/goodsshelves/bean/LiveGoodsShelvesCard;", "cardInfos", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class t0 {

    @SerializedName("card_infos")
    private final List<LiveGoodsShelvesCard> cardInfos;

    @SerializedName("server_time")
    private final long serverTime;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t0) == true) goto L8;
        return false;
    L8:
        t0 r101 = (t0) r100;
        if (this.serverTime == r101.serverTime) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.cardInfos, r101.cardInfos) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        long r100 = this.serverTime;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        List<LiveGoodsShelvesCard> r102 = this.cardInfos;
        if (r102 != null) goto L5;
        int r103 = 0;
    L7:
        return r101 + r103;
    L5:
        r103 = r102.hashCode();
        goto L7
    }

    public final String toString() {
        return "UpdatedGrouponInfo(serverTime=" + this.serverTime + ", cardInfos=" + this.cardInfos + ')';
    }

    public t0() {
        this.serverTime = 0;
        this.cardInfos = null;
    }

    public final List<LiveGoodsShelvesCard> a() {
        return this.cardInfos;
    }
}
