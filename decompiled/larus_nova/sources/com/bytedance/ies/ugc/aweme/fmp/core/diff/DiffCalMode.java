package com.bytedance.ies.ugc.aweme.fmp.core.diff;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ies/ugc/aweme/fmp/core/diff/DiffCalMode;", "", "CLOSE", "CAL_EACH_CALLBACK", "CAL_FMP_HAPPEN", "fmp-core_saasRelease"}, k = 1, mv = {1, 6, 0})
public final enum DiffCalMode extends Enum<DiffCalMode> {
    public static final DiffCalMode CAL_EACH_CALLBACK = null;
    public static final DiffCalMode CAL_FMP_HAPPEN = null;
    public static final DiffCalMode CLOSE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DiffCalMode[] f248910a = null;

    public static DiffCalMode valueOf(String r100) {
        return (DiffCalMode) a.a(DiffCalMode.class, r100);
    }

    public static DiffCalMode[] values() {
        return (DiffCalMode[]) f248910a.clone();
    }

    static {
        DiffCalMode r100 = new DiffCalMode("CLOSE", 0);
        CLOSE = r100;
        DiffCalMode r101 = new DiffCalMode("CAL_EACH_CALLBACK", 1);
        CAL_EACH_CALLBACK = r101;
        DiffCalMode r102 = new DiffCalMode("CAL_FMP_HAPPEN", 2);
        CAL_FMP_HAPPEN = r102;
        f248910a = new DiffCalMode[]{r100, r101, r102};
    }

    public DiffCalMode(String r100, int r101) {
        super(r100, r101);
    }
}
