package com.ss.android.ugc.aweme.poi.event;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/poi/event/GoodsDialogState;", "", "OPEN", "CLOSE", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final enum GoodsDialogState extends Enum<GoodsDialogState> {
    public static final GoodsDialogState CLOSE = null;
    public static final GoodsDialogState OPEN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GoodsDialogState[] f451325a = null;

    public static GoodsDialogState valueOf(String r100) {
        return (GoodsDialogState) a.a(GoodsDialogState.class, r100);
    }

    public static GoodsDialogState[] values() {
        return (GoodsDialogState[]) f451325a.clone();
    }

    static {
        GoodsDialogState r100 = new GoodsDialogState("OPEN", 0);
        OPEN = r100;
        GoodsDialogState r101 = new GoodsDialogState("CLOSE", 1);
        CLOSE = r101;
        f451325a = new GoodsDialogState[]{r100, r101};
    }

    public GoodsDialogState(String r100, int r101) {
        super(r100, r101);
    }
}
