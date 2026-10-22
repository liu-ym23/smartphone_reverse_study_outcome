package com.bytedance.live.layout;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/live/layout/LayoutOrientation;", "", "VERTICAL", "HORIZONTAL", "dynamiclayout_release"}, k = 1, mv = {1, 4, 3})
public final enum LayoutOrientation extends Enum<LayoutOrientation> {
    public static final LayoutOrientation HORIZONTAL = null;
    public static final LayoutOrientation VERTICAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LayoutOrientation[] f255193a = null;

    public static LayoutOrientation valueOf(String r100) {
        return (LayoutOrientation) r27.a.a(LayoutOrientation.class, r100);
    }

    public static LayoutOrientation[] values() {
        return (LayoutOrientation[]) f255193a.clone();
    }

    static {
        LayoutOrientation r100 = new LayoutOrientation("VERTICAL", 0);
        VERTICAL = r100;
        LayoutOrientation r101 = new LayoutOrientation("HORIZONTAL", 1);
        HORIZONTAL = r101;
        f255193a = new LayoutOrientation[]{r100, r101};
    }

    public LayoutOrientation(String r100, int r101) {
        super(r100, r101);
    }
}
