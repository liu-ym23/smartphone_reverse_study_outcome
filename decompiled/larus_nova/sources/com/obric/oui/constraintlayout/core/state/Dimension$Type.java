package com.obric.oui.constraintlayout.core.state;

/* JADX INFO: loaded from: classes34.dex */
public final enum Dimension$Type extends Enum<Dimension$Type> {
    public static final Dimension$Type FIXED = null;
    public static final Dimension$Type MATCH_CONSTRAINT = null;
    public static final Dimension$Type MATCH_PARENT = null;
    public static final Dimension$Type WRAP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Dimension$Type[] f399681a = null;

    static {
        Dimension$Type r100 = new Dimension$Type("FIXED", 0);
        FIXED = r100;
        Dimension$Type r101 = new Dimension$Type("WRAP", 1);
        WRAP = r101;
        Dimension$Type r102 = new Dimension$Type("MATCH_PARENT", 2);
        MATCH_PARENT = r102;
        Dimension$Type r103 = new Dimension$Type("MATCH_CONSTRAINT", 3);
        MATCH_CONSTRAINT = r103;
        f399681a = new Dimension$Type[]{r100, r101, r102, r103};
    }

    public static Dimension$Type[] values() {
        return (Dimension$Type[]) f399681a.clone();
    }

    public static Dimension$Type valueOf(String r100) {
        return (Dimension$Type) r27.a.a(Dimension$Type.class, r100);
    }

    public Dimension$Type(String r100, int r101) {
        super(r100, r101);
    }
}
