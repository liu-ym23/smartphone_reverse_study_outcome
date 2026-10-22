package com.skydoves.balloon;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/skydoves/balloon/ArrowOrientationRules;", "", "ALIGN_ANCHOR", "ALIGN_FIXED", "balloon_release"}, k = 1, mv = {1, 7, 1})
public final enum ArrowOrientationRules extends Enum<ArrowOrientationRules> {
    public static final ArrowOrientationRules ALIGN_ANCHOR = null;
    public static final ArrowOrientationRules ALIGN_FIXED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ArrowOrientationRules[] f406016a = null;

    public static ArrowOrientationRules valueOf(String r100) {
        return (ArrowOrientationRules) r27.a.a(ArrowOrientationRules.class, r100);
    }

    public static ArrowOrientationRules[] values() {
        return (ArrowOrientationRules[]) f406016a.clone();
    }

    static {
        ArrowOrientationRules r100 = new ArrowOrientationRules("ALIGN_ANCHOR", 0);
        ALIGN_ANCHOR = r100;
        ArrowOrientationRules r101 = new ArrowOrientationRules("ALIGN_FIXED", 1);
        ALIGN_FIXED = r101;
        f406016a = new ArrowOrientationRules[]{r100, r101};
    }

    public ArrowOrientationRules(String r100, int r101) {
        super(r100, r101);
    }
}
