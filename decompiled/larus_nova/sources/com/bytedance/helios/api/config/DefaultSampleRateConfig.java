package com.bytedance.helios.api.config;

import androidx.camera.video.AudioStats;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0000\b\u0016\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\nR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/bytedance/helios/api/config/DefaultSampleRateConfig;", "Ljava/io/Serializable;", "monitorNormal", "", "monitorError", "interceptError", "localSampleRate", "normalRate", "(DDDDD)V", "getInterceptError", "()D", "getLocalSampleRate", "getMonitorError", "monitorNormal$annotations", "()V", "getMonitorNormal", "getNormalRate", "toString", "", "api_release"}, k = 1, mv = {1, 1, 16})
public class DefaultSampleRateConfig implements Serializable {

    @SerializedName("intercept_error")
    private final double interceptError;

    @SerializedName("local_sample_rate")
    private final double localSampleRate;

    @SerializedName("monitor_error")
    private final double monitorError;

    @SerializedName("monitor_normal")
    private final double monitorNormal;

    @SerializedName("normal_rate")
    private final double normalRate;

    public DefaultSampleRateConfig() {
        this(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 31, null);
    }

    @Deprecated(message = "国内不适用")
    public static /* synthetic */ void monitorNormal$annotations() {
    }

    public String toString() {
        return "DefaultSampleRateConfig(monitorNormal=" + this.monitorNormal + ",monitorError=" + this.monitorError + ",interceptError=" + this.interceptError + ",localSampleRate=" + this.localSampleRate + ",normalRate=" + this.normalRate + ')';
    }

    public final double getInterceptError() {
        return this.interceptError;
    }

    public final double getLocalSampleRate() {
        return this.localSampleRate;
    }

    public final double getMonitorError() {
        return this.monitorError;
    }

    public final double getMonitorNormal() {
        return this.monitorNormal;
    }

    public final double getNormalRate() {
        return this.normalRate;
    }

    public DefaultSampleRateConfig(double r100, double r101, double r102, double r103, double r104) {
        this.monitorNormal = r100;
        this.monitorError = r101;
        this.interceptError = r102;
        this.localSampleRate = r103;
        this.normalRate = r104;
    }

    public /* synthetic */ DefaultSampleRateConfig(double r110, double r111, double r112, double r113, double r210, int r211, DefaultConstructorMarker r212) {
        int r100 = r211 & 1;
        double r101 = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (r100 == 0) goto L5;
        double r102 = 0.0d;
    L7:
        if ((r211 & 2) == 0) goto L9;
        double r103 = 0.01d;
    L10:
        double r104 = 1.0d;
        if ((r211 & 4) == 0) goto L13;
        double r105 = 1.0d;
    L15:
        if ((r211 & 8) != 0) goto L19;
        r104 = r113;
    L19:
        if ((r211 & 16) != 0) goto L22;
        r101 = r210;
    L22:
        this(r102, r103, r105, r104, r101);
        return;
    L13:
        r105 = r112;
        goto L15
    L9:
        r103 = r111;
        goto L10
    L5:
        r102 = r110;
        goto L7
    }
}
