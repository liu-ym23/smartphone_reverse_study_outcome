package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/relax/relaxframework/ModifierValue_Content;", "", "", "value", "I", "getValue", "()I", "Invalid", "Plain", "Image", "Text", "Layer", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum ModifierValue_Content extends Enum<ModifierValue_Content> {
    public static final ModifierValue_Content Image = null;
    public static final ModifierValue_Content Invalid = null;
    public static final ModifierValue_Content Layer = null;
    public static final ModifierValue_Content Plain = null;
    public static final ModifierValue_Content Text = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ModifierValue_Content[] f404809a = null;
    private final int value;

    public static ModifierValue_Content valueOf(String r100) {
        return (ModifierValue_Content) r27.a.a(ModifierValue_Content.class, r100);
    }

    public static ModifierValue_Content[] values() {
        return (ModifierValue_Content[]) f404809a.clone();
    }

    static {
        ModifierValue_Content r100 = new ModifierValue_Content("Invalid", 0, 0);
        Invalid = r100;
        ModifierValue_Content r101 = new ModifierValue_Content("Plain", 1, 1);
        Plain = r101;
        ModifierValue_Content r102 = new ModifierValue_Content("Image", 2, 2);
        Image = r102;
        ModifierValue_Content r103 = new ModifierValue_Content("Text", 3, 3);
        Text = r103;
        ModifierValue_Content r104 = new ModifierValue_Content("Layer", 4, 4);
        Layer = r104;
        f404809a = new ModifierValue_Content[]{r100, r101, r102, r103, r104};
    }

    public final int getValue() {
        return this.value;
    }

    public ModifierValue_Content(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
