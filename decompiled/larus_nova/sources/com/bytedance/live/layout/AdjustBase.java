package com.bytedance.live.layout;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/live/layout/AdjustBase;", "", "CONTENT", "CANVAS", "dynamiclayout_release"}, k = 1, mv = {1, 4, 3})
public final enum AdjustBase extends Enum<AdjustBase> {
    public static final AdjustBase CANVAS = null;
    public static final AdjustBase CONTENT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AdjustBase[] f255172a = null;

    public static AdjustBase valueOf(String r100) {
        return (AdjustBase) r27.a.a(AdjustBase.class, r100);
    }

    public static AdjustBase[] values() {
        return (AdjustBase[]) f255172a.clone();
    }

    static {
        AdjustBase r100 = new AdjustBase("CONTENT", 0);
        CONTENT = r100;
        AdjustBase r101 = new AdjustBase("CANVAS", 1);
        CANVAS = r101;
        f255172a = new AdjustBase[]{r100, r101};
    }

    public AdjustBase(String r100, int r101) {
        super(r100, r101);
    }
}
