package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/relax/relaxframework/JustifyContent;", "", "", "value", "I", "getValue", "()I", "Start", "Center", "End", "SpaceBetween", "SpaceAround", "SpaceEvenly", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum JustifyContent extends Enum<JustifyContent> {
    public static final JustifyContent Center = null;
    public static final JustifyContent End = null;
    public static final JustifyContent SpaceAround = null;
    public static final JustifyContent SpaceBetween = null;
    public static final JustifyContent SpaceEvenly = null;
    public static final JustifyContent Start = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ JustifyContent[] f404748a = null;
    private final int value;

    public static JustifyContent valueOf(String r100) {
        return (JustifyContent) r27.a.a(JustifyContent.class, r100);
    }

    public static JustifyContent[] values() {
        return (JustifyContent[]) f404748a.clone();
    }

    static {
        JustifyContent r100 = new JustifyContent("Start", 0, 0);
        Start = r100;
        JustifyContent r101 = new JustifyContent("Center", 1, 1);
        Center = r101;
        JustifyContent r102 = new JustifyContent("End", 2, 2);
        End = r102;
        JustifyContent r103 = new JustifyContent("SpaceBetween", 3, 3);
        SpaceBetween = r103;
        JustifyContent r104 = new JustifyContent("SpaceAround", 4, 4);
        SpaceAround = r104;
        JustifyContent r105 = new JustifyContent("SpaceEvenly", 5, 5);
        SpaceEvenly = r105;
        f404748a = new JustifyContent[]{r100, r101, r102, r103, r104, r105};
    }

    public final int getValue() {
        return this.value;
    }

    public JustifyContent(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
