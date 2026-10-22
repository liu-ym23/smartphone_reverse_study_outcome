package com.lynx.tasm.rendernode.compat;

import android.graphics.Canvas;
import android.view.DisplayListCanvas;
import android.view.RenderNode;

/* JADX INFO: loaded from: classes32.dex */
class RenderNodeV23Impl extends RenderNodeCompat {
    private RenderNode renderNode;

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public boolean hasDisplayList() {
        return this.renderNode.isValid();
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void init() {
        this.renderNode = RenderNode.create("", null);
    }

    public RenderNodeV23Impl() {
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public Object getRenderNode() {
        return this.renderNode;
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void drawRenderNode(Canvas r100) {
        ((DisplayListCanvas) r100).drawRenderNode(this.renderNode);
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void endRecording(Canvas r100) {
        this.renderNode.end((DisplayListCanvas) r100);
    }

    /* JADX INFO: renamed from: beginRecording, reason: collision with other method in class */
    public DisplayListCanvas m8576beginRecording(int r100, int r101) {
        return this.renderNode.start(r100, r101);
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void drawRenderNode(Canvas r100, Object r101) {
        ((DisplayListCanvas) r100).drawRenderNode((RenderNode) r101);
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public /* bridge */ /* synthetic */ Canvas beginRecording(int r100, int r101) {
        return m8576beginRecording(r100, r101);
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void setPosition(int r100, int r101, int r102, int r103) {
        this.renderNode.setLeftTopRightBottom(r100, r101, r102, r103);
    }
}
