package com.bytedance.dora.wlan;

import com.bytedance.dora.wlan.model.DoraWifiType;
import com.larus.dora.api.model.FlowDoraWifiLinkStrategy;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
public final enum DoraWifiLinkStrategy extends Enum<DoraWifiLinkStrategy> {
    private static final /* synthetic */ DoraWifiLinkStrategy[] $VALUES = null;
    public static final DoraWifiLinkStrategy P2P_NEXT_SOFT_AP = null;
    public static final DoraWifiLinkStrategy P2P_ONLY = null;
    public static final DoraWifiLinkStrategy SOFT_AP_NEXT_P2P = null;
    public static final DoraWifiLinkStrategy SOFT_AP_ONLY = null;
    private final DoraWifiType primaryWifiType;
    private final DoraWifiType secondWifiType;
    private final int value;

    static {
        DoraWifiType r110 = DoraWifiType.P2P;
        DoraWifiLinkStrategy r100 = new DoraWifiLinkStrategy(FlowDoraWifiLinkStrategy.P2P_ONLY, 0, 0, r110, null);
        P2P_ONLY = r100;
        DoraWifiType r101 = DoraWifiType.SOFT_AP;
        DoraWifiLinkStrategy r102 = new DoraWifiLinkStrategy(FlowDoraWifiLinkStrategy.SOFT_AP_ONLY, 1, 1, r101, null);
        SOFT_AP_ONLY = r102;
        DoraWifiLinkStrategy r103 = new DoraWifiLinkStrategy(FlowDoraWifiLinkStrategy.P2P_NEXT_SOFT_AP, 2, 2, r110, r101);
        P2P_NEXT_SOFT_AP = r103;
        DoraWifiLinkStrategy r104 = new DoraWifiLinkStrategy("SOFT_AP_NEXT_P2P", 3, 3, r101, r110);
        SOFT_AP_NEXT_P2P = r104;
        $VALUES = new DoraWifiLinkStrategy[]{r100, r102, r103, r104};
    }

    public static DoraWifiLinkStrategy[] values() {
        return (DoraWifiLinkStrategy[]) $VALUES.clone();
    }

    public static DoraWifiLinkStrategy getDefault() {
        return P2P_NEXT_SOFT_AP;
    }

    public DoraWifiType getPrimaryWifiType() {
        return this.primaryWifiType;
    }

    public DoraWifiType getSecondWifiType() {
        return this.secondWifiType;
    }

    public int getValue() {
        return this.value;
    }

    public static DoraWifiLinkStrategy fromValue(int r100) {
        DoraWifiLinkStrategy[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        DoraWifiLinkStrategy r104 = r101[r103];
        if (r104.value == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L9:
        return getDefault();
    }

    public static DoraWifiLinkStrategy valueOf(String r100) {
        return (DoraWifiLinkStrategy) a.a(DoraWifiLinkStrategy.class, r100);
    }

    private DoraWifiLinkStrategy(String r100, int r101, int r102, DoraWifiType r103, DoraWifiType r104) {
        super(r100, r101);
        this.value = r102;
        this.primaryWifiType = r103;
        this.secondWifiType = r104;
    }
}
