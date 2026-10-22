package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/relax/relaxframework/ModifierValue_FlexAlign;", "", "", "value", "I", "getValue", "()I", "Auto", "Stretch", "Start", "End", "Center", "Baseline", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum ModifierValue_FlexAlign extends Enum<ModifierValue_FlexAlign> {
    public static final ModifierValue_FlexAlign Auto = null;
    public static final ModifierValue_FlexAlign Baseline = null;
    public static final ModifierValue_FlexAlign Center = null;
    public static final ModifierValue_FlexAlign End = null;
    public static final ModifierValue_FlexAlign Start = null;
    public static final ModifierValue_FlexAlign Stretch = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ModifierValue_FlexAlign[] f404811a = null;
    private final int value;

    public static ModifierValue_FlexAlign valueOf(String r100) {
        return (ModifierValue_FlexAlign) r27.a.a(ModifierValue_FlexAlign.class, r100);
    }

    public static ModifierValue_FlexAlign[] values() {
        return (ModifierValue_FlexAlign[]) f404811a.clone();
    }

    static {
        ModifierValue_FlexAlign r100 = new ModifierValue_FlexAlign("Auto", 0, 0);
        Auto = r100;
        ModifierValue_FlexAlign r101 = new ModifierValue_FlexAlign("Stretch", 1, 1);
        Stretch = r101;
        ModifierValue_FlexAlign r102 = new ModifierValue_FlexAlign("Start", 2, 2);
        Start = r102;
        ModifierValue_FlexAlign r103 = new ModifierValue_FlexAlign("End", 3, 3);
        End = r103;
        ModifierValue_FlexAlign r104 = new ModifierValue_FlexAlign("Center", 4, 4);
        Center = r104;
        ModifierValue_FlexAlign r105 = new ModifierValue_FlexAlign("Baseline", 5, 5);
        Baseline = r105;
        f404811a = new ModifierValue_FlexAlign[]{r100, r101, r102, r103, r104, r105};
    }

    public final int getValue() {
        return this.value;
    }

    public ModifierValue_FlexAlign(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
