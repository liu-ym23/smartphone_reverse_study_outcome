package com.larus.audio.asr.sami.bean;

import com.google.gson.annotations.SerializedName;
import com.heytap.mcssdk.constant.b;
import com.ss.ttvideoengine.selector.strategy.GearStrategy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BW\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003JY\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\tHÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014¨\u0006#"}, d2 = {"Lcom/larus/audio/asr/sami/bean/AsrExtraInfo;", "", "asrMode", "", b.f276376z, "token", "language", "extraConfig", "maxRetryTime", "", "maxTimeOutDuration", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "getAsrMode", "()Ljava/lang/String;", "getAppKey", "getToken", "getLanguage", "getExtraConfig", "getMaxRetryTime", "()I", "getMaxTimeOutDuration", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AsrExtraInfo {

    @SerializedName("app_key")
    private final String appKey;

    @SerializedName("asr_mode")
    private final String asrMode;

    @SerializedName(GearStrategy.GEAR_STRATEGY_KEY_EXTRA_CONFIG)
    private final String extraConfig;

    @SerializedName("language")
    private final String language;

    @SerializedName("max_retry_time")
    private final int maxRetryTime;

    @SerializedName("time_out_duration")
    private final int maxTimeOutDuration;

    @SerializedName("token")
    private final String token;

    public AsrExtraInfo() {
        this(null, null, null, null, null, 0, 0, 127, null);
    }

    public static /* synthetic */ AsrExtraInfo copy$default(AsrExtraInfo r100, String r101, String r102, String r103, String r104, String r110, int r111, int r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.asrMode;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.appKey;
    L8:
        String r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.token;
    L11:
        String r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.language;
    L14:
        String r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.extraConfig;
    L17:
        String r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.maxRetryTime;
    L20:
        int r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.maxTimeOutDuration;
    L23:
        String r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final String component1() {
        return this.asrMode;
    }

    public final String component2() {
        return this.appKey;
    }

    public final String component3() {
        return this.token;
    }

    public final String component4() {
        return this.language;
    }

    public final String component5() {
        return this.extraConfig;
    }

    public final int component6() {
        return this.maxRetryTime;
    }

    public final int component7() {
        return this.maxTimeOutDuration;
    }

    public final AsrExtraInfo copy(String r110, String r111, String r112, String r113, String r114, int r115, int r116) {
        return new AsrExtraInfo(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AsrExtraInfo) == true) goto L8;
        return false;
    L8:
        AsrExtraInfo r101 = (AsrExtraInfo) r100;
        if (Intrinsics.areEqual(this.asrMode, r101.asrMode) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.appKey, r101.appKey) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.token, r101.token) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.language, r101.language) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.extraConfig, r101.extraConfig) == true) goto L24;
        return false;
    L24:
        if (this.maxRetryTime == r101.maxRetryTime) goto L27;
        return false;
    L27:
        if (this.maxTimeOutDuration == r101.maxTimeOutDuration) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        String r100 = this.asrMode;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.appKey;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.token;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.language;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.extraConfig;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return ((((r112 + r101) * 31) + this.maxRetryTime) * 31) + this.maxTimeOutDuration;
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
        return "AsrExtraInfo(asrMode=" + this.asrMode + ", appKey=" + this.appKey + ", token=" + this.token + ", language=" + this.language + ", extraConfig=" + this.extraConfig + ", maxRetryTime=" + this.maxRetryTime + ", maxTimeOutDuration=" + this.maxTimeOutDuration + ')';
    }

    public final String getAppKey() {
        return this.appKey;
    }

    public final String getAsrMode() {
        return this.asrMode;
    }

    public final String getExtraConfig() {
        return this.extraConfig;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final int getMaxRetryTime() {
        return this.maxRetryTime;
    }

    public final int getMaxTimeOutDuration() {
        return this.maxTimeOutDuration;
    }

    public final String getToken() {
        return this.token;
    }

    public AsrExtraInfo(String r100, String r101, String r102, String r103, String r104, int r105, int r106) {
        this.asrMode = r100;
        this.appKey = r101;
        this.token = r102;
        this.language = r103;
        this.extraConfig = r104;
        this.maxRetryTime = r105;
        this.maxTimeOutDuration = r106;
    }

    public /* synthetic */ AsrExtraInfo(String r100, String r101, String r102, String r103, String r110, int r111, int r112, int r113, DefaultConstructorMarker r114) {
        String r104 = "";
        if ((r113 & 1) == 0) goto L5;
        String r115 = "";
    L7:
        if ((r113 & 2) == 0) goto L9;
        String r105 = "";
    L11:
        if ((r113 & 4) == 0) goto L13;
        String r106 = "";
    L15:
        if ((r113 & 8) == 0) goto L17;
        String r107 = "";
    L19:
        if ((r113 & 16) != 0) goto L23;
        r104 = r110;
    L23:
        if ((r113 & 32) == 0) goto L25;
        int r108 = 0;
    L27:
        if ((r113 & 64) == 0) goto L29;
        int r116 = 0;
    L30:
        this(r115, r105, r106, r107, r104, r108, r116);
        return;
    L29:
        r116 = r112;
        goto L30
    L25:
        r108 = r111;
        goto L27
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r115 = r100;
        goto L7
    }
}
