package com.google.json;

/* JADX INFO: loaded from: classes23.dex */
final enum JsonSanitizer$State extends Enum<JsonSanitizer$State> {
    public static final JsonSanitizer$State AFTER_ELEMENT = null;
    public static final JsonSanitizer$State AFTER_KEY = null;
    public static final JsonSanitizer$State AFTER_VALUE = null;
    public static final JsonSanitizer$State BEFORE_ELEMENT = null;
    public static final JsonSanitizer$State BEFORE_KEY = null;
    public static final JsonSanitizer$State BEFORE_VALUE = null;
    public static final JsonSanitizer$State START_ARRAY = null;
    public static final JsonSanitizer$State START_MAP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ JsonSanitizer$State[] f275926a = null;

    static {
        JsonSanitizer$State r100 = new JsonSanitizer$State("START_ARRAY", 0);
        START_ARRAY = r100;
        JsonSanitizer$State r101 = new JsonSanitizer$State("BEFORE_ELEMENT", 1);
        BEFORE_ELEMENT = r101;
        JsonSanitizer$State r102 = new JsonSanitizer$State("AFTER_ELEMENT", 2);
        AFTER_ELEMENT = r102;
        JsonSanitizer$State r103 = new JsonSanitizer$State("START_MAP", 3);
        START_MAP = r103;
        JsonSanitizer$State r104 = new JsonSanitizer$State("BEFORE_KEY", 4);
        BEFORE_KEY = r104;
        JsonSanitizer$State r105 = new JsonSanitizer$State("AFTER_KEY", 5);
        AFTER_KEY = r105;
        JsonSanitizer$State r110 = new JsonSanitizer$State("BEFORE_VALUE", 6);
        BEFORE_VALUE = r110;
        JsonSanitizer$State r111 = new JsonSanitizer$State("AFTER_VALUE", 7);
        AFTER_VALUE = r111;
        f275926a = new JsonSanitizer$State[]{r100, r101, r102, r103, r104, r105, r110, r111};
    }

    public static JsonSanitizer$State[] values() {
        return (JsonSanitizer$State[]) f275926a.clone();
    }

    public static JsonSanitizer$State valueOf(String r100) {
        return (JsonSanitizer$State) r27.a.a(JsonSanitizer$State.class, r100);
    }

    public JsonSanitizer$State(String r100, int r101) {
        super(r100, r101);
    }
}
