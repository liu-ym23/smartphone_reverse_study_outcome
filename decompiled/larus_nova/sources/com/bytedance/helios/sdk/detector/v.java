package com.bytedance.helios.sdk.detector;

/* JADX INFO: loaded from: classes3.dex */
public final class v implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f245554a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f245555b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final v f245556c = null;

    public v() {
    }

    @Override // com.bytedance.helios.sdk.detector.a
    public final String b() {
        return "Sensor";
    }

    @Override // com.bytedance.helios.sdk.detector.a
    public final String getResourceId() {
        return "ss";
    }

    static {
        f245556c = new v();
        f245554a = new int[]{100700, 100701, 100702, 100703, 100704, 100705};
        f245555b = new int[]{0, 1};
    }

    @Override // com.bytedance.helios.sdk.detector.a
    public final int[] a() {
        return f245554a;
    }

    @Override // com.bytedance.helios.sdk.detector.k
    public final int[] getTypes() {
        return f245555b;
    }
}
