package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/relax/relaxframework/ModifierValue_ShadowOption;", "", "", "value", "I", "getValue", "()I", "None", "Inset", "Initial", "Inherit", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum ModifierValue_ShadowOption extends Enum<ModifierValue_ShadowOption> {
    public static final ModifierValue_ShadowOption Inherit = null;
    public static final ModifierValue_ShadowOption Initial = null;
    public static final ModifierValue_ShadowOption Inset = null;
    public static final ModifierValue_ShadowOption None = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ModifierValue_ShadowOption[] f404820a = null;
    private final int value;

    public static ModifierValue_ShadowOption valueOf(String r100) {
        return (ModifierValue_ShadowOption) r27.a.a(ModifierValue_ShadowOption.class, r100);
    }

    public static ModifierValue_ShadowOption[] values() {
        return (ModifierValue_ShadowOption[]) f404820a.clone();
    }

    static {
        ModifierValue_ShadowOption r100 = new ModifierValue_ShadowOption("None", 0, 0);
        None = r100;
        ModifierValue_ShadowOption r101 = new ModifierValue_ShadowOption("Inset", 1, 1);
        Inset = r101;
        ModifierValue_ShadowOption r102 = new ModifierValue_ShadowOption("Initial", 2, 2);
        Initial = r102;
        ModifierValue_ShadowOption r103 = new ModifierValue_ShadowOption("Inherit", 3, 3);
        Inherit = r103;
        f404820a = new ModifierValue_ShadowOption[]{r100, r101, r102, r103};
    }

    public final int getValue() {
        return this.value;
    }

    public ModifierValue_ShadowOption(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
