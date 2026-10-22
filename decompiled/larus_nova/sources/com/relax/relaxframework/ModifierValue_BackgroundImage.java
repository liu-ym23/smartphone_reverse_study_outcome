package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/relax/relaxframework/ModifierValue_BackgroundImage;", "", "", "value", "I", "getValue", "()I", "None", "Url", "LinearGradient", "RadialGradient", "ConicGradient", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum ModifierValue_BackgroundImage extends Enum<ModifierValue_BackgroundImage> {
    public static final ModifierValue_BackgroundImage ConicGradient = null;
    public static final ModifierValue_BackgroundImage LinearGradient = null;
    public static final ModifierValue_BackgroundImage None = null;
    public static final ModifierValue_BackgroundImage RadialGradient = null;
    public static final ModifierValue_BackgroundImage Url = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ModifierValue_BackgroundImage[] f404801a = null;
    private final int value;

    public static ModifierValue_BackgroundImage valueOf(String r100) {
        return (ModifierValue_BackgroundImage) r27.a.a(ModifierValue_BackgroundImage.class, r100);
    }

    public static ModifierValue_BackgroundImage[] values() {
        return (ModifierValue_BackgroundImage[]) f404801a.clone();
    }

    static {
        ModifierValue_BackgroundImage r100 = new ModifierValue_BackgroundImage("None", 0, 0);
        None = r100;
        ModifierValue_BackgroundImage r101 = new ModifierValue_BackgroundImage("Url", 1, 1);
        Url = r101;
        ModifierValue_BackgroundImage r102 = new ModifierValue_BackgroundImage("LinearGradient", 2, 2);
        LinearGradient = r102;
        ModifierValue_BackgroundImage r103 = new ModifierValue_BackgroundImage("RadialGradient", 3, 3);
        RadialGradient = r103;
        ModifierValue_BackgroundImage r104 = new ModifierValue_BackgroundImage("ConicGradient", 4, 4);
        ConicGradient = r104;
        f404801a = new ModifierValue_BackgroundImage[]{r100, r101, r102, r103, r104};
    }

    public final int getValue() {
        return this.value;
    }

    public ModifierValue_BackgroundImage(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
