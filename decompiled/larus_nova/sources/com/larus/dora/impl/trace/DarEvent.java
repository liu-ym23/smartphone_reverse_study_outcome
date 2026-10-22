package com.larus.dora.impl.trace;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b+\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B=\b\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R&\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fj\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2¨\u00063"}, d2 = {"Lcom/larus/dora/impl/trace/DarEvent;", "", "event", "", "type", "", "extra", "", "", "message", "<init>", "(Ljava/lang/String;ILjava/lang/String;ILjava/util/Map;Ljava/lang/String;)V", "getEvent", "()Ljava/lang/String;", "setEvent", "(Ljava/lang/String;)V", "getType", "()I", "getExtra", "()Ljava/util/Map;", "setExtra", "(Ljava/util/Map;)V", "getMessage", "setMessage", "BudsActive", "OtaCheckUpdateResult", "OtaUpdateBegin", "OtaUpdatePreCheckBegin", "OtaUpdatePreCheck", "OtaDownloadEnd", "OtaUpdateCheck", "OtaConnectEnd", "OtaTransferStart", "OtaTransferEnd", "OtaVerifyEnd", "OtaRebootEnd", "OtaUpdateEnd", "OtaRetry", "BtConnectStateChanged", "DoraLinkStateChanged", "CallBegin", "CallEnd", "BluetoothTurnOn", "BluetoothTurnOFF", "TWSDisconnected", "TWSConnected", "BoxOpen", "BoxClose", "OtaRoleChangeRetry", "BudsBusy", "BudsIdle", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DarEvent extends Enum<DarEvent> {
    public static final DarEvent BluetoothTurnOFF = null;
    public static final DarEvent BluetoothTurnOn = null;
    public static final DarEvent BoxClose = null;
    public static final DarEvent BoxOpen = null;
    public static final DarEvent BtConnectStateChanged = null;
    public static final DarEvent BudsActive = null;
    public static final DarEvent BudsBusy = null;
    public static final DarEvent BudsIdle = null;
    public static final DarEvent CallBegin = null;
    public static final DarEvent CallEnd = null;
    public static final DarEvent DoraLinkStateChanged = null;
    public static final DarEvent OtaCheckUpdateResult = null;
    public static final DarEvent OtaConnectEnd = null;
    public static final DarEvent OtaDownloadEnd = null;
    public static final DarEvent OtaRebootEnd = null;
    public static final DarEvent OtaRetry = null;
    public static final DarEvent OtaRoleChangeRetry = null;
    public static final DarEvent OtaTransferEnd = null;
    public static final DarEvent OtaTransferStart = null;
    public static final DarEvent OtaUpdateBegin = null;
    public static final DarEvent OtaUpdateCheck = null;
    public static final DarEvent OtaUpdateEnd = null;
    public static final DarEvent OtaUpdatePreCheck = null;
    public static final DarEvent OtaUpdatePreCheckBegin = null;
    public static final DarEvent OtaVerifyEnd = null;
    public static final DarEvent TWSConnected = null;
    public static final DarEvent TWSDisconnected = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DarEvent[] f338082a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f338083b = null;
    private String event;
    private Map<String, Object> extra;
    private String message;
    private final int type;

    public DarEvent() {
        throw null;
    }

    public static EnumEntries<DarEvent> getEntries() {
        return f338083b;
    }

    static {
        Lazy<b> r100 = b.f338085f;
        DarEvent r101 = new DarEvent("BudsActive", 0, "BudsActive", 0, null, null, 12, null);
        BudsActive = r101;
        DarEvent r102 = new DarEvent("OtaCheckUpdateResult", 1, "CheckUpdateResult", 0, null, null, 12, null);
        OtaCheckUpdateResult = r102;
        DarEvent r103 = new DarEvent("OtaUpdateBegin", 2, "UpdateBegin", 0, null, null, 12, null);
        OtaUpdateBegin = r103;
        DarEvent r104 = new DarEvent("OtaUpdatePreCheckBegin", 3, "UpdatePreCheckBegin", 0, null, null, 12, null);
        OtaUpdatePreCheckBegin = r104;
        DarEvent r105 = new DarEvent("OtaUpdatePreCheck", 4, "UpdatePreCheck", 0, null, null, 12, null);
        OtaUpdatePreCheck = r105;
        DarEvent r106 = new DarEvent("OtaDownloadEnd", 5, "OnDownloadEnd", 0, null, null, 12, null);
        OtaDownloadEnd = r106;
        DarEvent r107 = new DarEvent("OtaUpdateCheck", 6, "UpdateCheck", 0, null, null, 12, null);
        OtaUpdateCheck = r107;
        DarEvent r108 = new DarEvent("OtaConnectEnd", 7, "OnConnectEnd", 0, null, null, 12, null);
        OtaConnectEnd = r108;
        DarEvent r109 = new DarEvent("OtaTransferStart", 8, "OtaTransferStart", 0, null, null, 12, null);
        OtaTransferStart = r109;
        DarEvent r110 = new DarEvent("OtaTransferEnd", 9, "OnTransferEnd", 0, null, null, 12, null);
        OtaTransferEnd = r110;
        DarEvent r111 = new DarEvent("OtaVerifyEnd", 10, "OnVerifyEnd", 0, null, null, 12, null);
        OtaVerifyEnd = r111;
        DarEvent r210 = new DarEvent("OtaRebootEnd", 11, "OnRebootEnd", 0, null, null, 12, null);
        OtaRebootEnd = r210;
        int r112 = b.f338086g;
        DarEvent r113 = new DarEvent("OtaUpdateEnd", 12, "OnUpdateEnd", r112, null, null, 12, null);
        OtaUpdateEnd = r113;
        DarEvent r114 = new DarEvent("OtaRetry", 13, "OnRetry", r112, null, null, 12, null);
        OtaRetry = r114;
        DarEvent r115 = new DarEvent("BtConnectStateChanged", 14, "BtConnectStateChanged", r112, null, null, 12, null);
        BtConnectStateChanged = r115;
        DarEvent r116 = new DarEvent("DoraLinkStateChanged", 15, "DoraLinkStateChanged", r112, null, null, 12, null);
        DoraLinkStateChanged = r116;
        int r117 = b.f338087h;
        DarEvent r118 = new DarEvent("CallBegin", 16, "CallBegin", r117, null, null, 12, null);
        CallBegin = r118;
        DarEvent r119 = new DarEvent("CallEnd", 17, "CallEnd", r117, null, null, 12, null);
        CallEnd = r119;
        DarEvent r120 = new DarEvent("BluetoothTurnOn", 18, "BluetoothTurnOn", r117, null, null, 12, null);
        BluetoothTurnOn = r120;
        DarEvent r310 = new DarEvent("BluetoothTurnOFF", 19, "BluetoothTurnOFF", r117, null, null, 12, null);
        BluetoothTurnOFF = r310;
        DarEvent r121 = new DarEvent("TWSDisconnected", 20, "TWSDisconnected", r112, null, null, 12, null);
        TWSDisconnected = r121;
        DarEvent r211 = new DarEvent("TWSConnected", 21, "TWSConnected", r112, null, null, 12, null);
        TWSConnected = r211;
        DarEvent r212 = new DarEvent("BoxOpen", 22, "BoxOpen", r112, null, null, 12, null);
        BoxOpen = r212;
        DarEvent r213 = new DarEvent("BoxClose", 23, "BoxClose", r112, null, null, 12, null);
        BoxClose = r213;
        DarEvent r214 = new DarEvent("OtaRoleChangeRetry", 24, "OtaRoleChangeRetry", r112, null, null, 12, null);
        OtaRoleChangeRetry = r214;
        DarEvent r311 = new DarEvent("BudsBusy", 25, "BudsBusy", r112, null, null, 12, null);
        BudsBusy = r311;
        DarEvent r312 = new DarEvent("BudsIdle", 26, "BudsIdle", r112, null, null, 12, null);
        BudsIdle = r312;
        DarEvent[] r122 = {r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r210, r113, r114, r115, r116, r118, r119, r120, r310, r121, r211, r212, r213, r214, r311, r312};
        f338082a = r122;
        f338083b = EnumEntriesKt.enumEntries(r122);
    }

    public static DarEvent[] values() {
        return (DarEvent[]) f338082a.clone();
    }

    public final String getEvent() {
        return this.event;
    }

    public final Map<String, Object> getExtra() {
        return this.extra;
    }

    public final String getMessage() {
        return this.message;
    }

    public final int getType() {
        return this.type;
    }

    public static DarEvent valueOf(String r100) {
        return (DarEvent) r27.a.a(DarEvent.class, r100);
    }

    public final void setEvent(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.event = r100;
    }

    public final void setExtra(Map<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.extra = r100;
    }

    public final void setMessage(String r100) {
        this.message = r100;
    }

    public DarEvent(String r100, int r101, String r102, int r103, Map r104, String r105, int r106, DefaultConstructorMarker r107) {
        if ((r106 & 1) == 0) goto L6;
        r102 = "";
    L6:
        if ((r106 & 4) == 0) goto L9;
        r104 = new LinkedHashMap();
    L9:
        if ((r106 & 8) == 0) goto L11;
        r105 = "";
    L11:
        super(r100, r101);
        this.event = r102;
        this.type = r103;
        this.extra = r104;
        this.message = r105;
    }
}
