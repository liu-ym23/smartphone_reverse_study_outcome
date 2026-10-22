package com.google.zxing.pdf417.encoder;

import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import r27.a;

/* JADX INFO: loaded from: classes23.dex */
public final enum Compaction extends Enum<Compaction> {
    public static final Compaction AUTO = null;
    public static final Compaction BYTE = null;
    public static final Compaction NUMERIC = null;
    public static final Compaction TEXT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Compaction[] f275959a = null;

    static {
        Compaction r100 = new Compaction("AUTO", 0);
        AUTO = r100;
        Compaction r101 = new Compaction(CardAdapter.TEXT, 1);
        TEXT = r101;
        Compaction r102 = new Compaction("BYTE", 2);
        BYTE = r102;
        Compaction r103 = new Compaction("NUMERIC", 3);
        NUMERIC = r103;
        f275959a = new Compaction[]{r100, r101, r102, r103};
    }

    public static Compaction[] values() {
        return (Compaction[]) f275959a.clone();
    }

    public static Compaction valueOf(String r100) {
        return (Compaction) a.a(Compaction.class, r100);
    }

    public Compaction(String r100, int r101) {
        super(r100, r101);
    }
}
