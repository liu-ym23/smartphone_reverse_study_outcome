package com.bytedance.locallife.dito.view;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/locallife/dito/view/NestedJudgmentEdge;", "", "", "edge", "Ljava/lang/String;", "getEdge", "()Ljava/lang/String;", "Top", "Bottom", "Both", "dito-core-saas_release"}, k = 1, mv = {1, 4, 3})
public final enum NestedJudgmentEdge extends Enum<NestedJudgmentEdge> {
    public static final NestedJudgmentEdge Both = null;
    public static final NestedJudgmentEdge Bottom = null;
    public static final NestedJudgmentEdge Top = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NestedJudgmentEdge[] f258743a = null;
    private final String edge;

    public static NestedJudgmentEdge valueOf(String r100) {
        return (NestedJudgmentEdge) r27.a.a(NestedJudgmentEdge.class, r100);
    }

    public static NestedJudgmentEdge[] values() {
        return (NestedJudgmentEdge[]) f258743a.clone();
    }

    static {
        NestedJudgmentEdge r100 = new NestedJudgmentEdge("Top", 0, "top");
        Top = r100;
        NestedJudgmentEdge r101 = new NestedJudgmentEdge("Bottom", 1, "bottom");
        Bottom = r101;
        NestedJudgmentEdge r102 = new NestedJudgmentEdge("Both", 2, "both");
        Both = r102;
        f258743a = new NestedJudgmentEdge[]{r100, r101, r102};
    }

    public final String getEdge() {
        return this.edge;
    }

    public NestedJudgmentEdge(String r100, int r101, String r102) {
        super(r100, r101);
        this.edge = r102;
    }
}
