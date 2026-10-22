package com.google.crypto.tink.shaded.protobuf;

import androidx.camera.video.AudioStats;

/* JADX INFO: loaded from: classes23.dex */
public final enum WireFormat$JavaType extends Enum<WireFormat$JavaType> {
    public static final WireFormat$JavaType BOOLEAN = null;
    public static final WireFormat$JavaType BYTE_STRING = null;
    public static final WireFormat$JavaType DOUBLE = null;
    public static final WireFormat$JavaType ENUM = null;
    public static final WireFormat$JavaType FLOAT = null;
    public static final WireFormat$JavaType INT = null;
    public static final WireFormat$JavaType LONG = null;
    public static final WireFormat$JavaType MESSAGE = null;
    public static final WireFormat$JavaType STRING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WireFormat$JavaType[] f275852a = null;
    private final Object defaultDefault;

    static {
        WireFormat$JavaType r100 = new WireFormat$JavaType("INT", 0, 0);
        INT = r100;
        WireFormat$JavaType r101 = new WireFormat$JavaType("LONG", 1, 0L);
        LONG = r101;
        WireFormat$JavaType r102 = new WireFormat$JavaType("FLOAT", 2, Float.valueOf(0.0f));
        FLOAT = r102;
        WireFormat$JavaType r103 = new WireFormat$JavaType("DOUBLE", 3, Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE));
        DOUBLE = r103;
        WireFormat$JavaType r104 = new WireFormat$JavaType("BOOLEAN", 4, Boolean.FALSE);
        BOOLEAN = r104;
        WireFormat$JavaType r105 = new WireFormat$JavaType("STRING", 5, "");
        STRING = r105;
        WireFormat$JavaType r110 = new WireFormat$JavaType("BYTE_STRING", 6, ByteString.EMPTY);
        BYTE_STRING = r110;
        WireFormat$JavaType r111 = new WireFormat$JavaType("ENUM", 7, null);
        ENUM = r111;
        WireFormat$JavaType r112 = new WireFormat$JavaType("MESSAGE", 8, null);
        MESSAGE = r112;
        f275852a = new WireFormat$JavaType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112};
    }

    public static WireFormat$JavaType[] values() {
        return (WireFormat$JavaType[]) f275852a.clone();
    }

    public Object getDefaultDefault() {
        return this.defaultDefault;
    }

    public static WireFormat$JavaType valueOf(String r100) {
        return (WireFormat$JavaType) r27.a.a(WireFormat$JavaType.class, r100);
    }

    public WireFormat$JavaType(String r100, int r101, Object r102) {
        super(r100, r101);
        this.defaultDefault = r102;
    }
}
