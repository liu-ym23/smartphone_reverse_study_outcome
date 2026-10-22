package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/relax/relaxframework/ModifierValue_Position;", "", "", "value", "I", "getValue", "()I", "Absolute", "Relative", "Fixed", "Sticky", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum ModifierValue_Position extends Enum<ModifierValue_Position> {
    public static final ModifierValue_Position Absolute = null;
    public static final ModifierValue_Position Fixed = null;
    public static final ModifierValue_Position Relative = null;
    public static final ModifierValue_Position Sticky = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ModifierValue_Position[] f404819a = null;
    private final int value;

    public static ModifierValue_Position valueOf(String r100) {
        return (ModifierValue_Position) r27.a.a(ModifierValue_Position.class, r100);
    }

    public static ModifierValue_Position[] values() {
        return (ModifierValue_Position[]) f404819a.clone();
    }

    static {
        ModifierValue_Position r100 = new ModifierValue_Position("Absolute", 0, 0);
        Absolute = r100;
        ModifierValue_Position r101 = new ModifierValue_Position("Relative", 1, 1);
        Relative = r101;
        ModifierValue_Position r102 = new ModifierValue_Position("Fixed", 2, 2);
        Fixed = r102;
        ModifierValue_Position r103 = new ModifierValue_Position("Sticky", 3, 3);
        Sticky = r103;
        f404819a = new ModifierValue_Position[]{r100, r101, r102, r103};
    }

    public final int getValue() {
        return this.value;
    }

    public ModifierValue_Position(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
