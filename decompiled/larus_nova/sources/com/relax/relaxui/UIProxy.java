package com.relax.relaxui;

import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.relax.relaxui.events.EventProxy;
import com.relax.util.LynxUIParamAdapter;
import java.util.HashMap;

/* JADX INFO: loaded from: classes34.dex */
public class UIProxy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, Boolean> f405604a = null;

    private native long nativeCreateUIProxy(Object r100);

    private native void nativeInvokeUIMethodCallback(long r100, long r101, int r102, Object r103);

    private void onNativeProxyDestroyed() {
    }

    public float[] GetTransformValue(int r100, float[] r101) {
        return new float[32];
    }

    public int getNodeIdByPosition(int r100, int r101) {
        return 0;
    }

    public void setEventProxy(EventProxy r100) {
    }

    static {
        f405604a = new HashMap();
    }

    public void layoutDidFinish() {
        onNodeReady();
        throw null;
    }

    public void destroyAllNode() {
        throw null;
    }

    public void onNodeReady() {
        throw null;
    }

    public int indexOf(int r100) {
        throw null;
    }

    public void updateKeyFrames(ReadableMap r100) {
        throw null;
    }

    public void destroyNode(int r100, int r101) {
        throw null;
    }

    public void insertListItemNode(int r100, int r101) {
        throw null;
    }

    public void removeChild(int r100, int r101) {
        throw null;
    }

    public void removeListItemNode(int r100, int r101) {
        throw null;
    }

    public void setEvents(int r100, String r101) {
        throw null;
    }

    public void setGestures(int r100, ReadableArray r101) {
        throw null;
    }

    public void addChild(int r100, int r101, int r102) {
        throw null;
    }

    public void consumeGesture(int r100, int r101, ReadableMap r102) {
        throw null;
    }

    public void setGestureState(int r100, int r101, int r102) {
        throw null;
    }

    public void updateStyleAndAttr(int r100, ReadableMap r101, boolean r102) {
        throw null;
    }

    public boolean createUINode(int r100, String r101, ReadableMap r102, boolean r103) {
        Boolean r104 = f405604a.get(r101);
        r104.getClass();
        if (r104.booleanValue() == false) goto L5;
        throw null;
    L5:
        int r105 = LynxUIParamAdapter.f405705a;
        r101.getClass();
        throw null;
    }

    public void invokeUIMethod(int r100, String r101, ReadableMap r102, long r103) {
        throw null;
    }

    public RelaxScreenshotData takeScreenShot(int r100, int r101, int r102, int r103) {
        throw null;
    }

    public void updateContentSizeAndOffset(int r100, float r101, float r102, float r103) {
        throw null;
    }

    public void updateScrollInfo(int r100, boolean r101, float r102, boolean r103) {
        throw null;
    }

    public void updateLayoutResult(int r100, float r101, float r102, float r103, float r104, int r105, int r106, int r107, int r110, int r111, int r112, int r113, int r114, int r115, int r116, int r117, int r118, float[] r119, float[] r210, float r211) {
        throw null;
    }
}
