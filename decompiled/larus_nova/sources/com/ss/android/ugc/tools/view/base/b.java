package com.ss.android.ugc.tools.view.base;

/* JADX INFO: loaded from: classes40.dex */
public final /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f454875a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f454876b = null;

    static {
        int[] r100 = new int[BaseTransitionView.State.values().length];
        f454875a = r100;
        BaseTransitionView.State r101 = BaseTransitionView.State.SHOWING;
        r100[r101.ordinal()] = 1;
        r100[BaseTransitionView.State.SHOWN.ordinal()] = 2;
        BaseTransitionView.State r102 = BaseTransitionView.State.HIDING;
        r100[r102.ordinal()] = 3;
        int[] r103 = new int[BaseTransitionView.State.values().length];
        f454876b = r103;
        r103[r102.ordinal()] = 1;
        r103[BaseTransitionView.State.HIDE.ordinal()] = 2;
        r103[r101.ordinal()] = 3;
    }
}
