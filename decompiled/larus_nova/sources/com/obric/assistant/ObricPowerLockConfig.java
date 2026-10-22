package com.obric.assistant;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\tHÆ\u0003JJ\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\rR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0010\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\""}, d2 = {"Lcom/obric/assistant/ObricPowerLockConfig;", "", "obricFrontierLockTimeout", "", "obricKeepFrontierAliveLoopInterval", "obricNetworkKeepAliveLockReleaseDelay", "obricNetworkInterceptConfig", "Lcom/obric/assistant/ObricNetworkInterceptConfig;", "obricAiAgentNetworkInterceptConfig", "Lcom/obric/assistant/ObricAIagentNetworkInterceptConfig;", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/obric/assistant/ObricNetworkInterceptConfig;Lcom/obric/assistant/ObricAIagentNetworkInterceptConfig;)V", "getObricFrontierLockTimeout", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getObricKeepFrontierAliveLoopInterval", "getObricNetworkKeepAliveLockReleaseDelay", "getObricNetworkInterceptConfig", "()Lcom/obric/assistant/ObricNetworkInterceptConfig;", "getObricAiAgentNetworkInterceptConfig", "()Lcom/obric/assistant/ObricAIagentNetworkInterceptConfig;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/obric/assistant/ObricNetworkInterceptConfig;Lcom/obric/assistant/ObricAIagentNetworkInterceptConfig;)Lcom/obric/assistant/ObricPowerLockConfig;", "equals", "", "other", "hashCode", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricPowerLockConfig {

    @SerializedName("obric_aiagent_network_intercept_config")
    private final ObricAIagentNetworkInterceptConfig obricAiAgentNetworkInterceptConfig;

    @SerializedName("obric_frontier_lock_timeout")
    private final Integer obricFrontierLockTimeout;

    @SerializedName("obric_keep_frontier_alive_loop_interval")
    private final Integer obricKeepFrontierAliveLoopInterval;

    @SerializedName("obric_network_intercept_config")
    private final ObricNetworkInterceptConfig obricNetworkInterceptConfig;

    @SerializedName("obric_network_keep_alive_lock_release_delay")
    private final Integer obricNetworkKeepAliveLockReleaseDelay;

    public ObricPowerLockConfig() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ ObricPowerLockConfig copy$default(ObricPowerLockConfig r100, Integer r101, Integer r102, Integer r103, ObricNetworkInterceptConfig r104, ObricAIagentNetworkInterceptConfig r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.obricFrontierLockTimeout;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.obricKeepFrontierAliveLoopInterval;
    L8:
        Integer r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.obricNetworkKeepAliveLockReleaseDelay;
    L11:
        Integer r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.obricNetworkInterceptConfig;
    L14:
        ObricNetworkInterceptConfig r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.obricAiAgentNetworkInterceptConfig;
    L17:
        Integer r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final Integer component1() {
        return this.obricFrontierLockTimeout;
    }

    public final Integer component2() {
        return this.obricKeepFrontierAliveLoopInterval;
    }

    public final Integer component3() {
        return this.obricNetworkKeepAliveLockReleaseDelay;
    }

    public final ObricNetworkInterceptConfig component4() {
        return this.obricNetworkInterceptConfig;
    }

    public final ObricAIagentNetworkInterceptConfig component5() {
        return this.obricAiAgentNetworkInterceptConfig;
    }

    public final ObricPowerLockConfig copy(Integer r100, Integer r101, Integer r110, ObricNetworkInterceptConfig r111, ObricAIagentNetworkInterceptConfig r112) {
        return new ObricPowerLockConfig(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ObricPowerLockConfig) == true) goto L8;
        return false;
    L8:
        ObricPowerLockConfig r101 = (ObricPowerLockConfig) r100;
        if (Intrinsics.areEqual(this.obricFrontierLockTimeout, r101.obricFrontierLockTimeout) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.obricKeepFrontierAliveLoopInterval, r101.obricKeepFrontierAliveLoopInterval) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.obricNetworkKeepAliveLockReleaseDelay, r101.obricNetworkKeepAliveLockReleaseDelay) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.obricNetworkInterceptConfig, r101.obricNetworkInterceptConfig) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.obricAiAgentNetworkInterceptConfig, r101.obricAiAgentNetworkInterceptConfig) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.obricFrontierLockTimeout;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.obricKeepFrontierAliveLoopInterval;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.obricNetworkKeepAliveLockReleaseDelay;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        ObricNetworkInterceptConfig r110 = this.obricNetworkInterceptConfig;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        ObricAIagentNetworkInterceptConfig r113 = this.obricAiAgentNetworkInterceptConfig;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "ObricPowerLockConfig(obricFrontierLockTimeout=" + this.obricFrontierLockTimeout + ", obricKeepFrontierAliveLoopInterval=" + this.obricKeepFrontierAliveLoopInterval + ", obricNetworkKeepAliveLockReleaseDelay=" + this.obricNetworkKeepAliveLockReleaseDelay + ", obricNetworkInterceptConfig=" + this.obricNetworkInterceptConfig + ", obricAiAgentNetworkInterceptConfig=" + this.obricAiAgentNetworkInterceptConfig + ')';
    }

    public final ObricAIagentNetworkInterceptConfig getObricAiAgentNetworkInterceptConfig() {
        return this.obricAiAgentNetworkInterceptConfig;
    }

    public final Integer getObricFrontierLockTimeout() {
        return this.obricFrontierLockTimeout;
    }

    public final Integer getObricKeepFrontierAliveLoopInterval() {
        return this.obricKeepFrontierAliveLoopInterval;
    }

    public final ObricNetworkInterceptConfig getObricNetworkInterceptConfig() {
        return this.obricNetworkInterceptConfig;
    }

    public final Integer getObricNetworkKeepAliveLockReleaseDelay() {
        return this.obricNetworkKeepAliveLockReleaseDelay;
    }

    public ObricPowerLockConfig(Integer r100, Integer r101, Integer r102, ObricNetworkInterceptConfig r103, ObricAIagentNetworkInterceptConfig r104) {
        this.obricFrontierLockTimeout = r100;
        this.obricKeepFrontierAliveLoopInterval = r101;
        this.obricNetworkKeepAliveLockReleaseDelay = r102;
        this.obricNetworkInterceptConfig = r103;
        this.obricAiAgentNetworkInterceptConfig = r104;
    }

    public /* synthetic */ ObricPowerLockConfig(Integer r110, Integer r111, Integer r112, ObricNetworkInterceptConfig r113, ObricAIagentNetworkInterceptConfig r114, int r115, DefaultConstructorMarker r116) {
        if ((r115 & 1) == 0) goto L5;
        Integer r100 = 600;
    L7:
        if ((r115 & 2) == 0) goto L9;
        Integer r101 = 1;
    L11:
        if ((r115 & 4) == 0) goto L13;
        Integer r102 = 15;
    L15:
        if ((r115 & 8) == 0) goto L17;
        ObricNetworkInterceptConfig r103 = new ObricNetworkInterceptConfig(null, null, null, null, null, 31, null);
    L19:
        if ((r115 & 16) == 0) goto L21;
        ObricAIagentNetworkInterceptConfig r104 = new ObricAIagentNetworkInterceptConfig(null, null, null, 7, null);
    L22:
        this(r100, r101, r102, r103, r104);
        return;
    L21:
        r104 = r114;
        goto L22
    L17:
        r103 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
