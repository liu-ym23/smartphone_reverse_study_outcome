package com.bytedance.ies.sdk.widgets.info;

import android.graphics.Rect;

/* JADX INFO: loaded from: classes19.dex */
public class WidgetInfo {
    private int contentViewHeight;
    private int contentViewWidth;
    private Rect globalVisibleRect;
    private int[] locationOnScreen;
    private int[] locationOnWindow;

    public int getContentViewHeight() {
        return this.contentViewHeight;
    }

    public int getContentViewWidth() {
        return this.contentViewWidth;
    }

    public Rect getGlobalVisibleRect() {
        return this.globalVisibleRect;
    }

    public int[] getLocationOnScreen() {
        return this.locationOnScreen;
    }

    public int[] getLocationOnWindow() {
        return this.locationOnWindow;
    }

    public WidgetInfo(int r100, int r101, Rect r102, int[] r103, int[] r104) {
        this.contentViewWidth = r100;
        this.contentViewHeight = r101;
        this.globalVisibleRect = r102;
        this.locationOnScreen = r103;
        this.locationOnWindow = r104;
    }
}
