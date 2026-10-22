package com.bytedance.helios.sdk.detector;

import com.bytedance.android.livesdkapi.model.LinkMediaModel;
import com.ss.ttvideoengine.superresolution.SRStrategy;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f245522a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f245523b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final f f245524c = null;

    public f() {
    }

    @Override // com.bytedance.helios.sdk.detector.a
    public final String b() {
        return "Camera";
    }

    @Override // com.bytedance.helios.sdk.detector.a
    public final String getResourceId() {
        return SRStrategy.KEY_CURRENT_RESOLUTION;
    }

    static {
        f245524c = new f();
        f245522a = new int[]{100100, 100106, 100102, 100103, 100104, 100105, 100101, LinkMediaModel.LIVE_LINK_OPEN_ALBUM_REQUEST_CODE, 100205, 100202, 100203, 100204, 100201, 100206};
        f245523b = new int[]{0, 1, 0, 1, 0, 1, 3, 0, 1, 0, 0, 1, 3, 2};
    }

    @Override // com.bytedance.helios.sdk.detector.a
    public final int[] a() {
        return f245522a;
    }

    @Override // com.bytedance.helios.sdk.detector.k
    public final int[] getTypes() {
        return f245523b;
    }
}
