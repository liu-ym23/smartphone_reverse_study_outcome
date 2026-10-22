package com.lynx.tasm.rendernode.compat;

import android.graphics.Canvas;
import android.view.HardwareCanvas;
import android.view.RenderNode;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes32.dex */
class RenderNodeV21Impl extends RenderNodeCompat {
    private static Method sStartMethod;
    private RenderNode renderNode;

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public boolean hasDisplayList() {
        return this.renderNode.isValid();
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void init() {
        this.renderNode = RenderNode.create("", null);
    }

    public RenderNodeV21Impl() {
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public Object getRenderNode() {
        return this.renderNode;
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void drawRenderNode(Canvas r100) {
        ((HardwareCanvas) r100).drawRenderNode(this.renderNode);
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void endRecording(Canvas r100) {
        this.renderNode.end((HardwareCanvas) r100);
    }

    /* JADX INFO: renamed from: beginRecording, reason: collision with other method in class */
    public HardwareCanvas m8575beginRecording(int r100, int r101) {
    L7:
        e = move-exception;
        throw new RuntimeException(e);
    L3:
        if (sStartMethod != null) goto L5;
        Class r102 = Integer.TYPE;     // Catch: Exception -> L7
        Method r103 = RenderNode.class.getDeclaredMethod("start", new Class[]{r102, r102});     // Catch: Exception -> L7
        sStartMethod = r103;     // Catch: Exception -> L7
        r103.setAccessible(true);     // Catch: Exception -> L7
    L5:
        return (HardwareCanvas) sStartMethod.invoke(this.renderNode, new Object[]{Integer.valueOf(r100), Integer.valueOf(r101)});
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void drawRenderNode(Canvas r100, Object r101) {
        ((HardwareCanvas) r100).drawRenderNode((RenderNode) r101);
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public /* bridge */ /* synthetic */ Canvas beginRecording(int r100, int r101) {
        return m8575beginRecording(r100, r101);
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void setPosition(int r100, int r101, int r102, int r103) {
        this.renderNode.setLeftTopRightBottom(r100, r101, r102, r103);
    }
}
