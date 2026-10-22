package com.bytedance.live.layout;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/live/layout/LayoutScale;", "", "FILL", "ASPECT_FIT", "ASPECT_FILL", "FIT_WIDTH", "FIT_HEIGHT", "dynamiclayout_release"}, k = 1, mv = {1, 4, 3})
public final enum LayoutScale extends Enum<LayoutScale> {
    public static final LayoutScale ASPECT_FILL = null;
    public static final LayoutScale ASPECT_FIT = null;
    public static final LayoutScale FILL = null;
    public static final LayoutScale FIT_HEIGHT = null;
    public static final LayoutScale FIT_WIDTH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LayoutScale[] f255194a = null;

    public static LayoutScale valueOf(String r100) {
        return (LayoutScale) r27.a.a(LayoutScale.class, r100);
    }

    public static LayoutScale[] values() {
        return (LayoutScale[]) f255194a.clone();
    }

    static {
        LayoutScale r100 = new LayoutScale("FILL", 0);
        FILL = r100;
        LayoutScale r101 = new LayoutScale("ASPECT_FIT", 1);
        ASPECT_FIT = r101;
        LayoutScale r102 = new LayoutScale("ASPECT_FILL", 2);
        ASPECT_FILL = r102;
        LayoutScale r103 = new LayoutScale("FIT_WIDTH", 3);
        FIT_WIDTH = r103;
        LayoutScale r104 = new LayoutScale("FIT_HEIGHT", 4);
        FIT_HEIGHT = r104;
        f255194a = new LayoutScale[]{r100, r101, r102, r103, r104};
    }

    public LayoutScale(String r100, int r101) {
        super(r100, r101);
    }
}
