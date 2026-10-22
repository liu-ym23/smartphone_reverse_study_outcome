package com.bytedance.locallife.groupon.struct.performance.preload;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/performance/preload/TriggerAction;", "", "APPIDLE", "INPAGE", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final enum TriggerAction extends Enum<TriggerAction> {
    public static final TriggerAction APPIDLE = null;
    public static final TriggerAction INPAGE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TriggerAction[] f258847a = null;

    public static TriggerAction valueOf(String r100) {
        return (TriggerAction) a.a(TriggerAction.class, r100);
    }

    public static TriggerAction[] values() {
        return (TriggerAction[]) f258847a.clone();
    }

    static {
        TriggerAction r100 = new TriggerAction("APPIDLE", 0);
        APPIDLE = r100;
        TriggerAction r101 = new TriggerAction("INPAGE", 1);
        INPAGE = r101;
        f258847a = new TriggerAction[]{r100, r101};
    }

    public TriggerAction(String r100, int r101) {
        super(r100, r101);
    }
}
