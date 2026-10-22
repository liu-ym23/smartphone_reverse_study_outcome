package com.lynx.devtool;

import com.lynx.devtoolwrapper.CDPEventListener;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes32.dex */
public class CDPEventListenerWrapper {
    private WeakReference<CDPEventListener> listenerRef;

    public CDPEventListenerWrapper(CDPEventListener r100) {
        this.listenerRef = new WeakReference(r100);
    }

    public void onEvent(String r100) {
        CDPEventListener r101 = this.listenerRef.get();
        if (r101 == null) goto L6;
        r101.onEvent(r100);
        return;
    }
}
