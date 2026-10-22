package com.bytedance.badger.data;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/badger/data/ReportStage;", "", "PARTIAL", "FINAL", "badger-api_release"}, k = 1, mv = {1, 4, 0})
public final enum ReportStage extends Enum<ReportStage> {
    public static final ReportStage FINAL = null;
    public static final ReportStage PARTIAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ReportStage[] f199029a = null;

    static {
        ReportStage r100 = new ReportStage("PARTIAL", 0);
        PARTIAL = r100;
        ReportStage r101 = new ReportStage("FINAL", 1);
        FINAL = r101;
        f199029a = new ReportStage[]{r100, r101};
    }

    public static ReportStage valueOf(String r100) {
        return (ReportStage) a.a(ReportStage.class, r100);
    }

    public static ReportStage[] values() {
        return (ReportStage[]) f199029a.clone();
    }

    public ReportStage(String r100, int r101) {
        super(r100, r101);
    }
}
