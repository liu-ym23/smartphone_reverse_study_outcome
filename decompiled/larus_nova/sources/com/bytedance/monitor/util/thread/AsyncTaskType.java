package com.bytedance.monitor.util.thread;

import r27.a;

/* JADX INFO: loaded from: classes3.dex */
public final enum AsyncTaskType extends Enum<AsyncTaskType> {
    public static final AsyncTaskType IO = null;
    public static final AsyncTaskType LIGHT_WEIGHT = null;
    public static final AsyncTaskType TIME_SENSITIVE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AsyncTaskType[] f265653a = null;

    static {
        AsyncTaskType r100 = new AsyncTaskType("IO", 0);
        IO = r100;
        AsyncTaskType r101 = new AsyncTaskType("TIME_SENSITIVE", 1);
        TIME_SENSITIVE = r101;
        AsyncTaskType r102 = new AsyncTaskType("LIGHT_WEIGHT", 2);
        LIGHT_WEIGHT = r102;
        f265653a = new AsyncTaskType[]{r100, r101, r102};
    }

    public static AsyncTaskType[] values() {
        return (AsyncTaskType[]) f265653a.clone();
    }

    public static AsyncTaskType valueOf(String r100) {
        return (AsyncTaskType) a.a(AsyncTaskType.class, r100);
    }

    public AsyncTaskType(String r100, int r101) {
        super(r100, r101);
    }
}
