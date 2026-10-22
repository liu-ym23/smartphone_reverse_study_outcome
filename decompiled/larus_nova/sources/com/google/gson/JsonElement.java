package com.google.gson;

import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes.dex */
public abstract class JsonElement {
    public abstract JsonElement deepCopy();

    public BigDecimal getAsBigDecimal() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public BigInteger getAsBigInteger() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public boolean getAsBoolean() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public byte getAsByte() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public char getAsCharacter() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public double getAsDouble() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public float getAsFloat() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public int getAsInt() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public long getAsLong() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public Number getAsNumber() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public short getAsShort() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String getAsString() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String toString() {
        StringWriter r100 = new StringWriter();     // Catch: IOException -> L4
        JsonWriter r101 = new JsonWriter(r100);     // Catch: IOException -> L4
        r101.setLenient(true);     // Catch: IOException -> L4
        Streams.write(this, r101);     // Catch: IOException -> L4
        return r100.toString();
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }

    public JsonArray getAsJsonArray() {
        if (isJsonArray() == false) goto L7;
        return (JsonArray) this;
    L7:
        throw new IllegalStateException("Not a JSON Array: " + this);
    }

    public JsonNull getAsJsonNull() {
        if (isJsonNull() == false) goto L7;
        return (JsonNull) this;
    L7:
        throw new IllegalStateException("Not a JSON Null: " + this);
    }

    public JsonObject getAsJsonObject() {
        if (isJsonObject() == false) goto L7;
        return (JsonObject) this;
    L7:
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public JsonPrimitive getAsJsonPrimitive() {
        if (isJsonPrimitive() == false) goto L7;
        return (JsonPrimitive) this;
    L7:
        throw new IllegalStateException("Not a JSON Primitive: " + this);
    }

    public JsonElement() {
    }

    public boolean isJsonArray() {
        return this instanceof JsonArray;
    }

    public boolean isJsonNull() {
        return this instanceof JsonNull;
    }

    public boolean isJsonObject() {
        return this instanceof JsonObject;
    }

    public boolean isJsonPrimitive() {
        return this instanceof JsonPrimitive;
    }
}
