package com.google.common.graph;

/* JADX INFO: loaded from: classes23.dex */
final enum Graphs$NodeVisitState extends Enum<Graphs$NodeVisitState> {
    public static final Graphs$NodeVisitState COMPLETE = null;
    public static final Graphs$NodeVisitState PENDING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Graphs$NodeVisitState[] f275554a = null;

    static {
        Graphs$NodeVisitState r100 = new Graphs$NodeVisitState("PENDING", 0);
        PENDING = r100;
        Graphs$NodeVisitState r101 = new Graphs$NodeVisitState("COMPLETE", 1);
        COMPLETE = r101;
        f275554a = new Graphs$NodeVisitState[]{r100, r101};
    }

    public static Graphs$NodeVisitState[] values() {
        return (Graphs$NodeVisitState[]) f275554a.clone();
    }

    public static Graphs$NodeVisitState valueOf(String r100) {
        return (Graphs$NodeVisitState) r27.a.a(Graphs$NodeVisitState.class, r100);
    }

    public Graphs$NodeVisitState(String r100, int r101) {
        super(r100, r101);
    }
}
