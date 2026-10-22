package com.ss.android.lark.maincore;

import r27.a;

/* JADX INFO: loaded from: classes36.dex */
public final enum ITitleController$Style extends Enum<ITitleController$Style> {
    public static final ITitleController$Style New = null;
    public static final ITitleController$Style Old = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ITitleController$Style[] f431574a = null;
    private int value;

    static {
        ITitleController$Style r100 = new ITitleController$Style("Old", 0, 0);
        Old = r100;
        ITitleController$Style r101 = new ITitleController$Style("New", 1, 1);
        New = r101;
        f431574a = new ITitleController$Style[]{r100, r101};
    }

    public static ITitleController$Style[] values() {
        return (ITitleController$Style[]) f431574a.clone();
    }

    public int getNumber() {
        return this.value;
    }

    public static ITitleController$Style forNumber(int r100) {
        if (r100 == 0) goto L10;
        if (r100 == 1) goto L8;
        return null;
    L8:
        return New;
    L10:
        return Old;
    }

    public static ITitleController$Style valueOf(String r100) {
        return (ITitleController$Style) a.a(ITitleController$Style.class, r100);
    }

    public static ITitleController$Style valueOf(int r100) {
        return forNumber(r100);
    }

    public ITitleController$Style(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
