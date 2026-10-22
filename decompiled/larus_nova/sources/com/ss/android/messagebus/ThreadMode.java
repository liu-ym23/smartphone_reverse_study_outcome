package com.ss.android.messagebus;

import com.bytedance.sdk.bridge.annotation.BridgeSyncType;
import r27.a;

/* JADX INFO: loaded from: classes38.dex */
public final enum ThreadMode extends Enum<ThreadMode> {
    public static final ThreadMode ASYNC = null;
    public static final ThreadMode CURRENT = null;
    public static final ThreadMode UI = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ThreadMode[] f449130a = null;

    static {
        ThreadMode r100 = new ThreadMode("UI", 0);
        UI = r100;
        ThreadMode r101 = new ThreadMode("CURRENT", 1);
        CURRENT = r101;
        ThreadMode r102 = new ThreadMode(BridgeSyncType.ASYNC, 2);
        ASYNC = r102;
        f449130a = new ThreadMode[]{r100, r101, r102};
    }

    public static ThreadMode[] values() {
        return (ThreadMode[]) f449130a.clone();
    }

    public static ThreadMode valueOf(String r100) {
        return (ThreadMode) a.a(ThreadMode.class, r100);
    }

    public ThreadMode(String r100, int r101) {
        super(r100, r101);
    }
}
