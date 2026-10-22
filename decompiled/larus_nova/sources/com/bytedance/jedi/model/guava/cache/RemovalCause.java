package com.bytedance.jedi.model.guava.cache;

import r27.a;

/* JADX INFO: loaded from: classes19.dex */
public abstract enum RemovalCause extends Enum<RemovalCause> {
    public static final RemovalCause COLLECTED = null;
    public static final RemovalCause EXPIRED = null;
    public static final RemovalCause EXPLICIT = null;
    public static final RemovalCause REPLACED = null;
    public static final RemovalCause SIZE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RemovalCause[] f251180a = null;

    public RemovalCause() {
        throw null;
    }

    public abstract boolean wasEvicted();

    static {
        final String r100 = "EXPLICIT";
        final int r101 = 0;
        RemovalCause r102 = new AnonymousClass1(r100, r101);
        EXPLICIT = r102;
        final String r103 = "REPLACED";
        final int r104 = 1;
        RemovalCause r105 = new AnonymousClass2(r103, r104);
        REPLACED = r105;
        final String r106 = "COLLECTED";
        final int r107 = 2;
        RemovalCause r108 = new AnonymousClass3(r106, r107);
        COLLECTED = r108;
        final String r109 = "EXPIRED";
        final int r110 = 3;
        RemovalCause r111 = new AnonymousClass4(r109, r110);
        EXPIRED = r111;
        final String r112 = "SIZE";
        final int r113 = 4;
        RemovalCause r114 = new AnonymousClass5(r112, r113);
        SIZE = r114;
        f251180a = new RemovalCause[]{r102, r105, r108, r111, r114};
    }

    public static RemovalCause[] values() {
        return (RemovalCause[]) f251180a.clone();
    }

    public static RemovalCause valueOf(String r100) {
        return (RemovalCause) a.a(RemovalCause.class, r100);
    }

    public RemovalCause(String r100, int r101, AnonymousClass1 r102) {
        super(r100, r101);
    }
}
