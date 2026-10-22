package com.bytedance.helios.sdk.detector;

/* JADX INFO: loaded from: classes19.dex */
public final class h implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f245526a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f245527b = null;

    @Override // com.bytedance.helios.sdk.detector.a
    public final String b() {
        return "CameraFlash";
    }

    @Override // com.bytedance.helios.sdk.detector.a
    public final String getResourceId() {
        return "cf";
    }

    static {
        f245526a = new int[]{100300, 100301, 100302, 100303};
        f245527b = new int[]{3, 3, 3, 3};
        new String[]{"CameraFlashOff_Detected", "CameraFlashOn_Detected", "CameraFlashOff_Detected", "CameraFlashOn_Detected", "CameraFlashOff_Detected", "CameraFlashOn_Detected"};
    }

    @Override // com.bytedance.helios.sdk.detector.a
    public final int[] a() {
        return f245526a;
    }

    @Override // com.bytedance.helios.sdk.detector.k
    public final int[] getTypes() {
        return f245527b;
    }
}
