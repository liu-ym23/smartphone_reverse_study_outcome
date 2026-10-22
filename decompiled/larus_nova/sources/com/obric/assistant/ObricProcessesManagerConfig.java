package com.obric.assistant;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b)\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0006HÆ\u0003J\t\u0010'\u001a\u00020\u0006HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\fHÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\u008b\u0001\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u0003HÆ\u0001J\u0013\u00102\u001a\u00020\u00062\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u00020\fHÖ\u0001J\t\u00105\u001a\u000206HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0015R\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0015R\u0016\u0010\u000f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0015R\u0016\u0010\u0010\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0015R\u0016\u0010\u0011\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0015¨\u00067"}, d2 = {"Lcom/obric/assistant/ObricProcessesManagerConfig;", "", "novaStopFgsDelayMs", "", "novaStartFgsDelayMs", "enableBootAutoStartExitForLow", "", "enableBootAutoStartExit", "bootAutoStartWindowMs", "bootAutoStartFirstCheckDelayMs", "bootAutoStartRetryDelayMs", "bootAutoStartMaxRetryCount", "", "memoryReconnectDelayMs", "memoryInitBindDelayMs", "assistantIpcBindWaitConnectTimeLimitMs", "assistantIpcBindMaxDiedRebindDelayMs", "assistantIpcBindMaxFailRebindDelayMs", "<init>", "(JJZZJJJIJJJJJ)V", "getNovaStopFgsDelayMs", "()J", "getNovaStartFgsDelayMs", "getEnableBootAutoStartExitForLow", "()Z", "getEnableBootAutoStartExit", "getBootAutoStartWindowMs", "getBootAutoStartFirstCheckDelayMs", "getBootAutoStartRetryDelayMs", "getBootAutoStartMaxRetryCount", "()I", "getMemoryReconnectDelayMs", "getMemoryInitBindDelayMs", "getAssistantIpcBindWaitConnectTimeLimitMs", "getAssistantIpcBindMaxDiedRebindDelayMs", "getAssistantIpcBindMaxFailRebindDelayMs", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "equals", "other", "hashCode", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricProcessesManagerConfig {

    @SerializedName("assistant_ipc_bind_max_died_rebind_delay_ms")
    private final long assistantIpcBindMaxDiedRebindDelayMs;

    @SerializedName("assistant_ipc_bind_max_fail_rebind_delay_ms")
    private final long assistantIpcBindMaxFailRebindDelayMs;

    @SerializedName("assistant_ipc_bind_wait_connect_time_limit_ms")
    private final long assistantIpcBindWaitConnectTimeLimitMs;

    @SerializedName("boot_auto_start_first_check_delay_ms")
    private final long bootAutoStartFirstCheckDelayMs;

    @SerializedName("boot_auto_start_max_retry_count")
    private final int bootAutoStartMaxRetryCount;

    @SerializedName("boot_auto_start_retry_delay_ms")
    private final long bootAutoStartRetryDelayMs;

    @SerializedName("boot_auto_start_window_ms")
    private final long bootAutoStartWindowMs;

    @SerializedName("enable_boot_auto_start_exit")
    private final boolean enableBootAutoStartExit;

    @SerializedName("enable_boot_auto_start_exit_for_low")
    private final boolean enableBootAutoStartExitForLow;

    @SerializedName("memory_init_bind_delay_ms")
    private final long memoryInitBindDelayMs;

    @SerializedName("memory_reconnect_delay_ms")
    private final long memoryReconnectDelayMs;

    @SerializedName("nova_start_fgs_delay_ms")
    private final long novaStartFgsDelayMs;

    @SerializedName("nova_stop_fgs_delay_ms")
    private final long novaStopFgsDelayMs;

    public ObricProcessesManagerConfig() {
        this(0, 0, false, false, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8191, null);
    }

    public static /* synthetic */ ObricProcessesManagerConfig copy$default(ObricProcessesManagerConfig r110, long r111, long r112, boolean r210, boolean r211, long r212, long r213, long r214, int r215, long r310, long r311, long r312, long r313, long r314, int r410, Object r411) {
        if ((r410 & 1) == 0) goto L5;
        long r100 = r110.novaStopFgsDelayMs;
    L7:
        if ((r410 & 2) == 0) goto L9;
        long r101 = r110.novaStartFgsDelayMs;
    L11:
        if ((r410 & 4) == 0) goto L13;
        boolean r102 = r110.enableBootAutoStartExitForLow;
    L15:
        if ((r410 & 8) == 0) goto L17;
        boolean r103 = r110.enableBootAutoStartExit;
    L19:
        if ((r410 & 16) == 0) goto L21;
        long r104 = r110.bootAutoStartWindowMs;
    L23:
        if ((r410 & 32) == 0) goto L25;
        long r113 = r110.bootAutoStartFirstCheckDelayMs;
    L27:
        if ((r410 & 64) == 0) goto L29;
        long r114 = r110.bootAutoStartRetryDelayMs;
    L31:
        if ((r410 & 128) == 0) goto L33;
        int r115 = r110.bootAutoStartMaxRetryCount;
    L34:
        int r216 = r115;
        if ((r410 & 256) == 0) goto L37;
        long r116 = r110.memoryReconnectDelayMs;
    L38:
        long r315 = r116;
        if ((r410 & 512) == 0) goto L41;
        long r117 = r110.memoryInitBindDelayMs;
    L42:
        long r316 = r117;
        if ((r410 & 1024) == 0) goto L45;
        long r118 = r110.assistantIpcBindWaitConnectTimeLimitMs;
    L46:
        long r317 = r118;
        if ((r410 & 2048) == 0) goto L49;
        long r119 = r110.assistantIpcBindMaxDiedRebindDelayMs;
    L50:
        long r318 = r119;
        if ((r410 & 4096) == 0) goto L53;
        long r120 = r110.assistantIpcBindMaxFailRebindDelayMs;
    L55:
        return r110.copy(r100, r101, r102, r103, r104, r113, r114, r216, r315, r316, r317, r318, r120);
    L53:
        r120 = r314;
        goto L55
    L49:
        r119 = r313;
        goto L50
    L45:
        r118 = r312;
        goto L46
    L41:
        r117 = r311;
        goto L42
    L37:
        r116 = r310;
        goto L38
    L33:
        r115 = r215;
        goto L34
    L29:
        r114 = r214;
        goto L31
    L25:
        r113 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final long component1() {
        return this.novaStopFgsDelayMs;
    }

    public final long component10() {
        return this.memoryInitBindDelayMs;
    }

    public final long component11() {
        return this.assistantIpcBindWaitConnectTimeLimitMs;
    }

    public final long component12() {
        return this.assistantIpcBindMaxDiedRebindDelayMs;
    }

    public final long component13() {
        return this.assistantIpcBindMaxFailRebindDelayMs;
    }

    public final long component2() {
        return this.novaStartFgsDelayMs;
    }

    public final boolean component3() {
        return this.enableBootAutoStartExitForLow;
    }

    public final boolean component4() {
        return this.enableBootAutoStartExit;
    }

    public final long component5() {
        return this.bootAutoStartWindowMs;
    }

    public final long component6() {
        return this.bootAutoStartFirstCheckDelayMs;
    }

    public final long component7() {
        return this.bootAutoStartRetryDelayMs;
    }

    public final int component8() {
        return this.bootAutoStartMaxRetryCount;
    }

    public final long component9() {
        return this.memoryReconnectDelayMs;
    }

    public final ObricProcessesManagerConfig copy(long r210, long r211, boolean r310, boolean r311, long r312, long r313, long r314, int r315, long r316, long r410, long r411, long r412, long r413) {
        return new ObricProcessesManagerConfig(r210, r211, r310, r311, r312, r313, r314, r315, r316, r410, r411, r412, r413);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ObricProcessesManagerConfig) == true) goto L8;
        return false;
    L8:
        ObricProcessesManagerConfig r101 = (ObricProcessesManagerConfig) r100;
        if (this.novaStopFgsDelayMs == r101.novaStopFgsDelayMs) goto L12;
        return false;
    L12:
        if (this.novaStartFgsDelayMs == r101.novaStartFgsDelayMs) goto L15;
        return false;
    L15:
        if (this.enableBootAutoStartExitForLow == r101.enableBootAutoStartExitForLow) goto L18;
        return false;
    L18:
        if (this.enableBootAutoStartExit == r101.enableBootAutoStartExit) goto L21;
        return false;
    L21:
        if (this.bootAutoStartWindowMs == r101.bootAutoStartWindowMs) goto L24;
        return false;
    L24:
        if (this.bootAutoStartFirstCheckDelayMs == r101.bootAutoStartFirstCheckDelayMs) goto L27;
        return false;
    L27:
        if (this.bootAutoStartRetryDelayMs == r101.bootAutoStartRetryDelayMs) goto L30;
        return false;
    L30:
        if (this.bootAutoStartMaxRetryCount == r101.bootAutoStartMaxRetryCount) goto L33;
        return false;
    L33:
        if (this.memoryReconnectDelayMs == r101.memoryReconnectDelayMs) goto L36;
        return false;
    L36:
        if (this.memoryInitBindDelayMs == r101.memoryInitBindDelayMs) goto L39;
        return false;
    L39:
        if (this.assistantIpcBindWaitConnectTimeLimitMs == r101.assistantIpcBindWaitConnectTimeLimitMs) goto L42;
        return false;
    L42:
        if (this.assistantIpcBindMaxDiedRebindDelayMs == r101.assistantIpcBindMaxDiedRebindDelayMs) goto L45;
        return false;
    L45:
        if (this.assistantIpcBindMaxFailRebindDelayMs == r101.assistantIpcBindMaxFailRebindDelayMs) goto L47;
        return false;
    L47:
        return true;
    }

    public int hashCode() {
        long r100 = this.novaStopFgsDelayMs;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.novaStartFgsDelayMs;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        int r104 = 1231;
        if (this.enableBootAutoStartExitForLow == false) goto L5;
        int r105 = 1231;
    L6:
        int r106 = (r103 + r105) * 31;
        if (this.enableBootAutoStartExit == true) goto L10;
        r104 = 1237;
    L10:
        int r107 = (r106 + r104) * 31;
        long r108 = this.bootAutoStartWindowMs;
        int r109 = (r107 + ((int) (r108 ^ (r108 >>> 32)))) * 31;
        long r110 = this.bootAutoStartFirstCheckDelayMs;
        int r111 = (r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31;
        long r112 = this.bootAutoStartRetryDelayMs;
        int r113 = (((r111 + ((int) (r112 ^ (r112 >>> 32)))) * 31) + this.bootAutoStartMaxRetryCount) * 31;
        long r114 = this.memoryReconnectDelayMs;
        int r115 = (r113 + ((int) (r114 ^ (r114 >>> 32)))) * 31;
        long r116 = this.memoryInitBindDelayMs;
        int r117 = (r115 + ((int) (r116 ^ (r116 >>> 32)))) * 31;
        long r118 = this.assistantIpcBindWaitConnectTimeLimitMs;
        int r119 = (r117 + ((int) (r118 ^ (r118 >>> 32)))) * 31;
        long r120 = this.assistantIpcBindMaxDiedRebindDelayMs;
        int r121 = (r119 + ((int) (r120 ^ (r120 >>> 32)))) * 31;
        long r122 = this.assistantIpcBindMaxFailRebindDelayMs;
        return r121 + ((int) (r122 ^ (r122 >>> 32)));
    L5:
        r105 = 1237;
        goto L6
    }

    public String toString() {
        return "ObricProcessesManagerConfig(novaStopFgsDelayMs=" + this.novaStopFgsDelayMs + ", novaStartFgsDelayMs=" + this.novaStartFgsDelayMs + ", enableBootAutoStartExitForLow=" + this.enableBootAutoStartExitForLow + ", enableBootAutoStartExit=" + this.enableBootAutoStartExit + ", bootAutoStartWindowMs=" + this.bootAutoStartWindowMs + ", bootAutoStartFirstCheckDelayMs=" + this.bootAutoStartFirstCheckDelayMs + ", bootAutoStartRetryDelayMs=" + this.bootAutoStartRetryDelayMs + ", bootAutoStartMaxRetryCount=" + this.bootAutoStartMaxRetryCount + ", memoryReconnectDelayMs=" + this.memoryReconnectDelayMs + ", memoryInitBindDelayMs=" + this.memoryInitBindDelayMs + ", assistantIpcBindWaitConnectTimeLimitMs=" + this.assistantIpcBindWaitConnectTimeLimitMs + ", assistantIpcBindMaxDiedRebindDelayMs=" + this.assistantIpcBindMaxDiedRebindDelayMs + ", assistantIpcBindMaxFailRebindDelayMs=" + this.assistantIpcBindMaxFailRebindDelayMs + ')';
    }

    public final long getAssistantIpcBindMaxDiedRebindDelayMs() {
        return this.assistantIpcBindMaxDiedRebindDelayMs;
    }

    public final long getAssistantIpcBindMaxFailRebindDelayMs() {
        return this.assistantIpcBindMaxFailRebindDelayMs;
    }

    public final long getAssistantIpcBindWaitConnectTimeLimitMs() {
        return this.assistantIpcBindWaitConnectTimeLimitMs;
    }

    public final long getBootAutoStartFirstCheckDelayMs() {
        return this.bootAutoStartFirstCheckDelayMs;
    }

    public final int getBootAutoStartMaxRetryCount() {
        return this.bootAutoStartMaxRetryCount;
    }

    public final long getBootAutoStartRetryDelayMs() {
        return this.bootAutoStartRetryDelayMs;
    }

    public final long getBootAutoStartWindowMs() {
        return this.bootAutoStartWindowMs;
    }

    public final boolean getEnableBootAutoStartExit() {
        return this.enableBootAutoStartExit;
    }

    public final boolean getEnableBootAutoStartExitForLow() {
        return this.enableBootAutoStartExitForLow;
    }

    public final long getMemoryInitBindDelayMs() {
        return this.memoryInitBindDelayMs;
    }

    public final long getMemoryReconnectDelayMs() {
        return this.memoryReconnectDelayMs;
    }

    public final long getNovaStartFgsDelayMs() {
        return this.novaStartFgsDelayMs;
    }

    public final long getNovaStopFgsDelayMs() {
        return this.novaStopFgsDelayMs;
    }

    public ObricProcessesManagerConfig(long r100, long r101, boolean r102, boolean r103, long r110, long r111, long r112, int r113, long r114, long r115, long r210, long r211, long r212) {
        this.novaStopFgsDelayMs = r100;
        this.novaStartFgsDelayMs = r101;
        this.enableBootAutoStartExitForLow = r102;
        this.enableBootAutoStartExit = r103;
        this.bootAutoStartWindowMs = r110;
        this.bootAutoStartFirstCheckDelayMs = r111;
        this.bootAutoStartRetryDelayMs = r112;
        this.bootAutoStartMaxRetryCount = r113;
        this.memoryReconnectDelayMs = r114;
        this.memoryInitBindDelayMs = r115;
        this.assistantIpcBindWaitConnectTimeLimitMs = r210;
        this.assistantIpcBindMaxDiedRebindDelayMs = r211;
        this.assistantIpcBindMaxFailRebindDelayMs = r212;
    }

    public /* synthetic */ ObricProcessesManagerConfig(long r210, long r211, boolean r212, boolean r310, long r311, long r312, long r313, int r314, long r315, long r410, long r411, long r412, long r413, int r414, DefaultConstructorMarker r415) {
        if ((r414 & 1) == 0) goto L5;
        long r100 = 300000;
    L7:
        if ((r414 & 2) == 0) goto L9;
        long r101 = 2000;
    L11:
        if ((r414 & 4) == 0) goto L13;
        boolean r102 = true;
    L15:
        if ((r414 & 8) == 0) goto L17;
        boolean r103 = false;
    L19:
        if ((r414 & 16) == 0) goto L21;
        long r110 = 600000;
    L23:
        if ((r414 & 32) == 0) goto L25;
        long r111 = 60000;
    L27:
        if ((r414 & 64) == 0) goto L29;
        long r112 = 20000;
    L31:
        if ((r414 & 128) == 0) goto L33;
        int r104 = 10;
    L34:
        long r113 = 5000;
        if ((r414 & 256) == 0) goto L37;
        long r105 = 5000;
    L38:
        long r114 = r105;
        if ((r414 & 512) == 0) goto L41;
        long r106 = 3000;
    L42:
        long r213 = r106;
        if ((r414 & 1024) != 0) goto L47;
        r113 = r411;
    L47:
        if ((r414 & 2048) == 0) goto L49;
        long r107 = 600000;
    L51:
        if ((r414 & 4096) == 0) goto L53;
        long r214 = 30000;
    L54:
        this(r100, r101, r102, r103, r110, r111, r112, r104, r114, r213, r113, r107, r214);
        return;
    L53:
        r214 = r413;
        goto L54
    L49:
        r107 = r412;
        goto L51
    L41:
        r106 = r410;
        goto L42
    L37:
        r105 = r315;
        goto L38
    L33:
        r104 = r314;
        goto L34
    L29:
        r112 = r313;
        goto L31
    L25:
        r111 = r312;
        goto L27
    L21:
        r110 = r311;
        goto L23
    L17:
        r103 = r310;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
