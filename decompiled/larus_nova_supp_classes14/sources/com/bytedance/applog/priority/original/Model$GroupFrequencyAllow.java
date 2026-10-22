package com.bytedance.applog.priority.original;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"com/bytedance/applog/priority/original/Model$GroupFrequencyAllow", "", "Lcom/bytedance/applog/priority/original/Model$GroupFrequencyAllow;", "Allow", "BlockByFrequency", "BlockByBackoff", "priority_release"}, k = 1, mv = {1, 6, 0})
public final enum Model$GroupFrequencyAllow extends Enum<Model$GroupFrequencyAllow> {
    public static final Model$GroupFrequencyAllow Allow = null;
    public static final Model$GroupFrequencyAllow BlockByBackoff = null;
    public static final Model$GroupFrequencyAllow BlockByFrequency = null;
    public static final /* synthetic */ Model$GroupFrequencyAllow[] a = null;

    public static Model$GroupFrequencyAllow valueOf(String r1) {
        return (Model$GroupFrequencyAllow) r27.a.a(Model$GroupFrequencyAllow.class, r1);
    }

    public static Model$GroupFrequencyAllow[] values() {
        return (Model$GroupFrequencyAllow[]) a.clone();
    }

    static {
        Model$GroupFrequencyAllow r0 = new Model$GroupFrequencyAllow("Allow", 0);
        Allow = r0;
        Model$GroupFrequencyAllow r1 = new Model$GroupFrequencyAllow("BlockByFrequency", 1);
        BlockByFrequency = r1;
        Model$GroupFrequencyAllow r3 = new Model$GroupFrequencyAllow("BlockByBackoff", 2);
        BlockByBackoff = r3;
        a = new Model$GroupFrequencyAllow[]{r0, r1, r3};
    }

    public Model$GroupFrequencyAllow(String r1, int r2) {
        super(r1, r2);
    }
}
