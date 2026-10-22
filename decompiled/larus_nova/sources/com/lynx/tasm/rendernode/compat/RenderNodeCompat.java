package com.lynx.tasm.rendernode.compat;

import android.graphics.Canvas;

/* JADX INFO: loaded from: classes32.dex */
public abstract class RenderNodeCompat {
    private static boolean sEnable;

    public RenderNodeCompat() {
    }

    public abstract Canvas beginRecording(int r100, int r101);

    public abstract void drawRenderNode(Canvas r100);

    public abstract void drawRenderNode(Canvas r100, Object r101);

    public abstract void endRecording(Canvas r100);

    public abstract Object getRenderNode();

    public abstract boolean hasDisplayList();

    public abstract void init();

    public abstract void setPosition(int r100, int r101, int r102, int r103);

    public static boolean supportRenderNode() {
        return sEnable;
    }

    public static void enable(boolean r100) {
        sEnable = r100;
    }
}
