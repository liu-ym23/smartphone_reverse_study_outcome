package com.bytedance.locallife.poi.experiment;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import com.lynx.canvas.KryptonCamera;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class PoiChunkDelayStrategyExperiment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f262561a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f262562b = null;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/bytedance/locallife/poi/experiment/PoiChunkDelayStrategyExperiment$a;", "", "", BdpAppEventConstant.PARAMS_STRATEGY_NAME, "I", "getStrategy", "()I", "Lcom/bytedance/locallife/poi/experiment/PoiChunkDelayStrategyExperiment$b;", "maxDelayTimeConfig", "Lcom/bytedance/locallife/poi/experiment/PoiChunkDelayStrategyExperiment$b;", "getMaxDelayTimeConfig", "()Lcom/bytedance/locallife/poi/experiment/PoiChunkDelayStrategyExperiment$b;", "extraDelayTimeConfig", "getExtraDelayTimeConfig", "intervalUpdateTimeOutConfig", "getIntervalUpdateTimeOutConfig", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("extra_delay_time_config")
        private final b extraDelayTimeConfig;

        @SerializedName("interval_timeout_config")
        private final b intervalUpdateTimeOutConfig;

        @SerializedName("max_delay_time_config")
        private final b maxDelayTimeConfig;

        @SerializedName(BdpAppEventConstant.PARAMS_STRATEGY_NAME)
        private final int strategy;

        public a() {
            this(null, null, 15);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.strategy == r101.strategy) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.maxDelayTimeConfig, r101.maxDelayTimeConfig) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.extraDelayTimeConfig, r101.extraDelayTimeConfig) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.intervalUpdateTimeOutConfig, r101.intervalUpdateTimeOutConfig) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = this.strategy * 31;
            b r101 = this.maxDelayTimeConfig;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            b r105 = this.extraDelayTimeConfig;
            if (r105 != null) goto L9;
            int r106 = 0;
        L10:
            int r107 = (r104 + r106) * 31;
            b r108 = this.intervalUpdateTimeOutConfig;
            if (r108 == null) goto L15;
            r102 = r108.hashCode();
        L15:
            return r107 + r102;
        L9:
            r106 = r105.hashCode();
            goto L10
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "DelayStrategyConfig(strategy=" + this.strategy + ", maxDelayTimeConfig=" + this.maxDelayTimeConfig + ", extraDelayTimeConfig=" + this.extraDelayTimeConfig + ", intervalUpdateTimeOutConfig=" + this.intervalUpdateTimeOutConfig + ')';
        }

        public final long a(int r100) {
            if (r100 != 0) goto L5;
            b r101 = this.maxDelayTimeConfig;
            if (r101 != null) goto L25;
            return 3000;
        L25:
            return r101.d();
        L5:
            if (r100 != 1) goto L7;
            b r102 = this.maxDelayTimeConfig;
            if (r102 != null) goto L31;
            return 3000;
        L31:
            return r102.c();
        L7:
            if (r100 != 2) goto L9;
            b r103 = this.maxDelayTimeConfig;
            if (r103 != null) goto L28;
            return 2000;
        L28:
            return r103.b();
        L9:
            if (r100 != 3) goto L33;
            b r104 = this.maxDelayTimeConfig;
            if (r104 != null) goto L26;
            return 1500;
        L26:
            return r104.a();
        L33:
            return 3000;
        }

        public final long b(int r100) {
            if (r100 != 0) goto L5;
            b r101 = this.intervalUpdateTimeOutConfig;
            if (r101 != null) goto L25;
            return 800;
        L25:
            return r101.d();
        L5:
            if (r100 != 1) goto L7;
            b r102 = this.intervalUpdateTimeOutConfig;
            if (r102 != null) goto L32;
            return 800;
        L32:
            return r102.c();
        L7:
            if (r100 != 2) goto L9;
            b r103 = this.intervalUpdateTimeOutConfig;
            if (r103 != null) goto L29;
            return 600;
        L29:
            return r103.b();
        L9:
            if (r100 == 3) goto L11;
            return 0;
        L11:
            b r104 = this.intervalUpdateTimeOutConfig;
            if (r104 != null) goto L27;
            return 500;
        L27:
            return r104.a();
        }

        public a(b r100, b r101, int r102) {
            if ((r102 & 2) == 0) goto L6;
            r100 = null;
        L6:
            if ((r102 & 4) == 0) goto L8;
            r101 = null;
        L8:
            this.strategy = 0;
            this.maxDelayTimeConfig = r100;
            this.extraDelayTimeConfig = r101;
            this.intervalUpdateTimeOutConfig = null;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/bytedance/locallife/poi/experiment/PoiChunkDelayStrategyExperiment$b;", "", "", "high", "J", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()J", KryptonCamera.Config.RESOLUTION_MEDIUM, "b", "poor", "c", "unknown", "d", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("high")
        private final long high;

        @SerializedName(KryptonCamera.Config.RESOLUTION_MEDIUM)
        private final long medium;

        @SerializedName("poor")
        private final long poor;

        @SerializedName("unknown")
        private final long unknown;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.high == r101.high) goto L12;
            return false;
        L12:
            if (this.medium == r101.medium) goto L15;
            return false;
        L15:
            if (this.poor == r101.poor) goto L18;
            return false;
        L18:
            if (this.unknown == r101.unknown) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            long r100 = this.high;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            long r102 = this.medium;
            int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
            long r104 = this.poor;
            int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
            long r106 = this.unknown;
            return r105 + ((int) (r106 ^ (r106 >>> 32)));
        }

        public final String toString() {
            return "DelayTimeConfig(high=" + this.high + ", medium=" + this.medium + ", poor=" + this.poor + ", unknown=" + this.unknown + ')';
        }

        public b() {
            this(500, 1000, 1500, 1500);
        }

        public final long a() {
            return this.high;
        }

        public final long b() {
            return this.medium;
        }

        public final long c() {
            return this.poor;
        }

        public final long d() {
            return this.unknown;
        }

        public b(long r100, long r101, long r102, long r103) {
            this.high = r100;
            this.medium = r101;
            this.poor = r102;
            this.unknown = r103;
        }
    }

    static {
        f262561a = new a(new b(1500, 2000, 3000, 3000), new b(0, 0, 0, 0), 8);
        f262562b = LazyKt.lazy(LazyThreadSafetyMode.NONE, PoiChunkDelayStrategyExperiment$value$2.INSTANCE);
    }
}
