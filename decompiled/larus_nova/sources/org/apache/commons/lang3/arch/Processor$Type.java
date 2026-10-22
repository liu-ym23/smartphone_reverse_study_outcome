package org.apache.commons.lang3.arch;

import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum Processor$Type extends Enum<Processor$Type> {
    private static final /* synthetic */ Processor$Type[] $VALUES = null;
    public static final Processor$Type IA_64 = null;
    public static final Processor$Type PPC = null;
    public static final Processor$Type UNKNOWN = null;
    public static final Processor$Type X86 = null;

    static {
        Processor$Type r100 = new Processor$Type("X86", 0);
        X86 = r100;
        Processor$Type r101 = new Processor$Type("IA_64", 1);
        IA_64 = r101;
        Processor$Type r102 = new Processor$Type("PPC", 2);
        PPC = r102;
        Processor$Type r103 = new Processor$Type("UNKNOWN", 3);
        UNKNOWN = r103;
        $VALUES = new Processor$Type[]{r100, r101, r102, r103};
    }

    public static Processor$Type[] values() {
        return (Processor$Type[]) $VALUES.clone();
    }

    public static Processor$Type valueOf(String r100) {
        return (Processor$Type) a.a(Processor$Type.class, r100);
    }

    private Processor$Type(String r100, int r101) {
        super(r100, r101);
    }
}
