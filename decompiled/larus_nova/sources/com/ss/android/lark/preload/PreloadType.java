package com.ss.android.lark.preload;

/* JADX INFO: loaded from: classes37.dex */
public final enum PreloadType extends Enum<PreloadType> {
    public static final PreloadType IDLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PreloadType[] f438801a = null;

    static {
        PreloadType r100 = new PreloadType();
        IDLE = r100;
        f438801a = new PreloadType[]{r100};
    }

    public PreloadType() {
        super("IDLE", 0);
    }

    public static PreloadType[] values() {
        return (PreloadType[]) f438801a.clone();
    }

    public static PreloadType valueOf(String r100) {
        return (PreloadType) r27.a.a(PreloadType.class, r100);
    }
}
