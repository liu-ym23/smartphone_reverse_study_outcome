package com.lynx.tasm.rendernode.compat;

import android.graphics.Canvas;
import android.graphics.RecordingCanvas;
import android.graphics.RenderNode;

/* JADX INFO: loaded from: classes32.dex */
public class RenderNodeImpl extends RenderNodeCompat {
    private RenderNode renderNode;

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public boolean hasDisplayList() {
        return this.renderNode.hasDisplayList();
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void init() {
        this.renderNode = new RenderNode("");
    }

    public RenderNodeImpl() {
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public Object getRenderNode() {
        return this.renderNode;
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void drawRenderNode(Canvas r100) {
        ((RecordingCanvas) r100).drawRenderNode(this.renderNode);
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void endRecording(Canvas r100) {
        this.renderNode.endRecording();
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public RecordingCanvas beginRecording(int r100, int r101) {
        return this.renderNode.beginRecording();
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void drawRenderNode(Canvas r100, Object r101) {
        r100.drawRenderNode((RenderNode) r101);
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public /* bridge */ /* synthetic */ Canvas beginRecording(int r100, int r101) {
        return beginRecording(r100, r101);
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void setPosition(int r100, int r101, int r102, int r103) {
        this.renderNode.setPosition(r100, r101, r102, r103);
    }
}
