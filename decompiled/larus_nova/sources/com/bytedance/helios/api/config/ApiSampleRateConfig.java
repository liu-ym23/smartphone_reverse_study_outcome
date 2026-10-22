package com.bytedance.helios.api.config;

import androidx.camera.video.AudioStats;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002BG\u0012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007¢\u0006\u0002\u0010\fJ\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/bytedance/helios/api/config/ApiSampleRateConfig;", "Lcom/bytedance/helios/api/config/DefaultSampleRateConfig;", "Ljava/io/Serializable;", "apiIds", "", "", "monitorNormal", "", "monitorError", "interceptError", "localSampleRate", "normalRate", "(Ljava/util/List;DDDDD)V", "getApiIds", "()Ljava/util/List;", "toString", "", "api_release"}, k = 1, mv = {1, 1, 16})
public final class ApiSampleRateConfig extends DefaultSampleRateConfig {

    @SerializedName("api_ids")
    private final List<Integer> apiIds;

    public ApiSampleRateConfig() {
        this(null, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 63, null);
    }

    @Override // com.bytedance.helios.api.config.DefaultSampleRateConfig
    public String toString() {
        return "ApiSampleRateConfig(apiIds='" + this.apiIds + "',monitorNormal=" + getMonitorNormal() + ",monitorError=" + getMonitorError() + ",interceptError=" + getInterceptError() + ",localSampleRate=" + getLocalSampleRate() + ",normalRate=" + getNormalRate() + ')';
    }

    public final List<Integer> getApiIds() {
        return this.apiIds;
    }

    public ApiSampleRateConfig(List<Integer> r110, double r111, double r112, double r113, double r114, double r210) {
        super(r111, r112, r113, r114, r210);
        this.apiIds = r110;
    }

    public /* synthetic */ ApiSampleRateConfig(List r110, double r111, double r112, double r113, double r210, double r211, int r212, DefaultConstructorMarker r213) {
        if ((r212 & 1) == 0) goto L5;
        List r100 = CollectionsKt.emptyList();
    L6:
        int r101 = r212 & 2;
        double r102 = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (r101 == 0) goto L9;
        double r103 = 0.0d;
    L11:
        if ((r212 & 4) == 0) goto L13;
        double r104 = 0.01d;
    L14:
        double r105 = 1.0d;
        if ((r212 & 8) == 0) goto L17;
        double r114 = 1.0d;
    L19:
        if ((r212 & 16) != 0) goto L23;
        r105 = r210;
    L23:
        if ((r212 & 32) != 0) goto L26;
        r102 = r211;
    L26:
        this(r100, r103, r104, r114, r105, r102);
        return;
    L17:
        r114 = r113;
        goto L19
    L13:
        r104 = r112;
        goto L14
    L9:
        r103 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L6
    }
}
