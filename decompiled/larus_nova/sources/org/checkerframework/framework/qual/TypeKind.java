package org.checkerframework.framework.qual;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.larus.dora.api.model.FlowDoraWifiScene;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum TypeKind extends Enum<TypeKind> {
    public static final TypeKind ARRAY = null;
    public static final TypeKind BOOLEAN = null;
    public static final TypeKind BYTE = null;
    public static final TypeKind CHAR = null;
    public static final TypeKind DECLARED = null;
    public static final TypeKind DOUBLE = null;
    public static final TypeKind ERROR = null;
    public static final TypeKind EXECUTABLE = null;
    public static final TypeKind FLOAT = null;
    public static final TypeKind INT = null;
    public static final TypeKind INTERSECTION = null;
    public static final TypeKind LONG = null;
    public static final TypeKind NONE = null;
    public static final TypeKind NULL = null;
    public static final TypeKind OTHER = null;
    public static final TypeKind PACKAGE = null;
    public static final TypeKind SHORT = null;
    public static final TypeKind TYPEVAR = null;
    public static final TypeKind UNION = null;
    public static final TypeKind VOID = null;
    public static final TypeKind WILDCARD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TypeKind[] f525628a = null;

    static {
        TypeKind r100 = new TypeKind("BOOLEAN", 0);
        BOOLEAN = r100;
        TypeKind r101 = new TypeKind("BYTE", 1);
        BYTE = r101;
        TypeKind r102 = new TypeKind("SHORT", 2);
        SHORT = r102;
        TypeKind r103 = new TypeKind("INT", 3);
        INT = r103;
        TypeKind r104 = new TypeKind("LONG", 4);
        LONG = r104;
        TypeKind r105 = new TypeKind("CHAR", 5);
        CHAR = r105;
        TypeKind r110 = new TypeKind("FLOAT", 6);
        FLOAT = r110;
        TypeKind r111 = new TypeKind("DOUBLE", 7);
        DOUBLE = r111;
        TypeKind r112 = new TypeKind("VOID", 8);
        VOID = r112;
        TypeKind r113 = new TypeKind(UserProfileEvent.POSITION_NONE, 9);
        NONE = r113;
        TypeKind r114 = new TypeKind("NULL", 10);
        NULL = r114;
        TypeKind r115 = new TypeKind("ARRAY", 11);
        ARRAY = r115;
        TypeKind r106 = new TypeKind("DECLARED", 12);
        DECLARED = r106;
        TypeKind r107 = new TypeKind("ERROR", 13);
        ERROR = r107;
        TypeKind r108 = new TypeKind("TYPEVAR", 14);
        TYPEVAR = r108;
        TypeKind r109 = new TypeKind("WILDCARD", 15);
        WILDCARD = r109;
        TypeKind r116 = new TypeKind("PACKAGE", 16);
        PACKAGE = r116;
        TypeKind r117 = new TypeKind("EXECUTABLE", 17);
        EXECUTABLE = r117;
        TypeKind r118 = new TypeKind(FlowDoraWifiScene.OTHER, 18);
        OTHER = r118;
        TypeKind r119 = new TypeKind("UNION", 19);
        UNION = r119;
        TypeKind r120 = new TypeKind("INTERSECTION", 20);
        INTERSECTION = r120;
        f525628a = new TypeKind[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120};
    }

    public static TypeKind[] values() {
        return (TypeKind[]) f525628a.clone();
    }

    public static TypeKind valueOf(String r100) {
        return (TypeKind) a.a(TypeKind.class, r100);
    }

    public TypeKind(String r100, int r101) {
        super(r100, r101);
    }
}
