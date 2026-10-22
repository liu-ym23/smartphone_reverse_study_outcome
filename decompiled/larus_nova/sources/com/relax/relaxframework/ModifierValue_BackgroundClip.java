package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/relax/relaxframework/ModifierValue_BackgroundClip;", "", "", "value", "I", "getValue", "()I", "PaddingBox", "BorderBox", "ContentBox", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum ModifierValue_BackgroundClip extends Enum<ModifierValue_BackgroundClip> {
    public static final ModifierValue_BackgroundClip BorderBox = null;
    public static final ModifierValue_BackgroundClip ContentBox = null;
    public static final ModifierValue_BackgroundClip PaddingBox = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ModifierValue_BackgroundClip[] f404800a = null;
    private final int value;

    public static ModifierValue_BackgroundClip valueOf(String r100) {
        return (ModifierValue_BackgroundClip) r27.a.a(ModifierValue_BackgroundClip.class, r100);
    }

    public static ModifierValue_BackgroundClip[] values() {
        return (ModifierValue_BackgroundClip[]) f404800a.clone();
    }

    static {
        ModifierValue_BackgroundClip r100 = new ModifierValue_BackgroundClip("PaddingBox", 0, 0);
        PaddingBox = r100;
        ModifierValue_BackgroundClip r101 = new ModifierValue_BackgroundClip("BorderBox", 1, 1);
        BorderBox = r101;
        ModifierValue_BackgroundClip r102 = new ModifierValue_BackgroundClip("ContentBox", 2, 2);
        ContentBox = r102;
        f404800a = new ModifierValue_BackgroundClip[]{r100, r101, r102};
    }

    public final int getValue() {
        return this.value;
    }

    public ModifierValue_BackgroundClip(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
