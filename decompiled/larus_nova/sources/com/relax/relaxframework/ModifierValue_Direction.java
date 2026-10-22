package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/relax/relaxframework/ModifierValue_Direction;", "", "", "value", "I", "getValue", "()I", "Normal", "Rtl", "Ltr", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum ModifierValue_Direction extends Enum<ModifierValue_Direction> {
    public static final ModifierValue_Direction Ltr = null;
    public static final ModifierValue_Direction Normal = null;
    public static final ModifierValue_Direction Rtl = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ModifierValue_Direction[] f404810a = null;
    private final int value;

    public static ModifierValue_Direction valueOf(String r100) {
        return (ModifierValue_Direction) r27.a.a(ModifierValue_Direction.class, r100);
    }

    public static ModifierValue_Direction[] values() {
        return (ModifierValue_Direction[]) f404810a.clone();
    }

    static {
        ModifierValue_Direction r100 = new ModifierValue_Direction("Normal", 0, 0);
        Normal = r100;
        ModifierValue_Direction r101 = new ModifierValue_Direction("Rtl", 1, 2);
        Rtl = r101;
        ModifierValue_Direction r102 = new ModifierValue_Direction("Ltr", 2, 3);
        Ltr = r102;
        f404810a = new ModifierValue_Direction[]{r100, r101, r102};
    }

    public final int getValue() {
        return this.value;
    }

    public ModifierValue_Direction(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
