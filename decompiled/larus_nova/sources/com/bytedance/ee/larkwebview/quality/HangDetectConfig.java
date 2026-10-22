package com.bytedance.ee.larkwebview.quality;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b-\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001Ba\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0006HÆ\u0003J\t\u0010+\u001a\u00020\bHÆ\u0003J\t\u0010,\u001a\u00020\bHÆ\u0003J\t\u0010-\u001a\u00020\u0006HÆ\u0003J\t\u0010.\u001a\u00020\u0006HÆ\u0003J\t\u0010/\u001a\u00020\bHÆ\u0003J\t\u00100\u001a\u00020\u0006HÆ\u0003Jc\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\u0006HÆ\u0001J\u0013\u00102\u001a\u00020\u00032\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u00020\bHÖ\u0001J\t\u00105\u001a\u000206HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001b\"\u0004\b\u001f\u0010\u001dR\u001e\u0010\n\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0017\"\u0004\b!\u0010\u0019R\u001e\u0010\u000b\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0017\"\u0004\b#\u0010\u0019R\u001e\u0010\f\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001b\"\u0004\b%\u0010\u001dR\u001e\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0017\"\u0004\b'\u0010\u0019¨\u00067"}, d2 = {"Lcom/bytedance/ee/larkwebview/quality/HangDetectConfig;", "", "enableDetection", "", "enableRecoverKill", "pingTimeout", "", "reportHangCount", "", "maxHangCount", "checkReadyTimeout", "sendPingDelay", "maxKillCount", "minKillInterval", "<init>", "(ZZJIIJJIJ)V", "getEnableDetection", "()Z", "setEnableDetection", "(Z)V", "getEnableRecoverKill", "setEnableRecoverKill", "getPingTimeout", "()J", "setPingTimeout", "(J)V", "getReportHangCount", "()I", "setReportHangCount", "(I)V", "getMaxHangCount", "setMaxHangCount", "getCheckReadyTimeout", "setCheckReadyTimeout", "getSendPingDelay", "setSendPingDelay", "getMaxKillCount", "setMaxKillCount", "getMinKillInterval", "setMinKillInterval", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "", "lark-webview-base_chinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HangDetectConfig {

    @SerializedName("check_ready_timeout")
    private long checkReadyTimeout;

    @SerializedName("enable_hang_detect")
    private boolean enableDetection;

    @SerializedName("enable_recover_by_kill")
    private boolean enableRecoverKill;

    @SerializedName("max_hang_count")
    private int maxHangCount;

    @SerializedName("max_kill_count")
    private int maxKillCount;

    @SerializedName("min_kill_interval")
    private long minKillInterval;

    @SerializedName("ping_timeout")
    private long pingTimeout;

    @SerializedName("report_hang_count")
    private int reportHangCount;

    @SerializedName("send_ping_delay")
    private long sendPingDelay;

    public HangDetectConfig() {
        this(false, false, 0, 0, 0, 0, 0, 0, 0, 511, null);
    }

    public static /* synthetic */ HangDetectConfig copy$default(HangDetectConfig r110, boolean r111, boolean r112, long r113, int r210, int r211, long r212, long r213, int r214, long r215, int r216, Object r310) {
        if ((r216 & 1) == 0) goto L5;
        boolean r100 = r110.enableDetection;
    L7:
        if ((r216 & 2) == 0) goto L9;
        boolean r101 = r110.enableRecoverKill;
    L11:
        if ((r216 & 4) == 0) goto L13;
        long r102 = r110.pingTimeout;
    L15:
        if ((r216 & 8) == 0) goto L17;
        int r103 = r110.reportHangCount;
    L19:
        if ((r216 & 16) == 0) goto L21;
        int r104 = r110.maxHangCount;
    L23:
        if ((r216 & 32) == 0) goto L25;
        long r105 = r110.checkReadyTimeout;
    L27:
        if ((r216 & 64) == 0) goto L29;
        long r114 = r110.sendPingDelay;
    L31:
        if ((r216 & 128) == 0) goto L33;
        int r115 = r110.maxKillCount;
    L35:
        if ((r216 & 256) == 0) goto L37;
        long r116 = r110.minKillInterval;
    L39:
        return r110.copy(r100, r101, r102, r103, r104, r105, r114, r115, r116);
    L37:
        r116 = r215;
        goto L39
    L33:
        r115 = r214;
        goto L35
    L29:
        r114 = r213;
        goto L31
    L25:
        r105 = r212;
        goto L27
    L21:
        r104 = r211;
        goto L23
    L17:
        r103 = r210;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final boolean component1() {
        return this.enableDetection;
    }

    public final boolean component2() {
        return this.enableRecoverKill;
    }

    public final long component3() {
        return this.pingTimeout;
    }

    public final int component4() {
        return this.reportHangCount;
    }

    public final int component5() {
        return this.maxHangCount;
    }

    public final long component6() {
        return this.checkReadyTimeout;
    }

    public final long component7() {
        return this.sendPingDelay;
    }

    public final int component8() {
        return this.maxKillCount;
    }

    public final long component9() {
        return this.minKillInterval;
    }

    public final HangDetectConfig copy(boolean r110, boolean r111, long r112, int r210, int r211, long r212, long r213, int r214, long r215) {
        return new HangDetectConfig(r110, r111, r112, r210, r211, r212, r213, r214, r215);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof HangDetectConfig) == true) goto L8;
        return false;
    L8:
        HangDetectConfig r101 = (HangDetectConfig) r100;
        if (this.enableDetection == r101.enableDetection) goto L12;
        return false;
    L12:
        if (this.enableRecoverKill == r101.enableRecoverKill) goto L15;
        return false;
    L15:
        if (this.pingTimeout == r101.pingTimeout) goto L18;
        return false;
    L18:
        if (this.reportHangCount == r101.reportHangCount) goto L21;
        return false;
    L21:
        if (this.maxHangCount == r101.maxHangCount) goto L24;
        return false;
    L24:
        if (this.checkReadyTimeout == r101.checkReadyTimeout) goto L27;
        return false;
    L27:
        if (this.sendPingDelay == r101.sendPingDelay) goto L30;
        return false;
    L30:
        if (this.maxKillCount == r101.maxKillCount) goto L33;
        return false;
    L33:
        if (this.minKillInterval == r101.minKillInterval) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.enableDetection == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.enableRecoverKill == true) goto L10;
        r100 = 1237;
    L10:
        int r103 = (r102 + r100) * 31;
        long r104 = this.pingTimeout;
        int r105 = (((((r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31) + this.reportHangCount) * 31) + this.maxHangCount) * 31;
        long r106 = this.checkReadyTimeout;
        int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        long r108 = this.sendPingDelay;
        int r109 = (((r107 + ((int) (r108 ^ (r108 >>> 32)))) * 31) + this.maxKillCount) * 31;
        long r110 = this.minKillInterval;
        return r109 + ((int) (r110 ^ (r110 >>> 32)));
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "HangDetectConfig(enableDetection=" + this.enableDetection + ", enableRecoverKill=" + this.enableRecoverKill + ", pingTimeout=" + this.pingTimeout + ", reportHangCount=" + this.reportHangCount + ", maxHangCount=" + this.maxHangCount + ", checkReadyTimeout=" + this.checkReadyTimeout + ", sendPingDelay=" + this.sendPingDelay + ", maxKillCount=" + this.maxKillCount + ", minKillInterval=" + this.minKillInterval + ')';
    }

    public final long getCheckReadyTimeout() {
        return this.checkReadyTimeout;
    }

    public final boolean getEnableDetection() {
        return this.enableDetection;
    }

    public final boolean getEnableRecoverKill() {
        return this.enableRecoverKill;
    }

    public final int getMaxHangCount() {
        return this.maxHangCount;
    }

    public final int getMaxKillCount() {
        return this.maxKillCount;
    }

    public final long getMinKillInterval() {
        return this.minKillInterval;
    }

    public final long getPingTimeout() {
        return this.pingTimeout;
    }

    public final int getReportHangCount() {
        return this.reportHangCount;
    }

    public final long getSendPingDelay() {
        return this.sendPingDelay;
    }

    public final void setCheckReadyTimeout(long r100) {
        this.checkReadyTimeout = r100;
    }

    public final void setEnableDetection(boolean r100) {
        this.enableDetection = r100;
    }

    public final void setEnableRecoverKill(boolean r100) {
        this.enableRecoverKill = r100;
    }

    public final void setMaxHangCount(int r100) {
        this.maxHangCount = r100;
    }

    public final void setMaxKillCount(int r100) {
        this.maxKillCount = r100;
    }

    public final void setMinKillInterval(long r100) {
        this.minKillInterval = r100;
    }

    public final void setPingTimeout(long r100) {
        this.pingTimeout = r100;
    }

    public final void setReportHangCount(int r100) {
        this.reportHangCount = r100;
    }

    public final void setSendPingDelay(long r100) {
        this.sendPingDelay = r100;
    }

    public HangDetectConfig(boolean r100, boolean r101, long r102, int r103, int r104, long r105, long r106, int r110, long r111) {
        this.enableDetection = r100;
        this.enableRecoverKill = r101;
        this.pingTimeout = r102;
        this.reportHangCount = r103;
        this.maxHangCount = r104;
        this.checkReadyTimeout = r105;
        this.sendPingDelay = r106;
        this.maxKillCount = r110;
        this.minKillInterval = r111;
    }

    public /* synthetic */ HangDetectConfig(boolean r110, boolean r111, long r112, int r113, int r210, long r211, long r212, int r213, long r214, int r215, DefaultConstructorMarker r216) {
        boolean r100 = false;
        if ((r215 & 1) == 0) goto L5;
        boolean r101 = false;
    L7:
        if ((r215 & 2) != 0) goto L10;
        r100 = r111;
    L10:
        long r102 = 5000;
        if ((r215 & 4) == 0) goto L13;
        long r103 = 5000;
    L15:
        if ((r215 & 8) == 0) goto L17;
        int r104 = 1;
    L19:
        if ((r215 & 16) == 0) goto L21;
        int r105 = 2;
    L23:
        if ((r215 & 32) == 0) goto L25;
        long r106 = 5000;
    L27:
        if ((r215 & 64) != 0) goto L31;
        r102 = r212;
    L31:
        if ((r215 & 128) == 0) goto L33;
        int r114 = 3;
    L35:
        if ((r215 & 256) == 0) goto L37;
        long r115 = 120;
    L38:
        this(r101, r100, r103, r104, r105, r106, r102, r114, r115);
        return;
    L37:
        r115 = r214;
        goto L38
    L33:
        r114 = r213;
        goto L35
    L25:
        r106 = r211;
        goto L27
    L21:
        r105 = r210;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L5:
        r101 = r110;
        goto L7
    }
}
