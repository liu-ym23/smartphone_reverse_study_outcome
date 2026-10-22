package com.bytedance.locallife.dito.utils;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/locallife/dito/utils/LinearOrientation;", "", "", "orientation", "Ljava/lang/String;", "getOrientation", "()Ljava/lang/String;", "ORIENTATION_LEFT", "ORIENTATION_RIGHT", "ORIENTATION_BOTTOM", "ORIENTATION_TOP", "ORIENTATION_RIGHT_BOTTOM", "ORIENTATION_RIGHT_TOP", "ORIENTATION_LEFT_BOTTOM", "ORIENTATION_LEFT_TOP", "dito-core-saas_release"}, k = 1, mv = {1, 4, 3})
public final enum LinearOrientation extends Enum<LinearOrientation> {
    public static final LinearOrientation ORIENTATION_BOTTOM = null;
    public static final LinearOrientation ORIENTATION_LEFT = null;
    public static final LinearOrientation ORIENTATION_LEFT_BOTTOM = null;
    public static final LinearOrientation ORIENTATION_LEFT_TOP = null;
    public static final LinearOrientation ORIENTATION_RIGHT = null;
    public static final LinearOrientation ORIENTATION_RIGHT_BOTTOM = null;
    public static final LinearOrientation ORIENTATION_RIGHT_TOP = null;
    public static final LinearOrientation ORIENTATION_TOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LinearOrientation[] f258681a = null;
    private final String orientation;

    public static LinearOrientation valueOf(String r100) {
        return (LinearOrientation) r27.a.a(LinearOrientation.class, r100);
    }

    public static LinearOrientation[] values() {
        return (LinearOrientation[]) f258681a.clone();
    }

    static {
        LinearOrientation r100 = new LinearOrientation("ORIENTATION_LEFT", 0, "to left");
        ORIENTATION_LEFT = r100;
        LinearOrientation r101 = new LinearOrientation("ORIENTATION_RIGHT", 1, "to right");
        ORIENTATION_RIGHT = r101;
        LinearOrientation r102 = new LinearOrientation("ORIENTATION_BOTTOM", 2, "to bottom");
        ORIENTATION_BOTTOM = r102;
        LinearOrientation r103 = new LinearOrientation("ORIENTATION_TOP", 3, "to top");
        ORIENTATION_TOP = r103;
        LinearOrientation r104 = new LinearOrientation("ORIENTATION_RIGHT_BOTTOM", 4, "to right bottom");
        ORIENTATION_RIGHT_BOTTOM = r104;
        LinearOrientation r105 = new LinearOrientation("ORIENTATION_RIGHT_TOP", 5, "to right top");
        ORIENTATION_RIGHT_TOP = r105;
        LinearOrientation r110 = new LinearOrientation("ORIENTATION_LEFT_BOTTOM", 6, "to left bottom");
        ORIENTATION_LEFT_BOTTOM = r110;
        LinearOrientation r111 = new LinearOrientation("ORIENTATION_LEFT_TOP", 7, "to left top");
        ORIENTATION_LEFT_TOP = r111;
        f258681a = new LinearOrientation[]{r100, r101, r102, r103, r104, r105, r110, r111};
    }

    public final String getOrientation() {
        return this.orientation;
    }

    public LinearOrientation(String r100, int r101, String r102) {
        super(r100, r101);
        this.orientation = r102;
    }
}
