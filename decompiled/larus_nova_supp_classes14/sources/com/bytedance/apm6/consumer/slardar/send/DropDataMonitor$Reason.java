package com.bytedance.apm6.consumer.slardar.send;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final enum DropDataMonitor$Reason extends Enum<DropDataMonitor$Reason> {
    public static final DropDataMonitor$Reason FULL_DISK = null;
    public static final DropDataMonitor$Reason SERVER_DROP = null;
    public static final /* synthetic */ DropDataMonitor$Reason[] a = null;
    private String reason;

    static {
        DropDataMonitor$Reason r0 = new DropDataMonitor$Reason("SERVER_DROP", 0, "server drop message");
        SERVER_DROP = r0;
        DropDataMonitor$Reason r1 = new DropDataMonitor$Reason("FULL_DISK", 1, "disk is full");
        FULL_DISK = r1;
        a = new DropDataMonitor$Reason[]{r0, r1};
    }

    public static DropDataMonitor$Reason[] values() {
        return (DropDataMonitor$Reason[]) a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.reason;
    }

    public static DropDataMonitor$Reason valueOf(String r1) {
        return (DropDataMonitor$Reason) a.a(DropDataMonitor$Reason.class, r1);
    }

    public DropDataMonitor$Reason(String r1, int r2, String r3) {
        super(r1, r2);
        this.reason = r3;
    }
}
