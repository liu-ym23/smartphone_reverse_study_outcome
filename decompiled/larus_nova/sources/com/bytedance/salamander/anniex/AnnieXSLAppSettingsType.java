package com.bytedance.salamander.anniex;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/salamander/anniex/AnnieXSLAppSettingsType;", "", "", "value", "I", "getValue", "()I", "STRING", "BOOL", "INT32", "LONG", "FLOAT", "DOUBLE", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum AnnieXSLAppSettingsType extends Enum<AnnieXSLAppSettingsType> {
    public static final AnnieXSLAppSettingsType BOOL = null;
    public static final AnnieXSLAppSettingsType DOUBLE = null;
    public static final AnnieXSLAppSettingsType FLOAT = null;
    public static final AnnieXSLAppSettingsType INT32 = null;
    public static final AnnieXSLAppSettingsType LONG = null;
    public static final AnnieXSLAppSettingsType STRING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AnnieXSLAppSettingsType[] f267856a = null;
    private final int value;

    public static AnnieXSLAppSettingsType valueOf(String r100) {
        return (AnnieXSLAppSettingsType) r27.a.a(AnnieXSLAppSettingsType.class, r100);
    }

    public static AnnieXSLAppSettingsType[] values() {
        return (AnnieXSLAppSettingsType[]) f267856a.clone();
    }

    static {
        AnnieXSLAppSettingsType r100 = new AnnieXSLAppSettingsType("STRING", 0, 0);
        STRING = r100;
        AnnieXSLAppSettingsType r101 = new AnnieXSLAppSettingsType("BOOL", 1, 1);
        BOOL = r101;
        AnnieXSLAppSettingsType r102 = new AnnieXSLAppSettingsType("INT32", 2, 2);
        INT32 = r102;
        AnnieXSLAppSettingsType r103 = new AnnieXSLAppSettingsType("LONG", 3, 3);
        LONG = r103;
        AnnieXSLAppSettingsType r104 = new AnnieXSLAppSettingsType("FLOAT", 4, 4);
        FLOAT = r104;
        AnnieXSLAppSettingsType r105 = new AnnieXSLAppSettingsType("DOUBLE", 5, 5);
        DOUBLE = r105;
        f267856a = new AnnieXSLAppSettingsType[]{r100, r101, r102, r103, r104, r105};
    }

    public final int getValue() {
        return this.value;
    }

    public AnnieXSLAppSettingsType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
