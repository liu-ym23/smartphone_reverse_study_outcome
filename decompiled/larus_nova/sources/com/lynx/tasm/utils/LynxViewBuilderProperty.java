package com.lynx.tasm.utils;

import com.ss.texturerender.effect.ICEffect.ICEffectKeys;

/* JADX INFO: loaded from: classes32.dex */
public final enum LynxViewBuilderProperty extends Enum<LynxViewBuilderProperty> {
    public static final LynxViewBuilderProperty PLATFORM_CONFIG = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LynxViewBuilderProperty[] f384079a = null;
    private final String key;

    static {
        LynxViewBuilderProperty r100 = new LynxViewBuilderProperty();
        PLATFORM_CONFIG = r100;
        f384079a = new LynxViewBuilderProperty[]{r100};
    }

    public LynxViewBuilderProperty() {
        super("PLATFORM_CONFIG", 0);
        this.key = ICEffectKeys.KEY_IS_IC_EFFECT_PLATFORM_CONFIG;
    }

    public static LynxViewBuilderProperty[] values() {
        return (LynxViewBuilderProperty[]) f384079a.clone();
    }

    public String getKey() {
        return this.key;
    }

    public static LynxViewBuilderProperty valueOf(String r100) {
        return (LynxViewBuilderProperty) r27.a.a(LynxViewBuilderProperty.class, r100);
    }
}
