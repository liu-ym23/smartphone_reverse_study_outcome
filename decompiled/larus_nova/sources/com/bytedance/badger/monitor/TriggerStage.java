package com.bytedance.badger.monitor;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/badger/monitor/TriggerStage;", "", "login_finished", "login", "recollect", "manual", "periodic_first", "periodic", "custom", "badger-core_release"}, k = 1, mv = {1, 4, 0})
public final enum TriggerStage extends Enum {
    private static final /* synthetic */ TriggerStage[] $VALUES = null;
    public static final TriggerStage custom = null;
    public static final TriggerStage login = null;
    public static final TriggerStage login_finished = null;
    public static final TriggerStage manual = null;
    public static final TriggerStage periodic = null;
    public static final TriggerStage periodic_first = null;
    public static final TriggerStage recollect = null;

    static {
        TriggerStage r100 = new TriggerStage("login_finished", 0);
        login_finished = r100;
        TriggerStage r101 = new TriggerStage("login", 1);
        login = r101;
        TriggerStage r102 = new TriggerStage("recollect", 2);
        recollect = r102;
        TriggerStage r103 = new TriggerStage("manual", 3);
        manual = r103;
        TriggerStage r104 = new TriggerStage("periodic_first", 4);
        periodic_first = r104;
        TriggerStage r105 = new TriggerStage("periodic", 5);
        periodic = r105;
        TriggerStage r106 = new TriggerStage("custom", 6);
        custom = r106;
        $VALUES = new TriggerStage[]{r100, r101, r102, r103, r104, r105, r106};
    }

    public TriggerStage(String r100, int r101) {
        super(r100, r101);
    }

    public static TriggerStage valueOf(String r100) {
        return (TriggerStage) r27.a.a(TriggerStage.class, r100);
    }

    public static TriggerStage[] values() {
        return (TriggerStage[]) $VALUES.clone();
    }
}
