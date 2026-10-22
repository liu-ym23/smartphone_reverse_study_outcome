package com.bytedance.dtrace;

import com.android.ttcjpaysdk.kmp.common.pay_ability.cancel_retain.api.CancelRetainContactInfoFunctions;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
public final enum TraceThreadMode extends Enum<TraceThreadMode> {
    private static final /* synthetic */ TraceThreadMode[] $VALUES = null;
    public static final TraceThreadMode All = null;
    public static final TraceThreadMode OnlyChildThread = null;
    public static final TraceThreadMode OnlyMainThread = null;
    private final int value;

    static {
        TraceThreadMode r100 = new TraceThreadMode("OnlyMainThread", 0, 1);
        OnlyMainThread = r100;
        TraceThreadMode r101 = new TraceThreadMode("OnlyChildThread", 1, 2);
        OnlyChildThread = r101;
        TraceThreadMode r102 = new TraceThreadMode(CancelRetainContactInfoFunctions.All, 2, 4);
        All = r102;
        $VALUES = new TraceThreadMode[]{r100, r101, r102};
    }

    private TraceThreadMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }

    public static boolean onlyTraceChildThread(int r100) {
        if (r100 != OnlyChildThread.getValue()) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean onlyTraceMainThread(int r100) {
        if (r100 != OnlyMainThread.getValue()) goto L5;
        return true;
    L5:
        return false;
    }

    public static TraceThreadMode valueOf(String r100) {
        return (TraceThreadMode) a.a(TraceThreadMode.class, r100);
    }

    public static TraceThreadMode[] values() {
        return (TraceThreadMode[]) $VALUES.clone();
    }

    public int getValue() {
        return this.value;
    }
}
