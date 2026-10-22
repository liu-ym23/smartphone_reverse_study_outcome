package com.bytedance.locallife.dito.interact;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/locallife/dito/interact/HeadUnfoldState;", "", "STATE_HEAD_FOLD", "STATE_HEAD_TRANSITION", "STATE_HEAD_UNFOLD", "dito-core-saas_release"}, k = 1, mv = {1, 4, 3})
public final enum HeadUnfoldState extends Enum<HeadUnfoldState> {
    public static final HeadUnfoldState STATE_HEAD_FOLD = null;
    public static final HeadUnfoldState STATE_HEAD_TRANSITION = null;
    public static final HeadUnfoldState STATE_HEAD_UNFOLD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HeadUnfoldState[] f258417a = null;

    public static HeadUnfoldState valueOf(String r100) {
        return (HeadUnfoldState) r27.a.a(HeadUnfoldState.class, r100);
    }

    public static HeadUnfoldState[] values() {
        return (HeadUnfoldState[]) f258417a.clone();
    }

    static {
        HeadUnfoldState r100 = new HeadUnfoldState("STATE_HEAD_FOLD", 0);
        STATE_HEAD_FOLD = r100;
        HeadUnfoldState r101 = new HeadUnfoldState("STATE_HEAD_TRANSITION", 1);
        STATE_HEAD_TRANSITION = r101;
        HeadUnfoldState r102 = new HeadUnfoldState("STATE_HEAD_UNFOLD", 2);
        STATE_HEAD_UNFOLD = r102;
        f258417a = new HeadUnfoldState[]{r100, r101, r102};
    }

    public HeadUnfoldState(String r100, int r101) {
        super(r100, r101);
    }
}
