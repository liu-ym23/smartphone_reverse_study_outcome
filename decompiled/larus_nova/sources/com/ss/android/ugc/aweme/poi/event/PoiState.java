package com.ss.android.ugc.aweme.poi.event;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/poi/event/PoiState;", "", "OPEN", "CLOSE", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final enum PoiState extends Enum<PoiState> {
    public static final PoiState CLOSE = null;
    public static final PoiState OPEN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PoiState[] f451347a = null;

    public static PoiState valueOf(String r100) {
        return (PoiState) a.a(PoiState.class, r100);
    }

    public static PoiState[] values() {
        return (PoiState[]) f451347a.clone();
    }

    static {
        PoiState r100 = new PoiState("OPEN", 0);
        OPEN = r100;
        PoiState r101 = new PoiState("CLOSE", 1);
        CLOSE = r101;
        f451347a = new PoiState[]{r100, r101};
    }

    public PoiState(String r100, int r101) {
        super(r100, r101);
    }
}
