package com.bytedance.ug.sdk.deeplink;

import r27.a;

/* JADX INFO: loaded from: classes3.dex */
public final enum UriType extends Enum<UriType> {
    public static final UriType APP_LINKS = null;
    public static final UriType CLIPBOARD = null;
    public static final UriType DEVICE_PRINT = null;
    public static final UriType ILLEGAL = null;
    public static final UriType UNIVERSE_LINK = null;
    public static final UriType URI_SCHEME = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UriType[] f271060a = null;
    private String value;

    static {
        UriType r100 = new UriType("ILLEGAL", 0, "0");
        ILLEGAL = r100;
        UriType r101 = new UriType("APP_LINKS", 1, "1");
        APP_LINKS = r101;
        UriType r102 = new UriType("UNIVERSE_LINK", 2, "2");
        UNIVERSE_LINK = r102;
        UriType r103 = new UriType("URI_SCHEME", 3, "3");
        URI_SCHEME = r103;
        UriType r104 = new UriType("CLIPBOARD", 4, "4");
        CLIPBOARD = r104;
        UriType r105 = new UriType("DEVICE_PRINT", 5, "5");
        DEVICE_PRINT = r105;
        f271060a = new UriType[]{r100, r101, r102, r103, r104, r105};
    }

    public static UriType[] values() {
        return (UriType[]) f271060a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static UriType valueOf(String r100) {
        return (UriType) a.a(UriType.class, r100);
    }

    public UriType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
