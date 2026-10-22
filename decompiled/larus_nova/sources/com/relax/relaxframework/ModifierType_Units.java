package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/relax/relaxframework/ModifierType_Units;", "", "", "value", "J", "getValue", "()J", "Px", "Rpx", "Em", "Rem", "Vh", "Vw", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum ModifierType_Units extends Enum<ModifierType_Units> {
    public static final ModifierType_Units Em = null;
    public static final ModifierType_Units Px = null;
    public static final ModifierType_Units Rem = null;
    public static final ModifierType_Units Rpx = null;
    public static final ModifierType_Units Vh = null;
    public static final ModifierType_Units Vw = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ModifierType_Units[] f404793a = null;
    private final long value;

    public static ModifierType_Units valueOf(String r100) {
        return (ModifierType_Units) r27.a.a(ModifierType_Units.class, r100);
    }

    public static ModifierType_Units[] values() {
        return (ModifierType_Units[]) f404793a.clone();
    }

    static {
        ModifierType_Units r100 = new ModifierType_Units("Px", 0, 5);
        Px = r100;
        ModifierType_Units r101 = new ModifierType_Units("Rpx", 1, 6);
        Rpx = r101;
        ModifierType_Units r102 = new ModifierType_Units("Em", 2, 7);
        Em = r102;
        ModifierType_Units r103 = new ModifierType_Units("Rem", 3, 8);
        Rem = r103;
        ModifierType_Units r104 = new ModifierType_Units("Vh", 4, 9);
        Vh = r104;
        ModifierType_Units r105 = new ModifierType_Units("Vw", 5, 10);
        Vw = r105;
        f404793a = new ModifierType_Units[]{r100, r101, r102, r103, r104, r105};
    }

    public final long getValue() {
        return this.value;
    }

    public ModifierType_Units(String r100, int r101, long r102) {
        super(r100, r101);
        this.value = r102;
    }
}
