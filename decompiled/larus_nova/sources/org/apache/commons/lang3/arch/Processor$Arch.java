package org.apache.commons.lang3.arch;

import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum Processor$Arch extends Enum<Processor$Arch> {
    private static final /* synthetic */ Processor$Arch[] $VALUES = null;
    public static final Processor$Arch BIT_32 = null;
    public static final Processor$Arch BIT_64 = null;
    public static final Processor$Arch UNKNOWN = null;

    static {
        Processor$Arch r100 = new Processor$Arch("BIT_32", 0);
        BIT_32 = r100;
        Processor$Arch r101 = new Processor$Arch("BIT_64", 1);
        BIT_64 = r101;
        Processor$Arch r102 = new Processor$Arch("UNKNOWN", 2);
        UNKNOWN = r102;
        $VALUES = new Processor$Arch[]{r100, r101, r102};
    }

    public static Processor$Arch[] values() {
        return (Processor$Arch[]) $VALUES.clone();
    }

    public static Processor$Arch valueOf(String r100) {
        return (Processor$Arch) a.a(Processor$Arch.class, r100);
    }

    private Processor$Arch(String r100, int r101) {
        super(r100, r101);
    }
}
