package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/relax/relaxframework/ModifierValue_BackgroundSize;", "", "", "value", "I", "getValue", "()I", "Auto", "Cover", "Contain", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum ModifierValue_BackgroundSize extends Enum<ModifierValue_BackgroundSize> {
    public static final ModifierValue_BackgroundSize Auto = null;
    public static final ModifierValue_BackgroundSize Contain = null;
    public static final ModifierValue_BackgroundSize Cover = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ModifierValue_BackgroundSize[] f404805a = null;
    private final int value;

    public static ModifierValue_BackgroundSize valueOf(String r100) {
        return (ModifierValue_BackgroundSize) r27.a.a(ModifierValue_BackgroundSize.class, r100);
    }

    public static ModifierValue_BackgroundSize[] values() {
        return (ModifierValue_BackgroundSize[]) f404805a.clone();
    }

    static {
        ModifierValue_BackgroundSize r100 = new ModifierValue_BackgroundSize("Auto", 0, 32);
        Auto = r100;
        ModifierValue_BackgroundSize r101 = new ModifierValue_BackgroundSize("Cover", 1, 33);
        Cover = r101;
        ModifierValue_BackgroundSize r102 = new ModifierValue_BackgroundSize("Contain", 2, 34);
        Contain = r102;
        f404805a = new ModifierValue_BackgroundSize[]{r100, r101, r102};
    }

    public final int getValue() {
        return this.value;
    }

    public ModifierValue_BackgroundSize(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
