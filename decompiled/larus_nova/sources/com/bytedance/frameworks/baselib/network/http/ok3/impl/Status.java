package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import r27.a;

/* JADX INFO: loaded from: classes19.dex */
final enum Status extends Enum<Status> {
    private static final /* synthetic */ Status[] $VALUES = null;
    public static final Status CANCELED = null;
    public static final Status FAILED = null;
    public static final Status IO_PENDING = null;
    public static final Status SUCCESS = null;
    public static final Status UNKNOWN = null;

    static {
        Status r100 = new Status("UNKNOWN", 0);
        UNKNOWN = r100;
        Status r101 = new Status("SUCCESS", 1);
        SUCCESS = r101;
        Status r102 = new Status("IO_PENDING", 2);
        IO_PENDING = r102;
        Status r103 = new Status("CANCELED", 3);
        CANCELED = r103;
        Status r104 = new Status("FAILED", 4);
        FAILED = r104;
        $VALUES = new Status[]{r100, r101, r102, r103, r104};
    }

    public static Status[] values() {
        return (Status[]) $VALUES.clone();
    }

    public static Status valueOf(String r100) {
        return (Status) a.a(Status.class, r100);
    }

    private Status(String r100, int r101) {
        super(r100, r101);
    }
}
