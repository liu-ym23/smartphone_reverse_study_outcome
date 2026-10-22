package com.skydoves.balloon;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/skydoves/balloon/ArrowPositionRules;", "", "ALIGN_BALLOON", "ALIGN_ANCHOR", "balloon_release"}, k = 1, mv = {1, 7, 1})
public final enum ArrowPositionRules extends Enum<ArrowPositionRules> {
    public static final ArrowPositionRules ALIGN_ANCHOR = null;
    public static final ArrowPositionRules ALIGN_BALLOON = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ArrowPositionRules[] f406017a = null;

    public static ArrowPositionRules valueOf(String r100) {
        return (ArrowPositionRules) r27.a.a(ArrowPositionRules.class, r100);
    }

    public static ArrowPositionRules[] values() {
        return (ArrowPositionRules[]) f406017a.clone();
    }

    static {
        ArrowPositionRules r100 = new ArrowPositionRules("ALIGN_BALLOON", 0);
        ALIGN_BALLOON = r100;
        ArrowPositionRules r101 = new ArrowPositionRules("ALIGN_ANCHOR", 1);
        ALIGN_ANCHOR = r101;
        f406017a = new ArrowPositionRules[]{r100, r101};
    }

    public ArrowPositionRules(String r100, int r101) {
        super(r100, r101);
    }
}
