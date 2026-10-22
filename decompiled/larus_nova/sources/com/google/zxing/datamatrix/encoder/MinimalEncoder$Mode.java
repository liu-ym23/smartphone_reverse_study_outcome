package com.google.zxing.datamatrix.encoder;

import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import r27.a;

/* JADX INFO: loaded from: classes23.dex */
final enum MinimalEncoder$Mode extends Enum<MinimalEncoder$Mode> {
    public static final MinimalEncoder$Mode ASCII = null;
    public static final MinimalEncoder$Mode B256 = null;
    public static final MinimalEncoder$Mode C40 = null;
    public static final MinimalEncoder$Mode EDF = null;
    public static final MinimalEncoder$Mode TEXT = null;
    public static final MinimalEncoder$Mode X12 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MinimalEncoder$Mode[] f275946a = null;

    static {
        MinimalEncoder$Mode r100 = new MinimalEncoder$Mode("ASCII", 0);
        ASCII = r100;
        MinimalEncoder$Mode r101 = new MinimalEncoder$Mode("C40", 1);
        C40 = r101;
        MinimalEncoder$Mode r102 = new MinimalEncoder$Mode(CardAdapter.TEXT, 2);
        TEXT = r102;
        MinimalEncoder$Mode r103 = new MinimalEncoder$Mode("X12", 3);
        X12 = r103;
        MinimalEncoder$Mode r104 = new MinimalEncoder$Mode("EDF", 4);
        EDF = r104;
        MinimalEncoder$Mode r105 = new MinimalEncoder$Mode("B256", 5);
        B256 = r105;
        f275946a = new MinimalEncoder$Mode[]{r100, r101, r102, r103, r104, r105};
    }

    public static MinimalEncoder$Mode[] values() {
        return (MinimalEncoder$Mode[]) f275946a.clone();
    }

    public static MinimalEncoder$Mode valueOf(String r100) {
        return (MinimalEncoder$Mode) a.a(MinimalEncoder$Mode.class, r100);
    }

    public MinimalEncoder$Mode(String r100, int r101) {
        super(r100, r101);
    }
}
