package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.base.annotations.JNINamespace;

/* JADX INFO: loaded from: classes41.dex */
@JNINamespace("base::android")
public class EventLog {
    public EventLog() {
    }

    public static void writeEvent(int r100, int r101) {
        android.util.EventLog.writeEvent(r100, r101);
    }
}
