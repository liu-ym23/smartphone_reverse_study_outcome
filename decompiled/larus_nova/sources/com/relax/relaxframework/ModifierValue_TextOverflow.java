package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/relax/relaxframework/ModifierValue_TextOverflow;", "", "", "value", "I", "getValue", "()I", "Clip", "Ellipsis", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum ModifierValue_TextOverflow extends Enum<ModifierValue_TextOverflow> {
    public static final ModifierValue_TextOverflow Clip = null;
    public static final ModifierValue_TextOverflow Ellipsis = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ModifierValue_TextOverflow[] f404824a = null;
    private final int value;

    public static ModifierValue_TextOverflow valueOf(String r100) {
        return (ModifierValue_TextOverflow) r27.a.a(ModifierValue_TextOverflow.class, r100);
    }

    public static ModifierValue_TextOverflow[] values() {
        return (ModifierValue_TextOverflow[]) f404824a.clone();
    }

    static {
        ModifierValue_TextOverflow r100 = new ModifierValue_TextOverflow("Clip", 0, 0);
        Clip = r100;
        ModifierValue_TextOverflow r101 = new ModifierValue_TextOverflow("Ellipsis", 1, 1);
        Ellipsis = r101;
        f404824a = new ModifierValue_TextOverflow[]{r100, r101};
    }

    public final int getValue() {
        return this.value;
    }

    public ModifierValue_TextOverflow(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
