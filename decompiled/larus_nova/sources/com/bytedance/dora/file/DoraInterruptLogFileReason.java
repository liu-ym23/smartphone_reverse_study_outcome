package com.bytedance.dora.file;

import r27.a;

/* JADX INFO: loaded from: classes15.dex */
public final enum DoraInterruptLogFileReason extends Enum<DoraInterruptLogFileReason> {
    public static final DoraInterruptLogFileReason FETCH_OVER_RETRIES = null;
    public static final DoraInterruptLogFileReason FETCH_RETRY_FOR_SEQ_GAP = null;
    public static final DoraInterruptLogFileReason INTERRUPT_BY_BUSY_NOTIFY = null;
    public static final DoraInterruptLogFileReason INTERRUPT_BY_HIGHER_PRIORITY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraInterruptLogFileReason[] f204391a = null;
    private final String value;

    static {
        DoraInterruptLogFileReason r100 = new DoraInterruptLogFileReason("INTERRUPT_BY_BUSY_NOTIFY", 0, "interruptByBusyNotify");
        INTERRUPT_BY_BUSY_NOTIFY = r100;
        DoraInterruptLogFileReason r101 = new DoraInterruptLogFileReason("FETCH_RETRY_FOR_SEQ_GAP", 1, "fetchRetryForSeqGap");
        FETCH_RETRY_FOR_SEQ_GAP = r101;
        DoraInterruptLogFileReason r102 = new DoraInterruptLogFileReason("FETCH_OVER_RETRIES", 2, "fetchOverRetries");
        FETCH_OVER_RETRIES = r102;
        DoraInterruptLogFileReason r103 = new DoraInterruptLogFileReason("INTERRUPT_BY_HIGHER_PRIORITY", 3, "interruptByHigherPriority");
        INTERRUPT_BY_HIGHER_PRIORITY = r103;
        f204391a = new DoraInterruptLogFileReason[]{r100, r101, r102, r103};
    }

    public static DoraInterruptLogFileReason[] values() {
        return (DoraInterruptLogFileReason[]) f204391a.clone();
    }

    public String getValue() {
        return this.value;
    }

    public static DoraInterruptLogFileReason fromValue(String r100) {
        DoraInterruptLogFileReason[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        DoraInterruptLogFileReason r104 = r101[r103];
        if (r104.value.equals(r100) == true) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static DoraInterruptLogFileReason valueOf(String r100) {
        return (DoraInterruptLogFileReason) a.a(DoraInterruptLogFileReason.class, r100);
    }

    public DoraInterruptLogFileReason(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
