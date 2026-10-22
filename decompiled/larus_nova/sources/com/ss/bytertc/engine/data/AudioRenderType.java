package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum AudioRenderType extends Enum<AudioRenderType> {
    private static final /* synthetic */ AudioRenderType[] $VALUES = null;
    public static final AudioRenderType AUDIO_RENDER_TYPE_EXTERNAL = null;
    public static final AudioRenderType AUDIO_RENDER_TYPE_INTERNAL = null;
    private int value;

    static {
        AudioRenderType r100 = new AudioRenderType("AUDIO_RENDER_TYPE_EXTERNAL", 0, 0);
        AUDIO_RENDER_TYPE_EXTERNAL = r100;
        AudioRenderType r101 = new AudioRenderType("AUDIO_RENDER_TYPE_INTERNAL", 1, 1);
        AUDIO_RENDER_TYPE_INTERNAL = r101;
        $VALUES = new AudioRenderType[]{r100, r101};
    }

    public static AudioRenderType[] values() {
        return (AudioRenderType[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        if (this != AUDIO_RENDER_TYPE_EXTERNAL) goto L5;
        return "AUDIO_RENDER_TYPE_EXTERNAL";
    L5:
        return "AUDIO_RENDER_TYPE_INTERNAL";
    }

    public int value() {
        return this.value;
    }

    public static AudioRenderType fromId(int r100) {
        AudioRenderType[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        AudioRenderType r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static AudioRenderType valueOf(String r100) {
        return (AudioRenderType) a.a(AudioRenderType.class, r100);
    }

    private AudioRenderType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
