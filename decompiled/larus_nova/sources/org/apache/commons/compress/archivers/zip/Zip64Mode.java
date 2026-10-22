package org.apache.commons.compress.archivers.zip;

import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum Zip64Mode extends Enum<Zip64Mode> {
    private static final /* synthetic */ Zip64Mode[] $VALUES = null;
    public static final Zip64Mode Always = null;
    public static final Zip64Mode AsNeeded = null;
    public static final Zip64Mode Never = null;

    static {
        Zip64Mode r100 = new Zip64Mode("Always", 0);
        Always = r100;
        Zip64Mode r101 = new Zip64Mode("Never", 1);
        Never = r101;
        Zip64Mode r102 = new Zip64Mode("AsNeeded", 2);
        AsNeeded = r102;
        $VALUES = new Zip64Mode[]{r100, r101, r102};
    }

    public static Zip64Mode[] values() {
        return (Zip64Mode[]) $VALUES.clone();
    }

    public static Zip64Mode valueOf(String r100) {
        return (Zip64Mode) a.a(Zip64Mode.class, r100);
    }

    private Zip64Mode(String r100, int r101) {
        super(r100, r101);
    }
}
