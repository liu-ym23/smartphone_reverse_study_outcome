package com.bytedance.navigation.kmp.capability.sensor;

/* JADX INFO: loaded from: classes21.dex */
public final /* synthetic */ class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f265826a = null;

    static {
        int[] r100 = new int[FallbackDeviceHeadingSensor.State.values().length];
        r100[FallbackDeviceHeadingSensor.State.IDLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
    L13:
        r100[FallbackDeviceHeadingSensor.State.BOOTSTRAP_ROTV.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
    L19:
        r100[FallbackDeviceHeadingSensor.State.USING_ESKF.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
    L15:
        r100[FallbackDeviceHeadingSensor.State.DEGRADED_ROTV.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
    L7:
        f265826a = r100;
    }
}
