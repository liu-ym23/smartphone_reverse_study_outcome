package com.larus.im.internal.network.link.impl.rtc;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b#\b\u0086\b\u0018\u00002\u00020\u0001B\u008d\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u0018\b\u0002\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0010\u0010\u0011J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010$\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0019\u0010'\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\rHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0094\u0001\u0010*\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0018\b\u0002\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010+J\u0013\u0010,\u001a\u00020\u00052\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\tHÖ\u0001J\t\u0010/\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0004\u0010\u0014R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0006\u0010\u0014R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0016\u0010\u0014R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R&\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u001f\u0010\u0014¨\u00060"}, d2 = {"Lcom/larus/im/internal/network/link/impl/rtc/CustomConfig;", "", "ppeLane", "", "isNewArch", "", "isClientPreJoin", "burstMode", "extraVersion", "", "uplinkAudioFormat", "streamFuncVersion", "serverFgConfig", "", "streamApp", "uplinkBurstMode", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/Boolean;)V", "getPpeLane", "()Ljava/lang/String;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getBurstMode", "getExtraVersion", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUplinkAudioFormat", "getStreamFuncVersion", "getServerFgConfig", "()Ljava/util/Map;", "getStreamApp", "getUplinkBurstMode", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/larus/im/internal/network/link/impl/rtc/CustomConfig;", "equals", "other", "hashCode", "toString", "OApp.flowSDK.baseSDK.common.avsdk-flow-impl"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class b {

    @SerializedName("BurstMode")
    private final Boolean burstMode;

    @SerializedName("ExtraVersion")
    private final Integer extraVersion;

    @SerializedName("IsClientPreJoin")
    private final Boolean isClientPreJoin;

    @SerializedName("IsNewArch")
    private final Boolean isNewArch;

    @SerializedName("PPELane")
    private final String ppeLane;

    @SerializedName("FGConfig")
    private final Map<String, Object> serverFgConfig;

    @SerializedName("StreamApp")
    private final String streamApp;

    @SerializedName("StreamFuncVersion")
    private final String streamFuncVersion;

    @SerializedName("UplinkAudioFormat")
    private final String uplinkAudioFormat;

    @SerializedName("UplinkBurstMode")
    private final Boolean uplinkBurstMode;

    public b() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.ppeLane, r101.ppeLane) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.isNewArch, r101.isNewArch) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.isClientPreJoin, r101.isClientPreJoin) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.burstMode, r101.burstMode) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.extraVersion, r101.extraVersion) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.uplinkAudioFormat, r101.uplinkAudioFormat) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.streamFuncVersion, r101.streamFuncVersion) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.serverFgConfig, r101.serverFgConfig) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.streamApp, r101.streamApp) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.uplinkBurstMode, r101.uplinkBurstMode) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        String r100 = this.ppeLane;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.isNewArch;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.isClientPreJoin;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.burstMode;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.extraVersion;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.uplinkAudioFormat;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.streamFuncVersion;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Map<String, Object> r122 = this.serverFgConfig;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.streamApp;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Boolean r128 = this.uplinkBurstMode;
        if (r128 == null) goto L43;
        r101 = r128.hashCode();
    L43:
        return r127 + r101;
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
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

    public final String toString() {
        return "CustomConfig(ppeLane=" + this.ppeLane + ", isNewArch=" + this.isNewArch + ", isClientPreJoin=" + this.isClientPreJoin + ", burstMode=" + this.burstMode + ", extraVersion=" + this.extraVersion + ", uplinkAudioFormat=" + this.uplinkAudioFormat + ", streamFuncVersion=" + this.streamFuncVersion + ", serverFgConfig=" + this.serverFgConfig + ", streamApp=" + this.streamApp + ", uplinkBurstMode=" + this.uplinkBurstMode + ')';
    }

    public /* synthetic */ b(int r110) {
        Boolean r100 = Boolean.TRUE;
        Boolean r111 = Boolean.FALSE;
        this("", r100, r111, r111, 1, "opus", "", null, "", r111);
    }

    public b(String r100, Boolean r101, Boolean r102, Boolean r103, Integer r104, String r105, String r106, Map<String, ? extends Object> r107, String r108, Boolean r110) {
        this.ppeLane = r100;
        this.isNewArch = r101;
        this.isClientPreJoin = r102;
        this.burstMode = r103;
        this.extraVersion = r104;
        this.uplinkAudioFormat = r105;
        this.streamFuncVersion = r106;
        this.serverFgConfig = r107;
        this.streamApp = r108;
        this.uplinkBurstMode = r110;
    }
}
