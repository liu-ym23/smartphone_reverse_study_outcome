package com.bytedance.locallife.dito.view;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/locallife/dito/view/VisibleState;", "", "VISIBLE", "GONE", "dito-core-saas_release"}, k = 1, mv = {1, 4, 3})
public final enum VisibleState extends Enum<VisibleState> {
    public static final VisibleState GONE = null;
    public static final VisibleState VISIBLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VisibleState[] f258774a = null;

    public static VisibleState valueOf(String r100) {
        return (VisibleState) r27.a.a(VisibleState.class, r100);
    }

    public static VisibleState[] values() {
        return (VisibleState[]) f258774a.clone();
    }

    static {
        VisibleState r100 = new VisibleState("VISIBLE", 0);
        VISIBLE = r100;
        VisibleState r101 = new VisibleState("GONE", 1);
        GONE = r101;
        f258774a = new VisibleState[]{r100, r101};
    }

    public VisibleState(String r100, int r101) {
        super(r100, r101);
    }
}
