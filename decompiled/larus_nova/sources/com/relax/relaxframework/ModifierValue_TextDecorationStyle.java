package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/relax/relaxframework/ModifierValue_TextDecorationStyle;", "", "", "value", "I", "getValue", "()I", "Solid", "Double", "Dotted", "Dashed", "Wavy", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum ModifierValue_TextDecorationStyle extends Enum<ModifierValue_TextDecorationStyle> {
    public static final ModifierValue_TextDecorationStyle Dashed = null;
    public static final ModifierValue_TextDecorationStyle Dotted = null;
    public static final ModifierValue_TextDecorationStyle Double = null;
    public static final ModifierValue_TextDecorationStyle Solid = null;
    public static final ModifierValue_TextDecorationStyle Wavy = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ModifierValue_TextDecorationStyle[] f404823a = null;
    private final int value;

    public static ModifierValue_TextDecorationStyle valueOf(String r100) {
        return (ModifierValue_TextDecorationStyle) r27.a.a(ModifierValue_TextDecorationStyle.class, r100);
    }

    public static ModifierValue_TextDecorationStyle[] values() {
        return (ModifierValue_TextDecorationStyle[]) f404823a.clone();
    }

    static {
        ModifierValue_TextDecorationStyle r100 = new ModifierValue_TextDecorationStyle("Solid", 0, 4);
        Solid = r100;
        ModifierValue_TextDecorationStyle r101 = new ModifierValue_TextDecorationStyle("Double", 1, 8);
        Double = r101;
        ModifierValue_TextDecorationStyle r102 = new ModifierValue_TextDecorationStyle("Dotted", 2, 16);
        Dotted = r102;
        ModifierValue_TextDecorationStyle r103 = new ModifierValue_TextDecorationStyle("Dashed", 3, 32);
        Dashed = r103;
        ModifierValue_TextDecorationStyle r104 = new ModifierValue_TextDecorationStyle("Wavy", 4, 64);
        Wavy = r104;
        f404823a = new ModifierValue_TextDecorationStyle[]{r100, r101, r102, r103, r104};
    }

    public final int getValue() {
        return this.value;
    }

    public ModifierValue_TextDecorationStyle(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
