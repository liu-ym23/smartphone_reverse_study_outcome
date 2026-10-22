package com.bytedance.ee.eenet.util;

import r27.a;

/* JADX INFO: loaded from: classes16.dex */
public final enum RequestPriority extends Enum<RequestPriority> {
    public static final RequestPriority HIGH = null;
    public static final RequestPriority LOW = null;
    public static final RequestPriority MEDIUM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RequestPriority[] f242765a = null;
    private int level;

    static {
        RequestPriority r100 = new RequestPriority("HIGH", 0, 0);
        HIGH = r100;
        RequestPriority r101 = new RequestPriority("MEDIUM", 1, 1);
        MEDIUM = r101;
        RequestPriority r102 = new RequestPriority("LOW", 2, 2);
        LOW = r102;
        f242765a = new RequestPriority[]{r100, r101, r102};
    }

    public static RequestPriority[] values() {
        return (RequestPriority[]) f242765a.clone();
    }

    public int getLevel() {
        return this.level;
    }

    public static RequestPriority valueOf(String r100) {
        return (RequestPriority) a.a(RequestPriority.class, r100);
    }

    public RequestPriority(String r100, int r101, int r102) {
        super(r100, r101);
        this.level = r102;
    }
}
