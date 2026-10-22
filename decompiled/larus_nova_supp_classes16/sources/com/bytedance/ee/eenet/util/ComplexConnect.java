package com.bytedance.ee.eenet.util;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final enum ComplexConnect extends Enum<ComplexConnect> {
    public static final ComplexConnect FALSE = null;
    public static final ComplexConnect TRUE = null;
    public static final /* synthetic */ ComplexConnect[] a = null;
    private String value;

    static {
        ComplexConnect r0 = new ComplexConnect("TRUE", 0, "true");
        TRUE = r0;
        ComplexConnect r1 = new ComplexConnect("FALSE", 1, "false");
        FALSE = r1;
        a = new ComplexConnect[]{r0, r1};
    }

    public static ComplexConnect[] values() {
        return (ComplexConnect[]) a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static ComplexConnect valueOf(String r1) {
        return (ComplexConnect) a.a(ComplexConnect.class, r1);
    }

    public ComplexConnect(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
