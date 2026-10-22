package com.lynx.tasm.rendernode.compat;

import android.graphics.Canvas;

/* JADX INFO: loaded from: classes32.dex */
public class RenderNodeV18Impl extends RenderNodeV16Impl {
    @Override // com.lynx.tasm.rendernode.compat.RenderNodeV14Impl, com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public /* bridge */ /* synthetic */ Object getRenderNode() {
        return super.getRenderNode();
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeV16Impl, com.lynx.tasm.rendernode.compat.RenderNodeV14Impl, com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public /* bridge */ /* synthetic */ boolean hasDisplayList() {
        return super.hasDisplayList();
    }

    public RenderNodeV18Impl() {
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeV16Impl, com.lynx.tasm.rendernode.compat.RenderNodeV14Impl, com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public /* bridge */ /* synthetic */ void init() {
        super.init();
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeV16Impl, com.lynx.tasm.rendernode.compat.RenderNodeV14Impl, com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public /* bridge */ /* synthetic */ void drawRenderNode(Canvas r100) {
        super.drawRenderNode(r100);
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeV16Impl, com.lynx.tasm.rendernode.compat.RenderNodeV14Impl, com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void endRecording(Canvas r100) {
        this.displayList.end();
        this.displayList.setCaching(true);
        this.displayList.setLeftTopRightBottom(this.left, this.top, this.right, this.bottom);
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeV16Impl, com.lynx.tasm.rendernode.compat.RenderNodeV14Impl, com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public Canvas beginRecording(int r100, int r101) {
        return this.displayList.start(r100, r101);
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeV16Impl, com.lynx.tasm.rendernode.compat.RenderNodeV14Impl, com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public /* bridge */ /* synthetic */ void drawRenderNode(Canvas r100, Object r101) {
        super.drawRenderNode(r100, r101);
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeV14Impl, com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public /* bridge */ /* synthetic */ void setPosition(int r100, int r101, int r102, int r103) {
        super.setPosition(r100, r101, r102, r103);
    }
}
