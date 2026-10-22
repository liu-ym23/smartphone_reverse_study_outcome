package com.ss.android.ttve.nativePort;

import com.ss.android.vesdk.u;

/* JADX INFO: loaded from: classes38.dex */
public class TEAudioMetricsCallback {
    private u listener;

    public TEAudioMetricsCallback() {
    }

    public void setListener(Object r100) {
        this.listener = (u) r100;
    }

    public static boolean onProgressChanged(Object r100, int r101, float r102, String r103) {
        if ((r100 instanceof TEAudioMetricsCallback) == false) goto L11;
        TEAudioMetricsCallback r104 = (TEAudioMetricsCallback) r100;
        if (r104 == null) goto L11;
        u r105 = r104.listener;
        if (r105 == null) goto L11;
        if (r105.f() == false) goto L11;
        return true;
    L11:
        return false;
    }
}
