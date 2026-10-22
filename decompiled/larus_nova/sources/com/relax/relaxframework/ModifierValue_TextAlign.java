package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/relax/relaxframework/ModifierValue_TextAlign;", "", "", "value", "I", "getValue", "()I", "Left", "Center", "Right", "Start", "End", "Justify", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum ModifierValue_TextAlign extends Enum<ModifierValue_TextAlign> {
    public static final ModifierValue_TextAlign Center = null;
    public static final ModifierValue_TextAlign End = null;
    public static final ModifierValue_TextAlign Justify = null;
    public static final ModifierValue_TextAlign Left = null;
    public static final ModifierValue_TextAlign Right = null;
    public static final ModifierValue_TextAlign Start = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ModifierValue_TextAlign[] f404821a = null;
    private final int value;

    public static ModifierValue_TextAlign valueOf(String r100) {
        return (ModifierValue_TextAlign) r27.a.a(ModifierValue_TextAlign.class, r100);
    }

    public static ModifierValue_TextAlign[] values() {
        return (ModifierValue_TextAlign[]) f404821a.clone();
    }

    static {
        ModifierValue_TextAlign r100 = new ModifierValue_TextAlign("Left", 0, 0);
        Left = r100;
        ModifierValue_TextAlign r101 = new ModifierValue_TextAlign("Center", 1, 1);
        Center = r101;
        ModifierValue_TextAlign r102 = new ModifierValue_TextAlign("Right", 2, 2);
        Right = r102;
        ModifierValue_TextAlign r103 = new ModifierValue_TextAlign("Start", 3, 3);
        Start = r103;
        ModifierValue_TextAlign r104 = new ModifierValue_TextAlign("End", 4, 4);
        End = r104;
        ModifierValue_TextAlign r105 = new ModifierValue_TextAlign("Justify", 5, 5);
        Justify = r105;
        f404821a = new ModifierValue_TextAlign[]{r100, r101, r102, r103, r104, r105};
    }

    public final int getValue() {
        return this.value;
    }

    public ModifierValue_TextAlign(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
