package si2;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0012\u0018\u00002\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0014"}, d2 = {"Lsi2/n;", "", "", "delayLongMin", "I", "b", "()I", "setDelayLongMin", "(I)V", "delayLongMax", "a", "setDelayLongMax", "delayShortMin", "d", "setDelayShortMin", "delayShortMax", "c", "setDelayShortMax", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class n {
    public static final n a = null;

    @SerializedName("delay_long_max")
    private int delayLongMax;

    @SerializedName("delay_long_min")
    private int delayLongMin;

    @SerializedName("delay_short_max")
    private int delayShortMax;

    @SerializedName("delay_short_min")
    private int delayShortMin;

    public static final class a {
    }

    static {
        a = new n();
    }

    public n() {
        this.delayLongMax = 10;
        this.delayShortMax = 3;
    }

    public final int a() {
        return this.delayLongMax;
    }

    public final int b() {
        return this.delayLongMin;
    }

    public final int c() {
        return this.delayShortMax;
    }

    public final int d() {
        return this.delayShortMin;
    }
}
