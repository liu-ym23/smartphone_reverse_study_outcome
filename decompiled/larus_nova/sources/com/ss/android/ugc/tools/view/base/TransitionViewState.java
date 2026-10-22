package com.ss.android.ugc.tools.view.base;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/ugc/tools/view/base/TransitionViewState;", "", "PRE_SHOW", "SHOWN", "PRE_HIDE", "HIDDEN", "lib-runtime_release"}, k = 1, mv = {1, 4, 1})
public final enum TransitionViewState extends Enum<TransitionViewState> {
    public static final TransitionViewState HIDDEN = null;
    public static final TransitionViewState PRE_HIDE = null;
    public static final TransitionViewState PRE_SHOW = null;
    public static final TransitionViewState SHOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TransitionViewState[] f454872a = null;

    static {
        TransitionViewState r100 = new TransitionViewState("PRE_SHOW", 0);
        PRE_SHOW = r100;
        TransitionViewState r101 = new TransitionViewState("SHOWN", 1);
        SHOWN = r101;
        TransitionViewState r102 = new TransitionViewState("PRE_HIDE", 2);
        PRE_HIDE = r102;
        TransitionViewState r103 = new TransitionViewState("HIDDEN", 3);
        HIDDEN = r103;
        f454872a = new TransitionViewState[]{r100, r101, r102, r103};
    }

    public static TransitionViewState valueOf(String r100) {
        return (TransitionViewState) r27.a.a(TransitionViewState.class, r100);
    }

    public static TransitionViewState[] values() {
        return (TransitionViewState[]) f454872a.clone();
    }

    public TransitionViewState(String r100, int r101) {
        super(r100, r101);
    }
}
