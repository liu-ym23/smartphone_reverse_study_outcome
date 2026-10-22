package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/relax/relaxframework/ModifierValue_AnimationFillMode;", "", "", "value", "I", "getValue", "()I", "None", "Forwards", "Backwards", "Both", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum ModifierValue_AnimationFillMode extends Enum<ModifierValue_AnimationFillMode> {
    public static final ModifierValue_AnimationFillMode Backwards = null;
    public static final ModifierValue_AnimationFillMode Both = null;
    public static final ModifierValue_AnimationFillMode Forwards = null;
    public static final ModifierValue_AnimationFillMode None = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ModifierValue_AnimationFillMode[] f404796a = null;
    private final int value;

    public static ModifierValue_AnimationFillMode valueOf(String r100) {
        return (ModifierValue_AnimationFillMode) r27.a.a(ModifierValue_AnimationFillMode.class, r100);
    }

    public static ModifierValue_AnimationFillMode[] values() {
        return (ModifierValue_AnimationFillMode[]) f404796a.clone();
    }

    static {
        ModifierValue_AnimationFillMode r100 = new ModifierValue_AnimationFillMode("None", 0, 0);
        None = r100;
        ModifierValue_AnimationFillMode r101 = new ModifierValue_AnimationFillMode("Forwards", 1, 1);
        Forwards = r101;
        ModifierValue_AnimationFillMode r102 = new ModifierValue_AnimationFillMode("Backwards", 2, 2);
        Backwards = r102;
        ModifierValue_AnimationFillMode r103 = new ModifierValue_AnimationFillMode("Both", 3, 3);
        Both = r103;
        f404796a = new ModifierValue_AnimationFillMode[]{r100, r101, r102, r103};
    }

    public final int getValue() {
        return this.value;
    }

    public ModifierValue_AnimationFillMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
