package com.google.zxing.aztec.decoder;

import r27.a;

/* JADX INFO: loaded from: classes23.dex */
final enum Decoder$Table extends Enum<Decoder$Table> {
    public static final Decoder$Table BINARY = null;
    public static final Decoder$Table DIGIT = null;
    public static final Decoder$Table LOWER = null;
    public static final Decoder$Table MIXED = null;
    public static final Decoder$Table PUNCT = null;
    public static final Decoder$Table UPPER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Decoder$Table[] f275940a = null;

    static {
        Decoder$Table r100 = new Decoder$Table("UPPER", 0);
        UPPER = r100;
        Decoder$Table r101 = new Decoder$Table("LOWER", 1);
        LOWER = r101;
        Decoder$Table r102 = new Decoder$Table("MIXED", 2);
        MIXED = r102;
        Decoder$Table r103 = new Decoder$Table("DIGIT", 3);
        DIGIT = r103;
        Decoder$Table r104 = new Decoder$Table("PUNCT", 4);
        PUNCT = r104;
        Decoder$Table r105 = new Decoder$Table("BINARY", 5);
        BINARY = r105;
        f275940a = new Decoder$Table[]{r100, r101, r102, r103, r104, r105};
    }

    public static Decoder$Table[] values() {
        return (Decoder$Table[]) f275940a.clone();
    }

    public static Decoder$Table valueOf(String r100) {
        return (Decoder$Table) a.a(Decoder$Table.class, r100);
    }

    public Decoder$Table(String r100, int r101) {
        super(r100, r101);
    }
}
