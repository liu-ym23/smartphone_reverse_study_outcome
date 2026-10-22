package com.bytedance.applog.priority.original;

import com.bytedance.android.livesdk.diagnose.DiagnoseResult;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"com/bytedance/applog/priority/original/Model$PriorityName", "", "Lcom/bytedance/applog/priority/original/Model$PriorityName;", DiagnoseResult.DIAGNOSE_LEVEL_P0, DiagnoseResult.DIAGNOSE_LEVEL_P1, DiagnoseResult.DIAGNOSE_LEVEL_P2, "priority_release"}, k = 1, mv = {1, 6, 0})
public final enum Model$PriorityName extends Enum<Model$PriorityName> {
    public static final Model$PriorityName P0 = null;
    public static final Model$PriorityName P1 = null;
    public static final Model$PriorityName P2 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Model$PriorityName[] f192690a = null;

    public static Model$PriorityName valueOf(String r100) {
        return (Model$PriorityName) r27.a.a(Model$PriorityName.class, r100);
    }

    public static Model$PriorityName[] values() {
        return (Model$PriorityName[]) f192690a.clone();
    }

    static {
        Model$PriorityName r100 = new Model$PriorityName(DiagnoseResult.DIAGNOSE_LEVEL_P0, 0);
        P0 = r100;
        Model$PriorityName r101 = new Model$PriorityName(DiagnoseResult.DIAGNOSE_LEVEL_P1, 1);
        P1 = r101;
        Model$PriorityName r102 = new Model$PriorityName(DiagnoseResult.DIAGNOSE_LEVEL_P2, 2);
        P2 = r102;
        f192690a = new Model$PriorityName[]{r100, r101, r102};
    }

    public Model$PriorityName(String r100, int r101) {
        super(r100, r101);
    }
}
