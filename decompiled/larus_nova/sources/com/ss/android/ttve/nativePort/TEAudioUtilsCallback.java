package com.ss.android.ttve.nativePort;

import com.ss.android.vesdk.VEMixAudioListener;

/* JADX INFO: loaded from: classes38.dex */
public class TEAudioUtilsCallback {
    private VEMixAudioListener listener;

    public TEAudioUtilsCallback() {
    }

    public void onProgressChanged(double r100) {
        VEMixAudioListener r101 = this.listener;
        if (r101 == null) goto L6;
        r101.onProgressChanged(r100);
        return;
    }

    public void setListener(Object r100) {
        this.listener = (VEMixAudioListener) r100;
    }
}
