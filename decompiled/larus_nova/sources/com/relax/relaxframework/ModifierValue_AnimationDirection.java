package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/relax/relaxframework/ModifierValue_AnimationDirection;", "", "", "value", "I", "getValue", "()I", "Normal", "Reverse", "Alternate", "AlternateReverse", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum ModifierValue_AnimationDirection extends Enum<ModifierValue_AnimationDirection> {
    public static final ModifierValue_AnimationDirection Alternate = null;
    public static final ModifierValue_AnimationDirection AlternateReverse = null;
    public static final ModifierValue_AnimationDirection Normal = null;
    public static final ModifierValue_AnimationDirection Reverse = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ModifierValue_AnimationDirection[] f404795a = null;
    private final int value;

    public static ModifierValue_AnimationDirection valueOf(String r100) {
        return (ModifierValue_AnimationDirection) r27.a.a(ModifierValue_AnimationDirection.class, r100);
    }

    public static ModifierValue_AnimationDirection[] values() {
        return (ModifierValue_AnimationDirection[]) f404795a.clone();
    }

    static {
        ModifierValue_AnimationDirection r100 = new ModifierValue_AnimationDirection("Normal", 0, 0);
        Normal = r100;
        ModifierValue_AnimationDirection r101 = new ModifierValue_AnimationDirection("Reverse", 1, 1);
        Reverse = r101;
        ModifierValue_AnimationDirection r102 = new ModifierValue_AnimationDirection("Alternate", 2, 2);
        Alternate = r102;
        ModifierValue_AnimationDirection r103 = new ModifierValue_AnimationDirection("AlternateReverse", 3, 3);
        AlternateReverse = r103;
        f404795a = new ModifierValue_AnimationDirection[]{r100, r101, r102, r103};
    }

    public final int getValue() {
        return this.value;
    }

    public ModifierValue_AnimationDirection(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
