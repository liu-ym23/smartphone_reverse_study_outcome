package com.lynx.tasm.behavior.shadow;

import android.view.View;
import r27.a;

/* JADX INFO: loaded from: classes32.dex */
public final enum MeasureMode extends Enum<MeasureMode> {
    public static final MeasureMode AT_MOST = null;
    public static final MeasureMode EXACTLY = null;
    public static final MeasureMode UNDEFINED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MeasureMode[] f382211a = null;
    private final int mIntValue;

    static {
        MeasureMode r100 = new MeasureMode("UNDEFINED", 0, 0);
        UNDEFINED = r100;
        MeasureMode r101 = new MeasureMode("EXACTLY", 1, 1);
        EXACTLY = r101;
        MeasureMode r102 = new MeasureMode("AT_MOST", 2, 2);
        AT_MOST = r102;
        f382211a = new MeasureMode[]{r100, r101, r102};
    }

    public static MeasureMode[] values() {
        return (MeasureMode[]) f382211a.clone();
    }

    public int intValue() {
        return this.mIntValue;
    }

    public static MeasureMode fromInt(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 != 2) goto L10;
        return AT_MOST;
    L10:
        throw new IllegalArgumentException("Unknown measureMode");
    L12:
        return EXACTLY;
    L14:
        return UNDEFINED;
    }

    public static int fromMeasureSpec(int r100) {
        int r101 = View.MeasureSpec.getMode(r100);
        if (r101 == Integer.MIN_VALUE) goto L14;
        if (r101 == 0) goto L12;
        if (r101 != 1073741824) goto L10;
        return EXACTLY.intValue();
    L10:
        throw new IllegalArgumentException("Unknown measureSpec");
    L12:
        return UNDEFINED.intValue();
    L14:
        return AT_MOST.intValue();
    }

    public static MeasureMode valueOf(String r100) {
        return (MeasureMode) a.a(MeasureMode.class, r100);
    }

    public MeasureMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.mIntValue = r102;
    }
}
