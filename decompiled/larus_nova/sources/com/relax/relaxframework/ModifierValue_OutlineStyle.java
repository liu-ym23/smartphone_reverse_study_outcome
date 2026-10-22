package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/relax/relaxframework/ModifierValue_OutlineStyle;", "", "", "value", "I", "getValue", "()I", "Solid", "Dashed", "Dotted", "Double", "Groove", "Ridge", "Inset", "Outset", "Hide", "None", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum ModifierValue_OutlineStyle extends Enum<ModifierValue_OutlineStyle> {
    public static final ModifierValue_OutlineStyle Dashed = null;
    public static final ModifierValue_OutlineStyle Dotted = null;
    public static final ModifierValue_OutlineStyle Double = null;
    public static final ModifierValue_OutlineStyle Groove = null;
    public static final ModifierValue_OutlineStyle Hide = null;
    public static final ModifierValue_OutlineStyle Inset = null;
    public static final ModifierValue_OutlineStyle None = null;
    public static final ModifierValue_OutlineStyle Outset = null;
    public static final ModifierValue_OutlineStyle Ridge = null;
    public static final ModifierValue_OutlineStyle Solid = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ModifierValue_OutlineStyle[] f404817a = null;
    private final int value;

    public static ModifierValue_OutlineStyle valueOf(String r100) {
        return (ModifierValue_OutlineStyle) r27.a.a(ModifierValue_OutlineStyle.class, r100);
    }

    public static ModifierValue_OutlineStyle[] values() {
        return (ModifierValue_OutlineStyle[]) f404817a.clone();
    }

    static {
        ModifierValue_OutlineStyle r100 = new ModifierValue_OutlineStyle("Solid", 0, 0);
        Solid = r100;
        ModifierValue_OutlineStyle r101 = new ModifierValue_OutlineStyle("Dashed", 1, 1);
        Dashed = r101;
        ModifierValue_OutlineStyle r102 = new ModifierValue_OutlineStyle("Dotted", 2, 2);
        Dotted = r102;
        ModifierValue_OutlineStyle r103 = new ModifierValue_OutlineStyle("Double", 3, 3);
        Double = r103;
        ModifierValue_OutlineStyle r104 = new ModifierValue_OutlineStyle("Groove", 4, 4);
        Groove = r104;
        ModifierValue_OutlineStyle r105 = new ModifierValue_OutlineStyle("Ridge", 5, 5);
        Ridge = r105;
        ModifierValue_OutlineStyle r110 = new ModifierValue_OutlineStyle("Inset", 6, 6);
        Inset = r110;
        ModifierValue_OutlineStyle r111 = new ModifierValue_OutlineStyle("Outset", 7, 7);
        Outset = r111;
        ModifierValue_OutlineStyle r112 = new ModifierValue_OutlineStyle("Hide", 8, 8);
        Hide = r112;
        ModifierValue_OutlineStyle r113 = new ModifierValue_OutlineStyle("None", 9, 9);
        None = r113;
        f404817a = new ModifierValue_OutlineStyle[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
    }

    public final int getValue() {
        return this.value;
    }

    public ModifierValue_OutlineStyle(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
