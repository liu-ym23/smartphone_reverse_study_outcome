package com.ss.android.ttve.nativePort;

import com.ss.android.vesdk.VEListener;

/* JADX INFO: loaded from: classes38.dex */
public class TEReverseCallback {
    private VEListener.VEEditorGenReverseListener listener;

    public TEReverseCallback() {
        this.listener = null;
    }

    public void onProgressChanged(double r100) {
        VEListener.VEEditorGenReverseListener r101 = this.listener;
        if (r101 == null) goto L6;
        r101.onReverseProgress(r100);
        return;
    }

    public void setListener(Object r100) {
        this.listener = (VEListener.VEEditorGenReverseListener) r100;
    }
}
