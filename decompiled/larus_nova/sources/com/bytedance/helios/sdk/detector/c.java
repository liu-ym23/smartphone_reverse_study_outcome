package com.bytedance.helios.sdk.detector;

import com.bytedance.android.live.uikit.util.RTLUtil;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f245517a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f245518b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f245519c = null;

    public c() {
    }

    @Override // com.bytedance.helios.sdk.detector.a
    public final String b() {
        return "AudioRecord";
    }

    @Override // com.bytedance.helios.sdk.detector.a
    public final String getResourceId() {
        return RTLUtil.ARABIA_LANG;
    }

    static {
        f245519c = new c();
        f245517a = new int[]{100400, 100404, 100402, 100405, 100401, 100403, 102200, 102201, 102202, 100500, 100501, 100502, 100503};
        f245518b = new int[]{0, 1, 0, 1, 3, 3, 3, 3, 3, 0, 1, 0, 1};
    }

    @Override // com.bytedance.helios.sdk.detector.a
    public final int[] a() {
        return f245517a;
    }

    @Override // com.bytedance.helios.sdk.detector.k
    public final int[] getTypes() {
        return f245518b;
    }
}
