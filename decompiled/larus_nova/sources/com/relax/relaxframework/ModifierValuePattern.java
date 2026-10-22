package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u001a\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001b¨\u0006\u001c"}, d2 = {"Lcom/relax/relaxframework/ModifierValuePattern;", "", "", "value", "I", "getValue", "()I", "EMPTY", "STRING", "NUMBER", "BOOLEAN", "ENUM", "PX", "RPX", "EM", "REM", "VH", "VW", "PERCENT", "CALC", "ENV", "ARRAY", "MAP", "PPX", "INTRINSIC", "SP", "FR", "COUNT", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum ModifierValuePattern extends Enum<ModifierValuePattern> {
    public static final ModifierValuePattern ARRAY = null;
    public static final ModifierValuePattern BOOLEAN = null;
    public static final ModifierValuePattern CALC = null;
    public static final ModifierValuePattern COUNT = null;
    public static final ModifierValuePattern EM = null;
    public static final ModifierValuePattern EMPTY = null;
    public static final ModifierValuePattern ENUM = null;
    public static final ModifierValuePattern ENV = null;
    public static final ModifierValuePattern FR = null;
    public static final ModifierValuePattern INTRINSIC = null;
    public static final ModifierValuePattern MAP = null;
    public static final ModifierValuePattern NUMBER = null;
    public static final ModifierValuePattern PERCENT = null;
    public static final ModifierValuePattern PPX = null;
    public static final ModifierValuePattern PX = null;
    public static final ModifierValuePattern REM = null;
    public static final ModifierValuePattern RPX = null;
    public static final ModifierValuePattern SP = null;
    public static final ModifierValuePattern STRING = null;
    public static final ModifierValuePattern VH = null;
    public static final ModifierValuePattern VW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ModifierValuePattern[] f404794a = null;
    private final int value;

    public static ModifierValuePattern valueOf(String r100) {
        return (ModifierValuePattern) r27.a.a(ModifierValuePattern.class, r100);
    }

    public static ModifierValuePattern[] values() {
        return (ModifierValuePattern[]) f404794a.clone();
    }

    static {
        ModifierValuePattern r100 = new ModifierValuePattern("EMPTY", 0, 0);
        EMPTY = r100;
        ModifierValuePattern r101 = new ModifierValuePattern("STRING", 1, 1);
        STRING = r101;
        ModifierValuePattern r102 = new ModifierValuePattern("NUMBER", 2, 2);
        NUMBER = r102;
        ModifierValuePattern r103 = new ModifierValuePattern("BOOLEAN", 3, 3);
        BOOLEAN = r103;
        ModifierValuePattern r104 = new ModifierValuePattern("ENUM", 4, 4);
        ENUM = r104;
        ModifierValuePattern r105 = new ModifierValuePattern("PX", 5, 5);
        PX = r105;
        ModifierValuePattern r110 = new ModifierValuePattern("RPX", 6, 6);
        RPX = r110;
        ModifierValuePattern r111 = new ModifierValuePattern("EM", 7, 7);
        EM = r111;
        ModifierValuePattern r112 = new ModifierValuePattern("REM", 8, 8);
        REM = r112;
        ModifierValuePattern r113 = new ModifierValuePattern("VH", 9, 9);
        VH = r113;
        ModifierValuePattern r114 = new ModifierValuePattern("VW", 10, 10);
        VW = r114;
        ModifierValuePattern r115 = new ModifierValuePattern("PERCENT", 11, 11);
        PERCENT = r115;
        ModifierValuePattern r106 = new ModifierValuePattern("CALC", 12, 12);
        CALC = r106;
        ModifierValuePattern r107 = new ModifierValuePattern("ENV", 13, 13);
        ENV = r107;
        ModifierValuePattern r108 = new ModifierValuePattern("ARRAY", 14, 14);
        ARRAY = r108;
        ModifierValuePattern r109 = new ModifierValuePattern("MAP", 15, 15);
        MAP = r109;
        ModifierValuePattern r116 = new ModifierValuePattern("PPX", 16, 16);
        PPX = r116;
        ModifierValuePattern r117 = new ModifierValuePattern("INTRINSIC", 17, 17);
        INTRINSIC = r117;
        ModifierValuePattern r118 = new ModifierValuePattern("SP", 18, 18);
        SP = r118;
        ModifierValuePattern r119 = new ModifierValuePattern("FR", 19, 19);
        FR = r119;
        ModifierValuePattern r120 = new ModifierValuePattern("COUNT", 20, 20);
        COUNT = r120;
        f404794a = new ModifierValuePattern[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120};
    }

    public final int getValue() {
        return this.value;
    }

    public ModifierValuePattern(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
