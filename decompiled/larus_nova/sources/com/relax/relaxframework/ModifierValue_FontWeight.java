package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/relax/relaxframework/ModifierValue_FontWeight;", "", "", "value", "I", "getValue", "()I", "Normal", "Bold", "k100", "k200", "k300", "k400", "k500", "k600", "k700", "k800", "k900", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum ModifierValue_FontWeight extends Enum<ModifierValue_FontWeight> {
    public static final ModifierValue_FontWeight Bold = null;
    public static final ModifierValue_FontWeight Normal = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ModifierValue_FontWeight[] f404813a = null;
    public static final ModifierValue_FontWeight k100 = null;
    public static final ModifierValue_FontWeight k200 = null;
    public static final ModifierValue_FontWeight k300 = null;
    public static final ModifierValue_FontWeight k400 = null;
    public static final ModifierValue_FontWeight k500 = null;
    public static final ModifierValue_FontWeight k600 = null;
    public static final ModifierValue_FontWeight k700 = null;
    public static final ModifierValue_FontWeight k800 = null;
    public static final ModifierValue_FontWeight k900 = null;
    private final int value;

    public static ModifierValue_FontWeight valueOf(String r100) {
        return (ModifierValue_FontWeight) r27.a.a(ModifierValue_FontWeight.class, r100);
    }

    public static ModifierValue_FontWeight[] values() {
        return (ModifierValue_FontWeight[]) f404813a.clone();
    }

    static {
        ModifierValue_FontWeight r100 = new ModifierValue_FontWeight("Normal", 0, 0);
        Normal = r100;
        ModifierValue_FontWeight r101 = new ModifierValue_FontWeight("Bold", 1, 1);
        Bold = r101;
        ModifierValue_FontWeight r102 = new ModifierValue_FontWeight("k100", 2, 2);
        k100 = r102;
        ModifierValue_FontWeight r103 = new ModifierValue_FontWeight("k200", 3, 3);
        k200 = r103;
        ModifierValue_FontWeight r104 = new ModifierValue_FontWeight("k300", 4, 4);
        k300 = r104;
        ModifierValue_FontWeight r105 = new ModifierValue_FontWeight("k400", 5, 5);
        k400 = r105;
        ModifierValue_FontWeight r110 = new ModifierValue_FontWeight("k500", 6, 6);
        k500 = r110;
        ModifierValue_FontWeight r111 = new ModifierValue_FontWeight("k600", 7, 7);
        k600 = r111;
        ModifierValue_FontWeight r112 = new ModifierValue_FontWeight("k700", 8, 8);
        k700 = r112;
        ModifierValue_FontWeight r113 = new ModifierValue_FontWeight("k800", 9, 9);
        k800 = r113;
        ModifierValue_FontWeight r114 = new ModifierValue_FontWeight("k900", 10, 10);
        k900 = r114;
        f404813a = new ModifierValue_FontWeight[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114};
    }

    public final int getValue() {
        return this.value;
    }

    public ModifierValue_FontWeight(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
