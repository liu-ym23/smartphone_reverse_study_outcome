package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/relax/relaxframework/ModifierValue_BorderStyle;", "", "", "value", "I", "getValue", "()I", "Solid", "Dashed", "Dotted", "Double", "Groove", "Ridge", "Inset", "Outset", "Hide", "None", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum ModifierValue_BorderStyle extends Enum<ModifierValue_BorderStyle> {
    public static final ModifierValue_BorderStyle Dashed = null;
    public static final ModifierValue_BorderStyle Dotted = null;
    public static final ModifierValue_BorderStyle Double = null;
    public static final ModifierValue_BorderStyle Groove = null;
    public static final ModifierValue_BorderStyle Hide = null;
    public static final ModifierValue_BorderStyle Inset = null;
    public static final ModifierValue_BorderStyle None = null;
    public static final ModifierValue_BorderStyle Outset = null;
    public static final ModifierValue_BorderStyle Ridge = null;
    public static final ModifierValue_BorderStyle Solid = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ModifierValue_BorderStyle[] f404806a = null;
    private final int value;

    public static ModifierValue_BorderStyle valueOf(String r100) {
        return (ModifierValue_BorderStyle) r27.a.a(ModifierValue_BorderStyle.class, r100);
    }

    public static ModifierValue_BorderStyle[] values() {
        return (ModifierValue_BorderStyle[]) f404806a.clone();
    }

    static {
        ModifierValue_BorderStyle r100 = new ModifierValue_BorderStyle("Solid", 0, 0);
        Solid = r100;
        ModifierValue_BorderStyle r101 = new ModifierValue_BorderStyle("Dashed", 1, 1);
        Dashed = r101;
        ModifierValue_BorderStyle r102 = new ModifierValue_BorderStyle("Dotted", 2, 2);
        Dotted = r102;
        ModifierValue_BorderStyle r103 = new ModifierValue_BorderStyle("Double", 3, 3);
        Double = r103;
        ModifierValue_BorderStyle r104 = new ModifierValue_BorderStyle("Groove", 4, 4);
        Groove = r104;
        ModifierValue_BorderStyle r105 = new ModifierValue_BorderStyle("Ridge", 5, 5);
        Ridge = r105;
        ModifierValue_BorderStyle r110 = new ModifierValue_BorderStyle("Inset", 6, 6);
        Inset = r110;
        ModifierValue_BorderStyle r111 = new ModifierValue_BorderStyle("Outset", 7, 7);
        Outset = r111;
        ModifierValue_BorderStyle r112 = new ModifierValue_BorderStyle("Hide", 8, 8);
        Hide = r112;
        ModifierValue_BorderStyle r113 = new ModifierValue_BorderStyle("None", 9, 9);
        None = r113;
        f404806a = new ModifierValue_BorderStyle[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
    }

    public final int getValue() {
        return this.value;
    }

    public ModifierValue_BorderStyle(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
