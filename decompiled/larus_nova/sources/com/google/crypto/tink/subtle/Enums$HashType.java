package com.google.crypto.tink.subtle;

import r27.a;

/* JADX INFO: loaded from: classes23.dex */
public final enum Enums$HashType extends Enum<Enums$HashType> {
    public static final Enums$HashType SHA1 = null;
    public static final Enums$HashType SHA224 = null;
    public static final Enums$HashType SHA256 = null;
    public static final Enums$HashType SHA384 = null;
    public static final Enums$HashType SHA512 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Enums$HashType[] f275910a = null;

    static {
        Enums$HashType r100 = new Enums$HashType("SHA1", 0);
        SHA1 = r100;
        Enums$HashType r101 = new Enums$HashType("SHA224", 1);
        SHA224 = r101;
        Enums$HashType r102 = new Enums$HashType("SHA256", 2);
        SHA256 = r102;
        Enums$HashType r103 = new Enums$HashType("SHA384", 3);
        SHA384 = r103;
        Enums$HashType r104 = new Enums$HashType("SHA512", 4);
        SHA512 = r104;
        f275910a = new Enums$HashType[]{r100, r101, r102, r103, r104};
    }

    public static Enums$HashType[] values() {
        return (Enums$HashType[]) f275910a.clone();
    }

    public static Enums$HashType valueOf(String r100) {
        return (Enums$HashType) a.a(Enums$HashType.class, r100);
    }

    public Enums$HashType(String r100, int r101) {
        super(r100, r101);
    }
}
