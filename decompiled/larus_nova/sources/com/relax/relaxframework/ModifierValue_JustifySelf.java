package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/relax/relaxframework/ModifierValue_JustifySelf;", "", "", "value", "I", "getValue", "()I", "Auto", "Stretch", "Start", "End", "Center", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum ModifierValue_JustifySelf extends Enum<ModifierValue_JustifySelf> {
    public static final ModifierValue_JustifySelf Auto = null;
    public static final ModifierValue_JustifySelf Center = null;
    public static final ModifierValue_JustifySelf End = null;
    public static final ModifierValue_JustifySelf Start = null;
    public static final ModifierValue_JustifySelf Stretch = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ModifierValue_JustifySelf[] f404815a = null;
    private final int value;

    public static ModifierValue_JustifySelf valueOf(String r100) {
        return (ModifierValue_JustifySelf) r27.a.a(ModifierValue_JustifySelf.class, r100);
    }

    public static ModifierValue_JustifySelf[] values() {
        return (ModifierValue_JustifySelf[]) f404815a.clone();
    }

    static {
        ModifierValue_JustifySelf r100 = new ModifierValue_JustifySelf("Auto", 0, 0);
        Auto = r100;
        ModifierValue_JustifySelf r101 = new ModifierValue_JustifySelf("Stretch", 1, 1);
        Stretch = r101;
        ModifierValue_JustifySelf r102 = new ModifierValue_JustifySelf("Start", 2, 2);
        Start = r102;
        ModifierValue_JustifySelf r103 = new ModifierValue_JustifySelf("End", 3, 3);
        End = r103;
        ModifierValue_JustifySelf r104 = new ModifierValue_JustifySelf("Center", 4, 4);
        Center = r104;
        f404815a = new ModifierValue_JustifySelf[]{r100, r101, r102, r103, r104};
    }

    public final int getValue() {
        return this.value;
    }

    public ModifierValue_JustifySelf(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
