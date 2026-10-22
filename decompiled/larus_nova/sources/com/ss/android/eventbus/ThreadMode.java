package com.ss.android.eventbus;

import com.obric.miniapp.alarm.AccountType;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
public final enum ThreadMode extends Enum<ThreadMode> {
    private static final /* synthetic */ ThreadMode[] $VALUES = null;
    public static final ThreadMode BACKGROUDN = null;
    public static final ThreadMode MAIN = null;
    public static final ThreadMode POSTING = null;
    int value;

    static {
        ThreadMode r100 = new ThreadMode("POSTING", 0, 1);
        POSTING = r100;
        ThreadMode r101 = new ThreadMode(AccountType.MAIN, 1, 2);
        MAIN = r101;
        ThreadMode r102 = new ThreadMode("BACKGROUDN", 2, 3);
        BACKGROUDN = r102;
        $VALUES = new ThreadMode[]{r100, r101, r102};
    }

    public static ThreadMode[] values() {
        return (ThreadMode[]) $VALUES.clone();
    }

    public static ThreadMode valueOf(String r100) {
        return (ThreadMode) a.a(ThreadMode.class, r100);
    }

    private ThreadMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
