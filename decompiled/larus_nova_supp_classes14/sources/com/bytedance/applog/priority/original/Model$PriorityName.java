package com.bytedance.applog.priority.original;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"com/bytedance/applog/priority/original/Model$PriorityName", "", "Lcom/bytedance/applog/priority/original/Model$PriorityName;", "P0", "P1", "P2", "priority_release"}, k = 1, mv = {1, 6, 0})
public final enum Model$PriorityName extends Enum<Model$PriorityName> {
    public static final Model$PriorityName P0 = null;
    public static final Model$PriorityName P1 = null;
    public static final Model$PriorityName P2 = null;
    public static final /* synthetic */ Model$PriorityName[] a = null;

    public static Model$PriorityName valueOf(String r1) {
        return (Model$PriorityName) r27.a.a(Model$PriorityName.class, r1);
    }

    public static Model$PriorityName[] values() {
        return (Model$PriorityName[]) a.clone();
    }

    static {
        Model$PriorityName r0 = new Model$PriorityName("P0", 0);
        P0 = r0;
        Model$PriorityName r1 = new Model$PriorityName("P1", 1);
        P1 = r1;
        Model$PriorityName r3 = new Model$PriorityName("P2", 2);
        P2 = r3;
        a = new Model$PriorityName[]{r0, r1, r3};
    }

    public Model$PriorityName(String r1, int r2) {
        super(r1, r2);
    }
}
