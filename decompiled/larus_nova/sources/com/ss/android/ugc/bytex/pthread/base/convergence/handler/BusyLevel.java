package com.ss.android.ugc.bytex.pthread.base.convergence.handler;

import com.bytedance.android.livesdk.diagnose.DiagnoseResult;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/BusyLevel;", "", "reuseCount", "", "(Ljava/lang/String;II)V", "getReuseCount", "()I", DiagnoseResult.DIAGNOSE_LEVEL_P0, DiagnoseResult.DIAGNOSE_LEVEL_P1, DiagnoseResult.DIAGNOSE_LEVEL_P2, "P3", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public final enum BusyLevel extends Enum<BusyLevel> {
    private static final /* synthetic */ BusyLevel[] $VALUES = null;
    public static final BusyLevel P0 = null;
    public static final BusyLevel P1 = null;
    public static final BusyLevel P2 = null;
    public static final BusyLevel P3 = null;
    private final int reuseCount;

    static {
        BusyLevel r100 = new BusyLevel(DiagnoseResult.DIAGNOSE_LEVEL_P0, 0, 3);
        P0 = r100;
        BusyLevel r101 = new BusyLevel(DiagnoseResult.DIAGNOSE_LEVEL_P1, 1, 4);
        P1 = r101;
        BusyLevel r102 = new BusyLevel(DiagnoseResult.DIAGNOSE_LEVEL_P2, 2, 6);
        P2 = r102;
        BusyLevel r103 = new BusyLevel("P3", 3, 8);
        P3 = r103;
        $VALUES = new BusyLevel[]{r100, r101, r102, r103};
    }

    private BusyLevel(String r100, int r101, int r102) {
        super(r100, r101);
        this.reuseCount = r102;
    }

    public static BusyLevel valueOf(String r100) {
        return (BusyLevel) a.a(BusyLevel.class, r100);
    }

    public static BusyLevel[] values() {
        return (BusyLevel[]) $VALUES.clone();
    }

    public final int getReuseCount() {
        return this.reuseCount;
    }
}
