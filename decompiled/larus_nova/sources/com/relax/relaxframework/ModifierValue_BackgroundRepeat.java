package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/relax/relaxframework/ModifierValue_BackgroundRepeat;", "", "", "value", "I", "getValue", "()I", "Repeat", "NoRepeat", "RepeatX", "RepeatY", "Round", "Space", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum ModifierValue_BackgroundRepeat extends Enum<ModifierValue_BackgroundRepeat> {
    public static final ModifierValue_BackgroundRepeat NoRepeat = null;
    public static final ModifierValue_BackgroundRepeat Repeat = null;
    public static final ModifierValue_BackgroundRepeat RepeatX = null;
    public static final ModifierValue_BackgroundRepeat RepeatY = null;
    public static final ModifierValue_BackgroundRepeat Round = null;
    public static final ModifierValue_BackgroundRepeat Space = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ModifierValue_BackgroundRepeat[] f404804a = null;
    private final int value;

    public static ModifierValue_BackgroundRepeat valueOf(String r100) {
        return (ModifierValue_BackgroundRepeat) r27.a.a(ModifierValue_BackgroundRepeat.class, r100);
    }

    public static ModifierValue_BackgroundRepeat[] values() {
        return (ModifierValue_BackgroundRepeat[]) f404804a.clone();
    }

    static {
        ModifierValue_BackgroundRepeat r100 = new ModifierValue_BackgroundRepeat("Repeat", 0, 0);
        Repeat = r100;
        ModifierValue_BackgroundRepeat r101 = new ModifierValue_BackgroundRepeat("NoRepeat", 1, 1);
        NoRepeat = r101;
        ModifierValue_BackgroundRepeat r102 = new ModifierValue_BackgroundRepeat("RepeatX", 2, 2);
        RepeatX = r102;
        ModifierValue_BackgroundRepeat r103 = new ModifierValue_BackgroundRepeat("RepeatY", 3, 3);
        RepeatY = r103;
        ModifierValue_BackgroundRepeat r104 = new ModifierValue_BackgroundRepeat("Round", 4, 4);
        Round = r104;
        ModifierValue_BackgroundRepeat r105 = new ModifierValue_BackgroundRepeat("Space", 5, 5);
        Space = r105;
        f404804a = new ModifierValue_BackgroundRepeat[]{r100, r101, r102, r103, r104, r105};
    }

    public final int getValue() {
        return this.value;
    }

    public ModifierValue_BackgroundRepeat(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
