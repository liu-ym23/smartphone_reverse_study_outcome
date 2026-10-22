package com.ss.android.lark.monitor.abtest;

import androidx.camera.video.AudioStats;
import com.google.gson.annotations.SerializedName;
import iua.b;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes36.dex */
public final class PerfMonitorExperiment extends iua.a<PerfMonitorConfig> {

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/monitor/abtest/PerfMonitorExperiment$PerfMonitorConfig;", "", "cpuIdleFrequencyThreshold", "", "cpuIdleTimesThreshold", "", "bootMonitorIntervalInMills", "", "<init>", "(DIJ)V", "getCpuIdleFrequencyThreshold", "()D", "getCpuIdleTimesThreshold", "()I", "getBootMonitorIntervalInMills", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "monitor_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PerfMonitorConfig {

        @SerializedName("boot_monitor_interval_in_mills")
        private final long bootMonitorIntervalInMills;

        @SerializedName("cpu_idle_frequency_threshold")
        private final double cpuIdleFrequencyThreshold;

        @SerializedName("cpu_idle_times_threshold")
        private final int cpuIdleTimesThreshold;

        public PerfMonitorConfig() {
            this(AudioStats.AUDIO_AMPLITUDE_NONE, 0, 0, 7, null);
        }

        public static /* synthetic */ PerfMonitorConfig copy$default(PerfMonitorConfig r100, double r101, int r102, long r110, int r111, Object r112) {
            if ((r111 & 1) == 0) goto L5;
            r101 = r100.cpuIdleFrequencyThreshold;
        L5:
            double r103 = r101;
            if ((r111 & 2) == 0) goto L8;
            r102 = r100.cpuIdleTimesThreshold;
        L8:
            int r104 = r102;
            if ((r111 & 4) == 0) goto L12;
            r110 = r100.bootMonitorIntervalInMills;
        L12:
            return r100.copy(r103, r104, r110);
        }

        public final double component1() {
            return this.cpuIdleFrequencyThreshold;
        }

        public final int component2() {
            return this.cpuIdleTimesThreshold;
        }

        public final long component3() {
            return this.bootMonitorIntervalInMills;
        }

        public final PerfMonitorConfig copy(double r100, int r110, long r111) {
            return new PerfMonitorConfig(r100, r110, r111);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof PerfMonitorConfig) == true) goto L8;
            return false;
        L8:
            PerfMonitorConfig r101 = (PerfMonitorConfig) r100;
            if (Double.compare(this.cpuIdleFrequencyThreshold, r101.cpuIdleFrequencyThreshold) == 0) goto L12;
            return false;
        L12:
            if (this.cpuIdleTimesThreshold == r101.cpuIdleTimesThreshold) goto L15;
            return false;
        L15:
            if (this.bootMonitorIntervalInMills == r101.bootMonitorIntervalInMills) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            long r100 = Double.doubleToLongBits(this.cpuIdleFrequencyThreshold);
            int r101 = ((((int) (r100 ^ (r100 >>> 32))) * 31) + this.cpuIdleTimesThreshold) * 31;
            long r102 = this.bootMonitorIntervalInMills;
            return r101 + ((int) (r102 ^ (r102 >>> 32)));
        }

        public String toString() {
            return "PerfMonitorConfig(cpuIdleFrequencyThreshold=" + this.cpuIdleFrequencyThreshold + ", cpuIdleTimesThreshold=" + this.cpuIdleTimesThreshold + ", bootMonitorIntervalInMills=" + this.bootMonitorIntervalInMills + ')';
        }

        public final long getBootMonitorIntervalInMills() {
            return this.bootMonitorIntervalInMills;
        }

        public final double getCpuIdleFrequencyThreshold() {
            return this.cpuIdleFrequencyThreshold;
        }

        public final int getCpuIdleTimesThreshold() {
            return this.cpuIdleTimesThreshold;
        }

        public PerfMonitorConfig(double r100, int r101, long r102) {
            this.cpuIdleFrequencyThreshold = r100;
            this.cpuIdleTimesThreshold = r101;
            this.bootMonitorIntervalInMills = r102;
        }

        public /* synthetic */ PerfMonitorConfig(double r100, int r101, long r110, int r111, DefaultConstructorMarker r112) {
            if ((r111 & 1) == 0) goto L5;
            r100 = 30.0d;
        L5:
            double r102 = r100;
            if ((r111 & 2) == 0) goto L8;
            int r103 = 1;
        L10:
            if ((r111 & 4) == 0) goto L12;
            r110 = 30000;
        L12:
            this(r102, r103, r110);
            return;
        L8:
            r103 = r101;
            goto L10
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // iua.a
    public final boolean isSticky() {
        return true;
    }

    @Override // iua.a
    public final PerfMonitorConfig getDefault() {
        return new PerfMonitorConfig(AudioStats.AUDIO_AMPLITUDE_NONE, 0, 0, 7, null);
    }

    @Override // iua.a
    public final b getLarkExperimentInfo() {
        return new b("performance_monitor_config", "performance monitor configure experiment A/B test");
    }

    public PerfMonitorExperiment() {
    }
}
