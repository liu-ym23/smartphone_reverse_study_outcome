package com.bytedance.android.livesdk.live.extension.plugin.api.bytebench;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0015\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/bytebench/LiveWrappedBTCFeature;", "", "", "value", "I", "getValue", "()I", "DEVICE_OVERALL_SCORE", "DEVICE_CPU_SCORE", "DEVICE_GPU_SCORE", "DEVICE_MEMORY_SCORE", "DEVICE_VIDEO_SCORE", "DEVICE_IO_SCORE", "DEVICE_VIDEO_PLAY_SCENE_SCORE", "DEVICE_APP_LAUNCH_SCENE_SCORE", "DEVICE_VIDEO_RECORD_SCENE_SCORE", "DEVICE_RUNTIME_VIRTUAL_MEMORY", "DEVICE_RUNTIME_TEMPERATURE", "DEVICE_RUNTIME_BATTERY_LEVEL", "DEVICE_RUNTIME_CPU_SPEED", "DEVICE_RUNTIME_CPU_PROCESS_USAGE", "DEVICE_RUNTIME_REMAIN_MEMORY", "DEVICE_RUNTIME_BATTERYEL_ECTRICCURRENT", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedBTCFeature extends Enum<LiveWrappedBTCFeature> {
    public static final LiveWrappedBTCFeature DEVICE_APP_LAUNCH_SCENE_SCORE = null;
    public static final LiveWrappedBTCFeature DEVICE_CPU_SCORE = null;
    public static final LiveWrappedBTCFeature DEVICE_GPU_SCORE = null;
    public static final LiveWrappedBTCFeature DEVICE_IO_SCORE = null;
    public static final LiveWrappedBTCFeature DEVICE_MEMORY_SCORE = null;
    public static final LiveWrappedBTCFeature DEVICE_OVERALL_SCORE = null;
    public static final LiveWrappedBTCFeature DEVICE_RUNTIME_BATTERYEL_ECTRICCURRENT = null;
    public static final LiveWrappedBTCFeature DEVICE_RUNTIME_BATTERY_LEVEL = null;
    public static final LiveWrappedBTCFeature DEVICE_RUNTIME_CPU_PROCESS_USAGE = null;
    public static final LiveWrappedBTCFeature DEVICE_RUNTIME_CPU_SPEED = null;
    public static final LiveWrappedBTCFeature DEVICE_RUNTIME_REMAIN_MEMORY = null;
    public static final LiveWrappedBTCFeature DEVICE_RUNTIME_TEMPERATURE = null;
    public static final LiveWrappedBTCFeature DEVICE_RUNTIME_VIRTUAL_MEMORY = null;
    public static final LiveWrappedBTCFeature DEVICE_VIDEO_PLAY_SCENE_SCORE = null;
    public static final LiveWrappedBTCFeature DEVICE_VIDEO_RECORD_SCENE_SCORE = null;
    public static final LiveWrappedBTCFeature DEVICE_VIDEO_SCORE = null;
    public static final /* synthetic */ LiveWrappedBTCFeature[] a = null;
    private final int value;

    public static LiveWrappedBTCFeature valueOf(String r1) {
        return (LiveWrappedBTCFeature) a.a(LiveWrappedBTCFeature.class, r1);
    }

    public static LiveWrappedBTCFeature[] values() {
        return (LiveWrappedBTCFeature[]) a.clone();
    }

    static {
        LiveWrappedBTCFeature r1 = new LiveWrappedBTCFeature("DEVICE_OVERALL_SCORE", 0, 0);
        DEVICE_OVERALL_SCORE = r1;
        LiveWrappedBTCFeature r2 = new LiveWrappedBTCFeature("DEVICE_CPU_SCORE", 1, 1);
        DEVICE_CPU_SCORE = r2;
        LiveWrappedBTCFeature r3 = new LiveWrappedBTCFeature("DEVICE_GPU_SCORE", 2, 2);
        DEVICE_GPU_SCORE = r3;
        LiveWrappedBTCFeature r4 = new LiveWrappedBTCFeature("DEVICE_MEMORY_SCORE", 3, 3);
        DEVICE_MEMORY_SCORE = r4;
        LiveWrappedBTCFeature r5 = new LiveWrappedBTCFeature("DEVICE_VIDEO_SCORE", 4, 4);
        DEVICE_VIDEO_SCORE = r5;
        LiveWrappedBTCFeature r6 = new LiveWrappedBTCFeature("DEVICE_IO_SCORE", 5, 5);
        DEVICE_IO_SCORE = r6;
        LiveWrappedBTCFeature r7 = new LiveWrappedBTCFeature("DEVICE_VIDEO_PLAY_SCENE_SCORE", 6, 6);
        DEVICE_VIDEO_PLAY_SCENE_SCORE = r7;
        LiveWrappedBTCFeature r8 = new LiveWrappedBTCFeature("DEVICE_APP_LAUNCH_SCENE_SCORE", 7, 7);
        DEVICE_APP_LAUNCH_SCENE_SCORE = r8;
        LiveWrappedBTCFeature r9 = new LiveWrappedBTCFeature("DEVICE_VIDEO_RECORD_SCENE_SCORE", 8, 8);
        DEVICE_VIDEO_RECORD_SCENE_SCORE = r9;
        LiveWrappedBTCFeature r10 = new LiveWrappedBTCFeature("DEVICE_RUNTIME_VIRTUAL_MEMORY", 9, 9);
        DEVICE_RUNTIME_VIRTUAL_MEMORY = r10;
        LiveWrappedBTCFeature r11 = new LiveWrappedBTCFeature("DEVICE_RUNTIME_TEMPERATURE", 10, 10);
        DEVICE_RUNTIME_TEMPERATURE = r11;
        LiveWrappedBTCFeature r12 = new LiveWrappedBTCFeature("DEVICE_RUNTIME_BATTERY_LEVEL", 11, 11);
        DEVICE_RUNTIME_BATTERY_LEVEL = r12;
        LiveWrappedBTCFeature r13 = new LiveWrappedBTCFeature("DEVICE_RUNTIME_CPU_SPEED", 12, 12);
        DEVICE_RUNTIME_CPU_SPEED = r13;
        LiveWrappedBTCFeature r14 = new LiveWrappedBTCFeature("DEVICE_RUNTIME_CPU_PROCESS_USAGE", 13, 13);
        DEVICE_RUNTIME_CPU_PROCESS_USAGE = r14;
        LiveWrappedBTCFeature r15 = new LiveWrappedBTCFeature("DEVICE_RUNTIME_REMAIN_MEMORY", 14, 14);
        DEVICE_RUNTIME_REMAIN_MEMORY = r15;
        LiveWrappedBTCFeature r16 = new LiveWrappedBTCFeature("DEVICE_RUNTIME_BATTERYEL_ECTRICCURRENT", 15, 15);
        DEVICE_RUNTIME_BATTERYEL_ECTRICCURRENT = r16;
        a = new LiveWrappedBTCFeature[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16};
    }

    public final int getValue() {
        return this.value;
    }

    public LiveWrappedBTCFeature(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
