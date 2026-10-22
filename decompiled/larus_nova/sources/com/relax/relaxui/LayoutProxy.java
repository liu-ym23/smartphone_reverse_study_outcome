package com.relax.relaxui;

import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.mapbuffer.ReadableMapBuffer;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: classes34.dex */
public class LayoutProxy {
    private native long nativeCreateLayoutProxy(Object r100);

    private native void nativeTriggerLayout(long r100);

    public void addLayoutEventProps(int r100, String r101) {
    }

    public void afterLayout(int r100) {
    }

    public void attachLayoutNodeManager(long r100) {
    }

    public int createNode(int r100, String r101, ReadableMap r102, ReadableMapBuffer r103, ReadableArray r104, boolean r105) {
        return -1;
    }

    public void destroy() {
    }

    public void destroyAllNodes() {
    }

    public void destroyNode(int r100) {
    }

    public void dispatchOnLayout(int r100, int r101, int r102, int r103, int r104) {
    }

    public void dispatchOnLayoutBefore(int r100) {
    }

    public void insertNode(int r100, int r101, int r102) {
    }

    public void removeNode(int r100, int r101) {
    }

    public void scheduleLayout() {
    }

    public void setFontFaces(ReadableMap r100) {
    }

    public void updateProps(int r100, ReadableMap r101) {
    }

    public LayoutProxy() {
        new HashSet();
        new HashMap();
        nativeCreateLayoutProxy(this);
    }

    public void align(int r100) {
        throw null;
    }

    public float[] measure(int r100, float r101, int r102, float r103, int r104, boolean r105) {
        throw null;
    }
}
