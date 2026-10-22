package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/relax/relaxframework/ModifierValue_Visibility;", "", "", "value", "I", "getValue", "()I", "Hidden", "Visible", "Gone", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum ModifierValue_Visibility extends Enum<ModifierValue_Visibility> {
    public static final ModifierValue_Visibility Gone = null;
    public static final ModifierValue_Visibility Hidden = null;
    public static final ModifierValue_Visibility Visible = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ModifierValue_Visibility[] f404826a = null;
    private final int value;

    public static ModifierValue_Visibility valueOf(String r100) {
        return (ModifierValue_Visibility) r27.a.a(ModifierValue_Visibility.class, r100);
    }

    public static ModifierValue_Visibility[] values() {
        return (ModifierValue_Visibility[]) f404826a.clone();
    }

    static {
        ModifierValue_Visibility r100 = new ModifierValue_Visibility("Hidden", 0, 0);
        Hidden = r100;
        ModifierValue_Visibility r101 = new ModifierValue_Visibility("Visible", 1, 1);
        Visible = r101;
        ModifierValue_Visibility r102 = new ModifierValue_Visibility("Gone", 2, 2);
        Gone = r102;
        f404826a = new ModifierValue_Visibility[]{r100, r101, r102};
    }

    public final int getValue() {
        return this.value;
    }

    public ModifierValue_Visibility(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
