package com.bytedance.ee.eenet.util;

import r27.a;

/* JADX INFO: loaded from: classes16.dex */
public final enum ComplexConnect extends Enum<ComplexConnect> {
    public static final ComplexConnect FALSE = null;
    public static final ComplexConnect TRUE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ComplexConnect[] f242762a = null;
    private String value;

    static {
        ComplexConnect r100 = new ComplexConnect("TRUE", 0, "true");
        TRUE = r100;
        ComplexConnect r101 = new ComplexConnect("FALSE", 1, "false");
        FALSE = r101;
        f242762a = new ComplexConnect[]{r100, r101};
    }

    public static ComplexConnect[] values() {
        return (ComplexConnect[]) f242762a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static ComplexConnect valueOf(String r100) {
        return (ComplexConnect) a.a(ComplexConnect.class, r100);
    }

    public ComplexConnect(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
