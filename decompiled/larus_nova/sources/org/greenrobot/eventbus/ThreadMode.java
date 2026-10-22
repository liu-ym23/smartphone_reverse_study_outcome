package org.greenrobot.eventbus;

import com.bytedance.sdk.bridge.annotation.BridgeSyncType;
import com.obric.miniapp.alarm.AccountType;

/* JADX INFO: loaded from: classes42.dex */
public final enum ThreadMode extends Enum<ThreadMode> {
    private static final /* synthetic */ ThreadMode[] $VALUES = null;
    public static final ThreadMode ASYNC = null;
    public static final ThreadMode BACKGROUND = null;
    public static final ThreadMode MAIN = null;
    public static final ThreadMode MAIN_ORDERED = null;
    public static final ThreadMode POSTING = null;

    static {
        ThreadMode r100 = new ThreadMode("POSTING", 0);
        POSTING = r100;
        ThreadMode r101 = new ThreadMode(AccountType.MAIN, 1);
        MAIN = r101;
        ThreadMode r102 = new ThreadMode("MAIN_ORDERED", 2);
        MAIN_ORDERED = r102;
        ThreadMode r103 = new ThreadMode("BACKGROUND", 3);
        BACKGROUND = r103;
        ThreadMode r104 = new ThreadMode(BridgeSyncType.ASYNC, 4);
        ASYNC = r104;
        $VALUES = new ThreadMode[]{r100, r101, r102, r103, r104};
    }

    public static ThreadMode[] values() {
        return (ThreadMode[]) $VALUES.clone();
    }

    public static ThreadMode valueOf(String r100) {
        return (ThreadMode) r27.a.a(ThreadMode.class, r100);
    }

    private ThreadMode(String r100, int r101) {
        super(r100, r101);
    }
}
