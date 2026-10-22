package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/relax/relaxframework/ModifierValue_Overflow;", "", "", "value", "I", "getValue", "()I", "Visible", "Hidden", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum ModifierValue_Overflow extends Enum<ModifierValue_Overflow> {
    public static final ModifierValue_Overflow Hidden = null;
    public static final ModifierValue_Overflow Visible = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ModifierValue_Overflow[] f404818a = null;
    private final int value;

    public static ModifierValue_Overflow valueOf(String r100) {
        return (ModifierValue_Overflow) r27.a.a(ModifierValue_Overflow.class, r100);
    }

    public static ModifierValue_Overflow[] values() {
        return (ModifierValue_Overflow[]) f404818a.clone();
    }

    static {
        ModifierValue_Overflow r100 = new ModifierValue_Overflow("Visible", 0, 0);
        Visible = r100;
        ModifierValue_Overflow r101 = new ModifierValue_Overflow("Hidden", 1, 1);
        Hidden = r101;
        f404818a = new ModifierValue_Overflow[]{r100, r101};
    }

    public final int getValue() {
        return this.value;
    }

    public ModifierValue_Overflow(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
