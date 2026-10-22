package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/relax/relaxframework/ModifierValue_WhiteSpace;", "", "", "value", "I", "getValue", "()I", "Normal", "Nowrap", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum ModifierValue_WhiteSpace extends Enum<ModifierValue_WhiteSpace> {
    public static final ModifierValue_WhiteSpace Normal = null;
    public static final ModifierValue_WhiteSpace Nowrap = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ModifierValue_WhiteSpace[] f404827a = null;
    private final int value;

    public static ModifierValue_WhiteSpace valueOf(String r100) {
        return (ModifierValue_WhiteSpace) r27.a.a(ModifierValue_WhiteSpace.class, r100);
    }

    public static ModifierValue_WhiteSpace[] values() {
        return (ModifierValue_WhiteSpace[]) f404827a.clone();
    }

    static {
        ModifierValue_WhiteSpace r100 = new ModifierValue_WhiteSpace("Normal", 0, 0);
        Normal = r100;
        ModifierValue_WhiteSpace r101 = new ModifierValue_WhiteSpace("Nowrap", 1, 1);
        Nowrap = r101;
        f404827a = new ModifierValue_WhiteSpace[]{r100, r101};
    }

    public final int getValue() {
        return this.value;
    }

    public ModifierValue_WhiteSpace(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
