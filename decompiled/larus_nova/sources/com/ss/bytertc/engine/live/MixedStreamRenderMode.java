package com.ss.bytertc.engine.live;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum MixedStreamRenderMode extends Enum<MixedStreamRenderMode> {
    private static final /* synthetic */ MixedStreamRenderMode[] $VALUES = null;
    public static final MixedStreamRenderMode MIXED_STREAM_RENDER_MODE_ADAPTIVE = null;
    public static final MixedStreamRenderMode MIXED_STREAM_RENDER_MODE_FIT = null;
    public static final MixedStreamRenderMode MIXED_STREAM_RENDER_MODE_HIDDEN = null;
    private int renderMode;

    static {
        MixedStreamRenderMode r100 = new MixedStreamRenderMode("MIXED_STREAM_RENDER_MODE_HIDDEN", 0, 1);
        MIXED_STREAM_RENDER_MODE_HIDDEN = r100;
        MixedStreamRenderMode r101 = new MixedStreamRenderMode("MIXED_STREAM_RENDER_MODE_FIT", 1, 2);
        MIXED_STREAM_RENDER_MODE_FIT = r101;
        MixedStreamRenderMode r102 = new MixedStreamRenderMode("MIXED_STREAM_RENDER_MODE_ADAPTIVE", 2, 3);
        MIXED_STREAM_RENDER_MODE_ADAPTIVE = r102;
        $VALUES = new MixedStreamRenderMode[]{r100, r101, r102};
    }

    public static MixedStreamRenderMode[] values() {
        return (MixedStreamRenderMode[]) $VALUES.clone();
    }

    public int getValue() {
        return this.renderMode;
    }

    public static MixedStreamRenderMode valueOf(String r100) {
        return (MixedStreamRenderMode) a.a(MixedStreamRenderMode.class, r100);
    }

    private MixedStreamRenderMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.renderMode = r102;
    }
}
