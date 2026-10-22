package com.google.crypto.tink.tinkkey;

import r27.a;

/* JADX INFO: loaded from: classes23.dex */
public final enum KeyHandle$KeyStatusType extends Enum<KeyHandle$KeyStatusType> {
    public static final KeyHandle$KeyStatusType DESTROYED = null;
    public static final KeyHandle$KeyStatusType DISABLED = null;
    public static final KeyHandle$KeyStatusType ENABLED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KeyHandle$KeyStatusType[] f275912a = null;

    static {
        KeyHandle$KeyStatusType r100 = new KeyHandle$KeyStatusType("ENABLED", 0);
        ENABLED = r100;
        KeyHandle$KeyStatusType r101 = new KeyHandle$KeyStatusType("DISABLED", 1);
        DISABLED = r101;
        KeyHandle$KeyStatusType r102 = new KeyHandle$KeyStatusType("DESTROYED", 2);
        DESTROYED = r102;
        f275912a = new KeyHandle$KeyStatusType[]{r100, r101, r102};
    }

    public static KeyHandle$KeyStatusType[] values() {
        return (KeyHandle$KeyStatusType[]) f275912a.clone();
    }

    public static KeyHandle$KeyStatusType valueOf(String r100) {
        return (KeyHandle$KeyStatusType) a.a(KeyHandle$KeyStatusType.class, r100);
    }

    public KeyHandle$KeyStatusType(String r100, int r101) {
        super(r100, r101);
    }
}
