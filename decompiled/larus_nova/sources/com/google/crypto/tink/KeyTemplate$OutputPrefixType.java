package com.google.crypto.tink;

import r27.a;

/* JADX INFO: loaded from: classes23.dex */
public final enum KeyTemplate$OutputPrefixType extends Enum<KeyTemplate$OutputPrefixType> {
    public static final KeyTemplate$OutputPrefixType CRUNCHY = null;
    public static final KeyTemplate$OutputPrefixType LEGACY = null;
    public static final KeyTemplate$OutputPrefixType RAW = null;
    public static final KeyTemplate$OutputPrefixType TINK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KeyTemplate$OutputPrefixType[] f275742a = null;

    static {
        KeyTemplate$OutputPrefixType r100 = new KeyTemplate$OutputPrefixType("TINK", 0);
        TINK = r100;
        KeyTemplate$OutputPrefixType r101 = new KeyTemplate$OutputPrefixType("LEGACY", 1);
        LEGACY = r101;
        KeyTemplate$OutputPrefixType r102 = new KeyTemplate$OutputPrefixType("RAW", 2);
        RAW = r102;
        KeyTemplate$OutputPrefixType r103 = new KeyTemplate$OutputPrefixType("CRUNCHY", 3);
        CRUNCHY = r103;
        f275742a = new KeyTemplate$OutputPrefixType[]{r100, r101, r102, r103};
    }

    public static KeyTemplate$OutputPrefixType[] values() {
        return (KeyTemplate$OutputPrefixType[]) f275742a.clone();
    }

    public static KeyTemplate$OutputPrefixType valueOf(String r100) {
        return (KeyTemplate$OutputPrefixType) a.a(KeyTemplate$OutputPrefixType.class, r100);
    }

    public KeyTemplate$OutputPrefixType(String r100, int r101) {
        super(r100, r101);
    }
}
