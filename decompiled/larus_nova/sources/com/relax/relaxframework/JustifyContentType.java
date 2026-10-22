package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/relax/relaxframework/JustifyContentType;", "", "", "value", "I", "getValue", "()I", "Start", "Center", "End", "SpaceBetween", "SpaceAround", "SpaceEvenly", "Stretch", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum JustifyContentType extends Enum<JustifyContentType> {
    public static final JustifyContentType Center = null;
    public static final JustifyContentType End = null;
    public static final JustifyContentType SpaceAround = null;
    public static final JustifyContentType SpaceBetween = null;
    public static final JustifyContentType SpaceEvenly = null;
    public static final JustifyContentType Start = null;
    public static final JustifyContentType Stretch = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ JustifyContentType[] f404749a = null;
    private final int value;

    public static JustifyContentType valueOf(String r100) {
        return (JustifyContentType) r27.a.a(JustifyContentType.class, r100);
    }

    public static JustifyContentType[] values() {
        return (JustifyContentType[]) f404749a.clone();
    }

    static {
        JustifyContentType r100 = new JustifyContentType("Start", 0, 0);
        Start = r100;
        JustifyContentType r101 = new JustifyContentType("Center", 1, 1);
        Center = r101;
        JustifyContentType r102 = new JustifyContentType("End", 2, 2);
        End = r102;
        JustifyContentType r103 = new JustifyContentType("SpaceBetween", 3, 3);
        SpaceBetween = r103;
        JustifyContentType r104 = new JustifyContentType("SpaceAround", 4, 4);
        SpaceAround = r104;
        JustifyContentType r105 = new JustifyContentType("SpaceEvenly", 5, 5);
        SpaceEvenly = r105;
        JustifyContentType r110 = new JustifyContentType("Stretch", 6, 6);
        Stretch = r110;
        f404749a = new JustifyContentType[]{r100, r101, r102, r103, r104, r105, r110};
    }

    public final int getValue() {
        return this.value;
    }

    public JustifyContentType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
