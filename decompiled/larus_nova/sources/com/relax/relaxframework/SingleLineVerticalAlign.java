package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/relax/relaxframework/SingleLineVerticalAlign;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "Normal", "Center", "Bottom", "Top", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum SingleLineVerticalAlign extends Enum<SingleLineVerticalAlign> {
    public static final SingleLineVerticalAlign Bottom = null;
    public static final SingleLineVerticalAlign Center = null;
    public static final SingleLineVerticalAlign Normal = null;
    public static final SingleLineVerticalAlign Top = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SingleLineVerticalAlign[] f404957a = null;
    private final String value;

    public static SingleLineVerticalAlign valueOf(String r100) {
        return (SingleLineVerticalAlign) r27.a.a(SingleLineVerticalAlign.class, r100);
    }

    public static SingleLineVerticalAlign[] values() {
        return (SingleLineVerticalAlign[]) f404957a.clone();
    }

    static {
        SingleLineVerticalAlign r100 = new SingleLineVerticalAlign("Normal", 0, "normal");
        Normal = r100;
        SingleLineVerticalAlign r101 = new SingleLineVerticalAlign("Center", 1, "center");
        Center = r101;
        SingleLineVerticalAlign r102 = new SingleLineVerticalAlign("Bottom", 2, "bottom");
        Bottom = r102;
        SingleLineVerticalAlign r103 = new SingleLineVerticalAlign("Top", 3, "top");
        Top = r103;
        f404957a = new SingleLineVerticalAlign[]{r100, r101, r102, r103};
    }

    public final String getValue() {
        return this.value;
    }

    public SingleLineVerticalAlign(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
