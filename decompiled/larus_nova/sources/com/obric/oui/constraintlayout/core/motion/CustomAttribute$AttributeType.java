package com.obric.oui.constraintlayout.core.motion;

import r27.a;

/* JADX INFO: loaded from: classes34.dex */
public final enum CustomAttribute$AttributeType extends Enum<CustomAttribute$AttributeType> {
    public static final CustomAttribute$AttributeType BOOLEAN_TYPE = null;
    public static final CustomAttribute$AttributeType COLOR_DRAWABLE_TYPE = null;
    public static final CustomAttribute$AttributeType COLOR_TYPE = null;
    public static final CustomAttribute$AttributeType DIMENSION_TYPE = null;
    public static final CustomAttribute$AttributeType FLOAT_TYPE = null;
    public static final CustomAttribute$AttributeType INT_TYPE = null;
    public static final CustomAttribute$AttributeType REFERENCE_TYPE = null;
    public static final CustomAttribute$AttributeType STRING_TYPE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CustomAttribute$AttributeType[] f399677a = null;

    static {
        CustomAttribute$AttributeType r100 = new CustomAttribute$AttributeType("INT_TYPE", 0);
        INT_TYPE = r100;
        CustomAttribute$AttributeType r101 = new CustomAttribute$AttributeType("FLOAT_TYPE", 1);
        FLOAT_TYPE = r101;
        CustomAttribute$AttributeType r102 = new CustomAttribute$AttributeType("COLOR_TYPE", 2);
        COLOR_TYPE = r102;
        CustomAttribute$AttributeType r103 = new CustomAttribute$AttributeType("COLOR_DRAWABLE_TYPE", 3);
        COLOR_DRAWABLE_TYPE = r103;
        CustomAttribute$AttributeType r104 = new CustomAttribute$AttributeType("STRING_TYPE", 4);
        STRING_TYPE = r104;
        CustomAttribute$AttributeType r105 = new CustomAttribute$AttributeType("BOOLEAN_TYPE", 5);
        BOOLEAN_TYPE = r105;
        CustomAttribute$AttributeType r110 = new CustomAttribute$AttributeType("DIMENSION_TYPE", 6);
        DIMENSION_TYPE = r110;
        CustomAttribute$AttributeType r111 = new CustomAttribute$AttributeType("REFERENCE_TYPE", 7);
        REFERENCE_TYPE = r111;
        f399677a = new CustomAttribute$AttributeType[]{r100, r101, r102, r103, r104, r105, r110, r111};
    }

    public static CustomAttribute$AttributeType[] values() {
        return (CustomAttribute$AttributeType[]) f399677a.clone();
    }

    public static CustomAttribute$AttributeType valueOf(String r100) {
        return (CustomAttribute$AttributeType) a.a(CustomAttribute$AttributeType.class, r100);
    }

    public CustomAttribute$AttributeType(String r100, int r101) {
        super(r100, r101);
    }
}
