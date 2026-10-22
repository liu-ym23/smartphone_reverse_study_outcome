package com.google.errorprone.annotations;

import r27.a;

/* JADX INFO: loaded from: classes23.dex */
public final enum Modifier extends Enum<Modifier> {
    public static final Modifier ABSTRACT = null;
    public static final Modifier DEFAULT = null;
    public static final Modifier FINAL = null;
    public static final Modifier NATIVE = null;
    public static final Modifier PRIVATE = null;
    public static final Modifier PROTECTED = null;
    public static final Modifier PUBLIC = null;
    public static final Modifier STATIC = null;
    public static final Modifier STRICTFP = null;
    public static final Modifier SYNCHRONIZED = null;
    public static final Modifier TRANSIENT = null;
    public static final Modifier VOLATILE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Modifier[] f275913a = null;

    static {
        Modifier r100 = new Modifier("PUBLIC", 0);
        PUBLIC = r100;
        Modifier r101 = new Modifier("PROTECTED", 1);
        PROTECTED = r101;
        Modifier r102 = new Modifier("PRIVATE", 2);
        PRIVATE = r102;
        Modifier r103 = new Modifier("ABSTRACT", 3);
        ABSTRACT = r103;
        Modifier r104 = new Modifier("DEFAULT", 4);
        DEFAULT = r104;
        Modifier r105 = new Modifier("STATIC", 5);
        STATIC = r105;
        Modifier r110 = new Modifier("FINAL", 6);
        FINAL = r110;
        Modifier r111 = new Modifier("TRANSIENT", 7);
        TRANSIENT = r111;
        Modifier r112 = new Modifier("VOLATILE", 8);
        VOLATILE = r112;
        Modifier r113 = new Modifier("SYNCHRONIZED", 9);
        SYNCHRONIZED = r113;
        Modifier r114 = new Modifier("NATIVE", 10);
        NATIVE = r114;
        Modifier r115 = new Modifier("STRICTFP", 11);
        STRICTFP = r115;
        f275913a = new Modifier[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115};
    }

    public static Modifier[] values() {
        return (Modifier[]) f275913a.clone();
    }

    public static Modifier valueOf(String r100) {
        return (Modifier) a.a(Modifier.class, r100);
    }

    public Modifier(String r100, int r101) {
        super(r100, r101);
    }
}
