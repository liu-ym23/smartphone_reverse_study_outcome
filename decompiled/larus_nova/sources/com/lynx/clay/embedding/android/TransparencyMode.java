package com.lynx.clay.embedding.android;

import com.bytedance.android.ec.model.response.ECPromotion;

/* JADX INFO: loaded from: classes32.dex */
public final enum TransparencyMode extends Enum<TransparencyMode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TransparencyMode[] f380628a = null;
    public static final TransparencyMode opaque = null;
    public static final TransparencyMode transparent = null;

    static {
        TransparencyMode r100 = new TransparencyMode("opaque", 0);
        opaque = r100;
        TransparencyMode r101 = new TransparencyMode(ECPromotion.TRANSPARENT_BOTTON_ICON, 1);
        transparent = r101;
        f380628a = new TransparencyMode[]{r100, r101};
    }

    public static TransparencyMode[] values() {
        return (TransparencyMode[]) f380628a.clone();
    }

    public static TransparencyMode valueOf(String r100) {
        return (TransparencyMode) r27.a.a(TransparencyMode.class, r100);
    }

    public TransparencyMode(String r100, int r101) {
        super(r100, r101);
    }
}
