package com.google.gson;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class JsonNull extends JsonElement {
    public static final JsonNull INSTANCE = null;

    static {
        INSTANCE = new JsonNull();
    }

    public int hashCode() {
        return JsonNull.class.hashCode();
    }

    @Override // com.google.gson.JsonElement
    public /* bridge */ /* synthetic */ JsonElement deepCopy() {
        return deepCopy();
    }

    public JsonNull() {
    }

    @Override // com.google.gson.JsonElement
    public JsonNull deepCopy() {
        return INSTANCE;
    }

    public boolean equals(Object r1) {
        return r1 instanceof JsonNull;
    }
}
