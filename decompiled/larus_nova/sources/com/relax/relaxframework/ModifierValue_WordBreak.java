package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/relax/relaxframework/ModifierValue_WordBreak;", "", "", "value", "I", "getValue", "()I", "Normal", "BreakAll", "KeepAll", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum ModifierValue_WordBreak extends Enum<ModifierValue_WordBreak> {
    public static final ModifierValue_WordBreak BreakAll = null;
    public static final ModifierValue_WordBreak KeepAll = null;
    public static final ModifierValue_WordBreak Normal = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ModifierValue_WordBreak[] f404828a = null;
    private final int value;

    public static ModifierValue_WordBreak valueOf(String r100) {
        return (ModifierValue_WordBreak) r27.a.a(ModifierValue_WordBreak.class, r100);
    }

    public static ModifierValue_WordBreak[] values() {
        return (ModifierValue_WordBreak[]) f404828a.clone();
    }

    static {
        ModifierValue_WordBreak r100 = new ModifierValue_WordBreak("Normal", 0, 0);
        Normal = r100;
        ModifierValue_WordBreak r101 = new ModifierValue_WordBreak("BreakAll", 1, 1);
        BreakAll = r101;
        ModifierValue_WordBreak r102 = new ModifierValue_WordBreak("KeepAll", 2, 2);
        KeepAll = r102;
        f404828a = new ModifierValue_WordBreak[]{r100, r101, r102};
    }

    public final int getValue() {
        return this.value;
    }

    public ModifierValue_WordBreak(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
