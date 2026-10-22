package com.lynx.devtoolwrapper;

import android.graphics.Bitmap;
import com.lynx.react.bridge.ReadableMap;

/* JADX INFO: loaded from: classes32.dex */
public interface IDevToolDelegate {
    String getActualScreenshotMode();

    Bitmap getBitmapOfView();

    int getNodeForLocation(float r100, float r101, String r102);

    float[] getTransformValue(int r100, float[] r101);

    void onDispatchMessageEvent(ReadableMap r100);

    void scrollIntoViewFromUI(int r100);

    void takeScreenshot(ScreenshotBitmapHandler r100, String r101);
}
