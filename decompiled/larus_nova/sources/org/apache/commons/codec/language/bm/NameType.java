package org.apache.commons.codec.language.bm;

import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum NameType extends Enum<NameType> {
    private static final /* synthetic */ NameType[] $VALUES = null;
    public static final NameType ASHKENAZI = null;
    public static final NameType GENERIC = null;
    public static final NameType SEPHARDIC = null;
    private final String name;

    private static /* synthetic */ NameType[] $values() {
        return new NameType[]{ASHKENAZI, GENERIC, SEPHARDIC};
    }

    static {
        ASHKENAZI = new NameType("ASHKENAZI", 0, "ash");
        GENERIC = new NameType("GENERIC", 1, "gen");
        SEPHARDIC = new NameType("SEPHARDIC", 2, "sep");
        $VALUES = $values();
    }

    public static NameType[] values() {
        return (NameType[]) $VALUES.clone();
    }

    public String getName() {
        return this.name;
    }

    public static NameType valueOf(String r100) {
        return (NameType) a.a(NameType.class, r100);
    }

    private NameType(String r100, int r101, String r102) {
        super(r100, r101);
        this.name = r102;
    }
}
