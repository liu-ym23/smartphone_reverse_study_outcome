package nv6;

import com.bytedance.ee.bear.unbundle.BenefitStore;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u0013"}, d2 = {"Lnv6/c;", "", "", "ageLimit", "J", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()J", "", "enable", "Z", "b", "()Z", "", "randomTime", "I", "c", "()I", "delayLevel", "getDelayLevel", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f520898a;

    @SerializedName("age_limit")
    private final long ageLimit;

    @SerializedName("delay_level")
    private final int delayLevel;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("random_time")
    private final int randomTime;

    public c() {
        this(0, 0, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.ageLimit == r101.ageLimit) goto L12;
        return false;
    L12:
        if (this.enable == r101.enable) goto L15;
        return false;
    L15:
        if (this.randomTime == r101.randomTime) goto L18;
        return false;
    L18:
        if (this.delayLevel == r101.delayLevel) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        long r100 = this.ageLimit;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        if (this.enable == false) goto L5;
        int r102 = 1231;
    L7:
        return ((((r101 + r102) * 31) + this.randomTime) * 31) + this.delayLevel;
    L5:
        r102 = 1237;
        goto L7
    }

    public final String toString() {
        return "AggPreloadConfig(ageLimit=" + this.ageLimit + ", enable=" + this.enable + ", randomTime=" + this.randomTime + ", delayLevel=" + this.delayLevel + ')';
    }

    public final long a() {
        return this.ageLimit;
    }

    public final boolean b() {
        return this.enable;
    }

    public final int c() {
        return this.randomTime;
    }

    public c(long r100, int r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 300000;
    L6:
        if ((r102 & 4) == 0) goto L8;
        r101 = 1000;
    L8:
        this.ageLimit = r100;
        this.enable = false;
        this.randomTime = r101;
        this.delayLevel = 0;
        this.f520898a = BenefitStore.FROM_SERVER;
    }
}
