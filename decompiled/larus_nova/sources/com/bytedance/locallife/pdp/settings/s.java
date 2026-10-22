package com.bytedance.locallife.pdp.settings;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f261749a = null;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0013\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/bytedance/locallife/pdp/settings/s$a;", "", "", "optOpen", "Z", "getOptOpen", "()Z", "", "recoveryStrategy", "I", "b", "()I", "", "recoveryTime", "J", "c", "()J", "maxRecoveryTime", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "reportDelayTime", "d", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("max_recovery_time")
        private final long maxRecoveryTime;

        @SerializedName("opt_open")
        private final boolean optOpen;

        @SerializedName("recovery_strategy")
        private final int recoveryStrategy;

        @SerializedName("recovery_time")
        private final long recoveryTime;

        @SerializedName("report_delay_time")
        private final long reportDelayTime;

        public a() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.optOpen == r101.optOpen) goto L12;
            return false;
        L12:
            if (this.recoveryStrategy == r101.recoveryStrategy) goto L15;
            return false;
        L15:
            if (this.recoveryTime == r101.recoveryTime) goto L18;
            return false;
        L18:
            if (this.maxRecoveryTime == r101.maxRecoveryTime) goto L21;
            return false;
        L21:
            if (this.reportDelayTime == r101.reportDelayTime) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            if (this.optOpen == false) goto L5;
            int r100 = 1231;
        L6:
            int r101 = ((r100 * 31) + this.recoveryStrategy) * 31;
            long r102 = this.recoveryTime;
            int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
            long r104 = this.maxRecoveryTime;
            int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
            long r106 = this.reportDelayTime;
            return r105 + ((int) (r106 ^ (r106 >>> 32)));
        L5:
            r100 = 1237;
            goto L6
        }

        public final String toString() {
            return "GoodsDetailJSThreadOptConfig(optOpen=" + this.optOpen + ", recoveryStrategy=" + this.recoveryStrategy + ", recoveryTime=" + this.recoveryTime + ", maxRecoveryTime=" + this.maxRecoveryTime + ", reportDelayTime=" + this.reportDelayTime + ')';
        }

        public final long a() {
            return this.maxRecoveryTime;
        }

        public final int b() {
            return this.recoveryStrategy;
        }

        public final long c() {
            return this.recoveryTime;
        }

        public final long d() {
            return this.reportDelayTime;
        }

        public a(int r100) {
            this.optOpen = false;
            this.recoveryStrategy = 0;
            this.recoveryTime = 500;
            this.maxRecoveryTime = 1500;
            this.reportDelayTime = 5000;
        }
    }

    static {
        f261749a = new a(0);
    }
}
