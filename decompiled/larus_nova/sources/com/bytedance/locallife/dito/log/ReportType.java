package com.bytedance.locallife.dito.log;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/locallife/dito/log/ReportType;", "", "WARNING", "STATICS", "IMMEDIATELY", "dito-core-saas_release"}, k = 1, mv = {1, 4, 3})
public final enum ReportType extends Enum<ReportType> {
    public static final ReportType IMMEDIATELY = null;
    public static final ReportType STATICS = null;
    public static final ReportType WARNING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ReportType[] f258444a = null;

    public static ReportType valueOf(String r100) {
        return (ReportType) a.a(ReportType.class, r100);
    }

    public static ReportType[] values() {
        return (ReportType[]) f258444a.clone();
    }

    static {
        ReportType r100 = new ReportType("WARNING", 0);
        WARNING = r100;
        ReportType r101 = new ReportType("STATICS", 1);
        STATICS = r101;
        ReportType r102 = new ReportType("IMMEDIATELY", 2);
        IMMEDIATELY = r102;
        f258444a = new ReportType[]{r100, r101, r102};
    }

    public ReportType(String r100, int r101) {
        super(r100, r101);
    }
}
