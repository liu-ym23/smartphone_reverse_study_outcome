package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/relax/relaxframework/ModifierType_Lengths;", "", "", "value", "J", "getValue", "()J", "Px", "Rpx", "Em", "Rem", "Vh", "Vw", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum ModifierType_Lengths extends Enum<ModifierType_Lengths> {
    public static final ModifierType_Lengths Em = null;
    public static final ModifierType_Lengths Px = null;
    public static final ModifierType_Lengths Rem = null;
    public static final ModifierType_Lengths Rpx = null;
    public static final ModifierType_Lengths Vh = null;
    public static final ModifierType_Lengths Vw = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ModifierType_Lengths[] f404792a = null;
    private final long value;

    public static ModifierType_Lengths valueOf(String r100) {
        return (ModifierType_Lengths) r27.a.a(ModifierType_Lengths.class, r100);
    }

    public static ModifierType_Lengths[] values() {
        return (ModifierType_Lengths[]) f404792a.clone();
    }

    static {
        ModifierType_Lengths r100 = new ModifierType_Lengths("Px", 0, 5);
        Px = r100;
        ModifierType_Lengths r101 = new ModifierType_Lengths("Rpx", 1, 6);
        Rpx = r101;
        ModifierType_Lengths r102 = new ModifierType_Lengths("Em", 2, 7);
        Em = r102;
        ModifierType_Lengths r103 = new ModifierType_Lengths("Rem", 3, 8);
        Rem = r103;
        ModifierType_Lengths r104 = new ModifierType_Lengths("Vh", 4, 9);
        Vh = r104;
        ModifierType_Lengths r105 = new ModifierType_Lengths("Vw", 5, 10);
        Vw = r105;
        f404792a = new ModifierType_Lengths[]{r100, r101, r102, r103, r104, r105};
    }

    public final long getValue() {
        return this.value;
    }

    public ModifierType_Lengths(String r100, int r101, long r102) {
        super(r100, r101);
        this.value = r102;
    }
}
