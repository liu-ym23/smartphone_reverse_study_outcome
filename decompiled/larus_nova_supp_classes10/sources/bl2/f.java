package bl2;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\"\u0010#R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0019\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010\u001f\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0013\u001a\u0004\b \u0010\u0015\"\u0004\b!\u0010\u0017¨\u0006$"}, d2 = {"Lbl2/f;", "Lcom/bytedance/android/ec/model/g;", "", "applyStatus", "J", "a", "()J", "setApplyStatus", "(J)V", "", "Lbl2/c;", "couponCard", "Ljava/util/List;", "b", "()Ljava/util/List;", "setCouponCard", "(Ljava/util/List;)V", "", "toast", "Ljava/lang/String;", "getToast", "()Ljava/lang/String;", "setToast", "(Ljava/lang/String;)V", "", "errNo", "I", "c", "()I", "setErrNo", "(I)V", "errTips", "getErrTips", "setErrTips", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f extends com.bytedance.android.ec.model.g {

    @SerializedName("apply_status")
    private long applyStatus;

    @SerializedName("coupon_card")
    private List<c> couponCard;

    @SerializedName("err_no")
    private int errNo;

    @SerializedName("err_tips")
    private String errTips;

    @SerializedName("toast")
    private String toast;

    public static final class a {
    }

    static {
    }

    public f() {
    }

    public final long a() {
        return this.applyStatus;
    }

    public final List<c> b() {
        return this.couponCard;
    }

    public final int c() {
        return this.errNo;
    }
}
