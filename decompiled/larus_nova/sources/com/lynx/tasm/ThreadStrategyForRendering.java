package com.lynx.tasm;

/* JADX INFO: loaded from: classes32.dex */
public final enum ThreadStrategyForRendering extends Enum<ThreadStrategyForRendering> {
    public static final ThreadStrategyForRendering ALL_ON_UI = null;
    public static final ThreadStrategyForRendering MOST_ON_TASM = null;
    public static final ThreadStrategyForRendering MULTI_THREADS = null;
    public static final ThreadStrategyForRendering PART_ON_LAYOUT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ThreadStrategyForRendering[] f381785a = null;
    private int mId;

    static {
        ThreadStrategyForRendering r100 = new ThreadStrategyForRendering("ALL_ON_UI", 0, 0);
        ALL_ON_UI = r100;
        ThreadStrategyForRendering r101 = new ThreadStrategyForRendering("MOST_ON_TASM", 1, 1);
        MOST_ON_TASM = r101;
        ThreadStrategyForRendering r102 = new ThreadStrategyForRendering("PART_ON_LAYOUT", 2, 2);
        PART_ON_LAYOUT = r102;
        ThreadStrategyForRendering r103 = new ThreadStrategyForRendering("MULTI_THREADS", 3, 3);
        MULTI_THREADS = r103;
        f381785a = new ThreadStrategyForRendering[]{r100, r101, r102, r103};
    }

    public static ThreadStrategyForRendering[] values() {
        return (ThreadStrategyForRendering[]) f381785a.clone();
    }

    public int id() {
        return this.mId;
    }

    public static ThreadStrategyForRendering valueOf(String r100) {
        return (ThreadStrategyForRendering) r27.a.a(ThreadStrategyForRendering.class, r100);
    }

    public ThreadStrategyForRendering(String r100, int r101, int r102) {
        super(r100, r101);
        this.mId = r102;
    }
}
