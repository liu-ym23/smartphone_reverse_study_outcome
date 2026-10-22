package com.google.zxing.datamatrix.encoder;

import r27.a;

/* JADX INFO: loaded from: classes23.dex */
public final enum SymbolShapeHint extends Enum<SymbolShapeHint> {
    public static final SymbolShapeHint FORCE_NONE = null;
    public static final SymbolShapeHint FORCE_RECTANGLE = null;
    public static final SymbolShapeHint FORCE_SQUARE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SymbolShapeHint[] f275947a = null;

    static {
        SymbolShapeHint r100 = new SymbolShapeHint("FORCE_NONE", 0);
        FORCE_NONE = r100;
        SymbolShapeHint r101 = new SymbolShapeHint("FORCE_SQUARE", 1);
        FORCE_SQUARE = r101;
        SymbolShapeHint r102 = new SymbolShapeHint("FORCE_RECTANGLE", 2);
        FORCE_RECTANGLE = r102;
        f275947a = new SymbolShapeHint[]{r100, r101, r102};
    }

    public static SymbolShapeHint[] values() {
        return (SymbolShapeHint[]) f275947a.clone();
    }

    public static SymbolShapeHint valueOf(String r100) {
        return (SymbolShapeHint) a.a(SymbolShapeHint.class, r100);
    }

    public SymbolShapeHint(String r100, int r101) {
        super(r100, r101);
    }
}
