package org.checkerframework.framework.qual;

import com.obric.miniapp.alarm.AccountType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum LiteralKind extends Enum<LiteralKind> {
    public static final LiteralKind ALL = null;
    public static final LiteralKind BOOLEAN = null;
    public static final LiteralKind CHAR = null;
    public static final LiteralKind DOUBLE = null;
    public static final LiteralKind FLOAT = null;
    public static final LiteralKind INT = null;
    public static final LiteralKind LONG = null;
    public static final LiteralKind NULL = null;
    public static final LiteralKind PRIMITIVE = null;
    public static final LiteralKind STRING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiteralKind[] f525627a = null;

    public static List<LiteralKind> primitiveLiteralKinds() {
        return Arrays.asList(new LiteralKind[]{INT, LONG, FLOAT, DOUBLE, BOOLEAN, CHAR});
    }

    static {
        LiteralKind r100 = new LiteralKind("NULL", 0);
        NULL = r100;
        LiteralKind r101 = new LiteralKind("INT", 1);
        INT = r101;
        LiteralKind r102 = new LiteralKind("LONG", 2);
        LONG = r102;
        LiteralKind r103 = new LiteralKind("FLOAT", 3);
        FLOAT = r103;
        LiteralKind r104 = new LiteralKind("DOUBLE", 4);
        DOUBLE = r104;
        LiteralKind r105 = new LiteralKind("BOOLEAN", 5);
        BOOLEAN = r105;
        LiteralKind r110 = new LiteralKind("CHAR", 6);
        CHAR = r110;
        LiteralKind r111 = new LiteralKind("STRING", 7);
        STRING = r111;
        LiteralKind r112 = new LiteralKind(AccountType.ALL, 8);
        ALL = r112;
        LiteralKind r113 = new LiteralKind("PRIMITIVE", 9);
        PRIMITIVE = r113;
        f525627a = new LiteralKind[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
    }

    public static List<LiteralKind> allLiteralKinds() {
        ArrayList r100 = new ArrayList(Arrays.asList(values()));
        r100.remove(ALL);
        r100.remove(PRIMITIVE);
        return r100;
    }

    public static LiteralKind[] values() {
        return (LiteralKind[]) f525627a.clone();
    }

    public static LiteralKind valueOf(String r100) {
        return (LiteralKind) a.a(LiteralKind.class, r100);
    }

    public LiteralKind(String r100, int r101) {
        super(r100, r101);
    }
}
