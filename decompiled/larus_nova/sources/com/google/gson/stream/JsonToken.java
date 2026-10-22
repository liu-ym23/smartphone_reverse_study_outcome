package com.google.gson.stream;

/* JADX INFO: loaded from: classes.dex */
public final enum JsonToken extends Enum<JsonToken> {
    private static final /* synthetic */ JsonToken[] $VALUES = null;
    public static final JsonToken BEGIN_ARRAY = null;
    public static final JsonToken BEGIN_OBJECT = null;
    public static final JsonToken BOOLEAN = null;
    public static final JsonToken END_ARRAY = null;
    public static final JsonToken END_DOCUMENT = null;
    public static final JsonToken END_OBJECT = null;
    public static final JsonToken NAME = null;
    public static final JsonToken NULL = null;
    public static final JsonToken NUMBER = null;
    public static final JsonToken STRING = null;

    static {
        JsonToken r100 = new JsonToken("BEGIN_ARRAY", 0);
        BEGIN_ARRAY = r100;
        JsonToken r101 = new JsonToken("END_ARRAY", 1);
        END_ARRAY = r101;
        JsonToken r102 = new JsonToken("BEGIN_OBJECT", 2);
        BEGIN_OBJECT = r102;
        JsonToken r103 = new JsonToken("END_OBJECT", 3);
        END_OBJECT = r103;
        JsonToken r104 = new JsonToken("NAME", 4);
        NAME = r104;
        JsonToken r105 = new JsonToken("STRING", 5);
        STRING = r105;
        JsonToken r110 = new JsonToken("NUMBER", 6);
        NUMBER = r110;
        JsonToken r111 = new JsonToken("BOOLEAN", 7);
        BOOLEAN = r111;
        JsonToken r112 = new JsonToken("NULL", 8);
        NULL = r112;
        JsonToken r113 = new JsonToken("END_DOCUMENT", 9);
        END_DOCUMENT = r113;
        $VALUES = new JsonToken[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
    }

    public static JsonToken[] values() {
        return (JsonToken[]) $VALUES.clone();
    }

    public static JsonToken valueOf(String r100) {
        return (JsonToken) Enum.valueOf(JsonToken.class, r100);
    }

    private JsonToken(String r100, int r101) {
        super(r100, r101);
    }
}
