package com.bytedance.locallife.dito.view;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/locallife/dito/view/ListEdge;", "", "", "edge", "Ljava/lang/String;", "getEdge", "()Ljava/lang/String;", "Top", "Bottom", "dito-core-saas_release"}, k = 1, mv = {1, 4, 3})
public final enum ListEdge extends Enum<ListEdge> {
    public static final ListEdge Bottom = null;
    public static final ListEdge Top = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ListEdge[] f258742a = null;
    private final String edge;

    public static ListEdge valueOf(String r100) {
        return (ListEdge) r27.a.a(ListEdge.class, r100);
    }

    public static ListEdge[] values() {
        return (ListEdge[]) f258742a.clone();
    }

    static {
        ListEdge r100 = new ListEdge("Top", 0, "top");
        Top = r100;
        ListEdge r101 = new ListEdge("Bottom", 1, "bottom");
        Bottom = r101;
        f258742a = new ListEdge[]{r100, r101};
    }

    public final String getEdge() {
        return this.edge;
    }

    public ListEdge(String r100, int r101, String r102) {
        super(r100, r101);
        this.edge = r102;
    }
}
