package com.obric.assistant.os.libs;

import com.google.gson.annotations.SerializedName;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b$\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B§\u0001\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010#\u001a\u0004\u0018\u00010\u0004J\b\u0010$\u001a\u0004\u0018\u00010\u0006J\b\u0010%\u001a\u0004\u0018\u00010\bJ\b\u0010&\u001a\u0004\u0018\u00010\nJ\b\u0010'\u001a\u0004\u0018\u00010\fJ\u0013\u0010(\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010)\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0003HÆ\u0003J\u0013\u0010*\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0003HÆ\u0003J\u0013\u0010+\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0003HÆ\u0003J\u0013\u0010,\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u0010\u0010/\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010!J\u0010\u00100\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010!J\u0010\u00101\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010!J®\u0001\u00102\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00032\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00032\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u00032\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0012HÆ\u0001¢\u0006\u0002\u00103J\u0013\u00104\u001a\u00020\u00122\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00106\u001a\u000207HÖ\u0001J\t\u00108\u001a\u000209HÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R \u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R \u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R \u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R \u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b\u0011\u0010!R\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b\u0013\u0010!R\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b\u0014\u0010!¨\u0006:"}, d2 = {"Lcom/obric/assistant/os/libs/NetworkStateInfo;", "", "networkChangedEvents", "", "Lcom/obric/assistant/os/libs/NetworkChangedEvent;", "powerModeChangedEvents", "Lcom/obric/assistant/os/libs/PowerModeChangedEvent;", "wifiQoEQueue", "Lcom/obric/assistant/os/libs/WifiQoE;", "l4QoEQueue", "Lcom/obric/assistant/os/libs/L4QoE;", "cellularQoEQueue", "Lcom/obric/assistant/os/libs/CellularQoE;", "defaultNetworkInfo", "Lcom/obric/assistant/os/libs/NetworkInfo;", "vipStrategyReport", "Lcom/obric/assistant/os/libs/VipStrategyReport;", "isIdleMode", "", "isPowerSaveMode", "isSleepMode", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/obric/assistant/os/libs/NetworkInfo;Lcom/obric/assistant/os/libs/VipStrategyReport;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getNetworkChangedEvents", "()Ljava/util/List;", "getPowerModeChangedEvents", "getWifiQoEQueue", "getL4QoEQueue", "getCellularQoEQueue", "getDefaultNetworkInfo", "()Lcom/obric/assistant/os/libs/NetworkInfo;", "getVipStrategyReport", "()Lcom/obric/assistant/os/libs/VipStrategyReport;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLastNetworkEvent", "getLastPowerModeEvent", "getLastWifiQoE", "getLastL4QoE", "getLastCellularQoE", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/obric/assistant/os/libs/NetworkInfo;Lcom/obric/assistant/os/libs/VipStrategyReport;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/obric/assistant/os/libs/NetworkStateInfo;", "equals", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NetworkStateInfo {

    @SerializedName("CellularQoEQueue")
    private final List<CellularQoE> cellularQoEQueue;

    @SerializedName("defaultNetworkInfo")
    private final NetworkInfo defaultNetworkInfo;

    @SerializedName("isIdleMode")
    private final Boolean isIdleMode;

    @SerializedName("isPowerSaveMode")
    private final Boolean isPowerSaveMode;

    @SerializedName("isSleepMode")
    private final Boolean isSleepMode;

    @SerializedName("L4QoEQueue")
    private final List<L4QoE> l4QoEQueue;

    @SerializedName("networkChangedEvents")
    private final List<NetworkChangedEvent> networkChangedEvents;

    @SerializedName("powerModeChangedEvents")
    private final List<PowerModeChangedEvent> powerModeChangedEvents;

    @SerializedName("vipStrategyReport")
    private final VipStrategyReport vipStrategyReport;

    @SerializedName("wifiQoEQueue")
    private final List<WifiQoE> wifiQoEQueue;

    public NetworkStateInfo() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NetworkStateInfo copy$default(NetworkStateInfo r110, List r111, List r112, List r113, List r114, List r115, NetworkInfo r116, VipStrategyReport r117, Boolean r118, Boolean r210, Boolean r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        List r100 = r110.networkChangedEvents;
    L7:
        if ((r212 & 2) == 0) goto L9;
        List r101 = r110.powerModeChangedEvents;
    L11:
        if ((r212 & 4) == 0) goto L13;
        List r102 = r110.wifiQoEQueue;
    L15:
        if ((r212 & 8) == 0) goto L17;
        List r103 = r110.l4QoEQueue;
    L19:
        if ((r212 & 16) == 0) goto L21;
        List r104 = r110.cellularQoEQueue;
    L23:
        if ((r212 & 32) == 0) goto L25;
        NetworkInfo r105 = r110.defaultNetworkInfo;
    L27:
        if ((r212 & 64) == 0) goto L29;
        VipStrategyReport r106 = r110.vipStrategyReport;
    L31:
        if ((r212 & 128) == 0) goto L33;
        Boolean r107 = r110.isIdleMode;
    L35:
        if ((r212 & 256) == 0) goto L37;
        Boolean r119 = r110.isPowerSaveMode;
    L39:
        if ((r212 & 512) == 0) goto L41;
        Boolean r108 = r110.isSleepMode;
    L43:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r119, r108);
    L41:
        r108 = r211;
        goto L43
    L37:
        r119 = r210;
        goto L39
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
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

    public final List<NetworkChangedEvent> component1() {
        return this.networkChangedEvents;
    }

    public final Boolean component10() {
        return this.isSleepMode;
    }

    public final List<PowerModeChangedEvent> component2() {
        return this.powerModeChangedEvents;
    }

    public final List<WifiQoE> component3() {
        return this.wifiQoEQueue;
    }

    public final List<L4QoE> component4() {
        return this.l4QoEQueue;
    }

    public final List<CellularQoE> component5() {
        return this.cellularQoEQueue;
    }

    public final NetworkInfo component6() {
        return this.defaultNetworkInfo;
    }

    public final VipStrategyReport component7() {
        return this.vipStrategyReport;
    }

    public final Boolean component8() {
        return this.isIdleMode;
    }

    public final Boolean component9() {
        return this.isPowerSaveMode;
    }

    public final NetworkStateInfo copy(List<NetworkChangedEvent> r110, List<PowerModeChangedEvent> r111, List<WifiQoE> r112, List<L4QoE> r113, List<CellularQoE> r114, NetworkInfo r115, VipStrategyReport r116, Boolean r210, Boolean r211, Boolean r212) {
        return new NetworkStateInfo(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof NetworkStateInfo) == true) goto L8;
        return false;
    L8:
        NetworkStateInfo r101 = (NetworkStateInfo) r100;
        if (Intrinsics.areEqual(this.networkChangedEvents, r101.networkChangedEvents) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.powerModeChangedEvents, r101.powerModeChangedEvents) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.wifiQoEQueue, r101.wifiQoEQueue) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.l4QoEQueue, r101.l4QoEQueue) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.cellularQoEQueue, r101.cellularQoEQueue) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.defaultNetworkInfo, r101.defaultNetworkInfo) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.vipStrategyReport, r101.vipStrategyReport) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.isIdleMode, r101.isIdleMode) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.isPowerSaveMode, r101.isPowerSaveMode) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.isSleepMode, r101.isSleepMode) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        List<NetworkChangedEvent> r100 = this.networkChangedEvents;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<PowerModeChangedEvent> r104 = this.powerModeChangedEvents;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<WifiQoE> r107 = this.wifiQoEQueue;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        List<L4QoE> r110 = this.l4QoEQueue;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        List<CellularQoE> r113 = this.cellularQoEQueue;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        NetworkInfo r116 = this.defaultNetworkInfo;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        VipStrategyReport r119 = this.vipStrategyReport;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Boolean r122 = this.isIdleMode;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Boolean r125 = this.isPowerSaveMode;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Boolean r128 = this.isSleepMode;
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

    public String toString() {
        return "NetworkStateInfo(networkChangedEvents=" + this.networkChangedEvents + ", powerModeChangedEvents=" + this.powerModeChangedEvents + ", wifiQoEQueue=" + this.wifiQoEQueue + ", l4QoEQueue=" + this.l4QoEQueue + ", cellularQoEQueue=" + this.cellularQoEQueue + ", defaultNetworkInfo=" + this.defaultNetworkInfo + ", vipStrategyReport=" + this.vipStrategyReport + ", isIdleMode=" + this.isIdleMode + ", isPowerSaveMode=" + this.isPowerSaveMode + ", isSleepMode=" + this.isSleepMode + ')';
    }

    public final CellularQoE getLastCellularQoE() {
        List<CellularQoE> r100 = this.cellularQoEQueue;
        Object r101 = null;
        if (r100 == null) goto L32;
        Iterator<T> r102 = r100.iterator();
        if (r102.hasNext() == false) goto L28;
        r101 = r102.next();
        if (r102.hasNext() == false) goto L28;
        CellularQoE r103 = (CellularQoE) r101;
        if (r103 == null) goto L15;
        Long r104 = r103.getTimestamp();
        if (r104 == null) goto L15;
        long r105 = r104.longValue();
    L16:
        Object r106 = r102.next();
        CellularQoE r107 = (CellularQoE) r106;
        if (r107 == null) goto L21;
        Long r108 = r107.getTimestamp();
        if (r108 == null) goto L21;
        long r109 = r108.longValue();
    L23:
        if (r105 >= r109) goto L26;
        r101 = r106;
        r105 = r109;
    L26:
        if (r102.hasNext() == true) goto L16;
    L21:
        r109 = 0;
    L15:
        r105 = 0;
    L28:
        return (CellularQoE) r101;
    L32:
        return null;
    }

    public final L4QoE getLastL4QoE() {
        List<L4QoE> r100 = this.l4QoEQueue;
        Object r101 = null;
        if (r100 == null) goto L32;
        Iterator<T> r102 = r100.iterator();
        if (r102.hasNext() == false) goto L28;
        r101 = r102.next();
        if (r102.hasNext() == false) goto L28;
        L4QoE r103 = (L4QoE) r101;
        if (r103 == null) goto L15;
        Long r104 = r103.getTimestamp();
        if (r104 == null) goto L15;
        long r105 = r104.longValue();
    L16:
        Object r106 = r102.next();
        L4QoE r107 = (L4QoE) r106;
        if (r107 == null) goto L21;
        Long r108 = r107.getTimestamp();
        if (r108 == null) goto L21;
        long r109 = r108.longValue();
    L23:
        if (r105 >= r109) goto L26;
        r101 = r106;
        r105 = r109;
    L26:
        if (r102.hasNext() == true) goto L16;
    L21:
        r109 = 0;
    L15:
        r105 = 0;
    L28:
        return (L4QoE) r101;
    L32:
        return null;
    }

    public final NetworkChangedEvent getLastNetworkEvent() {
        List<NetworkChangedEvent> r100 = this.networkChangedEvents;
        Object r101 = null;
        if (r100 == null) goto L32;
        Iterator<T> r102 = r100.iterator();
        if (r102.hasNext() == false) goto L28;
        r101 = r102.next();
        if (r102.hasNext() == false) goto L28;
        NetworkChangedEvent r103 = (NetworkChangedEvent) r101;
        if (r103 == null) goto L15;
        Long r104 = r103.getTimestamp();
        if (r104 == null) goto L15;
        long r105 = r104.longValue();
    L16:
        Object r106 = r102.next();
        NetworkChangedEvent r107 = (NetworkChangedEvent) r106;
        if (r107 == null) goto L21;
        Long r108 = r107.getTimestamp();
        if (r108 == null) goto L21;
        long r109 = r108.longValue();
    L23:
        if (r105 >= r109) goto L26;
        r101 = r106;
        r105 = r109;
    L26:
        if (r102.hasNext() == true) goto L16;
    L21:
        r109 = 0;
    L15:
        r105 = 0;
    L28:
        return (NetworkChangedEvent) r101;
    L32:
        return null;
    }

    public final PowerModeChangedEvent getLastPowerModeEvent() {
        List<PowerModeChangedEvent> r100 = this.powerModeChangedEvents;
        Object r101 = null;
        if (r100 == null) goto L32;
        Iterator<T> r102 = r100.iterator();
        if (r102.hasNext() == false) goto L28;
        r101 = r102.next();
        if (r102.hasNext() == false) goto L28;
        PowerModeChangedEvent r103 = (PowerModeChangedEvent) r101;
        if (r103 == null) goto L15;
        Long r104 = r103.getTimestamp();
        if (r104 == null) goto L15;
        long r105 = r104.longValue();
    L16:
        Object r106 = r102.next();
        PowerModeChangedEvent r107 = (PowerModeChangedEvent) r106;
        if (r107 == null) goto L21;
        Long r108 = r107.getTimestamp();
        if (r108 == null) goto L21;
        long r109 = r108.longValue();
    L23:
        if (r105 >= r109) goto L26;
        r101 = r106;
        r105 = r109;
    L26:
        if (r102.hasNext() == true) goto L16;
    L21:
        r109 = 0;
    L15:
        r105 = 0;
    L28:
        return (PowerModeChangedEvent) r101;
    L32:
        return null;
    }

    public final WifiQoE getLastWifiQoE() {
        List<WifiQoE> r100 = this.wifiQoEQueue;
        Object r101 = null;
        if (r100 == null) goto L32;
        Iterator<T> r102 = r100.iterator();
        if (r102.hasNext() == false) goto L28;
        r101 = r102.next();
        if (r102.hasNext() == false) goto L28;
        WifiQoE r103 = (WifiQoE) r101;
        if (r103 == null) goto L15;
        Long r104 = r103.getTimestamp();
        if (r104 == null) goto L15;
        long r105 = r104.longValue();
    L16:
        Object r106 = r102.next();
        WifiQoE r107 = (WifiQoE) r106;
        if (r107 == null) goto L21;
        Long r108 = r107.getTimestamp();
        if (r108 == null) goto L21;
        long r109 = r108.longValue();
    L23:
        if (r105 >= r109) goto L26;
        r101 = r106;
        r105 = r109;
    L26:
        if (r102.hasNext() == true) goto L16;
    L21:
        r109 = 0;
    L15:
        r105 = 0;
    L28:
        return (WifiQoE) r101;
    L32:
        return null;
    }

    public final List<CellularQoE> getCellularQoEQueue() {
        return this.cellularQoEQueue;
    }

    public final NetworkInfo getDefaultNetworkInfo() {
        return this.defaultNetworkInfo;
    }

    public final List<L4QoE> getL4QoEQueue() {
        return this.l4QoEQueue;
    }

    public final List<NetworkChangedEvent> getNetworkChangedEvents() {
        return this.networkChangedEvents;
    }

    public final List<PowerModeChangedEvent> getPowerModeChangedEvents() {
        return this.powerModeChangedEvents;
    }

    public final VipStrategyReport getVipStrategyReport() {
        return this.vipStrategyReport;
    }

    public final List<WifiQoE> getWifiQoEQueue() {
        return this.wifiQoEQueue;
    }

    public final Boolean isIdleMode() {
        return this.isIdleMode;
    }

    public final Boolean isPowerSaveMode() {
        return this.isPowerSaveMode;
    }

    public final Boolean isSleepMode() {
        return this.isSleepMode;
    }

    public NetworkStateInfo(List<NetworkChangedEvent> r100, List<PowerModeChangedEvent> r101, List<WifiQoE> r102, List<L4QoE> r103, List<CellularQoE> r104, NetworkInfo r105, VipStrategyReport r106, Boolean r107, Boolean r108, Boolean r110) {
        this.networkChangedEvents = r100;
        this.powerModeChangedEvents = r101;
        this.wifiQoEQueue = r102;
        this.l4QoEQueue = r103;
        this.cellularQoEQueue = r104;
        this.defaultNetworkInfo = r105;
        this.vipStrategyReport = r106;
        this.isIdleMode = r107;
        this.isPowerSaveMode = r108;
        this.isSleepMode = r110;
    }

    public /* synthetic */ NetworkStateInfo(List r110, List r111, List r112, List r113, List r114, NetworkInfo r115, VipStrategyReport r116, Boolean r117, Boolean r210, Boolean r211, int r212, DefaultConstructorMarker r213) {
        Boolean r100 = null;
        if ((r212 & 1) == 0) goto L5;
        List r101 = null;
    L7:
        if ((r212 & 2) == 0) goto L9;
        List r102 = null;
    L11:
        if ((r212 & 4) == 0) goto L13;
        List r103 = null;
    L15:
        if ((r212 & 8) == 0) goto L17;
        List r104 = null;
    L19:
        if ((r212 & 16) == 0) goto L21;
        List r105 = null;
    L23:
        if ((r212 & 32) == 0) goto L25;
        NetworkInfo r106 = null;
    L27:
        if ((r212 & 64) == 0) goto L29;
        VipStrategyReport r107 = null;
    L31:
        if ((r212 & 128) == 0) goto L33;
        Boolean r108 = null;
    L35:
        if ((r212 & 256) == 0) goto L37;
        Boolean r118 = null;
    L39:
        if ((r212 & 512) != 0) goto L42;
        r100 = r211;
    L42:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r118, r100);
        return;
    L37:
        r118 = r210;
        goto L39
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
