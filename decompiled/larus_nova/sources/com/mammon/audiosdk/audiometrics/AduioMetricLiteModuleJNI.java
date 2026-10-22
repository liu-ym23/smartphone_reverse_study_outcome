package com.mammon.audiosdk.audiometrics;

/* JADX INFO: loaded from: classes32.dex */
public class AduioMetricLiteModuleJNI {
    public AduioMetricLiteModuleJNI() {
    }

    public static final native String AudioMetricsLite_get_result__SWIG_0(long r100, AudioMetricsLite r101, int r102);

    public static final native String AudioMetricsLite_get_result__SWIG_1(long r100, AudioMetricsLite r101);

    public static final native int AudioMetricsLite_init(long r100, AudioMetricsLite r101);

    public static final native int AudioMetricsLite_prepare(long r100, AudioMetricsLite r101, String r102);

    public static final native int AudioMetricsLite_process__SWIG_1(long r100, AudioMetricsLite r101, float[] r102, int r103, int r104);

    public static final native int AudioMetricsLite_process_tail(long r100, AudioMetricsLite r101);

    public static final native void AudioMetricsLite_release(long r100, AudioMetricsLite r101);

    public static final native int AudioMetricsLite_reset(long r100, AudioMetricsLite r101);

    public static final native String AudioMetricsLite_version(long r100, AudioMetricsLite r101);

    public static final native int ERROR_AUDIO_METRICS_LITE_PARAM_ERROR_get();

    public static final native int ERROR_AUDIO_METRICS_LITE_STATUS_ERROR_get();

    public static final native int OK_AUDIO_METRICS_LITE_get();

    public static final native void delete_AudioMetricsLite(long r100);

    public static final native long new_AudioMetricsLite();
}
