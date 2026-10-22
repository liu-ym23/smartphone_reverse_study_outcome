package org.apache.commons.lang3.time;

import r27.a;

/* JADX INFO: loaded from: classes42.dex */
abstract enum StopWatch$State extends Enum<StopWatch$State> {
    private static final /* synthetic */ StopWatch$State[] $VALUES = null;
    public static final StopWatch$State RUNNING = null;
    public static final StopWatch$State STOPPED = null;
    public static final StopWatch$State SUSPENDED = null;
    public static final StopWatch$State UNSTARTED = null;

    public abstract boolean isStarted();

    public abstract boolean isStopped();

    public abstract boolean isSuspended();

    static {
        final String r100 = "UNSTARTED";
        final int r101 = 0;
        StopWatch$State r102 = new AnonymousClass1(r100, r101);
        UNSTARTED = r102;
        final String r103 = "RUNNING";
        final int r104 = 1;
        StopWatch$State r105 = new AnonymousClass2(r103, r104);
        RUNNING = r105;
        final String r106 = "STOPPED";
        final int r107 = 2;
        StopWatch$State r108 = new AnonymousClass3(r106, r107);
        STOPPED = r108;
        final String r109 = "SUSPENDED";
        final int r110 = 3;
        StopWatch$State r111 = new AnonymousClass4(r109, r110);
        SUSPENDED = r111;
        $VALUES = new StopWatch$State[]{r102, r105, r108, r111};
    }

    public static StopWatch$State[] values() {
        return (StopWatch$State[]) $VALUES.clone();
    }

    public static StopWatch$State valueOf(String r100) {
        return (StopWatch$State) a.a(StopWatch$State.class, r100);
    }

    private StopWatch$State(String r100, int r101) {
        super(r100, r101);
    }

    public /* synthetic */ StopWatch$State(String r100, int r101, StopWatch$1 r102) {
        this(r100, r101);
    }
}
