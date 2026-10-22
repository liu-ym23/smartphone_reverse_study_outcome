package com.bytedance.badger.monitor;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/badger/monitor/CollectStage;", "", "collect_pre", "collect_finished", "report_finished", "badger-core_release"}, k = 1, mv = {1, 4, 0})
public final enum CollectStage extends Enum {
    private static final /* synthetic */ CollectStage[] $VALUES = null;
    public static final CollectStage collect_finished = null;
    public static final CollectStage collect_pre = null;
    public static final CollectStage report_finished = null;

    static {
        CollectStage r100 = new CollectStage("collect_pre", 0);
        collect_pre = r100;
        CollectStage r101 = new CollectStage("collect_finished", 1);
        collect_finished = r101;
        CollectStage r102 = new CollectStage("report_finished", 2);
        report_finished = r102;
        $VALUES = new CollectStage[]{r100, r101, r102};
    }

    public CollectStage(String r100, int r101) {
        super(r100, r101);
    }

    public static CollectStage valueOf(String r100) {
        return (CollectStage) r27.a.a(CollectStage.class, r100);
    }

    public static CollectStage[] values() {
        return (CollectStage[]) $VALUES.clone();
    }
}
