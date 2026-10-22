package bl2;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001b\u0010\u001cR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017¨\u0006\u001d"}, d2 = {"Lbl2/e;", "", "Lbl2/d;", "totalPopup", "Lbl2/d;", "d", "()Lbl2/d;", "setTotalPopup", "(Lbl2/d;)V", "", "Lbl2/c;", "couponCard", "Ljava/util/List;", "a", "()Ljava/util/List;", "setCouponCard", "(Ljava/util/List;)V", "", "durationTime", "J", "b", "()J", "setDurationTime", "(J)V", "exitTime", "c", "setExitTime", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e {

    @SerializedName("coupon_card")
    private List<c> couponCard;

    @SerializedName("enter_time")
    private long durationTime;

    @SerializedName("exit_time")
    private long exitTime;

    @SerializedName("popup")
    private d totalPopup;

    public e() {
    }

    public final List<c> a() {
        return this.couponCard;
    }

    public final long b() {
        return this.durationTime;
    }

    public final long c() {
        return this.exitTime;
    }

    public final d d() {
        return this.totalPopup;
    }
}
