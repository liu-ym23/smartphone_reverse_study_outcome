package com.larus.paging;

import com.larus.dora.api.model.FlowDoraWifiScene;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/larus/paging/CombineSource;", "", "INITIAL", "RECEIVER", FlowDoraWifiScene.OTHER, "paging-common_release"}, k = 1, mv = {1, 7, 1})
public final enum CombineSource extends Enum<CombineSource> {
    public static final CombineSource INITIAL = null;
    public static final CombineSource OTHER = null;
    public static final CombineSource RECEIVER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CombineSource[] f363642a = null;

    public static CombineSource valueOf(String r100) {
        return (CombineSource) r27.a.a(CombineSource.class, r100);
    }

    public static CombineSource[] values() {
        return (CombineSource[]) f363642a.clone();
    }

    static {
        CombineSource r100 = new CombineSource("INITIAL", 0);
        INITIAL = r100;
        CombineSource r101 = new CombineSource("RECEIVER", 1);
        RECEIVER = r101;
        CombineSource r102 = new CombineSource(FlowDoraWifiScene.OTHER, 2);
        OTHER = r102;
        f363642a = new CombineSource[]{r100, r101, r102};
    }

    public CombineSource(String r100, int r101) {
        super(r100, r101);
    }
}
