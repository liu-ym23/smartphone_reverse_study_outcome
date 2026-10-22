package com.ttnet.org.chromium.base.metrics;

import com.ttnet.org.chromium.base.annotations.JNINamespace;

/* JADX INFO: loaded from: classes41.dex */
@JNINamespace("base::android")
public final class StatisticsRecorderAndroid {

    public interface Natives {
        String toJson(int r100);
    }

    private StatisticsRecorderAndroid() {
    }

    public static String toJson(int r100) {
        return StatisticsRecorderAndroidJni.get().toJson(r100);
    }
}
