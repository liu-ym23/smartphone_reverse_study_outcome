package com.obric.assistant.performance;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/performance/MemoryLeakOptimizationAction;", "", "<init>", "(Ljava/lang/String;I)V", "DO_NOTHING", "KILL_PROCESS", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MemoryLeakOptimizationAction extends Enum<MemoryLeakOptimizationAction> {
    public static final MemoryLeakOptimizationAction DO_NOTHING = null;
    public static final MemoryLeakOptimizationAction KILL_PROCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MemoryLeakOptimizationAction[] f390985a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f390986b = null;

    public static EnumEntries<MemoryLeakOptimizationAction> getEntries() {
        return f390986b;
    }

    static {
        MemoryLeakOptimizationAction r100 = new MemoryLeakOptimizationAction("DO_NOTHING", 0);
        DO_NOTHING = r100;
        MemoryLeakOptimizationAction r101 = new MemoryLeakOptimizationAction("KILL_PROCESS", 1);
        KILL_PROCESS = r101;
        MemoryLeakOptimizationAction[] r102 = {r100, r101};
        f390985a = r102;
        f390986b = EnumEntriesKt.enumEntries(r102);
    }

    public static MemoryLeakOptimizationAction[] values() {
        return (MemoryLeakOptimizationAction[]) f390985a.clone();
    }

    public static MemoryLeakOptimizationAction valueOf(String r100) {
        return (MemoryLeakOptimizationAction) r27.a.a(MemoryLeakOptimizationAction.class, r100);
    }

    public MemoryLeakOptimizationAction(String r100, int r101) {
        super(r100, r101);
    }
}
