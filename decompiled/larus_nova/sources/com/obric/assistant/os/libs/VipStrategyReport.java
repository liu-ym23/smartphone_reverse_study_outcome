package com.obric.assistant.os.libs;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\bB\b\u0087\b\u0018\u00002\u00020\u0001B\u0083\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u00105\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u000b\u00106\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u00107\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u00108\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u00109\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010:\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010;\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010<\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010=\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010>\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010?\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010@\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010B\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010C\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010D\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010E\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u008a\u0002\u0010F\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010GJ\u0013\u0010H\u001a\u00020\u00032\b\u0010I\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010J\u001a\u00020\bHÖ\u0001J\t\u0010K\u001a\u00020\nHÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u0002\u0010\u001cR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u0004\u0010\u001cR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u0005\u0010\u001cR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u0006\u0010\u001cR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b#\u0010\u001fR\u001a\u0010\f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b$\u0010\u001fR\u001a\u0010\r\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b%\u0010\u001fR\u001a\u0010\u000e\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b&\u0010\u001fR\u001a\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b'\u0010\u001fR\u001a\u0010\u0010\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b(\u0010\u001fR\u001a\u0010\u0011\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b)\u0010\u001fR\u001a\u0010\u0012\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b*\u0010\u001fR\u001a\u0010\u0013\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b+\u0010\u001fR\u001a\u0010\u0014\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b,\u0010\u001fR\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u0015\u0010\u001cR\u001a\u0010\u0016\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b-\u0010\u001fR\u001a\u0010\u0017\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b.\u0010\u001fR\u001a\u0010\u0018\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b/\u0010\u001fR\u001a\u0010\u0019\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b0\u0010\u001f¨\u0006L"}, d2 = {"Lcom/obric/assistant/os/libs/VipStrategyReport;", "", "isVipNetworkFeatureEnabled", "", "isWifiAccelEnabled", "isSuperStableEnabled", "isVipChannelEnabled", "rateStrategyType", "", "foregroundAppPkg", "", "foregroundRateLimit", "vipChannelRateLimit", "backgroundRateLimit", "foregroundThroughput", "vipChannelThroughput", "backgroundThroughput", "doubaoRtt", "doubaoAvgRttFiveSec", "doubaoMaxRttFiveSec", "doubaoMinRttFiveSec", "isVpnEnabled", "wifiCurrentThroughput", "wifiRtt", "cellularThroughput", "cellularRtt", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getRateStrategyType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getForegroundAppPkg", "()Ljava/lang/String;", "getForegroundRateLimit", "getVipChannelRateLimit", "getBackgroundRateLimit", "getForegroundThroughput", "getVipChannelThroughput", "getBackgroundThroughput", "getDoubaoRtt", "getDoubaoAvgRttFiveSec", "getDoubaoMaxRttFiveSec", "getDoubaoMinRttFiveSec", "getWifiCurrentThroughput", "getWifiRtt", "getCellularThroughput", "getCellularRtt", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/obric/assistant/os/libs/VipStrategyReport;", "equals", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VipStrategyReport {

    @SerializedName("backgroundRateLimit")
    private final Integer backgroundRateLimit;

    @SerializedName("backgroundThroughput")
    private final Integer backgroundThroughput;

    @SerializedName("cellularRtt")
    private final Integer cellularRtt;

    @SerializedName("cellularThroughput")
    private final Integer cellularThroughput;

    @SerializedName("doubaoAvgRttFiveSec")
    private final Integer doubaoAvgRttFiveSec;

    @SerializedName("doubaoMaxRttFiveSec")
    private final Integer doubaoMaxRttFiveSec;

    @SerializedName("doubaoMinRttFiveSec")
    private final Integer doubaoMinRttFiveSec;

    @SerializedName("doubaoRtt")
    private final Integer doubaoRtt;

    @SerializedName("foregroundAppPkg")
    private final String foregroundAppPkg;

    @SerializedName("foregroundRateLimit")
    private final Integer foregroundRateLimit;

    @SerializedName("foregroundThroughput")
    private final Integer foregroundThroughput;

    @SerializedName("isSuperStableEnabled")
    private final Boolean isSuperStableEnabled;

    @SerializedName("isVipChannelEnabled")
    private final Boolean isVipChannelEnabled;

    @SerializedName("isVipNetworkFeatureEnabled")
    private final Boolean isVipNetworkFeatureEnabled;

    @SerializedName("isVpnEnabled")
    private final Boolean isVpnEnabled;

    @SerializedName("isWifiAccelEnabled")
    private final Boolean isWifiAccelEnabled;

    @SerializedName("rateStrategyType")
    private final Integer rateStrategyType;

    @SerializedName("vipChannelRateLimit")
    private final Integer vipChannelRateLimit;

    @SerializedName("vipChannelThroughput")
    private final Integer vipChannelThroughput;

    @SerializedName("wifiCurrentThroughput")
    private final Integer wifiCurrentThroughput;

    @SerializedName("wifiRtt")
    private final Integer wifiRtt;

    public VipStrategyReport() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097151, null);
    }

    public static /* synthetic */ VipStrategyReport copy$default(VipStrategyReport r110, Boolean r111, Boolean r112, Boolean r210, Boolean r211, Integer r212, String r213, Integer r214, Integer r215, Integer r216, Integer r217, Integer r218, Integer r219, Integer r310, Integer r311, Integer r312, Integer r313, Boolean r314, Integer r315, Integer r316, Integer r317, Integer r318, int r319, Object r410) {
        if ((r319 & 1) == 0) goto L5;
        Boolean r100 = r110.isVipNetworkFeatureEnabled;
    L7:
        if ((r319 & 2) == 0) goto L9;
        Boolean r101 = r110.isWifiAccelEnabled;
    L11:
        if ((r319 & 4) == 0) goto L13;
        Boolean r102 = r110.isSuperStableEnabled;
    L15:
        if ((r319 & 8) == 0) goto L17;
        Boolean r103 = r110.isVipChannelEnabled;
    L19:
        if ((r319 & 16) == 0) goto L21;
        Integer r104 = r110.rateStrategyType;
    L23:
        if ((r319 & 32) == 0) goto L25;
        String r105 = r110.foregroundAppPkg;
    L27:
        if ((r319 & 64) == 0) goto L29;
        Integer r106 = r110.foregroundRateLimit;
    L31:
        if ((r319 & 128) == 0) goto L33;
        Integer r107 = r110.vipChannelRateLimit;
    L35:
        if ((r319 & 256) == 0) goto L37;
        Integer r113 = r110.backgroundRateLimit;
    L39:
        if ((r319 & 512) == 0) goto L41;
        Integer r114 = r110.foregroundThroughput;
    L43:
        if ((r319 & 1024) == 0) goto L45;
        Integer r115 = r110.vipChannelThroughput;
    L47:
        if ((r319 & 2048) == 0) goto L49;
        Integer r116 = r110.backgroundThroughput;
    L51:
        if ((r319 & 4096) == 0) goto L53;
        Integer r117 = r110.doubaoRtt;
    L55:
        if ((r319 & 8192) == 0) goto L57;
        Integer r118 = r110.doubaoAvgRttFiveSec;
    L58:
        Integer r320 = r118;
        if ((r319 & 16384) == 0) goto L61;
        Integer r119 = r110.doubaoMaxRttFiveSec;
    L62:
        Integer r321 = r119;
        if ((r319 & 32768) == 0) goto L65;
        Integer r120 = r110.doubaoMinRttFiveSec;
    L66:
        Integer r322 = r120;
        if ((r319 & 65536) == 0) goto L69;
        Boolean r121 = r110.isVpnEnabled;
    L70:
        Boolean r323 = r121;
        if ((r319 & 131072) == 0) goto L73;
        Integer r122 = r110.wifiCurrentThroughput;
    L74:
        Integer r324 = r122;
        if ((r319 & 262144) == 0) goto L77;
        Integer r123 = r110.wifiRtt;
    L78:
        Integer r325 = r123;
        if ((r319 & 524288) == 0) goto L81;
        Integer r124 = r110.cellularThroughput;
    L83:
        if ((r319 & 1048576) == 0) goto L85;
        Integer r108 = r110.cellularRtt;
    L87:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r320, r321, r322, r323, r324, r325, r124, r108);
    L85:
        r108 = r318;
        goto L87
    L81:
        r124 = r317;
        goto L83
    L77:
        r123 = r316;
        goto L78
    L73:
        r122 = r315;
        goto L74
    L69:
        r121 = r314;
        goto L70
    L65:
        r120 = r313;
        goto L66
    L61:
        r119 = r312;
        goto L62
    L57:
        r118 = r311;
        goto L58
    L53:
        r117 = r310;
        goto L55
    L49:
        r116 = r219;
        goto L51
    L45:
        r115 = r218;
        goto L47
    L41:
        r114 = r217;
        goto L43
    L37:
        r113 = r216;
        goto L39
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
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

    public final Boolean component1() {
        return this.isVipNetworkFeatureEnabled;
    }

    public final Integer component10() {
        return this.foregroundThroughput;
    }

    public final Integer component11() {
        return this.vipChannelThroughput;
    }

    public final Integer component12() {
        return this.backgroundThroughput;
    }

    public final Integer component13() {
        return this.doubaoRtt;
    }

    public final Integer component14() {
        return this.doubaoAvgRttFiveSec;
    }

    public final Integer component15() {
        return this.doubaoMaxRttFiveSec;
    }

    public final Integer component16() {
        return this.doubaoMinRttFiveSec;
    }

    public final Boolean component17() {
        return this.isVpnEnabled;
    }

    public final Integer component18() {
        return this.wifiCurrentThroughput;
    }

    public final Integer component19() {
        return this.wifiRtt;
    }

    public final Boolean component2() {
        return this.isWifiAccelEnabled;
    }

    public final Integer component20() {
        return this.cellularThroughput;
    }

    public final Integer component21() {
        return this.cellularRtt;
    }

    public final Boolean component3() {
        return this.isSuperStableEnabled;
    }

    public final Boolean component4() {
        return this.isVipChannelEnabled;
    }

    public final Integer component5() {
        return this.rateStrategyType;
    }

    public final String component6() {
        return this.foregroundAppPkg;
    }

    public final Integer component7() {
        return this.foregroundRateLimit;
    }

    public final Integer component8() {
        return this.vipChannelRateLimit;
    }

    public final Integer component9() {
        return this.backgroundRateLimit;
    }

    public final VipStrategyReport copy(Boolean r210, Boolean r211, Boolean r212, Boolean r213, Integer r214, String r215, Integer r310, Integer r311, Integer r312, Integer r313, Integer r314, Integer r315, Integer r316, Integer r317, Integer r318, Integer r319, Boolean r410, Integer r411, Integer r412, Integer r413, Integer r414) {
        return new VipStrategyReport(r210, r211, r212, r213, r214, r215, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof VipStrategyReport) == true) goto L8;
        return false;
    L8:
        VipStrategyReport r101 = (VipStrategyReport) r100;
        if (Intrinsics.areEqual(this.isVipNetworkFeatureEnabled, r101.isVipNetworkFeatureEnabled) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.isWifiAccelEnabled, r101.isWifiAccelEnabled) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.isSuperStableEnabled, r101.isSuperStableEnabled) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.isVipChannelEnabled, r101.isVipChannelEnabled) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.rateStrategyType, r101.rateStrategyType) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.foregroundAppPkg, r101.foregroundAppPkg) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.foregroundRateLimit, r101.foregroundRateLimit) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.vipChannelRateLimit, r101.vipChannelRateLimit) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.backgroundRateLimit, r101.backgroundRateLimit) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.foregroundThroughput, r101.foregroundThroughput) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.vipChannelThroughput, r101.vipChannelThroughput) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.backgroundThroughput, r101.backgroundThroughput) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.doubaoRtt, r101.doubaoRtt) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.doubaoAvgRttFiveSec, r101.doubaoAvgRttFiveSec) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.doubaoMaxRttFiveSec, r101.doubaoMaxRttFiveSec) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.doubaoMinRttFiveSec, r101.doubaoMinRttFiveSec) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.isVpnEnabled, r101.isVpnEnabled) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.wifiCurrentThroughput, r101.wifiCurrentThroughput) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.wifiRtt, r101.wifiRtt) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.cellularThroughput, r101.cellularThroughput) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.cellularRtt, r101.cellularRtt) == true) goto L71;
        return false;
    L71:
        return true;
    }

    public int hashCode() {
        Boolean r100 = this.isVipNetworkFeatureEnabled;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.isWifiAccelEnabled;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.isSuperStableEnabled;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.isVipChannelEnabled;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.rateStrategyType;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.foregroundAppPkg;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.foregroundRateLimit;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.vipChannelRateLimit;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Integer r125 = this.backgroundRateLimit;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Integer r128 = this.foregroundThroughput;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        Integer r131 = this.vipChannelThroughput;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        Integer r134 = this.backgroundThroughput;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        Integer r137 = this.doubaoRtt;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        Integer r140 = this.doubaoAvgRttFiveSec;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        Integer r143 = this.doubaoMaxRttFiveSec;
        if (r143 != null) goto L61;
        int r144 = 0;
    L62:
        int r145 = (r142 + r144) * 31;
        Integer r146 = this.doubaoMinRttFiveSec;
        if (r146 != null) goto L65;
        int r147 = 0;
    L66:
        int r148 = (r145 + r147) * 31;
        Boolean r149 = this.isVpnEnabled;
        if (r149 != null) goto L69;
        int r150 = 0;
    L70:
        int r151 = (r148 + r150) * 31;
        Integer r152 = this.wifiCurrentThroughput;
        if (r152 != null) goto L73;
        int r153 = 0;
    L74:
        int r154 = (r151 + r153) * 31;
        Integer r155 = this.wifiRtt;
        if (r155 != null) goto L77;
        int r156 = 0;
    L78:
        int r157 = (r154 + r156) * 31;
        Integer r158 = this.cellularThroughput;
        if (r158 != null) goto L81;
        int r159 = 0;
    L82:
        int r160 = (r157 + r159) * 31;
        Integer r161 = this.cellularRtt;
        if (r161 == null) goto L87;
        r101 = r161.hashCode();
    L87:
        return r160 + r101;
    L81:
        r159 = r158.hashCode();
        goto L82
    L77:
        r156 = r155.hashCode();
        goto L78
    L73:
        r153 = r152.hashCode();
        goto L74
    L69:
        r150 = r149.hashCode();
        goto L70
    L65:
        r147 = r146.hashCode();
        goto L66
    L61:
        r144 = r143.hashCode();
        goto L62
    L57:
        r141 = r140.hashCode();
        goto L58
    L53:
        r138 = r137.hashCode();
        goto L54
    L49:
        r135 = r134.hashCode();
        goto L50
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
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
        return "VipStrategyReport(isVipNetworkFeatureEnabled=" + this.isVipNetworkFeatureEnabled + ", isWifiAccelEnabled=" + this.isWifiAccelEnabled + ", isSuperStableEnabled=" + this.isSuperStableEnabled + ", isVipChannelEnabled=" + this.isVipChannelEnabled + ", rateStrategyType=" + this.rateStrategyType + ", foregroundAppPkg=" + this.foregroundAppPkg + ", foregroundRateLimit=" + this.foregroundRateLimit + ", vipChannelRateLimit=" + this.vipChannelRateLimit + ", backgroundRateLimit=" + this.backgroundRateLimit + ", foregroundThroughput=" + this.foregroundThroughput + ", vipChannelThroughput=" + this.vipChannelThroughput + ", backgroundThroughput=" + this.backgroundThroughput + ", doubaoRtt=" + this.doubaoRtt + ", doubaoAvgRttFiveSec=" + this.doubaoAvgRttFiveSec + ", doubaoMaxRttFiveSec=" + this.doubaoMaxRttFiveSec + ", doubaoMinRttFiveSec=" + this.doubaoMinRttFiveSec + ", isVpnEnabled=" + this.isVpnEnabled + ", wifiCurrentThroughput=" + this.wifiCurrentThroughput + ", wifiRtt=" + this.wifiRtt + ", cellularThroughput=" + this.cellularThroughput + ", cellularRtt=" + this.cellularRtt + ')';
    }

    public final Integer getBackgroundRateLimit() {
        return this.backgroundRateLimit;
    }

    public final Integer getBackgroundThroughput() {
        return this.backgroundThroughput;
    }

    public final Integer getCellularRtt() {
        return this.cellularRtt;
    }

    public final Integer getCellularThroughput() {
        return this.cellularThroughput;
    }

    public final Integer getDoubaoAvgRttFiveSec() {
        return this.doubaoAvgRttFiveSec;
    }

    public final Integer getDoubaoMaxRttFiveSec() {
        return this.doubaoMaxRttFiveSec;
    }

    public final Integer getDoubaoMinRttFiveSec() {
        return this.doubaoMinRttFiveSec;
    }

    public final Integer getDoubaoRtt() {
        return this.doubaoRtt;
    }

    public final String getForegroundAppPkg() {
        return this.foregroundAppPkg;
    }

    public final Integer getForegroundRateLimit() {
        return this.foregroundRateLimit;
    }

    public final Integer getForegroundThroughput() {
        return this.foregroundThroughput;
    }

    public final Integer getRateStrategyType() {
        return this.rateStrategyType;
    }

    public final Integer getVipChannelRateLimit() {
        return this.vipChannelRateLimit;
    }

    public final Integer getVipChannelThroughput() {
        return this.vipChannelThroughput;
    }

    public final Integer getWifiCurrentThroughput() {
        return this.wifiCurrentThroughput;
    }

    public final Integer getWifiRtt() {
        return this.wifiRtt;
    }

    public final Boolean isSuperStableEnabled() {
        return this.isSuperStableEnabled;
    }

    public final Boolean isVipChannelEnabled() {
        return this.isVipChannelEnabled;
    }

    public final Boolean isVipNetworkFeatureEnabled() {
        return this.isVipNetworkFeatureEnabled;
    }

    public final Boolean isVpnEnabled() {
        return this.isVpnEnabled;
    }

    public final Boolean isWifiAccelEnabled() {
        return this.isWifiAccelEnabled;
    }

    public VipStrategyReport(Boolean r100, Boolean r101, Boolean r102, Boolean r103, Integer r104, String r105, Integer r106, Integer r110, Integer r111, Integer r112, Integer r113, Integer r114, Integer r115, Integer r116, Integer r117, Integer r118, Boolean r119, Integer r210, Integer r211, Integer r212, Integer r213) {
        this.isVipNetworkFeatureEnabled = r100;
        this.isWifiAccelEnabled = r101;
        this.isSuperStableEnabled = r102;
        this.isVipChannelEnabled = r103;
        this.rateStrategyType = r104;
        this.foregroundAppPkg = r105;
        this.foregroundRateLimit = r106;
        this.vipChannelRateLimit = r110;
        this.backgroundRateLimit = r111;
        this.foregroundThroughput = r112;
        this.vipChannelThroughput = r113;
        this.backgroundThroughput = r114;
        this.doubaoRtt = r115;
        this.doubaoAvgRttFiveSec = r116;
        this.doubaoMaxRttFiveSec = r117;
        this.doubaoMinRttFiveSec = r118;
        this.isVpnEnabled = r119;
        this.wifiCurrentThroughput = r210;
        this.wifiRtt = r211;
        this.cellularThroughput = r212;
        this.cellularRtt = r213;
    }

    public /* synthetic */ VipStrategyReport(Boolean r210, Boolean r211, Boolean r212, Boolean r213, Integer r214, String r215, Integer r216, Integer r310, Integer r311, Integer r312, Integer r313, Integer r314, Integer r315, Integer r316, Integer r317, Integer r318, Boolean r319, Integer r410, Integer r411, Integer r412, Integer r413, int r414, DefaultConstructorMarker r415) {
        if ((r414 & 1) == 0) goto L5;
        Boolean r100 = null;
    L7:
        if ((r414 & 2) == 0) goto L9;
        Boolean r101 = null;
    L11:
        if ((r414 & 4) == 0) goto L13;
        Boolean r102 = null;
    L15:
        if ((r414 & 8) == 0) goto L17;
        Boolean r103 = null;
    L19:
        if ((r414 & 16) == 0) goto L21;
        Integer r104 = null;
    L23:
        if ((r414 & 32) == 0) goto L25;
        String r105 = null;
    L27:
        if ((r414 & 64) == 0) goto L29;
        Integer r106 = null;
    L31:
        if ((r414 & 128) == 0) goto L33;
        Integer r107 = null;
    L35:
        if ((r414 & 256) == 0) goto L37;
        Integer r110 = null;
    L39:
        if ((r414 & 512) == 0) goto L41;
        Integer r111 = null;
    L43:
        if ((r414 & 1024) == 0) goto L45;
        Integer r112 = null;
    L47:
        if ((r414 & 2048) == 0) goto L49;
        Integer r113 = null;
    L51:
        if ((r414 & 4096) == 0) goto L53;
        Integer r114 = null;
    L55:
        if ((r414 & 8192) == 0) goto L57;
        Integer r115 = null;
    L59:
        if ((r414 & 16384) == 0) goto L61;
        Integer r108 = null;
    L63:
        if ((r414 & 32768) == 0) goto L65;
        Integer r116 = null;
    L67:
        if ((r414 & 65536) == 0) goto L69;
        Boolean r117 = null;
    L71:
        if ((r414 & 131072) == 0) goto L73;
        Integer r118 = null;
    L75:
        if ((r414 & 262144) == 0) goto L77;
        Integer r119 = null;
    L79:
        if ((r414 & 524288) == 0) goto L81;
        Integer r217 = null;
    L83:
        if ((r414 & 1048576) == 0) goto L85;
        Integer r109 = null;
    L86:
        this(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r115, r108, r116, r117, r118, r119, r217, r109);
        return;
    L85:
        r109 = r413;
        goto L86
    L81:
        r217 = r412;
        goto L83
    L77:
        r119 = r411;
        goto L79
    L73:
        r118 = r410;
        goto L75
    L69:
        r117 = r319;
        goto L71
    L65:
        r116 = r318;
        goto L67
    L61:
        r108 = r317;
        goto L63
    L57:
        r115 = r316;
        goto L59
    L53:
        r114 = r315;
        goto L55
    L49:
        r113 = r314;
        goto L51
    L45:
        r112 = r313;
        goto L47
    L41:
        r111 = r312;
        goto L43
    L37:
        r110 = r311;
        goto L39
    L33:
        r107 = r310;
        goto L35
    L29:
        r106 = r216;
        goto L31
    L25:
        r105 = r215;
        goto L27
    L21:
        r104 = r214;
        goto L23
    L17:
        r103 = r213;
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
