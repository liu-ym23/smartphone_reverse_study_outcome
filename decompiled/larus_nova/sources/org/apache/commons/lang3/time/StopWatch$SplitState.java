package org.apache.commons.lang3.time;

import r27.a;

/* JADX INFO: loaded from: classes42.dex */
final enum StopWatch$SplitState extends Enum<StopWatch$SplitState> {
    private static final /* synthetic */ StopWatch$SplitState[] $VALUES = null;
    public static final StopWatch$SplitState SPLIT = null;
    public static final StopWatch$SplitState UNSPLIT = null;

    static {
        StopWatch$SplitState r100 = new StopWatch$SplitState("SPLIT", 0);
        SPLIT = r100;
        StopWatch$SplitState r101 = new StopWatch$SplitState("UNSPLIT", 1);
        UNSPLIT = r101;
        $VALUES = new StopWatch$SplitState[]{r100, r101};
    }

    public static StopWatch$SplitState[] values() {
        return (StopWatch$SplitState[]) $VALUES.clone();
    }

    public static StopWatch$SplitState valueOf(String r100) {
        return (StopWatch$SplitState) a.a(StopWatch$SplitState.class, r100);
    }

    private StopWatch$SplitState(String r100, int r101) {
        super(r100, r101);
    }
}
