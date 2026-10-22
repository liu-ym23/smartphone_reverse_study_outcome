package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/relax/relaxframework/ModifierValue_TextDecorationLine;", "", "", "value", "I", "getValue", "()I", "None", "UnderLine", "LineThrough", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum ModifierValue_TextDecorationLine extends Enum<ModifierValue_TextDecorationLine> {
    public static final ModifierValue_TextDecorationLine LineThrough = null;
    public static final ModifierValue_TextDecorationLine None = null;
    public static final ModifierValue_TextDecorationLine UnderLine = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ModifierValue_TextDecorationLine[] f404822a = null;
    private final int value;

    public static ModifierValue_TextDecorationLine valueOf(String r100) {
        return (ModifierValue_TextDecorationLine) r27.a.a(ModifierValue_TextDecorationLine.class, r100);
    }

    public static ModifierValue_TextDecorationLine[] values() {
        return (ModifierValue_TextDecorationLine[]) f404822a.clone();
    }

    static {
        ModifierValue_TextDecorationLine r100 = new ModifierValue_TextDecorationLine("None", 0, 0);
        None = r100;
        ModifierValue_TextDecorationLine r101 = new ModifierValue_TextDecorationLine("UnderLine", 1, 1);
        UnderLine = r101;
        ModifierValue_TextDecorationLine r102 = new ModifierValue_TextDecorationLine("LineThrough", 2, 2);
        LineThrough = r102;
        f404822a = new ModifierValue_TextDecorationLine[]{r100, r101, r102};
    }

    public final int getValue() {
        return this.value;
    }

    public ModifierValue_TextDecorationLine(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
