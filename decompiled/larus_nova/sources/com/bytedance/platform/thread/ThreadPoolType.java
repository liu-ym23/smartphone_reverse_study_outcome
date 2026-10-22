package com.bytedance.platform.thread;

/* JADX INFO: loaded from: classes21.dex */
public final enum ThreadPoolType extends Enum<ThreadPoolType> {
    public static final ThreadPoolType BACKGROUND = null;
    public static final ThreadPoolType DEFAULT = null;
    public static final ThreadPoolType FIXED = null;
    public static final ThreadPoolType IO = null;
    public static final ThreadPoolType SCHEDULED = null;
    public static final ThreadPoolType SINGLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ThreadPoolType[] f266625a = null;

    static {
        ThreadPoolType r100 = new ThreadPoolType("IO", 0);
        IO = r100;
        ThreadPoolType r101 = new ThreadPoolType("DEFAULT", 1);
        DEFAULT = r101;
        ThreadPoolType r102 = new ThreadPoolType("BACKGROUND", 2);
        BACKGROUND = r102;
        ThreadPoolType r103 = new ThreadPoolType("FIXED", 3);
        FIXED = r103;
        ThreadPoolType r104 = new ThreadPoolType("SCHEDULED", 4);
        SCHEDULED = r104;
        ThreadPoolType r105 = new ThreadPoolType("SINGLE", 5);
        SINGLE = r105;
        f266625a = new ThreadPoolType[]{r100, r101, r102, r103, r104, r105};
    }

    public static ThreadPoolType[] values() {
        return (ThreadPoolType[]) f266625a.clone();
    }

    public static ThreadPoolType valueOf(String r100) {
        return (ThreadPoolType) r27.a.a(ThreadPoolType.class, r100);
    }

    public ThreadPoolType(String r100, int r101) {
        super(r100, r101);
    }
}
