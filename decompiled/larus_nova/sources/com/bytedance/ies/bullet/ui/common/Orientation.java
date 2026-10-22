package com.bytedance.ies.bullet.ui.common;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ies/bullet/ui/common/Orientation;", "", "UNKNOWN", "PORTRAIT", "LANDSCAPE", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum Orientation extends Enum<Orientation> {
    public static final Orientation LANDSCAPE = null;
    public static final Orientation PORTRAIT = null;
    public static final Orientation UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Orientation[] f248237a = null;

    public static Orientation valueOf(String r100) {
        return (Orientation) r27.a.a(Orientation.class, r100);
    }

    public static Orientation[] values() {
        return (Orientation[]) f248237a.clone();
    }

    static {
        Orientation r100 = new Orientation("UNKNOWN", 0);
        UNKNOWN = r100;
        Orientation r101 = new Orientation("PORTRAIT", 1);
        PORTRAIT = r101;
        Orientation r102 = new Orientation("LANDSCAPE", 2);
        LANDSCAPE = r102;
        f248237a = new Orientation[]{r100, r101, r102};
    }

    public Orientation(String r100, int r101) {
        super(r100, r101);
    }
}
