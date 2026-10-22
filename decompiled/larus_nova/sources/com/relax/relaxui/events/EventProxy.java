package com.relax.relaxui.events;

import com.relax.relaxui.value.JavaOnlyMap;

/* JADX INFO: loaded from: classes34.dex */
public class EventProxy {
    private native long nativeCreate(long r100);

    private native void nativeDestroy(long r100);

    private native void nativeSendCustomEvent(long r100, String r101, int r102, JavaOnlyMap r103);

    private native void nativeSendGestureEvent(long r100, String r101, int r102, int r103, JavaOnlyMap r104);

    private native void nativeSendGlobalEvent(long r100, String r101, Object r102);

    private native void nativeSendTouchEvent(long r100, String r101, int r102, float r103, float r104, float r105, float r106, float r107, float r110, long r111);
}
