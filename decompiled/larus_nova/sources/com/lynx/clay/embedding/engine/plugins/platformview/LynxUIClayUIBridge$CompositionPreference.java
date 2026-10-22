package com.lynx.clay.embedding.engine.plugins.platformview;

/* JADX INFO: loaded from: classes32.dex */
public final enum LynxUIClayUIBridge$CompositionPreference extends Enum<LynxUIClayUIBridge$CompositionPreference> {
    public static final LynxUIClayUIBridge$CompositionPreference AUTO = null;
    public static final LynxUIClayUIBridge$CompositionPreference HYBRID_COMPOSITION = null;
    public static final LynxUIClayUIBridge$CompositionPreference OFFSCREEN_SURFACE = null;
    public static final LynxUIClayUIBridge$CompositionPreference TEXTURE_LAYER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LynxUIClayUIBridge$CompositionPreference[] f380848a = null;

    static {
        LynxUIClayUIBridge$CompositionPreference r100 = new LynxUIClayUIBridge$CompositionPreference("AUTO", 0);
        AUTO = r100;
        LynxUIClayUIBridge$CompositionPreference r101 = new LynxUIClayUIBridge$CompositionPreference("HYBRID_COMPOSITION", 1);
        HYBRID_COMPOSITION = r101;
        LynxUIClayUIBridge$CompositionPreference r102 = new LynxUIClayUIBridge$CompositionPreference("TEXTURE_LAYER", 2);
        TEXTURE_LAYER = r102;
        LynxUIClayUIBridge$CompositionPreference r103 = new LynxUIClayUIBridge$CompositionPreference("OFFSCREEN_SURFACE", 3);
        OFFSCREEN_SURFACE = r103;
        f380848a = new LynxUIClayUIBridge$CompositionPreference[]{r100, r101, r102, r103};
    }

    public static LynxUIClayUIBridge$CompositionPreference[] values() {
        return (LynxUIClayUIBridge$CompositionPreference[]) f380848a.clone();
    }

    public static LynxUIClayUIBridge$CompositionPreference valueOf(String r100) {
        return (LynxUIClayUIBridge$CompositionPreference) r27.a.a(LynxUIClayUIBridge$CompositionPreference.class, r100);
    }

    public LynxUIClayUIBridge$CompositionPreference(String r100, int r101) {
        super(r100, r101);
    }
}
