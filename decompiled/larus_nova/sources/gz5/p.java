package gz5;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001a\u0010\u000f\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0014\u001a\u00020\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lgz5/p;", "", "", "maxCalledTimes", "I", "b", "()I", "", "timeInterval", "J", "e", "()J", "maxStoreSize", "c", "", "name", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "Lgz5/q;", "guardRange", "Lgz5/q;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lgz5/q;", "api_release"}, k = 1, mv = {1, 4, 0})
public final class p {

    @SerializedName("guard_range")
    private final q guardRange;

    @SerializedName("max_called_times")
    private final int maxCalledTimes;

    @SerializedName("max_store_size")
    private final int maxStoreSize;

    @SerializedName("name")
    private final String name;

    @SerializedName("time_interval")
    private final long timeInterval;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof p) == false) goto L16;
        p r101 = (p) r100;
        if (this.maxCalledTimes == r101.maxCalledTimes) goto L8;
        return false;
    L8:
        if (this.timeInterval == r101.timeInterval) goto L10;
        return false;
    L10:
        if (this.maxStoreSize == r101.maxStoreSize) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.guardRange, r101.guardRange) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        int r100 = this.maxCalledTimes * 31;
        long r101 = this.timeInterval;
        int r102 = (((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.maxStoreSize) * 31;
        String r103 = this.name;
        int r104 = 0;
        if (r103 == null) goto L5;
        int r105 = r103.hashCode();
    L6:
        int r106 = (r102 + r105) * 31;
        q r107 = this.guardRange;
        if (r107 == null) goto L10;
        r104 = r107.hashCode();
    L10:
        return r106 + r104;
    L5:
        r105 = 0;
        goto L6
    }

    public final String toString() {
        return "FrequencyConfig(maxCalledTimes=" + this.maxCalledTimes + ", timeInterval=" + this.timeInterval + ", maxStoreSize=" + this.maxStoreSize + ", name=" + this.name + ", guardRange=" + this.guardRange + ")";
    }

    public p() {
        long r100 = TimeUnit.MINUTES.toMillis(1);
        q r101 = new q(null);
        this.maxCalledTimes = 10;
        this.timeInterval = r100;
        this.maxStoreSize = 100;
        this.name = "";
        this.guardRange = r101;
    }

    public final q a() {
        return this.guardRange;
    }

    public final int b() {
        return this.maxCalledTimes;
    }

    public final int c() {
        return this.maxStoreSize;
    }

    public final String d() {
        return this.name;
    }

    public final long e() {
        return this.timeInterval;
    }
}
