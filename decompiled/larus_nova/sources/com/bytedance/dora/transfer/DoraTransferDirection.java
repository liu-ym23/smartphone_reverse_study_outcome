package com.bytedance.dora.transfer;

import r27.a;

/* JADX INFO: loaded from: classes15.dex */
public final enum DoraTransferDirection extends Enum<DoraTransferDirection> {
    public static final DoraTransferDirection BOTH = null;
    public static final DoraTransferDirection DOWNLINK = null;
    public static final DoraTransferDirection UPLINK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraTransferDirection[] f204665a = null;
    private final String value;

    static {
        DoraTransferDirection r100 = new DoraTransferDirection("UPLINK", 0, "uplink");
        UPLINK = r100;
        DoraTransferDirection r101 = new DoraTransferDirection("DOWNLINK", 1, "downlink");
        DOWNLINK = r101;
        DoraTransferDirection r102 = new DoraTransferDirection("BOTH", 2, "both");
        BOTH = r102;
        f204665a = new DoraTransferDirection[]{r100, r101, r102};
    }

    public static DoraTransferDirection[] values() {
        return (DoraTransferDirection[]) f204665a.clone();
    }

    public String getValue() {
        return this.value;
    }

    public static DoraTransferDirection valueOf(String r100) {
        return (DoraTransferDirection) a.a(DoraTransferDirection.class, r100);
    }

    public DoraTransferDirection(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
