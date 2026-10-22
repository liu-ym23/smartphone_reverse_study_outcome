package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/relax/relaxframework/ModifierValue_VerticalAlign;", "", "", "value", "I", "getValue", "()I", "Default", "Baseline", "Sub", "Super", "Top", "TextTop", "Middle", "Bottom", "TextBottom", "Length", "Percent", "Center", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum ModifierValue_VerticalAlign extends Enum<ModifierValue_VerticalAlign> {
    public static final ModifierValue_VerticalAlign Baseline = null;
    public static final ModifierValue_VerticalAlign Bottom = null;
    public static final ModifierValue_VerticalAlign Center = null;
    public static final ModifierValue_VerticalAlign Default = null;
    public static final ModifierValue_VerticalAlign Length = null;
    public static final ModifierValue_VerticalAlign Middle = null;
    public static final ModifierValue_VerticalAlign Percent = null;
    public static final ModifierValue_VerticalAlign Sub = null;
    public static final ModifierValue_VerticalAlign Super = null;
    public static final ModifierValue_VerticalAlign TextBottom = null;
    public static final ModifierValue_VerticalAlign TextTop = null;
    public static final ModifierValue_VerticalAlign Top = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ModifierValue_VerticalAlign[] f404825a = null;
    private final int value;

    public static ModifierValue_VerticalAlign valueOf(String r100) {
        return (ModifierValue_VerticalAlign) r27.a.a(ModifierValue_VerticalAlign.class, r100);
    }

    public static ModifierValue_VerticalAlign[] values() {
        return (ModifierValue_VerticalAlign[]) f404825a.clone();
    }

    static {
        ModifierValue_VerticalAlign r100 = new ModifierValue_VerticalAlign("Default", 0, 0);
        Default = r100;
        ModifierValue_VerticalAlign r101 = new ModifierValue_VerticalAlign("Baseline", 1, 1);
        Baseline = r101;
        ModifierValue_VerticalAlign r102 = new ModifierValue_VerticalAlign("Sub", 2, 2);
        Sub = r102;
        ModifierValue_VerticalAlign r103 = new ModifierValue_VerticalAlign("Super", 3, 3);
        Super = r103;
        ModifierValue_VerticalAlign r104 = new ModifierValue_VerticalAlign("Top", 4, 4);
        Top = r104;
        ModifierValue_VerticalAlign r105 = new ModifierValue_VerticalAlign("TextTop", 5, 5);
        TextTop = r105;
        ModifierValue_VerticalAlign r110 = new ModifierValue_VerticalAlign("Middle", 6, 6);
        Middle = r110;
        ModifierValue_VerticalAlign r111 = new ModifierValue_VerticalAlign("Bottom", 7, 7);
        Bottom = r111;
        ModifierValue_VerticalAlign r112 = new ModifierValue_VerticalAlign("TextBottom", 8, 8);
        TextBottom = r112;
        ModifierValue_VerticalAlign r113 = new ModifierValue_VerticalAlign("Length", 9, 9);
        Length = r113;
        ModifierValue_VerticalAlign r114 = new ModifierValue_VerticalAlign("Percent", 10, 10);
        Percent = r114;
        ModifierValue_VerticalAlign r115 = new ModifierValue_VerticalAlign("Center", 11, 11);
        Center = r115;
        f404825a = new ModifierValue_VerticalAlign[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115};
    }

    public final int getValue() {
        return this.value;
    }

    public ModifierValue_VerticalAlign(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
