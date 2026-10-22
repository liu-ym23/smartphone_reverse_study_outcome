package com.bytedance.xelement.markdown;

import android.graphics.RectF;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.event.EventTarget;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxFlattenUI;
import kr7.s;

/* JADX INFO: loaded from: classes22.dex */
public class MarkdownLinkExposureUI extends LynxFlattenUI {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f272661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s f272662b;

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean getEnableExposureUIMargin() {
        return getExposeReceiveTarget().getEnableExposureUIMargin();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final LynxBaseUI getExposeReceiveTarget() {
        return getParentBaseUI();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final float getExposureScreenMarginBottom() {
        return getExposeReceiveTarget().getExposureScreenMarginBottom();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final float getExposureScreenMarginLeft() {
        return getExposeReceiveTarget().getExposureScreenMarginLeft();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final float getExposureScreenMarginRight() {
        return getExposeReceiveTarget().getExposureScreenMarginRight();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final float getExposureScreenMarginTop() {
        return getExposeReceiveTarget().getExposureScreenMarginTop();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final String getExposeUniqueID() {
        return this.f272661a;
    }

    public MarkdownLinkExposureUI(LynxContext r100, s r101, String r102) {
        super(r100);
        this.f272661a = r102;
        this.f272662b = r101;
        RectF r103 = r101.f505838d;
        setWidth((int) r103.width());
        setHeight((int) r103.height());
        setTop((int) r103.top);
        setLeft((int) r103.left);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public final EventTarget hitTest(float r100, float r101, boolean r102) {
        return getExposeReceiveTarget();
    }
}
