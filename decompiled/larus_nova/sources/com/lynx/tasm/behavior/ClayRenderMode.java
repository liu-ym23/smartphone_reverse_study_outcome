package com.lynx.tasm.behavior;

import com.bytedance.sdk.bridge.annotation.BridgeSyncType;

/* JADX INFO: loaded from: classes32.dex */
public final enum ClayRenderMode extends Enum<ClayRenderMode> {
    public static final ClayRenderMode DELEGATE = null;
    public static final ClayRenderMode SURFACE = null;
    public static final ClayRenderMode SYNC = null;
    public static final ClayRenderMode TEXTURE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ClayRenderMode[] f381874a = null;

    static {
        ClayRenderMode r100 = new ClayRenderMode("SURFACE", 0);
        SURFACE = r100;
        ClayRenderMode r101 = new ClayRenderMode("TEXTURE", 1);
        TEXTURE = r101;
        ClayRenderMode r102 = new ClayRenderMode(BridgeSyncType.SYNC, 2);
        SYNC = r102;
        ClayRenderMode r103 = new ClayRenderMode("DELEGATE", 3);
        DELEGATE = r103;
        f381874a = new ClayRenderMode[]{r100, r101, r102, r103};
    }

    public static ClayRenderMode[] values() {
        return (ClayRenderMode[]) f381874a.clone();
    }

    public static ClayRenderMode valueOf(String r100) {
        return (ClayRenderMode) r27.a.a(ClayRenderMode.class, r100);
    }

    public ClayRenderMode(String r100, int r101) {
        super(r100, r101);
    }
}
