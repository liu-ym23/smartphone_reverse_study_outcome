package com.larus.network.config;

import com.google.gson.annotations.SerializedName;
import em9.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\nHÆ\u0003JV\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0012\u0010\u000eR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0013\u0010\u000eR\u001a\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0014\u0010\u000eR\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006%"}, d2 = {"Lcom/larus/network/config/BackgroundControlConfig;", "", "enable", "", "networkInterceptorConfig", "Lcom/larus/network/config/NetworkInterceptConfig;", "collectBackgroundOsResourcesApply", "shouldRunInPureMode", "shouldRunInMergeMode", "backgroundNetworkModeConfig", "Lcom/larus/network/config/BackgroundNetworkModeConfig;", "<init>", "(Ljava/lang/Boolean;Lcom/larus/network/config/NetworkInterceptConfig;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/larus/network/config/BackgroundNetworkModeConfig;)V", "getEnable", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getNetworkInterceptorConfig", "()Lcom/larus/network/config/NetworkInterceptConfig;", "getCollectBackgroundOsResourcesApply", "getShouldRunInPureMode", "getShouldRunInMergeMode", "getBackgroundNetworkModeConfig", "()Lcom/larus/network/config/BackgroundNetworkModeConfig;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Boolean;Lcom/larus/network/config/NetworkInterceptConfig;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/larus/network/config/BackgroundNetworkModeConfig;)Lcom/larus/network/config/BackgroundControlConfig;", "equals", "other", "hashCode", "", "toString", "", "ttnet_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BackgroundControlConfig {

    @SerializedName("background_network_mode_config")
    private final BackgroundNetworkModeConfig backgroundNetworkModeConfig;

    @SerializedName("collect_background_os_resource_apply")
    private final Boolean collectBackgroundOsResourcesApply;

    @SerializedName("enable")
    private final Boolean enable;

    @SerializedName("network_intercept_config")
    private final a networkInterceptorConfig;

    @SerializedName("should_run_in_merge_mode")
    private final Boolean shouldRunInMergeMode;

    @SerializedName("should_run_in_pure_mode")
    private final Boolean shouldRunInPureMode;

    public BackgroundControlConfig() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ BackgroundControlConfig copy$default(BackgroundControlConfig r100, Boolean r101, a r102, Boolean r103, Boolean r104, Boolean r105, BackgroundNetworkModeConfig r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.enable;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.networkInterceptorConfig;
    L8:
        a r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.collectBackgroundOsResourcesApply;
    L11:
        Boolean r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.shouldRunInPureMode;
    L14:
        Boolean r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.shouldRunInMergeMode;
    L17:
        Boolean r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.backgroundNetworkModeConfig;
    L20:
        Boolean r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final Boolean component1() {
        return this.enable;
    }

    public final a component2() {
        return this.networkInterceptorConfig;
    }

    public final Boolean component3() {
        return this.collectBackgroundOsResourcesApply;
    }

    public final Boolean component4() {
        return this.shouldRunInPureMode;
    }

    public final Boolean component5() {
        return this.shouldRunInMergeMode;
    }

    public final BackgroundNetworkModeConfig component6() {
        return this.backgroundNetworkModeConfig;
    }

    public final BackgroundControlConfig copy(Boolean r100, a r110, Boolean r111, Boolean r112, Boolean r113, BackgroundNetworkModeConfig r114) {
        return new BackgroundControlConfig(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BackgroundControlConfig) == true) goto L8;
        return false;
    L8:
        BackgroundControlConfig r101 = (BackgroundControlConfig) r100;
        if (Intrinsics.areEqual(this.enable, r101.enable) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.networkInterceptorConfig, r101.networkInterceptorConfig) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.collectBackgroundOsResourcesApply, r101.collectBackgroundOsResourcesApply) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.shouldRunInPureMode, r101.shouldRunInPureMode) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.shouldRunInMergeMode, r101.shouldRunInMergeMode) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.backgroundNetworkModeConfig, r101.backgroundNetworkModeConfig) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        Boolean r100 = this.enable;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        a r104 = this.networkInterceptorConfig;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.collectBackgroundOsResourcesApply;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.shouldRunInPureMode;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.shouldRunInMergeMode;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        BackgroundNetworkModeConfig r116 = this.backgroundNetworkModeConfig;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
    L21:
        r114 = r113.hashCode();
        goto L22
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
        return "BackgroundControlConfig(enable=" + this.enable + ", networkInterceptorConfig=" + this.networkInterceptorConfig + ", collectBackgroundOsResourcesApply=" + this.collectBackgroundOsResourcesApply + ", shouldRunInPureMode=" + this.shouldRunInPureMode + ", shouldRunInMergeMode=" + this.shouldRunInMergeMode + ", backgroundNetworkModeConfig=" + this.backgroundNetworkModeConfig + ')';
    }

    public final BackgroundNetworkModeConfig getBackgroundNetworkModeConfig() {
        return this.backgroundNetworkModeConfig;
    }

    public final Boolean getCollectBackgroundOsResourcesApply() {
        return this.collectBackgroundOsResourcesApply;
    }

    public final Boolean getEnable() {
        return this.enable;
    }

    public final a getNetworkInterceptorConfig() {
        return this.networkInterceptorConfig;
    }

    public final Boolean getShouldRunInMergeMode() {
        return this.shouldRunInMergeMode;
    }

    public final Boolean getShouldRunInPureMode() {
        return this.shouldRunInPureMode;
    }

    public BackgroundControlConfig(Boolean r100, a r101, Boolean r102, Boolean r103, Boolean r104, BackgroundNetworkModeConfig r105) {
        this.enable = r100;
        this.networkInterceptorConfig = r101;
        this.collectBackgroundOsResourcesApply = r102;
        this.shouldRunInPureMode = r103;
        this.shouldRunInMergeMode = r104;
        this.backgroundNetworkModeConfig = r105;
    }

    public /* synthetic */ BackgroundControlConfig(Boolean r110, a r111, Boolean r112, Boolean r113, Boolean r210, BackgroundNetworkModeConfig r211, int r212, DefaultConstructorMarker r213) {
        if ((r212 & 1) == 0) goto L5;
        Boolean r100 = Boolean.TRUE;
    L7:
        if ((r212 & 2) == 0) goto L9;
        a r101 = new a();
    L11:
        if ((r212 & 4) == 0) goto L13;
        Boolean r102 = Boolean.FALSE;
    L15:
        if ((r212 & 8) == 0) goto L17;
        Boolean r103 = Boolean.FALSE;
    L19:
        if ((r212 & 16) == 0) goto L21;
        Boolean r104 = Boolean.FALSE;
    L23:
        if ((r212 & 32) == 0) goto L25;
        BackgroundNetworkModeConfig r105 = new BackgroundNetworkModeConfig(0, false, false, false, 0, 31, null);
    L26:
        this(r100, r101, r102, r103, r104, r105);
        return;
    L25:
        r105 = r211;
        goto L26
    L21:
        r104 = r210;
        goto L23
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
