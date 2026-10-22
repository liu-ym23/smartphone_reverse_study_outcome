package com.ss.android.lark.maincore;

import r27.a;

/* JADX INFO: loaded from: classes36.dex */
public final enum IFunctionButtonV2$TipStyle extends Enum<IFunctionButtonV2$TipStyle> {
    public static final IFunctionButtonV2$TipStyle Custom = null;
    public static final IFunctionButtonV2$TipStyle RedDot = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IFunctionButtonV2$TipStyle[] f431573a = null;
    private int value;

    static {
        IFunctionButtonV2$TipStyle r100 = new IFunctionButtonV2$TipStyle("RedDot", 0, 0);
        RedDot = r100;
        IFunctionButtonV2$TipStyle r101 = new IFunctionButtonV2$TipStyle("Custom", 1, 1);
        Custom = r101;
        f431573a = new IFunctionButtonV2$TipStyle[]{r100, r101};
    }

    public static IFunctionButtonV2$TipStyle[] values() {
        return (IFunctionButtonV2$TipStyle[]) f431573a.clone();
    }

    public int getNumber() {
        return this.value;
    }

    public static IFunctionButtonV2$TipStyle forNumber(int r100) {
        if (r100 == 0) goto L10;
        if (r100 == 1) goto L8;
        return RedDot;
    L8:
        return Custom;
    L10:
        return RedDot;
    }

    public static IFunctionButtonV2$TipStyle valueOf(String r100) {
        return (IFunctionButtonV2$TipStyle) a.a(IFunctionButtonV2$TipStyle.class, r100);
    }

    public static IFunctionButtonV2$TipStyle valueOf(int r100) {
        return forNumber(r100);
    }

    public IFunctionButtonV2$TipStyle(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
