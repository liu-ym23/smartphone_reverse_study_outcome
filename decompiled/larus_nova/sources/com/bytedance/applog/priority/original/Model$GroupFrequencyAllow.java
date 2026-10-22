package com.bytedance.applog.priority.original;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"com/bytedance/applog/priority/original/Model$GroupFrequencyAllow", "", "Lcom/bytedance/applog/priority/original/Model$GroupFrequencyAllow;", "Allow", "BlockByFrequency", "BlockByBackoff", "priority_release"}, k = 1, mv = {1, 6, 0})
public final enum Model$GroupFrequencyAllow extends Enum<Model$GroupFrequencyAllow> {
    public static final Model$GroupFrequencyAllow Allow = null;
    public static final Model$GroupFrequencyAllow BlockByBackoff = null;
    public static final Model$GroupFrequencyAllow BlockByFrequency = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Model$GroupFrequencyAllow[] f192689a = null;

    public static Model$GroupFrequencyAllow valueOf(String r100) {
        return (Model$GroupFrequencyAllow) r27.a.a(Model$GroupFrequencyAllow.class, r100);
    }

    public static Model$GroupFrequencyAllow[] values() {
        return (Model$GroupFrequencyAllow[]) f192689a.clone();
    }

    static {
        Model$GroupFrequencyAllow r100 = new Model$GroupFrequencyAllow("Allow", 0);
        Allow = r100;
        Model$GroupFrequencyAllow r101 = new Model$GroupFrequencyAllow("BlockByFrequency", 1);
        BlockByFrequency = r101;
        Model$GroupFrequencyAllow r102 = new Model$GroupFrequencyAllow("BlockByBackoff", 2);
        BlockByBackoff = r102;
        f192689a = new Model$GroupFrequencyAllow[]{r100, r101, r102};
    }

    public Model$GroupFrequencyAllow(String r100, int r101) {
        super(r100, r101);
    }
}
