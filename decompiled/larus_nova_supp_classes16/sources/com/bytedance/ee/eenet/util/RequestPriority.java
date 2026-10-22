package com.bytedance.ee.eenet.util;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final enum RequestPriority extends Enum<RequestPriority> {
    public static final RequestPriority HIGH = null;
    public static final RequestPriority LOW = null;
    public static final RequestPriority MEDIUM = null;
    public static final /* synthetic */ RequestPriority[] a = null;
    private int level;

    static {
        RequestPriority r0 = new RequestPriority("HIGH", 0, 0);
        HIGH = r0;
        RequestPriority r1 = new RequestPriority("MEDIUM", 1, 1);
        MEDIUM = r1;
        RequestPriority r3 = new RequestPriority("LOW", 2, 2);
        LOW = r3;
        a = new RequestPriority[]{r0, r1, r3};
    }

    public static RequestPriority[] values() {
        return (RequestPriority[]) a.clone();
    }

    public int getLevel() {
        return this.level;
    }

    public static RequestPriority valueOf(String r1) {
        return (RequestPriority) a.a(RequestPriority.class, r1);
    }

    public RequestPriority(String r1, int r2, int r3) {
        super(r1, r2);
        this.level = r3;
    }
}
