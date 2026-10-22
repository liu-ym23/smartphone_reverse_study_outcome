package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/relax/relaxframework/ListScrollToPositionAlign;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "Top", "Middle", "Bottom", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum ListScrollToPositionAlign extends Enum<ListScrollToPositionAlign> {
    public static final ListScrollToPositionAlign Bottom = null;
    public static final ListScrollToPositionAlign Middle = null;
    public static final ListScrollToPositionAlign Top = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ListScrollToPositionAlign[] f404774a = null;
    private final String value;

    public static ListScrollToPositionAlign valueOf(String r100) {
        return (ListScrollToPositionAlign) r27.a.a(ListScrollToPositionAlign.class, r100);
    }

    public static ListScrollToPositionAlign[] values() {
        return (ListScrollToPositionAlign[]) f404774a.clone();
    }

    static {
        ListScrollToPositionAlign r100 = new ListScrollToPositionAlign("Top", 0, "top");
        Top = r100;
        ListScrollToPositionAlign r101 = new ListScrollToPositionAlign("Middle", 1, "middle");
        Middle = r101;
        ListScrollToPositionAlign r102 = new ListScrollToPositionAlign("Bottom", 2, "bottom");
        Bottom = r102;
        f404774a = new ListScrollToPositionAlign[]{r100, r101, r102};
    }

    public final String getValue() {
        return this.value;
    }

    public ListScrollToPositionAlign(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
