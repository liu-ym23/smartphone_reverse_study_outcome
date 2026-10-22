package org.checkerframework.framework.qual;

import com.obric.miniapp.alarm.AccountType;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum TypeUseLocation extends Enum<TypeUseLocation> {
    public static final TypeUseLocation ALL = null;
    public static final TypeUseLocation CONSTRUCTOR_RESULT = null;
    public static final TypeUseLocation EXCEPTION_PARAMETER = null;
    public static final TypeUseLocation EXPLICIT_LOWER_BOUND = null;
    public static final TypeUseLocation EXPLICIT_UPPER_BOUND = null;
    public static final TypeUseLocation FIELD = null;
    public static final TypeUseLocation IMPLICIT_LOWER_BOUND = null;
    public static final TypeUseLocation IMPLICIT_UPPER_BOUND = null;
    public static final TypeUseLocation LOCAL_VARIABLE = null;
    public static final TypeUseLocation LOWER_BOUND = null;
    public static final TypeUseLocation OTHERWISE = null;
    public static final TypeUseLocation PARAMETER = null;
    public static final TypeUseLocation RECEIVER = null;
    public static final TypeUseLocation RESOURCE_VARIABLE = null;
    public static final TypeUseLocation RETURN = null;
    public static final TypeUseLocation UPPER_BOUND = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TypeUseLocation[] f525629a = null;

    static {
        TypeUseLocation r100 = new TypeUseLocation("FIELD", 0);
        FIELD = r100;
        TypeUseLocation r101 = new TypeUseLocation("LOCAL_VARIABLE", 1);
        LOCAL_VARIABLE = r101;
        TypeUseLocation r102 = new TypeUseLocation("RESOURCE_VARIABLE", 2);
        RESOURCE_VARIABLE = r102;
        TypeUseLocation r103 = new TypeUseLocation("EXCEPTION_PARAMETER", 3);
        EXCEPTION_PARAMETER = r103;
        TypeUseLocation r104 = new TypeUseLocation("RECEIVER", 4);
        RECEIVER = r104;
        TypeUseLocation r105 = new TypeUseLocation("PARAMETER", 5);
        PARAMETER = r105;
        TypeUseLocation r110 = new TypeUseLocation("RETURN", 6);
        RETURN = r110;
        TypeUseLocation r111 = new TypeUseLocation("CONSTRUCTOR_RESULT", 7);
        CONSTRUCTOR_RESULT = r111;
        TypeUseLocation r112 = new TypeUseLocation("LOWER_BOUND", 8);
        LOWER_BOUND = r112;
        TypeUseLocation r113 = new TypeUseLocation("EXPLICIT_LOWER_BOUND", 9);
        EXPLICIT_LOWER_BOUND = r113;
        TypeUseLocation r114 = new TypeUseLocation("IMPLICIT_LOWER_BOUND", 10);
        IMPLICIT_LOWER_BOUND = r114;
        TypeUseLocation r115 = new TypeUseLocation("UPPER_BOUND", 11);
        UPPER_BOUND = r115;
        TypeUseLocation r106 = new TypeUseLocation("EXPLICIT_UPPER_BOUND", 12);
        EXPLICIT_UPPER_BOUND = r106;
        TypeUseLocation r107 = new TypeUseLocation("IMPLICIT_UPPER_BOUND", 13);
        IMPLICIT_UPPER_BOUND = r107;
        TypeUseLocation r108 = new TypeUseLocation("OTHERWISE", 14);
        OTHERWISE = r108;
        TypeUseLocation r109 = new TypeUseLocation(AccountType.ALL, 15);
        ALL = r109;
        f525629a = new TypeUseLocation[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109};
    }

    public static TypeUseLocation[] values() {
        return (TypeUseLocation[]) f525629a.clone();
    }

    public static TypeUseLocation valueOf(String r100) {
        return (TypeUseLocation) a.a(TypeUseLocation.class, r100);
    }

    public TypeUseLocation(String r100, int r101) {
        super(r100, r101);
    }
}
