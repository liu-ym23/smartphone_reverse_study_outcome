package xi2;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b$\u0010%R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R*\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010!\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u000e\u001a\u0004\b\"\u0010\u0010\"\u0004\b#\u0010\u0012¨\u0006&"}, d2 = {"Lxi2/d;", "", "", "minFindTime", "J", "d", "()J", "setMinFindTime", "(J)V", "maxFindTime", "c", "setMaxFindTime", "", "isFixedFindTime", "Z", "f", "()Z", "setFixedFindTime", "(Z)V", "", "hint", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setHint", "(Ljava/lang/String;)V", "", "deliveryDelayTimeRange", "Ljava/util/List;", "a", "()Ljava/util/List;", "setDeliveryDelayTimeRange", "(Ljava/util/List;)V", "support", "e", "setSupport", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("delivery_delay_time_range")
    private List<Long> deliveryDelayTimeRange;

    @SerializedName("hint")
    private String hint;

    @SerializedName("is_fixed_find_time")
    private boolean isFixedFindTime;

    @SerializedName("max_find_time")
    private long maxFindTime;

    @SerializedName("min_find_time")
    private long minFindTime;

    @SerializedName("support")
    private boolean support;

    public d() {
    }

    public final List<Long> a() {
        return this.deliveryDelayTimeRange;
    }

    public final String b() {
        return this.hint;
    }

    public final long c() {
        return this.maxFindTime;
    }

    public final long d() {
        return this.minFindTime;
    }

    public final boolean e() {
        return this.support;
    }

    public final boolean f() {
        return this.isFixedFindTime;
    }
}
