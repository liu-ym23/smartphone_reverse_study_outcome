package com.lynx.tasm.behavior.ui.canvas;

import android.content.Context;
import android.view.View;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.LynxUI;

/* JADX INFO: loaded from: classes32.dex */
public class LynxHeliumCanvas extends LynxUI<LynxHeliumCanvasView> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f382485a;

    public LynxHeliumCanvas(Context r100) {
        super(r100);
        this.mContext.getRuntimeId();
        this.f382485a = false;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r100) {
        LynxHeliumCanvasView r101 = new LynxHeliumCanvasView(r100);
        r101.setCanvasUI(this);
        r101.setConsumeAllEvents(this.f382485a);
        this.mView = r101;
        r101.setOpaque(false);
        return (LynxHeliumCanvasView) this.mView;
    }

    @LynxProp(name = "consume-android-events")
    public void setConsumeAllEvents(boolean r100) {
        this.f382485a = r100;
        T r101 = this.mView;
        if (r101 == 0) goto L6;
        ((LynxHeliumCanvasView) r101).setConsumeAllEvents(r100);
        return;
    }
}
