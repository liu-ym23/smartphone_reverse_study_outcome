package com.google.crypto.tink.shaded.protobuf;

import androidx.camera.video.AudioStats;

/* JADX INFO: loaded from: classes23.dex */
public final enum JavaType extends Enum<JavaType> {
    public static final JavaType BOOLEAN = null;
    public static final JavaType BYTE_STRING = null;
    public static final JavaType DOUBLE = null;
    public static final JavaType ENUM = null;
    public static final JavaType FLOAT = null;
    public static final JavaType INT = null;
    public static final JavaType LONG = null;
    public static final JavaType MESSAGE = null;
    public static final JavaType STRING = null;
    public static final JavaType VOID = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ JavaType[] f275827a = null;
    private final Class<?> boxedType;
    private final Object defaultDefault;
    private final Class<?> type;

    static {
        JavaType r100 = new JavaType("VOID", 0, Void.class, Void.class, null);
        VOID = r100;
        Class r110 = Integer.TYPE;
        JavaType r101 = new JavaType("INT", 1, r110, Integer.class, 0);
        INT = r101;
        JavaType r102 = new JavaType("LONG", 2, Long.TYPE, Long.class, 0L);
        LONG = r102;
        JavaType r103 = new JavaType("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        FLOAT = r103;
        JavaType r104 = new JavaType("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE));
        DOUBLE = r104;
        JavaType r105 = new JavaType("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        BOOLEAN = r105;
        JavaType r106 = new JavaType("STRING", 6, String.class, String.class, "");
        STRING = r106;
        JavaType r107 = new JavaType("BYTE_STRING", 7, ByteString.class, ByteString.class, ByteString.EMPTY);
        BYTE_STRING = r107;
        JavaType r108 = new JavaType("ENUM", 8, r110, Integer.class, null);
        ENUM = r108;
        JavaType r111 = new JavaType("MESSAGE", 9, Object.class, Object.class, null);
        MESSAGE = r111;
        f275827a = new JavaType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r111};
    }

    public static JavaType[] values() {
        return (JavaType[]) f275827a.clone();
    }

    public Class<?> getBoxedType() {
        return this.boxedType;
    }

    public Object getDefaultDefault() {
        return this.defaultDefault;
    }

    public Class<?> getType() {
        return this.type;
    }

    public static JavaType valueOf(String r100) {
        return (JavaType) r27.a.a(JavaType.class, r100);
    }

    public boolean isValidType(Class<?> r100) {
        return this.type.isAssignableFrom(r100);
    }

    public JavaType(String r100, int r101, Class r102, Class r103, Object r104) {
        super(r100, r101);
        this.type = r102;
        this.boxedType = r103;
        this.defaultDefault = r104;
    }
}
