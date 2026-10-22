package com.ss.android.ugc.aweme.thread;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum ThreadPoolType extends Enum<ThreadPoolType> {
    public static final ThreadPoolType BACKGROUND = null;
    public static final ThreadPoolType DEFAULT = null;
    public static final ThreadPoolType FIXED = null;
    public static final ThreadPoolType IO = null;
    public static final ThreadPoolType SCHEDULED = null;
    public static final ThreadPoolType SERIAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ThreadPoolType[] f454342a = null;

    static {
        ThreadPoolType r100 = new ThreadPoolType("IO", 0);
        IO = r100;
        ThreadPoolType r101 = new ThreadPoolType("DEFAULT", 1);
        DEFAULT = r101;
        ThreadPoolType r102 = new ThreadPoolType("BACKGROUND", 2);
        BACKGROUND = r102;
        ThreadPoolType r103 = new ThreadPoolType("SCHEDULED", 3);
        SCHEDULED = r103;
        ThreadPoolType r104 = new ThreadPoolType("SERIAL", 4);
        SERIAL = r104;
        ThreadPoolType r105 = new ThreadPoolType("FIXED", 5);
        FIXED = r105;
        f454342a = new ThreadPoolType[]{r100, r101, r102, r103, r104, r105};
    }

    public static ThreadPoolType[] values() {
        return (ThreadPoolType[]) f454342a.clone();
    }

    public static ThreadPoolType valueOf(String r100) {
        return (ThreadPoolType) a.a(ThreadPoolType.class, r100);
    }

    public ThreadPoolType(String r100, int r101) {
        super(r100, r101);
    }
}
