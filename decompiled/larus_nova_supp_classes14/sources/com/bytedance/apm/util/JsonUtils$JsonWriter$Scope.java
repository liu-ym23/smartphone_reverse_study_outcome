package com.bytedance.apm.util;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
final enum JsonUtils$JsonWriter$Scope extends Enum<JsonUtils$JsonWriter$Scope> {
    public static final JsonUtils$JsonWriter$Scope DANGLING_KEY = null;
    public static final JsonUtils$JsonWriter$Scope EMPTY_ARRAY = null;
    public static final JsonUtils$JsonWriter$Scope EMPTY_OBJECT = null;
    public static final JsonUtils$JsonWriter$Scope NONEMPTY_ARRAY = null;
    public static final JsonUtils$JsonWriter$Scope NONEMPTY_OBJECT = null;
    public static final JsonUtils$JsonWriter$Scope NULL = null;
    public static final /* synthetic */ JsonUtils$JsonWriter$Scope[] a = null;

    static {
        JsonUtils$JsonWriter$Scope r0 = new JsonUtils$JsonWriter$Scope("EMPTY_ARRAY", 0);
        EMPTY_ARRAY = r0;
        JsonUtils$JsonWriter$Scope r1 = new JsonUtils$JsonWriter$Scope("NONEMPTY_ARRAY", 1);
        NONEMPTY_ARRAY = r1;
        JsonUtils$JsonWriter$Scope r3 = new JsonUtils$JsonWriter$Scope("EMPTY_OBJECT", 2);
        EMPTY_OBJECT = r3;
        JsonUtils$JsonWriter$Scope r5 = new JsonUtils$JsonWriter$Scope("DANGLING_KEY", 3);
        DANGLING_KEY = r5;
        JsonUtils$JsonWriter$Scope r7 = new JsonUtils$JsonWriter$Scope("NONEMPTY_OBJECT", 4);
        NONEMPTY_OBJECT = r7;
        JsonUtils$JsonWriter$Scope r9 = new JsonUtils$JsonWriter$Scope("NULL", 5);
        NULL = r9;
        a = new JsonUtils$JsonWriter$Scope[]{r0, r1, r3, r5, r7, r9};
    }

    public static JsonUtils$JsonWriter$Scope[] values() {
        return (JsonUtils$JsonWriter$Scope[]) a.clone();
    }

    public static JsonUtils$JsonWriter$Scope valueOf(String r1) {
        return (JsonUtils$JsonWriter$Scope) a.a(JsonUtils$JsonWriter$Scope.class, r1);
    }

    public JsonUtils$JsonWriter$Scope(String r1, int r2) {
        super(r1, r2);
    }
}
