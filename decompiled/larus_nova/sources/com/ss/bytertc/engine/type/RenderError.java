package com.ss.bytertc.engine.type;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum RenderError extends Enum<RenderError> {
    private static final /* synthetic */ RenderError[] $VALUES = null;
    public static final RenderError RENDER_ERROR_OK = null;
    public static final RenderError RENDER_ERROR_USING_INTERNAL_SURFACE = null;
    public static final RenderError RENDER_ERROR_USING_SOFTWARE_DECODER = null;
    private int value;

    static {
        RenderError r100 = new RenderError("RENDER_ERROR_OK", 0, 0);
        RENDER_ERROR_OK = r100;
        RenderError r101 = new RenderError("RENDER_ERROR_USING_INTERNAL_SURFACE", 1, -1);
        RENDER_ERROR_USING_INTERNAL_SURFACE = r101;
        RenderError r102 = new RenderError("RENDER_ERROR_USING_SOFTWARE_DECODER", 2, -2);
        RENDER_ERROR_USING_SOFTWARE_DECODER = r102;
        $VALUES = new RenderError[]{r100, r101, r102};
    }

    public static RenderError[] values() {
        return (RenderError[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static RenderError fromId(int r100) {
        RenderError[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        RenderError r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L9:
        return RENDER_ERROR_OK;
    }

    public static RenderError valueOf(String r100) {
        return (RenderError) a.a(RenderError.class, r100);
    }

    private RenderError(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
