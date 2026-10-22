package com.lynx.tasm.behavior.ui;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;

/* JADX INFO: loaded from: classes32.dex */
public interface IDrawChildHook {

    public interface IDrawChildHookBinding {
        void bindDrawChildHook(IDrawChildHook r100);
    }

    void afterDispatchDraw(Canvas r100);

    void afterDraw(Canvas r100);

    void afterDrawChild(Canvas r100, View r101, long r102);

    void beforeDispatchDraw(Canvas r100);

    void beforeDraw(Canvas r100);

    Rect beforeDrawChild(Canvas r100, View r101, long r102);

    int getChildDrawingOrder(int r100, int r101);

    boolean hasOverlappingRendering();

    void performLayoutChildrenUI();

    void performMeasureChildrenUI();
}
